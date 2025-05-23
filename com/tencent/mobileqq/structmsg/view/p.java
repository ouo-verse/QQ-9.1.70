package com.tencent.mobileqq.structmsg.view;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.structmsg.AbsStructMsgElement;
import com.tencent.mobileqq.widget.PAImageView;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes18.dex */
public class p extends com.tencent.mobileqq.structmsg.a {
    static IPatchRedirector $redirector_;
    private TextView X0;

    public p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private void E(Context context, Resources resources, RelativeLayout relativeLayout, View view, LinearLayout linearLayout, TextView textView, TextView textView2) {
        float f16 = resources.getDisplayMetrics().density;
        relativeLayout.addView(view, new RelativeLayout.LayoutParams(-1, -1));
        FrameLayout frameLayout = new FrameLayout(context);
        frameLayout.setId(R.id.iyd);
        ImageView imageView = new ImageView(context);
        imageView.setImageResource(R.drawable.h2w);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 80;
        frameLayout.addView(imageView, layoutParams);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 17;
        frameLayout.addView(linearLayout, layoutParams2);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams3.addRule(14);
        layoutParams3.addRule(10);
        layoutParams3.topMargin = (int) (32.0f * f16);
        relativeLayout.addView(frameLayout, layoutParams3);
        textView2.setId(R.id.iye);
        textView2.setIncludeFontPadding(false);
        textView2.setSingleLine(false);
        textView2.setMaxLines(2);
        textView2.setTextSize(1, 40.0f);
        textView2.setTextColor(-1);
        textView2.setGravity(17);
        textView2.getPaint().setFakeBoldText(true);
        this.X0 = textView2;
        int i3 = (int) (240.0f * f16);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(i3, -2);
        layoutParams4.addRule(14);
        layoutParams4.addRule(3, R.id.iyd);
        int i16 = (int) (5.0f * f16);
        layoutParams4.topMargin = i16;
        layoutParams4.bottomMargin = i16;
        relativeLayout.addView(textView2, layoutParams4);
        ImageView imageView2 = new ImageView(context);
        imageView2.setId(R.id.iyf);
        imageView2.setImageResource(R.drawable.h2y);
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams5.addRule(14);
        layoutParams5.addRule(3, R.id.iye);
        relativeLayout.addView(imageView2, layoutParams5);
        RelativeLayout relativeLayout2 = new RelativeLayout(context);
        ImageView imageView3 = new ImageView(context);
        imageView3.setId(R.id.iyh);
        imageView3.setImageResource(R.drawable.h2z);
        RelativeLayout.LayoutParams layoutParams6 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams6.addRule(13);
        relativeLayout2.addView(imageView3, layoutParams6);
        ImageView imageView4 = new ImageView(context);
        imageView4.setImageResource(R.drawable.h2v);
        RelativeLayout.LayoutParams layoutParams7 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams7.addRule(15);
        layoutParams7.addRule(0, R.id.iyh);
        int i17 = (int) (6.0f * f16);
        layoutParams7.rightMargin = i17;
        relativeLayout2.addView(imageView4, layoutParams7);
        textView.setIncludeFontPadding(false);
        textView.setTextSize(1, 22.0f);
        textView.setTextColor(-1);
        textView.getPaint().setFakeBoldText(true);
        RelativeLayout.LayoutParams layoutParams8 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams8.addRule(15);
        layoutParams8.addRule(1, R.id.iyh);
        layoutParams8.leftMargin = i17;
        relativeLayout2.addView(textView, layoutParams8);
        RelativeLayout.LayoutParams layoutParams9 = new RelativeLayout.LayoutParams(i3, -2);
        layoutParams9.addRule(14);
        layoutParams9.addRule(3, R.id.iyf);
        layoutParams9.topMargin = (int) (f16 * 10.0f);
        relativeLayout.addView(relativeLayout2, layoutParams9);
    }

    @Override // com.tencent.mobileqq.structmsg.a
    protected int w() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        return 25;
    }

    @Override // com.tencent.mobileqq.structmsg.a
    public String x() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return "layout25";
    }

    @Override // com.tencent.mobileqq.structmsg.a
    public View y(Context context, View view, Bundle bundle) {
        LinearLayout linearLayout;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (View) iPatchRedirector.redirect((short) 4, this, context, view, bundle);
        }
        Resources resources = context.getResources();
        if (view != null && (view instanceof LinearLayout)) {
            linearLayout = (LinearLayout) view;
            linearLayout.removeAllViews();
        } else {
            linearLayout = new LinearLayout(context);
            linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            linearLayout.setOrientation(1);
        }
        ViewGroup viewGroup = linearLayout;
        RelativeLayout relativeLayout = new RelativeLayout(context);
        relativeLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, BaseAIOUtils.f(290.0f, resources)));
        viewGroup.addView(relativeLayout);
        Iterator<AbsStructMsgElement> it = this.U0.iterator();
        int i3 = 0;
        TextView textView = null;
        View view2 = null;
        LinearLayout linearLayout2 = null;
        TextView textView2 = null;
        while (it.hasNext()) {
            AbsStructMsgElement next = it.next();
            String str = next.f290322e;
            if ("type".equals(str) && (next instanceof au)) {
                i3 = ((au) next).R0;
                if (QLog.isColorLevel()) {
                    QLog.d("StructMsgItemLayout25", 2, "getView socialType=" + i3);
                }
            } else if ("title".equals(str) && textView2 == null) {
                if (next instanceof StructMsgItemTitle) {
                    ((StructMsgItemTitle) next).N(z(), this.S0);
                }
                textView2 = (TextView) next.c(context, null, bundle);
                textView2.setSingleLine();
                textView2.setEllipsize(TextUtils.TruncateAt.END);
                textView2.getPaint().setFakeBoldText(true);
            } else if ("summary".equals(str) && textView == null) {
                textView = (TextView) next.c(context, null, bundle);
                textView.setSingleLine();
                textView.setEllipsize(TextUtils.TruncateAt.END);
            } else if ("picture".equals(str) && view2 == null) {
                view2 = next.c(context, null, bundle);
                if (view2 != null && (view2 instanceof PAImageView)) {
                    ((PAImageView) view2).setUseRadiusRound(true, resources.getDimensionPixelSize(R.dimen.f158265bq));
                }
            } else if ("head".equals(str) && (next instanceof a) && linearLayout2 == null) {
                ((a) next).R0 = i3;
                linearLayout2 = (LinearLayout) next.c(context, null, bundle);
            }
        }
        View c16 = new ak(context.getString(R.string.hnt)).c(context, null, null);
        ViewGroup.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        int f16 = BaseAIOUtils.f(15.0f, resources);
        c16.setLayoutParams(layoutParams);
        c16.setPadding(f16, f16, f16, f16);
        TextView textView3 = (TextView) c16.findViewById(R.id.f166928j55);
        textView3.setSingleLine();
        textView3.setEllipsize(TextUtils.TruncateAt.END);
        textView3.setTextSize(1, 18.0f);
        viewGroup.addView(c16);
        if (textView2 != null && textView != null && view2 != null && linearLayout2 != null) {
            if (i3 == 4) {
                E(context, resources, relativeLayout, view2, linearLayout2, textView2, textView);
                textView3.setText(HardCodeUtil.qqStr(R.string.twf));
                return viewGroup;
            }
            relativeLayout.addView(view2, new RelativeLayout.LayoutParams(-1, -1));
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams2.addRule(14);
            layoutParams2.topMargin = BaseAIOUtils.f(25.0f, resources);
            textView2.setLayoutParams(layoutParams2);
            textView2.setId(R.id.iyg);
            relativeLayout.addView(textView2);
            RelativeLayout relativeLayout2 = new RelativeLayout(context);
            RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams3.addRule(13);
            textView.setLayoutParams(layoutParams3);
            relativeLayout2.addView(textView);
            ImageView imageView = new ImageView(context);
            imageView.setImageResource(R.drawable.h2p);
            RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams4.addRule(0, textView.getId());
            layoutParams4.addRule(15);
            layoutParams4.rightMargin = BaseAIOUtils.f(7.0f, resources);
            relativeLayout2.addView(imageView, layoutParams4);
            ImageView imageView2 = new ImageView(context);
            imageView2.setImageResource(R.drawable.h2q);
            RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams5.addRule(1, textView.getId());
            layoutParams5.addRule(15);
            layoutParams5.leftMargin = BaseAIOUtils.f(7.0f, resources);
            relativeLayout2.addView(imageView2, layoutParams5);
            RelativeLayout.LayoutParams layoutParams6 = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams6.topMargin = BaseAIOUtils.f(5.0f, resources);
            layoutParams6.addRule(3, R.id.iyg);
            relativeLayout2.setLayoutParams(layoutParams6);
            relativeLayout2.setId(R.id.iye);
            relativeLayout.addView(relativeLayout2);
            RelativeLayout.LayoutParams layoutParams7 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams7.addRule(14);
            layoutParams7.addRule(3, R.id.iye);
            layoutParams7.topMargin = BaseAIOUtils.f(10.0f, resources);
            linearLayout2.setId(R.id.iyd);
            linearLayout2.setLayoutParams(layoutParams7);
            relativeLayout.addView(linearLayout2);
            textView2.setTextSize(2, 14.0f);
            textView2.setTextColor(-1);
            textView.setTextSize(2, 30.0f);
            textView.setTextColor(-1);
        }
        return viewGroup;
    }
}
