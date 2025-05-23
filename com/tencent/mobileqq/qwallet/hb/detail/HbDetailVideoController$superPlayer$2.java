package com.tencent.mobileqq.qwallet.hb.detail;

import com.tencent.qphone.base.util.QLog;
import com.tencent.superplayer.api.ISuperPlayer;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n\u00a2\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/tencent/mobileqq/base/f;", "invoke", "()Lcom/tencent/mobileqq/base/f;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class HbDetailVideoController$superPlayer$2 extends Lambda implements Function0<com.tencent.mobileqq.base.f> {
    final /* synthetic */ int $skinId;
    final /* synthetic */ String $uniqueSkinId;
    final /* synthetic */ HbDetailVideoController this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HbDetailVideoController$superPlayer$2(HbDetailVideoController hbDetailVideoController, int i3, String str) {
        super(0);
        this.this$0 = hbDetailVideoController;
        this.$skinId = i3;
        this.$uniqueSkinId = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(HbDetailVideoController this$0, ISuperPlayer iSuperPlayer) {
        boolean f16;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.isVideoPrepared = true;
        f16 = this$0.f();
        if (f16) {
            this$0.m();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean e(ISuperPlayer iSuperPlayer, int i3, int i16, int i17, String str) {
        QLog.d("HbDetailVideoController", 1, "initVideoPlayer onError: module:" + i3 + "; errorType:" + i16 + "; errorCode:" + i17 + "; extraInfo:" + str);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean f(HbDetailVideoController this$0, int i3, String uniqueSkinId, ISuperPlayer iSuperPlayer, int i16, long j3, long j16, Object obj) {
        boolean z16;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(uniqueSkinId, "$uniqueSkinId");
        z16 = this$0.isPlayCompleteReported;
        if (!z16 && i16 == 108) {
            this$0.isPlayCompleteReported = true;
            HbDetailModule.l("redpacket.story.playfinish", String.valueOf(i3), "", uniqueSkinId);
            return false;
        }
        return false;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    @NotNull
    public final com.tencent.mobileqq.base.f invoke() {
        com.tencent.mobileqq.base.f fVar = new com.tencent.mobileqq.base.f(117, this.this$0.getVideoView());
        final HbDetailVideoController hbDetailVideoController = this.this$0;
        final int i3 = this.$skinId;
        final String str = this.$uniqueSkinId;
        fVar.p(0);
        fVar.n(new ISuperPlayer.OnVideoPreparedListener() { // from class: com.tencent.mobileqq.qwallet.hb.detail.z
            @Override // com.tencent.superplayer.api.ISuperPlayer.OnVideoPreparedListener
            public final void onVideoPrepared(ISuperPlayer iSuperPlayer) {
                HbDetailVideoController$superPlayer$2.d(HbDetailVideoController.this, iSuperPlayer);
            }
        });
        fVar.l(new ISuperPlayer.OnErrorListener() { // from class: com.tencent.mobileqq.qwallet.hb.detail.aa
            @Override // com.tencent.superplayer.api.ISuperPlayer.OnErrorListener
            public final boolean onError(ISuperPlayer iSuperPlayer, int i16, int i17, int i18, String str2) {
                boolean e16;
                e16 = HbDetailVideoController$superPlayer$2.e(iSuperPlayer, i16, i17, i18, str2);
                return e16;
            }
        });
        fVar.m(new ISuperPlayer.OnInfoListener() { // from class: com.tencent.mobileqq.qwallet.hb.detail.ab
            @Override // com.tencent.superplayer.api.ISuperPlayer.OnInfoListener
            public final boolean onInfo(ISuperPlayer iSuperPlayer, int i16, long j3, long j16, Object obj) {
                boolean f16;
                f16 = HbDetailVideoController$superPlayer$2.f(HbDetailVideoController.this, i3, str, iSuperPlayer, i16, j3, j16, obj);
                return f16;
            }
        });
        fVar.k(true);
        return fVar;
    }
}
