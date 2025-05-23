package com.tencent.mobileqq.structmsg.view;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.structmsg.AbsStructMsgElement;

/* compiled from: P */
/* loaded from: classes18.dex */
public class ae extends com.tencent.mobileqq.structmsg.a {
    static IPatchRedirector $redirector_;

    public ae() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public View E(Context context, View view, boolean z16, Bundle bundle) {
        Object obj;
        RelativeLayout relativeLayout;
        String str;
        String str2;
        boolean z17;
        Object obj2;
        String str3;
        Context context2 = context;
        Bundle bundle2 = bundle;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (View) iPatchRedirector.redirect((short) 7, this, context2, view, Boolean.valueOf(z16), bundle2);
        }
        Resources resources = context.getResources();
        int size = this.U0.size();
        String str4 = "2";
        String str5 = "";
        String str6 = "black";
        String str7 = null;
        if (view == null || !(view instanceof RelativeLayout)) {
            obj = "";
            relativeLayout = null;
        } else {
            relativeLayout = (RelativeLayout) view;
            if (relativeLayout.getChildCount() != size) {
                obj = "";
                relativeLayout.removeAllViews();
            } else {
                int i3 = 0;
                while (i3 < size) {
                    AbsStructMsgElement absStructMsgElement = this.U0.get(i3);
                    absStructMsgElement.O0 = this.O0;
                    String str8 = absStructMsgElement.f290322e;
                    if ("summary".equals(str8)) {
                        ap apVar = (ap) absStructMsgElement;
                        if (z16) {
                            apVar.F("black");
                        } else {
                            apVar.F(str7);
                        }
                        String z18 = apVar.z();
                        if (z18 != null && z18.equals("1")) {
                            apVar.K("22");
                            apVar.D(true);
                            apVar.c(context2, relativeLayout.findViewById(2), bundle2);
                        } else if (z18 != null && z18.equals("2")) {
                            apVar.K("44");
                            apVar.D(true);
                            apVar.c(context2, relativeLayout.findViewById(3), bundle2);
                        } else {
                            apVar.K("30");
                            apVar.N(20);
                            apVar.c(context2, relativeLayout.findViewById(4), bundle2);
                        }
                    } else if ("picture".equals(str8)) {
                        c cVar = (c) absStructMsgElement;
                        String str9 = cVar.f290329i;
                        if (str9 != null && !str9.equals(str5)) {
                            View n3 = cVar.n(context2, relativeLayout.findViewById(6), true, bundle2);
                            n3.setClickable(true);
                            n3.setOnClickListener(cVar);
                        } else {
                            str3 = str5;
                            cVar.n(context2, relativeLayout.findViewById(5), true, bundle2);
                            i3++;
                            str5 = str3;
                            str7 = null;
                        }
                    }
                    str3 = str5;
                    i3++;
                    str5 = str3;
                    str7 = null;
                }
                return relativeLayout;
            }
        }
        if (relativeLayout == null) {
            relativeLayout = new RelativeLayout(context2);
            relativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
        }
        LinearLayout linearLayout = new LinearLayout(context2);
        linearLayout.setOrientation(1);
        linearLayout.setGravity(3);
        linearLayout.setId(1);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(9, -1);
        layoutParams.rightMargin = BaseAIOUtils.f(20.0f, resources);
        relativeLayout.addView(linearLayout, layoutParams);
        int i16 = 0;
        View view2 = null;
        while (i16 < size) {
            AbsStructMsgElement absStructMsgElement2 = this.U0.get(i16);
            int i17 = size;
            absStructMsgElement2.O0 = this.O0;
            String str10 = absStructMsgElement2.f290322e;
            if ("summary".equals(str10)) {
                ap apVar2 = (ap) absStructMsgElement2;
                if (z16) {
                    apVar2.F(str6);
                } else {
                    apVar2.F(null);
                }
                String z19 = apVar2.z();
                if (z19 != null && z19.equals("1")) {
                    apVar2.K("22");
                    apVar2.D(true);
                    View c16 = apVar2.c(context2, null, bundle2);
                    c16.setId(2);
                    str = str6;
                    c16.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
                    linearLayout.addView(c16, 0);
                } else {
                    str = str6;
                    if (z19 != null && z19.equals(str4)) {
                        apVar2.K("44");
                        apVar2.D(true);
                        View c17 = apVar2.c(context2, null, bundle2);
                        c17.setId(3);
                        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
                        layoutParams2.topMargin = BaseAIOUtils.f(-3.5f, resources);
                        linearLayout.addView(c17, layoutParams2);
                    } else {
                        apVar2.K("30");
                        apVar2.N(20);
                        View c18 = apVar2.c(context2, null, bundle2);
                        c18.setId(4);
                        str2 = str4;
                        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
                        z17 = true;
                        layoutParams3.addRule(1, 1);
                        relativeLayout.addView(c18, layoutParams3);
                    }
                }
                str2 = str4;
                z17 = true;
            } else {
                str = str6;
                str2 = str4;
                z17 = true;
                if ("picture".equals(str10)) {
                    c cVar2 = (c) absStructMsgElement2;
                    View n16 = cVar2.n(context2, null, true, bundle2);
                    RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(BaseAIOUtils.f(40.0f, resources), BaseAIOUtils.f(40.0f, resources));
                    String str11 = cVar2.f290329i;
                    obj2 = obj;
                    if (str11 != null && !str11.equals(obj2)) {
                        n16.setId(6);
                        layoutParams4.addRule(11, -1);
                        relativeLayout.addView(n16, layoutParams4);
                        n16.setClickable(true);
                        n16.setOnClickListener(cVar2);
                    } else {
                        n16.setId(5);
                        view2 = n16;
                    }
                    i16++;
                    context2 = context;
                    bundle2 = bundle;
                    obj = obj2;
                    str4 = str2;
                    size = i17;
                    str6 = str;
                }
            }
            obj2 = obj;
            i16++;
            context2 = context;
            bundle2 = bundle;
            obj = obj2;
            str4 = str2;
            size = i17;
            str6 = str;
        }
        if (linearLayout.getChildCount() == 0) {
            linearLayout.setVisibility(8);
        }
        if (view2 != null) {
            RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(BaseAIOUtils.f(40.0f, resources), BaseAIOUtils.f(40.0f, resources));
            if (relativeLayout.findViewById(6) != null) {
                layoutParams5.addRule(0, 6);
                layoutParams5.rightMargin = BaseAIOUtils.f(7.5f, resources);
            } else {
                layoutParams5.addRule(11, -1);
            }
            relativeLayout.addView(view2, layoutParams5);
        }
        View findViewById = relativeLayout.findViewById(4);
        if (findViewById != null) {
            RelativeLayout.LayoutParams layoutParams6 = (RelativeLayout.LayoutParams) findViewById.getLayoutParams();
            if (relativeLayout.findViewById(5) != null) {
                layoutParams6.addRule(0, 5);
            } else if (relativeLayout.findViewById(6) != null) {
                layoutParams6.addRule(0, 6);
            }
            findViewById.setLayoutParams(layoutParams6);
        }
        B(relativeLayout);
        relativeLayout.setPadding(BaseAIOUtils.f(22.5f, resources), BaseAIOUtils.f(10.75f, resources), BaseAIOUtils.f(22.5f, resources), BaseAIOUtils.f(11.75f, resources));
        return relativeLayout;
    }

    @Override // com.tencent.mobileqq.structmsg.a
    protected int w() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return 9;
    }

    @Override // com.tencent.mobileqq.structmsg.a
    public String x() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return "Layout9";
    }

    @Override // com.tencent.mobileqq.structmsg.a
    public View y(Context context, View view, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (View) iPatchRedirector.redirect((short) 6, this, context, view, bundle);
        }
        return E(context, view, false, bundle);
    }
}
