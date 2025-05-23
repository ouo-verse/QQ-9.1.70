package com.tencent.mobileqq.guild.guildtab;

import androidx.annotation.UiThread;
import com.tencent.mobileqq.app.QMMKVFile;
import com.tencent.mobileqq.guild.api.IGuildDelayInitializeService;
import com.tencent.mobileqq.guild.api.IGuildUnreadEventApi;
import com.tencent.mobileqq.guild.base.repository.AccountChangedNotifier;
import com.tencent.mobileqq.guild.message.unread.UnreadInfo;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qroute.QRoute;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import tl.h;
import y02.d;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0003J\b\u0010\u0007\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0002H\u0002J\b\u0010\t\u001a\u00020\u0002H\u0002J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0016\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\nR\u0016\u0010\u0010\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010\u000fR\u0016\u0010\u0011\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010\u000fR\u0016\u0010\u0014\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0013R\u001a\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00040\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u0016\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/guild/guildtab/GuildTabRedLogic;", "Lcom/tencent/mobileqq/guild/base/repository/a;", "", "time", "", h.F, "j", "g", "f", "e", "", "account", "onAccountChanged", "from", "i", "J", "lastShowGrayRedTime", "lastClearGrayRedTime", "Lcom/tencent/mobileqq/guild/message/unread/UnreadInfo$a;", "Lcom/tencent/mobileqq/guild/message/unread/UnreadInfo$a;", "countInfo", "Lkotlin/Function0;", "Lkotlin/jvm/functions/Function0;", "mGuildTabUnreadCallback", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildTabRedLogic implements com.tencent.mobileqq.guild.base.repository.a {

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public static final GuildTabRedLogic f224628d;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private static long lastShowGrayRedTime;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private static long lastClearGrayRedTime;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static UnreadInfo.a countInfo;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Function0<Unit> mGuildTabUnreadCallback;

    static {
        GuildTabRedLogic guildTabRedLogic = new GuildTabRedLogic();
        f224628d = guildTabRedLogic;
        countInfo = new UnreadInfo.a(false, 0, 0, 7, null);
        GuildTabRedLogic$mGuildTabUnreadCallback$1 guildTabRedLogic$mGuildTabUnreadCallback$1 = GuildTabRedLogic$mGuildTabUnreadCallback$1.INSTANCE;
        mGuildTabUnreadCallback = guildTabRedLogic$mGuildTabUnreadCallback$1;
        AccountChangedNotifier.f214789d.a(guildTabRedLogic);
        ((IGuildUnreadEventApi) QRoute.api(IGuildUnreadEventApi.class)).addEventListener(guildTabRedLogic$mGuildTabUnreadCallback$1);
        guildTabRedLogic.g();
    }

    GuildTabRedLogic() {
    }

    private final long e() {
        MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, QMMKVFile.FILE_GUILD);
        Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.sMobileQQ, QMMKVFile.FILE_GUILD)");
        return from.decodeLong(ch.g() + "key_guild_tab_gray_red_clear_time", 0L);
    }

    private final long f() {
        MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, QMMKVFile.FILE_GUILD);
        Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.sMobileQQ, QMMKVFile.FILE_GUILD)");
        return from.decodeLong(ch.g() + "key_guild_tab_gray_red_show_time", 0L);
    }

    private final void g() {
        lastShowGrayRedTime = f();
        lastClearGrayRedTime = e();
        Logger.f235387a.d().i("Guild.tab.GuildTabRedLogic", 1, "initFromMMKV lastShowGrayRedTime=" + lastShowGrayRedTime + " lastClearGrayRedTime=" + lastClearGrayRedTime);
    }

    private final void h(long time) {
        lastClearGrayRedTime = time;
        MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, QMMKVFile.FILE_GUILD);
        Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.sMobileQQ, QMMKVFile.FILE_GUILD)");
        from.encodeLong(ch.g() + "key_guild_tab_gray_red_clear_time", time);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @UiThread
    public final void j() {
        UnreadInfo.a guildTabUnreadCountSafely = ((IGuildDelayInitializeService) ch.R0(IGuildDelayInitializeService.class)).getGuildTabUnreadCountSafely();
        if (countInfo.getCount() > 0 && guildTabUnreadCountSafely.getCount() == 0 && lastShowGrayRedTime != 0) {
            long currentTimeMillis = System.currentTimeMillis();
            h(currentTimeMillis);
            Logger.f235387a.d().i("Guild.tab.GuildTabRedLogic", 1, "setGuildTabGrayRedClearTime =" + currentTimeMillis + " lastShowGrayRedTime=" + lastShowGrayRedTime + " oldCount=" + countInfo + " newCount=" + guildTabUnreadCountSafely);
            i(0L, "clear red");
        }
        countInfo = guildTabUnreadCountSafely;
    }

    public final void i(long time, @NotNull String from) {
        Intrinsics.checkNotNullParameter(from, "from");
        if (d.a() <= 0) {
            return;
        }
        lastShowGrayRedTime = time;
        MMKVOptionEntity from2 = QMMKV.from(MobileQQ.sMobileQQ, QMMKVFile.FILE_GUILD);
        Intrinsics.checkNotNullExpressionValue(from2, "from(MobileQQ.sMobileQQ, QMMKVFile.FILE_GUILD)");
        from2.encodeLong(ch.g() + "key_guild_tab_gray_red_show_time", time);
        Logger.f235387a.d().i("Guild.tab.GuildTabRedLogic", 1, "setGuildTabWeakRedPointShowTime=" + time + " by=" + from);
    }

    @Override // com.tencent.mobileqq.guild.base.repository.a
    public void onAccountChanged(@NotNull String account) {
        Intrinsics.checkNotNullParameter(account, "account");
        g();
    }
}
