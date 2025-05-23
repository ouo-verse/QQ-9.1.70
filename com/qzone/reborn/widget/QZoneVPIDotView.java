package com.qzone.reborn.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.ViewUtils;

/* loaded from: classes37.dex */
public class QZoneVPIDotView extends View {
    private static final int D;
    private static final int E;
    public static final int F;
    public static final int G;

    /* renamed from: d, reason: collision with root package name */
    private DotType f59660d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f59661e;

    /* renamed from: f, reason: collision with root package name */
    private Paint f59662f;

    /* renamed from: h, reason: collision with root package name */
    private static final int f59657h = Color.parseColor("#0099FF");

    /* renamed from: i, reason: collision with root package name */
    private static final int f59658i = Color.parseColor("#0066CC");

    /* renamed from: m, reason: collision with root package name */
    private static final int f59659m = Color.parseColor("#CCCCCC");
    private static final int C = Color.parseColor("#666666");

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes37.dex */
    public enum DotType {
        Normal,
        Choose,
        More
    }

    static {
        int dip2px = ViewUtils.dip2px(6.0f);
        D = dip2px;
        E = ViewUtils.dip2px(3.0f);
        F = ViewUtils.dip2px(10.0f);
        G = dip2px;
    }

    public QZoneVPIDotView(Context context) {
        super(context);
        this.f59660d = DotType.Normal;
        this.f59661e = QQTheme.isNowThemeIsNightForQzone();
        Paint paint = new Paint();
        this.f59662f = paint;
        paint.setAntiAlias(true);
        this.f59662f.setStyle(Paint.Style.FILL);
    }

    private int a(DotType dotType) {
        return (dotType == DotType.Choose || dotType == DotType.Normal) ? D : E;
    }

    private int b(DotType dotType) {
        if (dotType != DotType.More && dotType != DotType.Normal) {
            if (this.f59661e) {
                return f59658i;
            }
            return f59657h;
        }
        if (this.f59661e) {
            return C;
        }
        return f59659m;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.save();
        this.f59662f.setColor(b(this.f59660d));
        canvas.drawCircle(getWidth() / 2, getHeight() / 2, a(this.f59660d) / 2, this.f59662f);
        canvas.restore();
        super.onDraw(canvas);
    }

    @Override // android.view.View
    protected void onMeasure(int i3, int i16) {
        super.onMeasure(i3, i16);
        setMeasuredDimension(F, G);
    }

    public void setDotType(DotType dotType) {
        this.f59660d = dotType;
        invalidate();
    }
}
