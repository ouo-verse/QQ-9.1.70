package MessageSvcPack;

import java.io.Serializable;

/* compiled from: P */
/* loaded from: classes.dex */
public final class BusinessType implements Serializable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final int _BusinessType_Friend = 1;
    public static final int _BusinessType_LBS_YSS = 101;
    public static final int _BusinessType_MQQ = 0;
    private String __T;
    private int __value;

    /* renamed from: d, reason: collision with root package name */
    private static BusinessType[] f24913d = new BusinessType[3];
    public static final BusinessType BusinessType_MQQ = new BusinessType(0, 0, "BusinessType_MQQ");
    public static final BusinessType BusinessType_Friend = new BusinessType(1, 1, "BusinessType_Friend");
    public static final BusinessType BusinessType_LBS_YSS = new BusinessType(2, 101, "BusinessType_LBS_YSS");

    BusinessType(int i3, int i16, String str) {
        new String();
        this.__T = str;
        this.__value = i16;
        f24913d[i3] = this;
    }

    public static BusinessType convert(int i3) {
        int i16 = 0;
        while (true) {
            BusinessType[] businessTypeArr = f24913d;
            if (i16 >= businessTypeArr.length) {
                return null;
            }
            if (businessTypeArr[i16].value() == i3) {
                return f24913d[i16];
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
            BusinessType[] businessTypeArr = f24913d;
            if (i3 >= businessTypeArr.length) {
                return null;
            }
            if (businessTypeArr[i3].toString().equals(str)) {
                return f24913d[i3];
            }
            i3++;
        }
    }
}
