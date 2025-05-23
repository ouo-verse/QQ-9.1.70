package com.tencent.mobileqq.gamecenter.metadream.fragment;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Looper;
import android.util.Size;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelStoreOwner;
import com.airbnb.lottie.LottieAnimationView;
import com.google.android.material.tabs.TabLayout;
import com.tencent.biz.richframework.compat.f;
import com.tencent.biz.richframework.part.Part;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.kuikly.core.render.android.context.KuiklyRenderCoreExecuteMode;
import com.tencent.kuikly.core.render.android.exception.ErrorReason;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.activity.recent.gamemsgbox.NTChatRecyclerViewWithHeaderFooter;
import com.tencent.mobileqq.activity.recent.gamemsgbox.af;
import com.tencent.mobileqq.activity.recent.gamemsgbox.api.IGameMsgBoxManager;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.fragment.QIphoneTitleBarFragment;
import com.tencent.mobileqq.gamecenter.api.IGameMsgHelperApi;
import com.tencent.mobileqq.gamecenter.api.IGameMsgManagerService;
import com.tencent.mobileqq.gamecenter.qa.api.IMetaDreamAttaReportApi;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.api.IQQKuiklyFactory;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.api.KuiklyLaunchParams;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.api.g;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.api.h;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.util.x;
import com.tencent.mobileqq.utils.ah;
import com.tencent.mobileqq.vas.comm.api.IGameCenterUnitedConfigApi;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import mqq.app.MobileQQ;
import org.json.JSONObject;
import ud1.MetaDreamInteractMsgTabConfig;

/* compiled from: P */
/* loaded from: classes33.dex */
public class GameMetaDreamMsgCenterFragment extends QIphoneTitleBarFragment implements TabLayout.d, h {
    public static final String EXTRA_META_DREAM_MSG_TAB_INDEX = "extra_meta_dream_msg_tab_index";
    private static final String LOADING_LOTTIE_ANIM = "metadream/lottie/metadream_loading.json";
    public static final int TAB_INDEX_GAME_MSG = 0;
    public static final int TAB_INDEX_INTERACT_MSG = 1;
    private static final String TAG = "GameMetaDreamMsgCenterFragment";
    private QBaseActivity mActivity;
    private int mCurrentTabIndex;
    private af mGameMsgBoxNtPart;
    private int mInitTabIndex;
    private FrameLayout mInteractMsgContainer;
    private g mInteractMsgKuiklyView;
    private boolean mIsInteractMsgViewInit;
    private boolean mIsShowInteractMsgTab;
    private LottieAnimationView mLoadingAnimView;
    private RelativeLayout mLoadingContainer;
    private DragFrameLayout mMsgListContainer;
    private NTChatRecyclerViewWithHeaderFooter mMsgListView;
    private TabLayout mTopTab;
    private RelativeLayout mTopTabContainer;
    private ie1.b mGameCenterObserver = new a(hashCode());
    private k71.a gameContactFetchListener = new b();

    /* compiled from: P */
    /* loaded from: classes33.dex */
    class a extends ie1.b {
        a(int i3) {
            super(i3);
        }

        @Override // ie1.b
        public void d(Object obj) {
            super.d(obj);
            QLog.d("GameCenterMsg.GameCenterUnissoObserver", 1, " onGameUsrInfoChangedNotify");
            GameMetaDreamMsgCenterFragment.this.refreshGameMsgList();
        }

        @Override // ie1.b
        public void t() {
            QLog.d("GameCenterMsg.GameCenterUnissoObserver", 1, " onSetSwitchCallback");
            GameMetaDreamMsgCenterFragment.this.refreshGameMsgList();
        }
    }

    /* compiled from: P */
    /* loaded from: classes33.dex */
    class b implements k71.a {
        b() {
        }

        @Override // k71.a
        public void onLoadSuccess() {
            QLog.d(GameMetaDreamMsgCenterFragment.TAG, 2, "IGameContactFetchListener onLoadSuccess");
            GameMetaDreamMsgCenterFragment.this.refreshGameMsgList();
        }

        @Override // k71.a
        public void onLoadFailed() {
        }
    }

    private TextView getTabTextView(TabLayout.g gVar) {
        View childAt;
        TabLayout.TabView tabView = gVar.f34288i;
        if (tabView == null || tabView.getChildCount() <= 1 || (childAt = gVar.f34288i.getChildAt(1)) == null || !(childAt instanceof TextView)) {
            return null;
        }
        return (TextView) childAt;
    }

    private void hideGameMsgList() {
        DragFrameLayout dragFrameLayout = this.mMsgListContainer;
        if (dragFrameLayout == null || dragFrameLayout.getVisibility() == 8) {
            return;
        }
        this.mMsgListContainer.setVisibility(8);
    }

    private void hideInteractMsgView() {
        FrameLayout frameLayout = this.mInteractMsgContainer;
        if (frameLayout != null) {
            frameLayout.setVisibility(8);
        }
        hideLoadingView();
    }

    private void initData() {
        QQAppInterface qQAppInterface = (QQAppInterface) BaseApplicationImpl.getApplication().getRuntime();
        qQAppInterface.addObserver(this.mGameCenterObserver);
        ((IGameMsgManagerService) qQAppInterface.getRuntimeService(IGameMsgManagerService.class)).addUserInfoChangedObserver(this.mGameCenterObserver);
        IGameMsgBoxManager iGameMsgBoxManager = (IGameMsgBoxManager) qQAppInterface.getRuntimeService(IGameMsgBoxManager.class);
        iGameMsgBoxManager.tryUpdateGameMsgInfoFromRecentUser();
        iGameMsgBoxManager.resetNTLoadRemoteUserList();
        iGameMsgBoxManager.fetchRecentGameContacts(false, this.gameContactFetchListener, 2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void initInteractMsgKuiklyView() {
        g createKuiklyRenderView = ((IQQKuiklyFactory) QRoute.api(IQQKuiklyFactory.class)).createKuiklyRenderView(this.mInteractMsgContainer.getContext(), this);
        this.mInteractMsgKuiklyView = createKuiklyRenderView;
        this.mInteractMsgContainer.addView((View) createKuiklyRenderView);
        MetaDreamInteractMsgTabConfig metaDreamInteractMsgTabConfig = (MetaDreamInteractMsgTabConfig) ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadConfig("101637");
        if (metaDreamInteractMsgTabConfig != null) {
            JSONObject openKuiklyInfo = metaDreamInteractMsgTabConfig.getOpenKuiklyInfo();
            QLog.d(TAG, 1, "initInteractMsgKuiklyView openKuiklyInfo=", openKuiklyInfo);
            Map<String, Object> m3 = KuiklyLaunchParams.INSTANCE.m(openKuiklyInfo);
            this.mInteractMsgKuiklyView.b((String) m3.get("page_name"), m3, new Size((int) ah.Z(), (int) ((ah.y() - getQBaseActivity().getTitleBarHeight()) - x.c(this.mInteractMsgContainer.getContext(), 56.0f))));
            return;
        }
        QLog.d(TAG, 1, "initInteractMsgKuiklyView config null");
    }

    private void initMsgListView() {
        DragFrameLayout dragFrameLayout = (DragFrameLayout) ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.f17550l);
        this.mMsgListContainer = dragFrameLayout;
        dragFrameLayout.setId(R.id.evx);
        if (this.mInitTabIndex == 0) {
            this.mMsgListContainer.setVisibility(0);
        } else {
            this.mMsgListContainer.setVisibility(8);
        }
        NTChatRecyclerViewWithHeaderFooter nTChatRecyclerViewWithHeaderFooter = (NTChatRecyclerViewWithHeaderFooter) ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.f17440a);
        this.mMsgListView = nTChatRecyclerViewWithHeaderFooter;
        nTChatRecyclerViewWithHeaderFooter.setId(R.id.tug);
        this.mMsgListView.C(View.inflate(this.mActivity, R.layout.f167783hc, null));
    }

    private void initTab() {
        int color;
        this.mInteractMsgContainer = (FrameLayout) ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.f17811a);
        this.mTopTabContainer = (RelativeLayout) ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.f17831c);
        this.mTopTab = (TabLayout) ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.f17821b);
        QLog.d(TAG, 1, "initTab");
        if (!this.mIsShowInteractMsgTab) {
            this.mTopTabContainer.setVisibility(8);
            return;
        }
        this.mTopTabContainer.setVisibility(0);
        this.mTopTab.g(this.mTopTab.J().t("\u804a\u5929\u6d88\u606f"));
        this.mTopTab.g(this.mTopTab.J().t("\u4e92\u52a8\u6d88\u606f"));
        boolean isNowThemeIsNight = ThemeUtil.isNowThemeIsNight(MobileQQ.sMobileQQ.peekAppRuntime(), false, null);
        Resources resources = super.getResources();
        if (isNowThemeIsNight) {
            color = resources.getColor(R.color.f158017al3);
        } else {
            color = resources.getColor(R.color.black);
        }
        this.mTopTab.setTabTextColors(color, Color.parseColor("#0099FF"));
        this.mTopTab.f(this);
        QLog.d(TAG, 1, "initTab tabIndex=", Integer.valueOf(this.mInitTabIndex));
        TabLayout tabLayout = this.mTopTab;
        tabLayout.R(tabLayout.B(this.mInitTabIndex), true);
    }

    private void initTabIndex() {
        boolean isSwitchOn = ((IGameCenterUnitedConfigApi) QRoute.api(IGameCenterUnitedConfigApi.class)).isSwitchOn("101637");
        this.mIsShowInteractMsgTab = isSwitchOn;
        if (!isSwitchOn) {
            this.mInitTabIndex = 0;
        } else if (this.mInitTabIndex > 1) {
            this.mInitTabIndex = 0;
        }
        this.mCurrentTabIndex = this.mInitTabIndex;
        QLog.d(TAG, 1, "initTabIndex isShowInteractMsgTab=", Boolean.valueOf(isSwitchOn), ", mInitTabIndex=", Integer.valueOf(this.mInitTabIndex));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$refreshGameMsgList$0() {
        if (this.mGameMsgBoxNtPart != null) {
            QLog.d(TAG, 1, "refreshMsgList2");
            this.mGameMsgBoxNtPart.B9();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refreshGameMsgList() {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            if (this.mGameMsgBoxNtPart != null) {
                QLog.d(TAG, 1, "refreshMsgList1");
                this.mGameMsgBoxNtPart.B9();
                return;
            }
            return;
        }
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.gamecenter.metadream.fragment.a
            @Override // java.lang.Runnable
            public final void run() {
                GameMetaDreamMsgCenterFragment.this.lambda$refreshGameMsgList$0();
            }
        });
    }

    private void reportPageExplosure() {
        String str;
        HashMap hashMap = new HashMap();
        if (this.mInitTabIndex == 0) {
            str = "1";
        } else {
            str = "2";
        }
        hashMap.put("ext2", str);
        ((IMetaDreamAttaReportApi) QRoute.api(IMetaDreamAttaReportApi.class)).report("1130000", "7", "113", "11301", "", "", hashMap);
    }

    private void showGameMsgList() {
        DragFrameLayout dragFrameLayout = this.mMsgListContainer;
        if (dragFrameLayout == null || dragFrameLayout.getVisibility() == 0) {
            return;
        }
        this.mMsgListContainer.setVisibility(0);
    }

    private void showInteractMsgView() {
        FrameLayout frameLayout = this.mInteractMsgContainer;
        if (frameLayout == null) {
            return;
        }
        frameLayout.setVisibility(0);
        if (this.mIsInteractMsgViewInit) {
            return;
        }
        initInteractMsgKuiklyView();
        this.mIsInteractMsgViewInit = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment
    public void doOnCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        super.doOnCreateView(layoutInflater, viewGroup, bundle);
        setTitle(this.mActivity.getString(R.string.f199384p_));
        initTabIndex();
        initMsgListView();
        initTab();
        initData();
        reportPageExplosure();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.f127179;
    }

    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* bridge */ /* synthetic */ ViewModel getViewModel(ViewModelStoreOwner viewModelStoreOwner, String str, Class cls) {
        return ne0.a.a(this, viewModelStoreOwner, str, cls);
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityResult(int i3, int i16, Intent intent) {
        g gVar;
        if (this.mCurrentTabIndex != 1 || (gVar = this.mInteractMsgKuiklyView) == null) {
            return;
        }
        gVar.onActivityResult(i3, i16, intent);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mActivity = getQBaseActivity();
        QQAppInterface qQAppInterface = (QQAppInterface) BaseApplicationImpl.getApplication().getRuntime();
        if (qQAppInterface != null) {
            ((IGameMsgBoxManager) qQAppInterface.getRuntimeService(IGameMsgBoxManager.class)).registerNTGameTabListener(new IGameMsgBoxManager.a() { // from class: com.tencent.mobileqq.gamecenter.metadream.fragment.b
                @Override // com.tencent.mobileqq.activity.recent.gamemsgbox.api.IGameMsgBoxManager.a
                public final void a() {
                    GameMetaDreamMsgCenterFragment.this.refreshGameMsgList();
                }
            });
        }
        ((IGameMsgHelperApi) QRoute.api(IGameMsgHelperApi.class)).requestGameListOfMsgBox();
        Bundle extras = this.mActivity.getIntent().getExtras();
        if (extras != null) {
            int i3 = extras.getInt(EXTRA_META_DREAM_MSG_TAB_INDEX, 0);
            this.mInitTabIndex = i3;
            QLog.d(TAG, 2, "onCreate mInitTabIndex=", Integer.valueOf(i3));
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        QQAppInterface qQAppInterface = (QQAppInterface) BaseApplicationImpl.getApplication().getRuntime();
        if (qQAppInterface != null) {
            ((IGameMsgManagerService) qQAppInterface.getRuntimeService(IGameMsgManagerService.class)).removeUserInfoChangedObserver(this.mGameCenterObserver);
            qQAppInterface.removeObserver(this.mGameCenterObserver);
            IGameMsgBoxManager iGameMsgBoxManager = (IGameMsgBoxManager) qQAppInterface.getRuntimeService(IGameMsgBoxManager.class);
            iGameMsgBoxManager.unregisterNTGameTabListener();
            iGameMsgBoxManager.clearTitles();
            iGameMsgBoxManager.resetFetchListener();
        }
        this.gameContactFetchListener = null;
        TabLayout tabLayout = this.mTopTab;
        if (tabLayout != null) {
            tabLayout.O(this);
        }
        onInteractMsgViewDestroy();
    }

    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    @Deprecated
    public /* bridge */ /* synthetic */ void onPartTimeCostReport(String str, String str2, long j3) {
        ne0.a.e(this, str, str2, j3);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.mCurrentTabIndex == 1) {
            onInteractMsgViewPause();
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        refreshGameMsgList();
        if (this.mCurrentTabIndex == 1) {
            onInteractMsgViewResume();
        }
    }

    @Override // com.google.android.material.tabs.TabLayout.c
    public void onTabReselected(TabLayout.g gVar) {
        int g16 = gVar.g();
        QLog.d(TAG, 1, "onTabReselected position=", Integer.valueOf(g16));
        updateTabTextTypeFace(getTabTextView(gVar), true);
        onTabSelect(g16);
    }

    @Override // com.google.android.material.tabs.TabLayout.c
    public void onTabSelected(TabLayout.g gVar) {
        int g16 = gVar.g();
        QLog.d(TAG, 1, "onTabSelected position=", Integer.valueOf(g16));
        updateTabTextTypeFace(getTabTextView(gVar), true);
        if (this.mCurrentTabIndex != g16) {
            reportTabClick(g16);
        }
        onTabSelect(g16);
    }

    @Override // com.google.android.material.tabs.TabLayout.c
    public void onTabUnselected(TabLayout.g gVar) {
        QLog.d(TAG, 1, "onTabUnselected position=", Integer.valueOf(gVar.g()));
        updateTabTextTypeFace(getTabTextView(gVar), false);
    }

    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public /* bridge */ /* synthetic */ void onUserLeaveHint() {
        f.m(this);
    }

    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public /* bridge */ /* synthetic */ boolean useArgusLifecycle() {
        return ne0.a.f(this);
    }

    private void onInteractMsgViewDestroy() {
        QLog.i(TAG, 1, "onInteractMsgViewDestroy");
        g gVar = this.mInteractMsgKuiklyView;
        if (gVar != null) {
            gVar.onPause();
            this.mInteractMsgKuiklyView.onDetach();
            this.mInteractMsgKuiklyView = null;
        }
    }

    private void onInteractMsgViewPause() {
        QLog.i(TAG, 1, "onInteractMsgViewPause");
        g gVar = this.mInteractMsgKuiklyView;
        if (gVar != null) {
            gVar.onPause();
        }
    }

    private void onInteractMsgViewResume() {
        QLog.i(TAG, 1, "onInteractMsgViewResume");
        g gVar = this.mInteractMsgKuiklyView;
        if (gVar != null) {
            gVar.onResume();
        }
    }

    private void onTabSelect(int i3) {
        QLog.d(TAG, 1, "onTabSelect position=", Integer.valueOf(i3));
        this.mCurrentTabIndex = i3;
        if (i3 == 0) {
            hideInteractMsgView();
            showGameMsgList();
            refreshGameMsgList();
            onInteractMsgViewPause();
            return;
        }
        if (i3 == 1) {
            hideGameMsgList();
            showInteractMsgView();
            onInteractMsgViewResume();
            return;
        }
        QLog.d(TAG, 1, "onTabSelect invalid position");
    }

    private void reportTabClick(int i3) {
        String str;
        QLog.d(TAG, 1, "reportTabClick position=", Integer.valueOf(i3));
        HashMap hashMap = new HashMap();
        if (i3 == 0) {
            str = "1";
        } else {
            str = "2";
        }
        hashMap.put("ext2", str);
        ((IMetaDreamAttaReportApi) QRoute.api(IMetaDreamAttaReportApi.class)).report("1130101", "20", "113", "11301", "", "", hashMap);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public List<Part> assembleParts() {
        QLog.d(TAG, 1, "assembleParts");
        ArrayList arrayList = new ArrayList();
        af afVar = new af(this.mActivity, ((QIphoneTitleBarFragment) this).mContentView, 2);
        this.mGameMsgBoxNtPart = afVar;
        arrayList.add(afVar);
        return arrayList;
    }

    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* bridge */ /* synthetic */ ViewModel getViewModel(String str, Class cls) {
        return ne0.a.c(this, str, cls);
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.kuikly.api.h
    public void hideLoadingView() {
        QLog.i(TAG, 1, "hideLoadingView");
        RelativeLayout relativeLayout = this.mLoadingContainer;
        if (relativeLayout == null || relativeLayout.getVisibility() != 0) {
            return;
        }
        this.mLoadingAnimView.pauseAnimation();
        this.mLoadingContainer.setVisibility(8);
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.kuikly.api.h
    public void onPageLoadComplete(boolean z16, ErrorReason errorReason, KuiklyRenderCoreExecuteMode kuiklyRenderCoreExecuteMode) {
        QLog.d(TAG, 1, "onPageLoadComplete isSucceed=", Boolean.valueOf(z16));
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.kuikly.api.h
    public void showLoadingView() {
        QLog.i(TAG, 1, "showLoadingView");
        RelativeLayout relativeLayout = (RelativeLayout) ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.f177818);
        this.mLoadingContainer = relativeLayout;
        relativeLayout.setVisibility(0);
        LottieAnimationView lottieAnimationView = (LottieAnimationView) this.mLoadingContainer.findViewById(R.id.f177919);
        this.mLoadingAnimView = lottieAnimationView;
        lottieAnimationView.setAnimation(LOADING_LOTTIE_ANIM);
        this.mLoadingAnimView.playAnimation();
    }

    private void updateTabTextTypeFace(TextView textView, boolean z16) {
        if (textView != null) {
            textView.setTypeface(Typeface.defaultFromStyle(z16 ? 1 : 0));
        }
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.kuikly.api.h
    public void hideErrorView() {
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.kuikly.api.h
    public void showErrorView() {
    }
}
