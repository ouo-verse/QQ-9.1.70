package com.tencent.mobileqq.trooponline;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.biz.qqstorysave.widget.StoryHomeHorizontalListView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.input.at.InputAtMsgIntent;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.profile.l;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.selectmember.ISelectMemberActivityConstants;
import com.tencent.mobileqq.statistics.q;
import com.tencent.mobileqq.troop.onlinemember.api.ITroopOnlineMemberService;
import com.tencent.mobileqq.troop.robot.api.ITroopRobotService;
import com.tencent.mobileqq.trooponline.a;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.eu;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

/* compiled from: P */
/* loaded from: classes19.dex */
public class TroopOnlineMemberBar implements AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener, StoryHomeHorizontalListView.b {
    static IPatchRedirector $redirector_;
    public static final int R;
    protected RelativeLayout C;
    protected String D;
    protected ValueAnimator E;
    protected ValueAnimator F;
    protected boolean G;
    protected ITroopOnlineMemberService H;
    public int I;
    public int J;
    private int K;
    Animatable L;
    TextView M;
    ViewGroup N;
    private ValueAnimator.AnimatorUpdateListener P;
    private ValueAnimator.AnimatorUpdateListener Q;

    /* renamed from: d, reason: collision with root package name */
    protected QQAppInterface f303240d;

    /* renamed from: e, reason: collision with root package name */
    protected com.tencent.aio.api.runtime.a f303241e;

    /* renamed from: f, reason: collision with root package name */
    protected Context f303242f;

    /* renamed from: h, reason: collision with root package name */
    protected StoryHomeHorizontalListView f303243h;

    /* renamed from: i, reason: collision with root package name */
    protected com.tencent.mobileqq.trooponline.a f303244i;

    /* renamed from: m, reason: collision with root package name */
    protected RelativeLayout f303245m;

    /* compiled from: P */
    /* loaded from: classes19.dex */
    class a implements ValueAnimator.AnimatorUpdateListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopOnlineMemberBar.this);
            }
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            View childAt;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) valueAnimator);
                return;
            }
            Integer num = (Integer) valueAnimator.getAnimatedValue();
            ((RelativeLayout.LayoutParams) TroopOnlineMemberBar.this.f303243h.getLayoutParams()).topMargin = num.intValue();
            TroopOnlineMemberBar.this.f303243h.requestLayout();
            if (num.intValue() >= TroopOnlineMemberBar.this.f303242f.getResources().getDimensionPixelSize(R.dimen.title_bar_height) && AppSetting.f99565y && TroopOnlineMemberBar.this.f303243h.getChildCount() > 0 && (childAt = TroopOnlineMemberBar.this.f303243h.getChildAt(0)) != null) {
                childAt.requestFocusFromTouch();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes19.dex */
    class b implements ValueAnimator.AnimatorUpdateListener {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopOnlineMemberBar.this);
            }
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) valueAnimator);
                return;
            }
            Integer num = (Integer) valueAnimator.getAnimatedValue();
            ((RelativeLayout.LayoutParams) TroopOnlineMemberBar.this.f303243h.getLayoutParams()).topMargin = num.intValue();
            TroopOnlineMemberBar.this.f303243h.requestLayout();
            if (num.intValue() <= (-TroopOnlineMemberBar.R) + TroopOnlineMemberBar.this.f303242f.getResources().getDimensionPixelSize(R.dimen.title_bar_height)) {
                TroopOnlineMemberBar.this.f303243h.setVisibility(8);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(77054);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 13)) {
            redirector.redirect((short) 13);
        } else {
            R = UIUtils.b(BaseApplication.getContext(), 112.0f);
        }
    }

    public TroopOnlineMemberBar(QQAppInterface qQAppInterface, com.tencent.aio.api.runtime.a aVar, RelativeLayout relativeLayout, RelativeLayout relativeLayout2, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, qQAppInterface, aVar, relativeLayout, relativeLayout2, Boolean.valueOf(z16));
            return;
        }
        this.I = 1;
        this.J = 0;
        this.K = 1;
        this.L = null;
        this.M = null;
        this.N = null;
        this.P = new a();
        this.Q = new b();
        this.f303240d = qQAppInterface;
        this.f303241e = aVar;
        this.f303245m = relativeLayout;
        this.C = relativeLayout2;
        this.H = (ITroopOnlineMemberService) qQAppInterface.getRuntimeService(ITroopOnlineMemberService.class, "");
        if (aVar == null) {
            if (QLog.isColorLevel()) {
                QLog.d("TroopOnlineMemberBar", 2, "null == mAioContext");
                return;
            }
            return;
        }
        Fragment c16 = aVar.c();
        if (c16 == null) {
            if (QLog.isColorLevel()) {
                QLog.d("TroopOnlineMemberBar", 2, "null == fragment");
                return;
            }
            return;
        }
        Context context = c16.getContext();
        if (context == null) {
            if (QLog.isColorLevel()) {
                QLog.d("TroopOnlineMemberBar", 2, "null == context");
            }
        } else {
            this.f303242f = context;
            if (z16 && (context instanceof Activity)) {
                this.J = cc2.b.a((Activity) context);
            }
        }
    }

    private void i() {
        if (this.E == null) {
            ValueAnimator ofInt = ValueAnimator.ofInt((-R) + this.f303242f.getResources().getDimensionPixelSize(R.dimen.title_bar_height) + this.J, this.f303242f.getResources().getDimensionPixelSize(R.dimen.title_bar_height) + this.J);
            this.E = ofInt;
            ofInt.setDuration(500L);
            this.E.addUpdateListener(this.P);
        }
        this.E.start();
        this.G = true;
        if (this.I == 2) {
            eu.g("Grp_idol", "Grp_renshu", "exp", 0, 0, this.D);
        } else {
            new q(this.f303240d).i("dc00899").a("Grp_online").f("online_box").d("exp").b(this.D).g();
        }
    }

    private void j() {
        Animatable animatable = this.L;
        if (animatable != null && animatable.isRunning()) {
            this.L.stop();
        }
        TextView textView = this.M;
        if (textView != null) {
            textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            this.M.setVisibility(8);
        }
    }

    @Override // com.tencent.biz.qqstorysave.widget.StoryHomeHorizontalListView.b
    public void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
        }
    }

    @Override // com.tencent.biz.qqstorysave.widget.StoryHomeHorizontalListView.b
    public void b() {
        int i3;
        int i16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        int i17 = this.I;
        if (i17 == 2) {
            i3 = 22;
            i16 = 8;
        } else {
            i3 = 17;
            i16 = 1;
        }
        if (i17 == 3) {
            i16 = 5;
        }
        Intent intent = new Intent();
        intent.putExtra("troop_uin", this.D);
        intent.putExtra(ISelectMemberActivityConstants.PARAM_FROM, i3);
        intent.putExtra(AppConstants.LeftViewText.SELFSET_LEFTVIEWTEXT, HardCodeUtil.qqStr(R.string.f171898lr0));
        intent.putExtra("sort_type", i16);
        RouteUtils.startActivity(this.f303242f, intent, "/troop/memberlist/TroopMemberList");
        if (this.I == 2) {
            eu.g("Grp_idol", "Grp_renshu", "right", 0, 0, this.D);
        } else {
            new q(this.f303240d).i("dc00899").a("Grp_online").f("online_box").d("enter_mberList").b(this.D).g();
        }
    }

    public void e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        RelativeLayout relativeLayout = this.f303245m;
        if (relativeLayout != null) {
            for (int childCount = relativeLayout.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = this.f303245m.getChildAt(childCount);
                ViewGroup viewGroup = this.N;
                if (childAt == viewGroup) {
                    this.f303245m.removeView(viewGroup);
                }
            }
        }
        ValueAnimator valueAnimator = this.E;
        if (valueAnimator != null) {
            valueAnimator.removeUpdateListener(this.P);
        }
        ValueAnimator valueAnimator2 = this.F;
        if (valueAnimator2 != null) {
            valueAnimator2.removeUpdateListener(this.Q);
        }
    }

    public boolean f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
        }
        return this.G;
    }

    public void g(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
            return;
        }
        this.D = str;
        int requestListServiceType = this.H.getRequestListServiceType(str);
        if (requestListServiceType == 3) {
            this.I = 2;
        } else if (requestListServiceType == 5) {
            this.I = 3;
        } else {
            this.I = 1;
        }
    }

    public View h(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (View) iPatchRedirector.redirect((short) 4, (Object) this, i3);
        }
        this.K = i3;
        if (this.N == null) {
            this.N = (ViewGroup) LayoutInflater.from(this.f303242f).inflate(R.layout.f168594ah4, (ViewGroup) null);
        }
        if (this.f303243h == null) {
            StoryHomeHorizontalListView storyHomeHorizontalListView = (StoryHomeHorizontalListView) this.N.findViewById(R.id.k0p);
            this.f303243h = storyHomeHorizontalListView;
            storyHomeHorizontalListView.setOnItemClickListener(this);
            this.f303243h.setOnItemLongClickListener(this);
            this.f303243h.setOnOverScrollRightListener(this);
            if (ThemeUtil.isNowThemeIsNight(this.f303240d, false, null)) {
                this.f303243h.setBackgroundColor(-16445151);
            } else {
                this.f303243h.setBackgroundColor(-436207617);
            }
            com.tencent.mobileqq.trooponline.a aVar = new com.tencent.mobileqq.trooponline.a(this.f303240d, this.D);
            this.f303244i = aVar;
            this.f303243h.setAdapter((ListAdapter) aVar);
            this.f303243h.setDataCount(Integer.MAX_VALUE);
            if (this.f303245m != null) {
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
                layoutParams.addRule(10);
                this.f303245m.addView(this.N, layoutParams);
            }
        }
        j();
        List<com.tencent.mobileqq.troop.onlinemember.data.b> detailMemberListFromCache = ((ITroopOnlineMemberService) this.f303240d.getRuntimeService(ITroopOnlineMemberService.class, "")).getDetailMemberListFromCache(this.D);
        if (detailMemberListFromCache != null && !detailMemberListFromCache.isEmpty()) {
            this.f303244i.setData(detailMemberListFromCache);
            this.f303244i.notifyDataSetChanged();
            this.K = 0;
        } else {
            if (this.M == null) {
                TextView textView = (TextView) this.N.findViewById(R.id.f164192ly);
                this.M = textView;
                if (this.f303245m == null) {
                    ((ViewGroup.MarginLayoutParams) textView.getLayoutParams()).topMargin = 0;
                }
            }
            this.f303244i.b();
            this.f303244i.notifyDataSetChanged();
            ThreadManager.getUIHandler().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.trooponline.TroopOnlineMemberBar.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TroopOnlineMemberBar.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    if (TroopOnlineMemberBar.this.K != 0) {
                        TroopOnlineMemberBar.this.M.setVisibility(0);
                        if (TroopOnlineMemberBar.this.K != 2 && NetworkUtil.isNetworkAvailable(TroopOnlineMemberBar.this.f303242f)) {
                            if (TroopOnlineMemberBar.this.K == 1) {
                                try {
                                    TroopOnlineMemberBar troopOnlineMemberBar = TroopOnlineMemberBar.this;
                                    if (troopOnlineMemberBar.L == null) {
                                        troopOnlineMemberBar.L = (Animatable) troopOnlineMemberBar.f303242f.getResources().getDrawable(R.drawable.f160545jt);
                                    }
                                    TroopOnlineMemberBar.this.M.setText((CharSequence) null);
                                    TroopOnlineMemberBar troopOnlineMemberBar2 = TroopOnlineMemberBar.this;
                                    troopOnlineMemberBar2.M.setCompoundDrawablesWithIntrinsicBounds((Drawable) troopOnlineMemberBar2.L, (Drawable) null, (Drawable) null, (Drawable) null);
                                    TroopOnlineMemberBar.this.L.start();
                                    return;
                                } catch (Exception e16) {
                                    QLog.e("TroopOnlineMemberBar", 4, "show exception, msg = " + e16.getMessage());
                                    return;
                                }
                            }
                            return;
                        }
                        TroopOnlineMemberBar troopOnlineMemberBar3 = TroopOnlineMemberBar.this;
                        int i16 = troopOnlineMemberBar3.I;
                        if (i16 == 1) {
                            troopOnlineMemberBar3.M.setText(R.string.cnw);
                        } else if (i16 == 3) {
                            troopOnlineMemberBar3.M.setText(R.string.ipt);
                        } else {
                            troopOnlineMemberBar3.M.setText(R.string.f173166hp2);
                        }
                        TroopOnlineMemberBar.this.M.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                        Animatable animatable = TroopOnlineMemberBar.this.L;
                        if (animatable != null && animatable.isRunning()) {
                            TroopOnlineMemberBar.this.L.stop();
                        }
                        TroopOnlineMemberBar.this.K = 2;
                    }
                }
            }, 500L);
            if (QLog.isColorLevel()) {
                QLog.i("TroopOnlineMemberBar", 2, "show(), itemList == null || itemList.empty");
            }
        }
        this.f303243h.setVisibility(0);
        if (this.f303245m != null) {
            i();
        }
        return this.N;
    }

    public void k() {
        List<com.tencent.mobileqq.troop.onlinemember.data.b> detailMemberListFromCache;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        if (f() && (detailMemberListFromCache = ((ITroopOnlineMemberService) this.f303240d.getRuntimeService(ITroopOnlineMemberService.class, "")).getDetailMemberListFromCache(this.D)) != null) {
            this.K = 0;
            j();
            this.f303244i.setData(detailMemberListFromCache);
            this.f303244i.notifyDataSetChanged();
        }
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i3, long j3) {
        EventCollector.getInstance().onItemClickBefore(adapterView, view, i3, j3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, adapterView, view, Integer.valueOf(i3), Long.valueOf(j3));
        } else {
            com.tencent.mobileqq.troop.onlinemember.data.b bVar = ((a.b) view.getTag()).f303259f;
            if (bVar != null) {
                if (bVar.f298043a == 2) {
                    eu.g("Grp_idol", "Grp_renshu", "clk", 0, 0, this.D);
                } else {
                    new q(this.f303240d).i("dc00899").a("Grp_online").f("online_box").d("clk_mberHead").b(this.D, bVar.f298045c).g();
                }
                if (!((ITroopRobotService) this.f303240d.getRuntimeService(ITroopRobotService.class, "all")).checkAndProcessJumpRobotPage(this.f303242f, this.D, Long.valueOf(bVar.f298044b).longValue())) {
                    l.d(this.f303240d, (Activity) this.f303242f, this.D, bVar.f298044b, 0, -1);
                }
            }
        }
        EventCollector.getInstance().onItemClick(adapterView, view, i3, j3);
    }

    @Override // android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i3, long j3) {
        EventCollector.getInstance().onItemLongClickBefore(adapterView, view, i3, j3);
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z16 = true;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            z16 = ((Boolean) iPatchRedirector.redirect((short) 10, this, adapterView, view, Integer.valueOf(i3), Long.valueOf(j3))).booleanValue();
        } else {
            boolean isSwitchOn = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("100733", false);
            if (QLog.isColorLevel()) {
                QLog.i("TroopOnlineMemberBar", 2, "onItemLongClick.isLongClickEffect:" + isSwitchOn);
            }
            if (isSwitchOn) {
                a.b bVar = (a.b) view.getTag();
                com.tencent.mobileqq.troop.onlinemember.data.b bVar2 = bVar.f303259f;
                if (this.f303241e == null) {
                    if (QLog.isColorLevel()) {
                        QLog.d("TroopOnlineMemberBar", 2, "null == mAioContext");
                    }
                } else {
                    String str = bVar2.f298044b;
                    String str2 = bVar2.f298049g;
                    if (QLog.isColorLevel()) {
                        QLog.d("TroopOnlineMemberBar", 2, String.format("uin = %s uid = %s ", str, str2));
                    }
                    this.f303241e.e().h(new InputAtMsgIntent.InsertAtMemberSpan(str2, str, bVar.f303258e.getText().toString(), true));
                    new q(this.f303240d).i("dc00899").a("Grp_online").f("online_box").d("press_mberHead").b(this.D, bVar2.f298045c).g();
                }
            }
        }
        EventCollector.getInstance().onItemLongClick(adapterView, view, i3, j3);
        return z16;
    }
}
