package com.tencent.mobileqq.wink.picker.interceptor;

import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.wink.picker.interceptor.DownloadQZoneMediaInterceptor$downloadMedia$1", f = "DownloadQZoneMediaInterceptor.kt", i = {}, l = {86, 87}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes21.dex */
public final class DownloadQZoneMediaInterceptor$downloadMedia$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ List<String> $unDownloadImageUrls;
    final /* synthetic */ List<String> $unDownloadVideoUrls;
    final /* synthetic */ List<LocalMediaInfo> $unDownloadedImages;
    final /* synthetic */ List<LocalMediaInfo> $unDownloadedVideos;
    int label;
    final /* synthetic */ DownloadQZoneMediaInterceptor this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public DownloadQZoneMediaInterceptor$downloadMedia$1(DownloadQZoneMediaInterceptor downloadQZoneMediaInterceptor, List<String> list, List<? extends LocalMediaInfo> list2, List<String> list3, List<? extends LocalMediaInfo> list4, Continuation<? super DownloadQZoneMediaInterceptor$downloadMedia$1> continuation) {
        super(2, continuation);
        this.this$0 = downloadQZoneMediaInterceptor;
        this.$unDownloadVideoUrls = list;
        this.$unDownloadedVideos = list2;
        this.$unDownloadImageUrls = list3;
        this.$unDownloadedImages = list4;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new DownloadQZoneMediaInterceptor$downloadMedia$1(this.this$0, this.$unDownloadVideoUrls, this.$unDownloadedVideos, this.$unDownloadImageUrls, this.$unDownloadedImages, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x004e  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        Object h16;
        Object f16;
        CountDownLatch countDownLatch;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 == 2) {
                    ResultKt.throwOnFailure(obj);
                    countDownLatch = this.this$0.syncLatch;
                    if (countDownLatch != null) {
                        countDownLatch.countDown();
                    }
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        } else {
            ResultKt.throwOnFailure(obj);
            DownloadQZoneMediaInterceptor downloadQZoneMediaInterceptor = this.this$0;
            List<String> list = this.$unDownloadVideoUrls;
            List<LocalMediaInfo> list2 = this.$unDownloadedVideos;
            Intrinsics.checkNotNull(list2);
            this.label = 1;
            h16 = downloadQZoneMediaInterceptor.h(list, list2, this);
            if (h16 == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        DownloadQZoneMediaInterceptor downloadQZoneMediaInterceptor2 = this.this$0;
        List<String> list3 = this.$unDownloadImageUrls;
        List<LocalMediaInfo> list4 = this.$unDownloadedImages;
        Intrinsics.checkNotNull(list4);
        this.label = 2;
        f16 = downloadQZoneMediaInterceptor2.f(list3, list4, this);
        if (f16 == coroutine_suspended) {
            return coroutine_suspended;
        }
        countDownLatch = this.this$0.syncLatch;
        if (countDownLatch != null) {
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((DownloadQZoneMediaInterceptor$downloadMedia$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
