package com.tencent.open.virtual;

import android.content.pm.Signature;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
import android.os.Looper;
import android.text.TextUtils;
import androidx.core.internal.view.SupportMenu;
import com.tencent.ad.tangram.analysis.sqlite.AdAnalysisSQLiteColumns;
import com.tencent.common.config.AppSetting;
import com.tencent.local_edit.andserver.util.MediaType;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.open.agent.util.t;
import com.tencent.open.model.AccountManage;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.MD5;
import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.security.MessageDigest;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import oicq.wlogin_sdk.tools.cryptor;

/* compiled from: P */
/* loaded from: classes22.dex */
public class OpenSdkVirtualUtil {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class a implements HostnameVerifier {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ URL f341758a;

        a(URL url) {
            this.f341758a = url;
        }

        @Override // javax.net.ssl.HostnameVerifier
        public boolean verify(String str, SSLSession sSLSession) {
            boolean verify = HttpsURLConnection.getDefaultHostnameVerifier().verify(this.f341758a.getHost(), sSLSession);
            if (!verify) {
                t.b("OpenSdkVirtualUtil", "OpenVirtual.HostnameVerifier.host:", this.f341758a.getHost(), ",address:", sSLSession.getPeerHost(), ",isverify:", Boolean.valueOf(verify));
            }
            return verify;
        }
    }

    public static String b(String str) {
        return com.tencent.mobileqq.login.account.b.a(str);
    }

    public static byte[] c(byte[] bArr, com.tencent.open.model.a aVar) {
        if (bArr == null) {
            t.b("OpenSdkVirtualUtil", "decryptData, buffer is null");
            return null;
        }
        if (aVar == null) {
            t.b("OpenSdkVirtualUtil", "decryptData, account is null");
            return null;
        }
        byte[] bArr2 = aVar.f341680c;
        if (bArr2 == null) {
            t.e("OpenSdkVirtualUtil", "decryptData, stKey is null.");
            return null;
        }
        return cryptor.decrypt(bArr, 0, bArr.length, bArr2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't wrap try/catch for region: R(23:5|6|(1:8)(1:106)|9|10|(1:12)(1:105)|13|15|16|17|18|19|20|21|22|(16:44|45|46|47|(1:49)|50|51|53|54|55|25|26|27|(1:(1:30)(1:31))|32|33)|24|25|26|27|(0)|32|33) */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0247, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0299, code lost:
    
        if (r8 != 0) goto L83;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x029b, code lost:
    
        r22.a(true, r4, r6, r0);
        r3 = r3;
        r5 = r5;
        r6 = r6;
        r13 = r13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x029f, code lost:
    
        r22.a(false, null, r6, r0);
        r3 = r3;
        r5 = r5;
        r6 = r6;
        r13 = r13;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:29:0x023a  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0299  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x02b0  */
    /* JADX WARN: Removed duplicated region for block: B:69:? A[SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r13v0 */
    /* JADX WARN: Type inference failed for: r13v2 */
    /* JADX WARN: Type inference failed for: r13v27 */
    /* JADX WARN: Type inference failed for: r13v28 */
    /* JADX WARN: Type inference failed for: r13v29 */
    /* JADX WARN: Type inference failed for: r13v30 */
    /* JADX WARN: Type inference failed for: r13v31 */
    /* JADX WARN: Type inference failed for: r13v32 */
    /* JADX WARN: Type inference failed for: r13v6 */
    /* JADX WARN: Type inference failed for: r3v14, types: [java.io.OutputStream, java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r3v2 */
    /* JADX WARN: Type inference failed for: r3v24 */
    /* JADX WARN: Type inference failed for: r3v25 */
    /* JADX WARN: Type inference failed for: r3v26 */
    /* JADX WARN: Type inference failed for: r3v27 */
    /* JADX WARN: Type inference failed for: r3v5 */
    /* JADX WARN: Type inference failed for: r3v6, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r3v9, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v21, types: [java.io.Closeable, java.io.Writer, java.io.OutputStreamWriter] */
    /* JADX WARN: Type inference failed for: r5v3 */
    /* JADX WARN: Type inference failed for: r5v31 */
    /* JADX WARN: Type inference failed for: r5v32 */
    /* JADX WARN: Type inference failed for: r5v4, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r5v6, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r6v11 */
    /* JADX WARN: Type inference failed for: r6v2, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r6v34 */
    /* JADX WARN: Type inference failed for: r6v35 */
    /* JADX WARN: Type inference failed for: r6v36 */
    /* JADX WARN: Type inference failed for: r6v37 */
    /* JADX WARN: Type inference failed for: r6v38 */
    /* JADX WARN: Type inference failed for: r6v39 */
    /* JADX WARN: Type inference failed for: r6v5 */
    /* JADX WARN: Type inference failed for: r8v2, types: [java.lang.Object[]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void d(String str, String str2, String str3, String str4, fp3.d dVar, boolean z16) {
        String str5;
        Throwable th5;
        String str6;
        int i3;
        boolean z17;
        String str7;
        int i16;
        ?? r36;
        ?? r56;
        ?? r57;
        int i17;
        ?? r37;
        String str8;
        int i18;
        String str9;
        String str10;
        HttpsURLConnection httpsURLConnection;
        String str11;
        int i19;
        String str12;
        String str13 = ";";
        String str14 = "";
        String str15 = "_";
        if (z16) {
            str5 = "https://oidb-test.tim.qq.com/v3/oidbinterface/%s?sdkappid=39998&actype=2";
        } else {
            str5 = "https://oidb.tim.qq.com/v3/oidbinterface/%s?sdkappid=20344&actype=2";
        }
        ?? format = String.format(str5, str);
        ?? r132 = 4;
        t.b("OpenSdkVirtualUtil", new Object[]{"OpenVirtual.doOIDBCGIwithPskey.cmd:", str, ", uin=*", com.tencent.open.agent.util.g.C(str2), ",is test env=", Boolean.valueOf(z16), ", url=", format});
        char c16 = '\uffff';
        try {
            try {
                URL url = new URL(format);
                a aVar = new a(url);
                httpsURLConnection = (HttpsURLConnection) url.openConnection();
                httpsURLConnection.setHostnameVerifier(aVar);
                httpsURLConnection.setConnectTimeout(10000);
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
                String str16 = AppSetting.f99551k;
                sb5.append(str16);
                sb5.append("_");
                sb5.append("QQ/");
                sb5.append(str16 + AppSetting.f99542b);
                httpsURLConnection.setRequestProperty("User-Agent", sb5.toString());
                httpsURLConnection.setRequestProperty("Accept", "*/*");
                if (z16) {
                    str11 = "https://oidb-test.tim.qq.com";
                } else {
                    str11 = "https://oidb.tim.qq.com";
                }
                httpsURLConnection.setRequestProperty("Referer", str11);
                if ("oidb_0xc7f_25".equals(str)) {
                    httpsURLConnection.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + String.format("=========%s", Long.valueOf(System.currentTimeMillis())));
                } else {
                    httpsURLConnection.setRequestProperty("Content-Type", MediaType.APPLICATION_JSON_UTF8_VALUE);
                }
                StringBuilder sb6 = new StringBuilder();
                sb6.append("p_uin=");
                sb6.append("o" + str2);
                sb6.append(";");
                sb6.append("utype=");
                sb6.append("QQ");
                sb6.append(";");
                sb6.append("p_skey=");
                sb6.append(str3);
                httpsURLConnection.setRequestProperty("Cookie", sb6.toString());
                r36 = httpsURLConnection.getOutputStream();
                try {
                    r57 = new OutputStreamWriter((OutputStream) r36, "UTF-8");
                    try {
                        r57.write(str4);
                        r57.flush();
                        httpsURLConnection.connect();
                        i16 = httpsURLConnection.getResponseCode();
                        try {
                            str7 = httpsURLConnection.getResponseMessage();
                            str12 = str7;
                        } catch (Exception e16) {
                            e = e16;
                            str7 = "";
                        } catch (Throwable th6) {
                            th5 = th6;
                            str6 = "";
                            i19 = i16;
                        }
                    } catch (Exception e17) {
                        e = e17;
                        str7 = "";
                        i16 = -1;
                    } catch (Throwable th7) {
                        th5 = th7;
                        str6 = "";
                        i19 = -1;
                    }
                } catch (Exception e18) {
                    e = e18;
                    str7 = "";
                    i16 = -1;
                    c16 = 0;
                    r36 = r36;
                    r57 = 0;
                    t.d("OpenSdkVirtualUtil", "OpenVirtual.doOIDBCGI.e:", e);
                    String str17 = "handle connect exception:" + e.getMessage();
                    com.tencent.open.agent.util.h.a(r57);
                    com.tencent.open.agent.util.h.a(r36);
                    str13 = r36;
                    str15 = r57;
                    format = i16;
                    r132 = str7;
                    if (dVar != null) {
                    }
                } catch (Throwable th8) {
                    th5 = th8;
                    str6 = "";
                    i3 = -1;
                    c16 = 0;
                    z17 = r36;
                    r56 = 0;
                    r37 = z17;
                    i17 = i3;
                    com.tencent.open.agent.util.h.a(r56);
                    com.tencent.open.agent.util.h.a(r37);
                    if (dVar != null) {
                    }
                }
            } catch (Exception e19) {
                e = e19;
                str7 = "";
                i16 = -1;
                c16 = 0;
                r36 = 0;
            } catch (Throwable th9) {
                th5 = th9;
                str6 = "";
                i3 = -1;
                c16 = 0;
                z17 = false;
            }
            if (i16 == 200) {
                try {
                    BufferedInputStream bufferedInputStream = new BufferedInputStream(httpsURLConnection.getInputStream());
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    try {
                        for (int read = bufferedInputStream.read(); read != -1; read = bufferedInputStream.read()) {
                            byteArrayOutputStream.write((byte) read);
                        }
                        str14 = byteArrayOutputStream.toString();
                        try {
                            c16 = 1;
                            str7 = str7;
                        } catch (Exception e26) {
                            e = e26;
                            c16 = 1;
                            t.d("OpenSdkVirtualUtil", "OpenVirtual.doOIDBCGI.e:", e);
                            String str172 = "handle connect exception:" + e.getMessage();
                            com.tencent.open.agent.util.h.a(r57);
                            com.tencent.open.agent.util.h.a(r36);
                            str13 = r36;
                            str15 = r57;
                            format = i16;
                            r132 = str7;
                            if (dVar != null) {
                            }
                        } catch (Throwable th10) {
                            th5 = th10;
                            str6 = str14;
                            c16 = 1;
                            str10 = r36;
                            str9 = r57;
                            i18 = i16;
                            str8 = str7;
                            str14 = str8;
                            r37 = str10;
                            r56 = str9;
                            i17 = i18;
                            com.tencent.open.agent.util.h.a(r56);
                            com.tencent.open.agent.util.h.a(r37);
                            if (dVar != null) {
                                if (c16 != 0) {
                                    dVar.a(true, str6, i17, str14);
                                    throw th5;
                                }
                                dVar.a(false, null, i17, str14);
                                throw th5;
                            }
                            throw th5;
                        }
                    } catch (IOException e27) {
                        t.a("OpenSdkVirtualUtil", "OpenVirtual.doOIDBCGI.exception:", e27);
                        String str18 = "handle connect result exception:" + e27.getMessage();
                        try {
                            str12 = str18;
                        } catch (Exception e28) {
                            e = e28;
                            str7 = str18;
                            c16 = 0;
                            t.d("OpenSdkVirtualUtil", "OpenVirtual.doOIDBCGI.e:", e);
                            String str1722 = "handle connect exception:" + e.getMessage();
                            com.tencent.open.agent.util.h.a(r57);
                            com.tencent.open.agent.util.h.a(r36);
                            str13 = r36;
                            str15 = r57;
                            format = i16;
                            r132 = str7;
                            if (dVar != null) {
                            }
                        } catch (Throwable th11) {
                            th5 = th11;
                            str6 = "";
                            str14 = str18;
                            i19 = i16;
                            c16 = 0;
                            r37 = r36;
                            r56 = r57;
                            i17 = i19;
                            com.tencent.open.agent.util.h.a(r56);
                            com.tencent.open.agent.util.h.a(r37);
                            if (dVar != null) {
                            }
                        }
                    } finally {
                        com.tencent.open.agent.util.h.a(bufferedInputStream);
                        com.tencent.open.agent.util.h.a(byteArrayOutputStream);
                    }
                    t.b("OpenSdkVirtualUtil", "OpenVirtual.doOIDBCGI.response.httpcode:", Integer.valueOf(i16), ", result:", h(str14, str2), ", errMsg:", str7);
                    com.tencent.open.agent.util.h.a(r57);
                    com.tencent.open.agent.util.h.a(r36);
                    str13 = r36;
                    str15 = r57;
                    format = i16;
                    r132 = str7;
                    if (dVar != null) {
                        if (c16 != 0) {
                            dVar.a(true, str14, i16, str7);
                            str13 = r36;
                            str15 = r57;
                            format = i16;
                            r132 = str7;
                        } else {
                            dVar.a(false, null, i16, str7);
                            str13 = r36;
                            str15 = r57;
                            format = i16;
                            r132 = str7;
                        }
                    }
                } catch (Exception e29) {
                    e = e29;
                    c16 = 0;
                    t.d("OpenSdkVirtualUtil", "OpenVirtual.doOIDBCGI.e:", e);
                    String str17222 = "handle connect exception:" + e.getMessage();
                    com.tencent.open.agent.util.h.a(r57);
                    com.tencent.open.agent.util.h.a(r36);
                    str13 = r36;
                    str15 = r57;
                    format = i16;
                    r132 = str7;
                    if (dVar != null) {
                    }
                } catch (Throwable th12) {
                    th5 = th12;
                    str6 = str14;
                    c16 = 0;
                    str10 = r36;
                    str9 = r57;
                    i18 = i16;
                    str8 = str7;
                }
            }
            c16 = 0;
            str7 = str12;
            t.b("OpenSdkVirtualUtil", "OpenVirtual.doOIDBCGI.response.httpcode:", Integer.valueOf(i16), ", result:", h(str14, str2), ", errMsg:", str7);
            com.tencent.open.agent.util.h.a(r57);
            com.tencent.open.agent.util.h.a(r36);
            str13 = r36;
            str15 = r57;
            format = i16;
            r132 = str7;
            if (dVar != null) {
            }
        } catch (Throwable th13) {
            th5 = th13;
            str6 = str14;
            str10 = str13;
            str9 = str15;
            i18 = format;
            str8 = r132;
        }
    }

    public static void e(final String str, String str2, final String str3, final String str4, final fp3.d dVar, final boolean z16) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str3)) {
            cq3.b.f391646a.f(str3, "tim.qq.com", str2, true, new AccountManage.g() { // from class: com.tencent.open.virtual.OpenSdkVirtualUtil.1
                @Override // com.tencent.open.model.AccountManage.g
                public void onFail(int i3, String str5) {
                    dVar.a(false, "", i3, str5);
                }

                @Override // com.tencent.open.model.AccountManage.g
                public void onSuccess(final String str5) {
                    if (!OpenSdkVirtualUtil.o()) {
                        OpenSdkVirtualUtil.d(str, str3, str5, str4, dVar, z16);
                    } else {
                        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.open.virtual.OpenSdkVirtualUtil.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                                OpenSdkVirtualUtil.d(str, str3, str5, str4, dVar, z16);
                            }
                        }, 128, null, true);
                    }
                }
            });
            return;
        }
        t.b("OpenSdkVirtualUtil", "OpenVirtual.doOIDBCGIwithPskey.failed.invalid.param.cmd:", str, ",env=", Boolean.valueOf(z16));
        if (dVar != null) {
            dVar.a(false, "", -1, "param error");
        }
    }

    public static byte[] f(byte[] bArr, com.tencent.open.model.a aVar) {
        if (bArr == null) {
            t.b("OpenSdkVirtualUtil", "encryptData, buffer is null");
            return null;
        }
        if (aVar == null) {
            t.b("OpenSdkVirtualUtil", "encryptData, account is null");
            return null;
        }
        byte[] bArr2 = aVar.f341679b;
        byte[] bArr3 = aVar.f341680c;
        if (bArr2 != null && bArr3 != null) {
            byte[] encrypt = cryptor.encrypt(bArr, 0, bArr.length, bArr3);
            byte[] bArr4 = new byte[bArr2.length + 4 + encrypt.length];
            System.arraycopy(new byte[]{(byte) (bArr2.length >> 24), (byte) (bArr2.length >> 16), (byte) (bArr2.length >> 8), (byte) bArr2.length}, 0, bArr4, 0, 4);
            System.arraycopy(bArr2, 0, bArr4, 4, bArr2.length);
            System.arraycopy(encrypt, 0, bArr4, 4 + bArr2.length, encrypt.length);
            return bArr4;
        }
        t.e("OpenSdkVirtualUtil", "encryptData, st or stKey is null.");
        return null;
    }

    public static void g(NewIntent newIntent) {
        newIntent.putExtra("timeout", 11000L);
        newIntent.putExtra(AdAnalysisSQLiteColumns.COLUMN_NAME_STRATEGY, 0);
    }

    public static String h(String str, String str2) {
        if (str != null && str2 != null && str.contains(str2)) {
            return str.replaceAll(str2, "*" + com.tencent.open.agent.util.g.C(str2));
        }
        return str;
    }

    public static Bitmap i(String str, int i3, boolean z16) {
        int i16 = (int) (i3 * MobileQQ.sMobileQQ.getResources().getDisplayMetrics().density);
        Bitmap c16 = com.tencent.mobileqq.util.j.c(n(str));
        if (c16 == null) {
            c16 = com.tencent.mobileqq.util.j.c(l(str));
        }
        Bitmap bitmap = c16;
        if (bitmap == null) {
            return null;
        }
        Matrix matrix = new Matrix();
        matrix.reset();
        float width = i16 / bitmap.getWidth();
        matrix.postScale(width, width);
        Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, false);
        if (z16) {
            return m(createBitmap);
        }
        return createBitmap;
    }

    public static Bitmap j(BaseApplication baseApplication, String str) {
        long j3 = baseApplication.getSharedPreferences("ssoappicon", 0).getLong(str, 0L);
        if (j3 == 0 || (System.currentTimeMillis() / 1000) - j3 > 172800) {
            return null;
        }
        File externalFilesDir = MobileQQ.sMobileQQ.getExternalFilesDir(null);
        if (externalFilesDir == null) {
            t.b("OpenSdkVirtualUtil", "getAppIcon getExternalFilesDir return null");
            return null;
        }
        return com.tencent.mobileqq.util.j.c(externalFilesDir.getAbsolutePath() + File.separator + "Tencent/MobileQQ/appicon/" + str);
    }

    public static String[] k(String str) {
        String str2;
        String str3;
        StringBuilder sb5 = new StringBuilder();
        sb5.append(System.currentTimeMillis() / 1000);
        String str4 = "";
        sb5.append("");
        String sb6 = sb5.toString();
        String[] strArr = {"", "", ""};
        try {
            Signature[] signatureArr = InstalledAppListMonitor.getPackageInfo(MobileQQ.sMobileQQ.getPackageManager(), str, 64).signatures;
            MessageDigest messageDigest = MessageDigest.getInstance(KeyPropertiesCompact.DIGEST_MD5);
            messageDigest.update(signatureArr[0].toByteArray());
            str3 = HexUtil.bytes2HexStr(messageDigest.digest()).toLowerCase();
            try {
                messageDigest.reset();
                messageDigest.update((str + "_" + str3 + "_" + sb6 + "").getBytes());
                str4 = HexUtil.bytes2HexStr(messageDigest.digest());
                t.b("OpenSdkVirtualUtil", "getAuthorizeSign.success");
            } catch (Exception e16) {
                e = e16;
                str2 = str4;
                str4 = str3;
                t.a("OpenSdkVirtualUtil", "getAuthorizeSign.e:", e);
                str3 = str4;
                str4 = str2;
                strArr[0] = str3;
                strArr[1] = str4;
                strArr[2] = sb6;
                return strArr;
            }
        } catch (Exception e17) {
            e = e17;
            str2 = "";
        }
        strArr[0] = str3;
        strArr[1] = str4;
        strArr[2] = sb6;
        return strArr;
    }

    private static String l(String str) {
        return AppConstants.PATH_HEAD_HD + MD5.toMD5(MD5.toMD5(MD5.toMD5(str) + str) + str) + ".png";
    }

    private static Bitmap m(Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint();
        Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
        RectF rectF = new RectF(rect);
        paint.setAntiAlias(true);
        canvas.drawARGB(0, 0, 0, 0);
        paint.setColor(SupportMenu.CATEGORY_MASK);
        canvas.drawRoundRect(rectF, 4.0f, 4.0f, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, rect, rect, paint);
        return createBitmap;
    }

    public static String n(String str) {
        return AppConstants.PATH_SSO_HEAD_HD + MD5.toMD5(MD5.toMD5(MD5.toMD5(str) + str) + str) + ".png";
    }

    public static boolean o() {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            return true;
        }
        return false;
    }

    public static void p(BaseApplication baseApplication, String str, Bitmap bitmap) {
        if (bitmap == null) {
            return;
        }
        baseApplication.getSharedPreferences("ssoappicon", 0).edit().putLong(str, System.currentTimeMillis() / 1000).commit();
        File externalFilesDir = MobileQQ.sMobileQQ.getExternalFilesDir(null);
        if (externalFilesDir == null) {
            t.b("OpenSdkVirtualUtil", "saveAppIcon getExternalFilesDir return null");
            return;
        }
        File file = new File(externalFilesDir, "Tencent/MobileQQ/appicon/");
        if (!file.exists()) {
            file.mkdirs();
        }
        File file2 = new File(file, str);
        if (file2.exists()) {
            file2.delete();
        }
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file2);
            bitmap.compress(Bitmap.CompressFormat.PNG, 90, fileOutputStream);
            fileOutputStream.flush();
            fileOutputStream.close();
        } catch (FileNotFoundException e16) {
            t.a("OpenSdkVirtualUtil", "FileNotFoundException", e16);
        } catch (IOException e17) {
            t.a("OpenSdkVirtualUtil", "IOException", e17);
        }
    }
}
