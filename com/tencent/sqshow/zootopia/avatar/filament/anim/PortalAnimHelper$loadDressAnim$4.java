package com.tencent.sqshow.zootopia.avatar.filament.anim;

import com.tencent.filament.zplan.animation.ZPlanAction;
import com.tencent.filament.zplan.engine.FilamentViewerV2;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.avatar.filament.i;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Job;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.sqshow.zootopia.avatar.filament.anim.PortalAnimHelper$loadDressAnim$4", f = "PortalAnimHelper.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes34.dex */
public final class PortalAnimHelper$loadDressAnim$4 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ZPlanAction $animAction;
    final /* synthetic */ boolean $isLoop;
    final /* synthetic */ FilamentViewerV2 $viewer;
    int label;
    final /* synthetic */ PortalAnimHelper this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PortalAnimHelper$loadDressAnim$4(PortalAnimHelper portalAnimHelper, ZPlanAction zPlanAction, FilamentViewerV2 filamentViewerV2, boolean z16, Continuation<? super PortalAnimHelper$loadDressAnim$4> continuation) {
        super(2, continuation);
        this.this$0 = portalAnimHelper;
        this.$animAction = zPlanAction;
        this.$viewer = filamentViewerV2;
        this.$isLoop = z16;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PortalAnimHelper$loadDressAnim$4(this.this$0, this.$animAction, this.$viewer, this.$isLoop, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Deferred deferred;
        ZPlanAction zPlanAction;
        boolean z16;
        ZPlanAction zPlanAction2;
        ZPlanAction zPlanAction3;
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            deferred = this.this$0.mDressAnimResJob;
            if (deferred != null) {
                Job.DefaultImpls.cancel$default((Job) deferred, (CancellationException) null, 1, (Object) null);
            }
            zPlanAction = this.this$0.mDressAnimAction;
            if (Intrinsics.areEqual(zPlanAction != null ? zPlanAction.getBodyAnimationGltfPath() : null, this.$animAction.getBodyAnimationGltfPath())) {
                zPlanAction3 = this.this$0.mDressAnimAction;
                if (Intrinsics.areEqual(zPlanAction3 != null ? zPlanAction3.getFaceAnimationGltfPath() : null, this.$animAction.getFaceAnimationGltfPath())) {
                    z16 = true;
                    zPlanAction2 = this.$animAction;
                    if (zPlanAction2 == null && !z16) {
                        this.this$0.mDressAnimAction = zPlanAction2;
                        i mTaskExecutor = this.this$0.getMTaskExecutor();
                        if (mTaskExecutor == null) {
                            return null;
                        }
                        final PortalAnimHelper portalAnimHelper = this.this$0;
                        final FilamentViewerV2 filamentViewerV2 = this.$viewer;
                        final ZPlanAction zPlanAction4 = this.$animAction;
                        final boolean z17 = this.$isLoop;
                        mTaskExecutor.runOnViewerThread("trackGroupWithAnimations", new Function0<Unit>() { // from class: com.tencent.sqshow.zootopia.avatar.filament.anim.PortalAnimHelper$loadDressAnim$4.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public /* bridge */ /* synthetic */ Unit invoke() {
                                invoke2();
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2() {
                                PortalAnimHelper.this.mDressAnim = PortalAnimHelper.r1(PortalAnimHelper.this, filamentViewerV2, new ZPlanAction[]{zPlanAction4}, null, 4, null);
                                if (!z17) {
                                    PortalAnimHelper.this.X0(filamentViewerV2);
                                } else {
                                    PortalAnimHelper.this.Y0(filamentViewerV2);
                                }
                            }
                        });
                        return Unit.INSTANCE;
                    }
                    QLog.i("PortalAnimHelper_", 1, "loadDressAnim isSame:" + z16 + ", animAction:" + zPlanAction2);
                    return Unit.INSTANCE;
                }
            }
            z16 = false;
            zPlanAction2 = this.$animAction;
            if (zPlanAction2 == null) {
            }
            QLog.i("PortalAnimHelper_", 1, "loadDressAnim isSame:" + z16 + ", animAction:" + zPlanAction2);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((PortalAnimHelper$loadDressAnim$4) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
