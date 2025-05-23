package com.tencent.mobileqq.util;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.biz.qui.noticebar.QUINoticeBarManager;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.activity.recent.bannerprocessor.SecurePhoneChangeNotifyBannerProcessor;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.banner.BannerManager;
import com.tencent.mobileqq.banner.processor.BaseBannerProcessor;
import com.tencent.mobileqq.servlet.LoginVerifyServlet;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.org.pb.oidb_0xe96$RspBody;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ThemeImageWrapper;

/* loaded from: classes20.dex */
public class SecurePhoneBannerManager {

    /* renamed from: h, reason: collision with root package name */
    private static volatile SecurePhoneBannerManager f306490h;

    /* renamed from: a, reason: collision with root package name */
    private String f306491a;

    /* renamed from: b, reason: collision with root package name */
    private String f306492b;

    /* renamed from: c, reason: collision with root package name */
    private String f306493c;

    /* renamed from: d, reason: collision with root package name */
    private String f306494d;

    /* renamed from: e, reason: collision with root package name */
    private int f306495e;

    /* renamed from: f, reason: collision with root package name */
    private int f306496f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f306497g;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes20.dex */
    public class b implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ QQAppInterface f306501d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Context f306502e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ Dialog f306503f;

        b(QQAppInterface qQAppInterface, Context context, Dialog dialog) {
            this.f306501d = qQAppInterface;
            this.f306502e = context;
            this.f306503f = dialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            SecurePhoneBannerManager.this.s(this.f306501d, this.f306502e, 1);
            SecurePhoneBannerManager.this.u(this.f306502e, this.f306503f);
            ReportController.o(this.f306501d, "dc00898", "", "", "0X800B0C7", "0X800B0C7", 0, 0, "", "", "", "");
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes20.dex */
    public class c implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Context f306505d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ QQAppInterface f306506e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ Dialog f306507f;

        c(Context context, QQAppInterface qQAppInterface, Dialog dialog) {
            this.f306505d = context;
            this.f306506e = qQAppInterface;
            this.f306507f = dialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            SecurePhoneBannerManager.this.w(this.f306505d);
            SecurePhoneBannerManager.this.s(this.f306506e, this.f306505d, 2);
            SecurePhoneBannerManager.this.u(this.f306505d, this.f306507f);
            ReportController.o(this.f306506e, "dc00898", "", "", "0X800B0C6", "0X800B0C6", 0, 0, "", "", "", "");
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes20.dex */
    public class e implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Context f306510d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Dialog f306511e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ QQAppInterface f306512f;

        e(Context context, Dialog dialog, QQAppInterface qQAppInterface) {
            this.f306510d = context;
            this.f306511e = dialog;
            this.f306512f = qQAppInterface;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            SecurePhoneBannerManager.this.u(this.f306510d, this.f306511e);
            ReportController.o(this.f306512f, "dc00898", "", "", "0X800B0C8", "0X800B0C8", 0, 0, "", "", "", "");
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes20.dex */
    public class f extends com.tencent.mobileqq.observer.c {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ QQAppInterface f306514d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Context f306515e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f306516f;

        f(QQAppInterface qQAppInterface, Context context, String str) {
            this.f306514d = qQAppInterface;
            this.f306515e = context;
            this.f306516f = str;
        }

        @Override // com.tencent.mobileqq.observer.c
        public void getSecurePhoneSuccess(oidb_0xe96$RspBody oidb_0xe96_rspbody) {
            SecurePhoneBannerManager.this.f306491a = oidb_0xe96_rspbody.str_change_mibao_url.get();
            SecurePhoneBannerManager.this.f306495e = oidb_0xe96_rspbody.uint32_next_access_time.get();
            SecurePhoneBannerManager.this.f306494d = oidb_0xe96_rspbody.str_tips_content.get();
            SecurePhoneBannerManager.this.f306496f = oidb_0xe96_rspbody.uint32_display_flag.get();
            SecurePhoneBannerManager.this.f306492b = oidb_0xe96_rspbody.str_hori_bar_content.get();
            SecurePhoneBannerManager.this.f306493c = oidb_0xe96_rspbody.str_tips_header.get();
            QLog.d("SecurePhoneBannerManager", 1, "getSecurePhoneState, displayTag : ", Integer.valueOf(SecurePhoneBannerManager.this.f306496f));
            if (SecurePhoneBannerManager.this.f306496f == 1) {
                BannerManager.l().O(SecurePhoneChangeNotifyBannerProcessor.f185269d, 2, null);
                SecurePhoneBannerManager.this.f306497g = true;
                ReportController.o(this.f306514d, "dc00898", "", "", "0X800B0C3", "0X800B0C3", 0, 0, "", "", "", "");
                ReportController.r(this.f306514d, "dc00898", "", "", BaseBannerProcessor.TVALUE_SHOW_COMMON, BaseBannerProcessor.TVALUE_SHOW_COMMON, 24, 0, "", "", "", "");
                return;
            }
            com.tencent.mobileqq.utils.p.g(this.f306515e, this.f306516f, true, "sp_key_secure_phone_notice_time", Integer.valueOf(SecurePhoneBannerManager.this.f306495e));
        }
    }

    SecurePhoneBannerManager() {
    }

    private Dialog n(QQAppInterface qQAppInterface, Context context) {
        Dialog c16 = t.c(context, R.style.MenuDialogStyle);
        View inflate = LayoutInflater.from(context).inflate(R.layout.f168790gw4, (ViewGroup) null);
        c16.setContentView(inflate);
        TextView textView = (TextView) inflate.findViewById(R.id.f109656ge);
        TextView textView2 = (TextView) inflate.findViewById(R.id.f10660696);
        TextView textView3 = (TextView) inflate.findViewById(R.id.f1060967s);
        TextView textView4 = (TextView) inflate.findViewById(R.id.k6s);
        LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.f166090ed2);
        textView.setText(this.f306493c);
        textView4.setText(this.f306494d);
        GradientDrawable gradientDrawable = new GradientDrawable();
        float dpToPx = ViewUtils.dpToPx(10.0f);
        gradientDrawable.setCornerRadii(new float[]{dpToPx, dpToPx, dpToPx, dpToPx, 0.0f, 0.0f, 0.0f, 0.0f});
        gradientDrawable.setColor(context.getResources().getColor(R.color.skin_white_bg_color));
        linearLayout.setBackgroundDrawable(gradientDrawable);
        int color = context.getResources().getColor(R.color.skin_mode_normal_border_color);
        if (ThemeImageWrapper.isNightMode()) {
            linearLayout.setBackgroundResource(R.drawable.cf5);
            color = -16777216;
        }
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setCornerRadius(BaseAIOUtils.f(6.0f, context.getResources()));
        textView2.setBackgroundDrawable(gradientDrawable2);
        gradientDrawable2.setColor(color);
        textView3.setOnClickListener(new b(qQAppInterface, context, c16));
        textView2.setOnClickListener(new c(context, qQAppInterface, c16));
        linearLayout.setOnClickListener(new d());
        inflate.setOnClickListener(new e(context, c16, qQAppInterface));
        return c16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void r(QQAppInterface qQAppInterface, Context context, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Dialog n3 = n(qQAppInterface, context);
        n3.show();
        t(context, n3);
        ReportController.o(qQAppInterface, "dc00898", "", "", "0X800B0C4", "0X800B0C4", 0, 0, "", "", "", "");
        ReportController.o(qQAppInterface, "dc00898", "", "", "0X800B0C5", "0X800B0C5", 0, 0, "", "", "", "");
        ReportController.r(qQAppInterface, "dc00898", "", "", BaseBannerProcessor.TVALUE_CLICK_COMMON, BaseBannerProcessor.TVALUE_CLICK_COMMON, 24, 0, "", "", "", "");
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s(QQAppInterface qQAppInterface, final Context context, int i3) {
        QLog.d("SecurePhoneBannerManager", 1, "dismiss banner");
        BannerManager.l().O(SecurePhoneChangeNotifyBannerProcessor.f185269d, 0, null);
        this.f306497g = false;
        com.tencent.mobileqq.utils.p.g(context, qQAppInterface.getAccount(), true, "sp_key_secure_phone_notice_time", Integer.valueOf(this.f306495e));
        if (i3 == 1) {
            ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.util.SecurePhoneBannerManager.6
                @Override // java.lang.Runnable
                public void run() {
                    Context context2 = context;
                    QQToast.makeText(context2, 2, context2.getString(R.string.zvn), 0).show();
                }
            });
        }
        LoginVerifyServlet.b(qQAppInterface, i3, null);
    }

    private void t(Context context, Dialog dialog) {
        if (dialog == null) {
            QLog.e("SecurePhoneBannerManager", 1, "showDialogEnterAnim dialog is null");
            return;
        }
        if (context == null) {
            QLog.e("SecurePhoneBannerManager", 1, "showDialogEnterAnim context is null");
            return;
        }
        LinearLayout linearLayout = (LinearLayout) dialog.findViewById(R.id.f166090ed2);
        if (linearLayout != null) {
            linearLayout.startAnimation(AnimationUtils.loadAnimation(context, R.anim.f155054vc));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(Context context, Dialog dialog) {
        if (dialog == null) {
            QLog.e("SecurePhoneBannerManager", 1, "showDialogExitAnim dialog is null");
            return;
        }
        if (context == null) {
            QLog.e("SecurePhoneBannerManager", 1, "showDialogExitAnim context is null");
            return;
        }
        LinearLayout linearLayout = (LinearLayout) dialog.findViewById(R.id.f166090ed2);
        if (linearLayout != null) {
            Animation loadAnimation = AnimationUtils.loadAnimation(context, R.anim.f155055vd);
            loadAnimation.setAnimationListener(new a(dialog));
            linearLayout.startAnimation(loadAnimation);
        }
    }

    public static SecurePhoneBannerManager v() {
        if (f306490h == null) {
            synchronized (SecurePhoneBannerManager.class) {
                if (f306490h == null) {
                    f306490h = new SecurePhoneBannerManager();
                }
            }
        }
        return f306490h;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(Context context) {
        context.startActivity(new Intent(context, (Class<?>) QQBrowserActivity.class).putExtra("url", this.f306491a));
    }

    public synchronized void o() {
        QLog.d("SecurePhoneBannerManager", 1, "destory");
        f306490h = null;
    }

    public void p(QQAppInterface qQAppInterface, Context context) {
        QLog.d("SecurePhoneBannerManager", 1, "getSecurePhoneState");
        if (qQAppInterface == null) {
            QLog.d("SecurePhoneBannerManager", 1, "getSecurePhoneState, app is null");
            return;
        }
        if (this.f306497g) {
            if (QLog.isColorLevel()) {
                QLog.i("SecurePhoneBannerManager", 2, "getSecurePhoneState, isShowing");
            }
            BannerManager.l().O(SecurePhoneChangeNotifyBannerProcessor.f185269d, 2, null);
            return;
        }
        if (!qQAppInterface.isLogin()) {
            if (QLog.isColorLevel()) {
                QLog.i("SecurePhoneBannerManager", 2, "getSecurePhoneState, but not login");
                return;
            }
            return;
        }
        String currentAccountUin = qQAppInterface.getCurrentAccountUin();
        int i3 = this.f306495e;
        if (i3 == 0) {
            i3 = ((Integer) com.tencent.mobileqq.utils.p.b(context, currentAccountUin, "sp_key_secure_phone_notice_time", 0)).intValue();
        }
        if (System.currentTimeMillis() < i3 * 1000) {
            if (QLog.isColorLevel()) {
                QLog.i("SecurePhoneBannerManager", 2, "getSecurePhoneState, but not time");
                return;
            }
            return;
        }
        LoginVerifyServlet.a(qQAppInterface, new f(qQAppInterface, context, currentAccountUin));
    }

    public View q(final QQAppInterface qQAppInterface, final Context context) {
        if (QLog.isColorLevel()) {
            QLog.d("SecurePhoneBannerManager", 2, "initSecurePhoneBanner");
        }
        return QUINoticeBarManager.l().h(context).setMsg(this.f306492b).c(new View.OnClickListener() { // from class: com.tencent.mobileqq.util.ch
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SecurePhoneBannerManager.this.r(qQAppInterface, context, view);
            }
        }).getView();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes20.dex */
    public class a implements Animation.AnimationListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Dialog f306499d;

        a(Dialog dialog) {
            this.f306499d = dialog;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            this.f306499d.dismiss();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes20.dex */
    public class d implements View.OnClickListener {
        d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
        }
    }
}
