package com.tencent.mobileqq.qqlive.room.prepare.covercrop;

import android.graphics.Bitmap;
import android.os.Looper;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqlive.data.upload.QQLiveUploadBitmapParams;
import com.tencent.mobileqq.qqlive.data.upload.QQLiveUploadBitmapResult;
import com.tencent.mobileqq.qqlive.room.widget.RegionView;
import com.tencent.qqlive.common.api.AegisLogger;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.qqlive.room.prepare.covercrop.QQLiveCoverCropFragment$onUploadCover$fileJob$1", f = "QQLiveCoverCropFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes17.dex */
public final class QQLiveCoverCropFragment$onUploadCover$fileJob$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ Ref.ObjectRef<d> $uploadBitmapTask;
    int label;
    final /* synthetic */ QQLiveCoverCropFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    @DebugMetadata(c = "com.tencent.mobileqq.qqlive.room.prepare.covercrop.QQLiveCoverCropFragment$onUploadCover$fileJob$1$1", f = "QQLiveCoverCropFragment.kt", i = {}, l = {301}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.tencent.mobileqq.qqlive.room.prepare.covercrop.QQLiveCoverCropFragment$onUploadCover$fileJob$1$1, reason: invalid class name */
    /* loaded from: classes17.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        static IPatchRedirector $redirector_;
        final /* synthetic */ QQLiveUploadBitmapResult $result;
        Object L$0;
        Object L$1;
        int label;
        final /* synthetic */ QQLiveCoverCropFragment this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(QQLiveUploadBitmapResult qQLiveUploadBitmapResult, QQLiveCoverCropFragment qQLiveCoverCropFragment, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$result = qQLiveUploadBitmapResult;
            this.this$0 = qQLiveCoverCropFragment;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, qQLiveUploadBitmapResult, qQLiveCoverCropFragment, continuation);
            }
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (Continuation) iPatchRedirector.redirect((short) 3, (Object) this, obj, (Object) continuation);
            }
            return new AnonymousClass1(this.$result, this.this$0, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended;
            QQLiveUploadBitmapResult qQLiveUploadBitmapResult;
            QQLiveCoverCropFragment qQLiveCoverCropFragment;
            QQLiveCoverCropFragment qQLiveCoverCropFragment2;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i3 = this.label;
                if (i3 != 0) {
                    if (i3 == 1) {
                        qQLiveCoverCropFragment2 = (QQLiveCoverCropFragment) this.L$1;
                        qQLiveUploadBitmapResult = (QQLiveUploadBitmapResult) this.L$0;
                        ResultKt.throwOnFailure(obj);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    qQLiveUploadBitmapResult = this.$result;
                    if (qQLiveUploadBitmapResult != null) {
                        qQLiveCoverCropFragment = this.this$0;
                        AegisLogger.INSTANCE.i("Open_Live|QQLiveCoverCropFragment", "onUploadCover", "retCode:" + qQLiveUploadBitmapResult.retCode + " isSuccess:" + qQLiveUploadBitmapResult.isSuccess + " errorMsg:" + qQLiveUploadBitmapResult.errorMsg);
                        if (qQLiveUploadBitmapResult.isSuccess) {
                            String str = qQLiveUploadBitmapResult.url;
                            Intrinsics.checkNotNullExpressionValue(str, "result.url");
                            qQLiveCoverCropFragment.Uh(str);
                        } else {
                            Thread currentThread = Thread.currentThread();
                            Intrinsics.checkExpressionValueIsNotNull(Looper.getMainLooper(), "Looper.getMainLooper()");
                            if (!Intrinsics.areEqual(currentThread, r4.getThread())) {
                                MainCoroutineDispatcher main = Dispatchers.getMain();
                                QQLiveCoverCropFragment$onUploadCover$fileJob$1$1$invokeSuspend$lambda$1$$inlined$runOnUI$1 qQLiveCoverCropFragment$onUploadCover$fileJob$1$1$invokeSuspend$lambda$1$$inlined$runOnUI$1 = new QQLiveCoverCropFragment$onUploadCover$fileJob$1$1$invokeSuspend$lambda$1$$inlined$runOnUI$1(null, qQLiveCoverCropFragment);
                                this.L$0 = qQLiveUploadBitmapResult;
                                this.L$1 = qQLiveCoverCropFragment;
                                this.label = 1;
                                if (BuildersKt.withContext(main, qQLiveCoverCropFragment$onUploadCover$fileJob$1$1$invokeSuspend$lambda$1$$inlined$runOnUI$1, this) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                qQLiveCoverCropFragment2 = qQLiveCoverCropFragment;
                            } else {
                                com.tencent.mobileqq.qqlive.room.multichat.utils.c.a(qQLiveCoverCropFragment.getContext(), "\u4e0a\u4f20\u5931\u8d25");
                                Unit unit = Unit.INSTANCE;
                                qQLiveCoverCropFragment.Th(qQLiveUploadBitmapResult, false);
                            }
                        }
                    }
                    return Unit.INSTANCE;
                }
                qQLiveCoverCropFragment = qQLiveCoverCropFragment2;
                qQLiveCoverCropFragment.Th(qQLiveUploadBitmapResult, false);
                return Unit.INSTANCE;
            }
            return iPatchRedirector.redirect((short) 2, (Object) this, obj);
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE) : iPatchRedirector.redirect((short) 4, (Object) this, (Object) coroutineScope, (Object) continuation);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QQLiveCoverCropFragment$onUploadCover$fileJob$1(Ref.ObjectRef<d> objectRef, QQLiveCoverCropFragment qQLiveCoverCropFragment, Continuation<? super QQLiveCoverCropFragment$onUploadCover$fileJob$1> continuation) {
        super(2, continuation);
        this.$uploadBitmapTask = objectRef;
        this.this$0 = qQLiveCoverCropFragment;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, objectRef, qQLiveCoverCropFragment, continuation);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Continuation) iPatchRedirector.redirect((short) 3, (Object) this, obj, (Object) continuation);
        }
        return new QQLiveCoverCropFragment$onUploadCover$fileJob$1(this.$uploadBitmapTask, this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        LoadBitmapTask Kh;
        Bitmap bitmap;
        QQLiveUploadBitmapParams Ih;
        CoroutineScope Lh;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                d dVar = this.$uploadBitmapTask.element;
                Kh = this.this$0.Kh();
                RegionView f16 = Kh.f();
                if (f16 != null) {
                    bitmap = f16.a();
                } else {
                    bitmap = null;
                }
                Ih = this.this$0.Ih();
                QQLiveUploadBitmapResult f17 = dVar.f(bitmap, Ih);
                Lh = this.this$0.Lh();
                BuildersKt__Builders_commonKt.launch$default(Lh, null, null, new AnonymousClass1(f17, this.this$0, null), 3, null);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return iPatchRedirector.redirect((short) 2, (Object) this, obj);
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? ((QQLiveCoverCropFragment$onUploadCover$fileJob$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE) : iPatchRedirector.redirect((short) 4, (Object) this, (Object) coroutineScope, (Object) continuation);
    }
}
