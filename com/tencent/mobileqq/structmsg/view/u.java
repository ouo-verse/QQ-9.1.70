package com.tencent.mobileqq.structmsg.view;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.structmsg.AbsStructMsgElement;
import com.tencent.mobileqq.structmsg.view.av;
import com.tencent.mobileqq.structmsg.widget.TextViewWrapLayout;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes18.dex */
public class u extends com.tencent.mobileqq.structmsg.a {
    static IPatchRedirector $redirector_;
    protected boolean X0;

    public u() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private void E(ViewGroup viewGroup, View view, RelativeLayout.LayoutParams layoutParams) {
        if (viewGroup != null && view != null && layoutParams != null) {
            viewGroup.addView(view, layoutParams);
        }
    }

    private TextViewWrapLayout F(Context context) {
        TextViewWrapLayout textViewWrapLayout = new TextViewWrapLayout(context);
        textViewWrapLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
        if (!TextUtils.isEmpty(this.f290329i)) {
            textViewWrapLayout.setBackgroundResource(R.drawable.common_strip_setting_bg);
        }
        D(textViewWrapLayout);
        return textViewWrapLayout;
    }

    private void G(Context context, ViewGroup viewGroup) {
        int i3;
        Resources resources = context.getResources();
        int dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.axy);
        int dimensionPixelSize2 = resources.getDimensionPixelSize(R.dimen.axz);
        int f16 = BaseAIOUtils.f(5.0f, resources);
        if (h(1)) {
            i3 = v(context, 10) + f16;
        } else {
            i3 = f16;
        }
        if (h(2)) {
            f16 += v(context, 10);
        }
        viewGroup.setPadding(dimensionPixelSize, i3, dimensionPixelSize2, f16);
    }

    private void H(Context context, ViewGroup viewGroup) {
        if (!this.X0) {
            Resources resources = context.getResources();
            int f16 = BaseAIOUtils.f(11.0f, resources);
            int f17 = BaseAIOUtils.f(14.0f, resources);
            viewGroup.setPadding(f17, f16, f17, BaseAIOUtils.f(12.0f, resources));
        }
    }

    private void I(TextView textView, int i3) {
        if (textView != null && i3 > 0) {
            textView.setMaxLines(i3);
        }
    }

    private void J(View view, int i3) {
        if (view == null) {
            return;
        }
        view.setVisibility(i3);
    }

    @Override // com.tencent.mobileqq.structmsg.a
    protected int w() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return 2;
    }

    @Override // com.tencent.mobileqq.structmsg.a
    public String x() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return "Layout2";
    }

    /* JADX WARN: Removed duplicated region for block: B:106:0x03f6  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0405  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x041e  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x040f  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x0414  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x03fb  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x038f  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x03a9  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x03c2 A[ADDED_TO_REGION] */
    @Override // com.tencent.mobileqq.structmsg.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public View y(Context context, View view, Bundle bundle) {
        TextView textView;
        TextView textView2;
        RelativeLayout.LayoutParams layoutParams;
        TextViewWrapLayout textViewWrapLayout;
        TextView textView3;
        View view2;
        String str;
        String str2;
        boolean z16;
        boolean z17;
        int i3;
        float f16;
        ap apVar;
        StructMsgItemTitle structMsgItemTitle;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (View) iPatchRedirector.redirect((short) 5, this, context, view, bundle);
        }
        Resources resources = context.getResources();
        this.X0 = bundle.getBoolean("pre_dialog", false);
        Iterator<AbsStructMsgElement> it = this.U0.iterator();
        while (it.hasNext()) {
            AbsStructMsgElement next = it.next();
            if (next instanceof c) {
                c cVar = (c) next;
                if (cVar.W0 == c.f290634a1) {
                    cVar.W0 = c.Y0;
                }
            }
        }
        String str3 = "video";
        String str4 = "title";
        if (view != null && (view instanceof TextViewWrapLayout)) {
            textViewWrapLayout = (TextViewWrapLayout) view;
            Iterator<AbsStructMsgElement> it5 = this.U0.iterator();
            textView3 = null;
            View view3 = null;
            TextView textView4 = null;
            view2 = null;
            while (it5.hasNext()) {
                AbsStructMsgElement next2 = it5.next();
                next2.O0 = this.O0;
                String str5 = next2.f290322e;
                if (("picture".equals(str5) || "vote".equals(str5) || "video".equals(str5)) && view3 == null) {
                    view3 = next2.c(context, textViewWrapLayout.findViewById(R.id.dgb), bundle);
                } else if ("title".equals(str5) && textView3 == null) {
                    if (next2 instanceof StructMsgItemTitle) {
                        ((StructMsgItemTitle) next2).N(z(), this.S0);
                    }
                    textView3 = (TextView) next2.c(context, textViewWrapLayout.findViewById(R.id.kbs), bundle);
                    if (u()) {
                        next2.b(textView3);
                    }
                } else if (textView4 == null) {
                    if (!"summary".equals(str5) && !SemanticAttributes.FaasTriggerValues.TIMER.equals(str5)) {
                        if ("checklist".equals(str5)) {
                            view2 = (LinearLayout) next2.c(context, textViewWrapLayout.findViewById(R.id.k6b), bundle);
                        }
                    } else {
                        TextView textView5 = (TextView) next2.c(context, textViewWrapLayout.findViewById(R.id.tv_summary), bundle);
                        if (u()) {
                            next2.b(textView5);
                        }
                        textView4 = textView5;
                    }
                }
            }
            textView = textView4;
        } else {
            TextViewWrapLayout F = F(context);
            Iterator<AbsStructMsgElement> it6 = this.U0.iterator();
            textView = null;
            View view4 = null;
            View view5 = null;
            TextView textView6 = null;
            while (it6.hasNext()) {
                AbsStructMsgElement next3 = it6.next();
                Iterator<AbsStructMsgElement> it7 = it6;
                next3.O0 = this.O0;
                String str6 = next3.f290322e;
                if (("picture".equals(str6) || "vote".equals(str6) || str3.equals(str6)) && view5 == null) {
                    str = str3;
                    view5 = next3.c(context, null, bundle);
                    str2 = str4;
                } else {
                    str = str3;
                    if (str4.equals(str6) && textView6 == null) {
                        if (next3 instanceof StructMsgItemTitle) {
                            str2 = str4;
                            ((StructMsgItemTitle) next3).N(z(), this.S0);
                        } else {
                            str2 = str4;
                        }
                        TextView textView7 = (TextView) next3.c(context, null, bundle);
                        if (u()) {
                            next3.b(textView7);
                        }
                        textView6 = textView7;
                    } else {
                        str2 = str4;
                        if (textView == null) {
                            if (!"summary".equals(str6) && !SemanticAttributes.FaasTriggerValues.TIMER.equals(str6)) {
                                if ("checklist".equals(str6)) {
                                    view4 = (LinearLayout) next3.c(context, null, bundle);
                                }
                            } else {
                                textView = (TextView) next3.c(context, null, bundle);
                                if (u()) {
                                    next3.b(textView);
                                }
                            }
                        }
                    }
                }
                it6 = it7;
                str3 = str;
                str4 = str2;
            }
            if (view5 == null) {
                if (QLog.isColorLevel()) {
                    QLog.e("StructMsg", 2, "generate 2 item failure.");
                    return null;
                }
                return null;
            }
            if (textView6 == null && textView != null) {
                textView2 = (TextView) new StructMsgItemTitle(textView.getText().toString()).c(context, null, bundle);
            } else {
                textView2 = textView6;
            }
            if (textView2 == null) {
                if (QLog.isColorLevel()) {
                    QLog.e("StructMsg", 2, "generate 2 item titleview failure.");
                    return null;
                }
                return null;
            }
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams2.topMargin = 0;
            layoutParams2.addRule(10);
            RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams3.addRule(3, textView2.getId());
            int i16 = this.R0;
            if (i16 != 1 && i16 != 3) {
                if (!this.X0) {
                    if (textView != null) {
                        textView.setLineSpacing(BaseAIOUtils.f(1.0f, resources), 1.0f);
                    }
                    RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(BaseAIOUtils.f(50.0f, resources), BaseAIOUtils.f(50.0f, resources));
                    layoutParams4.topMargin = BaseAIOUtils.f(7.0f, resources);
                    layoutParams4.leftMargin = BaseAIOUtils.f(10.0f, resources);
                    layoutParams4.addRule(3, textView2.getId());
                    layoutParams4.addRule(11);
                    layoutParams3.topMargin = BaseAIOUtils.f(5.0f, resources);
                    layoutParams3.addRule(0, view5.getId());
                    E(F, textView2, layoutParams2);
                    E(F, view5, layoutParams4);
                    E(F, textView, layoutParams3);
                    E(F, view4, layoutParams3);
                } else {
                    RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(BaseAIOUtils.f(32.0f, resources), BaseAIOUtils.f(32.0f, resources));
                    layoutParams5.leftMargin = BaseAIOUtils.f(6.0f, resources);
                    layoutParams5.addRule(11);
                    layoutParams5.addRule(15);
                    int dip2px = ViewUtils.dip2px(20.0f);
                    layoutParams2.topMargin = dip2px;
                    layoutParams2.bottomMargin = dip2px;
                    layoutParams2.addRule(0, view5.getId());
                    layoutParams2.addRule(9);
                    layoutParams2.addRule(15);
                    E(F, view5, layoutParams5);
                    E(F, textView2, layoutParams2);
                }
            } else {
                if (i16 == 1) {
                    layoutParams = new RelativeLayout.LayoutParams(BaseAIOUtils.f(50.0f, resources), BaseAIOUtils.f(50.0f, resources));
                    layoutParams.topMargin = BaseAIOUtils.f(3.0f, resources);
                } else {
                    layoutParams = new RelativeLayout.LayoutParams(BaseAIOUtils.f(115.0f, resources), BaseAIOUtils.f(70.0f, resources));
                    layoutParams.topMargin = BaseAIOUtils.f(3.0f, resources);
                }
                layoutParams.addRule(9);
                layoutParams.addRule(10);
                ViewGroup relativeLayout = new RelativeLayout(context);
                RelativeLayout.LayoutParams layoutParams6 = new RelativeLayout.LayoutParams(-1, -2);
                if (this.R0 == 3) {
                    layoutParams6.topMargin = BaseAIOUtils.f(12.0f, resources);
                    layoutParams3.topMargin = 5;
                } else {
                    layoutParams6.topMargin = BaseAIOUtils.f(7.0f, resources);
                    layoutParams3.topMargin = 0;
                }
                layoutParams6.addRule(10);
                layoutParams6.addRule(1, view5.getId());
                layoutParams6.leftMargin = BaseAIOUtils.f(10.0f, resources);
                E(F, view5, layoutParams);
                E(relativeLayout, textView2, layoutParams2);
                E(relativeLayout, textView, layoutParams3);
                E(relativeLayout, view4, layoutParams3);
                F.addView(relativeLayout, layoutParams6);
            }
            textViewWrapLayout = F;
            textView3 = textView2;
            view2 = view4;
        }
        int i17 = this.R0;
        if (i17 != 1 && i17 != 3) {
            H(context, textViewWrapLayout);
        } else {
            G(context, textViewWrapLayout);
        }
        if (textView3 != null) {
            Object tag = textView3.getTag();
            if ((tag instanceof StructMsgItemTitle) && (structMsgItemTitle = (StructMsgItemTitle) tag) != null) {
                z16 = !TextUtils.isEmpty(structMsgItemTitle.t());
                if (textView != null) {
                    Object tag2 = textView.getTag();
                    if ((tag2 instanceof ap) && (apVar = (ap) tag2) != null) {
                        z17 = !TextUtils.isEmpty(apVar.t());
                        if (view2 != null) {
                            Object tag3 = view2.getTag();
                            if (tag3 instanceof av) {
                                ArrayList<av.a> arrayList = ((av) tag3).f290626j1;
                                if (arrayList != null && !arrayList.isEmpty()) {
                                    z17 = true;
                                } else {
                                    z17 = false;
                                }
                            }
                        }
                        if (!z16 && textView3 != null) {
                            I(textView3, 2);
                            J(textView3, 0);
                            I(textView, 2);
                            int i18 = this.R0;
                            if (i18 != 1 && i18 != 3) {
                                if (!this.X0) {
                                    f16 = 17.0f;
                                } else {
                                    f16 = 14.0f;
                                }
                                textView3.setTextSize(f16);
                            } else {
                                textView3.setTextSize(16.0f);
                            }
                        } else {
                            J(textView3, 8);
                            I(textView, 4);
                        }
                        if (z17) {
                            J(textView, 0);
                        } else {
                            J(textView, 8);
                        }
                        i3 = this.R0;
                        if (i3 == 1 && i3 != 3) {
                            I(textView, 3);
                        } else {
                            if (textView != null) {
                                textView.setSingleLine(true);
                            }
                            if (textView3 != null) {
                                textView3.setSingleLine(true);
                                textView3.setMaxLines(1);
                            }
                        }
                        if (AppSetting.f99565y) {
                            StringBuilder sb5 = new StringBuilder();
                            if (textView3 != null) {
                                sb5.append(textView3.getText());
                            }
                            int i19 = bundle.getInt("serviceID", 0);
                            if (textView != null && (i19 == 32 || i19 == 14 || i19 == 15 || i19 == 16 || i19 == 17)) {
                                sb5.append(",");
                                sb5.append(textView.getText());
                            }
                            textViewWrapLayout.setContentDescription(sb5.toString());
                        }
                        return textViewWrapLayout;
                    }
                }
                z17 = false;
                if (view2 != null) {
                }
                if (!z16) {
                }
                J(textView3, 8);
                I(textView, 4);
                if (z17) {
                }
                i3 = this.R0;
                if (i3 == 1) {
                }
                if (textView != null) {
                }
                if (textView3 != null) {
                }
                if (AppSetting.f99565y) {
                }
                return textViewWrapLayout;
            }
        }
        z16 = false;
        if (textView != null) {
        }
        z17 = false;
        if (view2 != null) {
        }
        if (!z16) {
        }
        J(textView3, 8);
        I(textView, 4);
        if (z17) {
        }
        i3 = this.R0;
        if (i3 == 1) {
        }
        if (textView != null) {
        }
        if (textView3 != null) {
        }
        if (AppSetting.f99565y) {
        }
        return textViewWrapLayout;
    }
}
