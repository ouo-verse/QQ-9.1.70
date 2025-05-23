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
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.structmsg.AbsStructMsgElement;
import com.tencent.mobileqq.widget.PAImageView;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes18.dex */
public class ab {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private com.tencent.mobileqq.structmsg.a f290529a;

    /* renamed from: b, reason: collision with root package name */
    private Context f290530b;

    /* renamed from: c, reason: collision with root package name */
    private int f290531c;

    /* renamed from: d, reason: collision with root package name */
    private int f290532d;

    public ab(com.tencent.mobileqq.structmsg.a aVar, Context context, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, aVar, context, Integer.valueOf(i3));
            return;
        }
        this.f290529a = aVar;
        this.f290530b = context;
        this.f290531c = i3;
        this.f290532d = context.getResources().getDimensionPixelSize(R.dimen.f158266br);
    }

    public static boolean a(com.tencent.mobileqq.structmsg.a aVar, int i3) {
        QQAppInterface qQAppInterface;
        BaseApplicationImpl baseApplicationImpl = BaseApplicationImpl.sApplication;
        if (baseApplicationImpl != null) {
            qQAppInterface = (QQAppInterface) baseApplicationImpl.getRuntime();
        } else {
            qQAppInterface = null;
        }
        if (qQAppInterface == null || TextUtils.isEmpty(aVar.M0)) {
            return false;
        }
        if ((!((IPublicAccountUtil) QRoute.api(IPublicAccountUtil.class)).isMediaAndOtherSubscript(qQAppInterface, aVar.M0) && !"2909288299".equals(aVar.M0) && !"3338705755".equals(aVar.M0)) || i3 != 0) {
            return false;
        }
        int i16 = 0;
        int i17 = 0;
        for (int i18 = 0; i18 < aVar.U0.size(); i18++) {
            String str = aVar.U0.get(i18).f290322e;
            if ("picture".equals(str)) {
                i16++;
            } else if ("summary".equals(str)) {
                if (i16 != 0) {
                    i17++;
                }
            } else if (!"title".equals(str)) {
                return false;
            }
        }
        if (i16 != 1 || i17 > 1) {
            return false;
        }
        return true;
    }

    private TextView d(ap apVar, View view) {
        TextView textView;
        Resources resources = this.f290530b.getResources();
        if (view == null) {
            textView = new TextView(this.f290530b);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            layoutParams.setMargins(0, 0, 0, 0);
            textView.setLayoutParams(layoutParams);
            textView.setMaxLines(3);
            textView.setTextColor(-16777216);
            textView.setTextSize(2, 16.0f);
            textView.setLineSpacing(BaseAIOUtils.f(2.5f, resources), 1.0f);
            textView.setGravity(16);
            textView.setEllipsize(TextUtils.TruncateAt.END);
            int f16 = BaseAIOUtils.f(15.0f, resources);
            int f17 = BaseAIOUtils.f(12.0f, resources);
            textView.setPadding(f17, BaseAIOUtils.f(18.0f, resources), f17, f16);
            if (!TextUtils.isEmpty(apVar.t())) {
                textView.setText(apVar.t().trim());
            }
        } else {
            textView = (TextView) view;
            if (!TextUtils.isEmpty(apVar.t())) {
                textView.setText(apVar.t().trim());
            }
        }
        return textView;
    }

    private TextView e(String str, View view, boolean z16) {
        TextView textView;
        Resources resources = this.f290530b.getResources();
        if (view == null) {
            textView = new TextView(this.f290530b);
            textView.setMaxLines(2);
            textView.setTextColor(-1);
            textView.setTextSize(2, 19.0f);
            textView.setMaxLines(2);
            textView.setLineSpacing(BaseAIOUtils.f(2.5f, resources), 1.0f);
            textView.setGravity(80);
            textView.setEllipsize(TextUtils.TruncateAt.END);
            textView.setIncludeFontPadding(false);
            if (z16) {
                textView.setBackgroundResource(R.drawable.f161223sj);
            }
            int f16 = BaseAIOUtils.f(8.0f, resources);
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
        Resources resources = this.f290530b.getResources();
        if (view != null && (view instanceof FrameLayout)) {
            FrameLayout frameLayout = (FrameLayout) view;
            absStructMsgElement.c(this.f290530b, frameLayout.findViewById(R.id.dgb), bundle);
            return frameLayout;
        }
        FrameLayout frameLayout2 = new FrameLayout(this.f290530b);
        frameLayout2.setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
        frameLayout2.setId(R.id.j6t);
        if (bundle != null) {
            bundle.putBoolean("pa_should_change", true);
        }
        ImageView imageView = (ImageView) absStructMsgElement.c(this.f290530b, null, bundle).findViewById(R.id.dgb);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, this.f290532d);
        if (imageView != null && (imageView instanceof PAImageView)) {
            ((PAImageView) imageView).setUseRadiusRound(true, resources.getDimensionPixelSize(R.dimen.f158265bq));
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
        context.getResources();
        if (!a(this.f290529a, this.f290531c)) {
            return this.f290529a.c(context, view, bundle);
        }
        if (QLog.isColorLevel()) {
            QLog.d("StructMsgItemLayout6Adapter", 2, "layout6 use new style!");
        }
        if (view != null && (view instanceof LinearLayout)) {
            linearLayout = (LinearLayout) view;
            FrameLayout frameLayout = (FrameLayout) linearLayout.findViewById(R.id.j6t);
            if (frameLayout != null) {
                ArrayList arrayList = new ArrayList();
                String str2 = null;
                View view2 = null;
                int i3 = 0;
                boolean z16 = false;
                int i16 = 0;
                while (i3 < this.f290529a.U0.size()) {
                    AbsStructMsgElement absStructMsgElement = this.f290529a.U0.get(i3);
                    String str3 = absStructMsgElement.f290322e;
                    if ("title".equals(str3)) {
                        str = ((StructMsgItemTitle) absStructMsgElement).t();
                    } else if ("picture".equals(str3)) {
                        view2 = b(absStructMsgElement, frameLayout, bundle);
                        str = str2;
                        z16 = true;
                    } else {
                        if ("summary".equals(str3)) {
                            ap apVar = (ap) absStructMsgElement;
                            if (z16 && !TextUtils.isEmpty(apVar.t()) && apVar.t().trim().length() > 0) {
                                arrayList.add(d(apVar, linearLayout.findViewById(i16 + R.id.j77)));
                                i16++;
                            }
                        }
                        str = str2;
                    }
                    i3++;
                    str2 = str;
                }
                linearLayout.removeAllViews();
                if (view2 != null) {
                    TextView textView = (TextView) view2.findViewById(R.id.j75);
                    if (!TextUtils.isEmpty(str2)) {
                        if (textView == null) {
                            TextView e16 = e(str2, null, true);
                            e16.setId(R.id.j75);
                            ((ViewGroup) view2).addView(e16, new ViewGroup.LayoutParams(-1, this.f290532d));
                        } else {
                            e(str2, textView, true);
                        }
                    } else if (textView != null) {
                        ((ViewGroup) view2).removeView(textView);
                    }
                    linearLayout.addView(view2);
                } else {
                    String str4 = str2;
                    if (!TextUtils.isEmpty(str4)) {
                        TextView e17 = e(str4.trim(), null, false);
                        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -2);
                        e17.setGravity(16);
                        linearLayout.addView(e17, 0, layoutParams);
                    }
                }
                if (arrayList.size() > 0) {
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        linearLayout.addView((View) it.next());
                    }
                }
                return linearLayout;
            }
            linearLayout.removeAllViews();
        } else {
            linearLayout = null;
        }
        if (linearLayout == null) {
            linearLayout = new LinearLayout(context);
            linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            linearLayout.setOrientation(1);
        }
        View view3 = null;
        String str5 = null;
        boolean z17 = false;
        for (int i17 = 0; i17 < this.f290529a.U0.size(); i17++) {
            AbsStructMsgElement absStructMsgElement2 = this.f290529a.U0.get(i17);
            String str6 = absStructMsgElement2.f290322e;
            if ("title".equals(str6)) {
                str5 = ((StructMsgItemTitle) absStructMsgElement2).t();
            } else if ("picture".equals(str6)) {
                view3 = b(absStructMsgElement2, null, bundle);
                linearLayout.addView(view3);
                z17 = true;
            } else if ("summary".equals(str6)) {
                ap apVar2 = (ap) absStructMsgElement2;
                if (z17 && !TextUtils.isEmpty(apVar2.t()) && apVar2.t().trim().length() > 0) {
                    TextView d16 = d(apVar2, null);
                    d16.setId(i17 + R.id.j77);
                    linearLayout.addView(d16);
                }
            }
        }
        if (view3 != null && !TextUtils.isEmpty(str5)) {
            ViewGroup.LayoutParams layoutParams2 = new ViewGroup.LayoutParams(-1, this.f290532d);
            TextView e18 = e(str5.trim(), null, true);
            e18.setId(R.id.j75);
            ((ViewGroup) view3).addView(e18, layoutParams2);
        } else if (!TextUtils.isEmpty(str5) && str5.trim().length() > 0) {
            TextView e19 = e(str5.trim(), null, false);
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
            e19.setGravity(16);
            linearLayout.addView(e19, 0, layoutParams3);
        }
        return linearLayout;
    }
}
