package com.tencent.mobileqq.search.business.net.view;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.util.x;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes18.dex */
public class e implements sn2.d {

    /* renamed from: h, reason: collision with root package name */
    public static final String f283043h = "e";

    /* renamed from: d, reason: collision with root package name */
    public final int f283044d;

    /* renamed from: e, reason: collision with root package name */
    public View f283045e;

    /* renamed from: f, reason: collision with root package name */
    public Context f283046f;

    public e(Context context, int i3) {
        if (context != null) {
            if (i3 < 0 || i3 > 2) {
                QLog.e(f283043h, 1, "type is illegal, type = 0");
                i3 = 0;
            }
            this.f283046f = context;
            this.f283044d = i3;
            return;
        }
        throw new IllegalArgumentException(f283043h + "type is illegal, type = " + i3);
    }

    @Override // sn2.d
    public View getView() {
        View view = this.f283045e;
        if (view != null) {
            return view;
        }
        boolean isInNightMode = ThemeUtil.isInNightMode(MobileQQ.sMobileQQ.peekAppRuntime());
        RelativeLayout relativeLayout = new RelativeLayout(this.f283046f);
        int i3 = this.f283044d;
        if (i3 != 1) {
            if (i3 == 2) {
                relativeLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, x.c(this.f283046f, 18.0f)));
            }
        } else {
            relativeLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, x.c(this.f283046f, 12.0f)));
            View view2 = new View(this.f283046f);
            if (isInNightMode) {
                view2.setBackgroundColor(this.f283046f.getResources().getColor(R.color.aci));
            } else {
                view2.setBackgroundColor(this.f283046f.getResources().getColor(R.color.ach));
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, 1);
            layoutParams.addRule(15);
            layoutParams.leftMargin = x.c(this.f283046f, 15.0f);
            layoutParams.rightMargin = x.c(this.f283046f, 15.0f);
            relativeLayout.addView(view2, layoutParams);
        }
        if (isInNightMode) {
            relativeLayout.setBackgroundColor(this.f283046f.getResources().getColor(R.color.ac8));
        } else {
            relativeLayout.setBackgroundColor(this.f283046f.getResources().getColor(R.color.f158017al3));
        }
        this.f283045e = relativeLayout;
        return relativeLayout;
    }
}
