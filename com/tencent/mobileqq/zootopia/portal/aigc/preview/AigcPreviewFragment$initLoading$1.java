package com.tencent.mobileqq.zootopia.portal.aigc.preview;

import android.view.View;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.zootopia.portal.aigc.preview.AigcPreviewFragment;
import com.tencent.mobileqq.zootopia.portal.aigc.preview.AigcPreviewFragment$initLoading$1;
import com.tencent.sqshow.zootopia.avatar.filament.FilamentTouchHelper;
import java.util.Map;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
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
import t74.r;
import wc3.ExtraReportParams;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.zootopia.portal.aigc.preview.AigcPreviewFragment$initLoading$1", f = "AigcPreviewFragment.kt", i = {}, l = {204}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes35.dex */
public final class AigcPreviewFragment$initLoading$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ AigcPreviewFragment.b $listener;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ AigcPreviewFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    @DebugMetadata(c = "com.tencent.mobileqq.zootopia.portal.aigc.preview.AigcPreviewFragment$initLoading$1$1", f = "AigcPreviewFragment.kt", i = {}, l = {189}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.tencent.mobileqq.zootopia.portal.aigc.preview.AigcPreviewFragment$initLoading$1$1, reason: invalid class name */
    /* loaded from: classes35.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Job $firstFrameJob;
        final /* synthetic */ long $firstFrameStartMillis;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(long j3, Job job, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$firstFrameStartMillis = j3;
            this.$firstFrameJob = job;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$firstFrameStartMillis, this.$firstFrameJob, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended;
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i3 = this.label;
            final boolean z16 = false;
            try {
                if (i3 == 0) {
                    ResultKt.throwOnFailure(obj);
                    AigcPreviewFragment$initLoading$1$1$succeeded$1 aigcPreviewFragment$initLoading$1$1$succeeded$1 = new AigcPreviewFragment$initLoading$1$1$succeeded$1(this.$firstFrameJob, null);
                    this.label = 1;
                    obj = TimeoutKt.withTimeoutOrNull(60000L, aigcPreviewFragment$initLoading$1$1$succeeded$1, this);
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
                    z16 = bool.booleanValue();
                }
            } catch (CancellationException unused) {
            }
            final long currentTimeMillis = System.currentTimeMillis() - this.$firstFrameStartMillis;
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.zootopia.portal.aigc.preview.c
                @Override // java.lang.Runnable
                public final void run() {
                    AigcPreviewFragment$initLoading$1.AnonymousClass1.b(currentTimeMillis, z16);
                }
            }, 128, null, true);
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(long j3, boolean z16) {
            String str;
            Map mapOf;
            Pair[] pairArr = new Pair[2];
            pairArr[0] = TuplesKt.to("duration", String.valueOf(j3));
            if (z16) {
                str = "1";
            } else {
                str = "0";
            }
            pairArr[1] = TuplesKt.to("succeeded", str);
            mapOf = MapsKt__MapsKt.mapOf(pairArr);
            r.e(null, "zplan_aigc_preview_first_frame", mapOf, 1, null);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    @DebugMetadata(c = "com.tencent.mobileqq.zootopia.portal.aigc.preview.AigcPreviewFragment$initLoading$1$2", f = "AigcPreviewFragment.kt", i = {}, l = {205}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.tencent.mobileqq.zootopia.portal.aigc.preview.AigcPreviewFragment$initLoading$1$2, reason: invalid class name */
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
    public AigcPreviewFragment$initLoading$1(AigcPreviewFragment aigcPreviewFragment, AigcPreviewFragment.b bVar, Continuation<? super AigcPreviewFragment$initLoading$1> continuation) {
        super(2, continuation);
        this.this$0 = aigcPreviewFragment;
        this.$listener = bVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        AigcPreviewFragment$initLoading$1 aigcPreviewFragment$initLoading$1 = new AigcPreviewFragment$initLoading$1(this.this$0, this.$listener, continuation);
        aigcPreviewFragment$initLoading$1.L$0 = obj;
        return aigcPreviewFragment$initLoading$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        ExtraReportParams extraReportParams;
        long currentTimeMillis;
        Job launch$default;
        AigcPreviewBusinessScene aigcPreviewBusinessScene;
        AigcPreviewBusinessScene aigcPreviewBusinessScene2;
        View view;
        View view2;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        View view3 = null;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            extraReportParams = this.this$0.extraReportParams;
            if (extraReportParams != null) {
                currentTimeMillis = extraReportParams.getFirstFrameStartMillis();
            } else {
                currentTimeMillis = System.currentTimeMillis();
            }
            launch$default = BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new AigcPreviewFragment$initLoading$1$firstFrameJob$1(this.$listener, null), 3, null);
            BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new AnonymousClass1(currentTimeMillis, launch$default, null), 3, null);
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
        this.this$0.Ph(false);
        aigcPreviewBusinessScene = this.this$0.scene;
        if (aigcPreviewBusinessScene == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scene");
            aigcPreviewBusinessScene = null;
        }
        aigcPreviewBusinessScene.getAnimHelper().n1();
        aigcPreviewBusinessScene2 = this.this$0.scene;
        if (aigcPreviewBusinessScene2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scene");
            aigcPreviewBusinessScene2 = null;
        }
        FilamentTouchHelper touchHelper = aigcPreviewBusinessScene2.getTouchHelper();
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
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((AigcPreviewFragment$initLoading$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
