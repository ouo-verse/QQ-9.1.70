package com.tencent.mobileqq.search.fragment;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelStoreOwner;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.common.config.AppSetting;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.image.AbstractGifImage;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QBaseFragment;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qcircle.api.IQCircleReportApi;
import com.tencent.mobileqq.qcircle.api.constant.QCircleLpReportDc05504DataBuilder;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.BaseSearchEntryModel;
import com.tencent.mobileqq.search.HotWordSearchEntryModel;
import com.tencent.mobileqq.search.config.SearchEntrySortConfigProcessor;
import com.tencent.mobileqq.search.event.SearchSettingStateChangeEvent;
import com.tencent.mobileqq.search.fragment.searchentry.ISearchEntryFragment;
import com.tencent.mobileqq.search.model.HotWordSearchEntryDataModel;
import com.tencent.mobileqq.search.model.SearchEntryDataModel;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.search.util.an;
import com.tencent.mobileqq.search.util.ay;
import com.tencent.mobileqq.search.util.w;
import com.tencent.mobileqq.search.util.z;
import com.tencent.mobileqq.studymode.StudyModeManager;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.widget.ScrollView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import mqq.app.AppRuntime;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes18.dex */
public class SearchEntryFragment extends QBaseFragment implements ISearchEntryFragment, SimpleEventReceiver<SearchSettingStateChangeEvent> {
    public static final String KEY_SHADING_WORDS = "key_shading_words";
    public static final String TAG = "QQSearch.Local.entry.SearchEntryFragment";
    private LinearLayout contentLayout;
    private QQAppInterface mApp;
    private dp2.f mDialog;
    private int mFrom;
    private ArrayList<String> mHintWords;
    private boolean mIsVisible;
    private ap2.d mSearchEntryConfig;
    private int mSource;
    private String mTabType;
    u60.c searchPagePerfReporter;
    private TextView settingTextView;
    private an stateChangeDetector;
    protected List<BaseSearchEntryModel> mModelList = new ArrayList();
    private Bundle initData = new Bundle(9);
    private final z mExpHelper = z.c();

    private void addSettingTextView(LinearLayout linearLayout) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        TextView textView = new TextView(getActivity());
        this.settingTextView = textView;
        textView.setLayoutParams(layoutParams);
        this.settingTextView.setGravity(1);
        this.settingTextView.setText(R.string.f214025rs);
        this.settingTextView.setTextSize(14.0f);
        this.settingTextView.setTextColor(ContextCompat.getColor(linearLayout.getContext(), R.color.qui_common_text_link));
        this.settingTextView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.search.fragment.m
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SearchEntryFragment.this.lambda$addSettingTextView$1(view);
            }
        });
        layoutParams.setMargins(0, ViewUtils.dip2px(32.0f), 0, ViewUtils.dip2px(60.0f));
        com.tencent.mobileqq.search.util.u.q(this.settingTextView);
        linearLayout.addView(this.settingTextView);
    }

    private void buildContentView() {
        boolean z16;
        List<BaseSearchEntryModel> resortModelListByConfig = resortModelListByConfig(this.mModelList, convertTabTypeToSearchFrom(convertTabStrTypeToTabIntType(this.mTabType)));
        this.mModelList = resortModelListByConfig;
        int i3 = 0;
        for (final BaseSearchEntryModel baseSearchEntryModel : resortModelListByConfig) {
            baseSearchEntryModel.w(getDisplayNameByType(baseSearchEntryModel.getModelType()));
            if (isShowViewByType(baseSearchEntryModel.getModelType())) {
                int i16 = i3 + 1;
                if (i3 != 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                baseSearchEntryModel.showDivider = z16;
                this.contentLayout.post(new Runnable() { // from class: com.tencent.mobileqq.search.fragment.l
                    @Override // java.lang.Runnable
                    public final void run() {
                        SearchEntryFragment.this.lambda$buildContentView$4(baseSearchEntryModel);
                    }
                });
                i3 = i16;
            }
        }
        u60.c cVar = this.searchPagePerfReporter;
        if (cVar != null) {
            cVar.a("pg_search_activation");
        }
    }

    private boolean canShowHotword(boolean z16, boolean z17, int i3) {
        if ((i3 == 1 || i3 == 8) && z16 && !z17) {
            return true;
        }
        return false;
    }

    public static int convertTabTypeToSearchFrom(int i3) {
        if (i3 == 1) {
            return 1;
        }
        if (i3 == 2) {
            return 2;
        }
        if (i3 != 3) {
            return 0;
        }
        return 21;
    }

    private LinearLayout createContentLayout(Context context) {
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        linearLayout.setOrientation(1);
        linearLayout.setBackgroundResource(R.drawable.qui_common_fill_light_primary_bg);
        LinearLayout linearLayout2 = new LinearLayout(context);
        this.contentLayout = linearLayout2;
        linearLayout2.setLayoutParams(new LinearLayout.LayoutParams(-1, 0, 1.0f));
        this.contentLayout.setOrientation(1);
        this.contentLayout.setGravity(48);
        LinearLayout linearLayout3 = new LinearLayout(context);
        linearLayout3.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        linearLayout3.setOrientation(1);
        linearLayout3.setGravity(17);
        addSettingTextView(linearLayout3);
        linearLayout.addView(this.contentLayout);
        linearLayout.addView(linearLayout3);
        return linearLayout;
    }

    private String getDisplayNameByType(int i3) {
        ap2.d dVar = this.mSearchEntryConfig;
        if (dVar != null) {
            String str = dVar.b().get(String.valueOf(i3));
            if (!TextUtils.isEmpty(str)) {
                return str;
            }
        }
        if (i3 != 3) {
            if (i3 != 256) {
                if (i3 != 10) {
                    if (i3 != 11) {
                        return "";
                    }
                    return getString(R.string.f213945rk);
                }
                return getString(R.string.f213995rp);
            }
            return getString(R.string.f214005rq);
        }
        return getString(R.string.f214045ru);
    }

    private boolean[] getSettingStates() {
        List<BaseSearchEntryModel> list = this.mModelList;
        if (list == null) {
            return new boolean[0];
        }
        boolean[] zArr = new boolean[list.size()];
        for (int i3 = 0; i3 < this.mModelList.size(); i3++) {
            if (this.mModelList.get(i3) != null) {
                zArr[i3] = w.s(this.mModelList.get(i3).getModelType());
            }
        }
        return zArr;
    }

    private void hideHotSearchGif() {
        for (BaseSearchEntryModel baseSearchEntryModel : this.mModelList) {
            if (baseSearchEntryModel.isCreatedView && (baseSearchEntryModel instanceof HotWordSearchEntryModel)) {
                ((HotWordSearchEntryModel) baseSearchEntryModel).C();
            }
        }
    }

    private void hideSettingButton() {
        TextView textView = this.settingTextView;
        if (textView != null) {
            textView.setVisibility(8);
        }
    }

    private void hideSoftInput() {
        InputMethodManager inputMethodManager = (InputMethodManager) getQBaseActivity().getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD);
        if (inputMethodManager != null) {
            inputMethodManager.hideSoftInputFromWindow(this.contentLayout.getWindowToken(), 2);
        }
    }

    private boolean isConfigDisableByType(int i3) {
        ap2.d dVar = this.mSearchEntryConfig;
        if (dVar != null && dVar.a().contains(Integer.valueOf(i3))) {
            return true;
        }
        return false;
    }

    private boolean isGooglePlayOrStudyMode() {
        return StudyModeManager.t();
    }

    private boolean isShowViewByType(int i3) {
        if (isConfigDisableByType(i3)) {
            return false;
        }
        return w.s(i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$addSettingTextView$1(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        launchSettingFloatScreenDialog();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$buildContentView$4(BaseSearchEntryModel baseSearchEntryModel) {
        QBaseActivity qBaseActivity = getQBaseActivity();
        if (qBaseActivity != null) {
            this.contentLayout.addView(baseSearchEntryModel.s(qBaseActivity, this.mApp, null, null));
            baseSearchEntryModel.isCreatedView = true;
            baseSearchEntryModel.o();
            return;
        }
        QLog.d(TAG, 2, " ctx is null, ignore create view");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$launchSettingFloatScreenDialog$2(DialogInterface dialogInterface) {
        refreshUIByStates();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$launchSettingFloatScreenDialog$3(Map map) {
        dp2.f fVar = new dp2.f(getActivity(), map);
        this.mDialog = fVar;
        fVar.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.tencent.mobileqq.search.fragment.j
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                SearchEntryFragment.this.lambda$launchSettingFloatScreenDialog$2(dialogInterface);
            }
        });
        this.mDialog.show();
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$onCreateView$0(View view, MotionEvent motionEvent) {
        hideSoftInput();
        return false;
    }

    private void launchSettingFloatScreenDialog() {
        dp2.f fVar = this.mDialog;
        if (fVar != null) {
            fVar.dismiss();
        }
        if (getActivity() != null && !getActivity().isFinishing()) {
            this.stateChangeDetector = new an(getSettingStates());
            SearchEntryFragmentExtKt.a(this, new Function1() { // from class: com.tencent.mobileqq.search.fragment.k
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit lambda$launchSettingFloatScreenDialog$3;
                    lambda$launchSettingFloatScreenDialog$3 = SearchEntryFragment.this.lambda$launchSettingFloatScreenDialog$3((Map) obj);
                    return lambda$launchSettingFloatScreenDialog$3;
                }
            });
        }
    }

    private void notifyViewVisibleChanged(boolean z16) {
        if (this.mIsVisible == z16) {
            return;
        }
        this.mIsVisible = z16;
        for (BaseSearchEntryModel baseSearchEntryModel : this.mModelList) {
            if (baseSearchEntryModel.isCreatedView) {
                baseSearchEntryModel.v(z16);
            }
        }
    }

    private void onDestroyModeView() {
        for (BaseSearchEntryModel baseSearchEntryModel : this.mModelList) {
            if (baseSearchEntryModel.isCreatedView) {
                baseSearchEntryModel.t();
            }
        }
    }

    private void refreshLocalData(boolean z16, boolean z17) {
        resetSearchData();
        int[] d16 = nn2.a.d(this.mApp, convertTabStrTypeToTabIntType(this.mTabType));
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "refreshDataModels modelIdList = " + Arrays.toString(d16));
        }
        if (d16 != null && d16.length > 0) {
            int convertTabStrTypeToTabIntType = convertTabStrTypeToTabIntType(this.mTabType);
            for (int i3 = 0; i3 < d16.length; i3++) {
                if (canShowHotword(z16, z17, d16[i3])) {
                    if (QLog.isColorLevel()) {
                        QLog.d(TAG, 2, "refreshDataModels local, ignore hotWord: " + this.mSource);
                    }
                } else {
                    BaseSearchEntryModel<?> l3 = BaseSearchEntryModel.l(d16[i3], convertTabStrTypeToTabIntType, this.mExpHelper, this.mFrom, this.mHintWords);
                    if (l3 != null) {
                        if (i3 == 0) {
                            l3.showDivider = false;
                        }
                        this.mModelList.add(l3);
                    }
                }
            }
        }
        buildContentView();
    }

    private void refreshNetData(List<SearchEntryDataModel> list, boolean z16, boolean z17) {
        boolean f16 = nn2.a.f(this.mApp, convertTabStrTypeToTabIntType(this.mTabType), true);
        if (f16) {
            resetSearchData();
            for (int i3 = 0; i3 < list.size(); i3++) {
                if (canShowHotword(z16, z17, list.get(i3).f283456f)) {
                    if (QLog.isColorLevel()) {
                        QLog.d(TAG, 2, "refreshDataModels net, ignore hotWord: " + this.mSource);
                    }
                } else {
                    BaseSearchEntryModel<?> l3 = BaseSearchEntryModel.l(list.get(i3).f283456f, convertTabStrTypeToTabIntType(this.mTabType), this.mExpHelper, this.mFrom, this.mHintWords);
                    if (l3 != null) {
                        if (i3 == 0) {
                            l3.showDivider = false;
                        }
                        this.mModelList.add(l3);
                    }
                }
            }
            buildContentView();
        } else {
            for (BaseSearchEntryModel baseSearchEntryModel : this.mModelList) {
                if (baseSearchEntryModel.isCreatedView) {
                    baseSearchEntryModel.o();
                }
            }
        }
        for (int i16 = 0; i16 < list.size(); i16++) {
            if (list.get(i16).f283456f == 8) {
                reportQCircleShow(list.get(i16));
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "refreshDataModels,  mModelList.size = " + this.mTabType + this.mModelList.size() + ", needRefreshModelList = " + f16);
        }
    }

    private void refreshUIByStates() {
        an anVar = this.stateChangeDetector;
        if (anVar != null && anVar.a(getSettingStates())) {
            refreshDataModels(null);
        }
    }

    private void reportQCircleShow(SearchEntryDataModel searchEntryDataModel) {
        if (searchEntryDataModel instanceof HotWordSearchEntryDataModel) {
            CopyOnWriteArrayList<HotWordSearchEntryDataModel.HotSearchItem> copyOnWriteArrayList = ((HotWordSearchEntryDataModel) searchEntryDataModel).E;
            for (int i3 = 0; i3 < copyOnWriteArrayList.size(); i3++) {
                try {
                    JSONObject jSONObject = new JSONObject(copyOnWriteArrayList.get(i3).sExtInfo);
                    HashMap<String, String> hashMap = new HashMap<>();
                    hashMap.put("ext5", jSONObject.optString("ext5"));
                    hashMap.put("ext6", jSONObject.optString("ext6"));
                    hashMap.put("ext7", jSONObject.optString("ext7"));
                    hashMap.put("ext8", jSONObject.optString("ext8"));
                    ((IQCircleReportApi) QRoute.api(IQCircleReportApi.class)).report5504(new QCircleLpReportDc05504DataBuilder().setActionType(104).setSubActionType(1).setThrActionType(1).setExtras(hashMap));
                } catch (JSONException e16) {
                    e16.printStackTrace();
                }
            }
        }
    }

    private void resetSearchData() {
        this.contentLayout.removeAllViews();
        onDestroyModeView();
        this.mModelList.clear();
        if (ISearchEntryFragment.TAB_ID_MESSAGE.equals(this.mTabType) || ISearchEntryFragment.TAB_ID_CONTACT.equals(this.mTabType) || ISearchEntryFragment.TAB_ID_DYNAMIC.equals(this.mTabType)) {
            this.mModelList.add(this.mExpHelper.a(convertTabStrTypeToTabIntType(this.mTabType), this.mFrom));
        }
    }

    private void showSettingButton() {
        TextView textView = this.settingTextView;
        if (textView != null && textView.getVisibility() == 8) {
            this.settingTextView.setVisibility(0);
        }
    }

    @Override // com.tencent.mobileqq.search.fragment.searchentry.ISearchEntryFragment
    public void afterTextChanged(Editable editable) {
        hideHotSearchGif();
        notifyViewVisibleChanged(TextUtils.isEmpty(editable));
    }

    public int convertTabStrTypeToTabIntType(String str) {
        if (ISearchEntryFragment.TAB_ID_MESSAGE.equals(str)) {
            return 1;
        }
        if (ISearchEntryFragment.TAB_ID_CONTACT.equals(str)) {
            return 2;
        }
        if (!ISearchEntryFragment.TAB_ID_DYNAMIC.equals(str) && !ISearchEntryFragment.TAB_ID_WEB_TITLE.equals(str)) {
            return 1;
        }
        return 3;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment
    public /* bridge */ /* synthetic */ boolean doOnKeyDown(int i3, KeyEvent keyEvent) {
        return com.tencent.biz.richframework.compat.f.b(this, i3, keyEvent);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class<SearchSettingStateChangeEvent>> getEventClass() {
        ArrayList<Class<SearchSettingStateChangeEvent>> arrayList = new ArrayList<>();
        arrayList.add(SearchSettingStateChangeEvent.class);
        return arrayList;
    }

    @Override // com.tencent.mobileqq.search.fragment.searchentry.ISearchEntryFragment
    @NonNull
    public Bundle getInitData() {
        return this.initData;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @WorkerThread
    public Map<Integer, String> getModHashMap(List<BaseSearchEntryModel> list) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (list == null) {
            return linkedHashMap;
        }
        for (int i3 = 0; i3 < list.size(); i3++) {
            BaseSearchEntryModel baseSearchEntryModel = list.get(i3);
            if (baseSearchEntryModel != null) {
                int modelType = baseSearchEntryModel.getModelType();
                if (!isConfigDisableByType(modelType) && modelType != 1 && (!(list.get(i3) instanceof com.tencent.mobileqq.search.i) || !((com.tencent.mobileqq.search.i) list.get(i3)).G())) {
                    if (modelType == 12) {
                        baseSearchEntryModel.w(w.e(modelType));
                    }
                    linkedHashMap.put(Integer.valueOf(modelType), baseSearchEntryModel.getModelName());
                }
            }
        }
        return linkedHashMap;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* bridge */ /* synthetic */ ViewModel getViewModel(ViewModelStoreOwner viewModelStoreOwner, String str, @NonNull Class cls) {
        return ne0.a.a(this, viewModelStoreOwner, str, cls);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment
    public /* bridge */ /* synthetic */ void initWindowStyleAndAnimation(Activity activity) {
        com.tencent.biz.richframework.compat.f.c(this, activity);
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

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        for (BaseSearchEntryModel baseSearchEntryModel : this.mModelList) {
            if (baseSearchEntryModel.isCreatedView) {
                baseSearchEntryModel.r(configuration);
            }
        }
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        AppRuntime appRuntime = getQBaseActivity().getAppRuntime();
        if (appRuntime instanceof QQAppInterface) {
            this.mApp = (QQAppInterface) appRuntime;
        }
        this.mSearchEntryConfig = (ap2.d) ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadConfig("101147");
        QBaseActivity qBaseActivity = getQBaseActivity();
        LinearLayout createContentLayout = createContentLayout(qBaseActivity);
        ISearchEntryFragment.mIsModelsReported.clear();
        ScrollView scrollView = new ScrollView(qBaseActivity);
        scrollView.setOverScrollMode(0);
        scrollView.setVerticalScrollBarEnabled(false);
        scrollView.setFillViewport(true);
        scrollView.setOnTouchListener(new View.OnTouchListener() { // from class: com.tencent.mobileqq.search.fragment.n
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean lambda$onCreateView$0;
                lambda$onCreateView$0 = SearchEntryFragment.this.lambda$onCreateView$0(view, motionEvent);
                return lambda$onCreateView$0;
            }
        });
        scrollView.addView(createContentLayout);
        if (AppSetting.f99565y) {
            AccessibilityUtil.n(this.contentLayout, false);
            AccessibilityUtil.n(scrollView, false);
        }
        scrollView.setBackgroundResource(R.drawable.qui_common_bg_bottom_standard_bg);
        SimpleEventBus.getInstance().registerReceiver(this);
        if (getArguments() != null) {
            this.mHintWords = getArguments().getStringArrayList(KEY_SHADING_WORDS);
        }
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, scrollView);
        return scrollView;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        AbstractGifImage.pauseAll();
        hideHotSearchGif();
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        onDestroyModeView();
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    @Deprecated
    public /* bridge */ /* synthetic */ void onPartTimeCostReport(String str, String str2, long j3) {
        ne0.a.e(this, str, str2, j3);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        AbstractGifImage.pauseAll();
        hideHotSearchGif();
        for (BaseSearchEntryModel baseSearchEntryModel : this.mModelList) {
            if (baseSearchEntryModel.isCreatedView) {
                baseSearchEntryModel.u();
            }
        }
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
        if (simpleBaseEvent instanceof SearchSettingStateChangeEvent) {
            refreshUIByStates();
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        AbstractGifImage.resumeAll();
        if (!this.mModelList.isEmpty()) {
            for (BaseSearchEntryModel baseSearchEntryModel : this.mModelList) {
                if (baseSearchEntryModel.isCreatedView) {
                    baseSearchEntryModel.onResume();
                }
            }
            refresh();
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment
    public /* bridge */ /* synthetic */ void onUserLeaveHint() {
        com.tencent.biz.richframework.compat.f.m(this);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        refreshDataModels(null);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment
    public /* bridge */ /* synthetic */ boolean overrideFinish() {
        return com.tencent.biz.richframework.compat.f.o(this);
    }

    @Override // com.tencent.mobileqq.search.fragment.searchentry.ISearchEntryFragment
    public void refresh() {
        for (BaseSearchEntryModel baseSearchEntryModel : this.mModelList) {
            if (baseSearchEntryModel.isCreatedView) {
                baseSearchEntryModel.refresh();
            }
        }
    }

    @Override // com.tencent.mobileqq.search.fragment.searchentry.ISearchEntryFragment
    public void refreshDataModels(List<SearchEntryDataModel> list) {
        boolean z16;
        if (getQBaseActivity() == null) {
            QLog.e(TAG, 1, "in refreshDataModels() getActivity() is null.");
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "refreshDataModels,  mTabType = " + this.mTabType + ", result = " + list);
        }
        if (getQBaseActivity() != null && this.contentLayout != null && !isDetached()) {
            if (isGooglePlayOrStudyMode()) {
                hideSettingButton();
                return;
            }
            showSettingButton();
            boolean J0 = SearchUtils.J0(this.mSource);
            if (J0) {
                z16 = w.u(this.mSource);
            } else {
                z16 = false;
            }
            if (list != null) {
                refreshNetData(list, J0, z16);
                return;
            } else {
                refreshLocalData(J0, z16);
                return;
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "refreshDataModels,  fragment is in a invalid state");
        }
    }

    public List<BaseSearchEntryModel> resortModelListByConfig(List<BaseSearchEntryModel> list, int i3) {
        int[] iArr;
        if (list != null && !list.isEmpty()) {
            com.tencent.mobileqq.search.config.b a16 = SearchEntrySortConfigProcessor.a();
            if (a16 != null) {
                iArr = a16.a(ay.j(i3), ay.c());
            } else {
                iArr = null;
            }
            if (iArr == null) {
                iArr = new int[]{11, 3, 256};
            }
            if (iArr.length == 0) {
                return list;
            }
            LinkedHashMap linkedHashMap = new LinkedHashMap(list.size());
            for (BaseSearchEntryModel baseSearchEntryModel : list) {
                if (baseSearchEntryModel != null) {
                    linkedHashMap.put(Integer.valueOf(baseSearchEntryModel.getModelType()), baseSearchEntryModel);
                }
            }
            ArrayList arrayList = new ArrayList(list.size());
            for (int i16 : iArr) {
                BaseSearchEntryModel baseSearchEntryModel2 = (BaseSearchEntryModel) linkedHashMap.remove(Integer.valueOf(i16));
                if (baseSearchEntryModel2 != null) {
                    arrayList.add(baseSearchEntryModel2);
                }
            }
            arrayList.addAll(linkedHashMap.values());
            return arrayList;
        }
        return list;
    }

    @Override // com.tencent.mobileqq.search.fragment.searchentry.ISearchEntryFragment
    public void setApp(@NonNull QQAppInterface qQAppInterface) {
        this.mApp = qQAppInterface;
    }

    @Override // com.tencent.mobileqq.search.fragment.searchentry.ISearchEntryFragment
    public void setInitData(@NonNull Bundle bundle) {
        this.initData = bundle;
        this.mSource = bundle.getInt("source");
        this.mFrom = bundle.getInt("from");
        this.mTabType = bundle.getString("tabType");
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public /* bridge */ /* synthetic */ boolean useArgusLifecycle() {
        return ne0.a.f(this);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* bridge */ /* synthetic */ ViewModel getViewModel(String str, @NonNull Class cls) {
        return ne0.a.c(this, str, cls);
    }

    @Override // com.tencent.mobileqq.search.fragment.searchentry.ISearchEntryFragment
    @NonNull
    public QBaseFragment getFragment() {
        return this;
    }

    @Override // com.tencent.mobileqq.search.fragment.searchentry.ISearchEntryFragment
    public void onSoftKeyboardClosed() {
    }

    @Override // com.tencent.mobileqq.search.fragment.searchentry.ISearchEntryFragment
    public void onSoftKeyboardOpened(int i3) {
    }
}
