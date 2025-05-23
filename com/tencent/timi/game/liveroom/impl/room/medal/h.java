package com.tencent.timi.game.liveroom.impl.room.medal;

import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.qqlive.api.config.QQLiveSDKConfigHelper;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u001e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004J\u0016\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u0006\u0010\u000b\u001a\u00020\tR0\u0010\u000f\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070\fj\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0007`\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/timi/game/liveroom/impl/room/medal/h;", "", "", "roomId", "", "roomType", QQBrowserActivity.KEY_MSG_TYPE, "Lcom/tencent/timi/game/liveroom/impl/room/medal/e;", "a", "", "b", "c", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "Ljava/util/HashMap;", "medalInfoSuppliers", "<init>", "()V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final HashMap<Integer, e> medalInfoSuppliers = new HashMap<>();

    @NotNull
    public final e a(long roomId, int roomType, int msgType) {
        if (!uj4.b.f439096a.e(roomId, roomType)) {
            return com.tencent.timi.game.liveroom.impl.room.medal.supplier.c.f378042a;
        }
        e eVar = this.medalInfoSuppliers.get(Integer.valueOf(msgType));
        if (eVar == null) {
            return com.tencent.timi.game.liveroom.impl.room.medal.supplier.c.f378042a;
        }
        return eVar;
    }

    public final void b(long roomId, int roomType) {
        String appId = QQLiveSDKConfigHelper.getQQLiveAppId();
        HashMap<Integer, e> hashMap = this.medalInfoSuppliers;
        Intrinsics.checkNotNullExpressionValue(appId, "appId");
        hashMap.put(1, new com.tencent.timi.game.liveroom.impl.room.medal.supplier.d(roomId, roomType, appId));
        this.medalInfoSuppliers.put(100, new com.tencent.timi.game.liveroom.impl.room.medal.supplier.d(roomId, roomType, appId));
        this.medalInfoSuppliers.put(101, new com.tencent.timi.game.liveroom.impl.room.medal.supplier.d(roomId, roomType, appId));
        this.medalInfoSuppliers.put(5, new com.tencent.timi.game.liveroom.impl.room.medal.supplier.b(roomId, roomType, appId));
    }

    public final void c() {
        this.medalInfoSuppliers.clear();
    }
}
