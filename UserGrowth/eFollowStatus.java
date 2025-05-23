package UserGrowth;

import java.io.Serializable;

/* compiled from: P */
/* loaded from: classes.dex */
public final class eFollowStatus implements Serializable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final int _eStatusBidirectFollow = 3;
    public static final int _eStatusDoesNotFollow = 2;
    public static final int _eStatusHasFollow = 1;
    public static final int _eStatusHasReverseFollow = 4;
    public static final int _eStatusNoFollow = 0;
    private String __T;
    private int __value;
    private static eFollowStatus[] __values = new eFollowStatus[5];
    public static final eFollowStatus eStatusNoFollow = new eFollowStatus(0, 0, "eStatusNoFollow");
    public static final eFollowStatus eStatusHasFollow = new eFollowStatus(1, 1, "eStatusHasFollow");
    public static final eFollowStatus eStatusDoesNotFollow = new eFollowStatus(2, 2, "eStatusDoesNotFollow");
    public static final eFollowStatus eStatusBidirectFollow = new eFollowStatus(3, 3, "eStatusBidirectFollow");
    public static final eFollowStatus eStatusHasReverseFollow = new eFollowStatus(4, 4, "eStatusHasReverseFollow");

    eFollowStatus(int i3, int i16, String str) {
        new String();
        this.__T = str;
        this.__value = i16;
        __values[i3] = this;
    }

    public static eFollowStatus convert(int i3) {
        int i16 = 0;
        while (true) {
            eFollowStatus[] efollowstatusArr = __values;
            if (i16 >= efollowstatusArr.length) {
                return null;
            }
            if (efollowstatusArr[i16].value() == i3) {
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

    public static eFollowStatus convert(String str) {
        int i3 = 0;
        while (true) {
            eFollowStatus[] efollowstatusArr = __values;
            if (i3 >= efollowstatusArr.length) {
                return null;
            }
            if (efollowstatusArr[i3].toString().equals(str)) {
                return __values[i3];
            }
            i3++;
        }
    }
}
