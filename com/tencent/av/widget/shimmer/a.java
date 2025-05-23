package com.tencent.av.widget.shimmer;

import android.content.res.TypedArray;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private View f77235a;

    /* renamed from: b, reason: collision with root package name */
    private Paint f77236b;

    /* renamed from: c, reason: collision with root package name */
    private float f77237c;

    /* renamed from: d, reason: collision with root package name */
    private LinearGradient f77238d;

    /* renamed from: e, reason: collision with root package name */
    private Matrix f77239e;

    /* renamed from: f, reason: collision with root package name */
    private int f77240f;

    /* renamed from: g, reason: collision with root package name */
    private int f77241g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f77242h = true;

    /* renamed from: i, reason: collision with root package name */
    private boolean f77243i;

    /* compiled from: P */
    /* renamed from: com.tencent.av.widget.shimmer.a$a, reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0776a {
    }

    public a(View view, Paint paint, AttributeSet attributeSet) {
        this.f77235a = view;
        this.f77236b = paint;
        a(attributeSet);
    }

    private void a(AttributeSet attributeSet) {
        this.f77241g = -1;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = this.f77235a.getContext().obtainStyledAttributes(attributeSet, az3.a.T4, 0, 0);
            try {
                if (obtainStyledAttributes != null) {
                    try {
                        this.f77241g = obtainStyledAttributes.getColor(az3.a.U4, -1);
                    } catch (Exception e16) {
                        if (QLog.isColorLevel()) {
                            QLog.e("ShimmerTextView", 2, "Error while creating the view:", e16);
                        }
                    }
                }
            } finally {
                obtainStyledAttributes.recycle();
            }
        }
        this.f77239e = new Matrix();
    }

    private void e() {
        float f16 = -this.f77235a.getWidth();
        int i3 = this.f77240f;
        LinearGradient linearGradient = new LinearGradient(f16, 0.0f, 0.0f, 0.0f, new int[]{i3, this.f77241g, i3}, new float[]{0.0f, 0.5f, 1.0f}, Shader.TileMode.CLAMP);
        this.f77238d = linearGradient;
        this.f77236b.setShader(linearGradient);
    }

    public boolean b() {
        return this.f77242h;
    }

    public void c() {
        if (this.f77242h) {
            if (this.f77236b.getShader() == null) {
                this.f77236b.setShader(this.f77238d);
            }
            this.f77239e.setTranslate(this.f77237c * 2.0f, 0.0f);
            this.f77238d.setLocalMatrix(this.f77239e);
            return;
        }
        this.f77236b.setShader(null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void d() {
        e();
        if (!this.f77243i) {
            this.f77243i = true;
        }
    }

    public void g(float f16) {
        this.f77237c = f16;
        this.f77235a.invalidate();
    }

    public void h(int i3) {
        this.f77240f = i3;
        if (this.f77243i) {
            e();
        }
    }

    public void i(int i3) {
        this.f77241g = i3;
        if (this.f77243i) {
            e();
        }
    }

    public void j(boolean z16) {
        this.f77242h = z16;
    }

    public void f(InterfaceC0776a interfaceC0776a) {
    }
}
