package com.tencent.mobileqq.winkpublish.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* loaded from: classes21.dex */
public abstract class BaseProgressView extends FrameLayout {
    public BaseProgressView(@NonNull Context context) {
        this(context, null);
    }

    private void initView(Context context) {
        if (onGetLayoutId() != 0) {
            LayoutInflater.from(context).inflate(onGetLayoutId(), (ViewGroup) this, true);
        }
        onInitView(context, this);
    }

    public abstract int onGetLayoutId();

    protected abstract void onInitView(Context context, View view);

    public BaseProgressView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BaseProgressView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        initView(context);
    }
}
