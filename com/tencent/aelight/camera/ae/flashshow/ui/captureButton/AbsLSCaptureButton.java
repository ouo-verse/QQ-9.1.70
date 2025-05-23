package com.tencent.aelight.camera.ae.flashshow.ui.captureButton;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

/* compiled from: P */
/* loaded from: classes32.dex */
public abstract class AbsLSCaptureButton extends RelativeLayout implements com.tencent.aelight.camera.ae.flashshow.ui.captureButton.a, oq.a {

    /* compiled from: P */
    /* loaded from: classes32.dex */
    public interface a {
        void a();

        void d();

        boolean e();

        void f();

        void g();

        void h();
    }

    public AbsLSCaptureButton(Context context) {
        super(context);
    }

    public abstract /* synthetic */ void setFunctionFlag(int i3);

    public abstract /* synthetic */ void setMaxDuration(float f16);

    public abstract /* synthetic */ void setTouchEnable(boolean z16);

    public AbsLSCaptureButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public AbsLSCaptureButton(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
    }
}
