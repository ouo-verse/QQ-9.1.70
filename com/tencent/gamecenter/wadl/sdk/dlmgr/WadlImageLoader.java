package com.tencent.gamecenter.wadl.sdk.dlmgr;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import androidx.collection.LruCache;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.open.appcommon.Common;
import com.tencent.open.base.MD5Utils;
import com.tencent.open.base.img.ImageCache;
import com.tencent.qphone.base.util.QLog;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/* compiled from: P */
/* loaded from: classes6.dex */
public class WadlImageLoader {
    private static final int MAX_SIZE = 10;
    protected static final String TAG = "Wadl_WadlImageLoader";
    protected static WadlImageLoader sInstance;
    protected static final byte[] sLock = new byte[1];
    protected LruCache<String, Bitmap> mLruCache = new LruCache<>(10);

    /* compiled from: P */
    /* loaded from: classes6.dex */
    public interface ImageLoadListener {
        void onImageLoaded(String str, Bitmap bitmap, String str2);
    }

    /* compiled from: P */
    /* loaded from: classes6.dex */
    class a implements qp3.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f107245a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f107246b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ ImageLoadListener f107247c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f107248d;

        a(int i3, int i16, ImageLoadListener imageLoadListener, String str) {
            this.f107245a = i3;
            this.f107246b = i16;
            this.f107247c = imageLoadListener;
            this.f107248d = str;
        }

        /* JADX WARN: Removed duplicated region for block: B:17:0x0065 A[Catch: all -> 0x006b, TRY_LEAVE, TryCatch #7 {all -> 0x006b, blocks: (B:22:0x0052, B:23:0x0054, B:31:0x0060, B:15:0x0061, B:17:0x0065, B:25:0x0055, B:26:0x005c), top: B:21:0x0052, inners: #8 }] */
        /* JADX WARN: Removed duplicated region for block: B:21:0x0052 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        @Override // qp3.b
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void a(String str, String str2, String str3) {
            ImageLoadListener imageLoadListener;
            InputStream inputStream;
            if (!Common.w()) {
                Bitmap bitmap = null;
                try {
                } catch (IOException e16) {
                    e16.printStackTrace();
                }
                try {
                    try {
                        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(this.f107248d).openConnection();
                        httpURLConnection.setConnectTimeout(5000);
                        httpURLConnection.setRequestMethod("GET");
                        inputStream = httpURLConnection.getInputStream();
                    } catch (MalformedURLException e17) {
                        e = e17;
                        inputStream = null;
                    } catch (Throwable th5) {
                        th = th5;
                        inputStream = null;
                    }
                    try {
                        bitmap = WadlImageLoader.decodeScaledBitmap(str3, this.f107245a, this.f107246b);
                    } catch (MalformedURLException e18) {
                        e = e18;
                        e.printStackTrace();
                        if (inputStream != null) {
                            inputStream.close();
                        }
                        if (bitmap != null) {
                        }
                        imageLoadListener = this.f107247c;
                        if (imageLoadListener != null) {
                        }
                        QLog.d(WadlImageLoader.TAG, 1, "-->imgDownloadErrorload path = " + str2 + " localUrl = " + str3 + ",bitmap:" + bitmap);
                    } catch (Throwable th6) {
                        th = th6;
                        th.printStackTrace();
                        if (inputStream != null) {
                            inputStream.close();
                        }
                        if (bitmap != null) {
                        }
                        imageLoadListener = this.f107247c;
                        if (imageLoadListener != null) {
                        }
                        QLog.d(WadlImageLoader.TAG, 1, "-->imgDownloadErrorload path = " + str2 + " localUrl = " + str3 + ",bitmap:" + bitmap);
                    }
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    if (bitmap != null) {
                        try {
                            synchronized (WadlImageLoader.sLock) {
                                WadlImageLoader.this.mLruCache.put(str, bitmap);
                            }
                        } catch (Throwable th7) {
                            QLog.e(WadlImageLoader.TAG, 1, th7, new Object[0]);
                        }
                    }
                    imageLoadListener = this.f107247c;
                    if (imageLoadListener != null) {
                        imageLoadListener.onImageLoaded(this.f107248d, bitmap, str3);
                    }
                    QLog.d(WadlImageLoader.TAG, 1, "-->imgDownloadErrorload path = " + str2 + " localUrl = " + str3 + ",bitmap:" + bitmap);
                } catch (Throwable th8) {
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException e19) {
                            e19.printStackTrace();
                        }
                    }
                    throw th8;
                }
            }
        }

        @Override // qp3.b
        public void b(String str, String str2, String str3) {
            try {
                Bitmap decodeScaledBitmap = WadlImageLoader.decodeScaledBitmap(str3, this.f107245a, this.f107246b);
                if (decodeScaledBitmap != null) {
                    synchronized (WadlImageLoader.sLock) {
                        WadlImageLoader.this.mLruCache.put(str, decodeScaledBitmap);
                    }
                }
                ImageLoadListener imageLoadListener = this.f107247c;
                if (imageLoadListener != null) {
                    imageLoadListener.onImageLoaded(this.f107248d, decodeScaledBitmap, str3);
                }
                QLog.d(WadlImageLoader.TAG, 1, "-->imgDownloaded path = " + str2 + " localUrl = " + str3 + ",bitmap:" + decodeScaledBitmap);
            } catch (Throwable th5) {
                QLog.e(WadlImageLoader.TAG, 1, th5, new Object[0]);
            }
        }
    }

    protected WadlImageLoader() {
    }

    public static Bitmap decodeScaledBitmap(String str, int i3, int i16) {
        BufferedInputStream bufferedInputStream;
        BitmapFactory.Options options;
        BufferedInputStream bufferedInputStream2;
        Bitmap bitmap = null;
        if (str == null) {
            return null;
        }
        try {
            BitmapFactory.Options options2 = new BitmapFactory.Options();
            options2.inJustDecodeBounds = true;
            bufferedInputStream = new BufferedInputStream(new FileInputStream(str));
            try {
                SafeBitmapFactory.decodeStream(bufferedInputStream, null, options2);
                int i17 = options2.outWidth;
                int i18 = options2.outHeight;
                options = new BitmapFactory.Options();
                options.inSampleSize = Math.max(i17 / i3, i18 / i16);
                options.inJustDecodeBounds = false;
                options.inPurgeable = true;
                bufferedInputStream.close();
                bufferedInputStream2 = new BufferedInputStream(new FileInputStream(str));
            } catch (Throwable th5) {
                th = th5;
            }
        } catch (Throwable th6) {
            th = th6;
            bufferedInputStream = null;
        }
        try {
            bitmap = SafeBitmapFactory.decodeStream(bufferedInputStream2, null, options);
            bufferedInputStream2.close();
        } catch (Throwable th7) {
            th = th7;
            bufferedInputStream = bufferedInputStream2;
            try {
                th.printStackTrace();
                if (bufferedInputStream != null) {
                    bufferedInputStream.close();
                }
                return bitmap;
            } catch (Throwable th8) {
                if (bufferedInputStream != null) {
                    try {
                        bufferedInputStream.close();
                    } catch (IOException unused) {
                    }
                }
                throw th8;
            }
        }
        return bitmap;
    }

    public static WadlImageLoader getInstance() {
        if (sInstance == null) {
            synchronized (sLock) {
                if (sInstance == null) {
                    sInstance = new WadlImageLoader();
                }
            }
        }
        return sInstance;
    }

    public Bitmap loadCachedBitmap(String str) {
        Bitmap bitmap;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String encodeHexStr = MD5Utils.encodeHexStr(str);
        synchronized (sLock) {
            bitmap = this.mLruCache.get(encodeHexStr);
        }
        return bitmap;
    }

    public void loadImage(String str, ImageLoadListener imageLoadListener, int i3, int i16) {
        ImageCache.c("app", str, new a(i3, i16, imageLoadListener, str));
    }

    public void removeImage(String str) {
        String encodeHexStr = MD5Utils.encodeHexStr(str);
        synchronized (sLock) {
            this.mLruCache.remove(encodeHexStr);
        }
        ImageCache.a(str);
    }
}
