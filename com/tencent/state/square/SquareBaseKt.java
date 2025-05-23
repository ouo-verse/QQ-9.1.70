package com.tencent.state.square;

import com.tencent.state.square.api.ISquareHippyEngine;
import com.tencent.state.square.mmkv.SMMKV;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\"\u0011\u0010\u0000\u001a\u00020\u00018F\u00a2\u0006\u0006\u001a\u0004\b\u0002\u0010\u0003\"\u0011\u0010\u0004\u001a\u00020\u00058F\u00a2\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007\"\u0011\u0010\b\u001a\u00020\t8F\u00a2\u0006\u0006\u001a\u0004\b\n\u0010\u000b\"\u0011\u0010\f\u001a\u00020\r8F\u00a2\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f\"\u0011\u0010\u0010\u001a\u00020\u00118F\u00a2\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013\"\u0011\u0010\u0014\u001a\u00020\u00158F\u00a2\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017\"\u0011\u0010\u0018\u001a\u00020\u00198F\u00a2\u0006\u0006\u001a\u0004\b\u001a\u0010\u001b\"\u0011\u0010\u001c\u001a\u00020\u001d8F\u00a2\u0006\u0006\u001a\u0004\b\u001e\u0010\u001f\"\u000e\u0010 \u001a\u00020!X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\""}, d2 = {"SquareCommon", "Lcom/tencent/state/square/ICommonUtils;", "getSquareCommon", "()Lcom/tencent/state/square/ICommonUtils;", "SquareHippyEngine", "Lcom/tencent/state/square/api/ISquareHippyEngine;", "getSquareHippyEngine", "()Lcom/tencent/state/square/api/ISquareHippyEngine;", "SquareLog", "Lcom/tencent/state/square/SquareLogger;", "getSquareLog", "()Lcom/tencent/state/square/SquareLogger;", "SquareMMKV", "Lcom/tencent/state/square/mmkv/SMMKV;", "getSquareMMKV", "()Lcom/tencent/state/square/mmkv/SMMKV;", "SquareReporter", "Lcom/tencent/state/square/IReporter;", "getSquareReporter", "()Lcom/tencent/state/square/IReporter;", "SquareRouter", "Lcom/tencent/state/square/IRouter;", "getSquareRouter", "()Lcom/tencent/state/square/IRouter;", "SquareShareUtil", "Lcom/tencent/state/square/IShareUtils;", "getSquareShareUtil", "()Lcom/tencent/state/square/IShareUtils;", "SquareThread", "Lcom/tencent/state/square/IThreadManager;", "getSquareThread", "()Lcom/tencent/state/square/IThreadManager;", "TAG_PREFIX", "", "square_base_debug"}, k = 2, mv = {1, 4, 1})
/* loaded from: classes26.dex */
public final class SquareBaseKt {

    @NotNull
    public static final String TAG_PREFIX = "Square_";

    @NotNull
    public static final ICommonUtils getSquareCommon() {
        return SquareBase.INSTANCE.getConfig().getCommonUtils();
    }

    @NotNull
    public static final ISquareHippyEngine getSquareHippyEngine() {
        return SquareBase.INSTANCE.getConfig().getHippyEngine();
    }

    @NotNull
    public static final SquareLogger getSquareLog() {
        return SquareBase.INSTANCE.getConfig().getLogger();
    }

    @NotNull
    public static final SMMKV getSquareMMKV() {
        return SquareBase.INSTANCE.getConfig().getSquareMMKV();
    }

    @NotNull
    public static final IReporter getSquareReporter() {
        return SquareBase.INSTANCE.getConfig().getReporter();
    }

    @NotNull
    public static final IRouter getSquareRouter() {
        return SquareBase.INSTANCE.getConfig().getRouter();
    }

    @NotNull
    public static final IShareUtils getSquareShareUtil() {
        return SquareBase.INSTANCE.getConfig().getShareUtils();
    }

    @NotNull
    public static final IThreadManager getSquareThread() {
        return SquareBase.INSTANCE.getConfig().getThreadManager();
    }
}
