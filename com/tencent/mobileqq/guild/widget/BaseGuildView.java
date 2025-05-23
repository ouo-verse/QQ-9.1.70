package com.tencent.mobileqq.guild.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* compiled from: P */
/* loaded from: classes14.dex */
public abstract class BaseGuildView extends FrameLayout implements View.OnClickListener {
    public BaseGuildView(@NonNull Context context) {
        this(context, null);
    }

    private void a(Context context) {
        if (b() != 0) {
            LayoutInflater.from(context).inflate(b(), (ViewGroup) this, true);
        }
        c(context, this);
    }

    public abstract int b();

    protected abstract void c(Context context, View view);

    public BaseGuildView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BaseGuildView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        e();
        a(context);
        d();
    }

    protected void d() {
    }

    protected void e() {
    }
}
