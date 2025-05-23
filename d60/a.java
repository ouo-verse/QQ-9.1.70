package d60;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.viewpager.widget.ViewPager;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.beans.QCircleFolderBean;
import com.tencent.biz.qqcircle.events.QCirclePanelStateEvent;
import com.tencent.biz.qqcircle.immersive.QFSBaseFragment;
import com.tencent.biz.qqcircle.immersive.QFSFolderRightProfileFragment;
import com.tencent.biz.qqcircle.immersive.QFSHomePageFragment;
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
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes4.dex */
public class a extends u implements SimpleEventReceiver {

    /* renamed from: d, reason: collision with root package name */
    private final PartManager f393117d;

    /* renamed from: e, reason: collision with root package name */
    private QFSViewPager f393118e;

    /* renamed from: f, reason: collision with root package name */
    private v f393119f;

    /* renamed from: i, reason: collision with root package name */
    private QFSHomePageFragment f393121i;

    /* renamed from: m, reason: collision with root package name */
    private QFSFolderRightProfileFragment f393122m;

    /* renamed from: h, reason: collision with root package name */
    private final ArrayList<QFSBaseFragment> f393120h = new ArrayList<>();
    private boolean C = true;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class b implements QFSLazyExecuteEvent.a {
        b() {
        }

        @Override // com.tencent.biz.qqcircle.lazyload.QFSLazyExecuteEvent.a
        public void execute() {
            a.this.I9();
        }
    }

    public a(PartManager partManager) {
        this.f393117d = partManager;
    }

    private void B9() {
        this.f393118e.addOnPageChangeListener(new C10161a());
    }

    private void C9(QFSEnableSlideRightActionEvent qFSEnableSlideRightActionEvent) {
        if (getContext() != null && qFSEnableSlideRightActionEvent.getContextHashCode() == getContext().hashCode() && this.f393118e != null) {
            this.C = qFSEnableSlideRightActionEvent.isEnable();
            this.f393118e.setScrollable(qFSEnableSlideRightActionEvent.isEnable());
        }
    }

    private void D9(QFSLazyExecuteEvent qFSLazyExecuteEvent) {
        if (qFSLazyExecuteEvent.getNotifyId() == 1) {
            qFSLazyExecuteEvent.injectExecution(new b());
        }
    }

    private void E9(Object... objArr) {
        QFSViewPager qFSViewPager;
        if (objArr != null && objArr.length != 0) {
            Object obj = objArr[0];
            if ((obj instanceof Boolean) && (qFSViewPager = this.f393118e) != null && this.C) {
                qFSViewPager.setScrollable(((Boolean) obj).booleanValue());
            }
        }
    }

    private void F9(QFSSlideRightActionEvent qFSSlideRightActionEvent) {
        if (this.f393118e != null && qFSSlideRightActionEvent.getHashCode() == getContext().hashCode()) {
            QFSFolderRightProfileFragment qFSFolderRightProfileFragment = this.f393122m;
            if (qFSFolderRightProfileFragment != null) {
                qFSFolderRightProfileFragment.Ei(false);
                this.f393122m.ki(qFSSlideRightActionEvent.getClientFromType());
            }
            this.f393118e.setCurrentItem(1);
        }
    }

    private void G9(QCircleFolderBean qCircleFolderBean) {
        QFSViewPager qFSViewPager;
        if (qCircleFolderBean != null && (qFSViewPager = this.f393118e) != null && qFSViewPager.getCurrentItem() != 0 && qCircleFolderBean.isTeenModeLimit()) {
            this.f393118e.setCurrentItem(0);
        }
    }

    private void H9() {
        QFSHomePageFragment qFSHomePageFragment = new QFSHomePageFragment();
        this.f393121i = qFSHomePageFragment;
        qFSHomePageFragment.getPartManager().setPartManagerObservers(this.f393117d);
        this.f393120h.add(this.f393121i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I9() {
        if (!c.d()) {
            QLog.d("QFSFolderFragmentPart", 1, "initProfileFragmentIfNeed return processId=", Integer.valueOf(MobileQQ.sProcessId));
            return;
        }
        if (this.f393122m == null) {
            QFSFolderRightProfileFragment qFSFolderRightProfileFragment = new QFSFolderRightProfileFragment();
            this.f393122m = qFSFolderRightProfileFragment;
            this.f393120h.add(qFSFolderRightProfileFragment);
            this.f393119f.d(this.f393120h);
            this.f393119f.notifyDataSetChanged();
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void beforeFinish() {
        super.beforeFinish();
        Iterator<QFSBaseFragment> it = this.f393120h.iterator();
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
        return "QFSFolderFragmentPart";
    }

    @Override // com.tencent.biz.richframework.part.Part
    public Object getMessage(String str, Object obj) {
        return super.getMessage(str, obj);
    }

    @Override // com.tencent.biz.qqcircle.immersive.part.u, com.tencent.biz.richframework.part.Part
    public void handleBroadcastMessage(String str, Object obj) {
        super.handleBroadcastMessage(str, obj);
        if ("qfs_set_folder_viewpage_scrollable".equals(str)) {
            E9(obj);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public boolean onBackEvent() {
        QFSViewPager qFSViewPager = this.f393118e;
        if (qFSViewPager == null) {
            return false;
        }
        if (qFSViewPager.getCurrentItem() != 0) {
            this.f393118e.setCurrentItem(0);
            return true;
        }
        Iterator<QFSBaseFragment> it = this.f393120h.iterator();
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
        this.f393119f = new v(getHostFragment().getChildFragmentManager());
        QFSViewPager qFSViewPager = (QFSViewPager) view.findViewById(R.id.vfx);
        this.f393118e = qFSViewPager;
        qFSViewPager.setAdapter(this.f393119f);
        this.f393118e.setOffscreenPageLimit(3);
        B9();
        H9();
        this.f393119f.d(this.f393120h);
        this.f393119f.notifyDataSetChanged();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        G9(QCirclePluginUtil.getFolderBeanFromIntent(intent));
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(Activity activity, Bundle bundle) {
        super.onPartCreate(activity, bundle);
        SimpleEventBus.getInstance().registerReceiver(this);
        p40.u.H().E0();
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        SimpleEventBus.getInstance().unRegisterReceiver(this);
        QLog.d("QFSFolderFragmentPart", 1, "fs_lifecycle onPartDestroy");
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        if (simpleBaseEvent instanceof QFSLazyExecuteEvent) {
            D9((QFSLazyExecuteEvent) simpleBaseEvent);
        } else if (simpleBaseEvent instanceof QFSEnableSlideRightActionEvent) {
            C9((QFSEnableSlideRightActionEvent) simpleBaseEvent);
        } else if (simpleBaseEvent instanceof QFSSlideRightActionEvent) {
            F9((QFSSlideRightActionEvent) simpleBaseEvent);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: d60.a$a, reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C10161a implements ViewPager.OnPageChangeListener {
        C10161a() {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i3, float f16, int i16) {
            if (f16 > 0.0f) {
                a.this.f393122m.Ci();
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i3) {
            boolean z16;
            boolean z17 = true;
            QLog.i("QFSFolderFragmentPart", 1, "fs_lifecycle onPageSelected mFolderViewPager pos = " + i3);
            if (i3 == 1 && a.this.f393122m != null) {
                a.this.f393122m.Ei(a.this.f393118e.c());
            }
            if (bz.p()) {
                SimpleEventBus simpleEventBus = SimpleEventBus.getInstance();
                if (i3 == 1 && a.this.f393122m != null) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                simpleEventBus.dispatchEvent(new QCirclePanelStateEvent(36, "", z16));
            }
            SimpleEventBus simpleEventBus2 = SimpleEventBus.getInstance();
            if (i3 != 0) {
                z17 = false;
            }
            simpleEventBus2.dispatchEvent(new QFSFolderMainPageSelectedEvent(z17));
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i3) {
        }
    }
}
