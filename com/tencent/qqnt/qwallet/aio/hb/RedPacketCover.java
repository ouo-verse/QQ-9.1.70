package com.tencent.qqnt.qwallet.aio.hb;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.ViewUtils;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B1\b\u0007\u0012\u0006\u0010\u001b\u001a\u00020\u001a\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001c\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u001e\u0012\b\b\u0002\u0010 \u001a\u00020\u001e\u00a2\u0006\u0004\b!\u0010\"R\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\n\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0006R\u0017\u0010\r\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006R\u0017\u0010\u0013\u001a\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0019\u001a\u00020\u00148\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\u00a8\u0006#"}, d2 = {"Lcom/tencent/qqnt/qwallet/aio/hb/RedPacketCover;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Landroid/widget/ImageView;", "d", "Landroid/widget/ImageView;", "z0", "()Landroid/widget/ImageView;", "bgView", "e", "B0", "openIcon", "f", "C0", "redArc", "Landroid/widget/TextView;", tl.h.F, "Landroid/widget/TextView;", "D0", "()Landroid/widget/TextView;", "stateView", "Landroid/view/View;", "i", "Landroid/view/View;", "A0", "()Landroid/view/View;", "maskView", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "", "defStyleAttr", "defStyleRes", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class RedPacketCover extends ConstraintLayout {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ImageView bgView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ImageView openIcon;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ImageView redArc;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final TextView stateView;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final View maskView;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public RedPacketCover(@NotNull Context context) {
        this(context, null, 0, 0, 14, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @NotNull
    /* renamed from: A0, reason: from getter */
    public final View getMaskView() {
        return this.maskView;
    }

    @NotNull
    /* renamed from: B0, reason: from getter */
    public final ImageView getOpenIcon() {
        return this.openIcon;
    }

    @NotNull
    /* renamed from: C0, reason: from getter */
    public final ImageView getRedArc() {
        return this.redArc;
    }

    @NotNull
    /* renamed from: D0, reason: from getter */
    public final TextView getStateView() {
        return this.stateView;
    }

    @NotNull
    /* renamed from: z0, reason: from getter */
    public final ImageView getBgView() {
        return this.bgView;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public RedPacketCover(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public RedPacketCover(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        this(context, attributeSet, i3, 0, 8, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ RedPacketCover(Context context, AttributeSet attributeSet, int i3, int i16, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i17 & 2) != 0 ? null : attributeSet, (i17 & 4) != 0 ? 0 : i3, (i17 & 8) != 0 ? 0 : i16);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public RedPacketCover(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3, int i16) {
        super(context, attributeSet, i3, i16);
        Intrinsics.checkNotNullParameter(context, "context");
        View.inflate(context, R.layout.e5a, this);
        View findViewById = findViewById(R.id.x6j);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.hb_envelope_bg)");
        this.bgView = (ImageView) findViewById;
        View findViewById2 = findViewById(R.id.x6m);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.hb_envelope_red_arc)");
        this.redArc = (ImageView) findViewById2;
        View findViewById3 = findViewById(R.id.x6l);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.hb_envelope_open_icon)");
        this.openIcon = (ImageView) findViewById3;
        View findViewById4 = findViewById(R.id.x6n);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.hb_envelope_state_text)");
        this.stateView = (TextView) findViewById4;
        View findViewById5 = findViewById(R.id.x6k);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(R.id.hb_envelope_mask)");
        this.maskView = findViewById5;
        com.tencent.mobileqq.qwallet.k.b(this, ViewUtils.dip2px(6.0f));
    }
}
