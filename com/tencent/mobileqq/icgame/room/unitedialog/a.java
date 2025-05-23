package com.tencent.mobileqq.icgame.room.unitedialog;

import com.tencent.icgame.game.liveroom.impl.room.unitedialog.BaseUniteDialogComponent;
import com.tencent.mobileqq.icgame.framework.eventbroadcaster.annotation.ComponentEvent;
import com.tencent.mobileqq.icgame.framework.interfaceService.InjectService;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@ComponentEvent
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u00a2\u0006\u0004\b\u0010\u0010\u0011J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016R\u0016\u0010\u0006\u001a\u00020\u00048\u0002@\u0002X\u0083.\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\"\u0010\b\u001a\u00020\u00028\u0006@\u0006X\u0087.\u00a2\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/icgame/room/unitedialog/a;", "Lcom/tencent/icgame/game/liveroom/impl/room/unitedialog/BaseUniteDialogComponent;", "Lfx0/a;", "r", "Lh22/a;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "qqLiveRoomService", "Lh22/a;", "uniteDialogSupport", "Lfx0/a;", ReportConstant.COSTREPORT_PREFIX, "()Lfx0/a;", "setUniteDialogSupport", "(Lfx0/a;)V", "Lf32/a;", "cc", "<init>", "(Lf32/a;)V", "ic-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class a extends BaseUniteDialogComponent {

    @InjectService(key = h22.a.class)
    private h22.a qqLiveRoomService;

    @InjectService(key = fx0.a.class)
    public fx0.a uniteDialogSupport;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(@NotNull f32.a cc5) {
        super(cc5);
        Intrinsics.checkNotNullParameter(cc5, "cc");
    }

    @Override // com.tencent.icgame.game.liveroom.impl.room.unitedialog.BaseUniteDialogComponent
    @NotNull
    public h22.a q() {
        h22.a aVar = this.qqLiveRoomService;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("qqLiveRoomService");
            return null;
        }
        return aVar;
    }

    @Override // com.tencent.icgame.game.liveroom.impl.room.unitedialog.BaseUniteDialogComponent
    @NotNull
    public fx0.a r() {
        return s();
    }

    @NotNull
    public final fx0.a s() {
        fx0.a aVar = this.uniteDialogSupport;
        if (aVar != null) {
            return aVar;
        }
        Intrinsics.throwUninitializedPropertyAccessException("uniteDialogSupport");
        return null;
    }
}
