package UserGrowth;

import java.io.Serializable;

/* compiled from: P */
/* loaded from: classes.dex */
public final class eDarenMedal implements Serializable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final int _eDarenNothing = 0;
    public static final int _eDarenOrganization = 3;
    public static final int _eDarenPartyACertification = 5;
    public static final int _eDarenSenior = 2;
    public static final int _eDarenStar = 4;
    public static final int _eDarenTutor = 1;
    public static final int _eDarenWeseeAuthority = 6;
    private String __T;
    private int __value;
    private static eDarenMedal[] __values = new eDarenMedal[7];
    public static final eDarenMedal eDarenNothing = new eDarenMedal(0, 0, "eDarenNothing");
    public static final eDarenMedal eDarenTutor = new eDarenMedal(1, 1, "eDarenTutor");
    public static final eDarenMedal eDarenSenior = new eDarenMedal(2, 2, "eDarenSenior");
    public static final eDarenMedal eDarenOrganization = new eDarenMedal(3, 3, "eDarenOrganization");
    public static final eDarenMedal eDarenStar = new eDarenMedal(4, 4, "eDarenStar");
    public static final eDarenMedal eDarenPartyACertification = new eDarenMedal(5, 5, "eDarenPartyACertification");
    public static final eDarenMedal eDarenWeseeAuthority = new eDarenMedal(6, 6, "eDarenWeseeAuthority");

    eDarenMedal(int i3, int i16, String str) {
        new String();
        this.__T = str;
        this.__value = i16;
        __values[i3] = this;
    }

    public static eDarenMedal convert(int i3) {
        int i16 = 0;
        while (true) {
            eDarenMedal[] edarenmedalArr = __values;
            if (i16 >= edarenmedalArr.length) {
                return null;
            }
            if (edarenmedalArr[i16].value() == i3) {
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

    public static eDarenMedal convert(String str) {
        int i3 = 0;
        while (true) {
            eDarenMedal[] edarenmedalArr = __values;
            if (i3 >= edarenmedalArr.length) {
                return null;
            }
            if (edarenmedalArr[i3].toString().equals(str)) {
                return __values[i3];
            }
            i3++;
        }
    }
}
