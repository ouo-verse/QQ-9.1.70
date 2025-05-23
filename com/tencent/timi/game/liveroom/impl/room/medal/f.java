package com.tencent.timi.game.liveroom.impl.room.medal;

import com.tencent.mobileqq.qqlive.api.room.IAudienceRoom;
import com.tencent.mobileqq.qqlive.api.room.ILiveAudienceTPPlayerRoom;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010%\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0016\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006R\"\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00060\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010\u000b\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/timi/game/liveroom/impl/room/medal/f;", "", "Lcom/tencent/mobileqq/qqlive/api/room/ILiveAudienceTPPlayerRoom;", "a", "", "key", "", "mute", "", "b", "", "Ljava/util/Map;", "muteControlMap", "<init>", "()V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final f f377988a = new f();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static Map<String, Boolean> muteControlMap = new LinkedHashMap();

    f() {
    }

    private final ILiveAudienceTPPlayerRoom a() {
        IAudienceRoom N = ((jg4.b) mm4.b.b(jg4.b.class)).N(0L);
        if (N instanceof ILiveAudienceTPPlayerRoom) {
            return (ILiveAudienceTPPlayerRoom) N;
        }
        return null;
    }

    public final void b(@NotNull String key, boolean mute) {
        Intrinsics.checkNotNullParameter(key, "key");
        ILiveAudienceTPPlayerRoom a16 = a();
        if (a16 != null) {
            muteControlMap.put(key, Boolean.valueOf(mute));
            Iterator<Map.Entry<String, Boolean>> it = muteControlMap.entrySet().iterator();
            boolean z16 = false;
            while (it.hasNext()) {
                if (it.next().getValue().booleanValue()) {
                    z16 = true;
                }
            }
            a16.setMute(z16);
        }
    }
}
