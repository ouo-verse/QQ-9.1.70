package com.tencent.biz.qqcircle.bizparts;

import android.text.TextUtils;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.fragments.QCircleBaseFragment;
import com.tencent.biz.qqcircle.requests.QCircleSetUserSwitchRequest;
import com.tencent.biz.qqcircle.widgets.person.QFSSettingSwitchView;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.data.IDynamicParams;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Map;
import qqcircle.QQCircleFeedBase$StMainPageBasicBusiRspData;
import qqcircle.QQCircleProfile$SetUserSwitchRsp;

/* compiled from: P */
/* loaded from: classes4.dex */
public class bp extends com.tencent.biz.qqcircle.bizparts.b implements View.OnClickListener {

    /* renamed from: d, reason: collision with root package name */
    private QFSSettingSwitchView f82963d;

    /* renamed from: e, reason: collision with root package name */
    private List<Integer> f82964e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class a implements QFSSettingSwitchView.b {
        a() {
        }

        @Override // com.tencent.biz.qqcircle.widgets.person.QFSSettingSwitchView.b
        public void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
            if (compoundButton.isPressed()) {
                bp.this.E9(z16);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class b implements VSDispatchObserver.OnVSRspCallBack<QQCircleProfile$SetUserSwitchRsp> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f82966a;

        b(boolean z16) {
            this.f82966a = z16;
        }

        @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, QQCircleProfile$SetUserSwitchRsp qQCircleProfile$SetUserSwitchRsp) {
            if (z16 && j3 == 0) {
                com.tencent.biz.qqcircle.immersive.personal.utils.n.f89104a.c(bp.this.f82964e, 15, this.f82966a);
                QLog.d("QCircleNoticeSettingContentPart", 1, "switchChangeSuccess!");
            } else {
                com.tencent.biz.qqcircle.utils.cj.b(false, j3, str);
                QLog.d("QCircleNoticeSettingContentPart", 1, "switchChangeFail!");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public static class c implements IDynamicParams {

        /* renamed from: a, reason: collision with root package name */
        private final WeakReference<String> f82968a;

        /* renamed from: b, reason: collision with root package name */
        private final WeakReference<Boolean> f82969b;

        public c(String str, boolean z16) {
            this.f82968a = new WeakReference<>(str);
            this.f82969b = new WeakReference<>(Boolean.valueOf(z16));
        }

        @Override // com.tencent.qqlive.module.videoreport.data.IDynamicParams
        public Map<String, Object> getDynamicParams(String str) {
            Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
            buildElementParams.put(this.f82968a.get(), Integer.valueOf(this.f82969b.get().booleanValue() ? 1 : 0));
            return buildElementParams;
        }
    }

    private void B9() {
        if (!getPartManager().onBackEvent() && getActivity() != null) {
            getActivity().finish();
        }
    }

    private void C9(View view) {
        QFSSettingSwitchView qFSSettingSwitchView = (QFSSettingSwitchView) view.findViewById(R.id.f31720rt);
        this.f82963d = qFSSettingSwitchView;
        qFSSettingSwitchView.setVisibility(0);
        this.f82963d.setListener(new a());
        D9(this.f82963d, QCircleDaTongConstant.ElementId.EM_XSJ_INFORM_ON_OFF_STATE, QCircleDaTongConstant.ElementParamKey.XSJ_PRIVACY_SETTING_BUTTON_STATE);
    }

    private void D9(QFSSettingSwitchView qFSSettingSwitchView, String str, String str2) {
        VideoReport.setElementId(qFSSettingSwitchView.D0(), str);
        VideoReport.setEventDynamicParams(qFSSettingSwitchView.D0(), new c(str2, qFSSettingSwitchView.F0()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E9(boolean z16) {
        VSNetworkHelper.getInstance().sendRequest(new QCircleSetUserSwitchRequest(8, !z16 ? 1 : 0), new b(z16));
    }

    private void F9(boolean z16) {
        QFSSettingSwitchView qFSSettingSwitchView = this.f82963d;
        if (qFSSettingSwitchView != null) {
            qFSSettingSwitchView.setCheckedOnly(z16);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void G9() {
        int i3;
        String q16 = com.tencent.biz.qqcircle.immersive.utils.r.q();
        MutableLiveData globalData = w20.a.j().getGlobalData(QQCircleFeedBase$StMainPageBasicBusiRspData.class, q16);
        if (globalData != null && globalData.getValue() != 0 && ((QQCircleFeedBase$StMainPageBasicBusiRspData) globalData.getValue()).opMask.get() != null) {
            this.f82964e = ((QQCircleFeedBase$StMainPageBasicBusiRspData) globalData.getValue()).opMask.get();
            QLog.d("QCircleNoticeSettingContentPart", 4, "[updateSwitch] has cache data.");
            H9(((QQCircleFeedBase$StMainPageBasicBusiRspData) globalData.getValue()).opMask.get());
            return;
        }
        MutableLiveData globalData2 = w20.a.j().getGlobalData(com.tencent.biz.qqcircle.immersive.personal.data.w.class, q16);
        if (globalData2 != null && globalData2.getValue() != 0) {
            H9(((com.tencent.biz.qqcircle.immersive.personal.data.w) globalData2.getValue()).e().opMask.get());
            return;
        }
        com.tencent.biz.qqcircle.viewmodels.p pVar = (com.tencent.biz.qqcircle.viewmodels.p) getViewModel(com.tencent.biz.qqcircle.viewmodels.p.class);
        pVar.L1().observe(getHostFragment(), new Observer() { // from class: com.tencent.biz.qqcircle.bizparts.bo
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                bp.this.H9((List) obj);
            }
        });
        QCircleInitBean qCircleInitBean = QCirclePluginUtil.getQCircleInitBean(getContext());
        if (qCircleInitBean != null && qCircleInitBean.getSchemeAttrs() != null && qCircleInitBean.getSchemeAttrs().containsKey("from") && TextUtils.isDigitsOnly(qCircleInitBean.getSchemeAttrs().get("from"))) {
            i3 = Integer.parseInt(qCircleInitBean.getSchemeAttrs().get("from"));
        } else {
            i3 = 0;
        }
        pVar.O1(i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H9(List<Integer> list) {
        F9(com.tencent.biz.qqcircle.immersive.personal.utils.n.f89104a.a(list, 15));
    }

    @Override // com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QCircleNoticeSettingContentPart";
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view.getId() == R.id.y_2) {
            B9();
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
        C9(view);
        G9();
    }
}
