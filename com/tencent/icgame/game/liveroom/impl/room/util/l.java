package com.tencent.icgame.game.liveroom.impl.room.util;

import com.google.protobuf.nano.MessageNano;
import com.tencent.icgame.common.api.IAegisLogApi;
import com.tencent.mobileqq.icgame.api.IQQLiveSDK;
import com.tencent.mobileqq.icgame.api.IQQLiveSDKManager;
import com.tencent.mobileqq.icgame.api.config.QQLiveSDKConfigHelper;
import com.tencent.mobileqq.qqlive.callback.sso.IQQLiveProxySsoObserver;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0016\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002\"\u0014\u0010\t\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\b\u00a8\u0006\n"}, d2 = {"", "roomId", "", "eventType", "", "b", "Lcom/tencent/icgame/common/api/IAegisLogApi;", "a", "Lcom/tencent/icgame/common/api/IAegisLogApi;", "aegisLogger", "ic-game-timi-game-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes7.dex */
public final class l {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private static final IAegisLogApi f115701a;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/icgame/game/liveroom/impl/room/util/l$a", "Lcom/tencent/mobileqq/qqlive/callback/sso/IQQLiveProxySsoObserver;", "", "data", "", "onReceive", "", "errCode", "", "errMsg", "onFail", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes7.dex */
    public static final class a implements IQQLiveProxySsoObserver {
        a() {
        }

        @Override // com.tencent.mobileqq.qqlive.callback.sso.IQQLiveProxySsoObserver
        public void onFail(int errCode, @Nullable String errMsg) {
            l.f115701a.e("ICGameRoomReportUtil", "report onError code=" + errCode + " ,msg=" + errMsg);
        }

        @Override // com.tencent.mobileqq.qqlive.callback.sso.IQQLiveProxySsoObserver
        public void onReceive(@Nullable byte[] data) {
            l.f115701a.i("ICGameRoomReportUtil", "report success");
        }
    }

    static {
        QRouteApi api = QRoute.api(IAegisLogApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IAegisLogApi::class.java)");
        f115701a = (IAegisLogApi) api;
    }

    public static final void b(long j3, int i3) {
        IQQLiveSDK sDKImpl = ((IQQLiveSDKManager) QRoute.api(IQQLiveSDKManager.class)).getSDKImpl(QQLiveSDKConfigHelper.getQQLiveAppId());
        if (sDKImpl.isInited() && !sDKImpl.isDestroyed()) {
            fz0.a aVar = new fz0.a();
            aVar.f400961a = i3;
            aVar.f400962b = j3;
            aVar.f400963c = System.currentTimeMillis();
            f115701a.i("ICGameRoomReportUtil", "report roomId=" + j3 + ",eventType=" + i3);
            sDKImpl.getProxySsoService().sendQQLiveProxyReq("trpc.now.event_report.EventReport", "DoReport", MessageNano.toByteArray(aVar), new a());
        }
    }
}
