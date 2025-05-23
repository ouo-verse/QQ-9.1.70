package com.tencent.mobileqq.guild.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import com.tencent.widget.ListView;

/* compiled from: P */
/* loaded from: classes14.dex */
public class GuildLiveChatContentRelativeLayout extends RelativeLayout {
    private int C;

    /* renamed from: d, reason: collision with root package name */
    private final float[] f235919d;

    /* renamed from: e, reason: collision with root package name */
    private final Paint f235920e;

    /* renamed from: f, reason: collision with root package name */
    private int[] f235921f;

    /* renamed from: h, reason: collision with root package name */
    private int f235922h;

    /* renamed from: i, reason: collision with root package name */
    private float f235923i;

    /* renamed from: m, reason: collision with root package name */
    private int f235924m;

    public GuildLiveChatContentRelativeLayout(Context context) {
        this(context, null);
    }

    private void a() {
        this.f235920e.setShader(new LinearGradient(0.0f, 0.0f, 0.0f, this.f235923i, this.f235921f, this.f235919d, Shader.TileMode.CLAMP));
    }

    @Override // android.view.ViewGroup
    protected boolean drawChild(Canvas canvas, View view, long j3) {
        if (this.f235922h != 0 && (view instanceof ListView)) {
            int saveLayer = canvas.saveLayer(0.0f, 0.0f, getWidth(), getHeight(), null, 31);
            boolean drawChild = super.drawChild(canvas, view, j3);
            if ((this.f235922h & 1) != 0) {
                canvas.drawRect(0.0f, 0.0f, this.f235924m, this.f235923i, this.f235920e);
            }
            if ((this.f235922h & 2) != 0) {
                int save = canvas.save();
                canvas.rotate(180.0f, this.f235924m / 2.0f, this.C / 2.0f);
                canvas.drawRect(0.0f, 0.0f, this.f235924m, this.f235923i, this.f235920e);
                canvas.restoreToCount(save);
            }
            int i3 = (this.C - this.f235924m) / 2;
            if ((this.f235922h & 4) != 0) {
                int save2 = canvas.save();
                canvas.rotate(90.0f, this.f235924m / 2.0f, this.C / 2.0f);
                canvas.translate(0.0f, i3);
                canvas.drawRect(-i3, 0.0f, this.f235924m + i3, this.f235923i, this.f235920e);
                canvas.restoreToCount(save2);
            }
            if ((this.f235922h & 8) != 0) {
                int save3 = canvas.save();
                canvas.rotate(270.0f, this.f235924m / 2.0f, this.C / 2.0f);
                canvas.translate(0.0f, i3);
                canvas.drawRect(-i3, 0.0f, this.f235924m + i3, this.f235923i, this.f235920e);
                canvas.restoreToCount(save3);
            }
            canvas.restoreToCount(saveLayer);
            return drawChild;
        }
        return super.drawChild(canvas, view, j3);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i3, int i16, int i17, int i18) {
        super.onSizeChanged(i3, i16, i17, i18);
        a();
        this.f235924m = getWidth();
        this.C = getHeight();
    }

    public void setGradientColors(int[] iArr) {
        this.f235921f = iArr;
    }

    public void setPositionAndDrawSize(int i3, float f16) {
        this.f235922h = i3;
        this.f235923i = f16;
    }

    public GuildLiveChatContentRelativeLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public GuildLiveChatContentRelativeLayout(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f235919d = new float[]{0.0f, 1.0f};
        this.f235921f = new int[]{-1, 0};
        this.f235922h = 0;
        Paint paint = new Paint(1);
        this.f235920e = paint;
        paint.setStyle(Paint.Style.FILL);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
    }
}
