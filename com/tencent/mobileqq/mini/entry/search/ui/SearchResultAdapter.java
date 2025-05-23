package com.tencent.mobileqq.mini.entry.search.ui;

import NS_STORE_APP_CLIENT.STORE_APP_CLIENT$StRankingList;
import NS_STORE_APP_SEARCH.MiniAppSearch$CouponInfo;
import NS_STORE_APP_SEARCH.MiniAppSearch$SearchExtInfo;
import android.app.Activity;
import android.content.Context;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.aelight.camera.constants.AECameraConstants;
import com.tencent.biz.qui.quitagview.QUITagSize;
import com.tencent.biz.qui.quitagview.QUITagType;
import com.tencent.biz.qui.quitagview.QUITagView;
import com.tencent.biz.qui.quitagview.QUITagViewConfig;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.entry.MiniAppExposureManager;
import com.tencent.mobileqq.mini.entry.MiniAppUtils;
import com.tencent.mobileqq.mini.entry.search.comm.SearchInfo;
import com.tencent.mobileqq.mini.entry.search.data.MiniAppSearchDataManager;
import com.tencent.mobileqq.mini.report.MiniAppSearchDtReportHelper;
import com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239;
import com.tencent.mobileqq.mini.report.MiniProgramReportHelper;
import com.tencent.mobileqq.mini.sdk.MiniAppLauncher;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.wxmini.api.IWxMiniManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.report.MiniAppReportManager2;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import mqq.util.WeakReference;
import org.slf4j.Marker;

/* compiled from: P */
/* loaded from: classes33.dex */
public class SearchResultAdapter extends BaseAdapter implements MiniAppSearchDataManager.SearchResultDataChangedListener {
    private static final int COMMON_LIGHT_COLOR = -16578534;
    private static final int HIGH_LIGHT_COLOR = -14763268;
    private static final String[] SYNTAX_SPECIAL_WORD = {"\\", "$", "(", ")", "*", Marker.ANY_NON_NULL_MARKER, ".", "[", "]", QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER, AECameraConstants.WIDGETINFO_SEPARATE, "{", "}", "|"};
    private static final String TAG = "SearchResultAdapter";
    private List<String> highlightWords;
    private WeakReference<Activity> mActivityReference;
    private DataChangedListener mDataChangedListener;
    private boolean mIsHotKeyword;
    private String mKeyword;
    private int mRefer;
    private List<SearchInfo> appList = new ArrayList();
    private boolean mIsProactiveSearch = true;
    boolean mIsClassifyExperiment = false;

    /* compiled from: P */
    /* loaded from: classes33.dex */
    public interface DataChangedListener {
        void onResultDataChanged(boolean z16);

        void onTextChanged(String str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes33.dex */
    public static class Item {
        final View mContainer;
        final ImageView mCrown;
        final ImageView mIcon;
        final TextView mName;
        final TextView mRanking;
        final TextView mScore;
        final TextView mUnit;

        Item(View view) {
            this.mContainer = view;
            this.mIcon = (ImageView) view.findViewById(R.id.ltf);
            this.mCrown = (ImageView) view.findViewById(R.id.ltg);
            this.mName = (TextView) view.findViewById(R.id.lti);
            this.mRanking = (TextView) view.findViewById(R.id.ltj);
            this.mScore = (TextView) view.findViewById(R.id.ltk);
            this.mUnit = (TextView) view.findViewById(R.id.ltb);
        }

        public void gone() {
            this.mContainer.setVisibility(8);
        }

        public void setData(Context context, STORE_APP_CLIENT$StRankingList sTORE_APP_CLIENT$StRankingList) {
            this.mContainer.setVisibility(0);
            try {
                Drawable drawable = context.getResources().getDrawable(R.drawable.f160830com);
                URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
                obtain.mLoadingDrawable = drawable;
                obtain.mFailedDrawable = drawable;
                int dip2px = ViewUtils.dip2px(30.0f);
                obtain.mRequestHeight = dip2px;
                obtain.mRequestWidth = dip2px;
                URLDrawable drawable2 = URLDrawable.getDrawable(sTORE_APP_CLIENT$StRankingList.avatar.get(), obtain);
                drawable2.setTag(com.tencent.mobileqq.urldrawable.a.d(ViewUtils.dip2px(30.0f), ViewUtils.dip2px(30.0f)));
                drawable2.setDecodeHandler(com.tencent.mobileqq.urldrawable.a.f306335o);
                this.mIcon.setImageDrawable(drawable2);
            } catch (IllegalArgumentException unused) {
            }
            this.mName.setText(sTORE_APP_CLIENT$StRankingList.nick.get());
            this.mScore.setText("" + sTORE_APP_CLIENT$StRankingList.score.get());
            this.mUnit.setText(sTORE_APP_CLIENT$StRankingList.unit.get());
            this.mRanking.setText(sTORE_APP_CLIENT$StRankingList.ranks.get() + "");
        }

        public void setOutOfRankStyle(View view) {
            this.mRanking.setTextColor(view.getContext().getColor(R.color.qui_common_text_primary));
            this.mRanking.setTypeface(Typeface.create("sans-serif-condensed", 2));
            this.mRanking.setScaleX(0.8f);
        }
    }

    public SearchResultAdapter(Activity activity, int i3) {
        this.mActivityReference = new WeakReference<>(activity);
        this.mRefer = i3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static View createCouponView(MiniAppSearch$CouponInfo miniAppSearch$CouponInfo, View view) {
        String str = miniAppSearch$CouponInfo.leastPrice.get();
        String str2 = miniAppSearch$CouponInfo.amt.get();
        String str3 = miniAppSearch$CouponInfo.iconUrl.get();
        try {
            str = String.valueOf(Integer.valueOf(str).intValue() / 100);
            str2 = String.valueOf(Integer.valueOf(str2).intValue() / 100);
        } catch (Exception e16) {
            QLog.e(TAG, 1, "createCouponView, covert exception:" + Log.getStackTraceString(e16));
        }
        LinearLayout linearLayout = new LinearLayout(view.getContext());
        linearLayout.setOrientation(0);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, ViewUtils.dpToPx(33.0f));
        layoutParams.rightMargin = ViewUtils.dpToPx(20.0f);
        linearLayout.setLayoutParams(layoutParams);
        TextView textView = new TextView(view.getContext());
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(ViewUtils.dpToPx(39.0f), -1);
        layoutParams2.gravity = 17;
        textView.setText(str2);
        textView.setTextColor(view.getContext().getColor(R.color.qui_common_text_primary));
        textView.setTextSize(1, 15.0f);
        textView.setGravity(17);
        textView.setBackgroundDrawable(URLDrawable.getDrawable(str3, (URLDrawable.URLDrawableOptions) null));
        textView.setTypeface(Typeface.create("sans-serif-condensed", 3));
        textView.setLayoutParams(layoutParams2);
        linearLayout.addView(textView);
        TextView textView2 = new TextView(view.getContext());
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -1);
        layoutParams2.gravity = 17;
        int dpToPx = ViewUtils.dpToPx(7.0f);
        textView2.setPadding(dpToPx, 0, dpToPx, 0);
        textView2.setText(str + "\u51cf" + str2 + "\u5238");
        textView2.setTextColor(view.getContext().getColor(R.color.qui_common_text_primary));
        textView2.setTextSize(1, 12.0f);
        textView2.setGravity(17);
        textView2.setLayoutParams(layoutParams3);
        linearLayout.addView(textView2);
        linearLayout.setBackgroundResource(R.drawable.jyc);
        return linearLayout;
    }

    private static String escapeSyntaxSpecialWord(String str) {
        if (!TextUtils.isEmpty(str)) {
            for (String str2 : SYNTAX_SPECIAL_WORD) {
                if (str.contains(str2)) {
                    str = str.replace(str2, "\\" + str2);
                }
            }
        }
        return str;
    }

    public static Drawable getAvatarDrawable(Context context, String str) {
        Drawable drawable = context.getResources().getDrawable(R.drawable.f160830com);
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        obtain.mLoadingDrawable = drawable;
        obtain.mFailedDrawable = drawable;
        int dip2px = ViewUtils.dip2px(12.0f);
        obtain.mRequestHeight = dip2px;
        obtain.mRequestWidth = dip2px;
        URLDrawable drawable2 = URLDrawable.getDrawable(str, obtain);
        drawable2.setTag(com.tencent.mobileqq.urldrawable.a.d(ViewUtils.dip2px(12.0f), ViewUtils.dip2px(12.0f)));
        drawable2.setDecodeHandler(com.tencent.mobileqq.urldrawable.a.f306335o);
        return drawable2;
    }

    public static SpannableString highLightKeyword(int i3, String str, List<String> list) {
        SpannableString spannableString = new SpannableString(str);
        if (list != null) {
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                Matcher matcher = Pattern.compile(escapeSyntaxSpecialWord(it.next())).matcher(spannableString);
                while (matcher.find()) {
                    spannableString.setSpan(new ForegroundColorSpan(i3), matcher.start(), matcher.end(), 33);
                }
            }
        }
        return spannableString;
    }

    private void reportClassifyResultPageExpose() {
        if (this.mIsClassifyExperiment) {
            HashMap<String, String> hashMap = MiniProgramLpReportDC04239.CLASSIFY_PAGE_ACTION_MAP;
            if (hashMap.containsKey(this.mKeyword)) {
                MiniProgramLpReportDC04239.reportAsyncWithReferAndVia("page_view", "em_expo", hashMap.get(this.mKeyword), MiniProgramLpReportDC04239.SORT_RESULT_REFER, MiniProgramLpReportDC04239.CLASSIFY_PAGE_VIA_MAP.get(this.mKeyword));
            }
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.appList.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i3) {
        return this.appList.get(i3);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i3) {
        return i3;
    }

    @Override // com.tencent.mobileqq.mini.entry.search.data.MiniAppSearchDataManager.SearchResultDataChangedListener
    public void onResultDataChanged() {
        MiniAppSearchDataManager miniAppSearchDataManager = (MiniAppSearchDataManager) MiniAppUtils.getAppInterface().getManager(QQManagerFactory.MINI_APP_SEARCH_MANAGER);
        setData(miniAppSearchDataManager.getSearchResultData());
        this.highlightWords = miniAppSearchDataManager.getHighLightKeywords();
        notifyDataSetChanged();
        DataChangedListener dataChangedListener = this.mDataChangedListener;
        if (dataChangedListener != null) {
            dataChangedListener.onResultDataChanged(true);
        }
        reportClassifyResultPageExpose();
    }

    public void setData(List<SearchInfo> list) {
        this.appList.clear();
        this.appList.addAll(list);
    }

    public void setDataChangedListener(DataChangedListener dataChangedListener) {
        this.mDataChangedListener = dataChangedListener;
    }

    public void setIsClassifyExperiment(boolean z16) {
        this.mIsClassifyExperiment = z16;
    }

    public void setKeyword(String str, boolean z16, boolean z17) {
        this.mKeyword = str;
        this.mIsHotKeyword = z16;
        this.mIsProactiveSearch = z17;
    }

    @Override // android.widget.Adapter
    public View getView(int i3, View view, ViewGroup viewGroup) {
        SearchResultViewHolder searchResultViewHolder;
        if (view == null) {
            try {
                View inflate = LayoutInflater.from(viewGroup.getContext().getApplicationContext()).inflate(R.layout.fhu, viewGroup, false);
                if (inflate == null) {
                    QLog.e(TAG, 1, "getView convertView is null!");
                    return null;
                }
                SearchResultViewHolder searchResultViewHolder2 = new SearchResultViewHolder();
                searchResultViewHolder2.icon = (ImageView) inflate.findViewById(R.id.z9a);
                searchResultViewHolder2.name = (TextView) inflate.findViewById(R.id.z9b);
                searchResultViewHolder2.category = (QUITagView) inflate.findViewById(R.id.z9c);
                searchResultViewHolder2.desc = (TextView) inflate.findViewById(R.id.z9_);
                searchResultViewHolder2.userNumDesc = (TextView) inflate.findViewById(R.id.z9h);
                searchResultViewHolder2.divider = inflate.findViewById(R.id.z9e);
                searchResultViewHolder2.avatarContainer = (LinearLayout) inflate.findViewById(R.id.z9d);
                searchResultViewHolder2.payingFriendsDesc = (TextView) inflate.findViewById(R.id.z9f);
                searchResultViewHolder2.couponTitle = (TextView) inflate.findViewById(R.id.f166273z94);
                searchResultViewHolder2.pkRankingContainer = (RelativeLayout) inflate.findViewById(R.id.z95);
                searchResultViewHolder2.couponScrollView = (ViewGroup) inflate.findViewById(R.id.f166272z93);
                searchResultViewHolder2.couponContainer = (LinearLayout) inflate.findViewById(R.id.f166271z92);
                searchResultViewHolder2.mRanking.add(new Item(inflate.findViewById(R.id.f166263lt4)));
                searchResultViewHolder2.mRanking.add(new Item(inflate.findViewById(R.id.lt5)));
                searchResultViewHolder2.mRanking.add(new Item(inflate.findViewById(R.id.lt6)));
                searchResultViewHolder2.mRanking.add(new Item(inflate.findViewById(R.id.lt7)));
                searchResultViewHolder2.mRanking.get(0).mCrown.setVisibility(0);
                searchResultViewHolder2.mRanking.get(3).setOutOfRankStyle(inflate);
                inflate.setTag(searchResultViewHolder2);
                searchResultViewHolder = searchResultViewHolder2;
                view = inflate;
            } catch (Exception e16) {
                QLog.e(TAG, 1, "getView inflate error!", e16);
                return null;
            }
        } else {
            searchResultViewHolder = (SearchResultViewHolder) view.getTag();
        }
        SearchInfo searchInfo = this.appList.get(i3);
        try {
            searchResultViewHolder.position = i3;
            searchResultViewHolder.mIsHotKeyword = this.mIsHotKeyword;
            searchResultViewHolder.isProactiveSearch = this.mIsProactiveSearch;
            searchResultViewHolder.update(searchResultViewHolder, view, searchInfo, this.mActivityReference.get(), this.mKeyword, this.highlightWords, this.mRefer, this.mIsClassifyExperiment);
        } catch (Exception e17) {
            QLog.e(TAG, 1, "getView exception: " + Log.getStackTraceString(e17));
        }
        return view;
    }

    /* compiled from: P */
    /* loaded from: classes33.dex */
    static class SearchResultViewHolder {
        LinearLayout avatarContainer;
        QUITagView category;
        LinearLayout couponContainer;
        ViewGroup couponScrollView;
        TextView couponTitle;
        TextView desc;
        View divider;
        ImageView icon;
        boolean mIsHotKeyword;
        TextView name;
        TextView payingFriendsDesc;
        RelativeLayout pkRankingContainer;
        int position;
        TextView userNumDesc;
        ArrayList<Item> mRanking = new ArrayList<>();
        boolean isProactiveSearch = true;

        SearchResultViewHolder() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void reportClickHotKeywordApp(MiniAppInfo miniAppInfo, String str) {
            if (this.mIsHotKeyword) {
                MiniAppConfig miniAppConfig = new MiniAppConfig(miniAppInfo);
                miniAppConfig.launchParam.scene = 3026;
                MiniProgramLpReportDC04239.reportAsync(miniAppConfig, "page_view", "pg_click", "pulldown_search_hotword_result", "", str);
            }
        }

        private void reportShowHotKeywordApp(MiniAppInfo miniAppInfo, String str) {
            if (this.mIsHotKeyword) {
                MiniAppConfig miniAppConfig = new MiniAppConfig(miniAppInfo);
                miniAppConfig.launchParam.scene = 3026;
                MiniProgramLpReportDC04239.reportAsync(miniAppConfig, "page_view", "expo", "pulldown_search_hotword_result", "", str);
            }
        }

        private void resetPkAndCouponView(View view) {
            this.pkRankingContainer.setVisibility(8);
            this.couponContainer.removeAllViews();
            this.couponScrollView.setVisibility(8);
            this.couponTitle.setVisibility(8);
            view.setBackgroundDrawable(null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void reportClassifySearchClick(boolean z16, String str) {
            if (z16) {
                QLog.d(SearchResultAdapter.TAG, 1, "reportClassifySearchClick " + this.position);
                HashMap<String, String> hashMap = MiniProgramLpReportDC04239.CLASSIFY_PAGE_ACTION_MAP;
                if (hashMap.containsKey(str)) {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(MiniProgramReportHelper.newEntry(MiniAppReportManager2.KEY_SLOT_ID, String.valueOf(this.position + 1)));
                    arrayList.add(MiniProgramReportHelper.newEntry("refer", MiniProgramLpReportDC04239.SORT_RESULT_REFER));
                    arrayList.add(MiniProgramReportHelper.newEntry("via", MiniProgramLpReportDC04239.CLASSIFY_PAGE_VIA_MAP.get(str)));
                    MiniProgramLpReportDC04239.reportAsyncWithExtraEntries("page_view", "pg_click", hashMap.get(str), arrayList);
                }
            }
        }

        private void reportClassifySearchExpose(boolean z16, String str) {
            if (z16) {
                HashMap<String, String> hashMap = MiniProgramLpReportDC04239.CLASSIFY_PAGE_ACTION_MAP;
                if (hashMap.containsKey(str)) {
                    ArrayList arrayList = new ArrayList();
                    if (this.isProactiveSearch) {
                        arrayList.add(MiniProgramReportHelper.newEntry("trace_id", String.valueOf(1)));
                    } else {
                        arrayList.add(MiniProgramReportHelper.newEntry("trace_id", String.valueOf(2)));
                    }
                    arrayList.add(MiniProgramReportHelper.newEntry("refer", MiniProgramLpReportDC04239.SORT_RESULT_REFER));
                    arrayList.add(MiniProgramReportHelper.newEntry("via", MiniProgramLpReportDC04239.CLASSIFY_PAGE_VIA_MAP.get(str)));
                    MiniProgramLpReportDC04239.reportAsyncWithExtraEntries("page_view", "expo", hashMap.get(str), arrayList);
                }
            }
        }

        public void update(SearchResultViewHolder searchResultViewHolder, View view, final SearchInfo searchInfo, final Activity activity, final String str, List<String> list, int i3, final boolean z16) {
            String str2;
            String str3;
            String str4;
            String str5;
            String str6;
            String str7;
            String str8;
            final MiniAppInfo miniAppInfo = searchInfo.getMiniAppInfo();
            this.icon.setImageDrawable(MiniAppUtils.getIcon(view.getContext(), miniAppInfo.iconUrl, false, 0, 48));
            this.name.setText(SearchResultAdapter.highLightKeyword(SearchResultAdapter.HIGH_LIGHT_COLOR, miniAppInfo.name, list));
            this.category.setConfig(new QUITagViewConfig(QUITagType.FILL, QUITagSize.SMALL, null, searchInfo.getCategoryDesc()));
            if (TextUtils.isEmpty(searchInfo.getCategoryDesc())) {
                this.category.setVisibility(8);
            }
            this.desc.setText(miniAppInfo.desc);
            this.userNumDesc.setText(searchInfo.getUseNumberDesc());
            this.payingFriendsDesc.setText(searchInfo.playingFriendsDesc);
            if (searchInfo.userInfoList.size() == 0) {
                this.avatarContainer.setVisibility(8);
                this.divider.setVisibility(8);
            } else {
                this.avatarContainer.removeAllViews();
                this.avatarContainer.setVisibility(0);
                this.divider.setVisibility(0);
                for (int i16 = 0; i16 < 3 && i16 < searchInfo.userInfoList.size(); i16++) {
                    String str9 = searchInfo.userInfoList.get(i16).avatar.get();
                    if (!TextUtils.isEmpty(str9)) {
                        ImageView imageView = new ImageView(view.getContext());
                        imageView.setImageDrawable(SearchResultAdapter.getAvatarDrawable(view.getContext(), str9));
                        int dpToPx = ViewUtils.dpToPx(12.0f);
                        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dpToPx, dpToPx);
                        if (i16 > 0) {
                            layoutParams.leftMargin = -ViewUtils.dpToPx(2.0f);
                        }
                        imageView.setLayoutParams(layoutParams);
                        this.avatarContainer.addView(imageView);
                    }
                }
            }
            this.pkRankingContainer.setVisibility(8);
            this.couponScrollView.setVisibility(8);
            this.couponTitle.setVisibility(8);
            MiniAppSearch$SearchExtInfo searchExtInfo = searchInfo.getSearchExtInfo();
            String str10 = MiniProgramLpReportDC04239.DESKTOP_SEARCH_SUB_ACTION_EXPOSE;
            String str11 = "result_click";
            if (searchExtInfo != null) {
                MiniAppSearch$SearchExtInfo miniAppSearch$SearchExtInfo = searchInfo.getSearchExtInfo().get();
                List<MiniAppSearch$CouponInfo> list2 = miniAppSearch$SearchExtInfo.coupon.get();
                List<STORE_APP_CLIENT$StRankingList> list3 = miniAppSearch$SearchExtInfo.pkRank.get();
                if (list3 != null && list3.size() > 0) {
                    this.pkRankingContainer.setVisibility(0);
                    int i17 = 0;
                    while (i17 < list3.size() && i17 < this.mRanking.size()) {
                        this.mRanking.get(i17).setData(view.getContext(), list3.get(i17));
                        i17++;
                    }
                    while (i17 < this.mRanking.size()) {
                        this.mRanking.get(i17).gone();
                        i17++;
                    }
                    str7 = "pk_result_expo";
                    str8 = "pk_result_click";
                } else if (list2 != null && list2.size() > 0) {
                    this.couponScrollView.setVisibility(0);
                    this.couponTitle.setText("\u672c\u6e38\u620f\u53ef\u4f7f\u7528" + list2.size() + "\u5f20\u62b5\u6263\u5238");
                    this.couponTitle.setVisibility(0);
                    searchResultViewHolder.couponContainer.removeAllViews();
                    Iterator<MiniAppSearch$CouponInfo> it = list2.iterator();
                    while (it.hasNext()) {
                        searchResultViewHolder.couponContainer.addView(SearchResultAdapter.createCouponView(it.next(), view));
                    }
                    str7 = "ticket_result_expo";
                    str8 = "ticket_result_click";
                } else {
                    resetPkAndCouponView(view);
                }
                str10 = str7;
                str11 = str8;
            } else {
                resetPkAndCouponView(view);
            }
            if (!miniAppInfo.isAppTypeVirtualApp() && !miniAppInfo.isAppTypeYungGameApp() && !miniAppInfo.isAppTypeEnterUri()) {
                str5 = "desktop";
                str6 = "search";
                str3 = str6;
                str4 = str10;
                str2 = str11;
            } else {
                str2 = "search_shop_page";
                str3 = "click";
                str4 = "";
                str5 = "page_view";
                str6 = "expo";
            }
            String str12 = str4;
            final String str13 = str5;
            String str14 = str6;
            final String str15 = str3;
            final String str16 = str2;
            view.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.mini.entry.search.ui.SearchResultAdapter.SearchResultViewHolder.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    try {
                        ((InputMethodManager) view2.getContext().getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD)).hideSoftInputFromWindow(view2.getWindowToken(), 0);
                        int i18 = searchInfo.getType() == 5 ? 3028 : 3026;
                        if (z16) {
                            HashMap<String, String> hashMap = MiniProgramLpReportDC04239.CLASSIFY_PAGE_VIA_MAP;
                            if (hashMap.containsKey(str)) {
                                i18 = Integer.parseInt(MiniProgramLpReportDC04239.SORT_RESULT_REFER);
                                miniAppInfo.via = hashMap.get(str);
                            }
                        }
                        if (miniAppInfo.isWxMiniApp()) {
                            ((IWxMiniManager) QRoute.api(IWxMiniManager.class)).startWxMiniAppByAppId(activity, miniAppInfo.appId, "", i18);
                        } else {
                            MiniAppLauncher.launchAppByAppInfo(activity, miniAppInfo, i18);
                        }
                        if (SearchResultViewHolder.this.isProactiveSearch) {
                            ((MiniAppSearchDataManager) MiniAppUtils.getAppInterface().getManager(QQManagerFactory.MINI_APP_SEARCH_MANAGER)).updateHistorySearchList(str);
                        }
                        MiniAppConfig miniAppConfig = new MiniAppConfig(miniAppInfo);
                        miniAppConfig.launchParam.scene = 3026;
                        if (searchInfo.getType() == 5) {
                            miniAppConfig.launchParam.scene = 3028;
                        }
                        MiniProgramLpReportDC04239.reportAsync(miniAppConfig, str13, str15, str16, str);
                        IMiniAppService iMiniAppService = (IMiniAppService) QRoute.api(IMiniAppService.class);
                        MiniAppInfo miniAppInfo2 = miniAppConfig.config;
                        iMiniAppService.reportMiniSearch(miniAppInfo2, 2, true, miniAppInfo2.getReportType());
                        SearchResultViewHolder.this.reportClickHotKeywordApp(miniAppInfo, str);
                        SearchResultViewHolder.this.reportClassifySearchClick(z16, str);
                        QLog.i(SearchResultAdapter.TAG, 1, "SearchResultAdapter, click: appid=" + miniAppInfo.appId + ", appName=" + miniAppInfo.name + ", miniAppType" + miniAppInfo.miniAppType);
                        MiniAppSearchDtReportHelper.INSTANCE.getInstance().miniAppSearchCommonReport("dt_clck", MiniAppSearchDtReportHelper.MINI_APP_EM_APPLET_SEARCH_RESULTS_ENTRIES, new HashMap<String, String>(miniAppConfig) { // from class: com.tencent.mobileqq.mini.entry.search.ui.SearchResultAdapter.SearchResultViewHolder.1.1
                            final /* synthetic */ MiniAppConfig val$appConfig;

                            {
                                this.val$appConfig = miniAppConfig;
                                put(MiniAppSearchDtReportHelper.DT_MINI_APP_ID, miniAppConfig.config.appId);
                                put("search_query_text", str);
                                put("app_position", String.valueOf(SearchResultViewHolder.this.position));
                                put("applet_type", String.valueOf(miniAppConfig.config.engineType));
                            }
                        });
                    } catch (Exception e16) {
                        QLog.e(SearchResultAdapter.TAG, 1, "SearchResultAdapter, start miniApp exception: " + Log.getStackTraceString(e16));
                    }
                }
            });
            MiniAppExposureManager miniAppExposureManager = (MiniAppExposureManager) MiniAppUtils.getAppInterface().getManager(QQManagerFactory.MINI_APP_EXPOSURE_MANAGER);
            MiniAppConfig miniAppConfig = new MiniAppConfig(miniAppInfo);
            miniAppConfig.launchParam.scene = i3;
            MiniAppExposureManager.MiniAppModuleExposureData miniAppModuleExposureData = new MiniAppExposureManager.MiniAppModuleExposureData(miniAppConfig, "page_view", "expo");
            miniAppConfig.launchParam.scene = 3026;
            if (searchInfo.getType() == 5) {
                miniAppConfig.launchParam.scene = 3028;
            }
            IMiniAppService iMiniAppService = (IMiniAppService) QRoute.api(IMiniAppService.class);
            MiniAppInfo miniAppInfo2 = miniAppConfig.config;
            iMiniAppService.reportMiniSearch(miniAppInfo2, 2, false, miniAppInfo2.getReportType());
            MiniProgramLpReportDC04239.reportAsync(miniAppConfig, str13, str14, str12, str);
            miniAppExposureManager.addSearchItemAndCheckReport(miniAppModuleExposureData);
            reportShowHotKeywordApp(miniAppInfo, str);
            reportClassifySearchExpose(z16, str);
        }
    }
}
