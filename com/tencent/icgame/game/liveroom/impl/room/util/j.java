package com.tencent.icgame.game.liveroom.impl.room.util;

import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\b"}, d2 = {"Lcom/tencent/icgame/game/liveroom/impl/room/util/j;", "", "", "speed", "", "a", "<init>", "()V", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes7.dex */
public final class j {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final j f115698a = new j();

    j() {
    }

    @NotNull
    public final String a(long speed) {
        if (0 == speed) {
            return "\u6b63\u5728\u4e0b\u8f7d 0 B/s";
        }
        if (speed < 1024) {
            return "\u6b63\u5728\u4e0b\u8f7d " + speed + " B/s";
        }
        double d16 = speed / 1024.0d;
        if (d16 < 1024.0d) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String format = String.format("%.2f", Arrays.copyOf(new Object[]{Double.valueOf(d16)}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
            return "\u6b63\u5728\u4e0b\u8f7d " + format + " KB/s";
        }
        StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
        String format2 = String.format("%.2f", Arrays.copyOf(new Object[]{Double.valueOf(d16 / 1024.0d)}, 1));
        Intrinsics.checkNotNullExpressionValue(format2, "format(format, *args)");
        return "\u6b63\u5728\u4e0b\u8f7d " + format2 + " KB/s";
    }
}
