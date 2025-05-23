package com.tencent.mobileqq.guild.live.fragment;

import android.content.res.Configuration;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelStoreOwner;
import com.tencent.mobileqq.guild.live.livemanager.QQGuildOrientationSensorManager;
import com.tencent.mobileqq.guild.live.livemanager.s;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes14.dex */
public class QQGuildLiveRoomFragment extends QQGuildBaseLiveRoomFragment {
    private QQGuildOrientationSensorManager orientationSensorManager;
    private final String tag = "QGL.QQGuildLiveRoomFragment." + hashCode();

    /* compiled from: P */
    /* loaded from: classes14.dex */
    class a implements QQGuildOrientationSensorManager.b {
        a() {
        }

        @Override // com.tencent.mobileqq.guild.live.livemanager.QQGuildOrientationSensorManager.b
        public void a(int i3) {
            QQGuildLiveRoomFragment.this.updateOrientationAfterSensorNotify(i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateActivityOrientation(int i3) {
        QLog.d(this.tag, 2, "[updateActivityOrientation] orientation = " + i3);
        if (getActivity() == null) {
            QLog.e(this.tag, 1, "activity is null");
        } else {
            closeCardFragment();
            getActivity().setRequestedOrientation(i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateOrientationAfterSensorNotify(int i3) {
        QLog.d(this.tag, 4, "newOrientation = " + i3);
        boolean booleanValue = ((Boolean) e12.d.b(this.mLiveRoomUiData.J(), Boolean.TRUE)).booleanValue();
        boolean booleanValue2 = ((Boolean) e12.d.b(this.mLiveRoomUiData.n(), Boolean.FALSE)).booleanValue();
        if (booleanValue && getActivity() != null && booleanValue2) {
            com.tencent.mobileqq.guild.performance.report.l.b(3, i3);
            this.mLiveRoomUiData.T(i3);
            QLog.d(this.tag, 4, "[updateOrientation] to newOrientation = " + i3);
            return;
        }
        QLog.d(this.tag, 4, "[updateOrientation] illegal state");
    }

    @Override // com.tencent.mobileqq.guild.live.fragment.QQGuildBaseLiveRoomFragment
    protected void doFinish() {
        finishActivity();
    }

    @Override // com.tencent.mobileqq.guild.live.fragment.QQGuildBaseLiveRoomFragment
    protected void doLandscapeToPortraitOrientation() {
        this.mLiveRoomUiData.T(1);
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* bridge */ /* synthetic */ ViewModel getViewModel(ViewModelStoreOwner viewModelStoreOwner, String str, @NonNull Class cls) {
        return ne0.a.a(this, viewModelStoreOwner, str, cls);
    }

    @Override // com.tencent.mobileqq.guild.live.fragment.QQGuildBaseLiveRoomFragment, com.tencent.mobileqq.guild.live.fragment.base.QQGuildLiveModuleBaseFragment
    protected void initLiveDataObserver() {
        super.initLiveDataObserver();
        this.mLiveRoomUiData.d().observe(getViewLifecycleOwner(), new Observer() { // from class: com.tencent.mobileqq.guild.live.fragment.o
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QQGuildLiveRoomFragment.this.updateActivityOrientation(((Integer) obj).intValue());
            }
        });
        QLog.d(this.tag, 1, "initLiveDataObserver");
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(@Nullable Bundle bundle) {
        super.onActivityCreated(bundle);
        this.orientationSensorManager = new QQGuildOrientationSensorManager(new a());
    }

    @Override // com.tencent.mobileqq.guild.live.fragment.QQGuildBaseLiveRoomFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(@NonNull Configuration configuration) {
        boolean z16;
        super.onConfigurationChanged(configuration);
        if (configuration.orientation == 2) {
            z16 = true;
        } else {
            z16 = false;
        }
        this.mLiveRoomUiData.g0(gq1.b.b(getActivity()));
        checkToUpdateVideoState(z16);
    }

    @Override // com.tencent.mobileqq.guild.live.fragment.QQGuildBaseLiveRoomFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        QLog.i(this.tag, 1, "onDestroy.");
        QQGuildOrientationSensorManager qQGuildOrientationSensorManager = this.orientationSensorManager;
        if (qQGuildOrientationSensorManager != null) {
            qQGuildOrientationSensorManager.d();
        }
    }

    @Override // com.tencent.mobileqq.guild.live.fragment.QQGuildBaseLiveRoomFragment
    protected void onEnterRoomSuc() {
        boolean z16;
        super.onEnterRoomSuc();
        if (getResources().getConfiguration().orientation == 2) {
            z16 = true;
        } else {
            z16 = false;
        }
        checkToUpdateVideoState(z16);
    }

    @Override // com.tencent.mobileqq.guild.live.fragment.QQGuildBaseLiveRoomFragment, com.tencent.mobileqq.guild.live.fragment.base.QQGuildLiveModuleBaseFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment
    public void onFinish() {
        super.onFinish();
        QLog.i(this.tag, 1, "onFinish.");
        QQGuildOrientationSensorManager qQGuildOrientationSensorManager = this.orientationSensorManager;
        if (qQGuildOrientationSensorManager != null) {
            qQGuildOrientationSensorManager.d();
        }
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    @Deprecated
    public /* bridge */ /* synthetic */ void onPartTimeCostReport(String str, String str2, long j3) {
        ne0.a.e(this, str, str2, j3);
    }

    @Override // com.tencent.mobileqq.guild.live.fragment.QQGuildBaseLiveRoomFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        QLog.i(this.tag, 1, "onPause.");
        this.orientationSensorManager.d();
        s.f();
    }

    @Override // com.tencent.mobileqq.guild.live.fragment.QQGuildBaseLiveRoomFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        this.orientationSensorManager.f();
        s.g();
    }

    @Override // com.tencent.mobileqq.guild.live.fragment.QQGuildBaseLiveRoomFragment, com.tencent.mobileqq.guild.live.widget.GuildLiveSwipeBackLayout.c
    public boolean onSwipe(boolean z16) {
        QQGuildOrientationSensorManager qQGuildOrientationSensorManager = this.orientationSensorManager;
        if (qQGuildOrientationSensorManager != null) {
            qQGuildOrientationSensorManager.i(!z16);
        }
        return super.onSwipe(z16);
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public /* bridge */ /* synthetic */ void onUserLeaveHint() {
        com.tencent.biz.richframework.compat.f.m(this);
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public /* bridge */ /* synthetic */ boolean useArgusLifecycle() {
        return ne0.a.f(this);
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* bridge */ /* synthetic */ ViewModel getViewModel(String str, @NonNull Class cls) {
        return ne0.a.c(this, str, cls);
    }
}
