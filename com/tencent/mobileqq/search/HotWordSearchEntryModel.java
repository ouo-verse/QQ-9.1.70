package com.tencent.mobileqq.search;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.content.ContextCompat;
import com.tencent.biz.widgets.HotWordTipsContainer;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.AbstractGifImage;
import com.tencent.image.GifDrawable;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.UniteSearchHandler;
import com.tencent.mobileqq.app.cw;
import com.tencent.mobileqq.kandian.biz.framework.api.IReadInJoyUtils;
import com.tencent.mobileqq.kandian.glue.router.api.IRIJJumpUtils;
import com.tencent.mobileqq.qcircle.api.IQCircleReportApi;
import com.tencent.mobileqq.qcircle.api.constant.QCircleLpReportDc05504DataBuilder;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.activity.UniteSearchActivity;
import com.tencent.mobileqq.search.fragment.SearchEntryFragment;
import com.tencent.mobileqq.search.fragment.searchentry.ISearchEntryFragment;
import com.tencent.mobileqq.search.model.HotWordSearchEntryDataModel;
import com.tencent.mobileqq.search.model.SearchEntryDataModel;
import com.tencent.mobileqq.search.report.ReportModelDC02528;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.QAdVrReportParams;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.utils.ax;
import com.tencent.mobileqq.utils.bi;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ThemeImageWrapper;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes18.dex */
public class HotWordSearchEntryModel extends BaseSearchEntryModel implements View.OnClickListener {
    protected View F;
    protected URLImageView G;
    protected RelativeLayout H;
    protected URLImageView I;
    protected TextView J;
    protected TextView K;
    protected HotWordTipsContainer L;
    protected View M;
    protected View N;
    protected TextView P;
    protected List<HotWordSearchEntryDataModel.HotSearchItem> Q;
    protected QQAppInterface R;
    protected Context S;
    protected HotWordSearchEntryDataModel T;
    private boolean U;
    HotWordTipsContainer.a V;

    /* compiled from: P */
    /* loaded from: classes18.dex */
    class a implements HotWordTipsContainer.a {
        a() {
        }

        @Override // com.tencent.biz.widgets.HotWordTipsContainer.a
        public void a(HotWordSearchEntryDataModel.HotSearchItem hotSearchItem) {
            HotWordSearchEntryDataModel.HotSearchItem hotSearchItem2;
            String str;
            if (hotSearchItem != null) {
                Iterator<HotWordSearchEntryDataModel.HotSearchItem> it = HotWordSearchEntryModel.this.Q.iterator();
                while (true) {
                    if (it.hasNext()) {
                        hotSearchItem2 = it.next();
                        if (TextUtils.equals(hotSearchItem.title, hotSearchItem2.title)) {
                            break;
                        }
                    } else {
                        hotSearchItem2 = null;
                        break;
                    }
                }
                if (hotSearchItem2 == null) {
                    return;
                }
                String str2 = hotSearchItem2.jumpUrl;
                if (TextUtils.isEmpty(str2)) {
                    SearchUtils.n1("\u540e\u53f0\u6ca1\u6709\u914d\u7f6e\u94fe\u63a5\uff0c\u7ec8\u7aef\u62fc\u63a5\u8df3\u8f6c");
                    int i3 = HotWordSearchEntryModel.this.mTabType;
                    if (i3 == 10) {
                        if (hotSearchItem2.type == 7) {
                            str = "kandian_recomword";
                        } else {
                            str = "kandian_hotword";
                        }
                        str2 = com.tencent.mobileqq.search.util.w.g(hotSearchItem2.recallWord, 5, str);
                    } else {
                        str2 = com.tencent.mobileqq.search.util.w.g(hotSearchItem2.recallWord, 5, com.tencent.mobileqq.search.util.w.d(i3));
                    }
                } else {
                    SearchUtils.n1("\u540e\u53f0\u914d\u7f6e\u4e86\u94fe\u63a5\uff0c\u4f7f\u7528\u540e\u53f0\u94fe\u63a5\u8df3\u8f6c");
                }
                if (QLog.isColorLevel()) {
                    QLog.d("Q.uniteSearch.HotWordSearchEntryModel", 2, "open Browser append suffix url = " + str2);
                }
                HotWordSearchEntryModel.this.E(str2, hotSearchItem2.recallWord);
                SearchUtils.W0("hot_list", "clk_hot_list", hotSearchItem2.title, String.valueOf(HotWordSearchEntryModel.this.mTabType), String.valueOf(HotWordSearchEntryModel.this.Q.indexOf(hotSearchItem2) + 1));
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("project", com.tencent.mobileqq.search.report.b.c());
                    jSONObject.put("event_src", "client");
                    jSONObject.put(QAdVrReportParams.ParamKey.EXPERIMENT_ID, com.tencent.mobileqq.search.report.b.f283718b);
                } catch (JSONException e16) {
                    QLog.e("Q.uniteSearch.HotWordSearchEntryModel", 2, "e = " + e16);
                }
                HotWordSearchEntryModel.this.H(hotSearchItem2, jSONObject.toString());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class b implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ HotWordSearchEntryDataModel.a f282602d;

        b(HotWordSearchEntryDataModel.a aVar) {
            this.f282602d = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (!TextUtils.isEmpty(this.f282602d.f283452d)) {
                HotWordSearchEntryModel hotWordSearchEntryModel = HotWordSearchEntryModel.this;
                SearchUtils.Q0(hotWordSearchEntryModel.R, hotWordSearchEntryModel.S, this.f282602d.f283452d);
                SearchUtils.W0("hot_list", "clk_title", String.valueOf(1), String.valueOf(HotWordSearchEntryModel.this.mTabType));
            } else {
                SearchUtils.W0("hot_list", "clk_title", String.valueOf(2), String.valueOf(HotWordSearchEntryModel.this.mTabType));
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class c implements e {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ HotWordSearchEntryDataModel.GIFInfo f282604a;

        c(HotWordSearchEntryDataModel.GIFInfo gIFInfo) {
            this.f282604a = gIFInfo;
        }

        @Override // com.tencent.mobileqq.search.HotWordSearchEntryModel.e
        public void a() {
            SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(BaseApplication.getContext());
            int i3 = defaultSharedPreferences.getInt("HotWordSearchEntryModel.psk_hot_search_try_time", 0);
            QQAppInterface qQAppInterface = (QQAppInterface) BaseApplicationImpl.getApplication().getRuntime();
            UniteSearchHandler uniteSearchHandler = new UniteSearchHandler(qQAppInterface);
            if (i3 == 1) {
                uniteSearchHandler.G2(qQAppInterface, "gif_suc_first", null, null, this.f282604a.hotSearchGifID);
            } else {
                uniteSearchHandler.G2(qQAppInterface, "gif_suc_second", null, null, this.f282604a.hotSearchGifID);
            }
            defaultSharedPreferences.edit().putString("HotWordSearchEntryModel.psk_hot_search_last_show_id", this.f282604a.hotSearchGifID).apply();
        }

        @Override // com.tencent.mobileqq.search.HotWordSearchEntryModel.e
        public void d() {
            SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(BaseApplication.getContext());
            int i3 = defaultSharedPreferences.getInt("HotWordSearchEntryModel.psk_hot_search_try_time", 0);
            String string = defaultSharedPreferences.getString("HotWordSearchEntryModel.psk_hot_search_try_id", "");
            QQAppInterface qQAppInterface = (QQAppInterface) BaseApplicationImpl.getApplication().getRuntime();
            UniteSearchHandler uniteSearchHandler = new UniteSearchHandler(qQAppInterface);
            if (!TextUtils.equals(string, this.f282604a.hotSearchGifID)) {
                defaultSharedPreferences.edit().putString("HotWordSearchEntryModel.psk_hot_search_try_id", this.f282604a.hotSearchGifID).apply();
                defaultSharedPreferences.edit().putInt("HotWordSearchEntryModel.psk_hot_search_try_time", 1).apply();
                uniteSearchHandler.G2(qQAppInterface, "gif_sta_first", null, null, this.f282604a.hotSearchGifID);
            } else {
                defaultSharedPreferences.edit().putInt("HotWordSearchEntryModel.psk_hot_search_try_time", i3 + 1).apply();
                uniteSearchHandler.G2(qQAppInterface, "gif_sta_second", null, null, this.f282604a.hotSearchGifID);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public interface e {
        void a();

        void d();
    }

    public HotWordSearchEntryModel(int i3, int i16, int i17) {
        super(i16, i17);
        this.Q = new ArrayList();
        this.U = false;
        this.V = new a();
        x(i3);
    }

    private void B(HotWordSearchEntryDataModel.a aVar) {
        if (aVar == null) {
            return;
        }
        this.I.setVisibility(8);
        if (!TextUtils.isEmpty(aVar.f283449a)) {
            this.J.setText(aVar.f283449a);
        } else {
            this.J.setText(BaseApplication.getContext().getResources().getString(R.string.f2204969_));
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.J.getLayoutParams();
        layoutParams.leftMargin = 0;
        this.J.setLayoutParams(layoutParams);
        this.P.setVisibility(8);
        this.K.setVisibility(8);
        this.N.setVisibility(8);
    }

    private void D(HotWordSearchEntryDataModel.a aVar) {
        if (aVar == null) {
            return;
        }
        String str = aVar.f283450b;
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        if (TextUtils.isEmpty(str)) {
            str = "https://res.imtt.qq.com/res_mtt/KDhotword/xiaohuomiao.png";
        }
        ColorDrawable colorDrawable = new ColorDrawable();
        if (ThemeUtil.isInNightMode(BaseApplicationImpl.getApplication().getRuntime())) {
            colorDrawable.setColor(ContextCompat.getColor(this.S, R.color.akc));
        } else {
            colorDrawable.setColor(ContextCompat.getColor(this.S, R.color.akb));
        }
        obtain.mLoadingDrawable = colorDrawable;
        obtain.mFailedDrawable = colorDrawable;
        this.I.setImageDrawable(URLDrawable.getDrawable(str, obtain));
        if (!TextUtils.isEmpty(aVar.f283449a)) {
            this.J.setText(aVar.f283449a);
        } else {
            this.J.setText(HardCodeUtil.qqStr(R.string.nbg));
        }
        if (!TextUtils.isEmpty(aVar.f283451c)) {
            this.K.setText(aVar.f283451c);
        } else {
            this.K.setVisibility(8);
        }
        if (aVar.f283453e == 1 && !TextUtils.isEmpty(aVar.f283454f)) {
            this.P.setVisibility(0);
            this.K.setVisibility(8);
        } else {
            this.P.setVisibility(8);
        }
        this.H.setOnClickListener(new b(aVar));
        this.N.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E(String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            ax c16 = bi.c(this.R, this.S, str);
            if (c16 != null) {
                c16.b();
                SearchUtil.f282611a = true;
                return;
            } else if (!str.startsWith("http://") && !str.startsWith("https://")) {
                if (QLog.isColorLevel()) {
                    QLog.d("Q.uniteSearch.HotWordSearchEntryModel", 2, "OnTipClickListener jumpUrl is illegal");
                    return;
                }
                return;
            } else {
                ((IRIJJumpUtils) QRoute.api(IRIJJumpUtils.class)).jumpToNativeSearchResultPage(this.S, str2, str);
                SearchUtil.f282611a = true;
                return;
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d("Q.uniteSearch.HotWordSearchEntryModel", 2, "OnTipClickListener jumpUrl is empty");
        }
    }

    private void F(HotWordSearchEntryDataModel.a aVar) {
        if (aVar == null) {
            return;
        }
        String str = aVar.f283450b;
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        if (TextUtils.isEmpty(str)) {
            str = "https://wezone-theme.cdn-go.cn/url-resource/latest/defaultmode/870/qsearch_qcircle/logo_qcircle@3x.png";
        }
        ColorDrawable colorDrawable = new ColorDrawable();
        if (ThemeUtil.isInNightMode(BaseApplicationImpl.getApplication().getRuntime())) {
            colorDrawable.setColor(this.S.getResources().getColor(R.color.akc));
        } else {
            colorDrawable.setColor(this.S.getResources().getColor(R.color.akb));
        }
        obtain.mLoadingDrawable = colorDrawable;
        obtain.mFailedDrawable = colorDrawable;
        this.I.setImageDrawable(URLDrawable.getDrawable(str, obtain));
        ViewGroup.LayoutParams layoutParams = this.I.getLayoutParams();
        int c16 = com.tencent.mobileqq.util.x.c(this.S, 22.0f);
        layoutParams.width = c16;
        layoutParams.height = c16;
        this.I.setLayoutParams(layoutParams);
        ViewGroup.LayoutParams layoutParams2 = this.H.getLayoutParams();
        layoutParams2.height = com.tencent.mobileqq.util.x.c(this.S, 50.0f);
        this.H.setPadding(com.tencent.mobileqq.util.x.c(this.S, 10.0f), 0, com.tencent.mobileqq.util.x.c(this.S, 16.0f), 0);
        this.H.setLayoutParams(layoutParams2);
        if (!TextUtils.isEmpty(aVar.f283449a)) {
            this.J.setText(aVar.f283449a);
        } else {
            this.J.setText(HardCodeUtil.qqStr(R.string.reb));
        }
        this.K.setVisibility(8);
        this.P.setVisibility(8);
        this.N.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H(HotWordSearchEntryDataModel.HotSearchItem hotSearchItem, String str) {
        int i3;
        int i16;
        int i17;
        QQAppInterface qQAppInterface = (QQAppInterface) BaseApplicationImpl.getApplication().getRuntime();
        UniteSearchHandler uniteSearchHandler = new UniteSearchHandler(qQAppInterface);
        int i18 = hotSearchItem.type;
        if (i18 != 7) {
            if (i18 != 8) {
                ReportModelDC02528 action = new ReportModelDC02528().module("hot_list").action("clk_hot_list");
                int i19 = this.mTabType;
                if (i19 == 3) {
                    i19 = 21;
                }
                com.tencent.mobileqq.search.report.b.h(null, action.ver2(com.tencent.mobileqq.search.report.b.a(i19)).ver4(hotSearchItem.title).ver7(str).session_id(qQAppInterface.getCurrentAccountUin() + this.mCreateTimestamp));
                int i26 = this.mTabType;
                if (i26 == 3) {
                    i26 = 21;
                }
                i3 = 3;
                uniteSearchHandler.H2(qQAppInterface, "clk_hot_list", "hot_list", com.tencent.mobileqq.search.report.b.a(i26), hotSearchItem.sAppend, hotSearchItem.title, str);
            } else {
                i3 = 3;
                try {
                    JSONObject jSONObject = new JSONObject(hotSearchItem.sExtInfo);
                    HashMap<String, String> hashMap = new HashMap<>();
                    hashMap.put("ext5", jSONObject.optString("ext5"));
                    hashMap.put("ext6", jSONObject.optString("ext6"));
                    hashMap.put("ext7", jSONObject.optString("ext7"));
                    hashMap.put("ext8", jSONObject.optString("ext8"));
                    ((IQCircleReportApi) QRoute.api(IQCircleReportApi.class)).report5504(new QCircleLpReportDc05504DataBuilder().setActionType(104).setSubActionType(1).setThrActionType(2).setExtras(hashMap));
                } catch (JSONException e16) {
                    e16.printStackTrace();
                }
            }
        } else {
            i3 = 3;
            ReportModelDC02528 action2 = new ReportModelDC02528().module("recom_list").action("clk_recom_list");
            int i27 = this.mTabType;
            if (i27 == 3) {
                i27 = 21;
            }
            com.tencent.mobileqq.search.report.b.h(null, action2.ver2(com.tencent.mobileqq.search.report.b.a(i27)).ver4(hotSearchItem.title).ver7(str).session_id(qQAppInterface.getCurrentAccountUin() + this.mCreateTimestamp));
            int i28 = this.mTabType;
            if (i28 == 3) {
                i28 = 21;
            }
            uniteSearchHandler.H2(qQAppInterface, "clk_recom_list", "recom_list", com.tencent.mobileqq.search.report.b.a(i28), hotSearchItem.sAppend, hotSearchItem.title, str);
        }
        HotWordSearchEntryDataModel.HotSearchItem hotSearchItem2 = UniteSearchActivity.f282686d0;
        if (hotSearchItem2 != null && TextUtils.equals(hotSearchItem2.title, hotSearchItem.title)) {
            ReportModelDC02528 action3 = new ReportModelDC02528().module("default_word").action("clk_default_word");
            int i29 = this.mTabType;
            if (i29 == i3) {
                i29 = 21;
            }
            com.tencent.mobileqq.search.report.b.h(null, action3.ver2(com.tencent.mobileqq.search.report.b.a(i29)).ver4(hotSearchItem.title).ver7(nn2.a.f420532c));
            int i36 = this.mTabType;
            if (i36 == i3) {
                i17 = 21;
            } else {
                i17 = i36;
            }
            i16 = 8;
            uniteSearchHandler.H2(qQAppInterface, "clk_default_word", "default_word", com.tencent.mobileqq.search.report.b.a(i17), hotSearchItem.sAppend, hotSearchItem.title, nn2.a.f420532c);
        } else {
            i16 = 8;
        }
        com.tencent.mobileqq.search.report.b.e(this.R, 0, SearchEntryFragment.convertTabTypeToSearchFrom(this.mTabType), "0X8009D28", 0, 0, null, null);
        cw cwVar = (cw) ((QQAppInterface) ((IReadInJoyUtils) QRoute.api(IReadInJoyUtils.class)).getAppRuntime()).getManager(QQManagerFactory.SEARCH_WORD_HISTORY_MANAGER);
        if (hotSearchItem.type != i16) {
            cwVar.c(hotSearchItem.recallWord);
        }
    }

    public static void I(Context context, URLImageView uRLImageView, String str, String str2, e eVar) {
        final URLDrawable drawable;
        if (context != null && uRLImageView != null && !TextUtils.isEmpty(str)) {
            SoftReference softReference = new SoftReference(uRLImageView);
            ColorDrawable colorDrawable = new ColorDrawable();
            URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
            obtain.mLoadingDrawable = colorDrawable;
            obtain.mFailedDrawable = colorDrawable;
            obtain.mPlayGifImage = true;
            obtain.mUseMemoryCache = false;
            if (ThemeUtil.isInNightMode(BaseApplicationImpl.getApplication().getRuntime())) {
                if (TextUtils.isEmpty(str2)) {
                    return;
                }
                colorDrawable.setColor(ContextCompat.getColor(context, R.color.akc));
                drawable = URLDrawable.getDrawable(str2, obtain);
            } else {
                colorDrawable.setColor(ContextCompat.getColor(context, R.color.akb));
                drawable = URLDrawable.getDrawable(str, obtain);
            }
            if (drawable == null) {
                return;
            }
            d dVar = new d(softReference, drawable, eVar);
            drawable.setURLDrawableListener(dVar);
            if (drawable.getStatus() == 1) {
                dVar.onLoadSuccessed(drawable);
            } else {
                ThreadManager.getFileThreadHandler().post(new Runnable() { // from class: com.tencent.mobileqq.search.HotWordSearchEntryModel.6
                    @Override // java.lang.Runnable
                    public void run() {
                        URLDrawable.this.downloadImediatly();
                    }
                });
            }
        }
    }

    public static boolean J(HotWordSearchEntryDataModel.GIFInfo gIFInfo) {
        if (gIFInfo == null || TextUtils.isEmpty(gIFInfo.hotSearchGifID) || TextUtils.isEmpty(gIFInfo.hotSearchGifUrl)) {
            return false;
        }
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(BaseApplication.getContext());
        if (TextUtils.equals(defaultSharedPreferences.getString("HotWordSearchEntryModel.psk_hot_search_last_show_id", ""), gIFInfo.hotSearchGifID)) {
            return false;
        }
        int i3 = defaultSharedPreferences.getInt("HotWordSearchEntryModel.psk_hot_search_try_time", 0);
        if (TextUtils.equals(gIFInfo.hotSearchGifID, defaultSharedPreferences.getString("HotWordSearchEntryModel.psk_hot_search_try_id", "")) && i3 >= 2) {
            return false;
        }
        return true;
    }

    private void K(final HotWordSearchEntryDataModel.GIFInfo gIFInfo) {
        if (gIFInfo == null) {
            return;
        }
        final c cVar = new c(gIFInfo);
        this.F.post(new Runnable() { // from class: com.tencent.mobileqq.search.HotWordSearchEntryModel.4
            @Override // java.lang.Runnable
            public void run() {
                if (!TextUtils.isEmpty(gIFInfo.hotSearchGifID) && !TextUtils.isEmpty(gIFInfo.hotSearchGifUrl) && !TextUtils.isEmpty(gIFInfo.hotSearchGifUrlNight)) {
                    int height = HotWordSearchEntryModel.this.F.getHeight();
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) HotWordSearchEntryModel.this.G.getLayoutParams();
                    layoutParams.height = height;
                    HotWordSearchEntryModel.this.G.setLayoutParams(layoutParams);
                    HotWordSearchEntryModel hotWordSearchEntryModel = HotWordSearchEntryModel.this;
                    Context context = hotWordSearchEntryModel.S;
                    URLImageView uRLImageView = hotWordSearchEntryModel.G;
                    HotWordSearchEntryDataModel.GIFInfo gIFInfo2 = gIFInfo;
                    HotWordSearchEntryModel.I(context, uRLImageView, gIFInfo2.hotSearchGifUrl, gIFInfo2.hotSearchGifUrlNight, cVar);
                }
            }
        });
        this.U = true;
    }

    public void C() {
        if (this.G.getVisibility() != 8) {
            this.G.setImageDrawable(null);
            this.G.setVisibility(8);
        }
    }

    public void G(HotWordSearchEntryDataModel.a aVar) {
        int i3 = this.T.f283456f;
        if (i3 != 1) {
            if (i3 != 8) {
                B(aVar);
                return;
            } else {
                F(aVar);
                return;
            }
        }
        D(aVar);
    }

    @Override // com.tencent.mobileqq.search.BaseSearchEntryModel
    public void o() {
        HotWordSearchEntryDataModel hotWordSearchEntryDataModel;
        int modelType = getModelType();
        if (modelType != 7) {
            if (modelType != 8) {
                hotWordSearchEntryDataModel = new HotWordSearchEntryDataModel(1, this.mTabType, true);
            } else {
                hotWordSearchEntryDataModel = new HotWordSearchEntryDataModel(8, this.mTabType, true);
            }
        } else {
            hotWordSearchEntryDataModel = new HotWordSearchEntryDataModel(7, this.mTabType, true);
        }
        p(hotWordSearchEntryDataModel);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        HotWordSearchEntryDataModel.a aVar;
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view.getId() == R.id.gr8) {
            HotWordSearchEntryDataModel hotWordSearchEntryDataModel = this.T;
            if (hotWordSearchEntryDataModel != null && (aVar = hotWordSearchEntryDataModel.F) != null && !TextUtils.isEmpty(aVar.f283454f)) {
                E(this.T.F.f283454f, "");
            } else if (QLog.isColorLevel()) {
                QLog.d("Q.uniteSearch.HotWordSearchEntryModel", 2, "qq_index_text jumpUrl is illegal");
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("project", com.tencent.mobileqq.search.report.b.c());
                jSONObject.put("event_src", "client");
            } catch (JSONException e16) {
                QLog.e("Q.uniteSearch.HotWordSearchEntryModel", 2, "e = " + e16);
            }
            SearchUtils.W0("hot_list", "clk_qq_index", "", String.valueOf(this.mTabType));
            ReportModelDC02528 action = new ReportModelDC02528().module("hot_list").action("clk_qq_index");
            int i3 = this.mTabType;
            if (i3 == 3) {
                i3 = 21;
            }
            com.tencent.mobileqq.search.report.b.h(null, action.ver2(com.tencent.mobileqq.search.report.b.a(i3)).ver7(jSONObject.toString()).session_id(this.R.getCurrentAccountUin() + this.mCreateTimestamp));
            com.tencent.mobileqq.search.report.b.e(this.R, 0, SearchEntryFragment.convertTabTypeToSearchFrom(this.mTabType), "0X8009D28", 0, 0, null, null);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.search.BaseSearchEntryModel
    public View s(Context context, QQAppInterface qQAppInterface, ViewGroup viewGroup, Bundle bundle) {
        Object obj;
        this.S = context;
        this.mCreateTimestamp = System.currentTimeMillis();
        if (qQAppInterface == null) {
            if (context instanceof BaseActivity) {
                obj = ((BaseActivity) context).getAppRuntime();
            } else {
                obj = null;
            }
            if (obj instanceof QQAppInterface) {
                qQAppInterface = (QQAppInterface) obj;
            }
        }
        if (qQAppInterface == null) {
            return new View(context);
        }
        this.R = qQAppInterface;
        View inflate = LayoutInflater.from(context).inflate(R.layout.aq6, (ViewGroup) null);
        this.F = inflate;
        inflate.setVisibility(8);
        this.H = (RelativeLayout) this.F.findViewById(R.id.jnz);
        this.I = (URLImageView) this.F.findViewById(R.id.f166988jp1);
        this.J = (TextView) this.F.findViewById(R.id.f166992jq2);
        this.K = (TextView) this.F.findViewById(R.id.f0q);
        TextView textView = (TextView) this.F.findViewById(R.id.gr8);
        this.P = textView;
        textView.setOnClickListener(this);
        this.L = (HotWordTipsContainer) this.F.findViewById(R.id.jmp);
        this.M = this.F.findViewById(R.id.f165000bn4);
        this.N = this.F.findViewById(R.id.bn5);
        this.G = (URLImageView) this.F.findViewById(R.id.f165713ll3);
        if (ThemeImageWrapper.isNightMode()) {
            this.M.setBackgroundColor(Color.parseColor("#000000"));
            this.K.setTextColor(Color.parseColor("#4A4A4A"));
            this.P.setTextColor(Color.parseColor("#4A4A4A"));
            Drawable drawable = context.getResources().getDrawable(R.drawable.mrr);
            this.K.setCompoundDrawablePadding(com.tencent.mobileqq.util.x.c(context, 5.0f));
            this.P.setCompoundDrawablePadding(com.tencent.mobileqq.util.x.c(context, 5.0f));
            this.K.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, drawable, (Drawable) null);
            this.P.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, drawable, (Drawable) null);
        }
        if (!this.showDivider) {
            this.M.setVisibility(8);
        } else {
            this.M.setVisibility(0);
        }
        this.L.setOnTipsClickListener(this.V);
        if (com.tencent.mobileqq.search.util.z.d()) {
            this.M.getLayoutParams().height = ViewUtils.dpToPx(8.0f);
            this.M.setBackgroundColor(0);
            this.H.getLayoutParams().height = ViewUtils.dpToPx(38.0f);
            this.J.setTextSize(1, 14.0f);
            this.J.setTextColor(AppCompatResources.getColorStateList(context, R.color.qui_common_text_primary));
            if (com.tencent.mobileqq.search.util.z.e()) {
                this.J.setAlpha(0.7f);
                this.H.setBackgroundColor(0);
                this.L.setBackgroundColor(0);
            } else {
                this.H.setBackgroundResource(R.drawable.qui_common_bg_bottom_light_bg);
                this.L.setBackgroundColor(R.drawable.qui_common_bg_bottom_light_bg);
            }
            this.K.setTextColor(AppCompatResources.getColorStateList(context, R.color.qui_common_text_secondary));
            this.P.setTextColor(AppCompatResources.getColorStateList(context, R.color.qui_common_text_secondary_selector));
            this.N.setBackgroundResource(R.drawable.qui_common_border_standard_bg);
            Drawable drawable2 = AppCompatResources.getDrawable(context, R.drawable.jae);
            this.P.setCompoundDrawablesRelativeWithIntrinsicBounds((Drawable) null, (Drawable) null, drawable2, (Drawable) null);
            this.K.setCompoundDrawablesRelativeWithIntrinsicBounds((Drawable) null, (Drawable) null, drawable2, (Drawable) null);
        }
        return this.F;
    }

    @Override // com.tencent.mobileqq.search.BaseSearchEntryModel
    public void t() {
        super.t();
    }

    @Override // com.tencent.mobileqq.search.BaseSearchEntryModel
    /* renamed from: y */
    public void S(SearchEntryDataModel searchEntryDataModel) {
        CopyOnWriteArrayList<HotWordSearchEntryDataModel.HotSearchItem> copyOnWriteArrayList;
        int i3;
        HotWordSearchEntryDataModel hotWordSearchEntryDataModel = (HotWordSearchEntryDataModel) searchEntryDataModel;
        if (hotWordSearchEntryDataModel != null && (copyOnWriteArrayList = hotWordSearchEntryDataModel.E) != null && copyOnWriteArrayList.size() != 0) {
            this.T = hotWordSearchEntryDataModel;
            this.F.setVisibility(0);
            this.Q.clear();
            this.Q.addAll(hotWordSearchEntryDataModel.E);
            this.L.i(hotWordSearchEntryDataModel, this.mTabType);
            if (hotWordSearchEntryDataModel.F == null) {
                this.H.setVisibility(8);
            } else {
                this.H.setVisibility(0);
                G(hotWordSearchEntryDataModel.F);
            }
            if (!this.U && J(this.T.G) && this.mTabType == 10) {
                K(this.T.G);
            }
            Boolean bool = ISearchEntryFragment.mIsModelsReported.get(Integer.valueOf(this.T.f283456f));
            if (bool == null || !bool.booleanValue()) {
                String str = "";
                StringBuilder sb5 = new StringBuilder("");
                if (hotWordSearchEntryDataModel.s() != null && hotWordSearchEntryDataModel.s().size() > 0) {
                    int size = hotWordSearchEntryDataModel.s().size();
                    int i16 = 0;
                    while (true) {
                        i3 = size - 1;
                        if (i16 >= i3) {
                            break;
                        }
                        sb5.append(hotWordSearchEntryDataModel.s().get(i16).title);
                        sb5.append("::");
                        i16++;
                    }
                    sb5.append(hotWordSearchEntryDataModel.s().get(i3).title);
                }
                SearchUtils.W0("hot_list", "exp_hot_list", sb5.toString(), String.valueOf(this.mTabType));
                ISearchEntryFragment.mIsModelsReported.put(Integer.valueOf(this.T.f283456f), Boolean.TRUE);
                if (this.Q.size() > 0) {
                    for (int i17 = 0; i17 < this.Q.size() - 1; i17++) {
                        String str2 = this.Q.get(i17).title;
                    }
                    List<HotWordSearchEntryDataModel.HotSearchItem> list = this.Q;
                    Objects.toString(list.get(list.size() - 1));
                }
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("project", com.tencent.mobileqq.search.report.b.c());
                    jSONObject.put("event_src", "client");
                    jSONObject.put(QAdVrReportParams.ParamKey.EXPERIMENT_ID, com.tencent.mobileqq.search.report.b.f283718b);
                } catch (JSONException e16) {
                    QLog.e("Q.uniteSearch.HotWordSearchEntryModel", 2, "e = " + e16);
                }
                QQAppInterface qQAppInterface = (QQAppInterface) BaseApplicationImpl.getApplication().getRuntime();
                UniteSearchHandler uniteSearchHandler = new UniteSearchHandler(qQAppInterface);
                if (this.Q.size() > 0) {
                    str = this.Q.get(0).sAppend;
                }
                String str3 = str;
                int i18 = 21;
                if (searchEntryDataModel.f283456f == 7) {
                    ReportModelDC02528 action = new ReportModelDC02528().module("recom_list").action("exp_recom_list");
                    int i19 = this.mTabType;
                    if (i19 == 3) {
                        i19 = 21;
                    }
                    com.tencent.mobileqq.search.report.b.h(null, action.ver2(com.tencent.mobileqq.search.report.b.a(i19)).ver4(sb5.toString()).ver7(jSONObject.toString()).session_id(qQAppInterface.getCurrentAccountUin() + this.mCreateTimestamp));
                    int i26 = this.mTabType;
                    if (i26 != 3) {
                        i18 = i26;
                    }
                    uniteSearchHandler.H2(qQAppInterface, "exp_recom_list", "recom_list", com.tencent.mobileqq.search.report.b.a(i18), str3, sb5.toString(), jSONObject.toString());
                } else {
                    ReportModelDC02528 action2 = new ReportModelDC02528().module("hot_list").action("exp_hot_list");
                    int i27 = this.mTabType;
                    if (i27 == 3) {
                        i27 = 21;
                    }
                    com.tencent.mobileqq.search.report.b.h(null, action2.ver2(com.tencent.mobileqq.search.report.b.a(i27)).ver4(sb5.toString()).ver7(jSONObject.toString()).session_id(qQAppInterface.getCurrentAccountUin() + this.mCreateTimestamp));
                    int i28 = this.mTabType;
                    if (i28 != 3) {
                        i18 = i28;
                    }
                    uniteSearchHandler.H2(qQAppInterface, "exp_hot_list", "hot_list", com.tencent.mobileqq.search.report.b.a(i18), str3, sb5.toString(), jSONObject.toString());
                }
                com.tencent.mobileqq.search.report.b.e(qQAppInterface, 0, SearchEntryFragment.convertTabTypeToSearchFrom(this.mTabType), "0X8009D27", 0, 0, null, null);
                return;
            }
            return;
        }
        this.F.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class d implements URLDrawable.URLDrawableListener2 {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ SoftReference f282606d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ URLDrawable f282607e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ e f282608f;

        /* compiled from: P */
        /* loaded from: classes18.dex */
        class a implements GifDrawable.OnGIFPlayOnceListener {

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ AbstractGifImage f282609d;

            a(AbstractGifImage abstractGifImage) {
                this.f282609d = abstractGifImage;
            }

            @Override // com.tencent.image.GifDrawable.OnGIFPlayOnceListener
            public void onPlayOnce() {
                this.f282609d.setStrongGIFPlayOnceListener(null);
                e eVar = d.this.f282608f;
                if (eVar != null) {
                    eVar.a();
                }
                if (d.this.f282606d.get() == null) {
                    return;
                }
                AbstractGifImage.pauseAll();
                ((URLImageView) d.this.f282606d.get()).setVisibility(8);
            }
        }

        d(SoftReference softReference, URLDrawable uRLDrawable, e eVar) {
            this.f282606d = softReference;
            this.f282607e = uRLDrawable;
            this.f282608f = eVar;
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadSuccessed(URLDrawable uRLDrawable) {
            if (this.f282606d.get() == null) {
                return;
            }
            URLImageView uRLImageView = (URLImageView) this.f282606d.get();
            if (this.f282607e.getCurrDrawable() instanceof GifDrawable) {
                AbstractGifImage image = ((GifDrawable) this.f282607e.getCurrDrawable()).getImage();
                image.reset();
                image.setStrongGIFPlayOnceListener(new a(image));
                uRLImageView.setVisibility(0);
                uRLImageView.setImageDrawable(this.f282607e);
                e eVar = this.f282608f;
                if (eVar != null) {
                    eVar.d();
                }
            }
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener2
        public void onFileDownloaded(URLDrawable uRLDrawable) {
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadCanceled(URLDrawable uRLDrawable) {
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadFialed(URLDrawable uRLDrawable, Throwable th5) {
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadProgressed(URLDrawable uRLDrawable, int i3) {
        }
    }
}
