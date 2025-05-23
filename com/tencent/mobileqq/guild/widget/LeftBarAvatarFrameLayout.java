package com.tencent.mobileqq.guild.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;

/* compiled from: P */
/* loaded from: classes14.dex */
public class LeftBarAvatarFrameLayout extends FrameLayout {

    /* renamed from: d, reason: collision with root package name */
    private final Paint f236025d;

    /* renamed from: e, reason: collision with root package name */
    private Path f236026e;

    /* renamed from: f, reason: collision with root package name */
    private Path f236027f;

    /* renamed from: h, reason: collision with root package name */
    private int f236028h;

    /* renamed from: i, reason: collision with root package name */
    private int f236029i;

    /* renamed from: m, reason: collision with root package name */
    private boolean f236030m;

    public LeftBarAvatarFrameLayout(@NonNull Context context) {
        super(context);
        Paint paint = new Paint(1);
        this.f236025d = paint;
        this.f236030m = true;
        setLayerType(2, null);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
    }

    public void a() {
        this.f236027f = null;
        invalidate();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        if (this.f236027f != null) {
            int saveLayer = canvas.saveLayer(0.0f, 0.0f, getWidth(), getHeight(), null);
            super.dispatchDraw(canvas);
            canvas.drawPath(this.f236027f, this.f236025d);
            canvas.restoreToCount(saveLayer);
            return;
        }
        super.dispatchDraw(canvas);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        Path path = this.f236026e;
        if (path != null && this.f236030m) {
            canvas.drawPath(path, this.f236025d);
        }
    }

    public void setBottomRightHole() {
        Path path = new Path();
        this.f236027f = path;
        path.addCircle(QQGuildUIUtil.f(46.0f), QQGuildUIUtil.f(46.0f), QQGuildUIUtil.f(10.0f), Path.Direction.CCW);
        invalidate();
    }

    public void setHorizontalOffset(int i3) {
        this.f236028h = i3;
    }

    public void setTopRightHole(int i3, int i16, boolean z16) {
        if (i3 == 0 && i16 == 0) {
            this.f236026e = null;
            invalidate();
            return;
        }
        RectF rectF = new RectF((QQGuildUIUtil.f(56.0f) - i3) + this.f236028h, (QQGuildUIUtil.f(2.0f) * (-1)) + this.f236029i, QQGuildUIUtil.f(60.0f) + this.f236028h, i16 + QQGuildUIUtil.f(2.0f) + this.f236029i);
        Path path = new Path();
        this.f236026e = path;
        if (z16) {
            path.addRoundRect(rectF, QQGuildUIUtil.f(10.0f), QQGuildUIUtil.f(10.0f), Path.Direction.CCW);
        } else {
            path.addRoundRect(rectF, QQGuildUIUtil.f(7.5f), QQGuildUIUtil.f(7.5f), Path.Direction.CCW);
        }
        this.f236030m = true;
        invalidate();
    }

    public void setUnreadPointHoleShow(boolean z16) {
        this.f236030m = z16;
        invalidate();
    }

    public void setVerticalOffset(int i3) {
        this.f236029i = i3;
    }

    public LeftBarAvatarFrameLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Paint paint = new Paint(1);
        this.f236025d = paint;
        this.f236030m = true;
        setLayerType(2, null);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
    }

    public LeftBarAvatarFrameLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Paint paint = new Paint(1);
        this.f236025d = paint;
        this.f236030m = true;
        setLayerType(2, null);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
    }
}
