package com.tencent.aelight.camera.ae.album.nocropper;

import android.animation.Animator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.aelight.camera.ae.album.nocropper.AECropperImageView;
import com.tencent.aelight.camera.aeeditor.module.clip.image.EditorPicInfo;

/* compiled from: P */
/* loaded from: classes32.dex */
public class AECropperView extends FrameLayout {

    /* renamed from: d, reason: collision with root package name */
    public AECropperImageView f62177d;

    /* renamed from: e, reason: collision with root package name */
    private AECropperGridView f62178e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f62179f;

    /* compiled from: P */
    /* loaded from: classes32.dex */
    public interface a {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class b implements AECropperImageView.g {
        b() {
        }

        @Override // com.tencent.aelight.camera.ae.album.nocropper.AECropperImageView.g
        public void a() {
            AECropperView.this.f62179f = false;
            if (AECropperView.this.f62178e != null) {
                AECropperGridView aECropperGridView = AECropperView.this.f62178e;
                AECropperView.a(AECropperView.this);
                aECropperGridView.setShowGrid(false);
            }
        }

        @Override // com.tencent.aelight.camera.ae.album.nocropper.AECropperImageView.g
        public void b() {
            AECropperView.this.f62179f = true;
            if (AECropperView.this.f62178e != null) {
                AECropperGridView aECropperGridView = AECropperView.this.f62178e;
                AECropperView.a(AECropperView.this);
                AECropperImageView aECropperImageView = AECropperView.this.f62177d;
                aECropperGridView.setShowGrid(aECropperImageView != null && aECropperImageView.I());
            }
        }
    }

    public AECropperView(Context context) {
        super(context);
        this.f62179f = false;
        l(context, null);
    }

    static /* bridge */ /* synthetic */ a a(AECropperView aECropperView) {
        aECropperView.getClass();
        return null;
    }

    private com.tencent.aelight.camera.ae.album.nocropper.b d() {
        if (this.f62179f) {
            return com.tencent.aelight.camera.ae.album.nocropper.b.a();
        }
        com.tencent.aelight.camera.ae.album.nocropper.a z16 = this.f62177d.z();
        if (z16 != null) {
            return com.tencent.aelight.camera.ae.album.nocropper.b.c(z16);
        }
        return com.tencent.aelight.camera.ae.album.nocropper.b.b();
    }

    private void l(Context context, AttributeSet attributeSet) {
        this.f62177d = new AECropperImageView(context, attributeSet);
        this.f62178e = new AECropperGridView(context, attributeSet);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, 0);
        if (context.getResources().getConfiguration().orientation == 2) {
            layoutParams.width = 0;
            layoutParams.height = -1;
        }
        addView(this.f62177d, 0, layoutParams);
        addView(this.f62178e, 1, layoutParams);
        this.f62177d.setGestureCallback(new b());
    }

    public float e() {
        AECropperImageView aECropperImageView = this.f62177d;
        if (aECropperImageView == null) {
            return 0.0f;
        }
        return aECropperImageView.y();
    }

    public EditorPicInfo f(EditorPicInfo editorPicInfo) {
        com.tencent.aelight.camera.ae.album.nocropper.b d16 = d();
        if (d16.f62191c != c.f62193c || d16.f62190b == null) {
            return null;
        }
        int i3 = i();
        int g16 = g();
        com.tencent.aelight.camera.ae.album.nocropper.a aVar = d16.f62190b;
        double d17 = i3;
        editorPicInfo.f66186x = (aVar.f62181a * 1.0d) / d17;
        double d18 = g16;
        editorPicInfo.f66187y = (aVar.f62182b * 1.0d) / d18;
        editorPicInfo.f66185w = (aVar.f62183c * 1.0d) / d17;
        editorPicInfo.f66184h = (aVar.f62184d * 1.0d) / d18;
        return editorPicInfo;
    }

    public int g() {
        AECropperImageView aECropperImageView = this.f62177d;
        if (aECropperImageView == null) {
            return 0;
        }
        return aECropperImageView.B();
    }

    public Matrix h() {
        if (this.f62177d == null) {
            return new Matrix();
        }
        return new Matrix(this.f62177d.getImageMatrix());
    }

    public int i() {
        AECropperImageView aECropperImageView = this.f62177d;
        if (aECropperImageView == null) {
            return 0;
        }
        return aECropperImageView.C();
    }

    public float j() {
        AECropperImageView aECropperImageView = this.f62177d;
        if (aECropperImageView == null) {
            return 0.0f;
        }
        return aECropperImageView.E();
    }

    public int k() {
        AECropperImageView aECropperImageView = this.f62177d;
        if (aECropperImageView == null) {
            return 1;
        }
        return aECropperImageView.F();
    }

    public void m() {
        AECropperImageView aECropperImageView = this.f62177d;
        if (aECropperImageView != null) {
            aECropperImageView.M();
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i3, int i16) {
        super.onMeasure(i3, i16);
        int i17 = getContext().getResources().getConfiguration().orientation;
        if (i17 != 1 && i17 != 0) {
            int size = View.MeasureSpec.getSize(i16);
            setMeasuredDimension(View.MeasureSpec.makeMeasureSpec(size, 1073741824), size);
        } else {
            int size2 = View.MeasureSpec.getSize(i3);
            setMeasuredDimension(size2, View.MeasureSpec.makeMeasureSpec(size2, 1073741824));
        }
    }

    public void setAnimateCallback(Animator.AnimatorListener animatorListener) {
        AECropperImageView aECropperImageView = this.f62177d;
        if (aECropperImageView != null) {
            aECropperImageView.S = animatorListener;
        }
    }

    public void setDebug(boolean z16) {
        AECropperImageView aECropperImageView = this.f62177d;
        if (aECropperImageView != null) {
            aECropperImageView.setDEBUG(z16);
        }
    }

    public void setGestureEnabled(boolean z16) {
        AECropperImageView aECropperImageView = this.f62177d;
        if (aECropperImageView != null) {
            aECropperImageView.setGestureEnabled(z16);
        }
    }

    public void setImageBitmap(Bitmap bitmap) {
        AECropperImageView aECropperImageView = this.f62177d;
        if (aECropperImageView != null) {
            aECropperImageView.setImageBitmap(bitmap);
        }
    }

    public void setImageMatrix(Matrix matrix) {
        AECropperImageView aECropperImageView = this.f62177d;
        if (aECropperImageView != null) {
            aECropperImageView.setImageMatrix(matrix);
        }
    }

    public void setMaxZoom(float f16) {
        AECropperImageView aECropperImageView = this.f62177d;
        if (aECropperImageView != null) {
            aECropperImageView.setMaxZoom(f16);
        }
    }

    public void setMinZoom(float f16) {
        AECropperImageView aECropperImageView = this.f62177d;
        if (aECropperImageView != null) {
            aECropperImageView.setMinZoom(f16);
        }
    }

    public AECropperView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f62179f = false;
        l(context, attributeSet);
    }

    public AECropperView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f62179f = false;
        l(context, attributeSet);
    }

    public void setGridCallback(a aVar) {
    }
}
