package com.tencent.mobileqq.guild.mainframe;

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
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes14.dex */
public interface i {
    sr1.d N();

    boolean P();

    void R(@NonNull GuildAppReportSourceInfo guildAppReportSourceInfo);

    GuildCenterPanelController Z0();

    @NonNull
    GuildFacadeType a();

    int b();

    void c(LaunchGuildChatPieParam launchGuildChatPieParam);

    void d(int i3);

    vr1.a d1();

    DragFrameLayout e();

    GuildStartPanelRightController e1();

    void f(GuildMainFrameJumpParam guildMainFrameJumpParam);

    GuildAppReportSourceInfo f0();

    boolean g(String str);

    QBaseActivity getActivity();

    AppRuntime getApp();

    FragmentManager getChildFragmentManager();

    <T> T getHelper(int i3);

    LifecycleOwner getLifecycleOwner();

    ViewGroup getRootView();

    void guildCenterPanelInOrOut(int i3, boolean z16);

    void h(int i3, String str, @Nullable GuildAppReportSourceInfo guildAppReportSourceInfo);

    ViewModelStoreOwner y();
}
