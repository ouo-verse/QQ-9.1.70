package com.tencent.mobileqq.zplan.aio.panel.panel;

import com.tencent.mobileqq.qcoroutine.api.coroutine.CorountineFunKt;
import com.tencent.mobileqq.qcoroutine.api.i;
import com.tencent.mobileqq.zplan.aio.panel.panel.Panel;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.flow.MutableStateFlow;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.zplan.aio.panel.panel.Panel$Companion$configSource$1", f = "Panel.kt", i = {}, l = {200}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes35.dex */
public final class Panel$Companion$configSource$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ List<a> $builders;
    final /* synthetic */ int $entryType;
    final /* synthetic */ boolean $forceRefresh;
    final /* synthetic */ Function0<String> $getReportSubtabOpenSource;
    final /* synthetic */ String $reportSceneType;
    final /* synthetic */ MutableStateFlow<Panel> $this_configSource;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    @DebugMetadata(c = "com.tencent.mobileqq.zplan.aio.panel.panel.Panel$Companion$configSource$1$1", f = "Panel.kt", i = {1}, l = {203, 206, 208, 211, 220}, m = "invokeSuspend", n = {"cacheOrBackendPanel"}, s = {"L$0"})
    /* renamed from: com.tencent.mobileqq.zplan.aio.panel.panel.Panel$Companion$configSource$1$1, reason: invalid class name */
    /* loaded from: classes35.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ List<a> $builders;
        final /* synthetic */ int $entryType;
        final /* synthetic */ boolean $forceRefresh;
        final /* synthetic */ Function0<String> $getReportSubtabOpenSource;
        final /* synthetic */ String $reportSceneType;
        final /* synthetic */ MutableStateFlow<Panel> $this_configSource;
        Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass1(int i3, List<? extends a> list, MutableStateFlow<Panel> mutableStateFlow, boolean z16, String str, Function0<String> function0, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$entryType = i3;
            this.$builders = list;
            this.$this_configSource = mutableStateFlow;
            this.$forceRefresh = z16;
            this.$reportSceneType = str;
            this.$getReportSubtabOpenSource = function0;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$entryType, this.$builders, this.$this_configSource, this.$forceRefresh, this.$reportSceneType, this.$getReportSubtabOpenSource, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Can't wrap try/catch for region: R(11:1|2|(2:45|(1:(1:(1:(1:(2:51|52))(3:53|31|32))(6:54|55|28|(1:30)|31|32))(4:56|57|18|(3:35|31|32)(4:22|23|24|(1:26)(5:27|28|(0)|31|32))))(10:58|59|14|15|(1:17)|18|(1:20)|35|31|32))|4|5|6|7|8|9|(1:11)(9:13|14|15|(0)|18|(0)|35|31|32)|(1:(0))) */
        /* JADX WARN: Can't wrap try/catch for region: R(9:2|(2:45|(1:(1:(1:(1:(2:51|52))(3:53|31|32))(6:54|55|28|(1:30)|31|32))(4:56|57|18|(3:35|31|32)(4:22|23|24|(1:26)(5:27|28|(0)|31|32))))(10:58|59|14|15|(1:17)|18|(1:20)|35|31|32))|4|5|6|7|8|9|(1:11)(9:13|14|15|(0)|18|(0)|35|31|32)) */
        /* JADX WARN: Code restructure failed: missing block: B:41:0x00cd, code lost:
        
            r0 = th;
         */
        /* JADX WARN: Code restructure failed: missing block: B:42:0x00ce, code lost:
        
            r15 = r18;
         */
        /* JADX WARN: Code restructure failed: missing block: B:43:0x00d1, code lost:
        
            r0 = th;
         */
        /* JADX WARN: Removed duplicated region for block: B:11:0x0066 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:13:0x0067  */
        /* JADX WARN: Removed duplicated region for block: B:17:0x0083 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:20:0x0088 A[Catch: CancellationException -> 0x0049, all -> 0x00d1, TryCatch #0 {all -> 0x00d1, blocks: (B:6:0x0050, B:18:0x0084, B:20:0x0088, B:22:0x0090), top: B:5:0x0050 }] */
        /* JADX WARN: Removed duplicated region for block: B:30:0x00c3 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:39:0x00f9 A[RETURN] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:38:0x00f7 -> B:5:0x0050). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended;
            AnonymousClass1 anonymousClass1;
            Object obj2;
            Panel panel;
            Object obj3;
            MutableStateFlow<Panel> mutableStateFlow;
            MutableStateFlow<Panel> mutableStateFlow2;
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i3 = this.label;
            try {
                if (i3 != 0) {
                    try {
                    } catch (Throwable th5) {
                        th = th5;
                        anonymousClass1 = this;
                        QLog.e("AioAvatarPanel", 1, "\u62c9\u53d6\u9762\u677f\u5931\u8d25 " + th.getMessage(), th);
                        anonymousClass1.L$0 = null;
                        anonymousClass1.label = 5;
                        if (DelayKt.delay(1000L, anonymousClass1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        Panel.Companion companion = Panel.INSTANCE;
                        int i16 = anonymousClass1.$entryType;
                        List<a> list = anonymousClass1.$builders;
                        anonymousClass1.label = 1;
                        AnonymousClass1 anonymousClass12 = anonymousClass1;
                        obj2 = companion.l(i16, list, (r13 & 4) != 0 ? true : true, (r13 & 8) != 0, anonymousClass1);
                        if (obj2 != coroutine_suspended) {
                        }
                    }
                    if (i3 == 1) {
                        ResultKt.throwOnFailure(obj);
                        obj2 = obj;
                        anonymousClass1 = this;
                        try {
                        } catch (Throwable th6) {
                            th = th6;
                            QLog.e("AioAvatarPanel", 1, "\u62c9\u53d6\u9762\u677f\u5931\u8d25 " + th.getMessage(), th);
                            anonymousClass1.L$0 = null;
                            anonymousClass1.label = 5;
                            if (DelayKt.delay(1000L, anonymousClass1) == coroutine_suspended) {
                            }
                            Panel.Companion companion2 = Panel.INSTANCE;
                            int i162 = anonymousClass1.$entryType;
                            List<a> list2 = anonymousClass1.$builders;
                            anonymousClass1.label = 1;
                            AnonymousClass1 anonymousClass122 = anonymousClass1;
                            obj2 = companion2.l(i162, list2, (r13 & 4) != 0 ? true : true, (r13 & 8) != 0, anonymousClass1);
                            if (obj2 != coroutine_suspended) {
                            }
                        }
                        Panel.INSTANCE.k((Panel) obj2, anonymousClass1.$reportSceneType, anonymousClass1.$getReportSubtabOpenSource);
                        panel = (Panel) obj2;
                        mutableStateFlow2 = anonymousClass1.$this_configSource;
                        anonymousClass1.L$0 = panel;
                        anonymousClass1.label = 2;
                        if (mutableStateFlow2.emit(panel, anonymousClass1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        if (!anonymousClass1.$forceRefresh) {
                        }
                        anonymousClass1 = anonymousClass1;
                        return Unit.INSTANCE;
                    }
                    if (i3 == 2) {
                        panel = (Panel) this.L$0;
                        ResultKt.throwOnFailure(obj);
                        anonymousClass1 = this;
                        if (!anonymousClass1.$forceRefresh && panel.getDataSource() != DataSource.Backend) {
                            Panel.Companion companion3 = Panel.INSTANCE;
                            int i17 = anonymousClass1.$entryType;
                            List<a> list3 = anonymousClass1.$builders;
                            anonymousClass1.L$0 = null;
                            anonymousClass1.label = 3;
                            AnonymousClass1 anonymousClass13 = anonymousClass1;
                            obj3 = companion3.l(i17, list3, (r13 & 4) != 0, (r13 & 8) != 0, anonymousClass1);
                            if (obj3 == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            anonymousClass1 = anonymousClass13;
                            Panel.INSTANCE.k((Panel) obj3, anonymousClass1.$reportSceneType, anonymousClass1.$getReportSubtabOpenSource);
                            mutableStateFlow = anonymousClass1.$this_configSource;
                            anonymousClass1.label = 4;
                            if (mutableStateFlow.emit((Panel) obj3, anonymousClass1) == coroutine_suspended) {
                            }
                            return Unit.INSTANCE;
                        }
                        anonymousClass1 = anonymousClass1;
                        return Unit.INSTANCE;
                    }
                    if (i3 == 3) {
                        ResultKt.throwOnFailure(obj);
                        obj3 = obj;
                        anonymousClass1 = this;
                        Panel.INSTANCE.k((Panel) obj3, anonymousClass1.$reportSceneType, anonymousClass1.$getReportSubtabOpenSource);
                        mutableStateFlow = anonymousClass1.$this_configSource;
                        anonymousClass1.label = 4;
                        if (mutableStateFlow.emit((Panel) obj3, anonymousClass1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        return Unit.INSTANCE;
                    }
                    if (i3 == 4) {
                        ResultKt.throwOnFailure(obj);
                        anonymousClass1 = this;
                        return Unit.INSTANCE;
                    }
                    if (i3 != 5) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                }
                ResultKt.throwOnFailure(obj);
                anonymousClass1 = this;
                Panel.Companion companion22 = Panel.INSTANCE;
                int i1622 = anonymousClass1.$entryType;
                List<a> list22 = anonymousClass1.$builders;
                anonymousClass1.label = 1;
                AnonymousClass1 anonymousClass1222 = anonymousClass1;
                obj2 = companion22.l(i1622, list22, (r13 & 4) != 0 ? true : true, (r13 & 8) != 0, anonymousClass1);
                if (obj2 != coroutine_suspended) {
                    return coroutine_suspended;
                }
                anonymousClass1 = anonymousClass1222;
                Panel.INSTANCE.k((Panel) obj2, anonymousClass1.$reportSceneType, anonymousClass1.$getReportSubtabOpenSource);
                panel = (Panel) obj2;
                mutableStateFlow2 = anonymousClass1.$this_configSource;
                anonymousClass1.L$0 = panel;
                anonymousClass1.label = 2;
                if (mutableStateFlow2.emit(panel, anonymousClass1) == coroutine_suspended) {
                }
                if (!anonymousClass1.$forceRefresh) {
                }
                anonymousClass1 = anonymousClass1;
                return Unit.INSTANCE;
            } catch (CancellationException e16) {
                QLog.e("AioAvatarPanel", 1, "\u53d6\u6d88\u62c9\u53d6\u9762\u677f ", e16);
                return Unit.INSTANCE;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public Panel$Companion$configSource$1(int i3, List<? extends a> list, MutableStateFlow<Panel> mutableStateFlow, boolean z16, String str, Function0<String> function0, Continuation<? super Panel$Companion$configSource$1> continuation) {
        super(2, continuation);
        this.$entryType = i3;
        this.$builders = list;
        this.$this_configSource = mutableStateFlow;
        this.$forceRefresh = z16;
        this.$reportSceneType = str;
        this.$getReportSubtabOpenSource = function0;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new Panel$Companion$configSource$1(this.$entryType, this.$builders, this.$this_configSource, this.$forceRefresh, this.$reportSceneType, this.$getReportSubtabOpenSource, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            i.a aVar = i.a.f261779e;
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$entryType, this.$builders, this.$this_configSource, this.$forceRefresh, this.$reportSceneType, this.$getReportSubtabOpenSource, null);
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
        return ((Panel$Companion$configSource$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
