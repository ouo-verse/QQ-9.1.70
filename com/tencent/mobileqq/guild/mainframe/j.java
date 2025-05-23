package com.tencent.mobileqq.guild.mainframe;

import android.text.TextUtils;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelStoreOwner;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.guild.api.LaunchGuildChatPieParam;
import com.tencent.mobileqq.guild.constant.GuildFacadeType;
import com.tencent.mobileqq.guild.mainframe.centerpanel.GuildCenterPanelController;
import com.tencent.mobileqq.guild.mainframe.helper.jump.GuildMainFrameJumpParam;
import com.tencent.mobileqq.guild.mainframe.startpanel.rightpart.GuildStartPanelRightController;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes14.dex */
public class j implements i {

    /* renamed from: a, reason: collision with root package name */
    private c f227465a;

    public j(c cVar) {
        this.f227465a = cVar;
    }

    @Override // com.tencent.mobileqq.guild.mainframe.i
    public sr1.d N() {
        return this.f227465a.N();
    }

    @Override // com.tencent.mobileqq.guild.mainframe.i
    public boolean P() {
        return this.f227465a.P();
    }

    @Override // com.tencent.mobileqq.guild.mainframe.i
    public void R(@NonNull GuildAppReportSourceInfo guildAppReportSourceInfo) {
        this.f227465a.R(guildAppReportSourceInfo);
    }

    @Override // com.tencent.mobileqq.guild.mainframe.i
    public GuildCenterPanelController Z0() {
        return this.f227465a.Z0();
    }

    @Override // com.tencent.mobileqq.guild.mainframe.i
    @NonNull
    public GuildFacadeType a() {
        return GuildFacadeType.Tab;
    }

    @Override // com.tencent.mobileqq.guild.mainframe.i
    public int b() {
        return e1().l();
    }

    @Override // com.tencent.mobileqq.guild.mainframe.i
    public void c(LaunchGuildChatPieParam launchGuildChatPieParam) {
        if (TextUtils.isEmpty(launchGuildChatPieParam.f214354d)) {
            QLog.w("Guild.MF.GuildMainViewContext", 1, "jumpItemAndShowCenterPanel param invalid:$param");
            com.tencent.mobileqq.guild.performance.report.m.j().e("Guild.MF.GuildMainViewContextjumpItemAndShowCenterPanel invalid guildId", null);
        } else {
            this.f227465a.C1().P(this.f227465a.C1().I(launchGuildChatPieParam));
        }
    }

    @Override // com.tencent.mobileqq.guild.mainframe.i
    public void d(int i3) {
        GuildStartPanelRightController e16 = e1();
        if (e16 != null) {
            e16.p(i3);
        }
    }

    @Override // com.tencent.mobileqq.guild.mainframe.i
    public vr1.a d1() {
        return this.f227465a.d1();
    }

    @Override // com.tencent.mobileqq.guild.mainframe.i
    public DragFrameLayout e() {
        return this.f227465a.jh();
    }

    @Override // com.tencent.mobileqq.guild.mainframe.i
    public GuildStartPanelRightController e1() {
        return this.f227465a.e1();
    }

    @Override // com.tencent.mobileqq.guild.mainframe.i
    public void f(GuildMainFrameJumpParam guildMainFrameJumpParam) {
        if (guildMainFrameJumpParam.f227439c) {
            this.f227465a.C1().P(guildMainFrameJumpParam);
        } else {
            this.f227465a.C1().Q(guildMainFrameJumpParam);
        }
    }

    @Override // com.tencent.mobileqq.guild.mainframe.i
    public GuildAppReportSourceInfo f0() {
        return this.f227465a.f0();
    }

    @Override // com.tencent.mobileqq.guild.mainframe.i
    public boolean g(String str) {
        return e1().i(str);
    }

    @Override // com.tencent.mobileqq.guild.mainframe.i
    public QBaseActivity getActivity() {
        return (QBaseActivity) this.f227465a.getActivity();
    }

    @Override // com.tencent.mobileqq.guild.mainframe.i
    public AppRuntime getApp() {
        return this.f227465a.getApp();
    }

    @Override // com.tencent.mobileqq.guild.mainframe.i
    public FragmentManager getChildFragmentManager() {
        return this.f227465a.Rc();
    }

    @Override // com.tencent.mobileqq.guild.mainframe.i
    public <T> T getHelper(int i3) {
        return (T) this.f227465a.getHelper(i3);
    }

    @Override // com.tencent.mobileqq.guild.mainframe.i
    public LifecycleOwner getLifecycleOwner() {
        return this.f227465a.getLifecycleOwner();
    }

    @Override // com.tencent.mobileqq.guild.mainframe.i
    public ViewGroup getRootView() {
        return this.f227465a.getRootView();
    }

    @Override // com.tencent.mobileqq.guild.mainframe.i
    public void guildCenterPanelInOrOut(int i3, boolean z16) {
        if (z16) {
            this.f227465a.Z0().z(i3);
        } else {
            this.f227465a.Z0().y(i3);
        }
    }

    @Override // com.tencent.mobileqq.guild.mainframe.i
    public void h(int i3, String str, @Nullable GuildAppReportSourceInfo guildAppReportSourceInfo) {
        this.f227465a.C1().S(i3, str, guildAppReportSourceInfo);
    }

    @Override // com.tencent.mobileqq.guild.mainframe.i
    public ViewModelStoreOwner y() {
        return this.f227465a.y();
    }
}
