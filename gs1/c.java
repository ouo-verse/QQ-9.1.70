package gs1;

import android.view.ViewGroup;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.guild.mainframe.GuildAppReportSourceInfo;
import com.tencent.mobileqq.guild.mainframe.centerpanel.GuildCenterPanelController;
import com.tencent.mobileqq.guild.mainframe.helper.jump.GuildMainFrameJumpParam;
import com.tencent.mobileqq.guild.mainframe.i;
import com.tencent.mobileqq.guild.mainframe.k;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes14.dex */
public abstract class c extends k {

    /* renamed from: e, reason: collision with root package name */
    protected static final int f403267e = QQGuildUIUtil.f(0.0f);

    public c(i iVar) {
        super(iVar);
    }

    public boolean i(cs1.b bVar, GuildAppReportSourceInfo guildAppReportSourceInfo) {
        return true;
    }

    public boolean j(String str) {
        return false;
    }

    public abstract int k();

    public abstract void l();

    public void m(GuildCenterPanelController.b bVar) {
        if (QLog.isColorLevel()) {
            QLog.i("Guild.MF.Rt.GuildRightChildController", 2, "jump2TargetItem " + bVar);
        }
    }

    public abstract void n(ViewGroup viewGroup);

    public abstract void o(cs1.b bVar, @Nullable GuildAppReportSourceInfo guildAppReportSourceInfo);

    public boolean p(GuildMainFrameJumpParam.GuildCenterPanelJumpExtra guildCenterPanelJumpExtra, GuildAppReportSourceInfo guildAppReportSourceInfo) {
        QLog.w("Guild.MF.Rt.GuildRightChildController", 1, "not support showCenterPanelAnyWay");
        return false;
    }

    public boolean q(GuildMainFrameJumpParam guildMainFrameJumpParam) {
        return false;
    }
}
