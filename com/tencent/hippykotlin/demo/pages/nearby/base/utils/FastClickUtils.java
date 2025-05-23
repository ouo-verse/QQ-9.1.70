package com.tencent.hippykotlin.demo.pages.nearby.base.utils;

import com.tencent.hippykotlin.demo.pages.nearby.base.tech_reporter.APICallTechReporterKt;
import com.tencent.kuikly.core.log.KLog;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class FastClickUtils {
    public long lastClickTime;
    public final long timeDelay;

    public FastClickUtils(long j3) {
        this.timeDelay = j3;
    }

    public final boolean isFastDoubleClick() {
        long NBPCurrentTime = APICallTechReporterKt.NBPCurrentTime();
        long j3 = NBPCurrentTime - this.lastClickTime;
        if (0 <= j3 && j3 < this.timeDelay) {
            KLog.INSTANCE.e("FastClickUtils", "click so fast");
            return true;
        }
        this.lastClickTime = NBPCurrentTime;
        return false;
    }
}
