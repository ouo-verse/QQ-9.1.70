package com.tencent.mobileqq.qqgamepub.view;

import android.content.Context;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqgamepub.data.QQGameMsgInfo;
import com.tencent.mobileqq.qqgamepub.utils.g;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes16.dex */
public class MoreMsgHeaderView extends RelativeLayout implements a {
    static IPatchRedirector $redirector_;

    public MoreMsgHeaderView(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
        }
    }

    @Override // com.tencent.mobileqq.qqgamepub.view.a
    public void b(QQGameMsgInfo qQGameMsgInfo, Context context, int i3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, qQGameMsgInfo, context, Integer.valueOf(i3), str);
            return;
        }
        TextView textView = new TextView(getContext());
        textView.setText(HardCodeUtil.qqStr(R.string.f17637313));
        textView.setTextColor(-16777216);
        textView.setAlpha(0.5f);
        textView.setEms(1);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(9);
        layoutParams.addRule(15);
        layoutParams.leftMargin = g.a(50.0f, MobileQQ.sMobileQQ.getResources());
        addView(textView, layoutParams);
    }

    @Override // com.tencent.mobileqq.qqgamepub.view.a
    public void onDestory() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.qqgamepub.view.a
    public void onPause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.qqgamepub.view.a
    public void onResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        }
    }
}
