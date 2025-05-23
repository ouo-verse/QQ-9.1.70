package com.tencent.smtt.sdk.stat;

import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.Point;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.qq.e.comm.constants.TangramHippyConstants;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import com.tencent.smtt.sdk.TbsConfig;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.utils.FileProvider;
import cooperation.qzone.webviewplugin.QzoneWebViewOfflinePlugin;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import org.jf.dexlib2.analysis.RegisterType;

/* compiled from: P */
/* loaded from: classes23.dex */
public class MttLoader {
    public static final String CHANNEL_ID = "ChannelID";
    public static final String ENTRY_ID = "entryId";

    @Deprecated
    public static final String KEY_ACTIVITY_NAME = "KEY_ACT";

    @Deprecated
    public static final String KEY_APP_NAME = "KEY_APPNAME";
    public static final String KEY_EUSESTAT = "KEY_EUSESTAT";

    @Deprecated
    public static final String KEY_PACKAGE = "KEY_PKG";
    public static final String KEY_PID = "KEY_PID";
    public static final String MTT_ACTION = "com.tencent.QQBrowser.action.VIEW";
    public static final String MTT_ACTION_SP = "com.tencent.QQBrowser.action.VIEWSP";
    public static final String PID_ARTICLE_NEWS = "21272";
    public static final String PID_MOBILE_QQ = "50079";
    public static final String PID_QQPIM = "50190";
    public static final String PID_QZONE = "10494";
    public static final String PID_WECHAT = "10318";
    public static final String POS_ID = "PosID";
    public static final String QQBROWSER_DIRECT_DOWNLOAD_URL = "https://mdc.html5.qq.com/d/directdown.jsp?channel_id=50079";
    public static final String QQBROWSER_DOWNLOAD_URL = "https://mdc.html5.qq.com/mh?channel_id=50079&u=";
    public static final String QQBROWSER_PARAMS_FROME = ",from=";
    public static final String QQBROWSER_PARAMS_PACKAGENAME = ",packagename=";
    public static final String QQBROWSER_PARAMS_PD = ",product=";
    public static final String QQBROWSER_PARAMS_VERSION = ",version=";
    public static final String QQBROWSER_SCHEME = "mttbrowser://url=";
    public static final int RESULT_INVALID_CONTEXT = 3;
    public static final int RESULT_INVALID_URL = 2;
    public static final int RESULT_NOT_INSTALL_QQBROWSER = 4;
    public static final int RESULT_OK = 0;
    public static final int RESULT_QQBROWSER_LOW = 5;
    public static final int RESULT_UNKNOWN = 1;
    public static final String STAT_KEY = "StatKey";

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public static class BrowserInfo {
        public int browserType = -1;
        public int ver = -1;
        public String quahead = "";

        /* renamed from: vn, reason: collision with root package name */
        public String f369498vn = "0";
        public String packageName = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes23.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public String f369499a;

        /* renamed from: b, reason: collision with root package name */
        public String f369500b;

        a() {
            this.f369499a = "";
            this.f369500b = "";
        }
    }

    private static Uri a(Context context, String str) {
        return FileProvider.a(context, str);
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x00c6 A[Catch: Exception -> 0x00eb, TRY_ENTER, TRY_LEAVE, TryCatch #3 {Exception -> 0x00eb, blocks: (B:6:0x0030, B:9:0x0036, B:11:0x0042, B:13:0x0049, B:17:0x006d, B:19:0x007b, B:24:0x008a, B:21:0x00c6), top: B:5:0x0030 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static BrowserInfo getBrowserInfo(Context context) {
        PackageManager packageManager;
        PackageInfo packageInfo;
        int i3;
        boolean z16 = context.getApplicationContext().getSharedPreferences("x5_proxy_setting", 0).getBoolean("qb_install_status", false);
        BrowserInfo browserInfo = new BrowserInfo();
        if (z16) {
            return browserInfo;
        }
        try {
            packageManager = context.getPackageManager();
            packageInfo = null;
            try {
                packageInfo = InstalledAppListMonitor.getPackageInfo(packageManager, TbsConfig.APP_QB, 0);
                browserInfo.browserType = 2;
                browserInfo.packageName = TbsConfig.APP_QB;
                browserInfo.quahead = "ADRQB_";
                if (packageInfo != null && (i3 = packageInfo.versionCode) > 420000) {
                    browserInfo.ver = i3;
                    browserInfo.quahead += packageInfo.versionName.replaceAll("\\.", "");
                    browserInfo.f369498vn = packageInfo.versionName.replaceAll("\\.", "");
                    return browserInfo;
                }
            } catch (PackageManager.NameNotFoundException unused) {
            }
        } catch (Exception unused2) {
        }
        try {
            try {
                try {
                    try {
                        try {
                            InstalledAppListMonitor.getPackageInfo(packageManager, "com.tencent.qbx", 0);
                            browserInfo.browserType = 0;
                            browserInfo.packageName = "com.tencent.qbx";
                            browserInfo.quahead = "ADRQBX_";
                        } catch (PackageManager.NameNotFoundException unused3) {
                            packageInfo = InstalledAppListMonitor.getPackageInfo(packageManager, "com.tencent.qbx5", 0);
                            browserInfo.browserType = 1;
                            browserInfo.packageName = "com.tencent.qbx5";
                            browserInfo.quahead = "ADRQBX5_";
                            if (packageInfo != null) {
                            }
                            return browserInfo;
                        }
                    } catch (Exception unused4) {
                        if (packageInfo != null) {
                        }
                        return browserInfo;
                    }
                } catch (PackageManager.NameNotFoundException unused5) {
                    packageInfo = InstalledAppListMonitor.getPackageInfo(packageManager, "com.tencent.mtt.x86", 0);
                    browserInfo.packageName = "com.tencent.mtt.x86";
                    browserInfo.browserType = 2;
                    browserInfo.quahead = "ADRQB_";
                    if (packageInfo != null) {
                    }
                    return browserInfo;
                }
            } catch (PackageManager.NameNotFoundException unused6) {
                packageInfo = InstalledAppListMonitor.getPackageInfo(packageManager, TbsConfig.APP_QB, 0);
                browserInfo.packageName = TbsConfig.APP_QB;
                browserInfo.browserType = 2;
                browserInfo.quahead = "ADRQB_";
                if (packageInfo != null) {
                }
                return browserInfo;
            }
        } catch (Exception unused7) {
            a a16 = a(context, Uri.parse(QQBROWSER_DOWNLOAD_URL));
            if (a16 != null && !TextUtils.isEmpty(a16.f369500b)) {
                PackageInfo packageInfo2 = InstalledAppListMonitor.getPackageInfo(packageManager, a16.f369500b, 0);
                try {
                    browserInfo.packageName = a16.f369500b;
                    browserInfo.browserType = 2;
                    browserInfo.quahead = "ADRQB_";
                } catch (Exception unused8) {
                }
                packageInfo = packageInfo2;
            }
            if (packageInfo != null) {
                browserInfo.ver = packageInfo.versionCode;
                browserInfo.quahead += packageInfo.versionName.replaceAll("\\.", "");
                browserInfo.f369498vn = packageInfo.versionName.replaceAll("\\.", "");
            }
            return browserInfo;
        }
    }

    public static String getDownloadUrlWithQb(String str) {
        try {
            return QQBROWSER_DOWNLOAD_URL + URLEncoder.encode(str, "UTF-8");
        } catch (UnsupportedEncodingException e16) {
            e16.printStackTrace();
            return QQBROWSER_DOWNLOAD_URL;
        }
    }

    public static String getValidQBUrl(Context context, String str) {
        if (str.toLowerCase().startsWith("qb://")) {
            BrowserInfo browserInfo = getBrowserInfo(context);
            int i3 = browserInfo.browserType;
            boolean z16 = true;
            if (i3 != -1 && (i3 != 2 || browserInfo.ver >= 33)) {
                z16 = false;
            }
            if (z16) {
                return getDownloadUrlWithQb(str);
            }
        }
        return str;
    }

    public static boolean isBrowserInstalled(Context context) {
        if (getBrowserInfo(context).browserType == -1) {
            return false;
        }
        return true;
    }

    public static boolean isBrowserInstalledEx(Context context) {
        BrowserInfo browserInfo = getBrowserInfo(context);
        boolean z16 = false;
        try {
            if (Long.valueOf(browserInfo.f369498vn).longValue() >= 6001500) {
                z16 = true;
            }
        } catch (NumberFormatException e16) {
            e16.printStackTrace();
        }
        if (browserInfo.ver >= 601500) {
            return true;
        }
        return z16;
    }

    public static boolean isGreatBrowserVer(Context context, long j3, long j16) {
        boolean z16 = false;
        try {
            if (Long.valueOf(getBrowserInfo(context).f369498vn).longValue() >= j3) {
                z16 = true;
            }
        } catch (NumberFormatException e16) {
            e16.printStackTrace();
        }
        if (r4.ver >= j16) {
            return true;
        }
        return z16;
    }

    public static boolean isSupportQBScheme(Context context) {
        BrowserInfo browserInfo = getBrowserInfo(context);
        int i3 = browserInfo.browserType;
        if (i3 == -1) {
            return false;
        }
        if (i3 == 2 && browserInfo.ver < 42) {
            return false;
        }
        return true;
    }

    public static boolean isSupportingTbsTips(Context context) {
        BrowserInfo browserInfo = getBrowserInfo(context);
        if (browserInfo.browserType == 2 && browserInfo.ver >= 580000) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(12:1|2|3|(3:7|8|(8:10|11|12|(1:14)|15|(1:17)(1:21)|18|19))|25|11|12|(0)|15|(0)(0)|18|19) */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0028  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0030  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int loadUrl(Context context, String str, HashMap<String, String> hashMap, String str2, WebView webView) {
        boolean z16;
        PackageManager packageManager;
        PackageInfo packageInfo;
        StringBuilder sb5 = new StringBuilder();
        boolean z17 = false;
        try {
            packageManager = context.getPackageManager();
        } catch (Throwable unused) {
        }
        if (packageManager != null && (packageInfo = InstalledAppListMonitor.getPackageInfo(packageManager, TbsConfig.APP_QB, 0)) != null) {
            if (packageInfo.versionCode > 601000) {
                z16 = true;
                String encode = URLEncoder.encode(str, "UTF-8");
                if (z16) {
                    str = encode;
                }
                z17 = z16;
                String str3 = !z17 ? ",encoded=1" : "";
                sb5.append(QQBROWSER_SCHEME);
                sb5.append(str);
                sb5.append(QQBROWSER_PARAMS_PD);
                sb5.append("TBS");
                sb5.append(QQBROWSER_PARAMS_PACKAGENAME);
                sb5.append(context.getPackageName());
                sb5.append(QQBROWSER_PARAMS_FROME);
                sb5.append(str2);
                sb5.append(QQBROWSER_PARAMS_VERSION);
                sb5.append(TbsConfig.TBS_SDK_VERSIONNAME);
                sb5.append(str3);
                return loadUrl(context, sb5.toString(), hashMap, webView);
            }
        }
        z16 = false;
        String encode2 = URLEncoder.encode(str, "UTF-8");
        if (z16) {
        }
        z17 = z16;
        if (!z17) {
        }
        sb5.append(QQBROWSER_SCHEME);
        sb5.append(str);
        sb5.append(QQBROWSER_PARAMS_PD);
        sb5.append("TBS");
        sb5.append(QQBROWSER_PARAMS_PACKAGENAME);
        sb5.append(context.getPackageName());
        sb5.append(QQBROWSER_PARAMS_FROME);
        sb5.append(str2);
        sb5.append(QQBROWSER_PARAMS_VERSION);
        sb5.append(TbsConfig.TBS_SDK_VERSIONNAME);
        sb5.append(str3);
        return loadUrl(context, sb5.toString(), hashMap, webView);
    }

    public static boolean openDocWithQb(Context context, String str, int i3, String str2, HashMap<String, String> hashMap) {
        return openDocWithQb(context, str, i3, str2, hashMap, null);
    }

    public static boolean openVideoWithQb(Context context, String str, HashMap<String, String> hashMap) {
        boolean z16;
        Set<String> keySet;
        Uri parse = Uri.parse(str);
        Intent intent = new Intent(CommonConstant.ACTION.HWID_SCHEME_URL);
        intent.setFlags(268435456);
        intent.setDataAndType(parse, "video/*");
        if (hashMap != null && (keySet = hashMap.keySet()) != null) {
            for (String str2 : keySet) {
                String str3 = hashMap.get(str2);
                if (!TextUtils.isEmpty(str3)) {
                    intent.putExtra(str2, str3);
                }
            }
        }
        try {
            intent.putExtra(TangramHippyConstants.LOGIN_TYPE, a(context));
            intent.setComponent(new ComponentName(TbsConfig.APP_QB, "com.tencent.mtt.browser.video.H5VideoThrdcallActivity"));
            context.startActivity(intent);
            z16 = true;
        } catch (Throwable unused) {
            z16 = false;
        }
        if (!z16) {
            try {
                intent.setComponent(null);
                context.startActivity(intent);
            } catch (Throwable th5) {
                th5.printStackTrace();
                return false;
            }
        }
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:57:0x005b, code lost:
    
        if (r2 == null) goto L34;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean verifySignature(File file) {
        JarFile jarFile;
        JarEntry jarEntry;
        InputStream inputStream = null;
        try {
            jarFile = new JarFile(file);
            try {
                jarEntry = jarFile.getJarEntry("AndroidManifest.xml");
            } catch (Throwable unused) {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException unused2) {
                    }
                }
            }
        } catch (Throwable unused3) {
            jarFile = null;
        }
        if (jarEntry == null) {
            try {
                jarFile.close();
            } catch (IOException unused4) {
            }
            return false;
        }
        byte[] bArr = new byte[8192];
        inputStream = jarFile.getInputStream(jarEntry);
        do {
        } while (inputStream.read(bArr, 0, 8192) != -1);
        inputStream.close();
        Certificate[] certificates = jarEntry.getCertificates();
        if (certificates.length < 1) {
            try {
                inputStream.close();
            } catch (IOException unused5) {
            }
            try {
                jarFile.close();
            } catch (IOException unused6) {
            }
            return false;
        }
        String a16 = a(certificates[0]);
        if (a16 != null) {
            if (a16.equals("3082023f308201a8a00302010202044c46914a300d06092a864886f70d01010505003064310b30090603550406130238363110300e060355040813074265696a696e673110300e060355040713074265696a696e673110300e060355040a130754656e63656e74310c300a060355040b13035753443111300f0603550403130873616d75656c6d6f301e170d3130303732313036313835305a170d3430303731333036313835305a3064310b30090603550406130238363110300e060355040813074265696a696e673110300e060355040713074265696a696e673110300e060355040a130754656e63656e74310c300a060355040b13035753443111300f0603550403130873616d75656c6d6f30819f300d06092a864886f70d010101050003818d0030818902818100c209077044bd0d63ea00ede5b839914cabcc912a87f0f8b390877e0f7a2583f0d5933443c40431c35a4433bc4c965800141961adc44c9625b1d321385221fd097e5bdc2f44a1840d643ab59dc070cf6c4b4b4d98bed5cbb8046e0a7078ae134da107cdf2bfc9b440fe5cb2f7549b44b73202cc6f7c2c55b8cfb0d333a021f01f0203010001300d06092a864886f70d010105050003818100b007db9922774ef4ccfee81ba514a8d57c410257e7a2eba64bfa17c9e690da08106d32f637ac41fbc9f205176c71bde238c872c3ee2f8313502bee44c80288ea4ef377a6f2cdfe4d3653c145c4acfedbfbadea23b559d41980cc3cdd35d79a68240693739aabf5c5ed26148756cf88264226de394c8a24ac35b712b120d4d23a")) {
                try {
                    inputStream.close();
                } catch (IOException unused7) {
                }
                try {
                    jarFile.close();
                } catch (IOException unused8) {
                }
                return true;
            }
        }
        try {
            inputStream.close();
        } catch (IOException unused9) {
        }
        try {
            jarFile.close();
        } catch (IOException unused10) {
            return false;
        }
    }

    private static int a(Context context) {
        String str = context.getApplicationInfo().processName;
        if (str.equals("com.tencent.mobileqq")) {
            return 13;
        }
        if (str.equals("com.qzone")) {
            return 14;
        }
        if (str.equals("com.tencent.WBlog")) {
            return 15;
        }
        return str.equals("com.tencent.mm") ? 24 : 26;
    }

    public static boolean openDocWithQb(Context context, String str, int i3, String str2, HashMap<String, String> hashMap, Bundle bundle) {
        return openDocWithQb(context, str, i3, str2, "", hashMap, null);
    }

    public static boolean openDocWithQb(Context context, String str, int i3, String str2, String str3, HashMap<String, String> hashMap, Bundle bundle) {
        Set<String> keySet;
        try {
            Intent intent = new Intent("com.tencent.QQBrowser.action.sdk.document");
            if (hashMap != null && (keySet = hashMap.keySet()) != null) {
                for (String str4 : keySet) {
                    String str5 = hashMap.get(str4);
                    if (!TextUtils.isEmpty(str5)) {
                        intent.putExtra(str4, str5);
                    }
                }
            }
            new File(str);
            intent.putExtra("key_reader_sdk_id", 3);
            intent.putExtra("key_reader_sdk_type", i3);
            if (!TextUtils.isEmpty(str3)) {
                intent.putExtra("big_brother_source_key", str3);
            }
            if (i3 == 0) {
                intent.putExtra("key_reader_sdk_path", str);
            } else if (i3 == 1) {
                intent.putExtra("key_reader_sdk_url", str);
            }
            intent.putExtra("key_reader_sdk_format", str2);
            if (context != null && context.getApplicationInfo().targetSdkVersion >= 24 && Build.VERSION.SDK_INT >= 24) {
                intent.addFlags(1);
            }
            intent.addFlags(268435456);
            Uri a16 = a(context, str);
            if (a16 == null) {
                return false;
            }
            intent.setDataAndType(a16, "mtt/" + str2);
            intent.putExtra(TangramHippyConstants.LOGIN_TYPE, a(context.getApplicationContext()));
            if (bundle != null) {
                intent.putExtra("key_reader_sdk_extrals", bundle);
            }
            context.startActivity(intent);
            return true;
        } catch (Exception e16) {
            e16.printStackTrace();
            return false;
        }
    }

    private static a a(Context context, Uri uri) {
        Intent intent = new Intent(MTT_ACTION);
        intent.setData(uri);
        List<ResolveInfo> queryIntentActivities = InstalledAppListMonitor.queryIntentActivities(context.getPackageManager(), intent, 0);
        if (queryIntentActivities.size() <= 0) {
            return null;
        }
        a aVar = new a();
        for (ResolveInfo resolveInfo : queryIntentActivities) {
            String str = resolveInfo.activityInfo.packageName;
            if (str.contains(TbsConfig.APP_QB)) {
                ActivityInfo activityInfo = resolveInfo.activityInfo;
                aVar.f369499a = activityInfo.name;
                aVar.f369500b = activityInfo.packageName;
                return aVar;
            }
            if (str.contains("com.tencent.qbx")) {
                ActivityInfo activityInfo2 = resolveInfo.activityInfo;
                aVar.f369499a = activityInfo2.name;
                aVar.f369500b = activityInfo2.packageName;
            }
        }
        return aVar;
    }

    public static int loadUrl(Context context, String str, HashMap<String, String> hashMap, WebView webView) {
        Set<String> keySet;
        if (context == null) {
            return 3;
        }
        if (!a(str)) {
            str = "http://" + str;
        }
        try {
            Uri parse = Uri.parse(str);
            if (parse == null) {
                return 2;
            }
            BrowserInfo browserInfo = getBrowserInfo(context);
            int i3 = browserInfo.browserType;
            if (i3 == -1) {
                return 4;
            }
            if (i3 == 2 && browserInfo.ver < 33) {
                return 5;
            }
            Intent intent = new Intent(CommonConstant.ACTION.HWID_SCHEME_URL);
            int i16 = browserInfo.browserType;
            if (i16 == 2) {
                int i17 = browserInfo.ver;
                if (i17 >= 33 && i17 <= 39) {
                    intent.setClassName(TbsConfig.APP_QB, "com.tencent.mtt.MainActivity");
                } else if (i17 >= 40 && i17 <= 45) {
                    intent.setClassName(TbsConfig.APP_QB, "com.tencent.mtt.SplashActivity");
                } else if (i17 >= 46) {
                    intent = new Intent(MTT_ACTION);
                    a a16 = a(context, parse);
                    if (a16 != null && !TextUtils.isEmpty(a16.f369499a)) {
                        intent.setClassName(a16.f369500b, a16.f369499a);
                    }
                }
            } else if (i16 == 1) {
                int i18 = browserInfo.ver;
                if (i18 == 1) {
                    intent.setClassName("com.tencent.qbx5", "com.tencent.qbx5.MainActivity");
                } else if (i18 == 2) {
                    intent.setClassName("com.tencent.qbx5", "com.tencent.qbx5.SplashActivity");
                }
            } else if (i16 == 0) {
                int i19 = browserInfo.ver;
                if (i19 >= 4 && i19 <= 6) {
                    intent.setClassName("com.tencent.qbx", "com.tencent.qbx.SplashActivity");
                } else if (i19 > 6) {
                    intent = new Intent(MTT_ACTION);
                    a a17 = a(context, parse);
                    if (a17 != null && !TextUtils.isEmpty(a17.f369499a)) {
                        intent.setClassName(a17.f369500b, a17.f369499a);
                    }
                }
            } else {
                intent = new Intent(MTT_ACTION);
                a a18 = a(context, parse);
                if (a18 != null && !TextUtils.isEmpty(a18.f369499a)) {
                    intent.setClassName(a18.f369500b, a18.f369499a);
                }
            }
            intent.setData(parse);
            if (hashMap != null && (keySet = hashMap.keySet()) != null) {
                for (String str2 : keySet) {
                    String str3 = hashMap.get(str2);
                    if (!TextUtils.isEmpty(str3)) {
                        intent.putExtra(str2, str3);
                    }
                }
            }
            try {
                intent.putExtra(TangramHippyConstants.LOGIN_TYPE, a(context));
                intent.addFlags(268435456);
                if (webView != null) {
                    intent.putExtra("AnchorPoint", new Point(webView.getScrollX(), webView.getScrollY()));
                    intent.putExtra("ContentSize", new Point(webView.getContentWidth(), webView.getContentHeight()));
                }
                context.startActivity(intent);
                return 0;
            } catch (ActivityNotFoundException unused) {
                return 4;
            }
        } catch (Exception unused2) {
            return 2;
        }
    }

    private static boolean a(String str) {
        if (str == null || str.length() == 0) {
            return false;
        }
        String trim = str.trim();
        int indexOf = trim.toLowerCase().indexOf(QzoneWebViewOfflinePlugin.STR_DEVIDER);
        int indexOf2 = trim.toLowerCase().indexOf(46);
        if (indexOf <= 0 || indexOf2 <= 0 || indexOf <= indexOf2) {
            return trim.toLowerCase().contains(QzoneWebViewOfflinePlugin.STR_DEVIDER);
        }
        return false;
    }

    private static String a(Certificate certificate) throws CertificateEncodingException {
        byte[] encoded = certificate.getEncoded();
        int length = encoded.length;
        char[] cArr = new char[length * 2];
        for (int i3 = 0; i3 < length; i3++) {
            byte b16 = encoded[i3];
            int i16 = (b16 >> 4) & 15;
            int i17 = i3 * 2;
            cArr[i17] = (char) (i16 >= 10 ? (i16 + 97) - 10 : i16 + 48);
            int i18 = b16 & RegisterType.DOUBLE_HI;
            cArr[i17 + 1] = (char) (i18 >= 10 ? (i18 + 97) - 10 : i18 + 48);
        }
        return new String(cArr);
    }
}
