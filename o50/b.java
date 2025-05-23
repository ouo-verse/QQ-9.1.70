package o50;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.ViewPager;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.beans.QCircleLayerBean;
import com.tencent.biz.qqcircle.immersive.QFSBaseFragment;
import com.tencent.biz.qqcircle.immersive.QFSLayerPageFragment;
import com.tencent.biz.qqcircle.immersive.adapter.v;
import com.tencent.biz.qqcircle.immersive.events.QFSEnableSlideRightActionEvent;
import com.tencent.biz.qqcircle.immersive.events.QFSSlideRightActionEvent;
import com.tencent.biz.qqcircle.immersive.part.u;
import com.tencent.biz.qqcircle.immersive.views.QFSVideoView;
import com.tencent.biz.qqcircle.immersive.views.QFSViewPager;
import com.tencent.biz.qqcircle.lazyload.QFSLazyExecuteEvent;
import com.tencent.biz.richframework.compat.DisplayUtil;
import com.tencent.biz.richframework.compat.ImmersiveUtils;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.part.PartManager;
import com.tencent.biz.richframework.video.rfw.view.RFWPlayerReuseUtils;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import m50.h;
import t40.f;

/* compiled from: P */
/* loaded from: classes4.dex */
public class b extends u implements SimpleEventReceiver {
    private final h C;

    /* renamed from: d, reason: collision with root package name */
    private final PartManager f422079d;

    /* renamed from: e, reason: collision with root package name */
    private QFSViewPager f422080e;

    /* renamed from: f, reason: collision with root package name */
    private v f422081f;

    /* renamed from: h, reason: collision with root package name */
    private final ArrayList<QFSBaseFragment> f422082h = new ArrayList<>();

    /* renamed from: i, reason: collision with root package name */
    private QFSLayerPageFragment f422083i;

    /* renamed from: m, reason: collision with root package name */
    private QCircleInitBean f422084m;

    public b(PartManager partManager, QCircleInitBean qCircleInitBean) {
        this.f422079d = partManager;
        this.f422084m = qCircleInitBean;
        this.C = new h(qCircleInitBean);
    }

    private void B9() {
        this.f422080e.addOnPageChangeListener(new C10883b());
    }

    private void C9(QCircleInitBean qCircleInitBean) {
        View partRootView = getPartRootView();
        if ((partRootView instanceof ViewGroup) && qCircleInitBean != null) {
            this.C.v((ViewGroup) partRootView, DisplayUtil.getTopHeight(getContext()), ImmersiveUtils.dpToPx(56.0f), true);
            this.C.H(getActivity(), this.f422084m.getFeed(), new a());
            return;
        }
        D9();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D9() {
        RFWLog.d("QFSLayerFolderMainPart", RFWLog.USR, "doFastPlayFinish");
        G9();
    }

    private void G9() {
        if (this.f422081f != null || getHostFragment().getHost() == null) {
            return;
        }
        QLog.d("QFSLayerFolderMainPart", 1, "handleInitView start");
        this.f422081f = new v(getHostFragment().getChildFragmentManager());
        QFSViewPager qFSViewPager = (QFSViewPager) getPartRootView().findViewById(R.id.vfx);
        this.f422080e = qFSViewPager;
        qFSViewPager.setAdapter(this.f422081f);
        this.f422080e.setOffscreenPageLimit(3);
        B9();
        I9();
        this.f422081f.d(this.f422082h);
        this.f422081f.notifyDataSetChanged();
    }

    private void H9(Object... objArr) {
        QFSViewPager qFSViewPager;
        if (objArr != null && objArr.length != 0) {
            Object obj = objArr[0];
            if ((obj instanceof Boolean) && (qFSViewPager = this.f422080e) != null) {
                qFSViewPager.setScrollable(((Boolean) obj).booleanValue());
            }
        }
    }

    private void I9() {
        QFSLayerPageFragment F9 = F9();
        this.f422083i = F9;
        F9.getPartManager().setPartManagerObservers(this.f422079d);
        this.f422082h.add(this.f422083i);
    }

    private void J9() {
        WeakReference<QFSVideoView> weakReference;
        QCircleInitBean qCircleInitBean = this.f422084m;
        if (!(qCircleInitBean instanceof QCircleLayerBean) || !((QCircleLayerBean) qCircleInitBean).enableReUseWhenExit() || (weakReference = QFSVideoView.D) == null || weakReference.get() == null) {
            return;
        }
        RFWPlayerReuseUtils.prepareToReusePlayer(QFSVideoView.D.get());
    }

    public QFSLayerPageFragment E9() {
        return this.f422083i;
    }

    protected QFSLayerPageFragment F9() {
        return new QFSLayerPageFragment();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void beforeFinish() {
        super.beforeFinish();
        Iterator<QFSBaseFragment> it = this.f422082h.iterator();
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
        return "QFSLayerFolderMainPart";
    }

    @Override // com.tencent.biz.qqcircle.immersive.part.u, com.tencent.biz.richframework.part.Part
    public void handleBroadcastMessage(String str, Object obj) {
        super.handleBroadcastMessage(str, obj);
        if ("qfs_set_folder_viewpage_scrollable".equals(str)) {
            H9(obj);
        } else if ("qfs_transition_end_and_start_layout".equals(str)) {
            G9();
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public boolean onBackEvent() {
        QFSViewPager qFSViewPager = this.f422080e;
        if (qFSViewPager == null) {
            return false;
        }
        if (qFSViewPager.getCurrentItem() != 0) {
            this.f422080e.setCurrentItem(0);
            return true;
        }
        Iterator<QFSBaseFragment> it = this.f422082h.iterator();
        while (it.hasNext()) {
            QFSBaseFragment next = it.next();
            if (next != null && next.onBackEvent()) {
                return true;
            }
        }
        J9();
        return false;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        QCircleInitBean qCircleInitBean = this.f422084m;
        if (qCircleInitBean == null || !(qCircleInitBean instanceof QCircleLayerBean) || ((QCircleLayerBean) qCircleInitBean).getTransitionAnimBean() == null || !e.P9()) {
            if (ac0.a.a(this.f422084m) && u40.a.b(this.f422084m)) {
                QLog.d("QFSLayerFolderMainPart", 1, "handleInitView start fastPlay");
                C9(this.f422084m);
            } else {
                G9();
            }
        }
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
        this.C.D();
        QLog.d("QFSLayerFolderMainPart", 1, "fs_lifecycle onPartDestroy");
    }

    @Override // com.tencent.biz.qqcircle.immersive.part.u, com.tencent.biz.richframework.part.Part
    public void onPartPause(Activity activity) {
        super.onPartPause(activity);
        this.C.F();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class a implements h.c {
        a() {
        }

        @Override // m50.h.c
        public void a() {
            f fVar = (f) b.this.getIocInterface(f.class);
            if (fVar != null) {
                fVar.p8(b.this.C.x());
            }
            b.this.D9();
        }

        @Override // m50.h.c
        public void b() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: o50.b$b, reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C10883b implements ViewPager.OnPageChangeListener {
        C10883b() {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i3) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i3) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i3, float f16, int i16) {
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
    }
}
