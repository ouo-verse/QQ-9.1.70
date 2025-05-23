package com.tencent.mobileqq.onlinestatus.binder;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.core.content.res.ResourcesCompat;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.OnLifecycleEvent;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.DiyStatusEmoInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.data.AutoReplyText;
import com.tencent.mobileqq.onlinestatus.AutoReplyEditActivity;
import com.tencent.mobileqq.onlinestatus.OnlineStatusPanel;
import com.tencent.mobileqq.onlinestatus.OnlineStatusPermissionChecker;
import com.tencent.mobileqq.onlinestatus.af;
import com.tencent.mobileqq.onlinestatus.ar;
import com.tencent.mobileqq.onlinestatus.as;
import com.tencent.mobileqq.onlinestatus.at;
import com.tencent.mobileqq.onlinestatus.au;
import com.tencent.mobileqq.onlinestatus.aw;
import com.tencent.mobileqq.onlinestatus.ba;
import com.tencent.mobileqq.onlinestatus.bt;
import com.tencent.mobileqq.onlinestatus.bv;
import com.tencent.mobileqq.onlinestatus.diy.DIYStatusDialogFragment;
import com.tencent.mobileqq.onlinestatus.r;
import com.tencent.mobileqq.onlinestatus.view.ax;
import com.tencent.mobileqq.onlinestatus.view.v;
import com.tencent.mobileqq.onlinestatus.viewmodel.AccountOnlineStateViewModel;
import com.tencent.mobileqq.onlinestatus.w;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.relation.api.ICardHandler;
import com.tencent.mobileqq.relation.api.IContactUtilsApi;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.vas.onlinestatus.api.ICustomOnlineStatusManager;
import com.tencent.mobileqq.widget.FormItemRelativeLayout;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.listitem.QUISingleLineListItem;
import com.tencent.mobileqq.widget.listitem.x;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ListView;
import com.tencent.widget.SwipListView;
import java.util.ArrayList;
import java.util.List;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes16.dex */
public class AccountOnlineStateBinder extends com.tencent.mobileqq.mvvm.b implements View.OnClickListener, r.i, aw.a, bt.a, w.a, v.a, OnlineStatusPanel.a {
    private LinearLayout C;
    private ImageView D;
    private ImageView E;
    private View F;
    private View G;
    private View H;
    private TextView I;
    private TextView J;
    private View K;
    private ListView L;
    private bt M;
    private r N;
    private b P;
    private at Q = new at();
    private ax R = new ax();
    private AppInterface S;
    private QBaseActivity T;
    private AccountOnlineStateViewModel U;

    /* renamed from: d, reason: collision with root package name */
    private TopGestureLayout f255591d;

    /* renamed from: e, reason: collision with root package name */
    private AutoReplyText f255592e;

    /* renamed from: f, reason: collision with root package name */
    private AutoReplyText f255593f;

    /* renamed from: h, reason: collision with root package name */
    private QUISingleLineListItem f255594h;

    /* renamed from: i, reason: collision with root package name */
    private QUISingleLineListItem f255595i;

    /* renamed from: m, reason: collision with root package name */
    private TextView f255596m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes16.dex */
    public class a implements SwipListView.RightIconMenuListener {
        a() {
        }

        @Override // com.tencent.widget.SwipListView.RightIconMenuListener
        public void onRightIconMenuHide(View view) {
            if (AccountOnlineStateBinder.this.f255591d != null) {
                AccountOnlineStateBinder.this.f255591d.setInterceptTouchFlag(true);
            }
        }

        @Override // com.tencent.widget.SwipListView.RightIconMenuListener
        public void onRightIconMenuShow(View view) {
            if (AccountOnlineStateBinder.this.f255591d != null) {
                AccountOnlineStateBinder.this.f255591d.setInterceptTouchFlag(false);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes16.dex */
    public interface b {
        void C3(boolean z16, int i3);
    }

    public AccountOnlineStateBinder(AppInterface appInterface, QBaseActivity qBaseActivity, AccountOnlineStateViewModel accountOnlineStateViewModel, b bVar) {
        this.P = bVar;
        this.T = qBaseActivity;
        this.S = appInterface;
        this.U = accountOnlineStateViewModel;
    }

    private void C(View view, com.tencent.mobileqq.onlinestatus.model.g gVar) {
        this.C = (LinearLayout) view.findViewById(R.id.egb);
        QUISingleLineListItem qUISingleLineListItem = (QUISingleLineListItem) view.findViewById(R.id.s8_);
        this.f255594h = qUISingleLineListItem;
        qUISingleLineListItem.setOnClickListener(this);
        this.f255594h.setConfig(new x.b.d(""), new x.c.g("", true, false));
        this.f255596m = (TextView) view.findViewById(R.id.jm8);
        QUISingleLineListItem qUISingleLineListItem2 = (QUISingleLineListItem) view.findViewById(R.id.s8e);
        this.f255595i = qUISingleLineListItem2;
        qUISingleLineListItem2.setConfig(new x.b.d(""), new x.c.g("", true, false));
        this.H = view.findViewById(R.id.zxd);
        this.D = (ImageView) view.findViewById(R.id.f85024nu);
        this.E = (ImageView) view.findViewById(R.id.f85144o6);
        this.F = view.findViewById(R.id.s8c);
        this.G = view.findViewById(R.id.xvr);
        this.K = view.findViewById(R.id.f85154o7);
        this.J = (TextView) view.findViewById(R.id.s8b);
        this.I = (TextView) view.findViewById(R.id.s8a);
        this.F.setOnClickListener(this);
        this.G.setOnClickListener(this);
        this.f255595i.setOnClickListener(this);
        P(gVar.f256023b, false);
        A(gVar.f256022a, gVar.f256023b);
        O(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void F(List list) {
        r rVar;
        if (list != null && list.size() > 0 && (rVar = this.N) != null) {
            rVar.s(list);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void G(Integer num) {
        this.M.l();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void H(com.tencent.mobileqq.onlinestatus.model.g gVar) {
        if (gVar != null) {
            this.M.h(gVar.f256022a, gVar.f256023b);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void I(OnlineStatusPermissionChecker.OnlineStatusPermissionItem onlineStatusPermissionItem) {
        com.tencent.mobileqq.onlinestatus.model.g value = this.U.Q1().getValue();
        if (value == null) {
            return;
        }
        P(value.f256023b, true);
        A(value.f256022a, value.f256023b);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void J(AccountOnlineStateViewModel accountOnlineStateViewModel, com.tencent.mobileqq.onlinestatus.model.h hVar) {
        if (hVar.f256027c) {
            accountOnlineStateViewModel.f2(this.M.c());
            return;
        }
        b bVar = this.P;
        if (bVar != null) {
            bVar.C3(hVar.f256025a, hVar.f256026b);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void K(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        ((ICustomOnlineStatusManager) QRoute.api(ICustomOnlineStatusManager.class)).openH5(this.T, WinkDaTongReportConstant.ElementParamValue.MUSIC_FROM_PANEL);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void L(au auVar, DiyStatusEmoInfo diyStatusEmoInfo) {
        com.tencent.mobileqq.onlinestatus.model.g gVar = new com.tencent.mobileqq.onlinestatus.model.g(af.C().i(auVar), auVar.f255489b);
        gVar.f256024c = diyStatusEmoInfo;
        this.U.Q1().setValue(gVar);
    }

    private void N(boolean z16) {
        int i3;
        r rVar = this.N;
        if (rVar != null) {
            ArrayList<AutoReplyText> k3 = rVar.k();
            AutoReplyText autoReplyText = this.f255592e;
            int i16 = 0;
            if (autoReplyText != null) {
                i3 = autoReplyText.mTextId;
            } else {
                i3 = 0;
            }
            AutoReplyText autoReplyText2 = this.f255593f;
            if (autoReplyText2 != null) {
                i16 = autoReplyText2.mTextId;
            }
            ((ICardHandler) QRoute.api(ICardHandler.class)).setAutoReplyList(k3, i3, i16, z16);
        }
    }

    private void O(View view) {
        View findViewById = view.findViewById(R.id.xvq);
        if (findViewById instanceof FormItemRelativeLayout) {
            ((FormItemRelativeLayout) findViewById).setBGType(1);
        }
        View view2 = this.G;
        if (view2 instanceof FormItemRelativeLayout) {
            ((FormItemRelativeLayout) view2).setBGType(3);
        }
    }

    private void P(long j3, boolean z16) {
        String str;
        String str2;
        QBaseActivity qBaseActivity = this.T;
        if (qBaseActivity != null && !qBaseActivity.isFinishing()) {
            w b16 = this.Q.b(j3, this, this.S, this.T);
            if (b16 == null) {
                this.L.removeFooterView(this.C);
                return;
            }
            if (b16.f256875d) {
                this.H.setVisibility(0);
                this.U.b2(this.S, this.T);
                Q();
            } else {
                this.H.setVisibility(8);
            }
            if (z16) {
                return;
            }
            if (this.C.getParent() == null) {
                this.L.addFooterView(this.C);
            }
            TextView textView = this.f255596m;
            String str3 = "";
            if (TextUtils.isEmpty(b16.f256872a)) {
                str = "";
            } else {
                str = b16.f256872a;
            }
            textView.setText(str);
            if (TextUtils.isEmpty(b16.f256873b)) {
                str2 = "\u5728\u7ebf";
            } else {
                str2 = b16.f256873b;
            }
            x.b.d dVar = new x.b.d(str2);
            if (!TextUtils.isEmpty(b16.f256874c)) {
                str3 = b16.f256874c;
            }
            x.c.g gVar = new x.c.g(str3, true, false);
            this.f255594h.setConfig(dVar, gVar);
            com.tencent.mobileqq.onlinestatus.model.g value = this.U.Q1().getValue();
            if (value != null && (value.f256022a != AppRuntime.Status.online || value.f256023b != 0)) {
                this.f255594h.setOnClickListener(this);
            }
            if (b16.a()) {
                this.f255594h.setClickable(true);
            } else {
                this.f255594h.setClickable(false);
                gVar = new x.c.g(str3, false, false);
                this.f255594h.setConfig(dVar, gVar);
            }
            if (TextUtils.isEmpty(b16.f256876e)) {
                this.f255595i.setVisibility(8);
                return;
            }
            this.f255595i.setVisibility(0);
            this.f255594h.setConfig(new x.b.d(b16.f256876e), gVar);
        }
    }

    private void Q() {
        OnlineStatusPermissionChecker.OnlineStatusPermissionItem value = this.U.U1().getValue();
        if (value == null) {
            return;
        }
        int i3 = 8;
        if (value.isAllHasPermission()) {
            this.D.setVisibility(0);
            this.E.setVisibility(8);
            this.K.setVisibility(8);
        } else {
            this.D.setVisibility(8);
            this.E.setVisibility(0);
            this.K.setVisibility(0);
            if (value.getPermissionUins() == null) {
                return;
            }
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            for (int i16 = 0; i16 < value.getPermissionUins().size(); i16++) {
                spannableStringBuilder.append((CharSequence) ((IContactUtilsApi) QRoute.api(IContactUtilsApi.class)).getFriendShowName(String.valueOf(value.getPermissionUins().get(i16))));
                if (i16 != value.getPermissionUins().size() - 1) {
                    spannableStringBuilder.append((CharSequence) "\u3001");
                }
            }
            this.I.setText(spannableStringBuilder.toString());
            Drawable drawable = ResourcesCompat.getDrawable(this.T.getResources(), R.drawable.common_arrow_right_selector, this.T.getTheme());
            if (drawable != null) {
                drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
            }
            this.J.setCompoundDrawables(null, null, drawable, null);
            if (value.getPermissionUins().size() > 0) {
                this.J.setText("\uff08" + value.getPermissionUins().size() + "\u4eba\uff09");
            } else {
                this.J.setText("");
            }
        }
        ImageView imageView = this.E;
        if (!value.isAllHasPermission()) {
            i3 = 0;
        }
        imageView.setVisibility(i3);
    }

    public void A(AppRuntime.Status status, long j3) {
        if (status == AppRuntime.Status.online && j3 == 0) {
            if (this.C.getParent() == null) {
                this.L.addFooterView(this.C);
            }
            this.f255596m.setText(R.string.yji);
            this.f255594h.setConfig(new x.b.d(this.T.getResources().getString(R.string.yjj)), new x.c.g("", true, false));
            this.f255594h.setClickable(true);
            this.f255594h.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.onlinestatus.binder.f
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    AccountOnlineStateBinder.this.K(view);
                }
            });
            this.H.setVisibility(8);
            this.f255595i.setVisibility(8);
        }
    }

    public void B(int i3, int i16, Intent intent) {
        this.R.e(i3, i16, intent);
    }

    public void D(View view, com.tencent.mobileqq.onlinestatus.model.g gVar) {
        LinearLayout linearLayout = new LinearLayout(this.T);
        linearLayout.setOrientation(1);
        linearLayout.setBackgroundResource(R.drawable.j19);
        Drawable drawable = ResourcesCompat.getDrawable(this.T.getResources(), R.drawable.qq_account_select_icon, this.T.getTheme());
        ba baVar = new ba();
        baVar.f255562a = 2;
        baVar.f255572k = false;
        baVar.f255573l = false;
        baVar.f255571j = this.T.getResources().getDisplayMetrics().widthPixels;
        baVar.f255577p = QQTheme.isNowThemeIsNight();
        bt btVar = new bt(this.T, linearLayout, this, baVar, this);
        this.M = btVar;
        btVar.b();
        r rVar = new r(this.S, this.T, drawable);
        this.N = rVar;
        rVar.q(this);
        this.M.i(gVar.f256022a, gVar.f256023b, this);
        ListView listView = (ListView) view.findViewById(R.id.f163898bm);
        this.L = listView;
        if (listView instanceof SwipListView) {
            ((SwipListView) listView).setDragEnable(true);
            ((SwipListView) this.L).setRightIconMenuListener(new a());
        }
        this.L.addHeaderView(linearLayout);
        this.L.setAdapter((ListAdapter) this.N);
        this.L.setDividerHeight(0);
        C(View.inflate(this.T, R.layout.dpz, null), gVar);
    }

    public void E(AutoReplyText autoReplyText) {
        if (autoReplyText != null) {
            this.N.m(autoReplyText);
            this.N.p(autoReplyText.getTextId());
        }
    }

    @Override // com.tencent.mobileqq.onlinestatus.view.v.a
    public void G0(AppRuntime.Status status, long j3) {
        if (j3 == 2000) {
            c(af.C().I(AppRuntime.Status.online, j3), null);
        }
    }

    @Override // com.tencent.mobileqq.onlinestatus.view.v.a
    public void L0(AppRuntime.Status status, int i3) {
        com.tencent.mobileqq.onlinestatus.model.g value;
        if (this.M != null && (value = this.U.S1().getValue()) != null) {
            this.M.i(value.f256022a, value.f256023b, this);
        }
    }

    public void M(View view) {
        this.f255591d = y(view);
    }

    @Override // com.tencent.mobileqq.onlinestatus.OnlineStatusPanel.a
    public ArrayList<au> Qg() {
        bt btVar = this.M;
        if (btVar != null) {
            return btVar.e();
        }
        return null;
    }

    @Override // com.tencent.mobileqq.onlinestatus.r.i
    public void a(@Nullable AutoReplyText autoReplyText, boolean z16) {
        if (QLog.isColorLevel()) {
            QLog.d("AccountOnlineStateBinder", 2, autoReplyText + " is click");
        }
        if (autoReplyText != null && autoReplyText.getExtra().getBoolean("addFlag", false)) {
            as.b(this.S);
        }
        QBaseActivity qBaseActivity = this.T;
        if (qBaseActivity != null) {
            AutoReplyEditActivity.Lh(qBaseActivity, 325, autoReplyText);
        }
        ReportController.o(this.S, "dc00898", "", "", "0X8009E87", "0X8009E87", 0, 0, "", "", "", "");
    }

    @Override // com.tencent.mobileqq.onlinestatus.r.i
    public void b(AutoReplyText autoReplyText) {
        if (QLog.isColorLevel()) {
            QLog.d("AccountOnlineStateBinder", 2, "text is added, text = " + autoReplyText);
        }
    }

    @Override // com.tencent.mobileqq.onlinestatus.bt.a
    public void c(final au auVar, View view) {
        com.tencent.mobileqq.onlinestatus.model.g value = this.U.Q1().getValue();
        if (auVar != null) {
            value = new com.tencent.mobileqq.onlinestatus.model.g(af.C().i(auVar), auVar.f255489b);
            this.U.Q1().setValue(value);
        }
        if (view != null && auVar != null && auVar.f255489b == 2000) {
            value = new com.tencent.mobileqq.onlinestatus.model.g(af.C().i(auVar), auVar.f255489b);
            DIYStatusDialogFragment dIYStatusDialogFragment = new DIYStatusDialogFragment(this, 4);
            dIYStatusDialogFragment.Sh(new DIYStatusDialogFragment.d() { // from class: com.tencent.mobileqq.onlinestatus.binder.a
                @Override // com.tencent.mobileqq.onlinestatus.diy.DIYStatusDialogFragment.d
                public final void a(DiyStatusEmoInfo diyStatusEmoInfo) {
                    AccountOnlineStateBinder.this.L(auVar, diyStatusEmoInfo);
                }
            });
            dIYStatusDialogFragment.show(this.T.getSupportFragmentManager(), "diyStatusDialogFragment");
        }
        if (value == null) {
            return;
        }
        this.U.S1().setValue(new com.tencent.mobileqq.onlinestatus.model.g(value.f256022a, value.f256023b));
        this.N.r(ar.a(value.f256022a));
        w b16 = this.Q.b(value.f256023b, this, this.S, this.T);
        if (b16 != null) {
            b16.c();
        }
        if (this.C != null) {
            P(value.f256023b, false);
            if (auVar != null) {
                A(auVar.f255494g, auVar.f255489b);
            }
        }
    }

    @Override // com.tencent.mobileqq.onlinestatus.r.i
    public void d(AutoReplyText autoReplyText, boolean z16) {
        if (QLog.isColorLevel()) {
            QLog.d("AccountOnlineStateBinder", 2, autoReplyText + " is delete");
        }
        ReportController.o(this.S, "dc00898", "", "", "0X8009E88", "0X8009E88", 0, 0, "", "", "", "");
    }

    @Override // com.tencent.mobileqq.onlinestatus.r.i
    public void e(AutoReplyText autoReplyText, AutoReplyText autoReplyText2) {
        if (QLog.isColorLevel()) {
            QLog.d("AccountOnlineStateBinder", 2, autoReplyText + " is checked, lastChecked is " + autoReplyText2);
        }
        this.f255592e = autoReplyText;
        this.f255593f = autoReplyText2;
    }

    @Override // com.tencent.mobileqq.onlinestatus.w.a
    public void f() {
        com.tencent.mobileqq.onlinestatus.model.g value = this.U.Q1().getValue();
        if (value == null) {
            return;
        }
        P(value.f256023b, false);
        A(value.f256022a, value.f256023b);
    }

    @Override // com.tencent.mobileqq.onlinestatus.aw.a
    public void g2(au auVar, au auVar2, View view) {
        c(auVar2, view);
    }

    @Override // com.tencent.mobileqq.onlinestatus.OnlineStatusPanel.a
    public ArrayList<au> getDataList() {
        com.tencent.mobileqq.onlinestatus.model.g value = this.U.Q1().getValue();
        if (value == null) {
            return null;
        }
        return af.C().L(value.f256022a, value.f256023b, false);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        int id5 = view.getId();
        com.tencent.mobileqq.onlinestatus.model.g value = this.U.Q1().getValue();
        boolean z16 = true;
        if (id5 == R.id.s8c) {
            if (QLog.isColorLevel()) {
                QLog.d("AccountOnlineStateBinder", 2, "account_online_status_show_all!");
            }
            if (this.D.getVisibility() != 0 && value != null) {
                this.U.i2(OnlineStatusPermissionChecker.OnlineStatusPermissionItem.create(value.f256023b, true, null));
            }
            bv.b("0X800AF99", 1);
        } else if (id5 == R.id.s8_ && value != null) {
            w b16 = this.Q.b(value.f256023b, this, this.S, this.T);
            if (b16 != null) {
                b16.d();
            }
        } else if (id5 == R.id.s8e && value != null) {
            w b17 = this.Q.b(value.f256023b, this, this.S, this.T);
            if (b17 != null) {
                b17.e();
            }
        } else if (id5 == R.id.xvr) {
            AccountOnlineStateViewModel accountOnlineStateViewModel = this.U;
            if (this.E.getVisibility() == 0) {
                z16 = false;
            }
            accountOnlineStateViewModel.e2(z16, this.S, this.T);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    public void q(LifecycleOwner lifecycleOwner, AccountOnlineStateViewModel accountOnlineStateViewModel) {
        accountOnlineStateViewModel.O1().observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.onlinestatus.binder.e
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                AccountOnlineStateBinder.this.F((List) obj);
            }
        });
    }

    public void r(LifecycleOwner lifecycleOwner, AccountOnlineStateViewModel accountOnlineStateViewModel) {
        accountOnlineStateViewModel.P1().observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.onlinestatus.binder.d
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                AccountOnlineStateBinder.this.G((Integer) obj);
            }
        });
    }

    public void s(LifecycleOwner lifecycleOwner) {
        lifecycleOwner.getLifecycle().addObserver(new LifecycleObserver() { // from class: com.tencent.mobileqq.onlinestatus.binder.AccountOnlineStateBinder.2
            @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
            public void onDestroy(LifecycleOwner lifecycleOwner2) {
                AccountOnlineStateBinder.this.Q.c();
                AccountOnlineStateBinder.this.R.a();
                lifecycleOwner2.getLifecycle().removeObserver(this);
            }
        });
    }

    public void t(LifecycleOwner lifecycleOwner, AccountOnlineStateViewModel accountOnlineStateViewModel) {
        accountOnlineStateViewModel.Q1().observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.onlinestatus.binder.c
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                AccountOnlineStateBinder.this.H((com.tencent.mobileqq.onlinestatus.model.g) obj);
            }
        });
    }

    public void u(LifecycleOwner lifecycleOwner, AccountOnlineStateViewModel accountOnlineStateViewModel) {
        accountOnlineStateViewModel.U1().observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.onlinestatus.binder.g
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                AccountOnlineStateBinder.this.I((OnlineStatusPermissionChecker.OnlineStatusPermissionItem) obj);
            }
        });
    }

    public void v(LifecycleOwner lifecycleOwner, final AccountOnlineStateViewModel accountOnlineStateViewModel) {
        accountOnlineStateViewModel.W1().observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.onlinestatus.binder.b
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                AccountOnlineStateBinder.this.J(accountOnlineStateViewModel, (com.tencent.mobileqq.onlinestatus.model.h) obj);
            }
        });
    }

    public void w(Activity activity) {
        if (this.N.l()) {
            if (NetworkUtil.isNetworkAvailable(activity)) {
                N(false);
                return;
            } else {
                QLog.d("AccountOnlineStateBinder", 2, "onBackEvent network is not available");
                return;
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d("AccountOnlineStateBinder", 2, "onBackEvent auto reply list not changed!");
        }
    }

    public void x() {
        DiyStatusEmoInfo diyStatusEmoInfo;
        com.tencent.mobileqq.onlinestatus.model.g value = this.U.Q1().getValue();
        if (QLog.isColorLevel() && value != null) {
            QLog.d("AccountOnlineStateBinder", 2, "onSubmit online status " + value.f256022a);
        }
        QBaseActivity qBaseActivity = this.T;
        if (qBaseActivity == null) {
            return;
        }
        if (!NetworkUtil.isNetworkAvailable(qBaseActivity)) {
            QQToast.makeText(this.T, 1, R.string.hpk, 1).show();
            return;
        }
        if (this.N.l()) {
            N(true);
        } else {
            au c16 = this.M.c();
            if (c16 == null) {
                if (QLog.isColorLevel()) {
                    QLog.d("AccountOnlineStateBinder", 2, "onSubmit online status is empty");
                    return;
                }
                return;
            } else {
                w b16 = this.Q.b(c16.f255489b, this, this.S, this.T);
                if (value != null && value.f256023b == 2000 && (diyStatusEmoInfo = value.f256024c) != null) {
                    this.U.N1(c16, b16, this.S, diyStatusEmoInfo);
                } else {
                    this.U.N1(c16, b16, this.S, null);
                }
            }
        }
        this.U.M1(value, this.S, this.f255592e);
    }

    TopGestureLayout y(View view) {
        if (view == null) {
            return null;
        }
        for (ViewParent parent = view.getParent(); parent != null; parent = parent.getParent()) {
            if (parent instanceof TopGestureLayout) {
                return (TopGestureLayout) parent;
            }
        }
        return null;
    }

    public void z(int i3, int i16, Intent intent) {
        au c16 = this.M.c();
        if (c16 == null) {
            QLog.d("AccountOnlineStateBinder", 2, "checkStatusItem == null");
            return;
        }
        w b16 = this.Q.b(c16.f255489b, this, this.S, this.T);
        if (b16 != null) {
            b16.g(i3, i16, intent);
        } else {
            QLog.d("AccountOnlineStateBinder", 2, "info == null");
        }
    }

    @Override // com.tencent.mobileqq.onlinestatus.aw.a
    public void l3(View view) {
    }

    @Override // com.tencent.mobileqq.onlinestatus.aw.a
    public void Q9(au auVar, View view) {
    }
}
