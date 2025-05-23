package UserGrowth;

import java.io.Serializable;

/* loaded from: classes.dex */
public final class eLandingPage implements Serializable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final int _eLandingPageFallList = 0;
    public static final int _eLandingPageVideoPage = 1;
    private String __T;
    private int __value;
    private static eLandingPage[] __values = new eLandingPage[2];
    public static final eLandingPage eLandingPageFallList = new eLandingPage(0, 0, "eLandingPageFallList");
    public static final eLandingPage eLandingPageVideoPage = new eLandingPage(1, 1, "eLandingPageVideoPage");

    eLandingPage(int i3, int i16, String str) {
        new String();
        this.__T = str;
        this.__value = i16;
        __values[i3] = this;
    }

    public static eLandingPage convert(int i3) {
        int i16 = 0;
        while (true) {
            eLandingPage[] elandingpageArr = __values;
            if (i16 >= elandingpageArr.length) {
                return null;
            }
            if (elandingpageArr[i16].value() == i3) {
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

    public static eLandingPage convert(String str) {
        int i3 = 0;
        while (true) {
            eLandingPage[] elandingpageArr = __values;
            if (i3 >= elandingpageArr.length) {
                return null;
            }
            if (elandingpageArr[i3].toString().equals(str)) {
                return __values[i3];
            }
            i3++;
        }
    }
}
