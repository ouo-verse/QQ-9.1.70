package com.tencent.mobileqq.activity.photo;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.SystemClock;
import com.tencent.component.network.utils.BytesBufferPool;
import com.tencent.image.DownloadParams;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.image.URLState;
import com.tencent.mobileqq.activity.photo.album.QAlbumUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.bitmapcreator.BitmapDecoder;
import com.tencent.qphone.base.util.QLog;
import common.qzone.component.cache.common.a;
import common.qzone.component.util.SecurityUtil;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.ByteBuffer;

/* compiled from: P */
/* loaded from: classes10.dex */
public class AlbumThumbManager {
    static IPatchRedirector $redirector_ = null;
    private static final int BLOB_CACHE_MAX_BYTES = 52428800;
    private static final int BLOB_CACHE_MAX_ENTRIES = 2500;
    private static final int BLOB_CACHE_VERSION = 1;
    private static final int BYTESBUFFER_POOL_SIZE = 4;
    private static final int BYTESBUFFER_SIZE = 204800;
    private static final int BYTESBUFFER_SIZE_NEW = 102400;
    private static final int DEFAULT_JPEG_QUALITY = 70;
    private static final int MEGABYTE = 1048576;
    public static final String TAG = "QQAlbum";
    private static final int byteKeyLength = 16;
    private static final BytesBufferPool sCacheBufferPool;
    private static AlbumThumbManager sInstance;
    private static TempBuffer tempBuffer;
    private static ByteBuffer tempByteBuffer;
    final String BLOB_CACHE_DIRECTORY;
    private boolean isThumbKeyUseSize;
    common.qzone.component.cache.common.a mBlobCache;
    private final Object mBlobLock;
    Context mContext;

    /* compiled from: P */
    /* loaded from: classes10.dex */
    private static class TempBuffer {
        static IPatchRedirector $redirector_;
        public byte[] data;
        public int length;
        public int offset;

        TempBuffer(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, i3);
            } else {
                this.data = new byte[i3];
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(12686);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            sCacheBufferPool = new BytesBufferPool(4, BYTESBUFFER_SIZE);
        }
    }

    AlbumThumbManager(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.mBlobLock = new Object();
        this.isThumbKeyUseSize = false;
        this.BLOB_CACHE_DIRECTORY = getCacheDir(context) + "/qalbum/blob/";
        this.mContext = context.getApplicationContext();
        retrieveBlobCache(context);
    }

    private static byte[] compressToJPEG(Bitmap bitmap, int i3) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(65536);
        bitmap.compress(Bitmap.CompressFormat.JPEG, i3, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    private Bitmap createBitMapFromCache(URL url, DownloadParams downloadParams, BytesBufferPool.BytesBuffer bytesBuffer, long j3) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inPreferredConfig = Bitmap.Config.RGB_565;
        if (downloadParams == null) {
            options.inSampleSize = 1;
        } else {
            options.inJustDecodeBounds = true;
            SafeBitmapFactory.decodeByteArray(bytesBuffer.data, bytesBuffer.offset, bytesBuffer.length, options);
            options.inJustDecodeBounds = false;
            options.inSampleSize = URLState.calculateInSampleSize(options, downloadParams.reqWidth, downloadParams.reqHeight);
        }
        Bitmap decodeByteArray = SafeBitmapFactory.decodeByteArray(bytesBuffer.data, bytesBuffer.offset, bytesBuffer.length, options);
        if (QLog.isColorLevel() && url.getProtocol().equals(QAlbumUtil.PROTOCOL_ALBUM_THUMB)) {
            QLog.d("QQAlbum", 2, "getThumb bitmap from decode,url:" + url + " cost:" + (SystemClock.uptimeMillis() - j3) + " sizeDisk:" + bytesBuffer.length + " sizeMemory:" + decodeByteArray.getByteCount());
        }
        return decodeByteArray;
    }

    private Bitmap createBitMapFromUrl(URL url, BitmapDecoder bitmapDecoder, byte[] bArr, long j3, long j16) {
        Bitmap bitmap = bitmapDecoder.getBitmap(url);
        if (bitmap != null) {
            byte[] compressToJPEG = compressToJPEG(bitmap, 70);
            ByteBuffer allocate = ByteBuffer.allocate(bArr.length + compressToJPEG.length);
            allocate.put(bArr);
            allocate.put(compressToJPEG);
            synchronized (this.mBlobLock) {
                try {
                    this.mBlobCache.i(j16, allocate.array());
                } catch (IOException e16) {
                    QLog.e("AlbumThumbManager", 2, "decode thumb ioexception", e16);
                }
            }
            if (QLog.isColorLevel() && url.getProtocol().equals(QAlbumUtil.PROTOCOL_ALBUM_THUMB)) {
                QLog.d("QQAlbum", 2, "getThumb bitmap from cache,url:" + url + " cost:" + (SystemClock.uptimeMillis() - j3) + " sizeDisk:" + compressToJPEG.length + " sizeMemory:" + bitmap.getByteCount());
            }
            return bitmap;
        }
        return null;
    }

    private boolean getCacheData(byte[] bArr, long j3, TempBuffer tempBuffer2) {
        a.C10099a c10099a;
        if (bArr == null) {
            return false;
        }
        if (this.mBlobCache == null) {
            retrieveBlobCache(this.mContext);
            if (this.mBlobCache == null) {
                return false;
            }
        }
        try {
            c10099a = new a.C10099a();
            c10099a.f390058a = j3;
            c10099a.f390059b = tempBuffer2.data;
        } catch (IOException e16) {
            QLog.e("QQAlbum", 2, "getCacheData ioexception", e16);
        }
        synchronized (this.mBlobLock) {
            if (!this.mBlobCache.l(c10099a)) {
                return false;
            }
            if (isSameKey(bArr, c10099a.f390059b, c10099a.f390060c - 16, 16)) {
                tempBuffer2.data = c10099a.f390059b;
                tempBuffer2.offset = 0;
                tempBuffer2.length = c10099a.f390060c - 16;
                return true;
            }
            return false;
        }
    }

    static String getCacheDir(Context context) {
        if (context.getExternalCacheDir() != null) {
            return context.getExternalCacheDir().getAbsolutePath();
        }
        return context.getCacheDir().getAbsolutePath();
    }

    public static AlbumThumbManager getInstance(Context context) {
        AlbumThumbManager albumThumbManager;
        AlbumThumbManager albumThumbManager2 = sInstance;
        if (albumThumbManager2 != null) {
            return albumThumbManager2;
        }
        synchronized (AlbumThumbManager.class) {
            if (sInstance == null) {
                sInstance = new AlbumThumbManager(context);
                if (Build.BRAND.equals("Sony")) {
                    sInstance.isThumbKeyUseSize = true;
                }
            }
            albumThumbManager = sInstance;
        }
        return albumThumbManager;
    }

    private byte[] getKey(URL url, DownloadParams downloadParams) {
        String str;
        String str2 = "";
        if (this.isThumbKeyUseSize) {
            if (downloadParams != null) {
                Object obj = downloadParams.tag;
                if (obj instanceof LocalMediaInfo) {
                    str = "" + ((LocalMediaInfo) obj).modifiedDate;
                    if (str.equals("") && !str.equals("0")) {
                        str2 = str;
                    } else {
                        str2 = "" + new File(url.getPath()).length();
                    }
                }
            }
            str = "";
            if (str.equals("")) {
            }
            str2 = "" + new File(url.getPath()).length();
        }
        return SecurityUtil.e(url.toString() + str2);
    }

    private static boolean isSameKey(byte[] bArr, byte[] bArr2) {
        int length = bArr.length;
        if (bArr2.length < length) {
            return false;
        }
        for (int i3 = 0; i3 < length; i3++) {
            if (bArr[i3] != bArr2[i3]) {
                return false;
            }
        }
        return true;
    }

    private synchronized void retrieveBlobCache(Context context) {
        if (this.mBlobCache != null) {
            return;
        }
        String str = this.BLOB_CACHE_DIRECTORY + "/atb";
        try {
            File file = new File(this.BLOB_CACHE_DIRECTORY);
            if (!file.exists()) {
                file.mkdirs();
            }
            this.mBlobCache = new common.qzone.component.cache.common.a(str, 2500, 52428800, false, 1);
        } catch (Exception e16) {
            QLog.e("QQAlbum", 2, "init blobcache", e16);
        }
    }

    public synchronized void clear() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        sCacheBufferPool.clear();
        tempBuffer = null;
        tempByteBuffer = null;
    }

    public byte[] copyOf(byte[] bArr, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (byte[]) iPatchRedirector.redirect((short) 5, (Object) this, (Object) bArr, i3);
        }
        byte[] bArr2 = new byte[i3];
        for (int i16 = 0; i16 < bArr.length; i16++) {
            bArr2[i16] = bArr[i16];
        }
        return bArr2;
    }

    public Bitmap getThumb(URL url, BitmapDecoder bitmapDecoder) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) ? getThumb(url, bitmapDecoder, null) : (Bitmap) iPatchRedirector.redirect((short) 2, (Object) this, (Object) url, (Object) bitmapDecoder);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Not initialized variable reg: 20, insn: 0x007d: MOVE (r1 I:??[OBJECT, ARRAY]) = (r20 I:??[OBJECT, ARRAY]), block:B:26:0x007d */
    /* JADX WARN: Type inference failed for: r11v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r11v1 */
    /* JADX WARN: Type inference failed for: r9v0, types: [com.tencent.mobileqq.activity.photo.AlbumThumbManager] */
    /* JADX WARN: Type inference failed for: r9v1 */
    /* JADX WARN: Type inference failed for: r9v10 */
    /* JADX WARN: Type inference failed for: r9v11 */
    /* JADX WARN: Type inference failed for: r9v12 */
    /* JADX WARN: Type inference failed for: r9v13 */
    /* JADX WARN: Type inference failed for: r9v4 */
    /* JADX WARN: Type inference failed for: r9v5, types: [com.tencent.component.network.utils.BytesBufferPool$BytesBuffer] */
    /* JADX WARN: Type inference failed for: r9v8 */
    /* JADX WARN: Type inference failed for: r9v9 */
    public Bitmap getThumb(URL url, BitmapDecoder bitmapDecoder, DownloadParams downloadParams) {
        BytesBufferPool.BytesBuffer bytesBuffer;
        String str;
        int i3;
        String str2;
        BytesBufferPool.BytesBuffer bytesBuffer2 = this;
        int i16 = " cost:";
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Bitmap) iPatchRedirector.redirect((short) 3, this, url, bitmapDecoder, downloadParams);
        }
        byte[] key = bytesBuffer2.getKey(url, downloadParams);
        BytesBufferPool bytesBufferPool = sCacheBufferPool;
        BytesBufferPool.BytesBuffer bytesBuffer3 = bytesBufferPool.get();
        long uptimeMillis = SystemClock.uptimeMillis();
        long b16 = SecurityUtil.b(key);
        try {
            try {
                try {
                    if (!bytesBuffer2.getCacheData(key, b16, bytesBuffer3)) {
                        Bitmap createBitMapFromUrl = createBitMapFromUrl(url, bitmapDecoder, key, uptimeMillis, b16);
                        if (createBitMapFromUrl != null) {
                            bytesBufferPool.recycle(bytesBuffer3);
                            return createBitMapFromUrl;
                        }
                        bytesBufferPool.recycle(bytesBuffer3);
                        return null;
                    }
                    Bitmap createBitMapFromCache = createBitMapFromCache(url, downloadParams, bytesBuffer3, uptimeMillis);
                    bytesBufferPool.recycle(bytesBuffer3);
                    return createBitMapFromCache;
                } catch (OutOfMemoryError e16) {
                    e = e16;
                    str = str2;
                    bytesBuffer = bytesBuffer2;
                    i3 = i16;
                    QLog.e("QQAlbum", i3, "decode thumb", e);
                    bytesBuffer2 = bytesBuffer;
                    if (QLog.isColorLevel()) {
                        bytesBuffer2 = bytesBuffer;
                        if (url.getProtocol().equals(QAlbumUtil.PROTOCOL_ALBUM_THUMB)) {
                            QLog.d("QQAlbum", i3, "getThumb bitmap OutOfMemoryError,url:" + url + str + (SystemClock.uptimeMillis() - uptimeMillis));
                            bytesBuffer2 = bytesBuffer;
                        }
                    }
                    return null;
                } catch (Throwable th5) {
                    th = th5;
                    QLog.e("QQAlbum", i16, "decode thumb", th);
                    bytesBuffer2 = bytesBuffer2;
                    if (QLog.isColorLevel()) {
                        bytesBuffer2 = bytesBuffer2;
                        if (url.getProtocol().equals(QAlbumUtil.PROTOCOL_ALBUM_THUMB)) {
                            QLog.d("QQAlbum", i16, "getThumb bitmap Throwable,url:" + url + " cost:" + (SystemClock.uptimeMillis() - uptimeMillis));
                            bytesBuffer2 = bytesBuffer2;
                        }
                    }
                    return null;
                }
            } catch (OutOfMemoryError e17) {
                e = e17;
                bytesBuffer = bytesBuffer3;
                str = " cost:";
                i3 = 2;
            } catch (Throwable th6) {
                th = th6;
                bytesBuffer2 = bytesBuffer3;
                i16 = 2;
            }
        } finally {
            sCacheBufferPool.recycle(bytesBuffer2);
        }
    }

    private static boolean isSameKey(byte[] bArr, byte[] bArr2, int i3, int i16) {
        if (bArr.length < i16 || bArr2.length < i3 + i16) {
            return false;
        }
        for (int i17 = 0; i17 < i16; i17++) {
            if (bArr[i17] != bArr2[i3 + i17]) {
                return false;
            }
        }
        return true;
    }

    private boolean getCacheData(byte[] bArr, long j3, BytesBufferPool.BytesBuffer bytesBuffer) {
        a.C10099a c10099a;
        if (bArr == null) {
            return false;
        }
        if (this.mBlobCache == null) {
            retrieveBlobCache(this.mContext);
            if (this.mBlobCache == null) {
                return false;
            }
        }
        try {
            c10099a = new a.C10099a();
            c10099a.f390058a = j3;
            c10099a.f390059b = bytesBuffer.data;
        } catch (IOException e16) {
            QLog.e("QQAlbum", 2, "getCacheData ioexception", e16);
        }
        synchronized (this.mBlobLock) {
            if (!this.mBlobCache.l(c10099a)) {
                return false;
            }
            if (isSameKey(bArr, c10099a.f390059b)) {
                bytesBuffer.data = c10099a.f390059b;
                int length = bArr.length;
                bytesBuffer.offset = length;
                bytesBuffer.length = c10099a.f390060c - length;
                return true;
            }
            return false;
        }
    }
}
