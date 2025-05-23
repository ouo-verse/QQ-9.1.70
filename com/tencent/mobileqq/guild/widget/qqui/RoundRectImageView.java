package com.tencent.mobileqq.guild.widget.qqui;

import android.R;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.ImageView;

/* compiled from: P */
/* loaded from: classes14.dex */
public class RoundRectImageView extends ImageView {

    /* renamed from: d, reason: collision with root package name */
    protected Path f236481d;

    /* renamed from: e, reason: collision with root package name */
    private int f236482e;

    /* renamed from: f, reason: collision with root package name */
    protected int f236483f;

    /* renamed from: h, reason: collision with root package name */
    private int f236484h;

    /* renamed from: i, reason: collision with root package name */
    private int f236485i;

    public RoundRectImageView(Context context) {
        this(context, null);
    }

    private void a() {
        if (this.f236484h == this.f236482e && this.f236485i == this.f236483f) {
            return;
        }
        int width = getWidth();
        int height = getHeight();
        this.f236484h = this.f236482e;
        this.f236481d.reset();
        int i3 = this.f236483f;
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 != 4) {
                        if (i3 == 5) {
                            Path path = this.f236481d;
                            RectF rectF = new RectF(0.0f, 0.0f, width, height);
                            int i16 = this.f236482e;
                            path.addRoundRect(rectF, new float[]{0.0f, 0.0f, 0.0f, 0.0f, i16, i16, i16, i16}, Path.Direction.CW);
                            return;
                        }
                        return;
                    }
                    Path path2 = this.f236481d;
                    RectF rectF2 = new RectF(0.0f, 0.0f, width, height);
                    int i17 = this.f236482e;
                    path2.addRoundRect(rectF2, new float[]{0.0f, 0.0f, i17, i17, i17, i17, 0.0f, 0.0f}, Path.Direction.CW);
                    return;
                }
                Path path3 = this.f236481d;
                RectF rectF3 = new RectF(0.0f, 0.0f, width, height);
                int i18 = this.f236482e;
                path3.addRoundRect(rectF3, new float[]{i18, i18, i18, i18, 0.0f, 0.0f, 0.0f, 0.0f}, Path.Direction.CW);
                return;
            }
            Path path4 = this.f236481d;
            RectF rectF4 = new RectF(0.0f, 0.0f, width, height);
            int i19 = this.f236482e;
            path4.addRoundRect(rectF4, new float[]{i19, i19, 0.0f, 0.0f, 0.0f, 0.0f, i19, i19}, Path.Direction.CW);
            return;
        }
        Path path5 = this.f236481d;
        RectF rectF5 = new RectF(0.0f, 0.0f, width, height);
        int i26 = this.f236482e;
        path5.addRoundRect(rectF5, i26, i26, Path.Direction.CW);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        if (this.f236483f != 0) {
            int save = canvas.save();
            a();
            canvas.clipPath(this.f236481d);
            super.draw(canvas);
            canvas.restoreToCount(save);
            return;
        }
        super.draw(canvas);
    }

    public void setCornerRadiusAndMode(int i3, int i16) {
        this.f236482e = i3;
        this.f236483f = i16;
    }

    public RoundRectImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.listViewStyle);
    }

    public RoundRectImageView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f236483f = 0;
        Path path = new Path();
        this.f236481d = path;
        path.setFillType(Path.FillType.EVEN_ODD);
    }
}
