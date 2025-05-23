package com.tencent.mobileqq.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Shader;
import android.view.View;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;

/* loaded from: classes20.dex */
public class LoginPopupMaskView extends View {

    /* renamed from: d, reason: collision with root package name */
    private Path f315811d;

    /* renamed from: e, reason: collision with root package name */
    private int f315812e;

    /* renamed from: f, reason: collision with root package name */
    private int f315813f;

    /* renamed from: h, reason: collision with root package name */
    private int f315814h;

    /* renamed from: i, reason: collision with root package name */
    private Paint f315815i;

    public LoginPopupMaskView(Context context) {
        super(context);
        this.f315814h = 26;
        this.f315814h = a(13.0f, getResources());
        this.f315815i = new Paint();
    }

    private int a(float f16, Resources resources) {
        return ViewUtils.dip2px(f16);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        try {
            int measuredWidth = getMeasuredWidth();
            int measuredHeight = getMeasuredHeight();
            if (this.f315811d == null || measuredWidth != this.f315812e || measuredHeight != this.f315813f) {
                Path path = new Path();
                this.f315811d = path;
                float f16 = measuredWidth;
                path.moveTo(f16, measuredHeight - this.f315814h);
                Path path2 = this.f315811d;
                int i3 = this.f315814h;
                float f17 = measuredHeight;
                path2.arcTo(new RectF(measuredWidth - (i3 * 2), measuredHeight - (i3 * 2), f16, f17), 0.0f, 90.0f);
                this.f315811d.lineTo(this.f315814h, f17);
                Path path3 = this.f315811d;
                int i16 = this.f315814h;
                path3.arcTo(new RectF(0.0f, measuredHeight - (i16 * 2), i16 * 2, f17), 90.0f, 90.0f);
                this.f315811d.close();
                this.f315812e = measuredWidth;
                this.f315813f = measuredHeight;
                this.f315815i.setShader(new LinearGradient(0.0f, 0.0f, 0.0f, f17, new int[]{15922167, -2132417049, -2565928}, new float[]{0.0f, 0.5f, 1.0f}, Shader.TileMode.CLAMP));
            }
            canvas.save();
            canvas.clipPath(this.f315811d);
            canvas.drawRect(0.0f, 0.0f, measuredWidth, measuredHeight, this.f315815i);
            canvas.restore();
        } catch (Throwable th5) {
            QLog.e("LoginPopupMaskView", 1, "onDraw error2:" + th5.getMessage());
        }
    }
}
