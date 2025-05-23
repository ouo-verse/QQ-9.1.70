package QQService;

import java.io.Serializable;

/* loaded from: classes.dex */
public final class EVIPSPEC implements Serializable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final int _E_SP_BIGCLUB = 7;
    public static final int _E_SP_PAY_MUSIC_PACKAGE = 6;
    public static final int _E_SP_QQREADING_VIP = 5;
    public static final int _E_SP_QQVIDEO_HOLLYWOOD = 4;
    public static final int _E_SP_QQVIP = 1;
    public static final int _E_SP_SUPERQQ = 2;
    public static final int _E_SP_SUPERVIP = 3;
    private String __T;
    private int __value;

    /* renamed from: d, reason: collision with root package name */
    private static EVIPSPEC[] f25087d = new EVIPSPEC[7];
    public static final EVIPSPEC E_SP_QQVIP = new EVIPSPEC(0, 1, "E_SP_QQVIP");
    public static final EVIPSPEC E_SP_SUPERQQ = new EVIPSPEC(1, 2, "E_SP_SUPERQQ");
    public static final EVIPSPEC E_SP_SUPERVIP = new EVIPSPEC(2, 3, "E_SP_SUPERVIP");
    public static final EVIPSPEC E_SP_QQVIDEO_HOLLYWOOD = new EVIPSPEC(3, 4, "E_SP_QQVIDEO_HOLLYWOOD");
    public static final EVIPSPEC E_SP_QQREADING_VIP = new EVIPSPEC(4, 5, "E_SP_QQREADING_VIP");
    public static final EVIPSPEC E_SP_PAY_MUSIC_PACKAGE = new EVIPSPEC(5, 6, "E_SP_PAY_MUSIC_PACKAGE");
    public static final EVIPSPEC E_SP_BIGCLUB = new EVIPSPEC(6, 7, "E_SP_BIGCLUB");

    EVIPSPEC(int i3, int i16, String str) {
        new String();
        this.__T = str;
        this.__value = i16;
        f25087d[i3] = this;
    }

    public static EVIPSPEC convert(int i3) {
        int i16 = 0;
        while (true) {
            EVIPSPEC[] evipspecArr = f25087d;
            if (i16 >= evipspecArr.length) {
                return null;
            }
            if (evipspecArr[i16].value() == i3) {
                return f25087d[i16];
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

    public static EVIPSPEC convert(String str) {
        int i3 = 0;
        while (true) {
            EVIPSPEC[] evipspecArr = f25087d;
            if (i3 >= evipspecArr.length) {
                return null;
            }
            if (evipspecArr[i3].toString().equals(str)) {
                return f25087d[i3];
            }
            i3++;
        }
    }
}
