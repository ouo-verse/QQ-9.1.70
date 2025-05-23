package com.tencent.gamecenter.wadl.distribute.data;

import com.tencent.mobileqq.activity.QQBrowserActivity;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t\u00a2\u0006\u0002\u0010\u000bJ\t\u0010\u0018\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0019\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u001a\u001a\u00020\u0007H\u00c6\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\tH\u00c6\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\tH\u00c6\u0003J?\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\tH\u00c6\u0001J\u0013\u0010\u001e\u001a\u00020\u00072\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0096\u0002J\b\u0010!\u001a\u00020\"H\u0016J\b\u0010#\u001a\u00020\u0003H\u0016R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\n\u001a\u0004\u0018\u00010\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0011\"\u0004\b\u0017\u0010\u0013\u00a8\u0006$"}, d2 = {"Lcom/tencent/gamecenter/wadl/distribute/data/GameDistributeInfo;", "Ljava/io/Serializable;", "guildId", "", "buffer", "", "bufferFromCache", "", "guildUIColor", "Lorg/json/JSONObject;", QQBrowserActivity.APP_PARAM, "(Ljava/lang/String;[BZLorg/json/JSONObject;Lorg/json/JSONObject;)V", "getBuffer", "()[B", "getBufferFromCache", "()Z", "getExtraParams", "()Lorg/json/JSONObject;", "setExtraParams", "(Lorg/json/JSONObject;)V", "getGuildId", "()Ljava/lang/String;", "getGuildUIColor", "setGuildUIColor", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "", "hashCode", "", "toString", "qqgamedownloader-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes6.dex */
public final /* data */ class GameDistributeInfo implements Serializable {

    @NotNull
    private final byte[] buffer;
    private final boolean bufferFromCache;

    @Nullable
    private JSONObject extraParams;

    @NotNull
    private final String guildId;

    @Nullable
    private JSONObject guildUIColor;

    public GameDistributeInfo(@NotNull String guildId, @NotNull byte[] buffer, boolean z16, @Nullable JSONObject jSONObject, @Nullable JSONObject jSONObject2) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        this.guildId = guildId;
        this.buffer = buffer;
        this.bufferFromCache = z16;
        this.guildUIColor = jSONObject;
        this.extraParams = jSONObject2;
    }

    public static /* synthetic */ GameDistributeInfo copy$default(GameDistributeInfo gameDistributeInfo, String str, byte[] bArr, boolean z16, JSONObject jSONObject, JSONObject jSONObject2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = gameDistributeInfo.guildId;
        }
        if ((i3 & 2) != 0) {
            bArr = gameDistributeInfo.buffer;
        }
        byte[] bArr2 = bArr;
        if ((i3 & 4) != 0) {
            z16 = gameDistributeInfo.bufferFromCache;
        }
        boolean z17 = z16;
        if ((i3 & 8) != 0) {
            jSONObject = gameDistributeInfo.guildUIColor;
        }
        JSONObject jSONObject3 = jSONObject;
        if ((i3 & 16) != 0) {
            jSONObject2 = gameDistributeInfo.extraParams;
        }
        return gameDistributeInfo.copy(str, bArr2, z17, jSONObject3, jSONObject2);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final String getGuildId() {
        return this.guildId;
    }

    @NotNull
    /* renamed from: component2, reason: from getter */
    public final byte[] getBuffer() {
        return this.buffer;
    }

    /* renamed from: component3, reason: from getter */
    public final boolean getBufferFromCache() {
        return this.bufferFromCache;
    }

    @Nullable
    /* renamed from: component4, reason: from getter */
    public final JSONObject getGuildUIColor() {
        return this.guildUIColor;
    }

    @Nullable
    /* renamed from: component5, reason: from getter */
    public final JSONObject getExtraParams() {
        return this.extraParams;
    }

    @NotNull
    public final GameDistributeInfo copy(@NotNull String guildId, @NotNull byte[] buffer, boolean bufferFromCache, @Nullable JSONObject guildUIColor, @Nullable JSONObject extraParams) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        return new GameDistributeInfo(guildId, buffer, bufferFromCache, guildUIColor, extraParams);
    }

    public boolean equals(@Nullable Object other) {
        Class<?> cls;
        if (this == other) {
            return true;
        }
        if (other != null) {
            cls = other.getClass();
        } else {
            cls = null;
        }
        if (!Intrinsics.areEqual(GameDistributeInfo.class, cls)) {
            return false;
        }
        Intrinsics.checkNotNull(other, "null cannot be cast to non-null type com.tencent.gamecenter.wadl.distribute.data.GameDistributeInfo");
        GameDistributeInfo gameDistributeInfo = (GameDistributeInfo) other;
        if (Intrinsics.areEqual(this.guildId, gameDistributeInfo.guildId) && Arrays.equals(this.buffer, gameDistributeInfo.buffer) && this.bufferFromCache == gameDistributeInfo.bufferFromCache && Intrinsics.areEqual(this.guildUIColor, gameDistributeInfo.guildUIColor) && Intrinsics.areEqual(this.extraParams, gameDistributeInfo.extraParams)) {
            return true;
        }
        return false;
    }

    @NotNull
    public final byte[] getBuffer() {
        return this.buffer;
    }

    public final boolean getBufferFromCache() {
        return this.bufferFromCache;
    }

    @Nullable
    public final JSONObject getExtraParams() {
        return this.extraParams;
    }

    @NotNull
    public final String getGuildId() {
        return this.guildId;
    }

    @Nullable
    public final JSONObject getGuildUIColor() {
        return this.guildUIColor;
    }

    public int hashCode() {
        return (((this.guildId.hashCode() * 31) + Arrays.hashCode(this.buffer)) * 31) + com.tencent.aio.widget.textView.param.a.a(this.bufferFromCache);
    }

    public final void setExtraParams(@Nullable JSONObject jSONObject) {
        this.extraParams = jSONObject;
    }

    public final void setGuildUIColor(@Nullable JSONObject jSONObject) {
        this.guildUIColor = jSONObject;
    }

    @NotNull
    public String toString() {
        String str = this.guildId;
        boolean z16 = this.bufferFromCache;
        byte[] bArr = this.buffer;
        Charset UTF_8 = StandardCharsets.UTF_8;
        Intrinsics.checkNotNullExpressionValue(UTF_8, "UTF_8");
        return "GameDistributeInfo(guildId=" + str + ",bufferFromCache=" + z16 + ",bufferStr=" + new String(bArr, UTF_8) + ")";
    }

    public /* synthetic */ GameDistributeInfo(String str, byte[] bArr, boolean z16, JSONObject jSONObject, JSONObject jSONObject2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, bArr, z16, (i3 & 8) != 0 ? null : jSONObject, (i3 & 16) != 0 ? null : jSONObject2);
    }
}
