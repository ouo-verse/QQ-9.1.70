package com.tencent.icgame.game.tim.api.message;

import com.tencent.icgame.trpc.yes.common.CommonOuterClass$QQUserId;
import com.tencent.icgame.trpc.yes.common.MessageOuterClass$MsgContent;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0005\u001a\u00020\u0004H&J\b\u0010\u0007\u001a\u00020\u0006H&J\b\u0010\t\u001a\u00020\bH&J\b\u0010\u000b\u001a\u00020\nH&J\b\u0010\r\u001a\u00020\fH&J\b\u0010\u000e\u001a\u00020\u0002H&J\b\u0010\u000f\u001a\u00020\bH&J\b\u0010\u0010\u001a\u00020\bH&J\b\u0010\u0012\u001a\u00020\u0011H&J\b\u0010\u0013\u001a\u00020\u0011H&J\n\u0010\u0014\u001a\u0004\u0018\u00010\u0001H&J\u0012\u0010\u0017\u001a\u00020\u00162\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001H&J\u0010\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\nH&\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/icgame/game/tim/api/message/a;", "", "", "id", "", "type", "Lcom/tencent/icgame/trpc/yes/common/CommonOuterClass$QQUserId;", "c", "", "time", "Lcom/tencent/icgame/game/tim/api/message/MsgStatus;", h.F, "Lcom/tencent/icgame/trpc/yes/common/MessageOuterClass$MsgContent;", "a", "g", "j", "f", "", "b", "i", "d", "data", "", "e", "status", "k", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes7.dex */
public interface a {
    @NotNull
    MessageOuterClass$MsgContent a();

    boolean b();

    @NotNull
    CommonOuterClass$QQUserId c();

    @Nullable
    Object d();

    void e(@Nullable Object data);

    long f();

    @NotNull
    String g();

    @NotNull
    MsgStatus h();

    boolean i();

    @NotNull
    String id();

    long j();

    void k(@NotNull MsgStatus status);

    long time();

    int type();
}
