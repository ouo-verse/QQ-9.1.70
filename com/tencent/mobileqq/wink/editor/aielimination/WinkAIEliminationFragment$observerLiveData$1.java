package com.tencent.mobileqq.wink.editor.aielimination;

import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import java.util.LinkedHashMap;
import kotlin.Metadata;
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
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.StateFlow;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.wink.editor.aielimination.WinkAIEliminationFragment$observerLiveData$1", f = "WinkAIEliminationFragment.kt", i = {}, l = {1159}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes21.dex */
public final class WinkAIEliminationFragment$observerLiveData$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ WinkAIEliminationFragment this$0;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001b\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00028\u0000H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0004\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0006\u00b8\u0006\u0000"}, d2 = {"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/FlowCollector;", "value", "", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class a implements FlowCollector<com.tencent.mobileqq.wink.editor.aielimination.model.c> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ WinkAIEliminationFragment f318773d;

        public a(WinkAIEliminationFragment winkAIEliminationFragment) {
            this.f318773d = winkAIEliminationFragment;
        }

        @Override // kotlinx.coroutines.flow.FlowCollector
        @Nullable
        public Object emit(com.tencent.mobileqq.wink.editor.aielimination.model.c cVar, @NotNull Continuation<? super Unit> continuation) {
            TextView textView;
            ImageView imageView;
            ImageView imageView2;
            com.tencent.mobileqq.wink.editor.aielimination.model.c cVar2 = cVar;
            if (cVar2 != null) {
                this.f318773d.qi(cVar2);
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                linkedHashMap.put(WinkDaTongReportConstant.ElementParamKey.FUNCTION_STATE, Boxing.boxInt(this.f318773d.hi().H2()));
                WinkAIEliminationFragment winkAIEliminationFragment = this.f318773d;
                textView = winkAIEliminationFragment.payGuideYellowText;
                ImageView imageView3 = null;
                if (textView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("payGuideYellowText");
                    textView = null;
                }
                winkAIEliminationFragment.di(textView, WinkDaTongReportConstant.ElementId.EM_QZ_OPEN_YELLOW_DIAMOND, linkedHashMap);
                WinkAIEliminationFragment winkAIEliminationFragment2 = this.f318773d;
                imageView = winkAIEliminationFragment2.yellowDiamondIcon;
                if (imageView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("yellowDiamondIcon");
                    imageView = null;
                }
                winkAIEliminationFragment2.di(imageView, WinkDaTongReportConstant.ElementId.EM_QZ_OPEN_YELLOW_DIAMOND, linkedHashMap);
                imageView2 = this.f318773d.yellowDiamondIcon;
                if (imageView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("yellowDiamondIcon");
                } else {
                    imageView3 = imageView2;
                }
                VideoReport.setElementExposePolicy(imageView3, ExposurePolicy.REPORT_NONE);
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WinkAIEliminationFragment$observerLiveData$1(WinkAIEliminationFragment winkAIEliminationFragment, Continuation<? super WinkAIEliminationFragment$observerLiveData$1> continuation) {
        super(2, continuation);
        this.this$0 = winkAIEliminationFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new WinkAIEliminationFragment$observerLiveData$1(this.this$0, continuation);
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
            StateFlow<com.tencent.mobileqq.wink.editor.aielimination.model.c> gi5 = this.this$0.gi();
            a aVar = new a(this.this$0);
            this.label = 1;
            if (gi5.collect(aVar, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((WinkAIEliminationFragment$observerLiveData$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
