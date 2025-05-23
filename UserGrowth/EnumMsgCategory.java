package UserGrowth;

import java.io.Serializable;

/* compiled from: P */
/* loaded from: classes.dex */
public final class EnumMsgCategory implements Serializable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final int _eCommentType = 7;
    public static final int _eDingType = 2;
    public static final int _eFollowType = 4;
    public static final int _eFrdTAb = 6;
    public static final int _ePriMsgType = 5;
    public static final int _eRelatedToMeType = 1;
    public static final int _eRichDingType = 3;
    private String __T;
    private int __value;
    private static EnumMsgCategory[] __values = new EnumMsgCategory[7];
    public static final EnumMsgCategory eRelatedToMeType = new EnumMsgCategory(0, 1, "eRelatedToMeType");
    public static final EnumMsgCategory eDingType = new EnumMsgCategory(1, 2, "eDingType");
    public static final EnumMsgCategory eRichDingType = new EnumMsgCategory(2, 3, "eRichDingType");
    public static final EnumMsgCategory eFollowType = new EnumMsgCategory(3, 4, "eFollowType");
    public static final EnumMsgCategory ePriMsgType = new EnumMsgCategory(4, 5, "ePriMsgType");
    public static final EnumMsgCategory eFrdTAb = new EnumMsgCategory(5, 6, "eFrdTAb");
    public static final EnumMsgCategory eCommentType = new EnumMsgCategory(6, 7, "eCommentType");

    EnumMsgCategory(int i3, int i16, String str) {
        new String();
        this.__T = str;
        this.__value = i16;
        __values[i3] = this;
    }

    public static EnumMsgCategory convert(int i3) {
        int i16 = 0;
        while (true) {
            EnumMsgCategory[] enumMsgCategoryArr = __values;
            if (i16 >= enumMsgCategoryArr.length) {
                return null;
            }
            if (enumMsgCategoryArr[i16].value() == i3) {
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

    public static EnumMsgCategory convert(String str) {
        int i3 = 0;
        while (true) {
            EnumMsgCategory[] enumMsgCategoryArr = __values;
            if (i3 >= enumMsgCategoryArr.length) {
                return null;
            }
            if (enumMsgCategoryArr[i3].toString().equals(str)) {
                return __values[i3];
            }
            i3++;
        }
    }
}
