package com.tencent.mobileqq.teamwork;

import android.os.Build;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.teamwork.api.IGetExternalInterface;
import com.tencent.mobileqq.teamwork.api.ITeamWorkFacadeCreator;
import com.tencent.mobileqq.teamwork.api.ITeamWorkFileExportHandler;
import com.tencent.mobileqq.teamwork.api.ITeamWorkHandler;
import com.tencent.mobileqq.teamwork.bean.TeamWorkFileImportInfo;
import com.tencent.mobileqq.theme.ThemeConstants;
import com.tencent.mobileqq.util.cu;
import com.tencent.mobileqq.utils.httputils.HttpMsg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.CookieManager;
import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import com.tencent.thread.monitor.plugin.proxy.BaseTimer;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TimerTask;
import java.util.UUID;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import mqq.app.MobileQQ;
import org.apache.http.client.methods.HttpPut;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes18.dex */
public class TeamWorkHttpUtils {
    /* JADX WARN: Removed duplicated region for block: B:45:0x00ae A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final String A(String str) {
        FileInputStream fileInputStream;
        StringBuilder sb5;
        MessageDigest messageDigest;
        int i3;
        String str2;
        String str3 = null;
        str3 = null;
        str3 = null;
        str3 = null;
        FileInputStream fileInputStream2 = null;
        if (new File(str).exists()) {
            try {
                messageDigest = MessageDigest.getInstance(KeyPropertiesCompact.DIGEST_MD5);
                fileInputStream = new FileInputStream(str);
            } catch (Exception e16) {
                e = e16;
                fileInputStream = null;
            } catch (Throwable th5) {
                th = th5;
                if (fileInputStream2 != null) {
                }
                throw th;
            }
            try {
                try {
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int read = fileInputStream.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        messageDigest.update(bArr, 0, read);
                    }
                    fileInputStream.close();
                    StringBuilder sb6 = new StringBuilder();
                    for (byte b16 : messageDigest.digest()) {
                        int i16 = b16 & 255;
                        if (i16 < 16) {
                            str2 = "0";
                        } else {
                            str2 = "";
                        }
                        sb6.append(str2);
                        sb6.append(Integer.toHexString(i16).toLowerCase());
                    }
                    str3 = sb6.toString();
                    try {
                        fileInputStream.close();
                    } catch (Exception e17) {
                        e = e17;
                        sb5 = new StringBuilder();
                        sb5.append("fis close error:  ");
                        sb5.append(e.toString());
                        QLog.e("getFileMD5", 1, sb5.toString());
                        return str3;
                    }
                } catch (Throwable th6) {
                    th = th6;
                    fileInputStream2 = fileInputStream;
                    if (fileInputStream2 != null) {
                        try {
                            fileInputStream2.close();
                        } catch (Exception e18) {
                            QLog.e("getFileMD5", 1, "fis close error:  " + e18.toString());
                        }
                    }
                    throw th;
                }
            } catch (Exception e19) {
                e = e19;
                QLog.e("getFileMD5", 1, "getFileMD5 error:  " + e.toString());
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (Exception e26) {
                        e = e26;
                        sb5 = new StringBuilder();
                        sb5.append("fis close error:  ");
                        sb5.append(e.toString());
                        QLog.e("getFileMD5", 1, sb5.toString());
                        return str3;
                    }
                }
                return str3;
            }
        }
        return str3;
    }

    public static void A0(TeamWorkFileImportInfo teamWorkFileImportInfo, String str, IGetExternalInterface.d dVar) {
        if (teamWorkFileImportInfo != null && !TextUtils.isEmpty(teamWorkFileImportInfo.G) && !TextUtils.isEmpty(str)) {
            String replaceAll = UUID.randomUUID().toString().replaceAll("-", "");
            String str2 = teamWorkFileImportInfo.G;
            try {
                str2 = URLEncoder.encode(str2, "UTF-8");
            } catch (Throwable th5) {
                if (QLog.isColorLevel()) {
                    QLog.e("TeamWorkHttpUtils", 2, "url2Doc error", th5);
                }
            }
            StringBuilder sb5 = new StringBuilder("https://qqandroid.docs.qq.com/cgi-go/imp/import_url2doc");
            sb5.append("?xsrf=");
            sb5.append(replaceAll);
            if (!TextUtils.isEmpty(teamWorkFileImportInfo.S)) {
                sb5.append("&folderId=");
                sb5.append(teamWorkFileImportInfo.S);
            }
            sb5.append("&url=");
            sb5.append(str2);
            n0(str, sb5.toString(), ITeamWorkHandler.DOCS_DOMAIN, "TOK=" + replaceAll, true, dVar);
            return;
        }
        dVar.a("");
    }

    private static long B() {
        boolean e16 = cu.e();
        long b16 = cu.b();
        long c16 = cu.c();
        if (e16 && b16 != 0) {
            return b16 * 1024;
        }
        return c16 * 1024;
    }

    public static void C(final String str, final String str2, final IGetExternalInterface.d dVar) {
        if (MobileQQ.sMobileQQ.peekAppRuntime() == null) {
            dVar.a("");
        } else {
            ((IGetExternalInterface) QRoute.api(IGetExternalInterface.class)).getPsKey(str2, new IGetExternalInterface.c() { // from class: com.tencent.mobileqq.teamwork.au
                @Override // com.tencent.mobileqq.teamwork.api.IGetExternalInterface.c
                public final void a(String str3) {
                    TeamWorkHttpUtils.J(str, dVar, str2, str3);
                }
            });
        }
    }

    public static void D(String str, String str2, final IGetExternalInterface.d dVar) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            String replaceAll = UUID.randomUUID().toString().replaceAll("-", "");
            n0(str2, "https://qqandroid.docs.qq.com/cgi-go/discuss/get_unread_reddot?globalPadId=" + str + "&type=0&xsrf=" + replaceAll, ITeamWorkHandler.DOCS_DOMAIN, "TOK=" + replaceAll, true, new IGetExternalInterface.d() { // from class: com.tencent.mobileqq.teamwork.az
                @Override // com.tencent.mobileqq.teamwork.api.IGetExternalInterface.d
                public final void a(Object obj) {
                    TeamWorkHttpUtils.K(IGetExternalInterface.d.this, obj);
                }
            });
            return;
        }
        dVar.a("");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void E(Map map, HttpsURLConnection httpsURLConnection, IGetExternalInterface.d dVar, StringBuilder sb5) {
        map.put("Cookie", sb5.toString());
        dVar.a(c0(map, httpsURLConnection));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void F(String str, final Map map, final HttpsURLConnection httpsURLConnection, final IGetExternalInterface.d dVar, String str2, String str3) {
        if (TextUtils.isEmpty(str)) {
            str3 = null;
        }
        if (TextUtils.isEmpty(str3)) {
            QLog.e("TeamWorkHttpUtils", 1, "--- uploadFileInfo pskey is null ---");
            CookieManager cookieManager = CookieManager.getInstance();
            if (cookieManager != null) {
                map.put("Cookie", cookieManager.getCookie(str));
            }
            dVar.a(c0(map, httpsURLConnection));
            return;
        }
        z(str2, str3, new IGetExternalInterface.b() { // from class: com.tencent.mobileqq.teamwork.ao
            @Override // com.tencent.mobileqq.teamwork.api.IGetExternalInterface.b
            public final void a(StringBuilder sb5) {
                TeamWorkHttpUtils.E(map, httpsURLConnection, dVar, sb5);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x015a, code lost:
    
        if (r8 != null) goto L38;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static /* synthetic */ void G(String str, Map map, String str2, HttpsURLConnection httpsURLConnection, ITeamWorkFileExportHandler iTeamWorkFileExportHandler, String str3, String str4, String str5) {
        String str6;
        String str7;
        FileOutputStream fileOutputStream = null;
        if (TextUtils.isEmpty(str)) {
            str6 = null;
        } else {
            str6 = str5;
        }
        if (TextUtils.isEmpty(str6)) {
            QLog.e("TeamWorkHttpUtils", 1, "--- exportFile pskey is null ---");
            CookieManager cookieManager = CookieManager.getInstance();
            if (cookieManager != null) {
                map.put("filCookie", cookieManager.getCookie(str));
            }
        } else {
            if (str2 == null) {
                str7 = "";
            } else {
                str7 = str2;
            }
            map.put("Cookie", new StringBuilder(str7).toString());
        }
        try {
            for (Map.Entry entry : map.entrySet()) {
                httpsURLConnection.setRequestProperty((String) entry.getKey(), (String) entry.getValue());
            }
            httpsURLConnection.connect();
            int contentLength = httpsURLConnection.getContentLength();
            if (contentLength > B()) {
                iTeamWorkFileExportHandler.notifyUI(1, true, new Object[]{HardCodeUtil.qqStr(R.string.u19), str3});
            } else {
                InputStream inputStream = httpsURLConnection.getInputStream();
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                try {
                    try {
                        byte[] bArr = new byte[1048576];
                        long j3 = 0;
                        int i3 = 0;
                        while (true) {
                            int read = inputStream.read(bArr);
                            if (read == -1) {
                                break;
                            }
                            i3 += read;
                            byteArrayOutputStream.write(bArr, 0, read);
                            long currentTimeMillis = System.currentTimeMillis();
                            if (currentTimeMillis - j3 >= 1000) {
                                iTeamWorkFileExportHandler.notifyUI(4, true, new Object[]{Integer.valueOf((i3 * 100) / contentLength)});
                                j3 = currentTimeMillis;
                            }
                        }
                        byteArrayOutputStream.close();
                        byte[] byteArray = byteArrayOutputStream.toByteArray();
                        String w16 = com.tencent.mobileqq.filemanager.util.ah.w1(AppConstants.SDCARD_FILE_SAVE_PATH + str4);
                        FileOutputStream fileOutputStream2 = new FileOutputStream(new File(w16));
                        try {
                            fileOutputStream2.write(byteArray);
                            if (i3 >= contentLength) {
                                iTeamWorkFileExportHandler.notifyUI(3, true, new Object[]{w16, str3});
                            } else {
                                iTeamWorkFileExportHandler.notifyUI(1, true, new Object[]{HardCodeUtil.qqStr(R.string.u0d), str3});
                            }
                            byteArrayOutputStream.close();
                            fileOutputStream2.close();
                        } catch (IOException e16) {
                            e = e16;
                            fileOutputStream = fileOutputStream2;
                            QLog.d("TAG", 1, "exportFile download exception: " + e.toString());
                            iTeamWorkFileExportHandler.notifyUI(1, true, new Object[]{HardCodeUtil.qqStr(R.string.u0z), str3});
                            byteArrayOutputStream.close();
                            if (fileOutputStream != null) {
                                fileOutputStream.close();
                            }
                        } catch (Throwable th5) {
                            th = th5;
                            fileOutputStream = fileOutputStream2;
                            byteArrayOutputStream.close();
                            if (fileOutputStream != null) {
                                fileOutputStream.close();
                            }
                            if (inputStream != null) {
                                inputStream.close();
                            }
                            throw th;
                        }
                    } catch (Throwable th6) {
                        th = th6;
                    }
                } catch (IOException e17) {
                    e = e17;
                }
                inputStream.close();
            }
        } catch (Throwable th7) {
            try {
                QLog.d("TAG", 1, " teamwork exportFile exception: " + th7.toString());
                iTeamWorkFileExportHandler.notifyUI(1, true, new Object[]{HardCodeUtil.qqStr(R.string.u0h), str3});
            } finally {
                if (httpsURLConnection != null) {
                    httpsURLConnection.disconnect();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void H(String str, String str2, IGetExternalInterface.b bVar, Object obj) {
        StringBuilder sb5 = new StringBuilder();
        sb5.append("p_skey=");
        sb5.append(str);
        sb5.append(";p_uin=");
        sb5.append(str2);
        sb5.append(";");
        sb5.append(obj);
        bVar.a(sb5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void I(IGetExternalInterface.d dVar, StringBuilder sb5) {
        dVar.a(sb5.toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void J(String str, final IGetExternalInterface.d dVar, String str2, String str3) {
        if (!TextUtils.isEmpty(str3)) {
            z(str, str3, new IGetExternalInterface.b() { // from class: com.tencent.mobileqq.teamwork.av
                @Override // com.tencent.mobileqq.teamwork.api.IGetExternalInterface.b
                public final void a(StringBuilder sb5) {
                    TeamWorkHttpUtils.I(IGetExternalInterface.d.this, sb5);
                }
            });
            return;
        }
        CookieManager cookieManager = CookieManager.getInstance();
        if (cookieManager != null && cookieManager.getCookie(str2) != null) {
            dVar.a(cookieManager.getCookie(str2));
        } else {
            dVar.a("");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void K(IGetExternalInterface.d dVar, Object obj) {
        if (obj instanceof String) {
            try {
                JSONObject jSONObject = new JSONObject((String) obj);
                if (jSONObject.optInt("ret", -1) != 0) {
                    if (QLog.isColorLevel()) {
                        QLog.e("TeamWorkHttpUtils", 2, "setPolicy4AllByHttp failed result" + obj);
                    }
                } else {
                    dVar.a(jSONObject.getString("data"));
                    return;
                }
            } catch (Throwable th5) {
                if (QLog.isColorLevel()) {
                    QLog.e("TeamWorkHttpUtils", 2, th5, new Object[0]);
                }
            }
        }
        dVar.a("");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void L(File file, String str, Map map, HttpsURLConnection httpsURLConnection, String str2, TenDocOCRExportHandler tenDocOCRExportHandler, IGetExternalInterface.d dVar, StringBuilder sb5) {
        String str3;
        if (file.exists()) {
            str3 = A(str);
        } else {
            str3 = null;
        }
        if (str3 != null) {
            sb5.append(";uniquefileid=");
            sb5.append(str3);
        }
        map.put("Cookie", sb5.toString());
        dVar.a(d0(map, httpsURLConnection, str2, file, tenDocOCRExportHandler));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void M(String str, final Map map, final HttpsURLConnection httpsURLConnection, final String str2, final File file, final TenDocOCRExportHandler tenDocOCRExportHandler, final IGetExternalInterface.d dVar, String str3, final String str4, String str5) {
        String str6;
        if (TextUtils.isEmpty(str)) {
            str6 = null;
        } else {
            str6 = str5;
        }
        if (TextUtils.isEmpty(str6)) {
            QLog.e("TeamWorkHttpUtils", 1, "--- uploadFile pskey is null ---");
            CookieManager cookieManager = CookieManager.getInstance();
            if (cookieManager != null) {
                map.put("Cookie", cookieManager.getCookie(str));
            }
            dVar.a(d0(map, httpsURLConnection, str2, file, tenDocOCRExportHandler));
            return;
        }
        z(str3, str6, new IGetExternalInterface.b() { // from class: com.tencent.mobileqq.teamwork.al
            @Override // com.tencent.mobileqq.teamwork.api.IGetExternalInterface.b
            public final void a(StringBuilder sb5) {
                TeamWorkHttpUtils.L(file, str4, map, httpsURLConnection, str2, tenDocOCRExportHandler, dVar, sb5);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void N(String str, final Map map, final HttpsURLConnection httpsURLConnection, final IGetExternalInterface.d dVar, String str2, final String str3, String str4) {
        if (TextUtils.isEmpty(str)) {
            str4 = null;
        }
        if (TextUtils.isEmpty(str4)) {
            QLog.e("TeamWorkHttpUtils", 1, "--- uploadFileInfo pskey is null ---");
            CookieManager cookieManager = CookieManager.getInstance();
            if (cookieManager != null) {
                map.put("Cookie", cookieManager.getCookie(str));
            }
            dVar.a(f0(map, httpsURLConnection));
            return;
        }
        z(str2, str4, new IGetExternalInterface.b() { // from class: com.tencent.mobileqq.teamwork.ar
            @Override // com.tencent.mobileqq.teamwork.api.IGetExternalInterface.b
            public final void a(StringBuilder sb5) {
                TeamWorkHttpUtils.O(str3, map, httpsURLConnection, dVar, sb5);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void O(String str, Map map, HttpsURLConnection httpsURLConnection, IGetExternalInterface.d dVar, StringBuilder sb5) {
        if (!TextUtils.isEmpty(str)) {
            sb5.append(';');
            sb5.append(str);
        }
        map.put("Cookie", sb5.toString());
        dVar.a(f0(map, httpsURLConnection));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void P(String str, Map map, HttpsURLConnection httpsURLConnection, String str2, IGetExternalInterface.d dVar, StringBuilder sb5) {
        if (!TextUtils.isEmpty(str)) {
            sb5.append(';');
            sb5.append(str);
        }
        map.put("Cookie", sb5.toString());
        dVar.a(g0(map, httpsURLConnection, str2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void Q(String str, final Map map, final HttpsURLConnection httpsURLConnection, final String str2, final IGetExternalInterface.d dVar, String str3, final String str4, String str5) {
        if (TextUtils.isEmpty(str)) {
            str5 = null;
        }
        if (TextUtils.isEmpty(str5)) {
            QLog.e("TeamWorkHttpUtils", 1, "--- uploadFileInfo pskey is null ---");
            CookieManager cookieManager = CookieManager.getInstance();
            if (cookieManager != null && cookieManager.getCookie(str) != null) {
                map.put("Cookie", cookieManager.getCookie(str));
            }
            dVar.a(g0(map, httpsURLConnection, str2));
            return;
        }
        z(str3, str5, new IGetExternalInterface.b() { // from class: com.tencent.mobileqq.teamwork.ak
            @Override // com.tencent.mobileqq.teamwork.api.IGetExternalInterface.b
            public final void a(StringBuilder sb5) {
                TeamWorkHttpUtils.P(str4, map, httpsURLConnection, str2, dVar, sb5);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void R(File file, String str, Map map, HttpsURLConnection httpsURLConnection, TeamWorkFileImportInfo teamWorkFileImportInfo, String str2, IGetExternalInterface.d dVar, StringBuilder sb5) {
        String str3;
        if (file.exists()) {
            str3 = A(str);
        } else {
            str3 = null;
        }
        if (!TextUtils.isEmpty(str3)) {
            sb5.append(";uniquefileid=");
            sb5.append(str3);
        }
        map.put("Cookie", sb5.toString());
        dVar.a(k0(map, httpsURLConnection, teamWorkFileImportInfo, str2, file));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void S(String str, final Map map, final HttpsURLConnection httpsURLConnection, final TeamWorkFileImportInfo teamWorkFileImportInfo, final String str2, final File file, final IGetExternalInterface.d dVar, String str3, final String str4, String str5) {
        String str6;
        if (TextUtils.isEmpty(str)) {
            str6 = null;
        } else {
            str6 = str5;
        }
        if (TextUtils.isEmpty(str6)) {
            QLog.e("TeamWorkHttpUtils", 1, "--- uploadFile pskey is null ---");
            CookieManager cookieManager = CookieManager.getInstance();
            if (cookieManager != null) {
                map.put("Cookie", cookieManager.getCookie(str));
            }
            dVar.a(k0(map, httpsURLConnection, teamWorkFileImportInfo, str2, file));
            return;
        }
        z(str3, str6, new IGetExternalInterface.b() { // from class: com.tencent.mobileqq.teamwork.am
            @Override // com.tencent.mobileqq.teamwork.api.IGetExternalInterface.b
            public final void a(StringBuilder sb5) {
                TeamWorkHttpUtils.R(file, str4, map, httpsURLConnection, teamWorkFileImportInfo, str2, dVar, sb5);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void T(File file, TeamWorkFileImportInfo teamWorkFileImportInfo, Map map, HttpsURLConnection httpsURLConnection, String str, IGetExternalInterface.d dVar, StringBuilder sb5) {
        String str2;
        if (file.exists()) {
            str2 = A(teamWorkFileImportInfo.f292077h);
        } else {
            str2 = null;
        }
        if (str2 != null) {
            sb5.append(";uniquefileid=");
            sb5.append(str2);
        }
        map.put("Cookie", sb5.toString());
        dVar.a(h0(map, httpsURLConnection, str, file));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void U(String str, final Map map, final HttpsURLConnection httpsURLConnection, final String str2, final File file, final IGetExternalInterface.d dVar, String str3, final TeamWorkFileImportInfo teamWorkFileImportInfo, String str4) {
        if (TextUtils.isEmpty(str)) {
            str4 = null;
        }
        if (TextUtils.isEmpty(str4)) {
            QLog.e("TeamWorkHttpUtils", 1, "--- uploadFile pskey is null ---");
            CookieManager cookieManager = CookieManager.getInstance();
            if (cookieManager != null) {
                map.put("Cookie", cookieManager.getCookie(str));
            }
            dVar.a(h0(map, httpsURLConnection, str2, file));
            return;
        }
        z(str3, str4, new IGetExternalInterface.b() { // from class: com.tencent.mobileqq.teamwork.ai
            @Override // com.tencent.mobileqq.teamwork.api.IGetExternalInterface.b
            public final void a(StringBuilder sb5) {
                TeamWorkHttpUtils.T(file, teamWorkFileImportInfo, map, httpsURLConnection, str2, dVar, sb5);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void V(Map map, HttpsURLConnection httpsURLConnection, JSONObject jSONObject, IGetExternalInterface.d dVar, StringBuilder sb5) {
        map.put("Cookie", sb5.toString());
        dVar.a(j0(map, httpsURLConnection, jSONObject));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void W(String str, final Map map, final HttpsURLConnection httpsURLConnection, final JSONObject jSONObject, final IGetExternalInterface.d dVar, String str2, String str3) {
        if (TextUtils.isEmpty(str)) {
            str3 = null;
        }
        if (TextUtils.isEmpty(str3)) {
            QLog.e("TeamWorkHttpUtils", 1, "--- uploadFileInfo pskey is null ---");
            CookieManager cookieManager = CookieManager.getInstance();
            if (cookieManager != null) {
                map.put("Cookie", cookieManager.getCookie(str));
            }
            dVar.a(j0(map, httpsURLConnection, jSONObject));
            return;
        }
        z(str2, str3, new IGetExternalInterface.b() { // from class: com.tencent.mobileqq.teamwork.aj
            @Override // com.tencent.mobileqq.teamwork.api.IGetExternalInterface.b
            public final void a(StringBuilder sb5) {
                TeamWorkHttpUtils.V(map, httpsURLConnection, jSONObject, dVar, sb5);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void X(Map map, HttpsURLConnection httpsURLConnection, JSONObject jSONObject, IGetExternalInterface.d dVar, StringBuilder sb5) {
        map.put("Cookie", sb5.toString());
        dVar.a(i0(map, httpsURLConnection, jSONObject));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void Y(String str, final Map map, final HttpsURLConnection httpsURLConnection, final JSONObject jSONObject, final IGetExternalInterface.d dVar, String str2, String str3) {
        if (TextUtils.isEmpty(str)) {
            str3 = null;
        }
        if (TextUtils.isEmpty(str3)) {
            QLog.e("TeamWorkHttpUtils", 1, "--- uploadFileInfo pskey is null ---");
            CookieManager cookieManager = CookieManager.getInstance();
            if (cookieManager != null) {
                map.put("Cookie", cookieManager.getCookie(str));
            }
            dVar.a(i0(map, httpsURLConnection, jSONObject));
            return;
        }
        z(str2, str3, new IGetExternalInterface.b() { // from class: com.tencent.mobileqq.teamwork.aq
            @Override // com.tencent.mobileqq.teamwork.api.IGetExternalInterface.b
            public final void a(StringBuilder sb5) {
                TeamWorkHttpUtils.X(map, httpsURLConnection, jSONObject, dVar, sb5);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void Z(File file, String str, Map map, JSONObject jSONObject, HttpsURLConnection httpsURLConnection, String str2, IGetExternalInterface.d dVar, StringBuilder sb5) {
        String str3;
        if (file.exists()) {
            str3 = A(str);
        } else {
            str3 = null;
        }
        if (str3 != null) {
            sb5.append(";uniquefileid=");
            sb5.append(str3);
        }
        map.put("Cookie", sb5.toString());
        dVar.a(l0(jSONObject, map, httpsURLConnection, str2, file));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a0(String str, final Map map, final JSONObject jSONObject, final HttpsURLConnection httpsURLConnection, final String str2, final File file, final IGetExternalInterface.d dVar, String str3, final String str4, String str5) {
        String str6;
        if (TextUtils.isEmpty(str)) {
            str6 = null;
        } else {
            str6 = str5;
        }
        if (TextUtils.isEmpty(str6)) {
            QLog.e("TeamWorkHttpUtils", 1, "--- uploadFile pskey is null ---");
            CookieManager cookieManager = CookieManager.getInstance();
            if (cookieManager != null) {
                map.put("Cookie", cookieManager.getCookie(str));
            }
            dVar.a(l0(jSONObject, map, httpsURLConnection, str2, file));
            return;
        }
        z(str3, str6, new IGetExternalInterface.b() { // from class: com.tencent.mobileqq.teamwork.an
            @Override // com.tencent.mobileqq.teamwork.api.IGetExternalInterface.b
            public final void a(StringBuilder sb5) {
                TeamWorkHttpUtils.Z(file, str4, map, jSONObject, httpsURLConnection, str2, dVar, sb5);
            }
        });
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0154  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void b0(AppInterface appInterface, final String str, final String str2, final IGetExternalInterface.d dVar) {
        final HttpsURLConnection httpsURLConnection;
        l lVar;
        HttpsURLConnection httpsURLConnection2 = null;
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            final TenDocOCRExportHandler tenDocOCRExportHandler = (TenDocOCRExportHandler) appInterface.getBusinessHandler(TenDocOCRExportHandler.class.getName());
            tenDocOCRExportHandler.notifyUI(2, true, null);
            tenDocOCRExportHandler.notifyUI(4, true, new Object[]{20});
            final String str3 = "https://qqandroid.docs.qq.com/preview/imp/import_ocr?need_url=true";
            final File file = new File(str);
            final String str4 = "---------------------------123821742118716";
            try {
                try {
                    c cVar = new c();
                    SSLContext sSLContext = SSLContext.getInstance("TLSv1.2");
                    sSLContext.init(null, new TrustManager[]{cVar}, null);
                    lVar = new l(sSLContext.getSocketFactory());
                    HttpsURLConnection.setDefaultSSLSocketFactory(lVar);
                    httpsURLConnection = (HttpsURLConnection) new URL(str3).openConnection();
                } catch (Exception e16) {
                    e = e16;
                    httpsURLConnection = null;
                } catch (Throwable th5) {
                    th = th5;
                    if (httpsURLConnection2 != null) {
                    }
                    throw th;
                }
                try {
                    httpsURLConnection.setSSLSocketFactory(lVar);
                    httpsURLConnection.setConnectTimeout(5000);
                    httpsURLConnection.setReadTimeout(30000);
                    httpsURLConnection.setDoOutput(true);
                    httpsURLConnection.setDoInput(true);
                    httpsURLConnection.setUseCaches(false);
                    httpsURLConnection.setRequestMethod("POST");
                    httpsURLConnection.setRequestProperty("Connection", "Keep-Alive");
                    StringBuilder sb5 = new StringBuilder("android");
                    sb5.append("_");
                    sb5.append(Build.VERSION.SDK);
                    sb5.append("_");
                    sb5.append(Build.DEVICE);
                    sb5.append("_");
                    sb5.append(Build.VERSION.RELEASE);
                    sb5.append("_");
                    String str5 = AppSetting.f99551k;
                    sb5.append(str5);
                    sb5.append("_");
                    sb5.append("QQ/");
                    sb5.append(str5 + AppSetting.f99542b);
                    httpsURLConnection.setRequestProperty("User-Agent", sb5.toString());
                    httpsURLConnection.setRequestProperty("Accept", "*/*");
                    httpsURLConnection.setRequestProperty("Content-Type", "multipart/form-data; boundary=---------------------------123821742118716");
                    final HashMap hashMap = new HashMap();
                    hashMap.put("Connection", "keep-alive");
                    hashMap.put("Referer", str3);
                    ((IGetExternalInterface) QRoute.api(IGetExternalInterface.class)).getPsKey(ITeamWorkHandler.DOCS_DOMAIN, new IGetExternalInterface.c() { // from class: com.tencent.mobileqq.teamwork.aw
                        @Override // com.tencent.mobileqq.teamwork.api.IGetExternalInterface.c
                        public final void a(String str6) {
                            TeamWorkHttpUtils.M(str3, hashMap, httpsURLConnection, str4, file, tenDocOCRExportHandler, dVar, str2, str, str6);
                        }
                    });
                } catch (Exception e17) {
                    e = e17;
                    e.printStackTrace();
                    dVar.a(null);
                    if (httpsURLConnection == null) {
                        return;
                    }
                    httpsURLConnection.disconnect();
                    return;
                }
                httpsURLConnection.disconnect();
                return;
            } catch (Throwable th6) {
                th = th6;
                httpsURLConnection2 = httpsURLConnection;
                if (httpsURLConnection2 != null) {
                    httpsURLConnection2.disconnect();
                }
                throw th;
            }
        }
        QLog.e("TeamWorkHttpUtils", 1, "--- downloadFile fileUrl is null or uin is null ---");
        dVar.a(null);
    }

    private static String c0(Map<String, String> map, HttpsURLConnection httpsURLConnection) {
        try {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                httpsURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
            }
            int responseCode = httpsURLConnection.getResponseCode();
            if (responseCode != 200) {
                QLog.i("TeamWorkHttpUtils", 1, "--- checkIfExist response status: " + responseCode + " ----");
            }
            String e06 = e0(new BufferedReader(new InputStreamReader(httpsURLConnection.getInputStream())));
            httpsURLConnection.disconnect();
            return e06;
        } catch (Throwable th5) {
            try {
                QLog.e("TeamWorkHttpUtils", 1, "readCheckIfExistReturnData error, e: " + th5.toString());
                return null;
            } finally {
                if (httpsURLConnection != null) {
                    httpsURLConnection.disconnect();
                }
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0269  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x026e  */
    /* JADX WARN: Type inference failed for: r1v23 */
    /* JADX WARN: Type inference failed for: r1v25 */
    /* JADX WARN: Type inference failed for: r1v26, types: [org.json.JSONObject] */
    /* JADX WARN: Type inference failed for: r1v27 */
    /* JADX WARN: Type inference failed for: r1v28 */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r26v0, types: [com.tencent.mobileqq.app.BusinessHandler, com.tencent.mobileqq.teamwork.TenDocOCRExportHandler] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static JSONObject d0(Map<String, String> map, HttpsURLConnection httpsURLConnection, String str, File file, final TenDocOCRExportHandler tenDocOCRExportHandler) {
        HttpsURLConnection httpsURLConnection2;
        BaseTimer baseTimer;
        BaseTimer baseTimer2;
        JSONObject jSONObject;
        DataOutputStream dataOutputStream;
        StringBuffer stringBuffer;
        Throwable th5;
        try {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                try {
                    httpsURLConnection2 = httpsURLConnection;
                } catch (Throwable th6) {
                    th = th6;
                    httpsURLConnection2 = httpsURLConnection;
                    jSONObject = 0;
                    baseTimer2 = null;
                    try {
                        th.printStackTrace();
                        if (baseTimer2 != null) {
                        }
                        if (httpsURLConnection2 != null) {
                        }
                        return jSONObject;
                    } finally {
                    }
                }
                try {
                    httpsURLConnection2.setRequestProperty(entry.getKey(), entry.getValue());
                } catch (Throwable th7) {
                    th = th7;
                    jSONObject = 0;
                    baseTimer2 = null;
                    th.printStackTrace();
                    if (baseTimer2 != null) {
                    }
                    if (httpsURLConnection2 != null) {
                    }
                    return jSONObject;
                }
            }
            httpsURLConnection2 = httpsURLConnection;
        } catch (Throwable th8) {
            th = th8;
            httpsURLConnection2 = httpsURLConnection;
        }
        try {
            dataOutputStream = new DataOutputStream(httpsURLConnection.getOutputStream());
            stringBuffer = new StringBuffer();
            stringBuffer.append("\r\n");
            stringBuffer.append("--");
            stringBuffer.append(str);
            stringBuffer.append("\r\n");
            stringBuffer.append("Content-Disposition: form-data; name=\"");
            stringBuffer.append("file");
            stringBuffer.append("\"; filename=\"");
            stringBuffer.append(file.getName());
            stringBuffer.append("\";");
            stringBuffer.append("\r\n");
            stringBuffer.append("Content-Type:application/octet-stream\r\n\r\n");
        } catch (Throwable th9) {
            th = th9;
            baseTimer = null;
            baseTimer2 = baseTimer;
            jSONObject = baseTimer;
            th.printStackTrace();
            if (baseTimer2 != null) {
            }
            if (httpsURLConnection2 != null) {
            }
            return jSONObject;
        }
        try {
            dataOutputStream.write(stringBuffer.toString().getBytes());
            BufferedInputStream bufferedInputStream = new BufferedInputStream(new BufferedInputStream(new FileInputStream(file)));
            byte[] bArr = new byte[3072];
            int length = (int) file.length();
            long j3 = 0;
            int i3 = 0;
            while (true) {
                try {
                    try {
                        int read = bufferedInputStream.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        i3 += read;
                        dataOutputStream.write(bArr, 0, read);
                        long currentTimeMillis = System.currentTimeMillis();
                        if (currentTimeMillis - j3 >= 1000) {
                            tenDocOCRExportHandler.notifyUI(4, true, new Object[]{Integer.valueOf((i3 * 30) / length)});
                            j3 = currentTimeMillis;
                        }
                    } catch (OutOfMemoryError unused) {
                        QLog.e("TeamWorkHttpUtils", 1, "teamwork uploadfile OOM: fileSize = " + file.length() + ", name = " + file.getAbsolutePath());
                        dataOutputStream.flush();
                        dataOutputStream.close();
                        httpsURLConnection.disconnect();
                        try {
                            bufferedInputStream.close();
                            return null;
                        } catch (Throwable th10) {
                            th = th10;
                            jSONObject = 0;
                            baseTimer2 = null;
                            httpsURLConnection2 = null;
                            th.printStackTrace();
                            if (baseTimer2 != null) {
                            }
                            if (httpsURLConnection2 != null) {
                            }
                            return jSONObject;
                        }
                    }
                } catch (Throwable th11) {
                    bufferedInputStream.close();
                    throw th11;
                }
            }
            bufferedInputStream.close();
            final int[] iArr = {50};
            tenDocOCRExportHandler.notifyUI(4, true, new Object[]{50});
            baseTimer2 = new BaseTimer();
            try {
                baseTimer2.schedule(new TimerTask() { // from class: com.tencent.mobileqq.teamwork.TeamWorkHttpUtils.1
                    @Override // java.util.TimerTask, java.lang.Runnable
                    public void run() {
                        int[] iArr2 = iArr;
                        int i16 = iArr2[0];
                        if (i16 >= 99) {
                            tenDocOCRExportHandler.notifyUI(4, true, new Object[]{99});
                            return;
                        }
                        int i17 = i16 + 2;
                        iArr2[0] = i17;
                        tenDocOCRExportHandler.notifyUI(4, true, new Object[]{Integer.valueOf(i17)});
                    }
                }, 0L, 1000L);
                try {
                    dataOutputStream.write(("\r\n--" + str + "--\r\n").getBytes());
                    dataOutputStream.flush();
                    dataOutputStream.close();
                } catch (Exception e16) {
                    QLog.e("TeamWorkHttpUtils", 1, "ocrExportUploadImage out.flush IOException: " + e16);
                }
                int responseCode = httpsURLConnection.getResponseCode();
                if (responseCode != 200) {
                    QLog.i("TeamWorkHttpUtils", 1, "--- uploadFile response status: " + responseCode + " ----");
                }
                String e06 = e0(new BufferedReader(new InputStreamReader(httpsURLConnection.getInputStream())));
                tenDocOCRExportHandler.notifyUI(4, true, new Object[]{100});
                jSONObject = new JSONObject(e06);
                baseTimer2.cancel();
                httpsURLConnection.disconnect();
            } catch (Throwable th12) {
                th = th12;
                jSONObject = 0;
                th.printStackTrace();
                if (baseTimer2 != null) {
                }
                if (httpsURLConnection2 != null) {
                }
                return jSONObject;
            }
            return jSONObject;
        } catch (IOException e17) {
            QLog.e("TeamWorkHttpUtils", 1, "ocrExportUploadImage out.write IOException: " + e17);
            try {
                dataOutputStream.flush();
                try {
                    dataOutputStream.close();
                } catch (Exception e18) {
                    QLog.e("TeamWorkHttpUtils", 1, "ocrExportUploadImage out.close IOException: " + e18);
                }
            } catch (IOException e19) {
                try {
                    QLog.e("TeamWorkHttpUtils", 1, "ocrExportUploadImage out.close IOException: " + e19);
                    try {
                        dataOutputStream.close();
                    } catch (Exception e26) {
                        QLog.e("TeamWorkHttpUtils", 1, "ocrExportUploadImage out.close IOException: " + e26);
                    }
                    httpsURLConnection.disconnect();
                    return null;
                } catch (Throwable th13) {
                    baseTimer = null;
                    th5 = th13;
                    try {
                        try {
                            dataOutputStream.close();
                            throw th5;
                        } catch (Exception e27) {
                            QLog.e("TeamWorkHttpUtils", 1, "ocrExportUploadImage out.close IOException: " + e27);
                            throw th5;
                        }
                    } catch (Throwable th14) {
                        th = th14;
                        baseTimer2 = baseTimer;
                        jSONObject = baseTimer;
                        th.printStackTrace();
                        if (baseTimer2 != null) {
                            baseTimer2.cancel();
                        }
                        if (httpsURLConnection2 != null) {
                            httpsURLConnection2.disconnect();
                        }
                        return jSONObject;
                    }
                }
            } catch (Throwable th15) {
                th5 = th15;
                baseTimer = null;
                dataOutputStream.close();
                throw th5;
            }
            httpsURLConnection.disconnect();
            return null;
        }
    }

    private static String e0(BufferedReader bufferedReader) {
        StringBuilder sb5;
        String str = null;
        if (bufferedReader == null) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer();
        while (true) {
            try {
                try {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    stringBuffer.append(readLine);
                    stringBuffer.append("\n");
                } catch (IOException e16) {
                    QLog.e("TeamWorkHttpUtils", 1, "readReturnData reader.readLine IOException: " + e16);
                    try {
                        bufferedReader.close();
                    } catch (IOException e17) {
                        e = e17;
                        sb5 = new StringBuilder();
                        sb5.append("readReturnData reader.close IOException: ");
                        sb5.append(e);
                        QLog.e("TeamWorkHttpUtils", 1, sb5.toString());
                        return str;
                    }
                }
            } catch (Throwable th5) {
                try {
                    bufferedReader.close();
                } catch (IOException e18) {
                    QLog.e("TeamWorkHttpUtils", 1, "readReturnData reader.close IOException: " + e18);
                }
                throw th5;
            }
        }
        str = stringBuffer.toString();
        try {
            bufferedReader.close();
        } catch (IOException e19) {
            e = e19;
            sb5 = new StringBuilder();
            sb5.append("readReturnData reader.close IOException: ");
            sb5.append(e);
            QLog.e("TeamWorkHttpUtils", 1, sb5.toString());
            return str;
        }
        return str;
    }

    private static String f0(Map<String, String> map, HttpsURLConnection httpsURLConnection) {
        try {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                httpsURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
            }
            int responseCode = httpsURLConnection.getResponseCode();
            if (responseCode != 200) {
                QLog.i("TeamWorkHttpUtils", 1, "--- sendHttpsGet response status: " + responseCode + " ----");
            }
            String e06 = e0(new BufferedReader(new InputStreamReader(httpsURLConnection.getInputStream())));
            httpsURLConnection.disconnect();
            return e06;
        } catch (Throwable th5) {
            try {
                QLog.d("TeamWorkHttpUtils", 1, "readSendHttpsGetReturnData error, e: " + th5.toString());
                return null;
            } finally {
                if (httpsURLConnection != null) {
                    httpsURLConnection.disconnect();
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x009c, code lost:
    
        if (r6 == null) goto L21;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static String g0(Map<String, String> map, HttpsURLConnection httpsURLConnection, String str) {
        String str2 = null;
        try {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                httpsURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
            }
            DataOutputStream dataOutputStream = new DataOutputStream(httpsURLConnection.getOutputStream());
            try {
                dataOutputStream.write(str.getBytes("UTF-8"));
                dataOutputStream.flush();
                dataOutputStream.close();
                int responseCode = httpsURLConnection.getResponseCode();
                if (responseCode != 200) {
                    QLog.i("TeamWorkHttpUtils", 1, "--- sendHttpsGet response status: " + responseCode + " ----");
                }
                str2 = e0(new BufferedReader(new InputStreamReader(httpsURLConnection.getInputStream())));
            } catch (Exception unused) {
                dataOutputStream.close();
                httpsURLConnection.disconnect();
                return null;
            }
        } catch (Throwable th5) {
            try {
                QLog.e("TeamWorkHttpUtils", 1, "readSendHttpsRequestReturnData error, e: " + th5.toString());
            } catch (Throwable th6) {
                if (httpsURLConnection != null) {
                    httpsURLConnection.disconnect();
                }
                throw th6;
            }
        }
        httpsURLConnection.disconnect();
        return str2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:43:0x0210, code lost:
    
        if (r9 != null) goto L22;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static String h0(Map<String, String> map, HttpsURLConnection httpsURLConnection, String str, File file) {
        String str2;
        String str3 = null;
        try {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                httpsURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
            }
            DataOutputStream dataOutputStream = new DataOutputStream(httpsURLConnection.getOutputStream());
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("\r\n");
            stringBuffer.append("--");
            stringBuffer.append(str);
            stringBuffer.append("\r\n");
            stringBuffer.append("Content-Disposition: form-data; name=\"");
            stringBuffer.append("file");
            stringBuffer.append("\"; filename=\"");
            stringBuffer.append(file.getName());
            stringBuffer.append("\"\r\n");
            stringBuffer.append("Content-Type:application/octet-stream\r\n\r\n");
            try {
                dataOutputStream.write(stringBuffer.toString().getBytes());
                BufferedInputStream bufferedInputStream = new BufferedInputStream(new BufferedInputStream(new FileInputStream(file)));
                byte[] bArr = new byte[3072];
                while (true) {
                    try {
                        try {
                            int read = bufferedInputStream.read(bArr);
                            if (read == -1) {
                                break;
                            }
                            dataOutputStream.write(bArr, 0, read);
                        } catch (Throwable th5) {
                            try {
                                bufferedInputStream.close();
                                dataOutputStream.flush();
                                dataOutputStream.close();
                            } catch (Exception e16) {
                                QLog.e("TeamWorkHttpUtils", 1, "uploadFileForH5 in.close() IOException: " + e16);
                            }
                            throw th5;
                        }
                    } catch (OutOfMemoryError unused) {
                        QLog.e("TeamWorkHttpUtils", 1, "teamwork uploadfile OOM: fileSize = " + file.length() + ", name = " + file.getAbsolutePath());
                        httpsURLConnection.disconnect();
                        try {
                            try {
                                bufferedInputStream.close();
                                dataOutputStream.flush();
                                dataOutputStream.close();
                            } catch (Throwable th6) {
                                th = th6;
                                httpsURLConnection = null;
                                try {
                                    QLog.e("TeamWorkHttpUtils", 1, "readUploadFileForH5ReturnData error:" + th.toString());
                                } catch (Throwable th7) {
                                    if (httpsURLConnection != null) {
                                        httpsURLConnection.disconnect();
                                    }
                                    throw th7;
                                }
                            }
                        } catch (Exception e17) {
                            QLog.e("TeamWorkHttpUtils", 1, "uploadFileForH5 in.close() IOException: " + e17);
                            return null;
                        }
                        return null;
                    }
                }
                dataOutputStream.write(("\r\n--" + str + "--\r\n").getBytes());
                try {
                    bufferedInputStream.close();
                    dataOutputStream.flush();
                    dataOutputStream.close();
                } catch (Exception e18) {
                    QLog.e("TeamWorkHttpUtils", 1, "uploadFileForH5 in.close() IOException: " + e18);
                }
                int responseCode = httpsURLConnection.getResponseCode();
                if (responseCode != 200) {
                    QLog.i("TeamWorkHttpUtils", 1, "--- uploadFile response status: " + responseCode + " ----");
                }
                str3 = e0(new BufferedReader(new InputStreamReader(httpsURLConnection.getInputStream())));
            } catch (IOException e19) {
                QLog.e("TeamWorkHttpUtils", 1, "uploadFileForH5 out.write IOException: " + e19);
                try {
                    try {
                        dataOutputStream.flush();
                        try {
                            dataOutputStream.close();
                        } catch (Exception e26) {
                            str2 = "uploadFileForH5 out.close IOException: " + e26;
                            QLog.e("TeamWorkHttpUtils", 1, str2);
                            httpsURLConnection.disconnect();
                            return null;
                        }
                    } catch (Throwable th8) {
                        try {
                            dataOutputStream.close();
                        } catch (Exception e27) {
                            QLog.e("TeamWorkHttpUtils", 1, "uploadFileForH5 out.close IOException: " + e27);
                        }
                        throw th8;
                    }
                } catch (IOException e28) {
                    QLog.e("TeamWorkHttpUtils", 1, "uploadFileForH5 out.close IOException: " + e28);
                    try {
                        dataOutputStream.close();
                    } catch (Exception e29) {
                        str2 = "uploadFileForH5 out.close IOException: " + e29;
                        QLog.e("TeamWorkHttpUtils", 1, str2);
                        httpsURLConnection.disconnect();
                        return null;
                    }
                    httpsURLConnection.disconnect();
                    return null;
                }
                httpsURLConnection.disconnect();
                return null;
            }
        } catch (Throwable th9) {
            th = th9;
            QLog.e("TeamWorkHttpUtils", 1, "readUploadFileForH5ReturnData error:" + th.toString());
        }
        httpsURLConnection.disconnect();
        return str3;
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x00a0, code lost:
    
        if (r6 == null) goto L21;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static String i0(Map<String, String> map, HttpsURLConnection httpsURLConnection, JSONObject jSONObject) {
        DataOutputStream dataOutputStream;
        String str = null;
        try {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                httpsURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
            }
            dataOutputStream = new DataOutputStream(httpsURLConnection.getOutputStream());
        } catch (Throwable th5) {
            try {
                QLog.e("TeamWorkHttpUtils", 1, "readUploadFileInfoForH5ReturnData error, e: " + th5.toString());
            } catch (Throwable th6) {
                if (httpsURLConnection != null) {
                    httpsURLConnection.disconnect();
                }
                throw th6;
            }
        }
        try {
            dataOutputStream.write(jSONObject.toString().getBytes("UTF-8"));
            dataOutputStream.flush();
            dataOutputStream.close();
            int responseCode = httpsURLConnection.getResponseCode();
            if (responseCode != 200) {
                QLog.i("TeamWorkHttpUtils", 1, "--- uploadFileInfo response status: " + responseCode + " ----");
            }
            str = e0(new BufferedReader(new InputStreamReader(httpsURLConnection.getInputStream())));
            httpsURLConnection.disconnect();
            return str;
        } catch (Exception unused) {
            dataOutputStream.close();
            httpsURLConnection.disconnect();
            return null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x00a0, code lost:
    
        if (r6 == null) goto L21;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static String j0(Map<String, String> map, HttpsURLConnection httpsURLConnection, JSONObject jSONObject) {
        DataOutputStream dataOutputStream;
        String str = null;
        try {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                httpsURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
            }
            dataOutputStream = new DataOutputStream(httpsURLConnection.getOutputStream());
        } catch (Throwable th5) {
            try {
                QLog.d("TeamWorkHttpUtils", 1, "readUploadFileInfoReturnData error, e:" + th5.toString());
            } catch (Throwable th6) {
                if (httpsURLConnection != null) {
                    httpsURLConnection.disconnect();
                }
                throw th6;
            }
        }
        try {
            dataOutputStream.write(jSONObject.toString().getBytes("UTF-8"));
            dataOutputStream.flush();
            dataOutputStream.close();
            int responseCode = httpsURLConnection.getResponseCode();
            if (responseCode != 200) {
                QLog.i("TeamWorkHttpUtils", 1, "--- uploadFileInfo response status: " + responseCode + " ----");
            }
            str = e0(new BufferedReader(new InputStreamReader(httpsURLConnection.getInputStream())));
            httpsURLConnection.disconnect();
            return str;
        } catch (Exception unused) {
            dataOutputStream.close();
            httpsURLConnection.disconnect();
            return null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:40:0x0219, code lost:
    
        if (r9 != null) goto L65;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static String k0(Map<String, String> map, HttpsURLConnection httpsURLConnection, TeamWorkFileImportInfo teamWorkFileImportInfo, String str, File file) {
        String str2;
        String str3 = null;
        try {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                httpsURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
            }
            if (teamWorkFileImportInfo.Y != 1) {
                DataOutputStream dataOutputStream = new DataOutputStream(httpsURLConnection.getOutputStream());
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("\r\n");
                stringBuffer.append("--");
                stringBuffer.append(str);
                stringBuffer.append("\r\n");
                stringBuffer.append("Content-Disposition: form-data; name=\"");
                stringBuffer.append("file");
                stringBuffer.append("\"; filename=\"");
                stringBuffer.append(file.getName());
                stringBuffer.append("\";");
                stringBuffer.append("\r\n");
                stringBuffer.append("Content-Type:application/octet-stream\r\n\r\n");
                try {
                    dataOutputStream.write(stringBuffer.toString().getBytes());
                    BufferedInputStream bufferedInputStream = new BufferedInputStream(new BufferedInputStream(new FileInputStream(file)));
                    byte[] bArr = new byte[3072];
                    while (true) {
                        try {
                            try {
                                int read = bufferedInputStream.read(bArr);
                                if (read == -1) {
                                    break;
                                }
                                dataOutputStream.write(bArr, 0, read);
                            } catch (Throwable th5) {
                                try {
                                    bufferedInputStream.close();
                                    dataOutputStream.flush();
                                    dataOutputStream.close();
                                } catch (Exception e16) {
                                    QLog.e("TeamWorkHttpUtils", 1, "uploadFile in.close() IOException: " + e16);
                                }
                                throw th5;
                            }
                        } catch (OutOfMemoryError unused) {
                            QLog.e("TeamWorkHttpUtils", 1, "teamwork uploadfile OOM: fileSize = " + file.length() + ", name = " + file.getAbsolutePath());
                            httpsURLConnection.disconnect();
                            try {
                                try {
                                    bufferedInputStream.close();
                                    dataOutputStream.flush();
                                    dataOutputStream.close();
                                } catch (Throwable th6) {
                                    th = th6;
                                    httpsURLConnection = null;
                                    try {
                                        QLog.e("TeamWorkHttpUtils", 1, "readUploadFileReturnData error, e:" + th.toString());
                                    } catch (Throwable th7) {
                                        if (httpsURLConnection != null) {
                                            httpsURLConnection.disconnect();
                                        }
                                        throw th7;
                                    }
                                }
                            } catch (Exception e17) {
                                QLog.e("TeamWorkHttpUtils", 1, "uploadFile in.close() IOException: " + e17);
                                return null;
                            }
                            return null;
                        }
                    }
                    dataOutputStream.write(("\r\n--" + str + "--\r\n").getBytes());
                    try {
                        bufferedInputStream.close();
                        dataOutputStream.flush();
                        dataOutputStream.close();
                    } catch (Exception e18) {
                        QLog.e("TeamWorkHttpUtils", 1, "uploadFile in.close() IOException: " + e18);
                    }
                } catch (IOException e19) {
                    QLog.e("TeamWorkHttpUtils", 1, "uploadFile out.write IOException: " + e19);
                    try {
                        try {
                            dataOutputStream.flush();
                        } catch (IOException e26) {
                            QLog.e("TeamWorkHttpUtils", 1, "uploadFile out.close IOException: " + e26);
                            try {
                                dataOutputStream.close();
                            } catch (Exception e27) {
                                str2 = "uploadFile out.close IOException: " + e27;
                                QLog.e("TeamWorkHttpUtils", 1, str2);
                                httpsURLConnection.disconnect();
                                return null;
                            }
                            httpsURLConnection.disconnect();
                            return null;
                        }
                        try {
                            dataOutputStream.close();
                        } catch (Exception e28) {
                            str2 = "uploadFile out.close IOException: " + e28;
                            QLog.e("TeamWorkHttpUtils", 1, str2);
                            httpsURLConnection.disconnect();
                            return null;
                        }
                        httpsURLConnection.disconnect();
                        return null;
                    } catch (Throwable th8) {
                        try {
                            dataOutputStream.close();
                        } catch (Exception e29) {
                            QLog.e("TeamWorkHttpUtils", 1, "uploadFile out.close IOException: " + e29);
                        }
                        throw th8;
                    }
                }
            }
            int responseCode = httpsURLConnection.getResponseCode();
            if (responseCode != 200) {
                QLog.i("TeamWorkHttpUtils", 1, "--- uploadFile response status: " + responseCode + " ----");
            }
            str3 = e0(new BufferedReader(new InputStreamReader(httpsURLConnection.getInputStream())));
        } catch (Throwable th9) {
            th = th9;
            QLog.e("TeamWorkHttpUtils", 1, "readUploadFileReturnData error, e:" + th.toString());
        }
        httpsURLConnection.disconnect();
        return str3;
    }

    /* JADX WARN: Code restructure failed: missing block: B:40:0x0194, code lost:
    
        if (r12 == null) goto L38;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static String l0(JSONObject jSONObject, Map<String, String> map, HttpsURLConnection httpsURLConnection, String str, File file) {
        String str2 = null;
        try {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                httpsURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
            }
            DataOutputStream dataOutputStream = new DataOutputStream(httpsURLConnection.getOutputStream());
            if (jSONObject != null) {
                StringBuilder sb5 = new StringBuilder();
                Iterator keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String str3 = (String) keys.next();
                    String optString = jSONObject.optString(str3);
                    sb5.append("\r\n");
                    sb5.append("--");
                    sb5.append(str);
                    sb5.append("\r\n");
                    sb5.append("Content-Disposition: form-data; name=\"");
                    sb5.append(str3);
                    sb5.append("\"\r\n\r\n");
                    sb5.append((Object) optString);
                }
                dataOutputStream.write(sb5.toString().getBytes());
            }
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("\r\n");
            stringBuffer.append("--");
            stringBuffer.append(str);
            stringBuffer.append("\r\n");
            stringBuffer.append("Content-Disposition: form-data; name=\"");
            stringBuffer.append("file");
            stringBuffer.append("\"; filename=\"");
            stringBuffer.append(file.getName());
            stringBuffer.append("\";");
            stringBuffer.append("\r\n");
            stringBuffer.append("Content-Type:application/octet-stream\r\n\r\n");
            dataOutputStream.write(stringBuffer.toString().getBytes());
            BufferedInputStream bufferedInputStream = new BufferedInputStream(new BufferedInputStream(new FileInputStream(file)));
            byte[] bArr = new byte[3072];
            while (true) {
                try {
                    try {
                        int read = bufferedInputStream.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        dataOutputStream.write(bArr, 0, read);
                    } catch (OutOfMemoryError unused) {
                        QLog.e("TeamWorkHttpUtils", 1, "teamwork uploadfile OOM: fileSize = " + file.length() + ", name = " + file.getAbsolutePath());
                        dataOutputStream.flush();
                        dataOutputStream.close();
                        httpsURLConnection.disconnect();
                        try {
                            bufferedInputStream.close();
                            return null;
                        } catch (Throwable th5) {
                            th = th5;
                            httpsURLConnection = null;
                            try {
                                QLog.e("TeamWorkHttpUtils", 1, "readUploadFileWithParamReturnData error, e:" + th.toString());
                            } catch (Throwable th6) {
                                if (httpsURLConnection != null) {
                                    httpsURLConnection.disconnect();
                                }
                                throw th6;
                            }
                        }
                    }
                } catch (Throwable th7) {
                    bufferedInputStream.close();
                    throw th7;
                }
            }
            bufferedInputStream.close();
            dataOutputStream.write(("\r\n--" + str + "--\r\n").getBytes());
            dataOutputStream.flush();
            dataOutputStream.close();
            int responseCode = httpsURLConnection.getResponseCode();
            if (responseCode != 200) {
                QLog.i("TeamWorkHttpUtils", 1, "--- uploadFile response status: " + responseCode + " ----");
            }
            str2 = e0(new BufferedReader(new InputStreamReader(httpsURLConnection.getInputStream())));
        } catch (Throwable th8) {
            th = th8;
        }
        httpsURLConnection.disconnect();
        return str2;
    }

    public static void m0(String str, String str2, String str3, IGetExternalInterface.d dVar) {
        n0(str, str2, str3, null, true, dVar);
    }

    /* JADX WARN: Not initialized variable reg: 12, insn: 0x0144: MOVE (r11 I:??[OBJECT, ARRAY]) = (r12 I:??[OBJECT, ARRAY]) (LINE:325), block:B:25:0x0144 */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0147  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void n0(final String str, final String str2, String str3, final String str4, boolean z16, final IGetExternalInterface.d dVar) {
        final HttpsURLConnection httpsURLConnection;
        HttpURLConnection httpURLConnection;
        l lVar;
        HttpURLConnection httpURLConnection2 = null;
        try {
            try {
                c cVar = new c();
                SSLContext sSLContext = SSLContext.getInstance("TLSv1.2");
                sSLContext.init(null, new TrustManager[]{cVar}, null);
                lVar = new l(sSLContext.getSocketFactory());
                HttpsURLConnection.setDefaultSSLSocketFactory(lVar);
                httpsURLConnection = (HttpsURLConnection) new URL(str2).openConnection();
            } catch (Exception e16) {
                e = e16;
                httpsURLConnection = null;
            } catch (OutOfMemoryError e17) {
                e = e17;
                httpsURLConnection = null;
            } catch (Throwable th5) {
                th = th5;
                if (httpURLConnection2 != null) {
                }
                throw th;
            }
            try {
                httpsURLConnection.setSSLSocketFactory(lVar);
                httpsURLConnection.setConnectTimeout(5000);
                httpsURLConnection.setReadTimeout(15000);
                httpsURLConnection.setDoInput(true);
                httpsURLConnection.setUseCaches(false);
                httpsURLConnection.setRequestMethod("GET");
                httpsURLConnection.setRequestProperty("Connection", "Keep-Alive");
                StringBuilder sb5 = new StringBuilder("android");
                sb5.append("_");
                sb5.append(Build.VERSION.SDK);
                sb5.append("_");
                sb5.append(Build.DEVICE);
                sb5.append("_");
                sb5.append(Build.VERSION.RELEASE);
                sb5.append("_");
                String str5 = AppSetting.f99551k;
                sb5.append(str5);
                sb5.append("_");
                sb5.append("QQ/");
                sb5.append(str5 + AppSetting.f99542b);
                httpsURLConnection.setRequestProperty("User-Agent", sb5.toString());
                if (z16) {
                    httpsURLConnection.setRequestProperty("Content-Type", "application/json");
                } else {
                    httpsURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                }
                httpsURLConnection.setRequestProperty("Accept", "*/*");
                httpsURLConnection.setRequestProperty(HttpMsg.CHARSET, "UTF-8");
                final HashMap hashMap = new HashMap();
                hashMap.put("Connection", "keep-alive");
                hashMap.put("Referer", str2);
                ((IGetExternalInterface) QRoute.api(IGetExternalInterface.class)).getPsKey(str3, new IGetExternalInterface.c() { // from class: com.tencent.mobileqq.teamwork.ax
                    @Override // com.tencent.mobileqq.teamwork.api.IGetExternalInterface.c
                    public final void a(String str6) {
                        TeamWorkHttpUtils.N(str2, hashMap, httpsURLConnection, dVar, str, str4, str6);
                    }
                });
            } catch (Exception e18) {
                e = e18;
                QLog.d("TeamWorkHttpUtils", 1, "sendHttpsGet exception: " + e.toString());
                dVar.a(null);
                if (httpsURLConnection == null) {
                    return;
                }
                httpsURLConnection.disconnect();
            } catch (OutOfMemoryError e19) {
                e = e19;
                QLog.d("TeamWorkHttpUtils", 1, "sendHttpsGet error " + e);
                dVar.a(null);
                if (httpsURLConnection == null) {
                    return;
                }
                httpsURLConnection.disconnect();
            }
            httpsURLConnection.disconnect();
        } catch (Throwable th6) {
            th = th6;
            httpURLConnection2 = httpURLConnection;
            if (httpURLConnection2 != null) {
                httpURLConnection2.disconnect();
            }
            throw th;
        }
    }

    public static void o0(String str, String str2, String str3, String str4, IGetExternalInterface.d dVar) {
        p0(str, str2, str3, str4, null, null, false, dVar);
    }

    public static void p0(String str, String str2, String str3, String str4, String str5, Map<String, String> map, boolean z16, IGetExternalInterface.d dVar) {
        t0("POST", str, str2, str3, str4, str5, map, z16, dVar);
    }

    public static void q0(JSONObject jSONObject, String str, String str2, String str3, IGetExternalInterface.d dVar) {
        p0(jSONObject.toString(), str, str2, str3, null, null, true, dVar);
    }

    public static void r0(JSONObject jSONObject, String str, String str2, String str3, String str4, IGetExternalInterface.d dVar) {
        p0(jSONObject.toString(), str, str2, str3, str4, null, true, dVar);
    }

    public static void s0(String str, String str2, String str3, String str4, IGetExternalInterface.d dVar) {
        t0(HttpPut.METHOD_NAME, str, str2, str3, str4, null, null, false, dVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0150  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void t0(String str, final String str2, final String str3, final String str4, String str5, final String str6, Map<String, String> map, boolean z16, final IGetExternalInterface.d dVar) {
        final HttpsURLConnection httpsURLConnection;
        l lVar;
        HttpsURLConnection httpsURLConnection2 = null;
        try {
            c cVar = new c();
            SSLContext sSLContext = SSLContext.getInstance("TLSv1.2");
            sSLContext.init(null, new TrustManager[]{cVar}, null);
            lVar = new l(sSLContext.getSocketFactory());
            HttpsURLConnection.setDefaultSSLSocketFactory(lVar);
            httpsURLConnection = (HttpsURLConnection) new URL(str4).openConnection();
        } catch (Exception e16) {
            e = e16;
            httpsURLConnection = null;
        } catch (Throwable th5) {
            th = th5;
            if (httpsURLConnection2 != null) {
            }
            throw th;
        }
        try {
            try {
                httpsURLConnection.setSSLSocketFactory(lVar);
                httpsURLConnection.setConnectTimeout(5000);
                httpsURLConnection.setReadTimeout(30000);
                httpsURLConnection.setDoOutput(true);
                httpsURLConnection.setDoInput(true);
                httpsURLConnection.setUseCaches(false);
                httpsURLConnection.setRequestMethod(str);
                httpsURLConnection.setRequestProperty("Connection", "Keep-Alive");
                StringBuilder sb5 = new StringBuilder("android");
                sb5.append("_");
                sb5.append(Build.VERSION.SDK);
                sb5.append("_");
                sb5.append(Build.DEVICE);
                sb5.append("_");
                sb5.append(Build.VERSION.RELEASE);
                sb5.append("_");
                String str7 = AppSetting.f99551k;
                sb5.append(str7);
                sb5.append("_");
                sb5.append("QQ/");
                sb5.append(str7 + AppSetting.f99542b);
                httpsURLConnection.setRequestProperty("User-Agent", sb5.toString());
                if (z16) {
                    httpsURLConnection.setRequestProperty("Content-Type", "application/json");
                } else {
                    httpsURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                }
                httpsURLConnection.setRequestProperty("Accept", "*/*");
                httpsURLConnection.setRequestProperty(HttpMsg.CHARSET, "UTF-8");
                if (map != null) {
                    for (Map.Entry<String, String> entry : map.entrySet()) {
                        httpsURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
                    }
                }
                final HashMap hashMap = new HashMap();
                hashMap.put("Connection", "keep-alive");
                hashMap.put("Referer", str4);
                ((IGetExternalInterface) QRoute.api(IGetExternalInterface.class)).getPsKey(str5, new IGetExternalInterface.c() { // from class: com.tencent.mobileqq.teamwork.ay
                    @Override // com.tencent.mobileqq.teamwork.api.IGetExternalInterface.c
                    public final void a(String str8) {
                        TeamWorkHttpUtils.Q(str4, hashMap, httpsURLConnection, str2, dVar, str3, str6, str8);
                    }
                });
            } catch (Throwable th6) {
                th = th6;
                httpsURLConnection2 = httpsURLConnection;
                if (httpsURLConnection2 != null) {
                    httpsURLConnection2.disconnect();
                }
                throw th;
            }
        } catch (Exception e17) {
            e = e17;
            QLog.d("TeamWorkHttpUtils", 1, "sendHttpsGet exception: " + e.toString());
            dVar.a(null);
            if (httpsURLConnection == null) {
                return;
            }
            httpsURLConnection.disconnect();
        }
        httpsURLConnection.disconnect();
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x01b8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void u0(final TeamWorkFileImportInfo teamWorkFileImportInfo, final String str, final IGetExternalInterface.d dVar) {
        HttpsURLConnection httpsURLConnection;
        final HttpsURLConnection httpsURLConnection2;
        l lVar;
        if (teamWorkFileImportInfo != null && !TextUtils.isEmpty(teamWorkFileImportInfo.f292077h) && !TextUtils.isEmpty(str)) {
            final String str2 = teamWorkFileImportInfo.f292077h;
            StringBuilder sb5 = new StringBuilder();
            final File file = new File(str2);
            if (file.exists()) {
                try {
                    String A = A(str2);
                    sb5.append("https://");
                    sb5.append("qqandroid.docs.qq.com/ep/pad/impexp/import_office");
                    sb5.append("?uniquefileid=");
                    sb5.append(A);
                    sb5.append("&file_name=");
                    sb5.append(URLEncoder.encode(file.getName(), "UTF-8"));
                    sb5.append("&import_type=2");
                    sb5.append("&browse=1");
                    sb5.append("&fileid=");
                    String str3 = teamWorkFileImportInfo.f292067a0;
                    if (str3 != null) {
                        A = str3;
                    }
                    sb5.append(A);
                    sb5.append("&filetype=");
                    sb5.append(teamWorkFileImportInfo.f292068b0);
                    sb5.append("&importoption=");
                    sb5.append(teamWorkFileImportInfo.Y);
                    final String sb6 = sb5.toString();
                    final String str4 = "---------------------------123821742118716";
                    try {
                        try {
                            c cVar = new c();
                            SSLContext sSLContext = SSLContext.getInstance("TLSv1.2");
                            sSLContext.init(null, new TrustManager[]{cVar}, null);
                            lVar = new l(sSLContext.getSocketFactory());
                            HttpsURLConnection.setDefaultSSLSocketFactory(lVar);
                            httpsURLConnection2 = (HttpsURLConnection) new URL(sb6).openConnection();
                        } catch (Exception e16) {
                            e = e16;
                            httpsURLConnection2 = null;
                        } catch (Throwable th5) {
                            th = th5;
                            httpsURLConnection = null;
                            if (httpsURLConnection != null) {
                            }
                            throw th;
                        }
                        try {
                            httpsURLConnection2.setSSLSocketFactory(lVar);
                            httpsURLConnection2.setConnectTimeout(5000);
                            httpsURLConnection2.setReadTimeout(30000);
                            httpsURLConnection2.setDoOutput(true);
                            httpsURLConnection2.setDoInput(true);
                            httpsURLConnection2.setUseCaches(false);
                            httpsURLConnection2.setRequestMethod("POST");
                            httpsURLConnection2.setRequestProperty("Connection", "Keep-Alive");
                            StringBuilder sb7 = new StringBuilder("android");
                            sb7.append("_");
                            sb7.append(Build.VERSION.SDK);
                            sb7.append("_");
                            sb7.append(Build.DEVICE);
                            sb7.append("_");
                            sb7.append(Build.VERSION.RELEASE);
                            sb7.append("_");
                            String str5 = AppSetting.f99551k;
                            sb7.append(str5);
                            sb7.append("_");
                            sb7.append("QQ/");
                            sb7.append(str5 + AppSetting.f99542b);
                            httpsURLConnection2.setRequestProperty("User-Agent", sb7.toString());
                            httpsURLConnection2.setRequestProperty("Accept", "*/*");
                            httpsURLConnection2.setRequestProperty("Content-Type", "multipart/form-data; boundary=---------------------------123821742118716");
                            final HashMap hashMap = new HashMap();
                            hashMap.put("Connection", "keep-alive");
                            hashMap.put("Referer", sb6);
                            ((IGetExternalInterface) QRoute.api(IGetExternalInterface.class)).getPsKey(ITeamWorkHandler.DOCS_DOMAIN, new IGetExternalInterface.c() { // from class: com.tencent.mobileqq.teamwork.bb
                                @Override // com.tencent.mobileqq.teamwork.api.IGetExternalInterface.c
                                public final void a(String str6) {
                                    TeamWorkHttpUtils.S(sb6, hashMap, httpsURLConnection2, teamWorkFileImportInfo, str4, file, dVar, str, str2, str6);
                                }
                            });
                        } catch (Exception e17) {
                            e = e17;
                            QLog.d("TAG", 1, " teamwork uploadfile exception: " + e.toString());
                            dVar.a(null);
                            if (httpsURLConnection2 == null) {
                                return;
                            }
                            httpsURLConnection2.disconnect();
                            return;
                        }
                        httpsURLConnection2.disconnect();
                        return;
                    } catch (Throwable th6) {
                        th = th6;
                        httpsURLConnection = httpsURLConnection2;
                        if (httpsURLConnection != null) {
                            httpsURLConnection.disconnect();
                        }
                        throw th;
                    }
                } catch (Exception e18) {
                    QLog.e("TeamWorkHttpUtils", 1, "--- uploadFile URL encode exp: " + e18.toString());
                    dVar.a(null);
                    return;
                }
            }
            QLog.e("TeamWorkHttpUtils", 1, "--- uploadFile file not exist ---");
            dVar.a(null);
            return;
        }
        QLog.e("TeamWorkHttpUtils", 1, "--- uploadFile filePath is null or uin is null --- ");
        dVar.a(null);
    }

    public static boolean v0(File file, String str) {
        DataOutputStream dataOutputStream;
        FileInputStream fileInputStream;
        Throwable th5;
        HttpURLConnection httpURLConnection;
        boolean z16 = false;
        try {
            httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            try {
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setRequestMethod(HttpPut.METHOD_NAME);
                httpURLConnection.setRequestProperty("Content-Type", "application/octet-stream");
                httpURLConnection.setRequestProperty("Content-Length", String.valueOf(file.length()));
                dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
                try {
                    fileInputStream = new FileInputStream(file);
                    try {
                        byte[] bArr = new byte[1024];
                        while (true) {
                            int read = fileInputStream.read(bArr);
                            if (read == -1) {
                                break;
                            }
                            dataOutputStream.write(bArr, 0, read);
                        }
                        dataOutputStream.flush();
                        int responseCode = httpURLConnection.getResponseCode();
                        QLog.i("TeamWorkHttpUtils", 1, "[uploadFile2Cos] code:" + responseCode);
                        if (responseCode == 200) {
                            z16 = true;
                        }
                        try {
                            dataOutputStream.close();
                            fileInputStream.close();
                            httpURLConnection.disconnect();
                        } catch (Throwable th6) {
                            th6.printStackTrace();
                        }
                        return z16;
                    } catch (Throwable th7) {
                        th5 = th7;
                        try {
                            QLog.e("TeamWorkHttpUtils", 1, "[uploadFile2Cos] error, filePath:" + file.getAbsolutePath(), th5);
                            if (dataOutputStream != null) {
                                try {
                                } catch (Throwable th8) {
                                    return false;
                                }
                            }
                            return false;
                        } finally {
                            if (dataOutputStream != null) {
                                try {
                                    dataOutputStream.close();
                                } catch (Throwable th82) {
                                    th82.printStackTrace();
                                }
                            }
                            if (fileInputStream != null) {
                                fileInputStream.close();
                            }
                            if (httpURLConnection != null) {
                                httpURLConnection.disconnect();
                            }
                        }
                    }
                } catch (Throwable th9) {
                    fileInputStream = null;
                    th5 = th9;
                }
            } catch (Throwable th10) {
                fileInputStream = null;
                th5 = th10;
                dataOutputStream = null;
            }
        } catch (Throwable th11) {
            dataOutputStream = null;
            fileInputStream = null;
            th5 = th11;
            httpURLConnection = null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0174  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void w0(final TeamWorkFileImportInfo teamWorkFileImportInfo, final String str, final IGetExternalInterface.d dVar) {
        HttpsURLConnection httpsURLConnection;
        final HttpsURLConnection httpsURLConnection2;
        l lVar;
        if (!TextUtils.isEmpty(teamWorkFileImportInfo.f292077h) && !TextUtils.isEmpty(str)) {
            StringBuilder sb5 = new StringBuilder();
            final File file = new File(teamWorkFileImportInfo.f292077h);
            String str2 = teamWorkFileImportInfo.S;
            if (file.exists()) {
                try {
                    sb5.append("https://");
                    sb5.append(t.f292410o);
                    if (!TextUtils.isEmpty(str2)) {
                        sb5.append("?folderId=");
                        sb5.append(str2);
                    }
                    final String sb6 = sb5.toString();
                    final String str3 = "---------------------------123821742118716";
                    try {
                        try {
                            c cVar = new c();
                            SSLContext sSLContext = SSLContext.getInstance("TLSv1.2");
                            sSLContext.init(null, new TrustManager[]{cVar}, null);
                            lVar = new l(sSLContext.getSocketFactory());
                            HttpsURLConnection.setDefaultSSLSocketFactory(lVar);
                            httpsURLConnection2 = (HttpsURLConnection) new URL(sb6).openConnection();
                        } catch (Exception e16) {
                            e = e16;
                            httpsURLConnection2 = null;
                        } catch (Throwable th5) {
                            th = th5;
                            httpsURLConnection = null;
                            if (httpsURLConnection != null) {
                            }
                            throw th;
                        }
                        try {
                            httpsURLConnection2.setSSLSocketFactory(lVar);
                            httpsURLConnection2.setConnectTimeout(5000);
                            httpsURLConnection2.setReadTimeout(30000);
                            httpsURLConnection2.setDoOutput(true);
                            httpsURLConnection2.setDoInput(true);
                            httpsURLConnection2.setUseCaches(false);
                            httpsURLConnection2.setRequestMethod("POST");
                            httpsURLConnection2.setRequestProperty("Connection", "Keep-Alive");
                            StringBuilder sb7 = new StringBuilder("android");
                            sb7.append("_");
                            sb7.append(Build.VERSION.SDK);
                            sb7.append("_");
                            sb7.append(Build.DEVICE);
                            sb7.append("_");
                            sb7.append(Build.VERSION.RELEASE);
                            sb7.append("_");
                            String str4 = AppSetting.f99551k;
                            sb7.append(str4);
                            sb7.append("_");
                            sb7.append("QQ/");
                            sb7.append(str4 + AppSetting.f99542b);
                            httpsURLConnection2.setRequestProperty("User-Agent", sb7.toString());
                            httpsURLConnection2.setRequestProperty("Accept", "*/*");
                            httpsURLConnection2.setRequestProperty("Content-Type", "multipart/form-data; boundary=---------------------------123821742118716");
                            final HashMap hashMap = new HashMap();
                            hashMap.put("Connection", "keep-alive");
                            hashMap.put("Referer", sb6);
                            ((IGetExternalInterface) QRoute.api(IGetExternalInterface.class)).getPsKey(ITeamWorkHandler.DOCS_DOMAIN, new IGetExternalInterface.c() { // from class: com.tencent.mobileqq.teamwork.bd
                                @Override // com.tencent.mobileqq.teamwork.api.IGetExternalInterface.c
                                public final void a(String str5) {
                                    TeamWorkHttpUtils.U(sb6, hashMap, httpsURLConnection2, str3, file, dVar, str, teamWorkFileImportInfo, str5);
                                }
                            });
                        } catch (Exception e17) {
                            e = e17;
                            QLog.d("TAG", 1, " teamwork uploadfile exception: " + e.toString());
                            dVar.a(null);
                            if (httpsURLConnection2 == null) {
                                return;
                            }
                            httpsURLConnection2.disconnect();
                            return;
                        }
                        httpsURLConnection2.disconnect();
                        return;
                    } catch (Throwable th6) {
                        th = th6;
                        httpsURLConnection = httpsURLConnection2;
                        if (httpsURLConnection != null) {
                            httpsURLConnection.disconnect();
                        }
                        throw th;
                    }
                } catch (Exception e18) {
                    QLog.e("TeamWorkHttpUtils", 1, "--- uploadFile URL encode exp: " + e18.toString());
                    dVar.a(null);
                    return;
                }
            }
            QLog.e("TeamWorkHttpUtils", 1, "--- uploadFile file not exist ---");
            dVar.a(null);
            return;
        }
        QLog.e("TeamWorkHttpUtils", 1, "--- uploadFile filePath is null or uin is null ---");
        dVar.a(null);
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x014e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void x(String str, final String str2, final IGetExternalInterface.d dVar) {
        final HttpsURLConnection httpsURLConnection;
        l lVar;
        HttpsURLConnection httpsURLConnection2 = null;
        if (TextUtils.isEmpty(str)) {
            QLog.e("TeamWorkHttpUtils", 1, "--- uniqueFileId is Empty ---");
            dVar.a(null);
            return;
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("https://");
        sb5.append(".qqandroid.docs.qq.com/preview/imp/query?uniquefileid=" + str);
        final String sb6 = sb5.toString();
        try {
            c cVar = new c();
            SSLContext sSLContext = SSLContext.getInstance("TLSv1.2");
            sSLContext.init(null, new TrustManager[]{cVar}, null);
            lVar = new l(sSLContext.getSocketFactory());
            HttpsURLConnection.setDefaultSSLSocketFactory(lVar);
            httpsURLConnection = (HttpsURLConnection) new URL(sb6).openConnection();
        } catch (Exception e16) {
            e = e16;
            httpsURLConnection = null;
        } catch (Throwable th5) {
            th = th5;
            if (httpsURLConnection2 != null) {
            }
            throw th;
        }
        try {
            try {
                httpsURLConnection.setSSLSocketFactory(lVar);
                httpsURLConnection.setConnectTimeout(5000);
                httpsURLConnection.setReadTimeout(30000);
                httpsURLConnection.setDoOutput(true);
                httpsURLConnection.setDoInput(true);
                httpsURLConnection.setUseCaches(false);
                httpsURLConnection.setRequestMethod("GET");
                httpsURLConnection.setRequestProperty("Connection", "Keep-Alive");
                StringBuilder sb7 = new StringBuilder("android");
                sb7.append("_");
                sb7.append(Build.VERSION.SDK);
                sb7.append("_");
                sb7.append(Build.DEVICE);
                sb7.append("_");
                sb7.append(Build.VERSION.RELEASE);
                sb7.append("_");
                String str3 = AppSetting.f99551k;
                sb7.append(str3);
                sb7.append("_");
                sb7.append("QQ/");
                sb7.append(str3 + AppSetting.f99542b);
                httpsURLConnection.setRequestProperty("User-Agent", sb7.toString());
                httpsURLConnection.setRequestProperty("Content-Type", "application/json");
                httpsURLConnection.setRequestProperty("Accept", "*/*");
                httpsURLConnection.setRequestProperty(HttpMsg.CHARSET, "UTF-8");
                final HashMap hashMap = new HashMap();
                hashMap.put("Connection", "keep-alive");
                hashMap.put("Referer", sb6);
                ((IGetExternalInterface) QRoute.api(IGetExternalInterface.class)).getPsKey(ITeamWorkHandler.DOCS_DOMAIN, new IGetExternalInterface.c() { // from class: com.tencent.mobileqq.teamwork.ba
                    @Override // com.tencent.mobileqq.teamwork.api.IGetExternalInterface.c
                    public final void a(String str4) {
                        TeamWorkHttpUtils.F(sb6, hashMap, httpsURLConnection, dVar, str2, str4);
                    }
                });
            } catch (Throwable th6) {
                th = th6;
                httpsURLConnection2 = httpsURLConnection;
                if (httpsURLConnection2 != null) {
                    httpsURLConnection2.disconnect();
                }
                throw th;
            }
        } catch (Exception e17) {
            e = e17;
            QLog.d("teamwork", 1, "teamwork uploadFileInfo exception: " + e.toString());
            dVar.a(null);
            if (httpsURLConnection == null) {
                return;
            }
            httpsURLConnection.disconnect();
        }
        httpsURLConnection.disconnect();
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0148  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void x0(final JSONObject jSONObject, final String str, AppInterface appInterface, final IGetExternalInterface.d dVar) {
        final HttpsURLConnection httpsURLConnection;
        l lVar;
        HttpsURLConnection httpsURLConnection2 = null;
        if (jSONObject != null && !TextUtils.isEmpty(str) && appInterface != null) {
            final String str2 = "https://qqandroid.docs.qq.com/ep/pad/impexp/import_office" + ThemeConstants.THEME_DIY_BG_URL_SUFFIX;
            try {
                try {
                    c cVar = new c();
                    SSLContext sSLContext = SSLContext.getInstance("TLSv1.2");
                    sSLContext.init(null, new TrustManager[]{cVar}, null);
                    lVar = new l(sSLContext.getSocketFactory());
                    HttpsURLConnection.setDefaultSSLSocketFactory(lVar);
                    httpsURLConnection = (HttpsURLConnection) new URL(str2).openConnection();
                } catch (Exception e16) {
                    e = e16;
                    httpsURLConnection = null;
                } catch (Throwable th5) {
                    th = th5;
                    if (httpsURLConnection2 != null) {
                    }
                    throw th;
                }
                try {
                    httpsURLConnection.setSSLSocketFactory(lVar);
                    httpsURLConnection.setConnectTimeout(5000);
                    httpsURLConnection.setReadTimeout(30000);
                    httpsURLConnection.setDoOutput(true);
                    httpsURLConnection.setDoInput(true);
                    httpsURLConnection.setUseCaches(false);
                    httpsURLConnection.setRequestMethod("POST");
                    httpsURLConnection.setRequestProperty("Connection", "Keep-Alive");
                    StringBuilder sb5 = new StringBuilder("android");
                    sb5.append("_");
                    sb5.append(Build.VERSION.SDK);
                    sb5.append("_");
                    sb5.append(Build.DEVICE);
                    sb5.append("_");
                    sb5.append(Build.VERSION.RELEASE);
                    sb5.append("_");
                    String str3 = AppSetting.f99551k;
                    sb5.append(str3);
                    sb5.append("_");
                    sb5.append("QQ/");
                    sb5.append(str3 + AppSetting.f99542b);
                    httpsURLConnection.setRequestProperty("User-Agent", sb5.toString());
                    httpsURLConnection.setRequestProperty("Content-Type", "application/json");
                    httpsURLConnection.setRequestProperty("Accept", "*/*");
                    httpsURLConnection.setRequestProperty(HttpMsg.CHARSET, "UTF-8");
                    final HashMap hashMap = new HashMap();
                    hashMap.put("Connection", "keep-alive");
                    hashMap.put("Referer", str2);
                    ((IGetExternalInterface) QRoute.api(IGetExternalInterface.class)).getPsKey(ITeamWorkHandler.DOCS_DOMAIN, new IGetExternalInterface.c() { // from class: com.tencent.mobileqq.teamwork.as
                        @Override // com.tencent.mobileqq.teamwork.api.IGetExternalInterface.c
                        public final void a(String str4) {
                            TeamWorkHttpUtils.W(str2, hashMap, httpsURLConnection, jSONObject, dVar, str, str4);
                        }
                    });
                } catch (Exception e17) {
                    e = e17;
                    QLog.d("TeamWorkHttpUtils", 1, "teamwork uploadFileInfo exception: " + e.toString());
                    dVar.a(null);
                    if (httpsURLConnection == null) {
                        return;
                    }
                    httpsURLConnection.disconnect();
                    return;
                }
                httpsURLConnection.disconnect();
                return;
            } catch (Throwable th6) {
                th = th6;
                httpsURLConnection2 = httpsURLConnection;
                if (httpsURLConnection2 != null) {
                    httpsURLConnection2.disconnect();
                }
                throw th;
            }
        }
        QLog.e("TeamWorkHttpUtils", 1, "--- uploadFileInfo jsonParam is null or uin is null --- app = " + appInterface);
        dVar.a(null);
    }

    public static void y(AppInterface appInterface, String str, final String str2, final String str3, final String str4, String str5) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str5) && appInterface != null) {
            final ITeamWorkFileExportHandler iTeamWorkFileExportHandler = (ITeamWorkFileExportHandler) appInterface.getBusinessHandler(((ITeamWorkFacadeCreator) QRoute.api(ITeamWorkFacadeCreator.class)).getExportHandlerName());
            final String str6 = str;
            final HttpsURLConnection httpsURLConnection = null;
            try {
                try {
                    c cVar = new c();
                    SSLContext sSLContext = SSLContext.getInstance("TLSv1.2");
                    sSLContext.init(null, new TrustManager[]{cVar}, null);
                    l lVar = new l(sSLContext.getSocketFactory());
                    HttpsURLConnection.setDefaultSSLSocketFactory(lVar);
                    HttpsURLConnection httpsURLConnection2 = (HttpsURLConnection) new URL(str6).openConnection();
                    try {
                        httpsURLConnection2.setSSLSocketFactory(lVar);
                        httpsURLConnection2.setConnectTimeout(5000);
                        httpsURLConnection2.setReadTimeout(30000);
                        httpsURLConnection2.setDoInput(true);
                        httpsURLConnection2.setUseCaches(false);
                        httpsURLConnection2.setRequestMethod("GET");
                        httpsURLConnection2.setRequestProperty("Connection", "Keep-Alive");
                        StringBuilder sb5 = new StringBuilder("android");
                        sb5.append("_");
                        sb5.append(Build.VERSION.SDK);
                        sb5.append("_");
                        sb5.append(Build.DEVICE);
                        sb5.append("_");
                        sb5.append(Build.VERSION.RELEASE);
                        sb5.append("_");
                        String str7 = AppSetting.f99551k;
                        sb5.append(str7);
                        sb5.append("_");
                        sb5.append("QQ/");
                        sb5.append(str7 + AppSetting.f99542b);
                        httpsURLConnection2.setRequestProperty("User-Agent", sb5.toString());
                        httpsURLConnection2.setRequestProperty("Accept", "*/*");
                        httpsURLConnection2.setRequestProperty("Content-Type", "multipart/form-data; boundary=---------------------------123821742118716");
                        final HashMap hashMap = new HashMap();
                        hashMap.put("Connection", "keep-alive");
                        hashMap.put("Referer", str3);
                        httpsURLConnection = httpsURLConnection2;
                        ((IGetExternalInterface) QRoute.api(IGetExternalInterface.class)).getPsKey(ITeamWorkHandler.DOCS_DOMAIN, new IGetExternalInterface.c() { // from class: com.tencent.mobileqq.teamwork.ap
                            @Override // com.tencent.mobileqq.teamwork.api.IGetExternalInterface.c
                            public final void a(String str8) {
                                TeamWorkHttpUtils.G(str6, hashMap, str4, httpsURLConnection, iTeamWorkFileExportHandler, str3, str2, str8);
                            }
                        });
                        httpsURLConnection2.disconnect();
                    } catch (Exception e16) {
                        e = e16;
                        httpsURLConnection = httpsURLConnection2;
                        QLog.d("TAG", 1, " teamwork exportFile exception: " + e.toString());
                        iTeamWorkFileExportHandler.notifyUI(1, true, new Object[]{HardCodeUtil.qqStr(R.string.u0h), str3});
                        if (httpsURLConnection != null) {
                            httpsURLConnection.disconnect();
                        }
                    } catch (Throwable th5) {
                        th = th5;
                        httpsURLConnection = httpsURLConnection2;
                        if (httpsURLConnection != null) {
                            httpsURLConnection.disconnect();
                        }
                        throw th;
                    }
                } catch (Exception e17) {
                    e = e17;
                }
            } catch (Throwable th6) {
                th = th6;
            }
        } else {
            QLog.e("TeamWorkHttpUtils", 1, "--- downloadFile fileUrl is null or uin is null --- fileUrl = " + str + " uin = " + str5 + " app = " + appInterface);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x014e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void y0(final JSONObject jSONObject, TeamWorkFileImportInfo teamWorkFileImportInfo, final String str, final IGetExternalInterface.d dVar) {
        final HttpsURLConnection httpsURLConnection;
        l lVar;
        HttpsURLConnection httpsURLConnection2 = null;
        if (jSONObject != null && !TextUtils.isEmpty(str)) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("https://");
            sb5.append(t.f292411p);
            String str2 = teamWorkFileImportInfo.S;
            if (!TextUtils.isEmpty(str2)) {
                sb5.append("?folderId=");
                sb5.append(str2);
            }
            final String sb6 = sb5.toString();
            try {
                try {
                    c cVar = new c();
                    SSLContext sSLContext = SSLContext.getInstance("TLSv1.2");
                    sSLContext.init(null, new TrustManager[]{cVar}, null);
                    lVar = new l(sSLContext.getSocketFactory());
                    HttpsURLConnection.setDefaultSSLSocketFactory(lVar);
                    httpsURLConnection = (HttpsURLConnection) new URL(sb6).openConnection();
                } catch (Exception e16) {
                    e = e16;
                    httpsURLConnection = null;
                } catch (Throwable th5) {
                    th = th5;
                    if (httpsURLConnection2 != null) {
                    }
                    throw th;
                }
                try {
                    httpsURLConnection.setSSLSocketFactory(lVar);
                    httpsURLConnection.setConnectTimeout(5000);
                    httpsURLConnection.setReadTimeout(30000);
                    httpsURLConnection.setDoOutput(true);
                    httpsURLConnection.setDoInput(true);
                    httpsURLConnection.setUseCaches(false);
                    httpsURLConnection.setRequestMethod("POST");
                    httpsURLConnection.setRequestProperty("Connection", "Keep-Alive");
                    StringBuilder sb7 = new StringBuilder("android");
                    sb7.append("_");
                    sb7.append(Build.VERSION.SDK);
                    sb7.append("_");
                    sb7.append(Build.DEVICE);
                    sb7.append("_");
                    sb7.append(Build.VERSION.RELEASE);
                    sb7.append("_");
                    String str3 = AppSetting.f99551k;
                    sb7.append(str3);
                    sb7.append("_");
                    sb7.append("QQ/");
                    sb7.append(str3 + AppSetting.f99542b);
                    httpsURLConnection.setRequestProperty("User-Agent", sb7.toString());
                    httpsURLConnection.setRequestProperty("Content-Type", "application/json");
                    httpsURLConnection.setRequestProperty("Accept", "*/*");
                    httpsURLConnection.setRequestProperty(HttpMsg.CHARSET, "UTF-8");
                    final HashMap hashMap = new HashMap();
                    hashMap.put("Connection", "keep-alive");
                    hashMap.put("Referer", sb6);
                    ((IGetExternalInterface) QRoute.api(IGetExternalInterface.class)).getPsKey(ITeamWorkHandler.DOCS_DOMAIN, new IGetExternalInterface.c() { // from class: com.tencent.mobileqq.teamwork.bc
                        @Override // com.tencent.mobileqq.teamwork.api.IGetExternalInterface.c
                        public final void a(String str4) {
                            TeamWorkHttpUtils.Y(sb6, hashMap, httpsURLConnection, jSONObject, dVar, str, str4);
                        }
                    });
                } catch (Exception e17) {
                    e = e17;
                    QLog.d("TeamWorkHttpUtils", 1, "teamwork uploadFileInfo exception: " + e.toString());
                    dVar.a(null);
                    if (httpsURLConnection == null) {
                        return;
                    }
                    httpsURLConnection.disconnect();
                    return;
                }
                httpsURLConnection.disconnect();
                return;
            } catch (Throwable th6) {
                th = th6;
                httpsURLConnection2 = httpsURLConnection;
                if (httpsURLConnection2 != null) {
                    httpsURLConnection2.disconnect();
                }
                throw th;
            }
        }
        QLog.e("TeamWorkHttpUtils", 1, "--- uploadFileInfo jsonParam is null or uin is null ---");
        dVar.a(null);
    }

    private static void z(final String str, final String str2, final IGetExternalInterface.b bVar) {
        LoginTicketManager.g().f(new IGetExternalInterface.d() { // from class: com.tencent.mobileqq.teamwork.at
            @Override // com.tencent.mobileqq.teamwork.api.IGetExternalInterface.d
            public final void a(Object obj) {
                TeamWorkHttpUtils.H(str2, str, bVar, obj);
            }
        });
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0158  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void z0(final JSONObject jSONObject, final String str, String str2, final String str3, final IGetExternalInterface.d dVar) {
        HttpsURLConnection httpsURLConnection;
        final HttpsURLConnection httpsURLConnection2;
        l lVar;
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str3)) {
            StringBuilder sb5 = new StringBuilder();
            final File file = new File(str);
            if (file.exists()) {
                try {
                    sb5.append(str2);
                    final String sb6 = sb5.toString();
                    final String str4 = "---------------------------123821742118716";
                    try {
                        try {
                            c cVar = new c();
                            SSLContext sSLContext = SSLContext.getInstance("TLSv1.2");
                            sSLContext.init(null, new TrustManager[]{cVar}, null);
                            lVar = new l(sSLContext.getSocketFactory());
                            HttpsURLConnection.setDefaultSSLSocketFactory(lVar);
                            httpsURLConnection2 = (HttpsURLConnection) new URL(sb6).openConnection();
                        } catch (Exception e16) {
                            e = e16;
                            httpsURLConnection2 = null;
                        } catch (Throwable th5) {
                            th = th5;
                            httpsURLConnection = null;
                            if (httpsURLConnection != null) {
                            }
                            throw th;
                        }
                        try {
                            httpsURLConnection2.setSSLSocketFactory(lVar);
                            httpsURLConnection2.setConnectTimeout(5000);
                            httpsURLConnection2.setReadTimeout(30000);
                            httpsURLConnection2.setDoOutput(true);
                            httpsURLConnection2.setDoInput(true);
                            httpsURLConnection2.setUseCaches(false);
                            httpsURLConnection2.setRequestMethod("POST");
                            httpsURLConnection2.setRequestProperty("Connection", "Keep-Alive");
                            StringBuilder sb7 = new StringBuilder("android");
                            sb7.append("_");
                            sb7.append(Build.VERSION.SDK);
                            sb7.append("_");
                            sb7.append(Build.DEVICE);
                            sb7.append("_");
                            sb7.append(Build.VERSION.RELEASE);
                            sb7.append("_");
                            String str5 = AppSetting.f99551k;
                            sb7.append(str5);
                            sb7.append("_");
                            sb7.append("QQ/");
                            sb7.append(str5 + AppSetting.f99542b);
                            httpsURLConnection2.setRequestProperty("User-Agent", sb7.toString());
                            httpsURLConnection2.setRequestProperty("Accept", "*/*");
                            httpsURLConnection2.setRequestProperty("Content-Type", "multipart/form-data; boundary=---------------------------123821742118716");
                            final HashMap hashMap = new HashMap();
                            hashMap.put("Connection", "keep-alive");
                            hashMap.put("Referer", sb6);
                            ((IGetExternalInterface) QRoute.api(IGetExternalInterface.class)).getPsKey(ITeamWorkHandler.DOCS_DOMAIN, new IGetExternalInterface.c() { // from class: com.tencent.mobileqq.teamwork.ah
                                @Override // com.tencent.mobileqq.teamwork.api.IGetExternalInterface.c
                                public final void a(String str6) {
                                    TeamWorkHttpUtils.a0(sb6, hashMap, jSONObject, httpsURLConnection2, str4, file, dVar, str3, str, str6);
                                }
                            });
                        } catch (Exception e17) {
                            e = e17;
                            QLog.d("TAG", 1, " teamwork uploadfile exception: " + e.toString());
                            dVar.a(null);
                            if (httpsURLConnection2 == null) {
                                return;
                            }
                            httpsURLConnection2.disconnect();
                            return;
                        }
                        httpsURLConnection2.disconnect();
                        return;
                    } catch (Throwable th6) {
                        th = th6;
                        httpsURLConnection = httpsURLConnection2;
                        if (httpsURLConnection != null) {
                            httpsURLConnection.disconnect();
                        }
                        throw th;
                    }
                } catch (Exception e18) {
                    QLog.e("TeamWorkHttpUtils", 1, "--- uploadFile URL encode exp: " + e18.toString());
                    dVar.a(null);
                    return;
                }
            }
            QLog.e("TeamWorkHttpUtils", 1, "--- uploadFile file not exist ---");
            dVar.a(null);
            return;
        }
        QLog.e("TeamWorkHttpUtils", 1, "--- uploadFile filePath is null or uin is null --- ");
        dVar.a(null);
    }
}
