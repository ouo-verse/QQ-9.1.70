package com.qzone.reborn.layer.part;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.viewpager2.widget.ViewPager2;
import com.qzone.reborn.event.QZoneFeedxLayerScrollToQFSEvent;
import com.tencent.biz.qqcircle.events.QFSLayerPolymerizeDetailPreloadFinishEvent;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.part.adapter.widget.RFWConcatAdapter;
import com.tencent.biz.richframework.video.rfw.player.playinterceptor.RFWPlayerPreRenderHelper;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.auto.engine.lib.ASEngineConstants;
import com.tencent.mobileqq.auto.engine.lib.ASEnterBean;
import com.tencent.mobileqq.auto.engine.main.IASFragment;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.studymode.api.IStudyModeManager;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.gallery.bean.RFWLayerItemMediaInfo;
import com.tencent.richframework.gallery.bean.RFWLayerState;
import com.tencent.richframework.gallery.widget.RFWGalleryViewPager;
import com.tencent.richframework.widget.drag.RFWDragLayout;
import cooperation.qqcircle.report.datong.QCircleDTLoginReporter;
import cooperation.qzone.model.PhotoParam;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes37.dex */
public class QZoneFeedxLayerQFSPart extends ap implements SimpleEventReceiver {
    private ViewPager2 G;
    private ok.b H;
    private IASFragment I;
    private RFWDragLayout J;
    private String K;
    private final AtomicInteger L = new AtomicInteger(0);
    private volatile boolean M = false;

    /* loaded from: classes37.dex */
    class a extends ViewPager2.OnPageChangeCallback {
        a() {
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageSelected(int i3) {
            super.onPageSelected(i3);
            QZoneFeedxLayerQFSPart.this.J.setFeatureEnable(i3 == 0);
            if (i3 == 1) {
                QZoneFeedxLayerQFSPart.this.S9();
            }
        }
    }

    private boolean R9() {
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_qzone_ugc_use_diy_login_report", true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void S9() {
        if (!this.M && R9()) {
            this.M = true;
            QLog.d("QZoneFeedxLayerQFSPart", 1, "doLoginReport");
            ASEnterBean T9 = T9(uq3.c.i4());
            QCircleDTLoginReporter.daTongLoginReport(T9.getSchemeAction(), T9.getAttrs());
        }
    }

    protected static ASEnterBean T9(String str) {
        return new ASEnterBean(ASEngineConstants.BusinessKey.BUSINESS_QCIRCLE).convertSchemeToBean(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V9() {
        if (getActivity() != null && !getActivity().isFinishing() && !getActivity().isDestroyed()) {
            PhotoParam photoParam = this.f57988i;
            if (photoParam == null || TextUtils.isEmpty(photoParam.singleVideoQCircleSchema) || this.I == null) {
                return;
            }
            if (this.L.get() < 2 && uq3.c.V()) {
                QLog.d("QZoneFeedxLayerQFSPart", 1, "initQFSAdapter return data not ready");
                return;
            }
            ok.b bVar = new ok.b();
            this.H = bVar;
            bVar.m0(this.I);
            if (this.G.getAdapter() instanceof RFWConcatAdapter) {
                ((RFWConcatAdapter) this.G.getAdapter()).addAdapter(this.H);
                return;
            }
            return;
        }
        Y9();
    }

    private void W9() {
        if (this.H != null || getActivity() == null || getActivity().isFinishing() || getActivity().isDestroyed() || !(this.G.getAdapter() instanceof RFWConcatAdapter)) {
            return;
        }
        com.tencent.mobileqq.auto.engine.main.fragment.c.k("QZONE_LAYER").i();
        this.I = U9(getActivity(), uq3.c.i4(), "QZONE_LAYER");
    }

    private void X9(RFWLayerState rFWLayerState) {
        RFWLayerItemMediaInfo rFWLayerItemMediaInfo;
        if (rFWLayerState.getSelectedPosition() != 0 || (rFWLayerItemMediaInfo = this.mCurrentSelectedItem) == null || rFWLayerItemMediaInfo.getLayerVideoInfo() == null) {
            return;
        }
        this.K = this.mCurrentSelectedItem.getLayerVideoInfo().getFileId();
    }

    private void Y9() {
        IASFragment iASFragment = this.I;
        if (iASFragment != null) {
            iASFragment.onDestroy();
            com.tencent.mobileqq.auto.engine.main.fragment.c.k("QZONE_LAYER").i();
        }
    }

    public IASFragment U9(Activity activity, String str, String str2) {
        HashMap<String, String> attrs;
        Bundle bundle = new Bundle();
        ASEnterBean T9 = T9(str);
        if (R9() && (attrs = T9.getAttrs()) != null) {
            attrs.put("is_force_login_report", "0");
        }
        bundle.putSerializable(ASEngineConstants.ShadowEngineKey.KEY_AS_ENTER_BEAN, T9);
        IASFragment l3 = com.tencent.mobileqq.auto.engine.main.fragment.c.k(str2).l(activity, null, T9);
        if (activity != null) {
            try {
                l3.setHostActivity(activity);
                l3.setArguments(bundle);
                if (l3.getTargetDecorView() == null) {
                    l3.onCreateView(activity.getLayoutInflater(), null, null);
                    l3.onResume();
                    l3.onPause();
                    l3.onStop();
                }
            } catch (Exception e16) {
                QLog.e(getTAG(), 1, "getIASFragmentByScheme exception:", e16);
            }
        }
        return l3;
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        ArrayList<Class> arrayList = new ArrayList<>();
        arrayList.add(QFSLayerPolymerizeDetailPreloadFinishEvent.class);
        return arrayList;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void handleBroadcastMessage(String str, Object obj) {
        super.handleBroadcastMessage(str, obj);
        if (TextUtils.equals("FEEDX_LAYER_SINGLE_VIDEO_INIT_SUCCESS", str)) {
            QLog.d("QZoneFeedxLayerQFSPart", 1, "ON SINGLE_VIDEO_INIT_SUCCESS");
            this.L.incrementAndGet();
            V9();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.reborn.layer.part.ap
    public void initIntentData(Bundle bundle) {
        super.initIntentData(bundle);
    }

    @Override // com.qzone.reborn.layer.part.ap, com.tencent.biz.richframework.part.Part
    public boolean isPartEnable() {
        return (!super.isPartEnable() || ((IStudyModeManager) QRoute.api(IStudyModeManager.class)).getStudyModeSwitch() || com.qzone.reborn.util.k.f59549a.a() || SimpleUIUtil.isNowElderMode()) ? false : true;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        super.onInitView(view);
        ViewPager2 viewPager2 = ((RFWGalleryViewPager) view.findViewById(R.id.f73943ux)).getViewPager2();
        this.G = viewPager2;
        viewPager2.setOffscreenPageLimit(-1);
        this.G.setOrientation(1);
        this.J = (RFWDragLayout) view.findViewById(R.id.ulf);
        this.G.registerOnPageChangeCallback(new a());
        SimpleEventBus.getInstance().registerReceiver(this);
        W9();
        QLog.d("QZoneFeedxLayerQFSPart", 1, "onInitView");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.reborn.layer.part.ap
    public void onLayerStateUpdate(RFWLayerState rFWLayerState) {
        super.onLayerStateUpdate(rFWLayerState);
        X9(rFWLayerState);
        SimpleEventBus.getInstance().dispatchEvent(new QZoneFeedxLayerScrollToQFSEvent(rFWLayerState.getSelectedPosition() != 0, this.K));
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        SimpleEventBus.getInstance().unRegisterReceiver(this);
        Y9();
        RFWPlayerPreRenderHelper.getInstance().releaseRender();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartPause(Activity activity) {
        super.onPartPause(activity);
        IASFragment iASFragment = this.I;
        if (iASFragment != null) {
            iASFragment.onPause();
        }
    }

    @Override // com.qzone.reborn.layer.part.ap, com.tencent.biz.richframework.part.Part
    public void onPartResume(Activity activity) {
        super.onPartResume(activity);
        IASFragment iASFragment = this.I;
        if (iASFragment != null) {
            iASFragment.onResume();
        }
    }

    @Override // com.qzone.reborn.layer.part.ap, com.tencent.biz.richframework.part.Part
    public void onPartStop(Activity activity) {
        super.onPartStop(activity);
        IASFragment iASFragment = this.I;
        if (iASFragment != null) {
            iASFragment.onStop();
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        if ((simpleBaseEvent instanceof QFSLayerPolymerizeDetailPreloadFinishEvent) && uq3.c.V()) {
            QLog.d("QZoneFeedxLayerQFSPart", 1, "ON QFS DATA PREPARE FINISH");
            getMainHandler().post(new Runnable() { // from class: com.qzone.reborn.layer.part.QZoneFeedxLayerQFSPart.2
                @Override // java.lang.Runnable
                public void run() {
                    if (QZoneFeedxLayerQFSPart.this.H != null) {
                        return;
                    }
                    QZoneFeedxLayerQFSPart.this.L.incrementAndGet();
                    QZoneFeedxLayerQFSPart.this.V9();
                }
            });
        }
    }
}
