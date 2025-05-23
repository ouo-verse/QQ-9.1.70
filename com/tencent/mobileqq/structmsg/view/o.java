package com.tencent.mobileqq.structmsg.view;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.structmsg.AbsStructMsgElement;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes18.dex */
public class o extends com.tencent.mobileqq.structmsg.a {
    static IPatchRedirector $redirector_;

    /* compiled from: P */
    /* loaded from: classes18.dex */
    private static class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public View f290662a;

        /* renamed from: b, reason: collision with root package name */
        public TextView f290663b;

        /* renamed from: c, reason: collision with root package name */
        public TextView f290664c;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
                return;
            }
            this.f290662a = null;
            this.f290663b = null;
            this.f290664c = null;
        }

        public void a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            View view = this.f290662a;
            if (view != null) {
                view.setVisibility(8);
            }
            TextView textView = this.f290663b;
            if (textView != null) {
                textView.setVisibility(8);
            }
            TextView textView2 = this.f290664c;
            if (textView2 != null) {
                textView2.setVisibility(8);
            }
        }
    }

    public o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.structmsg.a
    protected int w() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return 24;
    }

    @Override // com.tencent.mobileqq.structmsg.a
    public String x() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return "layout24";
    }

    @Override // com.tencent.mobileqq.structmsg.a
    public View y(Context context, View view, Bundle bundle) {
        RelativeLayout relativeLayout;
        a aVar;
        TextView textView;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (View) iPatchRedirector.redirect((short) 2, this, context, view, bundle);
        }
        if (view != null && (view.getTag() instanceof a)) {
            relativeLayout = (RelativeLayout) view;
            relativeLayout.removeAllViews();
            aVar = (a) view.getTag();
            aVar.a();
        } else {
            relativeLayout = new RelativeLayout(context);
            relativeLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            int f16 = BaseAIOUtils.f(10.0f, context.getResources());
            int f17 = BaseAIOUtils.f(13.0f, context.getResources());
            relativeLayout.setPadding(f17, f16, f17, BaseAIOUtils.f(11.0f, context.getResources()));
            aVar = new a();
        }
        try {
            Iterator<AbsStructMsgElement> it = this.U0.iterator();
            boolean z16 = false;
            while (it.hasNext()) {
                AbsStructMsgElement next = it.next();
                if ("picture".equals(next.f290322e)) {
                    View n3 = ((c) next).n(context, aVar.f290662a, true, bundle);
                    int f18 = BaseAIOUtils.f(30.0f, context.getResources());
                    relativeLayout.addView(n3, new RelativeLayout.LayoutParams(f18, f18));
                    aVar.f290662a = n3;
                    n3.setVisibility(0);
                    z16 = true;
                } else if ("title".equals(next.f290322e)) {
                    TextView textView2 = (TextView) next.c(context, aVar.f290663b, bundle);
                    textView2.setGravity(16);
                    relativeLayout.addView(textView2, new RelativeLayout.LayoutParams(-2, BaseAIOUtils.f(30.0f, context.getResources())));
                    aVar.f290663b = textView2;
                    textView2.setVisibility(0);
                } else if ("summary".equals(next.f290322e)) {
                    ((ap) next).N(Integer.MAX_VALUE);
                    TextView textView3 = (TextView) next.c(context, aVar.f290664c, bundle);
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
                    layoutParams.topMargin = BaseAIOUtils.f(34.0f, context.getResources());
                    layoutParams.bottomMargin = BaseAIOUtils.f(3.0f, context.getResources());
                    relativeLayout.addView(textView3, layoutParams);
                    aVar.f290664c = textView3;
                    textView3.setVisibility(0);
                }
            }
            if (z16 && (textView = aVar.f290663b) != null) {
                ((RelativeLayout.LayoutParams) textView.getLayoutParams()).leftMargin = BaseAIOUtils.f(38.0f, context.getResources());
            }
            relativeLayout.setTag(aVar);
        } catch (Exception unused) {
        }
        return relativeLayout;
    }
}
