package SLICE_UPLOAD;

import java.io.Serializable;

/* loaded from: classes.dex */
public final class DUMP_BUSSINESS_ID implements Serializable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final int _DUMP_BUSSINESS_DEFAULT = 0;
    public static final int _DUMP_BUSSINESS_WEISHI = 1;
    private String __T;
    private int __value;
    private static DUMP_BUSSINESS_ID[] __values = new DUMP_BUSSINESS_ID[2];
    public static final DUMP_BUSSINESS_ID DUMP_BUSSINESS_DEFAULT = new DUMP_BUSSINESS_ID(0, 0, "DUMP_BUSSINESS_DEFAULT");
    public static final DUMP_BUSSINESS_ID DUMP_BUSSINESS_WEISHI = new DUMP_BUSSINESS_ID(1, 1, "DUMP_BUSSINESS_WEISHI");

    DUMP_BUSSINESS_ID(int i3, int i16, String str) {
        new String();
        this.__T = str;
        this.__value = i16;
        __values[i3] = this;
    }

    public static DUMP_BUSSINESS_ID convert(int i3) {
        int i16 = 0;
        while (true) {
            DUMP_BUSSINESS_ID[] dump_bussiness_idArr = __values;
            if (i16 >= dump_bussiness_idArr.length) {
                return null;
            }
            if (dump_bussiness_idArr[i16].value() == i3) {
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

    public static DUMP_BUSSINESS_ID convert(String str) {
        int i3 = 0;
        while (true) {
            DUMP_BUSSINESS_ID[] dump_bussiness_idArr = __values;
            if (i3 >= dump_bussiness_idArr.length) {
                return null;
            }
            if (dump_bussiness_idArr[i3].toString().equals(str)) {
                return __values[i3];
            }
            i3++;
        }
    }
}
