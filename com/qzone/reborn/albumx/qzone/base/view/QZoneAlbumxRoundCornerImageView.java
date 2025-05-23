package com.qzone.reborn.albumx.qzone.base.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.biz.qqcircle.richframework.widget.PressDarkImageView;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0014\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B)\b\u0007\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0017\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0019\u00a2\u0006\u0004\b\u001b\u0010\u001cJ&\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0002J\u0010\u0010\f\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\nH\u0016R\u0014\u0010\u0010\u001a\u00020\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013\u00a8\u0006\u001d"}, d2 = {"Lcom/qzone/reborn/albumx/qzone/base/view/QZoneAlbumxRoundCornerImageView;", "Lcom/tencent/biz/qqcircle/richframework/widget/PressDarkImageView;", "", "leftTop", "rightTop", "rightBottom", "leftBottom", "", "setRadius", "radius", "Landroid/graphics/Canvas;", PM.CANVAS, "draw", "Landroid/graphics/Path;", "i", "Landroid/graphics/Path;", "mPath", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "[F", "mRadii", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "", "defStyle", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QZoneAlbumxRoundCornerImageView extends PressDarkImageView {

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final Path mPath;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private float[] mRadii;

    public QZoneAlbumxRoundCornerImageView(Context context) {
        this(context, null, 0, 6, null);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        this.mPath.reset();
        this.mPath.addRoundRect(new RectF(getPaddingLeft(), getPaddingTop(), getPaddingLeft() + ((getWidth() - getPaddingLeft()) - getPaddingRight()), getPaddingTop() + ((getHeight() - getPaddingTop()) - getPaddingBottom())), this.mRadii, Path.Direction.CCW);
        this.mPath.setFillType(Path.FillType.EVEN_ODD);
        canvas.clipPath(this.mPath);
        super.draw(canvas);
    }

    public final void setRadius(float leftTop, float rightTop, float rightBottom, float leftBottom) {
        this.mRadii = new float[]{leftTop, leftTop, rightTop, rightTop, rightBottom, rightBottom, leftBottom, leftBottom};
    }

    public QZoneAlbumxRoundCornerImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    public final void setRadius(float radius) {
        setRadius(radius, radius, radius, radius);
    }

    public /* synthetic */ QZoneAlbumxRoundCornerImageView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    public QZoneAlbumxRoundCornerImageView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.mPath = new Path();
        this.mRadii = new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
        super.setLayerType(2, null);
    }
}
