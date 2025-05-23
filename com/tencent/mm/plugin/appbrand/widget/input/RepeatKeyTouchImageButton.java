package com.tencent.mm.plugin.appbrand.widget.input;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.annotation.UiThread;
import androidx.appcompat.widget.AppCompatImageButton;
import com.tencent.luggage.wxa.ol.w0;
import com.tencent.mm.plugin.appbrand.widget.input.a;

/* compiled from: P */
/* loaded from: classes9.dex */
public class RepeatKeyTouchImageButton extends AppCompatImageButton implements a.b {

    /* renamed from: a, reason: collision with root package name */
    public final a f152390a;

    /* renamed from: b, reason: collision with root package name */
    public w0 f152391b;

    public RepeatKeyTouchImageButton(Context context) {
        super(context);
        this.f152390a = new a(this);
        this.f152391b = null;
    }

    @Override // com.tencent.mm.plugin.appbrand.widget.input.a.b
    public void a() {
        d();
    }

    @Override // com.tencent.mm.plugin.appbrand.widget.input.a.b
    public void b() {
        c();
    }

    public final boolean c() {
        w0 w0Var = this.f152391b;
        if (w0Var != null) {
            w0Var.b();
            return true;
        }
        return false;
    }

    public final boolean d() {
        w0 w0Var = this.f152391b;
        if (w0Var != null) {
            w0Var.a();
            return true;
        }
        return false;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.f152390a.a(this, motionEvent);
    }

    @Override // android.view.View
    public boolean performClick() {
        return d();
    }

    @UiThread
    public void setRepeatKeyTouchListener(@Nullable w0 w0Var) {
        boolean z16;
        if (w0Var != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        setClickable(z16);
        this.f152391b = w0Var;
    }

    public RepeatKeyTouchImageButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f152390a = new a(this);
        this.f152391b = null;
    }

    public RepeatKeyTouchImageButton(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f152390a = new a(this);
        this.f152391b = null;
    }

    @Override // android.view.View
    public void setOnClickListener(@Nullable View.OnClickListener onClickListener) {
    }
}
