package com.tencent.mobileqq.guild.discover.recommend.miniapp;

import android.os.Bundle;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.mainframe.GuildMainFrameConstants;
import com.tencent.mobileqq.guild.mainframe.api.IGuildMainFrameApi;
import com.tencent.mobileqq.guild.mainframe.w;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProSecurityResult;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.util.QQToastUtil;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0007\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J \u0010\f\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0002J0\u0010\u0012\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\bH\u0002J&\u0010\u0014\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\b\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/guild/discover/recommend/miniapp/c;", "", "Ljava/lang/Runnable;", "block", "", tl.h.F, "Lcom/tencent/mobileqq/qqguildsdk/api/IGPSService;", "service", "", "guildId", "tinyId", "Lcom/tencent/mobileqq/qqguildsdk/data/i;", "c", "channelId", "", "memberType", "c2cNickName", "pginSource", "d", "c2cTinyId", "e", "<init>", "()V", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class c {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/guild/discover/recommend/miniapp/c$b", "Lcom/tencent/mobileqq/guild/mainframe/w;", "", "onSuccess", "", "code", "", "msg", "onFailed", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class b implements w {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Runnable f216524a;

        b(Runnable runnable) {
            this.f216524a = runnable;
        }

        @Override // com.tencent.mobileqq.guild.mainframe.w
        public void onFailed(int code, @Nullable String msg2) {
            Logger logger = Logger.f235387a;
            Logger.b bVar = new Logger.b();
            String str = "requestOpenGuildTab failed " + code + " " + msg2;
            if (str instanceof String) {
                bVar.a().add(str);
            }
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("Guild.jump.GuildDiscoverJumpC2CHelper", 1, (String) it.next(), null);
            }
        }

        @Override // com.tencent.mobileqq.guild.mainframe.w
        public void onSuccess() {
            Logger.f235387a.d().i("Guild.jump.GuildDiscoverJumpC2CHelper", 1, "requestOpenGuildTab succ");
            this.f216524a.run();
        }
    }

    private final com.tencent.mobileqq.qqguildsdk.data.i c(IGPSService service, String guildId, String tinyId) {
        com.tencent.mobileqq.qqguildsdk.data.i iVar = new com.tencent.mobileqq.qqguildsdk.data.i();
        iVar.f266704b = guildId;
        iVar.f266703a = tinyId;
        iVar.f266707e = service.getGuildUserDisplayName(guildId, tinyId);
        iVar.f266706d = service.getGuildUserDisplayName(guildId, tinyId);
        IGProGuildInfo guildInfo = service.getGuildInfo(guildId);
        if (guildInfo != null) {
            iVar.f266705c = guildInfo.getGuildName();
        }
        Logger.f235387a.d().i("Guild.jump.GuildDiscoverJumpC2CHelper", 1, "createInfo.toString()");
        return iVar;
    }

    private final void d(String guildId, String channelId, int memberType, String c2cNickName, String pginSource) {
        int i3;
        Logger.f235387a.d().i("Guild.jump.GuildDiscoverJumpC2CHelper", 1, "doJump2C2C guildId:" + guildId + " channelId:" + channelId + " c2cNickName:" + c2cNickName + " pginSource:" + pginSource);
        Bundle bundle = new Bundle();
        bundle.putBoolean("BUNDLE_KEY_IS_AIO", false);
        bundle.putInt("BUNDLE_KEY_TARGET_ITEM_TYPE", 4);
        bundle.putString("BUNDLE_KEY_TARGET_ITEM_KEY", guildId);
        bundle.putInt("BUNDLE_KEY_TARGET_INBOX_TYPE", 0);
        bundle.putString("BUNDLE_KEY_TARGET_INBOX_KEY", guildId);
        bundle.putString("channelId", channelId);
        bundle.putInt("peerMemberType", memberType);
        bundle.putString("c2cNickName", c2cNickName);
        bundle.putBoolean("BUNDLE_KEY_NEED_OPEN_CENTER_PANEL", true);
        bundle.putString("sgrp_stream_pgin_source_name", pginSource);
        if (d12.a.c()) {
            i3 = GuildMainFrameConstants.f227277u;
        } else {
            i3 = GuildMainFrameConstants.f227281y;
        }
        ((IGuildMainFrameApi) QRoute.api(IGuildMainFrameApi.class)).gotoGuildTab(ch.i(), i3, bundle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(final c this$0, String guildId, String c2cTinyId, final String c2cNickName, final String pginSource) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(guildId, "$guildId");
        Intrinsics.checkNotNullParameter(c2cTinyId, "$c2cTinyId");
        Intrinsics.checkNotNullParameter(c2cNickName, "$c2cNickName");
        Intrinsics.checkNotNullParameter(pginSource, "$pginSource");
        IGPSService service = (IGPSService) ch.R0(IGPSService.class);
        Intrinsics.checkNotNullExpressionValue(service, "service");
        service.createDirectMsgSession(this$0.c(service, guildId, c2cTinyId), new vh2.h() { // from class: com.tencent.mobileqq.guild.discover.recommend.miniapp.b
            @Override // vh2.h
            public final void a(int i3, String str, IGProSecurityResult iGProSecurityResult, boolean z16, com.tencent.mobileqq.qqguildsdk.data.k kVar) {
                c.g(c.this, c2cNickName, pginSource, i3, str, iGProSecurityResult, z16, kVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(c this$0, String c2cNickName, String pginSource, int i3, String str, IGProSecurityResult iGProSecurityResult, boolean z16, com.tencent.mobileqq.qqguildsdk.data.k session) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(c2cNickName, "$c2cNickName");
        Intrinsics.checkNotNullParameter(pginSource, "$pginSource");
        Intrinsics.checkNotNullParameter(session, "session");
        if (i3 == 0 && ch.p(iGProSecurityResult) && !z16) {
            String b16 = session.b();
            Intrinsics.checkNotNullExpressionValue(b16, "session.guildId");
            String a16 = session.a();
            Intrinsics.checkNotNullExpressionValue(a16, "session.channelId");
            this$0.d(b16, a16, session.e(), c2cNickName, pginSource);
            return;
        }
        if (i3 != 66000 && i3 != 66009) {
            QQToastUtil.showQQToast(1, R.string.f147310wj);
        } else {
            QQToastUtil.showQQToast(1, R.string.f146650ur);
        }
        Logger logger = Logger.f235387a;
        Logger.b bVar = new Logger.b();
        String str2 = "createDirectMsgSession network error code:" + i3 + " message: " + str + " security:" + iGProSecurityResult;
        if (str2 instanceof String) {
            bVar.a().add(str2);
        }
        Iterator<T> it = bVar.a().iterator();
        while (it.hasNext()) {
            Logger.f235387a.d().e("Guild.jump.GuildDiscoverJumpC2CHelper", 1, (String) it.next(), null);
        }
    }

    private final void h(Runnable block) {
        zr1.d.f("share", new b(block));
    }

    public final void e(@NotNull final String guildId, @NotNull final String c2cTinyId, @NotNull final String c2cNickName, @NotNull final String pginSource) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(c2cTinyId, "c2cTinyId");
        Intrinsics.checkNotNullParameter(c2cNickName, "c2cNickName");
        Intrinsics.checkNotNullParameter(pginSource, "pginSource");
        h(new Runnable() { // from class: com.tencent.mobileqq.guild.discover.recommend.miniapp.a
            @Override // java.lang.Runnable
            public final void run() {
                c.f(c.this, guildId, c2cTinyId, c2cNickName, pginSource);
            }
        });
    }
}
