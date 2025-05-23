package lg1;

import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.guild.client.GuildClientParams;
import com.tencent.mobileqq.qqecommerce.biz.sdk.api.IQQECommerceSdk;
import com.tencent.mobileqq.qroute.QRoute;

/* compiled from: P */
/* loaded from: classes12.dex */
public class c extends a {
    @Override // lg1.a
    public boolean a(QBaseActivity qBaseActivity, GuildClientParams guildClientParams) {
        ((IQQECommerceSdk) QRoute.api(IQQECommerceSdk.class)).handleScheme(guildClientParams.V(), null);
        return false;
    }
}
