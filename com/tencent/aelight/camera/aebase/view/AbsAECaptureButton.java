package com.tencent.aelight.camera.aebase.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import com.tencent.aelight.camera.ae.view.b;

/* compiled from: P */
/* loaded from: classes32.dex */
public abstract class AbsAECaptureButton extends RelativeLayout implements com.tencent.aelight.camera.aebase.view.a, zq.a {

    /* compiled from: P */
    /* loaded from: classes32.dex */
    public interface a {
        void a();

        void d();

        boolean e();

        void f();

        void g();

        void h();

        void o();
    }

    public AbsAECaptureButton(Context context) {
        super(context);
    }

    public abstract /* synthetic */ void setFunctionFlag(int i3);

    public abstract /* synthetic */ void setMaxDuration(float f16);

    public abstract /* synthetic */ void setTouchEnable(boolean z16);

    public AbsAECaptureButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public AbsAECaptureButton(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
    }

    public void h(boolean z16) {
    }

    public void setGifMode(boolean z16) {
    }

    public void g(boolean z16, b bVar) {
    }
}
