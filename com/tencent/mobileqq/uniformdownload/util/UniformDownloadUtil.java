package com.tencent.mobileqq.uniformdownload.util;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.util.ah;
import com.tencent.mobileqq.filemanager.util.q;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.kapalaiadapter.FileProvider7Helper;
import com.tencent.mtt.hippy.adapter.http.HttpHeader;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tmdownloader.TMAssistantDownloadManager;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;
import java.util.Random;
import org.apache.httpcore.HttpHeaders;

/* compiled from: P */
/* loaded from: classes17.dex */
public class UniformDownloadUtil {
    static IPatchRedirector $redirector_;

    /* compiled from: P */
    /* loaded from: classes17.dex */
    public static class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public String f306003a;

        /* renamed from: b, reason: collision with root package name */
        public long f306004b;

        public a(String str, long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, str, Long.valueOf(j3));
            } else {
                this.f306003a = str;
                this.f306004b = j3;
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes17.dex */
    public interface b {
        void onResult(String str);
    }

    public static long a() {
        return (((int) (System.currentTimeMillis() / 1000)) << 32) | Math.abs(new Random().nextInt());
    }

    public static Bitmap b(String str) {
        if (str == null) {
            QLog.i("UniformDownloadUtil", 1, "[UniformDL] getApkIcon failed.url = null");
            return null;
        }
        try {
            Class<?> cls = Class.forName("android.content.pm.PackageParser");
            Object newInstance = cls.getConstructor(String.class).newInstance(str);
            DisplayMetrics displayMetrics = new DisplayMetrics();
            displayMetrics.setToDefaults();
            Object invoke = cls.getDeclaredMethod("parsePackage", File.class, String.class, DisplayMetrics.class, Integer.TYPE).invoke(newInstance, new File(str), str, displayMetrics, 0);
            ApplicationInfo applicationInfo = (ApplicationInfo) invoke.getClass().getDeclaredField("applicationInfo").get(invoke);
            Class<?> cls2 = Class.forName("android.content.res.AssetManager");
            Object newInstance2 = cls2.newInstance();
            cls2.getDeclaredMethod("addAssetPath", String.class).invoke(newInstance2, str);
            Resources resources = BaseApplication.getContext().getResources();
            Resources resources2 = (Resources) Resources.class.getConstructor(newInstance2.getClass(), resources.getDisplayMetrics().getClass(), resources.getConfiguration().getClass()).newInstance(newInstance2, resources.getDisplayMetrics(), resources.getConfiguration());
            if (applicationInfo != null && applicationInfo.icon != 0) {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inJustDecodeBounds = true;
                BitmapFactory.decodeResource(resources2, applicationInfo.icon, options);
                options.inSampleSize = 1;
                options.inJustDecodeBounds = false;
                return BitmapFactory.decodeResource(resources2, applicationInfo.icon, options);
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        } catch (OutOfMemoryError e17) {
            e17.printStackTrace();
        }
        return null;
    }

    public static String c(String str) {
        String str2;
        if (str == null) {
            QLog.e("UniformDownloadUtil", 1, "[UniformDL] isApk. path = null");
            return null;
        }
        try {
            PackageInfo packageArchiveInfo = BaseApplication.getContext().getPackageManager().getPackageArchiveInfo(str, 1);
            if (packageArchiveInfo != null) {
                str2 = packageArchiveInfo.applicationInfo.packageName;
            } else {
                str2 = null;
            }
            if (str2 != null) {
                return str2;
            }
            QLog.e("UniformDownloadUtil", 1, "[UniformDL] isApk. get package failed.  PH:" + str);
            return null;
        } catch (Exception e16) {
            QLog.e("UniformDownloadUtil", 1, "[UniformDL] isApk. Exception 1");
            e16.printStackTrace();
            return null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x007a, code lost:
    
        if (r3.contains("\\") != false) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00c3, code lost:
    
        if (r5.contains("\\") != false) goto L57;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00aa, code lost:
    
        if (r9 == null) goto L73;
     */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00b3 A[Catch: Exception -> 0x00c7, TryCatch #5 {Exception -> 0x00c7, blocks: (B:25:0x00ad, B:27:0x00b3, B:29:0x00b9, B:31:0x00bf), top: B:24:0x00ad }] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00bf A[Catch: Exception -> 0x00c7, TRY_LEAVE, TryCatch #5 {Exception -> 0x00c7, blocks: (B:25:0x00ad, B:27:0x00b3, B:29:0x00b9, B:31:0x00bf), top: B:24:0x00ad }] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00d2  */
    /* JADX WARN: Type inference failed for: r9v0, types: [int] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static a d(String str) {
        String str2;
        HttpURLConnection httpURLConnection;
        Uri parse;
        String str3 = "";
        long j3 = 0;
        HttpURLConnection httpURLConnection2 = null;
        if (str != null) {
            ?? length = str.length();
            try {
                if (length >= 1) {
                    try {
                        httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
                        try {
                            httpURLConnection.setRequestProperty(HttpHeaders.ACCEPT_CHARSET, "utf-8");
                            httpURLConnection.setRequestProperty("contentType", "utf-8");
                            httpURLConnection.setRequestProperty(HttpHeaders.ACCEPT_CHARSET, "utf-8");
                            httpURLConnection.setRequestProperty("contentType", "utf-8");
                            httpURLConnection.connect();
                            httpURLConnection.getResponseCode();
                            URL url = httpURLConnection.getURL();
                            QLog.e("GetName", 1, "x:" + url);
                            j3 = (long) httpURLConnection.getContentLength();
                            str2 = f(httpURLConnection);
                            try {
                                if (TextUtils.isEmpty(str2) && url != null) {
                                    str2 = url.getFile();
                                }
                                if (str2 != null) {
                                    if (!str2.contains("/")) {
                                    }
                                    str2 = null;
                                }
                            } catch (MalformedURLException e16) {
                                e = e16;
                                e.printStackTrace();
                            } catch (IOException e17) {
                                e = e17;
                                e.printStackTrace();
                                if (httpURLConnection != null) {
                                    httpURLConnection.disconnect();
                                }
                                parse = Uri.parse(str);
                                if (parse != null) {
                                    if (!str3.contains("/")) {
                                    }
                                    str3 = null;
                                }
                                if (TextUtils.isEmpty(str2)) {
                                }
                                return new a(str2, j3);
                            } catch (Exception e18) {
                                e = e18;
                                e.printStackTrace();
                                if (httpURLConnection != null) {
                                    httpURLConnection.disconnect();
                                }
                                parse = Uri.parse(str);
                                if (parse != null) {
                                }
                                if (TextUtils.isEmpty(str2)) {
                                }
                                return new a(str2, j3);
                            }
                        } catch (MalformedURLException e19) {
                            e = e19;
                            str2 = "";
                        } catch (IOException e26) {
                            e = e26;
                            str2 = "";
                        } catch (Exception e27) {
                            e = e27;
                            str2 = "";
                        }
                    } catch (MalformedURLException e28) {
                        e = e28;
                        str2 = "";
                        httpURLConnection = null;
                    } catch (IOException e29) {
                        e = e29;
                        str2 = "";
                        httpURLConnection = null;
                    } catch (Exception e36) {
                        e = e36;
                        str2 = "";
                        httpURLConnection = null;
                    } catch (Throwable th5) {
                        th = th5;
                        if (httpURLConnection2 != null) {
                            httpURLConnection2.disconnect();
                        }
                        throw th;
                    }
                    httpURLConnection.disconnect();
                    try {
                        parse = Uri.parse(str);
                        if (parse != null && (str3 = parse.getLastPathSegment()) != null) {
                            if (!str3.contains("/")) {
                            }
                            str3 = null;
                        }
                    } catch (Exception e37) {
                        e37.printStackTrace();
                    }
                    if (TextUtils.isEmpty(str2)) {
                        str2 = str3;
                    }
                    return new a(str2, j3);
                }
            } catch (Throwable th6) {
                th = th6;
                httpURLConnection2 = length;
            }
        }
        return new a(null, 0L);
    }

    public static void e(String str, com.tencent.mobileqq.uniformdownload.util.a aVar) {
        ThreadManager.getSubThreadHandler().post(new Runnable(str, aVar) { // from class: com.tencent.mobileqq.uniformdownload.util.UniformDownloadUtil.1
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ String f305994d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ com.tencent.mobileqq.uniformdownload.util.a f305995e;

            {
                this.f305994d = str;
                this.f305995e = aVar;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, (Object) aVar);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                a d16 = UniformDownloadUtil.d(this.f305994d);
                com.tencent.mobileqq.uniformdownload.util.a aVar2 = this.f305995e;
                if (aVar2 != null && d16 != null) {
                    aVar2.a(d16.f306003a, d16.f306004b);
                }
            }
        });
    }

    private static String f(HttpURLConnection httpURLConnection) {
        String decode;
        String substring;
        String str = null;
        try {
            String decode2 = URLDecoder.decode(new String(httpURLConnection.getHeaderField(HttpHeader.RSP.CONTENT_DISPOSITION).getBytes("ISO-8859-1"), "utf-8"), "utf-8");
            if (decode2 == null || (decode = URLDecoder.decode(new String(decode2.getBytes("ISO-8859-1"), "utf-8"), "utf-8")) == null) {
                return null;
            }
            int indexOf = decode.indexOf("filename=");
            if (-1 == indexOf) {
                indexOf = decode.indexOf("FileName=");
            }
            if (-1 != indexOf && (substring = decode.substring(indexOf + 9, decode.length())) != null) {
                int indexOf2 = substring.indexOf(";");
                str = -1 != indexOf2 ? substring.substring(0, indexOf2 - 1) : substring;
            }
            if (!TextUtils.isEmpty(str)) {
                int indexOf3 = str.indexOf("\"");
                int lastIndexOf = str.lastIndexOf("\"") + 1;
                if (indexOf3 == 0 && lastIndexOf == str.length()) {
                    String substring2 = str.substring(1);
                    return substring2.substring(0, substring2.length() - 1);
                }
                return str;
            }
            return str;
        } catch (UnsupportedEncodingException e16) {
            e16.printStackTrace();
            return null;
        }
    }

    public static void g(String str) {
        h(str, null);
    }

    public static void h(String str, String str2) {
        n(str, new b(str, str2) { // from class: com.tencent.mobileqq.uniformdownload.util.UniformDownloadUtil.3
            static IPatchRedirector $redirector_;

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ String f305998a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ String f305999b;

            {
                this.f305998a = str;
                this.f305999b = str2;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, (Object) str2);
                }
            }

            @Override // com.tencent.mobileqq.uniformdownload.util.UniformDownloadUtil.b
            public void onResult(String str3) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) str3);
                } else {
                    if (str3 == null) {
                        return;
                    }
                    new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.tencent.mobileqq.uniformdownload.util.UniformDownloadUtil.3.1
                        static IPatchRedirector $redirector_;

                        {
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AnonymousClass3.this);
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            String str4;
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                iPatchRedirector2.redirect((short) 2, (Object) this);
                                return;
                            }
                            AnonymousClass3 anonymousClass3 = AnonymousClass3.this;
                            String str5 = anonymousClass3.f305998a;
                            if (TextUtils.isEmpty(anonymousClass3.f305999b)) {
                                str4 = "biz_src_unknown";
                            } else {
                                str4 = AnonymousClass3.this.f305999b;
                            }
                            UniformDownloadUtil.k(str5, str4);
                        }
                    });
                }
            }
        });
    }

    public static boolean i(String str) {
        if (str != null && q.j(str).equalsIgnoreCase(".apk")) {
            return true;
        }
        return false;
    }

    public static int j(String str) {
        return k(str, null);
    }

    public static int k(String str, String str2) {
        if (str == null) {
            return -1;
        }
        try {
            if (!new File(str).exists()) {
                QLog.e("UniformDownloadUtil", 1, "[UniformDL] openApk. file is not exsited. PH:" + str);
                return -2;
            }
            TMAssistantDownloadManager.getInstance(BaseApplication.getContext()).hookAM4Install();
            Intent openApkIntent = FileProvider7Helper.openApkIntent(BaseApplication.getContext(), str);
            openApkIntent.putExtra("big_brother_source_key", str2);
            BaseApplication.getContext().startActivity(openApkIntent);
            return 0;
        } catch (Exception e16) {
            QLog.e("UniformDownloadUtil", 1, "[UniformDL] openApk. Exception 2");
            e16.printStackTrace();
            return -3;
        }
    }

    public static void l(String str, String str2) {
        n(str, new b(str, str2) { // from class: com.tencent.mobileqq.uniformdownload.util.UniformDownloadUtil.4
            static IPatchRedirector $redirector_;

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ String f306000a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ String f306001b;

            {
                this.f306000a = str;
                this.f306001b = str2;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, (Object) str2);
                }
            }

            @Override // com.tencent.mobileqq.uniformdownload.util.UniformDownloadUtil.b
            public void onResult(String str3) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) str3);
                } else {
                    new Handler(Looper.getMainLooper()).post(new Runnable(str3) { // from class: com.tencent.mobileqq.uniformdownload.util.UniformDownloadUtil.4.1
                        static IPatchRedirector $redirector_;

                        /* renamed from: d, reason: collision with root package name */
                        final /* synthetic */ String f306002d;

                        {
                            this.f306002d = str3;
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AnonymousClass4.this, (Object) str3);
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                iPatchRedirector2.redirect((short) 2, (Object) this);
                            } else if (this.f306002d != null) {
                                AnonymousClass4 anonymousClass4 = AnonymousClass4.this;
                                UniformDownloadUtil.k(anonymousClass4.f306000a, anonymousClass4.f306001b);
                            } else {
                                AnonymousClass4 anonymousClass42 = AnonymousClass4.this;
                                UniformDownloadUtil.m(anonymousClass42.f306000a, anonymousClass42.f306001b);
                            }
                        }
                    });
                }
            }
        });
    }

    public static void m(String str, String str2) {
        String str3;
        QLog.i("UniformDownloadUtil", 1, "[UniformDL] >>>openFileWithOtherApp. localPath:" + str);
        if (str != null && q.p(str)) {
            BaseApplication context = BaseApplication.getContext();
            if (str.endsWith(".apk")) {
                str3 = AppSetting.e();
            } else {
                str3 = "";
            }
            Intent intent = new Intent();
            intent.addFlags(268435456);
            intent.setAction(CommonConstant.ACTION.HWID_SCHEME_URL);
            intent.putExtra("big_brother_source_key", str2);
            intent.setDataAndType(Uri.fromFile(new File(str)), str3);
            try {
                context.startActivity(intent);
                return;
            } catch (ActivityNotFoundException unused) {
                QLog.w("UniformDownloadUtil", 1, "[UniformDL] openFileWithOtherApp. no useful app. localPath:" + str);
                return;
            }
        }
        QLog.e("UniformDownloadUtil", 1, "[UniformDL] openFileWithOtherApp. file is not existed. localPath:" + str);
    }

    public static void n(String str, b bVar) {
        ah.b.a().execute(new Runnable(str, bVar) { // from class: com.tencent.mobileqq.uniformdownload.util.UniformDownloadUtil.2
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ String f305996d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ b f305997e;

            {
                this.f305996d = str;
                this.f305997e = bVar;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, (Object) bVar);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                String c16 = UniformDownloadUtil.c(this.f305996d);
                b bVar2 = this.f305997e;
                if (bVar2 != null) {
                    bVar2.onResult(c16);
                }
            }
        });
    }
}
