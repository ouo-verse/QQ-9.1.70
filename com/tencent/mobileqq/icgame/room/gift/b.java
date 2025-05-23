package com.tencent.mobileqq.icgame.room.gift;

import android.app.Activity;
import android.os.Bundle;
import av0.l;
import com.tencent.icgame.common.api.IAegisLogApi;
import com.tencent.icgame.game.api.live.LiveRoomExtraInfo;
import com.tencent.mobileqq.icgame.api.config.QQLiveSDKConfigHelper;
import com.tencent.mobileqq.icgame.api.room.IAudienceRoom;
import com.tencent.mobileqq.icgame.framework.interfaceService.InjectService;
import com.tencent.mobileqq.qqlive.data.room.BaseRoomInfo;
import com.tencent.mobileqq.qqlive.data.user.LiveUserInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import fu0.e;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Foreground;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00192\u00020\u0001:\u0001\u001aB\u000f\u0012\u0006\u0010\u0016\u001a\u00020\u0015\u00a2\u0006\u0004\b\u0017\u0010\u0018J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\u0006\u0010\u0005\u001a\u00020\u0002R\u0014\u0010\t\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u001c\u0010\u000e\u001a\n \u000b*\u0004\u0018\u00010\n0\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u0010\u001a\u00020\u000f8\u0002@\u0002X\u0083.\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0013\u001a\u00020\u00128\u0002@\u0002X\u0083.\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/icgame/room/gift/b;", "Lcom/tencent/mobileqq/icgame/framework/component/b;", "", "k", "i", "b", "Lcom/tencent/icgame/common/api/IAegisLogApi;", "e", "Lcom/tencent/icgame/common/api/IAegisLogApi;", "log", "Lfu0/c;", "kotlin.jvm.PlatformType", "f", "Lfu0/c;", "liveRoomService", "Lh22/a;", "qqLiveRoomService", "Lh22/a;", "Lcom/tencent/mobileqq/icgame/room/likeowner/a;", "liveLikeViewService", "Lcom/tencent/mobileqq/icgame/room/likeowner/a;", "Lf32/a;", "componentContext", "<init>", "(Lf32/a;)V", h.F, "a", "ic-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class b extends com.tencent.mobileqq.icgame.framework.component.b {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final IAegisLogApi log;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final fu0.c liveRoomService;

    @InjectService(key = com.tencent.mobileqq.icgame.room.likeowner.a.class)
    private com.tencent.mobileqq.icgame.room.likeowner.a liveLikeViewService;

    @InjectService(key = h22.a.class)
    private h22.a qqLiveRoomService;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(@NotNull f32.a componentContext) {
        super(componentContext);
        Intrinsics.checkNotNullParameter(componentContext, "componentContext");
        QRouteApi api = QRoute.api(IAegisLogApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IAegisLogApi::class.java)");
        this.log = (IAegisLogApi) api;
        this.liveRoomService = (fu0.c) qx0.a.b(fu0.c.class);
    }

    public final void b() {
        String str;
        Long l3;
        h22.a aVar = this.qqLiveRoomService;
        h22.a aVar2 = null;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("qqLiveRoomService");
            aVar = null;
        }
        long roomId = aVar.getRoomId();
        this.log.i("GiftEntranceComponent", "roomId " + roomId + " showGiftPanel");
        e n3 = this.liveRoomService.n(roomId);
        if (n3 == null) {
            this.log.e("GiftEntranceComponent", "roomId " + roomId + " showGiftPanel, userInfo == null");
            return;
        }
        LiveUserInfo selfUserInfo = this.liveRoomService.getSelfUserInfo();
        if (selfUserInfo == null) {
            this.log.e("GiftEntranceComponent", "roomId " + roomId + " showGiftPanel, selfUserInfo == null");
            return;
        }
        BaseRoomInfo q16 = this.liveRoomService.q(roomId);
        if (q16 == null) {
            this.log.e("GiftEntranceComponent", "roomId " + roomId + " showGiftPanel, roomInfo == null");
            return;
        }
        Activity topActivity = Foreground.getTopActivity();
        if (topActivity == null) {
            this.log.e("GiftEntranceComponent", "roomId " + roomId + " showGiftPanel, activity == null");
            return;
        }
        h22.a aVar3 = this.qqLiveRoomService;
        if (aVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("qqLiveRoomService");
            aVar3 = null;
        }
        LiveRoomExtraInfo extraInfo = aVar3.getExtraInfo();
        if (extraInfo == null) {
            this.log.e("GiftEntranceComponent", "roomId " + roomId + " showGiftPanel, extraInfo == null");
            return;
        }
        Bundle bundle = extraInfo.E;
        if (bundle != null) {
            str = bundle.getString("rcmd_context");
        } else {
            str = null;
        }
        if (str == null) {
            str = "";
        }
        String str2 = str;
        this.log.i("GiftEntranceComponent", "roomId " + roomId + " showGiftPanel, traceDetail " + str2);
        com.tencent.mobileqq.icgame.room.likeowner.a aVar4 = this.liveLikeViewService;
        if (aVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("liveLikeViewService");
            aVar4 = null;
        }
        boolean z16 = true;
        aVar4.a(true);
        long j3 = selfUserInfo.uid;
        IAudienceRoom N = this.liveRoomService.N(roomId);
        if (N != null) {
            l3 = Long.valueOf(N.getEnterRoomTime());
        } else {
            l3 = null;
        }
        String str3 = j3 + "_" + roomId + "_" + l3;
        int sceneId = QQLiveSDKConfigHelper.getSceneId();
        if (getComponentContext().getContext().getResources().getConfiguration().orientation != 2) {
            z16 = false;
        }
        l.Companion companion = l.INSTANCE;
        h22.a aVar5 = this.qqLiveRoomService;
        if (aVar5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("qqLiveRoomService");
        } else {
            aVar2 = aVar5;
        }
        int roomType = aVar2.getRoomType();
        long j16 = selfUserInfo.uid;
        String str4 = selfUserInfo.nick;
        Intrinsics.checkNotNullExpressionValue(str4, "selfUserInfo.nick");
        String str5 = selfUserInfo.headUrl;
        Intrinsics.checkNotNullExpressionValue(str5, "selfUserInfo.headUrl");
        long j17 = n3.f400636a;
        String str6 = n3.f400637b;
        Intrinsics.checkNotNullExpressionValue(str6, "userInfo.nickName");
        String str7 = n3.f400638c;
        Intrinsics.checkNotNullExpressionValue(str7, "userInfo.headUrl");
        long j18 = extraInfo.f114885m;
        StringBuilder sb5 = new StringBuilder();
        sb5.append(j18);
        String sb6 = sb5.toString();
        int i3 = extraInfo.f114883h;
        StringBuilder sb7 = new StringBuilder();
        sb7.append(i3);
        String sb8 = sb7.toString();
        String str8 = q16.getProgramId();
        String str9 = QQLiveSDKConfigHelper.getQQLiveAppId();
        int i16 = extraInfo.f114883h;
        StringBuilder sb9 = new StringBuilder();
        sb9.append(i16);
        companion.e(topActivity, (r58 & 2) != 0 ? false : z16, sceneId, roomId, roomType, j16, str4, str5, j17, str6, str7, sb6, sb8, str8, str9, str2, sb9.toString(), 1, (r58 & 262144) != 0 ? 0 : 0, str3, "2", "\u793c\u7269", "QQ\u5a31\u4e50", (r58 & 8388608) != 0 ? null : null);
    }

    @Override // com.tencent.mobileqq.icgame.framework.component.e
    public void i() {
    }

    @Override // com.tencent.mobileqq.icgame.framework.component.e
    public void k() {
    }
}
