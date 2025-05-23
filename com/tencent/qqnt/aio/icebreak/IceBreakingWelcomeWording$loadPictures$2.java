package com.tencent.qqnt.aio.icebreak;

import com.tencent.mobileqq.qcoroutine.api.coroutine.CorountineFunKt;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.FilesKt__UtilsKt;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lcom/tencent/mobileqq/qcoroutine/api/coroutine/b;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.qqnt.aio.icebreak.IceBreakingWelcomeWording$loadPictures$2", f = "IceBreakingWelcomeWording.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes34.dex */
final class IceBreakingWelcomeWording$loadPictures$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super com.tencent.mobileqq.qcoroutine.api.coroutine.b>, Object> {
    final /* synthetic */ File $prevPicturesDir;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    @DebugMetadata(c = "com.tencent.qqnt.aio.icebreak.IceBreakingWelcomeWording$loadPictures$2$1", f = "IceBreakingWelcomeWording.kt", i = {}, l = {146}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.tencent.qqnt.aio.icebreak.IceBreakingWelcomeWording$loadPictures$2$1, reason: invalid class name */
    /* loaded from: classes34.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ File $prevPicturesDir;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(File file, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$prevPicturesDir = file;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$prevPicturesDir, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended;
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i3 = this.label;
            if (i3 == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (DelayKt.delay(2000L, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (i3 == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            try {
                FilesKt__UtilsKt.deleteRecursively(this.$prevPicturesDir);
            } catch (IOException e16) {
                QLog.e("IceBreakingWelcomeWording", 1, "reload delay 2s delete " + this.$prevPicturesDir + " failed", e16);
            }
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public IceBreakingWelcomeWording$loadPictures$2(File file, Continuation<? super IceBreakingWelcomeWording$loadPictures$2> continuation) {
        super(2, continuation);
        this.$prevPicturesDir = file;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        IceBreakingWelcomeWording$loadPictures$2 iceBreakingWelcomeWording$loadPictures$2 = new IceBreakingWelcomeWording$loadPictures$2(this.$prevPicturesDir, continuation);
        iceBreakingWelcomeWording$loadPictures$2.L$0 = obj;
        return iceBreakingWelcomeWording$loadPictures$2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            return CorountineFunKt.e((CoroutineScope) this.L$0, "IceBreakingWelcomeWording delay delete prev pictures", null, null, null, new AnonymousClass1(this.$prevPicturesDir, null), 14, null);
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super com.tencent.mobileqq.qcoroutine.api.coroutine.b> continuation) {
        return ((IceBreakingWelcomeWording$loadPictures$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
