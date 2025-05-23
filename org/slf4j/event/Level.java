package org.slf4j.event;

import com.tencent.raft.codegenmeta.utils.RLog;

/* compiled from: P */
/* loaded from: classes29.dex */
public enum Level {
    ERROR(40, RLog.ERROR),
    WARN(30, "WARN"),
    INFO(20, "INFO"),
    DEBUG(10, "DEBUG"),
    TRACE(0, "TRACE");

    private int levelInt;
    private String levelStr;

    Level(int i3, String str) {
        this.levelInt = i3;
        this.levelStr = str;
    }

    public int toInt() {
        return this.levelInt;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.levelStr;
    }
}
