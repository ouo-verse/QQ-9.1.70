package NS_MOBILE_OPERATION;

import java.io.Serializable;

/* compiled from: P */
/* loaded from: classes.dex */
public final class enum_mood_modify_define implements Serializable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final int _enum_modify_content = 1;
    public static final int _enum_modify_ugcright = 2;
    private String __T;
    private int __value;
    private static enum_mood_modify_define[] __values = new enum_mood_modify_define[1];
    public static final enum_mood_modify_define enum_modify_content = new enum_mood_modify_define(0, 1, "enum_modify_content");

    enum_mood_modify_define(int i3, int i16, String str) {
        new String();
        this.__T = str;
        this.__value = i16;
        __values[i3] = this;
    }

    public static enum_mood_modify_define convert(int i3) {
        int i16 = 0;
        while (true) {
            enum_mood_modify_define[] enum_mood_modify_defineVarArr = __values;
            if (i16 >= enum_mood_modify_defineVarArr.length) {
                return null;
            }
            if (enum_mood_modify_defineVarArr[i16].value() == i3) {
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

    public static enum_mood_modify_define convert(String str) {
        int i3 = 0;
        while (true) {
            enum_mood_modify_define[] enum_mood_modify_defineVarArr = __values;
            if (i3 >= enum_mood_modify_defineVarArr.length) {
                return null;
            }
            if (enum_mood_modify_defineVarArr[i3].toString().equals(str)) {
                return __values[i3];
            }
            i3++;
        }
    }
}
