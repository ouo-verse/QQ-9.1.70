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
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\n\u0018\u0000 \u000b2\u00020\u0001:\u0001\u0003B\u0007\u00a2\u0006\u0004\b\u0016\u0010\u0017J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002H\u0002J\b\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\u000b\u001a\u00020\b2\b\u0010\n\u001a\u0004\u0018\u00010\u0002J\u0006\u0010\r\u001a\u00020\fJ\u000e\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000eR\u0016\u0010\u000f\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0011R\u0016\u0010\u0013\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010\u0012R\u0016\u0010\u0014\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0012R\u0016\u0010\u0015\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0012\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/guild/api/impl/b;", "", "Lcr0/a;", "a", "sourceActiveInfo", "channelInfo", "", "c", "", "d", "guildInfo", "e", "", "b", "", "activeTab", "f", "I", "Lcr0/a;", "mfActiveInfo", "oneSelfActiveInfo", "recentChatActiveInfo", "<init>", "()V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private int activeTab = 2;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private GuildActiveInfo mfActiveInfo = new GuildActiveInfo(null, 1, false, 5, null);

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private GuildActiveInfo oneSelfActiveInfo = new GuildActiveInfo(null, 2, false, 5, null);

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private GuildActiveInfo recentChatActiveInfo = new GuildActiveInfo(null, 3, false, 5, null);

    private final GuildActiveInfo a() {
        if (!this.oneSelfActiveInfo.d() && this.oneSelfActiveInfo.getBActive()) {
            return this.oneSelfActiveInfo;
        }
        if (this.activeTab == 1 && !this.mfActiveInfo.d() && this.mfActiveInfo.getBActive()) {
            return this.mfActiveInfo;
        }
        if (this.activeTab == 2 && !this.recentChatActiveInfo.d() && this.recentChatActiveInfo.getBActive()) {
            return this.recentChatActiveInfo;
        }
        return null;
    }

    private final void c(GuildActiveInfo sourceActiveInfo, GuildActiveInfo channelInfo) {
        if (channelInfo.getBActive()) {
            sourceActiveInfo.e(true);
            sourceActiveInfo.f(channelInfo.getUniqueKey());
        } else if (Intrinsics.areEqual(channelInfo.getUniqueKey(), sourceActiveInfo.getUniqueKey()) || channelInfo.getType() == 3) {
            sourceActiveInfo.e(false);
            sourceActiveInfo.getUniqueKey().c();
        }
    }

    private final boolean d() {
        return ((IGuildMainFrameApi) QRoute.api(IGuildMainFrameApi.class)).isSplashActivityTop();
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

    public final boolean e(@Nullable GuildActiveInfo guildInfo) {
        QLog.i("GuildActiveStrategy", 1, "setActiveGuild guildInfo: " + guildInfo);
        if (guildInfo == null || (guildInfo.getBActive() && guildInfo.d())) {
            return false;
        }
        String b16 = b();
        int type = guildInfo.getType();
        if (type != 1) {
            if (type != 2) {
                if (type == 3) {
                    c(this.recentChatActiveInfo, guildInfo);
                    if (guildInfo.getBActive() && d()) {
                        GuildActiveInfo guildActiveInfo = this.oneSelfActiveInfo;
                        guildActiveInfo.e(false);
                        guildActiveInfo.getUniqueKey().c();
                    }
                }
            } else {
                c(this.oneSelfActiveInfo, guildInfo);
            }
        } else {
            c(this.mfActiveInfo, guildInfo);
            if (guildInfo.getBActive() && d()) {
                GuildActiveInfo guildActiveInfo2 = this.oneSelfActiveInfo;
                guildActiveInfo2.e(false);
                guildActiveInfo2.getUniqueKey().c();
            }
        }
        String b17 = b();
        QLog.i("GuildActiveStrategy", 1, "setActiveGuild mf: " + this.mfActiveInfo + " oneSelf: " + this.oneSelfActiveInfo + " recentChatActiveInfo: " + this.recentChatActiveInfo + " new: " + b17 + " bChange: " + (!Intrinsics.areEqual(b16, b17)));
        return !Intrinsics.areEqual(b16, b17);
    }

    public final void f(int activeTab) {
        if (this.activeTab != activeTab) {
            this.activeTab = activeTab;
        }
    }
}
