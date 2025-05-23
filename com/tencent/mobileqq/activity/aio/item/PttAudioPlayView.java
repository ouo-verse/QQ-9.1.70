package com.tencent.mobileqq.activity.aio.item;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.support.annotation.DrawableRes;
import android.util.AttributeSet;
import com.tencent.mobileqq.R;

/* loaded from: classes10.dex */
public class PttAudioPlayView extends PttThemeBaseView {
    private final int R;
    private boolean S;
    private int T;
    Bitmap U;
    Bitmap V;

    public PttAudioPlayView(Context context) {
        super(context);
        this.R = 12;
        this.S = false;
        this.T = R.drawable.c2p;
        g(12);
    }

    @Override // com.tencent.mobileqq.activity.aio.item.PttThemeBaseView
    protected boolean a() {
        Bitmap bitmap;
        Bitmap bitmap2;
        Bitmap bitmap3 = this.V;
        if (bitmap3 != null && !bitmap3.isRecycled() && (bitmap = this.U) != null && !bitmap.isRecycled() && (bitmap2 = this.E) != null && !bitmap2.isRecycled()) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.activity.aio.item.PttThemeBaseView
    public void b() {
        super.b();
        Bitmap bitmap = this.U;
        if (bitmap != null && !bitmap.isRecycled()) {
            this.U.recycle();
        }
        Bitmap bitmap2 = this.V;
        if (bitmap2 != null && !bitmap2.isRecycled()) {
            this.V.recycle();
        }
        this.U = null;
        this.V = null;
    }

    @Override // com.tencent.mobileqq.activity.aio.item.PttThemeBaseView
    protected void c(Canvas canvas) {
        if (!this.S) {
            canvas.drawBitmap(this.V, (Rect) null, this.f179424i, this.K);
        } else {
            canvas.drawBitmap(this.U, (Rect) null, this.f179424i, this.K);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.activity.aio.item.PttThemeBaseView
    public void g(int i3) {
        super.g(i3);
        this.U = BitmapFactory.decodeResource(getResources(), this.T);
        this.V = BitmapFactory.decodeResource(getResources(), R.drawable.c2q);
    }

    public void setPlayState(boolean z16) {
        this.S = z16;
        if (this.E == null) {
            this.Q = true;
        }
        if (this.U == null) {
            this.U = BitmapFactory.decodeResource(getResources(), this.T);
        }
        if (this.V == null) {
            this.V = BitmapFactory.decodeResource(getResources(), R.drawable.c2q);
        }
        this.P = true;
        invalidate();
    }

    public void setPttPauseOrStopDrawable(@DrawableRes int i3) {
        this.T = i3;
    }

    public PttAudioPlayView(Context context, int i3) {
        super(context);
        this.R = 12;
        this.S = false;
        this.T = R.drawable.c2p;
        g(i3);
    }

    public PttAudioPlayView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.R = 12;
        this.S = false;
        this.T = R.drawable.c2p;
        g(12);
    }

    public PttAudioPlayView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet);
        this.R = 12;
        this.S = false;
        this.T = R.drawable.c2p;
        g(i3);
    }
}
