package com.tencent.sqshow.zootopia.avatar.filament.anim;

import com.tencent.filament.zplan.animation.ZPlanAction;
import com.tencent.filament.zplan.avatar.model.EnumUserGender;
import com.tencent.filament.zplan.engine.FilamentViewerV2;
import com.tencent.filament.zplanservice.feature.model.FilamentUrlTemplate;
import com.tencent.mobileqq.zootopia.api.UEAvatarGender;
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
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Job;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.sqshow.zootopia.avatar.filament.anim.PortalAnimHelper$loadDressAnim$2", f = "PortalAnimHelper.kt", i = {}, l = {323}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes34.dex */
public final class PortalAnimHelper$loadDressAnim$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ UEAvatarGender $gender;
    final /* synthetic */ AnimPath $path;
    final /* synthetic */ FilamentViewerV2 $viewer;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ PortalAnimHelper this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lcom/tencent/filament/zplan/animation/ZPlanAction;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    @DebugMetadata(c = "com.tencent.sqshow.zootopia.avatar.filament.anim.PortalAnimHelper$loadDressAnim$2$1", f = "PortalAnimHelper.kt", i = {}, l = {311}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.tencent.sqshow.zootopia.avatar.filament.anim.PortalAnimHelper$loadDressAnim$2$1, reason: invalid class name */
    /* loaded from: classes34.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ZPlanAction>, Object> {
        final /* synthetic */ UEAvatarGender $gender;
        final /* synthetic */ AnimPath $path;
        int label;
        final /* synthetic */ PortalAnimHelper this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(PortalAnimHelper portalAnimHelper, UEAvatarGender uEAvatarGender, AnimPath animPath, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = portalAnimHelper;
            this.$gender = uEAvatarGender;
            this.$path = animPath;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.this$0, this.$gender, this.$path, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended;
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i3 = this.label;
            try {
                if (i3 == 0) {
                    ResultKt.throwOnFailure(obj);
                    PortalAnimHelper portalAnimHelper = this.this$0;
                    EnumUserGender enumUserGender = this.$gender.toEnumUserGender();
                    String head = this.$path.getHead();
                    String body = this.$path.getBody();
                    FilamentUrlTemplate urlTemplate = this.this$0.getUrlTemplate();
                    this.label = 1;
                    obj = portalAnimHelper.d0(null, enumUserGender, head, body, urlTemplate, this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else if (i3 == 1) {
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                return (ZPlanAction) obj;
            } catch (Throwable th5) {
                QLog.e("PortalAnimHelper_", 1, "loadDressAnim failed", th5);
                return null;
            }
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super ZPlanAction> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PortalAnimHelper$loadDressAnim$2(PortalAnimHelper portalAnimHelper, AnimPath animPath, UEAvatarGender uEAvatarGender, FilamentViewerV2 filamentViewerV2, Continuation<? super PortalAnimHelper$loadDressAnim$2> continuation) {
        super(2, continuation);
        this.this$0 = portalAnimHelper;
        this.$path = animPath;
        this.$gender = uEAvatarGender;
        this.$viewer = filamentViewerV2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        PortalAnimHelper$loadDressAnim$2 portalAnimHelper$loadDressAnim$2 = new PortalAnimHelper$loadDressAnim$2(this.this$0, this.$path, this.$gender, this.$viewer, continuation);
        portalAnimHelper$loadDressAnim$2.L$0 = obj;
        return portalAnimHelper$loadDressAnim$2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        Deferred deferred;
        Deferred async$default;
        Deferred deferred2;
        final ZPlanAction zPlanAction;
        AnimPath animPath;
        boolean c16;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            this.this$0.mDressAnimPath = this.$path;
            deferred = this.this$0.mDressAnimResJob;
            if (deferred != null) {
                Job.DefaultImpls.cancel$default((Job) deferred, (CancellationException) null, 1, (Object) null);
            }
            PortalAnimHelper portalAnimHelper = this.this$0;
            async$default = BuildersKt__Builders_commonKt.async$default(coroutineScope, null, null, new AnonymousClass1(portalAnimHelper, this.$gender, this.$path, null), 3, null);
            portalAnimHelper.mDressAnimResJob = async$default;
            deferred2 = this.this$0.mDressAnimResJob;
            if (deferred2 == null) {
                zPlanAction = null;
                animPath = this.this$0.mDressAnimPath;
                AnimPath animPath2 = this.$path;
                c16 = animPath2.c(animPath);
                if (zPlanAction == null && c16) {
                    i mTaskExecutor = this.this$0.getMTaskExecutor();
                    if (mTaskExecutor == null) {
                        return null;
                    }
                    final PortalAnimHelper portalAnimHelper2 = this.this$0;
                    final FilamentViewerV2 filamentViewerV2 = this.$viewer;
                    mTaskExecutor.runOnViewerThread("trackGroupWithAnimations", new Function0<Unit>() { // from class: com.tencent.sqshow.zootopia.avatar.filament.anim.PortalAnimHelper$loadDressAnim$2.2
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
                            PortalAnimHelper.this.mDressAnim = PortalAnimHelper.r1(PortalAnimHelper.this, filamentViewerV2, new ZPlanAction[]{zPlanAction}, null, 4, null);
                            PortalAnimHelper.this.X0(filamentViewerV2);
                        }
                    });
                    return Unit.INSTANCE;
                }
                QLog.i("PortalAnimHelper_", 1, "loadDressAnim isSame:" + c16 + ", animPathNow:" + animPath + ", animPathSelf:" + animPath2 + ", animAction:" + zPlanAction);
                return Unit.INSTANCE;
            }
            this.label = 1;
            obj = deferred2.await(this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i3 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        zPlanAction = (ZPlanAction) obj;
        animPath = this.this$0.mDressAnimPath;
        AnimPath animPath22 = this.$path;
        c16 = animPath22.c(animPath);
        if (zPlanAction == null) {
        }
        QLog.i("PortalAnimHelper_", 1, "loadDressAnim isSame:" + c16 + ", animPathNow:" + animPath + ", animPathSelf:" + animPath22 + ", animAction:" + zPlanAction);
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((PortalAnimHelper$loadDressAnim$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
