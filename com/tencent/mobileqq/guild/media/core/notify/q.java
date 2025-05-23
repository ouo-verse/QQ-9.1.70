package com.tencent.mobileqq.guild.media.core.notify;

import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelUserNum;
import com.tencent.mobileqq.transfile.dns.DomainData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\r\b&\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b%\u0010&J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0018\u0010\r\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u0010\u0010\u0010\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J\u0012\u0010\u0013\u001a\u00020\b2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016J\u0012\u0010\u0014\u001a\u00020\b2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016J\u0012\u0010\u0015\u001a\u00020\b2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016J\u0012\u0010\u0016\u001a\u00020\b2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016J\u0012\u0010\u0017\u001a\u00020\b2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016J\b\u0010\u0018\u001a\u00020\bH\u0016J\u001c\u0010\u001c\u001a\u00020\b2\b\u0010\u0019\u001a\u0004\u0018\u00010\u000b2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0016J\b\u0010\u001d\u001a\u00020\bH\u0016J\b\u0010\u001e\u001a\u00020\bH\u0016J\u0012\u0010 \u001a\u00020\b2\b\u0010\u001f\u001a\u0004\u0018\u00010\u000bH\u0016J \u0010$\u001a\u00020\b2\u0006\u0010!\u001a\u00020\u000b2\u0006\u0010\"\u001a\u00020\u000b2\u0006\u0010#\u001a\u00020\u000bH\u0016\u00a8\u0006'"}, d2 = {"Lcom/tencent/mobileqq/guild/media/core/notify/q;", "", "", "type", "", "isSuccess", "Lcom/tencent/mobileqq/guild/media/core/data/i;", "data", "", "f", "roleType", "", "authMeta", "d", "Lcom/tencent/mobileqq/guild/media/core/data/h;", "visitorInfo", DomainData.DOMAIN_NAME, "Lcom/tencent/mobileqq/qqguildsdk/data/IGProChannelInfo;", "channelInfo", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "k", "g", tl.h.F, "e", "a", "from", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProChannelUserNum;", "channelNumber", "j", "i", "b", "action", "l", "guildId", "channelId", "newAuthMeta", "c", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public abstract class q {
    public void c(@NotNull String guildId, @NotNull String channelId, @NotNull String newAuthMeta) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        Intrinsics.checkNotNullParameter(newAuthMeta, "newAuthMeta");
    }

    public void d(int roleType, @NotNull String authMeta) {
        Intrinsics.checkNotNullParameter(authMeta, "authMeta");
    }

    public void f(int type, boolean isSuccess, @NotNull com.tencent.mobileqq.guild.media.core.data.i data) {
        Intrinsics.checkNotNullParameter(data, "data");
    }

    public void n(@NotNull com.tencent.mobileqq.guild.media.core.data.h visitorInfo) {
        Intrinsics.checkNotNullParameter(visitorInfo, "visitorInfo");
    }

    public void a() {
    }

    public void b() {
    }

    public void i() {
    }

    public void e(@Nullable IGProChannelInfo channelInfo) {
    }

    public void g(@Nullable IGProChannelInfo channelInfo) {
    }

    public void h(@Nullable IGProChannelInfo channelInfo) {
    }

    public void k(@Nullable IGProChannelInfo channelInfo) {
    }

    public void l(@Nullable String action) {
    }

    public void m(@Nullable IGProChannelInfo channelInfo) {
    }

    public void j(@Nullable String from, @Nullable IGProChannelUserNum channelNumber) {
    }
}
