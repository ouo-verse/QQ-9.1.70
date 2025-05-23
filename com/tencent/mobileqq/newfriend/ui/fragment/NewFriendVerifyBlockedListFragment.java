package com.tencent.mobileqq.newfriend.ui.fragment;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Message;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.addfriend.api.IAddFriendApi;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.avatar.api.IQQAvatarService;
import com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener;
import com.tencent.mobileqq.fragment.QIphoneTitleBarFragment;
import com.tencent.mobileqq.newfriend.api.INewFriendApi;
import com.tencent.mobileqq.newfriend.api.INewFriendVerificationService;
import com.tencent.mobileqq.newfriend.api.impl.NewFriendVerificationServiceImpl;
import com.tencent.mobileqq.newfriend.data.AddFriendBlockedInfo;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.utils.ProfileUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.relation.api.IAddFriendTempApi;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView;
import com.tencent.widget.ListView;
import com.tencent.widget.ThemeImageView;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import mqq.os.MqqHandler;

/* compiled from: P */
/* loaded from: classes15.dex */
public class NewFriendVerifyBlockedListFragment extends QIphoneTitleBarFragment implements DecodeTaskCompletionListener {
    static IPatchRedirector $redirector_;
    private ListView C;
    private TextView D;
    private View E;
    private QBaseActivity F;
    private f G;
    private List<AddFriendBlockedInfo> H;
    private IFaceDecoder I;
    MqqHandler J;
    private com.tencent.mobileqq.newfriend.observer.d K;
    private AbsListView.OnScrollListener L;

    /* compiled from: P */
    /* loaded from: classes15.dex */
    class a extends MqqHandler {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) NewFriendVerifyBlockedListFragment.this);
            }
        }

        @Override // mqq.os.MqqHandler
        public void handleMessage(Message message) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) message);
            } else if (message.what == 1) {
                NewFriendVerifyBlockedListFragment.this.wh();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    class b extends com.tencent.mobileqq.newfriend.observer.d {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) NewFriendVerifyBlockedListFragment.this);
            }
        }

        @Override // com.tencent.mobileqq.newfriend.observer.d
        public void a(boolean z16, Object obj) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, Boolean.valueOf(z16), obj);
            } else if (z16) {
                NewFriendVerifyBlockedListFragment.this.J.removeMessages(1);
                NewFriendVerifyBlockedListFragment.this.J.sendEmptyMessage(1);
            }
        }

        @Override // com.tencent.mobileqq.newfriend.observer.d
        public void b(boolean z16, List<AddFriendBlockedInfo> list, String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), list, str);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.i("BlockedListFragment", 2, "onGetAddFriendBlockedList, success=" + z16);
            }
            if (z16 && NewFriendVerifyBlockedListFragment.this.F != null && !NewFriendVerifyBlockedListFragment.this.F.isFinishing() && NewFriendVerifyBlockedListFragment.this.C != null && NewFriendVerifyBlockedListFragment.this.G != null) {
                NewFriendVerifyBlockedListFragment.this.J.removeMessages(1);
                NewFriendVerifyBlockedListFragment.this.J.sendEmptyMessage(1);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    class c implements AbsListView.OnScrollListener {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) NewFriendVerifyBlockedListFragment.this);
            }
        }

        @Override // com.tencent.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i3, int i16, int i17) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, absListView, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
            }
        }

        @Override // com.tencent.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) absListView, i3);
                return;
            }
            if (NewFriendVerifyBlockedListFragment.this.G != null) {
                if (i3 != 0 && i3 != 1) {
                    NewFriendVerifyBlockedListFragment.this.G.f();
                } else {
                    NewFriendVerifyBlockedListFragment.this.G.g();
                    NewFriendVerifyBlockedListFragment.this.G.h();
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    class d implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) NewFriendVerifyBlockedListFragment.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                NewFriendVerificationServiceImpl.getService(NewFriendVerifyBlockedListFragment.this.F.getAppRuntime()).clearAddFriendBlockedList(NewFriendVerifyBlockedListFragment.this.F.getAppRuntime().getCurrentAccountUin());
                ReportController.o(null, "dc00898", "", "", "0X800A3A9", "0X800A3A9", 0, 0, "", "", "", "");
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public class e extends ClickableSpan {
        static IPatchRedirector $redirector_;

        e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) NewFriendVerifyBlockedListFragment.this);
            }
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                ((IAddFriendTempApi) QRoute.api(IAddFriendTempApi.class)).gotoFriendSettingBrowser(NewFriendVerifyBlockedListFragment.this.F);
                ReportController.o(null, "dc00898", "", "", "0X800A3AA", "0X800A3AA", 0, 0, "", "", "", "");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public class f extends BaseAdapter implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        /* compiled from: P */
        /* loaded from: classes15.dex */
        public class a {
            static IPatchRedirector $redirector_;

            /* renamed from: a, reason: collision with root package name */
            public AddFriendBlockedInfo f254157a;

            /* renamed from: b, reason: collision with root package name */
            public View f254158b;

            /* renamed from: c, reason: collision with root package name */
            public ImageView f254159c;

            /* renamed from: d, reason: collision with root package name */
            public TextView f254160d;

            /* renamed from: e, reason: collision with root package name */
            public TextView f254161e;

            /* renamed from: f, reason: collision with root package name */
            public TextView f254162f;

            /* renamed from: g, reason: collision with root package name */
            public Button f254163g;

            /* renamed from: h, reason: collision with root package name */
            public TextView f254164h;

            public a() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) f.this);
                }
            }
        }

        f() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) NewFriendVerifyBlockedListFragment.this);
        }

        private void a(View view) {
            if (view instanceof ThemeImageView) {
                ((ThemeImageView) view).setSupportMaskView(true);
            }
        }

        private void b(a aVar) {
            if (QQTheme.isNowThemeIsNight()) {
                com.tencent.mobileqq.newfriend.utils.a.e(null, aVar.f254161e, aVar.f254162f);
            }
        }

        private void c(a aVar, View.OnClickListener onClickListener) {
            AddFriendBlockedInfo addFriendBlockedInfo = aVar.f254157a;
            if (addFriendBlockedInfo == null) {
                return;
            }
            if (TextUtils.isEmpty(addFriendBlockedInfo.f254009e)) {
                aVar.f254160d.setText(aVar.f254157a.f254008d);
            } else {
                aVar.f254160d.setText(aVar.f254157a.f254009e);
            }
            d(aVar, aVar.f254157a.f254008d);
            aVar.f254159c.setTag(aVar);
            INewFriendApi iNewFriendApi = (INewFriendApi) QRoute.api(INewFriendApi.class);
            TextView textView = aVar.f254164h;
            AddFriendBlockedInfo addFriendBlockedInfo2 = aVar.f254157a;
            iNewFriendApi.showGenderAge(textView, addFriendBlockedInfo2.f254011h, addFriendBlockedInfo2.f254010f, null);
            String str = aVar.f254157a.f254012i;
            if (!TextUtils.isEmpty(str)) {
                aVar.f254162f.setText(String.format(Locale.getDefault(), HardCodeUtil.qqStr(R.string.op6), str));
                aVar.f254162f.setVisibility(0);
            } else {
                aVar.f254162f.setVisibility(8);
            }
            int i3 = aVar.f254157a.D;
            if (i3 > 0) {
                String format = String.format(Locale.getDefault(), "%d\u4f4d\u5171\u540c\u597d\u53cb", Integer.valueOf(i3));
                aVar.f254161e.setVisibility(0);
                aVar.f254161e.setText(format);
            } else {
                aVar.f254161e.setVisibility(8);
            }
            aVar.f254163g.setTag(aVar);
            aVar.f254163g.setOnClickListener(this);
        }

        private void i(View view, boolean z16) {
            if (view == null) {
                return;
            }
            if (z16) {
                view.setBackgroundResource(R.drawable.f160542jo);
            } else {
                view.setBackgroundResource(R.drawable.qui_common_fill_light_primary_bg_selector);
            }
        }

        public void d(a aVar, String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                iPatchRedirector.redirect((short) 9, (Object) this, (Object) aVar, (Object) str);
                return;
            }
            if (aVar != null && aVar.f254159c != null && !TextUtils.isEmpty(str)) {
                Bitmap bitmapFromCache = NewFriendVerifyBlockedListFragment.this.I.getBitmapFromCache(1, str);
                if (bitmapFromCache == null && !NewFriendVerifyBlockedListFragment.this.I.isPausing()) {
                    NewFriendVerifyBlockedListFragment.this.I.requestDecodeFace(str, 1, true);
                }
                if (bitmapFromCache == null) {
                    bitmapFromCache = BaseImageUtil.getDefaultFaceBitmap();
                }
                aVar.f254159c.setImageBitmap(bitmapFromCache);
            }
        }

        @Override // android.widget.Adapter
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public AddFriendBlockedInfo getItem(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (AddFriendBlockedInfo) iPatchRedirector.redirect((short) 3, (Object) this, i3);
            }
            return (AddFriendBlockedInfo) NewFriendVerifyBlockedListFragment.this.H.get(i3);
        }

        public void f() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this);
            } else {
                NewFriendVerifyBlockedListFragment.this.I.cancelPendingRequests();
                NewFriendVerifyBlockedListFragment.this.I.pause();
            }
        }

        public void g() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this);
            } else if (NewFriendVerifyBlockedListFragment.this.I.isPausing()) {
                NewFriendVerifyBlockedListFragment.this.I.resume();
            }
        }

        @Override // android.widget.Adapter
        public int getCount() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
            }
            if (NewFriendVerifyBlockedListFragment.this.H == null) {
                return 0;
            }
            return NewFriendVerifyBlockedListFragment.this.H.size();
        }

        @Override // android.widget.Adapter
        public long getItemId(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Long) iPatchRedirector.redirect((short) 4, (Object) this, i3)).longValue();
            }
            return i3;
        }

        @Override // android.widget.Adapter
        public View getView(int i3, View view, ViewGroup viewGroup) {
            View view2;
            a aVar;
            View view3;
            View view4;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                view3 = (View) iPatchRedirector.redirect((short) 7, this, Integer.valueOf(i3), view, viewGroup);
                view4 = view;
            } else {
                if (view == null) {
                    aVar = new a();
                    view2 = LayoutInflater.from(NewFriendVerifyBlockedListFragment.this.F).inflate(R.layout.f168926hc4, (ViewGroup) null);
                    aVar.f254159c = (ImageView) view2.findViewById(R.id.f163821d);
                    aVar.f254160d = (TextView) view2.findViewById(R.id.nickname);
                    aVar.f254161e = (TextView) view2.findViewById(R.id.i95);
                    aVar.f254164h = (TextView) view2.findViewById(R.id.f164064iz);
                    aVar.f254162f = (TextView) view2.findViewById(R.id.iz7);
                    aVar.f254163g = (Button) view2.findViewById(R.id.i8s);
                    aVar.f254158b = view2;
                    view2.setOnClickListener(this);
                    a(aVar.f254159c);
                    view2.setTag(aVar);
                } else {
                    view2 = view;
                    aVar = (a) view.getTag();
                }
                AddFriendBlockedInfo item = getItem(i3);
                aVar.f254157a = item;
                if (!item.C) {
                    i(aVar.f254158b, true);
                } else {
                    i(aVar.f254158b, false);
                }
                c(aVar, this);
                com.tencent.mobileqq.newfriend.utils.a.c(aVar.f254163g);
                TextView textView = aVar.f254164h;
                AddFriendBlockedInfo addFriendBlockedInfo = aVar.f254157a;
                com.tencent.mobileqq.newfriend.utils.a.g(textView, addFriendBlockedInfo.f254011h, addFriendBlockedInfo.f254010f, null);
                com.tencent.mobileqq.newfriend.utils.a.e(null, aVar.f254161e, aVar.f254162f);
                b(aVar);
                view3 = view2;
                view4 = view3;
            }
            EventCollector.getInstance().onListGetView(i3, view4, viewGroup, getItemId(i3));
            return view3;
        }

        public void h() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                iPatchRedirector.redirect((short) 10, (Object) this);
                return;
            }
            int childCount = NewFriendVerifyBlockedListFragment.this.C.getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                Object tag = NewFriendVerifyBlockedListFragment.this.C.getChildAt(i3).getTag();
                if (tag instanceof a) {
                    a aVar = (a) tag;
                    d(aVar, aVar.f254157a.f254008d);
                }
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String str;
            AddFriendBlockedInfo addFriendBlockedInfo;
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                iPatchRedirector.redirect((short) 8, (Object) this, (Object) view);
            } else {
                int id5 = view.getId();
                if (id5 == R.id.ibi) {
                    Object tag = view.getTag();
                    if ((tag instanceof a) && (addFriendBlockedInfo = ((a) tag).f254157a) != null) {
                        if (QLog.isColorLevel()) {
                            QLog.d("BlockedListFragment", 2, "onClick rlSystemMsg\uff0c friendtype=109");
                        }
                        AllInOne allInOne = new AllInOne(addFriendBlockedInfo.f254008d, 109);
                        if (!TextUtils.isEmpty(addFriendBlockedInfo.f254009e)) {
                            allInOne.nickname = addFriendBlockedInfo.f254009e;
                        } else {
                            allInOne.nickname = addFriendBlockedInfo.f254008d;
                        }
                        allInOne.profileEntryType = 120;
                        ProfileUtils.openProfileCardForResult(NewFriendVerifyBlockedListFragment.this.F, allInOne, 100);
                        ReportController.o(null, "dc00898", "", "", "0X800A3A8", "0X800A3A8", 0, 0, "", "", "", "");
                    }
                } else if (id5 == R.id.i8s) {
                    Object tag2 = view.getTag();
                    if (tag2 instanceof a) {
                        if (!NetworkUtil.isNetworkAvailable(NewFriendVerifyBlockedListFragment.this.F)) {
                            QQToast.makeText(NewFriendVerifyBlockedListFragment.this.F, NewFriendVerifyBlockedListFragment.this.F.getResources().getString(R.string.b3j), 0).show(NewFriendVerifyBlockedListFragment.this.F.getTitleBarHeight());
                        } else {
                            AddFriendBlockedInfo addFriendBlockedInfo2 = ((a) tag2).f254157a;
                            if (!TextUtils.isEmpty(addFriendBlockedInfo2.f254009e)) {
                                str = addFriendBlockedInfo2.f254009e;
                            } else {
                                str = addFriendBlockedInfo2.f254008d;
                            }
                            ((IAddFriendApi) QRoute.api(IAddFriendApi.class)).launchAddFriendForResult(NewFriendVerifyBlockedListFragment.this.F, ((IAddFriendApi) QRoute.api(IAddFriendApi.class)).startAddFriend(NewFriendVerifyBlockedListFragment.this.F, 1, addFriendBlockedInfo2.f254008d, null, 3041, 15, str, null, null, NewFriendVerifyBlockedListFragment.this.F.getString(R.string.f170028dd), null), 100);
                            ReportController.o(null, "dc00898", "", "", "0X800A3A7", "0X800A3A7", 0, 0, "", "", "", "");
                        }
                    }
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }

        /* synthetic */ f(NewFriendVerifyBlockedListFragment newFriendVerifyBlockedListFragment, a aVar) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 11)) {
                return;
            }
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) newFriendVerifyBlockedListFragment, (Object) aVar);
        }
    }

    public NewFriendVerifyBlockedListFragment() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.H = new ArrayList();
        this.J = new a();
        this.K = new b();
        this.L = new c();
    }

    private void vh() {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append((CharSequence) getString(R.string.iys));
        spannableStringBuilder.setSpan(new e(), 27, 31, 33);
        this.D.setText(spannableStringBuilder);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#4D94FF")), 27, 31, 33);
        this.D.setMovementMethod(LinkMovementMethod.getInstance());
        this.D.setText(spannableStringBuilder);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wh() {
        if (this.G != null) {
            this.H.clear();
            QBaseActivity qBaseActivity = this.F;
            if (qBaseActivity == null) {
                if (QLog.isColorLevel()) {
                    QLog.d("BlockedListFragment", 2, "refreshData null == mActivity ");
                    return;
                }
                return;
            }
            this.H.addAll(NewFriendVerificationServiceImpl.getService(qBaseActivity.getAppRuntime()).addFriendBlockedInfoList);
            this.G.notifyDataSetChanged();
            if (this.H.isEmpty()) {
                this.D.setVisibility(8);
                this.E.setVisibility(0);
            } else {
                this.D.setVisibility(0);
                this.E.setVisibility(8);
            }
        }
    }

    public static void xh(Activity activity) {
        QPublicFragmentActivity.start(activity, new Intent(), NewFriendVerifyBlockedListFragment.class);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment
    public void doOnCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, layoutInflater, viewGroup, bundle);
            return;
        }
        super.doOnCreateView(layoutInflater, viewGroup, bundle);
        setTitle(this.F.getString(R.string.f201254ub));
        this.E = ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.bww);
        ListView listView = (ListView) ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.ldz);
        this.C = listView;
        listView.setNeedCheckSpringback(true);
        this.C.setOverscrollHeader(null);
        this.C.setOnScrollListener(this.L);
        this.D = (TextView) ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.lpu);
        f fVar = new f(this, null);
        this.G = fVar;
        this.C.setAdapter((ListAdapter) fVar);
        vh();
        setRightButton(R.string.a3k, new d());
        ((INewFriendVerificationService) this.F.getAppRuntime().getRuntimeService(INewFriendVerificationService.class, "")).getAddFriendBlockedList(this.F.getAppRuntime().getCurrentAccountUin());
        wh();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return R.layout.hc5;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityResult(int i3, int i16, Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, Integer.valueOf(i3), Integer.valueOf(i16), intent);
            return;
        }
        if (i3 == 100) {
            this.J.removeMessages(1);
            this.J.sendEmptyMessage(1);
        }
        super.onActivityResult(i3, i16, intent);
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) activity);
        } else {
            super.onAttach(activity);
            this.F = getQBaseActivity();
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) bundle);
            return;
        }
        super.onCreate(bundle);
        QBaseActivity qBaseActivity = getQBaseActivity();
        this.F = qBaseActivity;
        if (qBaseActivity.getAppRuntime() instanceof AppInterface) {
            ((AppInterface) this.F.getAppRuntime()).addObserver(this.K);
            IFaceDecoder iQQAvatarService = ((IQQAvatarService) this.F.getAppRuntime().getRuntimeService(IQQAvatarService.class, "")).getInstance((AppInterface) this.F.getAppRuntime());
            this.I = iQQAvatarService;
            iQQAvatarService.setDecodeTaskCompletionListener(this);
        }
    }

    @Override // com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener
    public void onDecodeTaskCompleted(int i3, int i16, String str, Bitmap bitmap) {
        f.a aVar;
        AddFriendBlockedInfo addFriendBlockedInfo;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Integer.valueOf(i16), str, bitmap);
            return;
        }
        if (bitmap != null && !TextUtils.isEmpty(str)) {
            int childCount = this.C.getChildCount();
            for (int i17 = 0; i17 < childCount; i17++) {
                Object tag = this.C.getChildAt(i17).getTag();
                if (tag != null && (tag instanceof f.a) && (addFriendBlockedInfo = (aVar = (f.a) tag).f254157a) != null && str.equals(addFriendBlockedInfo.f254008d)) {
                    aVar.f254159c.setImageBitmap(bitmap);
                }
            }
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        super.onDestroy();
        if (this.F.getAppRuntime() instanceof AppInterface) {
            ((AppInterface) this.F.getAppRuntime()).removeObserver(this.K);
            this.I.setDecodeTaskCompletionListener(null);
            this.I.destory();
        }
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onDetach() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
        } else {
            super.onDetach();
            this.F = null;
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        super.onResume();
        f fVar = this.G;
        if (fVar != null) {
            fVar.g();
        }
        ReportController.o(null, "dc00898", "", "", "0X800A3A6", "0X800A3A6", 0, 0, "", "", "", "");
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onStop() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        super.onStop();
        f fVar = this.G;
        if (fVar != null) {
            fVar.f();
        }
        NewFriendVerificationServiceImpl.getService(this.F.getAppRuntime()).setBlockInfoHasRead();
    }
}
