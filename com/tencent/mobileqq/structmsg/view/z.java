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
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.structmsg.AbsStructMsgElement;
import com.tencent.mobileqq.widget.PAImageView;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes18.dex */
public class z {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private com.tencent.mobileqq.structmsg.a f290692a;

    /* renamed from: b, reason: collision with root package name */
    private Context f290693b;

    /* renamed from: c, reason: collision with root package name */
    private int f290694c;

    /* renamed from: d, reason: collision with root package name */
    private TextView f290695d;

    /* renamed from: e, reason: collision with root package name */
    private View f290696e;

    /* renamed from: f, reason: collision with root package name */
    private int f290697f;

    public z(com.tencent.mobileqq.structmsg.a aVar, Context context, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, aVar, context, Integer.valueOf(i3));
            return;
        }
        this.f290692a = aVar;
        this.f290693b = context;
        this.f290694c = i3;
        this.f290697f = context.getResources().getDimensionPixelSize(R.dimen.f158266br);
    }

    public static boolean a(com.tencent.mobileqq.structmsg.a aVar, int i3) {
        if (i3 != 0) {
            return false;
        }
        Iterator<AbsStructMsgElement> it = aVar.U0.iterator();
        while (it.hasNext()) {
            String str = it.next().f290322e;
            if ("picture".equals(str)) {
                return true;
            }
            if (!"title".equals(str)) {
                return false;
            }
        }
        return false;
    }

    private TextView d(String str, View view, boolean z16) {
        TextView textView;
        Resources resources = this.f290693b.getResources();
        if (view == null) {
            textView = new TextView(this.f290693b);
            textView.setMaxLines(2);
            textView.setTextColor(-1);
            textView.setTextSize(2, 19.0f);
            textView.setMaxLines(2);
            textView.setLineSpacing(BaseAIOUtils.f(2.5f, resources), 1.0f);
            textView.setGravity(80);
            textView.setEllipsize(TextUtils.TruncateAt.END);
            if (z16) {
                textView.setBackgroundResource(R.drawable.f161223sj);
            }
            int f16 = BaseAIOUtils.f(12.5f, resources);
            int f17 = BaseAIOUtils.f(12.0f, resources);
            textView.setPadding(f17, 0, f17, f16);
            textView.setId(R.id.j78);
            if (!TextUtils.isEmpty(str)) {
                textView.setText(str);
            }
        } else {
            textView = (TextView) view;
            if (!TextUtils.isEmpty(str)) {
                textView.setText(str);
            }
            if (z16 && textView.getBackground() == null) {
                textView.setBackgroundResource(R.drawable.f161223sj);
            }
        }
        return textView;
    }

    public View b(AbsStructMsgElement absStructMsgElement, View view, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (View) iPatchRedirector.redirect((short) 3, this, absStructMsgElement, view, bundle);
        }
        Resources resources = this.f290693b.getResources();
        if (view != null && (view instanceof FrameLayout)) {
            FrameLayout frameLayout = (FrameLayout) view;
            absStructMsgElement.c(this.f290693b, frameLayout.findViewById(R.id.dgb), bundle);
            return frameLayout;
        }
        FrameLayout frameLayout2 = new FrameLayout(this.f290693b);
        frameLayout2.setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
        frameLayout2.setId(R.id.j6t);
        if (bundle != null) {
            bundle.putBoolean("pa_should_change", true);
        }
        ImageView imageView = (ImageView) absStructMsgElement.c(this.f290693b, null, bundle).findViewById(R.id.dgb);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, this.f290697f);
        if (imageView != null && (imageView instanceof PAImageView)) {
            PAImageView pAImageView = (PAImageView) imageView;
            pAImageView.setUseRadiusRound(true, resources.getDimensionPixelSize(R.dimen.f158265bq));
            pAImageView.setTag(R.id.g4h, 1);
        }
        frameLayout2.addView(imageView, layoutParams);
        return frameLayout2;
    }

    public View c(Context context, View view, Bundle bundle) {
        LinearLayout linearLayout;
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (View) iPatchRedirector.redirect((short) 2, this, context, view, bundle);
        }
        if (!a(this.f290692a, this.f290694c)) {
            return this.f290692a.c(context, view, bundle);
        }
        if (QLog.isColorLevel()) {
            QLog.d("StructMsgItemLayout5Adapter", 2, "layout5 use new style");
        }
        if (view != null && (view instanceof LinearLayout)) {
            linearLayout = (LinearLayout) view;
            FrameLayout frameLayout = (FrameLayout) linearLayout.findViewById(R.id.j6t);
            if (frameLayout != null) {
                Iterator<AbsStructMsgElement> it = this.f290692a.U0.iterator();
                str = null;
                while (it.hasNext()) {
                    AbsStructMsgElement next = it.next();
                    String str2 = next.f290322e;
                    if ("title".equals(str2)) {
                        str = ((StructMsgItemTitle) next).t();
                    } else if ("picture".equals(str2)) {
                        this.f290696e = b(next, frameLayout, bundle);
                    }
                }
                View view2 = this.f290696e;
                if (view2 != null) {
                    TextView textView = (TextView) view2.findViewById(R.id.j75);
                    if (!TextUtils.isEmpty(str)) {
                        if (textView != null) {
                            d(str, textView, true);
                        } else {
                            TextView d16 = d(str, null, true);
                            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, this.f290697f);
                            d16.setId(R.id.j75);
                            ((ViewGroup) this.f290696e).addView(d16, layoutParams);
                        }
                    } else if (textView != null) {
                        ((ViewGroup) this.f290696e).removeView(textView);
                    }
                    return linearLayout;
                }
                linearLayout.removeAllViews();
            } else {
                linearLayout.removeAllViews();
                str = null;
            }
        } else {
            linearLayout = null;
            str = null;
        }
        if (linearLayout == null) {
            linearLayout = new LinearLayout(context);
            linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            linearLayout.setOrientation(1);
            linearLayout.setId(R.id.j76);
        }
        Iterator<AbsStructMsgElement> it5 = this.f290692a.U0.iterator();
        while (it5.hasNext()) {
            AbsStructMsgElement next2 = it5.next();
            String str3 = next2.f290322e;
            if ("title".equals(str3)) {
                str = ((StructMsgItemTitle) next2).t();
            } else if ("picture".equals(str3)) {
                this.f290696e = b(next2, null, bundle);
            }
        }
        if (this.f290696e != null) {
            if (!TextUtils.isEmpty(str)) {
                ViewGroup.LayoutParams layoutParams2 = new ViewGroup.LayoutParams(-1, this.f290697f);
                TextView d17 = d(str.trim(), null, true);
                d17.setId(R.id.j75);
                ((ViewGroup) this.f290696e).addView(d17, layoutParams2);
            }
            linearLayout.addView(this.f290696e);
        } else if (!TextUtils.isEmpty(str) && str.trim().length() > 0) {
            this.f290695d = d(str.trim(), null, false);
            this.f290695d.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
            int f16 = BaseAIOUtils.f(12.0f, this.f290693b.getResources());
            this.f290695d.setPadding(f16, f16, f16, f16);
            this.f290695d.setId(R.id.j78);
            this.f290695d.setGravity(16);
            linearLayout.addView(this.f290695d);
        }
        return linearLayout;
    }
}
