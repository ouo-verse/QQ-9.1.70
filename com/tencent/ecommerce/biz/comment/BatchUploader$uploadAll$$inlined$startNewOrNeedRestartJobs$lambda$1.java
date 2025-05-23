package com.tencent.ecommerce.biz.comment;

import com.tencent.ecommerce.base.pageopener.api.imageselector.ECMediaInfo;
import com.tencent.ecommerce.base.uploader.ECBaseUploader;
import com.tencent.ecommerce.biz.comment.UploadStateListener;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0005\u001a\u00020\u0001*\u00020\u0000H\u008a@\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lcom/tencent/ecommerce/biz/comment/UploadStateListener$a$f;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "com/tencent/ecommerce/biz/comment/BatchUploader$uploadAll$2$1", "<anonymous>"}, k = 3, mv = {1, 4, 1})
@DebugMetadata(c = "com.tencent.ecommerce.biz.comment.BatchUploader$uploadAll$2$1", f = "BatchUploader.kt", i = {}, l = {101, 101}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes31.dex */
public final class BatchUploader$uploadAll$$inlined$startNewOrNeedRestartJobs$lambda$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super UploadStateListener.a.f>, Object> {
    final /* synthetic */ ECMediaInfo $mediaInfo;
    Object L$0;
    int label;
    final /* synthetic */ BatchUploader this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BatchUploader$uploadAll$$inlined$startNewOrNeedRestartJobs$lambda$1(ECMediaInfo eCMediaInfo, Continuation continuation, BatchUploader batchUploader) {
        super(2, continuation);
        this.$mediaInfo = eCMediaInfo;
        this.this$0 = batchUploader;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new BatchUploader$uploadAll$$inlined$startNewOrNeedRestartJobs$lambda$1(this.$mediaInfo, continuation, this.this$0);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super UploadStateListener.a.f> continuation) {
        return ((BatchUploader$uploadAll$$inlined$startNewOrNeedRestartJobs$lambda$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        BatchUploader batchUploader;
        Function3 function3;
        String str;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            batchUploader = this.this$0;
            function3 = batchUploader.uploaderFactory;
            String mediaPath = this.$mediaInfo.getMediaPath();
            str = this.this$0.scene;
            this.L$0 = batchUploader;
            this.label = 1;
            obj = function3.invoke(mediaPath, str, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i3 != 1) {
                if (i3 == 2) {
                    ResultKt.throwOnFailure(obj);
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            batchUploader = (BatchUploader) this.L$0;
            ResultKt.throwOnFailure(obj);
        }
        ECMediaInfo eCMediaInfo = this.$mediaInfo;
        this.L$0 = null;
        this.label = 2;
        obj = batchUploader.l((ECBaseUploader) obj, eCMediaInfo, this);
        return obj == coroutine_suspended ? coroutine_suspended : obj;
    }
}
