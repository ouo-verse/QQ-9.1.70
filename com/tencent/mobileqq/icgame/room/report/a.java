package com.tencent.mobileqq.icgame.room.report;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.icgame.game.api.live.LiveRoomExtraInfo;
import com.tencent.icgame.game.liveroom.impl.room.floatwindow.QQLiveFloatWindowManager;
import com.tencent.mobileqq.icgame.api.IQQLiveSDK;
import com.tencent.mobileqq.icgame.framework.interfaceService.InjectService;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import i22.k;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import y32.d;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u001d\u001a\u00020\u001c\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\n\u001a\u00020\tH\u0002J\b\u0010\u000b\u001a\u00020\u0006H\u0016J\b\u0010\f\u001a\u00020\u0006H\u0016J\u000e\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\rJ\u0006\u0010\u0010\u001a\u00020\u0006J\u0006\u0010\u0011\u001a\u00020\u0006J\u0006\u0010\u0012\u001a\u00020\u0006J\u0006\u0010\u0013\u001a\u00020\u0006R\u001c\u0010\u0018\u001a\n \u0015*\u0004\u0018\u00010\u00140\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001a\u001a\u00020\u00198\u0002@\u0002X\u0083.\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001b\u00a8\u0006 "}, d2 = {"Lcom/tencent/mobileqq/icgame/room/report/a;", "Lcom/tencent/mobileqq/icgame/framework/component/b;", "", "roomId", "Lcom/tencent/icgame/game/api/live/LiveRoomExtraInfo;", "extraInfo", "", ReportConstant.COSTREPORT_PREFIX, "b", "", "c", "k", "i", "Li22/k;", "event", "r", "p", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "o", DomainData.DOMAIN_NAME, "Lfu0/c;", "kotlin.jvm.PlatformType", "e", "Lfu0/c;", "liveRoomService", "Lh22/a;", "qqLiveRoomService", "Lh22/a;", "Lf32/a;", "componentContext", "<init>", "(Lf32/a;)V", "ic-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class a extends com.tencent.mobileqq.icgame.framework.component.b {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final fu0.c liveRoomService;

    @InjectService(key = h22.a.class)
    private h22.a qqLiveRoomService;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(@NotNull f32.a componentContext) {
        super(componentContext);
        Intrinsics.checkNotNullParameter(componentContext, "componentContext");
        this.liveRoomService = (fu0.c) qx0.a.b(fu0.c.class);
    }

    private final long b(LiveRoomExtraInfo extraInfo) {
        long m3 = QQLiveFloatWindowManager.f115256a.m();
        if (m3 != 0) {
            return m3;
        }
        Bundle bundle = extraInfo.E;
        if (bundle == null) {
            return -1L;
        }
        String string = bundle.getString("jump_start_time");
        if (!TextUtils.isEmpty(string)) {
            try {
                Intrinsics.checkNotNull(string);
                return Long.parseLong(string);
            } catch (NumberFormatException e16) {
                Intrinsics.checkNotNull(string);
                d.c(string, e16);
            }
        }
        return -1L;
    }

    private final String c() {
        String str;
        AppRuntime appRuntime;
        IQQLiveSDK f16 = this.liveRoomService.f();
        if (f16 != null && (appRuntime = f16.getAppRuntime()) != null) {
            str = appRuntime.getAccount();
        } else {
            str = null;
        }
        if (str == null) {
            return "";
        }
        return str;
    }

    private final void s(long roomId, LiveRoomExtraInfo extraInfo) {
        long b16 = b(extraInfo);
        ReportHelper reportHelper = ReportHelper.INSTANCE;
        int i3 = extraInfo.f114882f;
        StringBuilder sb5 = new StringBuilder();
        sb5.append(i3);
        String sb6 = sb5.toString();
        String str = extraInfo.I;
        Intrinsics.checkNotNullExpressionValue(str, "extraInfo.jumpSource");
        String c16 = c();
        Intrinsics.checkNotNull(c16);
        reportHelper.saveRecordInfo(roomId, sb6, str, c16);
        reportHelper.saveClickStartAndPreloadTime(roomId, b16, System.currentTimeMillis());
        reportHelper.saveSwitchRoomTime(roomId, b16);
    }

    public final void n() {
        ReportHelper reportHelper = ReportHelper.INSTANCE;
        h22.a aVar = this.qqLiveRoomService;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("qqLiveRoomService");
            aVar = null;
        }
        reportHelper.savePageOutTimeAndTryReportVideoError(aVar.getRoomId(), System.currentTimeMillis(), true);
        reportHelper.clear();
    }

    public final void o() {
        ReportHelper reportHelper = ReportHelper.INSTANCE;
        h22.a aVar = this.qqLiveRoomService;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("qqLiveRoomService");
            aVar = null;
        }
        reportHelper.saveEnterRoomEndTimeAndReport(aVar.getRoomId(), System.currentTimeMillis(), 0, "");
    }

    public final void p() {
        xw0.b bVar = xw0.b.f448881a;
        h22.a aVar = this.qqLiveRoomService;
        h22.a aVar2 = null;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("qqLiveRoomService");
            aVar = null;
        }
        long roomId = aVar.getRoomId();
        h22.a aVar3 = this.qqLiveRoomService;
        if (aVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("qqLiveRoomService");
            aVar3 = null;
        }
        bVar.w(roomId, aVar3.getExtraInfo());
        ReportHelper reportHelper = ReportHelper.INSTANCE;
        h22.a aVar4 = this.qqLiveRoomService;
        if (aVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("qqLiveRoomService");
        } else {
            aVar2 = aVar4;
        }
        reportHelper.savePageInTime(aVar2.getRoomId(), System.currentTimeMillis());
    }

    public final void q() {
        h22.a aVar = this.qqLiveRoomService;
        h22.a aVar2 = null;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("qqLiveRoomService");
            aVar = null;
        }
        LiveRoomExtraInfo extraInfo = aVar.getExtraInfo();
        if (extraInfo != null) {
            h22.a aVar3 = this.qqLiveRoomService;
            if (aVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("qqLiveRoomService");
            } else {
                aVar2 = aVar3;
            }
            s(aVar2.getRoomId(), extraInfo);
        }
    }

    public final void r(@NotNull k event) {
        Intrinsics.checkNotNullParameter(event, "event");
        ReportHelper reportHelper = ReportHelper.INSTANCE;
        h22.a aVar = this.qqLiveRoomService;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("qqLiveRoomService");
            aVar = null;
        }
        reportHelper.saveSwitchRoomTime(aVar.getRoomId(), System.currentTimeMillis());
    }

    @Override // com.tencent.mobileqq.icgame.framework.component.e
    public void i() {
    }

    @Override // com.tencent.mobileqq.icgame.framework.component.e
    public void k() {
    }
}
