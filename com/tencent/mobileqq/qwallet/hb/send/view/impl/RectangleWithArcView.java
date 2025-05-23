package com.tencent.mobileqq.qwallet.hb.send.view.impl;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.view.View;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes16.dex */
public class RectangleWithArcView extends View {
    private int C;
    private int D;
    private int E;

    /* renamed from: d, reason: collision with root package name */
    private Paint f277796d;

    /* renamed from: e, reason: collision with root package name */
    private Path f277797e;

    /* renamed from: f, reason: collision with root package name */
    private String f277798f;

    /* renamed from: h, reason: collision with root package name */
    private int f277799h;

    /* renamed from: i, reason: collision with root package name */
    private int f277800i;

    /* renamed from: m, reason: collision with root package name */
    private int f277801m;

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        try {
            this.f277796d.setColor(Color.parseColor(this.f277798f));
            this.f277796d.setStyle(Paint.Style.FILL);
            this.f277797e.moveTo(this.f277799h, this.f277800i - 200);
            this.f277797e.lineTo(this.f277799h, this.f277800i - this.C);
            this.f277797e.quadTo(this.D, this.E, this.f277799h + this.f277801m, this.f277800i - this.C);
            this.f277797e.lineTo(this.f277799h + this.f277801m, this.f277800i);
            this.f277797e.lineTo(this.f277799h, this.f277800i);
            this.f277797e.close();
            canvas.drawPath(this.f277797e, this.f277796d);
        } catch (Exception e16) {
            QLog.e("RectangleWithArcView", 1, "error msg in qqpay-impl module: ", e16);
        }
    }
}
