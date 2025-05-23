package com.tencent.mobileqq.activity.aio.doodle.control;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.mobileqq.util.Utils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

/* compiled from: P */
/* loaded from: classes10.dex */
public class ColorView extends View {

    /* renamed from: d, reason: collision with root package name */
    private b f178519d;

    /* renamed from: e, reason: collision with root package name */
    private int f178520e;

    /* renamed from: f, reason: collision with root package name */
    private Paint f178521f;

    /* renamed from: h, reason: collision with root package name */
    private Bitmap f178522h;

    /* renamed from: i, reason: collision with root package name */
    private int f178523i;

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (ColorView.this.f178519d != null) {
                ColorView.this.f178519d.onClick();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    interface b {
        void onClick();
    }

    public ColorView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f178523i = Utils.n(4.0f, getResources());
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        int i3;
        super.onDraw(canvas);
        Bitmap bitmap = this.f178522h;
        if (bitmap != null) {
            canvas.drawBitmap(bitmap, (Rect) null, new RectF(0.0f, 0.0f, getWidth(), getHeight()), (Paint) null);
            return;
        }
        if (this.f178521f == null) {
            return;
        }
        int width = getWidth();
        int height = getHeight();
        if (width > height) {
            i3 = width;
        } else {
            i3 = height;
        }
        this.f178521f.setStrokeWidth(i3);
        RectF rectF = new RectF(0.0f, 0.0f, width, height);
        int i16 = this.f178523i;
        canvas.drawRoundRect(rectF, i16, i16, this.f178521f);
    }

    public void setBtmap(Bitmap bitmap) {
        this.f178522h = bitmap;
        this.f178521f = null;
        invalidate();
    }

    public void setColor(int i3) {
        this.f178520e = i3;
        if (this.f178521f == null) {
            Paint paint = new Paint();
            this.f178521f = paint;
            paint.setAntiAlias(true);
        }
        this.f178521f.setColor(this.f178520e);
        this.f178522h = null;
        invalidate();
    }

    public void setListener(b bVar) {
        this.f178519d = bVar;
        setOnClickListener(new a());
    }
}
