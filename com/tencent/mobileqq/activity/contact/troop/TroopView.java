package com.tencent.mobileqq.activity.contact.troop;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.lifecycle.Observer;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.activity.contact.troop.BaseTroopView;
import com.tencent.mobileqq.adapter.TroopListAdapter2;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.bs;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.forward.ForwardShareCardOption;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.SearchUtil;
import com.tencent.mobileqq.search.activity.ContactSearchComponentActivity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.PullRefreshHeader;
import com.tencent.mobileqq.widget.ShaderAnimLayout;
import com.tencent.mobileqq.widget.SlideDetectListView;
import com.tencent.open.agent.report.ReportCenter;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.kernel.nativeinterface.GroupMsgMask;
import com.tencent.qqnt.troop.ITroopListRepoApi;
import com.tencent.widget.AbsListView;
import com.tencent.widget.ListView;
import com.tencent.widget.OverScrollViewListener;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes10.dex */
public class TroopView extends BaseTroopView implements View.OnClickListener, OverScrollViewListener, SlideDetectListView.c, TroopListAdapter2.d, AbsListView.OnScrollListener {
    static IPatchRedirector $redirector_;
    protected SlideDetectListView F;
    protected TroopListAdapter2 G;
    boolean H;
    protected PullRefreshHeader I;
    protected d J;
    protected f K;
    protected e L;
    protected b M;
    protected c N;
    protected View P;
    RelativeLayout Q;
    TextView R;
    TextView S;
    int T;
    protected int U;

    /* compiled from: P */
    /* loaded from: classes10.dex */
    static /* synthetic */ class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f181373a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(67955);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 1)) {
                redirector.redirect((short) 1);
                return;
            }
            int[] iArr = new int[GroupMsgMask.values().length];
            f181373a = iArr;
            try {
                iArr[GroupMsgMask.NOTIFY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f181373a[GroupMsgMask.ASSISTANT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f181373a[GroupMsgMask.SHIELD.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f181373a[GroupMsgMask.RECEIVE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    protected class b extends com.tencent.mobileqq.avatar.observer.a {
        static IPatchRedirector $redirector_;

        protected b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopView.this);
            }
        }

        @Override // com.tencent.mobileqq.avatar.observer.a
        protected void onUpdateTroopHead(boolean z16, String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), str);
            } else if (z16) {
                TroopView.this.A();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    protected class c extends bs {
        static IPatchRedirector $redirector_;

        protected c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopView.this);
            }
        }

        @Override // com.tencent.mobileqq.app.bs
        protected void onUpdateTroopList() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                TroopView.this.A();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    protected class d extends com.tencent.mobileqq.troop.roamsetting.b {
        static IPatchRedirector $redirector_;

        protected d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopView.this);
            }
        }

        @Override // com.tencent.mobileqq.troop.roamsetting.b
        protected void c(String str, GroupMsgMask groupMsgMask) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) str, (Object) groupMsgMask);
            } else {
                TroopView.this.A();
            }
        }

        @Override // com.tencent.mobileqq.troop.roamsetting.b
        protected void d(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
            } else {
                TroopView.this.A();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    protected class e extends com.tencent.mobileqq.troop.api.observer.b {
        static IPatchRedirector $redirector_;

        protected e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopView.this);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.troop.api.observer.b
        public void l(int i3, int i16, String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Integer.valueOf(i16), str);
                return;
            }
            if (i3 == 6) {
                if (i16 == 0) {
                    TroopView.this.A();
                }
            } else if (i3 == 2) {
                if (i16 == 0) {
                    TroopView.this.A();
                }
            } else if (i3 == 9 && i16 == 0) {
                TroopView.this.A();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    protected class f extends com.tencent.mobileqq.troop.api.observer.e {
        static IPatchRedirector $redirector_;

        protected f() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopView.this);
            }
        }

        @Override // com.tencent.mobileqq.troop.api.observer.e
        protected void onGetMutilTroopInfoResult(boolean z16, ArrayList<TroopInfo> arrayList) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, this, Boolean.valueOf(z16), arrayList);
            } else if (z16) {
                TroopView.this.A();
            }
        }

        @Override // com.tencent.mobileqq.troop.api.observer.e
        protected void onGetTroopInfoResult(boolean z16, String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), str);
            } else if (z16) {
                TroopView.this.A();
            }
        }

        @Override // com.tencent.mobileqq.troop.api.observer.e
        protected void onUpdateTroopNickname(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, z16);
            } else if (z16) {
                TroopView.this.A();
            }
        }
    }

    public TroopView(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.H = false;
        this.J = new d();
        this.K = new f();
        this.L = new e();
        this.M = new b();
        this.N = new c();
        this.P = null;
        this.R = null;
        this.S = null;
    }

    private void B() {
        f().getSharedPreferences("rec_last_troop_list_refresh_time", 0).edit().putLong("rec_last_troop_list_refresh_time", System.currentTimeMillis()).commit();
    }

    private void C(int i3) {
        TroopListAdapter2 troopListAdapter2;
        String qqStr;
        String valueOf;
        if (f() != null && (troopListAdapter2 = this.G) != null) {
            int i16 = i3 - 2;
            if (i16 >= 0 && i16 < troopListAdapter2.getCount()) {
                Object item = this.G.getItem(i16);
                if (!(item instanceof com.tencent.mobileqq.troop.adapter.contact.c)) {
                    return;
                }
                switch (((com.tencent.mobileqq.troop.adapter.contact.c) item).f293804a) {
                    case 2:
                    case 3:
                        qqStr = HardCodeUtil.qqStr(R.string.urw);
                        valueOf = String.valueOf(this.G.M);
                        break;
                    case 4:
                    case 5:
                        qqStr = HardCodeUtil.qqStr(R.string.f172862us0);
                        valueOf = String.valueOf(this.G.K);
                        break;
                    case 6:
                    case 7:
                        qqStr = HardCodeUtil.qqStr(R.string.f172863us3);
                        valueOf = String.valueOf(this.G.L);
                        break;
                    default:
                        qqStr = null;
                        valueOf = null;
                        break;
                }
                int i17 = ((com.tencent.mobileqq.troop.adapter.contact.c) this.G.getItem(i3 - 1)).f293804a;
                if (i17 != 6 && i17 != 4 && i17 != 2) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.Q.getLayoutParams();
                    if (layoutParams.topMargin != 0) {
                        layoutParams.topMargin = 0;
                        this.Q.setLayoutParams(layoutParams);
                        this.Q.requestLayout();
                    }
                } else {
                    View childAt = this.F.getChildAt(0);
                    if (childAt != null) {
                        int bottom = childAt.getBottom();
                        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.Q.getLayoutParams();
                        int i18 = this.T;
                        if (bottom < i18) {
                            layoutParams2.topMargin = bottom - i18;
                        } else {
                            layoutParams2.topMargin = 0;
                        }
                        this.Q.setLayoutParams(layoutParams2);
                        this.Q.requestLayout();
                    }
                }
                if (!TextUtils.isEmpty(qqStr)) {
                    this.Q.setVisibility(0);
                    this.R.setText(qqStr);
                    this.S.setText(valueOf);
                    return;
                }
                return;
            }
            this.Q.setVisibility(4);
        }
    }

    private void D(String str, String str2) {
        com.tencent.qqperf.opt.threadpriority.b.k(true);
        Intent m3 = BaseAIOUtils.m(SplashActivity.getAliasIntent(f()), null);
        m3.putExtra("uin", str);
        m3.putExtra("uintype", 3000);
        m3.putExtra("uinname", str2);
        t(m3);
    }

    private long v() {
        return f().getSharedPreferences("rec_last_troop_list_refresh_time", 0).getLong("rec_last_troop_list_refresh_time", 0L);
    }

    private void x() {
        SlideDetectListView slideDetectListView = (SlideDetectListView) findViewById(R.id.qb_troop_list_view);
        this.F = slideDetectListView;
        slideDetectListView.setNeedCheckSpringback(true);
        LayoutInflater from = LayoutInflater.from(f());
        this.Q = (RelativeLayout) findViewById(R.id.iea);
        this.R = (TextView) findViewById(R.id.k1f);
        this.S = (TextView) findViewById(R.id.k1e);
        View inflate = from.inflate(R.layout.search_box, (ViewGroup) this.F, false);
        this.P = inflate;
        inflate.findViewById(R.id.btn_cancel_search).setVisibility(8);
        EditText editText = (EditText) this.P.findViewById(R.id.et_search_keyword);
        editText.setFocusableInTouchMode(false);
        editText.setOnClickListener(this);
        editText.setCursorVisible(false);
        if (this.U != 3) {
            this.F.addHeaderView(this.P);
        }
        View view = new View(getContext());
        view.setLayoutParams(new AbsListView.LayoutParams(-1, BaseAIOUtils.f(12.0f, getResources())));
        this.F.addHeaderView(view);
        this.I = (PullRefreshHeader) from.inflate(R.layout.f168433w5, (ViewGroup) this.F, false);
        this.F.setTranscriptMode(0);
        this.F.setOverScrollHeader(this.I);
        this.F.setOverScrollListener(this);
        if (!this.f181328d.d()) {
            this.F.setOnSlideListener(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void A() {
        TroopListAdapter2 troopListAdapter2 = this.G;
        if (troopListAdapter2 != null) {
            troopListAdapter2.notifyDataSetChanged();
        }
    }

    void E(String str, String str2) {
        String str3;
        com.tencent.qqperf.opt.threadpriority.b.k(true);
        Intent m3 = BaseAIOUtils.m(SplashActivity.getAliasIntent(f()), null);
        m3.putExtra("uin", str);
        TroopInfo k3 = ((TroopManager) this.f181329e.getManager(QQManagerFactory.TROOP_MANAGER)).k(str);
        if (k3 != null && (str3 = k3.troopcode) != null) {
            m3.putExtra("troop_uin", str3);
        }
        m3.putExtra("uintype", 1);
        m3.putExtra("uinname", str2);
        t(m3);
    }

    protected boolean F() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Boolean) iPatchRedirector.redirect((short) 17, (Object) this)).booleanValue();
        }
        if (NetworkUtil.isNetworkAvailable(f())) {
            ((ITroopListRepoApi) QRoute.api(ITroopListRepoApi.class)).fetchTroopList(true);
            this.H = true;
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.adapter.TroopListAdapter2.d
    public void a(DiscussionInfo discussionInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, (Object) discussionInfo);
            return;
        }
        int i3 = 1;
        if (this.f181328d.d()) {
            ForwardBaseOption f16 = this.f181328d.f();
            if (f16 != null) {
                Bundle bundle = new Bundle();
                bundle.putString("uin", discussionInfo.uin);
                bundle.putInt("uintype", 3000);
                bundle.putString("uinname", ForwardUtils.r(this.f181329e, discussionInfo.discussionName, discussionInfo.uin));
                bundle.putBoolean("forward_report_confirm", true);
                bundle.putString("forward_report_confirm_action_name", "0X8005A12");
                f16.buildForwardDialog(com.tencent.mobileqq.forward.e.Q3.intValue(), bundle);
            }
            String str = "";
            try {
                long longExtra = this.f181328d.getActivity().getIntent().getLongExtra("req_share_id", 0L);
                if (longExtra > 0) {
                    str = String.valueOf(longExtra);
                }
            } catch (Exception unused) {
            }
            ReportCenter.f().p(this.f181329e.getAccount(), "", str, "1000", "32", "0", false);
            return;
        }
        D(discussionInfo.uin, discussionInfo.discussionName);
        QQAppInterface qQAppInterface = this.f181329e;
        if (!discussionInfo.hasCollect) {
            i3 = 2;
        }
        ReportController.o(qQAppInterface, "CliOper", "", "", "0X8006666", "0X8006666", i3, 0, "", "", "", "");
    }

    /* JADX WARN: Can't wrap try/catch for region: R(10:11|(3:13|(1:15)(1:17)|16)|(7:(1:(0)(1:32))(1:33)|22|23|24|(2:26|27)|29|30)|34|22|23|24|(0)|29|30) */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x007f, code lost:
    
        if (r26 != 7) goto L22;
     */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00d0 A[Catch: Exception -> 0x00d5, TRY_LEAVE, TryCatch #0 {Exception -> 0x00d5, blocks: (B:24:0x00b9, B:26:0x00d0), top: B:23:0x00b9 }] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x014d  */
    @Override // com.tencent.mobileqq.adapter.TroopListAdapter2.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void b(TroopInfo troopInfo, int i3) {
        int i16;
        int i17;
        long longExtra;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, (Object) troopInfo, i3);
            return;
        }
        if (troopInfo != null) {
            String str = "";
            int i18 = 2;
            if (this.f181328d.d()) {
                ForwardBaseOption f16 = this.f181328d.f();
                if (f16 != null) {
                    Bundle bundle = new Bundle();
                    bundle.putString("uin", troopInfo.troopuin);
                    bundle.putInt("uintype", 1);
                    bundle.putString("troop_uin", troopInfo.troopuin);
                    if (f16 instanceof ForwardShareCardOption) {
                        bundle.putString("uinname", troopInfo.getNewTroopNameOrTroopName());
                    } else {
                        bundle.putString("uinname", troopInfo.getTroopDisplayName());
                    }
                    bundle.putBoolean("forward_report_confirm", true);
                    bundle.putString("forward_report_confirm_action_name", "0X8005A11");
                    f16.buildForwardDialog(com.tencent.mobileqq.forward.e.P3.intValue(), bundle);
                }
                if (i3 != 1) {
                    if (i3 != 3) {
                        if (i3 == 5) {
                            i18 = 1;
                        }
                    } else {
                        i18 = 3;
                    }
                    ReportController.o(this.f181329e, "P_CliOper", "Grp_contacts", "", "choose_grp", "turn", 0, 0, troopInfo.troopuin + "", String.valueOf(i18), "", "");
                    longExtra = this.f181328d.getActivity().getIntent().getLongExtra("req_share_id", 0L);
                    if (longExtra > 0) {
                        str = String.valueOf(longExtra);
                    }
                    ReportCenter.f().p(this.f181329e.getAccount(), "", str, "1000", "31", "0", false);
                    return;
                }
                i18 = 0;
                ReportController.o(this.f181329e, "P_CliOper", "Grp_contacts", "", "choose_grp", "turn", 0, 0, troopInfo.troopuin + "", String.valueOf(i18), "", "");
                longExtra = this.f181328d.getActivity().getIntent().getLongExtra("req_share_id", 0L);
                if (longExtra > 0) {
                }
                ReportCenter.f().p(this.f181329e.getAccount(), "", str, "1000", "31", "0", false);
                return;
            }
            if (this.f181328d.e()) {
                Intent intent = new Intent();
                Bundle bundle2 = new Bundle();
                bundle2.putString("uin", troopInfo.troopuin);
                bundle2.putInt("uintype", 1);
                bundle2.putString("troop_uin", troopInfo.troopuin);
                bundle2.putString("uinname", troopInfo.getTroopDisplayName());
                intent.putExtras(bundle2);
                f().setResult(-1, intent);
                f().finish();
                return;
            }
            if (i3 != 1) {
                if (i3 != 3) {
                    if (i3 != 5) {
                        if (i3 == 7) {
                            i16 = 2;
                        }
                    } else {
                        i16 = 1;
                    }
                } else {
                    i16 = 3;
                }
                i17 = a.f181373a[this.f181329e.getTroopMask(troopInfo.troopuin).ordinal()];
                if (i17 != 1) {
                    if (i17 != 2) {
                        if (i17 != 3) {
                            if (i17 == 4) {
                                i18 = 1;
                            }
                        } else {
                            i18 = 3;
                        }
                    }
                    ReportController.o(this.f181329e, "P_CliOper", "Grp_contacts", "", "choose_grp", "grplist", 0, 0, troopInfo.troopuin + "", String.valueOf(i16), i18 + "", "");
                    E(troopInfo.troopuin, troopInfo.getTroopDisplayName());
                }
                i18 = 0;
                ReportController.o(this.f181329e, "P_CliOper", "Grp_contacts", "", "choose_grp", "grplist", 0, 0, troopInfo.troopuin + "", String.valueOf(i16), i18 + "", "");
                E(troopInfo.troopuin, troopInfo.getTroopDisplayName());
            }
            i16 = 0;
            i17 = a.f181373a[this.f181329e.getTroopMask(troopInfo.troopuin).ordinal()];
            if (i17 != 1) {
            }
            i18 = 0;
            ReportController.o(this.f181329e, "P_CliOper", "Grp_contacts", "", "choose_grp", "grplist", 0, 0, troopInfo.troopuin + "", String.valueOf(i16), i18 + "", "");
            E(troopInfo.troopuin, troopInfo.getTroopDisplayName());
        }
    }

    @Override // com.tencent.mobileqq.widget.SlideDetectListView.c
    public void c(SlideDetectListView slideDetectListView, View view, int i3) {
        ShaderAnimLayout shaderAnimLayout;
        Button button;
        int i16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, slideDetectListView, view, Integer.valueOf(i3));
            return;
        }
        TroopInfo k3 = this.G.k(i3);
        if (k3 == null || (shaderAnimLayout = (ShaderAnimLayout) view.findViewById(R.id.jxn)) == null || (button = (Button) shaderAnimLayout.findViewById(R.id.jxm)) == null) {
            return;
        }
        slideDetectListView.setDeleteAreaWidth(shaderAnimLayout.getLayoutParams().width);
        Activity f16 = f();
        if (k3.isTop) {
            i16 = R.string.bnq;
        } else {
            i16 = R.string.bnr;
        }
        String string = f16.getString(i16);
        button.setText(string);
        button.setVisibility(0);
        button.setTag(k3);
        if (AppSetting.f99565y) {
            button.setContentDescription(string);
        }
        shaderAnimLayout.f();
    }

    @Override // com.tencent.mobileqq.widget.SlideDetectListView.c
    public void d(SlideDetectListView slideDetectListView, View view, int i3) {
        ShaderAnimLayout shaderAnimLayout;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, slideDetectListView, view, Integer.valueOf(i3));
            return;
        }
        if (this.G.k(i3) != null && (shaderAnimLayout = (ShaderAnimLayout) view.findViewById(R.id.jxn)) != null) {
            shaderAnimLayout.a();
            Button button = (Button) shaderAnimLayout.findViewById(R.id.jxm);
            if (button != null) {
                button.setTag(null);
            }
        }
    }

    @Override // com.tencent.mobileqq.activity.contact.troop.BaseTroopView
    public boolean g(Message message) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Boolean) iPatchRedirector.redirect((short) 16, (Object) this, (Object) message)).booleanValue();
        }
        int i3 = message.what;
        if (i3 != 101) {
            if (i3 == 103) {
                this.F.springBackOverScrollHeaderView();
                r(R.string.hqe);
                return true;
            }
            return true;
        }
        this.F.springBackOverScrollHeaderView();
        return true;
    }

    @Override // com.tencent.mobileqq.activity.contact.troop.BaseTroopView
    public void i(int i3, int i16, Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, this, Integer.valueOf(i3), Integer.valueOf(i16), intent);
            return;
        }
        if (i16 == -1 && i3 == 21008 && intent != null) {
            if (this.f181328d.d()) {
                SearchUtil.h(intent, this.f181328d.f());
                return;
            }
            if (this.f181328d.e()) {
                String stringExtra = intent.getStringExtra("contactSearchResultTroopUin");
                String stringExtra2 = intent.getStringExtra("contactSearchResultName");
                Intent intent2 = new Intent();
                Bundle bundle = new Bundle();
                bundle.putString("uin", stringExtra);
                bundle.putInt("uintype", 1);
                bundle.putString("troop_uin", stringExtra);
                bundle.putString("uinname", stringExtra2);
                intent2.putExtras(bundle);
                f().setResult(-1, intent2);
                f().finish();
                return;
            }
            E(intent.getStringExtra("contactSearchResultTroopUin"), intent.getStringExtra("contactSearchResultName"));
        }
    }

    @Override // com.tencent.mobileqq.activity.contact.troop.BaseTroopView
    public void j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        super.j();
        w();
        this.G.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.activity.contact.troop.BaseTroopView
    public void k(Intent intent, BaseTroopView.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) intent, (Object) aVar);
            return;
        }
        super.k(intent, aVar);
        q(R.layout.ajg);
        this.U = ((Activity) getContext()).getIntent().getIntExtra("key_from", 0);
        x();
        this.T = BaseAIOUtils.f(44.0f, getResources());
        e(this.J);
        e(this.M);
        e(this.N);
        e(this.K);
        e(this.L);
        fx3.a<Boolean> fetchTroopListResultLiveData = ((ITroopListRepoApi) QRoute.api(ITroopListRepoApi.class)).getFetchTroopListResultLiveData();
        if (getContext() instanceof QBaseActivity) {
            fetchTroopListResultLiveData.observe((QBaseActivity) getContext(), new Observer() { // from class: com.tencent.mobileqq.activity.contact.troop.d
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    TroopView.this.y(((Boolean) obj).booleanValue());
                }
            });
        }
        if (this.f181328d.d()) {
            this.E = 6;
        } else {
            this.E = 1;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) view);
        } else if (view.getId() == R.id.et_search_keyword) {
            z();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.activity.contact.troop.BaseTroopView
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        super.onDestroy();
        o(this.J);
        o(this.M);
        o(this.N);
        o(this.K);
        o(this.L);
        TroopListAdapter2 troopListAdapter2 = this.G;
        if (troopListAdapter2 != null) {
            troopListAdapter2.destroy();
        }
    }

    @Override // com.tencent.widget.OverScrollViewListener
    public void onNotCompleteVisable(int i3, View view, ListView listView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, Integer.valueOf(i3), view, listView);
        } else {
            this.I.i(v());
        }
    }

    @Override // com.tencent.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i3, int i16, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, absListView, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
        } else if (this.G != null) {
            C(i3);
        }
    }

    @Override // com.tencent.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) absListView, i3);
        }
    }

    @Override // com.tencent.widget.OverScrollViewListener
    public void onViewCompleteVisable(int i3, View view, ListView listView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, this, Integer.valueOf(i3), view, listView);
        } else {
            this.I.d(v());
        }
    }

    @Override // com.tencent.widget.OverScrollViewListener
    public boolean onViewCompleteVisableAndReleased(int i3, View view, ListView listView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Boolean) iPatchRedirector.redirect((short) 14, this, Integer.valueOf(i3), view, listView)).booleanValue();
        }
        this.I.h(v());
        if (!F()) {
            p(103, 1000L);
        }
        return true;
    }

    @Override // com.tencent.widget.OverScrollViewListener
    public void onViewNotCompleteVisableAndReleased(int i3, View view, ListView listView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, this, Integer.valueOf(i3), view, listView);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v9 */
    public void w() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        if (this.G == null) {
            int i3 = this.f181328d.d();
            if (this.U == 3) {
                i3 = 2;
            }
            TroopListAdapter2 troopListAdapter2 = new TroopListAdapter2(f(), this.f181329e, this, this.F, i3, !this.f181328d.e());
            this.G = troopListAdapter2;
            this.F.setAdapter((ListAdapter) troopListAdapter2);
            this.F.setOnScrollGroupFloatingListener(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void y(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, z16);
            return;
        }
        if (z16) {
            B();
        }
        if (this.H) {
            this.H = false;
            if (z16) {
                this.I.l(0);
                p(101, 800L);
            } else {
                this.F.springBackOverScrollHeaderView();
                r(R.string.hqe);
            }
        }
        this.F.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.activity.contact.troop.e
            @Override // java.lang.Runnable
            public final void run() {
                TroopView.this.A();
            }
        }, 1200L);
    }

    public void z() {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        Intent intent = f().getIntent();
        boolean z16 = true;
        if (intent != null && intent.getIntExtra("_key_mode", 0) == 0) {
            z16 = false;
        }
        if (!this.f181328d.e() && z16) {
            i3 = 24;
        } else {
            i3 = 16;
        }
        ContactSearchComponentActivity.V2(f(), null, 8, i3 | 2097152, 21008);
    }
}
