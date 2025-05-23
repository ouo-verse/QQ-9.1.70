package com.huawei.hms.opendevice;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.IOUtils;
import com.huawei.secure.android.common.encrypt.utils.BaseKeyUtil;
import com.huawei.secure.android.common.encrypt.utils.EncryptUtil;
import com.huawei.secure.android.common.encrypt.utils.RootKeyUtil;
import com.huawei.secure.android.common.encrypt.utils.WorkKeyCryptUtil;
import com.huawei.secure.android.common.util.IOUtil;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes2.dex */
public abstract class c {

    /* renamed from: a, reason: collision with root package name */
    public static final String f37337a = "c";

    /* renamed from: b, reason: collision with root package name */
    public static Map<String, String> f37338b = new HashMap();

    /* renamed from: c, reason: collision with root package name */
    public static final Object f37339c = new Object();

    public static String a() {
        return "2A57086C86EF54970C1E6EB37BFC72B1";
    }

    public static byte[] b() {
        return a(d(), e(), c(), g());
    }

    public static void c(Context context) {
        synchronized (f37339c) {
            d(context.getApplicationContext());
            if (i()) {
                HMSLog.i(f37337a, "The local secret is already in separate file mode.");
                return;
            }
            StringBuilder sb5 = new StringBuilder();
            sb5.append(p.c(context.getApplicationContext()));
            sb5.append("/shared_prefs/LocalAvengers.xml");
            File file = new File(sb5.toString());
            if (file.exists()) {
                IOUtil.deleteSecure(file);
                HMSLog.i(f37337a, "destroy C, delete file LocalAvengers.xml.");
            }
            byte[] generateSecureRandom = EncryptUtil.generateSecureRandom(32);
            byte[] generateSecureRandom2 = EncryptUtil.generateSecureRandom(32);
            byte[] generateSecureRandom3 = EncryptUtil.generateSecureRandom(32);
            byte[] generateSecureRandom4 = EncryptUtil.generateSecureRandom(32);
            String a16 = a.a(generateSecureRandom);
            String a17 = a.a(generateSecureRandom2);
            String a18 = a.a(generateSecureRandom3);
            String a19 = a.a(generateSecureRandom4);
            a(a16, a17, a18, a19, WorkKeyCryptUtil.encryptWorkKey(a.a(EncryptUtil.generateSecureRandom(32)), a(a16, a17, a18, a19)), context);
            HMSLog.i(f37337a, "generate D.");
        }
    }

    public static void d(Context context) {
        if (i()) {
            HMSLog.i(f37337a, "secretKeyCache not empty.");
            return;
        }
        f37338b.clear();
        String c16 = p.c(context);
        if (TextUtils.isEmpty(c16)) {
            return;
        }
        String a16 = s.a(c16 + "/files/math/m");
        String a17 = s.a(c16 + "/files/panda/p");
        String a18 = s.a(c16 + "/files/panda/d");
        String a19 = s.a(c16 + "/files/math/t");
        String a26 = s.a(c16 + "/files/s");
        if (t.a(a16, a17, a18, a19, a26)) {
            f37338b.put(QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, a16);
            f37338b.put("p", a17);
            f37338b.put("d", a18);
            f37338b.put("t", a19);
            f37338b.put(ReportConstant.COSTREPORT_PREFIX, a26);
        }
    }

    public static synchronized String e(Context context) {
        synchronized (c.class) {
            String decryptWorkKey = WorkKeyCryptUtil.decryptWorkKey(f(), b());
            if (t.a(decryptWorkKey)) {
                HMSLog.i(f37337a, "keyS has been upgraded, no require operate again.");
                return decryptWorkKey;
            }
            String decryptWorkKey2 = WorkKeyCryptUtil.decryptWorkKey(f(), h());
            if (t.a(decryptWorkKey2)) {
                HMSLog.i(f37337a, "keyS is encrypt by RootKeyUtil, upgrade encrypt mode.");
                a(WorkKeyCryptUtil.encryptWorkKey(decryptWorkKey2, b()), context);
                return decryptWorkKey2;
            }
            String decryptWorkKey3 = WorkKeyCryptUtil.decryptWorkKey(f(), BaseKeyUtil.exportRootKey(d(), e(), c(), g(), 32, false));
            if (t.a(decryptWorkKey3)) {
                HMSLog.i(f37337a, "keyS is encrypt by ExportRootKey with sha1, upgrade encrypt mode to sha256.");
                a(WorkKeyCryptUtil.encryptWorkKey(decryptWorkKey3, b()), context);
                return decryptWorkKey3;
            }
            HMSLog.e(f37337a, "all mode unable to decrypt root key.");
            return "";
        }
    }

    public static String f() {
        return a(ReportConstant.COSTREPORT_PREFIX);
    }

    public static String g() {
        return a("t");
    }

    public static RootKeyUtil h() {
        return RootKeyUtil.newInstance(d(), e(), c(), g());
    }

    public static boolean i() {
        return !TextUtils.isEmpty(f());
    }

    public static byte[] a(String str, String str2, String str3, String str4) {
        if (Build.VERSION.SDK_INT >= 26) {
            return BaseKeyUtil.exportRootKey(str, str2, str3, str4, 32, true);
        }
        return BaseKeyUtil.exportRootKey(str, str2, str3, str4, 32, false);
    }

    public static String b(Context context) {
        if (!i()) {
            HMSLog.i(f37337a, "work key is empty, execute init.");
            c(context);
        }
        String decryptWorkKey = WorkKeyCryptUtil.decryptWorkKey(f(), b());
        return t.a(decryptWorkKey) ? decryptWorkKey : e(context);
    }

    public static byte[] a(Context context) {
        byte[] a16 = a.a(context.getString(R.string.f17671320));
        byte[] a17 = a.a(context.getString(R.string.f1767031z));
        return a(a(a(a16, a17), a.a(a())));
    }

    public static byte[] a(byte[] bArr, byte[] bArr2) {
        if (bArr == null || bArr2 == null || bArr.length == 0 || bArr2.length == 0) {
            return new byte[0];
        }
        int length = bArr.length;
        if (length != bArr2.length) {
            return new byte[0];
        }
        byte[] bArr3 = new byte[length];
        for (int i3 = 0; i3 < length; i3++) {
            bArr3[i3] = (byte) (bArr[i3] ^ bArr2[i3]);
        }
        return bArr3;
    }

    public static byte[] a(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return new byte[0];
        }
        for (int i3 = 0; i3 < bArr.length; i3++) {
            bArr[i3] = (byte) (bArr[i3] >> 2);
        }
        return bArr;
    }

    public static String e() {
        return a("p");
    }

    public static void a(String str, String str2, String str3, String str4, String str5, Context context) {
        String c16 = p.c(context.getApplicationContext());
        if (TextUtils.isEmpty(c16)) {
            return;
        }
        try {
            StringBuilder sb5 = new StringBuilder();
            sb5.append(c16);
            sb5.append("/files/math/m");
            a(QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, str, sb5.toString());
            StringBuilder sb6 = new StringBuilder();
            sb6.append(c16);
            sb6.append("/files/panda/p");
            a("p", str2, sb6.toString());
            StringBuilder sb7 = new StringBuilder();
            sb7.append(c16);
            sb7.append("/files/panda/d");
            a("d", str3, sb7.toString());
            StringBuilder sb8 = new StringBuilder();
            sb8.append(c16);
            sb8.append("/files/math/t");
            a("t", str4, sb8.toString());
            StringBuilder sb9 = new StringBuilder();
            sb9.append(c16);
            sb9.append("/files/s");
            a(ReportConstant.COSTREPORT_PREFIX, str5, sb9.toString());
        } catch (IOException unused) {
            HMSLog.e(f37337a, "save key IOException.");
        }
    }

    public static String d() {
        return a(QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO);
    }

    public static String c() {
        return a("d");
    }

    public static void a(String str, Context context) {
        String c16 = p.c(context.getApplicationContext());
        if (TextUtils.isEmpty(c16)) {
            return;
        }
        try {
            StringBuilder sb5 = new StringBuilder();
            sb5.append(c16);
            sb5.append("/files/s");
            a(ReportConstant.COSTREPORT_PREFIX, str, sb5.toString());
        } catch (IOException unused) {
            HMSLog.e(f37337a, "save keyS IOException.");
        }
    }

    public static void a(String str, String str2, String str3) throws IOException {
        OutputStreamWriter outputStreamWriter;
        BufferedWriter bufferedWriter;
        HMSLog.i(f37337a, "save local secret key.");
        BufferedWriter bufferedWriter2 = null;
        try {
            File file = new File(str3);
            s.a(file);
            outputStreamWriter = new OutputStreamWriter(new FileOutputStream(file), "UTF-8");
            try {
                bufferedWriter = new BufferedWriter(outputStreamWriter);
            } catch (Throwable th5) {
                th = th5;
            }
        } catch (Throwable th6) {
            th = th6;
            outputStreamWriter = null;
        }
        try {
            bufferedWriter.write(str2);
            bufferedWriter.flush();
            f37338b.put(str, str2);
            IOUtils.closeQuietly((Writer) outputStreamWriter);
            IOUtils.closeQuietly((Writer) bufferedWriter);
        } catch (Throwable th7) {
            th = th7;
            bufferedWriter2 = bufferedWriter;
            IOUtils.closeQuietly((Writer) outputStreamWriter);
            IOUtils.closeQuietly((Writer) bufferedWriter2);
            throw th;
        }
    }

    public static String a(String str) {
        String str2 = f37338b.get(str);
        return TextUtils.isEmpty(str2) ? "" : str2;
    }
}
