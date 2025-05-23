package com.tencent.robot.discover.viewmodel;

import androidx.lifecycle.MutableLiveData;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.robot.discover.viewmodel.RobotDiscoveryListViewModel$fetchRobotDiscoverList$1", f = "RobotDiscoveryListViewModel.kt", i = {0, 0, 1}, l = {45, 46}, m = "invokeSuspend", n = {"list", "discoveryData", "list"}, s = {"L$0", "L$1", "L$0"})
/* loaded from: classes25.dex */
public final class RobotDiscoveryListViewModel$fetchRobotDiscoverList$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Ref.LongRef $groupId;
    final /* synthetic */ int $sceneId;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ RobotDiscoveryListViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RobotDiscoveryListViewModel$fetchRobotDiscoverList$1(RobotDiscoveryListViewModel robotDiscoveryListViewModel, int i3, Ref.LongRef longRef, Continuation<? super RobotDiscoveryListViewModel$fetchRobotDiscoverList$1> continuation) {
        super(2, continuation);
        this.this$0 = robotDiscoveryListViewModel;
        this.$sceneId = i3;
        this.$groupId = longRef;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        RobotDiscoveryListViewModel$fetchRobotDiscoverList$1 robotDiscoveryListViewModel$fetchRobotDiscoverList$1 = new RobotDiscoveryListViewModel$fetchRobotDiscoverList$1(this.this$0, this.$sceneId, this.$groupId, continuation);
        robotDiscoveryListViewModel$fetchRobotDiscoverList$1.L$0 = obj;
        return robotDiscoveryListViewModel$fetchRobotDiscoverList$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        List arrayList;
        Deferred async$default;
        Deferred async$default2;
        boolean z16;
        Deferred deferred;
        List list;
        List list2;
        MutableLiveData mutableLiveData;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 == 2) {
                    list2 = (List) this.L$1;
                    arrayList = (List) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    list2.addAll((Collection) obj);
                    mutableLiveData = this.this$0.mListData;
                    mutableLiveData.setValue(arrayList);
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            List list3 = (List) this.L$2;
            Deferred deferred2 = (Deferred) this.L$1;
            List list4 = (List) this.L$0;
            ResultKt.throwOnFailure(obj);
            list = list3;
            arrayList = list4;
            deferred = deferred2;
        } else {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            arrayList = new ArrayList();
            async$default = BuildersKt__Builders_commonKt.async$default(coroutineScope, null, null, new RobotDiscoveryListViewModel$fetchRobotDiscoverList$1$recentData$1(this.$sceneId, this.this$0, null), 3, null);
            async$default2 = BuildersKt__Builders_commonKt.async$default(coroutineScope, null, null, new RobotDiscoveryListViewModel$fetchRobotDiscoverList$1$discoveryData$1(this.this$0, this.$groupId, this.$sceneId, null), 3, null);
            z16 = this.this$0.mShowSearchBar;
            arrayList.add(new k34.e(z16));
            this.L$0 = arrayList;
            this.L$1 = async$default2;
            this.L$2 = arrayList;
            this.label = 1;
            Object await = async$default.await(this);
            if (await == coroutine_suspended) {
                return coroutine_suspended;
            }
            deferred = async$default2;
            obj = await;
            list = arrayList;
        }
        list.addAll((Collection) obj);
        this.L$0 = arrayList;
        this.L$1 = arrayList;
        this.L$2 = null;
        this.label = 2;
        obj = deferred.await(this);
        if (obj == coroutine_suspended) {
            return coroutine_suspended;
        }
        list2 = arrayList;
        list2.addAll((Collection) obj);
        mutableLiveData = this.this$0.mListData;
        mutableLiveData.setValue(arrayList);
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((RobotDiscoveryListViewModel$fetchRobotDiscoverList$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
