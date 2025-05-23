package com.tencent.mobileqq.minigame.api;

import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005H&\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/minigame/api/MiniGameVAInterceptCallback;", "", "onInterceptResult", "", "isSuccess", "", "quitDirect", "qqmini-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes15.dex */
public interface MiniGameVAInterceptCallback {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes15.dex */
    public static final class DefaultImpls {
        public static /* synthetic */ void onInterceptResult$default(MiniGameVAInterceptCallback miniGameVAInterceptCallback, boolean z16, boolean z17, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 2) != 0) {
                    z17 = false;
                }
                miniGameVAInterceptCallback.onInterceptResult(z16, z17);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onInterceptResult");
        }
    }

    void onInterceptResult(boolean isSuccess, boolean quitDirect);
}
