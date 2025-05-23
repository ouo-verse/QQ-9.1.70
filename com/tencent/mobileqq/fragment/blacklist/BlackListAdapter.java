package com.tencent.mobileqq.fragment.blacklist;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.contacts.alphabet.IndexBar;
import com.tencent.mobileqq.adapter.k;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.fragment.blacklist.BlackListAdapter;
import com.tencent.mobileqq.fragment.blacklist.e;
import com.tencent.mobileqq.fragment.blacklist.userdb.UserDisplayManager;
import com.tencent.mobileqq.friend.api.IFriendDataService;
import com.tencent.mobileqq.profilecard.api.IProfileCardFeatureApi;
import com.tencent.mobileqq.profilecard.api.IRelationBlacklistApi;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.listener.RelationBlacklistListener;
import com.tencent.mobileqq.profilecard.utils.ProfileUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.PinnedDividerListView;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqnt.widget.SwipeMenuLayout;
import com.tencent.util.QQToastUtil;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes12.dex */
public class BlackListAdapter extends PinnedDividerListView.a {
    static IPatchRedirector $redirector_;
    public String[] C;
    private final boolean D;
    private BlackListViewModel E;
    private SwipeMenuLayout F;

    /* renamed from: d, reason: collision with root package name */
    private Context f211251d;

    /* renamed from: e, reason: collision with root package name */
    private IndexBar f211252e;

    /* renamed from: f, reason: collision with root package name */
    private IFaceDecoder f211253f;

    /* renamed from: h, reason: collision with root package name */
    private AppInterface f211254h;

    /* renamed from: i, reason: collision with root package name */
    public LinkedHashMap<String, List<e.a>> f211255i;

    /* renamed from: m, reason: collision with root package name */
    public int[] f211256m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class a implements SwipeMenuLayout.e {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ d f211260a;

        a(d dVar) {
            this.f211260a = dVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) BlackListAdapter.this, (Object) dVar);
            }
        }

        @Override // com.tencent.qqnt.widget.SwipeMenuLayout.e
        public void a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            BlackListAdapter.this.f211252e.setVisibility(8);
            BlackListAdapter.this.F = this.f211260a.f211266b;
            VideoReport.reportEvent("dt_imp", this.f211260a.f211268d, null);
        }

        @Override // com.tencent.qqnt.widget.SwipeMenuLayout.e
        public void b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
            } else {
                BlackListAdapter.this.f211252e.setVisibility(0);
                BlackListAdapter.this.F = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class b implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ d f211262d;

        b(d dVar) {
            this.f211262d = dVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) BlackListAdapter.this, (Object) dVar);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                BlackListAdapter.this.m(this.f211262d.f211270f);
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    static class c extends k {
        static IPatchRedirector $redirector_;

        /* renamed from: i, reason: collision with root package name */
        public TextView f211264i;

        public c(View view) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) view);
            } else {
                this.f211264i = (TextView) view.findViewById(R.id.k8u);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    public static class d {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public URLImageView f211265a;

        /* renamed from: b, reason: collision with root package name */
        public SwipeMenuLayout f211266b;

        /* renamed from: c, reason: collision with root package name */
        public ViewGroup f211267c;

        /* renamed from: d, reason: collision with root package name */
        public ViewGroup f211268d;

        /* renamed from: e, reason: collision with root package name */
        public TextView f211269e;

        /* renamed from: f, reason: collision with root package name */
        public String f211270f;

        public d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    public BlackListAdapter(Context context, IFaceDecoder iFaceDecoder, IndexBar indexBar, BlackListViewModel blackListViewModel) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, iFaceDecoder, indexBar, blackListViewModel);
            return;
        }
        this.f211255i = new LinkedHashMap<>();
        this.f211256m = new int[0];
        this.C = new String[0];
        this.D = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("black_list_swipe_menu", true);
        this.E = null;
        this.F = null;
        this.f211251d = context;
        this.f211253f = iFaceDecoder;
        this.f211254h = (AppInterface) MobileQQ.sMobileQQ.peekAppRuntime();
        this.f211252e = indexBar;
        this.E = blackListViewModel;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(final String str) {
        if (NetworkUtil.isNetSupport(BaseApplication.getContext())) {
            ((IRelationBlacklistApi) QRoute.api(IRelationBlacklistApi.class)).sendDeleteBlacklistRequest(str, new RelationBlacklistListener() { // from class: com.tencent.mobileqq.fragment.blacklist.a
                @Override // com.tencent.mobileqq.profilecard.listener.RelationBlacklistListener
                public final void onResult(boolean z16, Object obj) {
                    BlackListAdapter.this.q(str, z16, obj);
                }
            });
        } else {
            QQToastUtil.showQQToast(1, R.string.b3j);
        }
    }

    private ViewGroup k(LinearLayoutCompat linearLayoutCompat) {
        RelativeLayout relativeLayout = new RelativeLayout(this.f211251d);
        relativeLayout.setBackgroundColor(this.f211251d.getResources().getColor(R.color.qui_common_feedback_error, null));
        relativeLayout.setBackgroundTintList(this.f211251d.getResources().getColorStateList(R.color.qui_common_feedback_error_selector, null));
        TextView textView = new TextView(this.f211251d);
        textView.setTextColor(this.f211251d.getResources().getColorStateList(R.color.qui_common_text_white));
        textView.setText(HardCodeUtil.qqStr(R.string.f229956xu));
        textView.setTextSize(2, 17.0f);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        relativeLayout.addView(textView, layoutParams);
        linearLayoutCompat.addView(relativeLayout, new LinearLayoutCompat.LayoutParams(ViewUtils.dip2px(80.0f), -1));
        return relativeLayout;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean m(String str) {
        AppRuntime peekAppRuntime;
        if (TextUtils.isEmpty(str) || (peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime()) == null) {
            return false;
        }
        if (((IFriendDataService) peekAppRuntime.getRuntimeService(IFriendDataService.class, "")).isFriend(str)) {
            ProfileUtils.openProfileCard(this.f211251d, new AllInOne(str, 1));
        } else {
            ProfileUtils.openProfileCard(this.f211251d, new AllInOne(str, 19));
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void n(QQCustomDialog qQCustomDialog, HashMap<String, String> hashMap, d dVar) {
        VideoReport.setLogicParent(qQCustomDialog.getRootView(), dVar.f211268d);
        VideoReport.setElementId(qQCustomDialog.getRootView(), "em_bas_blacklist_remove_popup");
        VideoReport.setElementParams(qQCustomDialog.getRootView(), hashMap);
        VideoReport.setElementId(qQCustomDialog.getBtnLeft(), "em_bas_cancel");
        VideoReport.setElementParams(qQCustomDialog.getBtnLeft(), hashMap);
        VideoReport.setElementId(qQCustomDialog.getBtnight(), "em_bas_confirm");
        VideoReport.setElementParams(qQCustomDialog.getBtnight(), hashMap);
    }

    private void o(e.a aVar, d dVar) {
        dVar.f211270f = aVar.f211317a;
        dVar.f211269e.setText(aVar.f211318b);
        if (FaceDrawable.getFaceDrawable(this.f211254h, 1, aVar.f211317a) != null) {
            dVar.f211265a.setBackgroundDrawable(FaceDrawable.getFaceDrawable(this.f211254h, 1, aVar.f211317a));
        } else {
            dVar.f211265a.setBackgroundDrawable((BitmapDrawable) BaseImageUtil.getDefaultFaceDrawable140_140());
        }
        dVar.f211267c.setBackgroundResource(R.drawable.ktv);
        dVar.f211267c.setOnClickListener(new b(dVar));
        VideoReport.setElementId(dVar.f211267c, "em_blacklist_to_user");
        VideoReport.setElementParams(dVar.f211267c, new HashMap<String, String>(dVar) { // from class: com.tencent.mobileqq.fragment.blacklist.BlackListAdapter.5
            static IPatchRedirector $redirector_;
            final /* synthetic */ d val$holder;

            {
                this.val$holder = dVar;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) BlackListAdapter.this, (Object) dVar);
                } else {
                    put("to_uin", dVar.f211270f);
                }
            }
        });
    }

    private void p(d dVar, d dVar2) {
        dVar.f211268d.setOnClickListener(new AnonymousClass1(dVar2, dVar));
        dVar.f211266b.setSwipeListener(new a(dVar));
        dVar.f211266b.setSwipeEnable(this.D);
        VideoReport.setElementId(dVar.f211268d, "em_bas_remove");
        VideoReport.setElementParams(dVar.f211268d, new HashMap<String, String>(dVar) { // from class: com.tencent.mobileqq.fragment.blacklist.BlackListAdapter.3
            static IPatchRedirector $redirector_;
            final /* synthetic */ d val$holder;

            {
                this.val$holder = dVar;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) BlackListAdapter.this, (Object) dVar);
                } else {
                    put("to_uin", dVar.f211270f);
                }
            }
        });
        VideoReport.setElementExposePolicy(dVar.f211268d, ExposurePolicy.REPORT_NONE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void q(String str, boolean z16, Object obj) {
        if (z16) {
            BlackListViewModel blackListViewModel = this.E;
            if (blackListViewModel != null) {
                UserDisplayManager.a value = blackListViewModel.X1().getValue();
                if (value == null) {
                    return;
                }
                UserDisplayManager.a aVar = new UserDisplayManager.a(value);
                aVar.b(str);
                this.E.X1().postValue(aVar);
                this.E.P1();
            }
            ((IProfileCardFeatureApi) QRoute.api(IProfileCardFeatureApi.class)).updateUserIsBlacklistUinFlag(str, false);
        }
    }

    private void s() {
        if (this.f211252e != null) {
            if (getCount() >= 5) {
                this.f211252e.setLetters(this.C);
            } else {
                this.f211252e.setLetters(null);
            }
        }
    }

    @Override // com.tencent.mobileqq.widget.PinnedDividerListView.a
    public void configDividerView(View view, int i3) {
        int i16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) view, i3);
            return;
        }
        int binarySearch = Arrays.binarySearch(this.f211256m, i3);
        if (binarySearch < 0) {
            binarySearch = (-(binarySearch + 1)) - 1;
        }
        if (binarySearch < this.C.length && binarySearch >= 0 && (view instanceof TextView)) {
            TextView textView = (TextView) view;
            textView.setPadding(textView.getPaddingLeft(), textView.getPaddingTop(), 0, 0);
            String str = this.C[binarySearch];
            if (str.equals("\u2605")) {
                textView.setText(HardCodeUtil.qqStr(R.string.jd8));
            } else {
                textView.setText(str);
            }
            textView.setTextColor(this.f211251d.getResources().getColorStateList(R.color.qui_common_brand_standard));
            if (ThemeUtil.isNowThemeIsSimple(this.f211254h, false, null)) {
                if (ThemeUtil.isNowThemeIsNight(this.f211254h, false, null)) {
                    i16 = -1;
                } else {
                    i16 = -16777216;
                }
                textView.setTextColor(i16);
            }
            IndexBar indexBar = this.f211252e;
            if (indexBar != null) {
                indexBar.setChooseIndex(binarySearch);
            }
            textView.setTypeface(Typeface.SANS_SERIF);
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        LinkedHashMap<String, List<e.a>> linkedHashMap;
        String[] strArr;
        List<e.a> list;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this)).intValue();
        }
        int[] iArr = this.f211256m;
        if (iArr == null || iArr.length == 0 || (linkedHashMap = this.f211255i) == null || linkedHashMap.size() == 0 || (strArr = this.C) == null || strArr.length == 0 || (list = this.f211255i.get(strArr[strArr.length - 1])) == null) {
            return 0;
        }
        return this.f211256m[r1.length - 1] + list.size() + 1;
    }

    @Override // com.tencent.mobileqq.widget.PinnedDividerListView.a
    public int getDividerLayout() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this)).intValue();
        }
        return R.layout.e0i;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return iPatchRedirector.redirect((short) 4, (Object) this, i3);
        }
        int binarySearch = Arrays.binarySearch(this.f211256m, i3);
        if (binarySearch >= 0) {
            return null;
        }
        return this.f211255i.get(this.C[(-(binarySearch + 1)) - 1]).get((i3 - this.f211256m[r0]) - 1);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Long) iPatchRedirector.redirect((short) 5, (Object) this, i3)).longValue();
        }
        return 0L;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this, i3)).intValue();
        }
        if (Arrays.binarySearch(this.f211256m, i3) < 0) {
            return 1;
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public View getView(int i3, View view, ViewGroup viewGroup) {
        View view2;
        d dVar;
        View view3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            view3 = (View) iPatchRedirector.redirect((short) 9, this, Integer.valueOf(i3), view, viewGroup);
        } else if (this.f211254h == null) {
            view3 = null;
        } else {
            int binarySearch = Arrays.binarySearch(this.f211256m, i3);
            if (getItemViewType(i3) == 1) {
                int i16 = (-(binarySearch + 1)) - 1;
                List<e.a> list = this.f211255i.get(this.C[i16]);
                int i17 = (i3 - this.f211256m[i16]) - 1;
                if (list != null && i17 < list.size()) {
                    e.a aVar = list.get(i17);
                    if (aVar == null) {
                        if (QLog.isColorLevel()) {
                            QLog.d("BlackListActivity", 2, "item == null,\u8fd9\u79cd\u60c5\u51b5\u4e0d\u5e94\u8be5\u51fa\u73b0\u7684");
                        }
                    } else {
                        if (view != null && (view.getTag() instanceof d)) {
                            dVar = (d) view.getTag();
                        } else {
                            view = LayoutInflater.from(this.f211251d).inflate(R.layout.h3m, viewGroup, false);
                            dVar = new d();
                            dVar.f211265a = (URLImageView) view.findViewById(R.id.is5);
                            dVar.f211266b = (SwipeMenuLayout) view.findViewById(R.id.t8n);
                            dVar.f211267c = (ViewGroup) view.findViewById(R.id.t8r);
                            dVar.f211268d = k((LinearLayoutCompat) view.findViewById(R.id.t8t));
                            dVar.f211269e = (TextView) view.findViewById(R.id.is6);
                            view.setTag(dVar);
                        }
                        o(aVar, dVar);
                        p(dVar, dVar);
                    }
                }
            } else {
                if (view == null) {
                    view = LayoutInflater.from(this.f211251d).inflate(R.layout.h07, viewGroup, false);
                    view.setTag(new c(view));
                }
                if (!(view.getTag() instanceof c)) {
                    view = LayoutInflater.from(this.f211251d).inflate(R.layout.h07, viewGroup, false);
                    view.setTag(new c(view));
                }
                c cVar = (c) view.getTag();
                String valueOf = String.valueOf(this.C[binarySearch]);
                if (!TextUtils.isEmpty(valueOf)) {
                    if (valueOf.equals("\u2605")) {
                        cVar.f211264i.setText(HardCodeUtil.qqStr(R.string.jd8));
                    } else {
                        cVar.f211264i.setText(valueOf);
                    }
                }
                if (AppSetting.f99565y) {
                    cVar.f211264i.setContentDescription(String.format(HardCodeUtil.qqStr(R.string.aud), valueOf.toLowerCase()));
                }
            }
            view2 = view;
            EventCollector.getInstance().onListGetView(i3, view2, viewGroup, getItemId(i3));
            return view;
        }
        view2 = view;
        view = view3;
        EventCollector.getInstance().onListGetView(i3, view2, viewGroup, getItemId(i3));
        return view;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
        }
        return 2;
    }

    @Override // com.tencent.mobileqq.widget.PinnedDividerListView.a
    public boolean isDividerView(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this, i3)).booleanValue();
        }
        if (Arrays.binarySearch(this.f211256m, i3) >= 0) {
            return true;
        }
        return false;
    }

    public void j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        SwipeMenuLayout swipeMenuLayout = this.F;
        if (swipeMenuLayout != null) {
            swipeMenuLayout.h();
        }
    }

    public int l(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Integer) iPatchRedirector.redirect((short) 14, (Object) this, (Object) str)).intValue();
        }
        if (str == null) {
            return -1;
        }
        char charAt = str.charAt(0);
        if (this.C != null) {
            int i3 = 0;
            while (true) {
                String[] strArr = this.C;
                if (i3 < strArr.length) {
                    char charAt2 = strArr[i3].charAt(0);
                    if (charAt2 != "\u2605".charAt(0)) {
                        if (charAt == '#') {
                            i3 = this.C.length - 1;
                            break;
                        }
                        if (charAt <= charAt2) {
                            break;
                        }
                    }
                    i3++;
                } else {
                    i3 = -1;
                    break;
                }
            }
            if (i3 >= 0) {
                return this.f211256m[i3];
            }
        }
        return -1;
    }

    @Override // com.tencent.mobileqq.widget.PinnedDividerListView.a
    public boolean needHideDivider(View view, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Boolean) iPatchRedirector.redirect((short) 12, (Object) this, (Object) view, i3)).booleanValue();
        }
        if (this.C.length <= 0) {
            return true;
        }
        return false;
    }

    public void r(e eVar) {
        String[] strArr;
        LinkedHashMap<String, List<e.a>> linkedHashMap;
        int[] iArr;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) eVar);
            return;
        }
        if (eVar != null && (strArr = eVar.f211314a) != null && (linkedHashMap = eVar.f211316c) != null && (iArr = eVar.f211315b) != null) {
            this.f211255i = linkedHashMap;
            this.f211256m = iArr;
            this.C = strArr;
            s();
            notifyDataSetChanged();
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("BlackListActivity", 2, "PersonModel result == null!");
        }
        this.f211255i.clear();
        this.f211256m = new int[0];
        this.C = new String[0];
        s();
        notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.fragment.blacklist.BlackListAdapter$1, reason: invalid class name */
    /* loaded from: classes12.dex */
    public class AnonymousClass1 implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ d f211257d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ d f211258e;

        AnonymousClass1(d dVar, d dVar2) {
            this.f211257d = dVar;
            this.f211258e = dVar2;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, BlackListAdapter.this, dVar, dVar2);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void c(d dVar, DialogInterface dialogInterface, int i3) {
            BlackListAdapter.this.i(dVar.f211270f);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                this.f211257d.f211266b.l();
                if (BlackListAdapter.this.f211251d != null) {
                    Context context = BlackListAdapter.this.f211251d;
                    String qqStr = HardCodeUtil.qqStr(R.string.f229976xw);
                    String qqStr2 = HardCodeUtil.qqStr(R.string.f229966xv);
                    String qqStr3 = HardCodeUtil.qqStr(R.string.cancel);
                    String qqStr4 = HardCodeUtil.qqStr(R.string.f229956xu);
                    final d dVar = this.f211257d;
                    QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(context, 0, qqStr, qqStr2, qqStr3, qqStr4, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.fragment.blacklist.b
                        @Override // android.content.DialogInterface.OnClickListener
                        public final void onClick(DialogInterface dialogInterface, int i3) {
                            BlackListAdapter.AnonymousClass1.this.c(dVar, dialogInterface, i3);
                        }
                    }, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.fragment.blacklist.c
                        @Override // android.content.DialogInterface.OnClickListener
                        public final void onClick(DialogInterface dialogInterface, int i3) {
                            BlackListAdapter.AnonymousClass1.d(dialogInterface, i3);
                        }
                    });
                    BlackListAdapter.n(createCustomDialog, new HashMap<String, String>() { // from class: com.tencent.mobileqq.fragment.blacklist.BlackListAdapter.1.1
                        static IPatchRedirector $redirector_;

                        {
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AnonymousClass1.this);
                            } else {
                                put("to_uin", AnonymousClass1.this.f211258e.f211270f);
                            }
                        }
                    }, this.f211258e);
                    createCustomDialog.show();
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void d(DialogInterface dialogInterface, int i3) {
        }
    }
}
