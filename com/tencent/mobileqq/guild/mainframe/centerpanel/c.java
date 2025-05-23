package com.tencent.mobileqq.guild.mainframe.centerpanel;

import android.content.Intent;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentTransaction;
import com.tencent.mobileqq.app.QBaseFragment;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.guild.client.GuildClientParams;
import com.tencent.mobileqq.guild.mainframe.centerpanel.GuildCenterPanelController;
import com.tencent.mobileqq.guild.mainframe.util.GuildMainFrameUtils;
import com.tencent.mobileqq.guild.performance.report.g;
import com.tencent.mobileqq.guild.report.GuildChannelReportManager;
import com.tencent.mobileqq.guild.schedule.list.GuildScheduleListFragment;
import com.tencent.mobileqq.guild.util.q;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProAppChnnPreInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.timi.game.api.ITimiGameApi;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import rr1.i;

/* compiled from: P */
/* loaded from: classes14.dex */
public class c extends gs1.a {
    private rr1.a C;

    /* renamed from: e, reason: collision with root package name */
    private int f227337e;

    /* renamed from: f, reason: collision with root package name */
    private FrameLayout f227338f;

    /* renamed from: h, reason: collision with root package name */
    private QBaseFragment f227339h;

    /* renamed from: i, reason: collision with root package name */
    private String f227340i;

    /* renamed from: m, reason: collision with root package name */
    private String f227341m;

    /* compiled from: P */
    /* loaded from: classes14.dex */
    class a extends rr1.a {
        a() {
        }

        private boolean d(i iVar) {
            if (iVar.f() == 3 && (iVar.c() == 3 || iVar.c() == 2)) {
                return true;
            }
            return false;
        }

        private boolean e(i iVar) {
            if (iVar.g() == 1 || iVar.g() == 3) {
                return true;
            }
            return false;
        }

        private boolean f(i iVar) {
            if (iVar.f() == 3 && iVar.c() == 1) {
                return true;
            }
            return false;
        }

        @Override // rr1.a
        public void c(i iVar) {
            if (d(iVar)) {
                if (e(iVar)) {
                    c.this.s();
                }
            } else if (f(iVar)) {
                c.this.t();
            }
        }
    }

    public c(com.tencent.mobileqq.guild.mainframe.i iVar) {
        super(iVar);
        this.f227337e = 0;
        this.f227340i = "";
        this.f227341m = "";
        this.C = new a();
    }

    private QPublicBaseFragment q(String str) {
        return ((ITimiGameApi) QRoute.api(ITimiGameApi.class)).createExpandHallFragment(this.f227466d.getActivity(), ((ITimiGameApi) QRoute.api(ITimiGameApi.class)).buildLaunchParamFromLink(this.f227466d.getActivity(), str), null);
    }

    private QPublicBaseFragment r(GuildClientParams guildClientParams) {
        return GuildScheduleListFragment.ni(com.tencent.mobileqq.guild.mainframe.b.a(this.f227466d), guildClientParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s() {
        if (u() && v()) {
            GuildChannelReportManager.f231987a.f(GuildChannelReportManager.PageType.CHANNEL_PAGE_SCHEDULE_LIST, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t() {
        if (u() && v()) {
            GuildChannelReportManager.f231987a.e(GuildChannelReportManager.PageType.CHANNEL_PAGE_SCHEDULE_LIST, null);
        }
    }

    private boolean u() {
        if (this.f227466d.Z0().t() == 5) {
            return true;
        }
        return false;
    }

    private boolean v() {
        IGPSService iGPSService;
        IGProChannelInfo channelInfo;
        IGProAppChnnPreInfo appChnnPreInfo;
        GuildCenterPanelController.b x16 = this.f227466d.Z0().x();
        if (x16 == null) {
            return false;
        }
        String str = x16.f227300b;
        String str2 = x16.f227301c;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null || (channelInfo = (iGPSService = (IGPSService) peekAppRuntime.getRuntimeService(IGPSService.class, "all")).getChannelInfo(str2)) == null || channelInfo.getType() != 6 || (appChnnPreInfo = iGPSService.getAppChnnPreInfo(str, str2)) == null || appChnnPreInfo.getAppid() != 1000050) {
            return false;
        }
        return true;
    }

    private void w(String str) {
        g.b(str);
    }

    @Override // gs1.a
    public boolean i(Intent intent) {
        if (intent == null) {
            return false;
        }
        GuildClientParams guildClientParams = (GuildClientParams) intent.getParcelableExtra("EXTRA_KEY_CLIENT_PARAM");
        if (guildClientParams != null && !TextUtils.isEmpty(guildClientParams.V())) {
            if (!guildClientParams.h0() || !TextUtils.equals(this.f227341m, guildClientParams.V())) {
                return true;
            }
            if (!TextUtils.isEmpty(this.f227340i) && guildClientParams.u().equals(this.f227340i)) {
                return false;
            }
            return super.i(intent);
        }
        QLog.d("Guild.MF.Center.GuildClientCenterPanelController", 1, "canOpenWhenHasShow clientFragment params or jumpUrl is null ");
        return false;
    }

    @Override // gs1.a
    public int k() {
        return 5;
    }

    @Override // gs1.a
    public void l() {
        if (this.f227339h != null) {
            if (QLog.isColorLevel()) {
                QLog.d("Guild.MF.Center.GuildClientCenterPanelController", 2, "hide clientFragment for channelId  " + this.f227340i);
            }
            this.f227340i = "";
            this.f227341m = "";
            q.b(this.f227339h);
            this.f227339h = null;
        }
    }

    @Override // gs1.a
    public void m(ViewGroup viewGroup) {
        FrameLayout frameLayout = (FrameLayout) viewGroup;
        this.f227338f = frameLayout;
        this.f227337e = frameLayout.getId();
    }

    @Override // gs1.a
    public void n(@Nullable Intent intent) {
        boolean z16;
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("show clientFragment is null ? ");
            if (this.f227339h == null) {
                z16 = true;
            } else {
                z16 = false;
            }
            sb5.append(z16);
            QLog.d("Guild.MF.Center.GuildClientCenterPanelController", 2, sb5.toString());
        }
        if (this.f227339h != null) {
            if (QLog.isColorLevel()) {
                QLog.d("Guild.MF.Center.GuildClientCenterPanelController", 2, "remove clientFragment", Integer.valueOf(this.f227339h.hashCode()), " for channelId  " + this.f227340i);
            }
            this.f227340i = "";
            this.f227341m = "";
            q.b(this.f227339h);
        }
        if (intent == null) {
            QLog.w("Guild.MF.Center.GuildClientCenterPanelController", 1, "show clientFragment data is null ");
            return;
        }
        GuildClientParams guildClientParams = (GuildClientParams) intent.getParcelableExtra("EXTRA_KEY_CLIENT_PARAM");
        if (guildClientParams != null && !TextUtils.isEmpty(guildClientParams.V())) {
            if (QLog.isColorLevel()) {
                QLog.d("Guild.MF.Center.GuildClientCenterPanelController", 2, "client extra=" + guildClientParams.F());
            }
            int q16 = guildClientParams.q();
            if (q16 != 1000000 && q16 != 1000051 && q16 != 1000070 && !com.tencent.mobileqq.guild.main.b.b(q16)) {
                if (guildClientParams.q() == 1000050) {
                    this.f227339h = r(guildClientParams);
                } else {
                    QLog.w("Guild.MF.Center.GuildClientCenterPanelController", 1, "unsupported appid\uff1a" + guildClientParams.q());
                    return;
                }
            } else {
                w(guildClientParams.u());
                this.f227339h = q(guildClientParams.V());
            }
            this.f227340i = guildClientParams.u();
            this.f227341m = guildClientParams.V();
            nr1.b.a(guildClientParams.G(), this.f227340i);
            FragmentTransaction beginTransaction = j().beginTransaction();
            int i3 = this.f227337e;
            QBaseFragment qBaseFragment = this.f227339h;
            beginTransaction.add(i3, qBaseFragment, qBaseFragment.getClass().getName());
            beginTransaction.commitAllowingStateLoss();
            return;
        }
        QLog.d("Guild.MF.Center.GuildClientCenterPanelController", 1, "show clientFragment params or jumpUrl is null ");
    }

    @Override // com.tencent.mobileqq.guild.mainframe.k, com.tencent.mobileqq.guild.mainframe.t
    public boolean onBackPressed() {
        com.tencent.mobileqq.guild.mainframe.i iVar;
        GuildCenterPanelController Z0;
        if (this.f227338f == null || (iVar = this.f227466d) == null || (Z0 = iVar.Z0()) == null || Z0.t() != 5) {
            return false;
        }
        if (Z0.o()) {
            Z0.z(1);
            return true;
        }
        if (Z0.q()) {
            QBaseFragment qBaseFragment = this.f227339h;
            if (qBaseFragment != null && qBaseFragment.getActivity() != null && !((QPublicBaseFragment) this.f227339h).onBackEvent()) {
                Z0.z(2);
            }
            return true;
        }
        if (this.f227466d.Z0().p()) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.mobileqq.guild.mainframe.k, com.tencent.mobileqq.guild.mainframe.t
    public void onBeforeAccountChanged() {
        boolean z16;
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("onBeforeAccountChanged clientFragment is null ? ");
            if (this.f227339h == null) {
                z16 = true;
            } else {
                z16 = false;
            }
            sb5.append(z16);
            QLog.d("Guild.MF.Center.GuildClientCenterPanelController", 2, sb5.toString());
        }
        QBaseFragment qBaseFragment = this.f227339h;
        if (qBaseFragment != null) {
            q.b(qBaseFragment);
            this.f227339h = null;
            if (this.f227466d.Z0().t() == 5) {
                GuildMainFrameUtils.d(this.f227466d);
            }
        }
    }

    @Override // com.tencent.mobileqq.guild.mainframe.k, com.tencent.mobileqq.guild.mainframe.t
    public void onCreate() {
        super.onCreate();
        this.f227466d.N().addGestureListener(this.C);
    }

    @Override // com.tencent.mobileqq.guild.mainframe.k, com.tencent.mobileqq.guild.mainframe.t
    public void onDestroy() {
        super.onDestroy();
        this.f227466d.N().removeGestureListener(this.C);
    }
}
