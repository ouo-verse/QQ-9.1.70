package com.tencent.ecommerce.biz.comment;

import com.tencent.ecommerce.base.uploader.ECBaseUploader;
import com.tencent.ecommerce.base.uploader.IECUploaderFactory;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u008a@\u00a2\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "Lcom/tencent/ecommerce/base/uploader/ECBaseUploader;", "filePath", "", "scene", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 1})
@DebugMetadata(c = "com.tencent.ecommerce.biz.comment.BatchUploaderKt$DefaultUploadFactory$1", f = "BatchUploader.kt", i = {}, l = {361}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes31.dex */
final class BatchUploaderKt$DefaultUploadFactory$1 extends SuspendLambda implements Function3<String, String, Continuation<? super ECBaseUploader>, Object> {
    private /* synthetic */ Object L$0;
    private /* synthetic */ Object L$1;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@\u00a2\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "Lcom/tencent/ecommerce/base/uploader/ECBaseUploader;", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 1})
    @DebugMetadata(c = "com.tencent.ecommerce.biz.comment.BatchUploaderKt$DefaultUploadFactory$1$1", f = "BatchUploader.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.tencent.ecommerce.biz.comment.BatchUploaderKt$DefaultUploadFactory$1$1, reason: invalid class name */
    /* loaded from: classes31.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ECBaseUploader>, Object> {
        final /* synthetic */ String $filePath;
        final /* synthetic */ String $scene;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(String str, String str2, Continuation continuation) {
            super(2, continuation);
            this.$filePath = str;
            this.$scene = str2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$filePath, this.$scene, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super ECBaseUploader> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                return ECBaseUploader.INSTANCE.a(this.$filePath, IECUploaderFactory.UploaderType.IMAGE, this.$scene);
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public final Continuation<Unit> create(String str, String str2, Continuation<? super ECBaseUploader> continuation) {
        BatchUploaderKt$DefaultUploadFactory$1 batchUploaderKt$DefaultUploadFactory$1 = new BatchUploaderKt$DefaultUploadFactory$1(continuation);
        batchUploaderKt$DefaultUploadFactory$1.L$0 = str;
        batchUploaderKt$DefaultUploadFactory$1.L$1 = str2;
        return batchUploaderKt$DefaultUploadFactory$1;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(String str, String str2, Continuation<? super ECBaseUploader> continuation) {
        return ((BatchUploaderKt$DefaultUploadFactory$1) create(str, str2, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            String str = (String) this.L$0;
            String str2 = (String) this.L$1;
            MainCoroutineDispatcher main = Dispatchers.getMain();
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(str, str2, null);
            this.L$0 = null;
            this.label = 1;
            obj = BuildersKt.withContext(main, anonymousClass1, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i3 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return obj;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public BatchUploaderKt$DefaultUploadFactory$1(Continuation continuation) {
        super(3, continuation);
    }
}
