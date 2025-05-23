package com.tencent.biz.qqcircle.immersive.part.mixfeed;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.tencent.biz.qqcircle.beans.QCircleTabInfo;
import com.tencent.biz.qqcircle.immersive.adapter.t;
import com.tencent.biz.qqcircle.immersive.events.QFSMainTabSelectEvent;
import com.tencent.biz.qqcircle.immersive.events.QFSMixSubTabSelectEvent;
import com.tencent.biz.qqcircle.immersive.events.QFSRefreshSubTabEvent;
import com.tencent.biz.qqcircle.immersive.events.QFSSelectSubTabEvent;
import com.tencent.biz.qqcircle.immersive.part.u;
import com.tencent.biz.qqcircle.immersive.utils.bq;
import com.tencent.biz.qqcircle.immersive.utils.r;
import com.tencent.biz.qqcircle.immersive.utils.s;
import com.tencent.biz.qqcircle.immersive.views.QFSViewPager;
import com.tencent.biz.qqcircle.immersive.views.mixfeed.d;
import com.tencent.biz.qqcircle.manager.QCircleFolderTabInfoManager;
import com.tencent.biz.qqcircle.richframework.widget.tab.SlidingTabLayout;
import com.tencent.biz.qqcircle.utils.cx;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.richframework.thread.RFWThreadManager;
import com.tencent.richframework.widget.popupwindow.RFWSmartPopupWindow;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.util.ArrayList;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
import qqcircle.QQCircleFeedBase$StTabInfo;

/* loaded from: classes4.dex */
public class QFSMixFeedMainTopTabPart extends u implements SimpleEventReceiver {
    private t40.b C;
    private int D;
    private PagerAdapter E;

    /* renamed from: d, reason: collision with root package name */
    private SlidingTabLayout f88198d;

    /* renamed from: e, reason: collision with root package name */
    private QFSViewPager f88199e;

    /* renamed from: f, reason: collision with root package name */
    private t f88200f;

    /* renamed from: h, reason: collision with root package name */
    private final QCircleTabInfo f88201h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f88202i;

    /* renamed from: m, reason: collision with root package name */
    private int f88203m = -1;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class c implements RFWSmartPopupWindow.IStatusCallback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f88208a;

        c(int i3) {
            this.f88208a = i3;
        }

        @Override // com.tencent.richframework.widget.popupwindow.RFWSmartPopupWindow.IStatusCallback
        public void onClick(View view) {
            QLog.d("QFSMixFeedMainTopTabPart", 1, "tryShowLiveTabTip, onClick ");
            QFSMixFeedMainTopTabPart.this.f88199e.setCurrentItem(this.f88208a, false);
        }

        @Override // com.tencent.richframework.widget.popupwindow.RFWSmartPopupWindow.IStatusCallback
        public void onDismiss() {
            QLog.d("QFSMixFeedMainTopTabPart", 1, "tryShowLiveTabTip, onDismiss ");
        }

        @Override // com.tencent.richframework.widget.popupwindow.RFWSmartPopupWindow.IStatusCallback
        public void onShow() {
            QLog.d("QFSMixFeedMainTopTabPart", 1, "tryShowLiveTabTip, onShow ");
            s.f90240a.c(true);
        }
    }

    public QFSMixFeedMainTopTabPart(QCircleTabInfo qCircleTabInfo) {
        this.f88201h = qCircleTabInfo;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D9(int i3, boolean z16) {
        QLog.d("QFSMixFeedMainTopTabPart", 1, "onTabSelect pos:" + ((Object) this.f88200f.getPageTitle(i3)) + "fromInit:" + z16);
        L9(i3);
        VideoReport.traverseExposure();
    }

    private ViewPager.OnPageChangeListener F9() {
        return new b();
    }

    @NotNull
    private sb0.a G9() {
        return new a();
    }

    private void H9(QFSMainTabSelectEvent qFSMainTabSelectEvent) {
        if (this.f88200f != null && this.f88201h != null && qFSMainTabSelectEvent.getTabSourceType() == this.f88201h.mTab.sourceType.get()) {
            QLog.d("QFSMixFeedMainTopTabPart", 1, "handleMainTabSelectEvent:" + qFSMainTabSelectEvent.isSelected());
            if (QCircleFolderTabInfoManager.m().E(this.f88201h.mTab)) {
                QLog.d("QFSMixFeedMainTopTabPart", 1, "handleMainTabSelectEvent need change");
                this.f88200f.f(this.f88201h);
                this.f88200f.notifyDataSetChanged();
            }
        }
    }

    private void I9() {
        Intent intent;
        int b16;
        if (getActivity() != null && (intent = getActivity().getIntent()) != null && (b16 = bq.f90197a.b(intent)) != -1) {
            this.f88202i = true;
            this.f88203m = b16;
        }
    }

    private void J9() {
        int i3 = this.f88201h.mTab.defaultSubTabindex.get();
        QLog.d("QFSMixFeedMainTopTabPart", 1, "initItemPos, default sub tab index: " + i3);
        if (i3 < 0) {
            i3 = 0;
        }
        if (this.f88202i) {
            i3 = d.e(this.f88201h.mTab.subTabInfo.get(), this.f88203m);
            QLog.d("QFSMixFeedMainTopTabPart", 1, "initItemPos, has assign sub tab, initItemPos: " + i3);
            SimpleEventBus.getInstance().dispatchEvent(new QFSRefreshSubTabEvent(i3));
        }
        this.f88199e.setCurrentItem(i3, false);
        if (i3 == 0) {
            D9(0, true);
        }
        QLog.d("QFSMixFeedMainTopTabPart", 1, "default jump pos:" + i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void K9(mc0.a aVar, View view) {
        aVar.setOffsetDp(-cx.j(view.getLeft() - this.f88198d.l()), -10.0f);
    }

    private void L9(int i3) {
        int i16;
        if (this.C == null) {
            QLog.d("QFSMixFeedMainTopTabPart", 1, "notifySubTabOnSelect, mQFSFolderIoc is null ");
            return;
        }
        if (i3 >= 0 && i3 < this.f88201h.mTab.subTabInfo.size()) {
            this.C.onHandlerMessage("event_community_sub_tab_select", this.f88201h.mTab.subTabInfo.get(i3).get());
            Activity activity = getActivity();
            SimpleEventBus simpleEventBus = SimpleEventBus.getInstance();
            if (activity != null) {
                i16 = activity.hashCode();
            } else {
                i16 = -1;
            }
            simpleEventBus.dispatchEvent(new QFSMixSubTabSelectEvent(i3, i16));
            return;
        }
        QLog.d("QFSMixFeedMainTopTabPart", 1, "notifySubTabOnSelect, position is invalid ");
    }

    private void M9() {
        int e16 = d.e(this.f88201h.mTab.subTabInfo.get(), 12);
        int i3 = this.f88201h.mTab.defaultSubTabindex.get();
        if ((this.f88202i && this.f88203m == 12) || e16 == i3) {
            QLog.d("QFSMixFeedMainTopTabPart", 1, "tryShowLiveTabTip, init pos is live ");
            s.f90240a.c(true);
            return;
        }
        s sVar = s.f90240a;
        if (sVar.b()) {
            QLog.d("QFSMixFeedMainTopTabPart", 1, "tryShowLiveTabTip, has show tip ");
            return;
        }
        int e17 = d.e(this.f88201h.mTab.subTabInfo.get(), 12);
        if (e17 == -1) {
            QLog.d("QFSMixFeedMainTopTabPart", 1, "tryShowLiveTabTip, liveTabIndex is invalid ");
            return;
        }
        final View m3 = this.f88198d.m(e17);
        if (m3 == null) {
            QLog.d("QFSMixFeedMainTopTabPart", 1, "tryShowLiveTabTip, tabView is null ");
            return;
        }
        final mc0.a a16 = sVar.a(getContext(), m3);
        a16.addStatusCallback(new c(e17));
        m3.post(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.part.mixfeed.b
            @Override // java.lang.Runnable
            public final void run() {
                QFSMixFeedMainTopTabPart.this.K9(a16, m3);
            }
        });
    }

    public int E9() {
        return this.f88198d.k();
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        ArrayList<Class> arrayList = new ArrayList<>();
        arrayList.add(QFSSelectSubTabEvent.class);
        arrayList.add(QFSMainTabSelectEvent.class);
        return arrayList;
    }

    @Override // com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QFSMixFeedMainTopTabPart";
    }

    public void init() {
        QQCircleFeedBase$StTabInfo qQCircleFeedBase$StTabInfo;
        QCircleFolderTabInfoManager m3 = QCircleFolderTabInfoManager.m();
        QCircleTabInfo qCircleTabInfo = this.f88201h;
        if (qCircleTabInfo == null) {
            qQCircleFeedBase$StTabInfo = null;
        } else {
            qQCircleFeedBase$StTabInfo = qCircleTabInfo.mTab;
        }
        QLog.d("QFSMixFeedMainTopTabPart", 1, "first init update info:" + m3.E(qQCircleFeedBase$StTabInfo));
        t tVar = new t(getHostFragment().getChildFragmentManager(), 1);
        this.f88200f = tVar;
        tVar.f(this.f88201h);
        this.f88199e.setAdapter(this.f88200f);
        this.f88199e.setOffscreenPageLimit(1);
        this.f88198d.setOnTabSelectListener(G9());
        this.f88199e.addOnPageChangeListener(F9());
        this.f88199e.setScrollable(uq3.c.W4());
        this.f88198d.setViewPager(this.f88199e);
        this.f88198d.setSnapOnTabClick(true);
        QCircleTabInfo qCircleTabInfo2 = this.f88201h;
        if (qCircleTabInfo2 != null && qCircleTabInfo2.mTab != null) {
            I9();
            J9();
            M9();
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        super.onInitView(view);
        SlidingTabLayout slidingTabLayout = (SlidingTabLayout) view.findViewById(R.id.f47641xu);
        this.f88198d = slidingTabLayout;
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) slidingTabLayout.getLayoutParams();
        layoutParams.topMargin = r.K(getContext()) + cx.a(48.0f);
        this.f88198d.setLayoutParams(layoutParams);
        this.f88199e = (QFSViewPager) view.findViewById(R.id.f47651xv);
        this.C = (t40.b) getIocInterface(t40.b.class);
        this.E = new t(getHostFragment().getChildFragmentManager(), 1);
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

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        if (simpleBaseEvent instanceof QFSSelectSubTabEvent) {
            final QFSSelectSubTabEvent qFSSelectSubTabEvent = (QFSSelectSubTabEvent) simpleBaseEvent;
            final int i3 = qFSSelectSubTabEvent.mSubTabType;
            RFWThreadManager.getInstance().runOnUiThread(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.part.mixfeed.QFSMixFeedMainTopTabPart.4
                @Override // java.lang.Runnable
                public void run() {
                    int e16 = d.e(QFSMixFeedMainTopTabPart.this.f88201h.mTab.subTabInfo.get(), i3);
                    QFSMixFeedMainTopTabPart.this.f88199e.setCurrentItem(e16, false);
                    QFSRefreshSubTabEvent qFSRefreshSubTabEvent = new QFSRefreshSubTabEvent(e16);
                    qFSRefreshSubTabEvent.setAnchor(qFSSelectSubTabEvent.getAnchor());
                    SimpleEventBus.getInstance().dispatchEvent(qFSRefreshSubTabEvent);
                }
            });
        } else if (simpleBaseEvent instanceof QFSMainTabSelectEvent) {
            H9((QFSMainTabSelectEvent) simpleBaseEvent);
        }
    }

    public void switchToContentState() {
        QFSViewPager qFSViewPager = this.f88199e;
        if (qFSViewPager != null && this.f88200f != null) {
            PagerAdapter adapter = qFSViewPager.getAdapter();
            QLog.d(getTAG(), 1, "switchToContentState adapter:" + adapter + ",mEmptyAdapter:" + this.E);
            if (adapter == this.E) {
                QLog.d(getTAG(), 1, "switchToContentState real");
                this.f88199e.setAdapter(this.f88200f);
                this.f88199e.setCurrentItem(this.D, false);
            }
        }
    }

    public void switchToEmptyState() {
        QFSViewPager qFSViewPager = this.f88199e;
        if (qFSViewPager == null || qFSViewPager.getAdapter() == this.E) {
            return;
        }
        QLog.d(getTAG(), 1, "switchToEmptyState");
        this.D = this.f88199e.getCurrentItem();
        this.f88199e.setAdapter(this.E);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class b implements ViewPager.OnPageChangeListener {
        b() {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i3) {
            QLog.d("QFSMixFeedMainTopTabPart", 1, "onPageSelected pos:" + ((Object) QFSMixFeedMainTopTabPart.this.f88200f.getPageTitle(i3)));
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i3) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i3, float f16, int i16) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class a implements sb0.a {
        a() {
        }

        @Override // sb0.a
        public void a(int i3) {
            QFSMixFeedMainTopTabPart.this.D9(i3, false);
        }

        @Override // sb0.a
        public void b(View view, int i3) {
            if (QFSMixFeedMainTopTabPart.this.f88200f == null) {
                return;
            }
            VideoReport.setElementId(view, QCircleDaTongConstant.ElementId.EM_XSJ_SECOND_TOP_TAB);
            Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
            buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_TAB_TITLE, QFSMixFeedMainTopTabPart.this.f88200f.getPageTitle(i3));
            VideoReport.setElementParams(view, buildElementParams);
        }

        @Override // sb0.a
        public void c(int i3) {
            QLog.d("QFSMixFeedMainTopTabPart", 1, "onTabReselect pos:" + ((Object) QFSMixFeedMainTopTabPart.this.f88200f.getPageTitle(i3)));
            SimpleEventBus.getInstance().dispatchEvent(new QFSRefreshSubTabEvent(i3));
        }

        @Override // sb0.a
        public void d(View view, int i3) {
        }
    }
}
