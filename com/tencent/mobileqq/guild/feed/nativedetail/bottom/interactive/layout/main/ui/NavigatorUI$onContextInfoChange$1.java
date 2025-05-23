package com.tencent.mobileqq.guild.feed.nativedetail.bottom.interactive.layout.main.ui;

import com.tencent.mobileqq.guild.feed.nativedetail.bottom.base.GuideBarGuildInfo;
import com.tencent.mobileqq.guild.feed.util.ae;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import oicq.wlogin_sdk.tlv_type.tlv_t183;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.guild.feed.nativedetail.bottom.interactive.layout.main.ui.NavigatorUI$onContextInfoChange$1", f = "NavigatorUI.kt", i = {}, l = {tlv_t183.CMD_183}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes13.dex */
public final class NavigatorUI$onContextInfoChange$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ NavigatorUI this$0;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001b\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00028\u0000H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0004\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0006\u00b8\u0006\u0000"}, d2 = {"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/FlowCollector;", "value", "", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class a implements FlowCollector<GuideBarGuildInfo> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ CoroutineScope f220689d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ NavigatorUI f220690e;

        public a(CoroutineScope coroutineScope, NavigatorUI navigatorUI) {
            this.f220689d = coroutineScope;
            this.f220690e = navigatorUI;
        }

        @Override // kotlinx.coroutines.flow.FlowCollector
        @Nullable
        public Object emit(GuideBarGuildInfo guideBarGuildInfo, @NotNull Continuation<? super Unit> continuation) {
            BuildersKt__Builders_commonKt.launch$default(this.f220689d, ae.a().e(), null, new NavigatorUI$onContextInfoChange$1$1$1(this.f220690e, guideBarGuildInfo, null), 2, null);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NavigatorUI$onContextInfoChange$1(NavigatorUI navigatorUI, Continuation<? super NavigatorUI$onContextInfoChange$1> continuation) {
        super(2, continuation);
        this.this$0 = navigatorUI;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        NavigatorUI$onContextInfoChange$1 navigatorUI$onContextInfoChange$1 = new NavigatorUI$onContextInfoChange$1(this.this$0, continuation);
        navigatorUI$onContextInfoChange$1.L$0 = obj;
        return navigatorUI$onContextInfoChange$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 != 0) {
            if (i3 == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            Flow<GuideBarGuildInfo> a16 = this.this$0.dependency.a();
            a aVar = new a(coroutineScope, this.this$0);
            this.label = 1;
            if (a16.collect(aVar, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((NavigatorUI$onContextInfoChange$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
