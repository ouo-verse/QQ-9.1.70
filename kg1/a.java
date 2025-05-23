package kg1;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.guild.client.GuildClientParams;
import com.tencent.mobileqq.guild.nt.misc.api.IJumpApi;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.guild.util.cx;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.mini.sdk.EntryModel;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import lg1.b;
import lg1.c;
import lg1.d;

/* compiled from: P */
/* loaded from: classes12.dex */
public class a {
    private static String a(GuildClientParams guildClientParams, int i3) {
        boolean z16;
        String str;
        if (i3 == 2) {
            z16 = true;
        } else {
            z16 = false;
        }
        String V = guildClientParams.V();
        Object[] objArr = new Object[6];
        objArr[0] = 2097152;
        objArr[1] = Uri.encode(V);
        objArr[2] = Boolean.valueOf(z16);
        objArr[3] = guildClientParams.G();
        objArr[4] = guildClientParams.u();
        if (ch.B0()) {
            str = "test";
        } else {
            str = "";
        }
        objArr[5] = str;
        return String.format("https://qun.qq.com/guild/h5/jump/index.html?_wv=%s&_disableWVQuit=1#/?target=%s&examining=%s&guildid=%s&channelid=%s&cgi=%s", objArr);
    }

    private static lg1.a b(int i3) {
        if (h(i3)) {
            return new b();
        }
        if (e(i3)) {
            return new d();
        }
        if (f(i3)) {
            return new c();
        }
        return null;
    }

    public static void c(Context context, GuildClientParams guildClientParams) {
        String a16 = a(guildClientParams, guildClientParams.C());
        Bundle bundle = new Bundle();
        bundle.putInt("titleBarStyle", 11);
        bundle.putParcelable("extra_guild_client_params", guildClientParams);
        cx.b(context, a16, bundle);
    }

    public static boolean d(QBaseActivity qBaseActivity, @NonNull GuildClientParams guildClientParams) {
        boolean z16;
        QLog.i("Guild.jump.GuildAppChannelOpenHelper", 1, "handleClickAppChannelItem " + guildClientParams);
        int N = guildClientParams.N();
        if (N != 1) {
            if (N != 2) {
                if (N != 3) {
                    if (N != 4) {
                        ch.f1(qBaseActivity.getString(R.string.f158101op));
                        return false;
                    }
                    return ch.N0(qBaseActivity, guildClientParams.V()).booleanValue();
                }
                EntryModel entryModel = new EntryModel();
                entryModel.type = -1;
                entryModel.titlebarIconUrl = guildClientParams.E();
                Bundle bundle = new Bundle();
                bundle.putString("extra_guild_id", guildClientParams.G());
                bundle.putString("extra_channel_id", guildClientParams.u());
                bundle.putBoolean("extra_key_is_guest", guildClientParams.M());
                bundle.putLong("extra_app_id", guildClientParams.q());
                entryModel.mArguments = bundle;
                ((IMiniAppService) QRoute.api(IMiniAppService.class)).startMiniApp(qBaseActivity, guildClientParams.V(), 5002, entryModel, null);
                return true;
            }
            if (guildClientParams.q() == 9999999) {
                c(qBaseActivity, guildClientParams);
                return true;
            }
            if (guildClientParams.q() == 1000101) {
                z16 = true;
            } else {
                z16 = false;
            }
            ch.n1(qBaseActivity, guildClientParams.V(), guildClientParams.v(), guildClientParams.E(), true, z16);
            return true;
        }
        lg1.a b16 = b(guildClientParams.q());
        if (b16 == null) {
            ch.f1(qBaseActivity.getString(R.string.f158101op));
            return false;
        }
        return b16.a(qBaseActivity, guildClientParams);
    }

    public static boolean e(int i3) {
        if (i3 != 1000000 && i3 != 1000051 && i3 != 1000070 && i3 != 1000050 && !com.tencent.mobileqq.guild.main.b.b(i3)) {
            return false;
        }
        return true;
    }

    public static boolean f(int i3) {
        if (i3 == 1000017) {
            return true;
        }
        return false;
    }

    public static void g(QBaseActivity qBaseActivity, String str) {
        if (TextUtils.isEmpty(str)) {
            QLog.w("Guild.jump.GuildAppChannelOpenHelper", 1, "openAppChannelByJumpAction but jumpUrl is empty");
        } else if (qBaseActivity.getAppRuntime() instanceof BaseQQAppInterface) {
            ((IJumpApi) QRoute.api(IJumpApi.class)).doJumpAction(qBaseActivity.getAppRuntime(), qBaseActivity, str);
        } else {
            QLog.e("Guild.jump.GuildAppChannelOpenHelper", 1, "openAppChannelByJumpAction but appRuntime is not BaseQQAppInterface");
        }
    }

    public static boolean h(int i3) {
        return com.tencent.mobileqq.guild.constant.a.a(i3);
    }
}
