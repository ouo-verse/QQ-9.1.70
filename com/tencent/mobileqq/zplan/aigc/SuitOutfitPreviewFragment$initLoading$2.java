package com.tencent.mobileqq.zplan.aigc;

import android.view.View;
import com.tencent.mobileqq.zootopia.portal.aigc.preview.AigcPreviewBusinessScene;
import com.tencent.mobileqq.zplan.aigc.vm.SuitOutfitViewModel;
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
@DebugMetadata(c = "com.tencent.mobileqq.zplan.aigc.SuitOutfitPreviewFragment$initLoading$2", f = "SuitOutfitPreviewFragment.kt", i = {}, l = {495}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes35.dex */
public final class SuitOutfitPreviewFragment$initLoading$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ SuitOutfitPreviewFragment$initLoading$listener$1 $listener;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ SuitOutfitPreviewFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    @DebugMetadata(c = "com.tencent.mobileqq.zplan.aigc.SuitOutfitPreviewFragment$initLoading$2$1", f = "SuitOutfitPreviewFragment.kt", i = {}, l = {487}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.tencent.mobileqq.zplan.aigc.SuitOutfitPreviewFragment$initLoading$2$1, reason: invalid class name */
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
                    SuitOutfitPreviewFragment$initLoading$2$1$succeeded$1 suitOutfitPreviewFragment$initLoading$2$1$succeeded$1 = new SuitOutfitPreviewFragment$initLoading$2$1$succeeded$1(this.$firstFrameJob, null);
                    this.label = 1;
                    obj = TimeoutKt.withTimeoutOrNull(60000L, suitOutfitPreviewFragment$initLoading$2$1$succeeded$1, this);
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
    @DebugMetadata(c = "com.tencent.mobileqq.zplan.aigc.SuitOutfitPreviewFragment$initLoading$2$2", f = "SuitOutfitPreviewFragment.kt", i = {}, l = {com.tencent.luggage.wxa.ig.w.CTRL_INDEX}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.tencent.mobileqq.zplan.aigc.SuitOutfitPreviewFragment$initLoading$2$2, reason: invalid class name */
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
    public SuitOutfitPreviewFragment$initLoading$2(SuitOutfitPreviewFragment suitOutfitPreviewFragment, SuitOutfitPreviewFragment$initLoading$listener$1 suitOutfitPreviewFragment$initLoading$listener$1, Continuation<? super SuitOutfitPreviewFragment$initLoading$2> continuation) {
        super(2, continuation);
        this.this$0 = suitOutfitPreviewFragment;
        this.$listener = suitOutfitPreviewFragment$initLoading$listener$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        SuitOutfitPreviewFragment$initLoading$2 suitOutfitPreviewFragment$initLoading$2 = new SuitOutfitPreviewFragment$initLoading$2(this.this$0, this.$listener, continuation);
        suitOutfitPreviewFragment$initLoading$2.L$0 = obj;
        return suitOutfitPreviewFragment$initLoading$2;
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
        View view3 = null;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            launch$default = BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new SuitOutfitPreviewFragment$initLoading$2$firstFrameJob$1(this.$listener, null), 3, null);
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
        SuitOutfitViewModel suitOutfitViewModel = this.this$0.vm;
        if (suitOutfitViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("vm");
            suitOutfitViewModel = null;
        }
        AigcPreviewBusinessScene scene = suitOutfitViewModel.getScene();
        if (scene != null && (animHelper = scene.getAnimHelper()) != null) {
            animHelper.n1();
        }
        SuitOutfitViewModel suitOutfitViewModel2 = this.this$0.vm;
        if (suitOutfitViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("vm");
            suitOutfitViewModel2 = null;
        }
        AigcPreviewBusinessScene scene2 = suitOutfitViewModel2.getScene();
        if (scene2 != null && (touchHelper = scene2.getTouchHelper()) != null) {
            view = this.this$0.textureView;
            if (view == null) {
                Intrinsics.throwUninitializedPropertyAccessException("textureView");
                view = null;
            }
            int width = view.getWidth();
            view2 = this.this$0.textureView;
            if (view2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("textureView");
            } else {
                view3 = view2;
            }
            touchHelper.k(width, view3.getHeight());
        }
        QLog.i("SuitOutfitPreviewFragment", 1, "initLoading end");
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((SuitOutfitPreviewFragment$initLoading$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
