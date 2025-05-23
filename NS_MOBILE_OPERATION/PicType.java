package NS_MOBILE_OPERATION;

import java.io.Serializable;

/* loaded from: classes.dex */
public final class PicType implements Serializable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final int _ENUM_PIC_GIF = 2;
    public static final int _ENUM_PIC_JPG = 1;
    public static final int _ENUM_PIC_PNG = 3;
    private String __T;
    private int __value;
    private static PicType[] __values = new PicType[3];
    public static final PicType ENUM_PIC_JPG = new PicType(0, 1, "ENUM_PIC_JPG");
    public static final PicType ENUM_PIC_GIF = new PicType(1, 2, "ENUM_PIC_GIF");
    public static final PicType ENUM_PIC_PNG = new PicType(2, 3, "ENUM_PIC_PNG");

    PicType(int i3, int i16, String str) {
        new String();
        this.__T = str;
        this.__value = i16;
        __values[i3] = this;
    }

    public static PicType convert(int i3) {
        int i16 = 0;
        while (true) {
            PicType[] picTypeArr = __values;
            if (i16 >= picTypeArr.length) {
                return null;
            }
            if (picTypeArr[i16].value() == i3) {
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

    public static PicType convert(String str) {
        int i3 = 0;
        while (true) {
            PicType[] picTypeArr = __values;
            if (i3 >= picTypeArr.length) {
                return null;
            }
            if (picTypeArr[i3].toString().equals(str)) {
                return __values[i3];
            }
            i3++;
        }
    }
}
