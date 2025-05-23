package com.tencent.mobileqq.login.widget;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import com.tencent.common.config.AppSetting;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.login.al;
import com.tencent.mobileqq.login.dialog.n;
import com.tencent.mobileqq.login.fragment.BaseLoginFragment;
import com.tencent.mobileqq.login.relogin.dialog.AccountManagerComponent;
import com.tencent.mobileqq.login.relogin.fragment.ReLoginFragment;
import com.tencent.mobileqq.loginregister.z;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.o;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.util.aj;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wxapi.IWXAuthApi;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* loaded from: classes15.dex */
public class LoginPageBottomMoreActionsView extends LinearLayout {
    static IPatchRedirector $redirector_;
    private static final int[] T;
    private static final int[] U;
    private static final int[] V;
    private static final int[] W;
    private View.OnClickListener C;
    private View.OnClickListener D;
    private String E;
    private String F;
    private String G;
    private String H;
    private String I;
    private String J;
    private String K;
    private String L;
    private int M;
    private long N;
    private b P;
    private BaseLoginFragment Q;
    private QBaseActivity R;
    private int S;

    /* renamed from: d, reason: collision with root package name */
    private View.OnClickListener f242750d;

    /* renamed from: e, reason: collision with root package name */
    private View.OnClickListener f242751e;

    /* renamed from: f, reason: collision with root package name */
    private View.OnClickListener f242752f;

    /* renamed from: h, reason: collision with root package name */
    private View.OnClickListener f242753h;

    /* renamed from: i, reason: collision with root package name */
    private View.OnClickListener f242754i;

    /* renamed from: m, reason: collision with root package name */
    private View.OnClickListener f242755m;

    /* loaded from: classes15.dex */
    public interface a {
        boolean a();

        void b();
    }

    /* loaded from: classes15.dex */
    public static class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public boolean f242761a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f242762b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f242763c;

        /* renamed from: d, reason: collision with root package name */
        public View.OnClickListener f242764d;

        /* renamed from: e, reason: collision with root package name */
        public View.OnClickListener f242765e;

        /* renamed from: f, reason: collision with root package name */
        public a f242766f;

        /* renamed from: g, reason: collision with root package name */
        public Bundle f242767g;

        public b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
                return;
            }
            this.f242761a = false;
            this.f242762b = false;
            this.f242763c = false;
            this.f242764d = null;
            this.f242765e = null;
            this.f242766f = null;
            this.f242767g = null;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(41257);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
            return;
        }
        T = new int[]{R.id.zdz, R.id.f166313ze2, R.id.ze5, R.id.ze8};
        U = new int[]{R.id.f166312ze1, R.id.f166315ze4, R.id.ze7, R.id.ze_};
        V = new int[]{R.id.f166311ze0, R.id.f166314ze3, R.id.ze6, R.id.ze9};
        W = new int[]{R.id.xek, R.id.xel, R.id.xem, R.id.xen};
    }

    public LoginPageBottomMoreActionsView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) attributeSet);
    }

    private String A() {
        String H = H(R.string.f200454s6);
        BaseLoginFragment baseLoginFragment = this.Q;
        if (baseLoginFragment != null && baseLoginFragment.rh() == 6) {
            return H(R.string.f199974qv);
        }
        return H;
    }

    private Drawable B(int i3) {
        return ContextCompat.getDrawable(this.R, i3);
    }

    private int C(int i3) {
        return T[i3 - 1];
    }

    private int D(int i3) {
        return V[i3 - 1];
    }

    private int E(int i3) {
        return W[i3 - 1];
    }

    private int F(int i3) {
        return U[i3 - 1];
    }

    @NonNull
    private List<Integer> G(@NonNull b bVar) {
        int rh5 = this.Q.rh();
        ArrayList arrayList = new ArrayList();
        if (rh5 == 6) {
            arrayList.add(3);
            if (V()) {
                arrayList.add(5);
            }
            arrayList.add(2);
        }
        if (rh5 == 5 && bVar.f242763c) {
            arrayList.add(3);
        } else {
            arrayList.add(4);
        }
        if (Y() && !bVar.f242761a) {
            arrayList.add(1);
        }
        if (QLog.isDevelopLevel()) {
            QLog.d("LoginPageBottomMoreActionsView", 4, "jumpList=" + arrayList);
        }
        return arrayList;
    }

    private String H(int i3) {
        return this.R.getString(i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void K(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        QLog.d("LoginPageBottomMoreActionsView", 2, "qqLogin clicked");
        ReportController.r(y(), "dc00898", "", "", "0X800C449", "0X800C449", this.Q.uh(), 0, "", "2", o.c(), "");
        Bundle bundle = new Bundle();
        bundle.putAll(this.P.f242767g);
        bundle.putInt("key_uin_input_hint_type", 1);
        this.Q.Hh(5, bundle, false);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void L(int i3, List list, b bVar, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        QBaseActivity qBaseActivity = this.R;
        if (qBaseActivity != null && !qBaseActivity.isFinishing()) {
            ((InputMethodManager) this.R.getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD)).hideSoftInputFromWindow(view.getWindowToken(), 0);
            if (u()) {
                QLog.d("LoginPageBottomMoreActionsView", 4, "fragmentType=" + i3 + " isAccountNumExceedMax");
                new AccountManagerComponent().y(this.R);
            } else {
                ReportController.r(y(), "dc00898", "", "", "0X800C40A", "0X800C40A", this.Q.uh(), 0, "", "", o.c(), "");
                new n(this.R, list, this.Q, bVar.f242766f, A(), this.P.f242767g).show();
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void M(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        QLog.d("LoginPageBottomMoreActionsView", 2, "phoneLogin clicked");
        ReportController.r(y(), "dc00898", "", "", "0X800C459", "0X800C459", this.Q.uh(), 0, "", "2", o.c(), "");
        if (u()) {
            QLog.d("LoginPageBottomMoreActionsView", 1, " isAccountNumExceedMax");
            new AccountManagerComponent().y(this.R);
        } else {
            Bundle bundle = new Bundle();
            bundle.putAll(this.P.f242767g);
            aj.f306554f.s(this.Q, bundle);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void N(String str, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        QLog.d("LoginPageBottomMoreActionsView", 1, "qrCodeLogin clicked");
        if (TextUtils.isEmpty(str)) {
            QLog.e("LoginPageBottomMoreActionsView", 1, "qrCodeURl is null or empty");
        } else {
            QRoute.createNavigator(this.R, RouterConstants.UI_ROUTE_BROWSER).withString("url", z.h(str)).withBoolean("hide_more_button", true).withBoolean("key_from_opensdk_qrcode", true).request();
            X("0X800BA15");
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void O(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        z.t(this.R, "");
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void P(String str, View.OnClickListener onClickListener, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (!U()) {
            QLog.d("LoginPageBottomMoreActionsView", 1, str);
            onClickListener.onClick(view);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void Q(View view, View view2) {
        EventCollector.getInstance().onViewClickedBefore(view2);
        view.performClick();
        EventCollector.getInstance().onViewClicked(view2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void R(a aVar, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (aVar != null) {
            aVar.b();
        }
        new com.tencent.mobileqq.login.dialog.e(this.R, this.f242753h, 1, "").show();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void S(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        J();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void T(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        W();
        EventCollector.getInstance().onViewClicked(view);
    }

    private boolean U() {
        if (w()) {
            return true;
        }
        if (al.b(1).canLogin() && al.b(4).canLogin() && al.b(7).canLogin()) {
            return false;
        }
        QLog.i("LoginPageBottomMoreActionsView", 1, "interceptClick, is login now");
        QQToast.makeText(BaseApplication.getContext(), R.string.f200424s3, 0).show();
        return true;
    }

    private boolean V() {
        String str;
        Intent intent = this.R.getIntent();
        if (intent != null) {
            str = intent.getStringExtra("param_qr_code_url");
        } else {
            str = null;
        }
        return !TextUtils.isEmpty(str);
    }

    private void X(String str) {
        ReportController.o(y(), "dc00898", "", "", str, str, 0, 0, z.g(this.R.getIntent().getStringExtra("appid")), "", z.g(this.R.getIntent().getStringExtra("oauth_app_name")), "");
    }

    private boolean Y() {
        if (!((IWXAuthApi) QRoute.api(IWXAuthApi.class)).isInBlackDeviceList() && com.tencent.mobileqq.wxapi.impl.a.a().f() && !this.Q.Gh() && !this.Q.Fh()) {
            return true;
        }
        return false;
    }

    private void k() {
        this.f242750d = new View.OnClickListener() { // from class: com.tencent.mobileqq.login.widget.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LoginPageBottomMoreActionsView.this.K(view);
            }
        };
        this.E = H(R.string.f200644so);
    }

    private void l(View.OnClickListener onClickListener) {
        this.C = onClickListener;
        this.K = H(R.string.f200164rd);
    }

    private void m(final b bVar) {
        final int rh5 = this.Q.rh();
        final List<Integer> G = G(bVar);
        if (G.isEmpty()) {
            QLog.d("LoginPageBottomMoreActionsView", 4, "addMoreLoginTypeBtn itemList isEmpty");
        } else {
            this.f242752f = new View.OnClickListener() { // from class: com.tencent.mobileqq.login.widget.g
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    LoginPageBottomMoreActionsView.this.L(rh5, G, bVar, view);
                }
            };
            this.G = A();
        }
    }

    private void n() {
        this.f242751e = new View.OnClickListener() { // from class: com.tencent.mobileqq.login.widget.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LoginPageBottomMoreActionsView.this.M(view);
            }
        };
        this.F = H(R.string.f200624sm);
    }

    private void o() {
        String str;
        Intent intent = this.R.getIntent();
        Bundle bundle = null;
        if (intent != null) {
            str = intent.getStringExtra("param_qr_code_url");
        } else {
            str = null;
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (intent != null) {
            bundle = intent.getExtras();
        }
        final String k3 = com.tencent.open.agent.util.g.k(bundle, str);
        X("0X800BA14");
        this.D = new View.OnClickListener() { // from class: com.tencent.mobileqq.login.widget.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LoginPageBottomMoreActionsView.this.N(k3, view);
            }
        };
        this.L = H(R.string.f200664sq);
    }

    private void p(View.OnClickListener onClickListener) {
        this.f242754i = onClickListener;
        this.I = H(R.string.f200564sg);
    }

    private void q(b bVar) {
        View.OnClickListener onClickListener = bVar.f242764d;
        if (onClickListener == null) {
            this.f242753h = new View.OnClickListener() { // from class: com.tencent.mobileqq.login.widget.h
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    LoginPageBottomMoreActionsView.this.O(view);
                }
            };
        } else {
            this.f242753h = onClickListener;
        }
        this.H = H(R.string.f200594sj);
    }

    private void r(int i3) {
        if (i3 == 2) {
            for (int i16 = 1; i16 <= 3; i16++) {
                View findViewById = findViewById(E(i16));
                findViewById.setVisibility(0);
                ViewGroup.LayoutParams layoutParams = findViewById.getLayoutParams();
                if (layoutParams instanceof LinearLayout.LayoutParams) {
                    ((LinearLayout.LayoutParams) layoutParams).weight = 1.0f;
                }
            }
        }
    }

    private void s(final View.OnClickListener onClickListener, Drawable drawable, String str, final String str2) {
        if (onClickListener != null) {
            int i3 = this.S + 1;
            this.S = i3;
            if (i3 > 4) {
                return;
            }
            final View findViewById = findViewById(D(i3));
            View findViewById2 = findViewById(C(this.S));
            findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.login.widget.i
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    LoginPageBottomMoreActionsView.this.P(str2, onClickListener, view);
                }
            });
            findViewById2.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.login.widget.j
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    LoginPageBottomMoreActionsView.Q(findViewById, view);
                }
            });
            int dpToPx = ViewUtils.dpToPx(40.0f);
            x(findViewById, dpToPx, dpToPx, dpToPx, dpToPx);
            ((TextView) findViewById(F(this.S))).setText(str);
            ImageView imageView = (ImageView) findViewById(D(this.S));
            imageView.setImageDrawable(drawable);
            imageView.setBackground(z());
        }
    }

    private void t(int i3) {
        int i16;
        this.S = 0;
        View.OnClickListener onClickListener = this.f242750d;
        if (onClickListener != null) {
            s(onClickListener, B(R.drawable.oh_), this.E, "onClick QqLoginBtn");
        } else {
            View.OnClickListener onClickListener2 = this.f242751e;
            if (onClickListener2 != null) {
                s(onClickListener2, B(R.drawable.qui_phone), this.F, "onClick PhoneLoginBtn");
            }
        }
        View.OnClickListener onClickListener3 = this.D;
        if (onClickListener3 != null) {
            s(onClickListener3, B(R.drawable.qui_qrcode), this.L, "onClick QrCodeLogin");
        }
        View.OnClickListener onClickListener4 = this.f242752f;
        if (onClickListener4 != null) {
            s(onClickListener4, B(R.drawable.qui_user), this.G, "onClick ChangeLoginTypeBtn");
        }
        if (this.S <= 1) {
            this.I = H(R.string.f200574sh);
            this.J = H(R.string.f200444s5);
        }
        s(this.f242754i, B(R.drawable.qui_add), this.I, "onClick RegisterNewAccount");
        View.OnClickListener onClickListener5 = this.f242755m;
        if (onClickListener5 == null) {
            s(this.f242753h, B(R.drawable.qui_lock), this.H, "onClick RetrievePassword");
        } else {
            s(onClickListener5, B(R.drawable.qui_more), this.J, "onClick MoreActions");
        }
        s(this.C, B(R.drawable.qui_question_mark_circle), this.K, "onClick CommonProblems");
        if (this.S < 4) {
            if (this.Q instanceof ReLoginFragment) {
                i16 = 67;
            } else {
                i16 = 48;
            }
        } else {
            i16 = 30;
        }
        float min = Math.min(1.0f, (i3 * 1.0f) / ViewUtils.dpToPx(360.0f));
        int dip2px = (int) (ViewUtils.dip2px(i16) * min);
        findViewById(R.id.zdw).setPadding(dip2px, 0, dip2px, 0);
        for (int i17 = 1; i17 <= 4; i17++) {
            View findViewById = findViewById(C(i17));
            View findViewById2 = findViewById(E(i17));
            if (this.S < i17) {
                findViewById.setVisibility(8);
                findViewById2.setVisibility(8);
            } else {
                findViewById.setVisibility(0);
                findViewById2.setVisibility(0);
                ViewGroup.LayoutParams layoutParams = findViewById.getLayoutParams();
                layoutParams.width = (int) (ViewUtils.dpToPx(75.0f) * min);
                findViewById.setLayoutParams(layoutParams);
                ImageView imageView = (ImageView) findViewById(D(i17));
                int dpToPx = (int) (ViewUtils.dpToPx(48.0f) * min);
                int dpToPx2 = (int) (ViewUtils.dpToPx(14.0f) * min);
                ViewGroup.LayoutParams layoutParams2 = imageView.getLayoutParams();
                layoutParams2.height = dpToPx;
                layoutParams2.width = dpToPx;
                imageView.setLayoutParams(layoutParams2);
                imageView.setPadding(dpToPx2, dpToPx2, dpToPx2, dpToPx2);
                TextView textView = (TextView) findViewById(F(i17));
                textView.setTextSize(12.0f * min);
                if (AppSetting.f99565y) {
                    AccessibilityUtil.n(imageView, false);
                    AccessibilityUtil.n(textView, false);
                    AccessibilityUtil.n(findViewById, true);
                    AccessibilityUtil.p(findViewById, textView.getText());
                }
            }
        }
        r(this.S);
        if (this.S > 4) {
            QLog.e("LoginPageBottomMoreActionsView", 4, "mCountValidButtons > 4, some buttons hide");
        }
    }

    private boolean u() {
        BaseLoginFragment baseLoginFragment = this.Q;
        if (baseLoginFragment != null && baseLoginFragment.Fh()) {
            return false;
        }
        return Utils.F();
    }

    private void v(final a aVar) {
        if (this.f242753h == null) {
            QLog.e("LoginPageBottomMoreActionsView", 4, "mRetrievePasswordOnClickListener == null");
        } else {
            this.f242755m = new View.OnClickListener() { // from class: com.tencent.mobileqq.login.widget.c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    LoginPageBottomMoreActionsView.this.R(aVar, view);
                }
            };
            this.J = H(R.string.f200434s4);
        }
    }

    private boolean w() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.N < 500) {
            return true;
        }
        this.N = currentTimeMillis;
        return false;
    }

    private static void x(View view, int i3, int i16, int i17, int i18) {
        if (view == null) {
            return;
        }
        view.postDelayed(new Runnable(view, i3, i16, i17, i18) { // from class: com.tencent.mobileqq.login.widget.LoginPageBottomMoreActionsView.1
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ View f242756d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ int f242757e;

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ int f242758f;

            /* renamed from: h, reason: collision with root package name */
            final /* synthetic */ int f242759h;

            /* renamed from: i, reason: collision with root package name */
            final /* synthetic */ int f242760i;

            {
                this.f242756d = view;
                this.f242757e = i3;
                this.f242758f = i16;
                this.f242759h = i17;
                this.f242760i = i18;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, view, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                Rect rect = new Rect();
                this.f242756d.setEnabled(true);
                this.f242756d.getHitRect(rect);
                rect.top -= this.f242757e;
                rect.bottom += this.f242758f;
                rect.left -= this.f242759h;
                rect.right += this.f242760i;
                if (QLog.isColorLevel()) {
                    QLog.d("TouchDelegate", 2, " bounds.top=" + rect.top + "bounds.bottom=" + rect.bottom);
                }
                TouchDelegate touchDelegate = new TouchDelegate(rect, this.f242756d);
                if (this.f242756d.getParent() instanceof View) {
                    ((View) this.f242756d.getParent()).setTouchDelegate(touchDelegate);
                }
            }
        }, 500L);
    }

    private AppRuntime y() {
        AppRuntime appRuntime = this.R.getAppRuntime();
        if (appRuntime == null) {
            return MobileQQ.sMobileQQ.peekAppRuntime();
        }
        return appRuntime;
    }

    private Drawable z() {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(1);
        gradientDrawable.setStroke(ViewUtils.dpToPx(1.0f), ContextCompat.getColorStateList(this.R, R.color.qui_common_border_standard));
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setShape(1);
        gradientDrawable2.setColor(ContextCompat.getColorStateList(this.R, R.color.qui_common_overlay_light));
        gradientDrawable2.setStroke(ViewUtils.dpToPx(1.0f), ContextCompat.getColorStateList(this.R, R.color.qui_common_border_standard));
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{android.R.attr.state_pressed}, gradientDrawable2);
        stateListDrawable.addState(new int[0], gradientDrawable);
        return stateListDrawable;
    }

    public void I(BaseLoginFragment baseLoginFragment, @NonNull b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) baseLoginFragment, (Object) bVar);
            return;
        }
        this.P = bVar;
        this.Q = baseLoginFragment;
        this.R = baseLoginFragment.getQBaseActivity();
        if (this.Q.sh() == 3) {
            this.M = 3;
        } else {
            this.M = 1;
        }
        int rh5 = this.Q.rh();
        if (rh5 != 3 && rh5 != 4) {
            if (rh5 == 5) {
                n();
            }
        } else {
            k();
        }
        m(bVar);
        if (bVar.f242761a) {
            QLog.d("LoginPageBottomMoreActionsView", 2, "init fromWxLogin");
            q(bVar);
            l(new View.OnClickListener() { // from class: com.tencent.mobileqq.login.widget.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    LoginPageBottomMoreActionsView.this.S(view);
                }
            });
        } else {
            boolean V2 = V();
            if (rh5 != 6 && V2) {
                o();
            }
            if (!this.Q.Gh() && !this.Q.Fh() && !V2) {
                View.OnClickListener onClickListener = bVar.f242765e;
                if (onClickListener == null) {
                    onClickListener = new View.OnClickListener() { // from class: com.tencent.mobileqq.login.widget.b
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            LoginPageBottomMoreActionsView.this.T(view);
                        }
                    };
                }
                p(onClickListener);
            }
            q(bVar);
            v(bVar.f242766f);
        }
        t(ViewUtils.getScreenWidth());
    }

    public void J() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        QBaseActivity qBaseActivity = this.R;
        if (qBaseActivity != null && !qBaseActivity.isFinishing()) {
            QLog.d("LoginPageBottomMoreActionsView", 1, "commonProblem url is ", "https://kf.qq.com/touch/product/mobileqq_qqmp.html#showmenu=1007457");
            Intent intent = new Intent();
            intent.putExtra("uin", y().getAccount());
            intent.putExtra("url", "https://kf.qq.com/touch/product/mobileqq_qqmp.html#showmenu=1007457");
            z.z(this.R, intent, RouterConstants.UI_ROUTE_BROWSER);
        }
    }

    public void W() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        QBaseActivity qBaseActivity = this.R;
        if (qBaseActivity != null && !qBaseActivity.isFinishing()) {
            if (Utils.F()) {
                new AccountManagerComponent().y(this.R);
            } else if (!NetworkUtil.isNetworkAvailable()) {
                QQToast.makeText(this.R, H(R.string.f171137ci2), 1, 0).show();
            } else {
                com.tencent.mobileqq.register.n.f280469a.m(this.R, this.M, null, true, false, false, false);
            }
        }
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) configuration);
        } else {
            super.onConfigurationChanged(configuration);
            t(ViewUtils.getScreenWidthByContext(BaseApplication.getContext()));
        }
    }

    public LoginPageBottomMoreActionsView(Context context, AttributeSet attributeSet, int i3) {
        this(context, attributeSet, i3, 0);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, context, attributeSet, Integer.valueOf(i3));
    }

    public LoginPageBottomMoreActionsView(Context context, AttributeSet attributeSet, int i3, int i16) {
        super(context, attributeSet, i3, i16);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        this.E = "";
        this.F = "";
        this.G = "";
        this.H = "";
        this.I = "";
        this.J = "";
        this.K = "";
        this.L = "";
        this.N = 0L;
        LayoutInflater.from(context).inflate(R.layout.fgf, this);
    }
}
