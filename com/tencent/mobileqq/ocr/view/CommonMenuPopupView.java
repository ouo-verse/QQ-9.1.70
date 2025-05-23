package com.tencent.mobileqq.ocr.view;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenuItemPriorityHelper;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenuNoIconLayout;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.BubblePopupWindow;

/* loaded from: classes16.dex */
public class CommonMenuPopupView {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name */
    public static int f254860e;

    /* renamed from: f, reason: collision with root package name */
    public static int f254861f;

    /* renamed from: a, reason: collision with root package name */
    com.tencent.mobileqq.utils.dialogutils.a f254862a;

    /* renamed from: b, reason: collision with root package name */
    private BubblePopupWindow f254863b;

    /* renamed from: c, reason: collision with root package name */
    private BubblePopupWindow.OnDismissListener f254864c;

    /* renamed from: d, reason: collision with root package name */
    private View.OnClickListener f254865d;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(20658);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
        } else {
            f254860e = 1;
            f254861f = 2;
        }
    }

    public CommonMenuPopupView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static QQCustomMenuNoIconLayout c(BubblePopupWindow bubblePopupWindow, Context context, com.tencent.mobileqq.utils.dialogutils.a aVar, View.OnClickListener onClickListener) {
        QQCustomMenuItemPriorityHelper.d(aVar);
        QQCustomMenuNoIconLayout qQCustomMenuNoIconLayout = new QQCustomMenuNoIconLayout(context);
        qQCustomMenuNoIconLayout.setGravity(17);
        qQCustomMenuNoIconLayout.setPadding(0, 0, 0, 0);
        qQCustomMenuNoIconLayout.setPopupWindow(bubblePopupWindow, null);
        qQCustomMenuNoIconLayout.setMenu(aVar);
        qQCustomMenuNoIconLayout.setMenuIconClickListener(onClickListener);
        qQCustomMenuNoIconLayout.D();
        return qQCustomMenuNoIconLayout;
    }

    public void b(int i3, String str, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), str, Integer.valueOf(i16));
            return;
        }
        if (this.f254862a == null) {
            this.f254862a = new com.tencent.mobileqq.utils.dialogutils.a();
        }
        this.f254862a.b(i3, str, i16);
    }

    public void d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        BubblePopupWindow bubblePopupWindow = this.f254863b;
        if (bubblePopupWindow != null && bubblePopupWindow.isShowing()) {
            this.f254863b.dismiss();
        }
    }

    public boolean e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this)).booleanValue();
        }
        BubblePopupWindow bubblePopupWindow = this.f254863b;
        if (bubblePopupWindow != null && bubblePopupWindow.isShowing()) {
            return true;
        }
        return false;
    }

    public void f(View.OnClickListener onClickListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) onClickListener);
        } else {
            this.f254865d = onClickListener;
        }
    }

    public void g(View view, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, view, Integer.valueOf(i3), Integer.valueOf(i16));
        } else {
            h(view, i3, i16, f254861f, true);
        }
    }

    public void h(View view, int i3, int i16, int i17, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z17 = false;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, view, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Boolean.valueOf(z16));
            return;
        }
        BubblePopupWindow bubblePopupWindow = this.f254863b;
        if (bubblePopupWindow != null && bubblePopupWindow.isShowing()) {
            this.f254863b.dismiss();
            this.f254863b = null;
        }
        BubblePopupWindow bubblePopupWindow2 = new BubblePopupWindow(-2, -2);
        this.f254863b = bubblePopupWindow2;
        bubblePopupWindow2.setContentView(c(bubblePopupWindow2, view.getContext(), this.f254862a, this.f254865d));
        this.f254863b.setBackgroundDrawable(new ColorDrawable(0));
        this.f254863b.setOutsideTouchable(z16);
        if (z16) {
            this.f254863b.setFocusable(true);
        }
        this.f254863b.setFocusable(false);
        this.f254863b.setOutsideTouchable(true);
        this.f254863b.setSoftInputMode(1);
        this.f254863b.setInputMethodMode(2);
        BubblePopupWindow bubblePopupWindow3 = this.f254863b;
        if (i17 == f254860e) {
            z17 = true;
        }
        bubblePopupWindow3.setKeepAbove(z17);
        this.f254863b.setOnDismissListener(this.f254864c);
        view.post(new Runnable(view, i3, i16) { // from class: com.tencent.mobileqq.ocr.view.CommonMenuPopupView.1
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ View f254866d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ int f254867e;

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ int f254868f;

            {
                this.f254866d = view;
                this.f254867e = i3;
                this.f254868f = i16;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, CommonMenuPopupView.this, view, Integer.valueOf(i3), Integer.valueOf(i16));
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                Context context = this.f254866d.getContext();
                if ((context instanceof Activity) && !((Activity) context).isFinishing()) {
                    try {
                        CommonMenuPopupView.this.f254863b.showAtLocation(this.f254866d, this.f254867e, this.f254868f, true, 0, ViewUtils.getScreenWidth());
                    } catch (Exception e16) {
                        QLog.e("CommonMenuPopupView", 1, "showAtLocation fail, ", e16);
                    }
                }
            }
        });
    }
}
