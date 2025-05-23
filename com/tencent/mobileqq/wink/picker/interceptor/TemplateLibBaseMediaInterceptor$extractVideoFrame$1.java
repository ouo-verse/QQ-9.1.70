package com.tencent.mobileqq.wink.picker.interceptor;

import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.wink.editor.extractor.ExtractCoverHelper;
import com.tencent.mobileqq.wink.editor.model.template.TemplatePreProcessConfig;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.wink.picker.interceptor.TemplateLibBaseMediaInterceptor$extractVideoFrame$1", f = "TemplateLibBaseMediaInterceptor.kt", i = {}, l = {271}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes21.dex */
public final class TemplateLibBaseMediaInterceptor$extractVideoFrame$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ CountDownLatch $extractLatch;
    final /* synthetic */ List<Long> $extractTimestamps;
    final /* synthetic */ LocalMediaInfo $localMediaInfo;
    final /* synthetic */ TemplatePreProcessConfig.Media $mediaConfig;
    int label;
    final /* synthetic */ TemplateLibBaseMediaInterceptor this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TemplateLibBaseMediaInterceptor$extractVideoFrame$1(LocalMediaInfo localMediaInfo, List<Long> list, TemplatePreProcessConfig.Media media, CountDownLatch countDownLatch, TemplateLibBaseMediaInterceptor templateLibBaseMediaInterceptor, Continuation<? super TemplateLibBaseMediaInterceptor$extractVideoFrame$1> continuation) {
        super(2, continuation);
        this.$localMediaInfo = localMediaInfo;
        this.$extractTimestamps = list;
        this.$mediaConfig = media;
        this.$extractLatch = countDownLatch;
        this.this$0 = templateLibBaseMediaInterceptor;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new TemplateLibBaseMediaInterceptor$extractVideoFrame$1(this.$localMediaInfo, this.$extractTimestamps, this.$mediaConfig, this.$extractLatch, this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        String str;
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
            ExtractCoverHelper extractCoverHelper = ExtractCoverHelper.f320276a;
            LocalMediaInfo localMediaInfo = this.$localMediaInfo;
            List<Long> list = this.$extractTimestamps;
            int maxSize = this.$mediaConfig.getMaxSize();
            str = TemplateLibBaseMediaInterceptor.L;
            this.label = 1;
            obj = extractCoverHelper.E(localMediaInfo, list, maxSize, str, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        TemplateLibBaseMediaInterceptor templateLibBaseMediaInterceptor = this.this$0;
        TemplatePreProcessConfig.Media media = this.$mediaConfig;
        int i16 = 0;
        for (Object obj2 : (Iterable) obj) {
            int i17 = i16 + 1;
            if (i16 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            templateLibBaseMediaInterceptor.m().put(Boxing.boxInt(media.getPreprocess().get(i16).getIndex()), (String) obj2);
            i16 = i17;
        }
        this.$extractLatch.countDown();
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((TemplateLibBaseMediaInterceptor$extractVideoFrame$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
