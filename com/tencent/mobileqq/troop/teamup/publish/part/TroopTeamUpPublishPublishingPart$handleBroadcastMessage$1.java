package com.tencent.mobileqq.troop.teamup.publish.part;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import androidx.lifecycle.MutableLiveData;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.troop.teamup.member.event.TroopTeamUpUpdateEvent;
import com.tencent.mobileqq.troop.teamup.publish.vm.TroopTeamUpPublishVM;
import com.tencent.qqnt.aio.adapter.api.IAIOStarterApi;
import com.tencent.qqnt.kernel.nativeinterface.PostTeamUpReq;
import com.tencent.qqnt.kernel.nativeinterface.PostTeamUpRsp;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.troop.teamup.publish.part.TroopTeamUpPublishPublishingPart$handleBroadcastMessage$1", f = "TroopTeamUpPublishPublishingPart.kt", i = {0}, l = {75}, m = "invokeSuspend", n = {"req"}, s = {"L$0"})
/* loaded from: classes19.dex */
final class TroopTeamUpPublishPublishingPart$handleBroadcastMessage$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    static IPatchRedirector $redirector_;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ TroopTeamUpPublishPublishingPart this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TroopTeamUpPublishPublishingPart$handleBroadcastMessage$1(TroopTeamUpPublishPublishingPart troopTeamUpPublishPublishingPart, Continuation<? super TroopTeamUpPublishPublishingPart$handleBroadcastMessage$1> continuation) {
        super(2, continuation);
        this.this$0 = troopTeamUpPublishPublishingPart;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) troopTeamUpPublishPublishingPart, (Object) continuation);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Continuation) iPatchRedirector.redirect((short) 3, (Object) this, obj, (Object) continuation);
        }
        TroopTeamUpPublishPublishingPart$handleBroadcastMessage$1 troopTeamUpPublishPublishingPart$handleBroadcastMessage$1 = new TroopTeamUpPublishPublishingPart$handleBroadcastMessage$1(this.this$0, continuation);
        troopTeamUpPublishPublishingPart$handleBroadcastMessage$1.L$0 = obj;
        return troopTeamUpPublishPublishingPart$handleBroadcastMessage$1;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00b1  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        TroopTeamUpPublishVM C9;
        TroopTeamUpPublishVM C92;
        PostTeamUpReq postTeamUpReq;
        Throwable th5;
        TroopTeamUpPublishVM C93;
        TroopTeamUpPublishVM C94;
        Object m476constructorimpl;
        PostTeamUpRsp postTeamUpRsp;
        TroopTeamUpPublishVM C95;
        TroopTeamUpPublishVM C96;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i3 = this.label;
            boolean z16 = false;
            Object obj2 = null;
            if (i3 != 0) {
                if (i3 == 1) {
                    postTeamUpReq = (PostTeamUpReq) this.L$0;
                    try {
                        ResultKt.throwOnFailure(obj);
                    } catch (Throwable th6) {
                        th5 = th6;
                        Result.Companion companion = Result.INSTANCE;
                        m476constructorimpl = Result.m476constructorimpl(ResultKt.createFailure(th5));
                        if (!Result.m482isFailureimpl(m476constructorimpl)) {
                        }
                        postTeamUpRsp = (PostTeamUpRsp) obj2;
                        C95 = this.this$0.C9();
                        MutableLiveData<Boolean> U1 = C95.U1();
                        if (postTeamUpRsp != null) {
                        }
                        U1.postValue(Boxing.boxBoolean(z16));
                        if (postTeamUpRsp == null) {
                        }
                    }
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                ResultKt.throwOnFailure(obj);
                C9 = this.this$0.C9();
                C9.U1().postValue(null);
                C92 = this.this$0.C9();
                PostTeamUpReq L1 = C92.L1();
                if (L1 == null) {
                    C94 = this.this$0.C9();
                    C94.U1().postValue(Boxing.boxBoolean(false));
                    return Unit.INSTANCE;
                }
                TroopTeamUpPublishPublishingPart troopTeamUpPublishPublishingPart = this.this$0;
                try {
                    Result.Companion companion2 = Result.INSTANCE;
                    C93 = troopTeamUpPublishPublishingPart.C9();
                    this.L$0 = L1;
                    this.label = 1;
                    Object W1 = C93.W1(L1, this);
                    if (W1 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    postTeamUpReq = L1;
                    obj = W1;
                } catch (Throwable th7) {
                    postTeamUpReq = L1;
                    th5 = th7;
                    Result.Companion companion3 = Result.INSTANCE;
                    m476constructorimpl = Result.m476constructorimpl(ResultKt.createFailure(th5));
                    if (!Result.m482isFailureimpl(m476constructorimpl)) {
                    }
                    postTeamUpRsp = (PostTeamUpRsp) obj2;
                    C95 = this.this$0.C9();
                    MutableLiveData<Boolean> U12 = C95.U1();
                    if (postTeamUpRsp != null) {
                    }
                    U12.postValue(Boxing.boxBoolean(z16));
                    if (postTeamUpRsp == null) {
                    }
                }
            }
            m476constructorimpl = Result.m476constructorimpl((PostTeamUpRsp) obj);
            if (!Result.m482isFailureimpl(m476constructorimpl)) {
                obj2 = m476constructorimpl;
            }
            postTeamUpRsp = (PostTeamUpRsp) obj2;
            C95 = this.this$0.C9();
            MutableLiveData<Boolean> U122 = C95.U1();
            if (postTeamUpRsp != null) {
                z16 = true;
            }
            U122.postValue(Boxing.boxBoolean(z16));
            if (postTeamUpRsp == null) {
                return Unit.INSTANCE;
            }
            SimpleEventBus simpleEventBus = SimpleEventBus.getInstance();
            String str = postTeamUpRsp.teamId;
            Intrinsics.checkNotNullExpressionValue(str, "rsp.teamId");
            simpleEventBus.dispatchEvent(new TroopTeamUpUpdateEvent.NewTeamUp(str, postTeamUpReq));
            Activity activity = this.this$0.getActivity();
            Intent intent = new Intent();
            intent.putExtra("is_published", true);
            Unit unit = Unit.INSTANCE;
            activity.setResult(-1, intent);
            this.this$0.getActivity().finish();
            QRouteApi api = QRoute.api(IAIOStarterApi.class);
            Intrinsics.checkNotNullExpressionValue(api, "api(IAIOStarterApi::class.java)");
            IAIOStarterApi iAIOStarterApi = (IAIOStarterApi) api;
            Context applicationContext = this.this$0.getContext().getApplicationContext();
            Intrinsics.checkNotNullExpressionValue(applicationContext, "context.applicationContext");
            C96 = this.this$0.C9();
            IAIOStarterApi.a.a(iAIOStarterApi, applicationContext, 2, C96.R1(), "", 0L, null, 48, null);
            return Unit.INSTANCE;
        }
        return iPatchRedirector.redirect((short) 2, (Object) this, obj);
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? ((TroopTeamUpPublishPublishingPart$handleBroadcastMessage$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE) : iPatchRedirector.redirect((short) 4, (Object) this, (Object) coroutineScope, (Object) continuation);
    }
}
