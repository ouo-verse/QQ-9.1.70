package com.tencent.biz.qqcircle.immersive.part;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import androidx.annotation.Nullable;
import com.tencent.biz.qqcircle.beans.QFSNegativeItemInfo;
import com.tencent.biz.qqcircle.events.QCirclePanelStateEvent;
import com.tencent.biz.qqcircle.events.QFSNegativeSelectChangeEvent;
import com.tencent.biz.qqcircle.fragments.QCircleBlockContainer;
import com.tencent.biz.qqcircle.immersive.feed.event.QFSOpenNegativePanelEvent;
import com.tencent.biz.qqcircle.proxy.delegate.QCircleToast;
import com.tencent.biz.qqcircle.utils.QFSHalfScreenFloatingView;
import com.tencent.biz.qui.quibutton.QUIButton;
import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.part.utils.FastClickUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.richframework.compat.immersive.RFWNavigationBarImmersiveHelper;
import cooperation.qqcircle.report.QCircleLpReportDc05507;
import cooperation.qqcircle.report.QCircleReportBean;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudMeta$StFeed;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes4.dex */
public class ak extends com.tencent.biz.qqcircle.bizparts.b implements View.OnClickListener, SimpleEventReceiver {
    private static final String I = "com.tencent.biz.qqcircle.immersive.part.ak";
    private static final int J = com.tencent.biz.qqcircle.utils.cx.a(451.0f);
    private QUIButton C;
    private FeedCloudMeta$StFeed D;
    private boolean G;

    /* renamed from: d, reason: collision with root package name */
    private ViewStub f87693d;

    /* renamed from: e, reason: collision with root package name */
    private View f87694e;

    /* renamed from: f, reason: collision with root package name */
    private View f87695f;

    /* renamed from: h, reason: collision with root package name */
    private QFSHalfScreenFloatingView f87696h;

    /* renamed from: i, reason: collision with root package name */
    private com.tencent.biz.qqcircle.adapter.p f87697i;

    /* renamed from: m, reason: collision with root package name */
    private QCircleBlockContainer f87698m;
    private final ArrayList<QFSNegativeItemInfo> E = new ArrayList<>();
    private int F = 0;
    private String H = "";

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class a extends com.tencent.mobileqq.widget.qus.e {
        a() {
        }

        @Override // com.tencent.mobileqq.widget.qus.e, com.tencent.mobileqq.widget.qus.d
        public boolean canScrollDown(float f16, float f17) {
            if (ak.this.f87698m != null && ak.this.f87698m.getRecyclerView() != null) {
                return ak.this.f87698m.getRecyclerView().canScrollVertically(-1);
            }
            return false;
        }

        @Override // com.tencent.mobileqq.widget.qus.e, com.tencent.mobileqq.widget.qus.d
        public boolean canScrollUp(float f16, float f17) {
            return true;
        }

        @Override // com.tencent.mobileqq.widget.qus.d
        @Nullable
        /* renamed from: createContentView */
        public View getF57419d() {
            ak akVar = ak.this;
            akVar.f87695f = LayoutInflater.from(akVar.getContext()).inflate(R.layout.g8i, (ViewGroup) null);
            com.tencent.mobileqq.qui.b.f276860a.a(ak.this.f87695f, RFWNavigationBarImmersiveHelper.ImmersiveType.IMMERSIVE);
            ak.this.P9();
            return ak.this.f87695f;
        }

        @Override // com.tencent.mobileqq.widget.qus.e, com.tencent.mobileqq.widget.qus.d
        public int maxHeight() {
            return ak.J;
        }

        @Override // com.tencent.mobileqq.widget.qus.e, com.tencent.mobileqq.widget.qus.d
        public int showMode() {
            return 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class b extends com.tencent.mobileqq.widget.qus.a {
        b() {
        }

        @Override // com.tencent.mobileqq.widget.qus.a, com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView.p
        public void onShowTotal() {
            com.tencent.biz.qqcircle.immersive.utils.r.Z0(ak.this.getContext());
        }

        @Override // com.tencent.mobileqq.widget.qus.a, com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView.p
        public void onShowTotalStart() {
            String str;
            SimpleEventBus simpleEventBus = SimpleEventBus.getInstance();
            if (ak.this.D == null) {
                str = "";
            } else {
                str = ak.this.D.f398449id.get();
            }
            simpleEventBus.dispatchEvent(new QCirclePanelStateEvent(14, str, true));
            com.tencent.biz.qqcircle.immersive.utils.ax.g(ak.this.getContext(), false);
            ak.this.K9();
        }
    }

    private void G9(FeedCloudMeta$StFeed feedCloudMeta$StFeed, List<String> list, List<String> list2) {
        this.D = feedCloudMeta$StFeed;
        this.E.clear();
        this.F = 0;
        S9(1);
        R9(list, 1);
        S9(2);
        R9(list2, 2);
    }

    private boolean H9() {
        QFSHalfScreenFloatingView qFSHalfScreenFloatingView = this.f87696h;
        if (qFSHalfScreenFloatingView != null && qFSHalfScreenFloatingView.getVisibility() == 0) {
            this.f87696h.t();
            return true;
        }
        return false;
    }

    private void I9(int i3) {
        QCircleToast.h(R.string.f1897740a, 1);
        FeedCloudMeta$StFeed feedCloudMeta$StFeed = this.D;
        if (feedCloudMeta$StFeed != null) {
            V9(feedCloudMeta$StFeed, i3);
        }
    }

    private void J9() {
        String str;
        QUIButton qUIButton = this.C;
        if (this.F > 0) {
            str = QCircleDaTongConstant.ElementId.EM_XSJ_FEEDBACK_COLLECT_SUBMIT_BUTTON;
        } else {
            str = QCircleDaTongConstant.ElementId.EM_XSJ_FEEDBACK_COLLECT_CANCEL_BUTTON;
        }
        VideoReport.setElementId(qUIButton, str);
        Map<String, Object> L9 = L9();
        L9.put(QCircleDaTongConstant.ElementParamKey.XSJ_CONTENT, this.H);
        VideoReport.setElementClickPolicy(this.C, ClickPolicy.REPORT_NONE);
        VideoReport.reportEvent("dt_clck", this.C, L9);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K9() {
        VideoReport.setElementId(this.f87695f, QCircleDaTongConstant.ElementId.EM_XSJ_FEEDBACK_COLLECT_PANEL);
        VideoReport.reportEvent("dt_imp", this.f87695f, L9());
    }

    private Map<String, Object> L9() {
        Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
        FeedCloudMeta$StFeed feedCloudMeta$StFeed = this.D;
        if (feedCloudMeta$StFeed != null) {
            buildElementParams.put("xsj_feed_id", feedCloudMeta$StFeed.f398449id.get());
            buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_AUTHOR_UIN, this.D.poster.f398463id.get());
        }
        return buildElementParams;
    }

    private void M9(QFSNegativeSelectChangeEvent qFSNegativeSelectChangeEvent) {
        int i3;
        String string;
        if (!T9()) {
            QLog.d(I, 1, "[handleNegativeSelectChangeEvent] is not showing");
            return;
        }
        if (qFSNegativeSelectChangeEvent.getSelected().booleanValue()) {
            this.F++;
            this.H += qFSNegativeSelectChangeEvent.getSelectedText() + "|";
        } else {
            this.F--;
            this.H = this.H.replace(qFSNegativeSelectChangeEvent.getSelectedText() + "|", "");
        }
        if (this.F < 0) {
            this.F = 0;
        }
        QUIButton qUIButton = this.C;
        if (this.F == 0) {
            i3 = 1;
        } else {
            i3 = 0;
        }
        qUIButton.setType(i3);
        QUIButton qUIButton2 = this.C;
        if (this.F == 0) {
            string = com.tencent.biz.qqcircle.utils.h.a(R.string.f19156455);
        } else {
            string = RFWApplication.getApplication().getString(R.string.f196014g6, Integer.valueOf(this.F));
        }
        qUIButton2.setText(string);
    }

    private void N9(QFSOpenNegativePanelEvent qFSOpenNegativePanelEvent) {
        if (T9()) {
            QLog.d(I, 1, "[handleOpenNegativePanelEvent] panel is showing");
            return;
        }
        G9(qFSOpenNegativePanelEvent.getFeed(), qFSOpenNegativePanelEvent.getFirstCategoryList(), qFSOpenNegativePanelEvent.getSecondCategoryList());
        setReportBean(qFSOpenNegativePanelEvent.getReportBean());
        if (this.E.size() <= 2) {
            QLog.e(I, 1, "[handleOpenNegativePanelEvent] data is null");
            return;
        }
        Q9();
        X9();
        this.f87697i.setDatas(this.E);
    }

    private void O9() {
        String str = I;
        if (FastClickUtils.isFastDoubleClick(str)) {
            return;
        }
        H9();
        if (this.F > 0) {
            QLog.d(str, 2, "[handleSubmitBtnClick] mSelectedSize = " + this.F);
            I9(11);
        }
        J9();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P9() {
        this.f87698m = (QCircleBlockContainer) this.f87695f.findViewById(R.id.f34580zj);
        initBlockContainer();
        this.C = (QUIButton) this.f87695f.findViewById(R.id.f47491xf);
        W9();
        this.C.setOnClickListener(this);
    }

    private void Q9() {
        if (this.f87693d != null) {
            QLog.e(I, 1, "[initContentView] mPanelViewStub != null");
            return;
        }
        ViewStub viewStub = (ViewStub) getPartRootView().findViewById(R.id.f34600zl);
        this.f87693d = viewStub;
        if (viewStub == null) {
            QLog.e(I, 1, "[initContentView] mPanelViewStub == null");
            return;
        }
        View inflate = viewStub.inflate();
        this.f87694e = inflate;
        if (inflate == null) {
            QLog.e(I, 1, "[initContentView] mPanelContainer == null");
        } else {
            this.f87696h = (QFSHalfScreenFloatingView) inflate.findViewById(R.id.f34570zi);
            initHalfScreenView();
        }
    }

    private void R9(List<String> list, int i3) {
        for (String str : list) {
            String str2 = "";
            if (str.contains("|")) {
                String[] f16 = com.tencent.biz.qqcircle.utils.cu.f(str, "\\|");
                if (f16.length < 2) {
                    str = "";
                } else {
                    String str3 = f16[0];
                    str2 = f16[1];
                    str = str3;
                }
            }
            QFSNegativeItemInfo qFSNegativeItemInfo = new QFSNegativeItemInfo(-102, str, i3);
            if (!TextUtils.isEmpty(str2)) {
                qFSNegativeItemInfo.setSubTitle(str2);
            }
            qFSNegativeItemInfo.setSelected(false);
            this.E.add(qFSNegativeItemInfo);
        }
    }

    private void S9(int i3) {
        String a16;
        if (i3 == 1) {
            a16 = com.tencent.biz.qqcircle.utils.h.a(R.string.f193814a8);
        } else {
            a16 = com.tencent.biz.qqcircle.utils.h.a(R.string.f1920146c);
        }
        this.E.add(new QFSNegativeItemInfo(-101, a16, i3));
    }

    private boolean T9() {
        QFSHalfScreenFloatingView qFSHalfScreenFloatingView = this.f87696h;
        if (qFSHalfScreenFloatingView != null && qFSHalfScreenFloatingView.getVisibility() == 0) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void U9() {
        String str;
        SimpleEventBus simpleEventBus = SimpleEventBus.getInstance();
        FeedCloudMeta$StFeed feedCloudMeta$StFeed = this.D;
        if (feedCloudMeta$StFeed == null) {
            str = "";
        } else {
            str = feedCloudMeta$StFeed.f398449id.get();
        }
        simpleEventBus.dispatchEvent(new QCirclePanelStateEvent(14, str, false));
        com.tencent.biz.qqcircle.immersive.utils.ax.g(getContext(), true);
        com.tencent.biz.qqcircle.immersive.utils.r.Z0(getContext());
        this.f87696h.L();
        W9();
        QCircleBlockContainer qCircleBlockContainer = this.f87698m;
        if (qCircleBlockContainer != null) {
            qCircleBlockContainer.getRecyclerView().scrollToPosition(0);
        }
    }

    private void V9(FeedCloudMeta$StFeed feedCloudMeta$StFeed, int i3) {
        QCircleLpReportDc05507.report(new QCircleLpReportDc05507.DataBuilder(ua0.c.c(feedCloudMeta$StFeed).setToUin(feedCloudMeta$StFeed.poster.f398463id.get()).setActionType(65).setSubActionType(i3).setExt10(this.H).setExt3(String.valueOf(feedCloudMeta$StFeed.createTime)).setPageId(getReportBean().getPageId())));
    }

    private void W9() {
        this.H = "";
        this.C.setType(1);
        this.C.setText(com.tencent.biz.qqcircle.utils.h.a(R.string.f19156455));
    }

    private void X9() {
        View view = this.f87694e;
        if (view != null && this.f87696h != null) {
            view.setVisibility(0);
            this.f87696h.P(0);
        } else {
            QLog.e(I, 1, "[showPanel] mHalfScreenFloatingView == null");
        }
    }

    private void initBlockContainer() {
        QCircleBlockContainer qCircleBlockContainer = this.f87698m;
        if (qCircleBlockContainer == null) {
            QLog.e(I, 1, "[initBlockContainer] mPanelContainer == null");
            return;
        }
        qCircleBlockContainer.setLayoutManagerType(3, 2);
        this.f87698m.setParentFragment(getHostFragment());
        this.f87698m.getRecyclerView().setNestedScrollingEnabled(true);
        com.tencent.biz.qqcircle.adapter.p pVar = new com.tencent.biz.qqcircle.adapter.p(null);
        this.f87697i = pVar;
        QCircleReportBean qCircleReportBean = this.mReportBean;
        if (qCircleReportBean != null) {
            pVar.setReportBean(qCircleReportBean);
        }
        this.f87698m.registerBlock(this.f87697i);
        this.f87698m.start();
    }

    private void initHalfScreenView() {
        QFSHalfScreenFloatingView qFSHalfScreenFloatingView = this.f87696h;
        if (qFSHalfScreenFloatingView == null) {
            QLog.e(I, 1, "[initHalfScreenView] mHalfScreenFloatingView == null");
            return;
        }
        qFSHalfScreenFloatingView.setHeadNeedDragIcon(true);
        this.f87696h.v(false);
        this.f87696h.setQUSDragFloatController(new a());
        this.f87696h.j(new b());
        this.f87696h.setOnDismissListener(new QUSBaseHalfScreenFloatingView.l() { // from class: com.tencent.biz.qqcircle.immersive.part.aj
            @Override // com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView.l
            public final void onDismiss() {
                ak.this.U9();
            }
        });
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class<?>> getEventClass() {
        ArrayList<Class<?>> arrayList = new ArrayList<>();
        arrayList.add(QFSOpenNegativePanelEvent.class);
        arrayList.add(QFSNegativeSelectChangeEvent.class);
        return arrayList;
    }

    @Override // com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return I;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public boolean onBackEvent() {
        if (!H9() && !super.onBackEvent()) {
            return false;
        }
        return true;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view.getId() == R.id.f47491xf) {
            O9();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(Activity activity, Bundle bundle) {
        super.onPartCreate(activity, bundle);
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartPause(Activity activity) {
        this.G = false;
        H9();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartResume(Activity activity) {
        this.G = true;
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        if (!this.G) {
            return;
        }
        if (simpleBaseEvent instanceof QFSOpenNegativePanelEvent) {
            N9((QFSOpenNegativePanelEvent) simpleBaseEvent);
        } else if (simpleBaseEvent instanceof QFSNegativeSelectChangeEvent) {
            M9((QFSNegativeSelectChangeEvent) simpleBaseEvent);
        }
    }
}
