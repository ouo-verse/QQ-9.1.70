package RegisterProxySvcPack;

import java.io.Serializable;

/* compiled from: P */
/* loaded from: classes.dex */
public final class eDisGroupInfoFlag implements Serializable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final int _E_DIS_GROUP_ADD = 1;
    public static final int _E_DIS_GROUP_DEFAULT = -1;
    public static final int _E_DIS_GROUP_DEL = 3;
    public static final int _E_DIS_GROUP_EXIST_C = 4;
    public static final int _E_DIS_GROUP_EXIST_CS = 0;
    public static final int _E_DIS_GROUP_INVALID = 2;
    private String __T;
    private int __value;

    /* renamed from: d, reason: collision with root package name */
    private static eDisGroupInfoFlag[] f25096d = new eDisGroupInfoFlag[6];
    public static final eDisGroupInfoFlag E_DIS_GROUP_DEFAULT = new eDisGroupInfoFlag(0, -1, "E_DIS_GROUP_DEFAULT");
    public static final eDisGroupInfoFlag E_DIS_GROUP_EXIST_CS = new eDisGroupInfoFlag(1, 0, "E_DIS_GROUP_EXIST_CS");
    public static final eDisGroupInfoFlag E_DIS_GROUP_ADD = new eDisGroupInfoFlag(2, 1, "E_DIS_GROUP_ADD");
    public static final eDisGroupInfoFlag E_DIS_GROUP_INVALID = new eDisGroupInfoFlag(3, 2, "E_DIS_GROUP_INVALID");
    public static final eDisGroupInfoFlag E_DIS_GROUP_DEL = new eDisGroupInfoFlag(4, 3, "E_DIS_GROUP_DEL");
    public static final eDisGroupInfoFlag E_DIS_GROUP_EXIST_C = new eDisGroupInfoFlag(5, 4, "E_DIS_GROUP_EXIST_C");

    eDisGroupInfoFlag(int i3, int i16, String str) {
        new String();
        this.__T = str;
        this.__value = i16;
        f25096d[i3] = this;
    }

    public static eDisGroupInfoFlag convert(int i3) {
        int i16 = 0;
        while (true) {
            eDisGroupInfoFlag[] edisgroupinfoflagArr = f25096d;
            if (i16 >= edisgroupinfoflagArr.length) {
                return null;
            }
            if (edisgroupinfoflagArr[i16].value() == i3) {
                return f25096d[i16];
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

    public static eDisGroupInfoFlag convert(String str) {
        int i3 = 0;
        while (true) {
            eDisGroupInfoFlag[] edisgroupinfoflagArr = f25096d;
            if (i3 >= edisgroupinfoflagArr.length) {
                return null;
            }
            if (edisgroupinfoflagArr[i3].toString().equals(str)) {
                return f25096d[i3];
            }
            i3++;
        }
    }
}
