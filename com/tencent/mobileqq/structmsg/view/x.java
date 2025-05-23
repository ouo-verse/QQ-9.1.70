package com.tencent.mobileqq.structmsg.view;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsgElement;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes18.dex */
public class x extends com.tencent.mobileqq.structmsg.a {
    static IPatchRedirector $redirector_;
    private final int X0;

    public x() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.X0 = 16;
        }
    }

    private void E() {
        if (this.U0.size() > 2) {
            return;
        }
        int i3 = -1;
        int i16 = -1;
        for (int i17 = 0; i17 < this.U0.size(); i17++) {
            AbsStructMsgElement absStructMsgElement = this.U0.get(i17);
            if ("title".equals(absStructMsgElement.f290322e)) {
                i3 = i17;
            } else if ("picture".equals(absStructMsgElement.f290322e)) {
                i16 = i17;
            }
        }
        if (i3 >= 0 && i16 >= 0 && i3 < i16) {
            AbsStructMsgElement absStructMsgElement2 = this.U0.get(i3);
            ArrayList<AbsStructMsgElement> arrayList = this.U0;
            arrayList.set(i3, arrayList.get(i16));
            this.U0.set(i16, absStructMsgElement2);
        }
    }

    private LinearLayout F(Context context) {
        int f16;
        int f17;
        Resources resources = context.getResources();
        LinearLayout linearLayout = new LinearLayout(context);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        if (u()) {
            linearLayout.setBackgroundResource(R.drawable.f160242j92);
        } else {
            B(linearLayout);
            D(linearLayout);
        }
        int dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.axy);
        int dimensionPixelSize2 = resources.getDimensionPixelSize(R.dimen.axz);
        if (h(1)) {
            f16 = BaseAIOUtils.f(15.0f, resources);
        } else {
            f16 = BaseAIOUtils.f(6.0f, resources);
        }
        if (h(2)) {
            f17 = BaseAIOUtils.f(15.0f, resources);
        } else {
            f17 = BaseAIOUtils.f(6.0f, resources);
        }
        linearLayout.setPadding(dimensionPixelSize, f16, dimensionPixelSize2, f17);
        linearLayout.setLayoutParams(layoutParams);
        linearLayout.setOrientation(0);
        return linearLayout;
    }

    private LinearLayout.LayoutParams G(Resources resources, boolean z16) {
        int i3;
        if (z16) {
            i3 = 50;
        } else {
            i3 = 58;
        }
        float f16 = i3;
        return new LinearLayout.LayoutParams(BaseAIOUtils.f(f16, resources), BaseAIOUtils.f(f16, resources));
    }

    @Override // com.tencent.mobileqq.structmsg.a
    protected int w() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
            return 4;
        }
        return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
    }

    @Override // com.tencent.mobileqq.structmsg.a
    public String x() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return "Layout4";
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x018a  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x01cb  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x01e2  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0194  */
    @Override // com.tencent.mobileqq.structmsg.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public View y(Context context, View view, Bundle bundle) {
        boolean z16;
        LinearLayout F;
        boolean z17;
        Iterator<AbsStructMsgElement> it;
        String str;
        int i3;
        int i16;
        TextView textView;
        int i17;
        TextView textView2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (View) iPatchRedirector.redirect((short) 5, this, context, view, bundle);
        }
        boolean z18 = bundle.getBoolean("NAIOSub", false);
        if (bundle.getInt("accostType") == AbsStructMsg.SOURCE_ACCOUNT_TYPE_PA) {
            z16 = true;
        } else {
            z16 = false;
        }
        String str2 = "";
        if (view != null && (view instanceof LinearLayout)) {
            F = (LinearLayout) view;
            if (F.getChildCount() == this.U0.size()) {
                if (z16) {
                    E();
                }
                Iterator<AbsStructMsgElement> it5 = this.U0.iterator();
                int i18 = 0;
                while (it5.hasNext()) {
                    AbsStructMsgElement next = it5.next();
                    next.O0 = this.O0;
                    String str3 = next.f290322e;
                    if ("title".equals(str3) || "picture".equals(str3) || "video".equals(str3)) {
                        View childAt = F.getChildAt(i18);
                        next.c(context, childAt, bundle);
                        if (next instanceof StructMsgItemTitle) {
                            StructMsgItemTitle structMsgItemTitle = (StructMsgItemTitle) next;
                            structMsgItemTitle.N(z(), this.S0);
                            if (structMsgItemTitle.x() != null && !structMsgItemTitle.x().equals("")) {
                                try {
                                    i17 = Integer.parseInt(((StructMsgItemTitle) next).x()) / 2;
                                } catch (Exception unused) {
                                }
                                textView2 = (TextView) view.findViewById(R.id.kbs);
                                if (textView2 != null) {
                                    textView2.setTextSize(2, i17);
                                }
                            }
                            i17 = 16;
                            textView2 = (TextView) view.findViewById(R.id.kbs);
                            if (textView2 != null) {
                            }
                        }
                        if (u()) {
                            next.b(childAt);
                        }
                    }
                    i18++;
                }
                return F;
            }
        }
        Resources resources = context.getResources();
        F = F(context);
        if (z16) {
            F.setPadding(resources.getDimensionPixelSize(R.dimen.f158263bo), F.getPaddingTop(), resources.getDimensionPixelOffset(R.dimen.f158264bp), F.getPaddingBottom());
            E();
        }
        Iterator<AbsStructMsgElement> it6 = this.U0.iterator();
        while (it6.hasNext()) {
            AbsStructMsgElement next2 = it6.next();
            next2.O0 = this.O0;
            String str4 = next2.f290322e;
            if ("title".equals(str4)) {
                View c16 = next2.c(context, null, bundle);
                if (c16 instanceof TextView) {
                    TextView textView3 = (TextView) c16;
                    if (!TextUtils.isEmpty(textView3.getText())) {
                        F.setContentDescription(textView3.getText());
                    }
                }
                if (next2 instanceof StructMsgItemTitle) {
                    StructMsgItemTitle structMsgItemTitle2 = (StructMsgItemTitle) next2;
                    it = it6;
                    structMsgItemTitle2.N(z(), this.S0);
                    if (structMsgItemTitle2.x() != null && !structMsgItemTitle2.x().equals(str2)) {
                        try {
                            i3 = Integer.parseInt(((StructMsgItemTitle) next2).x()) / 2;
                        } catch (Exception unused2) {
                        }
                        str = str2;
                        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
                        layoutParams.gravity = 16;
                        layoutParams.weight = 1.0f;
                        if (F.getChildCount() != 0) {
                            layoutParams.leftMargin = 0;
                            layoutParams.rightMargin = BaseAIOUtils.f(15.0f, resources);
                        } else {
                            layoutParams.leftMargin = BaseAIOUtils.f(15.0f, resources);
                            layoutParams.rightMargin = 0;
                            if (z16) {
                                layoutParams.leftMargin = BaseAIOUtils.f(10.0f, resources);
                                TextView textView4 = (TextView) c16;
                                z17 = z16;
                                textView4.setLineSpacing(BaseAIOUtils.f(2.5f, resources), 1.0f);
                                i16 = 2;
                                textView4.setMaxLines(2);
                                textView = (TextView) c16.findViewById(R.id.kbs);
                                if (textView != null) {
                                    textView.setEllipsize(TextUtils.TruncateAt.END);
                                    if (i3 != 0) {
                                        textView.setTextSize(i16, i3);
                                    } else {
                                        textView.setTextSize(i16, 16.0f);
                                    }
                                }
                                if (u()) {
                                    next2.b(c16);
                                }
                                F.addView(c16, layoutParams);
                            }
                        }
                        z17 = z16;
                        i16 = 2;
                        textView = (TextView) c16.findViewById(R.id.kbs);
                        if (textView != null) {
                        }
                        if (u()) {
                        }
                        F.addView(c16, layoutParams);
                    }
                } else {
                    it = it6;
                }
                i3 = 0;
                str = str2;
                LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
                layoutParams2.gravity = 16;
                layoutParams2.weight = 1.0f;
                if (F.getChildCount() != 0) {
                }
                z17 = z16;
                i16 = 2;
                textView = (TextView) c16.findViewById(R.id.kbs);
                if (textView != null) {
                }
                if (u()) {
                }
                F.addView(c16, layoutParams2);
            } else {
                z17 = z16;
                it = it6;
                str = str2;
                if (!"picture".equals(str4) && !"video".equals(str4)) {
                    if ("hr".equals(str4)) {
                        View c17 = next2.c(context, null, bundle);
                        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, 1);
                        if (this.U0.size() == 1) {
                            F.setPadding(F.getPaddingLeft(), 0, F.getPaddingRight(), 0);
                        }
                        if (u()) {
                            next2.b(c17);
                        }
                        F.addView(c17, layoutParams3);
                    }
                } else {
                    F.addView(next2.c(context, null, bundle), G(resources, z18));
                }
                z16 = z17;
                it6 = it;
                str2 = str;
            }
            z16 = z17;
            it6 = it;
            str2 = str;
        }
        return F;
    }
}
