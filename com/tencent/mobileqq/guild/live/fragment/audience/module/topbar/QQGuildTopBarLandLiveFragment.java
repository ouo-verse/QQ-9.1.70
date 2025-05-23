package com.tencent.mobileqq.guild.live.fragment.audience.module.topbar;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.lifecycle.Observer;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.live.fragment.base.QQGuildLiveModuleBaseFragment;
import com.tencent.mobileqq.guild.live.fragment.base.module.topbar.QQGuildLiveBaseTopBarFragment;
import com.tencent.mobileqq.guild.live.livemanager.GLiveChannelCore;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes14.dex */
public class QQGuildTopBarLandLiveFragment extends QQGuildLiveBaseTopBarFragment implements View.OnClickListener {
    private final String D = "topBarLandLiveRootView";
    private ImageView E;

    private void rh(View view) {
        this.E = (ImageView) view.findViewById(R.id.wo7);
        if (!com.tencent.mobileqq.guild.live.viewmodel.d.P1()) {
            this.E.setVisibility(8);
        } else {
            this.E.setOnClickListener(this);
            GLiveChannelCore.f226698a.t().g().observe(getViewLifecycleOwner(), new Observer() { // from class: com.tencent.mobileqq.guild.live.fragment.audience.module.topbar.a
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    QQGuildTopBarLandLiveFragment.this.sh((Boolean) obj);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void sh(Boolean bool) {
        if (bool.booleanValue()) {
            this.E.setImageResource(R.drawable.guild_live_danmu_enable);
        } else {
            this.E.setImageResource(R.drawable.guild_live_danmu_disable);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void th() {
        nq1.g gVar = this.mLiveModuleControl;
        if (gVar != null && gVar.a() != null) {
            this.mLiveModuleControl.a().handleZoomFloatWindow(true);
        }
    }

    public static QQGuildLiveModuleBaseFragment uh() {
        return new QQGuildTopBarLandLiveFragment();
    }

    @SuppressLint({"SourceLockedOrientationActivity"})
    private void vh() {
        com.tencent.mobileqq.guild.performance.report.l.b(1, 1);
        yh();
    }

    private void wh() {
        GLiveChannelCore gLiveChannelCore = GLiveChannelCore.f226698a;
        if (!((Boolean) e12.d.b(gLiveChannelCore.t().n(), Boolean.FALSE)).booleanValue()) {
            QLog.w("QGL.QQGuildTopBarLandLiveFragment", 1, "onClickVideoFullScreenView, did not enter the room.");
        } else {
            gLiveChannelCore.t().V(Boolean.valueOf(!((Boolean) e12.d.b(gLiveChannelCore.t().g(), r2)).booleanValue()));
        }
    }

    @SuppressLint({"SourceLockedOrientationActivity"})
    private void xh() {
        com.tencent.mobileqq.guild.performance.report.l.b(1, 1);
        yh();
        ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.guild.live.fragment.audience.module.topbar.b
            @Override // java.lang.Runnable
            public final void run() {
                QQGuildTopBarLandLiveFragment.this.th();
            }
        }, 350L);
    }

    private void yh() {
        if (AppSetting.t(getContext())) {
            GLiveChannelCore.f226698a.t().b0(0);
        } else {
            GLiveChannelCore.f226698a.t().T(1);
        }
    }

    @Override // com.tencent.mobileqq.guild.live.fragment.base.QQGuildLiveModuleBaseFragment
    protected int getLayoutId() {
        return R.layout.ewq;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.live.fragment.base.module.topbar.QQGuildLiveBaseTopBarFragment, com.tencent.mobileqq.guild.live.fragment.base.QQGuildLiveModuleBaseFragment
    public void initView(@NonNull View view) {
        super.initView(view);
        QLog.d("QGL.QQGuildTopBarLandLiveFragment", 1, "[initView]  ");
        com.tencent.mobileqq.guild.live.livemanager.e showHideAnimHelper = getShowHideAnimHelper();
        if (showHideAnimHelper != null) {
            showHideAnimHelper.l(this.C, "topBarLandLiveRootView");
        }
        view.findViewById(R.id.x4h).setOnClickListener(this);
        View findViewById = view.findViewById(R.id.f165562wo2);
        findViewById.setOnClickListener(this);
        if (GLiveChannelCore.f226698a.s().getEnterSourceType().equals("functional_qq_little_world_feed")) {
            findViewById.setVisibility(8);
        }
        rh(view);
        HashMap hashMap = new HashMap();
        hashMap.put("sgroup_stream_aio_zoom", 2);
        ch.f235509b.setElementExposureAndClickParams(view.findViewById(R.id.x4h), "em_stream_aio_zoom", hashMap);
    }

    @Override // com.tencent.mobileqq.guild.live.fragment.base.module.topbar.QQGuildLiveBaseTopBarFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        QLog.d("QGL.QQGuildTopBarLandLiveFragment", 1, "[onAttach]  ");
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view.getId() == R.id.x4h) {
            vh();
        } else if (view.getId() == R.id.f165562wo2) {
            xh();
        } else if (view.getId() == R.id.wo7) {
            wh();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        QLog.d("QGL.QQGuildTopBarLandLiveFragment", 1, "[onDestroy]  ");
        com.tencent.mobileqq.guild.live.livemanager.e showHideAnimHelper = getShowHideAnimHelper();
        if (showHideAnimHelper != null) {
            showHideAnimHelper.L(this.C, "topBarLandLiveRootView");
        }
        super.onDestroy();
    }

    @Override // com.tencent.mobileqq.guild.live.fragment.base.module.topbar.QQGuildLiveBaseTopBarFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        QLog.d("QGL.QQGuildTopBarLandLiveFragment", 1, "[onDestroyView]  ");
    }

    @Override // com.tencent.mobileqq.guild.live.fragment.base.module.topbar.QQGuildLiveBaseTopBarFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onDetach() {
        super.onDetach();
        QLog.d("QGL.QQGuildTopBarLandLiveFragment", 1, "[onDetach]  ");
    }
}
