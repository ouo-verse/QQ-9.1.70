package ps1;

import android.content.Context;
import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.guild.api.IGuildTempApi;
import com.tencent.mobileqq.guild.jump.GuildJumpUtil;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ax;
import com.tencent.mobileqq.utils.bi;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0007\u00a8\u0006\f"}, d2 = {"Lps1/a;", "", "Landroid/content/Context;", "context", "", "navigationType", "", WadlProxyConsts.KEY_JUMP_URL, "", "a", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f427080a = new a();

    a() {
    }

    @JvmStatic
    public static final void a(@NotNull Context context, int navigationType, @NotNull String jumpUrl) {
        boolean startsWith$default;
        boolean startsWith$default2;
        BaseQQAppInterface baseQQAppInterface;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(jumpUrl, "jumpUrl");
        Boolean bool = null;
        switch (navigationType) {
            case 1:
            case 2:
                ((IMiniAppService) QRoute.api(IMiniAppService.class)).startMiniApp(context, jumpUrl, 5002, null);
                return;
            case 3:
            case 4:
                Bundle bundle = new Bundle();
                o02.a.e(bundle, 7);
                o02.a.f(7);
                GuildJumpUtil.i(context, jumpUrl, bundle);
                return;
            case 5:
                ch.o1(QBaseActivity.sTopActivity, jumpUrl);
                return;
            case 6:
                ax c16 = bi.c((BaseQQAppInterface) ch.l(), context, jumpUrl);
                if (c16 != null) {
                    bool = Boolean.valueOf(c16.b());
                }
                Logger.f235387a.d().d("Guild.MF.headerBars.GuildHeaderBarsJumpUtils", 1, "scheme jump result " + bool);
                return;
            case 7:
                Bundle bundle2 = new Bundle();
                o02.a.e(bundle2, 7);
                o02.a.f(7);
                bundle2.putBoolean("needHideGuestStatus", true);
                GuildJumpUtil.i(context, jumpUrl, bundle2);
                return;
            default:
                startsWith$default = StringsKt__StringsJVMKt.startsWith$default(jumpUrl, "http", false, 2, null);
                if (!startsWith$default) {
                    startsWith$default2 = StringsKt__StringsJVMKt.startsWith$default(jumpUrl, "https", false, 2, null);
                    if (!startsWith$default2) {
                        AppInterface l3 = ch.l();
                        if (l3 instanceof BaseQQAppInterface) {
                            baseQQAppInterface = (BaseQQAppInterface) l3;
                        } else {
                            baseQQAppInterface = null;
                        }
                        if (baseQQAppInterface == null) {
                            return;
                        }
                        ax c17 = bi.c(baseQQAppInterface, baseQQAppInterface.getApplicationContext(), jumpUrl);
                        if (c17 == null) {
                            Logger logger = Logger.f235387a;
                            Logger.b bVar = new Logger.b();
                            bVar.a().add("fail to gotoNavigationUrl, jumper == null");
                            Iterator<T> it = bVar.a().iterator();
                            while (it.hasNext()) {
                                Logger.f235387a.d().e("Guild.MF.headerBars.GuildHeaderBarsJumpUtils", 1, (String) it.next(), null);
                            }
                            return;
                        }
                        boolean b16 = c17.b();
                        Logger.f235387a.d().i("Guild.MF.headerBars.GuildHeaderBarsJumpUtils", 1, "gotoNavigationUrl: " + b16 + " " + jumpUrl);
                        return;
                    }
                }
                ((IGuildTempApi) QRoute.api(IGuildTempApi.class)).openGuildByShareUrl(context, jumpUrl, "");
                return;
        }
    }
}
