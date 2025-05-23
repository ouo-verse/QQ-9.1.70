package com.tencent.mobileqq.guild.media.core;

import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0011\u0018\u0000 *2\u00020\u0001:\u0001\u0004B-\b\u0007\u0012\u0006\u0010\u000f\u001a\u00020\n\u0012\u0006\u0010\u0011\u001a\u00020\n\u0012\b\b\u0002\u0010\u0016\u001a\u00020\b\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0017\u00a2\u0006\u0004\b/\u00100J\u000e\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0000J\u0013\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\t\u001a\u00020\bH\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016R\u0017\u0010\u000f\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u0004\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0011\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\f\u001a\u0004\b\u0010\u0010\u000eR\u0017\u0010\u0016\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\u001b\u001a\u00020\u00178\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR$\u0010\u001f\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\n8\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b\u001d\u0010\f\u001a\u0004\b\u001e\u0010\u000eR$\u0010&\u001a\u0004\u0018\u00010 8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\r\u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\"\u0010)\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\"\u0010\u0013\u001a\u0004\b\u001d\u0010\u0015\"\u0004\b'\u0010(R\"\u0010-\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001e\u0010\f\u001a\u0004\b*\u0010\u000e\"\u0004\b+\u0010,R$\u0010.\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\b8\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b\u0019\u0010\u0013\u001a\u0004\b\u0012\u0010\u0015\u00a8\u00061"}, d2 = {"Lcom/tencent/mobileqq/guild/media/core/q;", "", "startParams", "", "a", "other", "", "equals", "", "hashCode", "", "toString", "Ljava/lang/String;", "f", "()Ljava/lang/String;", "guildId", "b", "channelId", "c", "I", "d", "()I", "from", "Lcom/tencent/mobileqq/guild/media/core/data/j;", "Lcom/tencent/mobileqq/guild/media/core/data/j;", "i", "()Lcom/tencent/mobileqq/guild/media/core/data/j;", "previewData", "<set-?>", "e", tl.h.F, "key", "Lcom/tencent/mobileqq/guild/jump/model/JumpGuildParam;", "Lcom/tencent/mobileqq/guild/jump/model/JumpGuildParam;", "g", "()Lcom/tencent/mobileqq/guild/jump/model/JumpGuildParam;", "l", "(Lcom/tencent/mobileqq/guild/jump/model/JumpGuildParam;)V", "jumpGuildParam", "k", "(I)V", "fromPreView", "j", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "(Ljava/lang/String;)V", "sourceType", "channelType", "<init>", "(Ljava/lang/String;Ljava/lang/String;ILcom/tencent/mobileqq/guild/media/core/data/j;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class q {

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String guildId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String channelId;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final int from;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.guild.media.core.data.j previewData;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String key;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private JumpGuildParam jumpGuildParam;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private int fromPreView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String sourceType;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private int channelType;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0007\u0010\bJ\b\u0010\u0003\u001a\u00020\u0002H\u0007R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0006\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/guild/media/core/q$a;", "", "Lcom/tencent/mobileqq/guild/media/core/q;", "a", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.media.core.q$a, reason: from kotlin metadata */
    /* loaded from: classes14.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        @NotNull
        public final q a() {
            return new q("", "", 0, null, 12, null);
        }

        Companion() {
        }
    }

    @JvmOverloads
    public q(@NotNull String guildId, @NotNull String channelId, int i3, @NotNull com.tencent.mobileqq.guild.media.core.data.j previewData) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        Intrinsics.checkNotNullParameter(previewData, "previewData");
        this.guildId = guildId;
        this.channelId = channelId;
        this.from = i3;
        this.previewData = previewData;
        String uuid = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(uuid, "randomUUID().toString()");
        this.key = uuid;
        this.sourceType = "";
        this.channelType = 2;
        if (guildId.length() > 0) {
            if (channelId.length() > 0) {
                IGProChannelInfo C = ch.C(MobileQQ.sMobileQQ.peekAppRuntime(), guildId, channelId);
                this.channelType = C != null ? C.getType() : 2;
            }
        }
    }

    public final void a(@NotNull q startParams) {
        Intrinsics.checkNotNullParameter(startParams, "startParams");
        this.key = startParams.key;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final String getChannelId() {
        return this.channelId;
    }

    /* renamed from: c, reason: from getter */
    public final int getChannelType() {
        return this.channelType;
    }

    /* renamed from: d, reason: from getter */
    public final int getFrom() {
        return this.from;
    }

    /* renamed from: e, reason: from getter */
    public final int getFromPreView() {
        return this.fromPreView;
    }

    public boolean equals(@Nullable Object other) {
        if (other instanceof q) {
            q qVar = (q) other;
            if (Intrinsics.areEqual(qVar.guildId, this.guildId) && Intrinsics.areEqual(qVar.channelId, this.channelId)) {
                return true;
            }
        }
        return false;
    }

    @NotNull
    /* renamed from: f, reason: from getter */
    public final String getGuildId() {
        return this.guildId;
    }

    @Nullable
    /* renamed from: g, reason: from getter */
    public final JumpGuildParam getJumpGuildParam() {
        return this.jumpGuildParam;
    }

    @NotNull
    /* renamed from: h, reason: from getter */
    public final String getKey() {
        return this.key;
    }

    public int hashCode() {
        return (this.guildId.hashCode() * 31) + this.channelId.hashCode();
    }

    @NotNull
    /* renamed from: i, reason: from getter */
    public final com.tencent.mobileqq.guild.media.core.data.j getPreviewData() {
        return this.previewData;
    }

    @NotNull
    /* renamed from: j, reason: from getter */
    public final String getSourceType() {
        return this.sourceType;
    }

    public final void k(int i3) {
        this.fromPreView = i3;
    }

    public final void l(@Nullable JumpGuildParam jumpGuildParam) {
        this.jumpGuildParam = jumpGuildParam;
    }

    public final void m(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.sourceType = str;
    }

    @NotNull
    public String toString() {
        return "MediaChannelStartParams[" + this.guildId + "]-[" + this.channelId + "]-[" + this.sourceType + "]";
    }

    public /* synthetic */ q(String str, String str2, int i3, com.tencent.mobileqq.guild.media.core.data.j jVar, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, (i16 & 4) != 0 ? 1 : i3, (i16 & 8) != 0 ? com.tencent.mobileqq.guild.media.core.data.j.INSTANCE.a() : jVar);
    }
}
