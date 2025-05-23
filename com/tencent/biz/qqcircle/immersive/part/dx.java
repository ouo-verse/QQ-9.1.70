package com.tencent.biz.qqcircle.immersive.part;

import android.text.TextUtils;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import com.tencent.biz.qqcircle.fragments.QCircleBaseFragment;
import com.tencent.biz.qqcircle.immersive.feed.event.QFSFeedOrientationChangeEvent;
import com.tencent.biz.qqcircle.immersive.feed.event.QFSHotCommentSwitchChangeEvent;
import com.tencent.biz.qqcircle.proxy.delegate.QCircleToast;
import com.tencent.biz.qqcircle.widgets.person.QFSSettingSwitchView;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.requests.QCircleSetCircleSwitchRequest;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.data.IDynamicParams;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.util.Map;
import qqcircle.QQCircleSwitch$SetCircleSwitchRsp;

/* compiled from: P */
/* loaded from: classes4.dex */
public class dx extends com.tencent.biz.qqcircle.bizparts.b implements View.OnClickListener {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class a implements QFSSettingSwitchView.b {
        a() {
        }

        @Override // com.tencent.biz.qqcircle.widgets.person.QFSSettingSwitchView.b
        public void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
            QLog.d("QFSPlayerSettingContentPart", 1, "FloatWindowAutoTriggerSwitch:" + z16);
            if (!z16) {
                p40.n.e().t(false);
            }
            com.tencent.biz.qqcircle.f.Z(z16);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class b implements QFSSettingSwitchView.b {
        b() {
        }

        @Override // com.tencent.biz.qqcircle.widgets.person.QFSSettingSwitchView.b
        public void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
            com.tencent.biz.qqcircle.f.a0(z16);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class c implements QFSSettingSwitchView.b {
        c() {
        }

        @Override // com.tencent.biz.qqcircle.widgets.person.QFSSettingSwitchView.b
        public void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
            dx.this.E9(z16);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class d implements QFSSettingSwitchView.b {
        d() {
        }

        @Override // com.tencent.biz.qqcircle.widgets.person.QFSSettingSwitchView.b
        public void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
            dx.this.D9(z16);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class e implements VSDispatchObserver.OnVSRspCallBack<QQCircleSwitch$SetCircleSwitchRsp> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f88010a;

        e(boolean z16) {
            this.f88010a = z16;
        }

        @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, QQCircleSwitch$SetCircleSwitchRsp qQCircleSwitch$SetCircleSwitchRsp) {
            String str2;
            if (z16 && j3 == 0) {
                uq3.g.e("sp_key_user_hot_comment_enable", Boolean.valueOf(this.f88010a));
                if (this.f88010a) {
                    str2 = "1";
                } else {
                    str2 = "0";
                }
                uq3.c.h7("qqcircle", "qqcircle_hotcomment_user_switch", str2);
                SimpleEventBus.getInstance().dispatchEvent(new QFSHotCommentSwitchChangeEvent());
                return;
            }
            if (TextUtils.isEmpty(str)) {
                str = com.tencent.biz.qqcircle.utils.h.a(R.string.ci8);
            }
            QCircleToast.o(str, 0);
            QLog.e("QFSPlayerSettingContentPart", 1, "set switch error! isSuccess " + z16 + " retcode = " + j3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class f implements VSDispatchObserver.OnVSRspCallBack<QQCircleSwitch$SetCircleSwitchRsp> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f88012a;

        f(boolean z16) {
            this.f88012a = z16;
        }

        @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, QQCircleSwitch$SetCircleSwitchRsp qQCircleSwitch$SetCircleSwitchRsp) {
            String str2;
            if (z16 && j3 == 0) {
                if (this.f88012a) {
                    str2 = "1";
                } else {
                    str2 = "0";
                }
                uq3.c.e7("qqcircle", "qqcircle_autoslide_user_switch", str2);
                return;
            }
            if (TextUtils.isEmpty(str)) {
                str = com.tencent.biz.qqcircle.utils.h.a(R.string.ci8);
            }
            QCircleToast.o(str, 0);
            QLog.e("QFSPlayerSettingContentPart", 1, "set switch error! isSuccess " + z16 + " retcode = " + j3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class g implements IDynamicParams {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f88014a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ QFSSettingSwitchView f88015b;

        g(String str, QFSSettingSwitchView qFSSettingSwitchView) {
            this.f88014a = str;
            this.f88015b = qFSSettingSwitchView;
        }

        @Override // com.tencent.qqlive.module.videoreport.data.IDynamicParams
        public Map<String, Object> getDynamicParams(String str) {
            Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
            buildElementParams.put(this.f88014a, Integer.valueOf(this.f88015b.F0() ? 1 : 0));
            return buildElementParams;
        }
    }

    private void C9() {
        if (!getPartManager().onBackEvent() && getActivity() != null) {
            getActivity().finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D9(boolean z16) {
        String str;
        if (z16) {
            str = "1";
        } else {
            str = "0";
        }
        VSNetworkHelper.getInstance().sendRequest(new QCircleSetCircleSwitchRequest("qqcircle", "qqcircle_autoslide_user_switch", str), new f(z16));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E9(boolean z16) {
        String str;
        if (z16) {
            str = "1";
        } else {
            str = "0";
        }
        VSNetworkHelper.getInstance().sendRequest(new QCircleSetCircleSwitchRequest("qqcircle", "qqcircle_hotcomment_user_switch", str), new e(z16));
    }

    private void F9(final boolean z16) {
        final String valueOf;
        if (z16) {
            valueOf = String.valueOf(1);
        } else {
            valueOf = String.valueOf(0);
        }
        final QCircleSetCircleSwitchRequest qCircleSetCircleSwitchRequest = new QCircleSetCircleSwitchRequest("qqcircle", "qqcircle_feed_orientation_switch", valueOf);
        VSNetworkHelper.getInstance().sendRequest(qCircleSetCircleSwitchRequest, new VSDispatchObserver.OnVSRspCallBack() { // from class: com.tencent.biz.qqcircle.immersive.part.dw
            @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
            public final void onReceive(BaseRequest baseRequest, boolean z17, long j3, String str, Object obj) {
                dx.L9(QCircleSetCircleSwitchRequest.this, z16, valueOf, baseRequest, z17, j3, str, obj);
            }
        });
    }

    private void G9(View view) {
        if (!uq3.c.E6()) {
            return;
        }
        QFSSettingSwitchView qFSSettingSwitchView = (QFSSettingSwitchView) view.findViewById(R.id.f33910xq);
        qFSSettingSwitchView.setVisibility(0);
        qFSSettingSwitchView.setCheckedOnly(uq3.c.d5());
        qFSSettingSwitchView.setListener(new d());
        N9(qFSSettingSwitchView, QCircleDaTongConstant.ElementId.EM_XSJ_AUTOPLAY_SETTING_BUTTON, QCircleDaTongConstant.ElementParamKey.XSJ_AUTOPLAY_SETTING_BUTTON_STATE);
    }

    private void H9(View view) {
        if (!com.tencent.biz.qqcircle.f.f()) {
            QLog.d("QFSPlayerSettingContentPart", 1, "enableDefaultMuteFromWNS false, return");
            return;
        }
        QFSSettingSwitchView qFSSettingSwitchView = (QFSSettingSwitchView) view.findViewById(R.id.f30910pm);
        qFSSettingSwitchView.setVisibility(0);
        qFSSettingSwitchView.setChecked(com.tencent.biz.qqcircle.f.e());
        qFSSettingSwitchView.setListener(new b());
        N9(qFSSettingSwitchView, QCircleDaTongConstant.ElementId.EM_XSJ_LILENCE_ON_OFF_STATE, QCircleDaTongConstant.ElementParamKey.XSJ_PRIVACY_SETTING_BUTTON_STATE);
    }

    private void I9(View view) {
        if (!uq3.c.P5()) {
            return;
        }
        QFSSettingSwitchView qFSSettingSwitchView = (QFSSettingSwitchView) view.findViewById(R.id.f371616i);
        qFSSettingSwitchView.setVisibility(0);
        qFSSettingSwitchView.setCheckedOnly(uq3.c.b6());
        qFSSettingSwitchView.setListener(new QFSSettingSwitchView.b() { // from class: com.tencent.biz.qqcircle.immersive.part.dv
            @Override // com.tencent.biz.qqcircle.widgets.person.QFSSettingSwitchView.b
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
                dx.this.M9(compoundButton, z16);
            }
        });
        N9(qFSSettingSwitchView, QCircleDaTongConstant.ElementId.EM_XSJ_AUTO_ROTA, QCircleDaTongConstant.ElementParamKey.XSJ_PLAY_SETTING_BUTTON_STATE);
    }

    private void J9(View view) {
        if (!((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("102018", false)) {
            QLog.d("QFSPlayerSettingContentPart", 1, "initFloatWindowAutoTriggerSwitch:false");
            return;
        }
        if (!p40.n.e().k()) {
            QLog.d("QFSPlayerSettingContentPart", 1, "hitShareAndAutoEnter:false");
            return;
        }
        if (!p40.n.e().j()) {
            QLog.d("QFSPlayerSettingContentPart", 1, "no perMission:false");
            return;
        }
        QFSSettingSwitchView qFSSettingSwitchView = (QFSSettingSwitchView) view.findViewById(R.id.f371516h);
        qFSSettingSwitchView.setVisibility(0);
        qFSSettingSwitchView.setChecked(com.tencent.biz.qqcircle.f.c());
        qFSSettingSwitchView.setListener(new a());
        N9(qFSSettingSwitchView, QCircleDaTongConstant.ElementId.EX_XSJ_SMALL_WINDOWPLAY_SETTIN_BUTTON, QCircleDaTongConstant.ElementParamKey.XSJ_PLAY_SETTING_BUTTON_STATE);
    }

    private void K9(View view) {
        if (!com.tencent.biz.qqcircle.manager.i.a("qqcircle_hotcomment_user_switch_show")) {
            return;
        }
        QFSSettingSwitchView qFSSettingSwitchView = (QFSSettingSwitchView) view.findViewById(R.id.f31250qj);
        qFSSettingSwitchView.setVisibility(0);
        qFSSettingSwitchView.setCheckedOnly(uq3.c.g5());
        qFSSettingSwitchView.setListener(new c());
        N9(qFSSettingSwitchView, QCircleDaTongConstant.ElementId.EM_XSJ_HOTCOMMENT_SETTING_BUTTON, QCircleDaTongConstant.ElementParamKey.XSJ_PLAY_SETTING_BUTTON_STATE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void L9(QCircleSetCircleSwitchRequest qCircleSetCircleSwitchRequest, boolean z16, String str, BaseRequest baseRequest, boolean z17, long j3, String str2, Object obj) {
        String traceId;
        if (z17 && j3 == 0) {
            if (qCircleSetCircleSwitchRequest == null) {
                traceId = "null";
            } else {
                traceId = qCircleSetCircleSwitchRequest.getTraceId();
            }
            QLog.d("WNS-QFSPlayerSettingContentPart", 1, "[handleOrientationSwitchChange] secondaryKey: qqcircle_feed_orientation_switch | isChecked: " + z16 + " | switchVal: " + str + ", switch change success. traceId:" + traceId);
            uq3.c.e7("qqcircle", "qqcircle_feed_orientation_switch", str);
            SimpleEventBus.getInstance().dispatchEvent(new QFSFeedOrientationChangeEvent(z16));
            return;
        }
        if (TextUtils.isEmpty(str2)) {
            str2 = com.tencent.biz.qqcircle.utils.h.a(R.string.ci8);
        }
        QCircleToast.o(str2, 0);
        QLog.e("QFSPlayerSettingContentPart", 1, "[handleOrientationSwitchChange] set switch error! retCode = " + j3 + APLogFileUtil.SEPARATOR_LOG + qCircleSetCircleSwitchRequest.getTraceId());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void M9(CompoundButton compoundButton, boolean z16) {
        F9(z16);
    }

    private void N9(QFSSettingSwitchView qFSSettingSwitchView, String str, String str2) {
        VideoReport.setElementId(qFSSettingSwitchView.D0(), str);
        g gVar = new g(str2, qFSSettingSwitchView);
        VideoReport.setElementEndExposePolicy(qFSSettingSwitchView.D0(), EndExposurePolicy.REPORT_ALL);
        VideoReport.setEventDynamicParams(qFSSettingSwitchView.D0(), gVar);
    }

    @Override // com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QFSPlayerSettingContentPart";
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view.getId() == R.id.y_2) {
            C9();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        ImageView imageView = (ImageView) view.findViewById(R.id.y_2);
        imageView.setOnClickListener(this);
        if (getHostFragment() instanceof QCircleBaseFragment) {
            ((QCircleBaseFragment) getHostFragment()).setExcludeInteractiveView(imageView);
        }
        H9(view);
        K9(view);
        G9(view);
        I9(view);
        J9(view);
    }
}
