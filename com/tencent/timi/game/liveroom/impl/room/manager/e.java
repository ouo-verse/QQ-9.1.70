package com.tencent.timi.game.liveroom.impl.room.manager;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.qqlive.common.api.AegisLogger;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0006\u0018\u0000 \u000b2\u00020\u0001:\u0001\u0012B\u0007\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\b\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J*\u0010\u000b\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0002J*\u0010\f\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\u0002J\u001e\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0002J\u0016\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\rR\u001a\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00020\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/timi/game/liveroom/impl/room/manager/e;", "", "", "roomId", "", "e", "", "nick", "c", "speakId", "anchorId", "b", "d", "", "g", "hideNick", "f", "", "a", "Ljava/util/List;", "needHideRoomNickNameList", "<init>", "()V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class e {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    private static final e f377931c = new e();

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<Long> needHideRoomNickNameList = new ArrayList();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\b\u001a\u00020\u00078\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\b\u0010\t\u00a8\u0006\f"}, d2 = {"Lcom/tencent/timi/game/liveroom/impl/room/manager/e$a;", "", "Lcom/tencent/timi/game/liveroom/impl/room/manager/e;", WadlProxyConsts.LOAD_CONFIG_FROM_INSTANCE, "Lcom/tencent/timi/game/liveroom/impl/room/manager/e;", "a", "()Lcom/tencent/timi/game/liveroom/impl/room/manager/e;", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.timi.game.liveroom.impl.room.manager.e$a, reason: from kotlin metadata */
    /* loaded from: classes26.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final e a() {
            return e.f377931c;
        }

        Companion() {
        }
    }

    private final String c(String nick) {
        int i3;
        boolean z16;
        if (nick != null) {
            i3 = nick.length();
        } else {
            i3 = 0;
        }
        if (nick != null && i3 != 0) {
            boolean z17 = true;
            if (1 <= i3 && i3 < 3) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                return ((Object) nick.subSequence(0, 1)) + "**";
            }
            if (3 > i3 || i3 >= 5) {
                z17 = false;
            }
            if (z17) {
                return ((Object) nick.subSequence(0, 2)) + "**";
            }
            return ((Object) nick.subSequence(0, 3)) + "**";
        }
        return "";
    }

    private final void e(long roomId) {
        if (!this.needHideRoomNickNameList.contains(Long.valueOf(roomId))) {
            this.needHideRoomNickNameList.add(Long.valueOf(roomId));
            AegisLogger.Companion companion = AegisLogger.INSTANCE;
            if (companion.isColorLevel()) {
                companion.i("Audience|nickname_module|RoomNickNameManager", "addHideNickNameRoomId... roomId:" + roomId);
            }
        }
    }

    @Nullable
    public final String b(long roomId, @Nullable String nick, long speakId, long anchorId) {
        if (g(roomId, speakId, anchorId)) {
            String c16 = c(nick);
            AegisLogger.INSTANCE.d("Audience|nickname_module|RoomNickNameManager", "acquireSimplifyNick... " + nick + " to " + c16);
            return c16;
        }
        return nick;
    }

    @NotNull
    public final String d(long roomId, @Nullable String nick, long speakId, long anchorId) {
        String b16 = d.INSTANCE.a().b(roomId, nick);
        if (Intrinsics.areEqual(b16, nick)) {
            b16 = b(roomId, nick, speakId, anchorId);
        }
        if (b16 == null) {
            return "";
        }
        return b16;
    }

    public final void f(long roomId, boolean hideNick) {
        if (hideNick) {
            e(roomId);
            return;
        }
        if (this.needHideRoomNickNameList.contains(Long.valueOf(roomId))) {
            this.needHideRoomNickNameList.remove(Long.valueOf(roomId));
            AegisLogger.Companion companion = AegisLogger.INSTANCE;
            if (companion.isColorLevel()) {
                companion.i("Audience|nickname_module|RoomNickNameManager", "addHideNickNameRoomId... remove roomId:" + roomId);
            }
        }
    }

    public final boolean g(long roomId, long speakId, long anchorId) {
        long G = com.tencent.mobileqq.qqlive.sail.c.f272176a.G();
        if (G == anchorId) {
            AegisLogger.INSTANCE.d("Audience|nickname_module|RoomNickNameManager", "acquireSimplifyNick... selfUserInfo.uid:" + G);
            return false;
        }
        if (G == speakId || speakId == anchorId) {
            return false;
        }
        return this.needHideRoomNickNameList.contains(Long.valueOf(roomId));
    }
}
