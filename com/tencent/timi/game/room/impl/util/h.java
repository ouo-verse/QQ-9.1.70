package com.tencent.timi.game.room.impl.util;

import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import trpc.yes.common.CommonOuterClass$QQUserId;
import trpc.yes.common.YoloRoomOuterClass$YoloRoomInfo;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ\u001e\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006\u00a8\u0006\f"}, d2 = {"Lcom/tencent/timi/game/room/impl/util/h;", "", "Ltrpc/yes/common/CommonOuterClass$QQUserId;", "userId", "", "roomId", "", "reason", "", "a", "<init>", "()V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final h f379336a = new h();

    h() {
    }

    public final void a(@NotNull CommonOuterClass$QQUserId userId, long roomId, int reason) {
        YoloRoomOuterClass$YoloRoomInfo yoloRoomOuterClass$YoloRoomInfo;
        long j3;
        Intrinsics.checkNotNullParameter(userId, "userId");
        if (ll4.b.a(((ll4.a) mm4.b.b(ll4.a.class)).E(), userId)) {
            gm4.c K0 = ((fm4.g) mm4.b.b(fm4.g.class)).K0(roomId);
            if (K0 != null) {
                yoloRoomOuterClass$YoloRoomInfo = K0.getRoomInfo();
            } else {
                yoloRoomOuterClass$YoloRoomInfo = null;
            }
            ConcurrentHashMap<String, String> reportParam = YoloRoomUtil.L(yoloRoomOuterClass$YoloRoomInfo);
            if (reason == 1) {
                Intrinsics.checkNotNullExpressionValue(reportParam, "reportParam");
                reportParam.put("yes_leave_reason", "1");
            } else {
                Intrinsics.checkNotNullExpressionValue(reportParam, "reportParam");
                reportParam.put("yes_leave_reason", "2");
            }
            gm4.c K02 = ((fm4.g) mm4.b.b(fm4.g.class)).K0(roomId);
            if (K02 != null) {
                j3 = K02.A(userId);
            } else {
                j3 = 0;
            }
            reportParam.put("yes_stay_duration", String.valueOf(j3));
            ((ug4.b) mm4.b.b(ug4.b.class)).reportEvent("ev_yes_leave_mic", reportParam);
        }
    }
}
