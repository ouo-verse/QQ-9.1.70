package com.tencent.mobileqq.structmsg.view;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsgElement;

/* compiled from: P */
/* loaded from: classes18.dex */
public class l extends com.tencent.mobileqq.structmsg.a {
    static IPatchRedirector $redirector_;

    public l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private LinearLayout E(Context context) {
        Resources resources = context.getResources();
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(1);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        linearLayout.setPadding(resources.getDimensionPixelSize(R.dimen.axy), resources.getDimensionPixelSize(R.dimen.f159573ay0), resources.getDimensionPixelSize(R.dimen.axz), resources.getDimensionPixelSize(R.dimen.axx));
        linearLayout.setLayoutParams(layoutParams);
        return linearLayout;
    }

    @Override // com.tencent.mobileqq.structmsg.a
    protected int w() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return 21;
    }

    @Override // com.tencent.mobileqq.structmsg.a
    public String x() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return "Layout21";
    }

    @Override // com.tencent.mobileqq.structmsg.a
    public View y(Context context, View view, Bundle bundle) {
        LinearLayout E;
        int f16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (View) iPatchRedirector.redirect((short) 2, this, context, view, bundle);
        }
        bundle.getInt("accostType");
        String str = AbsStructMsg.DEFAULT_MSG_BRIEF;
        Resources resources = context.getResources();
        if (view != null && (view instanceof LinearLayout)) {
            E = (LinearLayout) view;
            E.removeAllViews();
        } else {
            E = E(context);
        }
        int paddingTop = E.getPaddingTop();
        int paddingBottom = E.getPaddingBottom();
        int dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.axy);
        int dimensionPixelSize2 = resources.getDimensionPixelSize(R.dimen.axz);
        B(E);
        D(E);
        E.setPadding(dimensionPixelSize, paddingTop, dimensionPixelSize2, paddingBottom);
        int f17 = BaseAIOUtils.f(7.0f, resources);
        for (int i3 = 0; i3 < this.U0.size(); i3++) {
            AbsStructMsgElement absStructMsgElement = this.U0.get(i3);
            if (absStructMsgElement instanceof at) {
                at atVar = (at) absStructMsgElement;
                View c16 = atVar.c(context, null, bundle);
                if (c16 != null) {
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
                    layoutParams.topMargin = atVar.T0;
                    layoutParams.bottomMargin = atVar.U0;
                    E.addView(c16, layoutParams);
                    if (u()) {
                        E.setBackgroundResource(R.drawable.j96);
                        atVar.b(c16);
                    }
                }
            } else if (absStructMsgElement instanceof d) {
                d dVar = (d) absStructMsgElement;
                View c17 = dVar.c(context, null, bundle);
                if (dVar.R0) {
                    f16 = 0;
                } else {
                    f16 = BaseAIOUtils.f(2.0f, resources);
                }
                LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, f16);
                layoutParams2.topMargin = f17;
                layoutParams2.bottomMargin = f17;
                if (c17 != null) {
                    E.addView(c17, layoutParams2);
                    if (u()) {
                        dVar.b(E);
                    }
                }
            }
        }
        return E;
    }
}
