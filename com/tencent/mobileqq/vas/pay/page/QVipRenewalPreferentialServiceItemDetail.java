package com.tencent.mobileqq.vas.pay.page;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.image.ApngDrawable;
import com.tencent.image.ApngImage;
import com.tencent.image.RegionDrawable;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.widget.RoundRectImageView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0013\b\u0016\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017\u00a2\u0006\u0004\b\u0019\u0010\u001aB\u001d\b\u0016\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b\u00a2\u0006\u0004\b\u0019\u0010\u001dB%\b\u0016\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b\u0012\u0006\u0010\u001e\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0019\u0010\u001fJ\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H\u0002J\u0006\u0010\n\u001a\u00020\tJ\u000e\u0010\r\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bJ\u000e\u0010\u000f\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u000bR\u0014\u0010\u0012\u001a\u00020\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0011R\u0014\u0010\u0016\u001a\u00020\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015\u00a8\u0006 "}, d2 = {"Lcom/tencent/mobileqq/vas/pay/page/QVipRenewalPreferentialServiceItemDetail;", "Landroid/widget/LinearLayout;", "Lcom/tencent/image/URLDrawable;", "d", "", "", "w", tl.h.F, "b", "", "c", "", "detail", "setDetailText", "picUrl", "setPic", "Landroid/widget/TextView;", "Landroid/widget/TextView;", "qvipRenewalItemDetailTitle", "Lcom/tencent/widget/RoundRectImageView;", "e", "Lcom/tencent/widget/RoundRectImageView;", "qvipRenewalItemDetailPic", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class QVipRenewalPreferentialServiceItemDetail extends LinearLayout {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final TextView qvipRenewalItemDetailTitle;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final RoundRectImageView qvipRenewalItemDetailPic;

    public QVipRenewalPreferentialServiceItemDetail(@Nullable Context context) {
        super(context);
        this.qvipRenewalItemDetailTitle = (TextView) o.a(this, R.id.f66943c0, new LinearLayout.LayoutParams(-2, -2), new Function0<TextView>() { // from class: com.tencent.mobileqq.vas.pay.page.QVipRenewalPreferentialServiceItemDetail$qvipRenewalItemDetailTitle$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final TextView invoke() {
                return o.v(QVipRenewalPreferentialServiceItemDetail.this, new Function1<TextView, Unit>() { // from class: com.tencent.mobileqq.vas.pay.page.QVipRenewalPreferentialServiceItemDetail$qvipRenewalItemDetailTitle$1.1
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(TextView textView) {
                        invoke2(textView);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull TextView text) {
                        Intrinsics.checkNotNullParameter(text, "$this$text");
                        text.setTextSize(o.u(14));
                    }
                });
            }
        });
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 1;
        layoutParams.topMargin = o.i(12);
        Unit unit = Unit.INSTANCE;
        this.qvipRenewalItemDetailPic = (RoundRectImageView) o.a(this, R.id.f66933bz, layoutParams, new Function0<RoundRectImageView>() { // from class: com.tencent.mobileqq.vas.pay.page.QVipRenewalPreferentialServiceItemDetail$qvipRenewalItemDetailPic$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final RoundRectImageView invoke() {
                return o.t(QVipRenewalPreferentialServiceItemDetail.this, new Function1<RoundRectImageView, Unit>() { // from class: com.tencent.mobileqq.vas.pay.page.QVipRenewalPreferentialServiceItemDetail$qvipRenewalItemDetailPic$2.1
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(RoundRectImageView roundRectImageView) {
                        invoke2(roundRectImageView);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull RoundRectImageView roundImage) {
                        Intrinsics.checkNotNullParameter(roundImage, "$this$roundImage");
                        roundImage.setBackgroundColor(-7829368);
                        roundImage.setCornerRadiusAndMode(o.i(4), 1);
                        roundImage.setVisibility(8);
                    }
                });
            }
        });
        setOrientation(1);
        setBackgroundResource(R.drawable.la5);
        setPadding(o.i(16), o.i(12), o.i(16), o.i(12));
    }

    private final int b(int w3, int h16) {
        if (w3 > 0 && h16 > 0) {
            int measuredWidth = this.qvipRenewalItemDetailPic.getMeasuredWidth();
            if (measuredWidth == 0) {
                measuredWidth = ViewUtils.getScreenWidth() - (o.i(32) * 2);
            }
            return (int) (((measuredWidth * 1.0f) / w3) * h16);
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean d(URLDrawable d16) {
        int i3;
        if (d16.getCurrDrawable() instanceof RegionDrawable) {
            Drawable currDrawable = d16.getCurrDrawable();
            Intrinsics.checkNotNull(currDrawable, "null cannot be cast to non-null type com.tencent.image.RegionDrawable");
            Bitmap bitmap = ((RegionDrawable) currDrawable).getBitmap();
            i3 = b(bitmap.getWidth(), bitmap.getHeight());
        } else if (d16.getCurrDrawable() instanceof ApngDrawable) {
            Drawable currDrawable2 = d16.getCurrDrawable();
            Intrinsics.checkNotNull(currDrawable2, "null cannot be cast to non-null type com.tencent.image.ApngDrawable");
            ApngImage image = ((ApngDrawable) currDrawable2).getImage();
            i3 = b(image.width, image.height);
        } else {
            i3 = 0;
        }
        if (i3 <= 0) {
            return false;
        }
        RoundRectImageView roundRectImageView = this.qvipRenewalItemDetailPic;
        ViewGroup.LayoutParams layoutParams = roundRectImageView.getLayoutParams();
        layoutParams.height = i3;
        roundRectImageView.setLayoutParams(layoutParams);
        return true;
    }

    public final void c() {
        this.qvipRenewalItemDetailTitle.setTextColor(o.f("#8F5600", "#FFDEAE"));
    }

    public final void setDetailText(@NotNull String detail) {
        Intrinsics.checkNotNullParameter(detail, "detail");
        this.qvipRenewalItemDetailTitle.setText(detail);
    }

    public final void setPic(@NotNull String picUrl) {
        Intrinsics.checkNotNullParameter(picUrl, "picUrl");
        if (TextUtils.isEmpty(picUrl)) {
            this.qvipRenewalItemDetailPic.setVisibility(8);
            setBackground(o.l(this, R.drawable.la5, R.drawable.la6));
            return;
        }
        this.qvipRenewalItemDetailPic.setVisibility(0);
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        ColorDrawable colorDrawable = new ColorDrawable(0);
        obtain.mFailedDrawable = colorDrawable;
        obtain.mLoadingDrawable = colorDrawable;
        URLDrawable d16 = URLDrawable.getDrawable(picUrl, obtain);
        Intrinsics.checkNotNullExpressionValue(d16, "d");
        if (!d(d16)) {
            d16.setURLDrawableListener(new a(d16, this));
        }
        this.qvipRenewalItemDetailPic.setImageDrawable(d16);
        setBackground(o.l(this, R.drawable.f162139la3, R.drawable.f162140la4));
    }

    public QVipRenewalPreferentialServiceItemDetail(@Nullable Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.qvipRenewalItemDetailTitle = (TextView) o.a(this, R.id.f66943c0, new LinearLayout.LayoutParams(-2, -2), new Function0<TextView>() { // from class: com.tencent.mobileqq.vas.pay.page.QVipRenewalPreferentialServiceItemDetail$qvipRenewalItemDetailTitle$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final TextView invoke() {
                return o.v(QVipRenewalPreferentialServiceItemDetail.this, new Function1<TextView, Unit>() { // from class: com.tencent.mobileqq.vas.pay.page.QVipRenewalPreferentialServiceItemDetail$qvipRenewalItemDetailTitle$1.1
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(TextView textView) {
                        invoke2(textView);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull TextView text) {
                        Intrinsics.checkNotNullParameter(text, "$this$text");
                        text.setTextSize(o.u(14));
                    }
                });
            }
        });
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 1;
        layoutParams.topMargin = o.i(12);
        Unit unit = Unit.INSTANCE;
        this.qvipRenewalItemDetailPic = (RoundRectImageView) o.a(this, R.id.f66933bz, layoutParams, new Function0<RoundRectImageView>() { // from class: com.tencent.mobileqq.vas.pay.page.QVipRenewalPreferentialServiceItemDetail$qvipRenewalItemDetailPic$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final RoundRectImageView invoke() {
                return o.t(QVipRenewalPreferentialServiceItemDetail.this, new Function1<RoundRectImageView, Unit>() { // from class: com.tencent.mobileqq.vas.pay.page.QVipRenewalPreferentialServiceItemDetail$qvipRenewalItemDetailPic$2.1
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(RoundRectImageView roundRectImageView) {
                        invoke2(roundRectImageView);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull RoundRectImageView roundImage) {
                        Intrinsics.checkNotNullParameter(roundImage, "$this$roundImage");
                        roundImage.setBackgroundColor(-7829368);
                        roundImage.setCornerRadiusAndMode(o.i(4), 1);
                        roundImage.setVisibility(8);
                    }
                });
            }
        });
        setOrientation(1);
        setBackgroundResource(R.drawable.la5);
        setPadding(o.i(16), o.i(12), o.i(16), o.i(12));
    }

    public QVipRenewalPreferentialServiceItemDetail(@Nullable Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.qvipRenewalItemDetailTitle = (TextView) o.a(this, R.id.f66943c0, new LinearLayout.LayoutParams(-2, -2), new Function0<TextView>() { // from class: com.tencent.mobileqq.vas.pay.page.QVipRenewalPreferentialServiceItemDetail$qvipRenewalItemDetailTitle$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final TextView invoke() {
                return o.v(QVipRenewalPreferentialServiceItemDetail.this, new Function1<TextView, Unit>() { // from class: com.tencent.mobileqq.vas.pay.page.QVipRenewalPreferentialServiceItemDetail$qvipRenewalItemDetailTitle$1.1
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(TextView textView) {
                        invoke2(textView);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull TextView text) {
                        Intrinsics.checkNotNullParameter(text, "$this$text");
                        text.setTextSize(o.u(14));
                    }
                });
            }
        });
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 1;
        layoutParams.topMargin = o.i(12);
        Unit unit = Unit.INSTANCE;
        this.qvipRenewalItemDetailPic = (RoundRectImageView) o.a(this, R.id.f66933bz, layoutParams, new Function0<RoundRectImageView>() { // from class: com.tencent.mobileqq.vas.pay.page.QVipRenewalPreferentialServiceItemDetail$qvipRenewalItemDetailPic$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final RoundRectImageView invoke() {
                return o.t(QVipRenewalPreferentialServiceItemDetail.this, new Function1<RoundRectImageView, Unit>() { // from class: com.tencent.mobileqq.vas.pay.page.QVipRenewalPreferentialServiceItemDetail$qvipRenewalItemDetailPic$2.1
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(RoundRectImageView roundRectImageView) {
                        invoke2(roundRectImageView);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull RoundRectImageView roundImage) {
                        Intrinsics.checkNotNullParameter(roundImage, "$this$roundImage");
                        roundImage.setBackgroundColor(-7829368);
                        roundImage.setCornerRadiusAndMode(o.i(4), 1);
                        roundImage.setVisibility(8);
                    }
                });
            }
        });
        setOrientation(1);
        setBackgroundResource(R.drawable.la5);
        setPadding(o.i(16), o.i(12), o.i(16), o.i(12));
    }

    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001c\u0010\b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010\t\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001a\u0010\f\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0016\u00a8\u0006\r"}, d2 = {"com/tencent/mobileqq/vas/pay/page/QVipRenewalPreferentialServiceItemDetail$a", "Lcom/tencent/image/URLDrawable$URLDrawableListener;", "Lcom/tencent/image/URLDrawable;", "drawable", "", "onLoadSuccessed", "", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_CAUSE, "onLoadFialed", "onLoadCanceled", "", "progress", "onLoadProgressed", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public static final class a implements URLDrawable.URLDrawableListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ URLDrawable f310340d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ QVipRenewalPreferentialServiceItemDetail f310341e;

        a(URLDrawable uRLDrawable, QVipRenewalPreferentialServiceItemDetail qVipRenewalPreferentialServiceItemDetail) {
            this.f310340d = uRLDrawable;
            this.f310341e = qVipRenewalPreferentialServiceItemDetail;
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadSuccessed(@Nullable URLDrawable drawable) {
            this.f310340d.setURLDrawableListener(null);
            QVipRenewalPreferentialServiceItemDetail qVipRenewalPreferentialServiceItemDetail = this.f310341e;
            URLDrawable d16 = this.f310340d;
            Intrinsics.checkNotNullExpressionValue(d16, "d");
            qVipRenewalPreferentialServiceItemDetail.d(d16);
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadCanceled(@Nullable URLDrawable drawable) {
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadFialed(@Nullable URLDrawable drawable, @Nullable Throwable cause) {
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadProgressed(@Nullable URLDrawable drawable, int progress) {
        }
    }
}
