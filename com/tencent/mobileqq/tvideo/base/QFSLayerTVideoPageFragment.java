package com.tencent.mobileqq.tvideo.base;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.view.OrientationEventListener;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import androidx.annotation.NonNull;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.beans.QCircleLayerBean;
import com.tencent.biz.qqcircle.events.QCircleConfigChangeEvent;
import com.tencent.biz.qqcircle.fragments.QCircleBaseFragment;
import com.tencent.biz.qqcircle.immersive.QFSLayerPageFragment;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.part.TagData;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.tvideo.TVideoLayerBean;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.QAdVrReportParams;
import com.tencent.mobileqq.tvideo.channel.event.QFSTVideoChannelClickEvent;
import com.tencent.mobileqq.tvideo.event.QFSTVideoAuthPayReloadEvent;
import com.tencent.mobileqq.tvideo.event.QFSTVideoFeedsItemSelectedEvent;
import com.tencent.mobileqq.tvideo.event.QFSTVideoFloatingWindowEvent;
import com.tencent.mobileqq.tvideo.floatingwindow.j;
import com.tencent.mobileqq.tvideo.like.QFSTVideoEnterReloadEvent;
import com.tencent.mobileqq.tvideo.net.utils.TVideoConfig;
import com.tencent.mobileqq.tvideo.recorder.TVideoPlayRecorder;
import com.tencent.mobileqq.tvideo.view.QFSTVideoPageTurnContainer;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.common.screen.ScreenUtils;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.richframework.thread.RFWThreadManager;
import cooperation.qqcircle.report.QCircleReportBean;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import tvideo.Video;
import uq3.k;

/* loaded from: classes19.dex */
public class QFSLayerTVideoPageFragment extends QFSLayerPageFragment implements com.tencent.mobileqq.pad.f {
    private QFSTVideoPageTurnContainer F;
    private OrientationEventListener G;
    private QCircleInitBean H;
    private Video I;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes19.dex */
    public class a extends OrientationEventListener {
        a(Context context, int i3) {
            super(context, i3);
        }

        @Override // android.view.OrientationEventListener
        public void onOrientationChanged(int i3) {
            if (com.tencent.mobileqq.tvideo.floatingwindow.h.l().r()) {
                QLog.d("QFSLayerTVideoPageFragment", 4, "isInFloatingWindowMode");
                return;
            }
            if (i3 == -1) {
                return;
            }
            if (i3 > 355 || i3 < 5) {
                QFSLayerTVideoPageFragment.this.Rh();
            } else if (i3 > 265 && i3 < 275) {
                QFSLayerTVideoPageFragment.this.Qh();
            }
        }
    }

    private boolean Fh(int i3) {
        if (jy2.g.w() && jy2.g.h() != i3) {
            QLog.d("QFSLayerTVideoPageFragment", 4, "canChangeScreenOrientation false");
            return false;
        }
        if (jy2.g.A(this.I)) {
            QLog.d("QFSLayerTVideoPageFragment", 4, "canChangeScreenOrientation isFullScreenVideo false");
            return false;
        }
        if (fb0.a.a("QFSLayerTVideoPageFragment_change_screen_fast_check")) {
            QLog.d("QFSLayerTVideoPageFragment", 4, "canChangeScreenOrientation isFastDoubleClick return false");
            return false;
        }
        QLog.d("QFSLayerTVideoPageFragment", 4, "canChangeScreenOrientation true");
        return true;
    }

    private void Gh() {
        if (qx2.a.c().j()) {
            QLog.d("QFSLayerTVideoPageFragment", 4, "isHasPayVipFromH5 true");
            QFSTVideoAuthPayReloadEvent qFSTVideoAuthPayReloadEvent = new QFSTVideoAuthPayReloadEvent();
            qFSTVideoAuthPayReloadEvent.setIgnorePos(true);
            SimpleEventBus.getInstance().dispatchEvent(qFSTVideoAuthPayReloadEvent);
            qx2.a.c().n(false);
        }
    }

    private void Hh() {
        QCircleInitBean qCircleInitBean;
        if (getArguments() == null || (qCircleInitBean = (QCircleInitBean) getArguments().getSerializable("key_bundle_common_init_bean")) == null) {
            return;
        }
        this.H = qCircleInitBean;
        Ph();
    }

    private void Ih(int i3) {
        if (AppSetting.t(getContext()) && getActivity() != null) {
            getActivity().setRequestedOrientation(i3);
        }
    }

    private void Jh(boolean z16) {
        if (!z16) {
            k.a().m("tvideo_floating_window_permission_count_key", k.a().e("tvideo_floating_window_permission_count_key", 0) + 1);
            k.a().n("tvideo_floating_window_permission_time_key", System.currentTimeMillis());
        }
        getMainHandler().post(new Runnable() { // from class: com.tencent.mobileqq.tvideo.base.d
            @Override // java.lang.Runnable
            public final void run() {
                QFSLayerTVideoPageFragment.Mh();
            }
        });
    }

    @SuppressLint({"WrongConstant"})
    private void Kh(QCircleConfigChangeEvent qCircleConfigChangeEvent) {
        Window window = getActivity().getWindow();
        if (qCircleConfigChangeEvent != null && window != null) {
            int i3 = qCircleConfigChangeEvent.configuration.orientation;
            QLog.d("QFSLayerTVideoPageFragment", 4, "handleConfigurationChange orientation : " + i3);
            if (i3 == 2) {
                window.setFlags(1024, 1024);
                int i16 = Build.VERSION.SDK_INT;
                window.getDecorView().setSystemUiVisibility(2818);
                if (i16 >= 28) {
                    WindowManager.LayoutParams attributes = window.getAttributes();
                    attributes.layoutInDisplayCutoutMode = 1;
                    window.setAttributes(attributes);
                }
                Oh(2);
                return;
            }
            if (window.getDecorView() == null) {
                return;
            }
            WindowManager.LayoutParams attributes2 = window.getAttributes();
            attributes2.flags &= -1025;
            window.setAttributes(attributes2);
            window.clearFlags(512);
            Oh(1);
        }
    }

    private void Lh() {
        Ih(1);
        if (!TVideoConfig.f304492a.o() && !AppSetting.t(getActivity())) {
            if (!jy2.g.I()) {
                QLog.d("QFSLayerTVideoPageFragment", 4, "isScreenAutoRotate: false");
                return;
            } else {
                this.G = new a(getActivity(), 2);
                return;
            }
        }
        QLog.d("QFSLayerTVideoPageFragment", 4, "isPad");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void Mh() {
        QFSTVideoFloatingWindowEvent qFSTVideoFloatingWindowEvent = new QFSTVideoFloatingWindowEvent(true);
        qFSTVideoFloatingWindowEvent.setAuto(true);
        SimpleEventBus.getInstance().dispatchEvent(qFSTVideoFloatingWindowEvent);
    }

    private void Oh(int i3) {
        VideoReport.setPageParams(((QCircleBaseFragment) this).mContentView, QAdVrReportParams.ParamKey.PLAYBOX_TYPE, Integer.valueOf(i3));
        VideoReport.reportPgIn(((QCircleBaseFragment) this).mContentView);
    }

    private void Ph() {
        RFWThreadManager.getInstance().runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.tvideo.base.QFSLayerTVideoPageFragment.2
            @Override // java.lang.Runnable
            public void run() {
                QLog.d("QFSLayerTVideoPageFragment", 1, "sendReloadEvent");
                QFSTVideoEnterReloadEvent qFSTVideoEnterReloadEvent = new QFSTVideoEnterReloadEvent();
                qFSTVideoEnterReloadEvent.setLayerBean((QCircleLayerBean) QFSLayerTVideoPageFragment.this.H);
                SimpleEventBus.getInstance().dispatchEvent(qFSTVideoEnterReloadEvent);
                qx2.a.c().n(false);
            }
        }, 100L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Qh() {
        try {
            if (!Fh(0)) {
                return;
            }
            QLog.d("QFSLayerTVideoPageFragment", 4, "setLandscape");
            if (!ScreenUtils.isLandscape()) {
                QLog.d("QFSLayerTVideoPageFragment", 4, "can setLandscape");
                jy2.g.R(getActivity(), 0, false);
            } else {
                QLog.d("QFSLayerTVideoPageFragment", 4, "isLandscape now");
                jy2.g.O(false);
            }
        } catch (Exception e16) {
            QLog.d("QFSLayerTVideoPageFragment", 4, "setLandscape Exception " + e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Rh() {
        try {
            if (!Fh(1)) {
                return;
            }
            QLog.d("QFSLayerTVideoPageFragment", 4, "setPortrait");
            if (!ScreenUtils.isPortrait()) {
                QLog.d("QFSLayerTVideoPageFragment", 4, "can setPortrait");
                jy2.g.R(getActivity(), 1, false);
            } else {
                jy2.g.O(false);
                QLog.d("QFSLayerTVideoPageFragment", 4, "isPortrait now");
            }
        } catch (Exception e16) {
            QLog.d("QFSLayerTVideoPageFragment", 4, "setPortrait Exception " + e16);
        }
    }

    private void setDtCustomPageId(Map<String, Object> map, Object obj) {
        if (map != null && (obj instanceof QCircleReportBean)) {
            Object obj2 = map.get("xsj_custom_pgid");
            if (!(obj2 instanceof String)) {
                return;
            }
            ((QCircleReportBean) obj).setDtCustomPageId((String) obj2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Nh(boolean z16, boolean z17) {
        gy2.c.u(z16, z17);
    }

    @Override // com.tencent.biz.qqcircle.immersive.QFSLayerPageFragment, com.tencent.biz.qqcircle.fragments.QCircleBaseFragment
    public Map<String, Object> getChildDaTongPageParams() {
        HashMap hashMap = new HashMap();
        QCircleInitBean initBean = getInitBean();
        if (initBean instanceof TVideoLayerBean) {
            Video q16 = jy2.g.q(initBean.getFeed());
            if (q16 != null) {
                hashMap.put(QAdVrReportParams.ParamKey.PG_VID, q16.video_base_info.vid);
                hashMap.put(QAdVrReportParams.ParamKey.PG_CID, q16.video_base_info.cid);
                hashMap.put("material_vid", q16.video_base_info.material_aspect_vid);
                hashMap.put("material_starting_time", Integer.valueOf(q16.video_base_info.material_starting_time));
                hashMap.put("material_end_time", Integer.valueOf(q16.video_base_info.material_end_time));
            }
            hashMap.put(QAdVrReportParams.ParamKey.PLAYBOX_TYPE, Integer.valueOf(gy2.c.r()));
        }
        return hashMap;
    }

    @Override // com.tencent.biz.qqcircle.immersive.QFSLayerPageFragment, com.tencent.biz.richframework.part.BasePartFragment
    protected int getContentLayoutId() {
        return R.layout.f168704gh4;
    }

    @Override // com.tencent.biz.qqcircle.immersive.QFSLayerPageFragment, com.tencent.biz.qqcircle.fragments.QCircleBaseFragment
    public String getDaTongPageId() {
        return "page_ugqqoa_play";
    }

    @Override // com.tencent.biz.qqcircle.immersive.QFSBaseFragment, com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        ArrayList<Class> eventClass = super.getEventClass();
        eventClass.add(QCircleConfigChangeEvent.class);
        eventClass.add(QFSTVideoChannelClickEvent.class);
        eventClass.add(QFSTVideoFeedsItemSelectedEvent.class);
        return eventClass;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.immersive.QFSLayerPageFragment
    public QCircleInitBean getInitBean() {
        QCircleInitBean qCircleInitBean = this.H;
        if (qCircleInitBean != null) {
            return qCircleInitBean;
        }
        QCircleInitBean initBean = super.getInitBean();
        if (initBean == null && getArguments() != null) {
            QCircleInitBean qCircleInitBean2 = (QCircleInitBean) getArguments().getSerializable("key_bundle_common_init_bean");
            this.H = qCircleInitBean2;
            return qCircleInitBean2;
        }
        this.H = initBean;
        return initBean;
    }

    @Override // com.tencent.biz.qqcircle.immersive.QFSLayerPageFragment, com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QFSLayerTVideoPageFragment";
    }

    @Override // com.tencent.biz.qqcircle.immersive.QFSLayerPageFragment, com.tencent.biz.qqcircle.fragments.QCircleBaseFragment
    public int getPageId() {
        return 57;
    }

    @Override // com.tencent.biz.qqcircle.immersive.QFSLayerPageFragment, com.tencent.biz.qqcircle.immersive.QFSBaseFragment, com.tencent.biz.richframework.part.ImmersivePartFragment
    protected boolean needSupportFullScreen() {
        return true;
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public boolean onBackEvent() {
        if (getPartManager().onBackEvent()) {
            return true;
        }
        if (getActivity() == null) {
            return false;
        }
        if (((Activity) getContext()).getResources().getConfiguration().orientation == 2) {
            jy2.g.Q(getActivity(), 1);
            return true;
        }
        if (com.tencent.mobileqq.tvideo.floatingwindow.a.a().c()) {
            boolean g16 = j.g();
            Jh(g16);
            Nh(g16, false);
            return true;
        }
        Nh(false, false);
        return false;
    }

    @Override // com.tencent.biz.qqcircle.fragments.QCircleBaseFragment
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(@NonNull Configuration configuration) {
        super.onConfigurationChanged(configuration);
        Ih(1);
        QLog.i("QFSLayerTVideoPageFragment", 1, "onConfigurationChanged newConfig  : " + configuration.orientation);
    }

    @Override // com.tencent.biz.qqcircle.immersive.QFSLayerPageFragment, com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Lh();
    }

    @Override // com.tencent.biz.qqcircle.immersive.QFSBaseFragment, com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        OrientationEventListener orientationEventListener = this.G;
        if (orientationEventListener != null) {
            orientationEventListener.disable();
        }
        Ih(3);
    }

    @Override // com.tencent.biz.qqcircle.immersive.QFSBaseFragment, com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onDetach() {
        super.onDetach();
        TVideoPlayRecorder.f304757a.d();
        com.tencent.mobileqq.tvideo.binge.data.b.d().b();
    }

    @Override // com.tencent.biz.qqcircle.immersive.QFSLayerPageFragment, com.tencent.biz.qqcircle.immersive.QFSBaseFragment, com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        OrientationEventListener orientationEventListener = this.G;
        if (orientationEventListener != null) {
            orientationEventListener.disable();
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.QFSBaseFragment, com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        super.onReceiveEvent(simpleBaseEvent);
        if (simpleBaseEvent instanceof QCircleConfigChangeEvent) {
            Kh((QCircleConfigChangeEvent) simpleBaseEvent);
            return;
        }
        if (simpleBaseEvent instanceof QFSTVideoChannelClickEvent) {
            VideoReport.setPageParams(((QCircleBaseFragment) this).mContentView, "ztid", Integer.valueOf(ox2.b.e().d()));
            VideoReport.reportPgIn(((QCircleBaseFragment) this).mContentView);
        } else if (simpleBaseEvent instanceof QFSTVideoFeedsItemSelectedEvent) {
            this.I = ((QFSTVideoFeedsItemSelectedEvent) simpleBaseEvent).getTVideoFeed();
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.QFSLayerPageFragment, com.tencent.biz.qqcircle.immersive.QFSBaseFragment, com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        OrientationEventListener orientationEventListener = this.G;
        if (orientationEventListener != null) {
            orientationEventListener.enable();
        }
        Gh();
    }

    @Override // com.tencent.biz.richframework.part.ImmersivePartFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.F = (QFSTVideoPageTurnContainer) view.findViewById(R.id.f165301vg1);
        if (iy2.a.e()) {
            jy2.g.Q(getActivity(), 0);
        }
    }

    @Override // com.tencent.mobileqq.pad.f
    public boolean qOnBackPressed() {
        return false;
    }

    @Override // com.tencent.mobileqq.pad.f
    public void qOnNewIntent() {
        Hh();
    }

    @Override // com.tencent.biz.qqcircle.fragments.QCircleBaseFragment
    public void registerDaTongReportPageId() {
        if (((QCircleBaseFragment) this).mContentView == null) {
            QLog.i("QFSLayerTVideoPageFragment", 1, "reportDaTongRegister  mContentView == null , subPage: " + getTAG());
            return;
        }
        VideoReport.addToDetectionWhitelist(getActivity());
        String daTongPageId = getDaTongPageId();
        Map<String, Object> childDaTongPageParams = getChildDaTongPageParams();
        VideoReport.setPageParams(((QCircleBaseFragment) this).mContentView, gy2.c.f(getTAG(), childDaTongPageParams));
        VideoReport.setPageId(((QCircleBaseFragment) this).mContentView, daTongPageId);
        Object createViewTagData = createViewTagData();
        setDtCustomPageId(childDaTongPageParams, createViewTagData);
        ((QCircleBaseFragment) this).mContentView.setTag(TagData.TAG_DATA_ID, createViewTagData);
    }
}
