package QQService;

import java.io.Serializable;

/* loaded from: classes.dex */
public final class PushType implements Serializable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final int _PUSH_TYPE_NONE = -1;
    public static final int _PUSH_TYPE_VISITOR_INCR = 1;
    public static final int _PUSH_TYPE_VOTE_INCR = 0;
    private String __T;
    private int __value;

    /* renamed from: d, reason: collision with root package name */
    private static PushType[] f25088d = new PushType[3];
    public static final PushType PUSH_TYPE_NONE = new PushType(0, -1, "PUSH_TYPE_NONE");
    public static final PushType PUSH_TYPE_VOTE_INCR = new PushType(1, 0, "PUSH_TYPE_VOTE_INCR");
    public static final PushType PUSH_TYPE_VISITOR_INCR = new PushType(2, 1, "PUSH_TYPE_VISITOR_INCR");

    PushType(int i3, int i16, String str) {
        new String();
        this.__T = str;
        this.__value = i16;
        f25088d[i3] = this;
    }

    public static PushType convert(int i3) {
        int i16 = 0;
        while (true) {
            PushType[] pushTypeArr = f25088d;
            if (i16 >= pushTypeArr.length) {
                return null;
            }
            if (pushTypeArr[i16].value() == i3) {
                return f25088d[i16];
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

    public static PushType convert(String str) {
        int i3 = 0;
        while (true) {
            PushType[] pushTypeArr = f25088d;
            if (i3 >= pushTypeArr.length) {
                return null;
            }
            if (pushTypeArr[i3].toString().equals(str)) {
                return f25088d[i3];
            }
            i3++;
        }
    }
}
