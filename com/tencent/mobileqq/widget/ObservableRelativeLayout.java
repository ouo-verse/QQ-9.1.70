package com.tencent.mobileqq.widget;

import android.content.Context;
import android.widget.RelativeLayout;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

/* compiled from: P */
/* loaded from: classes20.dex */
public class ObservableRelativeLayout extends RelativeLayout {

    /* renamed from: d, reason: collision with root package name */
    private MutableLiveData<Float> f315891d;

    public ObservableRelativeLayout(Context context) {
        super(context, null);
        this.f315891d = new MutableLiveData<>(Float.valueOf(0.0f));
    }

    private void a(float f16) {
        Float value = this.f315891d.getValue();
        if (value != null && value.floatValue() == f16) {
            return;
        }
        this.f315891d.setValue(Float.valueOf(f16));
    }

    public void b(LifecycleOwner lifecycleOwner, Observer<Float> observer) {
        this.f315891d.observe(lifecycleOwner, observer);
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i3, int i16) {
        super.onMeasure(i3, i16);
        a(getY());
    }

    @Override // android.view.View
    public void setTranslationY(float f16) {
        super.setTranslationY(f16);
        a(getY());
    }

    @Override // android.view.View
    public void setY(float f16) {
        super.setY(f16);
        a(f16);
    }
}
