package ct3;

import android.os.Parcelable;
import com.tencent.mobileqq.app.QMMKVFile;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes22.dex */
public class a {
    private static String a(String str, long j3) {
        return b(str, String.valueOf(j3));
    }

    private static String b(String str, String str2) {
        return str + str2;
    }

    public static boolean c(String str) {
        return f().decodeBool(str, true);
    }

    public static boolean d(String str, long j3) {
        return f().decodeBool(a(str, j3), false);
    }

    public static boolean e(String str, boolean z16) {
        return f().decodeBool(str, z16);
    }

    private static MMKVOptionEntity f() {
        return QMMKV.from(MobileQQ.sMobileQQ, QMMKVFile.FILE_QQLIVE);
    }

    public static int g(String str, int i3) {
        return f().decodeInt(str, i3);
    }

    public static long h(String str, long j3) {
        String a16 = a(str, j3);
        MMKVOptionEntity f16 = f();
        if (!f16.containsKey(a16)) {
            return 0L;
        }
        return f16.decodeLong(a16, 0L);
    }

    public static <T extends Parcelable> T i(String str, Class<T> cls, long j3) {
        String a16 = a(str, j3);
        MMKVOptionEntity f16 = f();
        if (!f16.containsKey(a16)) {
            return null;
        }
        return (T) f16.decodeParcelable(a16, cls, null);
    }

    public static <T extends Parcelable> T j(String str, Class<T> cls, String str2) {
        String b16 = b(str, str2);
        MMKVOptionEntity f16 = f();
        if (!f16.containsKey(b16)) {
            return null;
        }
        return (T) f16.decodeParcelable(b16, cls, null);
    }

    public static String k(String str, long j3) {
        return f().decodeString(a(str, j3), "");
    }

    public static String l(String str, String str2) {
        return f().decodeString(str, str2);
    }

    public static void m(String str, long j3) {
        f().removeKey(a(str, j3)).commitAsync();
    }

    public static void n(String str, long j3, boolean z16) {
        f().encodeBool(a(str, j3), z16).commitAsync();
    }

    public static void o(String str, boolean z16) {
        f().encodeBool(str, z16);
    }

    public static void p(String str, int i3) {
        f().encodeInt(str, i3);
    }

    public static void q(String str, long j3, long j16) {
        f().encodeLong(a(str, j3), j16).commitAsync();
    }

    public static void r(String str, long j3, Parcelable parcelable) {
        f().encodeParcelable(a(str, j3), parcelable).commitAsync();
    }

    public static void s(String str, long j3, String str2) {
        f().encodeString(a(str, j3), str2).commitAsync();
    }

    public static void t(String str, String str2) {
        f().encodeString(str, str2).commitAsync();
    }
}
