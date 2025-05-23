package d12;

import android.content.Context;
import android.os.Parcelable;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.filebrowser.IFileBrowserService;
import com.tencent.mobileqq.guild.base.extension.MiscKt;
import com.tencent.mobileqq.guild.feed.api.IGuildFeedLauncherApi;
import com.tencent.mobileqq.guild.guildtab.IGuildUserService;
import com.tencent.mobileqq.guild.home.fragments.eventbus.GuildHomeDialogEvent;
import com.tencent.mobileqq.guild.homev2.fragments.GuildHomeV2Fragment;
import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import com.tencent.mobileqq.guild.jump.model.extras.JumpGuildNoticeMsg;
import com.tencent.mobileqq.guild.mainframe.manager.GuildOpenRecordManager;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.at;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqnt.kernel.nativeinterface.GuildMsgAbFlag;
import com.tencent.util.QQToastUtil;
import java.util.Iterator;
import kotlin.ExceptionsKt__ExceptionsKt;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\b\u0010\u0003\u001a\u00020\u0002H\u0007J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0007J\u0018\u0010\n\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\r\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u0006H\u0002\u00a8\u0006\u0010"}, d2 = {"Ld12/a;", "", "", "c", "Landroid/content/Context;", "context", "Lcom/tencent/mobileqq/guild/jump/model/JumpGuildParam;", "jumpGuildParam", "", "d", "e", "a", "param", "b", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f392649a = new a();

    a() {
    }

    private final boolean a(JumpGuildParam jumpGuildParam) {
        QBaseActivity qBaseActivity;
        GuildHomeDialogEvent guildHomeDialogEvent;
        String string = jumpGuildParam.extras.getString("param_first_show_text");
        if (MiscKt.f(string) || (qBaseActivity = QBaseActivity.sTopActivity) == null) {
            return false;
        }
        Logger logger = Logger.f235387a;
        logger.d().d("Guild.jump.GuildFeedsHomeJumpUtils", 1, "checkDialogTipsShow isResume:" + qBaseActivity.isResume());
        if (!qBaseActivity.isResume() || !Intrinsics.areEqual(GuildOpenRecordManager.f227480a.c(qBaseActivity), jumpGuildParam.guildId)) {
            return false;
        }
        SimpleEventBus simpleEventBus = SimpleEventBus.getInstance();
        if (string != null) {
            guildHomeDialogEvent = new GuildHomeDialogEvent(string);
        } else {
            guildHomeDialogEvent = null;
        }
        simpleEventBus.dispatchEvent(guildHomeDialogEvent);
        logger.d().d("Guild.jump.GuildFeedsHomeJumpUtils", 1, "checkDialogTipsShow show");
        return true;
    }

    private final boolean b(JumpGuildParam param) {
        JumpGuildNoticeMsg jumpGuildNoticeMsg;
        Parcelable parcelable = param.extras.getParcelable(JumpGuildParam.EXTRA_JUMP_NOTICE_MSG);
        if (parcelable instanceof JumpGuildNoticeMsg) {
            jumpGuildNoticeMsg = (JumpGuildNoticeMsg) parcelable;
        } else {
            jumpGuildNoticeMsg = null;
        }
        if (jumpGuildNoticeMsg == null) {
            return false;
        }
        ((IGuildFeedLauncherApi) QRoute.api(IGuildFeedLauncherApi.class)).launchGuildFeedNoticeFragmentInPersonalDimension(jumpGuildNoticeMsg.getFeedId(), jumpGuildNoticeMsg.getJumpType(), param.extras.getInt(IFileBrowserService.FILE_BROWSER_PAGE_FROM, 0));
        return true;
    }

    @JvmStatic
    public static final boolean c() {
        if (!at.c()) {
            Logger.f235387a.d().w("Guild.jump.GuildFeedsHomeJumpUtils", 1, "isJumpFeedsHome sdkNotReady return true");
            return true;
        }
        IRuntimeService S0 = ch.S0(IGuildUserService.class, "");
        Intrinsics.checkNotNullExpressionValue(S0, "runtimeService(java, process)");
        if (((IGuildUserService) S0).guildMode() == GuildMsgAbFlag.KSIMPLEMODEL) {
            return true;
        }
        return false;
    }

    @JvmStatic
    public static final void d(@NotNull Context context, @NotNull JumpGuildParam jumpGuildParam) {
        String stackTraceToString;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(jumpGuildParam, "jumpGuildParam");
        if (!at.c()) {
            Logger logger = Logger.f235387a;
            Logger.b bVar = new Logger.b();
            stackTraceToString = ExceptionsKt__ExceptionsKt.stackTraceToString(new Throwable());
            String str = "jumpToGuildFeedHomePage sdkNotReady from:" + stackTraceToString;
            if (str instanceof String) {
                bVar.a().add(str);
            }
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("Guild.jump.GuildFeedsHomeJumpUtils", 1, (String) it.next(), null);
            }
            QQToastUtil.showQQToast(1, "\u6253\u5f00\u5931\u8d25\uff0c\u8bf7\u8fd4\u56de\u91cd\u8bd5");
            return;
        }
        f392649a.e(context, jumpGuildParam);
    }

    private final void e(Context context, JumpGuildParam jumpGuildParam) {
        if (a(jumpGuildParam) || b(jumpGuildParam)) {
            return;
        }
        GuildHomeV2Fragment.INSTANCE.c(context, jumpGuildParam);
    }
}
