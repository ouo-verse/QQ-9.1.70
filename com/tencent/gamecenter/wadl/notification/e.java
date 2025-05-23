package com.tencent.gamecenter.wadl.notification;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import androidx.collection.LruCache;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.mobileqq.utils.BaseImageUtil;
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
public class e {

    /* renamed from: b, reason: collision with root package name */
    protected static e f106953b;

    /* renamed from: c, reason: collision with root package name */
    protected static final byte[] f106954c = new byte[1];

    /* renamed from: a, reason: collision with root package name */
    protected LruCache<String, Bitmap> f106955a = new LruCache<>(10);

    /* compiled from: P */
    /* loaded from: classes6.dex */
    class a implements qp3.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f106956a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f106957b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ b f106958c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f106959d;

        a(int i3, int i16, b bVar, String str) {
            this.f106956a = i3;
            this.f106957b = i16;
            this.f106958c = bVar;
            this.f106959d = str;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:13:0x008b A[Catch: all -> 0x0091, TRY_LEAVE, TryCatch #0 {all -> 0x0091, blocks: (B:18:0x0078, B:19:0x007a, B:27:0x0086, B:11:0x0087, B:13:0x008b, B:21:0x007b, B:22:0x0082), top: B:17:0x0078, inners: #2 }] */
        /* JADX WARN: Removed duplicated region for block: B:17:0x0078 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Type inference failed for: r3v4, types: [java.lang.Throwable, java.io.IOException] */
        /* JADX WARN: Type inference failed for: r3v7, types: [java.lang.Throwable, java.io.IOException] */
        @Override // qp3.b
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void a(String str, String str2, String str3) {
            InputStream inputStream;
            InputStream inputStream2;
            b bVar;
            if (!Common.w()) {
                Bitmap bitmap = null;
                try {
                    try {
                        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(this.f106959d).openConnection();
                        httpURLConnection.setConnectTimeout(5000);
                        httpURLConnection.setRequestMethod("GET");
                        inputStream = httpURLConnection.getInputStream();
                        try {
                            bitmap = e.a(str3, this.f106956a, this.f106957b);
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (IOException e16) {
                                    QLog.e("Wadl_WadlImageLoader", 1, e16, new Object[0]);
                                }
                            }
                        } catch (MalformedURLException e17) {
                            e = e17;
                            QLog.e("Wadl_WadlImageLoader", 1, "imgDownloadError", e);
                            inputStream2 = inputStream;
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                    inputStream2 = inputStream;
                                } catch (IOException e18) {
                                    QLog.e("Wadl_WadlImageLoader", 1, (Throwable) e18, new Object[0]);
                                    inputStream2 = e18;
                                }
                            }
                            if (bitmap != null) {
                            }
                            bVar = this.f106958c;
                            if (bVar != null) {
                            }
                            QLog.d("Wadl_WadlImageLoader", 1, "-->imgDownloadErrorload path = " + str2 + " localUrl = " + str3 + ",bitmap:" + bitmap);
                        } catch (Throwable th5) {
                            th = th5;
                            QLog.e("Wadl_WadlImageLoader", 1, "imgDownloadError", th);
                            inputStream2 = inputStream;
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                    inputStream2 = inputStream;
                                } catch (IOException e19) {
                                    QLog.e("Wadl_WadlImageLoader", 1, (Throwable) e19, new Object[0]);
                                    inputStream2 = e19;
                                }
                            }
                            if (bitmap != null) {
                            }
                            bVar = this.f106958c;
                            if (bVar != null) {
                            }
                            QLog.d("Wadl_WadlImageLoader", 1, "-->imgDownloadErrorload path = " + str2 + " localUrl = " + str3 + ",bitmap:" + bitmap);
                        }
                    } catch (MalformedURLException e26) {
                        e = e26;
                        inputStream = null;
                    } catch (Throwable th6) {
                        th = th6;
                        inputStream = null;
                    }
                    if (bitmap != null) {
                        try {
                            synchronized (e.f106954c) {
                                e.this.f106955a.put(str, bitmap);
                            }
                        } catch (Throwable th7) {
                            QLog.e("Wadl_WadlImageLoader", 1, th7, new Object[0]);
                        }
                    }
                    bVar = this.f106958c;
                    if (bVar != null) {
                        bVar.onImageLoaded(this.f106959d, bitmap, str3);
                    }
                    QLog.d("Wadl_WadlImageLoader", 1, "-->imgDownloadErrorload path = " + str2 + " localUrl = " + str3 + ",bitmap:" + bitmap);
                } catch (Throwable th8) {
                    if (inputStream2 != null) {
                        try {
                            inputStream2.close();
                        } catch (IOException e27) {
                            QLog.e("Wadl_WadlImageLoader", 1, e27, new Object[0]);
                        }
                    }
                    throw th8;
                }
            }
        }

        @Override // qp3.b
        public void b(String str, String str2, String str3) {
            try {
                Bitmap a16 = e.a(str3, this.f106956a, this.f106957b);
                if (a16 != null) {
                    int i3 = this.f106956a;
                    a16 = BaseImageUtil.getRoundedCornerBitmap2(a16, i3 * 0.2f, i3, this.f106957b);
                    synchronized (e.f106954c) {
                        e.this.f106955a.put(str, a16);
                    }
                }
                b bVar = this.f106958c;
                if (bVar != null) {
                    bVar.onImageLoaded(this.f106959d, a16, str3);
                }
                QLog.d("Wadl_WadlImageLoader", 1, "-->imgDownloaded path = " + str2 + " localUrl = " + str3 + ",bitmap:" + a16);
            } catch (Throwable th5) {
                QLog.e("Wadl_WadlImageLoader", 1, "imgDownloaded exception", th5);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes6.dex */
    public interface b {
        void onImageLoaded(String str, Bitmap bitmap, String str2);
    }

    protected e() {
    }

    public static Bitmap a(String str, int i3, int i16) {
        BufferedInputStream bufferedInputStream;
        Bitmap bitmap = null;
        if (str == null) {
            return null;
        }
        try {
            try {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inJustDecodeBounds = true;
                bufferedInputStream = new BufferedInputStream(new FileInputStream(str));
                try {
                    SafeBitmapFactory.decodeStream(bufferedInputStream, null, options);
                    int i17 = options.outWidth;
                    int i18 = options.outHeight;
                    BitmapFactory.Options options2 = new BitmapFactory.Options();
                    options2.inSampleSize = Math.max(i17 / i3, i18 / i16);
                    options2.inJustDecodeBounds = false;
                    options2.inPurgeable = true;
                    bufferedInputStream.close();
                    BufferedInputStream bufferedInputStream2 = new BufferedInputStream(new FileInputStream(str));
                    try {
                        bitmap = SafeBitmapFactory.decodeStream(bufferedInputStream2, null, options2);
                        bufferedInputStream2.close();
                    } catch (Throwable th5) {
                        th = th5;
                        bufferedInputStream = bufferedInputStream2;
                        try {
                            QLog.e("Wadl_WadlImageLoader", 1, "decodeScaledBitmap exception", th);
                            if (bufferedInputStream != null) {
                                bufferedInputStream.close();
                            }
                            return bitmap;
                        } catch (Throwable th6) {
                            if (bufferedInputStream != null) {
                                try {
                                    bufferedInputStream.close();
                                } catch (IOException e16) {
                                    QLog.e("Wadl_WadlImageLoader", 1, "decodeScaledBitmap is.close exception", e16);
                                }
                            }
                            throw th6;
                        }
                    }
                } catch (Throwable th7) {
                    th = th7;
                }
            } catch (Throwable th8) {
                th = th8;
                bufferedInputStream = null;
            }
        } catch (IOException e17) {
            QLog.e("Wadl_WadlImageLoader", 1, "decodeScaledBitmap is.close exception", e17);
        }
        return bitmap;
    }

    public static e b() {
        if (f106953b == null) {
            synchronized (f106954c) {
                if (f106953b == null) {
                    f106953b = new e();
                }
            }
        }
        return f106953b;
    }

    public Bitmap c(String str) {
        Bitmap bitmap;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String encodeHexStr = MD5Utils.encodeHexStr(str);
        synchronized (f106954c) {
            bitmap = this.f106955a.get(encodeHexStr);
        }
        return bitmap;
    }

    public void d(String str, b bVar, int i3, int i16) {
        ImageCache.c("app", str, new a(i3, i16, bVar, str));
    }
}
