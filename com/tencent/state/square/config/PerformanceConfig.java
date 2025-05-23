package com.tencent.state.square.config;

import com.tencent.state.square.SquareBase;
import com.tencent.state.square.SquareBaseKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0015\u001a\u00020\u0016H\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001a\u0010\f\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\u001a\u0010\u000f\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\u001a\u0010\u0012\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\b\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/state/square/config/PerformanceConfig;", "", "()V", "autoUnbindURLDrawable", "", "getAutoUnbindURLDrawable", "()Z", "setAutoUnbindURLDrawable", "(Z)V", "forbiddenPagPlay", "getForbiddenPagPlay", "setForbiddenPagPlay", "forbiddenVideoPlay", "getForbiddenVideoPlay", "setForbiddenVideoPlay", "removeURLDrawableCacheOnDestroy", "getRemoveURLDrawableCacheOnDestroy", "setRemoveURLDrawableCacheOnDestroy", "removeURLDrawableCacheOnLowMem", "getRemoveURLDrawableCacheOnLowMem", "setRemoveURLDrawableCacheOnLowMem", "toString", "", "Companion", "square_base_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes26.dex */
public final class PerformanceConfig {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private static final boolean DEFAULT_AUTO_UNBIND_URL_DRAWABLE = false;
    private static final boolean DEFAULT_REMOVE_URL_DRAWABLE_CACHE_ON_DESTROY = true;
    private static final boolean DEFAULT_REMOVE_URL_DRAWABLE_CACHE_ON_LOW_MEM = true;
    private static final String KEY_AUTO_UNBIND_URL_DRWABLE = "AutoUnbindURLDrawable_Android";
    private static final String KEY_REMOVE_URL_DRAWABLE_CACHE_ON_DESTROY = "RemoveURLDrawableCacheOnDestroy_Android";
    private static final String KEY_REMOVE_URL_DRAWABLE_CACHE_ON_LOW_MEM = "RemoveURLDrawableCacheOnLowMem_Android";
    private static final String TAG = "SquarePerformanceConfig";
    private boolean autoUnbindURLDrawable;
    private boolean forbiddenPagPlay;
    private boolean forbiddenVideoPlay;
    private boolean removeURLDrawableCacheOnDestroy = true;
    private boolean removeURLDrawableCacheOnLowMem = true;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\bX\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\bX\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/state/square/config/PerformanceConfig$Companion;", "", "()V", "DEFAULT_AUTO_UNBIND_URL_DRAWABLE", "", "DEFAULT_REMOVE_URL_DRAWABLE_CACHE_ON_DESTROY", "DEFAULT_REMOVE_URL_DRAWABLE_CACHE_ON_LOW_MEM", "KEY_AUTO_UNBIND_URL_DRWABLE", "", "KEY_REMOVE_URL_DRAWABLE_CACHE_ON_DESTROY", "KEY_REMOVE_URL_DRAWABLE_CACHE_ON_LOW_MEM", "TAG", "parseConfig", "Lcom/tencent/state/square/config/PerformanceConfig;", "str", "square_base_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes26.dex */
    public static final class Companion {
        Companion() {
        }

        @NotNull
        public final PerformanceConfig parseConfig(@NotNull String str) {
            boolean z16;
            Intrinsics.checkNotNullParameter(str, "str");
            if (SquareBase.INSTANCE.getConfig().isDebug() && SquareBaseKt.getSquareLog().isColorLevel()) {
                SquareBaseKt.getSquareLog().d(PerformanceConfig.TAG, "parseConfig, str=" + str);
            }
            if (str.length() == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                return new PerformanceConfig();
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                PerformanceConfig performanceConfig = new PerformanceConfig();
                performanceConfig.setAutoUnbindURLDrawable(jSONObject.optBoolean(PerformanceConfig.KEY_AUTO_UNBIND_URL_DRWABLE, false));
                performanceConfig.setRemoveURLDrawableCacheOnDestroy(jSONObject.optBoolean(PerformanceConfig.KEY_REMOVE_URL_DRAWABLE_CACHE_ON_DESTROY, true));
                performanceConfig.setRemoveURLDrawableCacheOnLowMem(jSONObject.optBoolean(PerformanceConfig.KEY_REMOVE_URL_DRAWABLE_CACHE_ON_LOW_MEM, true));
                SquareBaseKt.getSquareLog().d(PerformanceConfig.TAG, "parseConfig:" + performanceConfig);
                return performanceConfig;
            } catch (Throwable th5) {
                SquareBaseKt.getSquareLog().e(PerformanceConfig.TAG, "parseConfig err.", th5);
                return new PerformanceConfig();
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public final boolean getAutoUnbindURLDrawable() {
        return this.autoUnbindURLDrawable;
    }

    public final boolean getForbiddenPagPlay() {
        return this.forbiddenPagPlay;
    }

    public final boolean getForbiddenVideoPlay() {
        return this.forbiddenVideoPlay;
    }

    public final boolean getRemoveURLDrawableCacheOnDestroy() {
        return this.removeURLDrawableCacheOnDestroy;
    }

    public final boolean getRemoveURLDrawableCacheOnLowMem() {
        return this.removeURLDrawableCacheOnLowMem;
    }

    public final void setAutoUnbindURLDrawable(boolean z16) {
        this.autoUnbindURLDrawable = z16;
    }

    public final void setForbiddenPagPlay(boolean z16) {
        this.forbiddenPagPlay = z16;
    }

    public final void setForbiddenVideoPlay(boolean z16) {
        this.forbiddenVideoPlay = z16;
    }

    public final void setRemoveURLDrawableCacheOnDestroy(boolean z16) {
        this.removeURLDrawableCacheOnDestroy = z16;
    }

    public final void setRemoveURLDrawableCacheOnLowMem(boolean z16) {
        this.removeURLDrawableCacheOnLowMem = z16;
    }

    @NotNull
    public String toString() {
        return "{autoUnbindURLDrawable:" + this.autoUnbindURLDrawable + ", removeURLDrawableCacheOnDestroy:" + this.removeURLDrawableCacheOnDestroy + ", removeURLDrawableCacheOnLowMem:" + this.removeURLDrawableCacheOnLowMem + '}';
    }
}
