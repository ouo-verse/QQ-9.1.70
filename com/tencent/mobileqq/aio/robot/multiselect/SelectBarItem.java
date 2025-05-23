package com.tencent.mobileqq.aio.robot.multiselect;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.ViewUtils;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00172\u00020\u0001:\u0001\u0007B'\b\u0007\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0012\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0007\u001a\u00020\u0006J\u000e\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bR\u0014\u0010\r\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/aio/robot/multiselect/SelectBarItem;", "Landroid/widget/LinearLayout;", "", "resId", "", "setImage", "Landroid/widget/ImageView;", "a", "", "enable", "setClickEnable", "d", "Landroid/widget/ImageView;", "imageView", "e", "I", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "f", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class SelectBarItem extends LinearLayout {

    /* renamed from: h, reason: collision with root package name */
    private static final int f193562h = ViewUtils.dip2px(24.0f);

    /* renamed from: i, reason: collision with root package name */
    private static final int f193563i = ViewUtils.dip2px(12.0f);

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ImageView imageView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private int resId;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public SelectBarItem(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final ImageView getImageView() {
        return this.imageView;
    }

    public final void setClickEnable(boolean enable) {
        setEnabled(enable);
        if (enable) {
            this.imageView.setImageDrawable(ie0.a.f().o(getContext(), this.resId, R.color.qui_common_icon_primary, 1000));
        } else {
            this.imageView.setImageDrawable(ie0.a.f().o(getContext(), this.resId, R.color.qui_common_icon_tertiary, 1000));
        }
    }

    public final void setImage(int resId) {
        this.resId = resId;
        this.imageView.setImageResource(resId);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public SelectBarItem(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ SelectBarItem(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public SelectBarItem(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        setLayoutParams(new LinearLayout.LayoutParams(-2, -1));
        setOrientation(1);
        ImageView imageView = new ImageView(context);
        int i16 = f193562h;
        imageView.setLayoutParams(new LinearLayout.LayoutParams(i16, i16));
        imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        this.imageView = imageView;
        addView(imageView, imageView.getLayoutParams());
        setGravity(48);
        int i17 = f193563i;
        setPadding(i17, 0, i17, 0);
    }
}
