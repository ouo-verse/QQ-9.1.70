package com.tencent.mobileqq.qwallet.hb.panel;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Outline;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.hb.IQWalletHbApi;
import com.tencent.mobileqq.qwallet.pb.RedPackSkin$RecommendSkin;
import com.tencent.mobileqq.qwallet.pb.RedPackSkin$SkinInfo;
import com.tencent.mobileqq.qwallet.pb.RedPackSkinExt;
import cooperation.qwallet.plugin.QWalletPicHelper;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt__MathJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 /2\u00020\u0001:\u00010B1\b\u0007\u0012\u0006\u0010(\u001a\u00020'\u0012\n\b\u0002\u0010*\u001a\u0004\u0018\u00010)\u0012\b\b\u0002\u0010+\u001a\u00020\u0004\u0012\b\b\u0002\u0010,\u001a\u00020\u0004\u00a2\u0006\u0004\b-\u0010.J\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004R\u0014\u0010\u000b\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\r\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\nR\u0014\u0010\u0011\u001a\u00020\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0013\u001a\u00020\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0010R\u0014\u0010\u0015\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\nR\u0014\u0010\u0017\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\nR\u0014\u0010\u0019\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\nR\u0016\u0010\u001d\u001a\u0004\u0018\u00010\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010\u001f\u001a\u0004\u0018\u00010\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001cR\"\u0010&\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%\u00a8\u00061"}, d2 = {"Lcom/tencent/mobileqq/qwallet/hb/panel/RecommendSkinView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Lcom/tencent/mobileqq/qwallet/pb/RedPackSkin$RecommendSkin;", "skinData", "", "showLabelType", "", "A0", "Landroid/widget/ImageView;", "d", "Landroid/widget/ImageView;", "imageView", "e", "specialImageView", "Landroid/widget/TextView;", "f", "Landroid/widget/TextView;", "labelView", tl.h.F, "leftLabelView", "i", "leftBadgeView", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "statusView", BdhLogUtil.LogTag.Tag_Conn, "redArc", "Landroid/graphics/drawable/Drawable;", "D", "Landroid/graphics/drawable/Drawable;", "defaultSkin", "E", "defaultSpecialSkin", UserInfo.SEX_FEMALE, "I", "getScene", "()I", "setScene", "(I)V", "scene", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "defStyleRes", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "G", "c", "qqpay-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class RecommendSkinView extends ConstraintLayout {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final ImageView redArc;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private final Drawable defaultSkin;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private final Drawable defaultSpecialSkin;

    /* renamed from: F, reason: from kotlin metadata */
    private int scene;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ImageView imageView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ImageView specialImageView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final TextView labelView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final TextView leftLabelView;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ImageView leftBadgeView;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ImageView statusView;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/qwallet/hb/panel/RecommendSkinView$a", "Landroid/view/ViewOutlineProvider;", "Landroid/view/View;", "view", "Landroid/graphics/Outline;", "outline", "", "getOutline", "qqpay-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public static final class a extends ViewOutlineProvider {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ float f277530a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ RecommendSkinView f277531b;

        a(float f16, RecommendSkinView recommendSkinView) {
            this.f277530a = f16;
            this.f277531b = recommendSkinView;
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(@Nullable View view, @Nullable Outline outline) {
            int roundToInt;
            int roundToInt2;
            if (outline != null) {
                roundToInt = MathKt__MathJVMKt.roundToInt(-this.f277530a);
                roundToInt2 = MathKt__MathJVMKt.roundToInt(this.f277531b.labelView.getWidth() + this.f277530a);
                outline.setRoundRect(0, roundToInt, roundToInt2, this.f277531b.labelView.getHeight(), this.f277530a);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/qwallet/hb/panel/RecommendSkinView$b", "Landroid/view/ViewOutlineProvider;", "Landroid/view/View;", "view", "Landroid/graphics/Outline;", "outline", "", "getOutline", "qqpay-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public static final class b extends ViewOutlineProvider {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ float f277533b;

        b(float f16) {
            this.f277533b = f16;
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(@Nullable View view, @Nullable Outline outline) {
            if (outline != null) {
                outline.setRoundRect(0, 0, RecommendSkinView.this.getWidth(), RecommendSkinView.this.getHeight(), this.f277533b);
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public RecommendSkinView(@NotNull Context context) {
        this(context, null, 0, 0, 14, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public final void A0(@NotNull RedPackSkin$RecommendSkin skinData, int showLabelType) {
        boolean z16;
        boolean z17;
        String str;
        boolean z18;
        PBStringField pBStringField;
        Intrinsics.checkNotNullParameter(skinData, "skinData");
        boolean z19 = true;
        if ((skinData.skin.type.get() & 8) != 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (this.scene == 1) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (z17) {
            RedPackSkin$SkinInfo redPackSkin$SkinInfo = skinData.skin;
            if (z16) {
                pBStringField = redPackSkin$SkinInfo.pop_broken_url;
            } else {
                pBStringField = redPackSkin$SkinInfo.pop_res_url;
            }
            str = pBStringField.get();
        } else {
            str = skinData.skin.aio_res_url.get();
        }
        String str2 = str;
        if (!getClipToOutline()) {
            setClipToOutline(true);
        }
        String c16 = RedPackSkinExt.c(skinData);
        this.labelView.setVisibility(8);
        this.leftLabelView.setVisibility(8);
        this.leftBadgeView.setVisibility(8);
        this.imageView.setVisibility(0);
        if (z16) {
            this.redArc.setVisibility(8);
            if (z17) {
                this.specialImageView.setVisibility(0);
            } else {
                this.specialImageView.setVisibility(8);
            }
        } else {
            this.redArc.setVisibility(0);
            this.specialImageView.setVisibility(8);
        }
        if (z16) {
            if (z17) {
                this.imageView.setVisibility(8);
                com.tencent.mobileqq.qwallet.utils.i.c(this.specialImageView, str2, this.defaultSpecialSkin, null, 8, null);
                setClipToOutline(false);
            } else {
                this.imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                com.tencent.mobileqq.qwallet.utils.i.c(this.imageView, str2, this.defaultSkin, null, 8, null);
            }
        } else {
            if (z17) {
                this.imageView.setScaleType(ImageView.ScaleType.FIT_START);
            } else {
                this.imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
            }
            com.tencent.mobileqq.qwallet.utils.i.c(this.imageView, str2, this.defaultSkin, null, 8, null);
        }
        if (showLabelType != 1) {
            if (showLabelType == 2) {
                String str3 = skinData.skin.badge_url.get();
                if (str3 != null && str3.length() != 0) {
                    z18 = false;
                } else {
                    z18 = true;
                }
                if (!z18) {
                    this.leftBadgeView.setVisibility(0);
                    this.leftBadgeView.setImageDrawable(QWalletPicHelper.getNetDrawableForQWallet(str3));
                } else {
                    if (c16.length() <= 0) {
                        z19 = false;
                    }
                    if (z19) {
                        this.leftLabelView.setVisibility(0);
                        this.leftLabelView.setText(c16);
                    }
                }
            }
        } else {
            if (c16.length() <= 0) {
                z19 = false;
            }
            if (z19) {
                this.labelView.setVisibility(0);
                this.labelView.setText(c16);
            }
        }
        if (skinData.has_got.get()) {
            if (!z17 && z16) {
                this.statusView.setVisibility(8);
                return;
            }
            ((IQWalletHbApi) QRoute.api(IQWalletHbApi.class)).updateOpenIcon(this.statusView, skinData.skin.pop_open_url.get());
            this.statusView.setVisibility(0);
            return;
        }
        this.statusView.setImageResource(R.drawable.mla);
        this.statusView.setVisibility(0);
    }

    public final void setScene(int i3) {
        this.scene = i3;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public RecommendSkinView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public RecommendSkinView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        this(context, attributeSet, i3, 0, 8, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ RecommendSkinView(Context context, AttributeSet attributeSet, int i3, int i16, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i17 & 2) != 0 ? null : attributeSet, (i17 & 4) != 0 ? 0 : i3, (i17 & 8) != 0 ? 0 : i16);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public RecommendSkinView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3, int i16) {
        super(context, attributeSet, i3, i16);
        int roundToInt;
        int roundToInt2;
        Intrinsics.checkNotNullParameter(context, "context");
        this.defaultSkin = ContextCompat.getDrawable(context, R.drawable.fpw);
        this.defaultSpecialSkin = ContextCompat.getDrawable(context, R.drawable.nuz);
        View.inflate(context, R.layout.him, this);
        View findViewById = findViewById(R.id.f85914q9);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.skin_img)");
        this.imageView = (ImageView) findViewById;
        View findViewById2 = findViewById(R.id.f86044ql);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.skin_special_img)");
        this.specialImageView = (ImageView) findViewById2;
        View findViewById3 = findViewById(R.id.f85924q_);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.skin_label)");
        TextView textView = (TextView) findViewById3;
        this.labelView = textView;
        View findViewById4 = findViewById(R.id.f85944qb);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.skin_label_left)");
        this.leftLabelView = (TextView) findViewById4;
        View findViewById5 = findViewById(R.id.f85864q4);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(R.id.skin_badge_left)");
        this.leftBadgeView = (ImageView) findViewById5;
        View findViewById6 = findViewById(R.id.f86054qm);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "findViewById(R.id.skin_status)");
        this.statusView = (ImageView) findViewById6;
        View findViewById7 = findViewById(R.id.f86024qj);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "findViewById(R.id.skin_red_arc)");
        this.redArc = (ImageView) findViewById7;
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, fj2.a.f399668x4, 0, 0);
        try {
            float dimension = obtainStyledAttributes.getDimension(fj2.a.f399676y4, 0.0f);
            textView.setTextSize(0, obtainStyledAttributes.getDimension(fj2.a.A4, 9.0f));
            roundToInt = MathKt__MathJVMKt.roundToInt(obtainStyledAttributes.getDimension(fj2.a.B4, 0.0f));
            roundToInt2 = MathKt__MathJVMKt.roundToInt(obtainStyledAttributes.getDimension(fj2.a.f399684z4, 0.0f));
            textView.setPadding(roundToInt2, roundToInt, roundToInt2, roundToInt);
            textView.setOutlineProvider(new a(dimension, this));
            textView.setClipToOutline(true);
            setOutlineProvider(new b(dimension));
            setClipToOutline(true);
        } finally {
            obtainStyledAttributes.recycle();
        }
    }
}
