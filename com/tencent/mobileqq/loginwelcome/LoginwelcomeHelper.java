package com.tencent.mobileqq.loginwelcome;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQTranslucentBrowserActivity;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.loginwelcome.LoginUserGuideHelper;
import com.tencent.mobileqq.loginwelcome.LoginWelcomeManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.soso.location.api.ILbsManagerServiceApi;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.sdk.launcher.ipc.IPCConst;
import com.tencent.widget.ThemeImageView;
import com.tencent.widget.ThemeImageWrapper;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes15.dex */
public class LoginwelcomeHelper {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private ViewGroup f243105a;

    /* renamed from: b, reason: collision with root package name */
    Conversation f243106b;

    /* renamed from: c, reason: collision with root package name */
    ViewGroup f243107c;

    /* renamed from: d, reason: collision with root package name */
    private volatile boolean f243108d;

    /* renamed from: e, reason: collision with root package name */
    private LoginUserGuideHelper.a f243109e;

    /* renamed from: f, reason: collision with root package name */
    LoginWelcomeManager.m f243110f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public class a implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) LoginwelcomeHelper.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                LoginwelcomeHelper.this.m();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public class b implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Activity f243115d;

        b(Activity activity) {
            this.f243115d = activity;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) LoginwelcomeHelper.this, (Object) activity);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                LoginUserGuideHelper.a(this.f243115d, LoginwelcomeHelper.this.f243106b.getApp(), LoginwelcomeHelper.this.f243109e);
                LoginwelcomeHelper.this.m();
                ReportController.o(LoginwelcomeHelper.this.f243106b.app, "dc00898", "", "", "0X8009F4A", "0X8009F4A", 2, 0, "2", "", "", "");
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public class c implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Activity f243117d;

        c(Activity activity) {
            this.f243117d = activity;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) LoginwelcomeHelper.this, (Object) activity);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                LoginUserGuideHelper.b(this.f243117d, LoginwelcomeHelper.this.f243106b.getApp(), LoginwelcomeHelper.this.f243109e);
                LoginwelcomeHelper.this.m();
                ReportController.o(LoginwelcomeHelper.this.f243106b.app, "dc00898", "", "", "0X8009F4A", "0X8009F4A", 1, 0, "1", "", "", "");
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public LoginwelcomeHelper(Conversation conversation, ViewGroup viewGroup) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) conversation, (Object) viewGroup);
            return;
        }
        this.f243108d = true;
        this.f243110f = new LoginWelcomeManager.m() { // from class: com.tencent.mobileqq.loginwelcome.LoginwelcomeHelper.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) LoginwelcomeHelper.this);
                }
            }

            @Override // com.tencent.mobileqq.loginwelcome.LoginWelcomeManager.m
            public void a(LoginWelcomeManager.j jVar) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 3)) {
                    iPatchRedirector2.redirect((short) 3, (Object) this, (Object) jVar);
                    return;
                }
                if (QLog.isColorLevel()) {
                    QLog.d("LoginWelcomeManager", 2, "onShowCommonGuideWeb");
                }
                LoginwelcomeHelper.this.q(jVar);
            }

            @Override // com.tencent.mobileqq.loginwelcome.LoginWelcomeManager.m
            public void b(URLDrawable uRLDrawable) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) uRLDrawable);
                    return;
                }
                if (QLog.isColorLevel()) {
                    QLog.d("LoginWelcomeManager", 2, "onShowContactsGuideLayer");
                }
                if (LoginwelcomeHelper.this.f243105a != null) {
                    LoginwelcomeHelper.this.f243105a.post(new Runnable(uRLDrawable) { // from class: com.tencent.mobileqq.loginwelcome.LoginwelcomeHelper.1.1
                        static IPatchRedirector $redirector_;

                        /* renamed from: d, reason: collision with root package name */
                        final /* synthetic */ URLDrawable f243112d;

                        {
                            this.f243112d = uRLDrawable;
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                iPatchRedirector3.redirect((short) 1, (Object) this, (Object) AnonymousClass1.this, (Object) uRLDrawable);
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 == null || !iPatchRedirector3.hasPatch((short) 2)) {
                                LoginwelcomeHelper.this.l(this.f243112d);
                            } else {
                                iPatchRedirector3.redirect((short) 2, (Object) this);
                            }
                        }
                    });
                }
            }
        };
        this.f243106b = conversation;
        this.f243105a = viewGroup;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        if (QLog.isColorLevel()) {
            QLog.d("LoginWelcomeManager", 2, String.format("isFirstLoginEnter=%s, shouldCheckOnResume=%s", Boolean.valueOf(this.f243108d), Boolean.valueOf(p())));
        }
        if (!this.f243108d && p()) {
            Conversation conversation = this.f243106b;
            if (conversation.app != null) {
                LoginWelcomeManager o16 = LoginWelcomeManager.o(conversation.getApp());
                o16.Y();
                if (o16.W) {
                    o16.X();
                }
                if (o16.X) {
                    o16.W();
                }
            }
        }
        this.f243108d = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(URLDrawable uRLDrawable) {
        if (QLog.isColorLevel()) {
            QLog.d("LoginWelcomeManager", 2, "realShowContactsGuideLayer");
        }
        if (!this.f243106b.isForeground()) {
            if (QLog.isColorLevel()) {
                QLog.d("LoginWelcomeManager", 2, "mConversation is not Foreground");
                return;
            }
            return;
        }
        ViewGroup viewGroup = this.f243105a;
        if (viewGroup != null && viewGroup.findViewById(R.id.b8e) == null && uRLDrawable != null && uRLDrawable.getStatus() == 1 && this.f243106b.app != null) {
            if (this.f243107c == null) {
                ViewGroup viewGroup2 = (ViewGroup) LayoutInflater.from(this.f243105a.getContext()).inflate(R.layout.f167822im, (ViewGroup) null);
                this.f243107c = viewGroup2;
                ImageView imageView = (ImageView) viewGroup2.findViewById(R.id.aze);
                imageView.setContentDescription(HardCodeUtil.qqStr(R.string.nvg));
                imageView.setOnClickListener(new a());
                QBaseActivity activity = this.f243106b.getActivity();
                Button button = (Button) this.f243107c.findViewById(R.id.can);
                button.setContentDescription(this.f243106b.getActivity().getString(R.string.fc5));
                button.setOnClickListener(new b(activity));
                TextView textView = (TextView) this.f243107c.findViewById(R.id.bnp);
                textView.setContentDescription(activity.getString(R.string.f171490fc4));
                textView.setOnClickListener(new c(activity));
                ThemeImageView themeImageView = (ThemeImageView) this.f243107c.findViewById(R.id.b9m);
                themeImageView.setMaskShape(ThemeImageWrapper.MODE_SQURE);
                themeImageView.setImageDrawable(uRLDrawable);
            }
            this.f243105a.removeView(this.f243107c);
            this.f243105a.addView(this.f243107c);
            LoginWelcomeManager.O(this.f243106b.getApp());
            LoginWelcomeManager o16 = LoginWelcomeManager.o(this.f243106b.getApp());
            o16.W = false;
            o16.f243075e = true;
            o(this.f243105a.getContext());
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("LoginWelcomeManager", 2, "view repeat or mDragHost==null or drawable status wrong");
        }
    }

    private void o(Context context) {
        boolean z16;
        if (context.checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") != 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (QLog.isColorLevel()) {
            QLog.i("LoginUserGuideHelper", 2, String.format("requestLocation [%s, %s]", Boolean.valueOf(z16), true));
        }
        if (this.f243109e == null) {
            LoginUserGuideHelper.a aVar = new LoginUserGuideHelper.a("Login.Guide");
            this.f243109e = aVar;
            aVar.observerOnUiThread = true;
        }
        if (!z16) {
            ((ILbsManagerServiceApi) QRoute.api(ILbsManagerServiceApi.class)).startLocation(this.f243109e);
        }
    }

    private boolean p() {
        LoginWelcomeManager o16 = LoginWelcomeManager.o(this.f243106b.getApp());
        if (!o16.W && !o16.X) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q(LoginWelcomeManager.j jVar) {
        if (!this.f243106b.isForeground()) {
            if (QLog.isColorLevel()) {
                QLog.d("LoginWelcomeManager", 2, "mConversation is not Foreground");
                return;
            }
            return;
        }
        if (TextUtils.isEmpty(jVar.f243094b)) {
            if (QLog.isColorLevel()) {
                QLog.d("LoginWelcomeManager", 2, "Bad url: " + jVar.f243094b);
                return;
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("LoginWelcomeManager", 2, "show common guide web");
        }
        BaseActivity baseActivity = BaseActivity.sTopActivity;
        Intent intent = new Intent(baseActivity, (Class<?>) QQTranslucentBrowserActivity.class);
        intent.putExtra("url", jVar.f243094b);
        intent.putExtra(QQTranslucentBrowserActivity.FLAG_SHOW_LOADING_DIALOG, false);
        intent.putExtra(IPCConst.KEY_HIDE_LEFT_BUTTON, true);
        intent.setData(Uri.parse(jVar.f243094b));
        baseActivity.startActivity(intent);
        LoginWelcomeManager o16 = LoginWelcomeManager.o(this.f243106b.getApp());
        o16.X = false;
        o16.f243075e = true;
        LoginWelcomeManager.N(this.f243106b.getApp(), jVar.f243093a);
    }

    public void f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        AppRuntime appRuntime = this.f243106b.app;
        if (appRuntime != null) {
            ((LoginWelcomeManager) appRuntime.getManager(QQManagerFactory.LOGIN_WELCOME_MANAGER)).U(this.f243110f);
        }
    }

    public void h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        m();
        n();
        this.f243108d = true;
    }

    public void i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        } else {
            m();
            n();
        }
    }

    public void j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.loginwelcome.LoginwelcomeHelper.2
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) LoginwelcomeHelper.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                        LoginwelcomeHelper.this.g();
                    } else {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                }
            }, 16, null, true);
        }
    }

    public void k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else {
            LoginWelcomeManager.B(this.f243106b.getApp());
        }
    }

    public void m() {
        ViewGroup viewGroup;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("LoginWelcomeManager", 2, "removeContactsGuidelayer");
        }
        ViewGroup viewGroup2 = this.f243105a;
        if (viewGroup2 != null && (viewGroup = this.f243107c) != null) {
            viewGroup2.removeView(viewGroup);
        }
        this.f243107c = null;
    }

    public void n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        AppRuntime appRuntime = this.f243106b.app;
        if (appRuntime != null) {
            ((LoginWelcomeManager) appRuntime.getManager(QQManagerFactory.LOGIN_WELCOME_MANAGER)).U(null);
        }
        if (this.f243109e != null) {
            ((ILbsManagerServiceApi) QRoute.api(ILbsManagerServiceApi.class)).removeListener(this.f243109e);
            this.f243109e = null;
        }
    }
}
