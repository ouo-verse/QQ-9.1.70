package com.tencent.mobileqq.activity.contact.addcontact.recommend;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.adapter.RecommendFriendAdapter;
import com.tencent.mobileqq.addfriend.api.IAddFriendServiceApi;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.MayknowRecommendManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.MayKnowRecommend;
import com.tencent.mobileqq.pymk.api.IQQRecommendFriendApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.util.ab;
import com.tencent.mobileqq.widget.navbar.NavBarCommon;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.ntrelation.friendsinfo.api.IFriendsInfoService;
import com.tencent.widget.SwipListView;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes10.dex */
public class RecommendFriendActivity extends BaseActivity {
    static IPatchRedirector $redirector_;

    /* renamed from: a0, reason: collision with root package name */
    private XListView f181209a0;

    /* renamed from: b0, reason: collision with root package name */
    private LinearLayout f181210b0;

    /* renamed from: c0, reason: collision with root package name */
    private NavBarCommon f181211c0;

    /* renamed from: d0, reason: collision with root package name */
    private TextView f181212d0;

    /* renamed from: e0, reason: collision with root package name */
    private RecommendFriendAdapter f181213e0;

    /* renamed from: f0, reason: collision with root package name */
    private MayknowRecommendManager f181214f0;

    /* renamed from: g0, reason: collision with root package name */
    private String f181215g0;

    /* renamed from: h0, reason: collision with root package name */
    private String f181216h0;

    /* renamed from: i0, reason: collision with root package name */
    private String f181217i0;

    /* renamed from: j0, reason: collision with root package name */
    private boolean f181218j0;

    /* renamed from: k0, reason: collision with root package name */
    ArrayList<MayKnowRecommend> f181219k0;

    /* renamed from: l0, reason: collision with root package name */
    private final com.tencent.mobileqq.pymk.c f181220l0;

    /* renamed from: m0, reason: collision with root package name */
    RecommendFriendAdapter.g f181221m0;

    /* renamed from: n0, reason: collision with root package name */
    com.tencent.mobileqq.pymk.api.a f181222n0;

    /* renamed from: o0, reason: collision with root package name */
    private TopGestureLayout f181223o0;

    /* renamed from: p0, reason: collision with root package name */
    SwipListView.RightIconMenuListener f181224p0;

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class a implements RecommendFriendAdapter.h {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) RecommendFriendActivity.this);
            }
        }

        @Override // com.tencent.mobileqq.adapter.RecommendFriendAdapter.h
        public void a(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                RecommendFriendActivity.this.K2(str);
            } else {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
            }
        }

        @Override // com.tencent.mobileqq.adapter.RecommendFriendAdapter.h
        public void b(List<MayKnowRecommend> list) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) list);
                return;
            }
            Intent intent = RecommendFriendActivity.this.getIntent();
            RecommendFriendActivity.this.M2(intent, intent.getIntExtra("EntranceId", 0), list);
        }

        @Override // com.tencent.mobileqq.adapter.RecommendFriendAdapter.g
        public void c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this);
            } else {
                RecommendFriendActivity.this.f181212d0.setVisibility(8);
            }
        }

        @Override // com.tencent.mobileqq.adapter.RecommendFriendAdapter.g
        public void d(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, i3);
            }
        }

        @Override // com.tencent.mobileqq.adapter.RecommendFriendAdapter.g
        public void e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this);
            } else {
                RecommendFriendActivity.this.f181212d0.setVisibility(0);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class b extends com.tencent.mobileqq.pymk.api.d {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) RecommendFriendActivity.this);
            }
        }

        @Override // com.tencent.mobileqq.pymk.api.d, com.tencent.mobileqq.pymk.api.a
        public void c(@NonNull String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                RecommendFriendActivity.this.K2(str);
            } else {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
            }
        }

        @Override // com.tencent.mobileqq.pymk.api.d, com.tencent.mobileqq.pymk.api.a
        public void d(@NonNull List<? extends MayKnowRecommend> list, boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, list, Boolean.valueOf(z16));
                return;
            }
            Intent intent = RecommendFriendActivity.this.getIntent();
            int intExtra = intent.getIntExtra("EntranceId", 0);
            ArrayList arrayList = new ArrayList(list);
            if (!arrayList.isEmpty()) {
                RecommendFriendActivity.this.M2(intent, intExtra, arrayList);
                if (RecommendFriendActivity.this.f181213e0 != null) {
                    RecommendFriendActivity.this.f181213e0.Q(arrayList, Boolean.valueOf(z16));
                }
                RecommendFriendActivity.this.f181212d0.setVisibility(8);
                return;
            }
            QLog.i("qqBaseActivity", 1, "onDataChange error, because dataList is Empty");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class c implements com.tencent.mobileqq.widget.navbar.a {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) RecommendFriendActivity.this);
            }
        }

        @Override // com.tencent.mobileqq.widget.navbar.a
        public void onItemSelect(View view, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view, i3);
            } else if (i3 == 1) {
                RecommendFriendActivity.this.finish();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class d implements SwipListView.RightIconMenuListener {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) RecommendFriendActivity.this);
            }
        }

        @Override // com.tencent.widget.SwipListView.RightIconMenuListener
        public void onRightIconMenuHide(View view) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                RecommendFriendActivity.this.L2(true);
            } else {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) view);
            }
        }

        @Override // com.tencent.widget.SwipListView.RightIconMenuListener
        public void onRightIconMenuShow(View view) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                RecommendFriendActivity.this.L2(false);
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            }
        }
    }

    public RecommendFriendActivity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f181215g0 = "";
        this.f181216h0 = "";
        this.f181217i0 = "0";
        this.f181219k0 = new ArrayList<>();
        this.f181220l0 = new com.tencent.mobileqq.pymk.c();
        this.f181221m0 = new a();
        this.f181222n0 = new b();
        this.f181224p0 = new d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K2(String str) {
        ArrayList arrayList;
        int intExtra = getIntent().getIntExtra("EntranceId", 0);
        if ((intExtra == 9 || intExtra == 8) && (arrayList = (ArrayList) this.f181219k0.clone()) != null && arrayList.size() > 0) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                MayKnowRecommend mayKnowRecommend = (MayKnowRecommend) it.next();
                if (str.equals(mayKnowRecommend.uin)) {
                    this.f181219k0.remove(mayKnowRecommend);
                    return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L2(boolean z16) {
        if (this.f181223o0 == null) {
            ViewGroup viewGroup = (ViewGroup) getWindow().getDecorView();
            View childAt = viewGroup.getChildAt(0);
            if (childAt != null && (childAt instanceof DragFrameLayout)) {
                viewGroup = (ViewGroup) childAt;
            }
            View childAt2 = viewGroup.getChildAt(0);
            if (childAt2 instanceof TopGestureLayout) {
                this.f181223o0 = (TopGestureLayout) childAt2;
            }
        }
        TopGestureLayout topGestureLayout = this.f181223o0;
        if (topGestureLayout != null) {
            topGestureLayout.setInterceptTouchFlag(z16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void M2(Intent intent, int i3, List<MayKnowRecommend> list) {
        if (i3 == 9 || i3 == 8) {
            ArrayList arrayList = (ArrayList) this.f181219k0.clone();
            if (arrayList == null) {
                arrayList = new ArrayList();
            }
            Iterator it = arrayList.iterator();
            ArrayList arrayList2 = new ArrayList(arrayList.size());
            while (it.hasNext()) {
                MayKnowRecommend mayKnowRecommend = (MayKnowRecommend) it.next();
                Iterator<MayKnowRecommend> it5 = list.iterator();
                while (true) {
                    if (!it5.hasNext()) {
                        break;
                    }
                    MayKnowRecommend next = it5.next();
                    if (next.uin.equalsIgnoreCase(mayKnowRecommend.uin)) {
                        arrayList2.add(next);
                        break;
                    }
                }
                if (i3 == 9) {
                    mayKnowRecommend.bHighLight = true;
                }
                IAddFriendServiceApi iAddFriendServiceApi = (IAddFriendServiceApi) ((QQAppInterface) MobileQQ.sMobileQQ.peekAppRuntime()).getRuntimeService(IAddFriendServiceApi.class, "");
                if (((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).isFriend(mayKnowRecommend.uin, "qqBaseActivity") || iAddFriendServiceApi.hasSendAddFriendReq(mayKnowRecommend.uin)) {
                    QLog.i("qqBaseActivity", 1, "removePushItem uin: " + mayKnowRecommend.uin + "isFriend: " + ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).isFriend(mayKnowRecommend.uin, "qqBaseActivity") + " hasSendAddFriendReq: " + iAddFriendServiceApi.hasSendAddFriendReq(mayKnowRecommend.uin));
                    it.remove();
                }
            }
            list.removeAll(arrayList2);
            list.addAll(0, arrayList);
            if (QLog.isColorLevel()) {
                StringBuilder sb5 = new StringBuilder("handlePushFrds");
                Iterator it6 = arrayList.iterator();
                while (it6.hasNext()) {
                    MayKnowRecommend mayKnowRecommend2 = (MayKnowRecommend) it6.next();
                    sb5.append(" ");
                    sb5.append(mayKnowRecommend2.uin);
                }
                QLog.i("qqBaseActivity", 2, sb5.toString());
            }
        }
    }

    private void N2() {
        VideoReport.addToDetectionWhitelist(this);
        VideoReport.setPageId(this.f181210b0, "pg_kl_pymk_more");
        VideoReport.setPageParams(this.f181210b0, "trace_id", this.f181215g0);
        VideoReport.setPageParams(this.f181210b0, "trans_info", this.f181216h0);
        VideoReport.setPageParams(this.f181210b0, WinkDaTongReportConstant.ElementParamKey.XSJ_USER_FROM, this.f181217i0);
    }

    private void P2() {
        this.f181212d0.setVisibility(0);
        this.f181220l0.s(false, new ArrayList<>());
    }

    private void Q2(Intent intent) {
        this.f181213e0.I(intent.getIntExtra("key_add_friend_sub_id", 65));
    }

    private void R2(int i3) {
        int i16;
        if (i3 != 8) {
            if (i3 != 11) {
                if (i3 != 12) {
                    i16 = 35;
                } else {
                    i16 = 38;
                }
            } else {
                i16 = 39;
            }
        } else {
            i16 = 37;
        }
        this.f181213e0.O(i16);
    }

    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public boolean doOnCreate(Bundle bundle) {
        ArrayList arrayList;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) bundle)).booleanValue();
        }
        super.doOnCreate(bundle);
        setContentView(R.layout.f167554al);
        Intent intent = getIntent();
        int intExtra = intent.getIntExtra("EntranceId", 0);
        String stringExtra = intent.getStringExtra("uin");
        this.f181218j0 = intent.getBooleanExtra("need_show_qzone_info", false);
        this.f181210b0 = (LinearLayout) findViewById(R.id.root);
        this.f181212d0 = (TextView) findViewById(R.id.bwk);
        this.f181209a0 = (XListView) findViewById(R.id.f166765i30);
        this.f181213e0 = new RecommendFriendAdapter(this, this.app, this.f181209a0, intExtra, this.f181221m0);
        Q2(intent);
        this.f181213e0.T(this.f181224p0);
        this.f181213e0.M(this.f181218j0);
        this.f181213e0.S(this.f181220l0);
        R2(intExtra);
        if (intent.hasExtra("may_know_from")) {
            this.f181217i0 = intent.getStringExtra("may_know_from");
        }
        this.f181213e0.J(getResources().getDimensionPixelSize(R.dimen.f159221xr));
        this.f181213e0.U(stringExtra);
        NavBarCommon navBarCommon = (NavBarCommon) findViewById(R.id.jo9);
        this.f181211c0 = navBarCommon;
        navBarCommon.setTitle(getString(R.string.c7p));
        setTitle(getString(R.string.c7p));
        this.f181211c0.setOnItemSelectListener(new c());
        if (ab.a() && AppSetting.f99565y) {
            AccessibilityUtil.c(this.f181211c0.getLeftBackIconImgView(), HardCodeUtil.qqStr(R.string.f170549u3), Button.class.getName());
        }
        this.f181214f0 = (MayknowRecommendManager) this.app.getManager(QQManagerFactory.MAYKNOW_RECOMMEND_MANAGER);
        this.f181215g0 = ((IQQRecommendFriendApi) QRoute.api(IQQRecommendFriendApi.class)).getTraceId();
        try {
            arrayList = (ArrayList) intent.getSerializableExtra("may_know_recmmds");
        } catch (Throwable th5) {
            if (QLog.isColorLevel()) {
                QLog.i("qqBaseActivity", 2, th5.getMessage(), th5);
            }
            arrayList = null;
        }
        if (arrayList != null && arrayList.size() > 0) {
            this.f181219k0.clear();
            this.f181219k0.addAll(arrayList);
        }
        this.f181220l0.l(this.f181222n0);
        P2();
        N2();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        super.doOnDestroy();
        RecommendFriendAdapter recommendFriendAdapter = this.f181213e0;
        if (recommendFriendAdapter != null) {
            recommendFriendAdapter.destroy();
        }
        this.f181220l0.r();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnNewIntent(Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) intent);
        } else {
            super.doOnNewIntent(intent);
            doOnCreate(intent.getExtras());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnPause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        super.doOnPause();
        RecommendFriendAdapter recommendFriendAdapter = this.f181213e0;
        if (recommendFriendAdapter != null) {
            recommendFriendAdapter.V();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        super.doOnResume();
        RecommendFriendAdapter recommendFriendAdapter = this.f181213e0;
        if (recommendFriendAdapter != null) {
            recommendFriendAdapter.F();
        }
    }

    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }
}
