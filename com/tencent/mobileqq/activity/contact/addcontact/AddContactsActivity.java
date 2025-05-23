package com.tencent.mobileqq.activity.contact.addcontact;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentManager;
import com.qzone.proxy.personalitycomponent.model.WidgetCacheConstellationData;
import com.tencent.biz.pubaccount.api.IPublicAccountDetailReportUtil;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.contact.addcontact.ContactBaseView;
import com.tencent.mobileqq.activity.contact.addcontact.findtroop.exp.ExpTroopView;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pad.LaunchMode;
import com.tencent.mobileqq.profilecard.api.IProfileCardConst;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqguildsdk.tianjige.IQQOpenTelemetryReportApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.relation.api.IAddFriendTempApi;
import com.tencent.mobileqq.search.activity.ActiveEntitySearchActivity;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.studymode.StudyModeManager;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.adv.fragment.AdHippyFragment;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.shadow.dynamic.host.Constant;
import com.tencent.theme.TextHook;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.qzone.report.lp.LpReport_UserInfo_dc02148;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes10.dex */
public class AddContactsActivity extends BaseActivity implements View.OnClickListener {
    static IPatchRedirector $redirector_;

    /* renamed from: u0, reason: collision with root package name */
    private static final HashMap<String, String> f180666u0;

    /* renamed from: a0, reason: collision with root package name */
    private ContactBaseView f180667a0;

    /* renamed from: b0, reason: collision with root package name */
    private AddContactsView f180668b0;

    /* renamed from: c0, reason: collision with root package name */
    private ExpTroopView f180669c0;

    /* renamed from: d0, reason: collision with root package name */
    private FrameLayout f180670d0;

    /* renamed from: e0, reason: collision with root package name */
    private RadioGroup f180671e0;

    /* renamed from: f0, reason: collision with root package name */
    private RadioButton f180672f0;

    /* renamed from: g0, reason: collision with root package name */
    private RadioButton f180673g0;

    /* renamed from: h0, reason: collision with root package name */
    private RadioButton f180674h0;

    /* renamed from: i0, reason: collision with root package name */
    private TextView f180675i0;

    /* renamed from: j0, reason: collision with root package name */
    private ImageView f180676j0;

    /* renamed from: k0, reason: collision with root package name */
    private boolean f180677k0;

    /* renamed from: l0, reason: collision with root package name */
    private boolean f180678l0;

    /* renamed from: m0, reason: collision with root package name */
    private boolean f180679m0;

    /* renamed from: n0, reason: collision with root package name */
    LinearLayout f180680n0;

    /* renamed from: o0, reason: collision with root package name */
    RelativeLayout f180681o0;

    /* renamed from: p0, reason: collision with root package name */
    boolean f180682p0;

    /* renamed from: q0, reason: collision with root package name */
    private boolean f180683q0;

    /* renamed from: r0, reason: collision with root package name */
    private RadioGroup.OnCheckedChangeListener f180684r0;

    /* renamed from: s0, reason: collision with root package name */
    ContactBaseView.a f180685s0;

    /* renamed from: t0, reason: collision with root package name */
    Handler f180686t0;

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class a implements RadioGroup.OnCheckedChangeListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AddContactsActivity.this);
            }
        }

        @Override // android.widget.RadioGroup.OnCheckedChangeListener
        public void onCheckedChanged(RadioGroup radioGroup, int i3) {
            EventCollector.getInstance().onRadioGroupCheckedBefore(radioGroup, i3);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) radioGroup, i3);
            } else {
                int i16 = 8;
                if (i3 == R.id.dx6 && AddContactsActivity.this.f180672f0.isChecked()) {
                    AddContactsActivity.this.T2();
                    if (AddContactsActivity.this.f180672f0.isPressed()) {
                        ReportController.o(AddContactsActivity.this.app, "CliOper", "", "", "0X8004BE9", "0X8004BE9", 0, 0, "", "", "", "");
                    }
                    if (!AppSetting.f99565y) {
                        AddContactsActivity.this.f180672f0.setSelected(true);
                        AddContactsActivity.this.f180673g0.setSelected(false);
                        AddContactsActivity.this.f180674h0.setSelected(false);
                    }
                    AddContactsActivity.this.f180676j0.setVisibility(8);
                } else if (i3 == R.id.dxb && AddContactsActivity.this.f180673g0.isChecked()) {
                    if (!StudyModeManager.w()) {
                        AddContactsActivity.this.U2();
                        ReportController.o(AddContactsActivity.this.app, "CliOper", "", "", "0X8004BEA", "0X8004BEA", 0, 0, "", "", "", "");
                        ReportController.o(AddContactsActivity.this.app, "P_CliOper", "Grp_find", "", "grptab", "exp", 0, 0, "", "", "", "");
                        if (!AppSetting.f99565y) {
                            AddContactsActivity.this.f180673g0.setSelected(true);
                            AddContactsActivity.this.f180672f0.setSelected(false);
                            AddContactsActivity.this.f180674h0.setSelected(false);
                        }
                        ImageView imageView = AddContactsActivity.this.f180676j0;
                        if (AddContactsActivity.this.f180677k0) {
                            i16 = 0;
                        }
                        imageView.setVisibility(i16);
                    } else {
                        radioGroup.check(R.id.dx6);
                        com.tencent.mobileqq.guild.util.qqui.g.c(0, R.string.f214315sk);
                    }
                }
            }
            EventCollector.getInstance().onRadioGroupChecked(radioGroup, i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class b implements ContactBaseView.a {
        static IPatchRedirector $redirector_;

        /* compiled from: P */
        /* loaded from: classes10.dex */
        class a implements ValueAnimator.AnimatorUpdateListener {
            static IPatchRedirector $redirector_;

            a() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) b.this);
                }
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) valueAnimator);
                }
            }
        }

        /* compiled from: P */
        /* renamed from: com.tencent.mobileqq.activity.contact.addcontact.AddContactsActivity$b$b, reason: collision with other inner class name */
        /* loaded from: classes10.dex */
        class C7142b extends com.tencent.mobileqq.widget.f {
            static IPatchRedirector $redirector_;

            C7142b() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) b.this);
                }
            }

            private int e() {
                Intent intent = AddContactsActivity.this.getIntent();
                if (intent != null) {
                    int intExtra = intent.getIntExtra("entrance_data_report", 0);
                    if (intExtra != 1) {
                        if (intExtra != 2) {
                            if (intExtra != 3) {
                                return 89;
                            }
                            return 85;
                        }
                        return 84;
                    }
                    return 83;
                }
                return -1;
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                    iPatchRedirector.redirect((short) 4, (Object) this, (Object) animator);
                }
            }

            @Override // com.tencent.mobileqq.widget.f, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                    iPatchRedirector.redirect((short) 3, (Object) this, (Object) animator);
                    return;
                }
                boolean z16 = true;
                AddContactsActivity.this.f180682p0 = true;
                if (QLog.isColorLevel()) {
                    QLog.d("AddContactsActivity", 2, "click search onAnimationEnd mCurrentView = " + AddContactsActivity.this.f180667a0);
                }
                if (AddContactsActivity.this.f180667a0 instanceof AddContactsView) {
                    int e16 = e();
                    ArrayList<String> p16 = ((AddContactsView) AddContactsActivity.this.f180667a0).p();
                    ((AddContactsView) AddContactsActivity.this.f180667a0).w();
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("AddContactsView.getHintWords is null:");
                    if (p16 != null) {
                        z16 = false;
                    }
                    sb5.append(z16);
                    QLog.d("AddContactsActivity", 2, sb5.toString());
                    ActiveEntitySearchActivity.e3(AddContactsActivity.this, HardCodeUtil.qqStr(R.string.f172669t74), new long[]{1001, Constant.FROM_ID_UNINSTALL_PLUGIN}, 99, e16, p16, "QQ\u53f7/QID/\u624b\u673a\u53f7/\u7fa4");
                } else {
                    Intent intent = new Intent(AddContactsActivity.this, (Class<?>) SearchContactsActivity.class);
                    intent.putExtra("from_key", AddContactsActivity.this.Q2());
                    intent.putExtra(IProfileCardConst.KEY_FROM_TYPE, 13);
                    AddContactsActivity.this.startActivity(intent);
                }
                AddContactsActivity.this.overridePendingTransition(0, 0);
                com.tencent.qqperf.opt.threadpriority.b.k(false);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                    iPatchRedirector.redirect((short) 5, (Object) this, (Object) animator);
                }
            }

            @Override // com.tencent.mobileqq.widget.f, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) animator);
                }
            }
        }

        /* compiled from: P */
        /* loaded from: classes10.dex */
        class c implements ValueAnimator.AnimatorUpdateListener {
            static IPatchRedirector $redirector_;

            c() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) b.this);
                }
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) valueAnimator);
                }
            }
        }

        /* compiled from: P */
        /* loaded from: classes10.dex */
        class d extends com.tencent.mobileqq.widget.f {
            static IPatchRedirector $redirector_;

            d() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) b.this);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                    iPatchRedirector.redirect((short) 4, (Object) this, (Object) animator);
                }
            }

            @Override // com.tencent.mobileqq.widget.f, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                    iPatchRedirector.redirect((short) 3, (Object) this, (Object) animator);
                } else {
                    AddContactsActivity.this.findViewById(android.R.id.content).setBackgroundDrawable(null);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                    iPatchRedirector.redirect((short) 5, (Object) this, (Object) animator);
                }
            }

            @Override // com.tencent.mobileqq.widget.f, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) animator);
                }
            }
        }

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AddContactsActivity.this);
            }
        }

        @Override // com.tencent.mobileqq.activity.contact.addcontact.ContactBaseView.a
        public void a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this);
                return;
            }
            AddContactsActivity.this.findViewById(R.id.idz).setVisibility(0);
            ValueAnimator ofInt = ValueAnimator.ofInt(-(AddContactsActivity.this.getTitleBarHeight() + 0 + AddContactsActivity.this.f180667a0.a()), 0);
            ofInt.setDuration(10L);
            ofInt.addUpdateListener(new c());
            ofInt.addListener(new d());
            ofInt.start();
        }

        @Override // com.tencent.mobileqq.activity.contact.addcontact.ContactBaseView.a
        public void b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this);
                return;
            }
            AddContactsActivity addContactsActivity = AddContactsActivity.this;
            if (addContactsActivity.f180682p0) {
                return;
            }
            ValueAnimator ofInt = ValueAnimator.ofInt(0, -(addContactsActivity.getTitleBarHeight() + 0 + AddContactsActivity.this.f180667a0.a()));
            ofInt.setDuration(10L);
            ofInt.addUpdateListener(new a());
            ofInt.addListener(new C7142b());
            ofInt.start();
            com.tencent.qqperf.opt.threadpriority.b.k(true);
        }

        @Override // com.tencent.mobileqq.activity.contact.addcontact.ContactBaseView.a
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public BaseActivity getActivity() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (BaseActivity) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return AddContactsActivity.this;
        }

        @Override // com.tencent.mobileqq.activity.contact.addcontact.ContactBaseView.a
        public QQAppInterface getApp() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (QQAppInterface) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return AddContactsActivity.this.app;
        }

        @Override // com.tencent.mobileqq.activity.contact.addcontact.ContactBaseView.a
        public FragmentManager getFragmentManager() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (FragmentManager) iPatchRedirector.redirect((short) 4, (Object) this);
            }
            return AddContactsActivity.this.getSupportFragmentManager();
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class c extends Handler {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AddContactsActivity.this);
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) message);
                return;
            }
            int i3 = message.what;
            if (i3 != 0) {
                if (i3 == 1) {
                    ((IPublicAccountDetailReportUtil) QRoute.api(IPublicAccountDetailReportUtil.class)).setAttrEntrance(300);
                }
            } else {
                AddContactsActivity.this.f180685s0.a();
                AddContactsActivity.this.f180682p0 = false;
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(67789);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 15)) {
            redirector.redirect((short) 15);
        } else {
            f180666u0 = new HashMap<String, String>() { // from class: com.tencent.mobileqq.activity.contact.addcontact.AddContactsActivity.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this);
                        return;
                    }
                    put("study", HardCodeUtil.qqStr(R.string.f212595ny));
                    put(AdHippyFragment.HEALTH_NAME, HardCodeUtil.qqStr(R.string.f212585nx));
                    put("game", HardCodeUtil.qqStr(R.string.f212515nq));
                    put("industry", HardCodeUtil.qqStr(R.string.f212535ns));
                    put("relax", HardCodeUtil.qqStr(R.string.f212565nv));
                    put("welfare", HardCodeUtil.qqStr(R.string.f212605nz));
                    put("interest", HardCodeUtil.qqStr(R.string.f212545nt));
                    put(LpReport_UserInfo_dc02148.CONSTELLATION, HardCodeUtil.qqStr(R.string.f212505np));
                    put("service", HardCodeUtil.qqStr(R.string.f212575nw));
                    put(WidgetCacheConstellationData.HEALTH, HardCodeUtil.qqStr(R.string.f212525nr));
                    put("makeFriends", HardCodeUtil.qqStr(R.string.f212555nu));
                }
            };
        }
    }

    public AddContactsActivity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f180678l0 = false;
        this.f180679m0 = false;
        this.f180683q0 = false;
        this.f180684r0 = new a();
        this.f180685s0 = new b();
        this.f180686t0 = new c();
    }

    private void N2() {
        String upperCase = DeviceInfoMonitor.getModel().toUpperCase();
        if (upperCase.contains("S968T") || upperCase.contains("A0001") || upperCase.contains("B9388") || upperCase.equals("MI 2") || upperCase.contains("LENOVO K900") || upperCase.contains("VIVO X3L")) {
            this.f180671e0.setPadding(0, 0, 0, 0);
        }
        if (QLog.isColorLevel()) {
            QLog.i("AddContactsActivity", 2, "adaptTabContainerPaddingByModel  model = " + upperCase);
        }
    }

    private void R2() {
        ImageView imageView = (ImageView) findViewById(R.id.b9l);
        this.f180676j0 = imageView;
        imageView.setOnClickListener(this);
        try {
            this.f180676j0.setBackgroundResource(R.drawable.qui_search_icon_navigation_02_selector);
        } catch (Exception e16) {
            QLog.d("AddContactsActivity", 1, "search icon qui exception " + e16.getMessage());
            this.f180676j0.setBackgroundResource(R.drawable.f161293u4);
            ((IQQOpenTelemetryReportApi) QRoute.api(IQQOpenTelemetryReportApi.class)).reportEvent("search_qui_exception_report");
        }
    }

    private void S2() {
        LinearLayout linearLayout;
        if (isInMultiWindow() && (linearLayout = this.f180680n0) != null) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) linearLayout.findViewById(R.id.idz).getLayoutParams();
            marginLayoutParams.setMargins(0, ImmersiveUtils.getStatusBarHeight(this) - ViewUtils.dpToPx(9.0f), 0, 0);
            this.f180680n0.findViewById(R.id.idz).setLayoutParams(marginLayoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void T2() {
        if (this.f180668b0 == null) {
            AddContactsView addContactsView = new AddContactsView(this.f180685s0, true, this.f180679m0);
            this.f180668b0 = addContactsView;
            addContactsView.c();
        }
        V2(this.f180668b0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void U2() {
        if (this.f180669c0 == null) {
            ExpTroopView expTroopView = new ExpTroopView(this.f180685s0, this);
            this.f180669c0 = expTroopView;
            expTroopView.c();
        }
        if (getIntent() != null) {
            this.f180669c0.setTroopRecommendType(f180666u0.get(getIntent().getStringExtra("first_classific")));
        }
        V2(this.f180669c0);
        ReportController.o(this.app, "dc00899", "Grp_find_new", "", "grptab", "exp", 0, 0, "", "", "", "");
    }

    private void V2(ContactBaseView contactBaseView) {
        ContactBaseView contactBaseView2 = this.f180667a0;
        if (contactBaseView2 != contactBaseView) {
            if (contactBaseView2 != null) {
                if (isResume()) {
                    this.f180667a0.e();
                }
                this.f180667a0.h();
            }
            this.f180667a0 = contactBaseView;
            if (contactBaseView != null) {
                contactBaseView.g();
                if (isResume()) {
                    this.f180667a0.f();
                }
                this.f180670d0.removeAllViews();
                this.f180670d0.addView(this.f180667a0);
            }
        }
    }

    public static void W2(Activity activity, int i3) {
        Bundle bundle = new Bundle();
        bundle.putInt("tab_index_key", i3);
        ((IAddFriendTempApi) QRoute.api(IAddFriendTempApi.class)).startAddContactsPage(activity, 0, 0, LaunchMode.singleTop, bundle);
    }

    private void Y2() {
        int intExtra = getIntent().getIntExtra("tab_index_key", 0);
        if (intExtra != 0) {
            if (intExtra != 1) {
                if (intExtra == 2) {
                    this.f180674h0.setChecked(true);
                    return;
                }
                return;
            }
            this.f180673g0.setChecked(true);
            return;
        }
        this.f180672f0.setChecked(true);
    }

    private void initData() {
        String b16 = com.tencent.mobileqq.config.c.b(this.app.getCurrentAccountUin(), AppConstants.Preferences.ADD_CONTACT_PAGE_PUBLIC_ACCOUNT_TAB_SWITCH);
        if (QLog.isColorLevel()) {
            QLog.i("addContacts.Activity", 2, "public account switch config is: " + b16);
        }
        if (!TextUtils.isEmpty(b16)) {
            try {
                boolean z16 = true;
                if (new JSONObject(b16).optInt("showPublicTab") != 1) {
                    z16 = false;
                }
                this.f180683q0 = z16;
            } catch (JSONException e16) {
                if (QLog.isDevelopLevel()) {
                    QLog.i("addContacts.Activity", 2, "public account switch config is: " + QLog.getStackTraceString(e16));
                }
            }
        }
    }

    @TargetApi(14)
    private void initView() {
        ((TextView) findViewById(R.id.ivTitleName)).setText(R.string.f170028dd);
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.idz);
        this.f180681o0 = relativeLayout;
        relativeLayout.setOnClickListener(this);
        this.f180680n0 = (LinearLayout) findViewById(R.id.root);
        if (ImmersiveUtils.isSupporImmersive() == 1) {
            this.f180680n0.setFitsSystemWindows(true);
            this.f180680n0.setPadding(0, ImmersiveUtils.getStatusBarHeight(this), 0, 0);
        }
        S2();
        TextView textView = (TextView) findViewById(R.id.ivTitleBtnLeft);
        this.f180675i0 = textView;
        textView.setText("");
        this.f180675i0.setOnClickListener(this);
        this.f180675i0.setContentDescription(getString(R.string.f1787637j));
        if (SimpleUIUtil.isNowElderMode()) {
            int dimensionPixelSize = BaseApplication.getContext().getResources().getDimensionPixelSize(R.dimen.cai);
            this.f180675i0.setMinHeight(dimensionPixelSize);
            this.f180675i0.setMinWidth(dimensionPixelSize);
        }
        R2();
        this.f180671e0 = (RadioGroup) findViewById(R.id.f164014x);
        this.f180672f0 = (RadioButton) findViewById(R.id.dx6);
        this.f180673g0 = (RadioButton) findViewById(R.id.dxb);
        this.f180674h0 = (RadioButton) findViewById(R.id.dx7);
        this.f180671e0.setOnCheckedChangeListener(this.f180684r0);
        N2();
        this.f180674h0.setVisibility(8);
        boolean z16 = getIntent().getExtras().getBoolean("newEntrance", false);
        this.f180679m0 = z16;
        if (z16) {
            this.f180671e0.setVisibility(8);
            TextView textView2 = (TextView) findViewById(R.id.ivTitleName);
            textView2.setText("\u627e\u4eba");
            textView2.setVisibility(0);
        }
        this.f180673g0.setGravity(16);
        this.f180673g0.setBackgroundDrawable(getResources().getDrawable(R.drawable.lk9));
        int paddingRight = this.f180674h0.getPaddingRight();
        if (!TextHook.getInstance().isDefault()) {
            paddingRight = 0;
        }
        this.f180673g0.setPadding(this.f180674h0.getPaddingLeft(), this.f180674h0.getPaddingTop(), paddingRight, this.f180674h0.getPaddingBottom());
        if (SimpleUIUtil.isNowElderMode()) {
            float f16 = 18;
            this.f180672f0.setTextSize(0, ViewUtils.dpToPx(f16));
            this.f180673g0.setTextSize(0, ViewUtils.dpToPx(f16));
            this.f180674h0.setTextSize(0, ViewUtils.dpToPx(f16));
        }
        this.f180670d0 = (FrameLayout) findViewById(R.id.b86);
        P2();
    }

    private void setUpOrientation() {
        if (AppSetting.o(this)) {
            setRequestedOrientation(-1);
        } else {
            setRequestedOrientation(1);
        }
    }

    protected void P2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
            return;
        }
        ColorStateList colorStateList = getResources().getColorStateList(R.color.qui_header_tab_item_color);
        this.f180672f0.setTextColor(colorStateList);
        this.f180673g0.setTextColor(colorStateList);
        this.f180674h0.setTextColor(colorStateList);
        this.f180672f0.setPadding(0, 0, 0, 0);
        this.f180673g0.setPadding(0, 0, 0, 0);
        this.f180674h0.setPadding(0, 0, 0, 0);
        this.f180672f0.setGravity(17);
        this.f180673g0.setGravity(17);
        this.f180674h0.setGravity(17);
    }

    int Q2() {
        ContactBaseView contactBaseView = this.f180667a0;
        if (contactBaseView instanceof AddContactsView) {
            return 0;
        }
        if (contactBaseView instanceof ExpTroopView) {
            return 1;
        }
        return 2;
    }

    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity
    public void doOnActivityResult(int i3, int i16, Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, Integer.valueOf(i3), Integer.valueOf(i16), intent);
            return;
        }
        super.doOnActivityResult(i3, i16, intent);
        ContactBaseView contactBaseView = this.f180667a0;
        if (contactBaseView != null) {
            contactBaseView.b(i3, i16, intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public boolean doOnCreate(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) bundle)).booleanValue();
        }
        if (bundle != null) {
            bundle.putParcelable("android:support:fragments", null);
            Bundle bundle2 = bundle.getBundle("androidx.lifecycle.BundlableSavedStateRegistry.key");
            if (bundle2 != null) {
                bundle2.putParcelable("android:support:fragments", null);
            }
        }
        super.doOnCreate(bundle);
        setUpOrientation();
        super.setContentView(R.layout.aq8);
        getWindow().setBackgroundDrawable(null);
        initData();
        initView();
        Y2();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        AddContactsView addContactsView = this.f180668b0;
        if (addContactsView != null) {
            addContactsView.d();
        }
        ExpTroopView expTroopView = this.f180669c0;
        if (expTroopView != null) {
            expTroopView.d();
        }
        this.f180670d0.removeAllViews();
        super.doOnDestroy();
        ((IPublicAccountDetailReportUtil) QRoute.api(IPublicAccountDetailReportUtil.class)).resetAttribute();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnPause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        super.doOnPause();
        ContactBaseView contactBaseView = this.f180667a0;
        if (contactBaseView != null) {
            contactBaseView.e();
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
        ContactBaseView contactBaseView = this.f180667a0;
        if (contactBaseView != null) {
            contactBaseView.f();
        }
        if (this.f180682p0) {
            this.f180686t0.sendEmptyMessage(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnStart() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        super.doOnStart();
        ContactBaseView contactBaseView = this.f180667a0;
        if (contactBaseView != null) {
            contactBaseView.g();
        }
        this.f180686t0.sendEmptyMessage(1);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnStop() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        super.doOnStop();
        ContactBaseView contactBaseView = this.f180667a0;
        if (contactBaseView != null) {
            contactBaseView.h();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity
    public boolean onBackEvent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this)).booleanValue();
        }
        finish();
        return true;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) view);
        } else {
            int id5 = view.getId();
            if (id5 == R.id.ivTitleBtnLeft) {
                onBackEvent();
            } else if (id5 == R.id.b9l) {
                if (1 == Q2()) {
                    Intent intent = new Intent(this, (Class<?>) SearchContactsActivity.class);
                    intent.putExtra("from_key", Q2());
                    intent.putExtra(IProfileCardConst.KEY_FROM_TYPE, 13);
                    startActivity(intent);
                    overridePendingTransition(0, 0);
                }
            } else if (id5 == R.id.idz) {
                ContactBaseView contactBaseView = this.f180667a0;
                if (contactBaseView instanceof ExpTroopView) {
                    ((ExpTroopView) contactBaseView).k0();
                }
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, com.tencent.mobileqq.app.ISkinCallback, com.tencent.theme.SkinnableActivityProcesser.Callback
    public void onPostThemeChanged() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
        } else {
            super.onPostThemeChanged();
            P2();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity
    public void requestWindowFeature(Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) intent);
        } else {
            requestWindowFeature(1);
        }
    }
}
