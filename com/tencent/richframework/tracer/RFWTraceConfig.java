package com.tencent.richframework.tracer;

import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0004J\u0006\u0010\b\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2 = {"Lcom/tencent/richframework/tracer/RFWTraceConfig;", "", "()V", "mLogEnable", "", "enableLog", "", "enable", "isLogEnable", "trace_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes25.dex */
public final class RFWTraceConfig {
    private boolean mLogEnable = RFWApplication.isDebug();

    public final void enableLog(boolean enable) {
        this.mLogEnable = enable;
    }

    /* renamed from: isLogEnable, reason: from getter */
    public final boolean getMLogEnable() {
        return this.mLogEnable;
    }
}
