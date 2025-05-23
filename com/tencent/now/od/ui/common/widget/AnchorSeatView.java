package com.tencent.now.od.ui.common.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.now.od.ui.game.meleegame.widget.PopularityView;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010.\u001a\u00020-\u0012\n\b\u0002\u00100\u001a\u0004\u0018\u00010/\u0012\b\b\u0002\u00101\u001a\u00020\u0006\u00a2\u0006\u0004\b2\u00103J\u0012\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u000e\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tR\u0014\u0010\u000f\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0017\u0010\u0015\u001a\u00020\u00108\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0019\u001a\u00020\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0017\u0010\u001f\u001a\u00020\u001a8\u0006\u00a2\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u0017\u0010%\u001a\u00020 8\u0006\u00a2\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R\"\u0010,\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+\u00a8\u00064"}, d2 = {"Lcom/tencent/now/od/ui/common/widget/AnchorSeatView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Landroid/graphics/Bitmap;", MimeHelper.IMAGE_SUBTYPE_BITMAP, "", "setAnchorImage", "", "popularity", "setPopularity", "", "res", "setDefaultAvatar", "Lcom/tencent/now/od/ui/common/widget/RoundImageView;", "d", "Lcom/tencent/now/od/ui/common/widget/RoundImageView;", "anchorIcon", "Landroid/widget/TextView;", "e", "Landroid/widget/TextView;", "getAnchorName", "()Landroid/widget/TextView;", "anchorName", "Lcom/tencent/now/od/ui/common/widget/WaveAnimationView;", "f", "Lcom/tencent/now/od/ui/common/widget/WaveAnimationView;", "speakWaveView", "Landroid/widget/ImageView;", h.F, "Landroid/widget/ImageView;", "getEffectImage", "()Landroid/widget/ImageView;", "effectImage", "Lcom/tencent/now/od/ui/game/meleegame/widget/PopularityView;", "i", "Lcom/tencent/now/od/ui/game/meleegame/widget/PopularityView;", "getAnchorPopularity", "()Lcom/tencent/now/od/ui/game/meleegame/widget/PopularityView;", "anchorPopularity", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/lang/String;", "getDefaultAvatarRes", "()Ljava/lang/String;", "setDefaultAvatarRes", "(Ljava/lang/String;)V", "defaultAvatarRes", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "qq-live-od-ui-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class AnchorSeatView extends ConstraintLayout {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final RoundImageView anchorIcon;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final TextView anchorName;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final WaveAnimationView speakWaveView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ImageView effectImage;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final PopularityView anchorPopularity;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String defaultAvatarRes;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public AnchorSeatView(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public static /* synthetic */ void setAnchorImage$default(AnchorSeatView anchorSeatView, Bitmap bitmap, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            bitmap = null;
        }
        anchorSeatView.setAnchorImage(bitmap);
    }

    public final void setAnchorImage(@Nullable Bitmap bitmap) {
        RoundImageView roundImageView = this.anchorIcon;
        if (bitmap == null) {
            vn3.a.c(roundImageView, this.defaultAvatarRes);
        } else {
            roundImageView.setImageBitmap(bitmap);
        }
    }

    public final void setDefaultAvatar(@NotNull String res) {
        Intrinsics.checkNotNullParameter(res, "res");
        this.defaultAvatarRes = res;
        vn3.a.c(this.anchorIcon, res);
    }

    public final void setDefaultAvatarRes(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.defaultAvatarRes = str;
    }

    public final void setPopularity(int popularity) {
        if (popularity > 0) {
            this.anchorPopularity.setVisibility(0);
            this.anchorPopularity.setPopularity(popularity);
        } else {
            this.anchorPopularity.setVisibility(8);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public AnchorSeatView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ AnchorSeatView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public AnchorSeatView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        this.defaultAvatarRes = "";
        LayoutInflater.from(context).inflate(R.layout.dzo, this);
        View findViewById = findViewById(R.id.so5);
        Intrinsics.checkNotNull(findViewById, "null cannot be cast to non-null type com.tencent.now.od.ui.common.widget.RoundImageView");
        this.anchorIcon = (RoundImageView) findViewById;
        View findViewById2 = findViewById(R.id.f164323sp2);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.anchor_seat_avatar_box)");
        vn3.a.c((ImageView) findViewById2, pn3.a.f426527o.b());
        View findViewById3 = findViewById(R.id.sop);
        Intrinsics.checkNotNull(findViewById3, "null cannot be cast to non-null type android.widget.TextView");
        this.anchorName = (TextView) findViewById3;
        View findViewById4 = findViewById(R.id.sox);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.anchor_popularity)");
        this.anchorPopularity = (PopularityView) findViewById4;
        View findViewById5 = findViewById(R.id.f87134tj);
        Intrinsics.checkNotNull(findViewById5, "null cannot be cast to non-null type com.tencent.now.od.ui.common.widget.WaveAnimationView");
        WaveAnimationView waveAnimationView = (WaveAnimationView) findViewById5;
        waveAnimationView.setColor(1090519039, false);
        this.speakWaveView = waveAnimationView;
        View findViewById6 = findViewById(R.id.t1d);
        Intrinsics.checkNotNull(findViewById6, "null cannot be cast to non-null type android.widget.ImageView");
        this.effectImage = (ImageView) findViewById6;
    }
}
