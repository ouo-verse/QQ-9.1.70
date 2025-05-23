package com.tencent.biz.qqcircle.immersive.part.push;

import android.app.Activity;
import android.view.View;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.qqcircle.activity.QCircleTransFragmentActivity;
import com.tencent.biz.qqcircle.events.QCirclePanelStateEvent;
import com.tencent.biz.qqcircle.fragments.QCircleBlockContainer;
import com.tencent.biz.qqcircle.immersive.events.QFSEnableSlideRightActionEvent;
import com.tencent.biz.qqcircle.immersive.part.u;
import com.tencent.biz.qqcircle.immersive.utils.ax;
import com.tencent.biz.qqcircle.push.i;
import com.tencent.biz.qqcircle.utils.QCircleSlidBottomView;
import com.tencent.biz.qqcircle.utils.ad;
import com.tencent.biz.qqcircle.utils.cx;
import com.tencent.biz.qqcircle.utils.h;
import com.tencent.biz.qqcircle.viewmodels.r;
import com.tencent.biz.qqcircle.widgets.QCirclePanelLoadingView;
import com.tencent.biz.qqcircle.widgets.QCircleStatusView;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.richframework.data.base.UIStateData;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudMeta$StFeed;
import java.util.List;
import java.util.Map;
import qqcircle.QQCircleClient$TaskInfo;

/* compiled from: P */
/* loaded from: classes4.dex */
public class a extends u implements View.OnClickListener {
    private QCirclePanelLoadingView C;
    private QCircleBlockContainer D;
    private i E;
    private r F;
    private FeedCloudMeta$StFeed G;

    /* renamed from: d, reason: collision with root package name */
    private View f88304d;

    /* renamed from: e, reason: collision with root package name */
    private QCircleSlidBottomView f88305e;

    /* renamed from: f, reason: collision with root package name */
    private FrameLayout f88306f;

    /* renamed from: h, reason: collision with root package name */
    private TextView f88307h;

    /* renamed from: i, reason: collision with root package name */
    private ImageView f88308i;

    /* renamed from: m, reason: collision with root package name */
    private QCircleStatusView f88309m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class b extends RecyclerView.OnScrollListener {
        b() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int i3) {
            super.onScrollStateChanged(recyclerView, i3);
            if (i3 == 0) {
                VideoReport.traverseExposure();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class c implements Observer<UIStateData<List<QQCircleClient$TaskInfo>>> {
        c() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(UIStateData<List<QQCircleClient$TaskInfo>> uIStateData) {
            a.this.L9(uIStateData);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class d implements e {
        d() {
        }

        @Override // com.tencent.biz.qqcircle.immersive.part.push.a.e
        public void a() {
            a.this.G9();
        }
    }

    /* compiled from: P */
    /* loaded from: classes4.dex */
    public interface e {
        void a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G9() {
        QCircleSlidBottomView qCircleSlidBottomView = this.f88305e;
        if (qCircleSlidBottomView != null && this.f88304d != null) {
            qCircleSlidBottomView.g();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H9(View view, String str, Map<String, Object> map) {
        Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
        if (map != null) {
            buildElementParams.putAll(map);
        }
        VideoReport.setElementId(view, str);
        VideoReport.setElementParams(view, buildElementParams);
        VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_ALL);
    }

    private void I9(UIStateData<List<QQCircleClient$TaskInfo>> uIStateData) {
        String a16;
        if (!this.f88305e.t()) {
            QLog.d("QFSPushMissionPart", 1, "[handleGetPushInfoError] mSlidView is not showing");
            return;
        }
        if (uIStateData.getState() == 4) {
            a16 = h.a(R.string.f184743mp);
        } else {
            a16 = h.a(R.string.f182993hz);
        }
        O9(a16);
    }

    private void J9(UIStateData<List<QQCircleClient$TaskInfo>> uIStateData) {
        r rVar;
        if (!this.f88305e.t()) {
            QLog.d("QFSPushMissionPart", 1, "[handleSuccessRsp] mSlidView is not showing");
            return;
        }
        this.f88309m.setVisibility(8);
        this.D.setVisibility(0);
        TextView textView = this.f88307h;
        if (textView != null && (rVar = this.F) != null) {
            textView.setText(rVar.P1());
        }
        this.E.setDatas(uIStateData.getData());
        this.E.j0(new d());
    }

    private void K9() {
        QCircleSlidBottomView qCircleSlidBottomView;
        if (fb0.a.b("QFSPushMissionPart", 500L)) {
            return;
        }
        M9();
        r rVar = this.F;
        if (rVar != null) {
            rVar.N1();
        }
        QCirclePanelLoadingView qCirclePanelLoadingView = this.C;
        if (qCirclePanelLoadingView != null && (qCircleSlidBottomView = this.f88305e) != null && this.D != null) {
            qCirclePanelLoadingView.o0(qCircleSlidBottomView.k());
            this.f88309m.setVisibility(8);
            this.D.setVisibility(8);
        }
        P9();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L9(UIStateData<List<QQCircleClient$TaskInfo>> uIStateData) {
        QCirclePanelLoadingView qCirclePanelLoadingView = this.C;
        if (qCirclePanelLoadingView != null) {
            qCirclePanelLoadingView.k0();
        }
        int state = uIStateData.getState();
        if (state != 3) {
            if (state == 4) {
                I9(uIStateData);
                return;
            }
            return;
        }
        J9(uIStateData);
    }

    private void M9() {
        ViewStub viewStub;
        if (this.f88306f != null || (viewStub = (ViewStub) getPartRootView().findViewById(R.id.f511627c)) == null) {
            return;
        }
        View inflate = viewStub.inflate();
        this.f88304d = inflate;
        this.f88306f = (FrameLayout) inflate.findViewById(R.id.f5110277);
        this.f88307h = (TextView) this.f88304d.findViewById(R.id.f511527b);
        this.f88308i = (ImageView) this.f88304d.findViewById(R.id.f5109276);
        this.f88305e = (QCircleSlidBottomView) this.f88304d.findViewById(R.id.f511427a);
        this.D = (QCircleBlockContainer) this.f88304d.findViewById(R.id.f511327_);
        this.f88309m = (QCircleStatusView) this.f88304d.findViewById(R.id.f5111278);
        this.C = (QCirclePanelLoadingView) this.f88304d.findViewById(R.id.f5112279);
        this.f88308i.setOnClickListener(this);
        initSlideView();
        initBlockContainer();
        initViewModel();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void N9(boolean z16) {
        if (getActivity() instanceof QCircleTransFragmentActivity) {
            return;
        }
        ax.g(getContext(), z16);
    }

    private void O9(String str) {
        QCircleStatusView qCircleStatusView = this.f88309m;
        if (qCircleStatusView == null) {
            return;
        }
        qCircleStatusView.setVisibility(0);
        this.D.setVisibility(8);
        this.f88309m.x0(str);
    }

    private void P9() {
        View view = this.f88304d;
        if (view != null && this.f88305e != null) {
            view.setVisibility(0);
            this.f88305e.f();
            this.f88305e.x(this.f88306f);
        }
    }

    private void initBlockContainer() {
        this.D.setLayoutManagerType(1, 1);
        this.D.setEnableLoadMore(false);
        this.D.setEnableRefresh(false);
        this.D.getRecyclerView().setNestedScrollingEnabled(true);
        this.D.getRecyclerView().addOnScrollListener(new b());
        i iVar = new i(null);
        this.E = iVar;
        this.D.registerBlock(iVar);
        this.D.start();
    }

    private void initSlideView() {
        this.f88305e.setTopSpaceHeight(cx.b(getContext()) / 3);
        this.f88305e.e(new C0895a());
    }

    private void initViewModel() {
        r rVar = (r) getViewModel(r.class);
        this.F = rVar;
        if (rVar == null) {
            return;
        }
        rVar.O1().observe(getHostFragment(), new c());
    }

    @Override // com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QFSPushMissionPart";
    }

    @Override // com.tencent.biz.qqcircle.immersive.part.u, com.tencent.biz.richframework.part.Part
    public void handleBroadcastMessage(String str, Object obj) {
        super.handleBroadcastMessage(str, obj);
        if ("open_push_mission_panel".equals(str)) {
            K9();
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public boolean onBackEvent() {
        View view = this.f88304d;
        if (view != null && view.getVisibility() == 0) {
            G9();
            return true;
        }
        return super.onBackEvent();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view.getId() == R.id.f5109276) {
            G9();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        ax.b(this.f88305e);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.biz.qqcircle.immersive.part.push.a$a, reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C0895a implements QCircleSlidBottomView.d {
        C0895a() {
        }

        @Override // com.tencent.biz.qqcircle.utils.QCircleSlidBottomView.d
        public void a() {
            a aVar = a.this;
            aVar.H9(aVar.f88306f, QCircleDaTongConstant.ElementId.EM_XSJ_TASK_PANEL, null);
            VideoReport.traverseExposure();
        }

        @Override // com.tencent.biz.qqcircle.utils.QCircleSlidBottomView.d
        public void onConfigurationChanged() {
            if (a.this.f88305e == null) {
                return;
            }
            a.this.f88305e.f();
            a.this.f88305e.y();
        }

        @Override // com.tencent.biz.qqcircle.utils.QCircleSlidBottomView.d
        public void onDismiss() {
            String str;
            a.this.N9(true);
            SimpleEventBus.getInstance().dispatchEvent(new QFSEnableSlideRightActionEvent(true, a.this.getContext()));
            if (a.this.f88304d != null) {
                a.this.f88304d.setVisibility(8);
            }
            SimpleEventBus simpleEventBus = SimpleEventBus.getInstance();
            if (a.this.G == null) {
                str = "";
            } else {
                str = a.this.G.f398449id.get();
            }
            simpleEventBus.dispatchEvent(new QCirclePanelStateEvent(2, str, false));
        }

        @Override // com.tencent.biz.qqcircle.utils.QCircleSlidBottomView.d
        public /* synthetic */ void onScrollChanged(int i3, int i16, int i17, int i18) {
            ad.b(this, i3, i16, i17, i18);
        }

        @Override // com.tencent.biz.qqcircle.utils.QCircleSlidBottomView.d
        public void onShow() {
            String str;
            a.this.N9(false);
            SimpleEventBus.getInstance().dispatchEvent(new QFSEnableSlideRightActionEvent(false, a.this.getContext()));
            SimpleEventBus simpleEventBus = SimpleEventBus.getInstance();
            if (a.this.G == null) {
                str = "";
            } else {
                str = a.this.G.f398449id.get();
            }
            simpleEventBus.dispatchEvent(new QCirclePanelStateEvent(2, str, true));
        }

        @Override // com.tencent.biz.qqcircle.utils.QCircleSlidBottomView.d
        public void onStatusChange(int i3) {
        }
    }
}
