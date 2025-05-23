package j2;

/* compiled from: P */
/* loaded from: classes2.dex */
public class c {
    public static boolean a(String str, String str2) {
        if (str == null && str2 == null) {
            return true;
        }
        if (str != null && str2 != null) {
            return str.equals(str2);
        }
        if (str == null) {
            if (str2.trim().length() == 0) {
                return true;
            }
            return false;
        }
        if (str.trim().length() == 0) {
            return true;
        }
        return false;
    }
}
