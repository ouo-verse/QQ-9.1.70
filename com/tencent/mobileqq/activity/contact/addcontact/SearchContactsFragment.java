package com.tencent.mobileqq.activity.contact.addcontact;

import addcontacts.AccountSearchPb$ResultItem;
import addcontacts.AccountSearchPb$hotwordrecord;
import addcontacts.AccountSearchPb$record;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.tencent.biz.pubaccount.api.IPublicAccountBrowser;
import com.tencent.biz.pubaccount.api.IPublicAccountDetailReportUtil;
import com.tencent.biz.pubaccount.api.IPublicAccountHandler;
import com.tencent.biz.pubaccount.util.api.IPublicAccountConfigUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.ecommerce.base.searchbar.IECSearchBar;
import com.tencent.image.ApngImage;
import com.tencent.image.URLDrawable;
import com.tencent.imsdk.BaseConstants;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.activity.contact.addcontact.SearchBaseActivity;
import com.tencent.mobileqq.activity.contact.addcontact.SearchBaseFragment;
import com.tencent.mobileqq.activity.contact.addcontact.ViewFactory;
import com.tencent.mobileqq.activity.contact.addcontact.groupsearch.GroupSearchRecommendView;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.UnifySearchHandler;
import com.tencent.mobileqq.app.di;
import com.tencent.mobileqq.guild.api.IGuildTempApi;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.profilecard.api.IProfileCardConst;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.mobileqq.qroute.route.o;
import com.tencent.mobileqq.search.SearchUtil;
import com.tencent.mobileqq.search.activity.ActiveEntitySearchActivity;
import com.tencent.mobileqq.search.activity.UniteSearchActivity;
import com.tencent.mobileqq.search.api.IGroupSearchHistoryManager;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.search.util.ac;
import com.tencent.mobileqq.search.util.t;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.api.ITroopUtilApi;
import com.tencent.mobileqq.troop.data.f;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.troop.utils.aq;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vas.util.PrettyAccountUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.shadow.dynamic.host.Constant;
import com.tencent.widget.ListView;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Matcher;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes10.dex */
public class SearchContactsFragment extends SearchBaseFragment {
    static IPatchRedirector $redirector_;

    /* renamed from: w0, reason: collision with root package name */
    private static int f180815w0;

    /* renamed from: c0, reason: collision with root package name */
    boolean f180816c0;

    /* renamed from: d0, reason: collision with root package name */
    int f180817d0;

    /* renamed from: e0, reason: collision with root package name */
    private double f180818e0;

    /* renamed from: f0, reason: collision with root package name */
    private double f180819f0;

    /* renamed from: g0, reason: collision with root package name */
    private ArrayList<un2.a> f180820g0;

    /* renamed from: h0, reason: collision with root package name */
    private String f180821h0;

    /* renamed from: i0, reason: collision with root package name */
    private String f180822i0;

    /* renamed from: j0, reason: collision with root package name */
    private String f180823j0;

    /* renamed from: k0, reason: collision with root package name */
    private Map<Integer, Integer> f180824k0;

    /* renamed from: l0, reason: collision with root package name */
    private String f180825l0;

    /* renamed from: m0, reason: collision with root package name */
    private int f180826m0;

    /* renamed from: n0, reason: collision with root package name */
    private int f180827n0;

    /* renamed from: o0, reason: collision with root package name */
    private int f180828o0;

    /* renamed from: p0, reason: collision with root package name */
    private boolean f180829p0;

    /* renamed from: q0, reason: collision with root package name */
    private di f180830q0;

    /* renamed from: r0, reason: collision with root package name */
    private GroupSearchRecommendView f180831r0;

    /* renamed from: s0, reason: collision with root package name */
    private ViewFactory.GuideView f180832s0;

    /* renamed from: t0, reason: collision with root package name */
    private e f180833t0;

    /* renamed from: u0, reason: collision with root package name */
    ArrayList<d> f180834u0;

    /* renamed from: v0, reason: collision with root package name */
    c f180835v0;

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class a extends di {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SearchContactsFragment.this);
            }
        }

        @Override // com.tencent.mobileqq.app.di
        public void e(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, z16);
                return;
            }
            super.e(z16);
            SearchContactsFragment.this.f180829p0 = z16;
            SearchContactsFragment.this.Ii(null);
        }

        @Override // com.tencent.mobileqq.app.di
        public void f(List<com.tencent.mobileqq.activity.contact.addcontact.groupsearch.guess.b> list, boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, list, Boolean.valueOf(z16));
                return;
            }
            super.f(list, z16);
            SearchContactsFragment.this.f180829p0 = z16;
            SearchContactsFragment.this.Ii(list);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class b implements ViewFactory.GuideView.b {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SearchContactsFragment.this);
            }
        }

        @Override // com.tencent.mobileqq.activity.contact.addcontact.ViewFactory.GuideView.b
        public void a(int i3, String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, i3, (Object) str);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("SearchContactsFragment", 2, "guide view | onItemClick type is:" + i3 + " keyWords is:" + str);
            }
            SearchContactsFragment searchContactsFragment = SearchContactsFragment.this;
            searchContactsFragment.f180816c0 = true;
            searchContactsFragment.f180817d0 = i3;
            if (i3 == 80000001) {
                SearchUtils.V0("add_page", "search", "clk_search_grp", searchContactsFragment.E + 1, 0, "", "", str, "");
            }
            SearchContactsFragment.this.Bh(str, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class c implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SearchContactsFragment.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int i3;
            boolean z16;
            String str;
            int i16;
            PBUInt64Field pBUInt64Field;
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                Object tag = view.getTag();
                if (tag != null && (tag instanceof d)) {
                    d dVar = (d) tag;
                    int i17 = 0;
                    if (dVar.f180842d == 80000003 && SearchContactsFragment.this.f180821h0 != null) {
                        SearchContactsFragment searchContactsFragment = SearchContactsFragment.this;
                        searchContactsFragment.Ai(searchContactsFragment.f180821h0, SearchContactsFragment.this.f180822i0, SearchContactsFragment.this.f180823j0);
                    } else {
                        int i18 = dVar.f180842d;
                        if (i18 == 80000004) {
                            QzoneSearchResultView.d(SearchContactsFragment.this.getBaseActivity(), dVar.f180847i);
                        } else {
                            SearchContactsFragment searchContactsFragment2 = SearchContactsFragment.this;
                            int i19 = searchContactsFragment2.E;
                            if (i19 == 1) {
                                i3 = 3;
                            } else if (i19 == 0) {
                                i3 = 2;
                            } else {
                                i3 = 0;
                            }
                            if (dVar.f180844f == 2) {
                                z16 = true;
                            } else {
                                z16 = false;
                            }
                            searchContactsFragment2.zi(i18, z16, i3);
                        }
                    }
                    Integer num = (Integer) SearchContactsFragment.this.f180824k0.get(Integer.valueOf(dVar.f180842d));
                    AccountSearchPb$record accountSearchPb$record = dVar.f180839a;
                    if (accountSearchPb$record != null && (pBUInt64Field = accountSearchPb$record.uin) != null) {
                        str = String.valueOf(pBUInt64Field.get());
                    } else {
                        str = null;
                    }
                    int i26 = dVar.f180842d;
                    if (num != null) {
                        i16 = num.intValue();
                    } else {
                        i16 = 0;
                    }
                    SearchUtils.a1(i26, i16, 0, true, str, SearchContactsFragment.this.D, SearchContactsFragment.f180815w0);
                    int i27 = dVar.f180842d;
                    if (i27 == 80000002) {
                        BaseActivity baseActivity = SearchContactsFragment.this.getBaseActivity();
                        if (baseActivity != null && (baseActivity instanceof SearchBaseActivity)) {
                            int G2 = ((SearchBaseActivity) baseActivity).G2();
                            if (SearchContactsFragment.f180815w0 == 12) {
                                ReportController.n(SearchContactsFragment.this.S, "CliOper", "", "", "0X8006571", "0X8006571", 0, 1, 0, "0", SearchBaseActivity.e.a(G2), str, SearchContactsFragment.this.D);
                            } else {
                                ((IPublicAccountReportUtils) QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(SearchContactsFragment.this.S, "P_CliOper", IPublicAccountHandler.MAIN_ACTION, "0", "0X8005D20", "0X8005D20", 0, 0, "0", SearchBaseActivity.e.a(G2), SearchContactsFragment.this.D, "", false);
                            }
                            IPublicAccountDetailReportUtil iPublicAccountDetailReportUtil = (IPublicAccountDetailReportUtil) QRoute.api(IPublicAccountDetailReportUtil.class);
                            if (num != null) {
                                i17 = num.intValue();
                            }
                            iPublicAccountDetailReportUtil.setAttrSearchClick(2, str, i17, SearchContactsFragment.f180815w0);
                        }
                    } else if (i27 == 80000003) {
                        if (SearchContactsFragment.f180815w0 == 12) {
                            SearchContactsFragment searchContactsFragment3 = SearchContactsFragment.this;
                            ReportController.o(searchContactsFragment3.S, "CliOper", "", "", "0X800658A", "0X800658A", 0, 0, "0", "", searchContactsFragment3.D, "0");
                        } else {
                            IPublicAccountReportUtils iPublicAccountReportUtils = (IPublicAccountReportUtils) QRoute.api(IPublicAccountReportUtils.class);
                            SearchContactsFragment searchContactsFragment4 = SearchContactsFragment.this;
                            iPublicAccountReportUtils.publicAccountReportClickEventForMigrate(searchContactsFragment4.S, "P_CliOper", IPublicAccountHandler.MAIN_ACTION, "0", "0X8005D95", "0X8005D95", 0, 0, "0", "", searchContactsFragment4.D, "0", false);
                        }
                    } else if (i27 == 80000001) {
                        SearchUtils.V0("add_page", "all_result", "clk_more_grp", 0, SearchContactsFragment.this.f180826m0, "", "", SearchContactsFragment.this.D, "");
                    }
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public static class d {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public AccountSearchPb$record f180839a;

        /* renamed from: b, reason: collision with root package name */
        public AccountSearchPb$hotwordrecord f180840b;

        /* renamed from: c, reason: collision with root package name */
        public int f180841c;

        /* renamed from: d, reason: collision with root package name */
        public int f180842d;

        /* renamed from: e, reason: collision with root package name */
        public String f180843e;

        /* renamed from: f, reason: collision with root package name */
        public int f180844f;

        /* renamed from: g, reason: collision with root package name */
        public String f180845g;

        /* renamed from: h, reason: collision with root package name */
        public AccountSearchPb$ResultItem f180846h;

        /* renamed from: i, reason: collision with root package name */
        public String f180847i;

        /* renamed from: j, reason: collision with root package name */
        boolean f180848j;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    private class e extends com.tencent.mobileqq.adapter.j {
        static IPatchRedirector $redirector_;
        private ArrayList<d> F;
        private String G;
        private boolean H;

        public e(Context context, QQAppInterface qQAppInterface, ListView listView, int i3, boolean z16) {
            super(context, qQAppInterface, listView, i3, z16);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, SearchContactsFragment.this, context, qQAppInterface, listView, Integer.valueOf(i3), Boolean.valueOf(z16));
            } else {
                this.G = "";
                this.H = false;
            }
        }

        private int h(int i3) {
            if (i3 >= 1) {
                if (getItemViewType(i3 - 1) == 0) {
                    return 1;
                }
                if (i3 >= 2 && getItemViewType(i3 - 2) == 0) {
                    return 2;
                }
                return 3;
            }
            return 3;
        }

        private View i(int i3, View view, ViewGroup viewGroup) {
            View view2;
            boolean z16;
            String str;
            String str2;
            String str3;
            String str4;
            String str5;
            String str6;
            int i16;
            if (view == null) {
                view2 = SearchContactsFragment.this.Gh().getLayoutInflater().inflate(R.layout.b1n, (ViewGroup) null);
                SearchBaseFragment.e eVar = new SearchBaseFragment.e();
                eVar.f180781a = (ImageView) view2.findViewById(R.id.d3i);
                eVar.f180782b = (TextView) view2.findViewById(R.id.f9r);
                eVar.f180784d = (TextView) view2.findViewById(R.id.jlx);
                eVar.f180785e = (TextView) view2.findViewById(R.id.a1e);
                eVar.f180783c = (TextView) view2.findViewById(R.id.f164643ae1);
                view2.setTag(eVar);
            } else {
                view2 = view;
            }
            SearchBaseFragment.e eVar2 = (SearchBaseFragment.e) view2.getTag();
            view2.setOnClickListener(SearchContactsFragment.this);
            d dVar = (d) getItem(i3);
            if (dVar.f180840b != null) {
                ((IPublicAccountReportUtils) QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "P_CliOper", IPublicAccountHandler.MAIN_ACTION, "", "0X8006F29", "0X8006F29", 0, 0, SearchContactsFragment.this.D, dVar.f180840b.hotword.get(), String.valueOf(dVar.f180840b.hotword_type.get()), "");
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                str = dVar.f180840b.hotword.get();
                str2 = dVar.f180840b.hotword_description.get();
                str3 = dVar.f180840b.hotword_title.get();
                str4 = dVar.f180840b.hotword_cover_url.get();
                String str7 = dVar.f180845g;
                SearchContactsFragment.this.f180822i0 = str;
                SearchContactsFragment.this.f180823j0 = String.valueOf(dVar.f180840b.hotword_type.get());
                eVar2.f180789i = SearchContactsFragment.this.f180822i0;
                eVar2.f180790j = SearchContactsFragment.this.f180823j0;
                str6 = str7;
                str5 = "";
            } else {
                str = dVar.f180839a.name.get();
                str2 = dVar.f180839a.article_author.get();
                str3 = dVar.f180839a.brief.get();
                str4 = dVar.f180839a.title_image.get();
                str5 = dVar.f180839a.article_create_time.get();
                str6 = dVar.f180839a.article_short_url.get();
                eVar2.f180788h = dVar.f180839a.account_id.get();
                eVar2.f180787g = dVar.f180839a.number.get();
            }
            if (!TextUtils.isEmpty(dVar.f180845g)) {
                SearchContactsFragment.this.f180821h0 = dVar.f180845g;
            }
            eVar2.f180784d.setText(str5);
            int dimensionPixelSize = SearchContactsFragment.this.getResources().getDimensionPixelSize(R.dimen.f159238y4);
            if (!TextUtils.isEmpty(str4)) {
                try {
                    eVar2.f180781a.setImageDrawable(URLDrawable.getDrawable(str4, dimensionPixelSize, dimensionPixelSize));
                } catch (Exception unused) {
                }
            }
            eVar2.f180786f = str6;
            if (!"".equals(str2)) {
                eVar2.f180785e.setText(str2);
            }
            view2.setTag(eVar2);
            if (!"".equals(str)) {
                eVar2.f180782b.setText(SearchContactsFragment.this.Kh(80000003, str));
            }
            if (!z16) {
                if (!"".equals(str3)) {
                    SearchContactsFragment searchContactsFragment = SearchContactsFragment.this;
                    if (searchContactsFragment.Ph(eVar2.f180782b, searchContactsFragment.Gh()) > 1) {
                        eVar2.f180783c.setMaxLines(1);
                    } else {
                        eVar2.f180783c.setMaxLines(2);
                    }
                    eVar2.f180783c.setText(SearchContactsFragment.this.Kh(80000003, str3));
                } else {
                    eVar2.f180783c.setVisibility(8);
                }
            } else {
                if (!"".equals(str3)) {
                    eVar2.f180783c.setMaxLines(1);
                    eVar2.f180783c.setText(SearchContactsFragment.this.Kh(80000003, str3));
                }
                eVar2.f180782b.setMaxWidth(BaseAIOUtils.f(190.0f, view2.getResources()));
                eVar2.f180782b.setMaxLines(1);
                eVar2.f180785e.setMaxLines(1);
            }
            ImageView imageView = (ImageView) view2.findViewById(R.id.f167121l13);
            imageView.setVisibility(4);
            ImageView imageView2 = (ImageView) view2.findViewById(R.id.bat);
            imageView2.setVisibility(4);
            AccountSearchPb$record accountSearchPb$record = dVar.f180839a;
            if (accountSearchPb$record != null && accountSearchPb$record.video_article.has() && dVar.f180839a.video_article.get() == SearchUtils.f284958g) {
                i16 = 0;
                imageView.setVisibility(0);
                imageView2.getBackground().setAlpha(25);
                imageView2.setVisibility(0);
            } else {
                i16 = 0;
            }
            TextView textView = (TextView) view2.findViewById(R.id.d9e);
            textView.setVisibility(4);
            if (z16) {
                textView.setVisibility(i16);
            }
            return view2;
        }

        private View j(int i3, View view, ViewGroup viewGroup) {
            d dVar = (d) getItem(i3);
            if (view == null) {
                view = com.tencent.biz.addContactTroopView.b.a(SearchContactsFragment.this.Gh(), viewGroup, 5, false, 1);
            }
            AccountSearchPb$record accountSearchPb$record = ((d) getItem(i3)).f180839a;
            com.tencent.biz.addContactTroopView.b.b(view, SearchContactsFragment.this.Gh(), dVar.f180839a);
            f.b bVar = (f.b) view.getTag();
            bVar.f294902i.setTextColor(SearchContactsFragment.this.Gh().getResources().getColor(R.color.skin_black_item));
            bVar.f294902i.setText(SearchContactsFragment.this.Kh(80000001, String.valueOf(accountSearchPb$record.name.get())));
            String l3 = Long.toString(dVar.f180839a.code.get());
            bVar.f187210d = l3;
            bVar.f187211e = 4;
            bVar.f187212f.setImageBitmap(c(4, l3));
            bVar.H = h(i3);
            bVar.J = dVar.f180839a.bytes_join_group_auth.get().toStringUtf8();
            bVar.K = dVar.f180848j;
            view.setOnClickListener(SearchContactsFragment.this);
            return view;
        }

        private View k(int i3, View view, ViewGroup viewGroup) {
            if (view == null) {
                view = SearchContactsFragment.this.Gh().getLayoutInflater().inflate(R.layout.apz, viewGroup, false);
            }
            view.setOnClickListener(SearchContactsFragment.this);
            SearchBaseFragment.f fVar = new SearchBaseFragment.f();
            fVar.f180791a = (ImageView) view.findViewById(R.id.d3i);
            fVar.f180792b = (TextView) view.findViewById(R.id.f9r);
            fVar.f180793c = (TextView) view.findViewById(R.id.kh6);
            fVar.f180794d = (TextView) view.findViewById(R.id.bgr);
            fVar.f180795e = (TextView) view.findViewById(R.id.efv);
            fVar.f180801k = ((d) getItem(i3)).f180839a;
            fVar.f180800j = ((d) getItem(i3)).f180842d;
            view.setTag(fVar);
            SearchBaseFragment.f fVar2 = (SearchBaseFragment.f) view.getTag();
            fVar2.f180801k = ((d) getItem(i3)).f180839a;
            fVar2.f180800j = ((d) getItem(i3)).f180842d;
            fVar2.f180803m = h(i3);
            String oi5 = SearchContactsFragment.this.oi(fVar2, this.F.get(i3));
            if (AppSetting.f99565y) {
                view.setContentDescription(oi5);
            }
            return view;
        }

        private View l(int i3, View view, ViewGroup viewGroup) {
            if (view == null) {
                view = SearchContactsFragment.this.Gh().getLayoutInflater().inflate(R.layout.f169037br2, viewGroup, false);
            }
            if (view instanceof QzoneSearchResultView) {
                QzoneSearchResultView qzoneSearchResultView = (QzoneSearchResultView) view;
                d dVar = (d) getItem(i3);
                SearchContactsFragment searchContactsFragment = SearchContactsFragment.this;
                qzoneSearchResultView.a(searchContactsFragment.S, searchContactsFragment, dVar.f180846h);
                qzoneSearchResultView.setAvartaView(c(1, qzoneSearchResultView.c()));
                view.setOnClickListener(SearchContactsFragment.this);
            }
            return view;
        }

        private View m(int i3, View view, ViewGroup viewGroup) {
            if (view == null) {
                view = SearchContactsFragment.this.Gh().getLayoutInflater().inflate(R.layout.f168777aq1, viewGroup, false);
            }
            SearchContactsFragment searchContactsFragment = SearchContactsFragment.this;
            if (searchContactsFragment.f180835v0 == null) {
                searchContactsFragment.f180835v0 = new c();
            }
            view.setTag(this.F.get(i3));
            view.setOnClickListener(SearchContactsFragment.this.f180835v0);
            if (AppSetting.f99565y) {
                view.setContentDescription(HardCodeUtil.qqStr(R.string.t68) + this.G + HardCodeUtil.qqStr(R.string.t6d));
            }
            return view;
        }

        private View n(int i3, View view, ViewGroup viewGroup) {
            if (view == null) {
                view = SearchContactsFragment.this.Gh().getLayoutInflater().inflate(R.layout.f168017p3, viewGroup, false);
            }
            TextView textView = (TextView) view.findViewById(R.id.title);
            if (UniteSearchActivity.f282684b0 == 12) {
                if (this.F.get(i3).f180843e.equals(HardCodeUtil.qqStr(R.string.t6b))) {
                    textView.setText(((IPublicAccountConfigUtil) QRoute.api(IPublicAccountConfigUtil.class)).getSubscriptName(SearchContactsFragment.this.S, BaseApplicationImpl.getApplication().getApplicationContext()));
                } else {
                    textView.setText(this.F.get(i3).f180843e);
                }
            } else {
                textView.setText(this.F.get(i3).f180843e);
            }
            this.G = this.F.get(i3).f180843e;
            if (AppSetting.f99565y) {
                view.setFocusable(true);
                view.setContentDescription(((Object) textView.getText()) + HardCodeUtil.qqStr(R.string.t6h));
            }
            View findViewById = view.findViewById(R.id.bnd);
            if (i3 > 0) {
                findViewById.setVisibility(0);
            } else if (i3 == 0) {
                findViewById.setVisibility(8);
            }
            return view;
        }

        @Override // com.tencent.mobileqq.adapter.j, android.widget.Adapter
        public int getCount() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
            }
            return this.F.size();
        }

        @Override // com.tencent.mobileqq.adapter.j, android.widget.Adapter
        public Object getItem(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return iPatchRedirector.redirect((short) 6, (Object) this, i3);
            }
            return this.F.get(i3);
        }

        @Override // com.tencent.mobileqq.adapter.j, android.widget.Adapter
        public long getItemId(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return ((Long) iPatchRedirector.redirect((short) 7, (Object) this, i3)).longValue();
            }
            return i3;
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public int getItemViewType(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this, i3)).intValue();
            }
            if (this.F.get(i3).f180841c == 2) {
                switch (this.F.get(i3).f180842d) {
                    case 80000001:
                        return 3;
                    case 80000003:
                        return 4;
                    case 80000004:
                        return 5;
                }
            }
            return this.F.get(i3).f180841c;
        }

        @Override // com.tencent.mobileqq.adapter.j, android.widget.Adapter
        public View getView(int i3, View view, ViewGroup viewGroup) {
            View view2;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                view2 = view;
                view = (View) iPatchRedirector.redirect((short) 8, this, Integer.valueOf(i3), view, viewGroup);
            } else {
                int itemViewType = getItemViewType(i3);
                if (itemViewType != 0) {
                    if (itemViewType != 1) {
                        if (itemViewType != 2) {
                            if (itemViewType != 3) {
                                if (itemViewType != 4) {
                                    if (itemViewType == 5) {
                                        view = l(i3, view, viewGroup);
                                    }
                                } else {
                                    view = i(i3, view, viewGroup);
                                }
                            } else {
                                view = j(i3, view, viewGroup);
                            }
                        } else {
                            view = k(i3, view, viewGroup);
                        }
                    } else {
                        view = m(i3, view, viewGroup);
                    }
                } else {
                    view = n(i3, view, viewGroup);
                }
                view2 = view;
            }
            EventCollector.getInstance().onListGetView(i3, view2, viewGroup, getItemId(i3));
            return view;
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public int getViewTypeCount() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
            }
            return 6;
        }

        public void setData(ArrayList<d> arrayList) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) arrayList);
                return;
            }
            this.F = arrayList;
            SearchContactsFragment.this.f180824k0.clear();
            int i3 = 0;
            for (int i16 = 0; i16 < this.F.size(); i16++) {
                if (this.F.get(i16).f180841c == 0) {
                    i3++;
                    SearchContactsFragment.this.f180824k0.put(Integer.valueOf(this.F.get(i16).f180842d), Integer.valueOf(i3));
                }
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(67848);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 18)) {
            redirector.redirect((short) 18);
        } else {
            f180815w0 = -1;
        }
    }

    public SearchContactsFragment() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f180818e0 = 0.0d;
        this.f180819f0 = 0.0d;
        this.f180821h0 = null;
        this.f180822i0 = "";
        this.f180823j0 = "";
        this.f180824k0 = new ConcurrentHashMap();
        this.f180826m0 = 2;
        this.f180830q0 = new a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Bi(String str, int i3) {
        this.f180816c0 = true;
        this.f180817d0 = 80000001;
        if (!TextUtils.isEmpty(str)) {
            ReportController.o(this.S, "dc00899", "add_page", "", "search_grp", "clk_history", 0, 0, "", "", str, "");
            qi(str, false, i3);
        }
    }

    private boolean Ci(ArrayList<un2.a> arrayList) {
        if (arrayList != null && arrayList.size() == 1) {
            un2.a aVar = arrayList.get(0);
            int i3 = 2;
            if (aVar.f439277j) {
                String str = "https://sqimg.qq.com/qq_product_operations/tiqq/suicide/?keyword=" + URLEncoder.encode(this.D);
                if (QLog.isColorLevel()) {
                    QLog.d("SearchContactsFragment", 2, "is SuicideWord word = " + this.D + " jump url is : " + str);
                }
                BaseActivity Gh = Gh();
                Intent intent = new Intent(Gh, (Class<?>) QQBrowserActivity.class);
                intent.putExtra("url", str);
                intent.putExtra("uin", this.S.getCurrentAccountUin());
                intent.putExtra("portraitOnly", true);
                intent.putExtra("hide_more_button", true);
                intent.putExtra("hide_operation_bar", true);
                intent.putExtra("isShowAd", false);
                Gh.startActivity(intent);
                return true;
            }
            List<AccountSearchPb$record> list = aVar.f439272e;
            if (list != null && list.size() == 2) {
                Matcher matcher = SearchBaseActivity.f180757p0.matcher(this.D);
                if (QLog.isColorLevel()) {
                    QLog.d("SearchContactsFragment", 2, "needJump lastKeywords = " + this.D);
                }
                if (matcher.matches()) {
                    xh();
                    sh(this.f180820g0);
                    int i16 = this.E;
                    if (i16 == 1) {
                        i3 = 3;
                    } else if (i16 != 0) {
                        i3 = 0;
                    }
                    zi(arrayList.get(0).f439268a, false, i3);
                    return true;
                }
            }
        }
        return false;
    }

    public static SearchContactsFragment Di(int i3) {
        f180815w0 = i3;
        return new SearchContactsFragment();
    }

    private void Ei(SearchBaseFragment.e eVar) {
        BaseActivity baseActivity;
        int i3;
        if (eVar != null && (baseActivity = getBaseActivity()) != null) {
            Bundle bundle = new Bundle();
            bundle.putString("url", eVar.f180786f);
            int i16 = f180815w0;
            if (i16 == 13) {
                bundle.putInt("articalChannelId", 12);
            } else if (i16 == 1) {
                bundle.putInt("articalChannelId", 10);
                if (eVar.f180789i != null) {
                    ((IPublicAccountReportUtils) QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "P_CliOper", IPublicAccountHandler.MAIN_ACTION, "", "0X8006F2A", "0X8006F2A", 0, 0, this.D, eVar.f180789i, eVar.f180790j, "1");
                }
            } else if (i16 == 2) {
                bundle.putInt("articalChannelId", 11);
            }
            ActivityURIRequest activityURIRequest = new ActivityURIRequest(baseActivity, IPublicAccountBrowser.ROUTE_NAME);
            activityURIRequest.extra().putAll(bundle);
            QRoute.startUri(activityURIRequest, (o) null);
            if (f180815w0 == 12) {
                ReportController.o(this.S, "CliOper", "", "", "0X800658A", "0X800658A", 0, 0, "" + eVar.f180787g, "", this.D, "" + eVar.f180788h);
            } else {
                ((IPublicAccountReportUtils) QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(this.S, "P_CliOper", IPublicAccountHandler.MAIN_ACTION, "0", "0X8005D95", "0X8005D95", 0, 0, "" + eVar.f180787g, "", this.D, "" + eVar.f180788h, false);
            }
            Integer num = this.f180824k0.get(80000003);
            if (num != null) {
                i3 = num.intValue();
            } else {
                i3 = 0;
            }
            SearchUtils.a1(80000003, i3, eVar.f180787g, true, null, this.D, f180815w0);
        }
    }

    private void Fi(SearchBaseFragment.f fVar) {
        String str;
        int i3;
        String str2;
        String str3;
        PBUInt64Field pBUInt64Field;
        if (fVar == null) {
            return;
        }
        ai(fVar.f180800j, fVar.f180801k, 2);
        ReportController.o(this.S, "CliOper", "", "", "0X8004BF2", "0X8004BF2", ti(fVar.f180800j), 0, "", "", "", "");
        Integer num = this.f180824k0.get(Integer.valueOf(fVar.f180800j));
        AccountSearchPb$record accountSearchPb$record = fVar.f180801k;
        if (accountSearchPb$record != null && (pBUInt64Field = accountSearchPb$record.uin) != null) {
            str = String.valueOf(pBUInt64Field.get());
        } else {
            str = null;
        }
        String str4 = str;
        int i16 = fVar.f180800j;
        if (num != null) {
            i3 = num.intValue();
        } else {
            i3 = 0;
        }
        SearchUtils.a1(i16, i3, fVar.f180803m, true, str4, this.D, f180815w0);
        if (fVar.f180800j == 80000002) {
            AccountSearchPb$record accountSearchPb$record2 = fVar.f180801k;
            BaseActivity baseActivity = getBaseActivity();
            if (accountSearchPb$record2 != null && baseActivity != null && (baseActivity instanceof SearchBaseActivity)) {
                int G2 = ((SearchBaseActivity) baseActivity).G2();
                IPublicAccountDetailReportUtil iPublicAccountDetailReportUtil = (IPublicAccountDetailReportUtil) QRoute.api(IPublicAccountDetailReportUtil.class);
                String str5 = "";
                if (accountSearchPb$record2.uin == null) {
                    str2 = "";
                } else {
                    str2 = accountSearchPb$record2.uin.get() + "";
                }
                iPublicAccountDetailReportUtil.setAttrSearchClick(2, str2, fVar.f180803m, f180815w0);
                if (f180815w0 == 12) {
                    QQAppInterface qQAppInterface = this.S;
                    String str6 = fVar.f180803m + "";
                    String a16 = SearchBaseActivity.e.a(G2);
                    if (accountSearchPb$record2.uin != null) {
                        str5 = accountSearchPb$record2.uin.get() + "";
                    }
                    ReportController.n(qQAppInterface, "CliOper", "", "", "0X8006571", "0X8006571", 0, 1, 0, str6, a16, str5, this.D);
                    return;
                }
                IPublicAccountReportUtils iPublicAccountReportUtils = (IPublicAccountReportUtils) QRoute.api(IPublicAccountReportUtils.class);
                QQAppInterface qQAppInterface2 = this.S;
                if (accountSearchPb$record2.uin == null) {
                    str3 = "";
                } else {
                    str3 = accountSearchPb$record2.uin.get() + "";
                }
                iPublicAccountReportUtils.publicAccountReportClickEventForMigrate(qQAppInterface2, "P_CliOper", IPublicAccountHandler.MAIN_ACTION, str3, "0X8005D20", "0X8005D20", 0, 0, fVar.f180803m + "", SearchBaseActivity.e.a(G2), this.D, "", false);
            }
        }
    }

    private void Gi(f.b bVar) {
        int i3;
        int i16;
        if (bVar.K) {
            i3 = 30004;
        } else {
            i3 = BaseConstants.ERR_SVR_FRIENDSHIP_WRITE_CONFLICT;
        }
        Bundle d16 = aq.d(bVar.f187210d, bVar.J, i3);
        d16.putInt("exposureSource", 3);
        d16.putInt("t_s_f", 1000);
        TroopUtils.I(Gh(), d16, 2);
        ReportController.o(this.S, "CliOper", "", "", "0X8004BF2", "0X8004BF2", ti(80000001), 0, "", "", "", "");
        ReportController.o(this.S, "P_CliOper", "Grp_find", "", "result", "Clk_grpdate", 0, 0, bVar.f187210d, "", "", "");
        Integer num = this.f180824k0.get(80000001);
        if (num != null) {
            i16 = num.intValue();
        } else {
            i16 = 0;
        }
        SearchUtils.a1(80000001, i16, bVar.H, true, bVar.f187210d, this.D, f180815w0);
        SearchUtils.V0("add_page", "all_result", "clk_grp", 0, this.f180826m0, bVar.f187210d, "", this.D, "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ii(List<com.tencent.mobileqq.activity.contact.addcontact.groupsearch.guess.b> list) {
        GroupSearchRecommendView groupSearchRecommendView = this.f180831r0;
        if (groupSearchRecommendView != null) {
            groupSearchRecommendView.setGuessData(list);
        }
    }

    private String si(int i3) {
        switch (i3) {
            case 80000000:
                return "0X8004BEE";
            case 80000001:
                return "0X8004BEF";
            case 80000002:
                return "0X8004BF0";
            default:
                return "";
        }
    }

    private int ti(int i3) {
        switch (i3) {
            case 80000001:
                return 2;
            case 80000002:
                return 3;
            default:
                return 1;
        }
    }

    private un2.a ui(int i3) {
        ArrayList<un2.a> arrayList = this.f180820g0;
        if (arrayList == null) {
            return null;
        }
        Iterator<un2.a> it = arrayList.iterator();
        while (it.hasNext()) {
            un2.a next = it.next();
            if (next.f439268a == i3) {
                return next;
            }
        }
        return null;
    }

    private void vi() {
        int i3 = this.F;
        if (i3 != 2) {
            if (i3 != 4) {
                if (i3 == 7) {
                    this.f180828o0 = 14;
                }
            } else {
                this.f180828o0 = 4;
            }
        } else {
            this.f180828o0 = 13;
        }
        this.f180827n0 = this.f180828o0;
    }

    private boolean wi() {
        if (f180815w0 == 13 && ac.a()) {
            return true;
        }
        return false;
    }

    private boolean xi() {
        ArrayList<d> arrayList = this.f180834u0;
        if (arrayList != null) {
            Iterator<d> it = arrayList.iterator();
            while (it.hasNext()) {
                d next = it.next();
                if (next != null && next.f180842d == 80000002) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    private boolean yi() {
        if (f180815w0 == 13 && this.f180829p0) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.activity.contact.addcontact.SearchBaseFragment
    public void Ah() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
        } else {
            super.Ah();
            xh();
        }
    }

    void Ai(String str, String str2, String str3) {
        if (!TextUtils.isEmpty(str)) {
            ActivityURIRequest activityURIRequest = new ActivityURIRequest(Gh(), IPublicAccountBrowser.ROUTE_NAME);
            activityURIRequest.extra().putString("url", str);
            QRoute.startUri(activityURIRequest, (o) null);
            ((IPublicAccountReportUtils) QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "P_CliOper", IPublicAccountHandler.MAIN_ACTION, "", "0X8006F2A", "0X8006F2A", 0, 0, this.D, str2, str3, "2");
        }
    }

    @Override // com.tencent.mobileqq.activity.contact.addcontact.SearchBaseFragment
    public void Bh(String str, boolean z16) {
        int i3;
        int i16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, str, Boolean.valueOf(z16));
            return;
        }
        IGroupSearchHistoryManager iGroupSearchHistoryManager = (IGroupSearchHistoryManager) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IGroupSearchHistoryManager.class, "");
        if (f180815w0 == 30) {
            ((ITroopUtilApi) QRoute.api(ITroopUtilApi.class)).openSearchTabPageFromTroopSquare(this.S, this.U, str);
            iGroupSearchHistoryManager.add(str);
            return;
        }
        if (!yi() && this.E != 6) {
            if (wi()) {
                ActiveEntitySearchActivity.c3(getContext(), str, HardCodeUtil.qqStr(R.string.t6z), new long[]{1001, Constant.FROM_ID_UNINSTALL_PLUGIN});
                iGroupSearchHistoryManager.add(str);
                return;
            }
            this.G = z16;
            if (QLog.isColorLevel()) {
                QLog.d("SearchContactsFragment", 2, IECSearchBar.METHOD_DO_SEARCH);
            }
            if (NetworkUtil.isNetSupport(BaseApplication.getContext())) {
                showLoadingDialog();
                this.D = str;
                g gVar = this.V;
                if (gVar == null) {
                    if (QLog.isColorLevel()) {
                        QLog.d("SearchContactsFragment", 2, "doSearch:should not be here | searchFacade = null");
                    }
                    yh();
                    return;
                }
                gVar.l();
                if (this.E == 1) {
                    this.f180816c0 = true;
                    this.f180817d0 = 80000001;
                    iGroupSearchHistoryManager.add(str);
                }
                if (f180815w0 == 12) {
                    g gVar2 = this.V;
                    if (this.f180816c0) {
                        i16 = this.f180817d0;
                    } else {
                        i16 = 80000006;
                    }
                    gVar2.n(str, i16, this.f180819f0, this.f180818e0, 1);
                } else {
                    g gVar3 = this.V;
                    if (this.f180816c0) {
                        i3 = this.f180817d0;
                    } else {
                        i3 = 80000005;
                    }
                    gVar3.n(str, i3, this.f180819f0, this.f180818e0, 0);
                }
                this.H = true;
                if (this.f180816c0) {
                    String si5 = si(this.f180817d0);
                    ReportController.o(this.S, "CliOper", "", "", si5, si5, this.E + 1, 0, "", "", "", "");
                    return;
                } else {
                    ReportController.o(this.S, "CliOper", "", "", "0X8004BED", "0X8004BED", this.E + 1, 0, "", "", "", "");
                    return;
                }
            }
            QQToast.makeText(BaseApplication.getContext(), R.string.f171139ci4, 0).show(getTitleBarHeight());
            return;
        }
        SearchUtil.x(this.S, getContext(), str, this.f180827n0, this.F);
        iGroupSearchHistoryManager.add(str);
    }

    void Hi(String str) {
        ViewFactory.GuideView guideView = this.f180832s0;
        if (guideView != null) {
            guideView.d(Mh(), str);
        }
    }

    public void Ji(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) str);
            return;
        }
        this.f180825l0 = str;
        if (!TextUtils.isEmpty(str)) {
            Mi();
            Hi(str);
        } else {
            this.J.removeAllViews();
        }
    }

    public void Ki(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, i3);
        } else {
            this.f180827n0 = i3;
        }
    }

    void Li() {
        if (QLog.isColorLevel()) {
            QLog.i("SearchContactsFragment", 2, "show group search recommend view");
        }
        GroupSearchRecommendView groupSearchRecommendView = new GroupSearchRecommendView(Gh());
        this.f180831r0 = groupSearchRecommendView;
        groupSearchRecommendView.setOnItemClickListener(new com.tencent.mobileqq.activity.contact.addcontact.groupsearch.d() { // from class: com.tencent.mobileqq.activity.contact.addcontact.j
            @Override // com.tencent.mobileqq.activity.contact.addcontact.groupsearch.d
            public final void a(String str, int i3) {
                SearchContactsFragment.this.Bi(str, i3);
            }
        });
        Zh(this.f180831r0);
    }

    void Mi() {
        if (this.f180832s0 == null) {
            ViewFactory.GuideView guideView = (ViewFactory.GuideView) ViewFactory.f().a(80000005, Gh(), true, this.M, null);
            this.f180832s0 = guideView;
            if (guideView == null) {
                return;
            }
            guideView.setListener(new b());
            Zh(this.f180832s0);
            return;
        }
        View childAt = this.J.getChildAt(0);
        ViewFactory.GuideView guideView2 = this.f180832s0;
        if (childAt != guideView2) {
            Zh(guideView2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.activity.contact.addcontact.SearchBaseFragment
    public void Nh() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        super.Nh();
        QQAppInterface qQAppInterface = this.S;
        if (qQAppInterface != null) {
            qQAppInterface.addObserver(this.f180830q0);
            ((UnifySearchHandler) this.S.getBusinessHandler(BusinessHandlerFactory.UNIFY_SEARCH_UNITE_HANDLER)).E2(false);
        }
    }

    ArrayList<un2.a> Ni(ArrayList<un2.a> arrayList) {
        int[] i3 = ViewFactory.i(Mh());
        ArrayList<un2.a> arrayList2 = new ArrayList<>(arrayList.size());
        for (int i16 : i3) {
            Iterator<un2.a> it = arrayList.iterator();
            while (it.hasNext()) {
                un2.a next = it.next();
                if (next.f439268a == i16) {
                    arrayList2.add(next);
                }
            }
        }
        return arrayList2;
    }

    @Override // com.tencent.mobileqq.activity.contact.addcontact.SearchBaseFragment
    protected void Th() {
        AccountSearchPb$record accountSearchPb$record;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
            return;
        }
        if (this.f180834u0 == null) {
            Vh();
            return;
        }
        if (this.f180833t0 == null) {
            e eVar = new e(BaseApplication.getContext(), this.S, this.K, 4, true);
            this.f180833t0 = eVar;
            eVar.setData(this.f180834u0);
            this.K.setAdapter((ListAdapter) this.f180833t0);
            this.I = this.f180833t0;
        }
        if (this.J.getChildAt(0) != this.K) {
            this.J.removeAllViews();
            this.J.addView(this.K);
        }
        this.f180833t0.setData(this.f180834u0);
        this.f180833t0.notifyDataSetChanged();
        if (this.H) {
            this.H = false;
            this.K.setSelection(0);
        }
        if (xi()) {
            BaseActivity baseActivity = getBaseActivity();
            if (baseActivity != null && (baseActivity instanceof SearchContactsActivity)) {
                ((IPublicAccountReportUtils) QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(this.S, "P_CliOper", IPublicAccountHandler.MAIN_ACTION, "0", "0X8005D1F", "0X8005D1F", 0, 0, "", SearchBaseActivity.e.a(((SearchContactsActivity) baseActivity).G2()), this.D, "", false);
            }
            if (this.f180834u0 != null) {
                StringBuilder sb5 = new StringBuilder();
                Iterator<d> it = this.f180834u0.iterator();
                int i3 = 0;
                while (it.hasNext()) {
                    d next = it.next();
                    if (next != null && (accountSearchPb$record = next.f180839a) != null && next.f180842d == 80000002) {
                        sb5.append(String.valueOf(accountSearchPb$record.uin.get()));
                        sb5.append("#");
                        i3++;
                    }
                }
                ((IPublicAccountDetailReportUtil) QRoute.api(IPublicAccountDetailReportUtil.class)).setAttrSearchPage(((IPublicAccountDetailReportUtil) QRoute.api(IPublicAccountDetailReportUtil.class)).buildSearchID(this.S.getCurrentAccountUin(), this.D), this.D, 2, false, i3, sb5.toString());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.activity.contact.addcontact.SearchBaseFragment
    public void Vh() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        } else {
            super.Vh();
            this.f180816c0 = false;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    String oi(SearchBaseFragment.f fVar, d dVar) {
        boolean z16;
        int i3;
        String str;
        StringBuilder sb5 = new StringBuilder();
        int i16 = dVar.f180842d;
        fVar.f180796f = dVar.f180839a.uin.get() + "";
        if (dVar.f180839a.uin.get() != 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        fVar.f180798h = z16;
        fVar.f180797g = dVar.f180839a.mobile.get();
        fVar.f180792b.setCompoundDrawables(null, null, null, null);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        switch (i16) {
            case 80000000:
                fVar.f180792b.setText(Kh(80000000, dVar.f180839a.name.get()));
                spannableStringBuilder.append((CharSequence) "(");
                if (fVar.f180798h) {
                    str = fVar.f180796f;
                } else {
                    str = fVar.f180797g;
                }
                spannableStringBuilder.append((CharSequence) Kh(80000000, str));
                spannableStringBuilder.append((CharSequence) ")");
                break;
            case 80000001:
                fVar.f180792b.setText(Kh(80000001, String.valueOf(dVar.f180839a.name.get())));
                spannableStringBuilder.append((CharSequence) "(");
                spannableStringBuilder.append((CharSequence) Kh(80000001, String.valueOf(dVar.f180839a.code.get())));
                spannableStringBuilder.append((CharSequence) ")");
                break;
            case 80000002:
                fVar.f180792b.setText(Kh(80000002, String.valueOf(dVar.f180839a.name.get())));
                break;
        }
        fVar.f180793c.setText(PrettyAccountUtil.handleAccountTxt(dVar.f180839a.uint32_richflag1_59.get(), dVar.f180839a.uint32_richflag4_409.get(), spannableStringBuilder, dVar.f180839a.accout.get()));
        if (i16 == 80000000 && !TextUtils.isEmpty(fVar.f180796f) && Utils.G(fVar.f180796f)) {
            Drawable drawable = this.S.getApp().getResources().getDrawable(R.drawable.br7);
            this.S.getApp();
            int f16 = BaseAIOUtils.f(15.0f, BaseApplication.getContext().getResources());
            this.S.getApp();
            drawable.setBounds(0, 0, f16, BaseAIOUtils.f(15.0f, BaseApplication.getContext().getResources()));
            fVar.f180793c.setCompoundDrawables(null, null, drawable, null);
        } else {
            fVar.f180793c.setCompoundDrawables(null, null, null, null);
        }
        PrettyAccountUtil.handleAccountClothForList(fVar.f180793c, dVar.f180839a.uint32_richflag1_59.get(), dVar.f180839a.uint32_richflag4_409.get(), R.color.skin_gray2_item, 17);
        sb5.append(fVar.f180792b.getText().toString());
        sb5.append(fVar.f180793c.getText().toString());
        switch (i16) {
            case 80000000:
                sb5.append(uh(fVar, dVar.f180839a));
                i3 = 1;
                break;
            case 80000001:
                fVar.f180794d.setVisibility(0);
                fVar.f180794d.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                fVar.f180794d.setText(dVar.f180839a.number.get() + HardCodeUtil.qqStr(R.string.t6c));
                fVar.f180794d.setTextColor(Gh().getResources().getColor(R.color.skin_gray2));
                fVar.f180795e.setText(dVar.f180839a.brief.get());
                fVar.f180796f = String.valueOf(dVar.f180839a.code.get());
                sb5.append(fVar.f180794d.getText());
                sb5.append(fVar.f180795e.getText());
                i3 = 4;
                break;
            case 80000002:
                sb5.append(vh(fVar, dVar.f180839a));
                i3 = 1;
                break;
            default:
                i3 = 1;
                break;
        }
        Bitmap bitmapFromCache = this.M.getBitmapFromCache(i3, fVar.f180796f);
        if (bitmapFromCache == null) {
            bitmapFromCache = BaseImageUtil.getDefaultFaceBitmap();
            if (!this.M.isPausing()) {
                this.M.requestDecodeFace(fVar.f180796f, i3, true, (byte) 1);
            }
        }
        fVar.f180791a.setImageBitmap(bitmapFromCache);
        return sb5.toString();
    }

    @Override // com.tencent.mobileqq.activity.contact.addcontact.SearchBaseFragment, android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) view);
        } else {
            Object tag = view.getTag();
            if (tag != null) {
                if (tag instanceof SearchBaseFragment.f) {
                    Fi((SearchBaseFragment.f) tag);
                } else if (tag instanceof f.b) {
                    Gi((f.b) tag);
                } else if (tag instanceof SearchBaseFragment.e) {
                    Ei((SearchBaseFragment.e) tag);
                }
            } else if (view instanceof QzoneSearchResultView) {
                ((QzoneSearchResultView) view).b(getBaseActivity());
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.activity.contact.addcontact.SearchBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
            return;
        }
        super.onDestroy();
        e eVar = this.f180833t0;
        if (eVar != null) {
            eVar.destroy();
        }
        QQAppInterface qQAppInterface = this.S;
        if (qQAppInterface != null) {
            qQAppInterface.removeObserver(this.f180830q0);
        }
    }

    @Override // com.tencent.mobileqq.activity.contact.addcontact.SearchBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onDetach() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
        } else {
            super.onDetach();
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            super.onPause();
            ApngImage.pauseByTag(37);
        }
    }

    @Override // com.tencent.mobileqq.activity.contact.addcontact.SearchBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        super.onResume();
        ApngImage.playByTag(37);
        if (!((IGuildTempApi) QRoute.api(IGuildTempApi.class)).isGuildTabSelected()) {
            com.tencent.mobileqq.guild.report.b.g("functional_qq_group_search_result", "SearchContactsFragment");
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) view, (Object) bundle);
            return;
        }
        super.onViewCreated(view, bundle);
        int i3 = this.E;
        if (i3 == 1 || i3 == 6) {
            Li();
            vi();
        }
    }

    ArrayList<d> pi(ArrayList<un2.a> arrayList) {
        String str;
        int i3;
        int i16;
        String str2;
        ArrayList<d> arrayList2 = new ArrayList<>(12);
        int size = arrayList.size();
        int i17 = 0;
        int i18 = 0;
        while (i18 < size) {
            un2.a aVar = arrayList.get(i18);
            if (aVar != null && (aVar.f439272e.size() > 0 || aVar.f439276i.size() > 0)) {
                d dVar = new d();
                dVar.f180841c = i17;
                int i19 = aVar.f439268a;
                dVar.f180842d = i19;
                dVar.f180848j = aVar.f439278k;
                if (ViewFactory.g(i19) == R.string.f170119h0) {
                    dVar.f180843e = ((IPublicAccountConfigUtil) QRoute.api(IPublicAccountConfigUtil.class)).getSubscriptName(this.S, BaseApplication.getContext());
                } else {
                    dVar.f180843e = Gh().getString(ViewFactory.g(aVar.f439268a));
                }
                arrayList2.add(dVar);
                if (!TextUtils.isEmpty(aVar.f439274g)) {
                    str = aVar.f439274g;
                } else {
                    str = null;
                }
                AccountSearchPb$hotwordrecord accountSearchPb$hotwordrecord = aVar.f439273f;
                if (accountSearchPb$hotwordrecord != null && accountSearchPb$hotwordrecord.hotword.has()) {
                    d dVar2 = new d();
                    dVar2.f180841c = 2;
                    dVar2.f180840b = aVar.f439273f;
                    dVar2.f180842d = aVar.f439268a;
                    dVar2.f180844f = aVar.f439275h;
                    dVar2.f180845g = str;
                    arrayList2.add(dVar2);
                    ((IPublicAccountReportUtils) QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "P_CliOper", IPublicAccountHandler.MAIN_ACTION, "", "0X8006F75", "0X8006F75", 0, 0, this.D, dVar2.f180840b.hotword.get(), String.valueOf(dVar2.f180840b.hotword_type.get()), "");
                    i3 = 2;
                } else {
                    i3 = 3;
                }
                if (aVar.f439268a == 80000004) {
                    i16 = aVar.f439276i.size();
                    for (int i26 = 0; i26 < i3; i26++) {
                        d dVar3 = new d();
                        dVar3.f180846h = aVar.f439276i.get(i26);
                        dVar3.f180841c = 2;
                        dVar3.f180842d = aVar.f439268a;
                        arrayList2.add(dVar3);
                        if (i26 < i16 - 1) {
                        }
                    }
                } else {
                    int size2 = aVar.f439272e.size();
                    for (int i27 = 0; i27 < i3; i27++) {
                        d dVar4 = new d();
                        dVar4.f180841c = 2;
                        dVar4.f180839a = aVar.f439272e.get(i27);
                        dVar4.f180842d = aVar.f439268a;
                        dVar4.f180844f = aVar.f439275h;
                        dVar4.f180845g = str;
                        dVar4.f180848j = aVar.f439278k;
                        arrayList2.add(dVar4);
                        if (i27 < size2 - 1) {
                            if (aVar.f439268a == 80000001) {
                                ReportController.o(this.S, "P_CliOper", "Grp_find", "", "result", "exp", 0, 0, "", "", "", "");
                            }
                        } else {
                            i16 = size2;
                        }
                    }
                    i16 = size2;
                }
                if (i16 > 3) {
                    d dVar5 = new d();
                    dVar5.f180841c = 1;
                    int i28 = aVar.f439268a;
                    dVar5.f180842d = i28;
                    dVar5.f180844f = aVar.f439275h;
                    if (i28 == 80000004) {
                        dVar5.f180847i = aVar.f439274g;
                    }
                    arrayList2.add(dVar5);
                }
                if (QLog.isColorLevel()) {
                    QLog.d("SearchContactsFragment", 2, "search reuslt : type = " + aVar.f439268a + "count = " + aVar.f439272e.size());
                }
                switch (aVar.f439268a) {
                    case 80000000:
                        str2 = "0X80061B8";
                        break;
                    case 80000001:
                        str2 = "0X80061BB";
                        break;
                    case 80000002:
                        str2 = "0X80061BE";
                        break;
                    case 80000003:
                        str2 = "0X80061C1";
                        break;
                    default:
                        str2 = "";
                        break;
                }
                String str3 = str2;
                ReportController.o(null, "CliOper", "", "", str3, str3, 0, 0, String.valueOf(Math.min(i16, 3)), "", "", "");
            }
            i18++;
            i17 = 0;
        }
        return arrayList2;
    }

    public void qi(String str, boolean z16, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, str, Boolean.valueOf(z16), Integer.valueOf(i3));
            return;
        }
        this.f180827n0 = i3;
        Bh(str, z16);
        this.f180827n0 = this.f180828o0;
    }

    public int ri() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Integer) iPatchRedirector.redirect((short) 16, (Object) this)).intValue();
        }
        return this.f180827n0;
    }

    @Override // com.tencent.mobileqq.activity.contact.addcontact.SearchBaseFragment
    protected boolean th(ArrayList<un2.a> arrayList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this, (Object) arrayList)).booleanValue();
        }
        int i3 = 1;
        if (!this.f180816c0) {
            this.f180820g0 = arrayList;
            this.f180826m0 = t.g(arrayList, this.f180825l0);
            if (Ci(this.f180820g0)) {
                return false;
            }
            this.f180834u0 = pi(Ni(arrayList));
            xh();
            sh(this.f180820g0);
            return true;
        }
        this.f180816c0 = false;
        this.f180820g0 = arrayList;
        xh();
        sh(this.f180820g0);
        if (!Ci(this.f180820g0)) {
            int i16 = this.E;
            if (i16 == 1) {
                i3 = 3;
            } else if (i16 != 0) {
                i3 = 0;
            }
            zi(arrayList.get(0).f439268a, false, i3);
        }
        return false;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    void zi(int i3, boolean z16, int i16) {
        int i17;
        String str;
        Intent intent = new Intent();
        intent.putExtra("last_key_words", this.D);
        int i18 = 2;
        switch (i3) {
            case 80000000:
                BaseActivity Gh = Gh();
                if (Gh != null) {
                    intent.putExtra("from_key", 0);
                    intent.setClass(Gh, ClassificationSearchActivity.class);
                    ClassificationSearchActivity.V2(Gh, intent, ui(i3));
                }
                i17 = 1;
                break;
            case 80000001:
                Long valueOf = Long.valueOf(Double.valueOf(this.f180818e0 * 1000000.0d).longValue());
                String str2 = "https://qqweb.qq.com/m/relativegroup/index.html?source=qun_rec&keyword=" + URLEncoder.encode(this.D) + "&gpstype=1&sid=AWSAPtjyiVRg92WelXNMAqd0&_bid=165&lon=" + Long.valueOf(Double.valueOf(this.f180819f0 * 1000000.0d).longValue()) + "&lat=" + valueOf + "&sourceext=" + i16;
                if (z16) {
                    str2 = str2 + "&show_tab=hot";
                }
                String str3 = str2 + "&_wv=17039363&_wwv=1293&_cwv=8";
                if (QLog.isColorLevel()) {
                    QLog.d("SearchContactsFragment", 2, "call jump ,lastKeywords = " + this.D + " jump url is : " + str3);
                }
                Intent intent2 = new Intent(Gh(), (Class<?>) QQBrowserActivity.class);
                intent2.putExtra("url", str3);
                intent2.putExtra("uin", this.S.getCurrentAccountUin());
                intent2.putExtra("portraitOnly", true);
                intent2.putExtra("hide_more_button", true);
                intent2.putExtra("hide_operation_bar", true);
                intent2.putExtra("isShowAd", false);
                Gh().startActivity(intent2);
                ReportController.o(this.S, "P_CliOper", "Grp_find", "", "result", "Clk_more", 0, 0, "", "", "", "");
                QQAppInterface qQAppInterface = this.S;
                if (this.D.matches("^\\d{5,11}$")) {
                    str = "2";
                } else {
                    str = "1";
                }
                ReportController.o(qQAppInterface, "dc00899", "Grp_find", "", "inte_add", "inte_find_grp", 0, 0, str, this.D, "", "");
                i17 = i18;
                break;
            case 80000002:
                intent.putExtra("from_key", 2);
                BaseActivity baseActivity = getBaseActivity();
                if (baseActivity != null && (baseActivity instanceof SearchContactsActivity)) {
                    intent.putExtra("jump_src_key", ((SearchContactsActivity) baseActivity).G2());
                }
                intent.setClass(Gh(), ClassificationSearchActivity.class);
                ClassificationSearchActivity.V2(Gh(), intent, ui(i3));
                if (baseActivity != null && (baseActivity instanceof SearchBaseActivity)) {
                    ((IPublicAccountReportUtils) QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(this.S, "P_CliOper", IPublicAccountHandler.MAIN_ACTION, "", "0X8005D21", "0X8005D21", 0, 0, "0", SearchBaseActivity.e.a(((SearchBaseActivity) baseActivity).G2()), this.D, "", false);
                }
                i18 = 3;
                i17 = i18;
                break;
            case 80000003:
                intent.putExtra("from_key", 5);
                intent.putExtra(IProfileCardConst.KEY_FROM_TYPE, f180815w0);
                intent.setClass(Gh(), ClassificationSearchActivity.class);
                ClassificationSearchActivity.V2(Gh(), intent, ui(i3));
                ((IPublicAccountReportUtils) QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(this.S, "P_CliOper", IPublicAccountHandler.MAIN_ACTION, "0", "0X8005D96", "0X8005D96", 0, 0, "0", "", this.D, "", false);
                i17 = 1;
                break;
            default:
                i17 = 1;
                break;
        }
        ReportController.o(this.S, "CliOper", "", "", "0X8004BF1", "0X8004BF1", i17, 0, "", "", "", "");
    }
}
