package com.tencent.mobileqq.screendetect;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes18.dex */
public class AutoGoneRelativeLayout extends RelativeLayout {
    static IPatchRedirector $redirector_;

    public AutoGoneRelativeLayout(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
    }

    @Override // android.view.View
    public AccessibilityNodeInfo createAccessibilityNodeInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (AccessibilityNodeInfo) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        long uptimeMillis = SystemClock.uptimeMillis();
        if (QLog.isColorLevel()) {
            QLog.d("AutoGoneRelativeLayout", 2, "createAccessibilityNodeInfo() called");
        }
        if ("HUAWEI".equalsIgnoreCase(Build.MANUFACTURER)) {
            StackTraceElement[] stackTrace = new Throwable().getStackTrace();
            int length = stackTrace.length;
            boolean z16 = false;
            int i3 = 0;
            int i16 = 0;
            while (true) {
                if (i3 >= length) {
                    break;
                }
                StackTraceElement stackTraceElement = stackTrace[i3];
                if (QLog.isColorLevel()) {
                    QLog.d("AutoGoneRelativeLayout", 2, "createAccessibilityNodeInfo() i = [" + i16 + "], " + stackTraceElement.toString());
                }
                i16++;
                if (stackTraceElement.getClassName().contains("AccessibilityInteractionController")) {
                    z16 = true;
                    break;
                }
                i3++;
            }
            if (QLog.isColorLevel()) {
                QLog.d("AutoGoneRelativeLayout", 2, "createAccessibilityNodeInfo() isFromAccessibilityService = [" + z16 + "], cost time = [" + (SystemClock.uptimeMillis() - uptimeMillis) + "]");
            }
            if (z16) {
                ScreenShotHelper.l((Activity) getContext());
            }
        }
        return super.createAccessibilityNodeInfo();
    }

    public AutoGoneRelativeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
    }

    public AutoGoneRelativeLayout(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            return;
        }
        iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
    }
}
