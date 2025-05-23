package NeighborComm;

import java.io.Serializable;

/* compiled from: P */
/* loaded from: classes.dex */
public final class MerchantType implements Serializable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final int _MerchantType_Nomal = 0;
    private String __T;
    private int __value;

    /* renamed from: d, reason: collision with root package name */
    private static MerchantType[] f25077d = new MerchantType[1];
    public static final MerchantType MerchantType_Nomal = new MerchantType(0, 0, "MerchantType_Nomal");

    MerchantType(int i3, int i16, String str) {
        new String();
        this.__T = str;
        this.__value = i16;
        f25077d[i3] = this;
    }

    public static MerchantType convert(int i3) {
        int i16 = 0;
        while (true) {
            MerchantType[] merchantTypeArr = f25077d;
            if (i16 >= merchantTypeArr.length) {
                return null;
            }
            if (merchantTypeArr[i16].value() == i3) {
                return f25077d[i16];
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

    public static MerchantType convert(String str) {
        int i3 = 0;
        while (true) {
            MerchantType[] merchantTypeArr = f25077d;
            if (i3 >= merchantTypeArr.length) {
                return null;
            }
            if (merchantTypeArr[i3].toString().equals(str)) {
                return f25077d[i3];
            }
            i3++;
        }
    }
}
