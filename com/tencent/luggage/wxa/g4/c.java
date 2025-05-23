package com.tencent.luggage.wxa.g4;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Region;
import android.view.View;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes8.dex */
public class c extends View {

    /* renamed from: a, reason: collision with root package name */
    public Rect f126412a;

    /* renamed from: b, reason: collision with root package name */
    public Bitmap f126413b;

    /* renamed from: c, reason: collision with root package name */
    public Bitmap f126414c;

    /* renamed from: d, reason: collision with root package name */
    public Bitmap f126415d;

    /* renamed from: e, reason: collision with root package name */
    public Bitmap f126416e;

    /* renamed from: f, reason: collision with root package name */
    public int f126417f;

    /* renamed from: g, reason: collision with root package name */
    public int f126418g;

    /* renamed from: h, reason: collision with root package name */
    public Paint f126419h;

    /* renamed from: i, reason: collision with root package name */
    public Paint f126420i;

    public c(Context context) {
        super(context);
        this.f126413b = null;
        this.f126414c = null;
        this.f126415d = null;
        this.f126416e = null;
        this.f126417f = 0;
        this.f126418g = 0;
        this.f126419h = new Paint();
        this.f126420i = new Paint();
        a();
    }

    public final void a() {
        this.f126413b = BitmapFactory.decodeResource(getResources(), R.drawable.ou9);
        this.f126414c = BitmapFactory.decodeResource(getResources(), R.drawable.ou_);
        this.f126415d = BitmapFactory.decodeResource(getResources(), R.drawable.oua);
        this.f126416e = BitmapFactory.decodeResource(getResources(), R.drawable.oub);
        this.f126417f = this.f126413b.getWidth();
        this.f126418g = this.f126413b.getHeight();
        this.f126419h.setAntiAlias(true);
        this.f126420i.setAntiAlias(true);
    }

    public Rect getRect() {
        return new Rect(this.f126412a);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.save();
        canvas.clipRect(this.f126412a, Region.Op.DIFFERENCE);
        canvas.drawRect(this.f126412a, this.f126419h);
        canvas.restore();
        Bitmap bitmap = this.f126413b;
        Rect rect = this.f126412a;
        canvas.drawBitmap(bitmap, rect.left, rect.top, this.f126420i);
        Bitmap bitmap2 = this.f126414c;
        Rect rect2 = this.f126412a;
        canvas.drawBitmap(bitmap2, rect2.right - this.f126417f, rect2.top, this.f126420i);
        Bitmap bitmap3 = this.f126415d;
        Rect rect3 = this.f126412a;
        canvas.drawBitmap(bitmap3, rect3.left, rect3.bottom - this.f126418g, this.f126420i);
        Bitmap bitmap4 = this.f126416e;
        Rect rect4 = this.f126412a;
        canvas.drawBitmap(bitmap4, rect4.right - this.f126417f, rect4.bottom - this.f126418g, this.f126420i);
    }

    public void setRect(Rect rect) {
        this.f126412a = rect;
    }
}
