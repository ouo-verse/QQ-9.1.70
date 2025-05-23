package com.qwallet.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* compiled from: P */
/* loaded from: classes3.dex */
public abstract class BaseLayout extends FrameLayout {

    /* renamed from: d, reason: collision with root package name */
    public View f41789d;

    public BaseLayout(@NonNull Context context) {
        super(context);
        this.f41789d = b(context);
    }

    private View b(Context context) {
        return LayoutInflater.from(context).inflate(a(), (ViewGroup) null, false);
    }

    protected abstract int a();

    public BaseLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f41789d = b(context);
    }
}
