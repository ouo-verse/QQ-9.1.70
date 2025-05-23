package com.tencent.biz.qqcircle.widgets.polymerization;

import android.content.Context;
import android.text.TextUtils;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.tencent.biz.qqcircle.beans.QCirclePolymerizationBean;
import com.tencent.biz.qqcircle.fragments.QCirclePolymerizationFragment;
import com.tencent.biz.qqcircle.fragments.polymerization.QFSPolymerizationHotTagFragment;
import com.tencent.biz.qqcircle.fragments.polymerization.QFSPolymerizationRecentTagFragment;
import com.tencent.biz.qqcircle.immersive.adapter.w;
import com.tencent.biz.qqcircle.immersive.part.dy;
import com.tencent.biz.qqcircle.immersive.personal.event.QFSLayerFeedPosSyncEvent;
import com.tencent.biz.qqcircle.utils.h;
import com.tencent.biz.qqcircle.viewmodels.QCirclePolymerizationViewModel;
import com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.richframework.data.base.UIStateData;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import qqcircle.QQCircleFeedBase$StFeedListBusiRspData;

/* loaded from: classes5.dex */
public class QFSPolymerizationTagBottomView extends QCircleBaseWidgetView<List<e30.b>> implements SimpleEventReceiver, LifecycleOwner {
    private ViewPager2 C;
    private w D;
    private QCirclePolymerizationViewModel E;
    private QCirclePolymerizationBean F;
    private RecyclerView G;

    /* renamed from: d, reason: collision with root package name */
    private String f93786d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f93787e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f93788f;

    /* renamed from: h, reason: collision with root package name */
    private boolean f93789h;

    /* renamed from: i, reason: collision with root package name */
    private LifecycleRegistry f93790i;

    /* renamed from: m, reason: collision with root package name */
    private dy f93791m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class a implements Observer<UIStateData<QQCircleFeedBase$StFeedListBusiRspData>> {
        a() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(UIStateData<QQCircleFeedBase$StFeedListBusiRspData> uIStateData) {
            if (uIStateData != null && QFSPolymerizationTagBottomView.this.E.a2() == 0) {
                int state = uIStateData.getState();
                if ((state != 2 && state != 3) || uIStateData.getData() == null) {
                    return;
                }
                String str = uIStateData.getData().tagPageData.tabInfo.name.get();
                if (!TextUtils.isEmpty(str)) {
                    QFSPolymerizationTagBottomView.this.f93791m.A9(str);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class b extends ViewPager2.OnPageChangeCallback {
        b() {
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageSelected(int i3) {
            super.onPageSelected(i3);
            QLog.d("QFSPolymerizationTagBottomView", 1, "[onPageSelected] position = " + i3);
            if (QFSPolymerizationTagBottomView.this.E == null) {
                return;
            }
            if (i3 != 0) {
                if (i3 == 1) {
                    QFSPolymerizationTagBottomView.this.E.n2(1);
                    QFSPolymerizationTagBottomView.this.F.setTagTabType(1);
                    if (QFSPolymerizationTagBottomView.this.f93787e) {
                        QFSPolymerizationTagBottomView.this.E.h2(QFSPolymerizationTagBottomView.this.getContext(), QFSPolymerizationTagBottomView.this.F, false, true, 1);
                        QFSPolymerizationTagBottomView.this.f93787e = false;
                    }
                    QFSPolymerizationTagBottomView.this.s0(h.a(R.string.f196094gd));
                    return;
                }
                return;
            }
            QFSPolymerizationTagBottomView.this.E.n2(0);
            QFSPolymerizationTagBottomView.this.F.setTagTabType(0);
            if (QFSPolymerizationTagBottomView.this.f93788f) {
                QFSPolymerizationTagBottomView.this.E.h2(QFSPolymerizationTagBottomView.this.getContext(), QFSPolymerizationTagBottomView.this.F, false, true, 0);
                QFSPolymerizationTagBottomView.this.f93788f = false;
            }
            QFSPolymerizationTagBottomView.this.s0(h.a(R.string.f196084gc));
        }
    }

    public QFSPolymerizationTagBottomView(@NonNull Context context, RecyclerView recyclerView) {
        super(context);
        this.f93786d = null;
        this.f93787e = true;
        this.f93788f = true;
        this.G = recyclerView;
        initView();
        w0();
        x0();
        LifecycleRegistry lifecycleRegistry = new LifecycleRegistry(this);
        this.f93790i = lifecycleRegistry;
        lifecycleRegistry.setCurrentState(Lifecycle.State.CREATED);
        setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
    }

    private void initView() {
        dy dyVar = new dy(this);
        this.f93791m = dyVar;
        dyVar.z9();
        this.C = (ViewPager2) findViewById(R.id.f54842ga);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s0(String str) {
        Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
        buildElementParams.put("xsj_eid", QCircleDaTongConstant.ElementId.EM_XSJ_IN_PAGE_TAB);
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_TAB_TITLE, str);
        buildElementParams.put("xsj_custom_pgid", QCircleDaTongConstant.PageId.PG_XSJ_TOPIC_AGG_PAGE);
        VideoReport.reportEvent("ev_xsj_abnormal_clck", buildElementParams);
    }

    private void v0() {
        int i3;
        QCirclePolymerizationBean qCirclePolymerizationBean;
        if (this.f93789h && (qCirclePolymerizationBean = this.F) != null && qCirclePolymerizationBean.getSelectedTabType() == 2) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("[initItemPos] has assign sub tab, initItemPos: ");
            i3 = 1;
            sb5.append(1);
            QLog.d("QFSPolymerizationTagBottomView", 1, sb5.toString());
        } else {
            i3 = 0;
        }
        this.C.setCurrentItem(i3, false);
    }

    private void w0() {
        boolean z16;
        QCirclePolymerizationViewModel qCirclePolymerizationViewModel = (QCirclePolymerizationViewModel) getViewModel((QCirclePolymerizationFragment) getQCircleBaseFragment(), QCirclePolymerizationViewModel.class);
        this.E = qCirclePolymerizationViewModel;
        QCirclePolymerizationBean X1 = qCirclePolymerizationViewModel.X1();
        this.F = X1;
        if (X1.getSelectedTabType() != -1) {
            z16 = true;
        } else {
            z16 = false;
        }
        this.f93789h = z16;
        this.f93786d = String.valueOf(this.F.getPolymerizationType());
        w20.a.j().registerDisplaySurface(this.f93786d, this.E);
        this.E.P.observe(getQCircleBaseFragment(), new a());
    }

    private void x0() {
        ViewPager2 viewPager2 = this.C;
        if (viewPager2 == null) {
            return;
        }
        viewPager2.registerOnPageChangeCallback(new b());
        ArrayList arrayList = new ArrayList();
        QFSPolymerizationHotTagFragment qFSPolymerizationHotTagFragment = new QFSPolymerizationHotTagFragment();
        qFSPolymerizationHotTagFragment.Ph(0);
        qFSPolymerizationHotTagFragment.Oh(this.G);
        QFSPolymerizationRecentTagFragment qFSPolymerizationRecentTagFragment = new QFSPolymerizationRecentTagFragment();
        qFSPolymerizationRecentTagFragment.Ph(1);
        qFSPolymerizationRecentTagFragment.Oh(this.G);
        arrayList.add(qFSPolymerizationHotTagFragment);
        arrayList.add(qFSPolymerizationRecentTagFragment);
        w wVar = new w(getQCircleBaseFragment());
        this.D = wVar;
        wVar.i0(arrayList);
        this.C.setAdapter(this.D);
        v0();
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        ArrayList<Class> arrayList = new ArrayList<>();
        arrayList.add(QFSLayerFeedPosSyncEvent.class);
        return arrayList;
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.gnu;
    }

    @Override // androidx.lifecycle.LifecycleOwner
    @NonNull
    public Lifecycle getLifecycle() {
        return this.f93790i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView
    public String getLogTag() {
        return "QFSPolymerizationTagBottomView";
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f93790i.setCurrentState(Lifecycle.State.STARTED);
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.widget.BaseWidgetView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public void release() {
        super.release();
        ViewPager2 viewPager2 = this.C;
        if (viewPager2 != null) {
            viewPager2.setAdapter(null);
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    /* renamed from: u0, reason: merged with bridge method [inline-methods] */
    public void bindData(List<e30.b> list, int i3) {
    }
}
