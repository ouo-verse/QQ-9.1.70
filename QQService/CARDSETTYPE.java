package QQService;

import java.io.Serializable;

/* loaded from: classes.dex */
public final class CARDSETTYPE implements Serializable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final int _TYPE_SET_BACKGROUND = 2;
    public static final int _TYPE_SET_DEFAUT = -1;
    public static final int _TYPE_SET_SINGLE = 0;
    public static final int _TYPE_SET_TAGS = 1;
    public static final int _TYPE_SET_TEMPLATE = 3;
    private String __T;
    private int __value;

    /* renamed from: d, reason: collision with root package name */
    private static CARDSETTYPE[] f25086d = new CARDSETTYPE[5];
    public static final CARDSETTYPE TYPE_SET_DEFAUT = new CARDSETTYPE(0, -1, "TYPE_SET_DEFAUT");
    public static final CARDSETTYPE TYPE_SET_SINGLE = new CARDSETTYPE(1, 0, "TYPE_SET_SINGLE");
    public static final CARDSETTYPE TYPE_SET_TAGS = new CARDSETTYPE(2, 1, "TYPE_SET_TAGS");
    public static final CARDSETTYPE TYPE_SET_BACKGROUND = new CARDSETTYPE(3, 2, "TYPE_SET_BACKGROUND");
    public static final CARDSETTYPE TYPE_SET_TEMPLATE = new CARDSETTYPE(4, 3, "TYPE_SET_TEMPLATE");

    CARDSETTYPE(int i3, int i16, String str) {
        new String();
        this.__T = str;
        this.__value = i16;
        f25086d[i3] = this;
    }

    public static CARDSETTYPE convert(int i3) {
        int i16 = 0;
        while (true) {
            CARDSETTYPE[] cardsettypeArr = f25086d;
            if (i16 >= cardsettypeArr.length) {
                return null;
            }
            if (cardsettypeArr[i16].value() == i3) {
                return f25086d[i16];
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

    public static CARDSETTYPE convert(String str) {
        int i3 = 0;
        while (true) {
            CARDSETTYPE[] cardsettypeArr = f25086d;
            if (i3 >= cardsettypeArr.length) {
                return null;
            }
            if (cardsettypeArr[i3].toString().equals(str)) {
                return f25086d[i3];
            }
            i3++;
        }
    }
}
