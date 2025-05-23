package com.tencent.mobileqq.activity.aio.zplan;

import com.tencent.mobileqq.activity.aio.zplan.ZPlanIntimateInfoView;
import com.tencent.mobileqq.zplan.aio.couple.CoupleAvatarSubScene;
import com.tencent.mobileqq.zplan.show.IZPlanMsgService;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.Channel;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.activity.aio.zplan.ZPlanIntimateInfoView$onDrawerOpened$1", f = "ZPlanIntimateInfoView.kt", i = {}, l = {485, 486, 487}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes10.dex */
public final class ZPlanIntimateInfoView$onDrawerOpened$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ ZPlanIntimateInfoView this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZPlanIntimateInfoView$onDrawerOpened$1(ZPlanIntimateInfoView zPlanIntimateInfoView, Continuation<? super ZPlanIntimateInfoView$onDrawerOpened$1> continuation) {
        super(2, continuation);
        this.this$0 = zPlanIntimateInfoView;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new ZPlanIntimateInfoView$onDrawerOpened$1(this.this$0, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x005b  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        Object b06;
        com.tencent.mobileqq.zplan.aio.couple.i I;
        IZPlanMsgService iZPlanMsgService;
        ZPlanIntimateInfoView.e eVar;
        Channel channel;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 == 3) {
                        ResultKt.throwOnFailure(obj);
                        I = this.this$0.I();
                        if (I != null) {
                            I.f(CoupleAvatarSubScene.IntimateInfo, this.this$0);
                        }
                        iZPlanMsgService = this.this$0.messageService;
                        eVar = this.this$0.messageReceiveListener;
                        iZPlanMsgService.addListener(eVar);
                        channel = this.this$0.drawerIsOpened;
                        channel.mo2003trySendJP2dKIU(Boxing.boxBoolean(true));
                        this.this$0.G();
                        return Unit.INSTANCE;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                if (((Boolean) obj).booleanValue()) {
                    ZPlanIntimateInfoView zPlanIntimateInfoView = this.this$0;
                    this.label = 3;
                    if (ZPlanIntimateInfoView.a0(zPlanIntimateInfoView, null, this, 1, null) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                I = this.this$0.I();
                if (I != null) {
                }
                iZPlanMsgService = this.this$0.messageService;
                eVar = this.this$0.messageReceiveListener;
                iZPlanMsgService.addListener(eVar);
                channel = this.this$0.drawerIsOpened;
                channel.mo2003trySendJP2dKIU(Boxing.boxBoolean(true));
                this.this$0.G();
                return Unit.INSTANCE;
            }
            ResultKt.throwOnFailure(obj);
        } else {
            ResultKt.throwOnFailure(obj);
            ZPlanIntimateInfoView zPlanIntimateInfoView2 = this.this$0;
            this.label = 1;
            b06 = zPlanIntimateInfoView2.b0(this);
            if (b06 == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        ZPlanIntimateInfoView zPlanIntimateInfoView3 = this.this$0;
        this.label = 2;
        obj = zPlanIntimateInfoView3.E(this);
        if (obj == coroutine_suspended) {
            return coroutine_suspended;
        }
        if (((Boolean) obj).booleanValue()) {
        }
        I = this.this$0.I();
        if (I != null) {
        }
        iZPlanMsgService = this.this$0.messageService;
        eVar = this.this$0.messageReceiveListener;
        iZPlanMsgService.addListener(eVar);
        channel = this.this$0.drawerIsOpened;
        channel.mo2003trySendJP2dKIU(Boxing.boxBoolean(true));
        this.this$0.G();
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((ZPlanIntimateInfoView$onDrawerOpened$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
