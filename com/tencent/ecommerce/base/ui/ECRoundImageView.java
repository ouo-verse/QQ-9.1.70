package com.tencent.ecommerce.base.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.heytap.databaseengine.model.UserInfo;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\u001b\u0010\u001cB\u0019\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u00a2\u0006\u0004\b\u001b\u0010\u001dB!\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u001f\u001a\u00020\u001e\u00a2\u0006\u0004\b\u001b\u0010 J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\u0012\u0010\n\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0014R\"\u0010\u0012\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019\u00a8\u0006!"}, d2 = {"Lcom/tencent/ecommerce/base/ui/ECRoundImageView;", "Landroid/widget/ImageView;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "", "a", "Landroid/graphics/Canvas;", PM.CANVAS, "onDraw", "", "d", UserInfo.SEX_FEMALE, "getRadius", "()F", "setRadius", "(F)V", "radius", "Landroid/graphics/Path;", "e", "Landroid/graphics/Path;", "path", "Landroid/graphics/RectF;", "f", "Landroid/graphics/RectF;", "rectF", "<init>", "(Landroid/content/Context;)V", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyle", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes32.dex */
public final class ECRoundImageView extends ImageView {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private float radius;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private Path path;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private RectF rectF;

    public ECRoundImageView(Context context) {
        super(context);
        this.path = new Path();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.radius > 0.0f) {
            if (this.rectF == null) {
                this.rectF = new RectF(0.0f, 0.0f, getWidth(), getHeight());
            }
            RectF rectF = this.rectF;
            if (rectF != null) {
                Path path = this.path;
                float f16 = this.radius;
                path.addRoundRect(rectF, f16, f16, Path.Direction.CW);
            }
            if (canvas != null) {
                canvas.clipPath(this.path);
            }
        }
        super.onDraw(canvas);
    }

    public final void setRadius(float f16) {
        this.radius = f16;
    }

    public ECRoundImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.path = new Path();
        a(context, attributeSet);
    }

    private final void a(Context context, AttributeSet attrs) {
        if (attrs != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attrs, ok0.b.f423058v);
            this.radius = obtainStyledAttributes.getDimension(ok0.b.f423059w, this.radius);
            obtainStyledAttributes.recycle();
        }
    }

    public ECRoundImageView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.path = new Path();
        a(context, attributeSet);
    }
}
