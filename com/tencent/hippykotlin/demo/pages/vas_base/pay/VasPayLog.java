package com.tencent.hippykotlin.demo.pages.vas_base.pay;

import com.tencent.hippykotlin.demo.pages.vas_base.vlog.VLog;

/* loaded from: classes33.dex */
public final class VasPayLog {
    public static final VasPayLog INSTANCE = new VasPayLog();
    public static final VLog log = new VLog("VasPayLog");

    public final void logInfo(String str) {
        log.log$enumunboxing$(str, 2, true);
    }
}
