package com.tencent.mobileqq.structmsg.view;

import android.R;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.StateSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.structmsg.AbsStructMsgElement;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes18.dex */
public class ac extends com.tencent.mobileqq.structmsg.a {
    static IPatchRedirector $redirector_;
    private static final int X0;

    /* compiled from: P */
    /* loaded from: classes18.dex */
    static class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public View f290533a;

        /* renamed from: b, reason: collision with root package name */
        public View f290534b;

        /* renamed from: c, reason: collision with root package name */
        public View f290535c;

        /* renamed from: d, reason: collision with root package name */
        public View f290536d;

        /* renamed from: e, reason: collision with root package name */
        public ViewGroup f290537e;

        /* renamed from: f, reason: collision with root package name */
        public ViewGroup f290538f;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(75562);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 8)) {
            redirector.redirect((short) 8);
        } else {
            X0 = Color.rgb(255, 221, 227);
        }
    }

    public ac() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private StateListDrawable E(Resources resources, int i3, float[] fArr) {
        GradientDrawable[] gradientDrawableArr = new GradientDrawable[2];
        int red = Color.red(i3);
        int green = Color.green(i3);
        int blue = Color.blue(i3);
        for (int i16 = 0; i16 < 2; i16++) {
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawableArr[i16] = gradientDrawable;
            gradientDrawable.setShape(0);
            int i17 = i16 << 5;
            red -= i17;
            if (red < 0) {
                red = 0;
            }
            green -= i17;
            if (green < 0) {
                green = 0;
            }
            blue -= i17;
            if (blue < 0) {
                blue = 0;
            }
            gradientDrawableArr[i16].setColor(Color.rgb(red, green, blue));
            if (fArr != null) {
                gradientDrawableArr[i16].setCornerRadii(fArr);
            } else {
                gradientDrawableArr[i16].setCornerRadius(BaseAIOUtils.f(14.0f, resources));
            }
        }
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{R.attr.state_pressed, R.attr.state_enabled}, gradientDrawableArr[1]);
        stateListDrawable.addState(StateSet.WILD_CARD, gradientDrawableArr[0]);
        return stateListDrawable;
    }

    private LinearLayout F(Context context) {
        LinearLayout linearLayout = new LinearLayout(context);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        B(linearLayout);
        linearLayout.setLayoutParams(layoutParams);
        linearLayout.setOrientation(1);
        return linearLayout;
    }

    @Override // com.tencent.mobileqq.structmsg.a
    @TargetApi(16)
    public void B(View view) {
        float[] fArr;
        float[] fArr2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) view);
            return;
        }
        if (view != null) {
            int f16 = BaseAIOUtils.f(14.0f, view.getResources());
            int g16 = g();
            if (g16 != 0) {
                if (g16 != 1) {
                    if (g16 != 2) {
                        fArr = null;
                    } else {
                        float f17 = f16;
                        fArr2 = new float[]{0.0f, 0.0f, 0.0f, 0.0f, f17, f17, f17, f17};
                    }
                } else {
                    float f18 = f16;
                    fArr2 = new float[]{f18, f18, f18, f18, 0.0f, 0.0f, 0.0f, 0.0f};
                }
                fArr = fArr2;
            } else {
                fArr = new float[8];
            }
            view.setBackground(E(view.getResources(), X0, fArr));
        }
    }

    @Override // com.tencent.mobileqq.structmsg.a
    protected int w() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return 7;
    }

    @Override // com.tencent.mobileqq.structmsg.a
    public String x() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return "Layout7";
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x01a0  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x01a5  */
    @Override // com.tencent.mobileqq.structmsg.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public View y(Context context, View view, Bundle bundle) {
        a aVar;
        LinearLayout F;
        Iterator<AbsStructMsgElement> it;
        View view2;
        View view3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (View) iPatchRedirector.redirect((short) 5, this, context, view, bundle);
        }
        Resources resources = context.getResources();
        if (view != null && (view instanceof LinearLayout)) {
            F = (LinearLayout) view;
            if (F.getChildCount() == 2 && (F.getChildAt(0).getTag() instanceof a)) {
                aVar = (a) F.getChildAt(0).getTag();
                View view4 = aVar.f290533a;
                if (view4 != null) {
                    view4.setVisibility(8);
                }
                View view5 = aVar.f290534b;
                if (view5 != null) {
                    view5.setVisibility(8);
                }
                View view6 = aVar.f290535c;
                if (view6 != null) {
                    view6.setVisibility(8);
                }
                View view7 = aVar.f290536d;
                if (view7 != null) {
                    view7.setVisibility(8);
                }
                it = this.U0.iterator();
                view2 = null;
                while (it.hasNext()) {
                    AbsStructMsgElement next = it.next();
                    next.O0 = this.O0;
                    String str = next.f290322e;
                    if ("title".equals(str)) {
                        if (next instanceof StructMsgItemTitle) {
                            StructMsgItemTitle structMsgItemTitle = (StructMsgItemTitle) next;
                            structMsgItemTitle.N(z(), 0);
                            structMsgItemTitle.D(true);
                        }
                        View c16 = next.c(context, aVar.f290533a, bundle);
                        TextView textView = (TextView) c16.findViewById(com.tencent.mobileqq.R.id.kbs);
                        if (textView != null) {
                            textView.setEllipsize(TextUtils.TruncateAt.END);
                        }
                        View view8 = aVar.f290533a;
                        if (view8 == null) {
                            aVar.f290533a = c16;
                            aVar.f290538f.addView(c16);
                        } else {
                            view8.setVisibility(0);
                        }
                    } else if ("summary".equals(str)) {
                        View c17 = next.c(context, aVar.f290534b, bundle);
                        View view9 = aVar.f290534b;
                        if (view9 == null) {
                            aVar.f290534b = c17;
                            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                            layoutParams.setMargins(0, BaseAIOUtils.f(4.0f, resources), 0, 0);
                            aVar.f290538f.addView(c17, layoutParams);
                        } else {
                            view9.setVisibility(0);
                        }
                    } else if (!"picture".equals(str) && !"video".equals(str)) {
                        if ("remark".equals(str)) {
                            view2 = next.c(context, aVar.f290536d, bundle);
                        }
                    } else {
                        int f16 = BaseAIOUtils.f(50.0f, resources);
                        View c18 = next.c(context, aVar.f290535c, bundle);
                        View view10 = aVar.f290535c;
                        if (view10 == null) {
                            aVar.f290535c = c18;
                            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(f16, f16);
                            int f17 = BaseAIOUtils.f(12.0f, resources);
                            int f18 = BaseAIOUtils.f(10.0f, resources);
                            layoutParams2.setMargins(f18, f17, f18, f17);
                            layoutParams2.gravity = 16;
                            aVar.f290537e.addView(c18, layoutParams2);
                        } else {
                            view10.setVisibility(0);
                        }
                    }
                }
                view3 = aVar.f290534b;
                if (view3 != null) {
                    view3.bringToFront();
                }
                if (view2 != null) {
                    View view11 = aVar.f290536d;
                    if (view11 == null) {
                        aVar.f290536d = view2;
                        F.addView(view2, new LinearLayout.LayoutParams(-1, BaseAIOUtils.f(25.0f, resources)));
                        float f19 = BaseAIOUtils.f(14.0f, resources);
                        view2.setBackgroundDrawable(E(resources, -1, new float[]{0.0f, 0.0f, 0.0f, 0.0f, f19, f19, f19, f19}));
                        view2.setPadding(BaseAIOUtils.f(12.0f, resources), BaseAIOUtils.f(5.0f, resources), 0, 0);
                    } else {
                        view11.setVisibility(0);
                    }
                }
                return F;
            }
        }
        aVar = new a();
        LinearLayout linearLayout = new LinearLayout(context);
        aVar.f290538f = linearLayout;
        linearLayout.setOrientation(1);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(0, -2);
        layoutParams3.weight = 1.0f;
        layoutParams3.gravity = 16;
        layoutParams3.setMargins(BaseAIOUtils.f(15.0f, resources), 0, 0, 0);
        LinearLayout linearLayout2 = new LinearLayout(context);
        aVar.f290537e = linearLayout2;
        linearLayout2.setTag(aVar);
        aVar.f290537e.addView(aVar.f290538f, layoutParams3);
        F = F(context);
        F.addView(aVar.f290537e, new LinearLayout.LayoutParams(-1, BaseAIOUtils.f(75.0f, resources)));
        it = this.U0.iterator();
        view2 = null;
        while (it.hasNext()) {
        }
        view3 = aVar.f290534b;
        if (view3 != null) {
        }
        if (view2 != null) {
        }
        return F;
    }
}
