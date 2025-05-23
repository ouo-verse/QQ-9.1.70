package com.tencent.mobileqq.wink.dailysign;

import androidx.lifecycle.MutableLiveData;
import com.tencent.mobileqq.wink.edit.manager.WinkEditorResourceManager;
import com.tencent.mobileqq.wink.preprocess.WinkMaterialResourceLoader;
import com.tencent.mobileqq.winkreport.dengta.WinkDengtaReportConstant;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.SupervisorKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.wink.dailysign.DailySignViewModel$requestAndProcessData$1", f = "DailySignViewModel.kt", i = {}, l = {251}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes21.dex */
public final class DailySignViewModel$requestAndProcessData$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ DailySignViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    @DebugMetadata(c = "com.tencent.mobileqq.wink.dailysign.DailySignViewModel$requestAndProcessData$1$1", f = "DailySignViewModel.kt", i = {}, l = {254}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.tencent.mobileqq.wink.dailysign.DailySignViewModel$requestAndProcessData$1$1, reason: invalid class name */
    /* loaded from: classes21.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ DailySignViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(DailySignViewModel dailySignViewModel, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = dailySignViewModel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new AnonymousClass1(this.this$0, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended;
            int i3;
            DailySignConfig dailySignConfig;
            DailySignConfig dailySignConfig2;
            Object obj2;
            DailySignConfig dailySignConfig3;
            Map mutableMapOf;
            MutableLiveData mutableLiveData;
            DailySignConfig dailySignConfig4;
            DailySignConfig dailySignConfig5;
            DailySignConfig dailySignConfig6;
            DailySignConfig dailySignConfig7;
            MutableLiveData mutableLiveData2;
            DailySignConfig dailySignConfig8;
            al a26;
            DailySignConfig dailySignConfig9;
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i16 = this.label;
            DailySignConfig dailySignConfig10 = null;
            try {
                if (i16 != 0) {
                    if (i16 == 1) {
                        ResultKt.throwOnFailure(obj);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    dailySignConfig4 = this.this$0.dailySignConfig;
                    if (dailySignConfig4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("dailySignConfig");
                        dailySignConfig4 = null;
                    }
                    if (!dailySignConfig4.isInited()) {
                        WinkMaterialResourceLoader winkMaterialResourceLoader = WinkMaterialResourceLoader.f325333a;
                        dailySignConfig5 = this.this$0.dailySignConfig;
                        if (dailySignConfig5 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("dailySignConfig");
                            dailySignConfig5 = null;
                        }
                        this.label = 1;
                        if (winkMaterialResourceLoader.h(dailySignConfig5, this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                }
                DailySignViewModel dailySignViewModel = this.this$0;
                dailySignConfig6 = dailySignViewModel.dailySignConfig;
                if (dailySignConfig6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("dailySignConfig");
                    dailySignConfig6 = null;
                }
                dailySignViewModel.allBackgroundPic = dailySignConfig6.getBackGroundPic();
                DailySignViewModel dailySignViewModel2 = this.this$0;
                dailySignConfig7 = dailySignViewModel2.dailySignConfig;
                if (dailySignConfig7 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("dailySignConfig");
                    dailySignConfig7 = null;
                }
                dailySignViewModel2.backPicPathRandomIndex = dailySignConfig7.getBackGroundPicIndex();
                WinkEditorResourceManager.a1().Q2("music");
                mutableLiveData2 = this.this$0._previewDataPrepared;
                Result.Companion companion = Result.INSTANCE;
                DailySignViewModel dailySignViewModel3 = this.this$0;
                dailySignConfig8 = dailySignViewModel3.dailySignConfig;
                if (dailySignConfig8 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("dailySignConfig");
                    dailySignConfig8 = null;
                }
                a26 = dailySignViewModel3.a2(dailySignConfig8);
                mutableLiveData2.setValue(Result.m475boximpl(Result.m476constructorimpl(a26)));
                String tag = this.this$0.getTAG();
                long currentTimeMillis = System.currentTimeMillis();
                dailySignConfig9 = this.this$0.dailySignConfig;
                if (dailySignConfig9 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("dailySignConfig");
                    dailySignConfig9 = null;
                }
                w53.b.a(tag, "on download finish cost = " + (currentTimeMillis - dailySignConfig9.getStartTime()));
            } catch (Exception e16) {
                w53.b.d(this.this$0.getTAG(), "requestAndProcessData fail", e16);
                DailySignViewModel dailySignViewModel4 = this.this$0;
                Pair[] pairArr = new Pair[7];
                if (e16 instanceof ResLoadException) {
                    i3 = ((ResLoadException) e16).getCode();
                } else {
                    i3 = -1;
                }
                pairArr[0] = TuplesKt.to(WinkDengtaReportConstant.Params.AVATAR_SHARE_LOAD_RESULT, String.valueOf(i3));
                dailySignConfig = this.this$0.dailySignConfig;
                if (dailySignConfig == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("dailySignConfig");
                    dailySignConfig = null;
                }
                pairArr[1] = TuplesKt.to(WinkDengtaReportConstant.Params.AVATAR_SHARE_LOAD_ALL_RESOURCE_TIME, String.valueOf(dailySignConfig.getLoadAllResourceTime()));
                pairArr[2] = TuplesKt.to(WinkDengtaReportConstant.Params.AVATAR_SHARE_LOAD_LIGHT_BUNDLE_TIME, "-1");
                pairArr[3] = TuplesKt.to(WinkDengtaReportConstant.Params.AVATAR_SHARE_LOAD_TEMPLATE_TIME, "-1");
                pairArr[4] = TuplesKt.to(WinkDengtaReportConstant.Params.REPORT_PARMA_BACK_PIC_LOAD_TIME, "-1");
                dailySignConfig2 = this.this$0.dailySignConfig;
                if (dailySignConfig2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("dailySignConfig");
                    dailySignConfig2 = null;
                }
                String str = "0";
                if (dailySignConfig2.getNeedDownLoadSo()) {
                    obj2 = "0";
                } else {
                    obj2 = "1";
                }
                pairArr[5] = TuplesKt.to(WinkDengtaReportConstant.Params.REPORT_PARAM_EDITOR_RES_READY, obj2);
                dailySignConfig3 = this.this$0.dailySignConfig;
                if (dailySignConfig3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("dailySignConfig");
                } else {
                    dailySignConfig10 = dailySignConfig3;
                }
                if (!dailySignConfig10.getNeedDownLoadTemplate()) {
                    str = "1";
                }
                pairArr[6] = TuplesKt.to(WinkDengtaReportConstant.Params.REPORT_PARAM_TEMPLATE_RES_READY, str);
                mutableMapOf = MapsKt__MapsKt.mutableMapOf(pairArr);
                dailySignViewModel4.dengTaParams = mutableMapOf;
                mutableLiveData = this.this$0._previewDataPrepared;
                Result.Companion companion2 = Result.INSTANCE;
                mutableLiveData.setValue(Result.m475boximpl(Result.m476constructorimpl(ResultKt.createFailure(e16))));
            }
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DailySignViewModel$requestAndProcessData$1(DailySignViewModel dailySignViewModel, Continuation<? super DailySignViewModel$requestAndProcessData$1> continuation) {
        super(2, continuation);
        this.this$0 = dailySignViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new DailySignViewModel$requestAndProcessData$1(this.this$0, continuation);
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
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, null);
            this.label = 1;
            if (SupervisorKt.supervisorScope(anonymousClass1, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((DailySignViewModel$requestAndProcessData$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
