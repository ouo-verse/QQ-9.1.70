package com.tencent.timi.game.expand.hall.impl.presenter;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.tencent.timi.game.utils.w;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import th4.o;
import tl.h;
import trpc.yes.common.YesUserRankingOuterClass$QueryUserRankingRsp;
import trpc.yes.common.YesUserRankingOuterClass$UserRanking;

/* compiled from: P */
@Metadata(d1 = {"\u0000O\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u001d\u0018\u0000 \u00072\u00020\u0001:\u0001\u0010B\u0017\u0012\u0006\u0010\u0012\u001a\u00020\u000f\u0012\u0006\u0010!\u001a\u00020 \u00a2\u0006\u0004\b\"\u0010#J\u0016\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0005H\u0002J\b\u0010\b\u001a\u00020\u0005H\u0002J\"\u0010\u000b\u001a\u00020\u00052\u001a\u0010\n\u001a\u0016\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002\u0012\u0004\u0012\u00020\u00050\tJ\u0006\u0010\f\u001a\u00020\u0005J\u0012\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\rR\u0014\u0010\u0012\u001a\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u001e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R \u0010\u001c\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001f\u001a\u00020\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\u001e\u00a8\u0006$"}, d2 = {"Lcom/tencent/timi/game/expand/hall/impl/presenter/OnlineUserViewModel;", "", "", "Ltrpc/yes/common/YesUserRankingOuterClass$UserRanking;", "userRankingList", "", "j", "f", "e", "Lkotlin/Function1;", "cb", "g", "i", "Landroidx/lifecycle/LiveData;", h.F, "", "a", "J", "roomId", "", "b", "Z", "isPolling", "c", "Ljava/util/List;", "Landroidx/lifecycle/MutableLiveData;", "d", "Landroidx/lifecycle/MutableLiveData;", "userRankingListLiveData", "com/tencent/timi/game/expand/hall/impl/presenter/OnlineUserViewModel$userRankingReqRunnable$1", "Lcom/tencent/timi/game/expand/hall/impl/presenter/OnlineUserViewModel$userRankingReqRunnable$1;", "userRankingReqRunnable", "Landroidx/lifecycle/LifecycleOwner;", "lifecycleOwner", "<init>", "(JLandroidx/lifecycle/LifecycleOwner;)V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class OnlineUserViewModel {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final long roomId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private boolean isPolling;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private List<YesUserRankingOuterClass$UserRanking> userRankingList;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MutableLiveData<List<YesUserRankingOuterClass$UserRanking>> userRankingListLiveData;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final OnlineUserViewModel$userRankingReqRunnable$1 userRankingReqRunnable;

    /* JADX WARN: Type inference failed for: r2v3, types: [com.tencent.timi.game.expand.hall.impl.presenter.OnlineUserViewModel$userRankingReqRunnable$1] */
    public OnlineUserViewModel(long j3, @NotNull LifecycleOwner lifecycleOwner) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        this.roomId = j3;
        lifecycleOwner.getLifecycle().addObserver(new LifecycleEventObserver() { // from class: com.tencent.timi.game.expand.hall.impl.presenter.OnlineUserViewModel.1
            @Override // androidx.lifecycle.LifecycleEventObserver
            public void onStateChanged(@NotNull LifecycleOwner p06, @NotNull Lifecycle.Event p16) {
                Intrinsics.checkNotNullParameter(p06, "p0");
                Intrinsics.checkNotNullParameter(p16, "p1");
                if (p16 == Lifecycle.Event.ON_DESTROY) {
                    OnlineUserViewModel.this.e();
                }
            }
        });
        this.userRankingListLiveData = new MutableLiveData<>();
        this.userRankingReqRunnable = new Runnable() { // from class: com.tencent.timi.game.expand.hall.impl.presenter.OnlineUserViewModel$userRankingReqRunnable$1
            @Override // java.lang.Runnable
            public void run() {
                boolean z16;
                OnlineUserViewModel.this.f();
                z16 = OnlineUserViewModel.this.isPolling;
                if (z16) {
                    w.e(this);
                    w.d(this, 5000L);
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void e() {
        this.isPolling = false;
        w.e(this.userRankingReqRunnable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void f() {
        o.a(this.roomId, 0, 100, new Function1<YesUserRankingOuterClass$QueryUserRankingRsp, Unit>() { // from class: com.tencent.timi.game.expand.hall.impl.presenter.OnlineUserViewModel$doUserRankingReq$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(YesUserRankingOuterClass$QueryUserRankingRsp yesUserRankingOuterClass$QueryUserRankingRsp) {
                invoke2(yesUserRankingOuterClass$QueryUserRankingRsp);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull YesUserRankingOuterClass$QueryUserRankingRsp it) {
                Intrinsics.checkNotNullParameter(it, "it");
                OnlineUserViewModel onlineUserViewModel = OnlineUserViewModel.this;
                List<YesUserRankingOuterClass$UserRanking> list = it.RankingList.get();
                Intrinsics.checkNotNullExpressionValue(list, "it.RankingList.get()");
                onlineUserViewModel.j(list);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void j(List<YesUserRankingOuterClass$UserRanking> userRankingList) {
        this.userRankingList = userRankingList;
        this.userRankingListLiveData.postValue(userRankingList);
    }

    public final void g(@NotNull final Function1<? super List<YesUserRankingOuterClass$UserRanking>, Unit> cb5) {
        Intrinsics.checkNotNullParameter(cb5, "cb");
        o.a(this.roomId, 0, 100, new Function1<YesUserRankingOuterClass$QueryUserRankingRsp, Unit>() { // from class: com.tencent.timi.game.expand.hall.impl.presenter.OnlineUserViewModel$forceDoUserRankingReq$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(YesUserRankingOuterClass$QueryUserRankingRsp yesUserRankingOuterClass$QueryUserRankingRsp) {
                invoke2(yesUserRankingOuterClass$QueryUserRankingRsp);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull YesUserRankingOuterClass$QueryUserRankingRsp it) {
                Intrinsics.checkNotNullParameter(it, "it");
                OnlineUserViewModel onlineUserViewModel = OnlineUserViewModel.this;
                List<YesUserRankingOuterClass$UserRanking> list = it.RankingList.get();
                Intrinsics.checkNotNullExpressionValue(list, "it.RankingList.get()");
                onlineUserViewModel.j(list);
                cb5.invoke(it.RankingList.get());
            }
        });
    }

    @NotNull
    public final LiveData<List<YesUserRankingOuterClass$UserRanking>> h() {
        return this.userRankingListLiveData;
    }

    public final void i() {
        this.isPolling = true;
        w.e(this.userRankingReqRunnable);
        f();
        w.d(this.userRankingReqRunnable, 5000L);
    }
}
