package com.tencent.biz.qqcircle.immersive.part.folder.homepage;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import androidx.viewpager.widget.ViewPager;
import com.tencent.biz.qqcircle.immersive.QFSBaseFragment;
import com.tencent.biz.qqcircle.immersive.QFSFolderOwnerFragment;
import com.tencent.biz.qqcircle.immersive.QFSFolderProfileFragment;
import com.tencent.biz.qqcircle.immersive.QFSMainFragment;
import com.tencent.biz.qqcircle.immersive.adapter.v;
import com.tencent.biz.qqcircle.immersive.events.QFSChangePgidEvent;
import com.tencent.biz.qqcircle.immersive.events.QFSDynamicUIBottomPanelVisibleEvent;
import com.tencent.biz.qqcircle.immersive.events.QFSHomePageSelectedEvent;
import com.tencent.biz.qqcircle.immersive.events.QFSSelectedPageEvent;
import com.tencent.biz.qqcircle.immersive.part.u;
import com.tencent.biz.qqcircle.immersive.views.QFSViewPager;
import com.tencent.biz.qqcircle.lazyload.QFSLazyExecuteEvent;
import com.tencent.biz.qqcircle.utils.bz;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.part.PartManager;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.event.QCircleSelectTabEvent;
import com.tencent.mobileqq.qcircle.api.global.QCircleHostGlobalInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.richframework.thread.RFWThreadManager;
import cooperation.qqcircle.helpers.QCircleSkinHelper;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import k30.e;

/* loaded from: classes4.dex */
public class QFSHomePageFragmentPart extends u implements SimpleEventReceiver, t40.b {
    private QFSFolderProfileFragment C;
    private RadioGroup D;
    private RadioButton E;
    private RadioButton F;
    private boolean G;

    /* renamed from: d, reason: collision with root package name */
    private final PartManager f88126d;

    /* renamed from: e, reason: collision with root package name */
    private QFSViewPager f88127e;

    /* renamed from: f, reason: collision with root package name */
    private v f88128f;

    /* renamed from: h, reason: collision with root package name */
    private final ArrayList<QFSBaseFragment> f88129h = new ArrayList<>();

    /* renamed from: i, reason: collision with root package name */
    private final ArrayList<RadioButton> f88130i = new ArrayList<>();

    /* renamed from: m, reason: collision with root package name */
    private QFSMainFragment f88131m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class a implements RadioGroup.OnCheckedChangeListener {
        a() {
        }

        @Override // android.widget.RadioGroup.OnCheckedChangeListener
        public void onCheckedChanged(RadioGroup radioGroup, int i3) {
            EventCollector.getInstance().onRadioGroupCheckedBefore(radioGroup, i3);
            boolean z16 = false;
            if (QFSHomePageFragmentPart.this.E.getId() == i3) {
                QFSHomePageFragmentPart.this.f88127e.setCurrentItem(0);
                QFSHomePageFragmentPart qFSHomePageFragmentPart = QFSHomePageFragmentPart.this;
                qFSHomePageFragmentPart.R9(qFSHomePageFragmentPart.G);
            } else if (QFSHomePageFragmentPart.this.F.getId() == i3) {
                QFSHomePageFragmentPart.this.P9();
                QFSHomePageFragmentPart.this.f88127e.setCurrentItem(1);
                SimpleEventBus.getInstance().dispatchEvent(new QFSChangePgidEvent("pg_xsj_profile_page"));
                QFSHomePageFragmentPart.this.R9(true);
            }
            QFSHomePageFragmentPart qFSHomePageFragmentPart2 = QFSHomePageFragmentPart.this;
            if (qFSHomePageFragmentPart2.E.getId() == i3) {
                z16 = true;
            }
            qFSHomePageFragmentPart2.broadcastMessage("qfs_set_folder_viewpage_scrollable", Boolean.valueOf(z16));
            EventCollector.getInstance().onRadioGroupChecked(radioGroup, i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class c implements QFSLazyExecuteEvent.a {
        c() {
        }

        @Override // com.tencent.biz.qqcircle.lazyload.QFSLazyExecuteEvent.a
        public void execute() {
            QFSHomePageFragmentPart.this.P9();
        }
    }

    public QFSHomePageFragmentPart(PartManager partManager) {
        this.f88126d = partManager;
    }

    private void H9() {
        ViewGroup.LayoutParams layoutParams;
        if (this.D == null || !bz.t() || (layoutParams = this.D.getLayoutParams()) == null || QCircleHostGlobalInfo.getQCircleTabHeight() == 0 || layoutParams.height == QCircleHostGlobalInfo.getQCircleTabHeight()) {
            return;
        }
        layoutParams.height = QCircleHostGlobalInfo.getQCircleTabHeight();
        this.D.setLayoutParams(layoutParams);
    }

    private void I9() {
        this.D.setOnCheckedChangeListener(new a());
    }

    private void J9() {
        this.f88127e.addOnPageChangeListener(new b());
    }

    private void K9(final int i3) {
        RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.part.folder.homepage.QFSHomePageFragmentPart.4
            @Override // java.lang.Runnable
            public void run() {
                if (QFSHomePageFragmentPart.this.f88127e != null && QFSHomePageFragmentPart.this.f88128f != null && i3 < QFSHomePageFragmentPart.this.f88128f.getF373114d()) {
                    QFSHomePageFragmentPart.this.f88127e.setCurrentItem(i3);
                }
            }
        });
    }

    private void M9(QFSLazyExecuteEvent qFSLazyExecuteEvent) {
        if (qFSLazyExecuteEvent.getNotifyId() == 1) {
            qFSLazyExecuteEvent.injectExecution(new c());
        }
    }

    private void N9() {
        RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.part.folder.homepage.QFSHomePageFragmentPart.3
            @Override // java.lang.Runnable
            public void run() {
                if (QFSHomePageFragmentPart.this.E != null) {
                    QFSHomePageFragmentPart.this.E.performClick();
                }
            }
        });
    }

    private void O9() {
        QFSMainFragment qFSMainFragment = new QFSMainFragment();
        this.f88131m = qFSMainFragment;
        qFSMainFragment.wh(2);
        this.f88131m.getPartManager().setPartManagerObservers(this.f88126d);
        this.f88129h.add(this.f88131m);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P9() {
        if (this.C == null) {
            QFSFolderOwnerFragment qFSFolderOwnerFragment = new QFSFolderOwnerFragment();
            this.C = qFSFolderOwnerFragment;
            this.f88129h.add(qFSFolderOwnerFragment);
            this.f88128f.d(this.f88129h);
            this.f88128f.notifyDataSetChanged();
        }
    }

    private void Q9(QFSDynamicUIBottomPanelVisibleEvent qFSDynamicUIBottomPanelVisibleEvent) {
        if (this.D != null && qFSDynamicUIBottomPanelVisibleEvent != null) {
            if (qFSDynamicUIBottomPanelVisibleEvent.getIsDynamicUIBottomPanelVisible()) {
                this.D.setVisibility(0);
            } else {
                this.D.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void R9(boolean z16) {
        int i3;
        int i16;
        QFSViewPager qFSViewPager = this.f88127e;
        if (qFSViewPager != null && qFSViewPager.getCurrentItem() == 1) {
            z16 = true;
        }
        RadioGroup radioGroup = this.D;
        if (radioGroup != null) {
            QCircleSkinHelper qCircleSkinHelper = QCircleSkinHelper.getInstance();
            if (z16) {
                i16 = R.color.qvideo_skin_color_bg_bottomnav;
            } else {
                i16 = R.color.cje;
            }
            radioGroup.setBackgroundColor(qCircleSkinHelper.getColor(i16));
        }
        RadioButton radioButton = this.E;
        int i17 = R.color.qvideo_skin_tab_text_color;
        if (radioButton != null) {
            QCircleSkinHelper qCircleSkinHelper2 = QCircleSkinHelper.getInstance();
            if (z16) {
                i3 = R.color.qvideo_skin_tab_text_color;
            } else {
                i3 = R.color.f157876cm4;
            }
            radioButton.setTextColor(qCircleSkinHelper2.getColorStateList(i3));
        }
        RadioButton radioButton2 = this.F;
        if (radioButton2 != null) {
            QCircleSkinHelper qCircleSkinHelper3 = QCircleSkinHelper.getInstance();
            if (!z16) {
                i17 = R.color.f157876cm4;
            }
            radioButton2.setTextColor(qCircleSkinHelper3.getColorStateList(i17));
        }
    }

    public String L9() {
        QFSViewPager qFSViewPager = this.f88127e;
        if (qFSViewPager != null && qFSViewPager.getCurrentItem() == 0) {
            QFSMainFragment qFSMainFragment = this.f88131m;
            if (qFSMainFragment == null || qFSMainFragment.getReportBean() == null) {
                return "";
            }
            return this.f88131m.getReportBean().getDtPageId();
        }
        QFSFolderProfileFragment qFSFolderProfileFragment = this.C;
        if (qFSFolderProfileFragment == null || qFSFolderProfileFragment.getReportBean() == null) {
            return "";
        }
        return this.C.getReportBean().getDtPageId();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void beforeFinish() {
        super.beforeFinish();
        Iterator<QFSBaseFragment> it = this.f88129h.iterator();
        while (it.hasNext()) {
            QFSBaseFragment next = it.next();
            if (next != null) {
                next.beforeFinish();
            }
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        ArrayList<Class> arrayList = new ArrayList<>();
        arrayList.add(QCircleSelectTabEvent.class);
        arrayList.add(QFSLazyExecuteEvent.class);
        arrayList.add(QFSSelectedPageEvent.class);
        arrayList.add(QFSDynamicUIBottomPanelVisibleEvent.class);
        return arrayList;
    }

    @Override // com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QFSHomePageFragmentPart";
    }

    @Override // com.tencent.biz.richframework.part.Part
    public Object getMessage(String str, Object obj) {
        return super.getMessage(str, obj);
    }

    @Override // com.tencent.biz.qqcircle.immersive.part.u
    public int getPageId() {
        QFSViewPager qFSViewPager = this.f88127e;
        if (qFSViewPager != null && qFSViewPager.getCurrentItem() == 0) {
            QFSMainFragment qFSMainFragment = this.f88131m;
            if (qFSMainFragment == null) {
                return -1;
            }
            return qFSMainFragment.getPageId();
        }
        QFSFolderProfileFragment qFSFolderProfileFragment = this.C;
        if (qFSFolderProfileFragment == null) {
            return -1;
        }
        return qFSFolderProfileFragment.getPageId();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public boolean onBackEvent() {
        Iterator<QFSBaseFragment> it = this.f88129h.iterator();
        while (it.hasNext()) {
            QFSBaseFragment next = it.next();
            if (next != null && next.onBackEvent()) {
                return true;
            }
        }
        return false;
    }

    @Override // com.tencent.biz.qqcircle.immersive.part.u
    protected void onEnableSkinChange(boolean z16) {
        this.G = z16;
        R9(z16);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        this.D = (RadioGroup) view.findViewById(R.id.f34610zm);
        this.E = (RadioButton) view.findViewById(R.id.f70553lr);
        RadioButton radioButton = (RadioButton) view.findViewById(R.id.f70563ls);
        this.F = radioButton;
        this.f88130i.addAll(Arrays.asList(this.E, radioButton));
        this.f88128f = new v(getHostFragment().getChildFragmentManager());
        QFSViewPager qFSViewPager = (QFSViewPager) view.findViewById(R.id.vfx);
        this.f88127e = qFSViewPager;
        qFSViewPager.setAdapter(this.f88128f);
        this.f88127e.setOffscreenPageLimit(3);
        this.f88127e.setScrollable(false);
        this.f88127e.setScrollWithAnim(false);
        J9();
        I9();
        H9();
        O9();
        this.f88128f.d(this.f88129h);
        this.f88128f.notifyDataSetChanged();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(Activity activity, Bundle bundle) {
        super.onPartCreate(activity, bundle);
        registerIoc(this, t40.b.class);
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        if (this.f88127e.getCurrentItem() == 1 && bz.t()) {
            e.i().t(2);
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        if (simpleBaseEvent instanceof QCircleSelectTabEvent) {
            N9();
            return;
        }
        if (simpleBaseEvent instanceof QFSLazyExecuteEvent) {
            M9((QFSLazyExecuteEvent) simpleBaseEvent);
        } else if (simpleBaseEvent instanceof QFSSelectedPageEvent) {
            K9(((QFSSelectedPageEvent) simpleBaseEvent).getSelectedIndex());
        } else if (simpleBaseEvent instanceof QFSDynamicUIBottomPanelVisibleEvent) {
            Q9((QFSDynamicUIBottomPanelVisibleEvent) simpleBaseEvent);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class b implements ViewPager.OnPageChangeListener {
        b() {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i3) {
            boolean z16 = true;
            QLog.i("QFSHomePageFragmentPart", 1, "fs_lifecycle onPageSelected mHomeViewPager pos = " + i3);
            for (int i16 = 0; i16 < QFSHomePageFragmentPart.this.f88129h.size(); i16++) {
                if (i16 == i3) {
                    ((RadioButton) QFSHomePageFragmentPart.this.f88130i.get(i16)).performClick();
                }
            }
            SimpleEventBus simpleEventBus = SimpleEventBus.getInstance();
            if (i3 != 0) {
                z16 = false;
            }
            simpleEventBus.dispatchEvent(new QFSHomePageSelectedEvent(z16));
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i3) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i3, float f16, int i16) {
        }
    }

    @Override // t40.b
    public void onHandlerMessage(String str, Object... objArr) {
    }
}
