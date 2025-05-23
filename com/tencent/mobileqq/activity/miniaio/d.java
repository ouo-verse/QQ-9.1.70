package com.tencent.mobileqq.activity.miniaio;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.widget.RedWidgetUtil;

/* compiled from: P */
/* loaded from: classes10.dex */
public class d implements IMiniMsgUnreadCallback {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private View f183471d;

    /* renamed from: e, reason: collision with root package name */
    private TextView f183472e;

    public d(View view, TextView textView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) view, (Object) textView);
        } else {
            this.f183471d = view;
            this.f183472e = textView;
        }
    }

    @Override // com.tencent.mobileqq.activity.miniaio.IMiniMsgUnreadCallback
    public void destroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        } else {
            this.f183471d = null;
            this.f183472e = null;
        }
    }

    @Override // com.tencent.mobileqq.activity.miniaio.IMiniMsgUnreadCallback
    public void hide() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            this.f183471d.setVisibility(4);
        }
    }

    @Override // com.tencent.mobileqq.activity.miniaio.IMiniMsgUnreadCallback
    public void hideUnread() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        TextView textView = this.f183472e;
        if (textView == null) {
            return;
        }
        textView.setVisibility(8);
    }

    @Override // com.tencent.mobileqq.activity.miniaio.IMiniMsgUnreadCallback
    public boolean show(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, i3)).booleanValue();
        }
        this.f183471d.setVisibility(0);
        updateUnreadCount(i3, false);
        return true;
    }

    @Override // com.tencent.mobileqq.activity.miniaio.IMiniMsgUnreadCallback
    public void updateOnBackFromMiniAIO(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) bundle);
        }
    }

    @Override // com.tencent.mobileqq.activity.miniaio.IMiniMsgUnreadCallback
    public void updateUnreadCount(int i3, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Integer.valueOf(i3), Boolean.valueOf(z16));
            return;
        }
        TextView textView = this.f183472e;
        if (textView == null) {
            return;
        }
        String valueOf = String.valueOf(i3);
        if (i3 > 99) {
            valueOf = "99+";
        }
        textView.setText(valueOf);
        if (!z16) {
            if (i3 <= 0) {
                textView.setVisibility(8);
            } else {
                textView.setVisibility(0);
            }
        }
        RedWidgetUtil.fixTextViewLayout(textView, i3, 99, R.drawable.skin_tips_newmessage);
    }
}
