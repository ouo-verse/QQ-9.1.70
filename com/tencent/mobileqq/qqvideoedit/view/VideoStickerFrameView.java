package com.tencent.mobileqq.qqvideoedit.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.qqvideoedit.editor.sticker.VideoStickerModel;
import com.tencent.mobileqq.util.x;

/* compiled from: P */
/* loaded from: classes17.dex */
public class VideoStickerFrameView extends View {

    /* renamed from: d, reason: collision with root package name */
    private float f276294d;

    /* renamed from: e, reason: collision with root package name */
    private Paint f276295e;

    /* renamed from: f, reason: collision with root package name */
    private RectF f276296f;

    /* renamed from: h, reason: collision with root package name */
    private RectF f276297h;

    /* renamed from: i, reason: collision with root package name */
    private VideoStickerModel f276298i;

    /* renamed from: m, reason: collision with root package name */
    private VideoStickerModel f276299m;

    public VideoStickerFrameView(Context context) {
        this(context, null);
    }

    private void a() {
        this.f276294d = x.c(getContext(), 4.0f);
        Paint paint = new Paint(1);
        this.f276295e = paint;
        paint.setStrokeWidth(x.c(getContext(), 2.0f));
        this.f276295e.setStyle(Paint.Style.STROKE);
        this.f276295e.setColor(-1);
        this.f276296f = new RectF();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f276298i == null) {
            return;
        }
        canvas.save();
        VideoStickerModel videoStickerModel = this.f276298i;
        canvas.rotate(-videoStickerModel.rotate, videoStickerModel.getCenterInView().f275793x, this.f276298i.getCenterInView().f275794y);
        RectF rectF = this.f276296f;
        float f16 = this.f276294d;
        canvas.drawRoundRect(rectF, f16, f16, this.f276295e);
        canvas.restore();
        if (this.f276299m != null) {
            canvas.save();
            VideoStickerModel videoStickerModel2 = this.f276299m;
            canvas.rotate(-videoStickerModel2.rotate, videoStickerModel2.getCenterInView().f275793x, this.f276299m.getCenterInView().f275794y);
            RectF rectF2 = this.f276297h;
            float f17 = this.f276294d;
            canvas.drawRoundRect(rectF2, f17, f17, this.f276295e);
            canvas.restore();
        }
    }

    public VideoStickerFrameView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public VideoStickerFrameView(Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        a();
    }
}
