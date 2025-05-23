package gs1;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentManager;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.guild.api.LaunchGuildChatPieParam;
import com.tencent.mobileqq.guild.inbox.startpanel.GuildMyProfileWithInboxFragment;
import com.tencent.mobileqq.guild.mainframe.GuildAppReportSourceInfo;
import com.tencent.mobileqq.guild.mainframe.centerpanel.GuildCenterPanelController;
import com.tencent.mobileqq.guild.mainframe.helper.c;
import com.tencent.mobileqq.guild.mainframe.helper.jump.GuildMainFrameJumpParam;
import com.tencent.mobileqq.guild.mainframe.i;
import com.tencent.mobileqq.guild.mainframe.util.GuildMainFrameUtils;
import com.tencent.mobileqq.guild.util.q;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes14.dex */
public class b extends c {

    /* renamed from: i, reason: collision with root package name */
    private static final int f403264i = ViewUtils.dpToPx(0.0f);

    /* renamed from: f, reason: collision with root package name */
    private GuildMyProfileWithInboxFragment f403265f;

    /* renamed from: h, reason: collision with root package name */
    private ViewGroup f403266h;

    public b(i iVar) {
        super(iVar);
        this.f403266h = null;
    }

    private int s(GuildCenterPanelController.b bVar) {
        int i3 = bVar.f227299a;
        if (i3 != 4) {
            if (i3 != 6) {
                if (i3 != 7 && i3 != 9 && i3 != 10) {
                    return -1;
                }
                return 1;
            }
            return 0;
        }
        return 1;
    }

    private boolean u() {
        int t16 = this.f227466d.Z0().t();
        if (t16 != 4 && t16 != 6 && t16 != 7 && t16 != 9 && t16 != 10) {
            return false;
        }
        return true;
    }

    private boolean v(GuildCenterPanelController.b bVar, c.a aVar) {
        if ((bVar.f227299a == 6 && TextUtils.equals(bVar.f227300b, aVar.f227422b)) || r(aVar.f227421a, aVar.f227422b) == bVar.f227299a) {
            return true;
        }
        return false;
    }

    private void w(i iVar, String str, Bundle bundle) {
        int i3;
        Intent intent;
        QLog.d("Guild.MF.Rt.GuildInboxController", 1, "openOfficeCenterPanel, uiData:", str);
        if (TextUtils.equals(str, String.valueOf(6))) {
            i3 = 4;
        } else if (TextUtils.equals(str, String.valueOf(7))) {
            i3 = 7;
        } else if (TextUtils.equals(str, String.valueOf(5))) {
            i3 = 10;
        } else {
            QLog.e("Guild.MF.Rt.GuildInboxController", 1, "handleOfficialNodeClick, the uiData is error, uiData:", str);
            return;
        }
        com.tencent.mobileqq.guild.mainframe.helper.c.k(iVar).o(1, str);
        int t16 = iVar.Z0().t();
        if (bundle != null) {
            intent = new Intent();
            intent.putExtra("param_ext_bundle", bundle);
        } else {
            intent = null;
        }
        if (t16 != i3 || intent != null) {
            iVar.Z0().F(i3, intent);
        }
        iVar.Z0().z(1);
    }

    @Override // com.tencent.mobileqq.guild.mainframe.k, com.tencent.mobileqq.guild.mainframe.t
    public void b(boolean z16) {
        super.b(z16);
        GuildMyProfileWithInboxFragment guildMyProfileWithInboxFragment = this.f403265f;
        if (guildMyProfileWithInboxFragment != null) {
            guildMyProfileWithInboxFragment.ni(z16);
        }
        if (QLog.isColorLevel()) {
            QLog.d("Guild.MF.Rt.GuildInboxController", 2, "onAfterAccountChanged");
        }
    }

    @Override // gs1.c
    public boolean i(cs1.b bVar, GuildAppReportSourceInfo guildAppReportSourceInfo) {
        return false;
    }

    @Override // gs1.c
    public int k() {
        return 3;
    }

    @Override // gs1.c
    public void l() {
        GuildMyProfileWithInboxFragment guildMyProfileWithInboxFragment = this.f403265f;
        if (guildMyProfileWithInboxFragment != null) {
            guildMyProfileWithInboxFragment.bi();
        }
        if (QLog.isColorLevel()) {
            Object[] objArr = new Object[2];
            boolean z16 = false;
            objArr[0] = "mNoticeFragment is hide, mNoticeFragment null is ";
            if (this.f403265f == null) {
                z16 = true;
            }
            objArr[1] = Boolean.valueOf(z16);
            QLog.d("Guild.MF.Rt.GuildInboxController", 1, objArr);
        }
    }

    @Override // gs1.c
    public void m(GuildCenterPanelController.b bVar) {
        c.a j3 = com.tencent.mobileqq.guild.mainframe.helper.c.k(this.f227466d).j();
        if (v(bVar, j3)) {
            return;
        }
        c.a aVar = new c.a(s(bVar), bVar.f227300b);
        QLog.i("Guild.MF.Rt.GuildInboxController", 1, "jump2TargetItem wantSelItem=" + aVar + " curSelItem=" + j3);
        com.tencent.mobileqq.guild.mainframe.helper.c.k(this.f227466d).o(aVar.f227421a, aVar.f227422b);
        GuildMyProfileWithInboxFragment guildMyProfileWithInboxFragment = this.f403265f;
        if (guildMyProfileWithInboxFragment != null) {
            guildMyProfileWithInboxFragment.gi(bVar);
            return;
        }
        QLog.w("Guild.MF.Rt.GuildInboxController", 1, "jump2TargetItem " + aVar);
    }

    @Override // gs1.c
    public void n(ViewGroup viewGroup) {
        this.f403266h = viewGroup;
    }

    @Override // gs1.c
    public void o(cs1.b bVar, @Nullable GuildAppReportSourceInfo guildAppReportSourceInfo) {
        Bundle bundle;
        t(guildAppReportSourceInfo);
        GuildMainFrameJumpParam.GuildCenterPanelJumpExtra guildCenterPanelJumpExtra = null;
        if (bVar != null && (bundle = bVar.f391799i) != null) {
            GuildMainFrameJumpParam.GuildCenterPanelJumpExtra guildCenterPanelJumpExtra2 = (GuildMainFrameJumpParam.GuildCenterPanelJumpExtra) bundle.getParcelable("EXTRA_KEY_CENTER_PANEL_PARAM");
            bVar.f391799i.putParcelable("EXTRA_KEY_CENTER_PANEL_PARAM", null);
            guildCenterPanelJumpExtra = guildCenterPanelJumpExtra2;
        }
        boolean vi5 = this.f403265f.vi(guildCenterPanelJumpExtra, guildAppReportSourceInfo);
        if (guildCenterPanelJumpExtra != null && !vi5) {
            p(guildCenterPanelJumpExtra, guildAppReportSourceInfo);
        } else if (!u()) {
            this.f227466d.Z0().r();
        }
        this.f227466d.d(f403264i);
        if (QLog.isColorLevel()) {
            QLog.d("Guild.MF.Rt.GuildInboxController", 1, "mNoticeFragment is show");
        }
    }

    @Override // com.tencent.mobileqq.guild.mainframe.k, com.tencent.mobileqq.guild.mainframe.t
    public void onBeforeAccountChanged() {
        super.onBeforeAccountChanged();
        GuildMyProfileWithInboxFragment guildMyProfileWithInboxFragment = this.f403265f;
        if (guildMyProfileWithInboxFragment != null) {
            guildMyProfileWithInboxFragment.oi();
        }
        if (QLog.isColorLevel()) {
            QLog.d("Guild.MF.Rt.GuildInboxController", 2, "onBeforeAccountChanged");
        }
    }

    @Override // com.tencent.mobileqq.guild.mainframe.k, com.tencent.mobileqq.guild.mainframe.t
    public void onDestroy() {
        GuildMyProfileWithInboxFragment guildMyProfileWithInboxFragment = this.f403265f;
        if (guildMyProfileWithInboxFragment != null) {
            q.b(guildMyProfileWithInboxFragment);
            this.f403265f = null;
        }
        if (QLog.isColorLevel()) {
            QLog.d("Guild.MF.Rt.GuildInboxController", 1, MosaicConstants$JsFunction.FUNC_ON_DESTROY);
        }
    }

    @Override // gs1.c
    public boolean p(GuildMainFrameJumpParam.GuildCenterPanelJumpExtra guildCenterPanelJumpExtra, GuildAppReportSourceInfo guildAppReportSourceInfo) {
        Bundle bundle;
        GuildMainFrameJumpParam.GuildInboxJumpExtra guildInboxJumpExtra = guildCenterPanelJumpExtra.f227443d;
        int i3 = guildInboxJumpExtra.f227446d;
        if (i3 == 0) {
            LaunchGuildChatPieParam launchGuildChatPieParam = guildCenterPanelJumpExtra.f227444e;
            launchGuildChatPieParam.G.putParcelable("GuildAppReportSourceInfo", guildAppReportSourceInfo);
            boolean r16 = GuildMainFrameUtils.r(this.f227466d.getActivity(), 6, launchGuildChatPieParam);
            if (r16) {
                com.tencent.mobileqq.guild.mainframe.helper.c.k(this.f227466d).o(0, launchGuildChatPieParam.f214354d);
            }
            QLog.i("Guild.MF.Rt.GuildInboxController", 1, "showCenterPanelAnyWay result=" + r16 + " param=" + guildCenterPanelJumpExtra);
            return r16;
        }
        if (i3 != 1) {
            return false;
        }
        LaunchGuildChatPieParam launchGuildChatPieParam2 = guildCenterPanelJumpExtra.f227444e;
        if (launchGuildChatPieParam2 != null) {
            bundle = launchGuildChatPieParam2.G;
        } else {
            bundle = null;
        }
        w(this.f227466d, guildInboxJumpExtra.f227447e, bundle);
        return true;
    }

    @Override // gs1.c
    public boolean q(GuildMainFrameJumpParam guildMainFrameJumpParam) {
        GuildMyProfileWithInboxFragment guildMyProfileWithInboxFragment = this.f403265f;
        if (guildMyProfileWithInboxFragment != null) {
            return guildMyProfileWithInboxFragment.wi(guildMainFrameJumpParam.f227440d, guildMainFrameJumpParam.f227441e);
        }
        return false;
    }

    public int r(int i3, String str) {
        if (i3 != 0) {
            if (i3 == 1) {
                if (TextUtils.equals(str, "6")) {
                    return 4;
                }
                if (TextUtils.equals(str, "7")) {
                    return 7;
                }
                if (TextUtils.equals(str, "5")) {
                    return 10;
                }
                return 0;
            }
            return 0;
        }
        return 6;
    }

    protected void t(@Nullable GuildAppReportSourceInfo guildAppReportSourceInfo) {
        FragmentManager childFragmentManager = g().getChildFragmentManager();
        if (this.f403265f == null) {
            GuildMyProfileWithInboxFragment mi5 = GuildMyProfileWithInboxFragment.mi(new Intent());
            this.f403265f = mi5;
            mi5.ui(g());
            if (guildAppReportSourceInfo != null) {
                Bundle bundle = new Bundle();
                bundle.putParcelable("GuildAppReportSourceInfo", guildAppReportSourceInfo);
                this.f403265f.setArguments(bundle);
            }
            childFragmentManager.beginTransaction().add(this.f403266h.getId(), this.f403265f, "GuildInboxC2CFragment").commitNowAllowingStateLoss();
        }
    }
}
