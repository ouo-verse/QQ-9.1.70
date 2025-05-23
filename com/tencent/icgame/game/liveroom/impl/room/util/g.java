package com.tencent.icgame.game.liveroom.impl.room.util;

import java.math.BigDecimal;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006\u00a8\u0006\t"}, d2 = {"Lcom/tencent/icgame/game/liveroom/impl/room/util/g;", "", "", "number", "", "a", "(Ljava/lang/Long;)Ljava/lang/String;", "<init>", "()V", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes7.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final g f115696a = new g();

    g() {
    }

    @NotNull
    public final String a(@Nullable Long number) {
        if (number == null) {
            return "";
        }
        if (number.longValue() <= 0) {
            return "0";
        }
        if (number.longValue() < 10000) {
            return number.toString();
        }
        double doubleValue = new BigDecimal(number.longValue() / 10000).setScale(1, 4).doubleValue();
        if (doubleValue >= 999.0d) {
            return "999\u4e07+";
        }
        return doubleValue + "\u4e07";
    }
}
