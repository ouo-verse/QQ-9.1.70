package com.tencent.mobileqq.guild.homev2.misc.logics;

import android.os.SystemClock;
import com.tencent.mobileqq.guild.base.extension.r;
import com.tencent.mobileqq.guild.base.repository.h;
import com.tencent.mobileqq.guild.rolegroup.model.data.RoleGroupListModel;
import com.tencent.mobileqq.guild.rolegroup.model.repositories.FetchRoleGroupParam;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import vh2.ak;
import vh2.aq;
import vh2.v;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0007\u0018\u0000 \u00152\u00020\u0001:\u0001\nB\u000f\u0012\u0006\u0010\u000e\u001a\u00020\t\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\t\u0010\b\u001a\u00020\u0006H\u0086\u0002R\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/guild/homev2/misc/logics/f;", "", "Lcom/tencent/mobileqq/qqguildsdk/api/IGPSService;", "gpsService", "", "guildId", "", "i", "f", "Lcom/tencent/mobileqq/guild/homev2/misc/d;", "a", "Lcom/tencent/mobileqq/guild/homev2/misc/d;", "e", "()Lcom/tencent/mobileqq/guild/homev2/misc/d;", "guildIdOwner", "", "b", "J", "lastRefreshRoleTime", "<init>", "(Lcom/tencent/mobileqq/guild/homev2/misc/d;)V", "c", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.guild.homev2.misc.d guildIdOwner;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private long lastRefreshRoleTime;

    public f(@NotNull com.tencent.mobileqq.guild.homev2.misc.d guildIdOwner) {
        Intrinsics.checkNotNullParameter(guildIdOwner, "guildIdOwner");
        this.guildIdOwner = guildIdOwner;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(ri1.a aVar, RoleGroupListModel roleGroupListModel) {
        Intrinsics.checkNotNullParameter(aVar, "<anonymous parameter 0>");
    }

    private final void i(final IGPSService gpsService, final String guildId) {
        if (SystemClock.uptimeMillis() - this.lastRefreshRoleTime < 5000) {
            return;
        }
        gpsService.fetchRoleList(guildId, 127, new aq() { // from class: com.tencent.mobileqq.guild.homev2.misc.logics.d
            @Override // vh2.aq
            public final void a(int i3, String str, List list, List list2) {
                f.j(IGPSService.this, guildId, i3, str, list, list2);
            }
        });
        this.lastRefreshRoleTime = SystemClock.uptimeMillis();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(IGPSService gpsService, String guildId, int i3, String str, List list, List list2) {
        Intrinsics.checkNotNullParameter(gpsService, "$gpsService");
        Intrinsics.checkNotNullParameter(guildId, "$guildId");
        gpsService.fetchMemberRoleList(guildId, "", gpsService.getSelfTinyId(), 101, new ak() { // from class: com.tencent.mobileqq.guild.homev2.misc.logics.e
            @Override // vh2.ak
            public final void a(int i16, String str2, List list3) {
                f.k(i16, str2, list3);
            }
        });
    }

    @NotNull
    /* renamed from: e, reason: from getter */
    public final com.tencent.mobileqq.guild.homev2.misc.d getGuildIdOwner() {
        return this.guildIdOwner;
    }

    public final void f() {
        Logger.f235387a.d().i("Guild.NewHome.PullRefreshLogic", 1, "pullRefreshLogic: " + getGuildIdOwner().getGuildId());
        String guildId = this.guildIdOwner.getGuildId();
        r rVar = r.f214743a;
        IRuntimeService S0 = ch.S0(IGPSService.class, "");
        Intrinsics.checkNotNullExpressionValue(S0, "runtimeService(T::class.java, process)");
        IGPSService iGPSService = (IGPSService) S0;
        iGPSService.refreshPollingData(guildId, 0);
        iGPSService.fetchGuildInfoWithSource(guildId, 1, new v() { // from class: com.tencent.mobileqq.guild.homev2.misc.logics.b
            @Override // vh2.v
            public final void a(int i3, String str, IGProGuildInfo iGProGuildInfo) {
                f.g(i3, str, iGProGuildInfo);
            }
        });
        com.tencent.mobileqq.guild.rolegroup.model.repositories.r.p().h(new FetchRoleGroupParam(guildId, null, false, 100, 6, null), new h() { // from class: com.tencent.mobileqq.guild.homev2.misc.logics.c
            @Override // com.tencent.mobileqq.guild.base.repository.h
            public final void a(ri1.a aVar, Object obj) {
                f.h(aVar, (RoleGroupListModel) obj);
            }
        });
        i(iGPSService, guildId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(int i3, String str, IGProGuildInfo iGProGuildInfo) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(int i3, String str, List list) {
    }
}
