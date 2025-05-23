package com.tencent.biz.qqcircle.immersive.views.mixfeed;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.viewpager2.widget.ViewPager2;
import com.tencent.biz.qcircleshadow.lib.QCirclePluginInitHelper;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.events.QCircleConfigChangeEvent;
import com.tencent.biz.qqcircle.immersive.adapter.s;
import com.tencent.biz.qqcircle.immersive.feed.event.QFSPageSelectEvent;
import com.tencent.biz.qqcircle.immersive.views.banner.QFSImageBanner;
import com.tencent.biz.qqcircle.richframework.widget.RoundCorneredRelativeLayout;
import com.tencent.biz.qqcircle.utils.bz;
import com.tencent.biz.qqcircle.utils.cx;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.layoutinflater.RFWLayoutPreLoader;
import com.tencent.biz.richframework.layoutinflater.RFWLayoutPreLoaderFactory;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.auto.engine.event.ASEngineTabStatusEvent;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import qqcircle.QQCircleDitto$StItemContainer;
import qqcircle.QQCircleDitto$StItemInfo;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSMixFeedBannerView extends QFSMixFeedBaseWidgetView<e30.b> implements SimpleEventReceiver {
    private FrameLayout C;
    private j20.a D;
    private int E;

    /* renamed from: e, reason: collision with root package name */
    private QFSImageBanner f90834e;

    /* renamed from: f, reason: collision with root package name */
    private s f90835f;

    /* renamed from: h, reason: collision with root package name */
    private QFSMixFeedBannerIndicator f90836h;

    /* renamed from: i, reason: collision with root package name */
    private int f90837i;

    /* renamed from: m, reason: collision with root package name */
    private RoundCorneredRelativeLayout f90838m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class a implements com.tencent.biz.qqcircle.immersive.views.mixfeed.a {
        a() {
        }

        @Override // com.tencent.biz.qqcircle.immersive.views.mixfeed.a
        public void onPause() {
            QFSMixFeedBannerView.this.D0();
        }

        @Override // com.tencent.biz.qqcircle.immersive.views.mixfeed.a
        public void onResume() {
            QFSMixFeedBannerView.this.C0();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class b extends ViewPager2.OnPageChangeCallback {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ List f90840b;

        b(List list) {
            this.f90840b = list;
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageSelected(int i3) {
            super.onPageSelected(i3);
            if (QFSMixFeedBannerView.this.f90835f != null) {
                QFSMixFeedBannerView.this.E0(i3);
                QFSMixFeedBannerView qFSMixFeedBannerView = QFSMixFeedBannerView.this;
                qFSMixFeedBannerView.s0(this.f90840b, qFSMixFeedBannerView.f90837i);
            }
        }
    }

    public QFSMixFeedBannerView(@NonNull Context context) {
        super(context);
        this.f90837i = -1;
        this.E = -1;
        y0(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void A0(List list, int i3) {
        QLog.i("QFSMixFeedBannerView", 1, "[setOnItemClickListener] -> position = " + i3 + ", itemInfos.size() = " + list.size());
        if (list.size() <= i3) {
            return;
        }
        Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
        buildElementParams.put("xsj_operation_activity_id", QCirclePluginUtil.getValueFromListEntry(((QQCircleDitto$StItemInfo) list.get(i3)).busiInfo.get(), "activityID"));
        VideoReport.setElementId(this.C, QCircleDaTongConstant.ElementId.EM_XSJ_BANNER);
        VideoReport.reportEvent("dt_clck", this.C, buildElementParams);
        B0(list);
        com.tencent.biz.qqcircle.launcher.c.g(getContext(), d.f((QQCircleDitto$StItemInfo) list.get(i3), "official_banner_jump_url"));
    }

    private void B0(List<QQCircleDitto$StItemInfo> list) {
        if (!z0(list)) {
            return;
        }
        QLog.i("QFSMixFeedBannerView", 1, "[preLoadNewPublish] WinkPublish, preload wink.");
        QCirclePluginInitHelper.PreloadWink(getContext());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C0() {
        QFSImageBanner qFSImageBanner = this.f90834e;
        if (qFSImageBanner == null) {
            QLog.e("QFSMixFeedBannerView", 1, "[startBanner] mImageBanner is null");
            return;
        }
        if (this.E < 2) {
            QLog.d("QFSMixFeedBannerView", 1, "[startBanner] mBannerCount = " + this.E);
            return;
        }
        qFSImageBanner.v0();
        QLog.i("QFSMixFeedBannerView", 1, "[startBanner]");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D0() {
        QFSImageBanner qFSImageBanner = this.f90834e;
        if (qFSImageBanner == null) {
            QLog.e("QFSMixFeedBannerView", 1, "[stopBanner] mImageBanner is null");
            return;
        }
        if (this.E < 2) {
            QLog.d("QFSMixFeedBannerView", 1, "[stopBanner] mBannerCount = " + this.E);
            return;
        }
        qFSImageBanner.y0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E0(int i3) {
        this.f90837i = i3;
        this.f90834e.setCurrentItem(i3, false);
    }

    private void r0() {
        QFSImageBanner qFSImageBanner = this.f90834e;
        if (qFSImageBanner == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = qFSImageBanner.getLayoutParams();
        int i3 = bz.i(getContext()) - 24;
        layoutParams.width = i3;
        layoutParams.height = (int) (i3 / 2.84f);
        this.f90834e.setLayoutParams(layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s0(List<QQCircleDitto$StItemInfo> list, int i3) {
        if (this.f90834e != null && list != null && list.size() > i3) {
            VideoReport.setElementId(this.f90834e, QCircleDaTongConstant.ElementId.EM_XSJ_BANNER);
            HashMap hashMap = new HashMap();
            hashMap.put("xsj_operation_activity_id", QCirclePluginUtil.getValueFromListEntry(list.get(i3).busiInfo.get(), "activityID"));
            VideoReport.setElementParams(this.f90834e, hashMap);
            VideoReport.setElementReuseIdentifier(this.f90834e, "em_xsj_banner_" + i3);
            VideoReport.setElementExposePolicy(this.f90834e, ExposurePolicy.REPORT_ALL);
        }
    }

    private void u0(ASEngineTabStatusEvent aSEngineTabStatusEvent) {
        if (!aSEngineTabStatusEvent.isSelected()) {
            D0();
        }
    }

    private void v0(QCircleConfigChangeEvent qCircleConfigChangeEvent) {
        r0();
    }

    private void w0(QFSPageSelectEvent qFSPageSelectEvent) {
        if (qFSPageSelectEvent.mSelectTabType != 8) {
            D0();
        }
    }

    private void x0(final List<QQCircleDitto$StItemInfo> list) {
        FrameLayout frameLayout = this.C;
        if (frameLayout != null && this.f90834e != null && this.f90836h != null && this.f90838m != null) {
            if (list == null) {
                QLog.e("QFSMixFeedBannerView", 1, "[initBanner] itemInfos == null");
                return;
            }
            frameLayout.setVisibility(0);
            if (this.f90835f == null) {
                s sVar = new s();
                this.f90835f = sVar;
                this.f90834e.setAdapter(sVar);
            }
            r0();
            this.f90835f.setData(list);
            this.f90835f.notifyDataSetChanged();
            this.f90835f.s0(4000L);
            this.f90834e.setEnableOperate(true);
            this.f90835f.setEnableLoop(true);
            this.f90836h.setCount(list.size());
            this.E = list.size();
            s0(list, 0);
            this.f90834e.q0(new b(list));
            this.f90834e.setOnItemClickListener(new QFSImageBanner.c() { // from class: com.tencent.biz.qqcircle.immersive.views.mixfeed.b
                @Override // com.tencent.biz.qqcircle.immersive.views.banner.QFSImageBanner.c
                public final void onItemClick(int i3) {
                    QFSMixFeedBannerView.this.A0(list, i3);
                }
            });
            E0(this.f90837i);
            float a16 = cx.a(8.0f);
            this.f90838m.setRadius(a16, a16, a16, a16);
            return;
        }
        QLog.e("QFSMixFeedBannerView", 1, "[initBanner] mBannerView == null");
    }

    private void y0(View view) {
        this.C = (FrameLayout) view.findViewById(R.id.f47031w7);
        this.f90834e = (QFSImageBanner) view.findViewById(R.id.f47051w9);
        QFSMixFeedBannerIndicator qFSMixFeedBannerIndicator = (QFSMixFeedBannerIndicator) view.findViewById(R.id.f47041w8);
        this.f90836h = qFSMixFeedBannerIndicator;
        qFSMixFeedBannerIndicator.b(this.f90834e);
        this.f90838m = (RoundCorneredRelativeLayout) view.findViewById(R.id.f47061w_);
        this.C.setClickable(true);
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    private boolean z0(List<QQCircleDitto$StItemInfo> list) {
        Iterator<QQCircleDitto$StItemInfo> it = list.iterator();
        while (it.hasNext()) {
            if (d.f(it.next(), "official_banner_jump_url").contains(QCircleScheme.Q_CIRCLE_ACTION_OPEN_QQPUBLISH)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        ArrayList<Class> arrayList = new ArrayList<>();
        arrayList.add(QCircleConfigChangeEvent.class);
        arrayList.add(QFSPageSelectEvent.class);
        arrayList.add(ASEngineTabStatusEvent.class);
        return arrayList;
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.gj7;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public RFWLayoutPreLoader getLayoutPreLoader() {
        return RFWLayoutPreLoaderFactory.getLayoutLoader(l30.a.a().c());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView
    public String getLogTag() {
        return "QFSMixFeedBannerView";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    @NonNull
    public FrameLayout.LayoutParams getPreLoadLayoutParams() {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.setMargins(cx.a(8.0f), cx.a(8.0f), cx.a(8.0f), cx.a(12.0f));
        return layoutParams;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        C0();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.widget.BaseWidgetView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        D0();
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        if (simpleBaseEvent instanceof QCircleConfigChangeEvent) {
            v0((QCircleConfigChangeEvent) simpleBaseEvent);
        } else if (simpleBaseEvent instanceof QFSPageSelectEvent) {
            w0((QFSPageSelectEvent) simpleBaseEvent);
        } else if (simpleBaseEvent instanceof ASEngineTabStatusEvent) {
            u0((ASEngineTabStatusEvent) simpleBaseEvent);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public void bindData(e30.b bVar, int i3) {
        if (bVar != null && bVar.g() != null) {
            QQCircleDitto$StItemContainer i16 = d.i(bVar, String.valueOf(bVar.g().dittoFeed.dittoId.get()));
            if (i16 == null || i16.items.size() < 1) {
                return;
            }
            this.f90837i = 0;
            x0(i16.items.get());
            j20.a aVar = (j20.a) getInteractor();
            this.D = aVar;
            if (aVar != null && aVar.isContainerOnScreen()) {
                C0();
                this.D.a(new a());
                return;
            }
            QLog.d("QFSMixFeedBannerView", 1, "[bindData] mInteractor = " + this.D + ", || !mInteractor.isContainerOnScreen()");
            return;
        }
        QLog.e("QFSMixFeedBannerView", 1, "[bindData] feedBlockData == null");
    }
}
