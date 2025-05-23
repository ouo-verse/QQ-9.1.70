package com.tencent.kuikly.core.log;

import com.tencent.kuikly.core.manager.BridgeManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\u0017B\t\b\u0002\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J\u0016\u0010\b\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002J\u0016\u0010\t\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002J\u0016\u0010\n\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002J\u0010\u0010\r\u001a\u00020\u00052\b\u0010\f\u001a\u0004\u0018\u00010\u000bR\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0011R\u0014\u0010\u0013\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0011R\u0014\u0010\u0014\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0011\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/kuikly/core/log/KLog;", "", "", "method", "msg", "", "logToNative", "tag", "i", "d", "e", "Lcom/tencent/kuikly/core/log/KLog$a;", "logCallback", "setLogCallbackIfNeed", "callback", "Lcom/tencent/kuikly/core/log/KLog$a;", "MODULE_NAME", "Ljava/lang/String;", "METHOD_LOG_INFO", "METHOD_LOG_DEBUG", "METHOD_LOG_ERROR", "<init>", "()V", "a", "core_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class KLog {
    public static final KLog INSTANCE = new KLog();
    private static final String METHOD_LOG_DEBUG = "logDebug";
    private static final String METHOD_LOG_ERROR = "logError";
    private static final String METHOD_LOG_INFO = "logInfo";
    private static final String MODULE_NAME = "KRLogModule";
    private static a callback;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\bf\u0018\u00002\u00020\u0001\u00a8\u0006\u0002"}, d2 = {"Lcom/tencent/kuikly/core/log/KLog$a;", "", "core_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes33.dex */
    public interface a {
    }

    KLog() {
    }

    private final void logToNative(String method, String msg2) {
        BridgeManager bridgeManager = BridgeManager.f117344a;
        bridgeManager.k(bridgeManager.u(), MODULE_NAME, method, msg2, null, 1);
    }

    public final void d(String tag, String msg2) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(msg2, "msg");
        logToNative(METHOD_LOG_DEBUG, "[KLog][" + tag + "]:" + msg2);
    }

    public final void e(String tag, String msg2) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(msg2, "msg");
        logToNative(METHOD_LOG_ERROR, "[KLog][" + tag + "]:" + msg2);
    }

    public final void i(String tag, String msg2) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(msg2, "msg");
        logToNative(METHOD_LOG_INFO, "[KLog][" + tag + "]:" + msg2);
    }

    public final void setLogCallbackIfNeed(a logCallback) {
    }
}
