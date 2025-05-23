package com.tencent.biz.qqcircle.immersive.personal.viewmodel;

import androidx.lifecycle.MutableLiveData;
import com.tencent.biz.qqcircle.immersive.personal.request.QFSPersonalQQGroupRequest;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.data.base.UIStateData;
import feedcloud.FeedCloudMeta$StFeed;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import qqcircle.QQCircleProfile$GetQQGroupsRsp;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.biz.qqcircle.immersive.personal.viewmodel.QFSProfileTroopViewModel$fetchTroopList$1", f = "QFSProfileTroopViewModel.kt", i = {}, l = {64}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes4.dex */
public final class QFSProfileTroopViewModel$fetchTroopList$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ FeedCloudMeta$StFeed $feed;
    final /* synthetic */ TroopRequestType $type;
    final /* synthetic */ String $uin;
    int label;
    final /* synthetic */ QFSProfileTroopViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QFSProfileTroopViewModel$fetchTroopList$1(TroopRequestType troopRequestType, String str, FeedCloudMeta$StFeed feedCloudMeta$StFeed, QFSProfileTroopViewModel qFSProfileTroopViewModel, Continuation<? super QFSProfileTroopViewModel$fetchTroopList$1> continuation) {
        super(2, continuation);
        this.$type = troopRequestType;
        this.$uin = str;
        this.$feed = feedCloudMeta$StFeed;
        this.this$0 = qFSProfileTroopViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new QFSProfileTroopViewModel$fetchTroopList$1(this.$type, this.$uin, this.$feed, this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        MutableLiveData mutableLiveData;
        boolean z16;
        int i3;
        List k26;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i16 = this.label;
        try {
            if (i16 != 0) {
                if (i16 == 1) {
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                ResultKt.throwOnFailure(obj);
                TroopRequestType troopRequestType = this.$type;
                TroopRequestType troopRequestType2 = TroopRequestType.PROFILE_HOST;
                if (troopRequestType != troopRequestType2 && troopRequestType != TroopRequestType.TYPE_FEED) {
                    z16 = false;
                } else {
                    z16 = true;
                }
                if (troopRequestType != troopRequestType2 && troopRequestType != TroopRequestType.PROFILE_GUEST) {
                    i3 = 2;
                } else {
                    i3 = 1;
                }
                QFSPersonalQQGroupRequest qFSPersonalQQGroupRequest = new QFSPersonalQQGroupRequest(this.$uin, z16, i3, this.$feed);
                qFSPersonalQQGroupRequest.setEnableCache(false);
                QFSProfileTroopViewModel qFSProfileTroopViewModel = this.this$0;
                this.label = 1;
                obj = qFSProfileTroopViewModel.o2(qFSPersonalQQGroupRequest, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            k26 = this.this$0.k2((QQCircleProfile$GetQQGroupsRsp) obj, this.$type);
            this.this$0.m2(k26);
        } catch (Throwable th5) {
            QLog.e("QFSProfileTroopViewModel", 1, "[getTroopList] errMsg=" + th5.getMessage());
            mutableLiveData = this.this$0._troopListLiveData;
            mutableLiveData.postValue(UIStateData.obtainError(th5.getMessage()));
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((QFSProfileTroopViewModel$fetchTroopList$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
