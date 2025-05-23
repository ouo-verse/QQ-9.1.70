package MessageSvcPack;

import java.io.Serializable;

/* compiled from: P */
/* loaded from: classes.dex */
public final class MsgSyncFlag implements Serializable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final int _SYNC_BEGIN = 0;
    public static final int _SYNC_CONTINUE = 1;
    public static final int _SYNC_END = 2;
    public static final int _SYNC_FINI = 3;
    private String __T;
    private int __value;

    /* renamed from: d, reason: collision with root package name */
    private static MsgSyncFlag[] f24916d = new MsgSyncFlag[4];
    public static final MsgSyncFlag SYNC_BEGIN = new MsgSyncFlag(0, 0, "SYNC_BEGIN");
    public static final MsgSyncFlag SYNC_CONTINUE = new MsgSyncFlag(1, 1, "SYNC_CONTINUE");
    public static final MsgSyncFlag SYNC_END = new MsgSyncFlag(2, 2, "SYNC_END");
    public static final MsgSyncFlag SYNC_FINI = new MsgSyncFlag(3, 3, "SYNC_FINI");

    MsgSyncFlag(int i3, int i16, String str) {
        new String();
        this.__T = str;
        this.__value = i16;
        f24916d[i3] = this;
    }

    public static MsgSyncFlag convert(int i3) {
        int i16 = 0;
        while (true) {
            MsgSyncFlag[] msgSyncFlagArr = f24916d;
            if (i16 >= msgSyncFlagArr.length) {
                return null;
            }
            if (msgSyncFlagArr[i16].value() == i3) {
                return f24916d[i16];
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

    public static MsgSyncFlag convert(String str) {
        int i3 = 0;
        while (true) {
            MsgSyncFlag[] msgSyncFlagArr = f24916d;
            if (i3 >= msgSyncFlagArr.length) {
                return null;
            }
            if (msgSyncFlagArr[i3].toString().equals(str)) {
                return f24916d[i3];
            }
            i3++;
        }
    }
}
