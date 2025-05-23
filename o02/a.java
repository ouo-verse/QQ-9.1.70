package o02;

import android.os.Bundle;
import com.tencent.mobileqq.guild.api.IQQGuildRouterApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes14.dex */
public class a {
    public static Bundle a(int i3) {
        Bundle bundle = new Bundle();
        bundle.putInt("channel_enter_source", i3);
        f(i3);
        return bundle;
    }

    public static int b() {
        return ((IQQGuildRouterApi) QRoute.api(IQQGuildRouterApi.class)).getChannelEnterSource();
    }

    public static boolean c() {
        if (b() != -1) {
            return true;
        }
        return false;
    }

    public static Bundle d(Bundle bundle) {
        bundle.putInt("channel_enter_source", b());
        return bundle;
    }

    public static Bundle e(Bundle bundle, int i3) {
        bundle.putInt("channel_enter_source", i3);
        return bundle;
    }

    public static void f(int i3) {
        String str = "setSource(" + i3 + ")";
        QLog.i("Guild.jump.ChannelEnterSource", 1, str);
        ((IQQGuildRouterApi) QRoute.api(IQQGuildRouterApi.class)).setChannelEnterSource(i3);
        if (QLog.isColorLevel()) {
            QLog.d("Guild.jump.ChannelEnterSource", 2, new RuntimeException(str + " BACKTRACE:"), new Object[0]);
        }
    }

    public static void g(int i3) {
        if (!c()) {
            f(i3);
        }
    }
}
