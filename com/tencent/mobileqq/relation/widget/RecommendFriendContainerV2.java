package com.tencent.mobileqq.relation.widget;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.biz.qui.quiemptystate.QUIEmptyState;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.contact.addcontact.recommend.RecommendFriendActivity;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.adapter.RecommendFriendAdapter;
import com.tencent.mobileqq.app.MayknowRecommendManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.ar;
import com.tencent.mobileqq.data.MayKnowRecommend;
import com.tencent.mobileqq.pymk.api.IPYMKSwitchAGuideApi;
import com.tencent.mobileqq.pymk.api.IQQRecommendFriendApi;
import com.tencent.mobileqq.pymk.api.d;
import com.tencent.mobileqq.pymk.c;
import com.tencent.mobileqq.pymk.i;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.business.addcontact.views.SearchHistoryContainer;
import com.tencent.mobileqq.search.util.ac;
import com.tencent.mobileqq.search.util.aq;
import com.tencent.mobileqq.search.util.z;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.studymode.StudyModeManager;
import com.tencent.mobileqq.studymode.api.IStudyModeManager;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.util.LoadingUtil;
import com.tencent.widget.SwipListView;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes17.dex */
public class RecommendFriendContainerV2 extends FrameLayout implements View.OnClickListener {
    static IPatchRedirector $redirector_;

    /* renamed from: e0, reason: collision with root package name */
    private static int f280659e0;
    private XListView C;
    private RecommendFriendAdapter D;
    private LinearLayout E;
    private MayknowRecommendManager F;
    private TopGestureLayout G;
    private int H;
    private boolean I;
    private int J;
    private boolean K;
    private String L;
    private String M;
    private final SearchHistoryContainer N;
    private final c P;
    private final CopyOnWriteArrayList<MayKnowRecommend> Q;
    private QUIEmptyState R;
    private View S;
    private View T;
    private boolean U;
    private final i V;
    private final ar W;

    /* renamed from: a0, reason: collision with root package name */
    private int f280660a0;

    /* renamed from: b0, reason: collision with root package name */
    private com.tencent.mobileqq.pymk.api.a f280661b0;

    /* renamed from: c0, reason: collision with root package name */
    RecommendFriendAdapter.h f280662c0;

    /* renamed from: d, reason: collision with root package name */
    public int f280663d;

    /* renamed from: d0, reason: collision with root package name */
    private SwipListView.RightIconMenuListener f280664d0;

    /* renamed from: e, reason: collision with root package name */
    private QQAppInterface f280665e;

    /* renamed from: f, reason: collision with root package name */
    private Context f280666f;

    /* renamed from: h, reason: collision with root package name */
    private View f280667h;

    /* renamed from: i, reason: collision with root package name */
    private TextView f280668i;

    /* renamed from: m, reason: collision with root package name */
    private FrameLayout f280669m;

    /* compiled from: P */
    /* loaded from: classes17.dex */
    class a extends d {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) RecommendFriendContainerV2.this);
            }
        }

        @Override // com.tencent.mobileqq.pymk.api.d, com.tencent.mobileqq.pymk.api.a
        public void d(@NotNull List<? extends MayKnowRecommend> list, boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                RecommendFriendContainerV2.this.U = false;
                RecommendFriendContainerV2.this.Q.clear();
                RecommendFriendContainerV2.this.Q.addAll(list);
                RecommendFriendContainerV2.this.S(z16);
                QLog.d("RecommendFriendContainerV2", 2, "onDataChange recommendData", list);
                return;
            }
            iPatchRedirector.redirect((short) 2, this, list, Boolean.valueOf(z16));
        }
    }

    /* compiled from: P */
    /* loaded from: classes17.dex */
    class b implements SwipListView.RightIconMenuListener {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) RecommendFriendContainerV2.this);
            }
        }

        @Override // com.tencent.widget.SwipListView.RightIconMenuListener
        public void onRightIconMenuHide(View view) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                RecommendFriendContainerV2.this.u(true);
            } else {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) view);
            }
        }

        @Override // com.tencent.widget.SwipListView.RightIconMenuListener
        public void onRightIconMenuShow(View view) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                RecommendFriendContainerV2.this.u(false);
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(74589);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 21)) {
            redirector.redirect((short) 21);
        } else {
            f280659e0 = 5;
        }
    }

    public RecommendFriendContainerV2(@NonNull Context context) {
        this(context, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
    }

    private void A() {
        z();
        y();
        B();
    }

    private void B() {
        View view = this.T;
        if (view != null) {
            this.C.removeHeaderView(view);
            this.T = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C() {
        this.f280669m.setVisibility(8);
        this.D.P(Collections.emptyList());
    }

    private void E() {
        FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(this.f280666f).inflate(R.layout.h1e, (ViewGroup) null, false);
        this.f280669m = frameLayout;
        this.f280668i = (TextView) frameLayout.findViewById(R.id.i38);
        LinearLayout linearLayout = (LinearLayout) this.f280669m.findViewById(R.id.yyx);
        this.E = linearLayout;
        linearLayout.setOnClickListener(this);
        VideoReport.setElementId(this.E, "em_bas_search_people_know_view_more");
        VideoReport.setElementClickPolicy(this.E, ClickPolicy.REPORT_NONE);
        VideoReport.setElementExposePolicy(this.E, ExposurePolicy.REPORT_ALL);
        VideoReport.setElementEndExposePolicy(this.E, EndExposurePolicy.REPORT_ALL);
    }

    private void F() {
        XListView xListView = (XListView) findViewById(R.id.f166765i30);
        this.C = xListView;
        xListView.setFocusable(false);
    }

    private void G() {
        this.f280667h = LayoutInflater.from(this.f280666f).inflate(R.layout.h1d, (ViewGroup) this, true);
        E();
        F();
        s();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void H(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (!hf0.a.a("RecommendFriendContainerV2")) {
            if (!NetworkUtil.isNetSupport(this.f280666f)) {
                QQToast.makeText(this.f280666f, "\u5f00\u542f\u5931\u8d25\uff0c\u8bf7\u68c0\u67e5\u7f51\u7edc", 0).show();
            } else {
                L();
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private static void L() {
        QLog.d("RecommendFriendContainerV2", 1, "requestSetMayKnowPersonOpen");
        ((IPYMKSwitchAGuideApi) QRoute.api(IPYMKSwitchAGuideApi.class)).reqOpenPYMKSetting();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void M() {
        int i3 = 8;
        if (!this.I) {
            LinearLayout linearLayout = this.E;
            if (this.C.getCount() > f280659e0) {
                i3 = 0;
            }
            linearLayout.setVisibility(i3);
            return;
        }
        this.E.setVisibility(8);
    }

    private void O() {
        B();
        z();
        if (this.R == null) {
            QUIEmptyState build = new QUIEmptyState.Builder(this.f280666f).setHalfScreenState(false).setImageType(9).setTitle("\u5f00\u542f\u597d\u53cb\u63a8\u8350\uff0c\u627e\u5230\u66f4\u591a\u611f\u5174\u8da3\u7684\u4eba").setButton("\u5f00\u542f", new View.OnClickListener() { // from class: com.tencent.mobileqq.relation.widget.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    RecommendFriendContainerV2.this.H(view);
                }
            }).setHalfScreenState(true).setBackgroundColorType(0).build();
            this.R = build;
            this.C.addHeaderView(build, null, false);
            VideoReport.setElementId(this.R.getButton(), "em_kl_open_pymk");
        }
    }

    private void P() {
        B();
        y();
        if (this.S == null) {
            View inflate = LayoutInflater.from(this.f280666f).inflate(R.layout.gyx, (ViewGroup) null, false);
            this.S = inflate;
            this.C.addHeaderView(inflate, null, false);
        }
    }

    private void Q() {
        if (this.U) {
            R();
        } else if (((IPYMKSwitchAGuideApi) QRoute.api(IPYMKSwitchAGuideApi.class)).getPYMKSetting()) {
            P();
        } else {
            O();
        }
    }

    private void R() {
        z();
        y();
        if (this.T == null) {
            View loadingDialogTipsRight = LoadingUtil.getLoadingDialogTipsRight(this.f280666f, false);
            this.T = loadingDialogTipsRight;
            ((TextView) loadingDialogTipsRight.findViewById(R.id.yt9)).setText("\u6570\u636e\u52a0\u8f7d\u4e2d...");
            this.C.addHeaderView(this.T, null, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void S(boolean z16) {
        if (this.F == null && this.D != null && this.C != null) {
            QLog.i("RecommendFriendContainerV2", 1, "updateData fail : manager is null");
            return;
        }
        boolean N = N();
        List<MayKnowRecommend> localRecommendData = ((IQQRecommendFriendApi) QRoute.api(IQQRecommendFriendApi.class)).getLocalRecommendData();
        if (!localRecommendData.isEmpty()) {
            this.L = localRecommendData.get(0).traceId;
            this.M = localRecommendData.get(0).transInfo;
        }
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.relation.widget.a
            @Override // java.lang.Runnable
            public final void run() {
                RecommendFriendContainerV2.this.T();
            }
        });
        RecommendFriendAdapter recommendFriendAdapter = this.D;
        if (recommendFriendAdapter != null) {
            recommendFriendAdapter.Q(this.Q, Boolean.valueOf(z16));
        }
        ThreadManagerV2.getUIHandlerV2().post(new Runnable(N) { // from class: com.tencent.mobileqq.relation.widget.RecommendFriendContainerV2.4
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ boolean f280674d;

            {
                this.f280674d = N;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, RecommendFriendContainerV2.this, Boolean.valueOf(N));
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                RecommendFriendContainerV2 recommendFriendContainerV2 = RecommendFriendContainerV2.this;
                int v3 = recommendFriendContainerV2.v(recommendFriendContainerV2.Q);
                if (!this.f280674d || v3 == 0) {
                    RecommendFriendContainerV2.this.C();
                } else {
                    RecommendFriendContainerV2.this.f280669m.setVisibility(0);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void T() {
        if (this.f280660a0 != 62) {
            return;
        }
        if (((IStudyModeManager) QRoute.api(IStudyModeManager.class)).getStudyModeSwitch()) {
            QLog.i("RecommendFriendContainerV2", 1, "hide pymk loading because studyMode");
            A();
        } else if (this.P.p().isEmpty()) {
            QLog.i("RecommendFriendContainerV2", 1, "show pymk loading because no data");
            Q();
        } else {
            QLog.i("RecommendFriendContainerV2", 1, "hide pymk loading because has pymk data");
            A();
        }
    }

    private void s() {
        if (ThemeUtil.isNowThemeIsNight(this.f280665e, false, null)) {
            if (!aq.a()) {
                this.f280668i.setTextColor(Color.parseColor("#8D8D93"));
            }
            setBackgroundResource(R.drawable.f160534jf);
        } else {
            if (SimpleUIUtil.isNowElderMode()) {
                this.f280668i.setTextSize(0, ViewUtils.dpToPx(18.0f));
            }
            if (!aq.a()) {
                this.f280668i.setTextColor(Color.parseColor("#999999"));
            }
            setBackgroundResource(R.drawable.f160533je);
        }
        if (aq.a() || z.d()) {
            this.f280668i.setTextSize(14.0f);
            this.f280668i.setTextColor(getResources().getColorStateList(R.color.qui_common_text_primary));
            ((TextView) this.E.findViewById(R.id.i38)).setTextColor(getResources().getColorStateList(R.color.qui_common_text_secondary));
            int dip2px = ViewUtils.dip2px(16.0f);
            View view = new View(this.f280666f);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, this.f280666f.getResources().getDimensionPixelSize(R.dimen.f158696ml));
            layoutParams.leftMargin = dip2px;
            if (!z.e()) {
                dip2px = 0;
            }
            layoutParams.rightMargin = dip2px;
            layoutParams.gravity = 80;
            view.setLayoutParams(layoutParams);
            view.setBackgroundDrawable(this.f280666f.getResources().getDrawable(R.drawable.qui_common_border_standard_bg));
            this.f280669m.addView(view);
            this.f280669m.setBackgroundResource(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(boolean z16) {
        if (this.G == null) {
            ViewGroup viewGroup = (ViewGroup) ((Activity) this.f280666f).getWindow().getDecorView();
            View childAt = viewGroup.getChildAt(0);
            if (childAt != null && (childAt instanceof DragFrameLayout)) {
                viewGroup = (ViewGroup) childAt;
            }
            View childAt2 = viewGroup.getChildAt(0);
            if (childAt2 instanceof TopGestureLayout) {
                this.G = (TopGestureLayout) childAt2;
            }
        }
        TopGestureLayout topGestureLayout = this.G;
        if (topGestureLayout != null) {
            topGestureLayout.setInterceptTouchFlag(z16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int v(List<MayKnowRecommend> list) {
        int size = list.size();
        if (this.I) {
            return size;
        }
        int i3 = this.H;
        if (size > i3) {
            return i3;
        }
        return size;
    }

    private void y() {
        QUIEmptyState qUIEmptyState = this.R;
        if (qUIEmptyState != null) {
            this.C.removeHeaderView(qUIEmptyState);
            this.R = null;
        }
    }

    private void z() {
        View view = this.S;
        if (view != null) {
            this.C.removeHeaderView(view);
            this.S = null;
        }
    }

    public void D() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        this.P.l(this.f280661b0);
        this.P.s(false, new ArrayList<>());
        if (this.P.p().isEmpty()) {
            C();
        }
        T();
    }

    public void I() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this);
            return;
        }
        this.C.removeHeaderView(this.N);
        this.N.L();
        RecommendFriendAdapter recommendFriendAdapter = this.D;
        if (recommendFriendAdapter != null) {
            recommendFriendAdapter.T(null);
            this.D.destroy();
        }
        if (this.f280661b0 != null) {
            this.P.r();
            this.f280661b0 = null;
        }
        ((IPYMKSwitchAGuideApi) QRoute.api(IPYMKSwitchAGuideApi.class)).removePYMKSwitchChangeListener(this.V, "RecommendFriendContainerV2");
        this.f280665e.removeObserver(this.W);
    }

    public void J() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this);
            return;
        }
        RecommendFriendAdapter recommendFriendAdapter = this.D;
        if (recommendFriendAdapter != null) {
            recommendFriendAdapter.V();
            this.D.E();
        }
    }

    public void K() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this);
            return;
        }
        RecommendFriendAdapter recommendFriendAdapter = this.D;
        if (recommendFriendAdapter != null) {
            recommendFriendAdapter.F();
        }
        this.N.Q();
    }

    public boolean N() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Boolean) iPatchRedirector.redirect((short) 17, (Object) this)).booleanValue();
        }
        boolean i3 = this.F.i("sp_mayknow_entry_list_add");
        boolean t16 = StudyModeManager.t();
        QLog.i("RecommendFriendContainerV2", 1, "shouldShowContainer addFriendOn: " + i3 + " isStudyMode: " + t16);
        if (i3 && !t16) {
            return true;
        }
        return false;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) view);
        } else if (view.getId() == R.id.yyx) {
            VideoReport.reportEvent("dt_clck", view, null);
            Intent intent = new Intent(this.f280666f, (Class<?>) RecommendFriendActivity.class);
            intent.putExtra("key_add_friend_sub_id", 65);
            intent.putExtra("may_know_from", "1");
            intent.putExtra("need_show_qzone_info", this.K);
            this.f280666f.startActivity(intent);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    public void setAdapter(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, i3);
            return;
        }
        this.f280660a0 = i3;
        if (ac.b() && this.f280663d == 99) {
            this.N.M();
            this.C.addHeaderView(this.N, null, false);
        }
        this.C.addHeaderView(this.f280669m, null, false);
        RecommendFriendAdapter recommendFriendAdapter = new RecommendFriendAdapter(this.f280666f, this.f280665e, this.C, this.J, this.f280662c0);
        this.D = recommendFriendAdapter;
        recommendFriendAdapter.I(i3);
        this.D.T(this.f280664d0);
        this.D.S(this.P);
        this.D.L(this.H);
    }

    public void setEntryId(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, i3);
        } else {
            this.J = i3;
        }
    }

    public void setNeedShowQZoneMediaInfo(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, z16);
        } else {
            this.K = z16;
            this.D.M(z16);
        }
    }

    public void setOnHistorySearchItemClickCallback(Function1<String, Unit> function1) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) function1);
        } else {
            this.N.setOnHistorySearchItemClickCallback(function1);
        }
    }

    public void setRecommendFriendPageId(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, i3);
        } else {
            this.D.O(i3);
        }
    }

    public void setRecommendItemClickListener(RecommendFriendAdapter.f fVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) fVar);
            return;
        }
        RecommendFriendAdapter recommendFriendAdapter = this.D;
        if (recommendFriendAdapter != null) {
            recommendFriendAdapter.N(fVar);
        }
    }

    public void setShowInfinite(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, z16);
        } else if (!z16) {
            this.I = false;
            this.H = f280659e0;
        }
    }

    public void t(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) view);
        } else {
            this.C.addHeaderView(view, null, false);
        }
    }

    public String w() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.L;
    }

    public String x() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (String) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.M;
    }

    public RecommendFriendContainerV2(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
    }

    public RecommendFriendContainerV2(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
            return;
        }
        this.f280663d = -1;
        this.H = Integer.MAX_VALUE;
        this.I = true;
        this.L = "";
        this.M = "";
        this.N = new SearchHistoryContainer(getContext());
        this.P = new c("pg_search_people");
        this.Q = new CopyOnWriteArrayList<>();
        this.U = false;
        i iVar = new i() { // from class: com.tencent.mobileqq.relation.widget.RecommendFriendContainerV2.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) RecommendFriendContainerV2.this);
                }
            }

            @Override // com.tencent.mobileqq.pymk.i
            public void a(boolean z16) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                    RecommendFriendContainerV2.this.U = true;
                    ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.relation.widget.RecommendFriendContainerV2.1.1
                        static IPatchRedirector $redirector_;

                        {
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                iPatchRedirector3.redirect((short) 1, (Object) this, (Object) AnonymousClass1.this);
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 == null || !iPatchRedirector3.hasPatch((short) 2)) {
                                RecommendFriendContainerV2.this.T();
                            } else {
                                iPatchRedirector3.redirect((short) 2, (Object) this);
                            }
                        }
                    });
                } else {
                    iPatchRedirector2.redirect((short) 2, (Object) this, z16);
                }
            }
        };
        this.V = iVar;
        ar arVar = new ar() { // from class: com.tencent.mobileqq.relation.widget.RecommendFriendContainerV2.2
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) RecommendFriendContainerV2.this);
                }
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.tencent.mobileqq.app.ar
            public void onMayKnowEntryStateChanged(boolean z16, Bundle bundle) {
                String str;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, this, Boolean.valueOf(z16), bundle);
                    return;
                }
                super.onMayKnowEntryStateChanged(z16, bundle);
                if (QLog.isColorLevel()) {
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("do network checkUpdate, rsp ");
                    if (z16) {
                        str = "success";
                    } else {
                        str = "false";
                    }
                    sb5.append(str);
                    sb5.append(". msg: \"send network respond done\"");
                    QLog.d("RecommendFriendContainerV2", 2, sb5.toString());
                }
                if (z16) {
                    ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.relation.widget.RecommendFriendContainerV2.2.1
                        static IPatchRedirector $redirector_;

                        {
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                iPatchRedirector3.redirect((short) 1, (Object) this, (Object) AnonymousClass2.this);
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 == null || !iPatchRedirector3.hasPatch((short) 2)) {
                                RecommendFriendContainerV2.this.T();
                            } else {
                                iPatchRedirector3.redirect((short) 2, (Object) this);
                            }
                        }
                    });
                }
            }
        };
        this.W = arVar;
        this.f280661b0 = new a();
        this.f280662c0 = new RecommendFriendAdapter.h() { // from class: com.tencent.mobileqq.relation.widget.RecommendFriendContainerV2.5
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) RecommendFriendContainerV2.this);
                }
            }

            @Override // com.tencent.mobileqq.adapter.RecommendFriendAdapter.h
            public void a(String str) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 3)) {
                    iPatchRedirector2.redirect((short) 3, (Object) this, (Object) str);
                } else {
                    ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.relation.widget.RecommendFriendContainerV2.5.1
                        static IPatchRedirector $redirector_;

                        {
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                iPatchRedirector3.redirect((short) 1, (Object) this, (Object) AnonymousClass5.this);
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                iPatchRedirector3.redirect((short) 2, (Object) this);
                                return;
                            }
                            if (RecommendFriendContainerV2.this.D.getCount() == 0) {
                                RecommendFriendContainerV2.this.f280669m.setVisibility(8);
                            } else {
                                RecommendFriendContainerV2.this.f280669m.setVisibility(0);
                            }
                            RecommendFriendContainerV2.this.M();
                        }
                    });
                }
            }

            @Override // com.tencent.mobileqq.adapter.RecommendFriendAdapter.h
            public void b(List<MayKnowRecommend> list) {
                String str;
                String str2;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) list);
                    return;
                }
                RecommendFriendContainerV2 recommendFriendContainerV2 = RecommendFriendContainerV2.this;
                if (list == null || list.size() == 0) {
                    str = RecommendFriendContainerV2.this.L;
                } else {
                    str = list.get(0).traceId;
                }
                recommendFriendContainerV2.L = str;
                RecommendFriendContainerV2 recommendFriendContainerV22 = RecommendFriendContainerV2.this;
                if (list == null || list.size() == 0) {
                    str2 = RecommendFriendContainerV2.this.M;
                } else {
                    str2 = list.get(0).transInfo;
                }
                recommendFriendContainerV22.M = str2;
            }

            @Override // com.tencent.mobileqq.adapter.RecommendFriendAdapter.g
            public void c() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 5)) {
                    iPatchRedirector2.redirect((short) 5, (Object) this);
                } else if (!RecommendFriendContainerV2.this.N()) {
                    RecommendFriendContainerV2.this.C();
                } else {
                    ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.relation.widget.RecommendFriendContainerV2.5.2
                        static IPatchRedirector $redirector_;

                        {
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                iPatchRedirector3.redirect((short) 1, (Object) this, (Object) AnonymousClass5.this);
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                iPatchRedirector3.redirect((short) 2, (Object) this);
                                return;
                            }
                            if (RecommendFriendContainerV2.this.D.getCount() == 0) {
                                RecommendFriendContainerV2.this.f280669m.setVisibility(8);
                            } else {
                                RecommendFriendContainerV2.this.f280669m.setVisibility(0);
                            }
                            RecommendFriendContainerV2.this.M();
                        }
                    });
                }
            }

            @Override // com.tencent.mobileqq.adapter.RecommendFriendAdapter.g
            public void d(int i16) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 6)) {
                    iPatchRedirector2.redirect((short) 6, (Object) this, i16);
                } else if (!RecommendFriendContainerV2.this.I) {
                    RecommendFriendContainerV2.this.E.setVisibility(0);
                }
            }

            @Override // com.tencent.mobileqq.adapter.RecommendFriendAdapter.g
            public void e() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 4)) {
                    RecommendFriendContainerV2.this.C();
                } else {
                    iPatchRedirector2.redirect((short) 4, (Object) this);
                }
            }
        };
        this.f280664d0 = new b();
        QQAppInterface qQAppInterface = (QQAppInterface) BaseApplicationImpl.getApplication().getRuntime();
        this.f280665e = qQAppInterface;
        this.I = true;
        this.J = 11;
        this.f280666f = context;
        this.F = (MayknowRecommendManager) qQAppInterface.getManager(QQManagerFactory.MAYKNOW_RECOMMEND_MANAGER);
        G();
        ((IPYMKSwitchAGuideApi) QRoute.api(IPYMKSwitchAGuideApi.class)).addPYMKSwitchChangeListener(iVar, "RecommendFriendContainerV2");
        this.f280665e.addObserver(arVar);
    }
}
