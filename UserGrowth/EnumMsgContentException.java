package UserGrowth;

import java.io.Serializable;

/* compiled from: P */
/* loaded from: classes.dex */
public final class EnumMsgContentException implements Serializable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final int _eCommentDel = 16;
    public static final int _eDescCommentDel = 64;
    public static final int _eFeedDel = 8;
    public static final int _eFeedHit = 2;
    public static final int _eFeedPrivate = 4;
    public static final int _eNotSupplement = 32;
    public static final int _eOperHit = 1;
    private String __T;
    private int __value;
    private static EnumMsgContentException[] __values = new EnumMsgContentException[7];
    public static final EnumMsgContentException eOperHit = new EnumMsgContentException(0, 1, "eOperHit");
    public static final EnumMsgContentException eFeedHit = new EnumMsgContentException(1, 2, "eFeedHit");
    public static final EnumMsgContentException eFeedPrivate = new EnumMsgContentException(2, 4, "eFeedPrivate");
    public static final EnumMsgContentException eFeedDel = new EnumMsgContentException(3, 8, "eFeedDel");
    public static final EnumMsgContentException eCommentDel = new EnumMsgContentException(4, 16, "eCommentDel");
    public static final EnumMsgContentException eNotSupplement = new EnumMsgContentException(5, 32, "eNotSupplement");
    public static final EnumMsgContentException eDescCommentDel = new EnumMsgContentException(6, 64, "eDescCommentDel");

    EnumMsgContentException(int i3, int i16, String str) {
        new String();
        this.__T = str;
        this.__value = i16;
        __values[i3] = this;
    }

    public static EnumMsgContentException convert(int i3) {
        int i16 = 0;
        while (true) {
            EnumMsgContentException[] enumMsgContentExceptionArr = __values;
            if (i16 >= enumMsgContentExceptionArr.length) {
                return null;
            }
            if (enumMsgContentExceptionArr[i16].value() == i3) {
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

    public static EnumMsgContentException convert(String str) {
        int i3 = 0;
        while (true) {
            EnumMsgContentException[] enumMsgContentExceptionArr = __values;
            if (i3 >= enumMsgContentExceptionArr.length) {
                return null;
            }
            if (enumMsgContentExceptionArr[i3].toString().equals(str)) {
                return __values[i3];
            }
            i3++;
        }
    }
}
