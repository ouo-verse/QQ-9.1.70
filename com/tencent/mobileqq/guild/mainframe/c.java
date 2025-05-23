package com.tencent.mobileqq.guild.mainframe;

import android.app.Activity;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelStoreOwner;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.guild.mainframe.centerpanel.GuildCenterPanelController;
import com.tencent.mobileqq.guild.mainframe.startpanel.leftbar.GuildLeftBarListController;
import com.tencent.mobileqq.guild.mainframe.startpanel.rightpart.GuildStartPanelRightController;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes14.dex */
public interface c {
    GuildLeftBarListController C1();

    sr1.d N();

    boolean P();

    void R(@NonNull GuildAppReportSourceInfo guildAppReportSourceInfo);

    FragmentManager Rc();

    GuildCenterPanelController Z0();

    vr1.a d1();

    GuildStartPanelRightController e1();

    GuildAppReportSourceInfo f0();

    Activity getActivity();

    AppRuntime getApp();

    Object getHelper(int i3);

    LifecycleOwner getLifecycleOwner();

    ViewGroup getRootView();

    DragFrameLayout jh();

    ViewModelStoreOwner y();
}
