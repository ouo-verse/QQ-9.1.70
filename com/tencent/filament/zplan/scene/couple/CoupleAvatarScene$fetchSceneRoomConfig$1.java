package com.tencent.filament.zplan.scene.couple;

import com.tencent.mobileqq.mini.share.MiniShareQuicklySendPanelFragment;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\u0001\u001a\u0004\u0018\u00010\u00002\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0082@"}, d2 = {"Lcom/tencent/zplan/zplantracing/c;", "spanContext", "", "roomBpUrl", "Lkotlin/coroutines/Continuation;", "Lcom/tencent/filament/zplan/scene/couple/config/BpConfig;", "continuation", "", "fetchSceneRoomConfig"}, k = 3, mv = {1, 4, 2})
@DebugMetadata(c = "com.tencent.filament.zplan.scene.couple.CoupleAvatarScene", f = "CoupleAvatarScene.kt", i = {0, 0, 1, 1, 2}, l = {675, 677, MiniShareQuicklySendPanelFragment.QUCIKLY_SHARE_REQUEST_CODE}, m = "fetchSceneRoomConfig", n = {"this", "spanContext", "this", "spanContext", "bpConfig"}, s = {"L$0", "L$1", "L$0", "L$1", "L$0"})
/* loaded from: classes6.dex */
public final class CoupleAvatarScene$fetchSceneRoomConfig$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ CoupleAvatarScene this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CoupleAvatarScene$fetchSceneRoomConfig$1(CoupleAvatarScene coupleAvatarScene, Continuation continuation) {
        super(continuation);
        this.this$0 = coupleAvatarScene;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.U0(null, null, this);
    }
}
