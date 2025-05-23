package com.tencent.guild.api.impl;

import com.tencent.mobileqq.guild.mainframe.api.IGuildMainFrameApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import cr0.GuildActiveInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u0000 \u00062\u00020\u0001:\u0001\fB\u0007\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\b\u001a\u00020\u0007H\u0002J\u0010\u0010\t\u001a\u00020\u00072\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002J\u0006\u0010\u000b\u001a\u00020\nJ\b\u0010\f\u001a\u0004\u0018\u00010\u0002R\u0016\u0010\u000e\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u000f\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\r\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/guild/api/impl/a;", "", "Lcr0/a;", "sourceActiveInfo", "channelInfo", "", "c", "", "d", "e", "", "b", "a", "Lcr0/a;", "mfActiveInfo", "oneSelfActiveInfo", "<init>", "()V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private GuildActiveInfo mfActiveInfo = new GuildActiveInfo(null, 1, false, 5, null);

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private GuildActiveInfo oneSelfActiveInfo = new GuildActiveInfo(null, 2, false, 5, null);

    private final void c(GuildActiveInfo sourceActiveInfo, GuildActiveInfo channelInfo) {
        if (channelInfo.getBActive()) {
            sourceActiveInfo.e(true);
            sourceActiveInfo.f(channelInfo.getUniqueKey());
        } else if (Intrinsics.areEqual(channelInfo.getUniqueKey(), sourceActiveInfo.getUniqueKey())) {
            sourceActiveInfo.e(false);
            sourceActiveInfo.getUniqueKey().c();
        }
    }

    private final boolean d() {
        return ((IGuildMainFrameApi) QRoute.api(IGuildMainFrameApi.class)).isSplashActivityTop();
    }

    @Nullable
    public final GuildActiveInfo a() {
        if (!this.oneSelfActiveInfo.d() && this.oneSelfActiveInfo.getBActive()) {
            return this.oneSelfActiveInfo;
        }
        if (!this.mfActiveInfo.d() && this.mfActiveInfo.getBActive()) {
            return this.mfActiveInfo;
        }
        return null;
    }

    @NotNull
    public final String b() {
        GuildActiveInfo.UniqueKey uniqueKey;
        String id5;
        GuildActiveInfo a16 = a();
        if (a16 == null || (uniqueKey = a16.getUniqueKey()) == null || (id5 = uniqueKey.getId()) == null) {
            return "0";
        }
        return id5;
    }

    public final boolean e(@Nullable GuildActiveInfo channelInfo) {
        QLog.i("ChannelActiveStrategy", 1, "setActiveChannel channelInfo: " + channelInfo);
        if (channelInfo == null || (channelInfo.getBActive() && channelInfo.d())) {
            return false;
        }
        String b16 = b();
        int type = channelInfo.getType();
        if (type != 1) {
            if (type == 2) {
                c(this.oneSelfActiveInfo, channelInfo);
            }
        } else {
            c(this.mfActiveInfo, channelInfo);
            if (channelInfo.getBActive() && d()) {
                GuildActiveInfo guildActiveInfo = this.oneSelfActiveInfo;
                guildActiveInfo.e(false);
                guildActiveInfo.getUniqueKey().c();
            }
        }
        String b17 = b();
        QLog.i("ChannelActiveStrategy", 1, "setActiveChannel mf: " + this.mfActiveInfo + " oneSelf: " + this.oneSelfActiveInfo + " new: " + b17 + " bChange: " + (!Intrinsics.areEqual(b16, b17)));
        return !Intrinsics.areEqual(b16, b17);
    }
}
