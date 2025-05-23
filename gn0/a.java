package gn0;

import android.os.Bundle;
import androidx.fragment.app.FragmentManager;
import com.tencent.aio.data.AIOContact;
import com.tencent.aio.data.AIOParam;
import com.tencent.aio.data.AIOSession;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.common.app.AppInterface;
import com.tencent.guild.aio.activity.GuildChatFragmentHiddenChangedEvent;
import com.tencent.guild.aio.util.ex.b;
import com.tencent.mobileqq.guild.api.IGuildStandalonePageOpenApi;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u001f\u0010 J\u001e\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u000e\u0010\f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nJ\u0006\u0010\r\u001a\u00020\nJ\u000e\u0010\u000e\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002J\u001e\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006R\"\u0010\u0017\u001a\u00020\u00118\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0012\u0010\u0014\"\u0004\b\u0015\u0010\u0016R$\u0010\u001e\u001a\u0004\u0018\u00010\u00188\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\r\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d\u00a8\u0006!"}, d2 = {"Lgn0/a;", "", "Landroid/os/Bundle;", "arguments", "Landroidx/fragment/app/FragmentManager;", "childFragmentManager", "", "containerId", "", "e", "", "hidden", "d", "b", "c", "fm", "g", "Lus/a;", "a", "Lus/a;", "()Lus/a;", "f", "(Lus/a;)V", "chatFragmentProvider", "Lcom/tencent/aio/data/AIOContact;", "Lcom/tencent/aio/data/AIOContact;", "getAioContact", "()Lcom/tencent/aio/data/AIOContact;", "setAioContact", "(Lcom/tencent/aio/data/AIOContact;)V", "aioContact", "<init>", "()V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public us.a chatFragmentProvider;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private AIOContact aioContact;

    @NotNull
    public final us.a a() {
        us.a aVar = this.chatFragmentProvider;
        if (aVar != null) {
            return aVar;
        }
        Intrinsics.throwUninitializedPropertyAccessException("chatFragmentProvider");
        return null;
    }

    public final boolean b() {
        if (!a().onBackPressed()) {
            return false;
        }
        return true;
    }

    public final void c(@NotNull Bundle arguments) {
        Intrinsics.checkNotNullParameter(arguments, "arguments");
        if (arguments.getBoolean("From_SplashActivity")) {
            ((IGuildStandalonePageOpenApi) QRoute.api(IGuildStandalonePageOpenApi.class)).unSetChannelPageSourceType("aio");
        }
    }

    public final void d(boolean hidden) {
        SimpleEventBus simpleEventBus;
        AIOContact aIOContact = this.aioContact;
        if (aIOContact != null && (simpleEventBus = SimpleEventBus.getInstance()) != null) {
            simpleEventBus.dispatchEvent(new GuildChatFragmentHiddenChangedEvent(aIOContact, hidden));
        }
    }

    public final void e(@NotNull Bundle arguments, @NotNull FragmentManager childFragmentManager, int containerId) {
        Intrinsics.checkNotNullParameter(arguments, "arguments");
        Intrinsics.checkNotNullParameter(childFragmentManager, "childFragmentManager");
        if (arguments.getBoolean("From_SplashActivity")) {
            ((IGuildStandalonePageOpenApi) QRoute.api(IGuildStandalonePageOpenApi.class)).setChannelPageSourceType("aio", 3);
        }
        g(arguments, childFragmentManager, containerId);
    }

    public final void f(@NotNull us.a aVar) {
        Intrinsics.checkNotNullParameter(aVar, "<set-?>");
        this.chatFragmentProvider = aVar;
    }

    public final void g(@NotNull Bundle arguments, @NotNull FragmentManager fm5, int containerId) {
        String str;
        boolean z16;
        String str2;
        boolean z17;
        boolean z18;
        boolean z19;
        AppInterface appInterface;
        IRuntimeService iRuntimeService;
        IGProChannelInfo channelInfo;
        Intrinsics.checkNotNullParameter(arguments, "arguments");
        Intrinsics.checkNotNullParameter(fm5, "fm");
        String string = arguments.getString("channel_id");
        String str3 = "";
        if (string == null) {
            str = "";
        } else {
            str = string;
        }
        String string2 = arguments.getString("guild_id");
        if (string2 == null) {
            string2 = "";
        }
        if (string2.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            String str4 = null;
            if (peekAppRuntime instanceof AppInterface) {
                appInterface = (AppInterface) peekAppRuntime;
            } else {
                appInterface = null;
            }
            if (appInterface != null) {
                iRuntimeService = appInterface.getRuntimeService(IGPSService.class, "");
            } else {
                iRuntimeService = null;
            }
            IGPSService iGPSService = (IGPSService) iRuntimeService;
            if (iGPSService != null && (channelInfo = iGPSService.getChannelInfo(str)) != null) {
                str4 = channelInfo.getGuildId();
            }
            if (str4 == null) {
                str4 = "";
            }
            str2 = str4;
        } else {
            str2 = string2;
        }
        String string3 = arguments.getString("factory_name");
        if (string3 != null) {
            str3 = string3;
        }
        if (str2.length() == 0) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (!z17) {
            if (str.length() == 0) {
                z18 = true;
            } else {
                z18 = false;
            }
            if (!z18) {
                if (str3.length() == 0) {
                    z19 = true;
                } else {
                    z19 = false;
                }
                if (!z19) {
                    this.aioContact = new AIOContact(4, str, str2, null, 8, null);
                    AIOParam.a e16 = new AIOParam.a().e(str3);
                    AIOContact aIOContact = this.aioContact;
                    Intrinsics.checkNotNull(aIOContact);
                    f(b.c(e16.h(new AIOSession(aIOContact)).i(true).d(0).a(arguments).c(), fm5, containerId, null, null, 24, null));
                    return;
                }
            }
        }
        QLog.e("GuildChatActivityAbility", 1, "startAIOFragment dataLegal guildId:" + str2 + " channelId:" + str + " factoryName:" + str3);
    }
}
