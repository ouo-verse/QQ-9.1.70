package com.tencent.mobileqq.mini.entry.search.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.ams.dsdk.core.hippy.DKHippyEvent;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.qqcircle.immersive.views.search.util.p;
import com.tencent.biz.qui.quiemptystate.QUIEmptyState;
import com.tencent.biz.richframework.ioc.RFWIocAbilityProvider;
import com.tencent.biz.richframework.part.adapter.widget.RFWConcatAdapter;
import com.tencent.biz.richframework.part.block.base.SafeLinearLayoutManager;
import com.tencent.biz.richframework.preload.recyclerview.ILoadMoreProvider$LoadMoreListener;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.entry.MiniAppUtils;
import com.tencent.mobileqq.mini.entry.search.data.MiniAppSearchDataManager;
import com.tencent.mobileqq.mini.entry.search.report.SearchDtReportExtKt;
import com.tencent.mobileqq.mini.entry.search.ui.adapter.MiniAppSearchLoadMoreAdapter;
import com.tencent.mobileqq.mini.entry.search.ui.adapter.MiniAppSearchResultAdapter;
import com.tencent.mobileqq.mini.entry.search.ui.history.MiniAppSearchHistoryRepo;
import com.tencent.mobileqq.mini.entry.search.viewmodel.MiniAppSearchResult;
import com.tencent.mobileqq.mini.entry.search.viewmodel.MiniAppSearchViewModel;
import com.tencent.mobileqq.mini.entry.util.SearchBarAnimationUtil;
import com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.api.ISearchDetailApi;
import com.tencent.mobileqq.search.api.ISearchReportApi;
import com.tencent.mobileqq.search.i;
import com.tencent.mobileqq.search.searchdetail.SearchPageType;
import com.tencent.mobileqq.search.util.ar;
import com.tencent.mobileqq.search.util.aw;
import com.tencent.mobileqq.search.view.QuickPinyinEditText;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.widget.search.ActionCallbackAdapter;
import com.tencent.mobileqq.widget.search.QUISearchBar;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqlive.module.videoreport.data.IDynamicParams;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import com.tencent.richframework.widget.refresh.layout.SmartRefreshLayout;
import com.tencent.util.InputMethodUtil;
import com.tencent.util.QQToastUtil;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import qp2.SearchActionReportParam;

/* compiled from: P */
/* loaded from: classes33.dex */
public class MiniAppSearchFragment extends PublicBaseFragment {
    public static final String IS_FROM_MINI_DESKTOP = "isFromMiniDesktop";
    public static final String KEY_RECOMMEND_WORD = "recommend_word";
    public static final String KEY_REFER = "key_refer";
    public static final String SEARCHBAR_BG_ID = "searchBarBgId";
    public static final String SEARCH_KEYWORD = "search_keyword";
    public static final String TAG = "MiniAppSearchFragment";
    private SearchActionReportParam actionReportParam;
    private boolean hasReportScroll;
    private boolean isEditTextChangeFromHistory;
    private AtomicBoolean isLoadingMore;
    private boolean isRunExitAnimAndFinish;
    private qp2.c mAutoMiniAppReporter;
    private ImageView mClearInputTextButton;
    private MiniAppSearchResult mCurrentSearchResult;
    private EditText mEditTextView;
    private DebounceTextWatcher mEditTextWatcher;
    private QUIEmptyState mEmptyState;
    private com.tencent.mobileqq.search.i mHistoryModel;
    private MiniAppSearchHistoryRepo mHistoryRepo;
    private boolean mIsFromMiniDeskTop;
    private TextView mKeySearchTv;
    private String mLastEditTextContent;
    private MiniAppSearchLoadMoreAdapter mLoadMoreAdapter;
    private View mLoadingContainer;
    private FrameLayout mMiniAppSearchPageContent;
    private qp2.d mMiniAppStayReporter;
    private ViewGroup mNoSearchResultViewGroup;
    private SmartRefreshLayout mNormalSearchResultRefreshRoot;
    private int mQuerySource;
    private int mRefer;
    private MiniAppSearchResultAdapter mResultAdapter;
    private RecyclerView mResultRecyclerView;
    private QUISearchBar mSearchBar;
    private View mSearchBarAnimView;
    private MiniAppSearchDataManager mSearchDataManager = (MiniAppSearchDataManager) MiniAppUtils.getAppInterface().getManager(QQManagerFactory.MINI_APP_SEARCH_MANAGER);
    private ViewGroup mSearchHistory;
    private ViewGroup mSearchResultContainer;
    private String mSessionId;
    private boolean mShouldHideKeyboard;
    private TextChangeListener mTextChangeListener;
    private String mTianShuKeyword;
    private int mUserSource;
    private MiniAppSearchViewModel mViewModel;
    private aw softKeyboardStateHelper;

    public MiniAppSearchFragment() {
        TextChangeListener textChangeListener = new TextChangeListener() { // from class: com.tencent.mobileqq.mini.entry.search.ui.b
            @Override // com.tencent.mobileqq.mini.entry.search.ui.TextChangeListener
            public final void onDebouncedTextChanged(String str) {
                MiniAppSearchFragment.this.lambda$new$0(str);
            }
        };
        this.mTextChangeListener = textChangeListener;
        this.mEditTextWatcher = new DebounceTextWatcher(200L, textChangeListener);
        this.isLoadingMore = new AtomicBoolean();
        this.isEditTextChangeFromHistory = false;
        this.mLastEditTextContent = "";
        this.mSessionId = p.r();
        this.mShouldHideKeyboard = false;
        this.actionReportParam = new SearchActionReportParam();
        this.hasReportScroll = false;
    }

    private void adjustSearchBarUIByRefer() {
        this.mSearchBar.updateStyle(this.mRefer == 2077 ? 2 : 3);
    }

    private void bindReportPageParams(View view) {
        SearchDtReportExtKt.bindPageReportInfo(getActivity(), SearchDtReportExtKt.PG_ID_APPLET_DROP_DOWN_SEARCH, getReportPageParams());
    }

    private void createMiniAppStayReportManager(String str, int i3, String str2, String str3, String str4) {
        this.mMiniAppStayReporter = ((ISearchDetailApi) QRoute.api(ISearchDetailApi.class)).createSearchMiniAppStayReportManager(str, i3, 7, str2, str3, str4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doLoadMore() {
        if (this.isLoadingMore.get()) {
            return;
        }
        String obj = this.mEditTextView.getText().toString();
        if (obj.isEmpty()) {
            return;
        }
        this.mViewModel.loadMoreMiniApp(obj);
    }

    private HashMap<String, Object> getReportPageParams() {
        return new HashMap<String, Object>(this.mRefer == 2077 ? 1 : 2) { // from class: com.tencent.mobileqq.mini.entry.search.ui.MiniAppSearchFragment.16
            final /* synthetic */ int val$pageSource;

            {
                this.val$pageSource = r2;
                put(SearchDtReportExtKt.PG_PARAM_APPLET_PAGE_SOURCE, Integer.valueOf(r2));
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: handleEditTextContentChange, reason: merged with bridge method [inline-methods] */
    public void lambda$new$0(String str) {
        this.mLastEditTextContent = str;
        judgeQuerySource();
        if (TextUtils.isEmpty(str)) {
            this.mCurrentSearchResult = null;
            this.mSearchHistory.setVisibility(0);
            this.mHistoryModel.refresh();
            this.mSearchResultContainer.setVisibility(8);
            this.mClearInputTextButton.setVisibility(8);
            this.mLoadingContainer.setVisibility(8);
            return;
        }
        this.mSearchResultContainer.setVisibility(0);
        boolean shouldShowLoading = shouldShowLoading();
        this.mLoadingContainer.setVisibility(shouldShowLoading ? 0 : 8);
        this.mNormalSearchResultRefreshRoot.setVisibility(shouldShowLoading ? 8 : 0);
        this.mNoSearchResultViewGroup.setVisibility(8);
        this.mSearchHistory.setVisibility(8);
        this.mViewModel.searchMiniApp(getActivity(), str, this.mQuerySource, this.mUserSource);
    }

    private void handleReceiveEmptyResult(MiniAppSearchResult miniAppSearchResult) {
        this.mNoSearchResultViewGroup.setVisibility(0);
        this.mNormalSearchResultRefreshRoot.setVisibility(8);
        if (this.mEmptyState == null) {
            this.mEmptyState = new QUIEmptyState.Builder(getContext()).setImageType(9).setBackgroundColorType(0).build();
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -1);
            layoutParams.addRule(13);
            this.mNoSearchResultViewGroup.addView(this.mEmptyState, layoutParams);
        }
        this.mEmptyState.setTitle(BaseApplication.getContext().getResources().getString(R.string.f167522d6));
        SearchDtReportExtKt.reportEvent("imp", "em_applet_no_result", new HashMap<String, Object>() { // from class: com.tencent.mobileqq.mini.entry.search.ui.MiniAppSearchFragment.14
            {
                put(SearchDtReportExtKt.EM_PARAM_APPLET_KEYWORD_NAME, MiniAppSearchFragment.this.mLastEditTextContent);
            }
        }, getReportPageParams());
    }

    private void handleReceiveNormalResult(MiniAppSearchResult miniAppSearchResult) {
        this.mNoSearchResultViewGroup.setVisibility(8);
        this.mNormalSearchResultRefreshRoot.setVisibility(0);
        this.mResultAdapter.setData(miniAppSearchResult.getResultData());
        this.mResultAdapter.notifyDataSetChanged();
        handleReportData(miniAppSearchResult.getResultData());
    }

    private void initData() {
        judgeUserSource();
        MiniAppSearchViewModel miniAppSearchViewModel = (MiniAppSearchViewModel) new ViewModelProvider(this).get(MiniAppSearchViewModel.class);
        this.mViewModel = miniAppSearchViewModel;
        miniAppSearchViewModel.getSearchResultData().observe(getLifecycleOwner(), new Observer<MiniAppSearchResult>() { // from class: com.tencent.mobileqq.mini.entry.search.ui.MiniAppSearchFragment.12
            @Override // androidx.lifecycle.Observer
            public void onChanged(MiniAppSearchResult miniAppSearchResult) {
                MiniAppSearchFragment.this.handleReceiveSearchResult(miniAppSearchResult);
            }
        });
    }

    private void initKeyboardStateHelper(View view) {
        aw awVar = new aw(view);
        this.softKeyboardStateHelper = awVar;
        awVar.a(new aw.a() { // from class: com.tencent.mobileqq.mini.entry.search.ui.MiniAppSearchFragment.10
            @Override // com.tencent.mobileqq.search.util.aw.a
            public void onSoftKeyboardClosed() {
                MiniAppSearchFragment.this.reportAction(5006);
            }

            @Override // com.tencent.mobileqq.search.util.aw.a
            public void onSoftKeyboardOpened(int i3) {
                MiniAppSearchFragment.this.reportAction(5007);
            }
        });
    }

    private void judgeQuerySource() {
        if (this.mUserSource == 22) {
            this.mQuerySource = this.isEditTextChangeFromHistory ? 40 : 39;
        } else {
            this.mQuerySource = this.isEditTextChangeFromHistory ? 42 : 41;
        }
        this.isEditTextChangeFromHistory = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$initHistoryView$4(String str) {
        QLog.i(TAG, 1, "on history item click:" + str);
        onSearchHistoryClick(str);
        saveSearchHistory(str);
        SearchDtReportExtKt.reportEvent("clck", SearchDtReportExtKt.EM_ID_APPLET_HISTORY_KEYWORD_ITEM, new HashMap<String, Object>(str) { // from class: com.tencent.mobileqq.mini.entry.search.ui.MiniAppSearchFragment.4
            final /* synthetic */ String val$keyword;

            {
                this.val$keyword = str;
                put(SearchDtReportExtKt.EM_PARAM_APPLET_KEYWORD_NAME, str);
            }
        }, getReportPageParams());
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$initHistoryView$5(Boolean bool, com.tencent.mobileqq.search.j jVar) {
        QLog.i(TAG, 1, "on history item delete, success:" + bool + ", keyword:" + jVar.f());
        this.mHistoryModel.j(bool.booleanValue(), jVar);
        SearchDtReportExtKt.reportEvent("clck", SearchDtReportExtKt.EM_ID_APPLET_HISTORY_DELETE_BUTTON, new HashMap<String, Object>(jVar) { // from class: com.tencent.mobileqq.mini.entry.search.ui.MiniAppSearchFragment.5
            final /* synthetic */ com.tencent.mobileqq.search.j val$searchable;

            {
                this.val$searchable = jVar;
                put(SearchDtReportExtKt.EM_PARAM_APPLET_KEYWORD_NAME, jVar.f());
            }
        }, getReportPageParams());
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initHistoryView$6(com.tencent.mobileqq.search.j jVar) {
        QLog.i(TAG, 1, "onItemExpose:" + jVar.f());
        SearchDtReportExtKt.reportEvent("imp", SearchDtReportExtKt.EM_ID_APPLET_HISTORY_KEYWORD_ITEM, new HashMap<String, Object>(jVar) { // from class: com.tencent.mobileqq.mini.entry.search.ui.MiniAppSearchFragment.6
            final /* synthetic */ com.tencent.mobileqq.search.j val$data;

            {
                this.val$data = jVar;
                put(SearchDtReportExtKt.EM_PARAM_APPLET_KEYWORD_NAME, jVar.f());
            }
        }, getReportPageParams());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initSearchBar$1(View view) {
        InputMethodUtil.show(this.mEditTextView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initSearchBar$2() {
        InputMethodUtil.show(this.mEditTextView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Map lambda$initSearchBar$3(String str) {
        return new HashMap<String, Object>() { // from class: com.tencent.mobileqq.mini.entry.search.ui.MiniAppSearchFragment.3
            {
                put(SearchDtReportExtKt.EM_PARAM_APPLET_KEYWORD_NAME, MiniAppSearchFragment.this.mLastEditTextContent);
            }
        };
    }

    private void onSearchHistoryClick(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.isEditTextChangeFromHistory = true;
        this.mEditTextView.setText(str);
        this.mEditTextView.setSelection(str.length());
        InputMethodUtil.hide(this.mEditTextView);
    }

    private void registerIoc() {
        RFWIocAbilityProvider.g().registerIoc(this.mResultRecyclerView, new com.tencent.mobileqq.search.searchdetail.d() { // from class: com.tencent.mobileqq.mini.entry.search.ui.MiniAppSearchFragment.11
            @Override // com.tencent.mobileqq.search.searchdetail.d
            public int getAllItemNums() {
                if (MiniAppSearchFragment.this.mCurrentSearchResult != null) {
                    return MiniAppSearchFragment.this.mCurrentSearchResult.getResultData().size();
                }
                return 0;
            }

            @Override // com.tencent.mobileqq.search.searchdetail.d
            public CoroutineScope getCoroutineScope() {
                return null;
            }

            @Override // com.tencent.mobileqq.search.searchdetail.d
            public String getDtAppKey() {
                return "0AND06A49O0PML4Z";
            }

            @Override // com.tencent.mobileqq.search.searchdetail.d
            public String getKeyword() {
                if (MiniAppSearchFragment.this.mCurrentSearchResult != null) {
                    return MiniAppSearchFragment.this.mCurrentSearchResult.getKeyword();
                }
                return "";
            }

            @Override // com.tencent.mobileqq.search.searchdetail.d
            public LifecycleOwner getLifecyclerOwner() {
                return MiniAppSearchFragment.this.getLifecycleOwner();
            }

            @Override // com.tencent.mobileqq.search.searchdetail.d
            public String getMiniAppSessionId() {
                return MiniAppSearchFragment.this.mViewModel.getSessionId();
            }

            @Override // com.tencent.mobileqq.search.searchdetail.d
            public Map<String, Object> getPageCacheMap() {
                return Collections.emptyMap();
            }

            @Override // com.tencent.mobileqq.search.searchdetail.d
            public int getPageMode() {
                return 0;
            }

            @Override // com.tencent.mobileqq.search.searchdetail.d
            public SearchPageType getPageType() {
                return MiniAppSearchViewModel.INSTANCE.getPageType();
            }

            @Override // com.tencent.mobileqq.search.searchdetail.d
            public int getQuerySource() {
                return MiniAppSearchFragment.this.mQuerySource;
            }

            @Override // com.tencent.mobileqq.search.searchdetail.d
            public String getSessionId() {
                return MiniAppSearchFragment.this.mSessionId;
            }

            @Override // com.tencent.mobileqq.search.searchdetail.d
            public long getStartSearchTimeStamps() {
                if (MiniAppSearchFragment.this.mCurrentSearchResult != null) {
                    return MiniAppSearchFragment.this.mCurrentSearchResult.getTimestamp();
                }
                return 0L;
            }

            @Override // com.tencent.mobileqq.search.searchdetail.d
            public String getSugTraceId() {
                return "";
            }

            @Override // com.tencent.mobileqq.search.searchdetail.d
            public long getTabMask() {
                return 7L;
            }

            @Override // com.tencent.mobileqq.search.searchdetail.d
            public String getTabName() {
                return MiniAppSearchViewModel.TAB_NAME;
            }

            @Override // com.tencent.mobileqq.search.searchdetail.d
            public int getUserSource() {
                return MiniAppSearchFragment.this.mUserSource;
            }

            @Override // com.tencent.mobileqq.search.searchdetail.d
            public void onClickMiniApp(String str) {
                if (MiniAppSearchFragment.this.mMiniAppStayReporter != null) {
                    MiniAppSearchFragment.this.mMiniAppStayReporter.onClickMiniApp(str);
                }
            }
        }, com.tencent.mobileqq.search.searchdetail.d.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reportAction(int i3) {
        SearchActionReportParam searchActionReportParam = this.actionReportParam;
        if (searchActionReportParam == null || !searchActionReportParam.c()) {
            return;
        }
        this.actionReportParam.d(i3);
        ((ISearchReportApi) QRoute.api(ISearchReportApi.class)).reportMiniAppAction(this.actionReportParam);
    }

    private void reportShowHotSearchWord(String str) {
        MiniAppConfig miniAppConfig = new MiniAppConfig(new MiniAppInfo());
        miniAppConfig.launchParam.scene = 3041;
        MiniProgramLpReportDC04239.reportAsync(miniAppConfig, "page_view", "em_expo", "pulldown_search_hotword", "", str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void runExitAnimAndFinish() {
        if (this.isRunExitAnimAndFinish) {
            QLog.e(TAG, 1, "isRunExitAnimAndFinish is true!");
            return;
        }
        if (getBaseActivity() == null) {
            QLog.e(TAG, 1, "getBaseActivity is null!");
            return;
        }
        this.isRunExitAnimAndFinish = true;
        if (this.mIsFromMiniDeskTop) {
            SearchBarAnimationUtil.runExitAnim(this.mSearchBarAnimView, this.mKeySearchTv, new AnimatorListenerAdapter() { // from class: com.tencent.mobileqq.mini.entry.search.ui.MiniAppSearchFragment.15
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (MiniAppSearchFragment.this.getBaseActivity() != null) {
                        MiniAppSearchFragment.this.getBaseActivity().finish();
                        MiniAppSearchFragment.this.getBaseActivity().overridePendingTransition(0, R.anim.f155053hw);
                    }
                }
            });
        } else {
            getBaseActivity().finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void saveSearchHistory(String str) {
        MiniAppSearchHistoryRepo miniAppSearchHistoryRepo = this.mHistoryRepo;
        if (miniAppSearchHistoryRepo != null) {
            miniAppSearchHistoryRepo.saveHistory(str);
        }
    }

    private void sendHotSearchRequest() {
        this.mSearchDataManager.sendHotSearchAppV2Request();
    }

    private boolean shouldShowLoading() {
        MiniAppSearchResult miniAppSearchResult = this.mCurrentSearchResult;
        return miniAppSearchResult == null || miniAppSearchResult.isNoResult() || this.mNormalSearchResultRefreshRoot.getVisibility() == 8;
    }

    private void updateReportInfo(String str, String str2, String str3) {
        this.actionReportParam.f(str);
        this.actionReportParam.h(str2);
        this.actionReportParam.e(str3);
        this.actionReportParam.g(qp2.f.b(this.mQuerySource));
        this.actionReportParam.i(this.mViewModel.getSessionId());
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* bridge */ /* synthetic */ ViewModel getViewModel(ViewModelStoreOwner viewModelStoreOwner, String str, Class cls) {
        return ne0.a.a(this, viewModelStoreOwner, str, cls);
    }

    @Override // com.tencent.mobileqq.fragment.PublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean isWrapContent() {
        return false;
    }

    @Override // com.tencent.mobileqq.fragment.PublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public boolean onBackEvent() {
        runExitAnimAndFinish();
        return true;
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = LayoutInflater.from(getBaseActivity()).inflate(R.layout.djg, (ViewGroup) null);
        if (ImmersiveUtils.isSupporImmersive() == 1) {
            inflate.setFitsSystemWindows(true);
        } else {
            inflate.setPadding(0, ImmersiveUtils.getStatusBarHeight(getBaseActivity()), 0, 0);
        }
        this.mRefer = getBaseActivity().getIntent().getIntExtra("key_refer", 2077);
        QLog.d(TAG, 1, "onCreateView, refer: " + this.mRefer);
        if (this.mRefer != 1005) {
            sendHotSearchRequest();
        }
        return inflate;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        QLog.d(TAG, 1, MosaicConstants$JsFunction.FUNC_ON_DESTROY);
        this.mEditTextWatcher.dispose();
        RFWIocAbilityProvider.g().unregisterSingleIoc(this.mResultRecyclerView, com.tencent.mobileqq.search.searchdetail.d.class);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    @Deprecated
    public /* bridge */ /* synthetic */ void onPartTimeCostReport(String str, String str2, long j3) {
        ne0.a.e(this, str, str2, j3);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        qp2.c cVar = this.mAutoMiniAppReporter;
        if (cVar != null) {
            cVar.pause();
        }
        qp2.d dVar = this.mMiniAppStayReporter;
        if (dVar != null) {
            dVar.onPause();
        }
        this.mShouldHideKeyboard = true;
        QLog.d(TAG, 1, MiniSDKConst.NOTIFY_EVENT_ONPAUSE);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.mShouldHideKeyboard) {
            this.mEditTextView.clearFocus();
            InputMethodUtil.hide(this.mEditTextView);
            this.mShouldHideKeyboard = false;
        }
        qp2.c cVar = this.mAutoMiniAppReporter;
        if (cVar != null) {
            cVar.resume();
        }
        qp2.d dVar = this.mMiniAppStayReporter;
        if (dVar != null) {
            dVar.onResume();
        }
        QLog.d(TAG, 1, "onResume");
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        qp2.c cVar = this.mAutoMiniAppReporter;
        if (cVar != null) {
            cVar.start();
        }
        QLog.d(TAG, 1, "onStart");
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        qp2.c cVar = this.mAutoMiniAppReporter;
        if (cVar != null) {
            cVar.stop();
        }
        QLog.d(TAG, 1, DKHippyEvent.EVENT_STOP);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment
    public /* bridge */ /* synthetic */ void onUserLeaveHint() {
        com.tencent.biz.richframework.compat.f.m(this);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        initSearchBar(view);
        initHistoryView(view);
        initSearchResultView(view);
        initKeyboardStateHelper(view);
        this.mLoadingContainer = view.findViewById(R.id.rgr);
        initData();
        boolean booleanExtra = getActivity().getIntent().getBooleanExtra(IS_FROM_MINI_DESKTOP, false);
        this.mIsFromMiniDeskTop = booleanExtra;
        if (booleanExtra) {
            View inflate = LayoutInflater.from(getActivity()).inflate(R.layout.djm, (ViewGroup) null);
            this.mSearchBarAnimView = inflate;
            this.mKeySearchTv = (TextView) inflate.findViewById(R.id.rhm);
            SearchBarAnimationUtil.runEnterAnim(getActivity(), this.mSearchBarAnimView, this.mKeySearchTv);
        }
        bindReportPageParams(view);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public /* bridge */ /* synthetic */ boolean useArgusLifecycle() {
        return ne0.a.f(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initHistoryView$7() {
        SearchDtReportExtKt.reportEvent("clck", SearchDtReportExtKt.EM_ID_APPLET_HISTORY_CLEAR_BUTTON, null, getReportPageParams());
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* bridge */ /* synthetic */ ViewModel getViewModel(String str, Class cls) {
        return ne0.a.c(this, str, cls);
    }

    private void handleReportData(List<com.tencent.mobileqq.search.searchdetail.a> list) {
        com.tencent.mobileqq.search.searchdetail.a aVar;
        qp2.a backEndReportFromItem;
        String str;
        if (list == null || list.isEmpty()) {
            return;
        }
        int i3 = 0;
        while (true) {
            if (i3 >= list.size()) {
                aVar = null;
                break;
            }
            aVar = list.get(i3);
            if (aVar.getItemType() == 22) {
                break;
            } else {
                i3++;
            }
        }
        if (aVar == null || (backEndReportFromItem = ((ISearchDetailApi) QRoute.api(ISearchDetailApi.class)).getBackEndReportFromItem(aVar)) == null || !backEndReportFromItem.p()) {
            return;
        }
        MiniAppSearchResult miniAppSearchResult = this.mCurrentSearchResult;
        if (miniAppSearchResult != null) {
            str = miniAppSearchResult.getKeyword();
        } else {
            str = "";
        }
        String str2 = str;
        String searchId = backEndReportFromItem.getSearchId();
        String parentSearchId = backEndReportFromItem.getParentSearchId();
        if (!backEndReportFromItem.getSearchId().equals(this.actionReportParam.getSearchId())) {
            updateReportInfo(str2, searchId, parentSearchId);
            this.hasReportScroll = false;
            this.mMiniAppStayReporter = null;
        }
        if (this.mMiniAppStayReporter == null) {
            createMiniAppStayReportManager(str2, this.mQuerySource, this.mViewModel.getSessionId(), searchId, parentSearchId);
            this.mMiniAppStayReporter.onFirstFrame();
        }
    }

    private void judgeUserSource() {
        this.mUserSource = 22;
        if (this.mRefer != 2077) {
            this.mUserSource = 21;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleReceiveSearchResult(MiniAppSearchResult miniAppSearchResult) {
        if (miniAppSearchResult == null) {
            return;
        }
        QLog.i(TAG, 1, "handleReceiveSearchResult, result:" + miniAppSearchResult);
        String keyword = miniAppSearchResult.getKeyword();
        String obj = this.mEditTextView.getText().toString();
        if (!keyword.equals(obj)) {
            QLog.w(TAG, 1, "handleReceiveSearchResult, resultKeyword:" + keyword + " mismatch currentKeyword " + obj);
            return;
        }
        this.mCurrentSearchResult = miniAppSearchResult;
        if (!miniAppSearchResult.getSuccess()) {
            QQToastUtil.showQQToastInUiThread(1, getResources().getString(R.string.xzd));
            SearchDtReportExtKt.reportEvent("imp", SearchDtReportExtKt.EM_ID_APPLET_REQUEST_FAIL_TOAST, new HashMap<String, Object>(miniAppSearchResult) { // from class: com.tencent.mobileqq.mini.entry.search.ui.MiniAppSearchFragment.13
                final /* synthetic */ MiniAppSearchResult val$result;

                {
                    this.val$result = miniAppSearchResult;
                    put(SearchDtReportExtKt.EM_PARAM_APPLET_KEYWORD_NAME, miniAppSearchResult.getKeyword());
                }
            }, getReportPageParams());
        }
        this.mLoadMoreAdapter.setLoadState(false, !miniAppSearchResult.isEnd());
        this.mSearchResultContainer.setVisibility(0);
        this.mLoadingContainer.setVisibility(8);
        if (miniAppSearchResult.isNoResult()) {
            handleReceiveEmptyResult(miniAppSearchResult);
        } else {
            handleReceiveNormalResult(miniAppSearchResult);
        }
    }

    private void initHistoryView(View view) {
        this.mSearchHistory = (ViewGroup) view.findViewById(R.id.rhj);
        RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.rhk);
        this.mHistoryRepo = new MiniAppSearchHistoryRepo(new Function1() { // from class: com.tencent.mobileqq.mini.entry.search.ui.f
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit lambda$initHistoryView$4;
                lambda$initHistoryView$4 = MiniAppSearchFragment.this.lambda$initHistoryView$4((String) obj);
                return lambda$initHistoryView$4;
            }
        }, new Function2() { // from class: com.tencent.mobileqq.mini.entry.search.ui.g
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                Unit lambda$initHistoryView$5;
                lambda$initHistoryView$5 = MiniAppSearchFragment.this.lambda$initHistoryView$5((Boolean) obj, (com.tencent.mobileqq.search.j) obj2);
                return lambda$initHistoryView$5;
            }
        }, 10028, 6);
        this.mHistoryModel = new com.tencent.mobileqq.search.i(14, 0, this.mHistoryRepo);
        relativeLayout.addView(this.mHistoryModel.s(getContext(), (QQAppInterface) MiniAppUtils.getAppInterface(), relativeLayout, null));
        this.mHistoryModel.w(getResources().getString(R.string.xz_));
        this.mHistoryModel.o();
        this.mHistoryModel.K(new i.c() { // from class: com.tencent.mobileqq.mini.entry.search.ui.h
            @Override // com.tencent.mobileqq.search.i.c
            public final void a(com.tencent.mobileqq.search.j jVar) {
                MiniAppSearchFragment.this.lambda$initHistoryView$6(jVar);
            }
        });
        SearchDtReportExtKt.bindElementReportInfo(this.mHistoryModel.F(), SearchDtReportExtKt.EM_ID_APPLET_HISTORY_SEARCH, ClickPolicy.REPORT_NONE, ExposurePolicy.REPORT_ALL, EndExposurePolicy.REPORT_ALL);
        View D = this.mHistoryModel.D();
        ClickPolicy clickPolicy = ClickPolicy.REPORT_ALL;
        SearchDtReportExtKt.bindElementReportInfo(D, SearchDtReportExtKt.EM_ID_APPLET_HISTORY_CLEAR_ICON, clickPolicy);
        SearchDtReportExtKt.bindElementReportInfo(this.mHistoryModel.E(), SearchDtReportExtKt.EM_ID_APPLET_HISTORY_FINISH_BUTTON, clickPolicy);
        this.mHistoryModel.L(new i.b() { // from class: com.tencent.mobileqq.mini.entry.search.ui.i
            @Override // com.tencent.mobileqq.search.i.b
            public final void onClear() {
                MiniAppSearchFragment.this.lambda$initHistoryView$7();
            }
        });
    }

    private void initSearchBar(View view) {
        QUISearchBar qUISearchBar = (QUISearchBar) view.findViewById(R.id.rhh);
        this.mSearchBar = qUISearchBar;
        qUISearchBar.setCustomResource(ar.a());
        this.mSearchBar.bindSearchChain(false);
        adjustSearchBarUIByRefer();
        this.mSearchBar.setActionCallback(new ActionCallbackAdapter() { // from class: com.tencent.mobileqq.mini.entry.search.ui.MiniAppSearchFragment.1
            @Override // com.tencent.mobileqq.widget.search.ActionCallbackAdapter, com.tencent.mobileqq.widget.search.QUISearchBar.ActionCallback
            public boolean onBack() {
                MiniAppSearchFragment.this.runExitAnimAndFinish();
                return true;
            }

            @Override // com.tencent.mobileqq.widget.search.ActionCallbackAdapter, com.tencent.mobileqq.widget.search.QUISearchBar.ActionCallback
            public int onCancel() {
                MiniAppSearchFragment.this.runExitAnimAndFinish();
                return 1;
            }

            @Override // com.tencent.mobileqq.widget.search.ActionCallbackAdapter, com.tencent.mobileqq.widget.search.QUISearchBar.ActionCallback
            public boolean onClear() {
                MiniAppSearchFragment miniAppSearchFragment = MiniAppSearchFragment.this;
                miniAppSearchFragment.mLastEditTextContent = miniAppSearchFragment.mEditTextView.getText().toString();
                QLog.i(MiniAppSearchFragment.TAG, 1, "onClear, content:" + MiniAppSearchFragment.this.mLastEditTextContent);
                MiniAppSearchFragment.this.mSearchResultContainer.setVisibility(8);
                MiniAppSearchFragment.this.mSearchHistory.setVisibility(0);
                MiniAppSearchFragment.this.mClearInputTextButton.setVisibility(8);
                MiniAppSearchFragment.this.mEditTextView.requestFocus();
                return super.onClear();
            }

            @Override // com.tencent.mobileqq.widget.search.ActionCallbackAdapter, com.tencent.mobileqq.widget.search.QUISearchBar.ActionCallback
            public void onSearch() {
                InputMethodUtil.hide(MiniAppSearchFragment.this.mEditTextView);
                String obj = MiniAppSearchFragment.this.mEditTextView.getText().toString();
                if (TextUtils.isEmpty(obj)) {
                    return;
                }
                MiniAppSearchFragment.this.saveSearchHistory(obj);
            }
        });
        this.mSearchBar.getInputWidget().addTextChangedListener(new TextWatcher() { // from class: com.tencent.mobileqq.mini.entry.search.ui.MiniAppSearchFragment.2
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (editable.length() == 0) {
                    MiniAppSearchFragment.this.reportAction(5008);
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
            }
        });
        this.mClearInputTextButton = this.mSearchBar.getClearView();
        QuickPinyinEditText inputWidget = this.mSearchBar.getInputWidget();
        this.mEditTextView = inputWidget;
        inputWidget.addTextChangedListener(this.mEditTextWatcher);
        this.mEditTextView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.mini.entry.search.ui.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                MiniAppSearchFragment.this.lambda$initSearchBar$1(view2);
            }
        });
        Intent intent = getBaseActivity().getIntent();
        this.mTianShuKeyword = intent.getStringExtra(KEY_RECOMMEND_WORD);
        String stringExtra = intent.getStringExtra("search_keyword");
        if (!TextUtils.isEmpty(this.mTianShuKeyword)) {
            this.mEditTextView.setHint(this.mTianShuKeyword);
            reportShowHotSearchWord(this.mTianShuKeyword);
        } else {
            this.mEditTextView.setHint(getString(R.string.f167512d5));
        }
        if (!TextUtils.isEmpty(stringExtra)) {
            this.mEditTextView.setText(stringExtra);
            this.mEditTextView.setSelection(stringExtra.length());
        }
        this.mEditTextView.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.mini.entry.search.ui.d
            @Override // java.lang.Runnable
            public final void run() {
                MiniAppSearchFragment.this.lambda$initSearchBar$2();
            }
        }, 300L);
        ImageView backView = this.mSearchBar.getBackView();
        ClickPolicy clickPolicy = ClickPolicy.REPORT_ALL;
        SearchDtReportExtKt.bindElementReportInfo(backView, SearchDtReportExtKt.EM_ID_APPLET_BACK_BUTTON, clickPolicy);
        SearchDtReportExtKt.bindElementReportInfo(this.mClearInputTextButton, SearchDtReportExtKt.EM_ID_APPLET_CLEAR_KEYWORD_BUTTON, clickPolicy);
        SearchDtReportExtKt.bindDynamicParams(this.mClearInputTextButton, new IDynamicParams() { // from class: com.tencent.mobileqq.mini.entry.search.ui.e
            @Override // com.tencent.qqlive.module.videoreport.data.IDynamicParams
            public final Map getDynamicParams(String str) {
                Map lambda$initSearchBar$3;
                lambda$initSearchBar$3 = MiniAppSearchFragment.this.lambda$initSearchBar$3(str);
                return lambda$initSearchBar$3;
            }
        });
        SearchDtReportExtKt.bindElementReportInfo(this.mSearchBar.getCancelView(), SearchDtReportExtKt.EM_ID_APPLET_CANCEL_BUTTON, clickPolicy);
    }

    private void initSearchResultView(View view) {
        this.mMiniAppSearchPageContent = (FrameLayout) view.findViewById(R.id.rhp);
        if (!QQTheme.isVasTheme()) {
            this.mMiniAppSearchPageContent.setBackgroundResource(R.drawable.qui_common_fill_light_primary_bg);
        }
        this.mSearchResultContainer = (ViewGroup) view.findViewById(R.id.rhq);
        this.mNoSearchResultViewGroup = (ViewGroup) view.findViewById(R.id.rho);
        SmartRefreshLayout smartRefreshLayout = (SmartRefreshLayout) view.findViewById(R.id.rhs);
        this.mNormalSearchResultRefreshRoot = smartRefreshLayout;
        smartRefreshLayout.setEnableRefresh(false);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.rhr);
        this.mResultRecyclerView = recyclerView;
        recyclerView.setLayoutManager(new SafeLinearLayoutManager(getContext()));
        MiniAppSearchResultAdapter miniAppSearchResultAdapter = new MiniAppSearchResultAdapter();
        this.mResultAdapter = miniAppSearchResultAdapter;
        miniAppSearchResultAdapter.setHasStableIds(true);
        MiniAppSearchLoadMoreAdapter miniAppSearchLoadMoreAdapter = new MiniAppSearchLoadMoreAdapter();
        this.mLoadMoreAdapter = miniAppSearchLoadMoreAdapter;
        miniAppSearchLoadMoreAdapter.registerLoadMoreListener(new ILoadMoreProvider$LoadMoreListener() { // from class: com.tencent.mobileqq.mini.entry.search.ui.MiniAppSearchFragment.7
            @Override // com.tencent.biz.richframework.preload.recyclerview.ILoadMoreProvider$LoadMoreListener
            public void onLoadMoreStart() {
                QLog.i(MiniAppSearchFragment.TAG, 1, "onLoadMoreStart");
                MiniAppSearchFragment.this.mLoadMoreAdapter.setLoadState(true, true);
                MiniAppSearchFragment.this.mLoadMoreAdapter.show();
                MiniAppSearchFragment.this.doLoadMore();
            }

            @Override // com.tencent.biz.richframework.preload.recyclerview.ILoadMoreProvider$LoadMoreListener
            public void onLoadMoreEnd(boolean z16) {
                QLog.i(MiniAppSearchFragment.TAG, 1, "onLoadMoreEnd");
            }
        });
        this.mResultRecyclerView.setAdapter(new RFWConcatAdapter(new RFWConcatAdapter.Config.Builder().setIsolateViewTypes(true).setStableIdMode(RFWConcatAdapter.Config.StableIdMode.ISOLATED_STABLE_IDS).build(), (RecyclerView.Adapter<? extends RecyclerView.ViewHolder>[]) new RecyclerView.Adapter[]{this.mResultAdapter, this.mLoadMoreAdapter}));
        this.mResultRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.tencent.mobileqq.mini.entry.search.ui.MiniAppSearchFragment.8
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView2, int i3) {
                if (i3 == 0) {
                    if (!MiniAppSearchFragment.this.hasReportScroll) {
                        MiniAppSearchFragment.this.reportAction(5005);
                        MiniAppSearchFragment.this.hasReportScroll = true;
                    }
                    VideoReport.traversePage(recyclerView2);
                }
            }
        });
        qp2.c createSearchMiniAppReportManager = ((ISearchDetailApi) QRoute.api(ISearchDetailApi.class)).createSearchMiniAppReportManager(this.mResultRecyclerView, new qp2.b() { // from class: com.tencent.mobileqq.mini.entry.search.ui.MiniAppSearchFragment.9
            @Override // qp2.b
            public String getKeyword() {
                if (MiniAppSearchFragment.this.mCurrentSearchResult != null) {
                    return MiniAppSearchFragment.this.mCurrentSearchResult.getKeyword();
                }
                return "";
            }

            @Override // qp2.b
            public String getMiniAppSessionId() {
                return MiniAppSearchFragment.this.mViewModel.getSessionId();
            }

            @Override // qp2.b
            public int getQuerySource() {
                return MiniAppSearchFragment.this.mQuerySource;
            }

            @Override // qp2.b
            public long getStartSearchTimeStamps() {
                if (MiniAppSearchFragment.this.mCurrentSearchResult != null) {
                    return MiniAppSearchFragment.this.mCurrentSearchResult.getTimestamp();
                }
                return 0L;
            }

            @Override // qp2.b
            public int getTabMask() {
                return 7;
            }
        });
        this.mAutoMiniAppReporter = createSearchMiniAppReportManager;
        createSearchMiniAppReportManager.start();
        registerIoc();
    }
}
