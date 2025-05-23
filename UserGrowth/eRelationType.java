package UserGrowth;

import java.io.Serializable;

/* compiled from: P */
/* loaded from: classes.dex */
public final class eRelationType implements Serializable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final int _eRelationTypeMajorFriend = 1;
    public static final int _eRelationTypeMinorFriend = 2;
    public static final int _eRelationTypeNotFriend = 0;
    private String __T;
    private int __value;
    private static eRelationType[] __values = new eRelationType[3];
    public static final eRelationType eRelationTypeNotFriend = new eRelationType(0, 0, "eRelationTypeNotFriend");
    public static final eRelationType eRelationTypeMajorFriend = new eRelationType(1, 1, "eRelationTypeMajorFriend");
    public static final eRelationType eRelationTypeMinorFriend = new eRelationType(2, 2, "eRelationTypeMinorFriend");

    eRelationType(int i3, int i16, String str) {
        new String();
        this.__T = str;
        this.__value = i16;
        __values[i3] = this;
    }

    public static eRelationType convert(int i3) {
        int i16 = 0;
        while (true) {
            eRelationType[] erelationtypeArr = __values;
            if (i16 >= erelationtypeArr.length) {
                return null;
            }
            if (erelationtypeArr[i16].value() == i3) {
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

    public static eRelationType convert(String str) {
        int i3 = 0;
        while (true) {
            eRelationType[] erelationtypeArr = __values;
            if (i3 >= erelationtypeArr.length) {
                return null;
            }
            if (erelationtypeArr[i3].toString().equals(str)) {
                return __values[i3];
            }
            i3++;
        }
    }
}
