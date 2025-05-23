package com.tencent.mobileqq.together.ui;

import android.app.Activity;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.PopupWindow;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* loaded from: classes9.dex */
public class TogetherPanel implements PopupWindow.OnDismissListener {

    /* renamed from: d, reason: collision with root package name */
    private TogetherPopupDialog f293386d;

    /* renamed from: e, reason: collision with root package name */
    private final Activity f293387e;

    public TogetherPanel(Activity activity) {
        this.f293387e = activity;
    }

    public void c() {
        if (QLog.isColorLevel()) {
            QLog.d("TogetherPanel", 2, "destroyPanel, this:" + this);
        }
        d();
        TogetherPopupDialog togetherPopupDialog = this.f293386d;
        if (togetherPopupDialog != null) {
            togetherPopupDialog.s();
            this.f293386d = null;
        }
    }

    public boolean d() {
        if (QLog.isColorLevel()) {
            QLog.d("TogetherPanel", 2, "dismissPanel, this:" + this);
        }
        TogetherPopupDialog togetherPopupDialog = this.f293386d;
        if (togetherPopupDialog != null && togetherPopupDialog.isShowing()) {
            this.f293386d.dismiss();
            return true;
        }
        return false;
    }

    public void e(String str, int i3) {
        InputMethodManager inputMethodManager = (InputMethodManager) this.f293387e.getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD);
        if (inputMethodManager.isActive()) {
            inputMethodManager.hideSoftInputFromWindow(this.f293387e.getWindow().getDecorView().getWindowToken(), 0);
        }
        if (QLog.isColorLevel()) {
            QLog.d("TogetherPanel", 2, "showDialog troopUin\uff1a" + str + "\uff0csource\uff1a" + i3 + ", this:" + this);
        }
        TogetherPopupDialog togetherPopupDialog = this.f293386d;
        if (togetherPopupDialog == null) {
            TogetherPopupDialog i16 = TogetherPopupDialog.i(str, this.f293387e, -1, -1, i3);
            this.f293386d = i16;
            i16.setOnDismissListener(this);
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime instanceof QQAppInterface) {
                tr2.b.q((QQAppInterface) peekAppRuntime).P();
            }
        } else if (i3 == 1) {
            togetherPopupDialog.k();
        }
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.together.ui.TogetherPanel.1
            @Override // java.lang.Runnable
            public void run() {
                if (TogetherPanel.this.f293386d != null && TogetherPanel.this.f293387e != null) {
                    try {
                        TogetherPanel.this.f293386d.showAtLocation(TogetherPanel.this.f293387e.getWindow().getDecorView(), 80, 0, 0);
                        TogetherPanel.this.f293386d.v();
                    } catch (Throwable th5) {
                        QLog.e("TogetherPanel", 1, "showDialog error:", th5);
                    }
                }
            }
        });
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        if (QLog.isColorLevel()) {
            QLog.d("TogetherPanel", 2, "onDismiss, this:" + this);
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof QQAppInterface) {
            tr2.b.q((QQAppInterface) peekAppRuntime).O(false);
        }
        Window window = this.f293387e.getWindow();
        if (window != null) {
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.alpha = 1.0f;
            window.setAttributes(attributes);
            window.clearFlags(134217728);
        }
        c();
    }
}
