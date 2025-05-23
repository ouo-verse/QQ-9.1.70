package AccostSvc;

import java.io.Serializable;

/* compiled from: P */
/* loaded from: classes.dex */
public final class MqqSysType implements Serializable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final int _MqqSysType_Android = 2;
    public static final int _MqqSysType_HD = 6;
    public static final int _MqqSysType_HD_MINI = 7;
    public static final int _MqqSysType_Iphone = 1;
    public static final int _MqqSysType_MTK = 8;
    public static final int _MqqSysType_Symbian_V3 = 5;
    public static final int _MqqSysType_Symbian_V5 = 3;
    public static final int _MqqSysType_WP7 = 4;
    public static final int _MqqSysType_default = 0;
    private String __T;
    private int __value;

    /* renamed from: d, reason: collision with root package name */
    private static MqqSysType[] f24894d = new MqqSysType[9];
    public static final MqqSysType MqqSysType_default = new MqqSysType(0, 0, "MqqSysType_default");
    public static final MqqSysType MqqSysType_Iphone = new MqqSysType(1, 1, "MqqSysType_Iphone");
    public static final MqqSysType MqqSysType_Android = new MqqSysType(2, 2, "MqqSysType_Android");
    public static final MqqSysType MqqSysType_Symbian_V5 = new MqqSysType(3, 3, "MqqSysType_Symbian_V5");
    public static final MqqSysType MqqSysType_WP7 = new MqqSysType(4, 4, "MqqSysType_WP7");
    public static final MqqSysType MqqSysType_Symbian_V3 = new MqqSysType(5, 5, "MqqSysType_Symbian_V3");
    public static final MqqSysType MqqSysType_HD = new MqqSysType(6, 6, "MqqSysType_HD");
    public static final MqqSysType MqqSysType_HD_MINI = new MqqSysType(7, 7, "MqqSysType_HD_MINI");
    public static final MqqSysType MqqSysType_MTK = new MqqSysType(8, 8, "MqqSysType_MTK");

    MqqSysType(int i3, int i16, String str) {
        new String();
        this.__T = str;
        this.__value = i16;
        f24894d[i3] = this;
    }

    public static MqqSysType convert(int i3) {
        int i16 = 0;
        while (true) {
            MqqSysType[] mqqSysTypeArr = f24894d;
            if (i16 >= mqqSysTypeArr.length) {
                return null;
            }
            if (mqqSysTypeArr[i16].value() == i3) {
                return f24894d[i16];
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

    public static MqqSysType convert(String str) {
        int i3 = 0;
        while (true) {
            MqqSysType[] mqqSysTypeArr = f24894d;
            if (i3 >= mqqSysTypeArr.length) {
                return null;
            }
            if (mqqSysTypeArr[i3].toString().equals(str)) {
                return f24894d[i3];
            }
            i3++;
        }
    }
}
