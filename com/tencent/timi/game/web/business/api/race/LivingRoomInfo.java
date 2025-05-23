package com.tencent.timi.game.web.business.api.race;

import com.tencent.mobileqq.qqlive.data.user.LiveUserInfo;
import com.tencent.qqmini.sdk.launcher.core.proxy.va.VirtualAppProxy;
import java.io.Serializable;
import jg4.b;
import jg4.h;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b \u0018\u00002\u00020\u0001B\u0007\b\u0016\u00a2\u0006\u0002\u0010\u0002B'\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u00a2\u0006\u0002\u0010\nR\u001a\u0010\u000b\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\r\"\u0004\b\u0011\u0010\u000fR\u001a\u0010\u0012\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\r\"\u0004\b\u0014\u0010\u000fR\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0019\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\r\"\u0004\b\u001b\u0010\u000fR\u001a\u0010\b\u001a\u00020\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001a\u0010\u001f\u001a\u00020\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u001c\"\u0004\b \u0010\u001eR\u001a\u0010!\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\r\"\u0004\b#\u0010\u000fR\u001a\u0010$\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\r\"\u0004\b&\u0010\u000fR\u001a\u0010\u0005\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\r\"\u0004\b(\u0010\u000f\u00a8\u0006)"}, d2 = {"Lcom/tencent/timi/game/web/business/api/race/LivingRoomInfo;", "Ljava/io/Serializable;", "()V", "anchorId", "", "roomId", VirtualAppProxy.KEY_GAME_ID, "", "isAnchor", "", "(Ljava/lang/String;Ljava/lang/String;IZ)V", "anchorHeadUrl", "getAnchorHeadUrl", "()Ljava/lang/String;", "setAnchorHeadUrl", "(Ljava/lang/String;)V", "getAnchorId", "setAnchorId", "anchorNick", "getAnchorNick", "setAnchorNick", "getGameId", "()I", "setGameId", "(I)V", "headUrl", "getHeadUrl", "setHeadUrl", "()Z", "setAnchor", "(Z)V", "isFromGuild", "setFromGuild", "liveUid", "getLiveUid", "setLiveUid", "nick", "getNick", "setNick", "getRoomId", "setRoomId", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes26.dex */
public final class LivingRoomInfo implements Serializable {

    @NotNull
    private String anchorHeadUrl;

    @NotNull
    private String anchorId;

    @NotNull
    private String anchorNick;
    private int gameId;

    @NotNull
    private String headUrl;
    private boolean isAnchor;
    private boolean isFromGuild;

    @NotNull
    private String liveUid;

    @NotNull
    private String nick;

    @NotNull
    private String roomId;

    public LivingRoomInfo() {
        this.anchorId = "";
        this.roomId = "";
        this.liveUid = "";
        this.nick = "";
        this.headUrl = "";
        this.anchorNick = "";
        this.anchorHeadUrl = "";
    }

    @NotNull
    public final String getAnchorHeadUrl() {
        return this.anchorHeadUrl;
    }

    @NotNull
    public final String getAnchorId() {
        return this.anchorId;
    }

    @NotNull
    public final String getAnchorNick() {
        return this.anchorNick;
    }

    public final int getGameId() {
        return this.gameId;
    }

    @NotNull
    public final String getHeadUrl() {
        return this.headUrl;
    }

    @NotNull
    public final String getLiveUid() {
        return this.liveUid;
    }

    @NotNull
    public final String getNick() {
        return this.nick;
    }

    @NotNull
    public final String getRoomId() {
        return this.roomId;
    }

    /* renamed from: isAnchor, reason: from getter */
    public final boolean getIsAnchor() {
        return this.isAnchor;
    }

    /* renamed from: isFromGuild, reason: from getter */
    public final boolean getIsFromGuild() {
        return this.isFromGuild;
    }

    public final void setAnchor(boolean z16) {
        this.isAnchor = z16;
    }

    public final void setAnchorHeadUrl(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.anchorHeadUrl = str;
    }

    public final void setAnchorId(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.anchorId = str;
    }

    public final void setAnchorNick(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.anchorNick = str;
    }

    public final void setFromGuild(boolean z16) {
        this.isFromGuild = z16;
    }

    public final void setGameId(int i3) {
        this.gameId = i3;
    }

    public final void setHeadUrl(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.headUrl = str;
    }

    public final void setLiveUid(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.liveUid = str;
    }

    public final void setNick(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.nick = str;
    }

    public final void setRoomId(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.roomId = str;
    }

    public LivingRoomInfo(@NotNull String anchorId, @NotNull String roomId, int i3, boolean z16) {
        Long longOrNull;
        Intrinsics.checkNotNullParameter(anchorId, "anchorId");
        Intrinsics.checkNotNullParameter(roomId, "roomId");
        this.liveUid = "";
        this.nick = "";
        this.headUrl = "";
        this.anchorNick = "";
        this.anchorHeadUrl = "";
        this.anchorId = anchorId;
        this.roomId = roomId;
        this.gameId = i3;
        this.isAnchor = z16;
        LiveUserInfo selfUserInfo = ((b) mm4.b.b(b.class)).getSelfUserInfo();
        if (selfUserInfo != null) {
            this.liveUid = String.valueOf(selfUserInfo.uid);
            String str = selfUserInfo.nick;
            Intrinsics.checkNotNullExpressionValue(str, "it.nick");
            this.nick = str;
            String str2 = selfUserInfo.headUrl;
            Intrinsics.checkNotNullExpressionValue(str2, "it.headUrl");
            this.headUrl = str2;
        }
        b bVar = (b) mm4.b.b(b.class);
        longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull(roomId);
        h n3 = bVar.n(longOrNull != null ? longOrNull.longValue() : 0L);
        if (n3 != null) {
            String str3 = n3.f409908b;
            Intrinsics.checkNotNullExpressionValue(str3, "it.nickName");
            this.anchorNick = str3;
            String str4 = n3.f409909c;
            Intrinsics.checkNotNullExpressionValue(str4, "it.headUrl");
            this.anchorHeadUrl = str4;
        }
    }
}
