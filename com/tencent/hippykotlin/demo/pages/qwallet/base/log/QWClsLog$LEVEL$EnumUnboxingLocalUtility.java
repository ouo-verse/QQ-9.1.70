package com.tencent.hippykotlin.demo.pages.qwallet.base.log;

import com.tencent.raft.codegenmeta.utils.RLog;

/* compiled from: P */
/* loaded from: classes33.dex */
public final /* synthetic */ class QWClsLog$LEVEL$EnumUnboxingLocalUtility {
    public static /* synthetic */ String name(int i3) {
        if (i3 == 1) {
            return "DEBUG";
        }
        if (i3 == 2) {
            return "INFO";
        }
        if (i3 == 3) {
            return "WARNING";
        }
        if (i3 == 4) {
            return RLog.ERROR;
        }
        throw null;
    }
}
