package com.tencent.av.ui.effect.toolbar.newversion;

import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.ViewTreeObserver;
import androidx.viewpager.widget.ViewPager;
import com.tencent.aelight.camera.api.IAEQQFilamentManager;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.business.manager.EffectConfigBase;
import com.tencent.av.business.manager.magicface.FaceItem;
import com.tencent.av.business.manager.pendant.EffectPendantTools;
import com.tencent.av.business.manager.pendant.PendantItem;
import com.tencent.av.n;
import com.tencent.av.opengl.effects.ag;
import com.tencent.av.opengl.effects.m;
import com.tencent.av.r;
import com.tencent.av.ui.AVActivity;
import com.tencent.av.ui.QavListItemBase;
import com.tencent.av.ui.c;
import com.tencent.av.ui.effect.toolbar.BaseToolbar;
import com.tencent.av.ui.effect.view.EffectViewPager;
import com.tencent.av.ui.effect.view.QavEffectSlidingTabView;
import com.tencent.av.ui.t;
import com.tencent.av.utils.AVUtil;
import com.tencent.av.utils.e;
import com.tencent.avcore.util.AVCoreLog;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.PtvTemplateManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.vas.IndividuationUrlHelper;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.CopyOnWriteArrayList;
import org.light.DeviceSupportUtil;

/* loaded from: classes3.dex */
public class PendantToolbar extends BaseToolbarNewVersion implements QavEffectSlidingTabView.c, ViewTreeObserver.OnScrollChangedListener, ViewPager.OnPageChangeListener, iw.b, EffectConfigBase.b<PendantItem> {
    public static final String TAG = "PendantToolbar";
    iw.a mEffectClickCallback;
    private hu.a mEffectMaterialManager;
    protected b mObserver;
    private com.tencent.av.ui.effect.adapter.a mPageAdapter;
    private EffectPendantTools mPendantManager;
    private List<hw.a> mTabList;
    private QavEffectSlidingTabView mTopTabBar;
    BaseToolbar.a mUIInfo;
    private EffectViewPager mViewPager;

    /* loaded from: classes3.dex */
    class a implements iw.a {
        a() {
        }

        @Override // iw.a
        public void b(long j3, QavListItemBase.c cVar) {
            BaseToolbar.keepInToolbar(((BaseToolbar) PendantToolbar.this).mApp, j3);
            m R = r.h0().R(false);
            if (R != null) {
                if (e.k()) {
                    QLog.w(PendantToolbar.TAG, 1, "onEffectClick, clearState, seq[" + j3 + "], info[" + cVar + "]");
                }
                R.a(j3);
            }
            if (cVar.f75024a.equals("0")) {
                PendantToolbar.this.postSetCurrentItemById(j3, null);
                n.e().f().f73082t2 = 0;
                r.h0().R1();
                return;
            }
            if (!cVar.f75027d) {
                return;
            }
            String str = PtvTemplateManager.f287624t + cVar.f75026c;
            boolean isEffectBtnNormal = PendantToolbar.this.isEffectBtnNormal();
            if (QLog.isColorLevel()) {
                QLog.w(PendantToolbar.TAG, 1, "onEffectClick, path[" + str + "], bSuc[" + isEffectBtnNormal + "], seq[" + j3 + "]");
            }
            PendantToolbar.this.postSetCurrentItemById(j3, cVar.f75024a);
            if (PendantToolbar.this.mEffectMaterialManager.o() != 0) {
                int i3 = n.e().f().S0;
                PendantItem w3 = PendantToolbar.this.mPendantManager.w(cVar.f75024a);
                c.c(i3, w3.getCategoryName(), w3.getName());
            }
        }

        @Override // iw.a
        public void c(long j3) {
            BaseToolbar.keepInToolbar(((BaseToolbar) PendantToolbar.this).mApp, j3);
        }

        @Override // iw.a
        public void d(QavListItemBase.c cVar) {
            if (!PendantToolbar.this.mEffectMaterialManager.m((ArrayList) PendantToolbar.this.mEffectMaterialManager.v(), cVar)) {
                PendantToolbar.this.mEffectMaterialManager.v().add(1, cVar);
                int size = PendantToolbar.this.mEffectMaterialManager.v().size();
                if (size > 20) {
                    PendantToolbar.this.mEffectMaterialManager.v().subList(20, size).clear();
                }
            }
            PendantToolbar.this.mEffectMaterialManager.J(cVar.f75024a);
            PendantToolbar.this.mEffectMaterialManager.C();
            PendantToolbar.this.mEffectMaterialManager.B();
            if (cVar.f75024a.equals("0")) {
                return;
            }
            int i3 = n.e().f().S0;
            PendantItem w3 = PendantToolbar.this.mPendantManager.w(cVar.f75024a);
            if (PendantToolbar.this.mEffectMaterialManager.o() == 0) {
                PendantToolbar.this.recentPendantClickReport(w3);
            } else if (w3 != null) {
                c.d(i3, w3.getCategoryName(), w3.getName());
            }
        }
    }

    /* loaded from: classes3.dex */
    static class b implements Observer {

        /* renamed from: d, reason: collision with root package name */
        private final WeakReference<PendantToolbar> f75572d;

        b(PendantToolbar pendantToolbar) {
            this.f75572d = new WeakReference<>(pendantToolbar);
        }

        @Override // java.util.Observer
        public void update(Observable observable, Object obj) {
            PendantToolbar pendantToolbar = this.f75572d.get();
            if (pendantToolbar != null) {
                pendantToolbar.handlerObserver(observable, obj);
            }
        }
    }

    public PendantToolbar(VideoAppInterface videoAppInterface, AVActivity aVActivity) {
        super(videoAppInterface, aVActivity);
        this.mUIInfo = null;
        this.mTabList = new CopyOnWriteArrayList();
        this.mEffectClickCallback = new a();
    }

    private void addRecent() {
        this.mEffectMaterialManager.L(new ArrayList(20));
        hw.a aVar = new hw.a();
        aVar.f406498a = "-9999";
        aVar.f406499b = getAVActivity().getResources().getString(R.string.f1779735e);
        this.mEffectMaterialManager.v().add(constructItem("0", String.valueOf(R.drawable.n7e), "", ""));
        ArrayList<QavListItemBase.c> y16 = this.mEffectMaterialManager.y(getAVActivity(), "recent_pendant_list_key", this.mTabList);
        if (y16 != null && y16.size() > 0) {
            this.mEffectMaterialManager.v().addAll(y16);
        }
        aVar.f406501d = this.mEffectMaterialManager.v();
        this.mTabList.add(0, aVar);
    }

    @Nullable
    private String getCurrentPendantId() {
        EffectPendantTools effectPendantTools = this.mPendantManager;
        String str = effectPendantTools.J;
        if (str != null) {
            effectPendantTools.J = null;
        } else {
            PendantItem u16 = effectPendantTools.u();
            if (u16 != null && u16.isShow()) {
                str = u16.getId();
            } else {
                str = null;
            }
        }
        if (QLog.isColorLevel()) {
            QLog.w(TAG, 1, "getCurrentPendantId, id[" + str + "]");
        }
        return str;
    }

    private ArrayList<QavEffectSlidingTabView.e> getTabNameList() {
        ArrayList<QavEffectSlidingTabView.e> arrayList = new ArrayList<>();
        for (int i3 = 0; i3 < this.mTabList.size(); i3++) {
            hw.a aVar = this.mTabList.get(i3);
            if (aVar != null) {
                QavEffectSlidingTabView.e eVar = new QavEffectSlidingTabView.e();
                eVar.f75600a = aVar.f406499b;
                arrayList.add(eVar);
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handlerObserver(Observable observable, Object obj) {
        String id5;
        Object[] objArr = (Object[]) obj;
        if (((Integer) objArr[0]).intValue() == 168) {
            FaceItem faceItem = (FaceItem) objArr[1];
            StringBuilder sb5 = new StringBuilder();
            sb5.append("TYPE_NOTIFY_FACE_ITEM_STATE_CHANGE :");
            if (faceItem == null) {
                id5 = "null";
            } else {
                id5 = faceItem.getId();
            }
            sb5.append(id5);
            AVCoreLog.printAllUserLog(TAG, sb5.toString());
            if (faceItem != null) {
                setLastItem();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void postSetCurrentItemById(final long j3, final String str) {
        FaceItem u16;
        notifyEvent(6101, null, Boolean.TRUE);
        this.mApp.M().post(new Runnable() { // from class: com.tencent.av.ui.effect.toolbar.newversion.PendantToolbar.2
            @Override // java.lang.Runnable
            public void run() {
                if (PendantToolbar.this.mPendantManager != null) {
                    QLog.w(PendantToolbar.TAG, 1, "postSetCurrentItemById, id[" + str + "], seq[" + j3 + "]");
                    PendantToolbar.this.mPendantManager.M(j3, str);
                }
            }
        });
        boolean z16 = false;
        if (this.mApp.Y(3) && (u16 = ((com.tencent.av.business.manager.magicface.a) this.mApp.B(3)).u()) != null && TextUtils.isEmpty(u16.getId())) {
            z16 = true;
        }
        if (QLog.isColorLevel()) {
            QLog.w(TAG, 1, "postSetCurrentItemById, isInDoubleScreenPendant[" + z16 + "], seq[" + j3 + "]");
        }
        if (z16) {
            r.h0().s2(3, "START_0");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void recentPendantClickReport(PendantItem pendantItem) {
        if (pendantItem == null) {
            return;
        }
        int i3 = -1;
        for (int i16 = 0; i16 < this.mEffectMaterialManager.v().size(); i16++) {
            if (this.mEffectMaterialManager.v().get(i16).f75024a.equals(pendantItem.getId())) {
                i3 = i16;
            }
        }
        if (i3 != -1) {
            ReportController.o(null, "dc00898", "", "", "0X800BC11", "0X800BC11", 0, 0, String.valueOf(i3), "", "", pendantItem.getName());
        }
    }

    private void setLastItem() {
        String currentPendantId;
        if (this.mApp.Y(3)) {
            FaceItem u16 = ((com.tencent.av.business.manager.magicface.a) this.mApp.B(3)).u();
            if (u16 != null) {
                u16.isSameType(IndividuationUrlHelper.UrlId.PENDANT_HOME);
                currentPendantId = null;
            } else {
                currentPendantId = getCurrentPendantId();
            }
        } else {
            currentPendantId = getCurrentPendantId();
        }
        if (currentPendantId == null) {
            currentPendantId = "0";
        }
        this.mEffectMaterialManager.J(currentPendantId);
        this.mEffectMaterialManager.B();
    }

    public ArrayList<hw.a> constructCategory() {
        QavListItemBase.c constructItem = constructItem("0", String.valueOf(R.drawable.n7e), "", "");
        List<PendantItem> q16 = this.mPendantManager.q(null);
        ArrayList<hw.a> arrayList = new ArrayList<>();
        for (PendantItem pendantItem : q16) {
            if (pendantItem.isZplan() && pendantItem.getZplanRenderType() == 1) {
                ((IAEQQFilamentManager) QRoute.api(IAEQQFilamentManager.class)).getAEFilamentManager().addZplanFilamentMaterialMap(pendantItem.getId());
                if (!DeviceSupportUtil.isAbilityDeviceSupport("ai.face3d")) {
                    QLog.d(TAG, 4, "Filament is not enable, can not show material id: " + pendantItem.getId());
                }
            }
            Iterator<hw.a> it = arrayList.iterator();
            boolean z16 = false;
            while (it.hasNext()) {
                hw.a next = it.next();
                if (next.f406498a.equals(pendantItem.getCategoryId())) {
                    next.f406501d.add(t.a(0, pendantItem));
                    z16 = true;
                }
            }
            if (!z16 && !"notshow".equals(pendantItem.getCategoryName())) {
                hw.a aVar = new hw.a();
                aVar.f406498a = pendantItem.getCategoryId();
                aVar.f406499b = pendantItem.getCategoryName();
                aVar.f406501d.add(constructItem);
                aVar.f406501d.add(t.a(0, pendantItem));
                arrayList.add(aVar);
            }
        }
        return arrayList;
    }

    public QavListItemBase.c constructItem(String str, String str2, String str3, String str4) {
        QavListItemBase.c cVar = new QavListItemBase.c();
        cVar.f75024a = str;
        cVar.f75026c = str;
        cVar.f75025b = str2;
        cVar.f75028e = false;
        return cVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.av.ui.effect.toolbar.BaseToolbar
    public BaseToolbar.a getUIInfo() {
        if (this.mUIInfo == null) {
            BaseToolbar.a aVar = new BaseToolbar.a();
            this.mUIInfo = aVar;
            aVar.f75560d = 1;
            aVar.f75564h = R.layout.f168482fu0;
            aVar.f75562f = R.drawable.de7;
            aVar.f75563g = this.mApp.getApp().getString(R.string.dld);
        }
        return this.mUIInfo;
    }

    @Override // com.tencent.av.ui.effect.toolbar.BaseToolbar
    public String getUnableInfo() {
        if (this.mActivity.get() != null) {
            return this.mActivity.get().getResources().getString(R.string.f171221da3);
        }
        return "";
    }

    @Override // com.tencent.av.ui.effect.toolbar.BaseToolbar
    public boolean isEffectBtnNormal() {
        if (is64bitAndSDKVersionUnderM()) {
            return false;
        }
        return super.isEffectBtnNormal();
    }

    protected void notifyEvent(Integer num, Object obj, Object obj2) {
        AVCoreLog.printColorLog(TAG, "notifyEvent :" + num + "|" + obj);
        this.mApp.k0(new Object[]{num, obj, obj2});
    }

    @Override // com.tencent.av.ui.effect.toolbar.BaseToolbar
    protected void onCreate(long j3, AVActivity aVActivity) {
        this.mPendantManager = (EffectPendantTools) this.mApp.B(2);
        this.mEffectMaterialManager = (hu.a) this.mApp.B(15);
        this.mTabList = new ArrayList(constructCategory());
        addRecent();
        QavEffectSlidingTabView qavEffectSlidingTabView = (QavEffectSlidingTabView) this.toolbarView.findViewById(R.id.e1y);
        this.mTopTabBar = qavEffectSlidingTabView;
        qavEffectSlidingTabView.setTabCheckListener(this);
        this.mTopTabBar.getViewTreeObserver().addOnScrollChangedListener(this);
        this.mTopTabBar.d(getTabNameList());
        this.mTopTabBar.setTabCheckListener(this);
        this.mViewPager = (EffectViewPager) this.toolbarView.findViewById(R.id.kwk);
        com.tencent.av.ui.effect.adapter.a aVar = new com.tencent.av.ui.effect.adapter.a(getAVActivity(), this.mApp, 1);
        this.mPageAdapter = aVar;
        aVar.k(this);
        this.mPageAdapter.j(this.mEffectClickCallback);
        this.mPageAdapter.setCategoryList(this.mTabList);
        this.mViewPager.setOnPageChangeListener(this);
        this.mViewPager.setAdapter(this.mPageAdapter);
        if (this.mTabList.size() > this.mEffectMaterialManager.o()) {
            this.mViewPager.setCurrentItem(this.mEffectMaterialManager.o());
        }
        this.mObserver = new b(this);
        this.mEffectMaterialManager.J(null);
        setLastItem();
        AVUtil.c(100);
    }

    @Override // com.tencent.av.ui.effect.toolbar.BaseToolbar
    protected void onDestroy(long j3, VideoAppInterface videoAppInterface) {
        this.mPendantManager.J(j3, this);
        this.mEffectMaterialManager.F(getAVActivity(), "recent_pendant_list_key", this.mEffectMaterialManager.v());
        this.mEffectMaterialManager.L(new ArrayList());
        this.mEffectMaterialManager.J(null);
        com.tencent.av.ui.effect.adapter.a aVar = this.mPageAdapter;
        if (aVar != null) {
            aVar.onDestroy();
        }
    }

    @Override // com.tencent.av.ui.effect.toolbar.BaseToolbar
    protected void onHide(long j3) {
        this.mPendantManager.J(j3, this);
        this.mApp.deleteObserver(this.mObserver);
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i3, float f16, int i16) {
        BaseToolbar.keepInToolbar(this.mApp, -1054L);
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageSelected(int i3) {
        this.mTopTabBar.f(i3);
        this.mEffectMaterialManager.G(i3);
        if (i3 == 0) {
            ReportController.o(null, "dc00898", "", "", "0X800BC10", "0X800BC10", 0, 0, "", "", "", "");
        } else {
            ReportController.o(null, "dc00898", "", "", "0X800BC0F", "0X800BC0F", 0, 0, "", "", this.mTabList.get(i3).f406499b, "");
        }
    }

    @Override // com.tencent.av.ui.effect.toolbar.BaseToolbar
    protected void onShow(long j3, int i3, boolean z16) {
        this.mPendantManager.p(j3, this);
        this.mApp.addObserver(this.mObserver);
        setLastItem();
    }

    @Override // com.tencent.av.ui.effect.view.QavEffectSlidingTabView.c
    public void onTabChecked(int i3) {
        this.mViewPager.setCurrentItem(i3);
    }

    @Override // iw.b
    public void startDownloadTemplate(AppInterface appInterface, long j3, QavListItemBase.c cVar, QavListItemBase.b bVar) {
        PendantItem w3 = this.mPendantManager.w(cVar.f75024a);
        if (w3 != null) {
            this.mPendantManager.N(j3, w3);
            return;
        }
        QLog.w(TAG, 1, "startDownloadTemplate, item\u4e3a\u7a7a, seq[" + j3 + "]");
        bVar.s(j3, cVar.f75024a, false);
    }

    @Override // com.tencent.av.business.manager.EffectConfigBase.b
    public void onDownloadFinish(long j3, PendantItem pendantItem, boolean z16) {
        if (pendantItem != null && pendantItem.getId() != null) {
            for (PendantItem pendantItem2 : this.mPendantManager.q(null)) {
                if (pendantItem.getId().equals(pendantItem2.getId())) {
                    pendantItem2.setUsable(true);
                }
            }
            Iterator<hw.a> it = this.mTabList.iterator();
            while (it.hasNext()) {
                for (QavListItemBase.c cVar : it.next().f406501d) {
                    if (pendantItem.getId().equals(cVar.f75024a)) {
                        cVar.f75027d = true;
                    }
                }
            }
        }
        com.tencent.av.ui.effect.adapter.a aVar = this.mPageAdapter;
        if (aVar == null || pendantItem == null) {
            return;
        }
        aVar.g(j3, pendantItem.getId(), z16);
    }

    @Override // com.tencent.av.business.manager.EffectConfigBase.b
    public void onItemSelectedChanged(long j3, PendantItem pendantItem) {
        m R;
        QLog.w(TAG, 1, "onItemSelectedChanged, current[" + pendantItem + "], seq[" + j3 + "]");
        if (pendantItem == null && (R = r.h0().R(false)) != null) {
            R.a(j3);
        }
        if (pendantItem != null) {
            if (pendantItem.isZplan() && pendantItem.getZplanRenderType() == 1) {
                ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.av.ui.effect.toolbar.newversion.PendantToolbar.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (((BaseToolbar) PendantToolbar.this).mApp != null) {
                            QLog.w(PendantToolbar.TAG, 1, "onItemSelectedChanged, filament tips show");
                            cw.e.n(((BaseToolbar) PendantToolbar.this).mApp, 3022);
                        }
                    }
                });
            } else {
                cw.e.d(this.mApp, 3022);
                ag.e().j();
            }
        }
    }

    @Override // com.tencent.av.business.manager.EffectConfigBase.b
    public void onProgressUpdate(PendantItem pendantItem, int i3) {
        com.tencent.av.ui.effect.adapter.a aVar = this.mPageAdapter;
        if (aVar != null) {
            aVar.h(pendantItem.getId(), i3);
        }
    }

    @Override // android.view.ViewTreeObserver.OnScrollChangedListener
    public void onScrollChanged() {
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i3) {
    }
}
