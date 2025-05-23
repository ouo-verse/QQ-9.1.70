package com.tencent.mobileqq.wink.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatImageView;
import com.heytap.databaseengine.model.UserInfo;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.wink.api.R;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0019\u001a\u00020\u0018\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001a\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u001c\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0014J&\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0006R\u0016\u0010\u000e\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u0010\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\rR\u0016\u0010\u0012\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\rR\u0016\u0010\u0014\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\rR\u0014\u0010\u0017\u001a\u00020\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u0016\u00a8\u0006 "}, d2 = {"Lcom/tencent/mobileqq/wink/view/WinkRoundedCornerImageView;", "Landroidx/appcompat/widget/AppCompatImageView;", "Landroid/graphics/Canvas;", PM.CANVAS, "", "onDraw", "", "topLeft", "topRight", "bottomRight", "bottomLeft", "setCornerRadius", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, UserInfo.SEX_FEMALE, "topLeftRadius", BdhLogUtil.LogTag.Tag_Conn, "topRightRadius", "D", "bottomLeftRadius", "E", "bottomRightRadius", "Landroid/graphics/Path;", "Landroid/graphics/Path;", "path", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "qq-wink-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class WinkRoundedCornerImageView extends AppCompatImageView {

    /* renamed from: C, reason: from kotlin metadata */
    private float topRightRadius;

    /* renamed from: D, reason: from kotlin metadata */
    private float bottomLeftRadius;

    /* renamed from: E, reason: from kotlin metadata */
    private float bottomRightRadius;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final Path path;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private float topLeftRadius;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public WinkRoundedCornerImageView(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(@NotNull Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        float width = getWidth();
        float height = getHeight();
        this.path.reset();
        Path path = this.path;
        RectF rectF = new RectF(0.0f, 0.0f, width, height);
        float f16 = this.topLeftRadius;
        float f17 = this.topRightRadius;
        float f18 = this.bottomRightRadius;
        float f19 = this.bottomLeftRadius;
        path.addRoundRect(rectF, new float[]{f16, f16, f17, f17, f18, f18, f19, f19}, Path.Direction.CW);
        canvas.clipPath(this.path);
        super.onDraw(canvas);
    }

    public final void setCornerRadius(float topLeft, float topRight, float bottomRight, float bottomLeft) {
        this.topLeftRadius = topLeft;
        this.topRightRadius = topRight;
        this.bottomRightRadius = bottomRight;
        this.bottomLeftRadius = bottomLeft;
        invalidate();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public WinkRoundedCornerImageView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ WinkRoundedCornerImageView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public WinkRoundedCornerImageView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        this.path = new Path();
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.CustomRoundedCornerImageView, 0, 0);
        try {
            this.topLeftRadius = obtainStyledAttributes.getDimension(R.styleable.CustomRoundedCornerImageView_topLeftRadius, 0.0f);
            this.topRightRadius = obtainStyledAttributes.getDimension(R.styleable.CustomRoundedCornerImageView_topRightRadius, 0.0f);
            this.bottomLeftRadius = obtainStyledAttributes.getDimension(R.styleable.CustomRoundedCornerImageView_bottomLeftRadius, 0.0f);
            this.bottomRightRadius = obtainStyledAttributes.getDimension(R.styleable.CustomRoundedCornerImageView_bottomRightRadius, 0.0f);
        } finally {
            obtainStyledAttributes.recycle();
        }
    }
}
