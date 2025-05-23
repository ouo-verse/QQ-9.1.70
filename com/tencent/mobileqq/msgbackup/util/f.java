package com.tencent.mobileqq.msgbackup.util;

import android.net.Uri;
import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.mobileqq.filemanager.util.q;
import com.tencent.mobileqq.msgbackup.controller.MsgBackupManager;
import com.tencent.mobileqq.msgbackup.controller.j;
import com.tencent.mobileqq.msgbackup.data.MsgBackupMsgEntity;
import com.tencent.mobileqq.msgbackup.data.MsgBackupResEntity;
import com.tencent.mobileqq.msgbackup.transport.MsgBackupJniProxy;
import com.tencent.mobileqq.persistence.backup.impl.DBBackupServiceImpl;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.IPAddressUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

/* compiled from: P */
/* loaded from: classes15.dex */
public class f {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static boolean f251421a;

    /* renamed from: b, reason: collision with root package name */
    public static boolean f251422b;

    /* renamed from: c, reason: collision with root package name */
    public static boolean f251423c;

    /* renamed from: d, reason: collision with root package name */
    public static boolean f251424d;

    /* renamed from: e, reason: collision with root package name */
    public static boolean f251425e;

    /* renamed from: f, reason: collision with root package name */
    public static AtomicLong f251426f;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(24159);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        f251421a = false;
        f251422b = true;
        f251423c = true;
        f251424d = false;
        f251425e = true;
        f251426f = new AtomicLong(1L);
    }

    public static boolean A(long j3) {
        if (j3 <= 1048576) {
            return true;
        }
        return false;
    }

    public static void B(String str, String str2, Object... objArr) {
        if (QLog.isColorLevel()) {
            QLog.d(str, 2, String.format(str2, objArr));
        }
    }

    public static void C(String str, Object... objArr) {
        if (QLog.isColorLevel()) {
            QLog.d("MsgBackup", 2, String.format(str, objArr));
        }
    }

    public static void D(String str, String str2, Object... objArr) {
        if (!f251421a) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            str = "MsgBackup";
        }
        if (QLog.isDevelopLevel()) {
            QLog.d(str, 4, String.format(str2, objArr));
        }
    }

    public static void E(String str, Object... objArr) {
        if (f251421a && QLog.isDevelopLevel()) {
            QLog.d("MsgBackup", 4, String.format(str, objArr));
        }
    }

    public static Map<String, String> F(String str) {
        HashMap hashMap = new HashMap();
        if (!TextUtils.isEmpty(str)) {
            String[] split = str.split("\\?");
            if (split.length > 1) {
                for (String str2 : split[1].split(ContainerUtils.FIELD_DELIMITER)) {
                    int indexOf = str2.indexOf(ContainerUtils.KEY_VALUE_DELIMITER);
                    if (indexOf != -1) {
                        hashMap.put(str2.substring(0, indexOf), str2.substring(indexOf + 1));
                    }
                }
            }
        }
        return hashMap;
    }

    public static void G(boolean z16) {
        f251425e = z16;
        QLog.i("MsgBackup", 1, "setQQCommonThreadSwitch " + f251425e);
    }

    public static int H(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        String[] split = str.split("\\.");
        if (split.length != 4) {
            return 0;
        }
        try {
            int parseInt = Integer.parseInt(split[0]);
            int parseInt2 = Integer.parseInt(split[1]) << 8;
            return (Integer.parseInt(split[3]) << 24) | parseInt | parseInt2 | (Integer.parseInt(split[2]) << 16);
        } catch (Exception e16) {
            QLog.e("MsgBackup", 1, e16, new Object[0]);
            return 0;
        }
    }

    public static void I(String str, j jVar) {
        String[] split = str.substring(0, str.indexOf(".")).split("_");
        jVar.f251082a = split[0];
        jVar.f251084c = x(Integer.parseInt(split[1]));
        if (split.length > 2) {
            jVar.f251086e = split[2];
        }
    }

    private static String a(double d16, boolean z16) {
        if (z16) {
            return j(d16);
        }
        return i(d16);
    }

    public static boolean b() {
        boolean z16;
        String str = a.f251370c;
        File file = new File(str);
        boolean exists = file.exists();
        if (!exists) {
            exists = file.mkdirs();
        }
        if (exists) {
            file = new File(a.f251369b);
            z16 = file.exists();
            if (!z16) {
                z16 = file.mkdirs();
            }
        } else {
            z16 = false;
        }
        E("Manager.init.file mkdirs result = %b,dbDirExist = %b,filePath = %s,multimsgDirExist = %b", Boolean.valueOf(exists), Boolean.valueOf(file.exists()), str, Boolean.valueOf(z16));
        return exists;
    }

    public static void c(MsgBackupResEntity msgBackupResEntity) {
        byte[] bArr;
        String str;
        if (f251422b && msgBackupResEntity != null && (bArr = msgBackupResEntity.extraData) != null && (str = MsgBackupManager.F) != null) {
            msgBackupResEntity.extraData = MsgBackupJniProxy.decryptFromByteArray(bArr, str);
        }
    }

    public static String d(String str, String str2, int i3, String str3) {
        if (TextUtils.isEmpty(str3)) {
            D("MsgBackup", "decrptUrlPathParams key is null", new Object[0]);
        }
        if (!f251422b || TextUtils.isEmpty(str) || TextUtils.isEmpty(str3)) {
            return "";
        }
        D("MsgBackup", "decrptUrlPathParams originUrl = %s, ip = %s, port = %d, encryptkey is not null!", str, str2, Integer.valueOf(i3));
        String[] split = str.split(z(str2, i3));
        if (split.length != 2) {
            return "";
        }
        String str4 = F(MsgBackupJniProxy.decryptFromString(split[1], str3)).get("filepath");
        if (TextUtils.isEmpty(str4)) {
            return "";
        }
        if (f251423c) {
            str4 = Uri.decode(str4);
        }
        String w3 = w(str4);
        D("decrptUrlPathParams filepath = %s", w3, new Object[0]);
        return w3;
    }

    public static void e(MsgBackupMsgEntity msgBackupMsgEntity) {
        if (f251422b && msgBackupMsgEntity != null) {
            if (!TextUtils.isEmpty(msgBackupMsgEntity.chatUin)) {
                msgBackupMsgEntity.chatUin = MsgBackupJniProxy.decryptFromString(msgBackupMsgEntity.chatUin, MsgBackupManager.F);
            }
            byte[] bArr = msgBackupMsgEntity.extraData;
            if (bArr != null) {
                msgBackupMsgEntity.extraData = MsgBackupJniProxy.decryptFromByteArray(bArr, MsgBackupManager.F);
            }
            byte[] bArr2 = msgBackupMsgEntity.extensionData;
            if (bArr2 != null) {
                msgBackupMsgEntity.extensionData = MsgBackupJniProxy.decryptFromByteArray(bArr2, MsgBackupManager.F);
            }
        }
    }

    public static String f(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            D("MsgBackup", "decryptPartionUrlParams key is null", new Object[0]);
        }
        if (f251422b && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            D("MsgBackup", "originUrl = %s, encryptkey = %s", str, str2);
            String[] split = str.split("\\/");
            if (split.length == 2) {
                String str3 = "/" + MsgBackupJniProxy.decryptFromString(split[1], str2);
                D("MsgBackup", "decryptUrl = %s", str3);
                return str3;
            }
            return str;
        }
        return str;
    }

    public static String g(String str, String str2, int i3, String str3) {
        if (TextUtils.isEmpty(str3)) {
            D("MsgBackup", "decryptUrlParams key is null", new Object[0]);
        }
        if (f251422b && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str3)) {
            D("MsgBackup", "originUrl = %s, ip = %s, port = %d, encryptkey is not null!", str, str2, Integer.valueOf(i3));
            String z16 = z(str2, i3);
            String[] split = str.split(z16);
            if (split.length == 2) {
                str = z16 + MsgBackupJniProxy.decryptFromString(split[1], str3);
            }
            D("MsgBackup", "decryptUrl = %s", str);
        }
        return str;
    }

    public static void h() {
        QLog.d("MsgBackup", 1, "delete MsgBackup Root Path");
        q.d(a.f251368a);
    }

    public static String i(double d16) {
        StringBuilder sb5 = new StringBuilder();
        if (d16 < 0.0d) {
            sb5.append('-');
            d16 = -d16;
        }
        long j3 = (long) ((d16 * 100.0d) + 0.5d);
        long j16 = 100;
        int i3 = 3;
        while (true) {
            long j17 = j16 * 10;
            if (j17 > j3) {
                break;
            }
            i3++;
            j16 = j17;
        }
        while (i3 > 0) {
            if (i3 == 2) {
                sb5.append('.');
            }
            long j18 = (j3 / j16) % 10;
            j16 /= 10;
            if (i3 != 1 || j18 != 0) {
                sb5.append((char) (j18 + 48));
            }
            i3--;
        }
        return sb5.toString();
    }

    public static String j(double d16) {
        StringBuilder sb5 = new StringBuilder();
        if (d16 < 0.0d) {
            sb5.append('-');
            d16 = -d16;
        }
        long j3 = (long) ((d16 * 100.0d) + 0.5d);
        long j16 = 100;
        int i3 = 3;
        while (true) {
            long j17 = j16 * 10;
            if (j17 > j3) {
                break;
            }
            i3++;
            j16 = j17;
        }
        while (i3 > 0) {
            if (i3 == 2) {
                sb5.append('.');
            }
            long j18 = (j3 / j16) % 10;
            j16 /= 10;
            sb5.append((char) (j18 + 48));
            i3--;
        }
        return sb5.toString();
    }

    public static String k(String str) {
        if (f251423c) {
            return Uri.encode(str);
        }
        return str;
    }

    public static void l(MsgBackupMsgEntity msgBackupMsgEntity) {
        if (f251422b && msgBackupMsgEntity != null && MsgBackupManager.E != null) {
            if (!TextUtils.isEmpty(msgBackupMsgEntity.chatUin)) {
                msgBackupMsgEntity.chatUin = MsgBackupJniProxy.encryptFromString(msgBackupMsgEntity.chatUin, MsgBackupManager.E);
            }
            byte[] bArr = msgBackupMsgEntity.extraData;
            if (bArr != null) {
                msgBackupMsgEntity.extraData = MsgBackupJniProxy.encryptFromByteArray(bArr, MsgBackupManager.E);
            }
            byte[] bArr2 = msgBackupMsgEntity.extensionData;
            if (bArr2 != null && bArr2.length > 0) {
                msgBackupMsgEntity.extensionData = MsgBackupJniProxy.encryptFromByteArray(bArr2, MsgBackupManager.E);
            }
        }
    }

    public static void m(MsgBackupResEntity msgBackupResEntity) {
        byte[] bArr;
        String str;
        if (f251422b && msgBackupResEntity != null && (bArr = msgBackupResEntity.extraData) != null && (str = MsgBackupManager.E) != null) {
            msgBackupResEntity.extraData = MsgBackupJniProxy.encryptFromByteArray(bArr, str);
        }
    }

    public static String n(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            D("MsgBackup", "encryptUrlParams key is null", new Object[0]);
        }
        if (f251422b && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            D("MsgBackup", "encryptUrlParams urlParams = %s, encryptkey is not null!", str);
            String encryptFromString = MsgBackupJniProxy.encryptFromString(str, str2);
            D("MsgBackup", "encryptUrlParams params = %s", encryptFromString);
            return encryptFromString;
        }
        return str;
    }

    private static String o(long j3, boolean z16) {
        if (j3 == 0) {
            return "0K";
        }
        if (j3 <= 1024) {
            if (z16) {
                return "1.00K";
            }
            return "1.0K";
        }
        if (j3 >= 1073741824) {
            return ("" + a(j3 / 1.073741824E9d, z16)) + "G";
        }
        if (j3 >= 1048576) {
            if (j3 >= 1048576000) {
                return ("" + a((j3 / 1048576.0d) / 1024.0d, z16)) + "G";
            }
            return ("" + a(j3 / 1048576.0d, z16)) + "M";
        }
        if (j3 < 1024) {
            return "";
        }
        if (j3 >= 1024000) {
            return ("" + a((j3 / 1024.0d) / 1024.0d, z16)) + "M";
        }
        return ("" + a(j3 / 1024.0d, z16)) + "K";
    }

    public static String p(long j3) {
        return o(j3, true);
    }

    public static int q(int i3) {
        if (i3 == 1) {
            return 1;
        }
        if (i3 == 3000) {
            return 2;
        }
        return 3;
    }

    public static String r(j jVar) {
        String format = String.format("%s_%d", jVar.f251082a, Integer.valueOf(q(jVar.f251084c)));
        if (!TextUtils.isEmpty(jVar.f251086e)) {
            format = String.format("%s_%d_%s", jVar.f251082a, Integer.valueOf(q(jVar.f251084c)), jVar.f251086e);
        }
        return a.f251370c + format + DBBackupServiceImpl.DB_FILE_SUFFIX;
    }

    public static String s(String str, int i3, String str2) {
        String format = String.format("%s_%d", str, Integer.valueOf(i3));
        if (!TextUtils.isEmpty(str2)) {
            format = String.format("%s_%d_%s", str, Integer.valueOf(i3), str2);
        }
        return a.f251370c + format + DBBackupServiceImpl.DB_FILE_SUFFIX;
    }

    public static String t(String str, int i3) {
        return str + "_" + i3;
    }

    public static int u(int i3) {
        if (i3 == -1000) {
            return 1;
        }
        return 2;
    }

    public static String v(String str) {
        return a.f251369b + str;
    }

    public static int x(int i3) {
        if (i3 == 1) {
            return 1;
        }
        if (i3 == 2) {
            return 3000;
        }
        return 0;
    }

    public static long y() {
        long j3 = f251426f.get();
        f251426f.set(1 + j3);
        return j3;
    }

    public static String z(String str, int i3) {
        String str2;
        if (IPAddressUtil.isIPv6LiteralAddress(str)) {
            str2 = "http://[%s]:%d/";
        } else {
            str2 = "http://%s:%d/";
        }
        return String.format(str2, str, Integer.valueOf(i3));
    }

    public static String w(String str) {
        return str;
    }
}
