package com.tencent.hippykotlin.demo.pages.vas_base.report.keport;

import com.tencent.raft.codegenmeta.utils.RLog;

/* compiled from: P */
/* loaded from: classes33.dex */
public final /* synthetic */ class LogLevel$EnumUnboxingLocalUtility {
    public static /* synthetic */ String getTag(int i3) {
        if (i3 == 1) {
            return "debug";
        }
        if (i3 == 2) {
            return "info";
        }
        if (i3 == 3) {
            return "error";
        }
        throw null;
    }

    public static /* synthetic */ String stringValueOf(int i3) {
        if (i3 == 1) {
            return "DEBUG";
        }
        if (i3 == 2) {
            return "INFO";
        }
        if (i3 == 3) {
            return RLog.ERROR;
        }
        return "null";
    }
}
