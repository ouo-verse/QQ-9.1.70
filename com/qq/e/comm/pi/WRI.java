package com.qq.e.comm.pi;

/* compiled from: P */
/* loaded from: classes3.dex */
public interface WRI {
    public static final int EVENT_ACTIVITY_GO_BACK = 10;
    public static final int EVENT_ACTIVITY_PAUSE = 11;
    public static final int EVENT_BEFORE_ACTIVITY_FINISH = 12;
    public static final int EVENT_LOAD_ERROR = 3;
    public static final int EVENT_LOAD_FINISH = 2;
    public static final int EVENT_LOAD_START = 1;

    void report(String str, int i3);
}
