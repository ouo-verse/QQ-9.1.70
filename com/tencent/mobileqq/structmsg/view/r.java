package com.tencent.mobileqq.structmsg.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.structmsg.AbsStructMsgElement;
import com.tencent.mobileqq.widget.BubbleViewLayout;
import java.util.Calendar;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes18.dex */
public class r extends com.tencent.mobileqq.structmsg.a {
    static IPatchRedirector $redirector_;
    protected final float X0;
    private boolean Y0;

    public r() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.X0 = 10.0f;
            this.Y0 = false;
        }
    }

    @Override // com.tencent.mobileqq.structmsg.a
    protected int w() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        return 27;
    }

    @Override // com.tencent.mobileqq.structmsg.a
    public String x() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return "layout27";
    }

    @Override // com.tencent.mobileqq.structmsg.a
    public View y(Context context, View view, Bundle bundle) {
        ViewGroup viewGroup;
        boolean z16;
        char c16;
        boolean z17;
        View view2;
        float f16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (View) iPatchRedirector.redirect((short) 4, this, context, view, bundle);
        }
        boolean z18 = bundle.getBoolean("isSend", true);
        this.Y0 = bundle.getBoolean("pre_dialog", false);
        Resources resources = context.getResources();
        int i3 = -2;
        if (view != null && (view instanceof LinearLayout)) {
            ViewGroup viewGroup2 = (LinearLayout) view;
            viewGroup2.removeAllViews();
            viewGroup = viewGroup2;
        } else {
            LinearLayout linearLayout = new LinearLayout(context);
            linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
            linearLayout.setOrientation(1);
            viewGroup = linearLayout;
        }
        viewGroup.setId(R.id.epa);
        BubbleViewLayout bubbleViewLayout = new BubbleViewLayout(context);
        bubbleViewLayout.setId(R.id.ep_);
        if (this.Y0) {
            bubbleViewLayout.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        } else {
            bubbleViewLayout.setLayoutParams(new LinearLayout.LayoutParams(BaseChatItemLayout.M - BaseAIOUtils.f(20.0f, resources), -2));
        }
        viewGroup.setFocusable(false);
        if (viewGroup.getParent() != null && (viewGroup.getParent() instanceof View)) {
            ((View) viewGroup.getParent()).setFocusable(false);
        }
        viewGroup.addView(bubbleViewLayout);
        RelativeLayout relativeLayout = new RelativeLayout(context);
        relativeLayout.setId(R.id.f166228ep4);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        bubbleViewLayout.addView(relativeLayout, 0);
        if (this.Y0) {
            if (this.R0 == 1) {
                relativeLayout.setBackgroundResource(R.drawable.f161695el4);
            } else {
                relativeLayout.setBackgroundResource(R.drawable.el5);
            }
            bubbleViewLayout.e(false);
            bubbleViewLayout.d(false);
            relativeLayout.setLayoutParams(layoutParams);
        } else {
            if (z18) {
                layoutParams.addRule(9);
            } else {
                layoutParams.addRule(11);
            }
            relativeLayout.setLayoutParams(layoutParams);
            ImageView imageView = new ImageView(context);
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
            if (!z18) {
                layoutParams2.addRule(9);
                layoutParams2.addRule(0, R.id.f166228ep4);
            } else {
                layoutParams2.addRule(11);
                layoutParams2.addRule(1, R.id.f166228ep4);
            }
            imageView.setLayoutParams(layoutParams2);
            imageView.setId(R.id.f166612gn1);
            if (bubbleViewLayout.f315477i != z18) {
                bubbleViewLayout.f315477i = z18;
            }
            if (this.R0 == 1) {
                relativeLayout.setBackgroundResource(R.drawable.f161690el0);
                imageView.setImageDrawable(resources.getDrawable(R.drawable.f161693el3));
            } else {
                relativeLayout.setBackgroundResource(R.drawable.f161691el1);
                imageView.setImageDrawable(resources.getDrawable(R.drawable.f161692el2));
            }
            relativeLayout.setFocusable(false);
            relativeLayout.setFocusableInTouchMode(false);
            relativeLayout.setClickable(false);
            bubbleViewLayout.setRadius(10.0f);
            bubbleViewLayout.e(false);
        }
        Iterator<AbsStructMsgElement> it = this.U0.iterator();
        View view3 = null;
        LinearLayout linearLayout2 = null;
        LinearLayout linearLayout3 = null;
        while (it.hasNext()) {
            AbsStructMsgElement next = it.next();
            String str = next.f290322e;
            if ("title".equals(str)) {
                TextView textView = (TextView) next.c(context, view3, bundle);
                textView.setSingleLine();
                RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, i3);
                int dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.f158685ma);
                int dimensionPixelSize2 = resources.getDimensionPixelSize(R.dimen.f158271bw);
                if (z18) {
                    layoutParams3.setMargins(0, 0, 0, 0);
                } else {
                    layoutParams3.setMargins(0, 0, 0, 0);
                }
                layoutParams3.addRule(12);
                z16 = z18;
                c16 = '\u3844';
                layoutParams3.addRule(3, R.id.f166228ep4);
                textView.setLayoutParams(layoutParams3);
                textView.setPadding(dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize2);
                textView.setSingleLine();
                textView.setEllipsize(TextUtils.TruncateAt.END);
                textView.setBackgroundColor(resources.getColor(R.color.f158017al3));
                bubbleViewLayout.addView(textView);
                view2 = null;
                z17 = false;
            } else {
                z16 = z18;
                c16 = '\u3844';
                if ("summary".equals(str)) {
                    try {
                        long parseLong = Long.parseLong(((ap) next).X0);
                        Calendar calendar = Calendar.getInstance();
                        calendar.setTimeInMillis(parseLong * 1000);
                        TextView textView2 = new TextView(context);
                        textView2.setId(R.id.jl7);
                        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(BaseAIOUtils.f(68.0f, resources), BaseAIOUtils.f(18.0f, resources));
                        layoutParams4.addRule(14);
                        if (this.Y0) {
                            f16 = 51.0f;
                        } else {
                            f16 = 44.0f;
                        }
                        layoutParams4.topMargin = BaseAIOUtils.f(f16, resources);
                        textView2.setLayoutParams(layoutParams4);
                        Object[] objArr = new Object[2];
                        try {
                            objArr[0] = Integer.valueOf(calendar.get(2) + 1);
                            objArr[1] = Integer.valueOf(calendar.get(5));
                            textView2.setText(String.format("%d\u6708%d\u65e5", objArr));
                            relativeLayout.addView(textView2);
                            textView2.setSingleLine();
                            z17 = false;
                            try {
                                textView2.setIncludeFontPadding(false);
                                textView2.setGravity(17);
                                textView2.setTextSize(14.0f);
                                if (this.R0 == 1) {
                                    textView2.setTextColor(resources.getColor(R.color.f156721a3));
                                } else {
                                    textView2.setTextColor(Color.parseColor("#ff455e"));
                                    textView2.setAlpha(0.8f);
                                }
                            } catch (Exception unused) {
                            }
                        } catch (Exception unused2) {
                            z17 = false;
                        }
                    } catch (Exception unused3) {
                        z17 = false;
                    }
                } else {
                    z17 = false;
                    if ("head".equals(str) && (next instanceof a)) {
                        bundle.putInt("bundle_args_avatar_width", BaseAIOUtils.f(52.0f, resources));
                        bundle.putInt("bundle_args_avatar_height", BaseAIOUtils.f(52.0f, resources));
                        bundle.putInt("bundle_args_cover_width", BaseAIOUtils.f(52.0f, resources));
                        bundle.putInt("bundle_args_cover_height", BaseAIOUtils.f(52.0f, resources));
                        if (BaseApplicationImpl.sApplication.getRuntime().getAccount().equalsIgnoreCase(((a) next).S0)) {
                            view2 = null;
                            linearLayout2 = (LinearLayout) next.c(context, null, bundle);
                        } else {
                            view2 = null;
                            linearLayout3 = (LinearLayout) next.c(context, null, bundle);
                        }
                    }
                }
                view2 = null;
            }
            view3 = view2;
            z18 = z16;
            i3 = -2;
        }
        RelativeLayout relativeLayout2 = new RelativeLayout(context);
        relativeLayout2.setId(R.id.a3j);
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams5.addRule(14);
        if (this.Y0) {
            layoutParams5.topMargin = BaseAIOUtils.f(9.0f, resources);
        } else {
            layoutParams5.topMargin = BaseAIOUtils.f(7.0f, resources);
        }
        layoutParams5.addRule(3, R.id.jl7);
        relativeLayout2.setLayoutParams(layoutParams5);
        relativeLayout.addView(relativeLayout2);
        RelativeLayout.LayoutParams layoutParams6 = new RelativeLayout.LayoutParams(BaseAIOUtils.f(52.0f, resources), BaseAIOUtils.f(52.0f, resources));
        if (linearLayout2 == null) {
            linearLayout2 = new LinearLayout(context);
        }
        linearLayout2.setId(R.id.imv);
        linearLayout2.setGravity(5);
        linearLayout2.setLayoutParams(layoutParams6);
        relativeLayout2.addView(linearLayout2);
        RelativeLayout.LayoutParams layoutParams7 = new RelativeLayout.LayoutParams(BaseAIOUtils.f(52.0f, resources), BaseAIOUtils.f(52.0f, resources));
        layoutParams7.addRule(1, R.id.imv);
        layoutParams7.leftMargin = BaseAIOUtils.f(15.0f, resources);
        if (linearLayout3 == null) {
            linearLayout3 = new LinearLayout(context);
        }
        linearLayout3.setId(R.id.cnp);
        linearLayout3.setGravity(3);
        linearLayout3.setLayoutParams(layoutParams7);
        relativeLayout2.addView(linearLayout3);
        return viewGroup;
    }
}
