package com.tencent.ad.tangram.views.canvas.components.roundview;

import android.graphics.Canvas;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewOutlineProvider;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes3.dex */
public final class RoundViewHelper implements IRoundView {
    private float borderWidth;
    private WeakReference<View> mView;
    private float radius;

    @NonNull
    private RectF mRectF = new RectF();

    @NonNull
    private Path mPath = new Path();

    @NonNull
    private Paint boarderPaint = new Paint(1);
    private int borderColor = -1;

    public RoundViewHelper(WeakReference<View> weakReference) {
        this.mView = weakReference;
    }

    private void resetRoundPath() {
        this.mPath.reset();
        Path path = this.mPath;
        RectF rectF = this.mRectF;
        float f16 = this.radius;
        path.addRoundRect(rectF, f16, f16, Path.Direction.CW);
    }

    @Override // com.tencent.ad.tangram.views.canvas.components.roundview.IRoundView
    public void dispatchDraw(@NonNull Canvas canvas) {
        View view;
        WeakReference<View> weakReference = this.mView;
        if (weakReference != null) {
            view = weakReference.get();
        } else {
            view = null;
        }
        if (view == null) {
            return;
        }
        final int width = view.getWidth();
        final int height = view.getHeight();
        view.setClipToOutline(true);
        view.setOutlineProvider(new ViewOutlineProvider() { // from class: com.tencent.ad.tangram.views.canvas.components.roundview.RoundViewHelper.1
            @Override // android.view.ViewOutlineProvider
            public void getOutline(View view2, @NonNull Outline outline) {
                outline.setRoundRect(0, 0, width, height, RoundViewHelper.this.radius);
            }
        });
        if (this.borderWidth > 0.0f) {
            float f16 = this.borderWidth;
            RectF rectF = new RectF(f16, f16, width - f16, height - f16);
            this.boarderPaint.setColor(this.borderColor);
            this.boarderPaint.setStyle(Paint.Style.STROKE);
            this.boarderPaint.setStrokeWidth(this.borderWidth);
            float f17 = this.radius;
            canvas.drawRoundRect(rectF, f17, f17, this.boarderPaint);
        }
    }

    @Override // com.tencent.ad.tangram.views.canvas.components.roundview.IRoundView
    public void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        View view;
        WeakReference<View> weakReference = this.mView;
        if (weakReference != null) {
            view = weakReference.get();
        } else {
            view = null;
        }
        if (view == null) {
            return;
        }
        view.getWidth();
        view.getHeight();
    }

    @Override // com.tencent.ad.tangram.views.canvas.components.roundview.IRoundView
    public void setBorderColor(int i3) {
        this.borderColor = i3;
    }

    @Override // com.tencent.ad.tangram.views.canvas.components.roundview.IRoundView
    public void setBorderWidth(float f16) {
        this.borderWidth = f16;
    }

    @Override // com.tencent.ad.tangram.views.canvas.components.roundview.IRoundView
    public void setRadius(float f16) {
        this.radius = f16;
    }
}
