package com.tencent.biz.qqcircle.utils;

import android.os.Build;
import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserCookieMonster;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes5.dex */
public class bu {

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public interface a {
        void a(String str, String str2, boolean z16, int i3, String str3);
    }

    public static void c(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e16) {
                QLog.e("QFSHttpsUtil", 1, "closeIgnoreException IOException : " + e16.getMessage());
            }
        }
    }

    public static String d(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            return SwiftBrowserCookieMonster.r(str);
        } catch (Throwable th5) {
            QLog.e("QFSHttpsUtil", 1, "getCookie error:" + th5.getMessage());
            return "";
        }
    }

    public static int e(String str) {
        String f16 = f(str);
        int i3 = 5381;
        if (TextUtils.isEmpty(f16)) {
            return 5381;
        }
        int length = f16.length();
        for (int i16 = 0; i16 < length; i16++) {
            i3 += (i3 << 5) + f16.charAt(i16);
        }
        return Integer.MAX_VALUE & i3;
    }

    public static String f(String str) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str) && str.contains("p_skey")) {
            for (String str2 : str.split(";")) {
                if (!TextUtils.isEmpty(str2) && str2.contains("p_skey")) {
                    return str2.substring(str2.indexOf(ContainerUtils.KEY_VALUE_DELIMITER) + 1, str2.length());
                }
            }
        }
        return "";
    }

    public static String g() {
        StringBuilder sb5 = new StringBuilder();
        sb5.append("android_");
        sb5.append(Build.VERSION.SDK);
        sb5.append("_");
        sb5.append(Build.DEVICE);
        sb5.append("_");
        sb5.append(Build.VERSION.RELEASE);
        sb5.append("_");
        String str = AppSetting.f99551k;
        sb5.append(str);
        sb5.append("_QQ/");
        sb5.append(str);
        sb5.append(AppSetting.f99542b);
        return sb5.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:29:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0142  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0147  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0124  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0129  */
    /* JADX WARN: Removed duplicated region for block: B:78:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r9v1 */
    /* JADX WARN: Type inference failed for: r9v10 */
    /* JADX WARN: Type inference failed for: r9v11 */
    /* JADX WARN: Type inference failed for: r9v12, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r9v14 */
    /* JADX WARN: Type inference failed for: r9v15 */
    /* JADX WARN: Type inference failed for: r9v3, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r9v4 */
    /* JADX WARN: Type inference failed for: r9v5, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r9v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static /* synthetic */ void h(String str, String str2, a aVar) {
        int i3;
        HttpsURLConnection httpsURLConnection;
        String str3;
        String str4;
        ?? r95;
        String str5;
        String str6;
        a aVar2;
        String str7;
        boolean z16;
        int i16;
        String str8;
        int i17;
        Closeable closeable;
        boolean z17 = true;
        int i18 = -1;
        ByteArrayOutputStream byteArrayOutputStream = null;
        r4 = null;
        String str9 = null;
        ByteArrayOutputStream byteArrayOutputStream2 = null;
        byteArrayOutputStream = null;
        boolean z18 = false;
        try {
            httpsURLConnection = (HttpsURLConnection) new URL(str).openConnection();
        } catch (Exception e16) {
            e = e16;
            httpsURLConnection = null;
            str4 = null;
        } catch (Throwable th5) {
            th = th5;
            i3 = -1;
            httpsURLConnection = null;
            str3 = null;
        }
        try {
            httpsURLConnection.setConnectTimeout(15000);
            httpsURLConnection.setReadTimeout(15000);
            httpsURLConnection.setRequestMethod("GET");
            httpsURLConnection.setRequestProperty("User-Agent", g());
            httpsURLConnection.setRequestProperty("Cookie", str2);
            if (httpsURLConnection.getResponseCode() == 200) {
                ByteArrayOutputStream byteArrayOutputStream3 = new ByteArrayOutputStream();
                try {
                    r95 = httpsURLConnection.getInputStream();
                    try {
                        try {
                            byte[] bArr = new byte[1024];
                            while (true) {
                                int read = r95.read(bArr);
                                if (read == -1) {
                                    break;
                                } else {
                                    byteArrayOutputStream3.write(bArr, 0, read);
                                }
                            }
                            str5 = new String(byteArrayOutputStream3.toByteArray());
                        } catch (Exception e17) {
                            e = e17;
                            str5 = str9;
                        }
                    } catch (Throwable th6) {
                        th = th6;
                    }
                } catch (Exception e18) {
                    e = e18;
                    r95 = 0;
                    str5 = null;
                } catch (Throwable th7) {
                    th = th7;
                    i3 = -1;
                    r95 = 0;
                    byteArrayOutputStream = byteArrayOutputStream3;
                    str3 = null;
                }
                try {
                    try {
                        if (!TextUtils.isEmpty(str5)) {
                            try {
                                str9 = str5.substring(10, str5.length() - 2);
                                try {
                                    JSONObject jSONObject = new JSONObject(str9);
                                    i18 = jSONObject.optInt("code", -10001);
                                    if (i18 == 0) {
                                        try {
                                            str5 = jSONObject.optString("content", "");
                                        } catch (Exception e19) {
                                            e = e19;
                                            z18 = true;
                                            QLog.e("QFSHttpsUtil", 1, "sendHttpsRequest parse data error : " + e);
                                            str5 = str9;
                                            i17 = i18;
                                            byteArrayOutputStream2 = byteArrayOutputStream3;
                                            closeable = r95;
                                            c(byteArrayOutputStream2);
                                            c(closeable);
                                            httpsURLConnection.disconnect();
                                            if (aVar == null) {
                                            }
                                        } catch (Throwable th8) {
                                            th = th8;
                                            z18 = true;
                                            i3 = i18;
                                            str3 = str9;
                                            byteArrayOutputStream = byteArrayOutputStream3;
                                            c(byteArrayOutputStream);
                                            c(r95);
                                            if (httpsURLConnection != null) {
                                            }
                                            if (aVar != null) {
                                            }
                                            throw th;
                                        }
                                    } else {
                                        str5 = jSONObject.optString("message", "");
                                        z17 = false;
                                    }
                                    z18 = z17;
                                } catch (Exception e26) {
                                    e = e26;
                                }
                            } catch (Exception e27) {
                                e = e27;
                                str9 = str5;
                            }
                        }
                        i17 = i18;
                        byteArrayOutputStream2 = byteArrayOutputStream3;
                        closeable = r95;
                    } catch (Exception e28) {
                        e = e28;
                        byteArrayOutputStream = byteArrayOutputStream3;
                        r95 = r95;
                        try {
                            str3 = e.getMessage();
                            i3 = -10001;
                        } catch (Throwable th9) {
                            th = th9;
                            str3 = str5;
                            i3 = i18;
                            c(byteArrayOutputStream);
                            c(r95);
                            if (httpsURLConnection != null) {
                            }
                            if (aVar != null) {
                            }
                            throw th;
                        }
                        try {
                            QLog.e("QFSHttpsUtil", 1, "requestGetQZoneFeedDetailData IOException : " + e.getMessage());
                            c(byteArrayOutputStream);
                            c(r95);
                            if (httpsURLConnection != null) {
                                httpsURLConnection.disconnect();
                            }
                            if (aVar == null) {
                                str6 = "";
                                aVar2 = aVar;
                                str7 = str;
                                z16 = z18;
                                i16 = -10001;
                                str8 = str3;
                                aVar2.a(str7, str6, z16, i16, str8);
                            }
                            return;
                        } catch (Throwable th10) {
                            th = th10;
                            c(byteArrayOutputStream);
                            c(r95);
                            if (httpsURLConnection != null) {
                                httpsURLConnection.disconnect();
                            }
                            if (aVar != null) {
                                aVar.a(str, "", z18, i3, str3);
                            }
                            throw th;
                        }
                    }
                } catch (Throwable th11) {
                    th = th11;
                    byteArrayOutputStream = byteArrayOutputStream3;
                    str3 = str5;
                    i3 = i18;
                    c(byteArrayOutputStream);
                    c(r95);
                    if (httpsURLConnection != null) {
                    }
                    if (aVar != null) {
                    }
                    throw th;
                }
            } else {
                str5 = httpsURLConnection.getResponseMessage();
                i17 = -1;
                closeable = null;
            }
            c(byteArrayOutputStream2);
            c(closeable);
            httpsURLConnection.disconnect();
        } catch (Exception e29) {
            e = e29;
            str4 = null;
            str5 = str4;
            r95 = str4;
            str3 = e.getMessage();
            i3 = -10001;
            QLog.e("QFSHttpsUtil", 1, "requestGetQZoneFeedDetailData IOException : " + e.getMessage());
            c(byteArrayOutputStream);
            c(r95);
            if (httpsURLConnection != null) {
            }
            if (aVar == null) {
            }
        } catch (Throwable th12) {
            th = th12;
            i3 = -1;
            str3 = null;
            r95 = str3;
            c(byteArrayOutputStream);
            c(r95);
            if (httpsURLConnection != null) {
            }
            if (aVar != null) {
            }
            throw th;
        }
        if (aVar == null) {
            str6 = "";
            aVar2 = aVar;
            str7 = str;
            z16 = z18;
            i16 = i17;
            str8 = str5;
            aVar2.a(str7, str6, z16, i16, str8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't wrap try/catch for region: R(8:10|(4:12|13|14|(2:15|16))|(10:17|(3:19|20|22)(1:55)|25|26|27|28|29|(1:31)|32|(3:34|35|36)(1:38))|56|58|59|(3:67|68|(1:70)(2:71|72))(1:61)|62) */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x0101, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x0102, code lost:
    
        r7 = r10;
        r10 = r14;
        r16 = r15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x0113, code lost:
    
        r9 = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x00fb, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x00fc, code lost:
    
        r16 = r14;
        r9 = -1;
     */
    /* JADX WARN: Removed duplicated region for block: B:31:0x01b1  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x01dd  */
    /* JADX WARN: Removed duplicated region for block: B:38:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0200  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x022a  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x015a  */
    /* JADX WARN: Removed duplicated region for block: B:66:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static /* synthetic */ void i(String str, int i3, int i16, String str2, String str3, String str4, a aVar) {
        String str5;
        HttpsURLConnection httpsURLConnection;
        String str6;
        ByteArrayOutputStream byteArrayOutputStream;
        OutputStream outputStream;
        InputStream inputStream;
        ByteArrayOutputStream byteArrayOutputStream2;
        InputStream inputStream2;
        String str7;
        int i17;
        boolean z16;
        String str8;
        String str9;
        a aVar2;
        int responseCode;
        String responseMessage;
        boolean z17;
        ByteArrayOutputStream byteArrayOutputStream3;
        byte[] bArr;
        int i18 = -1;
        try {
            httpsURLConnection = (HttpsURLConnection) new URL(str).openConnection();
        } catch (Exception e16) {
            e = e16;
            str6 = null;
            i18 = -1;
            byteArrayOutputStream = null;
            httpsURLConnection = null;
        } catch (Throwable th5) {
            th = th5;
            i18 = -1;
            str5 = null;
            httpsURLConnection = null;
        }
        try {
            httpsURLConnection.setConnectTimeout(i3);
            httpsURLConnection.setReadTimeout(i16);
            httpsURLConnection.setDoOutput(true);
            httpsURLConnection.setDoInput(true);
            httpsURLConnection.setUseCaches(false);
            httpsURLConnection.setRequestMethod("POST");
            httpsURLConnection.setRequestProperty("Connection", "Keep-Alive");
            httpsURLConnection.setRequestProperty("User-Agent", g());
            httpsURLConnection.setRequestProperty("Accept", "*/*");
            httpsURLConnection.setRequestProperty("Content-Type", str2);
            httpsURLConnection.setRequestProperty("Cookie", str3);
            outputStream = httpsURLConnection.getOutputStream();
        } catch (Exception e17) {
            e = e17;
            str6 = null;
            i18 = -1;
            byteArrayOutputStream = null;
            outputStream = null;
            inputStream2 = null;
            try {
                str6 = e.getMessage();
            } catch (Throwable th6) {
                th = th6;
            }
            try {
                QLog.e("QFSHttpsUtil", 1, "sendHttpsRequest IOException : " + e.getMessage());
                c(byteArrayOutputStream);
                c(inputStream2);
                c(outputStream);
                if (httpsURLConnection != null) {
                }
                QLog.d("QFSHttpsUtil", 1, "sendHttpsRequest --> response, httpsUrl : " + str + " isSuccess : false retCode : -10001 rspMsg : " + str6);
                if (aVar == null) {
                }
            } catch (Throwable th7) {
                th = th7;
                i18 = -10001;
                inputStream = inputStream2;
                byteArrayOutputStream2 = byteArrayOutputStream;
                str5 = str6;
                c(byteArrayOutputStream2);
                c(inputStream);
                c(outputStream);
                if (httpsURLConnection != null) {
                    httpsURLConnection.disconnect();
                }
                QLog.d("QFSHttpsUtil", 1, "sendHttpsRequest --> response, httpsUrl : " + str + " isSuccess : false retCode : " + i18 + " rspMsg : " + str5);
                if (aVar != null) {
                    aVar.a(str, str4, false, i18, str5);
                }
                throw th;
            }
        } catch (Throwable th8) {
            th = th8;
            i18 = -1;
            str5 = null;
            outputStream = null;
            inputStream = null;
            byteArrayOutputStream2 = null;
            c(byteArrayOutputStream2);
            c(inputStream);
            c(outputStream);
            if (httpsURLConnection != null) {
            }
            QLog.d("QFSHttpsUtil", 1, "sendHttpsRequest --> response, httpsUrl : " + str + " isSuccess : false retCode : " + i18 + " rspMsg : " + str5);
            if (aVar != null) {
            }
            throw th;
        }
        try {
            outputStream.write(str4.getBytes());
            outputStream.flush();
            httpsURLConnection.connect();
            responseCode = httpsURLConnection.getResponseCode();
            responseMessage = httpsURLConnection.getResponseMessage();
        } catch (Exception e18) {
            e = e18;
            str6 = null;
            i18 = -1;
            byteArrayOutputStream = null;
        } catch (Throwable th9) {
            th = th9;
            i18 = -1;
            str5 = null;
            inputStream = null;
            byteArrayOutputStream2 = null;
            c(byteArrayOutputStream2);
            c(inputStream);
            c(outputStream);
            if (httpsURLConnection != null) {
            }
            QLog.d("QFSHttpsUtil", 1, "sendHttpsRequest --> response, httpsUrl : " + str + " isSuccess : false retCode : " + i18 + " rspMsg : " + str5);
            if (aVar != null) {
            }
            throw th;
        }
        if (responseCode == 200) {
            byteArrayOutputStream3 = new ByteArrayOutputStream();
            try {
                inputStream = httpsURLConnection.getInputStream();
                try {
                    bArr = new byte[1024];
                } catch (Exception e19) {
                    e = e19;
                    byteArrayOutputStream = byteArrayOutputStream3;
                    inputStream2 = inputStream;
                    str6 = null;
                } catch (Throwable th10) {
                    th = th10;
                    byteArrayOutputStream2 = byteArrayOutputStream3;
                    i18 = -1;
                }
            } catch (Exception e26) {
                e = e26;
                byteArrayOutputStream = byteArrayOutputStream3;
                str6 = null;
                i18 = -1;
                inputStream2 = null;
                str6 = e.getMessage();
                QLog.e("QFSHttpsUtil", 1, "sendHttpsRequest IOException : " + e.getMessage());
                c(byteArrayOutputStream);
                c(inputStream2);
                c(outputStream);
                if (httpsURLConnection != null) {
                }
                QLog.d("QFSHttpsUtil", 1, "sendHttpsRequest --> response, httpsUrl : " + str + " isSuccess : false retCode : -10001 rspMsg : " + str6);
                if (aVar == null) {
                }
            } catch (Throwable th11) {
                th = th11;
                byteArrayOutputStream2 = byteArrayOutputStream3;
                i18 = -1;
                str5 = null;
                inputStream = null;
            }
            while (true) {
                int read = inputStream.read(bArr);
                if (read == -1) {
                    break;
                }
                try {
                    byteArrayOutputStream3.write(bArr, 0, read);
                } catch (Exception e27) {
                    e = e27;
                    byteArrayOutputStream = byteArrayOutputStream3;
                    inputStream2 = inputStream;
                    str6 = null;
                } catch (Throwable th12) {
                    th = th12;
                    byteArrayOutputStream2 = byteArrayOutputStream3;
                    str5 = null;
                    c(byteArrayOutputStream2);
                    c(inputStream);
                    c(outputStream);
                    if (httpsURLConnection != null) {
                    }
                    QLog.d("QFSHttpsUtil", 1, "sendHttpsRequest --> response, httpsUrl : " + str + " isSuccess : false retCode : " + i18 + " rspMsg : " + str5);
                    if (aVar != null) {
                    }
                    throw th;
                }
                str6 = e.getMessage();
                QLog.e("QFSHttpsUtil", 1, "sendHttpsRequest IOException : " + e.getMessage());
                c(byteArrayOutputStream);
                c(inputStream2);
                c(outputStream);
                if (httpsURLConnection != null) {
                    httpsURLConnection.disconnect();
                }
                QLog.d("QFSHttpsUtil", 1, "sendHttpsRequest --> response, httpsUrl : " + str + " isSuccess : false retCode : -10001 rspMsg : " + str6);
                if (aVar == null) {
                    z16 = false;
                    i17 = -10001;
                    aVar2 = aVar;
                    str9 = str;
                    str8 = str4;
                    str7 = str6;
                    aVar2.a(str9, str8, z16, i17, str7);
                }
                return;
            }
            str5 = new String(byteArrayOutputStream3.toByteArray());
            if (!TextUtils.isEmpty(str5)) {
                try {
                    JSONObject jSONObject = new JSONObject(str5);
                    i18 = jSONObject.optInt("code", -10001);
                    if (i18 == 0) {
                        z17 = true;
                    } else {
                        try {
                            try {
                                str5 = jSONObject.optString("message", "");
                            } catch (Exception e28) {
                                e = e28;
                                str6 = str5;
                                byteArrayOutputStream = byteArrayOutputStream3;
                                inputStream2 = inputStream;
                            } catch (Throwable th13) {
                                th = th13;
                                byteArrayOutputStream2 = byteArrayOutputStream3;
                                c(byteArrayOutputStream2);
                                c(inputStream);
                                c(outputStream);
                                if (httpsURLConnection != null) {
                                }
                                QLog.d("QFSHttpsUtil", 1, "sendHttpsRequest --> response, httpsUrl : " + str + " isSuccess : false retCode : " + i18 + " rspMsg : " + str5);
                                if (aVar != null) {
                                }
                                throw th;
                            }
                        } catch (JSONException e29) {
                            e = e29;
                            QLog.e("QFSHttpsUtil", 1, "sendHttpsRequest parse data error, JSONException : " + e);
                            z17 = false;
                            c(byteArrayOutputStream3);
                            c(inputStream);
                            c(outputStream);
                            httpsURLConnection.disconnect();
                            QLog.d("QFSHttpsUtil", 1, "sendHttpsRequest --> response, httpsUrl : " + str + " isSuccess : " + z17 + " retCode : " + i18 + " rspMsg : " + str5);
                            if (aVar == null) {
                            }
                        }
                    }
                } catch (JSONException e36) {
                    e = e36;
                    i18 = -1;
                }
            } else {
                i18 = -1;
            }
            z17 = false;
        } else {
            str5 = responseMessage;
            i18 = -1;
            z17 = false;
            byteArrayOutputStream3 = null;
            inputStream = null;
        }
        c(byteArrayOutputStream3);
        c(inputStream);
        c(outputStream);
        httpsURLConnection.disconnect();
        QLog.d("QFSHttpsUtil", 1, "sendHttpsRequest --> response, httpsUrl : " + str + " isSuccess : " + z17 + " retCode : " + i18 + " rspMsg : " + str5);
        if (aVar == null) {
            aVar2 = aVar;
            str9 = str;
            str8 = str4;
            z16 = z17;
            i17 = i18;
            str7 = str5;
            aVar2.a(str9, str8, z16, i17, str7);
        }
    }

    public static void j(final String str, final String str2, final a aVar) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.biz.qqcircle.utils.bs
            @Override // java.lang.Runnable
            public final void run() {
                bu.h(str, str2, aVar);
            }
        }, 128, null, true);
    }

    public static void k(final String str, final String str2, final String str3, final String str4, final int i3, final int i16, final a aVar) {
        QLog.d("QFSHttpsUtil", 1, "sendHttpsRequest httpsUrl : " + str);
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.biz.qqcircle.utils.bt
            @Override // java.lang.Runnable
            public final void run() {
                bu.i(str, i3, i16, str3, str2, str4, aVar);
            }
        }, 128, null, true);
    }
}
