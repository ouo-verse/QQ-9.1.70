package com.tencent.state.square;

import android.widget.ImageView;
import com.tencent.state.square.api.IFaceDecoder;
import com.tencent.state.square.api.ISquareLifecycleProxy;
import com.tencent.state.square.api.ISquareNearbyAvatarService;
import com.tencent.state.square.api.ISquareTaskService;
import com.tencent.state.square.api.ResultCallback;
import com.tencent.state.square.api.TaskItem;
import com.tencent.state.square.api.TaskRewardItem;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\nH\u0016\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/state/square/DefaultObtainInstanceHelper;", "Lcom/tencent/state/square/IObtainInstanceHelper;", "()V", "getFaceDecoder", "Lcom/tencent/state/square/api/IFaceDecoder;", "getNearByProAvatarService", "Lcom/tencent/state/square/api/ISquareNearbyAvatarService;", "getSquareLifecycleObserver", "Lcom/tencent/state/square/api/ISquareLifecycleProxy;", "getSquareTaskService", "Lcom/tencent/state/square/api/ISquareTaskService;", "square_base_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes26.dex */
public final class DefaultObtainInstanceHelper implements IObtainInstanceHelper {
    @Override // com.tencent.state.square.IObtainInstanceHelper
    @NotNull
    public IFaceDecoder getFaceDecoder() {
        return new DefaultObtainInstanceHelper$getFaceDecoder$1();
    }

    @Override // com.tencent.state.square.IObtainInstanceHelper
    @NotNull
    public ISquareNearbyAvatarService getNearByProAvatarService() {
        return new ISquareNearbyAvatarService() { // from class: com.tencent.state.square.DefaultObtainInstanceHelper$getNearByProAvatarService$1
            @Override // com.tencent.state.square.api.ISquareNearbyAvatarService
            public void loadAvatarWithTinyId(@NotNull ImageView avatarView, @NotNull String url) {
                Intrinsics.checkNotNullParameter(avatarView, "avatarView");
                Intrinsics.checkNotNullParameter(url, "url");
            }
        };
    }

    @Override // com.tencent.state.square.IObtainInstanceHelper
    @NotNull
    public ISquareLifecycleProxy getSquareLifecycleObserver() {
        return new ISquareLifecycleProxy() { // from class: com.tencent.state.square.DefaultObtainInstanceHelper$getSquareLifecycleObserver$1
            @Override // com.tencent.state.square.api.ISquareLifecycleProxy
            public void onCreate() {
            }

            @Override // com.tencent.state.square.api.ISquareLifecycleProxy
            public void onDestroy() {
            }
        };
    }

    @Override // com.tencent.state.square.IObtainInstanceHelper
    @NotNull
    public ISquareTaskService getSquareTaskService() {
        return new ISquareTaskService() { // from class: com.tencent.state.square.DefaultObtainInstanceHelper$getSquareTaskService$1
            @Override // com.tencent.state.square.api.ISquareTaskService
            public void fetchQuestReward(long j3, @NotNull ResultCallback<TaskRewardItem> callback) {
                Intrinsics.checkNotNullParameter(callback, "callback");
                ISquareTaskService.DefaultImpls.fetchQuestReward(this, j3, callback);
            }

            @Override // com.tencent.state.square.api.ISquareTaskService
            public void getTaskRedPointFlag(long j3, @NotNull Function1<? super Boolean, Unit> callback) {
                Intrinsics.checkNotNullParameter(callback, "callback");
                ISquareTaskService.DefaultImpls.getTaskRedPointFlag(this, j3, callback);
            }

            @Override // com.tencent.state.square.api.ISquareTaskService
            public void loadLeYuanTask(@NotNull ResultCallback<List<TaskItem>> callback) {
                Intrinsics.checkNotNullParameter(callback, "callback");
                ISquareTaskService.DefaultImpls.loadLeYuanTask(this, callback);
            }
        };
    }
}
