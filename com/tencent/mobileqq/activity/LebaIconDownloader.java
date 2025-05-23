package com.tencent.mobileqq.activity;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.tencent.cache.api.Business;
import com.tencent.cache.api.util.ImageCacheHelper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.emoticon.DownloadInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.HttpDownloadUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileInputStream;

/* compiled from: P */
/* loaded from: classes9.dex */
public class LebaIconDownloader {
    static IPatchRedirector $redirector_;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static class a implements HttpDownloadUtil.b {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        private Object[] f176377d;

        /* renamed from: e, reason: collision with root package name */
        private b f176378e;

        /* renamed from: f, reason: collision with root package name */
        private Context f176379f;

        public a(Context context, b bVar, Object... objArr) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, context, bVar, objArr);
                return;
            }
            this.f176378e = bVar;
            this.f176377d = objArr;
            this.f176379f = context.getApplicationContext();
        }

        @Override // com.tencent.mobileqq.utils.HttpDownloadUtil.b
        public void a(String str, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) str, i3);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.i("LebaListViewAdapter", 2, "--onHttpStart");
            }
            b bVar = this.f176378e;
            if (bVar != null) {
                bVar.a(0, str, null, this.f176377d);
            }
        }

        @Override // com.tencent.mobileqq.utils.HttpDownloadUtil.b
        public void b(String str, long j3, long j16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, str, Long.valueOf(j3), Long.valueOf(j16));
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.i("LebaListViewAdapter", 2, "--onHttpProgress");
            }
            b bVar = this.f176378e;
            if (bVar != null) {
                bVar.a(1, str, null, this.f176377d);
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:63:0x00ca  */
        /* JADX WARN: Removed duplicated region for block: B:66:0x00d1 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        @Override // com.tencent.mobileqq.utils.HttpDownloadUtil.b
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void c(String str, int i3) {
            FileInputStream fileInputStream;
            BitmapDrawable bitmapDrawable;
            FileInputStream fileInputStream2;
            b bVar;
            BitmapDrawable bitmapDrawable2;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) str, i3);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.i("LebaListViewAdapter", 2, "--onHttpEnd,resultCode:" + i3);
            }
            BitmapDrawable bitmapDrawable3 = null;
            try {
                if (i3 == 0) {
                    try {
                        File file = new File(this.f176379f.getFilesDir(), str);
                        if (!file.exists()) {
                            if (QLog.isColorLevel()) {
                                QLog.i("LebaListViewAdapter", 2, "--file " + str + " not exists");
                            }
                            b bVar2 = this.f176378e;
                            if (bVar2 != null) {
                                bVar2.a(2, str, null, this.f176377d);
                            }
                            b bVar3 = this.f176378e;
                            if (bVar3 != null) {
                                bVar3.a(2, str, null, this.f176377d);
                                return;
                            }
                            return;
                        }
                        fileInputStream = new FileInputStream(file);
                        try {
                            bitmapDrawable2 = new BitmapDrawable(fileInputStream);
                        } catch (Exception e16) {
                            e = e16;
                            fileInputStream2 = fileInputStream;
                            bitmapDrawable = null;
                        } catch (Throwable th5) {
                            th = th5;
                        }
                        try {
                            LebaIconDownloader.e(str, bitmapDrawable2);
                            b bVar4 = this.f176378e;
                            if (bVar4 != null) {
                                bVar4.a(2, str, bitmapDrawable2, this.f176377d);
                            }
                            fileInputStream.close();
                        } catch (Exception e17) {
                            bitmapDrawable = bitmapDrawable2;
                            e = e17;
                            fileInputStream2 = fileInputStream;
                            try {
                                if (QLog.isColorLevel()) {
                                    QLog.i("LebaListViewAdapter", 2, e.toString());
                                }
                                b bVar5 = this.f176378e;
                                if (bVar5 != null) {
                                    bVar5.a(2, str, null, this.f176377d);
                                }
                                if (fileInputStream2 != null) {
                                    fileInputStream2.close();
                                }
                            } catch (Throwable th6) {
                                th = th6;
                                bitmapDrawable3 = bitmapDrawable;
                                fileInputStream = fileInputStream2;
                                bVar = this.f176378e;
                                if (bVar != null) {
                                    bVar.a(2, str, bitmapDrawable3, this.f176377d);
                                }
                                if (fileInputStream != null) {
                                    try {
                                        fileInputStream.close();
                                    } catch (Exception unused) {
                                    }
                                }
                                throw th;
                            }
                        } catch (Throwable th7) {
                            bitmapDrawable3 = bitmapDrawable2;
                            th = th7;
                            bVar = this.f176378e;
                            if (bVar != null) {
                            }
                            if (fileInputStream != null) {
                            }
                            throw th;
                        }
                    } catch (Exception e18) {
                        e = e18;
                        bitmapDrawable = null;
                        fileInputStream2 = null;
                    } catch (Throwable th8) {
                        th = th8;
                        fileInputStream = null;
                    }
                } else {
                    b bVar6 = this.f176378e;
                    if (bVar6 != null) {
                        bVar6.a(2, str, null, this.f176377d);
                    }
                }
            } catch (Exception unused2) {
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public interface b {
        void a(int i3, String str, Drawable drawable, Object... objArr);
    }

    public static void a(QQAppInterface qQAppInterface, Context context, String str, HttpDownloadUtil.b bVar) {
        if (context == null || str == null || "".equals(str) || qQAppInterface == null) {
            return;
        }
        ThreadManagerV2.post(new Runnable(context, str, qQAppInterface, bVar) { // from class: com.tencent.mobileqq.activity.LebaIconDownloader.1
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ Context f176373d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ String f176374e;

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ QQAppInterface f176375f;

            /* renamed from: h, reason: collision with root package name */
            final /* synthetic */ HttpDownloadUtil.b f176376h;

            {
                this.f176373d = context;
                this.f176374e = str;
                this.f176375f = qQAppInterface;
                this.f176376h = bVar;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, context, str, qQAppInterface, bVar);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                try {
                    boolean z16 = false;
                    if (HttpDownloadUtil.downloadData(this.f176375f, new DownloadInfo(this.f176374e, new File(this.f176373d.getFilesDir(), this.f176374e), 0), this.f176376h) == 0) {
                        z16 = true;
                    }
                    if (z16) {
                        if (QLog.isColorLevel()) {
                            QLog.i("LebaIconDownloader", 2, "download ok");
                        }
                    } else if (QLog.isColorLevel()) {
                        QLog.i("LebaIconDownloader", 2, "download error,error code:" + z16);
                    }
                } catch (Exception e16) {
                    if (QLog.isColorLevel()) {
                        QLog.i("LebaIconDownloader", 2, e16.toString());
                    }
                }
            }
        }, 5, null, true);
    }

    public static Drawable b(Context context, String str) {
        if (d(str) != null) {
            return d(str);
        }
        if (c(context, str) != null) {
            e(str, c(context, str));
            return c(context, str);
        }
        return null;
    }

    /* JADX WARN: Type inference failed for: r5v2, types: [boolean] */
    public static Drawable c(Context context, String str) {
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2 = null;
        if (context == null) {
            return null;
        }
        File file = new File(context.getFilesDir(), str);
        ?? exists = file.exists();
        try {
            if (exists != 0) {
                try {
                    fileInputStream = new FileInputStream(file);
                } catch (Exception e16) {
                    e = e16;
                    fileInputStream = null;
                } catch (Throwable th5) {
                    th = th5;
                    if (fileInputStream2 != null) {
                        try {
                            fileInputStream2.close();
                        } catch (Exception unused) {
                        }
                    }
                    throw th;
                }
                try {
                    BitmapDrawable bitmapDrawable = new BitmapDrawable(fileInputStream);
                    try {
                        fileInputStream.close();
                    } catch (Exception unused2) {
                    }
                    return bitmapDrawable;
                } catch (Exception e17) {
                    e = e17;
                    if (QLog.isColorLevel()) {
                        QLog.e("LebaIconDownloader", 2, "io exception:" + e.toString());
                    }
                    if (fileInputStream == null) {
                        return null;
                    }
                    try {
                        fileInputStream.close();
                        return null;
                    } catch (Exception unused3) {
                        return null;
                    }
                }
            }
            if (!QLog.isColorLevel()) {
                return null;
            }
            QLog.e("LebaIconDownloader", 2, "--file " + str + "does not exist.");
            return null;
        } catch (Throwable th6) {
            th = th6;
            fileInputStream2 = exists;
        }
    }

    public static Drawable d(String str) {
        Object g16 = ImageCacheHelper.f98636a.g(str);
        if (g16 == null || !(g16 instanceof Drawable)) {
            return null;
        }
        return (Drawable) g16;
    }

    public static void e(String str, Drawable drawable) {
        ImageCacheHelper.f98636a.i(str, drawable, Business.Leba);
    }
}
