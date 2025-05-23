package com.tencent.mobileqq.search.fragment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.Editable;
import android.text.InputFilter;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.LinkMovementMethod;
import android.text.style.BackgroundColorSpan;
import android.text.style.ClickableSpan;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import circlesearch.CircleSearchExhibition$UnifySearchResultExt;
import com.tencent.biz.pubaccount.util.api.IPublicAccountConfigUtil;
import com.tencent.biz.qqcircle.widgets.comment.f;
import com.tencent.biz.richframework.compat.RFWImmersiveUtils;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.videostory.config.VSConfigManager;
import com.tencent.hippy.qq.api.TabPreloadItem;
import com.tencent.image.ApngImage;
import com.tencent.logcat.LogcatUtil;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseFragment;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.UnifySearchHandler;
import com.tencent.mobileqq.app.UniteSearchHandler;
import com.tencent.mobileqq.app.cw;
import com.tencent.mobileqq.guild.api.IGuildTempApi;
import com.tencent.mobileqq.kandian.biz.framework.api.IReadInJoyUtils;
import com.tencent.mobileqq.kandian.glue.router.api.IRIJJumpUtils;
import com.tencent.mobileqq.pad.LaunchMode;
import com.tencent.mobileqq.profilecard.api.IProfileCardConst;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.SearchUtil;
import com.tencent.mobileqq.search.ac;
import com.tencent.mobileqq.search.activity.UniteSearchActivity;
import com.tencent.mobileqq.search.api.ISearchReportApi;
import com.tencent.mobileqq.search.business.viewmodel.SearchDataFetchViewModel;
import com.tencent.mobileqq.search.event.GroupSearchEvent;
import com.tencent.mobileqq.search.event.UpdateSearchHintEvent;
import com.tencent.mobileqq.search.fragment.AssociateSearchWordsFragment;
import com.tencent.mobileqq.search.fragment.UniteSearchFragment;
import com.tencent.mobileqq.search.fragment.searchentry.ISearchEntryFragment;
import com.tencent.mobileqq.search.model.CompleteUrlSpan;
import com.tencent.mobileqq.search.model.DiscoveryResultData;
import com.tencent.mobileqq.search.model.HotWordSearchEntryDataModel;
import com.tencent.mobileqq.search.model.SearchEntryDataModel;
import com.tencent.mobileqq.search.model.v;
import com.tencent.mobileqq.search.model.x;
import com.tencent.mobileqq.search.model.y;
import com.tencent.mobileqq.search.qqmc.SearchQQMC;
import com.tencent.mobileqq.search.report.ReportModelDC02528;
import com.tencent.mobileqq.search.rich.RichNodeController;
import com.tencent.mobileqq.search.searchdetail.eventbus.JumpBusinessSearchEntryEvent;
import com.tencent.mobileqq.search.searchdetail.eventbus.UniteSearchEvent;
import com.tencent.mobileqq.search.unitsearch.viewmodel.UniteSearchViewModel;
import com.tencent.mobileqq.search.util.SearchEnginePerfReporter;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.search.util.aq;
import com.tencent.mobileqq.search.util.ar;
import com.tencent.mobileqq.search.util.w;
import com.tencent.mobileqq.search.util.z;
import com.tencent.mobileqq.search.view.AutoHintLayout;
import com.tencent.mobileqq.search.view.QuickPinyinEditText;
import com.tencent.mobileqq.search.voicesearch.ThirdAppComponent;
import com.tencent.mobileqq.search.voicesearch.VoiceSearchComponent;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.studymode.StudyModeManager;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.QAdVrReportParams;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.utils.ax;
import com.tencent.mobileqq.utils.bi;
import com.tencent.mobileqq.utils.cg;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.search.QUISearchBar;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.qqnt.kernel.nativeinterface.UfsTabItemGroup;
import com.tencent.qqnt.kernel.nativeinterface.cq;
import com.tencent.util.InputMethodUtil;
import com.tencent.widget.immersive.ImmersiveTitleBar2;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import lo2.am;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;
import vy2.b;

/* compiled from: P */
/* loaded from: classes18.dex */
public class UniteSearchFragment extends QBaseFragment implements TextView.OnEditorActionListener, TextWatcher, com.tencent.mobileqq.search.m, nn2.b, f.b, AssociateSearchWordsFragment.d, com.tencent.mobileqq.pad.f, SimpleEventReceiver, AutoHintLayout.b {
    public static final int FRAGMENT_ASSOCIATED_WORDS_LAYOUT = 3;
    public static final int FRAGMENT_NO_FLOAT_LAYOUT = 1;
    public static final int FRAGMENT_SEARCH_ENTRY_LAYOUT = 4;
    public static final int REQ_CODE_ASSOCIATE_JUMP_WEB = 10000;
    public static final int SEARCH_BAR_INPUT_MAX_NUMBER = 50;
    public static final String TAG = "Q.uniteSearch.UniteSearchFragment";
    public static final String TAG_ASSOCIATED_WORDS = "associated_words";
    public static final String TAG_SEARCH_ENTRY_LAYOUT = "search_entry_layout";
    public static boolean isNeedRequestAssociation = true;
    public static int mIsVsResultInvalidType = -1;
    public static int mResultSource;
    View associateLayout;
    public AutoHintLayout autoHintLayout;
    protected ImageView backView;
    protected TextView cancelButton;
    protected ImageView clearText;
    public String currKeyword;
    private SearchDataFetchViewModel dataFetchVM;
    View entryLayout;
    View groupSearchResultLayout;
    private com.tencent.mobileqq.search.business.viewmodel.a handleUniteSearchErrorCb;
    private com.tencent.mobileqq.search.business.viewmodel.b handlerUniteSearchResultSuccessCb;
    private ArrayList<String> hintWords;
    private boolean isFirstInGroupSearch;
    public boolean isInitiativeSearch;
    private Boolean isPaused;
    private boolean isSearchXsjHint;
    private Boolean isSoftKeyboardOpenning;
    private String lastSearchKeyWord;
    private QQAppInterface mApp;
    protected AssociateSearchWordsFragment mAssociatedFragment;
    private CharSequence mBeforeText;
    protected ImageView mConfigBackView;
    protected Button mConfigSearchButton;
    private FrameLayout mFlContent;
    private String mFragRequestCode;
    protected FragmentManager mFragmentManager;
    private String mHotSearchKeyWord;
    private String mHotSearchKeyWordId;
    private boolean mIsDeleteAction;
    private boolean mIsWaitToFinish;
    private LinearLayout mLlOldSearchLayout;
    private boolean mNeedUpdateBgWhenAnim;
    private int mRequestCode;
    private View mRootView;
    private QUISearchBar mSearchBar;
    com.tencent.biz.qqcircle.widgets.comment.f mSoftKeyboardStateHelper;
    private Runnable mTaskReqAssociateRunnable;
    final e mTaskRequestAssociate;
    protected String mTraceId;
    private View mVBg;
    protected SearchEntryFragment searchEntryFragment;
    protected GroupSearchFragment searchFragment;
    private jp2.b searchJumpConfig;
    private QuickPinyinEditText searchText;
    private ThirdAppComponent thirdAppComponent;
    private UniteSearchViewModel viewModel;
    private VoiceSearchComponent voiceComponent;
    public int source = 0;
    public int mFrom = -1;
    public boolean mIsCreateShow = true;
    private boolean canUseVoiceSearchComponent = false;
    private boolean canShowThirdAppComponent = false;
    byte[] cookies = null;
    private u60.c searchPagePerfReporter = new u60.c();
    private int mCurrentFragment = -1;
    protected Handler mHandler = new Handler(Looper.getMainLooper());
    public boolean isNeedShowAssociateLayout = true;
    public boolean isActivityFirstSearch = true;
    private int mResultSourceType = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.search.fragment.UniteSearchFragment$3, reason: invalid class name */
    /* loaded from: classes18.dex */
    public class AnonymousClass3 implements Runnable {
        AnonymousClass3() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void e() {
            FragmentManager fragmentManager;
            if (UniteSearchFragment.this.isAdded() && (fragmentManager = UniteSearchFragment.this.mFragmentManager) != null) {
                fragmentManager.beginTransaction().replace(R.id.cyj, UniteSearchFragment.this.searchFragment).commitAllowingStateLoss();
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (UniteSearchFragment.this.mNeedUpdateBgWhenAnim) {
                UniteSearchFragment uniteSearchFragment = UniteSearchFragment.this;
                uniteSearchFragment.updateLayoutBg(uniteSearchFragment.mVBg, true);
            }
            if (TextUtils.isEmpty(UniteSearchFragment.this.currKeyword)) {
                UniteSearchFragment.this.showFragment(4);
                UniteSearchFragment.this.refreshConfigSearchButtonStatus();
            } else {
                UniteSearchFragment.this.showFragment(3);
            }
            UniteSearchFragment.this.mHandler.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.search.fragment.u
                @Override // java.lang.Runnable
                public final void run() {
                    UniteSearchFragment.AnonymousClass3.this.e();
                }
            }, 200L);
            UniteSearchFragment.this.showInputMethod();
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    class a implements com.tencent.mobileqq.search.business.viewmodel.a {
        a() {
        }

        @Override // com.tencent.mobileqq.search.business.viewmodel.a
        public void a(@NonNull String str, boolean z16, @NonNull String str2, int i3, @NonNull String str3) {
            UniteSearchFragment.this.handleUniteSearchError(str, z16, str2, i3, str3);
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    class b implements com.tencent.mobileqq.search.business.viewmodel.b {
        b() {
        }

        @Override // com.tencent.mobileqq.search.business.viewmodel.b
        public void a(@NonNull String str, boolean z16, @NonNull String str2, @NonNull byte[] bArr, boolean z17, @NonNull List<UfsTabItemGroup> list, @NonNull List<? extends x> list2, int i3, boolean z18, @NonNull wp2.b bVar) {
            String str3;
            if (UniteSearchFragment.this.searchFragment.lastReqTime.equals(str2) && (str3 = UniteSearchFragment.this.currKeyword) != null && str3.equals(str)) {
                if (QLog.isColorLevel()) {
                    QLog.d(UniteSearchFragment.TAG, 2, "handleUniteSearchResult, keyword = " + cq.w(str, 2) + ", isFirstReq = " + z16 + ", reqTime = " + str2 + ", cookie = " + bArr + ", isEnd = " + z17 + ", tabList = " + list + ", result = " + list2.size() + " subId =" + i3);
                }
                UniteSearchFragment.this.preProcessModel(list2);
                if (!z16) {
                    UniteSearchFragment uniteSearchFragment = UniteSearchFragment.this;
                    uniteSearchFragment.cookies = bArr;
                    uniteSearchFragment.searchFragment.setCookie(bArr);
                    UniteSearchFragment.this.searchFragment.onResultSuc(str, z16, bArr, z17, SearchUtil.l(list2, z16), i3, z18, bVar);
                    return;
                }
                if (QLog.isColorLevel()) {
                    QLog.i(UniteSearchFragment.TAG, 2, "handleUniteSearchResult isEnd=" + z17 + " key=" + cq.w(str, 2));
                }
                if (list == null) {
                    UniteSearchFragment.this.handleUniteSearchError(str, z16, str2, -1, "tabList == null");
                    return;
                }
                if (list.size() > 0 && (list.get(0).tabName.equals(HardCodeUtil.qqStr(R.string.uu_)) || (list.get(0).groupMaskList != null && list.get(0).groupMaskList.size() == 0))) {
                    list.remove(0);
                }
                UniteSearchFragment.this.groupSearchResultLayout.setVisibility(0);
                UniteSearchFragment uniteSearchFragment2 = UniteSearchFragment.this;
                uniteSearchFragment2.cookies = bArr;
                uniteSearchFragment2.searchFragment.setCookie(bArr);
                List<v> l3 = SearchUtil.l(list2, z16);
                UniteSearchFragment.this.reportToDC00898(list2);
                UniteSearchFragment.this.searchFragment.onResultSuc(str, z16, bArr, z17, l3, i3, z18, bVar);
                UniteSearchFragment.isNeedRequestAssociation = true;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class c implements QUISearchBar.ActionCallback {
        c() {
        }

        @Override // com.tencent.mobileqq.widget.search.QUISearchBar.ActionCallback
        public boolean onBack() {
            UniteSearchFragment.this.doBackClickReport();
            UniteSearchFragment.this.doOnClickCancelBtn();
            QLog.i(UniteSearchFragment.TAG, 1, "onBack! moveToState(State.HIDE_ALL)");
            UniteSearchFragment.this.voiceComponent.Y(VoiceSearchComponent.Companion.State.HIDE_ALL);
            UniteSearchFragment.this.thirdAppComponent.d();
            return true;
        }

        @Override // com.tencent.mobileqq.widget.search.QUISearchBar.ActionCallback
        public int onCancel() {
            UniteSearchFragment.this.doOnClickCancelBtn();
            return 1;
        }

        @Override // com.tencent.mobileqq.widget.search.QUISearchBar.ActionCallback
        public boolean onClear() {
            com.tencent.mobileqq.search.report.b.e(UniteSearchFragment.this.mApp, 0, UniteSearchFragment.this.mFrom, "0X8009D2B", 0, 0, null, null);
            UniteSearchFragment.this.showInputMethod();
            return false;
        }

        @Override // com.tencent.mobileqq.widget.search.QUISearchBar.ActionCallback
        public void onSearch() {
            if (StudyModeManager.w()) {
                UniteSearchFragment.this.hideInputMethod();
            } else if (TextUtils.isEmpty(UniteSearchFragment.this.currKeyword)) {
                UniteSearchFragment.this.doSearchAction();
            } else if (UniteSearchFragment.this.enableJumpSearchDetailPageNow()) {
                SearchUtil.x(UniteSearchFragment.this.mApp, UniteSearchFragment.this.getContext(), UniteSearchFragment.this.currKeyword, 16, 9);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class d extends ClickableSpan {
        d() {
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            if (UniteSearchFragment.this.getActivity() != null) {
                UniteSearchFragment.this.getActivity().openContextMenu(UniteSearchFragment.this.searchText);
            }
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setUnderlineText(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public static class e {

        /* renamed from: a, reason: collision with root package name */
        public volatile String f283198a;

        /* renamed from: b, reason: collision with root package name */
        public volatile long f283199b;

        e() {
        }
    }

    public UniteSearchFragment() {
        Boolean bool = Boolean.FALSE;
        this.isSoftKeyboardOpenning = bool;
        this.isPaused = bool;
        this.searchJumpConfig = SearchQQMC.INSTANCE.getSearchDirectPageJumpControlConfig();
        this.handleUniteSearchErrorCb = new a();
        this.handlerUniteSearchResultSuccessCb = new b();
        this.lastSearchKeyWord = null;
        this.mTaskRequestAssociate = new e();
        this.mTaskReqAssociateRunnable = new Runnable() { // from class: com.tencent.mobileqq.search.fragment.q
            @Override // java.lang.Runnable
            public final void run() {
                UniteSearchFragment.this.lambda$new$3();
            }
        };
        this.isInitiativeSearch = false;
    }

    private void addVMObservers() {
        this.dataFetchVM.P1(this.handlerUniteSearchResultSuccessCb);
        this.dataFetchVM.O1(this.handleUniteSearchErrorCb);
    }

    private void autoSearch() {
        if (!TextUtils.isEmpty(this.currKeyword)) {
            if (this.currKeyword.length() > 50) {
                this.currKeyword = this.currKeyword.substring(0, 50);
            }
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 2, "\u81ea\u52a8\u641c\u7d22 isViewCreated:" + this.searchFragment.isViewCreated);
            }
            this.searchFragment.needSearchOnLoad = true;
            if (this.mFrom == 4) {
                setSearchForce(6);
            }
        }
    }

    private String changeKeywordForNewDataline(String str) {
        if (com.tencent.mobileqq.filemanager.fileassistant.util.h.p(this.mApp)) {
            if (str.equals(getResources().getString(R.string.f187513u7)) || str.equalsIgnoreCase(getResources().getString(R.string.f187503u6)) || str.equalsIgnoreCase(getResources().getString(R.string.f187493u5))) {
                return getResources().getString(R.string.f187533u9);
            }
            return str;
        }
        return str;
    }

    private void doEnterAnim() {
        com.tencent.mobileqq.search.util.j.k((FrameLayout) this.mRootView, this.mSearchBar, this.mFlContent, new AnonymousClass3());
    }

    private void doRichReport(am amVar) {
        if (amVar == null) {
            return;
        }
        int W = amVar.W();
        if (amVar.c0()) {
            com.tencent.mobileqq.search.report.b.i(this.mApp, this.source, this.mFrom, "0X8009D2C", W, 0, amVar.N);
        } else {
            com.tencent.mobileqq.search.report.b.i(this.mApp, this.source, this.mFrom, "0X8009D40", W, 0, amVar.N);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean doSearchAction() {
        boolean z16;
        String obj = this.searchText.getText().toString();
        AutoHintLayout autoHintLayout = this.autoHintLayout;
        if (autoHintLayout != null && !TextUtils.isEmpty(autoHintLayout.i()) && TextUtils.isEmpty(obj) && !isEqualDefaultHintWords()) {
            z16 = true;
        } else {
            z16 = false;
        }
        String changeKeywordForNewDataline = changeKeywordForNewDataline(tryReplaceKeywordWithHint(obj).trim());
        LogcatUtil.b(changeKeywordForNewDataline);
        if (cg.f307525d.matcher(changeKeywordForNewDataline).matches()) {
            this.currKeyword = changeKeywordForNewDataline;
            this.searchText.performClick();
        }
        if (TextUtils.isEmpty(changeKeywordForNewDataline) && (this.searchText.getTag() instanceof HotWordSearchEntryDataModel.HotSearchItem)) {
            ((ISearchReportApi) QRoute.api(ISearchReportApi.class)).reportUnusedModuleDetection(TAG, "from:" + this.mFrom);
            String str = UniteSearchActivity.f282686d0.recallWord;
            String str2 = ((HotWordSearchEntryDataModel.HotSearchItem) this.searchText.getTag()).jumpUrl;
            if (TextUtils.isEmpty(str2)) {
                SearchUtils.n1("\u540e\u53f0\u6ca1\u6709\u914d\u7f6e\u94fe\u63a5\uff0c\u7ec8\u7aef\u62fc\u63a5\u8df3\u8f6c");
                str2 = w.g(str, 6, "hotword");
            } else {
                SearchUtils.n1("\u540e\u53f0\u914d\u7f6e\u4e86\u94fe\u63a5\uff0c\u4f7f\u7528\u540e\u53f0\u94fe\u63a5\u8df3\u8f6c");
            }
            if (!TextUtils.isEmpty(str2)) {
                ax c16 = bi.c(this.mApp, getActivity(), str2);
                if (c16 != null) {
                    c16.b();
                } else if (SearchUtils.H0(str2)) {
                    ((IRIJJumpUtils) QRoute.api(IRIJJumpUtils.class)).jumpToNativeSearchResultPage(getActivity(), str, str2);
                } else if (!str2.startsWith("http://") && !str2.startsWith("https://")) {
                    if (QLog.isColorLevel()) {
                        QLog.d(TAG, 2, "onEditorAction jumpUrl is illegal");
                    }
                } else {
                    Intent intent = new Intent(getActivity(), (Class<?>) QQBrowserActivity.class);
                    intent.putExtra("url", str2);
                    intent.putExtra("search_title", str);
                    startActivity(intent);
                }
            } else if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "onEditorAction jumpUrl is empty");
            }
            SearchUtils.W0("all_result", "clk_wording", str, String.valueOf(convertFrom2FromType()));
            com.tencent.mobileqq.search.report.b.h(this.mApp, new ReportModelDC02528().module("hot_list").action("clk_default_word").ver2(com.tencent.mobileqq.search.report.b.a(this.mFrom)).ver4(str).ver7("{experiment_id:" + com.tencent.mobileqq.search.report.b.f283718b + "}"));
            SearchUtil.f282611a = true;
            if (this.searchEntryFragment != null) {
                ((cw) ((QQAppInterface) ((IReadInJoyUtils) QRoute.api(IReadInJoyUtils.class)).getAppRuntime()).getManager(QQManagerFactory.SEARCH_WORD_HISTORY_MANAGER)).c(str);
                this.searchEntryFragment.refresh();
            }
            return true;
        }
        if (!TextUtils.isEmpty(changeKeywordForNewDataline)) {
            this.currKeyword = changeKeywordForNewDataline;
            UniteSearchActivity.f282690h0 = changeKeywordForNewDataline;
            if (z16) {
                SearchUtil.x(this.mApp, getContext(), this.currKeyword, 27, 9);
            } else {
                search(changeKeywordForNewDataline, 1);
            }
            com.tencent.mobileqq.search.report.b.h(null, new ReportModelDC02528().module("all_result").action("clk_search_button").ver1(changeKeywordForNewDataline).ver2(com.tencent.mobileqq.search.report.b.a(this.mFrom)).ver3(UniteSearchActivity.f282688f0).ver6(UniteSearchActivity.f282687e0));
        } else if (this.searchText.getTag() instanceof HotWordSearchEntryDataModel.HotSearchItem) {
            String charSequence = this.searchText.getHint().toString();
            this.currKeyword = charSequence;
            UniteSearchActivity.f282690h0 = charSequence;
            this.searchText.setText(charSequence);
            this.searchText.setSelection(charSequence.length());
            ((ISearchReportApi) QRoute.api(ISearchReportApi.class)).reportUnusedModuleDetection(TAG, " HotWordSearch from:" + this.mFrom);
        }
        hideInputMethod();
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean enableJumpSearchDetailPageNow() {
        View view = this.groupSearchResultLayout;
        if (view != null && view.getVisibility() != 0) {
            QLog.w(TAG, 1, "enableJumpSearchDetailPageNow groupSearchResultLayout gone");
            return true;
        }
        if (!this.searchJumpConfig.getEnable()) {
            QLog.w(TAG, 1, "enableJumpSearchDetailPageNow disable qqmc");
            return true;
        }
        if (this.searchJumpConfig.getForceStay()) {
            QLog.w(TAG, 1, "enableJumpSearchDetailPageNow forceStay qqmc");
            return false;
        }
        return !this.searchFragment.hasLocalData;
    }

    private int getKandianTabType(int i3) {
        if (i3 == 1) {
            return 1;
        }
        if (i3 == 2) {
            return 2;
        }
        if (i3 != 21) {
            return 1;
        }
        return 3;
    }

    private Bundle getNotNullArgument() {
        if (getArguments() == null) {
            return Bundle.EMPTY;
        }
        return getArguments();
    }

    @NotNull
    private String getTabType() {
        int i3 = this.mFrom;
        if (i3 == 1) {
            return ISearchEntryFragment.TAB_ID_MESSAGE;
        }
        if (i3 != 2) {
            if (i3 != 21) {
                return ISearchEntryFragment.TAB_ID_MESSAGE;
            }
            return ISearchEntryFragment.TAB_ID_DYNAMIC;
        }
        return ISearchEntryFragment.TAB_ID_CONTACT;
    }

    private void initBottomComponent() {
        ap2.g c16 = com.tencent.mobileqq.search.util.p.f285069a.c();
        if (ap2.f.f26688a.a() && c16 != null) {
            this.canShowThirdAppComponent = true;
            this.thirdAppComponent.setConfig(c16);
            this.thirdAppComponent.setVisibility(0);
            this.voiceComponent.setVisibility(8);
            this.voiceComponent.Y(VoiceSearchComponent.Companion.State.HIDE_ALL);
            return;
        }
        boolean a16 = ap2.a.f26672a.a();
        this.canUseVoiceSearchComponent = a16;
        if (!a16) {
            QLog.i(TAG, 1, "can not useVoiceSearchComponent moveToState(State.HIDE_ALL)");
            this.voiceComponent.Y(VoiceSearchComponent.Companion.State.HIDE_ALL);
        }
    }

    private void initQUISearchBar() {
        this.mSearchBar.setVisibility(0);
        this.mSearchBar.updateStyle(2);
        this.mSearchBar.disableAutoFill();
        int i3 = 1;
        this.mSearchBar.bindSearchChain(true);
        this.mSearchBar.setCustomResource(ar.a());
        this.mSearchBar.setActionCallback(new c());
        isNeedRequestAssociation = false;
        this.cancelButton = this.mSearchBar.getCancelView();
        this.searchText = this.mSearchBar.getInputWidget();
        this.autoHintLayout = this.mSearchBar.getAutoHintLayout();
        this.clearText = this.mSearchBar.getClearView();
        this.mLlOldSearchLayout.setVisibility(8);
        this.searchText.getInputExtras(true).putInt("QUICK_SEARCH", 1);
        this.searchText.removeTextChangedListener(this);
        this.searchText.addTextChangedListener(this);
        ArrayList<String> stringArrayList = getNotNullArgument().getStringArrayList("home_hint_words");
        this.hintWords = stringArrayList;
        if (stringArrayList == null || stringArrayList.isEmpty()) {
            i3 = 0;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("dt_pgid", "pg_search_activation");
        hashMap.put("is_shading", Integer.valueOf(i3));
        if (i3 != 0) {
            this.autoHintLayout.setInterval(5000L);
            this.autoHintLayout.setAnimDuration(400);
            this.autoHintLayout.m(this);
            this.autoHintLayout.setHintList(this.hintWords);
            this.autoHintLayout.setReportDataList(this.hintWords);
            hashMap.put("literal_text", this.hintWords.get(0));
        }
        VideoReport.setElementParams(this.searchText, hashMap);
    }

    private void initViewModel() {
        UniteSearchViewModel uniteSearchViewModel = (UniteSearchViewModel) new ViewModelProvider(this).get(UniteSearchViewModel.class);
        this.viewModel = uniteSearchViewModel;
        uniteSearchViewModel.init(getNotNullArgument());
        this.viewModel.S1(this.mApp);
        this.viewModel.R1().observe(getViewLifecycleOwner(), new Observer() { // from class: com.tencent.mobileqq.search.fragment.t
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                UniteSearchFragment.this.lambda$initViewModel$1((DiscoveryResultData) obj);
            }
        });
    }

    private boolean isEqualDefaultHintWords() {
        AutoHintLayout autoHintLayout = this.autoHintLayout;
        if (autoHintLayout != null && TextUtils.equals(autoHintLayout.i(), getString(R.string.f214055rv))) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$finish$2(Activity activity) {
        hideInputMethod();
        this.searchText.setText("");
        this.searchText.clearFocus();
        Intent intent = activity.getIntent();
        intent.putExtra("keyword", this.currKeyword);
        activity.setResult(this.mRequestCode, intent);
        activity.finish();
        activity.overridePendingTransition(0, R.anim.f155053hw);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initViewModel$1(DiscoveryResultData discoveryResultData) {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "getSearchDiscoveryResult, result " + discoveryResultData);
        }
        int i3 = -1;
        if (discoveryResultData != null) {
            if (discoveryResultData.getIsSuccess()) {
                List<SearchEntryDataModel> d16 = discoveryResultData.d();
                Integer fromType = discoveryResultData.getFromType();
                UnifySearchHandler.a extraData = discoveryResultData.getExtraData();
                if (extraData != null) {
                    if (fromType != null) {
                        i3 = fromType.intValue();
                    }
                    handleSearchDiscoveryResult(d16, i3, extraData);
                    return;
                }
                QLog.e(TAG, 1, "getSearchDiscoveryResult, extraData is null");
                return;
            }
            int resultCode = discoveryResultData.getResultCode();
            String errorMsg = discoveryResultData.getErrorMsg();
            Integer fromType2 = discoveryResultData.getFromType();
            if (fromType2 != null) {
                i3 = fromType2.intValue();
            }
            handleSearchDiscoveryError(resultCode, errorMsg, i3);
            return;
        }
        handleSearchDiscoveryError(-1, null, -1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$3() {
        showFragment(3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showInputMethod$0() {
        if (!shouldShowInputMethod()) {
            QLog.i(TAG, 1, "shouldShowInputMethod false, return 2!");
            return;
        }
        this.searchText.requestFocus();
        InputMethodUtil.show(this.searchText);
        this.searchText.setCursorVisible(true);
    }

    public static UniteSearchFragment newInstance(Context context, Bundle bundle) {
        UniteSearchFragment uniteSearchFragment = new UniteSearchFragment();
        uniteSearchFragment.setArguments(bundle);
        return uniteSearchFragment;
    }

    private void patchRichExtraData(am amVar) {
        if (amVar == null) {
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "patchRichExtraData, source:" + this.source + " from:" + this.mFrom);
        }
        int i3 = this.source;
        if (i3 == 0) {
            int i16 = this.mFrom;
            if (i16 != 1) {
                if (i16 != 2) {
                    if (i16 == 21) {
                        i3 = 3;
                    }
                } else {
                    i3 = 2;
                }
            } else {
                i3 = 1;
            }
        }
        String b16 = com.tencent.mobileqq.search.rich.l.b(i3, amVar.c0(), amVar.N, ThemeUtil.isNowThemeIsNight(this.mApp, false, null));
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "patchRichExtraData, extraData:" + b16);
        }
        amVar.f0(b16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refreshConfigSearchButtonStatus() {
        if (this.mConfigSearchButton != null) {
            if (TextUtils.isEmpty(this.currKeyword) && !(this.searchText.getTag() instanceof HotWordSearchEntryDataModel.HotSearchItem)) {
                this.mConfigSearchButton.setAlpha(0.4f);
            } else {
                this.mConfigSearchButton.setAlpha(1.0f);
            }
        }
    }

    private void removeShowDatas() {
        this.cookies = null;
        if (TextUtils.isEmpty(this.currKeyword)) {
            this.groupSearchResultLayout.setVisibility(4);
        }
        this.searchFragment.resetData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reportToDC00898(List<? extends x> list) {
        List<y> o16;
        String str;
        if (list != null) {
            for (x xVar : list) {
                if (xVar != null && xVar.l() != null && xVar.l().equals(VSConfigManager.f97066i) && (o16 = xVar.o()) != null) {
                    for (y yVar : o16) {
                        if (yVar instanceof lo2.m) {
                            lo2.m mVar = (lo2.m) yVar;
                            QQAppInterface qQAppInterface = this.mApp;
                            if (mVar.getUin() != null) {
                                str = mVar.getUin();
                            } else {
                                str = "";
                            }
                            ReportController.o(qQAppInterface, "dc00898", "", str, "auth_search", "exp", 0, 0, "", "", "", "");
                        }
                    }
                }
            }
        }
    }

    private void setHomeHotWord() {
        showHomeHotWord(nn2.a.i(this.mApp));
    }

    private boolean shouldShowInputMethod() {
        if (!this.isSoftKeyboardOpenning.booleanValue() && !this.isPaused.booleanValue()) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void showFragment(int i3) {
        boolean z16;
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "showFragment  fragment=" + i3);
        }
        if (i3 != this.mCurrentFragment && this.mFragmentManager != null && isAdded()) {
            this.mCurrentFragment = i3;
            FragmentTransaction beginTransaction = this.mFragmentManager.beginTransaction();
            if (i3 != 1) {
                if (i3 != 3) {
                    if (i3 == 4) {
                        com.tencent.mobileqq.search.util.x.l(getActivity(), this.entryLayout, this.source);
                        com.tencent.mobileqq.search.util.u.d(this.cancelButton, this.mLlOldSearchLayout, "pg_search_activation", String.valueOf(this.source));
                        String valueOf = String.valueOf(this.searchText.getHint());
                        ArrayList<String> arrayList = this.hintWords;
                        if (arrayList != null && !arrayList.isEmpty()) {
                            z16 = true;
                        } else {
                            z16 = false;
                        }
                        if (z16) {
                            valueOf = this.autoHintLayout.i();
                        }
                        com.tencent.mobileqq.search.util.u.m(this.searchText, this.mLlOldSearchLayout, valueOf, "pg_search_activation", String.valueOf(this.source), z16);
                        if (this.mFragmentManager.findFragmentByTag(TAG_SEARCH_ENTRY_LAYOUT) == null) {
                            addFragment(i3);
                        }
                        SearchEntryFragment searchEntryFragment = this.searchEntryFragment;
                        if (searchEntryFragment != null) {
                            beginTransaction.show(searchEntryFragment.getFragment());
                            beginTransaction.commitAllowingStateLoss();
                        }
                        this.entryLayout.setVisibility(0);
                        this.associateLayout.setVisibility(8);
                        this.groupSearchResultLayout.setVisibility(8);
                    }
                } else {
                    if (this.mFragmentManager.findFragmentByTag(TAG_ASSOCIATED_WORDS) == null) {
                        addFragment(i3);
                    }
                    AssociateSearchWordsFragment associateSearchWordsFragment = this.mAssociatedFragment;
                    if (associateSearchWordsFragment != null) {
                        beginTransaction.show(associateSearchWordsFragment);
                        beginTransaction.commitAllowingStateLoss();
                        this.entryLayout.setVisibility(8);
                        this.associateLayout.setVisibility(0);
                        this.groupSearchResultLayout.setVisibility(8);
                    }
                }
            } else {
                this.searchPagePerfReporter.c();
                this.entryLayout.setVisibility(8);
                this.associateLayout.setVisibility(8);
                this.groupSearchResultLayout.setVisibility(0);
                com.tencent.mobileqq.search.report.b.e(null, 0, this.mFrom, "0X8009D29", 0, 0, null, null);
                com.tencent.mobileqq.search.util.x.m(getActivity(), this.groupSearchResultLayout, this.source, this.mTraceId, this.currKeyword, this.mResultSourceType);
                com.tencent.mobileqq.search.util.am.h(this.cancelButton, this.mLlOldSearchLayout, "pg_search_result", String.valueOf(this.source), this.mTraceId, this.currKeyword);
                QuickPinyinEditText quickPinyinEditText = this.searchText;
                com.tencent.mobileqq.search.util.am.p(quickPinyinEditText, this.mLlOldSearchLayout, String.valueOf(quickPinyinEditText.getHint()), "pg_search_result", String.valueOf(this.source), this.mTraceId, this.currKeyword);
                com.tencent.mobileqq.search.util.am.q(this.clearText, this.mLlOldSearchLayout, "pg_search_result", String.valueOf(this.source), this.mTraceId, this.currKeyword);
            }
            if (this.groupSearchResultLayout.getVisibility() == 0) {
                QLog.i(TAG, 1, "disableComponent");
                this.voiceComponent.L();
            } else {
                QLog.i(TAG, 1, "enableComponent");
                this.voiceComponent.N();
            }
        }
    }

    public static void startPadLogic(Context context, Bundle bundle) {
        com.tencent.mobileqq.pad.i.e(context, bundle, UniteSearchFragment.class, new com.tencent.mobileqq.pad.b().e(false).g(false).h(LaunchMode.singleTop).a());
    }

    private void tryFillHintWord(CircleSearchExhibition$UnifySearchResultExt circleSearchExhibition$UnifySearchResultExt) {
        if (circleSearchExhibition$UnifySearchResultExt != null && circleSearchExhibition$UnifySearchResultExt.shading_prompt.has() && this.autoHintLayout != null) {
            u60.a aVar = new u60.a(circleSearchExhibition$UnifySearchResultExt.shading_prompt.get(), false);
            this.autoHintLayout.m(this);
            this.autoHintLayout.setInterval(aVar.b());
            this.autoHintLayout.setReportDataList(aVar.c());
            this.autoHintLayout.setHintList(aVar.a());
        }
    }

    private String tryReplaceKeywordWithHint(String str) {
        AutoHintLayout autoHintLayout = this.autoHintLayout;
        if (autoHintLayout != null && !TextUtils.isEmpty(autoHintLayout.i()) && !isEqualDefaultHintWords() && TextUtils.isEmpty(str)) {
            this.isSearchXsjHint = true;
            return this.autoHintLayout.i();
        }
        return str;
    }

    private void updateBgAndStatus() {
        this.mFlContent = (FrameLayout) this.mRootView.findViewById(R.id.fid);
        this.mSearchBar = (QUISearchBar) this.mRootView.findViewById(R.id.search_box);
        this.mLlOldSearchLayout = (LinearLayout) this.mRootView.findViewById(R.id.ik9);
        View findViewById = this.mRootView.findViewById(R.id.iit);
        this.mVBg = findViewById;
        updateLayoutBg(findViewById, false);
        updateInitLayout();
    }

    private void updateInitLayout() {
        int i3;
        int dip2px;
        if (getQBaseActivity() == null) {
            QLog.w(TAG, 1, "activity is null");
            return;
        }
        ImmersiveTitleBar2 immersiveTitleBar2 = (ImmersiveTitleBar2) this.mRootView.findViewById(R.id.jo9);
        boolean isSupportImmersive = ImmersiveUtils.isSupportImmersive();
        int statusBarHeight = RFWImmersiveUtils.getStatusBarHeight();
        if (statusBarHeight <= 0) {
            statusBarHeight = ViewUtils.dpToPx(44.0f);
            QLog.e(TAG, 1, "stRealHeight is illegal, set to default" + statusBarHeight);
        }
        if (isSupportImmersive) {
            i3 = statusBarHeight;
        } else {
            i3 = 0;
        }
        Bitmap bitmap = com.tencent.mobileqq.search.util.j.f285047a.get();
        int dip2px2 = ViewUtils.dip2px(60.0f) + i3;
        QLog.i(TAG, 2, "state H:" + i3 + ", fl height:" + dip2px2 + " isImmersive:" + isSupportImmersive + " , stRealHeight:" + statusBarHeight);
        immersiveTitleBar2.setCustomHeight(dip2px2);
        View view = this.mVBg;
        if (bitmap != null) {
            dip2px = bitmap.getHeight();
        } else {
            dip2px = ViewUtils.dip2px(50.0f) + i3;
        }
        updateTopMargin(view, Math.min(dip2px2, dip2px));
        updateTopMargin(this.mFlContent, dip2px2);
        updateTopMargin(this.mSearchBar, i3);
        updateTopMargin(this.mLlOldSearchLayout, i3);
        this.mSearchBar.setVisibility(0);
        this.mLlOldSearchLayout.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateLayoutBg(@NonNull View view, boolean z16) {
        int i3 = R.drawable.qui_common_bg_bottom_light_bg;
        try {
            if (z16) {
                if (!z.e()) {
                    i3 = R.drawable.qui_common_bg_bottom_standard_bg;
                }
                view.setBackgroundResource(i3);
                return;
            }
            if (!QQTheme.isVasTheme() && aq.a()) {
                QUISearchBar qUISearchBar = this.mSearchBar;
                if (qUISearchBar != null) {
                    this.mNeedUpdateBgWhenAnim = true;
                    view.setBackground(qUISearchBar.getBackground());
                    return;
                } else {
                    if (!z.e()) {
                        i3 = R.drawable.qui_common_bg_bottom_standard_bg;
                    }
                    view.setBackgroundResource(i3);
                    return;
                }
            }
            view.setBackgroundResource(R.drawable.bg_texture_theme_version2);
        } catch (Exception e16) {
            QLog.e(TAG, 1, "doOnCreate, e = " + QLog.getStackTraceString(e16));
        }
    }

    private void updateTopMargin(View view, int i3) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        marginLayoutParams.topMargin = i3;
        view.setLayoutParams(marginLayoutParams);
    }

    public void addAssociateTask(String str, long j3) {
        this.mHandler.removeCallbacks(this.mTaskReqAssociateRunnable);
        this.mHandler.postDelayed(this.mTaskReqAssociateRunnable, j3);
        this.mTaskRequestAssociate.f283198a = str;
        this.mTaskRequestAssociate.f283199b = System.currentTimeMillis() + j3;
    }

    void addFragment(int i3) {
        FragmentTransaction beginTransaction = this.mFragmentManager.beginTransaction();
        if (i3 != 3) {
            if (i3 == 4 && this.searchEntryFragment == null) {
                String tabType = getTabType();
                this.searchEntryFragment = new SearchEntryFragment();
                Bundle bundle = new Bundle();
                bundle.putStringArrayList(SearchEntryFragment.KEY_SHADING_WORDS, this.hintWords);
                this.searchEntryFragment.setArguments(bundle);
                this.searchEntryFragment.searchPagePerfReporter = this.searchPagePerfReporter;
                com.tencent.mobileqq.search.report.b.h(this.mApp, new ReportModelDC02528().module("all_result").action("exp_entryweb").ver2(com.tencent.mobileqq.search.report.b.a(this.mFrom)).session_id(this.mApp.getCurrentAccountUin() + System.currentTimeMillis()));
                this.searchEntryFragment.setApp(this.mApp);
                Bundle bundle2 = new Bundle(9);
                bundle2.putInt("from", this.mFrom);
                bundle2.putInt("source", this.source);
                bundle2.putString("tabType", tabType);
                this.searchEntryFragment.setInitData(bundle2);
                beginTransaction.add(R.id.f165105by1, this.searchEntryFragment.getFragment(), TAG_SEARCH_ENTRY_LAYOUT);
                beginTransaction.commitAllowingStateLoss();
                if (z.d()) {
                    this.mLlOldSearchLayout.setBackgroundResource(R.drawable.qui_common_bg_bottom_light_bg);
                }
                this.entryLayout.setVisibility(0);
                return;
            }
            return;
        }
        if (this.mAssociatedFragment == null) {
            this.mAssociatedFragment = new AssociateSearchWordsFragment();
        }
        beginTransaction.add(R.id.f164502zy, this.mAssociatedFragment, TAG_ASSOCIATED_WORDS);
        beginTransaction.commitAllowingStateLoss();
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        if (!isAdded()) {
            return;
        }
        SearchEntryFragment searchEntryFragment = this.searchEntryFragment;
        if (searchEntryFragment != null) {
            searchEntryFragment.afterTextChanged(editable);
        }
        String changeKeywordForNewDataline = changeKeywordForNewDataline(removeSelectedSpan(this.searchText, this.mIsDeleteAction, this.mBeforeText));
        if (this.mIsDeleteAction && changeKeywordForNewDataline.equals(this.currKeyword)) {
            return;
        }
        if (this.searchFragment.forceRequestStatus != 6) {
            this.isInitiativeSearch = true;
        }
        if (TextUtils.isEmpty(UniteSearchActivity.f282688f0)) {
            UniteSearchActivity.f282688f0 = this.mApp.getAccount() + System.currentTimeMillis();
        }
        if (this.searchText.isInputtingPinYin()) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "\u6b63\u5728\u8f93\u5165\u62fc\u97f3\uff0c\u4e0d\u89e6\u53d1\u6587\u672c\u53d8\u52a8\u903b\u8f91\u3002 keyword=" + changeKeywordForNewDataline);
                return;
            }
            return;
        }
        this.currKeyword = changeKeywordForNewDataline;
        UniteSearchActivity.f282690h0 = changeKeywordForNewDataline;
        this.searchFragment.keyword = changeKeywordForNewDataline;
        String str = this.mHotSearchKeyWord;
        if (str == null || !str.equals(changeKeywordForNewDataline)) {
            setResultSourceType(0);
            setHotSearchKeyWord(null);
            setHotSearchKeyWordId(null);
        }
        if (TextUtils.isEmpty(changeKeywordForNewDataline)) {
            if (this.canUseVoiceSearchComponent && this.isSoftKeyboardOpenning.booleanValue()) {
                QLog.i(TAG, 1, "afterTextChanged! moveToState(State.SHOW_ENTRY)");
                this.voiceComponent.N();
                this.voiceComponent.Y(VoiceSearchComponent.Companion.State.SMALL_VOICE_INPUT_BAR);
            }
            if (this.canShowThirdAppComponent && this.isSoftKeyboardOpenning.booleanValue()) {
                this.thirdAppComponent.l();
            }
            SearchUtils.W0("home_page", "exp_home", "" + convertFromForReport(this.mFrom));
            ImageView imageView = this.clearText;
            if (imageView != null) {
                imageView.setVisibility(8);
            }
            removeShowDatas();
            this.searchFragment.clearSearchResult();
            refreshConfigSearchButtonStatus();
            AssociateSearchWordsFragment associateSearchWordsFragment = this.mAssociatedFragment;
            if (associateSearchWordsFragment != null) {
                associateSearchWordsFragment.uh(null);
            }
            if (UniteSearchActivity.f282685c0) {
                UniteSearchActivity.f282685c0 = false;
                SearchEntryFragment searchEntryFragment2 = this.searchEntryFragment;
                if (searchEntryFragment2 != null) {
                    searchEntryFragment2.refresh();
                }
            }
            showSearchHistory(true);
        } else {
            QLog.i(TAG, 1, "afterTextChanged! Hide()");
            if (this.isSoftKeyboardOpenning.booleanValue()) {
                this.voiceComponent.setTextInputMode(true);
            }
            this.voiceComponent.Y(VoiceSearchComponent.Companion.State.HIDE_ALL);
            this.thirdAppComponent.d();
            this.mTraceId = com.tencent.mobileqq.search.util.x.k();
            com.tencent.mobileqq.search.util.x.m(getActivity(), this.groupSearchResultLayout, this.source, this.mTraceId, this.currKeyword, this.mResultSourceType);
            com.tencent.mobileqq.search.util.x.a(this.groupSearchResultLayout, this.isSearchXsjHint ? 1 : 0);
            this.searchFragment.traceId = this.mTraceId;
            this.isSearchXsjHint = false;
            SearchEnginePerfReporter.u(changeKeywordForNewDataline, this.mFrom, this.isActivityFirstSearch);
            this.isActivityFirstSearch = false;
            ImageView imageView2 = this.clearText;
            if (imageView2 != null) {
                imageView2.setVisibility(0);
            }
            refreshConfigSearchButtonStatus();
            if (this.searchEntryFragment != null) {
                search(changeKeywordForNewDataline);
                showSearchHistory(false);
            } else if (!this.isNeedShowAssociateLayout) {
                isNeedRequestAssociation = true;
                search(changeKeywordForNewDataline);
            } else {
                addAssociateTask(changeKeywordForNewDataline, 0L);
            }
        }
        if (!changeKeywordForNewDataline.equals(this.currKeyword)) {
            SearchUtils.f284957f = 0L;
            mIsVsResultInvalidType = 2;
        }
        if (!TextUtils.isEmpty(this.lastSearchKeyWord)) {
            showSearchHistory(TextUtils.isEmpty(changeKeywordForNewDataline));
        }
        AssociateSearchWordsFragment associateSearchWordsFragment2 = this.mAssociatedFragment;
        if (associateSearchWordsFragment2 != null) {
            associateSearchWordsFragment2.uh(null);
        }
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
        if (!isAdded()) {
            return;
        }
        boolean z16 = false;
        if (TextUtils.isEmpty(charSequence) && i3 == 0 && i16 == 0 && this.isFirstInGroupSearch) {
            this.isFirstInGroupSearch = false;
            b.a.a();
            b.a.f443724m = System.nanoTime();
        }
        if (i17 == 0) {
            z16 = true;
        }
        this.mIsDeleteAction = z16;
        this.mBeforeText = "" + ((Object) charSequence);
    }

    public void changeText(String str, boolean z16, boolean z17) {
        if (this.searchText == null || TextUtils.isEmpty(str)) {
            return;
        }
        if (z17) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
            spannableStringBuilder.setSpan(new BackgroundColorSpan(858244351), 0, str.length(), 33);
            spannableStringBuilder.setSpan(new d(), 0, str.length(), 33);
            this.searchText.setMovementMethod(LinkMovementMethod.getInstance());
            if (z16) {
                this.searchText.setText(spannableStringBuilder);
            } else {
                this.searchText.removeTextChangedListener(this);
                this.searchText.setText(spannableStringBuilder);
                this.searchText.addTextChangedListener(this);
                this.clearText.setVisibility(0);
                refreshConfigSearchButtonStatus();
                removeShowDatas();
                showFragment(4);
            }
        } else if (z16) {
            this.searchText.setText(str);
        } else {
            this.searchText.removeTextChangedListener(this);
            this.searchText.setText(str);
            this.searchText.addTextChangedListener(this);
        }
        this.searchText.setSelection(str.length());
    }

    public int convertFrom2FromType() {
        int i3 = this.mFrom;
        if (i3 == 21) {
            return 3;
        }
        return i3;
    }

    public int convertFromForReport(int i3) {
        if (i3 != 21) {
            return i3;
        }
        return 3;
    }

    protected void dealSearchTextView(TextView textView) {
        Context context = textView.getContext();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) textView.getLayoutParams();
        int dpToPx = ViewUtils.dpToPx(12.0f);
        int dpToPx2 = ViewUtils.dpToPx(30.0f);
        int dpToPx3 = ViewUtils.dpToPx(5.0f);
        int dpToPx4 = ViewUtils.dpToPx(5.0f);
        if (QQTheme.isNowSimpleUI()) {
            textView.setCompoundDrawablePadding(ViewUtils.dpToPx(4.0f));
            textView.setTextSize(0, ViewUtils.dpToPx(14.0f));
            textView.setTextColor(context.getResources().getColor(R.color.skin_color_ff000000));
            textView.setHintTextColor(context.getResources().getColor(R.color.skin_color_ff999999));
            dpToPx = ViewUtils.dpToPx(16.0f);
            textView.setPadding(dpToPx, dpToPx3, dpToPx2, dpToPx4);
            layoutParams.rightMargin = ViewUtils.dpToPx(14.0f);
        } else {
            textView.setCompoundDrawablePadding(ViewUtils.dpToPx(5.0f));
            textView.setTextSize(0, ViewUtils.dpToPx(16.0f));
            textView.setTextColor(context.getResources().getColor(R.color.skin_input_theme_version2));
            textView.setHintTextColor(context.getResources().getColor(R.color.skin_hint_input_theme_version2));
            textView.setPadding(dpToPx, dpToPx3, dpToPx2, dpToPx4);
            layoutParams.rightMargin = ViewUtils.dpToPx(12.0f);
        }
        if (SimpleUIUtil.isNowElderMode()) {
            layoutParams.height = ViewUtils.dpToPx(44.0f);
            textView.setPadding(dpToPx, 0, dpToPx2, 0);
            textView.setTextSize(1, 18.0f);
            textView.setCompoundDrawablesWithIntrinsicBounds(R.drawable.o2z, 0, 0, 0);
            ((RelativeLayout.LayoutParams) this.cancelButton.getLayoutParams()).height = ViewUtils.dpToPx(44.0f);
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.clearText.getLayoutParams();
            layoutParams2.height = ViewUtils.dpToPx(44.0f);
            layoutParams2.width = ViewUtils.dpToPx(44.0f);
            if (!QQTheme.isNowThemeIsNight()) {
                this.clearText.setImageResource(R.drawable.kwc);
            }
        }
        if (aq.a() || z.d()) {
            Drawable drawable = getResources().getDrawable(R.drawable.qui_search_icon_secondary_01);
            int dip2px = ViewUtils.dip2px(16.0f);
            drawable.setBounds(0, 0, dip2px, dip2px);
            textView.setCompoundDrawables(drawable, null, null, null);
            textView.setBackground(getResources().getDrawable(R.drawable.qui_common_bg_bottom_standard_bg_corner_4));
            textView.setHintTextColor(getResources().getColorStateList(R.color.qui_common_text_secondary));
            textView.setTextColor(getResources().getColorStateList(R.color.qui_common_text_primary));
        }
    }

    public void doBackClickReport() {
        com.tencent.mobileqq.search.report.b.h(null, new ReportModelDC02528().module("search_box_back").action("clk_search_box_back").ver2(TabPreloadItem.TAB_NAME_KANDIAN).session_id(this.mApp.getCurrentAccountUin()));
        new UniteSearchHandler(this.mApp).H2(this.mApp, "clk_search_box_back", "search_box_back", TabPreloadItem.TAB_NAME_KANDIAN, "", "", "");
    }

    protected void doOnClickCancelBtn() {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "cancelType-2 ResultModule:" + rn2.d.c());
        }
        View view = this.groupSearchResultLayout;
        if (view != null && view.getVisibility() == 0) {
            com.tencent.mobileqq.search.report.b.e(this.mApp, 0, this.mFrom, "0X8009D2A", 0, 0, null, null);
        } else {
            com.tencent.mobileqq.search.report.b.e(this.mApp, 0, this.mFrom, "0X8009D17", 0, 0, null, null);
        }
        com.tencent.mobileqq.search.report.b.h(this.mApp, new ReportModelDC02528().module("all_result").action("cancel").ver1(getSearchKeyword()).ver2(com.tencent.mobileqq.search.report.b.a(this.mFrom)).ver3(UniteSearchActivity.f282688f0).ver6(UniteSearchActivity.f282687e0).session_id(this.mApp.getCurrentAccountUin() + System.currentTimeMillis()));
        com.tencent.mobileqq.search.util.u.b(this.cancelButton);
        finish();
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment
    public /* bridge */ /* synthetic */ boolean doOnKeyDown(int i3, KeyEvent keyEvent) {
        return com.tencent.biz.richframework.compat.f.b(this, i3, keyEvent);
    }

    public boolean finish() {
        mIsVsResultInvalidType = 0;
        final FragmentActivity activity = getActivity();
        if (activity == null) {
            return false;
        }
        com.tencent.mobileqq.search.report.b.h(this.mApp, new ReportModelDC02528().module("all_result").action("return").ver1(getSearchKeyword()).ver2(com.tencent.mobileqq.search.report.b.a(this.mFrom)).ver3(UniteSearchActivity.f282688f0).ver6(UniteSearchActivity.f282687e0).session_id(this.mApp.getCurrentAccountUin() + System.currentTimeMillis()));
        if (!(activity instanceof UniteSearchActivity)) {
            hideInputMethod();
            Bundle bundle = new Bundle();
            bundle.putString("keyword", this.currKeyword);
            getParentFragmentManager().setFragmentResult(this.mFragRequestCode, bundle);
            if (!isStateSaved()) {
                activity.onKeyDown(4, new KeyEvent(0, 4));
            } else {
                this.mIsWaitToFinish = true;
            }
            return true;
        }
        if (this.mNeedUpdateBgWhenAnim) {
            updateLayoutBg(this.mVBg, false);
        }
        com.tencent.mobileqq.search.util.j.l((FrameLayout) this.mRootView, this.mSearchBar, this.mFlContent, new Runnable() { // from class: com.tencent.mobileqq.search.fragment.r
            @Override // java.lang.Runnable
            public final void run() {
                UniteSearchFragment.this.lambda$finish$2(activity);
            }
        });
        return true;
    }

    @Override // nn2.b
    public long[] getCurrentPageMasks() {
        return new long[0];
    }

    public long[] getCurrentPageResultMasks() {
        return new long[0];
    }

    @Override // nn2.b
    public int getCurrentPageType() {
        return 1;
    }

    @Override // nn2.b
    public QBaseFragment getCurrentSearchFragment() {
        return this.searchFragment;
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        ArrayList<Class> arrayList = new ArrayList<>();
        arrayList.add(UpdateSearchHintEvent.class);
        arrayList.add(GroupSearchEvent.class);
        arrayList.add(UniteSearchEvent.class);
        arrayList.add(JumpBusinessSearchEntryEvent.class);
        return arrayList;
    }

    @Override // com.tencent.mobileqq.search.m
    public double getLat() {
        return 0.0d;
    }

    protected int getLayoutId() {
        return R.layout.c2e;
    }

    @Override // com.tencent.mobileqq.search.m
    public double getLon() {
        return 0.0d;
    }

    @Override // nn2.b
    public String getSearchKeyword() {
        return this.searchText.getText().toString();
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* bridge */ /* synthetic */ ViewModel getViewModel(ViewModelStoreOwner viewModelStoreOwner, String str, @NonNull Class cls) {
        return ne0.a.a(this, viewModelStoreOwner, str, cls);
    }

    public void handleSearchDiscoveryResult(List<SearchEntryDataModel> list, int i3, @NonNull UnifySearchHandler.a aVar) {
        if (i3 != convertFrom2FromType()) {
            return;
        }
        SearchEntryFragment searchEntryFragment = this.searchEntryFragment;
        if (searchEntryFragment != null) {
            searchEntryFragment.refreshDataModels(list);
        }
        tryFillHintWord(aVar.f195174a);
    }

    public void handleUniteSearchError(String str, boolean z16, String str2, int i3, String str3) {
        if (!this.searchFragment.lastReqTime.equals(str2) || !this.currKeyword.equals(str)) {
            return;
        }
        this.searchFragment.onResultError(str, i3, str3);
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "handleUniteSearchError resultCode=" + i3 + " key=" + str);
        }
        this.groupSearchResultLayout.setVisibility(0);
    }

    public void hideInputMethod() {
        InputMethodUtil.hide(this.searchText);
        this.searchText.clearFocus();
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment
    public /* bridge */ /* synthetic */ void initWindowStyleAndAnimation(Activity activity) {
        com.tencent.biz.richframework.compat.f.c(this, activity);
    }

    @Override // nn2.b
    public boolean isInitiativeSearch() {
        return this.isInitiativeSearch;
    }

    @Override // nn2.b
    public boolean isInputPinyin() {
        QuickPinyinEditText quickPinyinEditText = this.searchText;
        if (quickPinyinEditText == null) {
            return false;
        }
        return quickPinyinEditText.isInputtingPinYin();
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment
    public /* bridge */ /* synthetic */ boolean isSupportScreenShot() {
        return com.tencent.biz.richframework.compat.f.d(this);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment
    public /* bridge */ /* synthetic */ boolean isWrapContent() {
        return com.tencent.biz.richframework.compat.f.e(this);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment
    public /* bridge */ /* synthetic */ boolean needImmersive() {
        return com.tencent.biz.richframework.compat.f.f(this);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment
    public /* bridge */ /* synthetic */ boolean needStatusTrans() {
        return com.tencent.biz.richframework.compat.f.g(this);
    }

    protected GroupSearchFragment newSearchFragment() {
        try {
            Bundle notNullArgument = getNotNullArgument();
            this.mFrom = notNullArgument.getInt(IProfileCardConst.KEY_FROM_TYPE, -1);
            this.source = notNullArgument.getInt("source", 0);
        } catch (Exception e16) {
            QLog.d(TAG, 1, e16, new Object[0]);
        }
        return GroupSearchFragment.newInstance(this.mFrom, this.source);
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityResult(int i3, int i16, @Nullable Intent intent) {
        String stringExtra;
        List<M> list;
        this.mRequestCode = i3;
        GroupSearchFragment groupSearchFragment = this.searchFragment;
        if (groupSearchFragment != null && (list = groupSearchFragment.mResultList) != 0 && list.size() > 0) {
            hideInputMethod();
        }
        if (i3 == 1300) {
            if (-1 == i16 && intent != null && (stringExtra = intent.getStringExtra("roomId")) != null) {
                TroopUtils.e(getActivity(), stringExtra, true);
                ReportController.o(this.mApp, "CliOper", "", "", "0X8006360", "0X8006360", 0, 0, "", "", "", "");
                return;
            }
            return;
        }
        if (i3 == 21011) {
            if (-1 == i16 && intent != null) {
                String stringExtra2 = intent.getStringExtra("keyword");
                if (!TextUtils.isEmpty(stringExtra2)) {
                    this.searchText.setText(stringExtra2);
                    this.searchText.setSelection(stringExtra2.length());
                    search(stringExtra2);
                    hideInputMethod();
                    return;
                }
                return;
            }
            return;
        }
        if (i3 == 10000) {
            SearchEntryFragment searchEntryFragment = this.searchEntryFragment;
            if (searchEntryFragment != null) {
                searchEntryFragment.refresh();
            }
            this.searchText.setText("");
        }
    }

    @Override // com.tencent.mobileqq.search.fragment.AssociateSearchWordsFragment.d
    public void onAssociateWordClick(String str, int i3) {
        if (!TextUtils.isEmpty(str)) {
            this.currKeyword = str;
            ReportModelDC02528 ver6 = new ReportModelDC02528().module("all_result").action("clk_thinkword_list").ver1(getSearchKeyword()).ver2(com.tencent.mobileqq.search.report.b.a(this.mFrom)).ver3(UniteSearchActivity.f282688f0).ver6(UniteSearchActivity.f282687e0);
            StringBuilder sb5 = new StringBuilder();
            sb5.append("{\"clk_index\":");
            sb5.append(i3 - 1);
            sb5.append(",\"experiment_id\":");
            sb5.append(com.tencent.mobileqq.search.report.b.f283718b);
            sb5.append("}");
            com.tencent.mobileqq.search.report.b.h(null, ver6.ver7(sb5.toString()).ver4(str));
            this.searchText.removeTextChangedListener(this);
            this.searchText.setText(str);
            ImageView imageView = this.clearText;
            if (imageView != null) {
                imageView.setVisibility(0);
            }
            refreshConfigSearchButtonStatus();
            this.searchText.addTextChangedListener(this);
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "onAssociateWordClick keyword = " + str);
            }
            this.searchText.setSelection(str.length());
            search(str, 2);
        }
        hideInputMethod();
    }

    @Override // com.tencent.mobileqq.search.fragment.AssociateSearchWordsFragment.d
    public void onAssociateWordInput(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.currKeyword = str;
            this.searchText.setText(str);
            ImageView imageView = this.clearText;
            if (imageView != null) {
                imageView.setVisibility(0);
            }
            refreshConfigSearchButtonStatus();
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "onAssociateWordClick keyword = " + str);
            }
            this.searchText.setSelection(str.length());
        }
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.dataFetchVM = (SearchDataFetchViewModel) new ViewModelProvider(this).get(SearchDataFetchViewModel.class);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.searchPagePerfReporter.c();
        if (TextUtils.isEmpty(com.tencent.mobileqq.search.util.f.b().c())) {
            SearchUtils.n1("\u8fd8\u6ca1\u62c9\u5230\u6c47\u5ddd\u914d\u7f6e\uff0c\u518d\u91cd\u542f\u4e00\u4e0b\u624bQ");
        } else {
            SearchUtils.n1("\u62c9\u5230\u914d\u7f6e\u4e86\uff0c\u83bd\u5427");
        }
        GroupSearchFragment newSearchFragment = newSearchFragment();
        this.searchFragment = newSearchFragment;
        newSearchFragment.searchPagePerfReporter = this.searchPagePerfReporter;
        this.mApp = (QQAppInterface) MobileQQ.sMobileQQ.peekAppRuntime();
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View view;
        SearchEntryFragment searchEntryFragment;
        View view2 = this.mRootView;
        if (view2 != null) {
            if (view2.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.mRootView.getParent()).removeView(this.mRootView);
            }
            view = this.mRootView;
        } else {
            this.mRootView = layoutInflater.inflate(getLayoutId(), viewGroup, false);
            com.tencent.biz.qqcircle.widgets.comment.f fVar = new com.tencent.biz.qqcircle.widgets.comment.f(this.mRootView);
            this.mSoftKeyboardStateHelper = fVar;
            fVar.a(this);
            SearchUtil.B();
            Bundle notNullArgument = getNotNullArgument();
            z.c();
            this.mRequestCode = notNullArgument.getInt("requestCode", 0);
            this.mFragRequestCode = notNullArgument.getString("requestFragCode", "");
            mIsVsResultInvalidType = -1;
            this.mFragmentManager = getChildFragmentManager();
            int kandianTabType = getKandianTabType(this.mFrom);
            if (kandianTabType != -1) {
                UniteSearchActivity.f282687e0 = kandianTabType + "_" + this.mApp.getAccount() + "_" + System.currentTimeMillis();
            } else {
                UniteSearchActivity.f282687e0 = "";
            }
            updateBgAndStatus();
            initViewModel();
            initQUISearchBar();
            this.currKeyword = notNullArgument.getString("keyword");
            HotWordSearchEntryDataModel.HotSearchItem hotSearchItem = (HotWordSearchEntryDataModel.HotSearchItem) notNullArgument.getSerializable("home_hot_word");
            if (hotSearchItem != null && !TextUtils.isEmpty(hotSearchItem.title)) {
                UniteSearchActivity.f282686d0 = hotSearchItem;
                setHomeHotWord();
                SearchUtils.W0("home_page", "hot_list", UniteSearchActivity.f282686d0.title, String.valueOf(convertFrom2FromType()));
            }
            DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
            SearchUtils.W0("home_page", "active_search", "" + convertFromForReport(this.mFrom), displayMetrics.widthPixels + "*" + displayMetrics.heightPixels);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("project", com.tencent.mobileqq.search.report.b.c());
                jSONObject.put("event_src", "client");
                jSONObject.put(QAdVrReportParams.ParamKey.EXPERIMENT_ID, com.tencent.mobileqq.search.report.b.f283718b);
            } catch (JSONException e16) {
                QLog.e(TAG, 2, "e = " + e16);
            }
            com.tencent.mobileqq.search.report.b.h(this.mApp, new ReportModelDC02528().module("all_result").action("active_search").ver2(com.tencent.mobileqq.search.report.b.a(this.mFrom)).ver7(jSONObject.toString()).session_id(this.mApp.getCurrentAccountUin() + System.currentTimeMillis()));
            if (TextUtils.isEmpty(this.currKeyword)) {
                SearchUtils.W0("home_page", "exp_home", "" + convertFromForReport(this.mFrom));
            }
            SearchUtils.f284955d = System.currentTimeMillis();
            if (this.mFrom == 12) {
                this.searchText.setHint(String.format(getResources().getString(R.string.e0k), ((IPublicAccountConfigUtil) QRoute.api(IPublicAccountConfigUtil.class)).getSubscriptName(this.mApp, getContext())));
            }
            String f16 = ac.f(this.mApp);
            this.lastSearchKeyWord = f16;
            if (!TextUtils.isEmpty(f16) && this.mFrom != 12 && (searchEntryFragment = this.searchEntryFragment) != null) {
                searchEntryFragment.refresh();
            }
            this.isFirstInGroupSearch = true;
            this.entryLayout = this.mRootView.findViewById(R.id.f165105by1);
            this.associateLayout = this.mRootView.findViewById(R.id.f164502zy);
            this.groupSearchResultLayout = this.mRootView.findViewById(R.id.cyj);
            this.thirdAppComponent = (ThirdAppComponent) this.mRootView.findViewById(R.id.f96515hw);
            VoiceSearchComponent voiceSearchComponent = (VoiceSearchComponent) this.mRootView.findViewById(R.id.f1201178o);
            this.voiceComponent = voiceSearchComponent;
            voiceSearchComponent.F(this);
            this.voiceComponent.setTextInputMode(true);
            this.voiceComponent.setPageId("pg_search_activation");
            this.thirdAppComponent.setPageId("pg_search_activation");
            initBottomComponent();
            QuickPinyinEditText quickPinyinEditText = this.searchText;
            quickPinyinEditText.mMaxTextLen = 50;
            quickPinyinEditText.setFilters(new InputFilter[]{new InputFilter.LengthFilter(50)});
            this.viewModel.U1(this.mApp);
            autoSearch();
            view = this.mRootView;
        }
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, view);
        return view;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        z.f(null);
        this.mHandler.removeCallbacksAndMessages(null);
        com.tencent.mobileqq.search.util.o.a().c();
        SearchUtils.f284962k = null;
        mIsVsResultInvalidType = -1;
        GroupSearchFragment groupSearchFragment = this.searchFragment;
        if (groupSearchFragment != null) {
            groupSearchFragment.destroyEngine();
        }
        UniteSearchActivity.f282690h0 = "";
        hideInputMethod();
        SearchUtils.h();
        RichNodeController.e();
        SimpleEventBus.getInstance().unRegisterReceiver(this);
        AutoHintLayout autoHintLayout = this.autoHintLayout;
        if (autoHintLayout != null) {
            autoHintLayout.u(this);
        }
        this.voiceComponent.Z();
        this.thirdAppComponent.f();
    }

    @Override // android.widget.TextView.OnEditorActionListener
    public boolean onEditorAction(TextView textView, int i3, KeyEvent keyEvent) {
        boolean z16;
        if (i3 != 3 && (keyEvent == null || keyEvent.getKeyCode() != 66)) {
            z16 = false;
        } else {
            z16 = true;
            if (keyEvent == null || keyEvent.getAction() == 1) {
                doSearchAction();
            }
        }
        EventCollector.getInstance().onEditorAction(textView, i3, keyEvent);
        return z16;
    }

    @Override // com.tencent.mobileqq.search.view.AutoHintLayout.b
    public void onHintChange(int i3, String str, String str2) {
        if (TextUtils.isEmpty(this.searchText.getText()) && this.mCurrentFragment == 4) {
            com.tencent.mobileqq.search.util.u.c(this.searchText, str);
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    @Deprecated
    public /* bridge */ /* synthetic */ void onPartTimeCostReport(String str, String str2, long j3) {
        ne0.a.e(this, str, str2, j3);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        this.isPaused = Boolean.TRUE;
        SearchUtils.f284955d = -1L;
        RichNodeController.f();
        ApngImage.pauseByTag(41);
        hideInputMethod();
        AutoHintLayout autoHintLayout = this.autoHintLayout;
        if (autoHintLayout != null) {
            autoHintLayout.s();
        }
        this.voiceComponent.a0();
        this.thirdAppComponent.h();
        this.mSoftKeyboardStateHelper.s(this);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public /* bridge */ /* synthetic */ void onPostThemeChanged() {
        com.tencent.biz.richframework.compat.f.k(this);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment
    public /* bridge */ /* synthetic */ void onPreThemeChanged() {
        com.tencent.biz.richframework.compat.f.l(this);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        if (simpleBaseEvent instanceof UpdateSearchHintEvent) {
            tryFillHintWord(((UpdateSearchHintEvent) simpleBaseEvent).unifySearchResultExt);
            return;
        }
        if (simpleBaseEvent instanceof GroupSearchEvent) {
            GroupSearchEvent groupSearchEvent = (GroupSearchEvent) simpleBaseEvent;
            String searchWord = groupSearchEvent.getSearchWord();
            this.searchText.setText(searchWord);
            if (groupSearchEvent.getIsSelectionEnd()) {
                this.searchText.setSelection(searchWord.length());
                return;
            }
            return;
        }
        if (simpleBaseEvent instanceof UniteSearchEvent) {
            SearchDataFetchViewModel searchDataFetchViewModel = this.dataFetchVM;
            if (searchDataFetchViewModel != null) {
                UniteSearchEvent uniteSearchEvent = (UniteSearchEvent) simpleBaseEvent;
                searchDataFetchViewModel.f2(uniteSearchEvent.getKeyword(), uniteSearchEvent.getTime(), uniteSearchEvent.getCount(), uniteSearchEvent.getBusinessMaskArray(), uniteSearchEvent.getIdList(), uniteSearchEvent.getFromAction(), uniteSearchEvent.getCookie(), uniteSearchEvent.getLatitude(), uniteSearchEvent.getLongitude(), uniteSearchEvent.getIsMoreSearch(), uniteSearchEvent.getHasLocalData(), uniteSearchEvent.getFromType(), uniteSearchEvent.getExtraData());
                return;
            }
            return;
        }
        if (simpleBaseEvent instanceof JumpBusinessSearchEntryEvent) {
            QLog.d(TAG, 1, "receive JumpBusinessSearchEntryEvent", Integer.valueOf(((JumpBusinessSearchEntryEvent) simpleBaseEvent).getBusinessId()));
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        this.isPaused = Boolean.FALSE;
        this.mSoftKeyboardStateHelper.a(this);
        this.voiceComponent.b0();
        this.thirdAppComponent.i();
        RichNodeController.g();
        if (!this.mIsCreateShow) {
            com.tencent.mobileqq.search.report.b.h(null, new ReportModelDC02528().module("all_result").action("return").ver2(com.tencent.mobileqq.search.report.b.a(this.mFrom)).ver3(UniteSearchActivity.f282688f0).ver6(UniteSearchActivity.f282687e0));
        }
        this.mIsCreateShow = false;
        UniteSearchActivity.f282688f0 = "";
        ApngImage.playByTag(41);
        if (this.mIsWaitToFinish && getActivity() != null) {
            QLog.d("zsg-test", 1, "onViewStateRestored, isSaveState = " + isStateSaved());
            getActivity().onKeyDown(4, new KeyEvent(0, 4));
        } else if (this.mCurrentFragment == 4) {
            QLog.d(TAG, 1, "onResume, showInputMethod");
            showInputMethod();
        }
        AutoHintLayout autoHintLayout = this.autoHintLayout;
        if (autoHintLayout != null && this.mCurrentFragment == 4) {
            autoHintLayout.q();
        }
        if (!((IGuildTempApi) QRoute.api(IGuildTempApi.class)).isGuildTabSelected()) {
            com.tencent.mobileqq.guild.report.b.g("functional_qq_search", TAG);
        }
        com.tencent.mobileqq.guild.report.b.i("pg_search_activation", TAG);
    }

    @Override // com.tencent.biz.qqcircle.widgets.comment.f.b
    public void onSoftKeyboardClosed() {
        this.isSoftKeyboardOpenning = Boolean.FALSE;
        QLog.i(TAG, 1, "onSoftKeyboardClosed!");
        this.voiceComponent.onSoftKeyboardClosed();
        this.voiceComponent.Y(VoiceSearchComponent.Companion.State.HIDE_ALL);
        this.thirdAppComponent.onSoftKeyboardClosed();
        this.thirdAppComponent.d();
        this.searchText.clearFocus();
        SearchEntryFragment searchEntryFragment = this.searchEntryFragment;
        if (searchEntryFragment != null) {
            searchEntryFragment.onSoftKeyboardClosed();
        }
    }

    @Override // com.tencent.biz.qqcircle.widgets.comment.f.b
    public void onSoftKeyboardOpened(int i3) {
        this.isSoftKeyboardOpenning = Boolean.TRUE;
        if (this.canUseVoiceSearchComponent) {
            QLog.i(TAG, 1, "onSoftKeyboardOpened! keyboardHeightInPx=" + i3 + ", moveToState(State.SHOW_ENTRY)");
            if (!TextUtils.isEmpty(this.currKeyword)) {
                this.voiceComponent.Y(VoiceSearchComponent.Companion.State.HIDE_ALL);
            } else {
                this.voiceComponent.onSoftKeyboardOpened(i3);
                this.voiceComponent.Y(VoiceSearchComponent.Companion.State.SMALL_VOICE_INPUT_BAR);
            }
        }
        if (this.canShowThirdAppComponent) {
            this.thirdAppComponent.onSoftKeyboardOpened(i3);
            if (!TextUtils.isEmpty(this.currKeyword)) {
                this.thirdAppComponent.d();
            } else {
                this.thirdAppComponent.l();
            }
        }
        this.searchText.setCursorVisible(true);
        SearchEntryFragment searchEntryFragment = this.searchEntryFragment;
        if (searchEntryFragment != null) {
            searchEntryFragment.onSoftKeyboardOpened(i3);
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        if (!b.a.f443728q && b.a.f443717f != 1) {
            b.a.f443724m = System.nanoTime();
            b.a.f443726o = System.nanoTime();
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        if (!b.a.f443728q && b.a.f443717f != 1) {
            b.a.f443725n += (System.nanoTime() - b.a.f443724m) / 1000000;
            b.a.f443727p += (System.nanoTime() - b.a.f443726o) / 1000000;
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment
    public /* bridge */ /* synthetic */ void onUserLeaveHint() {
        com.tencent.biz.richframework.compat.f.m(this);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        doEnterAnim();
        SimpleEventBus.getInstance().registerReceiver(this);
        addVMObservers();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewStateRestored(@Nullable Bundle bundle) {
        QuickPinyinEditText quickPinyinEditText = this.searchText;
        if (quickPinyinEditText != null) {
            quickPinyinEditText.removeTextChangedListener(this);
        }
        super.onViewStateRestored(bundle);
        QuickPinyinEditText quickPinyinEditText2 = this.searchText;
        if (quickPinyinEditText2 != null) {
            quickPinyinEditText2.addTextChangedListener(this);
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment
    public /* bridge */ /* synthetic */ boolean overrideFinish() {
        return com.tencent.biz.richframework.compat.f.o(this);
    }

    public void preProcessModel(List<? extends x> list) {
        if (list == null) {
            return;
        }
        for (x xVar : list) {
            if (xVar.o() != null && xVar.o().size() != 0) {
                for (y yVar : xVar.o()) {
                    if (yVar instanceof com.tencent.mobileqq.search.model.z) {
                        ((com.tencent.mobileqq.search.model.z) yVar).F(this.source);
                    }
                }
                if (xVar instanceof lo2.e) {
                    Iterator<y> it = xVar.o().iterator();
                    while (it.hasNext()) {
                        y next = it.next();
                        if (next instanceof am) {
                            am amVar = (am) next;
                            int a06 = amVar.a0();
                            if (!com.tencent.mobileqq.search.rich.n.g().h(a06)) {
                                it.remove();
                                if (QLog.isColorLevel()) {
                                    QLog.d(TAG, 2, "handleUniteSearchResult, remove rich node:" + a06);
                                }
                            }
                            patchRichExtraData(amVar);
                            doRichReport(amVar);
                        }
                    }
                }
            }
        }
    }

    @Override // com.tencent.mobileqq.pad.f
    public boolean qOnBackPressed() {
        return false;
    }

    public String removeSelectedSpan(EditText editText, boolean z16, CharSequence charSequence) {
        String substring;
        String searchKeyword = getSearchKeyword();
        SpannableStringBuilder spannableStringBuilder = (SpannableStringBuilder) editText.getText();
        if (spannableStringBuilder != null) {
            CompleteUrlSpan[] completeUrlSpanArr = (CompleteUrlSpan[]) spannableStringBuilder.getSpans(0, spannableStringBuilder.toString().length(), CompleteUrlSpan.class);
            if (completeUrlSpanArr.length != 0) {
                int spanStart = spannableStringBuilder.getSpanStart(completeUrlSpanArr[0]);
                spannableStringBuilder.getSpanEnd(completeUrlSpanArr[0]);
                if (z16) {
                    substring = charSequence.toString().substring(0, spanStart + 1);
                } else {
                    substring = searchKeyword.toString().substring(0, spanStart);
                }
                editText.removeTextChangedListener(this);
                editText.setText(substring);
                editText.setSelection(substring.length());
                editText.addTextChangedListener(this);
                return substring;
            }
        }
        return searchKeyword.trim();
    }

    public void search(String str, int i3) {
        removeShowDatas();
        this.groupSearchResultLayout.setVisibility(0);
        setSearchForce(i3);
        this.searchFragment.startSearchLocalAndNet(str);
        this.searchFragment.setCookie(null);
        showFragment(1);
        SearchEntryFragment searchEntryFragment = this.searchEntryFragment;
        if (searchEntryFragment == null || !TextUtils.equals(searchEntryFragment.getInitData().getString("tabType"), ISearchEntryFragment.TAB_ID_DYNAMIC)) {
            return;
        }
        ((cw) ((QQAppInterface) ((IReadInJoyUtils) QRoute.api(IReadInJoyUtils.class)).getAppRuntime()).getManager(QQManagerFactory.SEARCH_WORD_HISTORY_MANAGER)).c(str);
        this.searchEntryFragment.refresh();
    }

    public void setHotSearchKeyWord(String str) {
        this.mHotSearchKeyWord = str;
    }

    public void setHotSearchKeyWordId(String str) {
        this.mHotSearchKeyWordId = str;
    }

    public void setResultSourceType(int i3) {
        if (i3 != this.mResultSourceType) {
            QLog.i(TAG, 1, "setResultSourceType type=" + i3);
        }
        this.mResultSourceType = i3;
    }

    public void setSearchForce(int i3) {
        this.searchFragment.forceRequestStatus = i3;
    }

    public void showHomeHotWord(boolean z16) {
        if (z16) {
            HotWordSearchEntryDataModel.HotSearchItem hotSearchItem = UniteSearchActivity.f282686d0;
            if (hotSearchItem == null) {
                this.searchText.setHint(R.string.ha7);
                return;
            } else {
                this.searchText.setHint(hotSearchItem.title);
                this.searchText.setTag(UniteSearchActivity.f282686d0);
                this.searchText.setCursorVisible(true);
            }
        } else {
            this.searchText.setHint(R.string.ha7);
            this.searchText.setTag("");
        }
        refreshConfigSearchButtonStatus();
    }

    public void showInputMethod() {
        if (this.searchText == null) {
            return;
        }
        if (!shouldShowInputMethod()) {
            QLog.i(TAG, 1, "shouldShowInputMethod false, return 1!");
        } else {
            this.mHandler.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.search.fragment.s
                @Override // java.lang.Runnable
                public final void run() {
                    UniteSearchFragment.this.lambda$showInputMethod$0();
                }
            }, 500L);
        }
    }

    void showSearchHistory(boolean z16) {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "showSearchHistory,  isShow: " + z16);
        }
        View view = this.entryLayout;
        if (view == null) {
            return;
        }
        if (z16 && view.getVisibility() != 0 && this.mFrom != 12) {
            showFragment(4);
        } else if ((!z16 && this.entryLayout.getVisibility() == 0) || this.mFrom == 12) {
            showFragment(1);
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public /* bridge */ /* synthetic */ boolean useArgusLifecycle() {
        return ne0.a.f(this);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* bridge */ /* synthetic */ ViewModel getViewModel(String str, @NonNull Class cls) {
        return ne0.a.c(this, str, cls);
    }

    public void search(String str) {
        removeShowDatas();
        this.groupSearchResultLayout.setVisibility(0);
        if (this.mResultSourceType == 1) {
            this.searchFragment.hotSearchKeyWordId = this.mHotSearchKeyWordId;
            this.searchFragment.startSearchLocalAndNet(str, true, 3);
        } else {
            this.searchFragment.startSearchLocalAndNet(str);
        }
        this.searchFragment.setCookie(null);
        showFragment(1);
    }

    @Override // com.tencent.mobileqq.pad.f
    public void qOnNewIntent() {
    }

    public void handleSearchDiscoveryError(int i3, String str, int i16) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
    }
}
