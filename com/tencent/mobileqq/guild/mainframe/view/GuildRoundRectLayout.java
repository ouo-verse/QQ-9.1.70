package com.tencent.mobileqq.guild.mainframe.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Region;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.utils.ViewUtils;

/* compiled from: P */
/* loaded from: classes14.dex */
public class GuildRoundRectLayout extends FrameLayout {

    /* renamed from: d, reason: collision with root package name */
    private float f227743d;

    public GuildRoundRectLayout(@NonNull Context context) {
        super(context);
        this.f227743d = ViewUtils.dpToPx(1.0f);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        Path path = new Path();
        RectF rectF = new RectF(getPaddingLeft(), getPaddingTop(), getWidth() - getPaddingRight(), getHeight() - getPaddingBottom());
        float f16 = this.f227743d;
        path.addRoundRect(rectF, f16, f16, Path.Direction.CW);
        canvas.save();
        canvas.clipPath(path, Region.Op.INTERSECT);
        super.dispatchDraw(canvas);
        canvas.restore();
    }

    public GuildRoundRectLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f227743d = ViewUtils.dpToPx(1.0f);
    }

    public GuildRoundRectLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f227743d = ViewUtils.dpToPx(1.0f);
    }
}
