package lg1;

import android.content.Intent;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.guild.client.GuildClientParams;
import com.tencent.mobileqq.guild.mainframe.centerpanel.GuildCenterPanelController;
import com.tencent.mobileqq.guild.mainframe.manager.GuildMainFrameManager;

/* compiled from: P */
/* loaded from: classes12.dex */
public class d extends a {
    @Override // lg1.a
    public boolean a(QBaseActivity qBaseActivity, GuildClientParams guildClientParams) {
        boolean z16;
        GuildCenterPanelController f16 = GuildMainFrameManager.f();
        if (f16 == null) {
            return false;
        }
        if (guildClientParams.Z() != 3) {
            z16 = true;
        } else {
            z16 = false;
        }
        guildClientParams.k0(z16);
        Intent intent = new Intent();
        intent.putExtra("guild_id", guildClientParams.G());
        intent.putExtra("uin", guildClientParams.u());
        intent.putExtra("EXTRA_KEY_CLIENT_PARAM", guildClientParams);
        f16.F(5, intent);
        f16.z(1);
        return false;
    }
}
