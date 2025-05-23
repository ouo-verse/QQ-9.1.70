package go2;

import android.os.Bundle;
import com.tencent.mobileqq.guild.api.IQQGuildRouterApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes18.dex */
public class d {
    public static void a(boolean z16, String str, String str2, Bundle bundle) {
        QLog.d("GuildSearchJumpUtils", 1, "[jumpToGuildFromSearch] guildTabShow = " + z16);
        ((IQQGuildRouterApi) QRoute.api(IQQGuildRouterApi.class)).jumpGuildFormSearch(str, str2, 246614, bundle);
    }
}
