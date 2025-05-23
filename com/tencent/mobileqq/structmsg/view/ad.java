package com.tencent.mobileqq.structmsg.view;

import android.R;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Bundle;
import android.util.StateSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.structmsg.AbsStructMsgElement;

/* compiled from: P */
/* loaded from: classes18.dex */
public class ad extends com.tencent.mobileqq.structmsg.a {
    static IPatchRedirector $redirector_;

    public ad() {
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
                gradientDrawableArr[i16].setCornerRadius(BaseAIOUtils.f(4.0f, resources));
            }
        }
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{R.attr.state_pressed, R.attr.state_enabled}, gradientDrawableArr[1]);
        stateListDrawable.addState(StateSet.WILD_CARD, gradientDrawableArr[0]);
        return stateListDrawable;
    }

    @Override // com.tencent.mobileqq.structmsg.a
    @TargetApi(16)
    public void B(View view) {
        float[] fArr;
        float[] fArr2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) view);
            return;
        }
        if (view != null) {
            if (this.S0 == 0) {
                super.B(view);
                return;
            }
            int f16 = BaseAIOUtils.f(4.0f, view.getResources());
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
            view.setBackground(E(view.getResources(), this.S0, fArr));
        }
    }

    @Override // com.tencent.mobileqq.structmsg.a
    protected int w() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return 8;
    }

    @Override // com.tencent.mobileqq.structmsg.a
    public String x() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return "Layout8";
    }

    @Override // com.tencent.mobileqq.structmsg.a
    @TargetApi(16)
    public View y(Context context, View view, Bundle bundle) {
        RelativeLayout relativeLayout;
        int i3;
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (View) iPatchRedirector.redirect((short) 6, this, context, view, bundle);
        }
        Resources resources = context.getResources();
        int size = this.U0.size();
        String str2 = "picture";
        int i16 = 1;
        if (view == null || !(view instanceof RelativeLayout)) {
            String str3 = "picture";
            relativeLayout = new RelativeLayout(context);
            char c16 = 0;
            relativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, BaseAIOUtils.f(40.0f, resources)));
            int i17 = 0;
            while (i17 < size && i17 <= 2) {
                AbsStructMsgElement absStructMsgElement = this.U0.get(i17);
                absStructMsgElement.O0 = this.O0;
                String str4 = absStructMsgElement.f290322e;
                String str5 = str3;
                if (str5.equals(str4)) {
                    ImageView imageView = (ImageView) absStructMsgElement.c(context, null, bundle);
                    imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                    imageView.setId(1);
                    i3 = size;
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(BaseAIOUtils.f(40.0f, resources), BaseAIOUtils.f(30.0f, resources));
                    layoutParams.addRule(9, -1);
                    layoutParams.addRule(15, -1);
                    relativeLayout.addView(imageView, layoutParams);
                } else {
                    i3 = size;
                    if ("title".equals(str4)) {
                        StructMsgItemTitle structMsgItemTitle = (StructMsgItemTitle) absStructMsgElement;
                        structMsgItemTitle.K("30");
                        structMsgItemTitle.D(true);
                        structMsgItemTitle.N(z(), this.S0);
                        View c17 = absStructMsgElement.c(context, null, bundle);
                        c17.setId(2);
                        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
                        layoutParams2.addRule(15, -1);
                        relativeLayout.addView(c17, layoutParams2);
                    } else if ("summary".equals(str4)) {
                        ap apVar = (ap) absStructMsgElement;
                        apVar.K("28");
                        apVar.D(true);
                        if (this.S0 != 0) {
                            apVar.M(z(), this.S0);
                        } else {
                            apVar.F("black");
                        }
                        View c18 = absStructMsgElement.c(context, null, bundle);
                        TextView textView = (TextView) c18;
                        textView.setMaxWidth(resources.getDisplayMetrics().widthPixels - BaseAIOUtils.f(89.5f, resources));
                        textView.setSingleLine(true);
                        c18.setId(3);
                        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
                        layoutParams3.addRule(11, -1);
                        layoutParams3.addRule(15, -1);
                        relativeLayout.addView(c18, layoutParams3);
                        i17++;
                        size = i3;
                        c16 = 0;
                        str3 = str5;
                    }
                }
                i17++;
                size = i3;
                c16 = 0;
                str3 = str5;
            }
        } else {
            relativeLayout = (RelativeLayout) view;
            if (size == relativeLayout.getChildCount()) {
                int i18 = 0;
                for (int i19 = 2; i18 < size && i18 <= i19; i19 = 2) {
                    AbsStructMsgElement absStructMsgElement2 = this.U0.get(i18);
                    absStructMsgElement2.O0 = this.O0;
                    String str6 = absStructMsgElement2.f290322e;
                    if (str2.equals(str6)) {
                        ImageView imageView2 = (ImageView) absStructMsgElement2.c(context, relativeLayout.findViewById(i16), bundle);
                        RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) imageView2.getLayoutParams();
                        str = str2;
                        layoutParams4.addRule(9, -1);
                        layoutParams4.addRule(15, -1);
                        imageView2.setLayoutParams(layoutParams4);
                    } else {
                        str = str2;
                        if ("title".equals(str6)) {
                            StructMsgItemTitle structMsgItemTitle2 = (StructMsgItemTitle) absStructMsgElement2;
                            structMsgItemTitle2.K("30");
                            structMsgItemTitle2.D(true);
                            structMsgItemTitle2.N(z(), this.S0);
                            View c19 = absStructMsgElement2.c(context, relativeLayout.findViewById(2), bundle);
                            RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-2, -2);
                            layoutParams5.addRule(15, -1);
                            c19.setLayoutParams(layoutParams5);
                        } else if ("summary".equals(str6)) {
                            ap apVar2 = (ap) absStructMsgElement2;
                            apVar2.K("28");
                            apVar2.D(true);
                            if (this.S0 != 0) {
                                apVar2.M(z(), this.S0);
                            } else {
                                apVar2.F("black");
                            }
                            View c26 = absStructMsgElement2.c(context, relativeLayout.findViewById(3), bundle);
                            RelativeLayout.LayoutParams layoutParams6 = new RelativeLayout.LayoutParams(-2, -2);
                            layoutParams6.addRule(11, -1);
                            layoutParams6.addRule(15, -1);
                            c26.setLayoutParams(layoutParams6);
                        }
                    }
                    i18++;
                    str2 = str;
                    i16 = 1;
                }
            }
        }
        View findViewById = relativeLayout.findViewById(2);
        if (findViewById != null) {
            RelativeLayout.LayoutParams layoutParams7 = (RelativeLayout.LayoutParams) findViewById.getLayoutParams();
            layoutParams7.addRule(0, 3);
            layoutParams7.rightMargin = BaseAIOUtils.f(7.5f, resources);
            if (relativeLayout.findViewById(1) != null) {
                layoutParams7.addRule(1, 1);
                findViewById.setPadding(BaseAIOUtils.f(7.5f, resources), 0, 0, 0);
            } else {
                layoutParams7.addRule(9, -1);
                findViewById.setPadding(0, 0, 0, 0);
            }
            findViewById.setLayoutParams(layoutParams7);
        }
        relativeLayout.setBackground(null);
        B(relativeLayout);
        relativeLayout.setPadding(BaseAIOUtils.f(11.0f, resources), 0, BaseAIOUtils.f(11.0f, resources), 0);
        return relativeLayout;
    }
}
