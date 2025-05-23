package com.tencent.aelight.camera.ae.download;

import com.tencent.aelight.camera.download.AEResManagerConfigBean;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lcom/tencent/aelight/camera/download/AEResManagerConfigBean;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.aelight.camera.ae.download.AENewResUtilKt$doSetup$1$config$1", f = "AENewResUtil.kt", i = {}, l = {74}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes32.dex */
final class AENewResUtilKt$doSetup$1$config$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super AEResManagerConfigBean>, Object> {
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lcom/tencent/aelight/camera/download/AEResManagerConfigBean;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    @DebugMetadata(c = "com.tencent.aelight.camera.ae.download.AENewResUtilKt$doSetup$1$config$1$1", f = "AENewResUtil.kt", i = {}, l = {104}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.tencent.aelight.camera.ae.download.AENewResUtilKt$doSetup$1$config$1$1, reason: invalid class name */
    /* loaded from: classes32.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super AEResManagerConfigBean>, Object> {
        int label;

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended;
            Continuation intercepted;
            Object coroutine_suspended2;
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i3 = this.label;
            if (i3 == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(this);
                final CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(intercepted, 1);
                cancellableContinuationImpl.initCancellability();
                AEResNewManagerConfigParser.INSTANCE.c(new py2.a<AEResManagerConfigBean>() { // from class: com.tencent.aelight.camera.ae.download.AENewResUtilKt$doSetup$1$config$1$1$1$1
                    @Override // py2.a
                    /* renamed from: b, reason: merged with bridge method [inline-methods] */
                    public void a(AEResManagerConfigBean config) {
                        ms.a.f("AEResUtil", "loadConfig callback, config " + config);
                        if (config == null) {
                            cancellableContinuationImpl.resume(new AEResManagerConfigBean(), new Function1<Throwable, Unit>() { // from class: com.tencent.aelight.camera.ae.download.AENewResUtilKt$doSetup$1$config$1$1$1$1$onLoad$1
                                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(Throwable it) {
                                    Intrinsics.checkNotNullParameter(it, "it");
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(Throwable th5) {
                                    invoke2(th5);
                                    return Unit.INSTANCE;
                                }
                            });
                        } else {
                            cancellableContinuationImpl.resume(config, new Function1<Throwable, Unit>() { // from class: com.tencent.aelight.camera.ae.download.AENewResUtilKt$doSetup$1$config$1$1$1$1$onLoad$2
                                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(Throwable it) {
                                    Intrinsics.checkNotNullParameter(it, "it");
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(Throwable th5) {
                                    invoke2(th5);
                                    return Unit.INSTANCE;
                                }
                            });
                        }
                    }
                });
                cancellableContinuationImpl.invokeOnCancellation(new Function1<Throwable, Unit>() { // from class: com.tencent.aelight.camera.ae.download.AENewResUtilKt$doSetup$1$config$1$1$1$2
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Throwable th5) {
                        invoke2(th5);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Throwable th5) {
                        ms.a.c("AEResUtil", "loadConfig coroutine cancelled");
                    }
                });
                obj = cancellableContinuationImpl.getResult();
                coroutine_suspended2 = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (obj == coroutine_suspended2) {
                    DebugProbes.probeCoroutineSuspended(this);
                }
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

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super AEResManagerConfigBean> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AENewResUtilKt$doSetup$1$config$1(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineDispatcher io5 = Dispatchers.getIO();
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(null);
            this.label = 1;
            obj = BuildersKt.withContext(io5, anonymousClass1, this);
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
    public AENewResUtilKt$doSetup$1$config$1(Continuation<? super AENewResUtilKt$doSetup$1$config$1> continuation) {
        super(2, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super AEResManagerConfigBean> continuation) {
        return ((AENewResUtilKt$doSetup$1$config$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
