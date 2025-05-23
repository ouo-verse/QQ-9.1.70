package com.tencent.icgame.game.liveroom.impl.room.followguide;

import android.app.Activity;
import android.content.Context;
import com.tencent.mobileqq.icgame.framework.interfaceService.InjectService;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u00a2\u0006\u0004\b\u0010\u0010\u0011J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\u0006\u0010\u0005\u001a\u00020\u0002J\u0006\u0010\u0006\u001a\u00020\u0002R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR\u0016\u0010\f\u001a\u00020\u000b8\u0002@\u0002X\u0083.\u00a2\u0006\u0006\n\u0004\b\f\u0010\r\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/icgame/game/liveroom/impl/room/followguide/b;", "Lcom/tencent/mobileqq/icgame/framework/component/b;", "", "k", "i", "b", "c", "Lcom/tencent/icgame/game/liveroom/impl/room/followguide/FollowGuideDialogController;", "e", "Lcom/tencent/icgame/game/liveroom/impl/room/followguide/FollowGuideDialogController;", "guideDialogController", "Lh22/a;", "qqLiveRoomService", "Lh22/a;", "Lf32/a;", "cc", "<init>", "(Lf32/a;)V", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes7.dex */
public final class b extends com.tencent.mobileqq.icgame.framework.component.b {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private FollowGuideDialogController guideDialogController;

    @InjectService(key = h22.a.class)
    private h22.a qqLiveRoomService;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(@NotNull f32.a cc5) {
        super(cc5);
        Intrinsics.checkNotNullParameter(cc5, "cc");
    }

    public final void b() {
        if (this.guideDialogController == null) {
            this.guideDialogController = new FollowGuideDialogController();
        }
        FollowGuideDialogController followGuideDialogController = this.guideDialogController;
        if (followGuideDialogController != null) {
            h22.a aVar = this.qqLiveRoomService;
            h22.a aVar2 = null;
            if (aVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("qqLiveRoomService");
                aVar = null;
            }
            Context d16 = aVar.d();
            Intrinsics.checkNotNull(d16, "null cannot be cast to non-null type android.app.Activity");
            Activity activity = (Activity) d16;
            h22.a aVar3 = this.qqLiveRoomService;
            if (aVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("qqLiveRoomService");
            } else {
                aVar2 = aVar3;
            }
            followGuideDialogController.l(activity, aVar2.getRoomId());
        }
    }

    public final void c() {
        FollowGuideDialogController followGuideDialogController = this.guideDialogController;
        if (followGuideDialogController != null) {
            followGuideDialogController.m();
        }
    }

    @Override // com.tencent.mobileqq.icgame.framework.component.e
    public void i() {
    }

    @Override // com.tencent.mobileqq.icgame.framework.component.e
    public void k() {
    }
}
