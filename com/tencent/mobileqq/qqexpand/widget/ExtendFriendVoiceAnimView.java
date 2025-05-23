package com.tencent.mobileqq.qqexpand.widget;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;

/* compiled from: P */
/* loaded from: classes16.dex */
public class ExtendFriendVoiceAnimView extends FrameLayout {

    /* renamed from: d, reason: collision with root package name */
    private long f264151d;

    /* renamed from: e, reason: collision with root package name */
    private View f264152e;

    /* renamed from: f, reason: collision with root package name */
    private View f264153f;

    public ExtendFriendVoiceAnimView(@NonNull Context context) {
        super(context);
        this.f264151d = 800L;
        a(context);
    }

    private void a(Context context) {
        this.f264152e = new View(context);
        this.f264153f = new View(context);
        addView(this.f264152e, new FrameLayout.LayoutParams(-1, -1, 17));
        addView(this.f264153f, new FrameLayout.LayoutParams(-1, -1, 17));
        this.f264152e.setAlpha(0.0f);
        this.f264153f.setAlpha(0.0f);
    }

    public void setCircleParams(int i3, int i16) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(1);
        gradientDrawable.setColor(i3);
        this.f264152e.setBackgroundDrawable(gradientDrawable);
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setShape(1);
        gradientDrawable2.setColor(i3);
        this.f264153f.setBackgroundDrawable(gradientDrawable2);
        if (i16 > 0) {
            this.f264151d = i16;
        }
    }

    public ExtendFriendVoiceAnimView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f264151d = 800L;
        a(context);
    }

    public ExtendFriendVoiceAnimView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f264151d = 800L;
        a(context);
    }
}
