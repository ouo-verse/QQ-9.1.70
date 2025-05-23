package com.tencent.mobileqq.redtouch;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.quibadge.QUIBadge;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.RedWidgetUtil;
import org.slf4j.Marker;

/* compiled from: P */
/* loaded from: classes17.dex */
public class RedTouchTab extends RedTouch {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private static final boolean f280274d;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(34227);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
            return;
        }
        boolean z16 = false;
        if (((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("red_touch_use_badge", false)) {
            z16 = true;
        }
        f280274d = z16;
    }

    public RedTouchTab(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        QLog.d(RedTouch.TAG, 1, "sUseBadgeRedTouch:" + f280274d);
    }

    private View a(String str, int i3, int i16, int i17) {
        QUIBadge qUIBadge = new QUIBadge(this.context);
        try {
            qUIBadge.setRedNum(Integer.parseInt(str));
        } catch (NumberFormatException unused) {
            qUIBadge.setRedText(str.trim());
        }
        qUIBadge.setLayoutParams(getRedTouchLayoutParams());
        if (this.isLeftAlign) {
            qUIBadge.measure(0, 0);
            this.leftMargin += qUIBadge.getMeasuredWidth() / 2;
            changeRedTouchContainer();
        }
        return qUIBadge;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0076 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x006e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private TextView b(String str, int i3, int i16, int i17) {
        int i18;
        boolean z16;
        TextView textView = new TextView(this.context);
        boolean z17 = true;
        try {
            i18 = Integer.parseInt(str);
            try {
                if (i18 > this.maxNum) {
                    textView.setText(this.maxNum + Marker.ANY_NON_NULL_MARKER);
                } else {
                    textView.setText(str);
                }
                z16 = true;
            } catch (NumberFormatException unused) {
                textView.setText(str.trim());
                z16 = false;
                textView.setTextColor(i3);
                textView.setGravity(17);
                textView.setSingleLine(true);
                if (i16 == 0) {
                }
                z17 = false;
                if (!z16) {
                }
                textView.setLayoutParams(getRedTouchLayoutParams());
                if (this.isLeftAlign) {
                }
                return textView;
            }
        } catch (NumberFormatException unused2) {
            i18 = 0;
        }
        textView.setTextColor(i3);
        textView.setGravity(17);
        textView.setSingleLine(true);
        if (i16 == 0) {
            textView.setTextSize(11.0f);
            if (this.compactMode) {
                textView.setIncludeFontPadding(false);
                try {
                    textView.setBackgroundResource(R.drawable.h1w);
                } catch (OutOfMemoryError unused3) {
                    BaseImageUtil.setBackgroundBitmapWhenOOM(getResources(), textView, R.drawable.h1w);
                }
            } else {
                try {
                    textView.setBackgroundResource(R.drawable.skin_tips_newmessage);
                } catch (OutOfMemoryError unused4) {
                    BaseImageUtil.setBackgroundBitmapWhenOOM(getResources(), textView, R.drawable.skin_tips_newmessage);
                }
                if (!z16 && z17) {
                    RedWidgetUtil.fixTextViewLayout(textView, i18, this.maxNum, R.drawable.skin_tips_newmessage, this.isUseRobotoTtf);
                } else {
                    textView.setLayoutParams(getRedTouchLayoutParams());
                }
                if (this.isLeftAlign) {
                    if (z16 && z17 && this.isUseRobotoTtf) {
                        this.leftMargin += textView.getLayoutParams().width / 2;
                    } else {
                        textView.measure(0, 0);
                        this.leftMargin += textView.getMeasuredWidth() / 2;
                    }
                    changeRedTouchContainer();
                }
                return textView;
            }
        } else {
            textView.setTextSize(13.0f);
        }
        z17 = false;
        if (!z16) {
        }
        textView.setLayoutParams(getRedTouchLayoutParams());
        if (this.isLeftAlign) {
        }
        return textView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.tianshu.ui.RedTouch
    public View getRedPointView(int i3, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (View) iPatchRedirector.redirect((short) 4, this, Integer.valueOf(i3), Boolean.valueOf(z16));
        }
        if (f280274d) {
            QUIBadge qUIBadge = new QUIBadge(this.context);
            qUIBadge.setRedDot();
            return qUIBadge;
        }
        return super.getRedPointView(i3, z16);
    }

    @Override // com.tencent.mobileqq.tianshu.ui.RedTouch
    protected View getTextRedPoint(String str, int i3, int i16, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (View) iPatchRedirector.redirect((short) 3, this, str, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
        }
        if (f280274d) {
            return a(str, i3, i16, i17);
        }
        return b(str, i3, i16, i17);
    }

    public RedTouchTab(Context context, View view) {
        super(context, view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) view);
            return;
        }
        QLog.d(RedTouch.TAG, 1, "sUseBadgeRedTouch:" + f280274d);
    }
}
