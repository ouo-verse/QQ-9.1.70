package UserGrowth;

import java.io.Serializable;

/* compiled from: P */
/* loaded from: classes.dex */
public final class EnumMsgContentTemplate implements Serializable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final int _eHasBtnAndHasPic = 4;
    public static final int _eHasBtnAndNoPic = 3;
    public static final int _eNoBtnAndHasPic = 2;
    public static final int _eNoBtnAndNoPic = 1;
    private String __T;
    private int __value;
    private static EnumMsgContentTemplate[] __values = new EnumMsgContentTemplate[4];
    public static final EnumMsgContentTemplate eNoBtnAndNoPic = new EnumMsgContentTemplate(0, 1, "eNoBtnAndNoPic");
    public static final EnumMsgContentTemplate eNoBtnAndHasPic = new EnumMsgContentTemplate(1, 2, "eNoBtnAndHasPic");
    public static final EnumMsgContentTemplate eHasBtnAndNoPic = new EnumMsgContentTemplate(2, 3, "eHasBtnAndNoPic");
    public static final EnumMsgContentTemplate eHasBtnAndHasPic = new EnumMsgContentTemplate(3, 4, "eHasBtnAndHasPic");

    EnumMsgContentTemplate(int i3, int i16, String str) {
        new String();
        this.__T = str;
        this.__value = i16;
        __values[i3] = this;
    }

    public static EnumMsgContentTemplate convert(int i3) {
        int i16 = 0;
        while (true) {
            EnumMsgContentTemplate[] enumMsgContentTemplateArr = __values;
            if (i16 >= enumMsgContentTemplateArr.length) {
                return null;
            }
            if (enumMsgContentTemplateArr[i16].value() == i3) {
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

    public static EnumMsgContentTemplate convert(String str) {
        int i3 = 0;
        while (true) {
            EnumMsgContentTemplate[] enumMsgContentTemplateArr = __values;
            if (i3 >= enumMsgContentTemplateArr.length) {
                return null;
            }
            if (enumMsgContentTemplateArr[i3].toString().equals(str)) {
                return __values[i3];
            }
            i3++;
        }
    }
}
