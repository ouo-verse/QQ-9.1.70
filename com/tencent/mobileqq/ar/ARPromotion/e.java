package com.tencent.mobileqq.ar.ARPromotion;

import android.content.Context;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes11.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    private Context f196889a;

    /* renamed from: b, reason: collision with root package name */
    private FrameLayout f196890b;

    /* renamed from: c, reason: collision with root package name */
    private TextView f196891c;

    /* renamed from: d, reason: collision with root package name */
    private volatile boolean f196892d = false;

    public e(Context context) {
        this.f196889a = context;
        c();
    }

    private void c() {
        FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(this.f196889a).inflate(R.layout.ar_, (ViewGroup) null);
        this.f196890b = frameLayout;
        this.f196891c = (TextView) frameLayout.findViewById(R.id.l56);
    }

    public void a(RelativeLayout relativeLayout) {
        QLog.d("ARTransferPromotionUIContainer", 2, "attachToRootViewGroup");
        if (this.f196892d) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        layoutParams.bottomMargin = BaseAIOUtils.f(57.0f, this.f196889a.getResources());
        relativeLayout.addView(this.f196890b, layoutParams);
        this.f196892d = true;
    }

    public void b(RelativeLayout relativeLayout) {
        QLog.d("ARTransferPromotionUIContainer", 2, "disattachFromRootViewGroup");
        if (this.f196892d && Thread.currentThread() == Looper.getMainLooper().getThread()) {
            relativeLayout.removeView(this.f196890b);
            this.f196892d = false;
        }
    }

    public void d(String str) {
        this.f196891c.setVisibility(0);
        this.f196891c.setText(str);
    }
}
