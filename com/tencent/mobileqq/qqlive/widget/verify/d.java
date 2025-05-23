package com.tencent.mobileqq.qqlive.widget.verify;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqlive.utils.q;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.app.Foreground;

/* compiled from: P */
/* loaded from: classes17.dex */
public class d implements View.OnClickListener {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private final Runnable f274072d;

    /* renamed from: e, reason: collision with root package name */
    private PopupWindow f274073e;

    /* renamed from: f, reason: collision with root package name */
    private View f274074f;

    /* renamed from: h, reason: collision with root package name */
    private String f274075h;

    /* renamed from: i, reason: collision with root package name */
    private String f274076i;

    /* renamed from: m, reason: collision with root package name */
    private int f274077m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes17.dex */
    public class a extends ClickableSpan {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) d.this);
            }
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(@NonNull View view) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                d.this.g();
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            }
        }
    }

    public d(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, (Object) str2);
            return;
        }
        this.f274072d = new Runnable() { // from class: com.tencent.mobileqq.qqlive.widget.verify.b
            @Override // java.lang.Runnable
            public final void run() {
                d.this.n();
            }
        };
        this.f274077m = 3;
        this.f274075h = str;
        this.f274076i = str2;
    }

    private void d(Activity activity, View view) {
        if (activity != null && view != null) {
            IBinder windowToken = view.getWindowToken();
            if (windowToken == null) {
                QLog.e("FacePrivacyPopupWindow", 1, "addMaskView fail, token is null!");
                return;
            }
            WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
            layoutParams.width = -1;
            layoutParams.height = -1;
            layoutParams.format = -3;
            layoutParams.type = 1000;
            layoutParams.token = windowToken;
            layoutParams.windowAnimations = R.style.Animation.Toast;
            View view2 = new View(view.getContext());
            this.f274074f = view2;
            view2.setBackgroundColor(-1895825408);
            this.f274074f.setFitsSystemWindows(false);
            activity.getWindowManager().addView(this.f274074f, layoutParams);
            return;
        }
        QLog.e("FacePrivacyPopupWindow", 1, "addMaskView fail, container is null!");
    }

    private void e(View view) {
        if (view == null) {
            QLog.e("FacePrivacyPopupWindow", 1, "addPopupWindow fail, rootView is null!");
            return;
        }
        View f16 = f(view.getContext());
        if (f16 == null) {
            QLog.e("FacePrivacyPopupWindow", 1, "addPopupWindow fail, contentView create fail!");
            return;
        }
        PopupWindow popupWindow = new PopupWindow(f16, -1, q.a(view.getContext(), 328.0f));
        this.f274073e = popupWindow;
        popupWindow.setFocusable(false);
        this.f274073e.setOutsideTouchable(false);
        this.f274073e.setSoftInputMode(16);
        this.f274073e.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.tencent.mobileqq.qqlive.widget.verify.c
            @Override // android.widget.PopupWindow.OnDismissListener
            public final void onDismiss() {
                d.this.h();
            }
        });
        this.f274073e.setAnimationStyle(com.tencent.mobileqq.R.style.ayq);
        this.f274073e.showAtLocation(view, 80, 0, 0);
    }

    private View f(Context context) {
        if (context == null) {
            QLog.e("FacePrivacyPopupWindow", 1, "createContentView fail, context is null!");
            return null;
        }
        View inflate = View.inflate(context, com.tencent.mobileqq.R.layout.h9e, null);
        inflate.findViewById(com.tencent.mobileqq.R.id.f6362341).setOnClickListener(this);
        inflate.findViewById(com.tencent.mobileqq.R.id.f636033z).setOnClickListener(this);
        TextView textView = (TextView) inflate.findViewById(com.tencent.mobileqq.R.id.f6361340);
        String string = context.getResources().getString(com.tencent.mobileqq.R.string.f199724q7);
        String string2 = context.getResources().getString(com.tencent.mobileqq.R.string.f199734q8);
        SpannableString spannableString = new SpannableString(string + string2);
        spannableString.setSpan(new a(), string.length(), string.length() + string2.length(), 17);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        textView.setText(spannableString);
        return inflate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        com.tencent.qqlive.common.webview.a.g(Foreground.getTopActivity(), "https://now.qq.com/app/rules/detail.html?actid=173560773&_bid=3429", new Bundle(), QQBrowserActivity.class, null, null, this.f274075h);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void h() {
        Activity topActivity = Foreground.getTopActivity();
        if (topActivity == null) {
            return;
        }
        WindowManager.LayoutParams attributes = topActivity.getWindow().getAttributes();
        attributes.alpha = 1.0f;
        topActivity.getWindow().setAttributes(attributes);
        l();
    }

    private void i() {
        PopupWindow popupWindow = this.f274073e;
        if (popupWindow != null) {
            popupWindow.dismiss();
        }
        com.tencent.mobileqq.qqlive.widget.verify.a.d(this.f274076i, true);
    }

    private void j() {
        PopupWindow popupWindow = this.f274073e;
        if (popupWindow != null) {
            popupWindow.dismiss();
        }
        Activity topActivity = Foreground.getTopActivity();
        if (topActivity != null && (topActivity instanceof QQBrowserActivity)) {
            topActivity.finish();
        }
    }

    private void k() {
        ThreadManagerV2.getUIHandlerV2().postDelayed(this.f274072d, 200L);
    }

    private void l() {
        Activity topActivity;
        if (this.f274074f == null || (topActivity = Foreground.getTopActivity()) == null) {
            return;
        }
        topActivity.getWindowManager().removeView(this.f274074f);
        this.f274074f = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n() {
        if (com.tencent.mobileqq.qqlive.widget.verify.a.c(this.f274076i) || this.f274077m <= 0) {
            return;
        }
        o();
    }

    private void o() {
        Activity topActivity = Foreground.getTopActivity();
        if (topActivity == null) {
            return;
        }
        if ((topActivity instanceof QQBrowserActivity) && topActivity.hasWindowFocus()) {
            FrameLayout rootView = ((QQBrowserActivity) topActivity).getRootView();
            d(topActivity, rootView);
            e(rootView);
        } else {
            this.f274077m--;
            k();
        }
    }

    public void m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            this.f274077m = 3;
            n();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) view);
        } else if (view.getId() == com.tencent.mobileqq.R.id.f6362341) {
            j();
        } else if (view.getId() == com.tencent.mobileqq.R.id.f636033z) {
            i();
        }
        EventCollector.getInstance().onViewClicked(view);
    }
}
