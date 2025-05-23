package UserGrowth;

import java.io.Serializable;

/* compiled from: P */
/* loaded from: classes.dex */
public final class eFeedType implements Serializable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final int _eFeedTypeFriendFeeds = 4;
    public static final int _eFeedTypePerson = 1;
    public static final int _eFeedTypeSplitBlock = 3;
    public static final int _eFeedTypeVideo = 2;
    private String __T;
    private int __value;
    private static eFeedType[] __values = new eFeedType[4];
    public static final eFeedType eFeedTypePerson = new eFeedType(0, 1, "eFeedTypePerson");
    public static final eFeedType eFeedTypeVideo = new eFeedType(1, 2, "eFeedTypeVideo");
    public static final eFeedType eFeedTypeSplitBlock = new eFeedType(2, 3, "eFeedTypeSplitBlock");
    public static final eFeedType eFeedTypeFriendFeeds = new eFeedType(3, 4, "eFeedTypeFriendFeeds");

    eFeedType(int i3, int i16, String str) {
        new String();
        this.__T = str;
        this.__value = i16;
        __values[i3] = this;
    }

    public static eFeedType convert(int i3) {
        int i16 = 0;
        while (true) {
            eFeedType[] efeedtypeArr = __values;
            if (i16 >= efeedtypeArr.length) {
                return null;
            }
            if (efeedtypeArr[i16].value() == i3) {
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

    public static eFeedType convert(String str) {
        int i3 = 0;
        while (true) {
            eFeedType[] efeedtypeArr = __values;
            if (i3 >= efeedtypeArr.length) {
                return null;
            }
            if (efeedtypeArr[i3].toString().equals(str)) {
                return __values[i3];
            }
            i3++;
        }
    }
}
