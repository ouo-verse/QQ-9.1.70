package com.tencent.mobileqq.zplan.aigc;

import android.view.View;
import com.tencent.mobileqq.zootopia.portal.aigc.preview.AigcPreviewBusinessScene;
import com.tencent.mobileqq.zplan.aigc.SuitPreviewFragment;
import com.tencent.mobileqq.zplan.aigc.p011const.ZPlanAIGCStatusCode;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.avatar.filament.FilamentTouchHelper;
import com.tencent.sqshow.zootopia.avatar.filament.anim.PortalAnimHelper;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.TimeoutKt;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.zplan.aigc.SuitPreviewFragment$initLoading$1", f = "SuitPreviewFragment.kt", i = {}, l = {872}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes35.dex */
public final class SuitPreviewFragment$initLoading$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ SuitPreviewFragment.b $listener;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ SuitPreviewFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    @DebugMetadata(c = "com.tencent.mobileqq.zplan.aigc.SuitPreviewFragment$initLoading$1$1", f = "SuitPreviewFragment.kt", i = {}, l = {864}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.tencent.mobileqq.zplan.aigc.SuitPreviewFragment$initLoading$1$1, reason: invalid class name */
    /* loaded from: classes35.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Job $firstFrameJob;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(Job job, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$firstFrameJob = job;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$firstFrameJob, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended;
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i3 = this.label;
            try {
                if (i3 == 0) {
                    ResultKt.throwOnFailure(obj);
                    SuitPreviewFragment$initLoading$1$1$succeeded$1 suitPreviewFragment$initLoading$1$1$succeeded$1 = new SuitPreviewFragment$initLoading$1$1$succeeded$1(this.$firstFrameJob, null);
                    this.label = 1;
                    obj = TimeoutKt.withTimeoutOrNull(60000L, suitPreviewFragment$initLoading$1$1$succeeded$1, this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else if (i3 == 1) {
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                Boolean bool = (Boolean) obj;
                if (bool != null) {
                    bool.booleanValue();
                }
            } catch (CancellationException unused) {
            }
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    @DebugMetadata(c = "com.tencent.mobileqq.zplan.aigc.SuitPreviewFragment$initLoading$1$2", f = "SuitPreviewFragment.kt", i = {}, l = {873}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.tencent.mobileqq.zplan.aigc.SuitPreviewFragment$initLoading$1$2, reason: invalid class name */
    /* loaded from: classes35.dex */
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Job $firstFrameJob;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(Job job, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$firstFrameJob = job;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass2(this.$firstFrameJob, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended;
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i3 = this.label;
            if (i3 == 0) {
                ResultKt.throwOnFailure(obj);
                Job job = this.$firstFrameJob;
                this.label = 1;
                if (job.join(this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (i3 == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SuitPreviewFragment$initLoading$1(SuitPreviewFragment.b bVar, SuitPreviewFragment suitPreviewFragment, Continuation<? super SuitPreviewFragment$initLoading$1> continuation) {
        super(2, continuation);
        this.$listener = bVar;
        this.this$0 = suitPreviewFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        SuitPreviewFragment$initLoading$1 suitPreviewFragment$initLoading$1 = new SuitPreviewFragment$initLoading$1(this.$listener, this.this$0, continuation);
        suitPreviewFragment$initLoading$1.L$0 = obj;
        return suitPreviewFragment$initLoading$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        Job launch$default;
        FilamentTouchHelper touchHelper;
        View view;
        View view2;
        PortalAnimHelper animHelper;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            launch$default = BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new SuitPreviewFragment$initLoading$1$firstFrameJob$1(this.$listener, null), 3, null);
            BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new AnonymousClass1(launch$default, null), 3, null);
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(launch$default, null);
            this.label = 1;
            if (TimeoutKt.withTimeoutOrNull(5000L, anonymousClass2, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i3 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        if (this.$listener.getDone()) {
            AigcPreviewBusinessScene aigcPreviewBusinessScene = this.this$0.scene;
            if (aigcPreviewBusinessScene != null && (animHelper = aigcPreviewBusinessScene.getAnimHelper()) != null) {
                animHelper.n1();
            }
            AigcPreviewBusinessScene aigcPreviewBusinessScene2 = this.this$0.scene;
            if (aigcPreviewBusinessScene2 != null && (touchHelper = aigcPreviewBusinessScene2.getTouchHelper()) != null) {
                view = this.this$0.textureView;
                Intrinsics.checkNotNull(view);
                int width = view.getWidth();
                view2 = this.this$0.textureView;
                Intrinsics.checkNotNull(view2);
                touchHelper.k(width, view2.getHeight());
            }
            QLog.i("SuitPreviewFragment", 1, "initLoading end");
            return Unit.INSTANCE;
        }
        QLog.e("SuitPreviewFragment", 1, "init filament failed");
        this.this$0.Uj(ZPlanAIGCStatusCode.NORMAL_ERROR.getMessage());
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((SuitPreviewFragment$initLoading$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
