package NeighborComm;

import java.io.Serializable;

/* compiled from: P */
/* loaded from: classes.dex */
public final class LocalInfoType implements Serializable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final int _LocalInfoType_Decode = 0;
    public static final int _LocalInfoType_Encode = 1;
    public static final int _LocalInfoType_SOSO = 2;
    private String __T;
    private int __value;

    /* renamed from: d, reason: collision with root package name */
    private static LocalInfoType[] f25076d = new LocalInfoType[3];
    public static final LocalInfoType LocalInfoType_Decode = new LocalInfoType(0, 0, "LocalInfoType_Decode");
    public static final LocalInfoType LocalInfoType_Encode = new LocalInfoType(1, 1, "LocalInfoType_Encode");
    public static final LocalInfoType LocalInfoType_SOSO = new LocalInfoType(2, 2, "LocalInfoType_SOSO");

    LocalInfoType(int i3, int i16, String str) {
        new String();
        this.__T = str;
        this.__value = i16;
        f25076d[i3] = this;
    }

    public static LocalInfoType convert(int i3) {
        int i16 = 0;
        while (true) {
            LocalInfoType[] localInfoTypeArr = f25076d;
            if (i16 >= localInfoTypeArr.length) {
                return null;
            }
            if (localInfoTypeArr[i16].value() == i3) {
                return f25076d[i16];
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

    public static LocalInfoType convert(String str) {
        int i3 = 0;
        while (true) {
            LocalInfoType[] localInfoTypeArr = f25076d;
            if (i3 >= localInfoTypeArr.length) {
                return null;
            }
            if (localInfoTypeArr[i3].toString().equals(str)) {
                return f25076d[i3];
            }
            i3++;
        }
    }
}
