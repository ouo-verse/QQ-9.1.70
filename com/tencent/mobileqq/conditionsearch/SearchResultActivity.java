package com.tencent.mobileqq.conditionsearch;

import SummaryCard.CondFitUser;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.addfriend.api.IAddFriendApi;
import com.tencent.mobileqq.app.ConditionSearchManager;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.avatar.api.IQQAvatarService;
import com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener;
import com.tencent.mobileqq.profilecard.api.IProfileCardConst;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.utils.ProfileCardConst;
import com.tencent.mobileqq.profilecard.utils.ProfileUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.richstatus.StatusManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.ca;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqnt.ntrelation.friendsinfo.api.IFriendsInfoService;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import com.tencent.util.WeakReferenceHandler;
import com.tencent.widget.AbsListView;
import com.tencent.widget.XListView;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes5.dex */
public class SearchResultActivity extends IphoneTitleBarActivity implements DecodeTaskCompletionListener, AbsListView.OnScrollListener, View.OnClickListener {
    static IPatchRedirector $redirector_;

    /* renamed from: m0, reason: collision with root package name */
    static final boolean f201989m0;

    /* renamed from: n0, reason: collision with root package name */
    private static List<CondFitUser> f201990n0;

    /* renamed from: a0, reason: collision with root package name */
    XListView f201991a0;

    /* renamed from: b0, reason: collision with root package name */
    int f201992b0;

    /* renamed from: c0, reason: collision with root package name */
    c f201993c0;

    /* renamed from: d0, reason: collision with root package name */
    IFaceDecoder f201994d0;

    /* renamed from: e0, reason: collision with root package name */
    List<CondFitUser> f201995e0;

    /* renamed from: f0, reason: collision with root package name */
    Set<Long> f201996f0;

    /* renamed from: g0, reason: collision with root package name */
    StatusManager f201997g0;

    /* renamed from: h0, reason: collision with root package name */
    ConditionSearchManager f201998h0;

    /* renamed from: i0, reason: collision with root package name */
    int f201999i0;

    /* renamed from: j0, reason: collision with root package name */
    private Handler f202000j0;

    /* renamed from: k0, reason: collision with root package name */
    private Handler.Callback f202001k0;

    /* renamed from: l0, reason: collision with root package name */
    ConditionSearchManager.e f202002l0;

    /* compiled from: P */
    /* loaded from: classes5.dex */
    class a implements Handler.Callback {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SearchResultActivity.this);
            }
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) message)).booleanValue();
            }
            int i3 = message.what;
            if (i3 != 3) {
                if (i3 != 4) {
                    if (i3 == 5) {
                        SearchResultActivity.this.f201991a0.springBackOverScrollHeaderView();
                        return true;
                    }
                    return true;
                }
                SearchResultActivity.this.f201991a0.springBackOverScrollHeaderView();
                return true;
            }
            SearchResultActivity.this.f201991a0.springBackOverScrollHeaderView();
            QQToast.makeText(SearchResultActivity.this, R.string.f171139ci4, 0).show(SearchResultActivity.this.getTitleBarHeight());
            return true;
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    class b implements ConditionSearchManager.e {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SearchResultActivity.this);
            }
        }

        @Override // com.tencent.mobileqq.app.ConditionSearchManager.e
        public void a(boolean z16, List<CondFitUser> list, boolean z17, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), list, Boolean.valueOf(z17), Integer.valueOf(i3));
                return;
            }
            if (i3 == 3) {
                if (!z16) {
                    SearchResultActivity.this.f201999i0 = 3;
                } else {
                    if (list != null && !list.isEmpty()) {
                        SearchResultActivity.this.f201995e0.addAll(list);
                    }
                    SearchResultActivity.this.f201999i0 = z17 ? 1 : 0;
                }
                SearchResultActivity.this.f201993c0.notifyDataSetChanged();
                return;
            }
            if (i3 == 2) {
                if (z16) {
                    com.tencent.qqperf.opt.threadpriority.b.k(true);
                    if (list != null && !list.isEmpty()) {
                        SearchResultActivity.this.f201995e0.clear();
                        SearchResultActivity.this.f201995e0.addAll(list);
                    }
                    SearchResultActivity.this.f201993c0.notifyDataSetChanged();
                    com.tencent.qqperf.opt.threadpriority.b.k(false);
                    Message obtain = Message.obtain();
                    obtain.what = 5;
                    SearchResultActivity.this.f202000j0.sendMessageDelayed(obtain, 1000L);
                    return;
                }
                Message obtain2 = Message.obtain();
                obtain2.what = 4;
                SearchResultActivity.this.f202000j0.sendMessageDelayed(obtain2, 1000L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class c extends BaseAdapter {
        static IPatchRedirector $redirector_;

        /* compiled from: P */
        /* loaded from: classes5.dex */
        class a implements View.OnClickListener {
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ int f202006d;

            a(int i3) {
                this.f202006d = i3;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) c.this, i3);
                }
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                CondFitUser condFitUser;
                EventCollector.getInstance().onViewClickedBefore(view);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
                } else {
                    List<CondFitUser> list = SearchResultActivity.this.f201995e0;
                    if (list != null && this.f202006d < list.size()) {
                        condFitUser = SearchResultActivity.this.f201995e0.get(this.f202006d);
                    } else {
                        condFitUser = null;
                    }
                    SearchResultActivity.this.P2(condFitUser);
                }
                EventCollector.getInstance().onViewClicked(view);
            }
        }

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SearchResultActivity.this);
            }
        }

        private void a(View view, View view2, String str) {
            VideoReport.setElementId(view, "em_searching_people_unit");
            VideoReport.setElementParam(view, "to_uin", str);
            ClickPolicy clickPolicy = ClickPolicy.REPORT_ALL;
            VideoReport.setElementClickPolicy(view, clickPolicy);
            ExposurePolicy exposurePolicy = ExposurePolicy.REPORT_ALL;
            VideoReport.setElementExposePolicy(view, exposurePolicy);
            VideoReport.setElementId(view2, "em_searching_people_add");
            VideoReport.setElementParam(view2, "to_uin", str);
            VideoReport.setElementClickPolicy(view2, clickPolicy);
            VideoReport.setElementExposePolicy(view2, exposurePolicy);
        }

        @Override // android.widget.Adapter
        public int getCount() {
            int i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
            }
            int size = SearchResultActivity.this.f201995e0.size();
            if (SearchResultActivity.this.f201999i0 != 0) {
                i3 = 1;
            } else {
                i3 = 0;
            }
            return size + i3;
        }

        @Override // android.widget.Adapter
        public Object getItem(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return iPatchRedirector.redirect((short) 3, (Object) this, i3);
            }
            return null;
        }

        @Override // android.widget.Adapter
        public long getItemId(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return ((Long) iPatchRedirector.redirect((short) 6, (Object) this, i3)).longValue();
            }
            return i3;
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public int getItemViewType(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this, i3)).intValue();
            }
            if (i3 < SearchResultActivity.this.f201995e0.size()) {
                return 0;
            }
            return 1;
        }

        @Override // android.widget.Adapter
        public View getView(int i3, View view, ViewGroup viewGroup) {
            String str;
            View view2;
            View view3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                view2 = (View) iPatchRedirector.redirect((short) 7, this, Integer.valueOf(i3), view, viewGroup);
                view3 = view;
            } else {
                CondFitUser condFitUser = null;
                if (getItemViewType(i3) == 0) {
                    if (view == null) {
                        view = SearchResultActivity.this.getLayoutInflater().inflate(R.layout.ast, (ViewGroup) null);
                        view.setOnClickListener(SearchResultActivity.this);
                        d dVar = new d();
                        dVar.f202008a = (ImageView) view.findViewById(R.id.d3i);
                        dVar.f202009b = (TextView) view.findViewById(R.id.f9r);
                        dVar.f202010c = (TextView) view.findViewById(R.id.ivg);
                        dVar.f202012e = (TextView) view.findViewById(R.id.cso);
                        dVar.f202013f = (TextView) view.findViewById(R.id.l67);
                        dVar.f202011d = (TextView) view.findViewById(R.id.ard);
                        dVar.f202014g = (TextView) view.findViewById(R.id.eg_);
                        SearchResultActivity.this.K2(dVar);
                        Button button = (Button) view.findViewById(R.id.u3b);
                        dVar.f202016i = button;
                        button.setOnClickListener(new a(i3));
                        view.setTag(dVar);
                    }
                    d dVar2 = (d) view.getTag();
                    List<CondFitUser> list = SearchResultActivity.this.f201995e0;
                    if (list != null && i3 < list.size()) {
                        condFitUser = SearchResultActivity.this.f201995e0.get(i3);
                    }
                    String L2 = SearchResultActivity.this.L2(dVar2, condFitUser);
                    if (SearchResultActivity.f201989m0) {
                        view.setContentDescription(L2);
                    }
                } else {
                    if (view == null) {
                        view = SearchResultActivity.this.getLayoutInflater().inflate(R.layout.f168308si, (ViewGroup) null);
                        view.setOnClickListener(SearchResultActivity.this);
                        e eVar = new e();
                        view.setTag(eVar);
                        eVar.f202017a = (ProgressBar) view.findViewById(R.id.i5n);
                        view.findViewById(R.id.eex).setVisibility(8);
                        eVar.f202018b = (TextView) view.findViewById(R.id.f0v);
                    }
                    SearchResultActivity searchResultActivity = SearchResultActivity.this;
                    if (searchResultActivity.f201999i0 == 1) {
                        searchResultActivity.f201999i0 = 2;
                        searchResultActivity.N2();
                    }
                    e eVar2 = (e) view.getTag();
                    int i16 = SearchResultActivity.this.f201999i0;
                    if (i16 == 3) {
                        eVar2.f202017a.setVisibility(8);
                        eVar2.f202018b.setText(HardCodeUtil.qqStr(R.string.t7e));
                    } else if (i16 == 2) {
                        eVar2.f202017a.setVisibility(0);
                        eVar2.f202018b.setText(HardCodeUtil.qqStr(R.string.t76));
                    } else if (i16 == 4) {
                        eVar2.f202017a.setVisibility(8);
                        eVar2.f202018b.setText(HardCodeUtil.qqStr(R.string.t75));
                    }
                }
                if (ThemeUtil.isDefaultTheme()) {
                    view.setBackgroundResource(R.drawable.f160540jm);
                } else {
                    view.setBackgroundResource(R.drawable.common_list_item_background);
                }
                View findViewById = view.findViewById(R.id.u3b);
                List<CondFitUser> list2 = SearchResultActivity.this.f201995e0;
                if (list2 != null && i3 < list2.size()) {
                    str = String.valueOf(SearchResultActivity.this.f201995e0.get(i3).lUIN);
                } else {
                    str = "";
                }
                a(view, findViewById, str);
                view2 = view;
                view3 = view2;
            }
            EventCollector.getInstance().onListGetView(i3, view3, viewGroup, getItemId(i3));
            return view2;
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public int getViewTypeCount() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
            }
            return 2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static class d {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public ImageView f202008a;

        /* renamed from: b, reason: collision with root package name */
        public TextView f202009b;

        /* renamed from: c, reason: collision with root package name */
        public TextView f202010c;

        /* renamed from: d, reason: collision with root package name */
        public TextView f202011d;

        /* renamed from: e, reason: collision with root package name */
        public TextView f202012e;

        /* renamed from: f, reason: collision with root package name */
        public TextView f202013f;

        /* renamed from: g, reason: collision with root package name */
        public TextView f202014g;

        /* renamed from: h, reason: collision with root package name */
        public String f202015h;

        /* renamed from: i, reason: collision with root package name */
        public Button f202016i;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    static class e {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public ProgressBar f202017a;

        /* renamed from: b, reason: collision with root package name */
        public TextView f202018b;

        e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(71281);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 8)) {
            redirector.redirect((short) 8);
        } else {
            f201989m0 = AppSetting.f99565y;
            f201990n0 = null;
        }
    }

    public SearchResultActivity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f201992b0 = 0;
        this.f201999i0 = 0;
        this.f202001k0 = new a();
        this.f202002l0 = new b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K2(d dVar) {
        if (dVar != null && QQTheme.isNowThemeIsNight()) {
            TextView textView = dVar.f202012e;
            if (textView != null) {
                textView.setBackgroundResource(R.drawable.ji9);
            }
            TextView textView2 = dVar.f202013f;
            if (textView2 != null) {
                textView2.setBackgroundResource(R.drawable.ji9);
            }
            TextView textView3 = dVar.f202011d;
            if (textView3 != null) {
                textView3.setBackgroundResource(R.drawable.ji9);
            }
            TextView textView4 = dVar.f202014g;
            if (textView4 != null) {
                textView4.setBackgroundResource(R.drawable.ji9);
            }
        }
    }

    private void M2() {
        Intent intent = getIntent();
        String stringExtra = intent.getStringExtra("key_keyword");
        if (stringExtra == null) {
            stringExtra = "";
        }
        int intExtra = intent.getIntExtra("key_sex_index", 0);
        int[] iArr = {intent.getIntExtra("key_age_index1", 0), intent.getIntExtra("key_age_index2", 0)};
        String[] stringArrayExtra = intent.getStringArrayExtra("key_loc_code");
        String[] stringArrayExtra2 = intent.getStringArrayExtra("key_home_code");
        int intExtra2 = intent.getIntExtra("key_xingzuo_index", 0);
        int intExtra3 = intent.getIntExtra("key_job_index", 0);
        QLog.i("SearchResultActivity", 1, "initDTPageReport, keyword=" + stringExtra + ", minAge=" + Arrays.toString(iArr) + ", gender=" + intExtra + ", locationCodes=" + Arrays.toString(stringArrayExtra) + ", homeCodes=" + Arrays.toString(stringArrayExtra2) + ", constellationIndex=" + intExtra2 + ", jobIndex=" + intExtra3);
        VideoReport.addToDetectionWhitelist(this);
        VideoReport.setPageId(this.mContentView, "pg_searching_people_result");
        VideoReport.setPageParams(this.mContentView, "search_query", stringExtra);
        VideoReport.setPageParams(this.mContentView, "gender_search_condition", Integer.valueOf(intExtra));
        VideoReport.setPageParams(this.mContentView, "age_search_criteria", iArr);
        VideoReport.setPageParams(this.mContentView, "job_search_criteria", Integer.valueOf(intExtra3));
        VideoReport.setPageParams(this.mContentView, "location_search_condition", Arrays.toString(stringArrayExtra));
        VideoReport.setPageParams(this.mContentView, "hometown_search_criteria", Arrays.toString(stringArrayExtra2));
        VideoReport.setPageParams(this.mContentView, "constellation_search_condition", Integer.valueOf(intExtra2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void N2() {
        if (!NetworkUtil.isNetSupport(this)) {
            this.f201999i0 = 4;
            this.f201993c0.notifyDataSetChanged();
            return;
        }
        this.f201998h0.g(this.f202002l0);
        try {
            this.f201998h0.c0(false, null, 0, 0, 0, null, null, 0, 0, 3);
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d("SearchResultActivity", 2, e16, new Object[0]);
            }
            this.f201999i0 = 0;
            this.f201993c0.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P2(CondFitUser condFitUser) {
        if (this.app != null && !isFinishing() && condFitUser != null) {
            long j3 = condFitUser.lUIN;
            if (j3 > 0) {
                String valueOf = String.valueOf(j3);
                ReportController.o(this.app, "CliOper", "", valueOf, "0X800C0FA", "0X800C0FA", 0, 0, valueOf, "", "", "");
                FriendsManager friendsManager = (FriendsManager) this.app.getManager(QQManagerFactory.FRIENDS_MANAGER);
                if (!((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).isFriend(((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(valueOf), "SearchResultActivity") && !friendsManager.P(valueOf)) {
                    ((IAddFriendApi) QRoute.api(IAddFriendApi.class)).launchAddFriend(this, ((IAddFriendApi) QRoute.api(IAddFriendApi.class)).startAddFriend(this, 1, String.valueOf(condFitUser.lUIN), null, 3017, 1, condFitUser.strNick, null, null, getString(R.string.f170028dd), null));
                    return;
                } else {
                    QLog.e("SearchResultActivity", 1, "erorr state: friend showed in addList");
                    QQToast.makeText(this, "\u597d\u53cb\u8bf7\u6c42\u5df2\u53d1\u9001\uff0c\u8bf7\u786e\u8ba4\u540e\u91cd\u8bd5\u3002", 0).show();
                    return;
                }
            }
        }
        QLog.e("SearchResultActivity", 1, "add friend fail");
    }

    public static void Q2(Context context, String str, int i3, int i16, int i17, String[] strArr, String[] strArr2, int i18, int i19, List<CondFitUser> list, boolean z16) {
        Intent intent = new Intent(context, (Class<?>) SearchResultActivity.class);
        intent.putExtra("key_keyword", str);
        intent.putExtra("key_age_index1", i3);
        intent.putExtra("key_age_index2", i16);
        intent.putExtra("key_sex_index", i17);
        intent.putExtra("key_loc_code", strArr);
        intent.putExtra("key_home_code", strArr2);
        intent.putExtra("key_xingzuo_index", i19);
        intent.putExtra("key_job_index", i18);
        intent.putExtra("key_has_more", z16);
        f201990n0 = list;
        context.startActivity(intent);
    }

    private void setAccSoft() {
        ViewGroup viewGroup = (ViewGroup) findViewById(R.id.rlCommenTitle);
        if (viewGroup != null) {
            IphoneTitleBarActivity.setLayerType(viewGroup);
        }
        View findViewById = findViewById(R.id.idz);
        if (findViewById != null) {
            IphoneTitleBarActivity.setLayerType(findViewById);
        }
        TextView textView = (TextView) findViewById(R.id.ivTitleBtnLeft);
        if (textView != null) {
            IphoneTitleBarActivity.setLayerType(textView);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x0129  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x014d  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0167  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0191  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0220  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0158  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    String L2(d dVar, CondFitUser condFitUser) {
        int i3;
        int i16;
        byte b16;
        Bitmap bitmapFromCache;
        String str = "";
        if (dVar != null && condFitUser != null) {
            StringBuilder sb5 = new StringBuilder();
            String str2 = condFitUser.lUIN + "";
            dVar.f202015h = str2;
            ReportController.o(this.app, "CliOper", "", str2, "0X800C0F9", "0X800C0F9", 0, 0, str2, "", "", "");
            dVar.f202009b.setText(condFitUser.strNick);
            TextView textView = dVar.f202009b;
            int i17 = 8;
            if (TextUtils.isEmpty(condFitUser.strNick)) {
                i3 = 8;
            } else {
                i3 = 0;
            }
            textView.setVisibility(i3);
            sb5.append(condFitUser.strNick);
            String str3 = this.f201998h0.f0(condFitUser.locDesc)[1];
            if (str3.equals(IProfileCardConst.NAME_NO_LIMIT)) {
                str3 = "";
            }
            String[] f06 = this.f201998h0.f0(str3);
            String str4 = f06[1];
            if (str4.equals(IProfileCardConst.NAME_NO_LIMIT)) {
                str4 = f06[0];
            }
            if (str4.equals(IProfileCardConst.NAME_NO_LIMIT)) {
                str4 = "";
            }
            byte b17 = condFitUser.cSex;
            if (b17 != 1) {
                if (b17 != 2) {
                    i16 = 0;
                } else {
                    str = HardCodeUtil.qqStr(R.string.t7k);
                    i16 = R.drawable.ngh;
                }
            } else {
                str = HardCodeUtil.qqStr(R.string.f172667t72);
                i16 = R.drawable.ngi;
            }
            sb5.append(str);
            sb5.append(String.format("%s\u5c81", Long.valueOf(condFitUser.dwAge)));
            sb5.append(str4);
            if (i16 != 0) {
                dVar.f202012e.setCompoundDrawablesWithIntrinsicBounds(i16, 0, 0, 0);
            }
            dVar.f202012e.setVisibility(0);
            dVar.f202012e.setText(String.valueOf(condFitUser.dwAge));
            if (QLog.isColorLevel()) {
                QLog.i("SearchResultActivity", 2, "bindView jobId=" + condFitUser.iOccupationId);
            }
            int i18 = condFitUser.iOccupationId;
            if (i18 > 0) {
                String[] strArr = ConditionSearchManager.f194489q0;
                if (i18 < strArr.length - 1) {
                    dVar.f202011d.setText(strArr[i18]);
                    dVar.f202011d.setVisibility(0);
                    sb5.append(strArr[condFitUser.iOccupationId]);
                    b16 = condFitUser.cConstellationId;
                    if (b16 > 0) {
                        String[] strArr2 = ConditionSearchManager.f194487o0;
                        if (b16 < strArr2.length) {
                            dVar.f202013f.setText(strArr2[b16]);
                            dVar.f202013f.setVisibility(0);
                            sb5.append(strArr2[condFitUser.cConstellationId]);
                            if (!TextUtils.isEmpty(str4)) {
                                dVar.f202014g.setVisibility(0);
                                dVar.f202014g.setText(str4);
                            } else {
                                dVar.f202014g.setVisibility(8);
                            }
                            bitmapFromCache = this.f201994d0.getBitmapFromCache(1, dVar.f202015h);
                            if (bitmapFromCache == null) {
                                bitmapFromCache = BaseImageUtil.getDefaultFaceBitmap();
                                if (!this.f201994d0.isPausing()) {
                                    this.f201994d0.requestDecodeFace(dVar.f202015h, 1, true, (byte) 1);
                                }
                            }
                            dVar.f202008a.setImageBitmap(bitmapFromCache);
                            dVar.f202010c.setText(condFitUser.personalSignature);
                            TextView textView2 = dVar.f202010c;
                            if (!TextUtils.isEmpty(condFitUser.personalSignature)) {
                                i17 = 0;
                            }
                            textView2.setVisibility(i17);
                            sb5.append(dVar.f202010c.getText().toString());
                            if (QLog.isColorLevel()) {
                                QLog.d("SearchResultActivity", 2, "bindview | uin:" + condFitUser.lUIN + "| nickname:" + condFitUser.strNick + "| sex:" + ((int) condFitUser.cSex) + "| age:" + condFitUser.dwAge + "| country:" + condFitUser.dwCountry + "| province:" + condFitUser.dwProvince + "| city:" + condFitUser.dwCity + "| occupation:" + condFitUser.iOccupationId + "| horoscope:" + ((int) condFitUser.cConstellationId) + "| sign:" + dVar.f202010c.getText().toString());
                            }
                            return sb5.toString();
                        }
                    }
                    dVar.f202013f.setVisibility(8);
                    if (!TextUtils.isEmpty(str4)) {
                    }
                    bitmapFromCache = this.f201994d0.getBitmapFromCache(1, dVar.f202015h);
                    if (bitmapFromCache == null) {
                    }
                    dVar.f202008a.setImageBitmap(bitmapFromCache);
                    dVar.f202010c.setText(condFitUser.personalSignature);
                    TextView textView22 = dVar.f202010c;
                    if (!TextUtils.isEmpty(condFitUser.personalSignature)) {
                    }
                    textView22.setVisibility(i17);
                    sb5.append(dVar.f202010c.getText().toString());
                    if (QLog.isColorLevel()) {
                    }
                    return sb5.toString();
                }
            }
            dVar.f202011d.setVisibility(8);
            b16 = condFitUser.cConstellationId;
            if (b16 > 0) {
            }
            dVar.f202013f.setVisibility(8);
            if (!TextUtils.isEmpty(str4)) {
            }
            bitmapFromCache = this.f201994d0.getBitmapFromCache(1, dVar.f202015h);
            if (bitmapFromCache == null) {
            }
            dVar.f202008a.setImageBitmap(bitmapFromCache);
            dVar.f202010c.setText(condFitUser.personalSignature);
            TextView textView222 = dVar.f202010c;
            if (!TextUtils.isEmpty(condFitUser.personalSignature)) {
            }
            textView222.setVisibility(i17);
            sb5.append(dVar.f202010c.getText().toString());
            if (QLog.isColorLevel()) {
            }
            return sb5.toString();
        }
        QLog.e("SearchResultActivity", 1, "bindView is error, holder or user is invalid!");
        return "";
    }

    @Override // com.tencent.mobileqq.app.IphoneTitleBarActivity, com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public boolean doOnCreate(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) bundle)).booleanValue();
        }
        super.doOnCreate(bundle);
        ca.a(this);
        setContentView(R.layout.asv);
        setContentBackgroundResource(R.drawable.bg_texture);
        setTitle(R.string.a8d);
        setLeftViewName(R.string.button_back);
        setAccSoft();
        this.f202000j0 = new WeakReferenceHandler(Looper.getMainLooper(), this.f202001k0);
        this.f201999i0 = getIntent().getBooleanExtra("key_has_more", false) ? 1 : 0;
        List<CondFitUser> list = f201990n0;
        this.f201995e0 = list;
        f201990n0 = null;
        if (list != null && list.size() != 0) {
            this.f201996f0 = new HashSet();
            this.f201997g0 = (StatusManager) this.app.getManager(QQManagerFactory.STATUS_MANAGER);
            this.f201998h0 = (ConditionSearchManager) this.app.getManager(QQManagerFactory.CONDITION_SEARCH_MANAGER);
            IFaceDecoder iQQAvatarService = ((IQQAvatarService) this.app.getRuntimeService(IQQAvatarService.class, "")).getInstance(this.app);
            this.f201994d0 = iQQAvatarService;
            iQQAvatarService.setDecodeTaskCompletionListener(this);
            XListView xListView = (XListView) findViewById(R.id.root);
            this.f201991a0 = xListView;
            xListView.setNeedCheckSpringback(true);
            try {
                this.f202000j0.sendEmptyMessage(2);
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.d("SearchResultActivity", 2, "infate failure:", e16);
                }
                this.f202000j0.sendEmptyMessage(1);
            }
            this.f201991a0.setOnScrollListener(this);
            c cVar = new c();
            this.f201993c0 = cVar;
            this.f201991a0.setAdapter((ListAdapter) cVar);
            this.f201991a0.setDivider(null);
            this.f201991a0.setDividerHeight(0);
            M2();
            return true;
        }
        finish();
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        super.doOnDestroy();
        IFaceDecoder iFaceDecoder = this.f201994d0;
        if (iFaceDecoder != null) {
            iFaceDecoder.destory();
            this.f201994d0 = null;
        }
        ConditionSearchManager conditionSearchManager = this.f201998h0;
        if (conditionSearchManager != null) {
            conditionSearchManager.S(this.f202002l0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i3;
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) view);
        } else {
            Object tag = view.getTag();
            if (tag != null) {
                int i16 = 1;
                if (tag instanceof d) {
                    d dVar = (d) tag;
                    if (this.app.getCurrentAccountUin().equals(dVar.f202015h)) {
                        i16 = 0;
                    } else {
                        if (!((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).isFriend(((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(dVar.f202015h), "SearchResultActivity")) {
                            i16 = 75;
                        }
                    }
                    ReportController.o(this.app, "CliOper", "", "", "0X8006F0C", "0X8006F0C", 0, 0, "", "", "", "");
                    AllInOne allInOne = new AllInOne(dVar.f202015h, i16);
                    allInOne.nickname = dVar.f202009b.getText().toString();
                    allInOne.profileEntryType = 87;
                    allInOne.extras.putInt(ProfileCardConst.ENTER_PAGE_SOURCE_ID, 9);
                    allInOne.extras.putInt(ProfileCardConst.ENTER_PAGE_SUB_SOURCE_ID, 91);
                    ProfileUtils.openProfileCard(this, allInOne);
                } else if ((tag instanceof e) && ((i3 = this.f201999i0) == 3 || i3 == 4)) {
                    this.f201999i0 = 1;
                    this.f201993c0.notifyDataSetChanged();
                }
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.app.IphoneTitleBarActivity, com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    @Override // com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener
    public void onDecodeTaskCompleted(int i3, int i16, String str, Bitmap bitmap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Integer.valueOf(i3), Integer.valueOf(i16), str, bitmap);
            return;
        }
        if (bitmap != null && this.f201992b0 == 0) {
            int childCount = this.f201991a0.getChildCount();
            for (int i17 = 0; i17 < childCount; i17++) {
                Object tag = this.f201991a0.getChildAt(i17).getTag();
                if (tag != null && (tag instanceof d)) {
                    d dVar = (d) tag;
                    if (dVar.f202015h.equals(str)) {
                        dVar.f202008a.setImageBitmap(bitmap);
                    }
                }
            }
        }
    }

    @Override // com.tencent.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i3, int i16, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, absListView, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
        }
    }

    @Override // com.tencent.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) absListView, i3);
            return;
        }
        this.f201992b0 = i3;
        if (i3 != 0) {
            this.f201994d0.cancelPendingRequests();
            this.f201994d0.pause();
        } else {
            if (this.f201994d0.isPausing()) {
                this.f201994d0.resume();
            }
            this.f201993c0.notifyDataSetChanged();
        }
    }
}
