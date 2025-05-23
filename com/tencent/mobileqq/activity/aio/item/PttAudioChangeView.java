package com.tencent.mobileqq.activity.aio.item;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;

/* loaded from: classes10.dex */
public class PttAudioChangeView extends PttThemeBaseView {
    Bitmap R;

    @Override // com.tencent.mobileqq.activity.aio.item.PttThemeBaseView
    protected boolean a() {
        Bitmap bitmap;
        Bitmap bitmap2 = this.E;
        if (bitmap2 != null && !bitmap2.isRecycled() && (bitmap = this.R) != null && !bitmap.isRecycled()) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.activity.aio.item.PttThemeBaseView
    protected void c(Canvas canvas) {
        canvas.drawBitmap(this.R, (Rect) null, this.f179424i, this.K);
    }
}
