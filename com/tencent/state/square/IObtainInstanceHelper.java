package com.tencent.state.square;

import com.tencent.state.square.api.IFaceDecoder;
import com.tencent.state.square.api.ISquareLifecycleProxy;
import com.tencent.state.square.api.ISquareNearbyAvatarService;
import com.tencent.state.square.api.ISquareTaskService;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\b\u001a\u00020\tH&\u00a8\u0006\n"}, d2 = {"Lcom/tencent/state/square/IObtainInstanceHelper;", "", "getFaceDecoder", "Lcom/tencent/state/square/api/IFaceDecoder;", "getNearByProAvatarService", "Lcom/tencent/state/square/api/ISquareNearbyAvatarService;", "getSquareLifecycleObserver", "Lcom/tencent/state/square/api/ISquareLifecycleProxy;", "getSquareTaskService", "Lcom/tencent/state/square/api/ISquareTaskService;", "square_base_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes26.dex */
public interface IObtainInstanceHelper {
    @NotNull
    IFaceDecoder getFaceDecoder();

    @NotNull
    ISquareNearbyAvatarService getNearByProAvatarService();

    @NotNull
    ISquareLifecycleProxy getSquareLifecycleObserver();

    @NotNull
    ISquareTaskService getSquareTaskService();
}
