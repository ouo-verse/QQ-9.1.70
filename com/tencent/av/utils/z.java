package com.tencent.av.utils;

import android.app.Notification;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes3.dex */
public class z {

    /* renamed from: a, reason: collision with root package name */
    Integer f77186a = null;

    /* renamed from: b, reason: collision with root package name */
    float f77187b = 14.0f;

    /* renamed from: c, reason: collision with root package name */
    Integer f77188c = null;

    /* renamed from: d, reason: collision with root package name */
    float f77189d = 16.0f;

    /* renamed from: e, reason: collision with root package name */
    DisplayMetrics f77190e = new DisplayMetrics();

    /* renamed from: f, reason: collision with root package name */
    Context f77191f;

    public z(Context context) {
        this.f77191f = context;
        ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(this.f77190e);
        if (this.f77186a != null && this.f77188c != null) {
            return;
        }
        try {
            Notification build = new Notification.Builder(this.f77191f).setContentTitle("SearchForTitle").setContentText("SearchForText").build();
            LinearLayout linearLayout = new LinearLayout(this.f77191f);
            ViewGroup viewGroup = (ViewGroup) build.contentView.apply(this.f77191f, linearLayout);
            b(viewGroup);
            a(viewGroup);
            linearLayout.removeAllViews();
        } catch (Exception unused) {
            QLog.e("NotificationStyleDiscover", 2, "erro");
        }
    }

    boolean a(ViewGroup viewGroup) {
        int childCount = viewGroup.getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            if (viewGroup.getChildAt(i3) instanceof TextView) {
                TextView textView = (TextView) viewGroup.getChildAt(i3);
                if ("SearchForText".equals(textView.getText().toString())) {
                    this.f77186a = Integer.valueOf(textView.getTextColors().getDefaultColor());
                    float textSize = textView.getTextSize();
                    this.f77187b = textSize;
                    this.f77187b = textSize / this.f77190e.scaledDensity;
                    return true;
                }
            } else if ((viewGroup.getChildAt(i3) instanceof ViewGroup) && a((ViewGroup) viewGroup.getChildAt(i3))) {
                return true;
            }
        }
        return false;
    }

    boolean b(ViewGroup viewGroup) {
        int childCount = viewGroup.getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            if (viewGroup.getChildAt(i3) instanceof TextView) {
                TextView textView = (TextView) viewGroup.getChildAt(i3);
                if ("SearchForTitle".equals(textView.getText().toString())) {
                    this.f77188c = Integer.valueOf(textView.getTextColors().getDefaultColor());
                    float textSize = textView.getTextSize();
                    this.f77189d = textSize;
                    this.f77189d = textSize / this.f77190e.scaledDensity;
                    return true;
                }
            } else if ((viewGroup.getChildAt(i3) instanceof ViewGroup) && b((ViewGroup) viewGroup.getChildAt(i3))) {
                return true;
            }
        }
        return false;
    }
}
