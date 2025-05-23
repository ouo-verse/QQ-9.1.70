package com.tencent.luggage.wxa.z1;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.tencent.luggage.wxa.tn.w;

/* compiled from: P */
/* loaded from: classes9.dex */
public class g extends FrameLayout {

    /* renamed from: a, reason: collision with root package name */
    public b f146181a;

    /* renamed from: b, reason: collision with root package name */
    public Activity f146182b;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public interface a {
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public enum b {
        UNDEFINED,
        PORTRAIT,
        LANDSCAPE,
        PORTRAIT_REVERSE,
        LANDSCAPE_REVERSE
    }

    public g(Context context) {
        this(context, null);
    }

    public final b a(int i3) {
        if (i3 == 0) {
            return b.PORTRAIT;
        }
        if (i3 == 1) {
            return b.LANDSCAPE;
        }
        if (i3 == 2) {
            return b.PORTRAIT_REVERSE;
        }
        if (i3 != 3) {
            w.b("MicroMsg.WAContainerView", "hy: invalid rotate: %d!", Integer.valueOf(i3));
            return b.UNDEFINED;
        }
        return b.LANDSCAPE_REVERSE;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        super.onLayout(z16, i3, i16, i17, i18);
        Activity activity = this.f146182b;
        if (activity != null) {
            this.f146181a = a(activity.getWindowManager().getDefaultDisplay().getRotation());
        }
    }

    public g(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public g(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f146181a = null;
        this.f146182b = com.tencent.luggage.wxa.bo.a.a(getContext());
    }

    public void a(Activity activity) {
        this.f146182b = activity;
    }

    public void a() {
        this.f146182b = null;
    }

    public void setOnConfigurationChangedListener(a aVar) {
    }
}
