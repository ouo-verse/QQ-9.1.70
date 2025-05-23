package com.tencent.mobileqq.activity.contact.addcontact;

import addcontacts.AccountSearchPb$record;
import android.annotation.TargetApi;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.biz.eqq.CrmUtils;
import com.tencent.biz.pubaccount.accountdetail.api.IPublicAccountDetailActivity;
import com.tencent.biz.pubaccount.api.IPublicAccountDataManager;
import com.tencent.biz.pubaccount.api.IPublicAccountDetailReportUtil;
import com.tencent.biz.pubaccount.api.IPublicAccountHandler;
import com.tencent.biz.pubaccount.api.IPublicAccountSearchRecommendManager;
import com.tencent.biz.pubaccount.util.api.IPublicAccountConfigUtil;
import com.tencent.common.config.AppSetting;
import com.tencent.image.ApngImage;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.activity.contact.addcontact.SearchBaseActivity;
import com.tencent.mobileqq.activity.contact.addcontact.SearchBaseFragment;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.mobileqq.qroute.route.o;
import com.tencent.mobileqq.search.activity.UniteSearchActivity;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.vas.util.PrettyAccountUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.widget.AbsListView;
import com.tencent.widget.GridView;
import com.tencent.widget.ThemeImageView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes10.dex */
public class ClassificationSearchFragment extends SearchBaseFragment {
    static IPatchRedirector $redirector_;

    /* renamed from: n0, reason: collision with root package name */
    private static un2.a f180720n0;

    /* renamed from: o0, reason: collision with root package name */
    private static boolean f180721o0;

    /* renamed from: p0, reason: collision with root package name */
    private static int f180722p0;

    /* renamed from: c0, reason: collision with root package name */
    int f180723c0;

    /* renamed from: d0, reason: collision with root package name */
    int f180724d0;

    /* renamed from: e0, reason: collision with root package name */
    private View f180725e0;

    /* renamed from: f0, reason: collision with root package name */
    private View f180726f0;

    /* renamed from: g0, reason: collision with root package name */
    private List<AccountSearchPb$record> f180727g0;

    /* renamed from: h0, reason: collision with root package name */
    private int f180728h0;

    /* renamed from: i0, reason: collision with root package name */
    private boolean f180729i0;

    /* renamed from: j0, reason: collision with root package name */
    private int f180730j0;

    /* renamed from: k0, reason: collision with root package name */
    private a f180731k0;

    /* renamed from: l0, reason: collision with root package name */
    boolean f180732l0;

    /* renamed from: m0, reason: collision with root package name */
    private c f180733m0;

    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class a extends BaseAdapter implements IPublicAccountSearchRecommendManager.a, DecodeTaskCompletionListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        private View.OnClickListener f180735d;

        /* renamed from: e, reason: collision with root package name */
        private boolean f180736e;

        /* renamed from: f, reason: collision with root package name */
        private String f180737f;

        /* renamed from: h, reason: collision with root package name */
        private ArrayList<IPublicAccountSearchRecommendManager.c> f180738h;

        /* renamed from: i, reason: collision with root package name */
        private com.tencent.mobileqq.activity.recent.i f180739i;

        /* compiled from: P */
        /* renamed from: com.tencent.mobileqq.activity.contact.addcontact.ClassificationSearchFragment$a$a, reason: collision with other inner class name */
        /* loaded from: classes10.dex */
        class ViewOnClickListenerC7143a implements View.OnClickListener {
            static IPatchRedirector $redirector_;

            ViewOnClickListenerC7143a() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) a.this);
                }
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                boolean z16;
                String str;
                EventCollector.getInstance().onViewClickedBefore(view);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
                } else {
                    IPublicAccountSearchRecommendManager.c cVar = (IPublicAccountSearchRecommendManager.c) view.getTag();
                    IPublicAccountDataManager iPublicAccountDataManager = (IPublicAccountDataManager) ClassificationSearchFragment.this.S.getRuntimeService(IPublicAccountDataManager.class, "all");
                    if (iPublicAccountDataManager != null && ((PublicAccountInfo) iPublicAccountDataManager.findPublicAccountInfoCache(cVar.f79362a)) != null) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (z16) {
                        Intent intent = new Intent(ClassificationSearchFragment.this.Gh(), (Class<?>) ChatActivity.class);
                        if (cVar.f79364c) {
                            intent.putExtra("uintype", 1008);
                        } else {
                            intent.putExtra("uintype", 1024);
                        }
                        intent.putExtra("uin", cVar.f79362a);
                        intent.putExtra("uinname", cVar.f79363b);
                        intent.putExtra("start_time", System.currentTimeMillis());
                        ClassificationSearchFragment.this.Gh().startActivity(intent);
                    } else if (cVar.f79364c) {
                        ActivityURIRequest activityURIRequest = new ActivityURIRequest(ClassificationSearchFragment.this.Gh(), IPublicAccountDetailActivity.ROUTE_NAME);
                        activityURIRequest.extra().putInt("uintype", 1008);
                        activityURIRequest.extra().putInt("source", 118);
                        QRoute.startUri(activityURIRequest, (o) null);
                    } else {
                        Intent n3 = CrmUtils.n(ClassificationSearchFragment.this.Gh(), null, "", false, -1, false, -1);
                        n3.putExtra("uin", cVar.f79362a);
                        n3.addFlags(67108864);
                        ClassificationSearchFragment.this.Gh().startActivity(n3);
                    }
                    if (a.this.f180736e) {
                        str = "houtai";
                    } else {
                        str = "duan";
                    }
                    ((IPublicAccountReportUtils) QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(ClassificationSearchFragment.this.S, cVar.f79362a, "0X8007404", "0X8007404", 0, 0, "", "", str, "");
                    if (QLog.isColorLevel()) {
                        QLog.d("ClassificationSearchFragment", 2, "clickRecommendAccount->source:" + str + ", puin:" + cVar.f79362a + ", isFollow:" + z16);
                    }
                }
                EventCollector.getInstance().onViewClicked(view);
            }
        }

        public a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ClassificationSearchFragment.this);
                return;
            }
            this.f180735d = new ViewOnClickListenerC7143a();
            this.f180736e = false;
            this.f180739i = new com.tencent.mobileqq.activity.recent.i(ClassificationSearchFragment.this.S, this, false);
            f(true);
        }

        @Override // com.tencent.biz.pubaccount.api.IPublicAccountSearchRecommendManager.a
        public void a(ArrayList<IPublicAccountSearchRecommendManager.c> arrayList, String str, boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, this, arrayList, str, Boolean.valueOf(z16));
                return;
            }
            this.f180738h = arrayList;
            this.f180737f = str;
            this.f180736e = z16;
            if (ClassificationSearchFragment.this.f180726f0 != null) {
                if (getCount() == 0) {
                    ((TextView) ClassificationSearchFragment.this.f180726f0.findViewById(R.id.iju)).setText(HardCodeUtil.qqStr(R.string.f171746km3));
                    ClassificationSearchFragment.this.f180726f0.setVisibility(8);
                } else {
                    if (TextUtils.isEmpty(str)) {
                        ((TextView) ClassificationSearchFragment.this.f180726f0.findViewById(R.id.iju)).setText(HardCodeUtil.qqStr(R.string.km8));
                    } else {
                        ((TextView) ClassificationSearchFragment.this.f180726f0.findViewById(R.id.iju)).setText(str);
                    }
                    ClassificationSearchFragment.this.f180726f0.setVisibility(0);
                    notifyDataSetChanged();
                }
            }
            if (QLog.isColorLevel()) {
                StringBuilder sb5 = new StringBuilder("onGetRecommendSuccess->isFromRecommend:" + z16 + ", title:" + str + ", list:");
                if (arrayList == null) {
                    sb5.append("null");
                } else {
                    sb5.append("size:");
                    sb5.append(arrayList.size());
                }
                QLog.d("ClassificationSearchFragment", 2, sb5.toString());
                if (arrayList != null && arrayList.size() > 0) {
                    Iterator<IPublicAccountSearchRecommendManager.c> it = arrayList.iterator();
                    while (it.hasNext()) {
                        QLog.d("ClassificationSearchFragment", 2, "onGetRecommendSuccess->" + it.next().toString());
                    }
                }
            }
        }

        public ArrayList<IPublicAccountSearchRecommendManager.c> c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return (ArrayList) iPatchRedirector.redirect((short) 6, (Object) this);
            }
            return this.f180738h;
        }

        public String d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (String) iPatchRedirector.redirect((short) 5, (Object) this);
            }
            return this.f180737f;
        }

        public void e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            com.tencent.mobileqq.activity.recent.i iVar = this.f180739i;
            if (iVar != null) {
                iVar.r();
            }
        }

        public void f(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, z16);
            } else {
                ((IPublicAccountSearchRecommendManager) QRoute.api(IPublicAccountSearchRecommendManager.class)).getRecommendList(ClassificationSearchFragment.this.S, z16, this);
            }
        }

        @Override // android.widget.Adapter
        public int getCount() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
            }
            ArrayList<IPublicAccountSearchRecommendManager.c> arrayList = this.f180738h;
            if (arrayList == null) {
                return 0;
            }
            return arrayList.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return iPatchRedirector.redirect((short) 8, (Object) this, i3);
            }
            ArrayList<IPublicAccountSearchRecommendManager.c> arrayList = this.f180738h;
            if (arrayList != null && i3 < arrayList.size()) {
                return this.f180738h.get(i3);
            }
            return null;
        }

        @Override // android.widget.Adapter
        public long getItemId(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                return ((Long) iPatchRedirector.redirect((short) 9, (Object) this, i3)).longValue();
            }
            return i3;
        }

        @Override // android.widget.Adapter
        public View getView(int i3, View view, ViewGroup viewGroup) {
            View view2;
            View view3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                view2 = (View) iPatchRedirector.redirect((short) 10, this, Integer.valueOf(i3), view, viewGroup);
                view3 = view;
            } else {
                if (view == null) {
                    view = LayoutInflater.from(ClassificationSearchFragment.this.getBaseActivity()).inflate(R.layout.f168429vy, (ViewGroup) null);
                }
                IPublicAccountSearchRecommendManager.c cVar = (IPublicAccountSearchRecommendManager.c) getItem(i3);
                if (cVar != null) {
                    com.tencent.mobileqq.activity.recent.i iVar = this.f180739i;
                    if (iVar != null) {
                        ((URLImageView) view.findViewById(R.id.head)).setImageDrawable(iVar.e(1008, cVar.f79362a));
                    }
                    ((TextView) view.findViewById(R.id.f5e)).setText(cVar.f79363b);
                    view.findViewById(R.id.b8q).setOnClickListener(this.f180735d);
                    view.findViewById(R.id.b8q).setTag(cVar);
                    view.setTag(cVar);
                }
                view2 = view;
                view3 = view2;
            }
            EventCollector.getInstance().onListGetView(i3, view3, viewGroup, getItemId(i3));
            return view2;
        }

        @Override // com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener
        public void onDecodeTaskCompleted(int i3, int i16, String str, Bitmap bitmap) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
                iPatchRedirector.redirect((short) 11, this, Integer.valueOf(i3), Integer.valueOf(i16), str, bitmap);
                return;
            }
            if (ClassificationSearchFragment.this.f180726f0 != null && !TextUtils.isEmpty(str)) {
                if ((bitmap != null || i3 <= 0) && bitmap != null) {
                    GridView gridView = (GridView) ClassificationSearchFragment.this.f180726f0.findViewById(R.id.ijq);
                    int childCount = gridView.getChildCount();
                    for (int i17 = 0; i17 < childCount; i17++) {
                        View childAt = gridView.getChildAt(i17);
                        if (str.equals(((IPublicAccountSearchRecommendManager.c) childAt.getTag()).f79362a)) {
                            ((URLImageView) childAt.findViewById(R.id.head)).setImageBitmap(bitmap);
                        }
                    }
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    static class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public ProgressBar f180742a;

        /* renamed from: b, reason: collision with root package name */
        public TextView f180743b;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class c extends BaseAdapter {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        private List<AccountSearchPb$record> f180744d;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ClassificationSearchFragment.this);
            }
        }

        public List<AccountSearchPb$record> a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (List) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return this.f180744d;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            int i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
            }
            int size = this.f180744d.size();
            if (ClassificationSearchFragment.this.f180723c0 != 0) {
                i3 = 1;
            } else {
                i3 = 0;
            }
            return size + i3;
        }

        @Override // android.widget.Adapter
        public Object getItem(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return iPatchRedirector.redirect((short) 7, (Object) this, i3);
            }
            return this.f180744d.get(i3);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return ((Long) iPatchRedirector.redirect((short) 8, (Object) this, i3)).longValue();
            }
            return i3;
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public int getItemViewType(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this, i3)).intValue();
            }
            if (i3 < this.f180744d.size()) {
                if (this.f180744d.get(i3).account_id.has()) {
                    return 2;
                }
                return 0;
            }
            return 1;
        }

        @Override // android.widget.Adapter
        public View getView(int i3, View view, ViewGroup viewGroup) {
            View view2;
            View view3;
            View view4;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                view2 = (View) iPatchRedirector.redirect((short) 9, this, Integer.valueOf(i3), view, viewGroup);
                view3 = view;
            } else {
                int itemViewType = getItemViewType(i3);
                if (itemViewType != 0) {
                    if (itemViewType != 1) {
                        if (itemViewType != 2) {
                            view2 = view;
                        } else {
                            AccountSearchPb$record accountSearchPb$record = this.f180744d.get(i3);
                            if (view == null) {
                                View inflate = ClassificationSearchFragment.this.Gh().getLayoutInflater().inflate(R.layout.b1o, (ViewGroup) null);
                                SearchBaseFragment.e eVar = new SearchBaseFragment.e();
                                eVar.f180781a = (ImageView) inflate.findViewById(R.id.d3i);
                                eVar.f180782b = (TextView) inflate.findViewById(R.id.f9r);
                                eVar.f180784d = (TextView) inflate.findViewById(R.id.jlx);
                                eVar.f180785e = (TextView) inflate.findViewById(R.id.a1e);
                                eVar.f180783c = (TextView) inflate.findViewById(R.id.f164643ae1);
                                eVar.f180788h = accountSearchPb$record.account_id.get();
                                inflate.setOnClickListener(ClassificationSearchFragment.this);
                                inflate.setTag(eVar);
                                view4 = inflate;
                            } else {
                                view4 = view;
                            }
                            SearchBaseFragment.e eVar2 = (SearchBaseFragment.e) view4.getTag();
                            eVar2.f180784d.setText(accountSearchPb$record.article_create_time.get());
                            if (accountSearchPb$record.article_author.has() && !"".equals(accountSearchPb$record.article_author.get())) {
                                eVar2.f180785e.setText(accountSearchPb$record.article_author.get());
                            }
                            int dimensionPixelSize = ClassificationSearchFragment.this.getResources().getDimensionPixelSize(R.dimen.f159238y4);
                            if (!TextUtils.isEmpty(accountSearchPb$record.title_image.get())) {
                                try {
                                    eVar2.f180781a.setImageDrawable(URLDrawable.getDrawable(accountSearchPb$record.title_image.get(), dimensionPixelSize, dimensionPixelSize));
                                } catch (Exception e16) {
                                    QLog.d("ClassificationSearchFragment", 1, "classification urldrawable error:" + e16.toString());
                                }
                            }
                            eVar2.f180786f = accountSearchPb$record.article_short_url.get();
                            if (accountSearchPb$record.name.has()) {
                                eVar2.f180782b.setText(ClassificationSearchFragment.this.Kh(80000003, accountSearchPb$record.name.get()));
                            }
                            if (accountSearchPb$record.brief.has() && !"".equals(accountSearchPb$record.brief.get())) {
                                ClassificationSearchFragment classificationSearchFragment = ClassificationSearchFragment.this;
                                if (classificationSearchFragment.Ph(eVar2.f180782b, classificationSearchFragment.Gh()) > 1) {
                                    eVar2.f180783c.setMaxLines(1);
                                } else {
                                    eVar2.f180783c.setMaxLines(2);
                                }
                                eVar2.f180783c.setVisibility(0);
                                eVar2.f180783c.setEllipsize(TextUtils.TruncateAt.END);
                                SpannableString Kh = ClassificationSearchFragment.this.Kh(80000003, accountSearchPb$record.brief.get());
                                if (QLog.isColorLevel()) {
                                    QLog.d("ClassificationSearchFragment", 2, "brief = " + ((Object) Kh));
                                }
                                eVar2.f180783c.setText(Kh);
                                view4.setLayoutParams(new AbsListView.LayoutParams(new AbsListView.LayoutParams(-1, BaseAIOUtils.f(110.0f, ClassificationSearchFragment.this.Gh().getResources()))));
                            } else {
                                if (QLog.isColorLevel()) {
                                    QLog.d("ClassificationSearchFragment", 2, "brief = gone");
                                }
                                eVar2.f180783c.setVisibility(8);
                                view4.setLayoutParams(new AbsListView.LayoutParams(new AbsListView.LayoutParams(-1, BaseAIOUtils.f(90.0f, ClassificationSearchFragment.this.Gh().getResources()))));
                            }
                            ImageView imageView = (ImageView) view4.findViewById(R.id.f167121l13);
                            imageView.setVisibility(4);
                            ImageView imageView2 = (ImageView) view4.findViewById(R.id.bat);
                            imageView2.setVisibility(4);
                            if (accountSearchPb$record.video_article.has() && accountSearchPb$record.video_article.get() == 11) {
                                imageView.setVisibility(0);
                                imageView2.getBackground().setAlpha(25);
                                imageView2.setVisibility(0);
                            }
                            eVar2.f180787g = i3 + 1;
                            view2 = view4;
                        }
                    } else {
                        if (view == null) {
                            view2 = ClassificationSearchFragment.this.Gh().getLayoutInflater().inflate(R.layout.f168308si, (ViewGroup) null);
                            view2.setOnClickListener(ClassificationSearchFragment.this);
                            b bVar = new b();
                            view2.setTag(bVar);
                            bVar.f180742a = (ProgressBar) view2.findViewById(R.id.i5n);
                            view2.findViewById(R.id.eex).setVisibility(8);
                            bVar.f180743b = (TextView) view2.findViewById(R.id.f0v);
                        } else {
                            view2 = view;
                        }
                        ClassificationSearchFragment.this.hi();
                        b bVar2 = (b) view2.getTag();
                        ClassificationSearchFragment classificationSearchFragment2 = ClassificationSearchFragment.this;
                        int i16 = classificationSearchFragment2.f180723c0;
                        if (i16 == 3) {
                            if (!classificationSearchFragment2.f180732l0) {
                                classificationSearchFragment2.f180732l0 = true;
                                bVar2.f180742a.setVisibility(8);
                                bVar2.f180743b.setText(HardCodeUtil.qqStr(R.string.f171747km4));
                            } else if (NetworkUtil.isNetSupport(BaseApplication.getContext())) {
                                ClassificationSearchFragment.this.f180732l0 = false;
                                bVar2.f180742a.setVisibility(0);
                                bVar2.f180743b.setText(HardCodeUtil.qqStr(R.string.kmc));
                                ClassificationSearchFragment classificationSearchFragment3 = ClassificationSearchFragment.this;
                                classificationSearchFragment3.Bh(classificationSearchFragment3.D, true);
                            }
                        } else if (i16 == 2) {
                            bVar2.f180742a.setVisibility(0);
                            bVar2.f180743b.setText(HardCodeUtil.qqStr(R.string.kmk));
                        } else if (i16 == 4) {
                            bVar2.f180742a.setVisibility(8);
                            bVar2.f180743b.setText(HardCodeUtil.qqStr(R.string.kmg));
                        }
                    }
                } else {
                    if (view == null) {
                        view2 = ClassificationSearchFragment.this.Gh().getLayoutInflater().inflate(R.layout.apz, viewGroup, false);
                        view2.setOnClickListener(ClassificationSearchFragment.this);
                        SearchBaseFragment.f fVar = new SearchBaseFragment.f();
                        fVar.f180791a = (ImageView) view2.findViewById(R.id.d3i);
                        fVar.f180792b = (TextView) view2.findViewById(R.id.f9r);
                        fVar.f180793c = (TextView) view2.findViewById(R.id.kh6);
                        fVar.f180794d = (TextView) view2.findViewById(R.id.bgr);
                        fVar.f180795e = (TextView) view2.findViewById(R.id.efv);
                        fVar.f180801k = (AccountSearchPb$record) getItem(i3);
                        fVar.f180800j = ClassificationSearchFragment.this.f180728h0;
                        view2.setTag(R.id.emf, Integer.valueOf(i3));
                        view2.setTag(fVar);
                        ImageView imageView3 = fVar.f180791a;
                        if (imageView3 instanceof ThemeImageView) {
                            ((ThemeImageView) imageView3).setSupportMaskView(false);
                        }
                    } else {
                        view2 = view;
                    }
                    SearchBaseFragment.f fVar2 = (SearchBaseFragment.f) view2.getTag();
                    fVar2.f180801k = (AccountSearchPb$record) getItem(i3);
                    fVar2.f180803m = i3 + 1;
                    String gi5 = ClassificationSearchFragment.this.gi(fVar2, this.f180744d.get(i3));
                    if (AppSetting.f99565y) {
                        view2.setContentDescription(gi5);
                    }
                }
                view3 = view2;
            }
            EventCollector.getInstance().onListGetView(i3, view3, viewGroup, getItemId(i3));
            return view2;
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public int getViewTypeCount() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
            }
            return 3;
        }

        public void setData(List<AccountSearchPb$record> list) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) list);
            } else {
                this.f180744d = list;
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(67812);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 17)) {
            redirector.redirect((short) 17);
        } else {
            f180721o0 = false;
            f180722p0 = 0;
        }
    }

    public ClassificationSearchFragment() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f180723c0 = 0;
        this.f180724d0 = 0;
        this.f180727g0 = new ArrayList(20);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String gi(SearchBaseFragment.f fVar, AccountSearchPb$record accountSearchPb$record) {
        boolean z16;
        int i3;
        String str;
        String str2;
        String str3;
        StringBuilder sb5 = new StringBuilder();
        fVar.f180796f = accountSearchPb$record.uin.get() + "";
        fVar.f180797g = accountSearchPb$record.mobile.get();
        if (accountSearchPb$record.uin.get() != 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        fVar.f180798h = z16;
        fVar.f180792b.setText(Kh(fVar.f180800j, accountSearchPb$record.name.get()));
        sb5.append(fVar.f180792b.getText());
        if (fVar.f180800j == 80000000) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            spannableStringBuilder.append((CharSequence) "(");
            if (fVar.f180798h) {
                str3 = fVar.f180796f;
            } else {
                str3 = fVar.f180797g;
            }
            spannableStringBuilder.append((CharSequence) Kh(80000000, str3));
            spannableStringBuilder.append((CharSequence) ")");
            fVar.f180793c.setText(spannableStringBuilder);
            if (!TextUtils.isEmpty(fVar.f180796f) && Utils.G(fVar.f180796f)) {
                Resources resources = this.S.getApp().getResources();
                Drawable drawable = resources.getDrawable(R.drawable.br7);
                drawable.setBounds(0, 0, BaseAIOUtils.f(15.0f, resources), BaseAIOUtils.f(15.0f, resources));
                ThemeUtil.setThemeFilter(drawable, ThemeUtil.curThemeId);
                fVar.f180793c.setCompoundDrawables(null, null, drawable, null);
            } else {
                fVar.f180793c.setCompoundDrawables(null, null, null, null);
            }
            int i16 = accountSearchPb$record.uint32_richflag1_59.get();
            int i17 = accountSearchPb$record.uint32_richflag4_409.get();
            PrettyAccountUtil.reportLhEvent("0X800B238", i16, i17);
            fVar.f180793c.setText(PrettyAccountUtil.handleAccountTxt(i16, i17, spannableStringBuilder, fVar.f180796f));
            PrettyAccountUtil.handleAccountClothForList(fVar.f180793c, i16, i17, R.color.skin_gray2_item, 17);
            sb5.append(fVar.f180793c.getText());
        }
        int i18 = this.E;
        if (i18 != 0) {
            if (i18 == 2) {
                sb5.append(vh(fVar, accountSearchPb$record));
            }
        } else {
            sb5.append(uh(fVar, accountSearchPb$record));
        }
        IFaceDecoder iFaceDecoder = this.M;
        boolean z17 = fVar.f180798h;
        int i19 = 11;
        if (z17) {
            i3 = 1;
        } else {
            i3 = 11;
        }
        if (z17) {
            str = fVar.f180796f;
        } else {
            str = fVar.f180797g;
        }
        Bitmap bitmapFromCache = iFaceDecoder.getBitmapFromCache(i3, str);
        if (bitmapFromCache == null) {
            bitmapFromCache = BaseImageUtil.getDefaultFaceBitmap();
            if (!this.M.isPausing()) {
                IFaceDecoder iFaceDecoder2 = this.M;
                boolean z18 = fVar.f180798h;
                if (z18) {
                    str2 = fVar.f180796f;
                } else {
                    str2 = fVar.f180797g;
                }
                if (z18) {
                    i19 = 1;
                }
                iFaceDecoder2.requestDecodeFace(str2, i19, true, (byte) 1);
            }
        }
        fVar.f180791a.setImageBitmap(bitmapFromCache);
        return sb5.toString();
    }

    private boolean ii(ArrayList<un2.a> arrayList) {
        List<AccountSearchPb$record> list;
        if (this.G || arrayList == null || arrayList.size() != 1 || (list = arrayList.get(0).f439272e) == null || list.size() != 1) {
            return false;
        }
        ai(arrayList.get(0).f439268a, list.get(0), 2);
        return true;
    }

    public static ClassificationSearchFragment ki(int i3) {
        f180722p0 = i3;
        return new ClassificationSearchFragment();
    }

    public static ClassificationSearchFragment li(un2.a aVar) {
        f180720n0 = aVar;
        return new ClassificationSearchFragment();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ni(int i3) {
        this.f180723c0 = i3;
        c cVar = this.f180733m0;
        if (cVar != null) {
            cVar.notifyDataSetChanged();
        }
    }

    @Override // com.tencent.mobileqq.activity.contact.addcontact.SearchBaseFragment
    public void Bh(String str, boolean z16) {
        BaseActivity baseActivity;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, str, Boolean.valueOf(z16));
            return;
        }
        this.G = z16;
        if (z16) {
            if (UniteSearchActivity.f282684b0 == 12) {
                this.V.n(this.D, this.f180728h0, 0.0d, 0.0d, 1);
            } else if (f180722p0 == ClassificationSearchActivity.G0) {
                this.V.n(this.D, this.f180728h0, 0.0d, 0.0d, 2);
            } else {
                this.V.n(this.D, this.f180728h0, 0.0d, 0.0d, 0);
            }
        } else if (NetworkUtil.isNetSupport(BaseApplication.getContext())) {
            showLoadingDialog();
            this.D = str;
            this.V.l();
            if (UniteSearchActivity.f282684b0 == 12) {
                this.V.n(this.D, this.f180728h0, 0.0d, 0.0d, 1);
            } else if (f180722p0 == ClassificationSearchActivity.G0) {
                this.V.n(this.D, this.f180728h0, 0.0d, 0.0d, 2);
            } else {
                this.V.n(this.D, this.f180728h0, 0.0d, 0.0d, 0);
            }
            this.H = true;
        } else {
            QQToast.makeText(BaseApplication.getContext(), R.string.f171139ci4, 0).show(getTitleBarHeight());
            ni(4);
        }
        if (this.E == 2 && (baseActivity = getBaseActivity()) != null && (baseActivity instanceof SearchBaseActivity)) {
            int G2 = ((SearchBaseActivity) baseActivity).G2();
            int j3 = this.V.j() + 1;
            ((IPublicAccountReportUtils) QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(this.S, "P_CliOper", IPublicAccountHandler.MAIN_ACTION, "", "0X8005D21", "0X8005D21", 0, 0, "" + j3, SearchBaseActivity.e.a(G2), this.D, "", false);
        }
    }

    @Override // com.tencent.mobileqq.activity.contact.addcontact.SearchBaseFragment
    protected void Qh() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
        } else if (this.f180723c0 == 2) {
            ni(0);
        }
    }

    @Override // com.tencent.mobileqq.activity.contact.addcontact.SearchBaseFragment
    protected void Th() {
        int i3;
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("isGetMore = ");
            sb5.append(this.G);
            sb5.append(" mListData is null = ");
            if (this.f180727g0 == null) {
                z16 = true;
            } else {
                z16 = false;
            }
            sb5.append(z16);
            QLog.d("ClassificationSearchFragment", 2, sb5.toString());
        }
        if (!this.G && this.f180727g0 == null) {
            Vh();
            return;
        }
        if (this.f180733m0 == null) {
            c cVar = new c();
            this.f180733m0 = cVar;
            cVar.setData(this.f180727g0);
            View view = this.f180725e0;
            StringBuilder sb6 = new StringBuilder();
            if (this.E == 0) {
                i3 = R.string.kmh;
            } else {
                i3 = R.string.kmn;
            }
            sb6.append(HardCodeUtil.qqStr(i3));
            sb6.append(HardCodeUtil.qqStr(R.string.kmj));
            view.setContentDescription(sb6.toString());
            this.K.addHeaderView(this.f180725e0);
            this.K.setAdapter((ListAdapter) this.f180733m0);
            this.I = this.f180733m0;
        }
        if (this.J.getChildAt(0) != this.K) {
            this.J.removeAllViews();
            this.J.addView(this.K);
        }
        if (this.G) {
            this.f180733m0.a().addAll(this.f180727g0);
        } else {
            this.f180733m0.setData(this.f180727g0);
        }
        this.f180733m0.notifyDataSetChanged();
        if (this.H) {
            this.H = false;
            this.K.setSelection(0);
        }
        if (this.E == 2 && this.f180727g0 != null) {
            StringBuilder sb7 = new StringBuilder();
            Iterator<AccountSearchPb$record> it = this.f180727g0.iterator();
            int i16 = 0;
            while (it.hasNext()) {
                sb7.append(String.valueOf(it.next().uin.get()));
                sb7.append("#");
                i16++;
            }
            ((IPublicAccountDetailReportUtil) QRoute.api(IPublicAccountDetailReportUtil.class)).setAttrSearchPage(((IPublicAccountDetailReportUtil) QRoute.api(IPublicAccountDetailReportUtil.class)).buildSearchID(this.S.getCurrentAccountUin(), this.D), this.D, 3, true, i16, sb7.toString());
        }
    }

    @Override // com.tencent.mobileqq.activity.contact.addcontact.SearchBaseFragment
    protected void Xh(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) str);
        } else {
            super.Xh(str);
            ni(3);
        }
    }

    void hi() {
        if (this.f180723c0 == 1) {
            ni(2);
            Bh(this.D, true);
        }
    }

    public boolean ji() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Boolean) iPatchRedirector.redirect((short) 14, (Object) this)).booleanValue();
        }
        return this.f180729i0;
    }

    public void mi(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, i3);
        } else {
            this.f180730j0 = i3;
        }
    }

    public void oi(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, z16);
        } else {
            this.f180729i0 = z16;
        }
    }

    @Override // com.tencent.mobileqq.activity.contact.addcontact.SearchBaseFragment, android.view.View.OnClickListener
    public void onClick(View view) {
        String str;
        String str2;
        String str3;
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) view);
        } else {
            Object tag = view.getTag();
            if (tag != null) {
                String str4 = "";
                if (tag instanceof SearchBaseFragment.f) {
                    SearchBaseFragment.f fVar = (SearchBaseFragment.f) tag;
                    ai(fVar.f180800j, fVar.f180801k, 2);
                    int i3 = fVar.f180803m;
                    int i16 = fVar.f180800j;
                    if (fVar.f180801k.uin != null) {
                        str = fVar.f180801k.uin.get() + "";
                    } else {
                        str = null;
                    }
                    SearchUtils.a1(i16, 0, i3, false, str, this.D, UniteSearchActivity.f282684b0);
                    if (fVar.f180800j == 80000002) {
                        AccountSearchPb$record accountSearchPb$record = fVar.f180801k;
                        BaseActivity baseActivity = getBaseActivity();
                        if (baseActivity != null && (baseActivity instanceof ClassificationSearchActivity)) {
                            String a16 = SearchBaseActivity.e.a(((SearchBaseActivity) baseActivity).G2());
                            Object tag2 = view.getTag(R.id.emf);
                            if (tag2 != null && (tag2 instanceof Integer)) {
                                fVar.f180803m = ((Integer) tag2).intValue() + 1;
                            }
                            IPublicAccountDetailReportUtil iPublicAccountDetailReportUtil = (IPublicAccountDetailReportUtil) QRoute.api(IPublicAccountDetailReportUtil.class);
                            if (accountSearchPb$record.uin == null) {
                                str2 = "";
                            } else {
                                str2 = accountSearchPb$record.uin.get() + "";
                            }
                            iPublicAccountDetailReportUtil.setAttrSearchClick(3, str2, i3, UniteSearchActivity.f282684b0);
                            if (UniteSearchActivity.f282684b0 == 12) {
                                QQAppInterface qQAppInterface = this.S;
                                String str5 = fVar.f180803m + "";
                                if (accountSearchPb$record.uin != null) {
                                    str4 = accountSearchPb$record.uin.get() + "";
                                }
                                ReportController.n(qQAppInterface, "CliOper", "", "", "0X800658B", "0X800658B", 0, 1, 0, str5, a16, str4, this.D);
                            } else {
                                IPublicAccountReportUtils iPublicAccountReportUtils = (IPublicAccountReportUtils) QRoute.api(IPublicAccountReportUtils.class);
                                QQAppInterface qQAppInterface2 = this.S;
                                if (accountSearchPb$record.uin == null) {
                                    str3 = "";
                                } else {
                                    str3 = accountSearchPb$record.uin.get() + "";
                                }
                                iPublicAccountReportUtils.publicAccountReportClickEventForMigrate(qQAppInterface2, "P_CliOper", IPublicAccountHandler.MAIN_ACTION, str3, "0X8005D22", "0X8005D22", 0, 0, fVar.f180803m + "", a16, this.D, "", false);
                            }
                        }
                    }
                } else if (tag instanceof b) {
                    int i17 = this.f180723c0;
                    if (i17 == 3 || i17 == 4) {
                        if (NetworkUtil.isNetSupport(BaseApplication.getContext())) {
                            ni(1);
                        } else {
                            QQToast.makeText(BaseApplication.getContext(), R.string.f171139ci4, 0).show(getTitleBarHeight());
                            ni(4);
                        }
                    }
                } else if (tag instanceof SearchBaseFragment.e) {
                    SearchBaseFragment.e eVar = (SearchBaseFragment.e) tag;
                    Intent intent = new Intent(this.U, (Class<?>) QQBrowserActivity.class);
                    intent.putExtra("url", eVar.f180786f);
                    int i18 = UniteSearchActivity.f282684b0;
                    if (i18 == 1) {
                        intent.putExtra("articalChannelId", 10);
                    } else if (i18 == 2) {
                        intent.putExtra("articalChannelId", 11);
                    } else {
                        int i19 = this.f180730j0;
                        if (i19 == 14) {
                            intent.putExtra("articalChannelId", 14);
                        } else if (i19 == 13) {
                            intent.putExtra("articalChannelId", 12);
                        } else if (i19 == 15) {
                            intent.putExtra("articalChannelId", 13);
                        }
                    }
                    this.U.startActivity(intent);
                    if (UniteSearchActivity.f282684b0 == 12) {
                        ReportController.o(this.S, "CliOper", "", "", "0X800658C", "0X800658C", 0, 0, "" + eVar.f180787g, "", this.D, "" + eVar.f180788h);
                    } else {
                        ((IPublicAccountReportUtils) QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(this.S, "P_CliOper", IPublicAccountHandler.MAIN_ACTION, "0", "0X8005D97", "0X8005D97", 0, 0, "" + eVar.f180787g, "", this.D, "" + eVar.f180788h, false);
                    }
                }
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.activity.contact.addcontact.SearchBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View onCreateView;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            onCreateView = (View) iPatchRedirector.redirect((short) 4, this, layoutInflater, viewGroup, bundle);
        } else {
            onCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
            if (this.f180725e0 == null) {
                View inflate = Gh().getLayoutInflater().inflate(R.layout.f168017p3, (ViewGroup) this.K, false);
                this.f180725e0 = inflate;
                inflate.setClickable(false);
                this.f180725e0.setFocusable(true);
            }
        }
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, onCreateView);
        return onCreateView;
    }

    @Override // com.tencent.mobileqq.activity.contact.addcontact.SearchBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        super.onDestroy();
        a aVar = this.f180731k0;
        if (aVar != null) {
            aVar.e();
        }
        ((IPublicAccountDetailReportUtil) QRoute.api(IPublicAccountDetailReportUtil.class)).backPage();
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else {
            super.onPause();
            ApngImage.pauseByTag(36);
        }
    }

    @Override // com.tencent.mobileqq.activity.contact.addcontact.SearchBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            super.onResume();
            ApngImage.playByTag(36);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) view, (Object) bundle);
            return;
        }
        super.onViewCreated(view, bundle);
        un2.a aVar = f180720n0;
        if (aVar != null) {
            ni(!aVar.f439270c ? 1 : 0);
            this.f180727g0.addAll(f180720n0.f439272e);
            this.V.o(f180720n0.f439269b);
            if (ViewFactory.g(f180720n0.f439268a) == R.string.f170119h0) {
                ((TextView) this.f180725e0.findViewById(R.id.title)).setText(((IPublicAccountConfigUtil) QRoute.api(IPublicAccountConfigUtil.class)).getSubscriptName(this.S, BaseApplication.getContext()));
            } else {
                ((TextView) this.f180725e0.findViewById(R.id.title)).setText(ViewFactory.g(f180720n0.f439268a));
            }
            if (this.R.size() == 0 && this.f180727g0.size() > 0) {
                ArrayList<un2.a> arrayList = new ArrayList<>();
                arrayList.add(f180720n0);
                sh(arrayList);
            }
            f180720n0 = null;
            Th();
        } else {
            if (f180722p0 != ClassificationSearchActivity.G0 && f180722p0 != ClassificationSearchActivity.H0) {
                if (f180722p0 == ClassificationSearchActivity.I0 || f180722p0 == ClassificationSearchActivity.K0) {
                    ((TextView) this.f180725e0.findViewById(R.id.title)).setText(ViewFactory.g(80000002));
                }
            } else {
                ((TextView) this.f180725e0.findViewById(R.id.title)).setText(ViewFactory.g(80000003));
            }
            if (QLog.isColorLevel()) {
                QLog.d("ClassificationSearchFragment", 2, "searchResult is null");
            }
            Vh();
        }
        this.f180728h0 = Mh();
        if (this.E == 2 && this.f180731k0 == null) {
            this.f180731k0 = new a();
        }
    }

    @Override // com.tencent.mobileqq.activity.contact.addcontact.SearchBaseFragment
    protected boolean th(ArrayList<un2.a> arrayList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) arrayList)).booleanValue();
        }
        un2.a aVar = arrayList.get(0);
        if (ii(arrayList)) {
            this.f180729i0 = true;
            return false;
        }
        Handler handler = this.X;
        if (handler != null) {
            handler.post(new Runnable(aVar) { // from class: com.tencent.mobileqq.activity.contact.addcontact.ClassificationSearchFragment.1
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ un2.a f180734d;

                {
                    this.f180734d = aVar;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ClassificationSearchFragment.this, (Object) aVar);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    un2.a aVar2 = this.f180734d;
                    if (aVar2 != null) {
                        ClassificationSearchFragment.this.ni(!aVar2.f439270c ? 1 : 0);
                    }
                }
            });
        }
        if (QLog.isColorLevel()) {
            QLog.d("ClassificationSearchFragment", 2, "is no more page  = " + aVar.f439270c);
        }
        this.f180727g0 = aVar.f439272e;
        if (!this.G) {
            xh();
        }
        sh(arrayList);
        return true;
    }

    @Override // com.tencent.mobileqq.activity.contact.addcontact.SearchBaseFragment
    @TargetApi(9)
    public void wh() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this);
            return;
        }
        super.wh();
        if (this.J != null && this.E == 2) {
            if (this.f180726f0 == null) {
                View inflate = LayoutInflater.from(getBaseActivity()).inflate(R.layout.f168428vx, (ViewGroup) null);
                this.f180726f0 = inflate;
                GridView gridView = (GridView) inflate.findViewById(R.id.ijq);
                gridView.setOverScrollMode(2);
                gridView.setNumColumns(4);
                gridView.setStretchMode(2);
                gridView.setVerticalSpacing(BaseAIOUtils.f(20.0f, getResources()));
                gridView.setAdapter((ListAdapter) this.f180731k0);
            }
            this.J.addView(this.f180726f0);
            this.J.setClickable(false);
            a aVar = this.f180731k0;
            if (aVar != null && aVar.getCount() > 0) {
                this.f180726f0.setVisibility(0);
                String d16 = this.f180731k0.d();
                if (TextUtils.isEmpty(d16)) {
                    ((TextView) this.f180726f0.findViewById(R.id.iju)).setText(getString(R.string.d75));
                } else {
                    ((TextView) this.f180726f0.findViewById(R.id.iju)).setText(d16);
                }
            } else {
                this.f180726f0.setVisibility(8);
            }
            a aVar2 = this.f180731k0;
            if (aVar2 != null && aVar2.c() != null && !this.f180731k0.f180736e) {
                this.f180731k0.f(false);
            }
        }
    }
}
