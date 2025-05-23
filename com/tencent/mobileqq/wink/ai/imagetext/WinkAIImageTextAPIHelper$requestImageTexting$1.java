package com.tencent.mobileqq.wink.ai.imagetext;

import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.tencent.mobileqq.wink.ai.imagetext.model.WinkAiImageTextConfig;
import com.tencent.mobileqq.wink.api.e;
import cooperation.qzone.video.QzoneVideoBeaconReport;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.TimeoutCancellationException;
import kotlinx.coroutines.TimeoutKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import qshadow.QZoneAutoTexting$TextInfo;
import w53.b;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.wink.ai.imagetext.WinkAIImageTextAPIHelper$requestImageTexting$1", f = "WinkAIImageTextAPIHelper.kt", i = {}, l = {96}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes21.dex */
public final class WinkAIImageTextAPIHelper$requestImageTexting$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ e $callback;
    final /* synthetic */ Ref.ObjectRef<List<QZoneAutoTexting$TextInfo>> $finishedTextInfos;
    final /* synthetic */ String $imagePath;
    final /* synthetic */ String $originText;
    final /* synthetic */ Ref.ObjectRef<Map<String, String>> $reportParams;
    Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "Lqshadow/QZoneAutoTexting$TextInfo;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    @DebugMetadata(c = "com.tencent.mobileqq.wink.ai.imagetext.WinkAIImageTextAPIHelper$requestImageTexting$1$1", f = "WinkAIImageTextAPIHelper.kt", i = {}, l = {97}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.tencent.mobileqq.wink.ai.imagetext.WinkAIImageTextAPIHelper$requestImageTexting$1$1, reason: invalid class name */
    /* loaded from: classes21.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends QZoneAutoTexting$TextInfo>>, Object> {
        final /* synthetic */ e $callback;
        final /* synthetic */ String $imagePath;
        final /* synthetic */ String $originText;
        final /* synthetic */ Ref.ObjectRef<Map<String, String>> $reportParams;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(String str, String str2, e eVar, Ref.ObjectRef<Map<String, String>> objectRef, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$imagePath = str;
            this.$originText = str2;
            this.$callback = eVar;
            this.$reportParams = objectRef;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new AnonymousClass1(this.$imagePath, this.$originText, this.$callback, this.$reportParams, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super List<? extends QZoneAutoTexting$TextInfo>> continuation) {
            return invoke2(coroutineScope, (Continuation<? super List<QZoneAutoTexting$TextInfo>>) continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended;
            WinkAiImageTextConfig winkAiImageTextConfig;
            WinkAiImageTextConfig winkAiImageTextConfig2;
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
                WinkAIImageTextAPIHelper winkAIImageTextAPIHelper = WinkAIImageTextAPIHelper.f317663a;
                String str = this.$imagePath;
                String str2 = this.$originText;
                winkAiImageTextConfig = WinkAIImageTextAPIHelper.imageTextConfig;
                boolean isStream = winkAiImageTextConfig.isStream();
                winkAiImageTextConfig2 = WinkAIImageTextAPIHelper.imageTextConfig;
                boolean useImageCache = winkAiImageTextConfig2.getUseImageCache();
                e eVar = this.$callback;
                Map<String, String> map = this.$reportParams.element;
                this.label = 1;
                obj = winkAIImageTextAPIHelper.h(str, str2, isStream, useImageCache, eVar, map, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            return obj;
        }

        @Nullable
        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super List<QZoneAutoTexting$TextInfo>> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WinkAIImageTextAPIHelper$requestImageTexting$1(Ref.ObjectRef<Map<String, String>> objectRef, Ref.ObjectRef<List<QZoneAutoTexting$TextInfo>> objectRef2, e eVar, String str, String str2, Continuation<? super WinkAIImageTextAPIHelper$requestImageTexting$1> continuation) {
        super(2, continuation);
        this.$reportParams = objectRef;
        this.$finishedTextInfos = objectRef2;
        this.$callback = eVar;
        this.$imagePath = str;
        this.$originText = str2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new WinkAIImageTextAPIHelper$requestImageTexting$1(this.$reportParams, this.$finishedTextInfos, this.$callback, this.$imagePath, this.$originText, continuation);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        boolean z16;
        boolean z17;
        WinkAiImageTextConfig winkAiImageTextConfig;
        String str;
        WinkAiImageTextConfig winkAiImageTextConfig2;
        WinkAiImageTextConfig winkAiImageTextConfig3;
        WinkAiImageTextConfig winkAiImageTextConfig4;
        WinkAiImageTextConfig winkAiImageTextConfig5;
        Ref.ObjectRef<List<QZoneAutoTexting$TextInfo>> objectRef;
        T t16;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        try {
            if (i3 != 0) {
                if (i3 == 1) {
                    objectRef = (Ref.ObjectRef) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    t16 = obj;
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                ResultKt.throwOnFailure(obj);
                z17 = WinkAIImageTextAPIHelper.hasFetchedImageTextConfig;
                if (!z17) {
                    Pair<WinkAiImageTextConfig, Boolean> b16 = WinkAiImageTextConfig.INSTANCE.b();
                    WinkAiImageTextConfig component1 = b16.component1();
                    boolean booleanValue = b16.component2().booleanValue();
                    WinkAIImageTextAPIHelper.imageTextConfig = component1;
                    WinkAIImageTextAPIHelper.hasFetchedImageTextConfig = booleanValue;
                }
                Map<String, String> map = this.$reportParams.element;
                winkAiImageTextConfig = WinkAIImageTextAPIHelper.imageTextConfig;
                String str2 = "1";
                if (winkAiImageTextConfig.isStream()) {
                    str = "1";
                } else {
                    str = "0";
                }
                map.put("useStream", str);
                Map<String, String> map2 = this.$reportParams.element;
                winkAiImageTextConfig2 = WinkAIImageTextAPIHelper.imageTextConfig;
                if (!winkAiImageTextConfig2.getConcurrent()) {
                    str2 = "0";
                }
                map2.put("concurrent", str2);
                winkAiImageTextConfig3 = WinkAIImageTextAPIHelper.imageTextConfig;
                b.a("WinkAIImageTextAPIHelper", "imageTextConfig " + winkAiImageTextConfig3);
                winkAiImageTextConfig4 = WinkAIImageTextAPIHelper.imageTextConfig;
                WinkAIImageTextAPIHelper.imageTextConfig = winkAiImageTextConfig4;
                Ref.ObjectRef<List<QZoneAutoTexting$TextInfo>> objectRef2 = this.$finishedTextInfos;
                winkAiImageTextConfig5 = WinkAIImageTextAPIHelper.imageTextConfig;
                long timeOutMs = winkAiImageTextConfig5.getTimeOutMs();
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$imagePath, this.$originText, this.$callback, this.$reportParams, null);
                this.L$0 = objectRef2;
                this.label = 1;
                Object withTimeout = TimeoutKt.withTimeout(timeOutMs, anonymousClass1, this);
                if (withTimeout == coroutine_suspended) {
                    return coroutine_suspended;
                }
                objectRef = objectRef2;
                t16 = withTimeout;
            }
            objectRef.element = t16;
        } catch (TimeoutCancellationException e16) {
            this.$reportParams.element.put(HiAnalyticsConstant.HaKey.BI_KEY_RESULT, QzoneVideoBeaconReport.RESULTCODE_VIDEO_TRIIMRECORD_DOWNLOADERROR);
            b.d("WinkAIImageTextAPIHelper", "getImageTextInfosFromApi timeout", e16);
        }
        b.f("WinkAIImageTextAPIHelper", "report performance " + this.$reportParams.element);
        a.f317671a.b(this.$reportParams.element);
        e eVar = this.$callback;
        List<QZoneAutoTexting$TextInfo> list = this.$finishedTextInfos.element;
        if (list != null && !list.isEmpty()) {
            z16 = false;
        } else {
            z16 = true;
        }
        boolean z18 = !z16;
        List<QZoneAutoTexting$TextInfo> list2 = this.$finishedTextInfos.element;
        if (list2 == null) {
            list2 = CollectionsKt__CollectionsKt.emptyList();
        }
        eVar.b(z18, 0L, null, list2);
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((WinkAIImageTextAPIHelper$requestImageTexting$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
