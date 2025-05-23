package com.tencent.mobileqq.zplan.minixwconnected.view;

import com.tencent.mobileqq.qcoroutine.api.coroutine.CorountineFunKt;
import com.tencent.mobileqq.qcoroutine.api.i;
import com.tencent.mobileqq.zplan.aio.panel.panel.Panel;
import com.tencent.qphone.base.util.QLog;
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
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.flow.MutableStateFlow;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.zplan.minixwconnected.view.MiniHomeConnectActionFocusComponent$configSource$1", f = "MiniHomeConnectActionFocusComponent.kt", i = {}, l = {218}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes34.dex */
public final class MiniHomeConnectActionFocusComponent$configSource$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ List<com.tencent.mobileqq.zplan.aio.panel.panel.a> $builders;
    final /* synthetic */ MutableStateFlow<Panel> $this_configSource;
    int label;
    final /* synthetic */ MiniHomeConnectActionFocusComponent this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    @DebugMetadata(c = "com.tencent.mobileqq.zplan.minixwconnected.view.MiniHomeConnectActionFocusComponent$configSource$1$1", f = "MiniHomeConnectActionFocusComponent.kt", i = {}, l = {221, 222, 227}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.tencent.mobileqq.zplan.minixwconnected.view.MiniHomeConnectActionFocusComponent$configSource$1$1, reason: invalid class name */
    /* loaded from: classes34.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ List<com.tencent.mobileqq.zplan.aio.panel.panel.a> $builders;
        final /* synthetic */ MutableStateFlow<Panel> $this_configSource;
        int label;
        final /* synthetic */ MiniHomeConnectActionFocusComponent this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass1(MiniHomeConnectActionFocusComponent miniHomeConnectActionFocusComponent, List<? extends com.tencent.mobileqq.zplan.aio.panel.panel.a> list, MutableStateFlow<Panel> mutableStateFlow, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = miniHomeConnectActionFocusComponent;
            this.$builders = list;
            this.$this_configSource = mutableStateFlow;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.this$0, this.$builders, this.$this_configSource, continuation);
        }

        /* JADX WARN: Can't wrap try/catch for region: R(6:1|(2:26|(1:(1:(2:30|31))(3:32|15|16))(5:33|34|10|11|(1:13)(3:14|15|16)))|3|4|5|(1:7)(4:9|10|11|(0)(0))) */
        /* JADX WARN: Code restructure failed: missing block: B:24:0x0053, code lost:
        
            r1 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:25:0x0054, code lost:
        
            r8 = r0;
            r0 = r10;
            r10 = r1;
            r1 = r8;
         */
        /* JADX WARN: Removed duplicated region for block: B:13:0x004b A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:14:0x004c  */
        /* JADX WARN: Removed duplicated region for block: B:22:0x007e A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:23:0x007f  */
        /* JADX WARN: Removed duplicated region for block: B:7:0x003a A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:9:0x003b  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x007f -> B:4:0x002e). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended;
            Object obj2;
            AnonymousClass1 anonymousClass1;
            AnonymousClass1 anonymousClass12;
            MutableStateFlow<Panel> mutableStateFlow;
            Object m3;
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i3 = this.label;
            if (i3 != 0) {
                try {
                } catch (Throwable th5) {
                    th = th5;
                    obj2 = coroutine_suspended;
                    anonymousClass1 = this;
                    QLog.e("MiniHomeConnectFriendFocusComponent", 1, "\u62c9\u53d6\u9762\u677f\u5931\u8d25 " + th.getMessage(), th);
                    anonymousClass1.label = 3;
                    if (DelayKt.delay(1000L, anonymousClass1) == obj2) {
                    }
                }
                if (i3 == 1) {
                    ResultKt.throwOnFailure(obj);
                    obj2 = coroutine_suspended;
                    anonymousClass1 = this;
                    try {
                    } catch (Throwable th6) {
                        th = th6;
                        QLog.e("MiniHomeConnectFriendFocusComponent", 1, "\u62c9\u53d6\u9762\u677f\u5931\u8d25 " + th.getMessage(), th);
                        anonymousClass1.label = 3;
                        if (DelayKt.delay(1000L, anonymousClass1) == obj2) {
                            return obj2;
                        }
                        anonymousClass12 = anonymousClass1;
                        coroutine_suspended = obj2;
                        MiniHomeConnectActionFocusComponent miniHomeConnectActionFocusComponent = anonymousClass12.this$0;
                        List<com.tencent.mobileqq.zplan.aio.panel.panel.a> list = anonymousClass12.$builders;
                        anonymousClass12.label = 1;
                        m3 = miniHomeConnectActionFocusComponent.m(list, anonymousClass12);
                        if (m3 != coroutine_suspended) {
                        }
                    }
                    mutableStateFlow = anonymousClass1.$this_configSource;
                    anonymousClass1.label = 2;
                    if (mutableStateFlow.emit((Panel) obj, anonymousClass1) != obj2) {
                        return obj2;
                    }
                    coroutine_suspended = obj2;
                    return Unit.INSTANCE;
                }
                if (i3 == 2) {
                    ResultKt.throwOnFailure(obj);
                    return Unit.INSTANCE;
                }
                if (i3 != 3) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
            ResultKt.throwOnFailure(obj);
            anonymousClass12 = this;
            MiniHomeConnectActionFocusComponent miniHomeConnectActionFocusComponent2 = anonymousClass12.this$0;
            List<com.tencent.mobileqq.zplan.aio.panel.panel.a> list2 = anonymousClass12.$builders;
            anonymousClass12.label = 1;
            m3 = miniHomeConnectActionFocusComponent2.m(list2, anonymousClass12);
            if (m3 != coroutine_suspended) {
                return coroutine_suspended;
            }
            Object obj3 = coroutine_suspended;
            anonymousClass1 = anonymousClass12;
            obj = m3;
            obj2 = obj3;
            mutableStateFlow = anonymousClass1.$this_configSource;
            anonymousClass1.label = 2;
            if (mutableStateFlow.emit((Panel) obj, anonymousClass1) != obj2) {
            }
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public MiniHomeConnectActionFocusComponent$configSource$1(MiniHomeConnectActionFocusComponent miniHomeConnectActionFocusComponent, List<? extends com.tencent.mobileqq.zplan.aio.panel.panel.a> list, MutableStateFlow<Panel> mutableStateFlow, Continuation<? super MiniHomeConnectActionFocusComponent$configSource$1> continuation) {
        super(2, continuation);
        this.this$0 = miniHomeConnectActionFocusComponent;
        this.$builders = list;
        this.$this_configSource = mutableStateFlow;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new MiniHomeConnectActionFocusComponent$configSource$1(this.this$0, this.$builders, this.$this_configSource, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            i.a aVar = i.a.f261779e;
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, this.$builders, this.$this_configSource, null);
            this.label = 1;
            if (CorountineFunKt.i(aVar, null, null, anonymousClass1, this, 6, null) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i3 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((MiniHomeConnectActionFocusComponent$configSource$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
