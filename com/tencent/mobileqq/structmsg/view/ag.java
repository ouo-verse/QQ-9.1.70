package com.tencent.mobileqq.structmsg.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsgElement;

/* compiled from: P */
/* loaded from: classes18.dex */
public class ag extends com.tencent.mobileqq.structmsg.a {
    static IPatchRedirector $redirector_;

    public ag() {
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
        return 0;
    }

    @Override // com.tencent.mobileqq.structmsg.a
    public String x() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return "Layout0";
    }

    /* JADX WARN: Removed duplicated region for block: B:157:0x0692  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x0695 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:202:0x04ea  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0307  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x030a A[SYNTHETIC] */
    @Override // com.tencent.mobileqq.structmsg.a
    @TargetApi(16)
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public View y(Context context, View view, Bundle bundle) {
        boolean z16;
        LinearLayout linearLayout;
        Object obj;
        boolean z17;
        String str;
        int i3;
        int i16;
        String z18;
        char c16;
        int i17;
        int i18;
        String str2;
        int i19;
        int i26;
        LinearLayout linearLayout2;
        String str3;
        int i27;
        String str4;
        Context context2;
        int i28;
        int i29;
        int i36;
        int i37;
        int i38;
        Context context3 = context;
        Bundle bundle2 = bundle;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (View) iPatchRedirector.redirect((short) 5, this, context, view, bundle);
        }
        String string = bundle2.getString("sType");
        String str5 = "1";
        if (string != null) {
            string.equals("1");
        }
        if (bundle2.getInt("accostType") == AbsStructMsg.SOURCE_ACCOUNT_TYPE_PA) {
            z16 = true;
        } else {
            z16 = false;
        }
        Resources resources = context.getResources();
        int dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.axy);
        int dimensionPixelSize2 = resources.getDimensionPixelSize(R.dimen.axz);
        int f16 = BaseAIOUtils.f(2.0f, resources);
        if (z16) {
            dimensionPixelSize = BaseAIOUtils.f(12.0f, resources);
            dimensionPixelSize2 = dimensionPixelSize;
        }
        if (view != null && (view instanceof LinearLayout)) {
            linearLayout = (LinearLayout) view;
        } else {
            linearLayout = new LinearLayout(context3);
            linearLayout.setOrientation(1);
            linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        }
        if (h(1)) {
            f16 += v(context3, 10);
        }
        if (!TextUtils.isEmpty(this.f290329i)) {
            if (u()) {
                linearLayout.setBackgroundResource(R.drawable.f160242j92);
            } else {
                linearLayout.setBackgroundResource(R.drawable.f160241dz);
            }
            int f17 = BaseAIOUtils.f(1.0f, resources);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) linearLayout.getLayoutParams();
            layoutParams.leftMargin = f17;
            layoutParams.rightMargin = f17;
            linearLayout.setLayoutParams(layoutParams);
        }
        linearLayout.setPadding(dimensionPixelSize, 0, dimensionPixelSize2, 0);
        String str6 = "hr";
        String str7 = "image";
        String str8 = "video";
        int i39 = f16;
        int i46 = dimensionPixelSize;
        if (linearLayout.getChildCount() == this.U0.size()) {
            int size = this.U0.size();
            int i47 = 0;
            while (i47 < size) {
                AbsStructMsgElement absStructMsgElement = this.U0.get(i47);
                int i48 = size;
                absStructMsgElement.O0 = this.O0;
                if (absStructMsgElement instanceof StructMsgItemTitle) {
                    i19 = dimensionPixelSize2;
                    str2 = str6;
                    ((StructMsgItemTitle) absStructMsgElement).N(z(), this.S0);
                } else {
                    str2 = str6;
                    i19 = dimensionPixelSize2;
                }
                View c17 = absStructMsgElement.c(context3, linearLayout.getChildAt(i47), bundle2);
                if (c17 == null) {
                    return linearLayout;
                }
                int f18 = BaseAIOUtils.f(10.0f, resources);
                int f19 = BaseAIOUtils.f(5.0f, resources);
                LinearLayout linearLayout3 = linearLayout;
                LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
                if (i47 > 0) {
                    layoutParams2.topMargin = f19;
                }
                String str9 = absStructMsgElement.f290322e;
                if ("picture".equals(str9)) {
                    c17.setId(-1);
                    layoutParams2.height = (BaseChatItemLayout.N - f18) - f18;
                } else if ("video".equals(str9)) {
                    layoutParams2.height = (BaseChatItemLayout.N - f18) - f18;
                } else if ("title".equals(str9)) {
                    if (z16) {
                        StructMsgItemTitle structMsgItemTitle = (StructMsgItemTitle) absStructMsgElement;
                        if (TextUtils.isEmpty(structMsgItemTitle.x())) {
                            ((TextView) c17).setTextSize(18.0f);
                        }
                        if (TextUtils.isEmpty(structMsgItemTitle.y())) {
                            ((TextView) c17).setTypeface(Typeface.DEFAULT, 1);
                            c17.setId(-1);
                        }
                    }
                    c17.setId(-1);
                } else if ("summary".equals(str9)) {
                    if (this.R0 == 1) {
                        TextView textView = (TextView) c17;
                        textView.setTextSize(12.0f);
                        textView.setTextColor(-4473925);
                    }
                    if (z16) {
                        ap apVar = (ap) absStructMsgElement;
                        String z19 = apVar.z();
                        if (z19 != null && z19.equals(str5)) {
                            if (TextUtils.isEmpty(apVar.x())) {
                                ((TextView) c17).setTextSize(12.0f);
                            }
                            if (TextUtils.isEmpty(apVar.u())) {
                                ((TextView) c17).setTextColor(Color.parseColor("#8e8e8e"));
                            }
                        } else {
                            if (TextUtils.isEmpty(apVar.x())) {
                                ((TextView) c17).setTextSize(16.0f);
                            }
                            if (TextUtils.isEmpty(apVar.u())) {
                                ((TextView) c17).setTextColor(-16777216);
                            }
                            ((TextView) c17).setLineSpacing(4.0f, 1.0f);
                        }
                    }
                    c17.setId(-1);
                } else {
                    String str10 = str2;
                    if (str10.equals(str9)) {
                        if (((d) absStructMsgElement).R0) {
                            layoutParams2.height = 0;
                        } else {
                            layoutParams2.height = 1;
                        }
                        if (z16 && i47 != 0) {
                            layoutParams2.topMargin += BaseAIOUtils.f(6.0f, resources);
                        }
                        c17.setLayoutParams(layoutParams2);
                        if (z16) {
                            i29 = i46;
                            i36 = i19;
                            linearLayout2 = linearLayout3;
                            i37 = 0;
                            linearLayout2.setPadding(i29, 0, i36, 0);
                            str3 = str5;
                            str2 = str10;
                            i38 = i39;
                            i26 = i48;
                        } else {
                            str2 = str10;
                            i29 = i46;
                            i26 = i48;
                            i36 = i19;
                            linearLayout2 = linearLayout3;
                            i37 = 0;
                            str3 = str5;
                            if (i26 == 1) {
                                linearLayout2.setPadding(2, 0, 2, 0);
                            } else if (i47 == i26 - 1) {
                                i38 = i39;
                                linearLayout2.setPadding(i29, i38, i36, 0);
                            }
                            i38 = i39;
                        }
                        c17.setVisibility(i37);
                        i39 = i38;
                        i19 = i36;
                        str4 = str7;
                        context2 = context;
                        i27 = i29;
                    } else {
                        str2 = str10;
                        i26 = i48;
                        linearLayout2 = linearLayout3;
                        int i49 = i46;
                        str3 = str5;
                        String str11 = str7;
                        i27 = i49;
                        if (str11.equals(str9)) {
                            str4 = str11;
                            layoutParams2.gravity = 1;
                            linearLayout2.setPadding(0, 0, 0, 0);
                        } else {
                            str4 = str11;
                            if ("progress".equals(str9)) {
                                layoutParams2.height = BaseAIOUtils.f(4.0f, resources);
                                if (i26 == 1 && c17.getVisibility() == 8) {
                                    linearLayout2.setPadding(0, 0, 0, 0);
                                    context2 = context;
                                    if (h(1)) {
                                        i28 = 10;
                                        linearLayout2.setPadding(0, v(context2, 10), 0, 0);
                                    } else {
                                        i28 = 10;
                                    }
                                    if (h(2)) {
                                        linearLayout2.setPadding(0, 0, 0, v(context2, i28));
                                    }
                                }
                            } else {
                                context2 = context;
                                if ("more".equals(str9)) {
                                    c17.setVisibility(0);
                                }
                            }
                        }
                        context2 = context;
                    }
                    if (!u()) {
                        absStructMsgElement.b(c17);
                    }
                    i47++;
                    context3 = context2;
                    size = i26;
                    linearLayout = linearLayout2;
                    str5 = str3;
                    dimensionPixelSize2 = i19;
                    str6 = str2;
                    bundle2 = bundle;
                    i46 = i27;
                    str7 = str4;
                }
                i26 = i48;
                linearLayout2 = linearLayout3;
                str4 = str7;
                i27 = i46;
                str3 = str5;
                context2 = context;
                if (!u()) {
                }
                i47++;
                context3 = context2;
                size = i26;
                linearLayout = linearLayout2;
                str5 = str3;
                dimensionPixelSize2 = i19;
                str6 = str2;
                bundle2 = bundle;
                i46 = i27;
                str7 = str4;
            }
            return linearLayout;
        }
        LinearLayout linearLayout4 = linearLayout;
        String str12 = "hr";
        int i56 = dimensionPixelSize2;
        String str13 = str7;
        int i57 = i46;
        Object obj2 = "1";
        Context context4 = context3;
        linearLayout4.removeAllViews();
        int size2 = this.U0.size();
        int i58 = 0;
        while (i58 < size2) {
            AbsStructMsgElement absStructMsgElement2 = this.U0.get(i58);
            absStructMsgElement2.O0 = this.O0;
            if (absStructMsgElement2 instanceof StructMsgItemTitle) {
                ((StructMsgItemTitle) absStructMsgElement2).N(z(), this.S0);
            }
            View c18 = absStructMsgElement2.c(context4, null, bundle);
            if (c18 == null) {
                return linearLayout4;
            }
            int f26 = BaseAIOUtils.f(10.0f, resources);
            int f27 = BaseAIOUtils.f(5.0f, resources);
            LinearLayout linearLayout5 = linearLayout4;
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
            if (i58 > 0) {
                layoutParams3.topMargin = f27;
            }
            String str14 = absStructMsgElement2.f290322e;
            if ("picture".equals(str14)) {
                c18.setId(-1);
                layoutParams3.height = (BaseChatItemLayout.N - f26) - f26;
                layoutParams3.topMargin = BaseAIOUtils.f(9.5f, resources);
                layoutParams3.bottomMargin = BaseAIOUtils.f(9.5f, resources);
            } else if (str8.equals(str14)) {
                layoutParams3.height = (BaseChatItemLayout.N - f26) - f26;
                layoutParams3.topMargin = BaseAIOUtils.f(9.5f, resources);
                layoutParams3.bottomMargin = BaseAIOUtils.f(9.5f, resources);
            } else {
                if ("title".equals(str14)) {
                    if (z16) {
                        StructMsgItemTitle structMsgItemTitle2 = (StructMsgItemTitle) absStructMsgElement2;
                        if (TextUtils.isEmpty(structMsgItemTitle2.x())) {
                            ((TextView) c18).setTextSize(18.0f);
                        }
                        if (TextUtils.isEmpty(structMsgItemTitle2.y())) {
                            i18 = 1;
                            ((TextView) c18).setTypeface(Typeface.DEFAULT, 1);
                            layoutParams3.topMargin = BaseAIOUtils.f(3.0f, resources);
                            layoutParams3.bottomMargin = BaseAIOUtils.f(3.0f, resources);
                            if (h(i18) && i58 == 0) {
                                layoutParams3.topMargin += BaseAIOUtils.f(14.0f, resources);
                            }
                            c18.setId(-1);
                            z17 = z16;
                            i16 = size2;
                            str = str8;
                            i3 = i39;
                            obj = obj2;
                            linearLayout4 = linearLayout5;
                        }
                    }
                    i18 = 1;
                    layoutParams3.topMargin = BaseAIOUtils.f(3.0f, resources);
                    layoutParams3.bottomMargin = BaseAIOUtils.f(3.0f, resources);
                    if (h(i18)) {
                        layoutParams3.topMargin += BaseAIOUtils.f(14.0f, resources);
                    }
                    c18.setId(-1);
                    z17 = z16;
                    i16 = size2;
                    str = str8;
                    i3 = i39;
                    obj = obj2;
                    linearLayout4 = linearLayout5;
                } else if ("summary".equals(str14)) {
                    if (z16) {
                        ap apVar2 = (ap) absStructMsgElement2;
                        String z26 = apVar2.z();
                        obj = obj2;
                        if (z26 != null && z26.equals(obj)) {
                            if (TextUtils.isEmpty(apVar2.x())) {
                                ((TextView) c18).setTextSize(12.0f);
                            }
                            if (TextUtils.isEmpty(apVar2.u())) {
                                ((TextView) c18).setTextColor(Color.parseColor("#8e8e8e"));
                            }
                        } else {
                            if (TextUtils.isEmpty(apVar2.x())) {
                                ((TextView) c18).setTextSize(16.0f);
                            }
                            if (TextUtils.isEmpty(apVar2.u())) {
                                ((TextView) c18).setTextColor(-16777216);
                            }
                            ((TextView) c18).setLineSpacing(4.0f, 1.0f);
                            z18 = ((ap) absStructMsgElement2).z();
                            if (z18 == null && z18.equals(obj)) {
                                layoutParams3.topMargin = BaseAIOUtils.f(3.0f, resources);
                                layoutParams3.bottomMargin = BaseAIOUtils.f(8.0f, resources);
                            } else {
                                layoutParams3.topMargin = BaseAIOUtils.f(5.0f, resources);
                                layoutParams3.bottomMargin = BaseAIOUtils.f(5.0f, resources);
                            }
                            if (this.R0 == 1) {
                                TextView textView2 = (TextView) c18;
                                textView2.setTextSize(12.0f);
                                textView2.setTextColor(-4473925);
                            }
                            if (!h(2) && i58 == size2 - 1) {
                                if (z16) {
                                    c16 = 0;
                                    layoutParams3.bottomMargin += BaseAIOUtils.f(12.0f, resources);
                                    i17 = -1;
                                    c18.setId(i17);
                                    z17 = z16;
                                    i16 = size2;
                                    str = str8;
                                    i3 = i39;
                                    linearLayout4 = linearLayout5;
                                } else {
                                    c16 = 0;
                                    layoutParams3.bottomMargin += BaseAIOUtils.f(16.0f, resources);
                                }
                            } else {
                                c16 = 0;
                            }
                            i17 = -1;
                            c18.setId(i17);
                            z17 = z16;
                            i16 = size2;
                            str = str8;
                            i3 = i39;
                            linearLayout4 = linearLayout5;
                        }
                    } else {
                        obj = obj2;
                    }
                    z18 = ((ap) absStructMsgElement2).z();
                    if (z18 == null) {
                    }
                    layoutParams3.topMargin = BaseAIOUtils.f(5.0f, resources);
                    layoutParams3.bottomMargin = BaseAIOUtils.f(5.0f, resources);
                    if (this.R0 == 1) {
                    }
                    if (!h(2)) {
                    }
                    c16 = 0;
                    i17 = -1;
                    c18.setId(i17);
                    z17 = z16;
                    i16 = size2;
                    str = str8;
                    i3 = i39;
                    linearLayout4 = linearLayout5;
                } else {
                    obj = obj2;
                    String str15 = str12;
                    if (str15.equals(str14)) {
                        if (((d) absStructMsgElement2).R0) {
                            layoutParams3.height = 0;
                        } else {
                            layoutParams3.height = 1;
                        }
                        if (z16 && i58 != 0) {
                            layoutParams3.topMargin += BaseAIOUtils.f(6.0f, resources);
                        }
                        if (z16) {
                            z17 = z16;
                            str12 = str15;
                            linearLayout4 = linearLayout5;
                            linearLayout4.setPadding(i57, 0, i56, 0);
                            context4 = context;
                            i16 = size2;
                            str = str8;
                            i3 = i39;
                        } else {
                            z17 = z16;
                            str12 = str15;
                            str = str8;
                            int i59 = i57;
                            int i65 = i56;
                            linearLayout4 = linearLayout5;
                            if (size2 == 1) {
                                linearLayout4.setPadding(2, 0, 2, 0);
                                context4 = context;
                                i56 = i65;
                                i16 = size2;
                                i57 = i59;
                                i3 = i39;
                            } else {
                                if (i58 == size2 - 1) {
                                    i3 = i39;
                                    linearLayout4.setPadding(i59, i3, i65, 0);
                                } else {
                                    i3 = i39;
                                }
                                context4 = context;
                                i56 = i65;
                                i16 = size2;
                                i57 = i59;
                            }
                        }
                    } else {
                        z17 = z16;
                        str12 = str15;
                        str = str8;
                        i3 = i39;
                        String str16 = str13;
                        int i66 = i56;
                        linearLayout4 = linearLayout5;
                        if (str16.equals(str14)) {
                            i56 = i66;
                            layoutParams3.gravity = 1;
                            linearLayout4.setPadding(0, 0, 0, 0);
                            str13 = str16;
                            i16 = size2;
                        } else {
                            i56 = i66;
                            if ("progress".equals(str14)) {
                                layoutParams3.height = BaseAIOUtils.f(4.0f, resources);
                                if (size2 == 1) {
                                    if (c18.getVisibility() == 8) {
                                        linearLayout4.setPadding(0, 0, 0, 0);
                                        str13 = str16;
                                        i16 = size2;
                                        if (h(1)) {
                                            context4 = context;
                                            linearLayout4.setPadding(0, v(context4, 10), 0, 0);
                                        } else {
                                            context4 = context;
                                        }
                                        if (h(2)) {
                                            linearLayout4.setPadding(0, 0, 0, v(context4, 10));
                                        }
                                    } else {
                                        str13 = str16;
                                        i16 = size2;
                                        context4 = context;
                                    }
                                } else {
                                    str13 = str16;
                                    i16 = size2;
                                    context4 = context;
                                }
                            } else {
                                str13 = str16;
                                i16 = size2;
                                context4 = context;
                                if ("more".equals(str14)) {
                                    layoutParams3 = new LinearLayout.LayoutParams(-1, BaseAIOUtils.f(36.0f, resources));
                                }
                            }
                        }
                    }
                    if (u()) {
                        absStructMsgElement2.b(c18);
                    }
                    linearLayout4.addView(c18, layoutParams3);
                    i58++;
                    size2 = i16;
                    i39 = i3;
                    obj2 = obj;
                    z16 = z17;
                    str8 = str;
                }
                context4 = context;
                if (u()) {
                }
                linearLayout4.addView(c18, layoutParams3);
                i58++;
                size2 = i16;
                i39 = i3;
                obj2 = obj;
                z16 = z17;
                str8 = str;
            }
            context4 = context;
            z17 = z16;
            i16 = size2;
            str = str8;
            i3 = i39;
            obj = obj2;
            linearLayout4 = linearLayout5;
            if (u()) {
            }
            linearLayout4.addView(c18, layoutParams3);
            i58++;
            size2 = i16;
            i39 = i3;
            obj2 = obj;
            z16 = z17;
            str8 = str;
        }
        return linearLayout4;
    }
}
