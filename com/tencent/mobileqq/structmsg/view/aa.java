package com.tencent.mobileqq.structmsg.view;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.TextAppearanceSpan;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsgElement;
import com.tencent.mobileqq.structmsg.b;
import com.tencent.mobileqq.widget.AnyScaleTypeImageView;
import com.tencent.mobileqq.widget.FixRatioPAHighLightImageView;
import com.tencent.mobileqq.widget.PAImageView;
import com.tencent.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes18.dex */
public class aa extends com.tencent.mobileqq.structmsg.a {
    static IPatchRedirector $redirector_;
    public static int Y0;
    public static int Z0;

    /* renamed from: a1, reason: collision with root package name */
    public static int f290527a1;

    /* renamed from: b1, reason: collision with root package name */
    public static int f290528b1;
    private boolean X0;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(75559);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
            return;
        }
        Y0 = 100;
        Z0 = 200;
        f290527a1 = 300;
        f290528b1 = 400;
    }

    public aa() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.X0 = false;
        }
    }

    private LinearLayout E(Context context) {
        Resources resources = context.getResources();
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(1);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        linearLayout.setPadding(resources.getDimensionPixelSize(R.dimen.axy), 0, resources.getDimensionPixelSize(R.dimen.axz), 0);
        linearLayout.setLayoutParams(layoutParams);
        return linearLayout;
    }

    /* JADX WARN: Removed duplicated region for block: B:128:0x02d6  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x030d  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x0323  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x0334  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x02e8  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x014d  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0150 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void F(Context context, Resources resources, LinearLayout linearLayout, int i3, Bundle bundle, boolean z16) {
        aa aaVar;
        int i16;
        String str;
        String str2;
        int i17;
        int i18;
        LinearLayout.LayoutParams layoutParams;
        float f16;
        String str3;
        View view;
        String str4;
        LinearLayout.LayoutParams layoutParams2;
        Iterator<AbsStructMsgElement> it;
        Resources resources2;
        aa aaVar2 = this;
        Context context2 = context;
        int dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.f158263bo);
        int dimensionPixelSize2 = resources.getDimensionPixelSize(R.dimen.f158264bp);
        if (bundle == null) {
            return;
        }
        String string = bundle.getString("sType");
        String str5 = "1";
        if (string != null) {
            string.equals("1");
        }
        String str6 = "#000000";
        if (linearLayout.getChildCount() == aaVar2.U0.size()) {
            Iterator<AbsStructMsgElement> it5 = aaVar2.U0.iterator();
            int i19 = 0;
            while (it5.hasNext()) {
                AbsStructMsgElement next = it5.next();
                next.O0 = aaVar2.O0;
                boolean z17 = next instanceof StructMsgItemTitle;
                if (z17) {
                    StructMsgItemTitle structMsgItemTitle = (StructMsgItemTitle) next;
                    it = it5;
                    structMsgItemTitle.N(z(), aaVar2.S0);
                    structMsgItemTitle.D(false);
                    if (TextUtils.isEmpty(structMsgItemTitle.x())) {
                        structMsgItemTitle.K(String.valueOf(36));
                    }
                } else {
                    it = it5;
                    if (next instanceof ap) {
                        ap apVar = (ap) next;
                        apVar.J();
                        if (apVar.x() == null || apVar.x().equals("")) {
                            apVar.K(String.valueOf(28));
                        }
                        String z18 = apVar.z();
                        if (z18 != null && z18.equals("1")) {
                            apVar.K(String.valueOf(24));
                            if (z16 && TextUtils.isEmpty(apVar.u())) {
                                apVar.F("#8e8e8e");
                            }
                        } else if (z16) {
                            if (TextUtils.isEmpty(apVar.x())) {
                                apVar.K(String.valueOf(32));
                            }
                            if (TextUtils.isEmpty(apVar.u())) {
                                apVar.F(str6);
                            }
                        }
                    }
                }
                View childAt = linearLayout.getChildAt(i19);
                next.c(context2, childAt, bundle);
                int paddingTop = childAt.getPaddingTop();
                int paddingBottom = childAt.getPaddingBottom();
                String str7 = str6;
                if (z16) {
                    if (!(next instanceof c) && !(next instanceof d)) {
                        childAt.setPadding(dimensionPixelSize, paddingTop, dimensionPixelSize2, paddingBottom);
                    } else {
                        childAt.setPadding(0, paddingTop, 0, paddingBottom);
                    }
                }
                if (z17) {
                    if (z16 && TextUtils.isEmpty(((StructMsgItemTitle) next).y())) {
                        ((TextView) childAt).setTypeface(Typeface.DEFAULT, 1);
                    }
                } else if ((next instanceof ap) && z16) {
                    resources2 = resources;
                    ((TextView) childAt).setLineSpacing(BaseAIOUtils.f(2.0f, resources2), 1.0f);
                    if (!u()) {
                        next.b(childAt);
                    }
                    i19++;
                    it5 = it;
                    str6 = str7;
                }
                resources2 = resources;
                if (!u()) {
                }
                i19++;
                it5 = it;
                str6 = str7;
            }
        } else {
            String str8 = "#000000";
            linearLayout.removeAllViews();
            Iterator<AbsStructMsgElement> it6 = aaVar2.U0.iterator();
            int i26 = 0;
            while (it6.hasNext()) {
                AbsStructMsgElement next2 = it6.next();
                next2.O0 = aaVar2.O0;
                String str9 = next2.f290322e;
                Iterator<AbsStructMsgElement> it7 = it6;
                if ("title".equals(str9)) {
                    if (next2 instanceof StructMsgItemTitle) {
                        StructMsgItemTitle structMsgItemTitle2 = (StructMsgItemTitle) next2;
                        structMsgItemTitle2.N(z(), aaVar2.S0);
                        structMsgItemTitle2.D(false);
                        if (TextUtils.isEmpty(structMsgItemTitle2.x())) {
                            structMsgItemTitle2.K(String.valueOf(36));
                        }
                    }
                    View c16 = next2.c(context2, null, bundle);
                    LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
                    layoutParams3.topMargin = BaseAIOUtils.f(2.5f, resources);
                    layoutParams3.bottomMargin = BaseAIOUtils.f(1.5f, resources);
                    if (aaVar2.h(1) && i26 == 0) {
                        layoutParams3.topMargin = BaseAIOUtils.f(20.0f, resources);
                    }
                    if (z16) {
                        c16.setPadding(dimensionPixelSize, c16.getPaddingTop(), dimensionPixelSize2, c16.getPaddingBottom());
                        if (TextUtils.isEmpty(((StructMsgItemTitle) next2).y())) {
                            ((TextView) c16).setTypeface(Typeface.DEFAULT, 1);
                        }
                    }
                    if (u()) {
                        next2.b(c16);
                    }
                    linearLayout.addView(c16, layoutParams3);
                } else if ("hr".equals(str9)) {
                    View c17 = next2.c(context2, null, bundle);
                    LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-1, 1);
                    if (i26 > 0) {
                        layoutParams4.topMargin = BaseAIOUtils.f(7.5f, resources);
                    }
                    if (z16) {
                        layoutParams4.leftMargin = dimensionPixelSize;
                        layoutParams4.rightMargin = dimensionPixelSize2;
                    }
                    if (c17 != null) {
                        if (u()) {
                            next2.b(c17);
                        }
                        linearLayout.addView(c17, layoutParams4);
                    }
                } else {
                    if ("summary".equals(str9)) {
                        if (next2 instanceof com.tencent.mobileqq.structmsg.b) {
                            ap apVar2 = (ap) next2;
                            apVar2.J();
                            if (apVar2.x() == null || apVar2.x().equals("")) {
                                apVar2.K(String.valueOf(28));
                            }
                            String z19 = apVar2.z();
                            if (z19 != null && z19.equals(str5)) {
                                apVar2.K(String.valueOf(24));
                                if (z16 && TextUtils.isEmpty(apVar2.u())) {
                                    apVar2.F("#8e8e8e");
                                }
                                str3 = str8;
                                view = null;
                                View c18 = next2.c(context2, view, bundle);
                                if (z16) {
                                }
                                layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
                                layoutParams2.topMargin = BaseAIOUtils.f(4.5f, resources);
                                layoutParams2.bottomMargin = BaseAIOUtils.f(5.5f, resources);
                                aaVar = this;
                                if (aaVar.h(2)) {
                                    layoutParams2.bottomMargin = BaseAIOUtils.f(13.0f, resources);
                                }
                                if (z16) {
                                }
                                if (u()) {
                                }
                                linearLayout.addView(c18, layoutParams2);
                                i16 = i3;
                                i17 = dimensionPixelSize;
                                i18 = dimensionPixelSize2;
                                str2 = str5;
                                str = str4;
                            } else if (z16) {
                                if (TextUtils.isEmpty(apVar2.x())) {
                                    apVar2.K(String.valueOf(32));
                                }
                                if (TextUtils.isEmpty(apVar2.u())) {
                                    str3 = str8;
                                    apVar2.F(str3);
                                } else {
                                    str3 = str8;
                                }
                                view = null;
                                View c182 = next2.c(context2, view, bundle);
                                if (z16) {
                                    str4 = str3;
                                    ((TextView) c182).setLineSpacing(BaseAIOUtils.f(2.0f, resources), 1.0f);
                                } else {
                                    str4 = str3;
                                }
                                layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
                                layoutParams2.topMargin = BaseAIOUtils.f(4.5f, resources);
                                layoutParams2.bottomMargin = BaseAIOUtils.f(5.5f, resources);
                                aaVar = this;
                                if (aaVar.h(2) && i26 == aaVar.U0.size() - 1) {
                                    layoutParams2.bottomMargin = BaseAIOUtils.f(13.0f, resources);
                                }
                                if (z16) {
                                    c182.setPadding(dimensionPixelSize, c182.getPaddingTop(), dimensionPixelSize2, c182.getPaddingBottom());
                                }
                                if (u()) {
                                    next2.b(c182);
                                }
                                linearLayout.addView(c182, layoutParams2);
                                i16 = i3;
                                i17 = dimensionPixelSize;
                                i18 = dimensionPixelSize2;
                                str2 = str5;
                                str = str4;
                            } else {
                                str3 = str8;
                            }
                        } else {
                            str3 = str8;
                        }
                        view = null;
                        View c1822 = next2.c(context2, view, bundle);
                        if (z16) {
                        }
                        layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
                        layoutParams2.topMargin = BaseAIOUtils.f(4.5f, resources);
                        layoutParams2.bottomMargin = BaseAIOUtils.f(5.5f, resources);
                        aaVar = this;
                        if (aaVar.h(2)) {
                        }
                        if (z16) {
                        }
                        if (u()) {
                        }
                        linearLayout.addView(c1822, layoutParams2);
                        i16 = i3;
                        i17 = dimensionPixelSize;
                        i18 = dimensionPixelSize2;
                        str2 = str5;
                        str = str4;
                    } else {
                        aaVar = this;
                        String str10 = str8;
                        if (SemanticAttributes.FaasTriggerValues.TIMER.equals(str9)) {
                            View c19 = next2.c(context2, null, bundle);
                            LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-2, -2);
                            i16 = i3;
                            if (i26 > 0) {
                                layoutParams5.topMargin = i16;
                            }
                            if (z16) {
                                str = str10;
                                c19.setPadding(dimensionPixelSize, c19.getPaddingTop(), dimensionPixelSize2, c19.getPaddingBottom());
                            } else {
                                str = str10;
                            }
                            linearLayout.addView(c19, layoutParams5);
                            i17 = dimensionPixelSize;
                            i18 = dimensionPixelSize2;
                            str2 = str5;
                        } else {
                            i16 = i3;
                            str = str10;
                            if (!"picture".equals(str9) && !"video".equals(str9)) {
                                if ("more".equals(str9)) {
                                    View c26 = next2.c(context2, null, bundle);
                                    str2 = str5;
                                    ViewGroup.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(-1, BaseAIOUtils.f(36.0f, resources));
                                    if (z16) {
                                        c26.setPadding(dimensionPixelSize, c26.getPaddingTop(), dimensionPixelSize2, c26.getPaddingBottom());
                                    }
                                    if (u()) {
                                        next2.b(c26);
                                    }
                                    linearLayout.addView(c26, layoutParams6);
                                } else {
                                    str2 = str5;
                                    if (PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME.equals(str9)) {
                                        View c27 = next2.c(context2, null, bundle);
                                        if (z16) {
                                            c27.setPadding(dimensionPixelSize, c27.getPaddingTop(), dimensionPixelSize2, c27.getPaddingBottom());
                                        }
                                        linearLayout.addView(c27);
                                    } else if ("price".equals(str9)) {
                                        View c28 = next2.c(context2, null, bundle);
                                        if (z16) {
                                            c28.setPadding(dimensionPixelSize, c28.getPaddingTop(), dimensionPixelSize2, c28.getPaddingBottom());
                                        }
                                        linearLayout.addView(c28);
                                    } else if ("pavideo".equals(str9)) {
                                        View c29 = next2.c(context2, null, bundle);
                                        ((AnyScaleTypeImageView) c29).setImageResource(R.drawable.d7v);
                                        LinearLayout.LayoutParams layoutParams7 = new LinearLayout.LayoutParams(-1, (int) (BaseChatItemLayout.J / 1.8d));
                                        if (z16) {
                                            c29.setPadding(dimensionPixelSize, c29.getPaddingTop(), dimensionPixelSize2, c29.getPaddingBottom());
                                            layoutParams7.topMargin = BaseAIOUtils.f(7.5f, resources);
                                            layoutParams7.bottomMargin = BaseAIOUtils.f(7.5f, resources);
                                        }
                                        linearLayout.addView(c29, layoutParams7);
                                    } else if ("asyncmsg".equals(str9)) {
                                        View c36 = next2.c(context2, null, bundle);
                                        if (z16) {
                                            c36.setPadding(dimensionPixelSize, c36.getPaddingTop(), dimensionPixelSize2, c36.getPaddingBottom());
                                        }
                                        linearLayout.addView(c36);
                                    }
                                }
                            } else {
                                str2 = str5;
                                View c37 = next2.c(context2, null, bundle);
                                if (c37 != null) {
                                    View findViewById = c37.findViewById(R.id.dgb);
                                    if ("picture".equals(str9) && z16 && aaVar.h(1) && i26 == 0) {
                                        bundle.putBoolean("pa_should_change", true);
                                    }
                                    if ((findViewById instanceof AnyScaleTypeImageView) && "picture".equals(str9)) {
                                    }
                                    if (z16) {
                                        i17 = dimensionPixelSize;
                                        i18 = dimensionPixelSize2;
                                        c37.setPadding(0, c37.getPaddingTop(), 0, c37.getPaddingBottom());
                                        if (findViewById instanceof FixRatioPAHighLightImageView) {
                                            ((FixRatioPAHighLightImageView) findViewById).setRatio(1.8f);
                                            layoutParams = new LinearLayout.LayoutParams(-1, -2);
                                        } else {
                                            int i27 = BaseChatItemLayout.f178057o0;
                                            if (!bundle.getBoolean("hasHeadIcon", true)) {
                                                i27 = BaseChatItemLayout.f178058p0;
                                            }
                                            layoutParams = new LinearLayout.LayoutParams(-1, (int) (i27 / 1.8d));
                                        }
                                    } else {
                                        i17 = dimensionPixelSize;
                                        i18 = dimensionPixelSize2;
                                        if (!bundle.getBoolean("hasHeadIcon", true) && bundle.getInt("serviceID", 0) == 21) {
                                            layoutParams = new LinearLayout.LayoutParams(-1, BaseAIOUtils.f(105.0f, resources));
                                        } else {
                                            layoutParams = new LinearLayout.LayoutParams(-1, BaseAIOUtils.f(175.0f, resources));
                                        }
                                    }
                                    if (i26 > 0) {
                                        layoutParams.topMargin = i16;
                                    }
                                    if ("picture".equals(str9) && z16) {
                                        if (aaVar.h(1) && i26 == 0) {
                                            layoutParams.topMargin = 0;
                                            if (c37 instanceof PAImageView) {
                                                ((PAImageView) c37).setUseRadiusRound(true, resources.getDimensionPixelSize(R.dimen.f158265bq));
                                            }
                                            f16 = 7.5f;
                                            layoutParams.bottomMargin = BaseAIOUtils.f(f16, resources);
                                            linearLayout.addView(c37, layoutParams);
                                            i26++;
                                            context2 = context;
                                            aaVar2 = aaVar;
                                            it6 = it7;
                                            dimensionPixelSize = i17;
                                            str8 = str;
                                            str5 = str2;
                                            dimensionPixelSize2 = i18;
                                        }
                                    }
                                    f16 = 7.5f;
                                    layoutParams.topMargin = BaseAIOUtils.f(7.5f, resources);
                                    layoutParams.bottomMargin = BaseAIOUtils.f(f16, resources);
                                    linearLayout.addView(c37, layoutParams);
                                    i26++;
                                    context2 = context;
                                    aaVar2 = aaVar;
                                    it6 = it7;
                                    dimensionPixelSize = i17;
                                    str8 = str;
                                    str5 = str2;
                                    dimensionPixelSize2 = i18;
                                }
                            }
                            i17 = dimensionPixelSize;
                            i18 = dimensionPixelSize2;
                        }
                    }
                    i26++;
                    context2 = context;
                    aaVar2 = aaVar;
                    it6 = it7;
                    dimensionPixelSize = i17;
                    str8 = str;
                    str5 = str2;
                    dimensionPixelSize2 = i18;
                }
                aaVar = this;
                i16 = i3;
                i17 = dimensionPixelSize;
                i18 = dimensionPixelSize2;
                str2 = str5;
                str = str8;
                i26++;
                context2 = context;
                aaVar2 = aaVar;
                it6 = it7;
                dimensionPixelSize = i17;
                str8 = str;
                str5 = str2;
                dimensionPixelSize2 = i18;
            }
        }
        if (aaVar2.X0) {
            linearLayout.setPadding(0, 0, 0, 0);
        }
    }

    private int G(int i3) {
        if (u()) {
            return com.tencent.mobileqq.structmsg.k.f(i3);
        }
        return i3;
    }

    private void H(Context context, Resources resources, LinearLayout linearLayout, int i3, View view, boolean z16) {
        TextView textView;
        StringBuffer stringBuffer = new StringBuffer();
        ArrayList arrayList = new ArrayList();
        Iterator<AbsStructMsgElement> it = this.U0.iterator();
        int i16 = -1;
        while (it.hasNext()) {
            AbsStructMsgElement next = it.next();
            next.O0 = this.O0;
            if (next instanceof com.tencent.mobileqq.structmsg.b) {
                com.tencent.mobileqq.structmsg.b bVar = (com.tencent.mobileqq.structmsg.b) next;
                if (z16) {
                    if (bVar instanceof ap) {
                        if (TextUtils.isEmpty(bVar.x())) {
                            bVar.K(String.valueOf(32));
                        }
                        if (TextUtils.isEmpty(bVar.u())) {
                            bVar.F("#000000");
                        }
                    } else if ((bVar instanceof StructMsgItemTitle) && TextUtils.isEmpty(bVar.x())) {
                        bVar.K(String.valueOf(36));
                    }
                }
                b.a s16 = bVar.s(resources);
                if (s16 != null) {
                    int i17 = i16 + 1;
                    s16.f290396f = i17;
                    s16.f290397g = i17 + s16.f290395e.length();
                    i16 += s16.f290395e.length();
                    stringBuffer.append(s16.f290395e);
                    arrayList.add(s16);
                }
            }
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(stringBuffer.toString());
        Iterator it5 = arrayList.iterator();
        while (it5.hasNext()) {
            b.a aVar = (b.a) it5.next();
            spannableStringBuilder.setSpan(new TextAppearanceSpan(null, aVar.f290392b, (int) TypedValue.applyDimension(2, aVar.f290393c, resources.getDisplayMetrics()), ColorStateList.valueOf(G(aVar.f290391a)), null), aVar.f290396f, aVar.f290397g, 33);
        }
        if (view != null && (view instanceof TextView)) {
            textView = (TextView) view;
        } else {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            TextView textView2 = new TextView(context);
            if (z16) {
                textView2.setLineSpacing(BaseAIOUtils.f(2.0f, resources), 1.0f);
                layoutParams.topMargin = BaseAIOUtils.f(4.5f, resources);
                layoutParams.bottomMargin = BaseAIOUtils.f(5.5f, resources);
            } else {
                textView2.setLineSpacing(i3, 1.0f);
                if (h(2)) {
                    layoutParams.bottomMargin = BaseAIOUtils.f(10.0f, resources);
                }
                if (h(1)) {
                    layoutParams.topMargin = BaseAIOUtils.f(10.0f, resources);
                }
            }
            linearLayout.addView(textView2, layoutParams);
            textView = textView2;
        }
        textView.setText(spannableStringBuilder);
        textView.requestLayout();
    }

    @Override // com.tencent.mobileqq.structmsg.a
    protected int w() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return 6;
    }

    @Override // com.tencent.mobileqq.structmsg.a
    public String x() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return "Layout6";
    }

    @Override // com.tencent.mobileqq.structmsg.a
    public View y(Context context, View view, Bundle bundle) {
        boolean z16;
        LinearLayout E;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (View) iPatchRedirector.redirect((short) 5, this, context, view, bundle);
        }
        if (bundle.getInt("accostType") == AbsStructMsg.SOURCE_ACCOUNT_TYPE_PA) {
            z16 = true;
        } else {
            z16 = false;
        }
        Resources resources = context.getResources();
        if (view != null && (view instanceof LinearLayout)) {
            E = (LinearLayout) view;
        } else {
            E = E(context);
        }
        int paddingTop = E.getPaddingTop();
        int paddingBottom = E.getPaddingBottom();
        int dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.axy);
        int dimensionPixelSize2 = resources.getDimensionPixelSize(R.dimen.axz);
        if (u()) {
            E.setBackgroundResource(R.drawable.f160242j92);
        } else {
            B(E);
            D(E);
        }
        if (z16) {
            if (this.R0 == 1) {
                dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.f158263bo);
            } else {
                dimensionPixelSize = 0;
            }
            dimensionPixelSize2 = dimensionPixelSize;
        }
        E.setPadding(dimensionPixelSize, paddingTop, dimensionPixelSize2, paddingBottom);
        int f16 = BaseAIOUtils.f(8.0f, resources);
        if (this.R0 == 1) {
            H(context, resources, E, f16, E.getChildAt(0), z16);
        } else {
            F(context, resources, E, f16, bundle, z16);
        }
        return E;
    }
}
