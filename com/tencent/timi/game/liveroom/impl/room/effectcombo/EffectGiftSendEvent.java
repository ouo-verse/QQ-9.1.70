package com.tencent.timi.game.liveroom.impl.room.effectcombo;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.mobileqq.qqgift.data.service.d;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\t\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\f\u001a\u00020\u0007\u00a2\u0006\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0003\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\b\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\f\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000b\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/timi/game/liveroom/impl/room/effectcombo/EffectGiftSendEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "Lcom/tencent/mobileqq/qqgift/data/service/d;", "giftServiceData", "Lcom/tencent/mobileqq/qqgift/data/service/d;", "getGiftServiceData", "()Lcom/tencent/mobileqq/qqgift/data/service/d;", "", "comboCnt", "I", "getComboCnt", "()I", "allComboCnt", "getAllComboCnt", "<init>", "(Lcom/tencent/mobileqq/qqgift/data/service/d;II)V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class EffectGiftSendEvent extends SimpleBaseEvent {
    private final int allComboCnt;
    private final int comboCnt;

    @NotNull
    private final d giftServiceData;

    public EffectGiftSendEvent(@NotNull d giftServiceData, int i3, int i16) {
        Intrinsics.checkNotNullParameter(giftServiceData, "giftServiceData");
        this.giftServiceData = giftServiceData;
        this.comboCnt = i3;
        this.allComboCnt = i16;
    }

    public final int getAllComboCnt() {
        return this.allComboCnt;
    }

    public final int getComboCnt() {
        return this.comboCnt;
    }

    @NotNull
    public final d getGiftServiceData() {
        return this.giftServiceData;
    }
}
