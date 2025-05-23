package com.tencent.ams.mosaic.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Movie;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Base64;
import com.tencent.ams.animateddrawable.io.StreamReader;
import com.tencent.ams.animateddrawable.webp.WebPDrawable;
import com.tencent.ams.animateddrawable.webp.decode.WebPParser;
import com.tencent.ams.fusion.widget.apng.APNGDrawable;
import com.tencent.ams.fusion.widget.apng.decode.APNGParser;
import com.tencent.ams.fusion.widget.apng.frame.animation.loader.ByteBufferLoader;
import com.tencent.ams.mosaic.MosaicManager;
import com.tencent.ams.mosaic.f;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import cooperation.qzone.widget.QzoneEmotionUtils;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.ByteBuffer;

/* compiled from: P */
/* loaded from: classes3.dex */
public class e implements f.c {
    static IPatchRedirector $redirector_ = null;
    private static final int FLAG_SUPPORT = 1;
    private static final int FLAG_UNKNOWN = -1;
    private static final int FLAG_UNSUPPORT = 0;
    private static final String TAG = "DefaultImageLoader";
    private int aWebPLibFlag;
    private int apngLibFlag;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public class a extends ByteBufferLoader {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ byte[] f71562a;

        a(byte[] bArr) {
            this.f71562a = bArr;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) e.this, (Object) bArr);
            }
        }

        @Override // com.tencent.ams.fusion.widget.apng.frame.animation.loader.ByteBufferLoader
        public ByteBuffer getByteBuffer() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (ByteBuffer) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return ByteBuffer.wrap(this.f71562a);
        }
    }

    public e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.aWebPLibFlag = -1;
            this.apngLibFlag = -1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$loadImage$0(f.c.a aVar, String str) {
        if (aVar != null) {
            aVar.onLoadStart();
            Object image = getImage(str);
            aVar.onLoadFinish(image);
            f.e(TAG, "load image(" + str + ") result: " + image);
            return;
        }
        f.h(TAG, "cancel load image(" + str + "): listener is null");
    }

    protected int getAWebPLibFlag() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Integer) iPatchRedirector.redirect((short) 11, (Object) this)).intValue();
        }
        int i3 = this.aWebPLibFlag;
        if (i3 != -1) {
            return i3;
        }
        try {
            Class.forName("com.tencent.ams.animateddrawable.webp.WebPDrawable");
            this.aWebPLibFlag = 1;
        } catch (Throwable unused) {
            this.aWebPLibFlag = 0;
        }
        return this.aWebPLibFlag;
    }

    protected int getApngLibFlag() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Integer) iPatchRedirector.redirect((short) 15, (Object) this)).intValue();
        }
        if (this.apngLibFlag == -1) {
            this.apngLibFlag = MosaicUtils.y("com.tencent.ams.fusion.widget.apng.APNGDrawable") ? 1 : 0;
        }
        return this.apngLibFlag;
    }

    protected Drawable getDrawableFromAssert(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (Drawable) iPatchRedirector.redirect((short) 10, (Object) this, (Object) str);
        }
        f.e(TAG, "getDrawableFromAssert, src: " + str);
        if (isSupportWebP() && WebPParser.isAWebP(MosaicManager.j().i(), str)) {
            f.e(TAG, "getAWebPFromAssert, isAWebP");
            WebPDrawable fromAsset = WebPDrawable.fromAsset(MosaicManager.j().i(), str);
            fromAsset.setLoopLimit(-1);
            return fromAsset;
        }
        if (isSupportApng() && APNGParser.isAPNG(MosaicManager.j().i(), str)) {
            f.e(TAG, "getAWebPFromAssert, isAPNG");
            APNGDrawable fromAsset2 = APNGDrawable.fromAsset(MosaicManager.j().i(), str);
            fromAsset2.setLoopLimit(-1);
            return fromAsset2;
        }
        f.h(TAG, "getAWebPFromAssert, not find");
        return null;
    }

    protected Object getDrawableOrImageFromAssert(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
        }
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Drawable drawableFromAssert = getDrawableFromAssert(str);
        if (drawableFromAssert != null) {
            return drawableFromAssert;
        }
        return getImageFromAssert(str);
    }

    protected Object getImage(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
        }
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (!str.startsWith("http://") && !str.startsWith("https://")) {
            if (str.startsWith("resource://")) {
                return getDrawableOrImageFromAssert(str.replace("resource://", ""));
            }
            if (str.startsWith("assets://")) {
                return getDrawableOrImageFromAssert(str.replace("assets://", ""));
            }
            if (str.startsWith("base64://")) {
                try {
                    return getImageFromByteArray(Base64.decode(str.replace("base64://", ""), 0), null);
                } catch (Throwable th5) {
                    f.h(TAG, "getImage error." + th5.toString());
                }
            }
            return null;
        }
        return getImageFromNet(str);
    }

    protected Object getImageFromAssert(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return iPatchRedirector.redirect((short) 12, (Object) this, (Object) str);
        }
        f.a(TAG, "getImageFromAssert: " + str);
        try {
            if (str.endsWith(QzoneEmotionUtils.SIGN_ICON_URL_END)) {
                return MosaicUtils.s(MosaicManager.j().i(), str);
            }
            return MosaicUtils.c(MosaicManager.j().i(), str);
        } catch (Throwable th5) {
            f.i(TAG, "Error getImageFromAssert", th5);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Object getImageFromByteArray(final byte[] bArr, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return iPatchRedirector.redirect((short) 6, (Object) this, (Object) bArr, (Object) str);
        }
        try {
            if (isAWebP(bArr)) {
                f.e(TAG, "getImageFromByteArray, isAWebP: " + str);
                WebPDrawable webPDrawable = new WebPDrawable(new com.tencent.ams.animateddrawable.loader.ByteBufferLoader(bArr) { // from class: com.tencent.ams.mosaic.utils.DefaultImageLoader$1
                    static IPatchRedirector $redirector_;

                    /* renamed from: a, reason: collision with root package name */
                    final /* synthetic */ byte[] f71537a;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        this.f71537a = bArr;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) e.this, (Object) bArr);
                        }
                    }
                });
                webPDrawable.setLoopLimit(-1);
                f.e(TAG, "getImageFromByteArray: load webp image(" + str + ") from net success");
                return webPDrawable;
            }
            if (isApng(bArr)) {
                f.e(TAG, "getImageFromByteArray, isApng: " + str);
                APNGDrawable aPNGDrawable = new APNGDrawable(new a(bArr));
                aPNGDrawable.setLoopLimit(-1);
                return aPNGDrawable;
            }
            f.e(TAG, "getImageFromByteArray, normal image: " + str);
            BitmapFactory.Options imageOptions = getImageOptions(bArr);
            if (imageOptions != null) {
                if ("image/gif".equalsIgnoreCase(imageOptions.outMimeType)) {
                    f.e(TAG, "getImageFromByteArray: load gif image(" + str + ") from net success");
                    return new com.tencent.ams.mosaic.jsengine.component.image.b(str, Movie.decodeByteArray(bArr, 0, bArr.length));
                }
                Bitmap decodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length);
                if (decodeByteArray == null) {
                    f.h(TAG, "getImageFromByteArray, normal image, decode byte array failed");
                }
                f.e(TAG, "getImageFromByteArray, normal image, decode success");
                return decodeByteArray;
            }
            return null;
        } catch (Throwable th5) {
            f.h(TAG, "getImageFromByteArray error: " + th5.toString());
            return null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0087 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0082 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x007d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected Object getImageFromNet(String str) {
        HttpURLConnection httpURLConnection;
        InputStream inputStream;
        BufferedInputStream bufferedInputStream;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
        }
        f.a(TAG, "getImageFromNet, url: " + str);
        try {
            httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        } catch (Throwable th5) {
            th = th5;
            httpURLConnection = null;
            inputStream = null;
        }
        try {
            httpURLConnection.connect();
            inputStream = httpURLConnection.getInputStream();
            try {
                bufferedInputStream = new BufferedInputStream(inputStream);
            } catch (Throwable th6) {
                th = th6;
                bufferedInputStream = 0;
            }
        } catch (Throwable th7) {
            th = th7;
            inputStream = null;
            bufferedInputStream = inputStream;
            try {
                f.i(TAG, "Error getImageFromNet", th);
                if (httpURLConnection != null) {
                }
                if (inputStream != null) {
                }
                if (bufferedInputStream != 0) {
                }
                return null;
            } finally {
            }
        }
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr = new byte[4096];
            while (true) {
                int read = bufferedInputStream.read(bArr);
                if (-1 == read) {
                    break;
                }
                byteArrayOutputStream.write(bArr, 0, read);
            }
            Object imageFromByteArray = getImageFromByteArray(byteArrayOutputStream.toByteArray(), str);
            try {
                httpURLConnection.disconnect();
            } catch (Throwable unused) {
            }
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException unused2) {
                }
            }
            try {
                bufferedInputStream.close();
            } catch (IOException unused3) {
            }
            return imageFromByteArray;
        } catch (Throwable th8) {
            th = th8;
            f.i(TAG, "Error getImageFromNet", th);
            if (httpURLConnection != null) {
                try {
                    httpURLConnection.disconnect();
                } catch (Throwable unused4) {
                }
            }
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException unused5) {
                }
            }
            if (bufferedInputStream != 0) {
                try {
                    bufferedInputStream.close();
                } catch (IOException unused6) {
                }
            }
            return null;
        }
    }

    protected BitmapFactory.Options getImageOptions(byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (BitmapFactory.Options) iPatchRedirector.redirect((short) 9, (Object) this, (Object) bArr);
        }
        if (bArr != null && bArr.length != 0) {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
            return options;
        }
        return null;
    }

    protected boolean isAWebP(byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this, (Object) bArr)).booleanValue();
        }
        if (!isSupportWebP()) {
            return false;
        }
        return WebPParser.isAWebP(new StreamReader(new ByteArrayInputStream(bArr)));
    }

    protected boolean isApng(byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Boolean) iPatchRedirector.redirect((short) 13, (Object) this, (Object) bArr)).booleanValue();
        }
        if (!isSupportApng()) {
            return false;
        }
        return APNGParser.isAPNG(new com.tencent.ams.fusion.widget.apng.frame.animation.io.StreamReader(new ByteArrayInputStream(bArr)));
    }

    protected boolean isSupportApng() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Boolean) iPatchRedirector.redirect((short) 14, (Object) this)).booleanValue();
        }
        int apngLibFlag = getApngLibFlag();
        f.a(TAG, "getAWebPFromNet, flag: " + apngLibFlag);
        if (apngLibFlag == 1) {
            return true;
        }
        return false;
    }

    protected boolean isSupportWebP() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this)).booleanValue();
        }
        int aWebPLibFlag = getAWebPLibFlag();
        f.a(TAG, "getAWebPFromNet, flag: " + aWebPLibFlag);
        if (aWebPLibFlag == 1) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.ams.mosaic.f.c
    public void loadImage(final String str, final f.c.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) str, (Object) aVar);
        } else {
            MosaicUtils.G(new Runnable() { // from class: com.tencent.ams.mosaic.utils.d
                @Override // java.lang.Runnable
                public final void run() {
                    e.this.lambda$loadImage$0(aVar, str);
                }
            }, true);
        }
    }
}
