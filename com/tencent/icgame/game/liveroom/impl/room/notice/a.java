package com.tencent.icgame.game.liveroom.impl.room.notice;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tenpay.sdk.util.UinConfigManager;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\u0006\u0018\u0000 \u00052\u00020\u0001:\u0001\u000bB\u0007\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0018\u0010\b\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u0004J\u0010\u0010\t\u001a\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002R \u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/icgame/game/liveroom/impl/room/notice/a;", "", "", UinConfigManager.KEY_ADS, "", "b", "state", "", "d", "c", "", "a", "Ljava/util/Map;", "noticeStateMap", "<init>", "()V", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes7.dex */
public final class a {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    private static final a f115451c = new a();

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Map<String, Integer> noticeStateMap = new LinkedHashMap();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rR\u0017\u0010\u0003\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\b\u001a\u00020\u00078\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u00078\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\n\u0010\tR\u0014\u0010\u000b\u001a\u00020\u00078\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\t\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/icgame/game/liveroom/impl/room/notice/a$a;", "", "Lcom/tencent/icgame/game/liveroom/impl/room/notice/a;", WadlProxyConsts.LOAD_CONFIG_FROM_INSTANCE, "Lcom/tencent/icgame/game/liveroom/impl/room/notice/a;", "a", "()Lcom/tencent/icgame/game/liveroom/impl/room/notice/a;", "", "STATE_FORBID", "I", "STATE_NORMAL", "STATE_REVIEW_ING", "<init>", "()V", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.icgame.game.liveroom.impl.room.notice.a$a, reason: collision with other inner class name and from kotlin metadata */
    /* loaded from: classes7.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final a a() {
            return a.f115451c;
        }

        Companion() {
        }
    }

    public final int b(@Nullable String notice) {
        Integer num;
        if (notice == null || (num = this.noticeStateMap.get(notice)) == null) {
            return 1;
        }
        return num.intValue();
    }

    @NotNull
    public final String c(@Nullable String notice) {
        int i3;
        if (notice == null) {
            return "";
        }
        Integer num = this.noticeStateMap.get(notice);
        if (num != null) {
            i3 = num.intValue();
        } else {
            i3 = 1;
        }
        if (i3 != 2) {
            if (i3 != 3) {
                return "";
            }
            return "(\u5ba1\u6838\u4e0d\u901a\u8fc7)";
        }
        return "(\u5ba1\u6838\u4e2d)";
    }

    public final void d(@Nullable String notice, int state) {
        if (notice != null) {
            this.noticeStateMap.put(notice, Integer.valueOf(state));
        }
    }
}
