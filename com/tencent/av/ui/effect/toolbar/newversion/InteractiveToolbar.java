package com.tencent.av.ui.effect.toolbar.newversion;

import android.text.TextUtils;
import android.view.ViewTreeObserver;
import androidx.viewpager.widget.ViewPager;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.business.manager.EffectConfigBase;
import com.tencent.av.business.manager.magicface.FaceItem;
import com.tencent.av.business.manager.magicface.MagicDataReport;
import com.tencent.av.n;
import com.tencent.av.opengl.effects.j;
import com.tencent.av.r;
import com.tencent.av.ui.AVActivity;
import com.tencent.av.ui.ControlUIObserver;
import com.tencent.av.ui.QavListItemBase;
import com.tencent.av.ui.effect.toolbar.BaseToolbar;
import com.tencent.av.ui.effect.view.EffectViewPager;
import com.tencent.av.ui.effect.view.QavEffectSlidingTabView;
import com.tencent.av.utils.AVUtil;
import com.tencent.av.utils.e;
import com.tencent.avcore.util.AVCoreLog;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.vas.IndividuationUrlHelper;
import com.tencent.qphone.base.util.QLog;
import iw.b;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes3.dex */
public class InteractiveToolbar extends BaseToolbarNewVersion implements b, QavEffectSlidingTabView.c, ViewTreeObserver.OnScrollChangedListener, ViewPager.OnPageChangeListener, EffectConfigBase.b<FaceItem> {
    public static final String DOUBLE_PENDANT_CATEGORY = "900003";
    public static final int TAB_DOUBLE_PENDANT_INDEX = 0;
    public static final int TAB_MAGIC_STICKER_INDEX = 1;
    public static final int TAB_MULTI_SCREEN_INTERACT_INDEX = 2;
    public static final String TAG = "InteractiveToolbar";
    static String unableInfo;
    private String mCurrentSelectCategory;
    com.tencent.av.business.manager.magicface.a mFaceManager;
    iw.a mInteractiveClickCallback;
    QavListItemBase.c mLastClickItemInfo;
    hu.a mMaterialManager;
    private com.tencent.av.ui.effect.adapter.a mPageAdapter;
    com.tencent.av.business.manager.support.a mSupportManager;
    private List<hw.a> mTabList;
    private QavEffectSlidingTabView mTopTabBar;
    private BaseToolbar.a mUIInfo;
    private EffectViewPager mViewPager;

    /* compiled from: P */
    /* loaded from: classes3.dex */
    class a implements iw.a {
        a() {
        }

        @Override // iw.a
        public void b(long j3, QavListItemBase.c cVar) {
            boolean z16 = true;
            if (e.k()) {
                QLog.w(InteractiveToolbar.TAG, 1, "onEffectClick, seq[" + j3 + "], id[" + cVar.f75024a + "]");
            }
            BaseToolbar.keepInToolbar(((BaseToolbar) InteractiveToolbar.this).mApp, j3);
            String str = r.h0().J(n.e().f().f73091w) + "";
            if (cVar.f75024a.equals("0")) {
                InteractiveToolbar.this.notifyEvent(6101, null, Boolean.TRUE);
                MagicDataReport.m(2, str);
                MagicDataReport.l(2);
                if (((BaseToolbar) InteractiveToolbar.this).mApp.Y(13)) {
                    ((gu.a) ((BaseToolbar) InteractiveToolbar.this).mApp.B(13)).b0(j3, "onEffectClick2");
                    return;
                }
                return;
            }
            e.r(cVar.f75024a, false);
            if (cVar.f75029f == 1 && !ControlUIObserver.d.f74777j && ControlUIObserver.d.f74778k == 4 && TextUtils.equals(ControlUIObserver.d.f74776i, cVar.f75024a) && InteractiveToolbar.this.mLastClickItemInfo != cVar) {
                z16 = false;
            }
            if (QLog.isColorLevel()) {
                QLog.i(InteractiveToolbar.TAG, 2, "onEffectClick_Check, type[" + cVar.f75029f + "], sLastSenderFlag[" + ControlUIObserver.d.f74777j + "], sLastItemId[" + ControlUIObserver.d.f74776i + "], sLastFrom[" + ControlUIObserver.d.f74778k + "], id[" + cVar.f75024a + "], isSender[" + z16 + "], click[" + InteractiveToolbar.this.mLastClickItemInfo + "], info[" + cVar + "]");
            }
            new ControlUIObserver.d(j3, cVar.f75024a, z16, 1).b(((BaseToolbar) InteractiveToolbar.this).mApp);
            MagicDataReport.k(cVar.f75024a, 2, str);
            MagicDataReport.j(cVar.f75024a, 2);
        }

        @Override // iw.a
        public void c(long j3) {
            BaseToolbar.keepInToolbar(((BaseToolbar) InteractiveToolbar.this).mApp, j3);
        }

        @Override // iw.a
        public void d(QavListItemBase.c cVar) {
            InteractiveToolbar interactiveToolbar = InteractiveToolbar.this;
            interactiveToolbar.mLastClickItemInfo = cVar;
            if (cVar != null) {
                interactiveToolbar.mMaterialManager.H(cVar.f75024a);
            }
            if (cVar != null && !cVar.f75024a.equals("0")) {
                MagicDataReport.c(2, cVar.f75024a);
            }
        }
    }

    public InteractiveToolbar(VideoAppInterface videoAppInterface, AVActivity aVActivity) {
        super(videoAppInterface, aVActivity);
        this.mCurrentSelectCategory = DOUBLE_PENDANT_CATEGORY;
        this.mTabList = new ArrayList();
        this.mLastClickItemInfo = null;
        this.mInteractiveClickCallback = new a();
    }

    private ArrayList<hw.a> constructCategory() {
        boolean D = j.D();
        ArrayList<hw.a> arrayList = new ArrayList<>();
        if (D) {
            hw.a aVar = new hw.a();
            aVar.f406499b = "\u53cc\u4eba\u6302\u4ef6";
            aVar.f406498a = DOUBLE_PENDANT_CATEGORY;
            aVar.f406501d = new ArrayList(getList(IndividuationUrlHelper.UrlId.PENDANT_HOME));
            arrayList.add(aVar);
        }
        return arrayList;
    }

    private int getFromType(String str) {
        if (DOUBLE_PENDANT_CATEGORY.equals(str)) {
            return 1001;
        }
        return -1;
    }

    private ArrayList<QavListItemBase.c> getList(String str) {
        boolean z16;
        ArrayList<QavListItemBase.c> arrayList = new ArrayList<>();
        boolean i3 = uv.b.f().i();
        boolean n3 = this.mSupportManager.n(3, "normal");
        boolean n16 = this.mSupportManager.n(3, "interact");
        QLog.w(TAG, 1, "getList, type[" + str + "], supportNormal[" + n3 + "], supportInteract[" + n16 + "], supportCreative[false], isSOExist[" + i3 + "]");
        if (IndividuationUrlHelper.UrlId.PENDANT_HOME.equals(str)) {
            QavListItemBase.c cVar = new QavListItemBase.c();
            cVar.f75024a = "0";
            cVar.f75025b = String.valueOf(R.drawable.n7e);
            cVar.f75031h = !n16;
            cVar.f75034k = this.mApp.getApp().getString(R.string.iwb);
            arrayList.add(cVar);
        }
        List<FaceItem> q16 = this.mFaceManager.q(str);
        if (q16 != null && q16.size() != 0) {
            for (FaceItem faceItem : q16) {
                if (faceItem.isShow()) {
                    if (n16 && i3) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    arrayList.add(getListItemInfoFromEmotionInfo(faceItem, n3, z16));
                }
            }
        }
        return arrayList;
    }

    static QavListItemBase.c getListItemInfoFromEmotionInfo(FaceItem faceItem, boolean z16, boolean z17) {
        boolean z18;
        QavListItemBase.c cVar = new QavListItemBase.c();
        cVar.f75029f = 1;
        cVar.f75024a = faceItem.getId();
        cVar.f75026c = faceItem.getText();
        cVar.f75025b = faceItem.getIconUrl();
        cVar.f75030g = faceItem.getVipLevel();
        cVar.f75034k = faceItem.getDesc();
        if (z16 && (z17 || !faceItem.isInteract())) {
            z18 = false;
        } else {
            z18 = true;
        }
        cVar.f75031h = z18;
        if (z18) {
            cVar.f75027d = true;
        } else {
            cVar.f75027d = faceItem.isUsable();
        }
        cVar.f75035l = faceItem;
        return cVar;
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

    public static boolean isEnable() {
        if (r.h0() != null && !n.e().f().O) {
            unableInfo = VideoAppInterface.N().getApp().getApplicationContext().getString(R.string.d_z);
            return false;
        }
        return true;
    }

    private void setLastItem() {
        String id5;
        FaceItem u16 = ((com.tencent.av.business.manager.magicface.a) this.mApp.B(3)).u();
        if (u16 == null) {
            id5 = "0";
        } else {
            id5 = u16.getId();
        }
        this.mMaterialManager.H(id5);
        this.mMaterialManager.z();
    }

    void enterDoubleScreen() {
        MagicDataReport.a(r.h0().J(n.e().f().f73091w) + "");
        r.h0().s2(4, "1");
        this.mActivity.get().e4();
    }

    void enterOriginScreen() {
        this.mActivity.get().J3(false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.av.ui.effect.toolbar.BaseToolbar
    public BaseToolbar.a getUIInfo() {
        if (this.mUIInfo == null) {
            BaseToolbar.a aVar = new BaseToolbar.a();
            this.mUIInfo = aVar;
            aVar.f75560d = 2;
            aVar.f75564h = R.layout.f168482fu0;
            aVar.f75562f = R.drawable.d_r;
            aVar.f75563g = this.mApp.getApp().getString(R.string.dl6);
        }
        return this.mUIInfo;
    }

    @Override // com.tencent.av.ui.effect.toolbar.BaseToolbar
    public String getUnableInfo() {
        if (unableInfo == null) {
            isEnable();
        }
        if (unableInfo == null) {
            unableInfo = VideoAppInterface.N().getApp().getApplicationContext().getString(R.string.f1779635d);
        }
        return unableInfo;
    }

    @Override // com.tencent.av.ui.effect.toolbar.BaseToolbar
    public boolean isEffectBtnNormal() {
        if (is64bitAndSDKVersionUnderM()) {
            return false;
        }
        return isEnable();
    }

    protected void notifyEvent(Integer num, Object obj, Object obj2) {
        AVCoreLog.printColorLog(TAG, "notifyEvent :" + num + "|" + obj + "|" + obj2);
        this.mApp.k0(new Object[]{num, obj, obj2});
    }

    @Override // com.tencent.av.ui.effect.toolbar.BaseToolbar
    protected void onCreate(long j3, AVActivity aVActivity) {
        QLog.w(TAG, 1, "TAG, onCreate, seq[" + j3 + "]");
        this.mFaceManager = (com.tencent.av.business.manager.magicface.a) this.mApp.B(3);
        this.mSupportManager = (com.tencent.av.business.manager.support.a) this.mApp.B(5);
        this.mMaterialManager = (hu.a) this.mApp.B(15);
        QavEffectSlidingTabView qavEffectSlidingTabView = (QavEffectSlidingTabView) this.toolbarView.findViewById(R.id.e1y);
        this.mTopTabBar = qavEffectSlidingTabView;
        qavEffectSlidingTabView.setTabCheckListener(this);
        this.mTopTabBar.getViewTreeObserver().addOnScrollChangedListener(this);
        this.mTopTabBar.setVisibility(8);
        this.mViewPager = (EffectViewPager) this.toolbarView.findViewById(R.id.kwk);
        com.tencent.av.ui.effect.adapter.a aVar = new com.tencent.av.ui.effect.adapter.a(getAVActivity(), this.mApp, 2);
        this.mPageAdapter = aVar;
        aVar.k(this);
        this.mPageAdapter.j(this.mInteractiveClickCallback);
        this.mPageAdapter.setCategoryList(new ArrayList());
        this.mViewPager.setOnPageChangeListener(this);
        this.mViewPager.setAdapter(this.mPageAdapter);
        this.mMaterialManager.H(null);
        updateData();
        FaceItem u16 = this.mFaceManager.u();
        if (u16 != null) {
            if (u16.isSameType(IndividuationUrlHelper.UrlId.PENDANT_HOME)) {
                this.mViewPager.setCurrentItem(0);
                return;
            } else {
                this.mViewPager.setCurrentItem(1);
                return;
            }
        }
        this.mViewPager.setCurrentItem(1);
    }

    @Override // com.tencent.av.ui.effect.toolbar.BaseToolbar
    protected void onDestroy(long j3, VideoAppInterface videoAppInterface) {
        this.mFaceManager.J(j3, this);
        this.mMaterialManager.H(null);
        com.tencent.av.ui.effect.adapter.a aVar = this.mPageAdapter;
        if (aVar != null) {
            aVar.onDestroy();
        }
    }

    @Override // com.tencent.av.ui.effect.toolbar.BaseToolbar
    protected void onHide(long j3) {
        this.mFaceManager.J(j3, this);
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageSelected(int i3) {
        this.mTopTabBar.f(i3);
        this.mCurrentSelectCategory = this.mTabList.get(i3).f406498a;
        hw.a aVar = this.mTabList.get(i3);
        if (DOUBLE_PENDANT_CATEGORY.equals(aVar.f406498a)) {
            enterDoubleScreen();
        } else {
            enterOriginScreen();
        }
        int fromType = getFromType(aVar.f406498a);
        if (fromType != -1) {
            ReportController.o(null, "dc00898", "", "", "0X800BC12", "0X800BC12", fromType, 0, "", "", "", "");
        }
    }

    @Override // com.tencent.av.ui.effect.toolbar.BaseToolbar
    protected void onShow(long j3, int i3, boolean z16) {
        this.mFaceManager.p(j3, this);
        if (!this.mActivity.get().s3() && this.mCurrentSelectCategory.equals(DOUBLE_PENDANT_CATEGORY)) {
            enterDoubleScreen();
        }
        setLastItem();
        AVUtil.c(103);
    }

    @Override // com.tencent.av.ui.effect.view.QavEffectSlidingTabView.c
    public void onTabChecked(int i3) {
        this.mViewPager.setCurrentItem(i3);
    }

    @Override // iw.b
    public void startDownloadTemplate(AppInterface appInterface, long j3, QavListItemBase.c cVar, QavListItemBase.b bVar) {
        FaceItem w3 = this.mFaceManager.w(cVar.f75024a);
        if (w3 != null) {
            this.mFaceManager.N(j3, w3);
            return;
        }
        QLog.w(TAG, 1, "startDownloadTemplate, item\u4e3a\u7a7a, seq[" + j3 + "]");
        bVar.s(j3, cVar.f75024a, false);
    }

    public void updateData() {
        ArrayList arrayList = new ArrayList(constructCategory());
        this.mTabList = arrayList;
        com.tencent.av.ui.effect.adapter.a aVar = this.mPageAdapter;
        if (aVar != null) {
            aVar.setCategoryList(arrayList);
            this.mPageAdapter.notifyDataSetChanged();
        }
        EffectViewPager effectViewPager = this.mViewPager;
        if (effectViewPager != null) {
            effectViewPager.setAdapter(this.mPageAdapter);
        }
        QavEffectSlidingTabView qavEffectSlidingTabView = this.mTopTabBar;
        if (qavEffectSlidingTabView != null) {
            qavEffectSlidingTabView.d(getTabNameList());
            this.mTopTabBar.setTabCheckListener(this);
        }
    }

    @Override // com.tencent.av.business.manager.EffectConfigBase.b
    public void onDownloadFinish(long j3, FaceItem faceItem, boolean z16) {
        com.tencent.av.ui.effect.adapter.a aVar = this.mPageAdapter;
        if (aVar != null) {
            aVar.g(j3, faceItem.getId(), z16);
        }
    }

    @Override // com.tencent.av.business.manager.EffectConfigBase.b
    public void onItemSelectedChanged(long j3, FaceItem faceItem) {
        setLastItem();
    }

    @Override // com.tencent.av.business.manager.EffectConfigBase.b
    public void onProgressUpdate(FaceItem faceItem, int i3) {
        com.tencent.av.ui.effect.adapter.a aVar = this.mPageAdapter;
        if (aVar != null) {
            aVar.h(faceItem.getId(), i3);
        }
    }

    @Override // android.view.ViewTreeObserver.OnScrollChangedListener
    public void onScrollChanged() {
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i3) {
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i3, float f16, int i16) {
    }
}
