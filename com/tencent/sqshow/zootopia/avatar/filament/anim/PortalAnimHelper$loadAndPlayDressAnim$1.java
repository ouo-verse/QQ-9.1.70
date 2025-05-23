package com.tencent.sqshow.zootopia.avatar.filament.anim;

import com.tencent.filament.zplan.engine.FilamentViewerV2;
import com.tencent.mobileqq.zootopia.api.UEAvatarGender;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.sqshow.zootopia.avatar.filament.anim.PortalAnimHelper$loadAndPlayDressAnim$1", f = "PortalAnimHelper.kt", i = {}, l = {218}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes34.dex */
public final class PortalAnimHelper$loadAndPlayDressAnim$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ UEAvatarGender $gender;
    final /* synthetic */ AnimPath $path;
    final /* synthetic */ FilamentViewerV2 $viewer;
    int label;
    final /* synthetic */ PortalAnimHelper this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PortalAnimHelper$loadAndPlayDressAnim$1(PortalAnimHelper portalAnimHelper, FilamentViewerV2 filamentViewerV2, UEAvatarGender uEAvatarGender, AnimPath animPath, Continuation<? super PortalAnimHelper$loadAndPlayDressAnim$1> continuation) {
        super(2, continuation);
        this.this$0 = portalAnimHelper;
        this.$viewer = filamentViewerV2;
        this.$gender = uEAvatarGender;
        this.$path = animPath;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PortalAnimHelper$loadAndPlayDressAnim$1(this.this$0, this.$viewer, this.$gender, this.$path, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        Object y06;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            PortalAnimHelper portalAnimHelper = this.this$0;
            FilamentViewerV2 filamentViewerV2 = this.$viewer;
            UEAvatarGender uEAvatarGender = this.$gender;
            AnimPath animPath = this.$path;
            this.label = 1;
            y06 = portalAnimHelper.y0(filamentViewerV2, uEAvatarGender, animPath, this);
            if (y06 == coroutine_suspended) {
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
        return ((PortalAnimHelper$loadAndPlayDressAnim$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
