package com.tencent.mobileqq.matchfriend.reborn.publish.upload;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lkotlinx/coroutines/Deferred;", "Lcom/tencent/mobileqq/matchfriend/reborn/publish/upload/a;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.matchfriend.reborn.publish.upload.SquareFeedPicUploader$uploadPics$resultList$1$1", f = "SquareFeedPicUploader.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes33.dex */
public final class SquareFeedPicUploader$uploadPics$resultList$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Deferred<? extends PicUploadResult>>, Object> {
    final /* synthetic */ boolean $compress;
    final /* synthetic */ String $path;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lcom/tencent/mobileqq/matchfriend/reborn/publish/upload/a;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    @DebugMetadata(c = "com.tencent.mobileqq.matchfriend.reborn.publish.upload.SquareFeedPicUploader$uploadPics$resultList$1$1$1", f = "SquareFeedPicUploader.kt", i = {}, l = {64}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.tencent.mobileqq.matchfriend.reborn.publish.upload.SquareFeedPicUploader$uploadPics$resultList$1$1$1, reason: invalid class name */
    /* loaded from: classes33.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super PicUploadResult>, Object> {
        final /* synthetic */ boolean $compress;
        final /* synthetic */ String $path;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(String str, boolean z16, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$path = str;
            this.$compress = z16;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$path, this.$compress, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended;
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i3 = this.label;
            if (i3 == 0) {
                ResultKt.throwOnFailure(obj);
                SquareFeedPicUploader squareFeedPicUploader = SquareFeedPicUploader.f245352a;
                String str = this.$path;
                boolean z16 = this.$compress;
                this.label = 1;
                obj = squareFeedPicUploader.k(str, z16, this);
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

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super PicUploadResult> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SquareFeedPicUploader$uploadPics$resultList$1$1(String str, boolean z16, Continuation<? super SquareFeedPicUploader$uploadPics$resultList$1$1> continuation) {
        super(2, continuation);
        this.$path = str;
        this.$compress = z16;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        SquareFeedPicUploader$uploadPics$resultList$1$1 squareFeedPicUploader$uploadPics$resultList$1$1 = new SquareFeedPicUploader$uploadPics$resultList$1$1(this.$path, this.$compress, continuation);
        squareFeedPicUploader$uploadPics$resultList$1$1.L$0 = obj;
        return squareFeedPicUploader$uploadPics$resultList$1$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super Deferred<? extends PicUploadResult>> continuation) {
        return invoke2(coroutineScope, (Continuation<? super Deferred<PicUploadResult>>) continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Deferred async$default;
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            async$default = BuildersKt__Builders_commonKt.async$default((CoroutineScope) this.L$0, null, null, new AnonymousClass1(this.$path, this.$compress, null), 3, null);
            return async$default;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope coroutineScope, Continuation<? super Deferred<PicUploadResult>> continuation) {
        return ((SquareFeedPicUploader$uploadPics$resultList$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
