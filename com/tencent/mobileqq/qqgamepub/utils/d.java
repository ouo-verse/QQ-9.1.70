package com.tencent.mobileqq.qqgamepub.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v4.util.LruCache;
import android.text.TextUtils;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
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
/* loaded from: classes16.dex */
public class d {
    static IPatchRedirector $redirector_;

    /* renamed from: b, reason: collision with root package name */
    protected static d f264713b;

    /* renamed from: c, reason: collision with root package name */
    protected static final byte[] f264714c;

    /* renamed from: a, reason: collision with root package name */
    protected LruCache<String, Bitmap> f264715a;

    /* compiled from: P */
    /* loaded from: classes16.dex */
    class a implements qp3.b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f264716a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f264717b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ b f264718c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f264719d;

        a(int i3, int i16, b bVar, String str) {
            this.f264716a = i3;
            this.f264717b = i16;
            this.f264718c = bVar;
            this.f264719d = str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, d.this, Integer.valueOf(i3), Integer.valueOf(i16), bVar, str);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:25:0x0079 A[Catch: all -> 0x007f, TRY_LEAVE, TryCatch #8 {all -> 0x007f, blocks: (B:29:0x0066, B:30:0x0068, B:38:0x0074, B:23:0x0075, B:25:0x0079, B:32:0x0069, B:33:0x0070), top: B:28:0x0066, inners: #1 }] */
        /* JADX WARN: Removed duplicated region for block: B:28:0x0066 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Type inference failed for: r1v14, types: [boolean] */
        /* JADX WARN: Type inference failed for: r1v15 */
        /* JADX WARN: Type inference failed for: r1v16 */
        /* JADX WARN: Type inference failed for: r1v17 */
        /* JADX WARN: Type inference failed for: r1v18 */
        /* JADX WARN: Type inference failed for: r1v5, types: [java.io.InputStream] */
        /* JADX WARN: Type inference failed for: r1v7 */
        @Override // qp3.b
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void a(String str, String str2, String str3) {
            b bVar;
            InputStream inputStream;
            ?? r16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && (r16 = iPatchRedirector.hasPatch((short) 3)) != 0) {
                iPatchRedirector.redirect((short) 3, this, str, str2, str3);
                return;
            }
            if (!Common.w()) {
                Bitmap bitmap = null;
                try {
                } catch (IOException e16) {
                    e16.printStackTrace();
                }
                try {
                    try {
                        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(this.f264719d).openConnection();
                        httpURLConnection.setConnectTimeout(5000);
                        httpURLConnection.setRequestMethod("GET");
                        inputStream = httpURLConnection.getInputStream();
                        try {
                            bitmap = d.a(str3, this.f264716a, this.f264717b);
                        } catch (MalformedURLException e17) {
                            e = e17;
                            e.printStackTrace();
                            r16 = inputStream;
                            if (inputStream != null) {
                                inputStream.close();
                                r16 = inputStream;
                            }
                            if (bitmap != null) {
                            }
                            bVar = this.f264718c;
                            if (bVar != null) {
                            }
                            QLog.d("QQGameImageLoader", 1, "-->imgDownloadErrorload path = " + str2 + " localUrl = " + str3 + ",bitmap:" + bitmap);
                        } catch (Throwable th5) {
                            th = th5;
                            th.printStackTrace();
                            r16 = inputStream;
                            if (inputStream != null) {
                                inputStream.close();
                                r16 = inputStream;
                            }
                            if (bitmap != null) {
                            }
                            bVar = this.f264718c;
                            if (bVar != null) {
                            }
                            QLog.d("QQGameImageLoader", 1, "-->imgDownloadErrorload path = " + str2 + " localUrl = " + str3 + ",bitmap:" + bitmap);
                        }
                    } catch (MalformedURLException e18) {
                        e = e18;
                        inputStream = null;
                    } catch (Throwable th6) {
                        th = th6;
                        inputStream = null;
                    }
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    if (bitmap != null) {
                        try {
                            synchronized (d.f264714c) {
                                d.this.f264715a.put(str, bitmap);
                            }
                        } catch (Throwable th7) {
                            QLog.e("QQGameImageLoader", 1, th7, new Object[0]);
                        }
                    }
                    bVar = this.f264718c;
                    if (bVar != null) {
                        bVar.onImageLoaded(this.f264719d, bitmap, str3);
                    }
                    QLog.d("QQGameImageLoader", 1, "-->imgDownloadErrorload path = " + str2 + " localUrl = " + str3 + ",bitmap:" + bitmap);
                } catch (Throwable th8) {
                    if (r16 != 0) {
                        try {
                            r16.close();
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
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, str, str2, str3);
                return;
            }
            try {
                Bitmap a16 = d.a(str3, this.f264716a, this.f264717b);
                if (a16 != null) {
                    synchronized (d.f264714c) {
                        d.this.f264715a.put(str, a16);
                    }
                }
                b bVar = this.f264718c;
                if (bVar != null) {
                    bVar.onImageLoaded(this.f264719d, a16, str3);
                }
                QLog.d("QQGameImageLoader", 1, "-->imgDownloaded path = " + str2 + " localUrl = " + str3 + ",bitmap:" + a16);
            } catch (Throwable th5) {
                QLog.e("QQGameImageLoader", 1, th5, new Object[0]);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes16.dex */
    public interface b {
        void onImageLoaded(String str, Bitmap bitmap, String str2);
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(27525);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            f264714c = new byte[1];
        }
    }

    protected d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f264715a = new LruCache<>(10);
        }
    }

    public static Bitmap a(String str, int i3, int i16) {
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

    public static d b() {
        if (f264713b == null) {
            synchronized (f264714c) {
                if (f264713b == null) {
                    f264713b = new d();
                }
            }
        }
        return f264713b;
    }

    public Bitmap c(String str) {
        Bitmap bitmap;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Bitmap) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
        }
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String encodeHexStr = MD5Utils.encodeHexStr(str);
        synchronized (f264714c) {
            bitmap = this.f264715a.get(encodeHexStr);
        }
        return bitmap;
    }

    public void d(String str, b bVar, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, str, bVar, Integer.valueOf(i3), Integer.valueOf(i16));
        } else {
            ImageCache.c("app", str, new a(i3, i16, bVar, str));
        }
    }
}
