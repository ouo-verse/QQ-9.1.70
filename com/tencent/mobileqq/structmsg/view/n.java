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
public class n extends com.tencent.mobileqq.structmsg.a {
    static IPatchRedirector $redirector_;

    /* compiled from: P */
    /* loaded from: classes18.dex */
    static class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        View f290661a;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    public n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private LinearLayout E(Context context) {
        LinearLayout linearLayout = new LinearLayout(context);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 17;
        linearLayout.setLayoutParams(layoutParams);
        return linearLayout;
    }

    @Override // com.tencent.mobileqq.structmsg.a
    protected int w() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return 23;
    }

    @Override // com.tencent.mobileqq.structmsg.a
    public String x() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return "layout23";
    }

    @Override // com.tencent.mobileqq.structmsg.a
    public View y(Context context, View view, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (View) iPatchRedirector.redirect((short) 4, this, context, view, bundle);
        }
        if (view != null && (view instanceof LinearLayout) && (view.getTag() instanceof a)) {
            a aVar = (a) view.getTag();
            Iterator<AbsStructMsgElement> it = this.U0.iterator();
            while (it.hasNext()) {
                AbsStructMsgElement next = it.next();
                if ("button".equals(next.f290322e)) {
                    TextView textView = (TextView) next.c(context, aVar.f290661a, bundle);
                    StructMsgItemButton structMsgItemButton = (StructMsgItemButton) next;
                    if (TextUtils.isEmpty(structMsgItemButton.x())) {
                        textView.setTextSize(16.0f);
                    }
                    if (TextUtils.isEmpty(structMsgItemButton.u())) {
                        textView.setTextColor(Color.parseColor("#12b7f5"));
                    }
                }
            }
            return view;
        }
        LinearLayout E = E(context);
        a aVar2 = new a();
        Iterator<AbsStructMsgElement> it5 = this.U0.iterator();
        TextView textView2 = null;
        while (it5.hasNext()) {
            AbsStructMsgElement next2 = it5.next();
            if ("button".equals(next2.f290322e)) {
                textView2 = (TextView) next2.c(context, null, bundle);
                StructMsgItemButton structMsgItemButton2 = (StructMsgItemButton) next2;
                if (TextUtils.isEmpty(structMsgItemButton2.x())) {
                    textView2.setTextSize(16.0f);
                }
                if (TextUtils.isEmpty(structMsgItemButton2.u())) {
                    textView2.setTextColor(Color.parseColor("#12b7f5"));
                }
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, BaseAIOUtils.f(41.0f, context.getResources()));
                layoutParams.gravity = 17;
                E.addView(textView2, layoutParams);
            }
        }
        if (textView2 != null) {
            aVar2.f290661a = textView2;
        }
        E.setTag(aVar2);
        return E;
    }
}
