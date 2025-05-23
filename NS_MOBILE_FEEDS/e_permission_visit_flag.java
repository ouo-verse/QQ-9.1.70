package NS_MOBILE_FEEDS;

import java.io.Serializable;

/* compiled from: P */
/* loaded from: classes.dex */
public final class e_permission_visit_flag implements Serializable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final int _enum_not_permission_some_fri = 8;
    public static final int _enum_permission_each_other = 7;
    public static final int _enum_permission_feed_safemode = 10;
    public static final int _enum_permission_friend = 4;
    public static final int _enum_permission_passwd = 2;
    public static final int _enum_permission_private = 3;
    public static final int _enum_permission_public = 1;
    public static final int _enum_permission_qa = 5;
    public static final int _enum_permission_secndegrcontac = 9;
    public static final int _enum_permission_some_fri = 6;
    private String __T;
    private int __value;
    private static e_permission_visit_flag[] __values = new e_permission_visit_flag[10];
    public static final e_permission_visit_flag enum_permission_public = new e_permission_visit_flag(0, 1, "enum_permission_public");
    public static final e_permission_visit_flag enum_permission_passwd = new e_permission_visit_flag(1, 2, "enum_permission_passwd");
    public static final e_permission_visit_flag enum_permission_private = new e_permission_visit_flag(2, 3, "enum_permission_private");
    public static final e_permission_visit_flag enum_permission_friend = new e_permission_visit_flag(3, 4, "enum_permission_friend");
    public static final e_permission_visit_flag enum_permission_qa = new e_permission_visit_flag(4, 5, "enum_permission_qa");
    public static final e_permission_visit_flag enum_permission_some_fri = new e_permission_visit_flag(5, 6, "enum_permission_some_fri");
    public static final e_permission_visit_flag enum_permission_each_other = new e_permission_visit_flag(6, 7, "enum_permission_each_other");
    public static final e_permission_visit_flag enum_not_permission_some_fri = new e_permission_visit_flag(7, 8, "enum_not_permission_some_fri");
    public static final e_permission_visit_flag enum_permission_secndegrcontac = new e_permission_visit_flag(8, 9, "enum_permission_secndegrcontac");
    public static final e_permission_visit_flag enum_permission_feed_safemode = new e_permission_visit_flag(9, 10, "enum_permission_feed_safemode");

    e_permission_visit_flag(int i3, int i16, String str) {
        new String();
        this.__T = str;
        this.__value = i16;
        __values[i3] = this;
    }

    public static e_permission_visit_flag convert(int i3) {
        int i16 = 0;
        while (true) {
            e_permission_visit_flag[] e_permission_visit_flagVarArr = __values;
            if (i16 >= e_permission_visit_flagVarArr.length) {
                return null;
            }
            if (e_permission_visit_flagVarArr[i16].value() == i3) {
                return __values[i16];
            }
            i16++;
        }
    }

    public String toString() {
        return this.__T;
    }

    public int value() {
        return this.__value;
    }

    public static e_permission_visit_flag convert(String str) {
        int i3 = 0;
        while (true) {
            e_permission_visit_flag[] e_permission_visit_flagVarArr = __values;
            if (i3 >= e_permission_visit_flagVarArr.length) {
                return null;
            }
            if (e_permission_visit_flagVarArr[i3].toString().equals(str)) {
                return __values[i3];
            }
            i3++;
        }
    }
}
