package com.tencent.mobileqq.guild.quicksearch.resultview.dssearch;

import android.os.SystemClock;
import android.util.Log;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0005\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00010\u0002H\u008a@\u00a8\u0006\u0004"}, d2 = {"T", BdhLogUtil.LogTag.Tag_Req, "Lkotlinx/coroutines/flow/FlowCollector;", "", "kotlinx/coroutines/flow/FlowKt__EmittersKt$transform$1", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.guild.quicksearch.resultview.dssearch.DSSearchViewModelKt$slowContentEmit$$inlined$transform$1", f = "DSSearchViewModel.kt", i = {}, l = {223}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes14.dex */
public final class DSSearchViewModelKt$slowContentEmit$$inlined$transform$1 extends SuspendLambda implements Function2<FlowCollector<? super DSSearchData>, Continuation<? super Unit>, Object> {
    final /* synthetic */ Ref.LongRef $emitTimestamp$inlined;
    final /* synthetic */ long $interval$inlined;
    final /* synthetic */ Ref.ObjectRef $prevAnswerData$inlined;
    final /* synthetic */ int $stepLength$inlined;
    final /* synthetic */ Flow $this_transform;
    private /* synthetic */ Object L$0;
    int label;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00028\u0000H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0006\u00b8\u0006\u0007"}, d2 = {"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/FlowCollector;", "emit", "", "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core", "kotlinx/coroutines/flow/FlowKt__EmittersKt$transform$1$invokeSuspend$$inlined$collect$1"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* renamed from: com.tencent.mobileqq.guild.quicksearch.resultview.dssearch.DSSearchViewModelKt$slowContentEmit$$inlined$transform$1$1, reason: invalid class name */
    /* loaded from: classes14.dex */
    public static final class AnonymousClass1 implements FlowCollector<DSSearchData> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ FlowCollector f231666d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Ref.ObjectRef f231667e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ Ref.LongRef f231668f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ int f231669h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ long f231670i;

        /* compiled from: P */
        @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
        @DebugMetadata(c = "com.tencent.mobileqq.guild.quicksearch.resultview.dssearch.DSSearchViewModelKt$slowContentEmit$$inlined$transform$1$1", f = "DSSearchViewModel.kt", i = {1, 1, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 6, 6}, l = {145, 157, 167, 170, 194, 197, 211}, m = "emit", n = {"this", "data", "this", "data", "$this$slowContentEmit_u24lambda_u246", "prevData", "reasonStep", "i", "this", "data", "$this$slowContentEmit_u24lambda_u246", "prevData", "reasonStep", "i", "this", "data", "$this$slowContentEmit_u24lambda_u246", "prevData", "contentStep", "i", "this", "data", "$this$slowContentEmit_u24lambda_u246", "prevData", "contentStep", "i", "this", "data"}, s = {"L$0", "L$1", "L$0", "L$1", "L$2", "L$3", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "I$0", "I$1", "L$0", "L$1"})
        /* renamed from: com.tencent.mobileqq.guild.quicksearch.resultview.dssearch.DSSearchViewModelKt$slowContentEmit$$inlined$transform$1$1$1, reason: invalid class name and collision with other inner class name */
        /* loaded from: classes14.dex */
        public static final class C78701 extends ContinuationImpl {
            int I$0;
            int I$1;
            Object L$0;
            Object L$1;
            Object L$2;
            Object L$3;
            int label;
            /* synthetic */ Object result;

            public C78701(Continuation continuation) {
                super(continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                this.result = obj;
                this.label |= Integer.MIN_VALUE;
                return AnonymousClass1.this.emit(null, this);
            }
        }

        public AnonymousClass1(FlowCollector flowCollector, Ref.ObjectRef objectRef, Ref.LongRef longRef, int i3, long j3) {
            this.f231667e = objectRef;
            this.f231668f = longRef;
            this.f231669h = i3;
            this.f231670i = j3;
            this.f231666d = flowCollector;
        }

        /* JADX WARN: Failed to find 'out' block for switch in B:7:0x002f. Please report as an issue. */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:11:0x003b  */
        /* JADX WARN: Removed duplicated region for block: B:15:0x0048  */
        /* JADX WARN: Removed duplicated region for block: B:19:0x0278  */
        /* JADX WARN: Removed duplicated region for block: B:26:0x02e7  */
        /* JADX WARN: Removed duplicated region for block: B:29:0x0317 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:30:0x0318  */
        /* JADX WARN: Removed duplicated region for block: B:31:0x0320  */
        /* JADX WARN: Removed duplicated region for block: B:34:0x0339 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:35:0x033a  */
        /* JADX WARN: Removed duplicated region for block: B:36:0x006a  */
        /* JADX WARN: Removed duplicated region for block: B:37:0x0085  */
        /* JADX WARN: Removed duplicated region for block: B:41:0x0198  */
        /* JADX WARN: Removed duplicated region for block: B:50:0x021a  */
        /* JADX WARN: Removed duplicated region for block: B:53:0x024a A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:54:0x024b  */
        /* JADX WARN: Removed duplicated region for block: B:56:0x0256  */
        /* JADX WARN: Removed duplicated region for block: B:61:0x00a7  */
        /* JADX WARN: Removed duplicated region for block: B:62:0x00c0  */
        /* JADX WARN: Removed duplicated region for block: B:64:0x00cd  */
        /* JADX WARN: Removed duplicated region for block: B:65:0x00d2  */
        /* JADX WARN: Removed duplicated region for block: B:8:0x0032  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:30:0x0318 -> B:16:0x0061). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:54:0x024b -> B:38:0x0251). Please report as a decompilation issue!!! */
        @Override // kotlinx.coroutines.flow.FlowCollector
        @Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public Object emit(DSSearchData dSSearchData, @NotNull Continuation continuation) {
            C78701 c78701;
            Object coroutine_suspended;
            AnonymousClass1 anonymousClass1;
            FlowCollector flowCollector;
            DSSearchData dSSearchData2;
            int i3;
            DSSearchData dSSearchData3;
            int i16;
            AnonymousClass1 anonymousClass12;
            T t16;
            int i17;
            FlowCollector flowCollector2;
            DSSearchData dSSearchData4;
            Object obj;
            DSSearchData dSSearchData5;
            FlowCollector flowCollector3;
            DSSearchData dSSearchData6;
            int i18;
            AnonymousClass1 anonymousClass13;
            DSSearchData dSSearchData7;
            int i19;
            DSSearchData dSSearchData8;
            FlowCollector flowCollector4;
            DSSearchData dSSearchData9;
            int i26;
            AnonymousClass1 anonymousClass14;
            DSSearchData c16;
            int i27;
            AnonymousClass1 anonymousClass15;
            DSSearchData dSSearchData10;
            AnonymousClass1 anonymousClass16;
            DSSearchData dSSearchData11;
            FlowCollector flowCollector5;
            DSSearchData c17;
            int i28;
            T t17;
            if (continuation instanceof C78701) {
                c78701 = (C78701) continuation;
                int i29 = c78701.label;
                if ((i29 & Integer.MIN_VALUE) != 0) {
                    c78701.label = i29 - Integer.MIN_VALUE;
                    Object obj2 = c78701.result;
                    coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    switch (c78701.label) {
                        case 0:
                            ResultKt.throwOnFailure(obj2);
                            FlowCollector flowCollector6 = this.f231666d;
                            DSSearchData dSSearchData12 = dSSearchData;
                            DSSearchData dSSearchData13 = (DSSearchData) this.f231667e.element;
                            if (dSSearchData12.getState() != 2 && dSSearchData12.getState() != 4 && (dSSearchData13 == null || (dSSearchData13.getContent().length() == dSSearchData12.getContent().length() && dSSearchData13.getReasonContent().length() == dSSearchData12.getReasonContent().length()))) {
                                Logger logger = Logger.f235387a;
                                if (QLog.isDevelopLevel()) {
                                    Log.d("DSSearchViewModel", "slowContentEmit: ignore: " + dSSearchData12);
                                }
                                c78701.label = 1;
                                if (flowCollector6.emit(dSSearchData12, c78701) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                return Unit.INSTANCE;
                            }
                            if (dSSearchData13 == null) {
                                this.f231668f.element = SystemClock.uptimeMillis();
                                Logger logger2 = Logger.f235387a;
                                if (QLog.isDevelopLevel()) {
                                    Log.d("DSSearchViewModel", "slowContentEmit: first: " + dSSearchData12);
                                }
                                c78701.L$0 = this;
                                c78701.L$1 = dSSearchData12;
                                c78701.label = 2;
                                if (flowCollector6.emit(dSSearchData12, c78701) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                anonymousClass12 = this;
                                t16 = dSSearchData12;
                                anonymousClass12.f231667e.element = t16;
                                return Unit.INSTANCE;
                            }
                            int length = (dSSearchData12.getReasonContent().length() - dSSearchData13.getReasonContent().length()) / this.f231669h;
                            anonymousClass1 = this;
                            if (length > 0) {
                                flowCollector = flowCollector6;
                                dSSearchData2 = dSSearchData12;
                                i3 = 0;
                                dSSearchData3 = dSSearchData13;
                                i16 = length;
                                FlowCollector flowCollector7 = flowCollector;
                                if (i3 < i16) {
                                    DSSearchData dSSearchData14 = dSSearchData2;
                                    long uptimeMillis = anonymousClass1.f231670i - (SystemClock.uptimeMillis() - anonymousClass1.f231668f.element);
                                    if (uptimeMillis > 0) {
                                        c78701.L$0 = anonymousClass1;
                                        c78701.L$1 = dSSearchData14;
                                        c78701.L$2 = flowCollector7;
                                        c78701.L$3 = dSSearchData3;
                                        c78701.I$0 = i16;
                                        c78701.I$1 = i3;
                                        c78701.label = 3;
                                        if (DelayKt.delay(uptimeMillis, c78701) == coroutine_suspended) {
                                            return coroutine_suspended;
                                        }
                                        flowCollector2 = flowCollector7;
                                        dSSearchData4 = dSSearchData14;
                                        i17 = i3;
                                        dSSearchData8 = dSSearchData4;
                                        dSSearchData9 = dSSearchData3;
                                        FlowCollector flowCollector8 = flowCollector2;
                                        i26 = i16;
                                        anonymousClass14 = anonymousClass1;
                                        flowCollector4 = flowCollector8;
                                        int i36 = i26;
                                        anonymousClass14.f231668f.element = SystemClock.uptimeMillis();
                                        String substring = dSSearchData8.getReasonContent().substring(0, dSSearchData9.getReasonContent().length() + (anonymousClass14.f231669h * (i17 + 1)));
                                        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String\u2026ing(startIndex, endIndex)");
                                        c16 = DSSearchData.c(dSSearchData8, 2, "", substring, 0L, 0L, 24, null);
                                        Logger logger3 = Logger.f235387a;
                                        if (QLog.isDevelopLevel()) {
                                            Log.d("DSSearchViewModel", "slowContentEmit: reasonSlow[step=" + i17 + "]: " + c16);
                                        }
                                        c78701.L$0 = anonymousClass14;
                                        c78701.L$1 = dSSearchData8;
                                        c78701.L$2 = flowCollector4;
                                        c78701.L$3 = dSSearchData9;
                                        c78701.I$0 = i36;
                                        c78701.I$1 = i17;
                                        c78701.label = 4;
                                        if (flowCollector4.emit(c16, c78701) == coroutine_suspended) {
                                            return coroutine_suspended;
                                        }
                                        flowCollector = flowCollector4;
                                        i27 = 1;
                                        anonymousClass1 = anonymousClass14;
                                        i16 = i36;
                                        dSSearchData3 = dSSearchData9;
                                        dSSearchData2 = dSSearchData8;
                                        i3 = i17 + i27;
                                        FlowCollector flowCollector72 = flowCollector;
                                        if (i3 < i16) {
                                            flowCollector6 = flowCollector72;
                                            dSSearchData13 = dSSearchData3;
                                            dSSearchData12 = dSSearchData2;
                                        }
                                    } else {
                                        i26 = i16;
                                        dSSearchData9 = dSSearchData3;
                                        dSSearchData8 = dSSearchData14;
                                        anonymousClass14 = anonymousClass1;
                                        flowCollector4 = flowCollector72;
                                        i17 = i3;
                                        int i362 = i26;
                                        anonymousClass14.f231668f.element = SystemClock.uptimeMillis();
                                        String substring2 = dSSearchData8.getReasonContent().substring(0, dSSearchData9.getReasonContent().length() + (anonymousClass14.f231669h * (i17 + 1)));
                                        Intrinsics.checkNotNullExpressionValue(substring2, "this as java.lang.String\u2026ing(startIndex, endIndex)");
                                        c16 = DSSearchData.c(dSSearchData8, 2, "", substring2, 0L, 0L, 24, null);
                                        Logger logger32 = Logger.f235387a;
                                        if (QLog.isDevelopLevel()) {
                                        }
                                        c78701.L$0 = anonymousClass14;
                                        c78701.L$1 = dSSearchData8;
                                        c78701.L$2 = flowCollector4;
                                        c78701.L$3 = dSSearchData9;
                                        c78701.I$0 = i362;
                                        c78701.I$1 = i17;
                                        c78701.label = 4;
                                        if (flowCollector4.emit(c16, c78701) == coroutine_suspended) {
                                        }
                                    }
                                }
                            }
                            int length2 = (dSSearchData12.getContent().length() - dSSearchData13.getContent().length()) / anonymousClass1.f231669h;
                            if (length2 > 0) {
                                flowCollector3 = flowCollector6;
                                dSSearchData6 = dSSearchData13;
                                i18 = length2;
                                anonymousClass13 = anonymousClass1;
                                dSSearchData7 = dSSearchData12;
                                i19 = 0;
                                if (i19 < i18) {
                                    long uptimeMillis2 = anonymousClass13.f231670i - (SystemClock.uptimeMillis() - anonymousClass13.f231668f.element);
                                    if (uptimeMillis2 > 0) {
                                        c78701.L$0 = anonymousClass13;
                                        c78701.L$1 = dSSearchData7;
                                        c78701.L$2 = flowCollector3;
                                        c78701.L$3 = dSSearchData6;
                                        c78701.I$0 = i18;
                                        c78701.I$1 = i19;
                                        c78701.label = 5;
                                        if (DelayKt.delay(uptimeMillis2, c78701) == coroutine_suspended) {
                                            return coroutine_suspended;
                                        }
                                    }
                                    FlowCollector flowCollector9 = flowCollector3;
                                    dSSearchData10 = dSSearchData6;
                                    anonymousClass16 = anonymousClass13;
                                    dSSearchData11 = dSSearchData7;
                                    flowCollector5 = flowCollector9;
                                    anonymousClass16.f231668f.element = SystemClock.uptimeMillis();
                                    String substring3 = dSSearchData11.getContent().substring(0, dSSearchData10.getContent().length() + (anonymousClass16.f231669h * (i19 + 1)));
                                    Intrinsics.checkNotNullExpressionValue(substring3, "this as java.lang.String\u2026ing(startIndex, endIndex)");
                                    c17 = DSSearchData.c(dSSearchData11, 4, substring3, null, 0L, 0L, 28, null);
                                    Logger logger4 = Logger.f235387a;
                                    if (QLog.isDevelopLevel()) {
                                        Log.d("DSSearchViewModel", "slowContentEmit: contentSlow[step=" + i19 + "]: " + c17);
                                    }
                                    c78701.L$0 = anonymousClass16;
                                    c78701.L$1 = dSSearchData11;
                                    c78701.L$2 = flowCollector5;
                                    c78701.L$3 = dSSearchData10;
                                    c78701.I$0 = i18;
                                    c78701.I$1 = i19;
                                    c78701.label = 6;
                                    if (flowCollector5.emit(c17, c78701) != coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    i28 = 1;
                                    DSSearchData dSSearchData15 = dSSearchData11;
                                    anonymousClass13 = anonymousClass16;
                                    dSSearchData6 = dSSearchData10;
                                    flowCollector3 = flowCollector5;
                                    dSSearchData7 = dSSearchData15;
                                    i19 += i28;
                                    if (i19 < i18) {
                                        obj = coroutine_suspended;
                                        flowCollector6 = flowCollector3;
                                        dSSearchData5 = dSSearchData7;
                                        anonymousClass1 = anonymousClass13;
                                        c78701.L$0 = anonymousClass1;
                                        c78701.L$1 = dSSearchData5;
                                        c78701.L$2 = null;
                                        c78701.L$3 = null;
                                        c78701.label = 7;
                                        if (flowCollector6.emit(dSSearchData5, c78701) != obj) {
                                            return obj;
                                        }
                                        anonymousClass15 = anonymousClass1;
                                        t17 = dSSearchData5;
                                        anonymousClass15.f231667e.element = t17;
                                        return Unit.INSTANCE;
                                    }
                                }
                            } else {
                                obj = coroutine_suspended;
                                dSSearchData5 = dSSearchData12;
                                c78701.L$0 = anonymousClass1;
                                c78701.L$1 = dSSearchData5;
                                c78701.L$2 = null;
                                c78701.L$3 = null;
                                c78701.label = 7;
                                if (flowCollector6.emit(dSSearchData5, c78701) != obj) {
                                }
                            }
                            break;
                        case 1:
                            ResultKt.throwOnFailure(obj2);
                            return Unit.INSTANCE;
                        case 2:
                            DSSearchData dSSearchData16 = (DSSearchData) c78701.L$1;
                            anonymousClass12 = (AnonymousClass1) c78701.L$0;
                            ResultKt.throwOnFailure(obj2);
                            t16 = dSSearchData16;
                            anonymousClass12.f231667e.element = t16;
                            return Unit.INSTANCE;
                        case 3:
                            i17 = c78701.I$1;
                            i16 = c78701.I$0;
                            dSSearchData3 = (DSSearchData) c78701.L$3;
                            flowCollector2 = (FlowCollector) c78701.L$2;
                            dSSearchData4 = (DSSearchData) c78701.L$1;
                            anonymousClass1 = (AnonymousClass1) c78701.L$0;
                            ResultKt.throwOnFailure(obj2);
                            dSSearchData8 = dSSearchData4;
                            dSSearchData9 = dSSearchData3;
                            FlowCollector flowCollector82 = flowCollector2;
                            i26 = i16;
                            anonymousClass14 = anonymousClass1;
                            flowCollector4 = flowCollector82;
                            int i3622 = i26;
                            anonymousClass14.f231668f.element = SystemClock.uptimeMillis();
                            String substring22 = dSSearchData8.getReasonContent().substring(0, dSSearchData9.getReasonContent().length() + (anonymousClass14.f231669h * (i17 + 1)));
                            Intrinsics.checkNotNullExpressionValue(substring22, "this as java.lang.String\u2026ing(startIndex, endIndex)");
                            c16 = DSSearchData.c(dSSearchData8, 2, "", substring22, 0L, 0L, 24, null);
                            Logger logger322 = Logger.f235387a;
                            if (QLog.isDevelopLevel()) {
                            }
                            c78701.L$0 = anonymousClass14;
                            c78701.L$1 = dSSearchData8;
                            c78701.L$2 = flowCollector4;
                            c78701.L$3 = dSSearchData9;
                            c78701.I$0 = i3622;
                            c78701.I$1 = i17;
                            c78701.label = 4;
                            if (flowCollector4.emit(c16, c78701) == coroutine_suspended) {
                            }
                            break;
                        case 4:
                            i17 = c78701.I$1;
                            int i37 = c78701.I$0;
                            DSSearchData dSSearchData17 = (DSSearchData) c78701.L$3;
                            FlowCollector flowCollector10 = (FlowCollector) c78701.L$2;
                            DSSearchData dSSearchData18 = (DSSearchData) c78701.L$1;
                            AnonymousClass1 anonymousClass17 = (AnonymousClass1) c78701.L$0;
                            ResultKt.throwOnFailure(obj2);
                            i27 = 1;
                            dSSearchData3 = dSSearchData17;
                            dSSearchData2 = dSSearchData18;
                            anonymousClass1 = anonymousClass17;
                            i16 = i37;
                            flowCollector = flowCollector10;
                            i3 = i17 + i27;
                            FlowCollector flowCollector722 = flowCollector;
                            if (i3 < i16) {
                            }
                            break;
                        case 5:
                            i19 = c78701.I$1;
                            i18 = c78701.I$0;
                            dSSearchData6 = (DSSearchData) c78701.L$3;
                            flowCollector3 = (FlowCollector) c78701.L$2;
                            dSSearchData7 = (DSSearchData) c78701.L$1;
                            anonymousClass13 = (AnonymousClass1) c78701.L$0;
                            ResultKt.throwOnFailure(obj2);
                            FlowCollector flowCollector92 = flowCollector3;
                            dSSearchData10 = dSSearchData6;
                            anonymousClass16 = anonymousClass13;
                            dSSearchData11 = dSSearchData7;
                            flowCollector5 = flowCollector92;
                            anonymousClass16.f231668f.element = SystemClock.uptimeMillis();
                            String substring32 = dSSearchData11.getContent().substring(0, dSSearchData10.getContent().length() + (anonymousClass16.f231669h * (i19 + 1)));
                            Intrinsics.checkNotNullExpressionValue(substring32, "this as java.lang.String\u2026ing(startIndex, endIndex)");
                            c17 = DSSearchData.c(dSSearchData11, 4, substring32, null, 0L, 0L, 28, null);
                            Logger logger42 = Logger.f235387a;
                            if (QLog.isDevelopLevel()) {
                            }
                            c78701.L$0 = anonymousClass16;
                            c78701.L$1 = dSSearchData11;
                            c78701.L$2 = flowCollector5;
                            c78701.L$3 = dSSearchData10;
                            c78701.I$0 = i18;
                            c78701.I$1 = i19;
                            c78701.label = 6;
                            if (flowCollector5.emit(c17, c78701) != coroutine_suspended) {
                            }
                            break;
                        case 6:
                            i19 = c78701.I$1;
                            i18 = c78701.I$0;
                            dSSearchData10 = (DSSearchData) c78701.L$3;
                            flowCollector5 = (FlowCollector) c78701.L$2;
                            dSSearchData11 = (DSSearchData) c78701.L$1;
                            anonymousClass16 = (AnonymousClass1) c78701.L$0;
                            ResultKt.throwOnFailure(obj2);
                            i28 = 1;
                            DSSearchData dSSearchData152 = dSSearchData11;
                            anonymousClass13 = anonymousClass16;
                            dSSearchData6 = dSSearchData10;
                            flowCollector3 = flowCollector5;
                            dSSearchData7 = dSSearchData152;
                            i19 += i28;
                            if (i19 < i18) {
                            }
                            break;
                        case 7:
                            DSSearchData dSSearchData19 = (DSSearchData) c78701.L$1;
                            anonymousClass15 = (AnonymousClass1) c78701.L$0;
                            ResultKt.throwOnFailure(obj2);
                            t17 = dSSearchData19;
                            anonymousClass15.f231667e.element = t17;
                            return Unit.INSTANCE;
                        default:
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                }
            }
            c78701 = new C78701(continuation);
            Object obj22 = c78701.result;
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (c78701.label) {
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DSSearchViewModelKt$slowContentEmit$$inlined$transform$1(Flow flow, Continuation continuation, Ref.ObjectRef objectRef, Ref.LongRef longRef, int i3, long j3) {
        super(2, continuation);
        this.$this_transform = flow;
        this.$prevAnswerData$inlined = objectRef;
        this.$emitTimestamp$inlined = longRef;
        this.$stepLength$inlined = i3;
        this.$interval$inlined = j3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        DSSearchViewModelKt$slowContentEmit$$inlined$transform$1 dSSearchViewModelKt$slowContentEmit$$inlined$transform$1 = new DSSearchViewModelKt$slowContentEmit$$inlined$transform$1(this.$this_transform, continuation, this.$prevAnswerData$inlined, this.$emitTimestamp$inlined, this.$stepLength$inlined, this.$interval$inlined);
        dSSearchViewModelKt$slowContentEmit$$inlined$transform$1.L$0 = obj;
        return dSSearchViewModelKt$slowContentEmit$$inlined$transform$1;
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
            FlowCollector flowCollector = (FlowCollector) this.L$0;
            Flow flow = this.$this_transform;
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(flowCollector, this.$prevAnswerData$inlined, this.$emitTimestamp$inlined, this.$stepLength$inlined, this.$interval$inlined);
            this.label = 1;
            if (flow.collect(anonymousClass1, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull FlowCollector<? super DSSearchData> flowCollector, @Nullable Continuation<? super Unit> continuation) {
        return ((DSSearchViewModelKt$slowContentEmit$$inlined$transform$1) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
