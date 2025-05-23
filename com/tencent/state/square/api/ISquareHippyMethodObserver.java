package com.tencent.state.square.api;

import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.modules.Promise;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J$\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tH&\u00a8\u0006\n"}, d2 = {"Lcom/tencent/state/square/api/ISquareHippyMethodObserver;", "", "onMethodCall", "", "method", "", "readableMap", "Lcom/tencent/mtt/hippy/common/HippyMap;", "promise", "Lcom/tencent/mtt/hippy/modules/Promise;", "square_base_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes26.dex */
public interface ISquareHippyMethodObserver {

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes26.dex */
    public static final class DefaultImpls {
        public static /* synthetic */ void onMethodCall$default(ISquareHippyMethodObserver iSquareHippyMethodObserver, String str, HippyMap hippyMap, Promise promise, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 4) != 0) {
                    promise = null;
                }
                iSquareHippyMethodObserver.onMethodCall(str, hippyMap, promise);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onMethodCall");
        }
    }

    void onMethodCall(@NotNull String method, @NotNull HippyMap readableMap, @Nullable Promise promise);
}
