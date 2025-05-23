package com.tencent.thumbplayer.report.reportv2;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes26.dex */
public class TPReportControllerState {
    public static final int IDLE = 1;
    private static final int INDEX = 0;
    public static final int PREPARED = 3;
    public static final int PREPARING = 2;
    private static final Map<Integer, String> STATE_TO_STRING_MAP;
    private int mCurState = 1;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes26.dex */
    public @interface State {
    }

    static {
        HashMap hashMap = new HashMap();
        STATE_TO_STRING_MAP = hashMap;
        hashMap.put(1, "IDLE");
        hashMap.put(2, "PREPARING");
        hashMap.put(3, "PREPARED");
    }

    public synchronized int getState() {
        return this.mCurState;
    }

    public synchronized boolean isMatchState(int i3) {
        boolean z16;
        if (this.mCurState == i3) {
            z16 = true;
        } else {
            z16 = false;
        }
        return z16;
    }

    public synchronized void setState(int i3) {
        this.mCurState = i3;
    }

    public synchronized String toString() {
        return "state[ cur : " + STATE_TO_STRING_MAP.get(Integer.valueOf(this.mCurState)) + " ]";
    }
}
