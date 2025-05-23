package com.tencent.mobileqq.guild.mainframe.helper.jump;

import android.os.Bundle;
import com.tencent.mobileqq.guild.feed.api.IGuildFeedLauncherApi;
import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import com.tencent.mobileqq.guild.jump.model.extras.JumpGuildNoticeMsg;
import com.tencent.mobileqq.guild.mainframe.GuildAppReportSourceInfo;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import java.util.Iterator;
import kotlin.Function0;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u000b2\u00020\u0001:\u0001\u0005B\u0011\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\u0004\b\t\u0010\nJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016R\u0016\u0010\b\u001a\u0004\u0018\u00010\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0007\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/guild/mainframe/helper/jump/b;", "Lcom/tencent/mobileqq/guild/mainframe/helper/jump/c;", "Landroid/os/Bundle;", "extra", "", "a", "Lcom/tencent/mobileqq/guild/mainframe/i;", "Lcom/tencent/mobileqq/guild/mainframe/i;", "guildMainViewContext", "<init>", "(Lcom/tencent/mobileqq/guild/mainframe/i;)V", "b", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class b implements c {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final com.tencent.mobileqq.guild.mainframe.i guildMainViewContext;

    public b(@Nullable com.tencent.mobileqq.guild.mainframe.i iVar) {
        this.guildMainViewContext = iVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(b this$0, JumpGuildNoticeMsg jumpGuildNoticeMsg, GuildAppReportSourceInfo guildAppReportSourceInfo) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.guildMainViewContext.h(1, jumpGuildNoticeMsg.getGuildId(), guildAppReportSourceInfo);
    }

    @Override // com.tencent.mobileqq.guild.mainframe.helper.jump.c
    public void a(@Nullable Bundle extra) {
        if (this.guildMainViewContext == null) {
            Logger logger = Logger.f235387a;
            Logger.b bVar = new Logger.b();
            bVar.a().add("handleAction guildMainViewContext == null");
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("Guild.jump.GuildOpenNoticeMsgJumper", 1, (String) it.next(), null);
            }
            return;
        }
        if (extra != null && !extra.isEmpty()) {
            final JumpGuildNoticeMsg jumpGuildNoticeMsg = (JumpGuildNoticeMsg) extra.getParcelable(JumpGuildParam.EXTRA_JUMP_NOTICE_MSG);
            if (jumpGuildNoticeMsg == null) {
                Logger logger2 = Logger.f235387a;
                Logger.b bVar2 = new Logger.b();
                bVar2.a().add("handleAction jumpNoticeMsg is null");
                Iterator<T> it5 = bVar2.a().iterator();
                while (it5.hasNext()) {
                    Logger.f235387a.d().e("Guild.jump.GuildOpenNoticeMsgJumper", 1, (String) it5.next(), null);
                }
                return;
            }
            if (ch.L(jumpGuildNoticeMsg.getGuildId()) == null) {
                Logger logger3 = Logger.f235387a;
                Logger.b bVar3 = new Logger.b();
                String str = "handleAction guildInfoIsNull. jumpNoticeMsg:" + jumpGuildNoticeMsg;
                if (str instanceof String) {
                    bVar3.a().add(str);
                }
                Iterator<T> it6 = bVar3.a().iterator();
                while (it6.hasNext()) {
                    Logger.f235387a.d().e("Guild.jump.GuildOpenNoticeMsgJumper", 1, (String) it6.next(), null);
                }
                return;
            }
            final GuildAppReportSourceInfo guildAppReportSourceInfo = (GuildAppReportSourceInfo) extra.getParcelable("GuildAppReportSourceInfo");
            Logger.f235387a.d().i("Guild.jump.GuildOpenNoticeMsgJumper", 1, "handleAction jumpNoticeMsg:" + jumpGuildNoticeMsg + " sourceInfo:" + guildAppReportSourceInfo);
            if (guildAppReportSourceInfo != null) {
                this.guildMainViewContext.R(guildAppReportSourceInfo);
            }
            QRouteApi api = QRoute.api(IGuildFeedLauncherApi.class);
            Intrinsics.checkNotNullExpressionValue(api, "api(IGuildFeedLauncherApi::class.java)");
            IGuildFeedLauncherApi.a.b((IGuildFeedLauncherApi) api, jumpGuildNoticeMsg, 0, 2, null);
            Function0.b(100, new Runnable() { // from class: com.tencent.mobileqq.guild.mainframe.helper.jump.a
                @Override // java.lang.Runnable
                public final void run() {
                    b.c(b.this, jumpGuildNoticeMsg, guildAppReportSourceInfo);
                }
            });
            return;
        }
        Logger logger4 = Logger.f235387a;
        Logger.b bVar4 = new Logger.b();
        bVar4.a().add("handleAction extra isNullOrEmpty");
        Iterator<T> it7 = bVar4.a().iterator();
        while (it7.hasNext()) {
            Logger.f235387a.d().e("Guild.jump.GuildOpenNoticeMsgJumper", 1, (String) it7.next(), null);
        }
    }
}
