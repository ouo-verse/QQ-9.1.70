package com.tencent.mobileqq.webview.webso;

import android.content.SharedPreferences;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.common.config.AppSetting;
import com.tencent.commonsdk.pool.ByteArrayPool;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.studymode.api.IStudyModeManager;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.vas.VasConstant;
import com.tencent.mobileqq.vas.VipMMKV;
import com.tencent.mobileqq.vas.util.VasUtil;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.open.base.MD5Utils;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import common.config.service.QzoneConfig;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.MobileQQ;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes20.dex */
public class e {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static final String f315029a;

    /* renamed from: b, reason: collision with root package name */
    public static String f315030b;

    /* renamed from: c, reason: collision with root package name */
    public static AtomicBoolean f315031c;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(48295);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        f315029a = VFSAssistantUtils.getSDKPrivatePath(s() + "tencent/MobileQQ/webso/offline/");
        f315030b = null;
        f315031c = null;
    }

    public static String A(String str) {
        try {
            JSONObject jSONObject = new JSONObject(QzoneConfig.getInstance().getConfig("QzUrlCache", QzoneConfig.SECONDARY_WEBSO_COMMAND, QzoneConfig.WEBSO_DEFAULT_COMMAND_SETTING));
            Iterator keys = jSONObject.keys();
            String host = Uri.parse(str).getHost();
            while (keys.hasNext()) {
                String obj = keys.next().toString();
                if (host.equals(obj) || (obj.startsWith(".") && host.endsWith(obj))) {
                    JSONObject jSONObject2 = (JSONObject) jSONObject.get(obj);
                    String optString = jSONObject2.optString("command");
                    String optString2 = jSONObject2.optString(BaseConstants.CMD_MSFCOMMAND);
                    if (TextUtils.isEmpty(optString)) {
                        return optString2;
                    }
                    return optString;
                }
            }
            return null;
        } catch (Exception e16) {
            QLog.e("WebSoUtils", 1, "getWnsCommand error:", e16);
            return null;
        }
    }

    public static void B(Uri uri) {
        if (uri == null) {
            return;
        }
        f(uri);
        SharedPreferences.Editor edit = t().edit();
        edit.putLong("webso_" + String.valueOf(k()) + x(uri) + "_503", System.currentTimeMillis());
        edit.apply();
    }

    public static boolean C(String str) {
        try {
            String queryParameter = Uri.parse(str).getQueryParameter("_updateProxy");
            if (TextUtils.isEmpty(queryParameter)) {
                return false;
            }
            if ("0".equals(queryParameter)) {
                return false;
            }
            return true;
        } catch (Exception e16) {
            e16.printStackTrace();
            return false;
        }
    }

    public static boolean D(Uri uri) {
        if (uri == null) {
            return false;
        }
        try {
            String queryParameter = uri.getQueryParameter("_proxy");
            if (!"1".equals(queryParameter) && !"true".equals(queryParameter)) {
                return false;
            }
            if (TextUtils.isEmpty(A(uri.toString()))) {
                return false;
            }
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean E(String str) {
        try {
            return D(Uri.parse(str));
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean F(String str) {
        try {
            String config = QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_QZONECOVER, QzoneConfig.SECONDARY_DYNAMIC_COVER_PREVIEW_URL, QzoneConfig.SECONDARY_DYNAMIC_COVER_PREVIEW_DEFAULT);
            String config2 = QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_QZONECOVER, QzoneConfig.SECONDARY_DYNAMIC_COVER_PREVIEW_URL_KEYWORD, QzoneConfig.SECONDARY_DYNAMIC_COVER_PREVIEW_URL_KEYWORD_DEFAULT);
            if (str == null || !str.contains(config)) {
                return false;
            }
            if (!str.contains(config2)) {
                return false;
            }
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean G(String str) {
        if (TextUtils.isEmpty(str) || !C(str)) {
            return false;
        }
        Uri parse = Uri.parse(str);
        long j3 = t().getLong("webso_" + String.valueOf(k()) + x(parse) + "_503", -1L);
        if (j3 == -1 || System.currentTimeMillis() - j3 >= 43200000) {
            return false;
        }
        if (QLog.isColorLevel()) {
            QLog.e("WebSoUtils", 2, "now hit webso time, so return true");
            return true;
        }
        return true;
    }

    public static String H(String str) {
        h("removeTag");
        return str.replaceFirst("<script>.*_WebSoLocalTime.*_WebSoNetTime.*;</script>", "");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.io.File] */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v14 */
    /* JADX WARN: Type inference failed for: r1v16 */
    /* JADX WARN: Type inference failed for: r1v18 */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v7, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARN: Type inference failed for: r1v9, types: [java.io.OutputStream] */
    public static boolean I(byte[] bArr, String str) {
        ByteArrayInputStream byteArrayInputStream;
        BufferedOutputStream bufferedOutputStream;
        h("saveHtmlData");
        if (bArr == null || TextUtils.isEmpty(str)) {
            return false;
        }
        ?? file = new File(str);
        byte[] bArr2 = null;
        try {
            try {
                try {
                    if (file.exists()) {
                        file.delete();
                    }
                    file.createNewFile();
                    byteArrayInputStream = new ByteArrayInputStream(bArr, 0, bArr.length);
                    try {
                        bufferedOutputStream = new BufferedOutputStream(new FileOutputStream((File) file), 4096);
                    } catch (IOException e16) {
                        e = e16;
                        file = 0;
                    } catch (Exception e17) {
                        e = e17;
                        file = 0;
                    } catch (Throwable th5) {
                        th = th5;
                        file = 0;
                    }
                    try {
                        bArr2 = ByteArrayPool.getGenericInstance().getBuf(4096);
                        while (true) {
                            int read = byteArrayInputStream.read(bArr2);
                            if (read != -1) {
                                bufferedOutputStream.write(bArr2, 0, read);
                            } else {
                                bufferedOutputStream.flush();
                                ByteArrayPool.getGenericInstance().returnBuf(bArr2);
                                byteArrayInputStream.close();
                                bufferedOutputStream.close();
                                return true;
                            }
                        }
                    } catch (IOException e18) {
                        file = bufferedOutputStream;
                        e = e18;
                        e.printStackTrace();
                        ByteArrayPool.getGenericInstance().returnBuf(bArr2);
                        if (byteArrayInputStream != null) {
                            byteArrayInputStream.close();
                        }
                        if (file != 0) {
                            file.close();
                        }
                        return false;
                    } catch (Exception e19) {
                        file = bufferedOutputStream;
                        e = e19;
                        e.printStackTrace();
                        ByteArrayPool.getGenericInstance().returnBuf(bArr2);
                        if (byteArrayInputStream != null) {
                            byteArrayInputStream.close();
                        }
                        if (file != 0) {
                            file.close();
                        }
                        return false;
                    } catch (Throwable th6) {
                        file = bufferedOutputStream;
                        th = th6;
                        try {
                            ByteArrayPool.getGenericInstance().returnBuf(bArr2);
                            if (byteArrayInputStream != null) {
                                byteArrayInputStream.close();
                            }
                            if (file != 0) {
                                file.close();
                            }
                        } catch (Exception e26) {
                            e26.printStackTrace();
                        }
                        throw th;
                    }
                } catch (IOException e27) {
                    e = e27;
                    file = 0;
                    byteArrayInputStream = null;
                } catch (Exception e28) {
                    e = e28;
                    file = 0;
                    byteArrayInputStream = null;
                } catch (Throwable th7) {
                    th = th7;
                    file = 0;
                    byteArrayInputStream = null;
                }
            } catch (Exception e29) {
                e29.printStackTrace();
                return false;
            }
        } catch (Throwable th8) {
            th = th8;
        }
    }

    public static String a(String str, String str2) {
        String valueOf = String.valueOf(System.currentTimeMillis());
        WebSoService.j().b(str, valueOf);
        return c(str2, valueOf, null);
    }

    public static String b(String str, String str2) {
        String c16 = c(str2, WebSoService.j().k(str), String.valueOf(System.currentTimeMillis()));
        WebSoService.j().B(str);
        return c16;
    }

    public static String c(String str, String str2, String str3) {
        h("addTag");
        StringBuilder sb5 = new StringBuilder(str);
        if (!TextUtils.isEmpty(str)) {
            try {
                sb5.append("<script> var _WebSoLocalTime=" + str2 + ";</script>");
                sb5.append("<script> var _WebSoNetTime=" + str3 + ";</script>");
                QLog.i("WebSoService", 1, "add _WebSoLocalTime=" + str2 + ", add _WebSoNetTime=" + str3);
                return sb5.toString();
            } catch (Exception e16) {
                e16.printStackTrace();
                return "";
            } catch (OutOfMemoryError e17) {
                e17.printStackTrace();
                return "";
            }
        }
        return str;
    }

    public static boolean d(String str) {
        File file;
        try {
            try {
                file = new File(l(Uri.parse(str)));
            } catch (Throwable th5) {
                if (QLog.isColorLevel()) {
                    QLog.d("WebSoUtils", 2, "getHtmlData", th5);
                }
                file = null;
            }
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.w("WebSoUtils", 2, "getHtmlData", e16);
            }
        }
        if (file == null || !file.exists() || !file.canRead()) {
            return false;
        }
        if (file.length() <= 0) {
            return false;
        }
        return true;
    }

    public static void e() {
        try {
            FileUtils.deleteFilesInDirectory(u());
        } catch (Exception e16) {
            QLog.e("WebSoUtils", 1, e16, new Object[0]);
        }
    }

    public static void f(Uri uri) {
        if (uri == null) {
            return;
        }
        i(l(uri));
        i(v(uri));
        SharedPreferences.Editor edit = t().edit();
        String valueOf = String.valueOf(k());
        String x16 = x(uri);
        edit.remove("eTag_" + valueOf + x16);
        edit.remove("templateTag_" + valueOf + x16);
        edit.remove("htmlSha1_" + valueOf + x16);
        edit.apply();
    }

    public static String g(InputStream inputStream) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        StringBuilder sb5 = new StringBuilder();
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine != null) {
                sb5.append(readLine);
            } else {
                bufferedReader.close();
                return sb5.toString();
            }
        }
    }

    public static void h(String str) {
        if (QLog.isColorLevel()) {
            QLog.i("WebSo", 1, str);
        }
    }

    private static boolean i(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return FileUtils.deleteFile(str);
    }

    private static boolean j(Uri uri) {
        String queryParameter;
        if (uri != null) {
            try {
                queryParameter = uri.getQueryParameter("_proxyByURL");
            } catch (Exception unused) {
                return false;
            }
        } else {
            queryParameter = null;
        }
        if (queryParameter == null) {
            return false;
        }
        if (!"1".equals(queryParameter)) {
            if (!"true".equals(queryParameter)) {
                return false;
            }
        }
        return true;
    }

    public static long k() {
        return MobileQQ.sMobileQQ.waitAppRuntime(null).getLongAccountUin();
    }

    public static String l(Uri uri) {
        String m3 = m(uri);
        if (TextUtils.isEmpty(m3)) {
            return "";
        }
        return m3 + ".txt";
    }

    public static String m(Uri uri) {
        String str;
        if (uri == null) {
            return "";
        }
        String u16 = u();
        if (j(uri)) {
            str = uri.toString();
        } else {
            str = uri.getAuthority() + uri.getPath();
        }
        String str2 = str + String.valueOf(k());
        try {
            str2 = MD5Utils.toMD5(str2);
        } catch (Throwable th5) {
            if (QLog.isColorLevel()) {
                QLog.d("WebSoUtils", 2, "getFileBasePath..uri", th5);
            }
        }
        return u16 + str2;
    }

    public static String n(String str) {
        File file;
        h("getHtmlData");
        try {
            file = new File(l(Uri.parse(str)));
        } catch (Throwable th5) {
            if (QLog.isColorLevel()) {
                QLog.d("WebSoUtils", 2, "getHtmlData", th5);
            }
            file = null;
        }
        if (file != null && file.exists()) {
            try {
                return FileUtils.readFileToString(file);
            } catch (Throwable th6) {
                th6.printStackTrace();
            }
        }
        return null;
    }

    public static String o(String str) {
        String n3 = n(str);
        if (TextUtils.isEmpty(n3)) {
            return "";
        }
        SharedPreferences t16 = t();
        String y16 = y(str);
        String string = t16.getString("htmlSha1_" + String.valueOf(k()) + y16, "");
        try {
            String b16 = b.b(n3);
            if (b16.equals(string)) {
                h("getHtmlDataAndCheck success");
                return n3;
            }
            h("\u6821\u9a8c\u7f13\u5b58etag \u4e0d\u4e00\u81f4\uff0chtml-sha1 check fail. http rsp etag=" + string + ",cache_sha1=" + b16);
            try {
                f(Uri.parse(str));
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.d("WebSoUtils", 2, "clean web so data exception=" + e16.getMessage());
                }
                e16.printStackTrace();
            }
            return "";
        } catch (OutOfMemoryError e17) {
            QLog.e("WebSoUtils", 1, e17, new Object[0]);
            return "";
        }
    }

    public static String p(String str) {
        try {
            JSONObject jSONObject = new JSONObject(QzoneConfig.getInstance().getConfig("QzUrlCache", QzoneConfig.SECONDARY_WEBSO_COMMAND, QzoneConfig.WEBSO_DEFAULT_COMMAND_SETTING));
            Iterator keys = jSONObject.keys();
            String host = Uri.parse(str).getHost();
            while (keys.hasNext()) {
                String obj = keys.next().toString();
                if (host.equals(obj) || (obj.startsWith(".") && host.endsWith(obj))) {
                    JSONObject jSONObject2 = (JSONObject) jSONObject.get(obj);
                    String optString = jSONObject2.optString("command");
                    String optString2 = jSONObject2.optString(BaseConstants.CMD_MSFCOMMAND);
                    if (!TextUtils.isEmpty(optString2)) {
                        return optString2;
                    }
                    return optString;
                }
            }
            return null;
        } catch (Exception e16) {
            e16.printStackTrace();
            return null;
        }
    }

    public static String q(String str) {
        if (TextUtils.isEmpty(str)) {
            QLog.w("WebSoRequest", 1, "cmd is EMPTY OR NULL !!!");
            return null;
        }
        String[] split = str.split("\\.");
        if (split == null || split.length <= 0) {
            return null;
        }
        return split[split.length - 1];
    }

    public static String r(String str) {
        if (str == null) {
            return "error";
        }
        return u() + y(str) + ".screenshot";
    }

    private static String s() {
        try {
            return AppConstants.SDCARD_PATH;
        } catch (Throwable unused) {
            return "";
        }
    }

    public static SharedPreferences t() {
        return VipMMKV.INSTANCE.getWebSo(BaseApplication.getContext());
    }

    private static String u() {
        File file = new File(VasConstant.WEBSO_DATA_PATH);
        if (!file.exists()) {
            file.mkdirs();
        }
        String absolutePath = file.getAbsolutePath();
        String str = File.separator;
        if (!absolutePath.endsWith(str)) {
            return absolutePath + str;
        }
        return absolutePath;
    }

    public static String v(Uri uri) {
        String m3 = m(uri);
        if (TextUtils.isEmpty(m3)) {
            return "";
        }
        return m3 + "_template.txt";
    }

    public static String w() {
        String str;
        boolean z16;
        String str2 = "Android Qzone/" + VasUtil.getTempApi().websoGetQUA();
        int netWorkType = HttpUtil.getNetWorkType();
        if (netWorkType != -1) {
            if (netWorkType != 1) {
                if (netWorkType != 2) {
                    if (netWorkType != 3) {
                        if (netWorkType != 4) {
                            str = "";
                        } else {
                            str = " NetType/4G";
                        }
                    } else {
                        str = " NetType/3G";
                    }
                } else {
                    str = " NetType/2G";
                }
            } else {
                str = " NetType/WIFI";
            }
        } else {
            str = " NetType/UNKNOWN";
        }
        int statusBarHeight = ImmersiveUtils.getStatusBarHeight(BaseApplication.getContext());
        StringBuilder sb5 = new StringBuilder(str2);
        sb5.append(" ");
        sb5.append("QQ/");
        sb5.append(AppSetting.f99551k);
        sb5.append(".");
        sb5.append(AppSetting.f99542b);
        sb5.append(str);
        sb5.append(" Pixel/");
        sb5.append(z());
        sb5.append(" StatusBarHeight/" + statusBarHeight);
        sb5.append(" QQTheme/" + QQTheme.getCurrentThemeId());
        try {
            z16 = ((IStudyModeManager) QRoute.api(IStudyModeManager.class)).getStudyModeSwitch();
        } catch (Exception unused) {
            z16 = false;
        }
        if (z16) {
            sb5.append("StudyMode/1");
        }
        return sb5.toString();
    }

    public static String x(Uri uri) {
        String str;
        try {
            if (j(uri)) {
                str = uri.toString();
            } else {
                str = uri.getAuthority() + uri.getPath();
            }
            return MD5Utils.toMD5(str);
        } catch (Throwable th5) {
            if (QLog.isColorLevel()) {
                QLog.d("WebSoUtils", 2, "getUrlKey..uri", th5);
            }
            return uri.toString();
        }
    }

    public static String y(String str) {
        try {
            return x(Uri.parse(str));
        } catch (Throwable th5) {
            if (QLog.isColorLevel()) {
                QLog.d("WebSoUtils", 2, "getUrlKey..url", th5);
            }
            return str;
        }
    }

    private static int z() {
        try {
            return BaseApplication.getContext().getResources().getDisplayMetrics().widthPixels;
        } catch (Throwable unused) {
            return 0;
        }
    }
}
