package com.tencent.mobileqq.guild.aisearch.models.operators;

import android.os.SystemClock;
import android.util.Log;
import com.qzone.proxy.personalitycomponent.model.WidgetCacheConstellationData;
import com.tencent.mobileqq.guild.aisearch.models.ChatAnswerData;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.math.MathKt__MathJVMKt;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0005\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00010\u0002H\u008a@\u00a8\u0006\u0004"}, d2 = {"T", BdhLogUtil.LogTag.Tag_Req, "Lkotlinx/coroutines/flow/FlowCollector;", "", "kotlinx/coroutines/flow/FlowKt__EmittersKt$transform$1", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.guild.aisearch.models.operators.AdaptiveContentEmitKt$adaptiveContentEmit$$inlined$transform$1", f = "adaptiveContentEmit.kt", i = {}, l = {223}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes12.dex */
public final class AdaptiveContentEmitKt$adaptiveContentEmit$$inlined$transform$1 extends SuspendLambda implements Function2<FlowCollector<? super ChatAnswerData>, Continuation<? super Unit>, Object> {
    final /* synthetic */ Ref.LongRef $emitTimestamp$inlined;
    final /* synthetic */ Ref.ObjectRef $prevAnswerData$inlined;
    final /* synthetic */ d $speedState$inlined;
    final /* synthetic */ Flow $this_transform;
    private /* synthetic */ Object L$0;
    int label;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00028\u0000H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0006\u00b8\u0006\u0007"}, d2 = {"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/FlowCollector;", "emit", "", "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core", "kotlinx/coroutines/flow/FlowKt__EmittersKt$transform$1$invokeSuspend$$inlined$collect$1"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* renamed from: com.tencent.mobileqq.guild.aisearch.models.operators.AdaptiveContentEmitKt$adaptiveContentEmit$$inlined$transform$1$1, reason: invalid class name */
    /* loaded from: classes12.dex */
    public static final class AnonymousClass1 implements FlowCollector<ChatAnswerData> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ FlowCollector f214155d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Ref.ObjectRef f214156e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ d f214157f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ Ref.LongRef f214158h;

        /* compiled from: P */
        @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
        @DebugMetadata(c = "com.tencent.mobileqq.guild.aisearch.models.operators.AdaptiveContentEmitKt$adaptiveContentEmit$$inlined$transform$1$1", f = "adaptiveContentEmit.kt", i = {1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 5, 5}, l = {145, 157, 172, 181, 195, 206}, m = "emit", n = {"this", "data", "this", "data", "$this$adaptiveContentEmit_u24lambda_u245", "prevData", "reasonContentDiff", "contentDiff", "totalCount", WidgetCacheConstellationData.INTERVAL, "stepLength", "this", "data", "$this$adaptiveContentEmit_u24lambda_u245", "prevData", "i", "reasonContentDiff", "contentDiff", "totalCount", WidgetCacheConstellationData.INTERVAL, "stepLength", "emitStep", "emitCount", "this", "data", "$this$adaptiveContentEmit_u24lambda_u245", "prevData", "i", "reasonContentDiff", "contentDiff", "totalCount", WidgetCacheConstellationData.INTERVAL, "stepLength", "emitStep", "this", "data"}, s = {"L$0", "L$1", "L$0", "L$1", "L$2", "L$3", "I$0", "I$1", "I$2", "J$0", "F$0", "L$0", "L$1", "L$2", "L$3", "L$4", "I$0", "I$1", "I$2", "J$0", "F$0", "F$1", "I$3", "L$0", "L$1", "L$2", "L$3", "L$4", "I$0", "I$1", "I$2", "J$0", "F$0", "F$1", "L$0", "L$1"})
        /* renamed from: com.tencent.mobileqq.guild.aisearch.models.operators.AdaptiveContentEmitKt$adaptiveContentEmit$$inlined$transform$1$1$1, reason: invalid class name and collision with other inner class name */
        /* loaded from: classes12.dex */
        public static final class C76661 extends ContinuationImpl {
            float F$0;
            float F$1;
            int I$0;
            int I$1;
            int I$2;
            int I$3;
            long J$0;
            Object L$0;
            Object L$1;
            Object L$2;
            Object L$3;
            Object L$4;
            int label;
            /* synthetic */ Object result;

            public C76661(Continuation continuation) {
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

        public AnonymousClass1(FlowCollector flowCollector, Ref.ObjectRef objectRef, d dVar, Ref.LongRef longRef) {
            this.f214156e = objectRef;
            this.f214157f = dVar;
            this.f214158h = longRef;
            this.f214155d = flowCollector;
        }

        /* JADX WARN: Failed to find 'out' block for switch in B:7:0x0027. Please report as an issue. */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:11:0x0033  */
        /* JADX WARN: Removed duplicated region for block: B:16:0x0040  */
        /* JADX WARN: Removed duplicated region for block: B:20:0x01f1  */
        /* JADX WARN: Removed duplicated region for block: B:28:0x026a  */
        /* JADX WARN: Removed duplicated region for block: B:33:0x027e  */
        /* JADX WARN: Removed duplicated region for block: B:36:0x0319  */
        /* JADX WARN: Removed duplicated region for block: B:39:0x036b A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:40:0x036c  */
        /* JADX WARN: Removed duplicated region for block: B:41:0x0340  */
        /* JADX WARN: Removed duplicated region for block: B:42:0x02ad  */
        /* JADX WARN: Removed duplicated region for block: B:44:0x0275  */
        /* JADX WARN: Removed duplicated region for block: B:46:0x0380  */
        /* JADX WARN: Removed duplicated region for block: B:53:0x007e  */
        /* JADX WARN: Removed duplicated region for block: B:54:0x00b0  */
        /* JADX WARN: Removed duplicated region for block: B:56:0x00d1  */
        /* JADX WARN: Removed duplicated region for block: B:58:0x00de  */
        /* JADX WARN: Removed duplicated region for block: B:59:0x00e3  */
        /* JADX WARN: Removed duplicated region for block: B:8:0x002a  */
        /* JADX WARN: Type inference failed for: r3v20, types: [T, com.tencent.mobileqq.guild.aisearch.models.e, java.lang.Object] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:40:0x036c -> B:17:0x037c). Please report as a decompilation issue!!! */
        @Override // kotlinx.coroutines.flow.FlowCollector
        @Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public Object emit(ChatAnswerData chatAnswerData, @NotNull Continuation continuation) {
            C76661 c76661;
            Object coroutine_suspended;
            FlowCollector flowCollector;
            ChatAnswerData chatAnswerData2;
            ChatAnswerData chatAnswerData3;
            Object obj;
            String str;
            AnonymousClass1 anonymousClass1;
            T t16;
            String str2;
            int reasonContentDiff;
            int contentDiff;
            int totalCount;
            long interval;
            float f16;
            Object obj2;
            AnonymousClass1 anonymousClass12;
            Object obj3;
            float f17;
            float f18;
            float f19;
            C76661 c766612;
            FlowCollector flowCollector2;
            AnonymousClass1 anonymousClass13;
            int i3;
            ChatAnswerData chatAnswerData4;
            int i16;
            long j3;
            Ref.IntRef intRef;
            ChatAnswerData chatAnswerData5;
            float f26;
            float f27;
            int i17;
            FlowCollector flowCollector3;
            ChatAnswerData chatAnswerData6;
            AnonymousClass1 anonymousClass14;
            String str3;
            int i18;
            int i19;
            long j16;
            float f28;
            ChatAnswerData chatAnswerData7;
            FlowCollector flowCollector4;
            ChatAnswerData chatAnswerData8;
            Ref.IntRef intRef2;
            AnonymousClass1 anonymousClass15;
            int i26;
            int i27;
            Object obj4;
            boolean z16;
            float f29;
            float f36;
            long j17;
            Triple triple;
            ?? c16;
            String str4;
            Object obj5;
            ChatAnswerData chatAnswerData9;
            ChatAnswerData chatAnswerData10;
            int roundToInt;
            int roundToInt2;
            T t17;
            AnonymousClass1 anonymousClass16 = this;
            if (continuation instanceof C76661) {
                c76661 = (C76661) continuation;
                int i28 = c76661.label;
                if ((i28 & Integer.MIN_VALUE) != 0) {
                    c76661.label = i28 - Integer.MIN_VALUE;
                    Object obj6 = c76661.result;
                    coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    String str5 = "AIChatRepository";
                    switch (c76661.label) {
                        case 0:
                            ResultKt.throwOnFailure(obj6);
                            flowCollector = anonymousClass16.f214155d;
                            chatAnswerData2 = chatAnswerData;
                            chatAnswerData3 = (ChatAnswerData) anonymousClass16.f214156e.element;
                            if (chatAnswerData2.getState() != 2 && chatAnswerData2.getState() != 4 && (chatAnswerData3 == null || (chatAnswerData3.getContent().length() == chatAnswerData2.getContent().length() && chatAnswerData3.getReasonContent().length() == chatAnswerData2.getReasonContent().length()))) {
                                Logger logger = Logger.f235387a;
                                if (QLog.isDevelopLevel()) {
                                    Log.d("AIChatRepository", "adaptiveContentEmit: ignore: " + chatAnswerData2);
                                }
                                c76661.label = 1;
                                if (flowCollector.emit(chatAnswerData2, c76661) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                return Unit.INSTANCE;
                            }
                            StepResult b16 = anonymousClass16.f214157f.b(chatAnswerData2, chatAnswerData3);
                            if (b16 != null) {
                                if (chatAnswerData3 == null) {
                                    obj = coroutine_suspended;
                                    str = "AIChatRepository";
                                } else {
                                    reasonContentDiff = b16.getReasonContentDiff();
                                    contentDiff = b16.getContentDiff();
                                    totalCount = b16.getTotalCount() - b16.getReserveCount();
                                    EmitSpeed emitSpeed = b16.getEmitSpeed();
                                    interval = emitSpeed.getInterval();
                                    float stepLength = emitSpeed.getStepLength();
                                    if (b16.getDelayDuration() > 0) {
                                        Logger logger2 = Logger.f235387a;
                                        if (QLog.isDevelopLevel()) {
                                            long delayDuration = b16.getDelayDuration();
                                            obj3 = coroutine_suspended;
                                            StringBuilder sb5 = new StringBuilder();
                                            f17 = stepLength;
                                            sb5.append("adaptiveContentEmit: delayDuration=");
                                            sb5.append(delayDuration);
                                            Log.d("AIChatRepository", sb5.toString());
                                        } else {
                                            obj3 = coroutine_suspended;
                                            f17 = stepLength;
                                        }
                                        long delayDuration2 = b16.getDelayDuration();
                                        c76661.L$0 = anonymousClass16;
                                        c76661.L$1 = chatAnswerData2;
                                        c76661.L$2 = flowCollector;
                                        c76661.L$3 = chatAnswerData3;
                                        c76661.I$0 = reasonContentDiff;
                                        c76661.I$1 = contentDiff;
                                        c76661.I$2 = totalCount;
                                        c76661.J$0 = interval;
                                        f16 = f17;
                                        c76661.F$0 = f16;
                                        c76661.label = 3;
                                        obj2 = obj3;
                                        if (DelayKt.delay(delayDuration2, c76661) == obj2) {
                                            return obj2;
                                        }
                                    } else {
                                        f16 = stepLength;
                                        obj2 = coroutine_suspended;
                                    }
                                    anonymousClass12 = anonymousClass16;
                                    f18 = 0.0f;
                                    long j18 = interval;
                                    f19 = f16;
                                    c766612 = c76661;
                                    flowCollector2 = flowCollector;
                                    anonymousClass13 = anonymousClass12;
                                    i3 = reasonContentDiff;
                                    chatAnswerData4 = chatAnswerData3;
                                    i16 = contentDiff;
                                    j3 = j18;
                                    ChatAnswerData chatAnswerData11 = chatAnswerData2;
                                    intRef = new Ref.IntRef();
                                    chatAnswerData5 = chatAnswerData11;
                                    roundToInt = MathKt__MathJVMKt.roundToInt(f18);
                                    if (roundToInt >= totalCount) {
                                        float f37 = f18 + f19;
                                        roundToInt2 = MathKt__MathJVMKt.roundToInt(f37);
                                        i19 = Math.min(roundToInt2, totalCount);
                                        str3 = str5;
                                        float f38 = f19;
                                        int i29 = totalCount;
                                        long uptimeMillis = j3 - (SystemClock.uptimeMillis() - anonymousClass13.f214158h.element);
                                        if (uptimeMillis > 0) {
                                            c766612.L$0 = anonymousClass13;
                                            c766612.L$1 = chatAnswerData5;
                                            c766612.L$2 = flowCollector2;
                                            c766612.L$3 = chatAnswerData4;
                                            c766612.L$4 = intRef;
                                            c766612.I$0 = i3;
                                            c766612.I$1 = i16;
                                            c766612.I$2 = i29;
                                            c766612.J$0 = j3;
                                            c766612.F$0 = f38;
                                            c766612.F$1 = f37;
                                            c766612.I$3 = i19;
                                            c766612.label = 4;
                                            if (DelayKt.delay(uptimeMillis, c766612) == obj2) {
                                                return obj2;
                                            }
                                            anonymousClass14 = anonymousClass13;
                                            chatAnswerData6 = chatAnswerData5;
                                            coroutine_suspended = obj2;
                                            f27 = f38;
                                            i18 = i19;
                                            i17 = i29;
                                            c76661 = c766612;
                                            flowCollector3 = flowCollector2;
                                            f26 = f37;
                                            c766612 = c76661;
                                            i26 = i16;
                                            f28 = f27;
                                            intRef2 = intRef;
                                            int i36 = i18;
                                            anonymousClass15 = anonymousClass14;
                                            i27 = i17;
                                            chatAnswerData8 = chatAnswerData4;
                                            j16 = j3;
                                            flowCollector4 = flowCollector3;
                                            chatAnswerData7 = chatAnswerData6;
                                            i19 = i36;
                                            if (i19 <= i3) {
                                                obj4 = coroutine_suspended;
                                                if (chatAnswerData8.getState() <= 2) {
                                                    z16 = true;
                                                    if (!z16) {
                                                        f29 = f26;
                                                        Integer boxInt = Boxing.boxInt(2);
                                                        f36 = f28;
                                                        j17 = j16;
                                                        String substring = chatAnswerData7.getReasonContent().substring(0, chatAnswerData8.getReasonContent().length() + Math.min(i3, i19));
                                                        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String\u2026ing(startIndex, endIndex)");
                                                        triple = new Triple(boxInt, substring, "");
                                                    } else {
                                                        f29 = f26;
                                                        f36 = f28;
                                                        j17 = j16;
                                                        Integer boxInt2 = Boxing.boxInt(4);
                                                        String reasonContent = chatAnswerData7.getReasonContent();
                                                        String substring2 = chatAnswerData7.getContent().substring(0, chatAnswerData8.getContent().length() + Math.min(i26, i19 - i3));
                                                        Intrinsics.checkNotNullExpressionValue(substring2, "this as java.lang.String\u2026ing(startIndex, endIndex)");
                                                        triple = new Triple(boxInt2, reasonContent, substring2);
                                                    }
                                                    int intValue = ((Number) triple.component1()).intValue();
                                                    String str6 = (String) triple.component2();
                                                    String str7 = (String) triple.component3();
                                                    anonymousClass15.f214158h.element = SystemClock.uptimeMillis();
                                                    c16 = ChatAnswerData.c(chatAnswerData7, intValue, str7, str6, 0L, 0L, 0L, 56, null);
                                                    anonymousClass15.f214156e.element = c16;
                                                    Logger logger3 = Logger.f235387a;
                                                    if (!QLog.isDevelopLevel()) {
                                                        int i37 = intRef2.element + 1;
                                                        intRef2.element = i37;
                                                        str4 = str3;
                                                        Log.d(str4, "adaptiveContentEmit: reasonSlow[step=" + i37 + "]: " + ((Object) c16));
                                                    } else {
                                                        str4 = str3;
                                                    }
                                                    c766612.L$0 = anonymousClass15;
                                                    c766612.L$1 = chatAnswerData7;
                                                    c766612.L$2 = flowCollector4;
                                                    c766612.L$3 = chatAnswerData8;
                                                    c766612.L$4 = intRef2;
                                                    c766612.I$0 = i3;
                                                    c766612.I$1 = i26;
                                                    c766612.I$2 = i27;
                                                    flowCollector2 = flowCollector4;
                                                    long j19 = j17;
                                                    c766612.J$0 = j19;
                                                    float f39 = f36;
                                                    c766612.F$0 = f39;
                                                    float f46 = f29;
                                                    c766612.F$1 = f46;
                                                    c766612.label = 5;
                                                    obj5 = obj4;
                                                    if (flowCollector2.emit(c16, c766612) != obj5) {
                                                        return obj5;
                                                    }
                                                    chatAnswerData9 = chatAnswerData7;
                                                    j3 = j19;
                                                    ChatAnswerData chatAnswerData12 = chatAnswerData8;
                                                    totalCount = i27;
                                                    chatAnswerData10 = chatAnswerData12;
                                                    i16 = i26;
                                                    anonymousClass13 = anonymousClass15;
                                                    obj2 = obj5;
                                                    f18 = f46;
                                                    intRef = intRef2;
                                                    f19 = f39;
                                                    str5 = str4;
                                                    chatAnswerData4 = chatAnswerData10;
                                                    chatAnswerData5 = chatAnswerData9;
                                                    roundToInt = MathKt__MathJVMKt.roundToInt(f18);
                                                    if (roundToInt >= totalCount) {
                                                        if (chatAnswerData5.getState() != 2 && chatAnswerData5.getState() != 4) {
                                                            c766612.L$0 = anonymousClass13;
                                                            c766612.L$1 = chatAnswerData5;
                                                            c766612.L$2 = null;
                                                            c766612.L$3 = null;
                                                            c766612.L$4 = null;
                                                            c766612.label = 6;
                                                            Object emit = flowCollector2.emit(chatAnswerData5, c766612);
                                                            t17 = chatAnswerData5;
                                                            if (emit == obj2) {
                                                                return obj2;
                                                            }
                                                            anonymousClass13.f214156e.element = t17;
                                                        }
                                                        return Unit.INSTANCE;
                                                    }
                                                }
                                            } else {
                                                obj4 = coroutine_suspended;
                                            }
                                            z16 = false;
                                            if (!z16) {
                                            }
                                            int intValue2 = ((Number) triple.component1()).intValue();
                                            String str62 = (String) triple.component2();
                                            String str72 = (String) triple.component3();
                                            anonymousClass15.f214158h.element = SystemClock.uptimeMillis();
                                            c16 = ChatAnswerData.c(chatAnswerData7, intValue2, str72, str62, 0L, 0L, 0L, 56, null);
                                            anonymousClass15.f214156e.element = c16;
                                            Logger logger32 = Logger.f235387a;
                                            if (!QLog.isDevelopLevel()) {
                                            }
                                            c766612.L$0 = anonymousClass15;
                                            c766612.L$1 = chatAnswerData7;
                                            c766612.L$2 = flowCollector4;
                                            c766612.L$3 = chatAnswerData8;
                                            c766612.L$4 = intRef2;
                                            c766612.I$0 = i3;
                                            c766612.I$1 = i26;
                                            c766612.I$2 = i27;
                                            flowCollector2 = flowCollector4;
                                            long j192 = j17;
                                            c766612.J$0 = j192;
                                            float f392 = f36;
                                            c766612.F$0 = f392;
                                            float f462 = f29;
                                            c766612.F$1 = f462;
                                            c766612.label = 5;
                                            obj5 = obj4;
                                            if (flowCollector2.emit(c16, c766612) != obj5) {
                                            }
                                        } else {
                                            intRef2 = intRef;
                                            chatAnswerData8 = chatAnswerData4;
                                            i27 = i29;
                                            j16 = j3;
                                            chatAnswerData7 = chatAnswerData5;
                                            coroutine_suspended = obj2;
                                            flowCollector4 = flowCollector2;
                                            f26 = f37;
                                            anonymousClass15 = anonymousClass13;
                                            i26 = i16;
                                            f28 = f38;
                                            if (i19 <= i3) {
                                            }
                                            z16 = false;
                                            if (!z16) {
                                            }
                                            int intValue22 = ((Number) triple.component1()).intValue();
                                            String str622 = (String) triple.component2();
                                            String str722 = (String) triple.component3();
                                            anonymousClass15.f214158h.element = SystemClock.uptimeMillis();
                                            c16 = ChatAnswerData.c(chatAnswerData7, intValue22, str722, str622, 0L, 0L, 0L, 56, null);
                                            anonymousClass15.f214156e.element = c16;
                                            Logger logger322 = Logger.f235387a;
                                            if (!QLog.isDevelopLevel()) {
                                            }
                                            c766612.L$0 = anonymousClass15;
                                            c766612.L$1 = chatAnswerData7;
                                            c766612.L$2 = flowCollector4;
                                            c766612.L$3 = chatAnswerData8;
                                            c766612.L$4 = intRef2;
                                            c766612.I$0 = i3;
                                            c766612.I$1 = i26;
                                            c766612.I$2 = i27;
                                            flowCollector2 = flowCollector4;
                                            long j1922 = j17;
                                            c766612.J$0 = j1922;
                                            float f3922 = f36;
                                            c766612.F$0 = f3922;
                                            float f4622 = f29;
                                            c766612.F$1 = f4622;
                                            c766612.label = 5;
                                            obj5 = obj4;
                                            if (flowCollector2.emit(c16, c766612) != obj5) {
                                            }
                                        }
                                    }
                                }
                            } else {
                                obj = coroutine_suspended;
                                str = "AIChatRepository";
                                anonymousClass16 = this;
                            }
                            anonymousClass16.f214158h.element = SystemClock.uptimeMillis();
                            Logger logger4 = Logger.f235387a;
                            if (QLog.isDevelopLevel()) {
                                if (chatAnswerData3 == null) {
                                    str2 = "first data";
                                } else {
                                    str2 = "ignore data";
                                }
                                Log.d(str, "adaptiveContentEmit: date content " + chatAnswerData2 + ", " + str2);
                            }
                            c76661.L$0 = anonymousClass16;
                            c76661.L$1 = chatAnswerData2;
                            c76661.label = 2;
                            if (flowCollector.emit(chatAnswerData2, c76661) == obj) {
                                return obj;
                            }
                            anonymousClass1 = anonymousClass16;
                            t16 = chatAnswerData2;
                            anonymousClass1.f214156e.element = t16;
                            return Unit.INSTANCE;
                        case 1:
                            ResultKt.throwOnFailure(obj6);
                            return Unit.INSTANCE;
                        case 2:
                            ChatAnswerData chatAnswerData13 = (ChatAnswerData) c76661.L$1;
                            anonymousClass1 = (AnonymousClass1) c76661.L$0;
                            ResultKt.throwOnFailure(obj6);
                            t16 = chatAnswerData13;
                            anonymousClass1.f214156e.element = t16;
                            return Unit.INSTANCE;
                        case 3:
                            float f47 = c76661.F$0;
                            interval = c76661.J$0;
                            totalCount = c76661.I$2;
                            contentDiff = c76661.I$1;
                            reasonContentDiff = c76661.I$0;
                            chatAnswerData3 = (ChatAnswerData) c76661.L$3;
                            flowCollector = (FlowCollector) c76661.L$2;
                            chatAnswerData2 = (ChatAnswerData) c76661.L$1;
                            anonymousClass12 = (AnonymousClass1) c76661.L$0;
                            ResultKt.throwOnFailure(obj6);
                            f16 = f47;
                            obj2 = coroutine_suspended;
                            f18 = 0.0f;
                            long j182 = interval;
                            f19 = f16;
                            c766612 = c76661;
                            flowCollector2 = flowCollector;
                            anonymousClass13 = anonymousClass12;
                            i3 = reasonContentDiff;
                            chatAnswerData4 = chatAnswerData3;
                            i16 = contentDiff;
                            j3 = j182;
                            ChatAnswerData chatAnswerData112 = chatAnswerData2;
                            intRef = new Ref.IntRef();
                            chatAnswerData5 = chatAnswerData112;
                            roundToInt = MathKt__MathJVMKt.roundToInt(f18);
                            if (roundToInt >= totalCount) {
                            }
                            break;
                        case 4:
                            int i38 = c76661.I$3;
                            f26 = c76661.F$1;
                            f27 = c76661.F$0;
                            j3 = c76661.J$0;
                            i17 = c76661.I$2;
                            i16 = c76661.I$1;
                            i3 = c76661.I$0;
                            intRef = (Ref.IntRef) c76661.L$4;
                            chatAnswerData4 = (ChatAnswerData) c76661.L$3;
                            flowCollector3 = (FlowCollector) c76661.L$2;
                            chatAnswerData6 = (ChatAnswerData) c76661.L$1;
                            AnonymousClass1 anonymousClass17 = (AnonymousClass1) c76661.L$0;
                            ResultKt.throwOnFailure(obj6);
                            anonymousClass14 = anonymousClass17;
                            str3 = "AIChatRepository";
                            i18 = i38;
                            c766612 = c76661;
                            i26 = i16;
                            f28 = f27;
                            intRef2 = intRef;
                            int i362 = i18;
                            anonymousClass15 = anonymousClass14;
                            i27 = i17;
                            chatAnswerData8 = chatAnswerData4;
                            j16 = j3;
                            flowCollector4 = flowCollector3;
                            chatAnswerData7 = chatAnswerData6;
                            i19 = i362;
                            if (i19 <= i3) {
                            }
                            z16 = false;
                            if (!z16) {
                            }
                            int intValue222 = ((Number) triple.component1()).intValue();
                            String str6222 = (String) triple.component2();
                            String str7222 = (String) triple.component3();
                            anonymousClass15.f214158h.element = SystemClock.uptimeMillis();
                            c16 = ChatAnswerData.c(chatAnswerData7, intValue222, str7222, str6222, 0L, 0L, 0L, 56, null);
                            anonymousClass15.f214156e.element = c16;
                            Logger logger3222 = Logger.f235387a;
                            if (!QLog.isDevelopLevel()) {
                            }
                            c766612.L$0 = anonymousClass15;
                            c766612.L$1 = chatAnswerData7;
                            c766612.L$2 = flowCollector4;
                            c766612.L$3 = chatAnswerData8;
                            c766612.L$4 = intRef2;
                            c766612.I$0 = i3;
                            c766612.I$1 = i26;
                            c766612.I$2 = i27;
                            flowCollector2 = flowCollector4;
                            long j19222 = j17;
                            c766612.J$0 = j19222;
                            float f39222 = f36;
                            c766612.F$0 = f39222;
                            float f46222 = f29;
                            c766612.F$1 = f46222;
                            c766612.label = 5;
                            obj5 = obj4;
                            if (flowCollector2.emit(c16, c766612) != obj5) {
                            }
                            break;
                        case 5:
                            float f48 = c76661.F$1;
                            float f49 = c76661.F$0;
                            long j26 = c76661.J$0;
                            int i39 = c76661.I$2;
                            int i46 = c76661.I$1;
                            int i47 = c76661.I$0;
                            Ref.IntRef intRef3 = (Ref.IntRef) c76661.L$4;
                            ChatAnswerData chatAnswerData14 = (ChatAnswerData) c76661.L$3;
                            FlowCollector flowCollector5 = (FlowCollector) c76661.L$2;
                            ChatAnswerData chatAnswerData15 = (ChatAnswerData) c76661.L$1;
                            AnonymousClass1 anonymousClass18 = (AnonymousClass1) c76661.L$0;
                            ResultKt.throwOnFailure(obj6);
                            c766612 = c76661;
                            anonymousClass13 = anonymousClass18;
                            chatAnswerData10 = chatAnswerData14;
                            totalCount = i39;
                            obj2 = coroutine_suspended;
                            str4 = "AIChatRepository";
                            chatAnswerData9 = chatAnswerData15;
                            f18 = f48;
                            i3 = i47;
                            intRef = intRef3;
                            flowCollector2 = flowCollector5;
                            f19 = f49;
                            j3 = j26;
                            i16 = i46;
                            str5 = str4;
                            chatAnswerData4 = chatAnswerData10;
                            chatAnswerData5 = chatAnswerData9;
                            roundToInt = MathKt__MathJVMKt.roundToInt(f18);
                            if (roundToInt >= totalCount) {
                            }
                            break;
                        case 6:
                            ChatAnswerData chatAnswerData16 = (ChatAnswerData) c76661.L$1;
                            anonymousClass13 = (AnonymousClass1) c76661.L$0;
                            ResultKt.throwOnFailure(obj6);
                            t17 = chatAnswerData16;
                            anonymousClass13.f214156e.element = t17;
                            return Unit.INSTANCE;
                        default:
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                }
            }
            c76661 = new C76661(continuation);
            Object obj62 = c76661.result;
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            String str52 = "AIChatRepository";
            switch (c76661.label) {
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AdaptiveContentEmitKt$adaptiveContentEmit$$inlined$transform$1(Flow flow, Continuation continuation, Ref.ObjectRef objectRef, d dVar, Ref.LongRef longRef) {
        super(2, continuation);
        this.$this_transform = flow;
        this.$prevAnswerData$inlined = objectRef;
        this.$speedState$inlined = dVar;
        this.$emitTimestamp$inlined = longRef;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        AdaptiveContentEmitKt$adaptiveContentEmit$$inlined$transform$1 adaptiveContentEmitKt$adaptiveContentEmit$$inlined$transform$1 = new AdaptiveContentEmitKt$adaptiveContentEmit$$inlined$transform$1(this.$this_transform, continuation, this.$prevAnswerData$inlined, this.$speedState$inlined, this.$emitTimestamp$inlined);
        adaptiveContentEmitKt$adaptiveContentEmit$$inlined$transform$1.L$0 = obj;
        return adaptiveContentEmitKt$adaptiveContentEmit$$inlined$transform$1;
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
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(flowCollector, this.$prevAnswerData$inlined, this.$speedState$inlined, this.$emitTimestamp$inlined);
            this.label = 1;
            if (flow.collect(anonymousClass1, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull FlowCollector<? super ChatAnswerData> flowCollector, @Nullable Continuation<? super Unit> continuation) {
        return ((AdaptiveContentEmitKt$adaptiveContentEmit$$inlined$transform$1) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
