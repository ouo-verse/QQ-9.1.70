package com.tencent.mobileqq.structmsg.view;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.structmsg.AbsStructMsgElement;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes18.dex */
public class m extends com.tencent.mobileqq.structmsg.a {
    static IPatchRedirector $redirector_;

    public m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private LinearLayout E(Context context) {
        LinearLayout linearLayout = new LinearLayout(context);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        int f16 = BaseAIOUtils.f(12.0f, context.getResources());
        linearLayout.setPadding(f16, f16, f16, f16);
        linearLayout.setLayoutParams(layoutParams);
        return linearLayout;
    }

    @Override // com.tencent.mobileqq.structmsg.a
    protected int w() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return 22;
    }

    @Override // com.tencent.mobileqq.structmsg.a
    public String x() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return "layout22";
    }

    @Override // com.tencent.mobileqq.structmsg.a
    public View y(Context context, View view, Bundle bundle) {
        LinearLayout E;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (View) iPatchRedirector.redirect((short) 4, this, context, view, bundle);
        }
        if (view != null && (view instanceof LinearLayout)) {
            E = (LinearLayout) view;
            E.removeAllViews();
        } else {
            E = E(context);
        }
        Iterator<AbsStructMsgElement> it = this.U0.iterator();
        while (it.hasNext()) {
            AbsStructMsgElement next = it.next();
            String str = next.f290322e;
            next.O0 = this.O0;
            if ("title".equals(str)) {
                StructMsgItemTitle structMsgItemTitle = (StructMsgItemTitle) next;
                structMsgItemTitle.N(z(), this.S0);
                TextView textView = (TextView) next.c(context, null, bundle);
                textView.setEllipsize(TextUtils.TruncateAt.END);
                textView.setMaxLines(2);
                if (TextUtils.isEmpty(structMsgItemTitle.x())) {
                    textView.setTextSize(18.0f);
                }
                if (TextUtils.isEmpty(structMsgItemTitle.u())) {
                    textView.setTextColor(Color.parseColor("#000000"));
                }
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
                layoutParams.gravity = 16;
                layoutParams.weight = 1.0f;
                layoutParams.rightMargin = BaseAIOUtils.f(12.0f, context.getResources());
                E.addView(textView, layoutParams);
            } else if ("picture".equals(str)) {
                View c16 = next.c(context, null, bundle);
                int f16 = BaseAIOUtils.f(50.0f, context.getResources());
                E.addView(c16, new LinearLayout.LayoutParams(f16, f16));
            }
        }
        return E;
    }
}
