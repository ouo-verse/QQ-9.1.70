package com.tencent.mobileqq.mutualmark.widget.util;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.calloutpopupwindow.CalloutPopupWindow;

/* compiled from: P */
/* loaded from: classes15.dex */
public class c {
    static IPatchRedirector $redirector_;

    /* compiled from: P */
    /* loaded from: classes15.dex */
    public static class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private final View f252456a;

        /* renamed from: b, reason: collision with root package name */
        private final String f252457b;

        /* renamed from: c, reason: collision with root package name */
        private final int f252458c;

        /* renamed from: d, reason: collision with root package name */
        private final int f252459d;

        public a(View view, String str, int i3, int i16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, view, str, Integer.valueOf(i3), Integer.valueOf(i16));
                return;
            }
            this.f252456a = view;
            this.f252457b = str;
            this.f252458c = i3;
            this.f252459d = i16;
        }

        public boolean e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
            }
            View view = this.f252456a;
            if (view != null && view.getVisibility() == 0) {
                if (TextUtils.isEmpty(this.f252457b)) {
                    QLog.e("IntimateBubbleUtil", 1, "[BubbleSetUp.isValid] bubbleText invalid");
                    return false;
                }
                int i3 = this.f252458c;
                if (i3 != 49 && i3 != 50 && i3 != 51 && i3 != 52) {
                    QLog.e("IntimateBubbleUtil", 1, "[BubbleSetUp.isValid] bubblePosition invalid");
                    return false;
                }
                if (this.f252459d > 0) {
                    return true;
                }
                QLog.e("IntimateBubbleUtil", 1, "[BubbleSetUp.isValid] lifeTimeSecond invalid");
                return false;
            }
            QLog.e("IntimateBubbleUtil", 1, "[BubbleSetUp.isValid] pointerView invalid");
            return false;
        }
    }

    public static View a(Context context, a aVar) {
        int color;
        if (context != null && aVar != null && aVar.e()) {
            try {
                CalloutPopupWindow.Builder textColor = CalloutPopupWindow.builder(context).setText(aVar.f252457b).setTextSize(14.0f).setTextColor(-1);
                textColor.setPosition(aVar.f252458c);
                textColor.setLifetime(aVar.f252459d);
                if (QQTheme.isNowThemeIsNight()) {
                    color = context.getResources().getColor(R.color.c4t);
                } else {
                    color = context.getResources().getColor(R.color.c4v);
                }
                CalloutPopupWindow build = new CalloutPopupWindow.DrawableBuilder(textColor).setBackgroundColor(color).setBackgroundRadius(8).build().build();
                if (build != null) {
                    build.setAlignMode(82);
                    build.showAsPointer(aVar.f252456a);
                    QLog.d("IntimateBubbleUtil", 1, "[showIntimateBubbleTips] show");
                    return build.getContentView();
                }
            } catch (Exception e16) {
                QLog.e("IntimateBubbleUtil", 1, "[showIntimateBubbleTips] exception:", e16);
            }
            return null;
        }
        QLog.e("IntimateBubbleUtil", 1, "[showIntimateBubbleTips] context unavailable or bubbleSetup unavailable");
        return null;
    }
}
