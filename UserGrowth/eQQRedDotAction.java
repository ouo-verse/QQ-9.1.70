package UserGrowth;

import java.io.Serializable;

/* compiled from: P */
/* loaded from: classes.dex */
public final class eQQRedDotAction implements Serializable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final int _eQQRedDotActionExpose = 2;
    public static final int _eQQRedDotActionRequest = 1;
    private String __T;
    private int __value;
    private static eQQRedDotAction[] __values = new eQQRedDotAction[2];
    public static final eQQRedDotAction eQQRedDotActionRequest = new eQQRedDotAction(0, 1, "eQQRedDotActionRequest");
    public static final eQQRedDotAction eQQRedDotActionExpose = new eQQRedDotAction(1, 2, "eQQRedDotActionExpose");

    eQQRedDotAction(int i3, int i16, String str) {
        new String();
        this.__T = str;
        this.__value = i16;
        __values[i3] = this;
    }

    public static eQQRedDotAction convert(int i3) {
        int i16 = 0;
        while (true) {
            eQQRedDotAction[] eqqreddotactionArr = __values;
            if (i16 >= eqqreddotactionArr.length) {
                return null;
            }
            if (eqqreddotactionArr[i16].value() == i3) {
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

    public static eQQRedDotAction convert(String str) {
        int i3 = 0;
        while (true) {
            eQQRedDotAction[] eqqreddotactionArr = __values;
            if (i3 >= eqqreddotactionArr.length) {
                return null;
            }
            if (eqqreddotactionArr[i3].toString().equals(str)) {
                return __values[i3];
            }
            i3++;
        }
    }
}
