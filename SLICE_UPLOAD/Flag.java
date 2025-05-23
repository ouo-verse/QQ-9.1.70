package SLICE_UPLOAD;

import java.io.Serializable;

/* compiled from: P */
/* loaded from: classes.dex */
public final class Flag implements Serializable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final int _FLAG_COMPOSITE_FILE_COMPLETE = 3;
    public static final int _FLAG_ERROR = 10;
    public static final int _FLAG_FILECOMPLETE = 1;
    public static final int _FLAG_FILENEEDCOMMIT = 2;
    public static final int _FLAG_OVERWRITE_RETRY_COMMIT = 15;
    public static final int _FLAG_OVERWRITE_RETRY_CTRL_NOSESSION = 16;
    public static final int _FLAG_RETRY_CTRL_NOSESSION = 13;
    public static final int _FLAG_RETRY_CTRL_SESSION = 12;
    public static final int _FLAG_RETRY_CURRENT = 11;
    public static final int _FLAG_RETRY_RECONNECT_CTRL_NOSESSION = 14;
    public static final int _FLAG_SUCC = 0;
    private String __T;
    private int __value;
    private static Flag[] __values = new Flag[11];
    public static final Flag FLAG_SUCC = new Flag(0, 0, "FLAG_SUCC");
    public static final Flag FLAG_FILECOMPLETE = new Flag(1, 1, "FLAG_FILECOMPLETE");
    public static final Flag FLAG_FILENEEDCOMMIT = new Flag(2, 2, "FLAG_FILENEEDCOMMIT");
    public static final Flag FLAG_COMPOSITE_FILE_COMPLETE = new Flag(3, 3, "FLAG_COMPOSITE_FILE_COMPLETE");
    public static final Flag FLAG_ERROR = new Flag(4, 10, "FLAG_ERROR");
    public static final Flag FLAG_RETRY_CURRENT = new Flag(5, 11, "FLAG_RETRY_CURRENT");
    public static final Flag FLAG_RETRY_CTRL_SESSION = new Flag(6, 12, "FLAG_RETRY_CTRL_SESSION");
    public static final Flag FLAG_RETRY_CTRL_NOSESSION = new Flag(7, 13, "FLAG_RETRY_CTRL_NOSESSION");
    public static final Flag FLAG_RETRY_RECONNECT_CTRL_NOSESSION = new Flag(8, 14, "FLAG_RETRY_RECONNECT_CTRL_NOSESSION");
    public static final Flag FLAG_OVERWRITE_RETRY_COMMIT = new Flag(9, 15, "FLAG_OVERWRITE_RETRY_COMMIT");
    public static final Flag FLAG_OVERWRITE_RETRY_CTRL_NOSESSION = new Flag(10, 16, "FLAG_OVERWRITE_RETRY_CTRL_NOSESSION");

    Flag(int i3, int i16, String str) {
        new String();
        this.__T = str;
        this.__value = i16;
        __values[i3] = this;
    }

    public static Flag convert(int i3) {
        int i16 = 0;
        while (true) {
            Flag[] flagArr = __values;
            if (i16 >= flagArr.length) {
                return null;
            }
            if (flagArr[i16].value() == i3) {
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

    public static Flag convert(String str) {
        int i3 = 0;
        while (true) {
            Flag[] flagArr = __values;
            if (i3 >= flagArr.length) {
                return null;
            }
            if (flagArr[i3].toString().equals(str)) {
                return __values[i3];
            }
            i3++;
        }
    }
}
