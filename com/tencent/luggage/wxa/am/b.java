package com.tencent.luggage.wxa.am;

import android.app.Activity;
import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.tencent.luggage.wxa.mo.x;
import com.tencent.luggage.wxa.tn.c0;
import com.tencent.mobileqq.R;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class b extends x {

    /* renamed from: c, reason: collision with root package name */
    public final boolean f121567c;

    /* renamed from: d, reason: collision with root package name */
    public final TextView f121568d;

    /* renamed from: e, reason: collision with root package name */
    public final ImageView f121569e;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public b(Context context) {
        this(context, false, 2, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public final void a() {
        a(this, 0L, 1, null);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(Context context, boolean z16) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.f121567c = z16;
        Drawable drawable = null;
        if (z16) {
            FrameLayout frameLayout = new FrameLayout(context);
            View.inflate(context, R.layout.dyl, frameLayout);
            setContentView(frameLayout);
            getContentView().findViewById(R.id.g1f).setVisibility(8);
            this.f121569e = (ImageView) getContentView().findViewById(R.id.dvu);
            View findViewById = getContentView().findViewById(R.id.title);
            Intrinsics.checkNotNullExpressionValue(findViewById, "contentView.findViewById(R.id.title)");
            this.f121568d = (TextView) findViewById;
            Drawable drawable2 = ContextCompat.getDrawable(context, R.drawable.m8r);
            if (drawable2 != null) {
                drawable2.mutate().setColorFilter(new PorterDuffColorFilter(-1, PorterDuff.Mode.SRC_ATOP));
                drawable = drawable2;
            }
            a(drawable);
        } else {
            FrameLayout frameLayout2 = new FrameLayout(context);
            View.inflate(context, R.layout.dyk, frameLayout2);
            setContentView(frameLayout2);
            View findViewById2 = getContentView().findViewById(R.id.title);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "contentView.findViewById(R.id.title)");
            this.f121568d = (TextView) findViewById2;
            this.f121569e = null;
        }
        setFocusable(true);
        getContentView().setFocusable(true);
        this.f121568d.setFocusable(true);
    }

    public final b a(CharSequence charSequence) {
        if (!this.f121567c) {
            this.f121568d.setText(charSequence);
            this.f121568d.setContentDescription(charSequence);
            return this;
        }
        if (!(charSequence == null || charSequence.length() == 0)) {
            this.f121568d.setLineSpacing(0.0f, 1.0f);
            this.f121568d.setSpannableFactory(new d(com.tencent.luggage.wxa.kn.a.a(getContentView().getContext(), 17)));
            this.f121568d.setText(charSequence, TextView.BufferType.SPANNABLE);
            this.f121568d.setVisibility(0);
            getContentView().findViewById(R.id.f85234oe).setPadding(0, com.tencent.luggage.wxa.kn.a.a(getContentView().getContext(), 27), 0, 0);
            this.f121568d.setContentDescription(charSequence);
        } else {
            this.f121568d.setVisibility(4);
        }
        return this;
    }

    public final b a(Drawable drawable) {
        Intrinsics.checkNotNull(this.f121569e);
        this.f121569e.setVisibility(0);
        this.f121569e.setScaleType(ImageView.ScaleType.FIT_CENTER);
        this.f121569e.setImageDrawable(drawable);
        this.f121569e.setScaleType(ImageView.ScaleType.FIT_CENTER);
        View findViewById = getContentView().findViewById(R.id.g1f);
        if (findViewById != null) {
            findViewById.setVisibility(8);
        }
        return this;
    }

    public /* synthetic */ b(Context context, boolean z16, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? true : z16);
    }

    public static /* synthetic */ void a(b bVar, long j3, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            j3 = 1500;
        }
        bVar.a(j3);
    }

    public final void a(long j3) {
        Activity h16 = com.tencent.luggage.wxa.po.b.h(getContentView().getContext());
        if (h16 != null) {
            super.showAtLocation(h16.findViewById(android.R.id.content), 17, 0, 0);
            this.f121568d.requestFocus();
            if (j3 != Long.MAX_VALUE) {
                c0.a(new c(this), j3);
            }
        }
    }
}
