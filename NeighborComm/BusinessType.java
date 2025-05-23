package NeighborComm;

import java.io.Serializable;

/* compiled from: P */
/* loaded from: classes.dex */
public final class BusinessType implements Serializable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final int _BusinessType_Friend = 1;
    public static final int _BusinessType_MGroup = 2;
    public static final int _BusinessType_MQQ = 0;
    public static final int _BusinessType_TEST = 3;
    private String __T;
    private int __value;

    /* renamed from: d, reason: collision with root package name */
    private static BusinessType[] f25074d = new BusinessType[4];
    public static final BusinessType BusinessType_MQQ = new BusinessType(0, 0, "BusinessType_MQQ");
    public static final BusinessType BusinessType_Friend = new BusinessType(1, 1, "BusinessType_Friend");
    public static final BusinessType BusinessType_MGroup = new BusinessType(2, 2, "BusinessType_MGroup");
    public static final BusinessType BusinessType_TEST = new BusinessType(3, 3, "BusinessType_TEST");

    BusinessType(int i3, int i16, String str) {
        new String();
        this.__T = str;
        this.__value = i16;
        f25074d[i3] = this;
    }

    public static BusinessType convert(int i3) {
        int i16 = 0;
        while (true) {
            BusinessType[] businessTypeArr = f25074d;
            if (i16 >= businessTypeArr.length) {
                return null;
            }
            if (businessTypeArr[i16].value() == i3) {
                return f25074d[i16];
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

    public static BusinessType convert(String str) {
        int i3 = 0;
        while (true) {
            BusinessType[] businessTypeArr = f25074d;
            if (i3 >= businessTypeArr.length) {
                return null;
            }
            if (businessTypeArr[i3].toString().equals(str)) {
                return f25074d[i3];
            }
            i3++;
        }
    }
}
