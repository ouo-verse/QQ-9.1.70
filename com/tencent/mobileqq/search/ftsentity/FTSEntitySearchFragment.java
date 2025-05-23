package com.tencent.mobileqq.search.ftsentity;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.qui.quiemptystate.QUIEmptyState;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.RichTextHelper;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.search.base.activity.BaseSearchActivity;
import com.tencent.mobileqq.search.base.activity.SearchMoreActivity;
import com.tencent.mobileqq.search.base.fragment.BaseSearchFragment;
import com.tencent.mobileqq.search.model.v;
import com.tencent.mobileqq.search.model.y;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.PageReportPolicy;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.qqnt.msg.migration.NTMsgMigrationManager;
import com.tencent.widget.AbsListView;
import com.tencent.widget.ListView;
import ep2.e;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import qn2.d;

/* compiled from: P */
/* loaded from: classes18.dex */
public class FTSEntitySearchFragment extends BaseSearchFragment<v> {
    private volatile Integer C;
    private boolean E;
    private int G;
    private volatile boolean D = true;
    private List F = new ArrayList();

    /* compiled from: P */
    /* loaded from: classes18.dex */
    class b extends mn2.b<y, sn2.c> {
        b(ListView listView, IFaceDecoder iFaceDecoder) {
            super(listView, iFaceDecoder);
        }

        @Override // mn2.a
        protected d<y, sn2.c> e(int i3) {
            return new com.tencent.mobileqq.search.presenter.c(((BaseSearchFragment) FTSEntitySearchFragment.this).faceDecoder);
        }

        @Override // mn2.a
        protected sn2.d f(int i3, ViewGroup viewGroup) {
            int i16;
            if (FTSEntitySearchFragment.this.getArguments() != null && FTSEntitySearchFragment.this.getArguments().getInt("key_situation") == 2) {
                i16 = R.layout.bxr;
            } else {
                i16 = R.layout.bxt;
            }
            return new ao2.a(viewGroup, i16);
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            ReportController.o(((BaseSearchFragment) FTSEntitySearchFragment.this).appInterface, "dc00898", "", "", "0X800C4DB", "0X800C4DB", NTMsgMigrationManager.X().h0(), 0, "", "", "", "");
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    private PageParams sh(boolean z16) {
        String str;
        int i3 = 0;
        String str2 = "";
        if (getArguments() == null) {
            str = "";
        } else {
            i3 = getArguments().getInt("dtReferPage", 0);
            str = getArguments().getString("trace_id");
        }
        if (!TextUtils.isEmpty(str)) {
            str2 = str;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("referpage", Integer.valueOf(i3));
        hashMap.put("search_query_text", "@\u6211");
        hashMap.put("have_result", Integer.valueOf(z16 ? 1 : 0));
        hashMap.put("search_trace_id", str2);
        return new PageParams(hashMap);
    }

    private void th() {
        int childCount = this.noResultLayout.getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            this.noResultLayout.getChildAt(i3).setVisibility(8);
        }
        this.noResultLayout.setGravity(17);
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.noResultLayout.getLayoutParams();
        marginLayoutParams.height = -1;
        marginLayoutParams.width = -1;
        marginLayoutParams.leftMargin = 0;
        marginLayoutParams.rightMargin = 0;
        marginLayoutParams.topMargin = 0;
        this.noResultLayout.addView(new QUIEmptyState.Builder(getContext()).setImageType(8).setTitle("\u6682\u65e0@\u6211\u76f8\u5173\u804a\u5929\u8bb0\u5f55").build(), -1, -1);
    }

    public static FTSEntitySearchFragment uh(String str) {
        FTSEntitySearchFragment fTSEntitySearchFragment = new FTSEntitySearchFragment();
        Bundle bundle = new Bundle(1);
        bundle.putString("keyword", str);
        fTSEntitySearchFragment.setArguments(bundle);
        return fTSEntitySearchFragment;
    }

    private void vh(boolean z16) {
        if (this.activityContentView != null) {
            VideoReport.addToDetectionWhitelist(getActivity());
            VideoReport.setPageId(this.activityContentView, "pg_bans_at_me_function");
            VideoReport.setPageReportPolicy(this.activityContentView, PageReportPolicy.REPORT_ALL);
            VideoReport.setPageParams(this.activityContentView, sh(z16));
        }
    }

    public static void wh(Context context, String str, int i3, int i16, int i17, String str2, String str3, String str4) {
        Bundle bundle = new Bundle();
        bundle.putString("keyword", str);
        bundle.putBoolean(BaseSearchFragment.KEY_NEED_SHOW_HEADER, false);
        bundle.putInt("key_fit_type", i3);
        bundle.putInt("key_situation", i16);
        bundle.putInt("dtReferPage", i17);
        bundle.putString("trace_id", str2);
        bundle.putString("peerId", str3);
        SearchMoreActivity.INSTANCE.a(context, FTSEntitySearchFragment.class, str4, bundle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xh() {
        if (this.C != null && !this.E && this.D) {
            this.E = true;
            pn2.a aVar = new pn2.a(this.keyword);
            Bundle bundle = new Bundle();
            aVar.f426496b = bundle;
            bundle.putInt("queryId", this.C.intValue());
            startSearch(aVar, 3);
            QLog.d("FTSEntitySearchFragment", 1, "trySearchMore queryId:", this.C, " keyword: ", this.keyword);
        }
    }

    @Override // com.tencent.mobileqq.search.base.fragment.BaseSearchFragment
    protected String getHeaderText() {
        return e.c(getActivity());
    }

    @Override // com.tencent.mobileqq.search.base.fragment.BaseSearchFragment
    protected Bundle getOtherSearchRequestExtraInfo() {
        String str;
        String str2;
        Bundle bundle = new Bundle();
        int i3 = this.G;
        int i16 = 2;
        if (i3 == 1 || i3 == 2) {
            int i17 = 0;
            String str3 = "";
            if (getArguments() == null) {
                str = "";
                str2 = str;
            } else {
                i17 = getArguments().getInt("dtReferPage", 0);
                str = getArguments().getString("trace_id");
                str2 = getArguments().getString("peerId");
            }
            if (!TextUtils.isEmpty(str)) {
                str3 = str;
            }
            int i18 = this.G;
            if (i18 != 1 && i18 == 2) {
                i16 = 3;
            }
            bundle.putInt("key_search_type", i16);
            bundle.putInt("search_req_key_dt_refer_page", i17);
            bundle.putString("search_req_key_peerId", str2);
            bundle.putString("search_req_key_trace_id", str3);
        }
        return bundle;
    }

    @Override // com.tencent.mobileqq.search.base.fragment.BaseSearchFragment
    protected String getRightTvText() {
        return HardCodeUtil.qqStr(R.string.jzq);
    }

    @Override // com.tencent.mobileqq.search.base.fragment.BaseSearchFragment
    protected mn2.a newAdapter() {
        return new b(this.listView, this.faceDecoder);
    }

    @Override // com.tencent.mobileqq.search.base.fragment.BaseSearchFragment
    protected on2.b newSearchEngine() {
        int i3;
        if (getArguments() != null && getArguments().getInt("key_fit_type", -999) != -999) {
            i3 = getArguments().getInt("key_fit_type");
        } else {
            i3 = ((BaseSearchActivity) getQBaseActivity()).f282787f0;
        }
        return e.f((QQAppInterface) this.appInterface, i3);
    }

    @Override // com.tencent.mobileqq.search.base.fragment.BaseSearchFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getArguments() != null) {
            this.keyword = getArguments().getString("keyword");
            this.G = getArguments().getInt("key_situation");
        }
    }

    @Override // com.tencent.mobileqq.search.base.fragment.BaseSearchFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View onCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
        this.listView.addOnScrollListener(new a());
        int i3 = this.G;
        if (i3 == 1 || i3 == 2) {
            th();
        }
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, onCreateView);
        return onCreateView;
    }

    @Override // com.tencent.mobileqq.search.base.fragment.BaseSearchFragment, on2.d
    public void onFinish(List list, pn2.b bVar) {
        if (bVar.a(this.keyword)) {
            Bundle bundle = bVar.f426499b;
            if (bundle != null && bundle.containsKey("queryId")) {
                this.C = Integer.valueOf(bVar.f426499b.getInt("queryId"));
            } else {
                this.C = null;
            }
            Bundle bundle2 = bVar.f426499b;
            boolean z16 = (bundle2 == null || !bundle2.containsKey("extra_is_first_page")) ? false : bVar.f426499b.getBoolean("extra_is_first_page");
            Bundle bundle3 = bVar.f426499b;
            if (bundle3 != null) {
                this.D = bundle3.getBoolean("extra_has_more", true);
            }
            if (z16) {
                vh(list != null && list.size() > 0);
            }
            onFinish(list, bVar.f426500c, z16);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("FTSEntitySearchFragment", 2, "onFinish not match keyword1:", bVar.f426498a, " keyword2:", this.keyword);
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        this.searchEngine.pause();
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        this.searchEngine.resume();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.search.base.fragment.BaseSearchFragment
    public void onSearchFinished(List<v> list) {
        this.E = false;
        if (list != null && !list.isEmpty()) {
            QLog.d("FTSEntitySearchFragment", 1, "onSearchFinished resultList:", Integer.valueOf(list.size()));
        }
        super.onSearchFinished(list);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.search.base.fragment.BaseSearchFragment
    public void showNoMoreResult(boolean z16) {
        if (this.noMoreResultView != null && getActivity() != null) {
            if (NTMsgMigrationManager.X().F0()) {
                if (z16) {
                    ReportController.o(this.appInterface, "dc00898", "", "", "0X800C4DA", "0X800C4DA", NTMsgMigrationManager.X().h0(), 0, "", "", "", "");
                }
                this.noMoreResultView.setText(NTMsgMigrationManager.X().e0(getContext(), new c()));
                this.noMoreResultView.setMovementMethod(RichTextHelper.getMovementMethodInstance());
            } else {
                this.noMoreResultView.setText(BaseApplication.getContext().getString(R.string.f172446qv2));
            }
            super.showNoMoreResult(z16);
        }
    }

    @Override // com.tencent.mobileqq.search.base.fragment.BaseSearchFragment
    public void startSearch(String str) {
        mn2.a aVar;
        if (!TextUtils.isEmpty(this.keyword) && !TextUtils.equals(str, this.keyword) && (aVar = this.adapter) != null) {
            aVar.g(new ArrayList());
            this.C = null;
        }
        QLog.d("FTSEntitySearchFragment", 1, "startSearch queryId:", this.C, " keyword: ", str);
        startSearch(str, 1);
    }

    @Override // com.tencent.mobileqq.search.base.fragment.BaseSearchFragment
    public void onFinish(List<v> list, int i3, boolean z16) {
        super.onFinish(list, i3, z16);
        if (this.isReported) {
            return;
        }
        String[] strArr = new String[2];
        strArr[0] = "" + this.keyword;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("");
        sb5.append(list != null ? list.size() : 0);
        strArr[1] = sb5.toString();
        SearchUtils.W0("talk", "exp_page", strArr);
        this.isReported = true;
    }

    @Override // com.tencent.mobileqq.search.base.fragment.BaseSearchFragment, on2.d
    public void onFinish(List list, int i3) {
        super.onFinish(list, i3);
        if (this.isReported) {
            return;
        }
        String[] strArr = new String[2];
        strArr[0] = "" + this.keyword;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("");
        sb5.append(list != null ? list.size() : 0);
        strArr[1] = sb5.toString();
        SearchUtils.W0("talk", "exp_page", strArr);
        this.isReported = true;
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    class a implements AbsListView.OnScrollListener {
        a() {
        }

        @Override // com.tencent.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i3, int i16, int i17) {
            if (i17 > 0 && i3 + i16 > i17 - 5) {
                FTSEntitySearchFragment.this.xh();
            }
        }

        @Override // com.tencent.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i3) {
        }
    }
}
