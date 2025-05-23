package com.tencent.aelight.camera.ae.play;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.RelativeLayout;
import androidx.lifecycle.Observer;
import androidx.viewpager.widget.ViewPager;
import com.tencent.aelight.camera.ae.AEPituCameraUnit;
import com.tencent.aelight.camera.ae.data.AEMaterialManager;
import com.tencent.aelight.camera.ae.download.AEDownloadMaterialRunnable;
import com.tencent.aelight.camera.ae.mode.AECaptureMode;
import com.tencent.aelight.camera.ae.mode.AECaptureModeChangingEvent;
import com.tencent.aelight.camera.ae.n;
import com.tencent.aelight.camera.ae.report.AEBaseReportParam;
import com.tencent.aelight.camera.ae.util.AECameraPrefsUtil;
import com.tencent.aelight.camera.aioeditor.capture.view.QIMSlidingTabView;
import com.tencent.aelight.camera.api.IAECameraUnit;
import com.tencent.aelight.camera.constants.AECameraConstants;
import com.tencent.aelight.camera.struct.camera.material.AEMaterialCategory;
import com.tencent.aelight.camera.struct.camera.material.AEMaterialMetaData;
import com.tencent.image.ApngImage;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.PreloadWebService;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.ttpic.baseutils.collection.CollectionUtils;
import cooperation.peak.PeakConstants;
import java.util.ArrayList;
import java.util.List;
import yq2.c;

/* loaded from: classes32.dex */
public class AEPlayShowPart extends com.tencent.aelight.camera.ae.part.b implements c {
    public static final int ANIMATION_DURATION = 200;
    private static final String TAG = "AEPlayShowPart";
    private com.tencent.aelight.camera.ae.mode.c mCaptureModeViewModel;
    private AEMaterialManager mMidMaterialManager;
    private AEPlayShowMaterialManager mPsMaterialManager;
    private AEPituCameraUnit mUnit;
    private View progressView;
    private AEPlayShowTabView tabView;
    private View tvRetryBtn;
    private ViewGroup vgContainer;
    private ViewGroup vgNoData;
    private ViewPager viewPager;
    private PlayViewPagerAdapter viewPagerAdapter;
    private ViewStub vsNoData;

    public AEPlayShowPart(Activity activity, ViewStub viewStub, com.tencent.aelight.camera.ae.part.c cVar) {
        super(activity, viewStub, cVar);
        this.mUnit = (AEPituCameraUnit) cVar.b(65537, new Object[0]);
        this.mPsMaterialManager = (AEPlayShowMaterialManager) com.tencent.aelight.camera.ae.control.a.c().d(2);
        this.mMidMaterialManager = (AEMaterialManager) com.tencent.aelight.camera.ae.control.a.c().d(1);
        ThreadManager.getFileThreadHandler().postAtFrontOfQueue(new Runnable() { // from class: com.tencent.aelight.camera.ae.play.AEPlayShowPart.1
            @Override // java.lang.Runnable
            public void run() {
                QLog.d(AEPlayShowPart.TAG, 4, "load data");
                AEPlayShowPart.this.mPsMaterialManager.refresh();
            }
        });
        this.mPsMaterialManager.addObserver(this, 1);
        this.mMidMaterialManager.g(this, 116);
        initViewModel();
        preLoadWebView(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cancelProgressDialog() {
        View view = this.progressView;
        if (view != null) {
            view.setVisibility(8);
        }
        ViewGroup viewGroup = this.vgNoData;
        if (viewGroup != null) {
            viewGroup.setVisibility(8);
        }
    }

    private String findTabNameById(String str) {
        List<AEMaterialMetaData> list;
        List<AEMaterialCategory> list2 = this.viewPagerAdapter.getmCategoryList();
        if (list2 != null) {
            for (AEMaterialCategory aEMaterialCategory : list2) {
                if (aEMaterialCategory != null && (list = aEMaterialCategory.f69044d) != null) {
                    for (AEMaterialMetaData aEMaterialMetaData : list) {
                        if (aEMaterialMetaData != null && str != null && str.equals(aEMaterialMetaData.f69050id)) {
                            return aEMaterialCategory.f69046f;
                        }
                    }
                }
            }
            return "";
        }
        return "";
    }

    private String getCurTabName() {
        ArrayList<QIMSlidingTabView.d> dataList = this.tabView.getDataList();
        int curIndex = this.tabView.getCurIndex();
        if (dataList != null && curIndex < dataList.size()) {
            return dataList.get(curIndex).f67316a;
        }
        return "";
    }

    private AEMaterialCategory getCurrentTabMaterial(String str) {
        ensureInflate();
        List<AEMaterialCategory> list = this.viewPagerAdapter.getmCategoryList();
        if (list == null) {
            return null;
        }
        for (AEMaterialCategory aEMaterialCategory : list) {
            if (aEMaterialCategory != null && str != null && str.equals(aEMaterialCategory.f69047h)) {
                return aEMaterialCategory;
            }
        }
        return null;
    }

    private int getPageScrollY() {
        PlayViewPagerAdapter playViewPagerAdapter = this.viewPagerAdapter;
        if (playViewPagerAdapter == null || playViewPagerAdapter.getCurrentPageView() == null) {
            return 0;
        }
        return this.viewPagerAdapter.getCurrentPageView().getScrollY();
    }

    private List<AEMaterialCategory> getPlayShowCategories() {
        if (QLog.isDevelopLevel()) {
            QLog.d(TAG, 4, "getPlayShowCategories");
        }
        return this.mPsMaterialManager.getPsCategoryList();
    }

    private String getPositionFlag(String str) {
        AEPituCameraUnit aEPituCameraUnit = this.mUnit;
        if (aEPituCameraUnit != null && aEPituCameraUnit.z() != null && this.mUnit.z().getIntent() != null) {
            return this.mUnit.z().getIntent().getStringExtra(str);
        }
        return "";
    }

    private synchronized ArrayList<QIMSlidingTabView.d> getTabDataList(List<AEMaterialCategory> list) {
        if (list == null) {
            return null;
        }
        ArrayList<QIMSlidingTabView.d> arrayList = new ArrayList<>();
        for (AEMaterialCategory aEMaterialCategory : list) {
            QIMSlidingTabView.d dVar = new QIMSlidingTabView.d();
            dVar.f67316a = aEMaterialCategory.f69047h;
            arrayList.add(dVar);
        }
        return arrayList;
    }

    private String getTabIdByMaterialId(String str) {
        List<AEMaterialCategory> list;
        List<AEMaterialMetaData> list2;
        PlayViewPagerAdapter playViewPagerAdapter = this.viewPagerAdapter;
        if (playViewPagerAdapter != null && (list = playViewPagerAdapter.getmCategoryList()) != null) {
            for (AEMaterialCategory aEMaterialCategory : list) {
                if (aEMaterialCategory != null && (list2 = aEMaterialCategory.f69044d) != null) {
                    for (AEMaterialMetaData aEMaterialMetaData : list2) {
                        if (aEMaterialMetaData != null && str != null && str.equals(aEMaterialMetaData.f69050id)) {
                            return aEMaterialCategory.f69047h;
                        }
                    }
                }
            }
            return "";
        }
        return "";
    }

    private void initNoDataView(List<AEMaterialCategory> list, List<QIMSlidingTabView.d> list2) {
        if (!CollectionUtils.isEmpty(list) && !CollectionUtils.isEmpty(list2)) {
            ViewGroup viewGroup = this.vgNoData;
            if (viewGroup == null || viewGroup.getVisibility() != 0) {
                return;
            }
            this.vgNoData.setVisibility(8);
            return;
        }
        if (this.vgNoData == null) {
            ViewGroup viewGroup2 = (ViewGroup) this.vsNoData.inflate();
            this.vgNoData = viewGroup2;
            View findViewById = viewGroup2.findViewById(R.id.f163806s35);
            this.tvRetryBtn = findViewById;
            findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.aelight.camera.ae.play.AEPlayShowPart.9
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    EventCollector.getInstance().onViewClickedBefore(view);
                    AEPlayShowPart.this.showProgressDialog();
                    AEPlayShowPart.this.vgNoData.setVisibility(8);
                    AECameraPrefsUtil.f().p("ShadowBackendSvc.GetPlayShowCatMatTree", "", 4);
                    ThreadManager.getSubThreadHandler().post(new AEDownloadMaterialRunnable());
                    EventCollector.getInstance().onViewClicked(view);
                }
            });
        }
        this.vgNoData.setVisibility(0);
    }

    private void initViewModel() {
        com.tencent.aelight.camera.ae.mode.c cVar = (com.tencent.aelight.camera.ae.mode.c) n.a(this.mUnit).get(com.tencent.aelight.camera.ae.mode.c.class);
        this.mCaptureModeViewModel = cVar;
        cVar.f65622i.observe(this.mUnit, new Observer<AECaptureModeChangingEvent>() { // from class: com.tencent.aelight.camera.ae.play.AEPlayShowPart.7
            @Override // androidx.lifecycle.Observer
            public void onChanged(AECaptureModeChangingEvent aECaptureModeChangingEvent) {
                if (aECaptureModeChangingEvent == null) {
                    return;
                }
                AECaptureMode aECaptureMode = aECaptureModeChangingEvent.f65599b;
                if (aECaptureMode == AECaptureMode.NORMAL) {
                    AEMaterialMetaData aEMaterialMetaData = AEPlayShowGridAdapter.selectedMaterial;
                    if (aEMaterialMetaData == null || aEMaterialMetaData != AEMaterialManager.H()) {
                        AEBaseReportParam.U().S0("none");
                    }
                    if (AEPlayShowPart.this.hasInflated()) {
                        AEPlayShowPart.this.vgContainer.setVisibility(8);
                        return;
                    }
                    return;
                }
                if (aECaptureMode == AECaptureMode.GIF) {
                    if (AEPlayShowPart.this.hasInflated()) {
                        AEPlayShowPart.this.vgContainer.setVisibility(8);
                    }
                } else if (aECaptureMode == AECaptureMode.PLAY) {
                    AEPlayShowPart.this.ensureInflate();
                    if (AEPlayShowPart.this.viewPagerAdapter != null) {
                        String lastMaterialTabId = AEPlayShowPart.this.viewPagerAdapter.getLastMaterialTabId();
                        if (!TextUtils.isEmpty(lastMaterialTabId) && !"-1".equals(lastMaterialTabId)) {
                            AEBaseReportParam.U().S0(lastMaterialTabId);
                        }
                    }
                    AEPlayShowPart.this.vgContainer.setVisibility(0);
                    AEPlayShowPart.this.showGirdAnimation();
                }
            }
        });
        com.tencent.aelight.camera.ae.config.b.d().observe(this.mUnit, new Observer<Boolean>() { // from class: com.tencent.aelight.camera.ae.play.AEPlayShowPart.8
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                if (bool.booleanValue()) {
                    AEPlayShowPart.this.mPsMaterialManager.refresh();
                }
            }
        });
    }

    private void preLoadWebView(String str) {
        if (QLog.isDevelopLevel()) {
            QLog.d(TAG, 4, "preLoadWebView, url=" + str);
        }
        Intent intent = new Intent(this.mActivity, (Class<?>) PreloadWebService.class);
        if (!TextUtils.isEmpty(str)) {
            intent.putExtra("url", str);
        }
        try {
            this.mActivity.startService(intent);
        } catch (Throwable th5) {
            if (QLog.isColorLevel()) {
                QLog.e(TAG, 2, "preLoadWebView, error=", th5);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refreshViews() {
        List<AEMaterialCategory> playShowCategories = getPlayShowCategories();
        preLoadWebView(null);
        ArrayList<QIMSlidingTabView.d> tabDataList = getTabDataList(playShowCategories);
        if (tabDataList != null && tabDataList.size() > 0) {
            QLog.d(TAG, 2, "tabDataList size: " + tabDataList.size());
            ViewGroup viewGroup = this.vgNoData;
            if (viewGroup != null) {
                viewGroup.setVisibility(8);
            }
            this.tabView.setVisibility(tabDataList.size() > 1 ? 0 : 4);
            this.viewPager.setVisibility(0);
            String curTabName = getCurTabName();
            int pageScrollY = getPageScrollY();
            this.tabView.initTabItemsWithRedDot(tabDataList);
            this.viewPagerAdapter.setCategoryList(playShowCategories);
            this.viewPagerAdapter.notifyDataSetChanged();
            String positionFlag = getPositionFlag(IAECameraUnit.KEY_CURRENT_SELECT_ID);
            String positionFlag2 = getPositionFlag(IAECameraUnit.KEY_CURRENT_TYPE);
            String positionFlag3 = getPositionFlag(IAECameraUnit.KEY_CURRENT_TAB);
            String tabIdByMaterialId = getTabIdByMaterialId(positionFlag);
            AEMaterialCategory currentTabMaterial = getCurrentTabMaterial(tabIdByMaterialId);
            StringBuilder sb5 = new StringBuilder();
            sb5.append("chooseId: ");
            sb5.append(positionFlag);
            sb5.append(" typeId: ");
            sb5.append(positionFlag2);
            sb5.append(" posTabName: ");
            sb5.append(tabIdByMaterialId);
            sb5.append(" isMaterial null: ");
            sb5.append(currentTabMaterial == null);
            ms.a.a(TAG, sb5.toString());
            if (currentTabMaterial != null && AECaptureMode.PLAY.name.equals(positionFlag3)) {
                send(655364, tabIdByMaterialId, positionFlag);
                return;
            } else {
                scrollToSpecPos(curTabName, pageScrollY);
                return;
            }
        }
        QLog.d(TAG, 2, "no data.");
        this.tabView.setVisibility(8);
        this.viewPager.setVisibility(8);
        initNoDataView(playShowCategories, tabDataList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scrollToSpecItemWithClick(String str, String str2) {
        List<AEMaterialMetaData> list;
        AEMaterialCategory currentTabMaterial = getCurrentTabMaterial(str);
        if (currentTabMaterial == null || (list = currentTabMaterial.f69044d) == null) {
            return;
        }
        for (int i3 = 0; i3 < list.size(); i3++) {
            AEMaterialMetaData aEMaterialMetaData = list.get(i3);
            if (aEMaterialMetaData != null && str2 != null && str2.equals(aEMaterialMetaData.f69050id)) {
                AEPlayShowPageView currentPageView = this.viewPagerAdapter.getCurrentPageView();
                if (currentPageView != null) {
                    currentPageView.scrollToPosWithClick(i3);
                    return;
                }
                return;
            }
        }
    }

    private void scrollToSpecPos(final String str, final int i3) {
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.aelight.camera.ae.play.AEPlayShowPart.6
            @Override // java.lang.Runnable
            public void run() {
                String str2;
                if ("".equals(str)) {
                    AEPlayShowPart.this.switchToTab(0);
                    return;
                }
                List<AEMaterialCategory> list = AEPlayShowPart.this.viewPagerAdapter.getmCategoryList();
                if (list != null) {
                    for (int i16 = 0; i16 < list.size(); i16++) {
                        AEMaterialCategory aEMaterialCategory = list.get(i16);
                        if (aEMaterialCategory != null && (str2 = str) != null && str2.equals(aEMaterialCategory.f69047h)) {
                            AEPlayShowPart.this.switchToTab(i16);
                            if (AEPlayShowPart.this.viewPagerAdapter.getCurrentPageView() != null) {
                                AEPlayShowPart.this.viewPagerAdapter.getCurrentPageView().scrollTo(i3);
                            }
                        }
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showGirdAnimation() {
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(ObjectAnimator.ofFloat(this.vgContainer, com.tencent.luggage.wxa.c8.c.f123400v, 0.0f, 1.0f));
        animatorSet.setDuration(200L).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showProgressDialog() {
        if (this.progressView == null) {
            View inflate = LayoutInflater.from(this.mActivity).inflate(R.layout.f168383uh, this.vgContainer, false);
            this.progressView = inflate;
            this.vgContainer.addView(inflate);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.progressView.getLayoutParams();
            layoutParams.addRule(13);
            this.progressView.setLayoutParams(layoutParams);
        }
        this.progressView.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void switchToTab(int i3) {
        this.tabView.onTabChecked(i3);
    }

    @Override // com.tencent.aelight.camera.ae.part.b
    protected void initAfterInflation(View view) {
        ViewGroup viewGroup = (ViewGroup) view;
        this.vgContainer = viewGroup;
        this.tabView = (AEPlayShowTabView) viewGroup.findViewById(R.id.ryf);
        this.viewPager = (ViewPager) this.vgContainer.findViewById(R.id.s4v);
        this.vsNoData = (ViewStub) this.vgContainer.findViewById(R.id.f163813s50);
        this.tabView.setIndicateColor(0);
        this.tabView.setTabCheckListener(new QIMSlidingTabView.c() { // from class: com.tencent.aelight.camera.ae.play.AEPlayShowPart.2
            @Override // com.tencent.aelight.camera.aioeditor.capture.view.QIMSlidingTabView.c
            public void onTabChecked(int i3) {
                AEPlayShowPart.this.viewPager.setCurrentItem(i3);
            }
        });
        PlayViewPagerAdapter playViewPagerAdapter = new PlayViewPagerAdapter(this.mActivity, this.mPartManager, getPlayShowCategories());
        this.viewPagerAdapter = playViewPagerAdapter;
        this.viewPager.setAdapter(playViewPagerAdapter);
        this.viewPager.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() { // from class: com.tencent.aelight.camera.ae.play.AEPlayShowPart.3
            @Override // androidx.viewpager.widget.ViewPager.SimpleOnPageChangeListener, androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int i3) {
                AEPlayShowPart.this.tabView.onTabChecked(i3);
            }

            @Override // androidx.viewpager.widget.ViewPager.SimpleOnPageChangeListener, androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i3) {
                if (i3 == 0) {
                    ApngImage.resumeAll();
                } else {
                    ApngImage.pauseAll();
                }
            }
        });
        refreshViews();
    }

    @Override // com.tencent.aelight.camera.ae.part.b
    public void onDestroy() {
        super.onDestroy();
        AEPlayShowGridAdapter.selectedMaterial = null;
        AEPlayShowGridAdapter.onSelectedMidMaterialConsumed();
        AEMaterialManager aEMaterialManager = this.mMidMaterialManager;
        if (aEMaterialManager != null) {
            aEMaterialManager.n0(this);
        }
        AEPlayShowMaterialManager aEPlayShowMaterialManager = this.mPsMaterialManager;
        if (aEPlayShowMaterialManager != null) {
            aEPlayShowMaterialManager.removeObserver(this);
            this.mPsMaterialManager.clearCategoryList();
        }
    }

    @Override // yq2.c
    public void notify(Object obj, int i3, Object... objArr) {
        if (i3 == 1) {
            ms.a.f(TAG, "notify, eventId=AEPlayShowMaterialManager.EVENT_MATERIAL_LIST_UPDATED");
            if (hasInflated()) {
                ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.aelight.camera.ae.play.AEPlayShowPart.5
                    @Override // java.lang.Runnable
                    public void run() {
                        AEPlayShowPart.this.cancelProgressDialog();
                        AEPlayShowPart.this.refreshViews();
                    }
                });
                return;
            }
            return;
        }
        if (i3 == 116) {
            ms.a.f(TAG, "notify, eventId=AEMaterialManager.TEMPLATE_INFO_LIST_UPDATE");
            this.mPsMaterialManager.refresh();
        }
    }

    @Override // com.tencent.aelight.camera.ae.part.b
    public void send(int i3, Object... objArr) {
        ArrayList<QIMSlidingTabView.d> dataList;
        if (i3 == 655361) {
            if (objArr == null || objArr.length != 1) {
                return;
            }
            Object obj = objArr[0];
            if (obj instanceof AEMaterialMetaData) {
                AEMaterialMetaData aEMaterialMetaData = (AEMaterialMetaData) obj;
                if (aEMaterialMetaData.equals(AEPlayShowGridAdapter.selectedMaterial)) {
                    String localPath = aEMaterialMetaData.getLocalPath();
                    String findTabNameById = findTabNameById(aEMaterialMetaData.f69050id);
                    AEBaseReportParam.U().i1(aEMaterialMetaData.f69050id);
                    AETemplateInfoFragment.jumpToMe(this.mActivity, findTabNameById, localPath, aEMaterialMetaData.f69050id, aEMaterialMetaData.name, aEMaterialMetaData.takeSameName);
                    return;
                }
                return;
            }
            return;
        }
        if (i3 == 655362) {
            if (objArr == null || objArr.length != 1) {
                return;
            }
            Object obj2 = objArr[0];
            if (obj2 instanceof AEMaterialMetaData) {
                AEMaterialMetaData aEMaterialMetaData2 = (AEMaterialMetaData) obj2;
                if (aEMaterialMetaData2.equals(AEPlayShowGridAdapter.selectedMaterial)) {
                    AEBaseReportParam.U().i1(aEMaterialMetaData2.f69050id);
                    String findTabNameById2 = findTabNameById(aEMaterialMetaData2.f69050id);
                    Intent intent = new Intent(this.mActivity, (Class<?>) QQBrowserActivity.class);
                    intent.addFlags(536870912);
                    intent.addFlags(67108864);
                    intent.putExtra("url", aEMaterialMetaData2.webUrl);
                    intent.putExtra(AECameraConstants.LOC_PLAY_SHOW_TAB_NAME, findTabNameById2);
                    intent.putExtra(AECameraConstants.LOC_PLAY_SHOW_MATERIAL_ID, aEMaterialMetaData2.f69050id);
                    intent.putExtra(PeakConstants.KEY_QQ_CAMERA_MATERIAL_NAME, aEMaterialMetaData2.takeSameName);
                    intent.putExtra(AECameraConstants.VIDEO_STORY_FROM_TYPE, AETemplateInfoFragment.getFromType(this.mActivity));
                    if (this.mActivity.getIntent().hasExtra(AECameraConstants.ORIGIN_VIDEO_STORY_FROM_TYPE)) {
                        intent.putExtra(AECameraConstants.ORIGIN_VIDEO_STORY_FROM_TYPE, this.mActivity.getIntent().getIntExtra(AECameraConstants.ORIGIN_VIDEO_STORY_FROM_TYPE, js.a.f410904d.b()));
                    } else {
                        intent.putExtra(AECameraConstants.ORIGIN_VIDEO_STORY_FROM_TYPE, this.mActivity.getIntent().getIntExtra(AECameraConstants.VIDEO_STORY_FROM_TYPE, js.a.f410904d.b()));
                    }
                    this.mActivity.startActivityForResult(intent, 1025);
                    return;
                }
                return;
            }
            return;
        }
        if (i3 == 655363) {
            if (objArr == null || objArr.length != 1) {
                return;
            }
            Object obj3 = objArr[0];
            if (obj3 instanceof AEMaterialMetaData) {
                AEMaterialMetaData aEMaterialMetaData3 = (AEMaterialMetaData) obj3;
                if (aEMaterialMetaData3.equals(AEPlayShowGridAdapter.selectedMaterial)) {
                    AEBaseReportParam.U().i1(aEMaterialMetaData3.f69050id);
                    ((IMiniAppService) QRoute.api(IMiniAppService.class)).startAppByAppid(this.mActivity, aEMaterialMetaData3.miniAppId, null, null, 2083, null);
                    return;
                }
                return;
            }
            return;
        }
        if (i3 == 655364) {
            if (objArr != null && objArr.length == 2 && (objArr[0] instanceof String) && (objArr[1] instanceof String)) {
                ensureInflate();
                final String str = (String) objArr[0];
                final String str2 = (String) objArr[1];
                AEPlayShowTabView aEPlayShowTabView = this.tabView;
                if (aEPlayShowTabView == null || (dataList = aEPlayShowTabView.getDataList()) == null) {
                    return;
                }
                for (int i16 = 0; i16 < dataList.size(); i16++) {
                    QIMSlidingTabView.d dVar = dataList.get(i16);
                    if (dVar != null && str.equals(dVar.f67316a)) {
                        switchToTab(i16);
                        this.viewPager.post(new Runnable() { // from class: com.tencent.aelight.camera.ae.play.AEPlayShowPart.4
                            @Override // java.lang.Runnable
                            public void run() {
                                AEPlayShowPart.this.scrollToSpecItemWithClick(str, str2);
                            }
                        });
                        return;
                    }
                }
                return;
            }
            return;
        }
        if (i3 == 655365 && objArr != null && objArr.length == 1) {
            Object obj4 = objArr[0];
            if (obj4 instanceof String) {
                String str3 = (String) obj4;
                ms.a.f(TAG, "click cameraAD, materialId=" + str3);
                if (TextUtils.isEmpty(str3)) {
                    return;
                }
                String tabIdByMaterialId = getTabIdByMaterialId(str3);
                AEMaterialCategory currentTabMaterial = getCurrentTabMaterial(tabIdByMaterialId);
                StringBuilder sb5 = new StringBuilder();
                sb5.append("chooseId: ");
                sb5.append(str3);
                sb5.append(" posTabName: ");
                sb5.append(tabIdByMaterialId);
                sb5.append(" isMaterial null: ");
                sb5.append(currentTabMaterial == null);
                ms.a.a(TAG, sb5.toString());
                if (currentTabMaterial != null) {
                    send(655364, tabIdByMaterialId, str3);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.aelight.camera.ae.part.b
    public void initView() {
    }
}
