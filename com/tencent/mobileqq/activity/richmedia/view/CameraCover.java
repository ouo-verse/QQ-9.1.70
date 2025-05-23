package com.tencent.mobileqq.activity.richmedia.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;

/* compiled from: P */
/* loaded from: classes10.dex */
public class CameraCover extends FrameLayout {

    /* renamed from: d, reason: collision with root package name */
    private View f186022d;

    /* compiled from: P */
    /* loaded from: classes10.dex */
    public interface a {
        void a(String str);
    }

    public CameraCover(Context context) {
        this(context, null);
    }

    public void setCameraView(View view) {
        this.f186022d = view;
    }

    public CameraCover(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CameraCover(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
    }
}
