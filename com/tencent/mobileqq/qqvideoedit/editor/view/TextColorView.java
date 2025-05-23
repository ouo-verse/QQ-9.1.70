package com.tencent.mobileqq.qqvideoedit.editor.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;
import com.tencent.mobileqq.R;
import com.tencent.videocut.utils.e;

/* compiled from: P */
/* loaded from: classes17.dex */
public class TextColorView extends View {

    /* renamed from: d, reason: collision with root package name */
    private Rect f275851d;

    /* renamed from: e, reason: collision with root package name */
    private Paint f275852e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f275853f;

    /* renamed from: h, reason: collision with root package name */
    private int f275854h;

    public TextColorView(Context context) {
        super(context);
        this.f275853f = false;
        this.f275854h = -16777216;
        a();
    }

    private void a() {
        this.f275851d = new Rect();
        this.f275852e = new Paint(1);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        new RectF(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight());
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        e eVar = e.f384236a;
        eVar.a(6.0f);
        int a16 = eVar.a(5.0f);
        int a17 = eVar.a(4.0f);
        int a18 = eVar.a(3.0f);
        paint.setColor(this.f275854h);
        float f16 = a16;
        RectF rectF = new RectF(f16, f16, r0 - a16, r1 - a16);
        float f17 = a17;
        canvas.drawRoundRect(rectF, f17, f17, paint);
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        if (this.f275853f) {
            Bitmap decodeResource = BitmapFactory.decodeResource(getResources(), R.drawable.f161875nh4, null);
            canvas.drawBitmap(decodeResource, new Rect(0, 0, decodeResource.getWidth(), decodeResource.getHeight()), new Rect(0, 0, measuredWidth, measuredHeight), paint);
        } else {
            Bitmap decodeResource2 = BitmapFactory.decodeResource(getResources(), R.drawable.nh5, null);
            canvas.drawBitmap(decodeResource2, new Rect(0, 0, decodeResource2.getWidth(), decodeResource2.getHeight()), new Rect(a18, a18, measuredWidth - a18, measuredHeight - a18), paint);
        }
    }

    public void setColor(int i3) {
        this.f275854h = i3;
    }

    @Override // android.view.View
    public void setSelected(boolean z16) {
        super.setSelected(z16);
        this.f275853f = z16;
    }
}
