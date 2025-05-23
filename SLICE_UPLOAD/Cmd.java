package SLICE_UPLOAD;

import java.io.Serializable;

/* compiled from: P */
/* loaded from: classes.dex */
public final class Cmd implements Serializable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final int _CMD_COMMIT = 3;
    public static final int _CMD_CONTROL = 1;
    public static final int _CMD_UNKNOWN = 0;
    public static final int _CMD_UPLOAD = 2;
    private String __T;
    private int __value;
    private static Cmd[] __values = new Cmd[4];
    public static final Cmd CMD_UNKNOWN = new Cmd(0, 0, "CMD_UNKNOWN");
    public static final Cmd CMD_CONTROL = new Cmd(1, 1, "CMD_CONTROL");
    public static final Cmd CMD_UPLOAD = new Cmd(2, 2, "CMD_UPLOAD");
    public static final Cmd CMD_COMMIT = new Cmd(3, 3, "CMD_COMMIT");

    Cmd(int i3, int i16, String str) {
        new String();
        this.__T = str;
        this.__value = i16;
        __values[i3] = this;
    }

    public static Cmd convert(int i3) {
        int i16 = 0;
        while (true) {
            Cmd[] cmdArr = __values;
            if (i16 >= cmdArr.length) {
                return null;
            }
            if (cmdArr[i16].value() == i3) {
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

    public static Cmd convert(String str) {
        int i3 = 0;
        while (true) {
            Cmd[] cmdArr = __values;
            if (i3 >= cmdArr.length) {
                return null;
            }
            if (cmdArr[i3].toString().equals(str)) {
                return __values[i3];
            }
            i3++;
        }
    }
}
