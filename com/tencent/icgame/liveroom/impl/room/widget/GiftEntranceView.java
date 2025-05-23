package com.tencent.icgame.liveroom.impl.room.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.util.x;
import com.tencent.mobileqq.vas.ui.APNGDrawable;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u0000 \u00142\u00020\u0001:\u0001\u0005B'\b\u0007\u0012\u0006\u0010\r\u001a\u00020\f\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0010\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0006\u0010\u0006\u001a\u00020\u0004J\u0006\u0010\u0007\u001a\u00020\u0004R\u0014\u0010\u000b\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/icgame/liveroom/impl/room/widget/GiftEntranceView;", "Landroid/widget/FrameLayout;", "", "margin", "", "a", "b", "c", "Landroid/widget/ImageView;", "d", "Landroid/widget/ImageView;", "placeHolderIv", "Landroid/content/Context;", "ctx", "Landroid/util/AttributeSet;", "attr", "", "def", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "e", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes7.dex */
public final class GiftEntranceView extends FrameLayout {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ImageView placeHolderIv;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GiftEntranceView(@NotNull Context ctx) {
        this(ctx, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(ctx, "ctx");
    }

    private final void a(float margin) {
        ViewGroup.LayoutParams layoutParams = this.placeHolderIv.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.leftMargin = x.c(getContext(), margin);
            marginLayoutParams.topMargin = x.c(getContext(), margin);
            marginLayoutParams.rightMargin = x.c(getContext(), margin);
            marginLayoutParams.bottomMargin = x.c(getContext(), margin);
        }
        this.placeHolderIv.setLayoutParams(layoutParams);
    }

    public final void b() {
        this.placeHolderIv.setImageDrawable(new APNGDrawable("GiftEntranceView", "https://dlied5v6.qq.com/now/qqlive_bottom_gift_icon.png"));
        a(0.0f);
    }

    public final void c() {
        this.placeHolderIv.setImageResource(R.drawable.f162564o92);
        a(5.0f);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GiftEntranceView(@NotNull Context ctx, @Nullable AttributeSet attributeSet) {
        this(ctx, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(ctx, "ctx");
    }

    public /* synthetic */ GiftEntranceView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GiftEntranceView(@NotNull Context ctx, @Nullable AttributeSet attributeSet, int i3) {
        super(ctx, attributeSet, i3);
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        ImageView imageView = new ImageView(ctx);
        imageView.setImageResource(R.drawable.f162564o92);
        this.placeHolderIv = imageView;
        addView(imageView, new FrameLayout.LayoutParams(-1, -1));
        setBackgroundResource(R.drawable.f162563o91);
    }
}
