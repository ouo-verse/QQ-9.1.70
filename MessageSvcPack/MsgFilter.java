package MessageSvcPack;

import java.io.Serializable;

/* compiled from: P */
/* loaded from: classes.dex */
public final class MsgFilter implements Serializable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final int _LIMIT_10_AND_IN_3_DAYS = 1;
    public static final int _NO_FILTER = 0;
    private String __T;
    private int __value;

    /* renamed from: d, reason: collision with root package name */
    private static MsgFilter[] f24915d = new MsgFilter[2];
    public static final MsgFilter NO_FILTER = new MsgFilter(0, 0, "NO_FILTER");
    public static final MsgFilter LIMIT_10_AND_IN_3_DAYS = new MsgFilter(1, 1, "LIMIT_10_AND_IN_3_DAYS");

    MsgFilter(int i3, int i16, String str) {
        new String();
        this.__T = str;
        this.__value = i16;
        f24915d[i3] = this;
    }

    public static MsgFilter convert(int i3) {
        int i16 = 0;
        while (true) {
            MsgFilter[] msgFilterArr = f24915d;
            if (i16 >= msgFilterArr.length) {
                return null;
            }
            if (msgFilterArr[i16].value() == i3) {
                return f24915d[i16];
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

    public static MsgFilter convert(String str) {
        int i3 = 0;
        while (true) {
            MsgFilter[] msgFilterArr = f24915d;
            if (i3 >= msgFilterArr.length) {
                return null;
            }
            if (msgFilterArr[i3].toString().equals(str)) {
                return f24915d[i3];
            }
            i3++;
        }
    }
}
