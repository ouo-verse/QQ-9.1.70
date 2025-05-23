package g60;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.viewpager.widget.ViewPager;
import com.tencent.biz.qqcircle.QCirclePluginGlobalInfo;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.beans.QCircleFolderBean;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.events.QCirclePanelStateEvent;
import com.tencent.biz.qqcircle.immersive.QFSBaseFragment;
import com.tencent.biz.qqcircle.immersive.QFSFolderRightProfileFragment;
import com.tencent.biz.qqcircle.immersive.QFSMainFragment;
import com.tencent.biz.qqcircle.immersive.adapter.v;
import com.tencent.biz.qqcircle.immersive.events.QFSEnableSlideRightActionEvent;
import com.tencent.biz.qqcircle.immersive.events.QFSFolderMainPageSelectedEvent;
import com.tencent.biz.qqcircle.immersive.events.QFSSlideRightActionEvent;
import com.tencent.biz.qqcircle.immersive.part.u;
import com.tencent.biz.qqcircle.immersive.views.QFSViewPager;
import com.tencent.biz.qqcircle.launcher.c;
import com.tencent.biz.qqcircle.lazyload.QFSLazyExecuteEvent;
import com.tencent.biz.qqcircle.utils.bz;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.part.PartManager;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.auto.engine.loader.ASEngineUtils;
import com.tencent.mobileqq.qcircle.api.event.QFSFrameTabBarVisibleEvent;
import com.tencent.mobileqq.qcircle.api.global.QCircleHostGlobalInfo;
import com.tencent.mobileqq.qui.QUIImmersiveHelper;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import k30.e;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes4.dex */
public class a extends u implements SimpleEventReceiver, t40.b {
    private QFSMainFragment C;
    private QFSFolderRightProfileFragment D;

    /* renamed from: d, reason: collision with root package name */
    private final PartManager f401431d;

    /* renamed from: e, reason: collision with root package name */
    private final boolean f401432e;

    /* renamed from: f, reason: collision with root package name */
    private QFSViewPager f401433f;

    /* renamed from: h, reason: collision with root package name */
    private v f401434h;

    /* renamed from: i, reason: collision with root package name */
    private final ArrayList<QFSBaseFragment> f401435i = new ArrayList<>();

    /* renamed from: m, reason: collision with root package name */
    private int f401436m = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class b implements QFSLazyExecuteEvent.a {
        b() {
        }

        @Override // com.tencent.biz.qqcircle.lazyload.QFSLazyExecuteEvent.a
        public void execute() {
            if (a.this.C != null) {
                a.this.L9();
            }
        }
    }

    public a(PartManager partManager, boolean z16) {
        this.f401431d = partManager;
        this.f401432e = z16;
    }

    private void F9() {
        this.f401433f.addOnPageChangeListener(new C10357a());
    }

    private void G9(QFSEnableSlideRightActionEvent qFSEnableSlideRightActionEvent) {
        QFSViewPager qFSViewPager;
        if (getContext() != null && qFSEnableSlideRightActionEvent.getContextHashCode() == getContext().hashCode() && (qFSViewPager = this.f401433f) != null) {
            qFSViewPager.setScrollable(qFSEnableSlideRightActionEvent.isEnable());
        }
    }

    private void H9(QFSLazyExecuteEvent qFSLazyExecuteEvent) {
        if (qFSLazyExecuteEvent.getNotifyId() == 1) {
            qFSLazyExecuteEvent.injectExecution(new b());
        }
    }

    private void I9(QFSSlideRightActionEvent qFSSlideRightActionEvent) {
        if (this.f401433f != null && qFSSlideRightActionEvent.getHashCode() == getContext().hashCode()) {
            QFSFolderRightProfileFragment qFSFolderRightProfileFragment = this.D;
            if (qFSFolderRightProfileFragment != null) {
                qFSFolderRightProfileFragment.Ei(false);
                this.D.ki(qFSSlideRightActionEvent.getClientFromType());
            }
            this.f401433f.setCurrentItem(1);
        }
    }

    private void J9(QCircleFolderBean qCircleFolderBean) {
        QFSViewPager qFSViewPager;
        if (qCircleFolderBean != null && (qFSViewPager = this.f401433f) != null && qFSViewPager.getCurrentItem() != 0 && qCircleFolderBean.isTeenModeLimit()) {
            this.f401433f.setCurrentItem(0);
        }
    }

    private void K9(boolean z16) {
        QFSMainFragment qFSMainFragment = new QFSMainFragment();
        this.C = qFSMainFragment;
        qFSMainFragment.wh(3);
        this.C.getPartManager().setPartManagerObservers(this.f401431d);
        this.f401435i.add(this.C);
        QLog.d("QFSTabFolderFragmentPart", 1, "initMainFragment isCreateFromPreload :" + z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L9() {
        if (!c.d()) {
            QLog.d("QFSTabFolderFragmentPart", 1, "initProfileFragmentIfNeed return processId=", Integer.valueOf(MobileQQ.sProcessId));
            return;
        }
        if (this.D == null) {
            QFSFolderRightProfileFragment qFSFolderRightProfileFragment = new QFSFolderRightProfileFragment();
            this.D = qFSFolderRightProfileFragment;
            this.f401435i.add(qFSFolderRightProfileFragment);
            this.f401434h.d(this.f401435i);
            this.f401434h.notifyDataSetChanged();
        }
    }

    private void M9() {
        if (bz.t() && e.i().o() == 2) {
            QCircleInitBean qCircleInitBean = new QCircleInitBean();
            qCircleInitBean.setUser(QCirclePluginGlobalInfo.m());
            qCircleInitBean.setFromReportBean(getReportBean().m466clone());
            qCircleInitBean.setLaunchFrom("QFSTabFolderFragmentPart");
            c.d0(getContext(), qCircleInitBean);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void N9(int i3) {
        boolean z16;
        boolean isSpecifiedPanelShowing = QCirclePanelStateEvent.isSpecifiedPanelShowing(0);
        boolean isSpecifiedPanelShowing2 = QCirclePanelStateEvent.isSpecifiedPanelShowing(29);
        if (i3 == 0 && !isSpecifiedPanelShowing && !isSpecifiedPanelShowing2) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (isSpecifiedPanelShowing || isSpecifiedPanelShowing2) {
            QLog.d("QFSTabFolderFragmentPart", 1, "setFrameTabBarVisible has other panel showing");
        }
        QLog.d("QFSTabFolderFragmentPart", 1, "setFrameTabBarVisible:", Boolean.valueOf(z16));
        SimpleEventBus.getInstance().dispatchEvent(new QFSFrameTabBarVisibleEvent(z16));
    }

    public void O9(boolean z16) {
        if (this.C != null) {
            return;
        }
        QLog.d("QFSTabFolderFragmentPart", 1, "lazyLoad " + z16);
        K9(z16);
        this.f401434h.d(this.f401435i);
        this.f401434h.notifyDataSetChanged();
        M9();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void beforeFinish() {
        super.beforeFinish();
        Iterator<QFSBaseFragment> it = this.f401435i.iterator();
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
        arrayList.add(QFSLazyExecuteEvent.class);
        arrayList.add(QFSEnableSlideRightActionEvent.class);
        arrayList.add(QFSSlideRightActionEvent.class);
        return arrayList;
    }

    @Override // com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QFSTabFolderFragmentPart";
    }

    @Override // com.tencent.biz.richframework.part.Part
    public Object getMessage(String str, Object obj) {
        return super.getMessage(str, obj);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public boolean onBackEvent() {
        QFSViewPager qFSViewPager = this.f401433f;
        if (qFSViewPager == null) {
            return false;
        }
        if (qFSViewPager.getCurrentItem() != 0) {
            this.f401433f.setCurrentItem(0);
            return true;
        }
        Iterator<QFSBaseFragment> it = this.f401435i.iterator();
        while (it.hasNext()) {
            QFSBaseFragment next = it.next();
            if (next != null && next.onBackEvent()) {
                return true;
            }
        }
        return false;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        this.f401434h = new v(getHostFragment().getChildFragmentManager());
        QFSViewPager qFSViewPager = (QFSViewPager) view.findViewById(R.id.vfx);
        this.f401433f = qFSViewPager;
        qFSViewPager.setAdapter(this.f401434h);
        this.f401433f.setOffscreenPageLimit(3);
        F9();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        J9(QCirclePluginUtil.getFolderBeanFromIntent(intent));
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
        SimpleEventBus.getInstance().unRegisterReceiver(this);
        if (this.f401433f.getCurrentItem() == 1 && bz.t()) {
            SimpleEventBus.getInstance().dispatchEvent(new QFSFrameTabBarVisibleEvent(true));
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.part.u, com.tencent.biz.richframework.part.Part
    public void onPartResume(Activity activity) {
        super.onPartResume(activity);
        if (!QCircleHostGlobalInfo.isCurrentTabActive()) {
            QLog.e("QFSTabFolderFragmentPart", 1, "current is not tab mode!");
        } else {
            O9(false);
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        if (simpleBaseEvent instanceof QFSLazyExecuteEvent) {
            H9((QFSLazyExecuteEvent) simpleBaseEvent);
        } else if (simpleBaseEvent instanceof QFSEnableSlideRightActionEvent) {
            G9((QFSEnableSlideRightActionEvent) simpleBaseEvent);
        } else if (simpleBaseEvent instanceof QFSSlideRightActionEvent) {
            I9((QFSSlideRightActionEvent) simpleBaseEvent);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: g60.a$a, reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C10357a implements ViewPager.OnPageChangeListener {
        C10357a() {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i3, float f16, int i16) {
            if (f16 > 0.0f) {
                a.this.D.Ci();
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i3) {
            boolean z16 = true;
            QLog.i("QFSTabFolderFragmentPart", 1, "fs_lifecycle onPageSelected mFolderViewPager pos = " + i3 + " , mLastPageSelectPosition = " + a.this.f401436m);
            a.this.f401436m = i3;
            a.this.N9(i3);
            if (i3 == 1 && a.this.D != null) {
                a.this.D.Ei(a.this.f401433f.c());
                a.this.D.Di(a.this.C.getDaTongPageId());
                Context hostContext = ASEngineUtils.getHostContext(a.this.getContext());
                if (hostContext instanceof Activity) {
                    QUIImmersiveHelper.s((Activity) hostContext, true, true);
                }
            }
            SimpleEventBus simpleEventBus = SimpleEventBus.getInstance();
            if (i3 != 0) {
                z16 = false;
            }
            simpleEventBus.dispatchEvent(new QFSFolderMainPageSelectedEvent(z16));
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i3) {
        }
    }

    @Override // t40.b
    public void onHandlerMessage(String str, Object... objArr) {
    }
}
