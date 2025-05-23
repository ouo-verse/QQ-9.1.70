package com.tencent.mobileqq.guild.homev2.parts.title.view;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.guild.util.Logger;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u001e2\u00020\u0001:\u0001\u0005B1\b\u0007\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0018\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0007\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J0\u0010\r\u001a\u00020\f2\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u0007H\u0014J\u0012\u0010\u0010\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016J(\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u0007H\u0014\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/mobileqq/guild/homev2/parts/title/view/GuildHomeV2CoverTopCenterCropImageView;", "Landroid/widget/ImageView;", "", "from", "", "a", "changed", "", "left", "top", "right", "bottom", "", "onLayout", "Landroid/graphics/drawable/Drawable;", "drawable", "setImageDrawable", "l", "t", "r", "b", "setFrame", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "defStyleRes", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "d", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildHomeV2CoverTopCenterCropImageView extends ImageView {
    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuildHomeV2CoverTopCenterCropImageView(@NotNull Context context) {
        this(context, null, 0, 0, 14, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final boolean a(String from) {
        float f16;
        float f17;
        Drawable drawable = super.getDrawable();
        if (drawable == null) {
            return false;
        }
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        if (intrinsicWidth != 0 && intrinsicHeight != 0) {
            if (intrinsicWidth != -1 && intrinsicHeight != -1) {
                int width = (getWidth() - getPaddingLeft()) - getPaddingRight();
                int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
                if (width != 0 && height != 0) {
                    if (intrinsicWidth * height > width * intrinsicHeight) {
                        f16 = height / intrinsicHeight;
                        f17 = (width - (intrinsicWidth * f16)) * 0.5f;
                    } else {
                        f16 = width / intrinsicWidth;
                        f17 = 0.0f;
                    }
                    Matrix imageMatrix = super.getImageMatrix();
                    imageMatrix.setScale(f16, f16);
                    imageMatrix.postTranslate(f17, 0.0f);
                    super.setImageMatrix(imageMatrix);
                    return true;
                }
                Logger.f235387a.d().e("GuildHomeV2CoverTopCenterCropImageView", 1, "resetMatrix from:" + from + " unExpected vSize:" + width + HippyTKDListViewAdapter.X + height);
                return false;
            }
            Logger.f235387a.d().e("GuildHomeV2CoverTopCenterCropImageView", 1, "resetMatrix from:" + from + " unExpected dSize:" + intrinsicWidth + HippyTKDListViewAdapter.X + intrinsicHeight);
            return false;
        }
        Logger.f235387a.d().e("GuildHomeV2CoverTopCenterCropImageView", 1, "resetMatrix from:" + from + " unExpected dSize:" + intrinsicWidth + HippyTKDListViewAdapter.X + intrinsicHeight);
        return false;
    }

    @Override // android.view.View
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        a("onLayout");
    }

    @Override // android.widget.ImageView
    protected boolean setFrame(int l3, int t16, int r16, int b16) {
        a("setFrame");
        return super.setFrame(l3, t16, r16, b16);
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(@Nullable Drawable drawable) {
        super.setImageDrawable(drawable);
        a("setImageDrawable");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuildHomeV2CoverTopCenterCropImageView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuildHomeV2CoverTopCenterCropImageView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        this(context, attributeSet, i3, 0, 8, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ GuildHomeV2CoverTopCenterCropImageView(Context context, AttributeSet attributeSet, int i3, int i16, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i17 & 2) != 0 ? null : attributeSet, (i17 & 4) != 0 ? 0 : i3, (i17 & 8) != 0 ? 0 : i16);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuildHomeV2CoverTopCenterCropImageView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3, int i16) {
        super(context, attributeSet, i3, i16);
        Intrinsics.checkNotNullParameter(context, "context");
        setScaleType(ImageView.ScaleType.MATRIX);
    }
}
