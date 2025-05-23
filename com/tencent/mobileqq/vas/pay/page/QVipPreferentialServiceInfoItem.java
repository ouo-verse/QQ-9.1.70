package com.tencent.mobileqq.vas.pay.page;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.image.ApngDrawable;
import com.tencent.image.RegionDrawable;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.vas.image.AbsAsyncDrawable;
import com.tencent.mobileqq.vas.image.ILoaderSucessCallback;
import com.tencent.mobileqq.vas.pay.api.impl.VasNativePayManagerImpl;
import com.tencent.mtt.hippy.views.hippylist.ViewStickEventHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 J2\u00020\u0001:\u0001KB\u0011\b\u0016\u0012\u0006\u0010B\u001a\u00020A\u00a2\u0006\u0004\bC\u0010DB\u001b\b\u0016\u0012\u0006\u0010B\u001a\u00020A\u0012\b\u0010F\u001a\u0004\u0018\u00010E\u00a2\u0006\u0004\bC\u0010GB#\b\u0016\u0012\u0006\u0010B\u001a\u00020A\u0012\b\u0010F\u001a\u0004\u0018\u00010E\u0012\u0006\u0010H\u001a\u00020\u0002\u00a2\u0006\u0004\bC\u0010IJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u000e\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0006J\u0016\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\fJ\u0016\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\fJ\u000e\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0006J\u000e\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\fJ>\u0010\u001c\u001a\u00020\u000426\u0010\u001b\u001a2\u0012\u0013\u0012\u00110\u0016\u00a2\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u0019\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u001a\u0012\u0004\u0012\u00020\u00040\u0015R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0014\u0010\"\u001a\u00020\u001f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010&\u001a\u00020#8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0014\u0010*\u001a\u00020'8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0014\u0010,\u001a\u00020'8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b+\u0010)R\u0014\u0010.\u001a\u00020'8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b-\u0010)R\u0014\u00100\u001a\u00020#8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b/\u0010%R\u0014\u00104\u001a\u0002018\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b2\u00103R\u0014\u00106\u001a\u0002018\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b5\u00103R\u0014\u00108\u001a\u0002018\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b7\u00103R\u0014\u0010:\u001a\u0002018\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b9\u00103R\u0014\u0010<\u001a\u0002018\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b;\u00103R\u001b\u0010@\u001a\u00020\u00168BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001e\u0010=\u001a\u0004\b>\u0010?\u00a8\u0006L"}, d2 = {"Lcom/tencent/mobileqq/vas/pay/page/QVipPreferentialServiceInfoItem;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "", "position", "", "setPosition", "", "url", "setItemBg", "flagText", "setRedFlag", "title", "", "isSelected", "setInfoTitle", "price", "setPreferentialPrice", "originalPrice", "setOriginalPrice", ViewStickEventHelper.IS_SHOW, "setSmallTriangleMarkVisible", "Lkotlin/Function2;", "Landroid/view/View;", "Lkotlin/ParameterName;", "name", "v", "p", "invoke", "setOnItemClickListener", "d", "I", "Landroid/graphics/Typeface;", "e", "Landroid/graphics/Typeface;", "numTypeface", "Landroid/widget/ImageView;", "f", "Landroid/widget/ImageView;", "bgImage", "Landroidx/cardview/widget/CardView;", tl.h.F, "Landroidx/cardview/widget/CardView;", "qvipRenewalPreferentialServiceBg", "i", "topRightShadow", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "bottomLeftShadow", BdhLogUtil.LogTag.Tag_Conn, "qvipRenewalPreferentialServiceBgImg", "Landroid/widget/TextView;", "D", "Landroid/widget/TextView;", "qvipRenewalRedFlag", "E", "qvipRenewalPreferentialInfoTitle", UserInfo.SEX_FEMALE, "moneySymbol", "G", "qvipRenewalPreferentialInfoPrice", "H", "qvipRenewalOriginalPrice", "Lkotlin/Lazy;", "D0", "()Landroid/view/View;", "smallTriangleMark", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "J", "a", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class QVipPreferentialServiceInfoItem extends ConstraintLayout {
    private static final float K = o.i(12) + 1;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final ImageView qvipRenewalPreferentialServiceBgImg;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final TextView qvipRenewalRedFlag;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final TextView qvipRenewalPreferentialInfoTitle;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final TextView moneySymbol;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final TextView qvipRenewalPreferentialInfoPrice;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final TextView qvipRenewalOriginalPrice;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final Lazy smallTriangleMark;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private int position;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Typeface numTypeface;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private ImageView bgImage;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final CardView qvipRenewalPreferentialServiceBg;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final CardView topRightShadow;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final CardView bottomLeftShadow;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QVipPreferentialServiceInfoItem(@NotNull Context context) {
        super(context);
        Lazy lazy;
        Intrinsics.checkNotNullParameter(context, "context");
        this.position = -1;
        setLayoutParams(new ViewGroup.LayoutParams(o.i(109), o.i(141)));
        setClipToPadding(false);
        setClipChildren(false);
        Typeface createFromAsset = Typeface.createFromAsset(getContext().getResources().getAssets(), VasNativePayManagerImpl.DINALTERNATE_BOLD_FONT_PATH);
        Intrinsics.checkNotNullExpressionValue(createFromAsset, "createFromAsset(context.\u2026ALTERNATE_BOLD_FONT_PATH)");
        this.numTypeface = createFromAsset;
        ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(-2, -2);
        layoutParams.topToTop = 0;
        layoutParams.leftToLeft = 0;
        layoutParams.setMarginStart(o.i(3));
        ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = o.i(7);
        Unit unit = Unit.INSTANCE;
        this.qvipRenewalPreferentialServiceBg = (CardView) o.a(this, R.id.f67083cd, layoutParams, new Function0<CardView>() { // from class: com.tencent.mobileqq.vas.pay.page.QVipPreferentialServiceInfoItem$qvipRenewalPreferentialServiceBg$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final CardView invoke() {
                CardView cardView = new CardView(QVipPreferentialServiceInfoItem.this.getContext());
                QVipPreferentialServiceInfoItem qVipPreferentialServiceInfoItem = QVipPreferentialServiceInfoItem.this;
                cardView.setClipChildren(false);
                cardView.setCardElevation(o.i(5));
                cardView.setRadius(o.i(18));
                cardView.setCardBackgroundColor(Color.parseColor("#33cfcfcf"));
                cardView.addView(o.w(qVipPreferentialServiceInfoItem, new Function1<View, Unit>() { // from class: com.tencent.mobileqq.vas.pay.page.QVipPreferentialServiceInfoItem$qvipRenewalPreferentialServiceBg$2$1$1
                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull View view) {
                        Intrinsics.checkNotNullParameter(view, "$this$view");
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(View view) {
                        invoke2(view);
                        return Unit.INSTANCE;
                    }
                }), new FrameLayout.LayoutParams(o.i(97), o.i(129)));
                return cardView;
            }
        });
        ConstraintLayout.LayoutParams layoutParams2 = new ConstraintLayout.LayoutParams(o.i(18), o.i(18));
        layoutParams2.topToTop = 0;
        layoutParams2.endToEnd = R.id.f67083cd;
        ((ViewGroup.MarginLayoutParams) layoutParams2).topMargin = o.i(7);
        this.topRightShadow = (CardView) o.c(this, layoutParams2, new Function0<CardView>() { // from class: com.tencent.mobileqq.vas.pay.page.QVipPreferentialServiceInfoItem$topRightShadow$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final CardView invoke() {
                CardView cardView = new CardView(QVipPreferentialServiceInfoItem.this.getContext());
                cardView.setAlpha(0.8f);
                cardView.setCardElevation(o.i(5));
                cardView.setRadius(o.i(6));
                cardView.setCardBackgroundColor(Color.parseColor("#33cfcfcf"));
                return cardView;
            }
        });
        ConstraintLayout.LayoutParams layoutParams3 = new ConstraintLayout.LayoutParams(o.i(18), o.i(18));
        layoutParams3.bottomToBottom = R.id.f67083cd;
        layoutParams3.startToStart = 0;
        layoutParams3.setMarginStart(o.i(3));
        this.bottomLeftShadow = (CardView) o.c(this, layoutParams3, new Function0<CardView>() { // from class: com.tencent.mobileqq.vas.pay.page.QVipPreferentialServiceInfoItem$bottomLeftShadow$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final CardView invoke() {
                CardView cardView = new CardView(QVipPreferentialServiceInfoItem.this.getContext());
                cardView.setAlpha(0.8f);
                cardView.setCardElevation(o.i(5));
                cardView.setRadius(o.i(6));
                cardView.setCardBackgroundColor(Color.parseColor("#33cfcfcf"));
                return cardView;
            }
        });
        ConstraintLayout.LayoutParams layoutParams4 = new ConstraintLayout.LayoutParams(o.i(97), o.i(129));
        layoutParams4.topToTop = 0;
        layoutParams4.leftToLeft = 0;
        layoutParams4.setMarginStart(o.i(3));
        ((ViewGroup.MarginLayoutParams) layoutParams4).topMargin = o.i(7);
        this.qvipRenewalPreferentialServiceBgImg = (ImageView) o.a(this, R.id.f67093ce, layoutParams4, new Function0<ImageView>() { // from class: com.tencent.mobileqq.vas.pay.page.QVipPreferentialServiceInfoItem$qvipRenewalPreferentialServiceBgImg$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final ImageView invoke() {
                final QVipPreferentialServiceInfoItem qVipPreferentialServiceInfoItem = QVipPreferentialServiceInfoItem.this;
                return o.m(qVipPreferentialServiceInfoItem, new Function1<ImageView, Unit>() { // from class: com.tencent.mobileqq.vas.pay.page.QVipPreferentialServiceInfoItem$qvipRenewalPreferentialServiceBgImg$2.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(ImageView imageView) {
                        invoke2(imageView);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull ImageView image) {
                        Intrinsics.checkNotNullParameter(image, "$this$image");
                        image.setElevation(o.i(5));
                        QVipPreferentialServiceInfoItem.this.bgImage = image;
                        image.setScaleType(ImageView.ScaleType.FIT_XY);
                    }
                });
            }
        });
        this.qvipRenewalRedFlag = (TextView) o.b(this, R.id.f67103cf, new Function0<TextView>() { // from class: com.tencent.mobileqq.vas.pay.page.QVipPreferentialServiceInfoItem$qvipRenewalRedFlag$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final TextView invoke() {
                return o.v(QVipPreferentialServiceInfoItem.this, new Function1<TextView, Unit>() { // from class: com.tencent.mobileqq.vas.pay.page.QVipPreferentialServiceInfoItem$qvipRenewalRedFlag$1.1
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(TextView textView) {
                        invoke2(textView);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull TextView text) {
                        float f16;
                        Intrinsics.checkNotNullParameter(text, "$this$text");
                        f16 = QVipPreferentialServiceInfoItem.K;
                        text.setElevation(f16);
                        ConstraintLayout.LayoutParams layoutParams5 = new ConstraintLayout.LayoutParams(-2, o.i(19));
                        layoutParams5.startToStart = 0;
                        layoutParams5.topToTop = 0;
                        ((ViewGroup.MarginLayoutParams) layoutParams5).topMargin = o.i(7);
                        text.setLayoutParams(layoutParams5);
                        o.p(text, o.i(3));
                        o.q(text, o.i(2));
                        text.setGravity(17);
                        text.setTextSize(o.u(10));
                        text.setMaxLines(1);
                        text.setMaxWidth(o.i(55));
                        text.setTextColor(o.g(-1, 0, 2, null));
                        text.setIncludeFontPadding(false);
                        text.setEllipsize(TextUtils.TruncateAt.END);
                        text.setBackground(new AbsAsyncDrawable() { // from class: com.tencent.mobileqq.vas.pay.page.QVipPreferentialServiceInfoItem$qvipRenewalRedFlag$1$1$d$1
                            /* JADX INFO: Access modifiers changed from: package-private */
                            {
                                setSupportNinePath(true);
                                setTargetDrawableBuild(new Function0<URLDrawable>() { // from class: com.tencent.mobileqq.vas.pay.page.QVipPreferentialServiceInfoItem$qvipRenewalRedFlag$1$1$d$1.1
                                    /* JADX WARN: Can't rename method to resolve collision */
                                    @Override // kotlin.jvm.functions.Function0
                                    public final URLDrawable invoke() {
                                        return URLDrawable.getDrawable(j.INSTANCE.k());
                                    }
                                });
                                AbsAsyncDrawable.load$default(this, false, 1, null);
                            }

                            @Override // com.tencent.mobileqq.vas.image.AbsAsyncDrawable
                            public void doLoadTask(@NotNull ILoaderSucessCallback callback) {
                                Intrinsics.checkNotNullParameter(callback, "callback");
                            }

                            @Override // com.tencent.mobileqq.vas.image.AbsAsyncDrawable
                            @Nullable
                            public Bitmap getNinePathBitmap(@Nullable Drawable d16) {
                                if (d16 instanceof URLDrawable) {
                                    Drawable currDrawable = ((URLDrawable) d16).getCurrDrawable();
                                    if (currDrawable instanceof ApngDrawable) {
                                        return ((ApngDrawable) currDrawable).getImage().getCurrentFrame();
                                    }
                                    if (currDrawable instanceof RegionDrawable) {
                                        return ((RegionDrawable) currDrawable).getBitmap();
                                    }
                                }
                                return super.getNinePathBitmap(d16);
                            }

                            @Override // com.tencent.mobileqq.vas.image.AbsAsyncDrawable
                            /* renamed from: isLoadSucess */
                            public boolean getIsLoadSuccess() {
                                return true;
                            }
                        });
                        text.setVisibility(8);
                    }
                });
            }
        });
        this.qvipRenewalPreferentialInfoTitle = (TextView) o.d(this, new Function0<TextView>() { // from class: com.tencent.mobileqq.vas.pay.page.QVipPreferentialServiceInfoItem$qvipRenewalPreferentialInfoTitle$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final TextView invoke() {
                return o.v(QVipPreferentialServiceInfoItem.this, new Function1<TextView, Unit>() { // from class: com.tencent.mobileqq.vas.pay.page.QVipPreferentialServiceInfoItem$qvipRenewalPreferentialInfoTitle$1.1
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(TextView textView) {
                        invoke2(textView);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull TextView text) {
                        float f16;
                        Intrinsics.checkNotNullParameter(text, "$this$text");
                        f16 = QVipPreferentialServiceInfoItem.K;
                        text.setElevation(f16);
                        ConstraintLayout.LayoutParams layoutParams5 = new ConstraintLayout.LayoutParams(-2, -2);
                        ((ViewGroup.MarginLayoutParams) layoutParams5).topMargin = o.i(16);
                        layoutParams5.topToTop = R.id.f67083cd;
                        layoutParams5.startToStart = R.id.f67083cd;
                        layoutParams5.endToEnd = R.id.f67083cd;
                        text.setLayoutParams(layoutParams5);
                        text.getPaint().setFakeBoldText(true);
                        text.setMaxLines(1);
                        text.setEllipsize(TextUtils.TruncateAt.END);
                        text.setMaxWidth(o.i(97));
                        text.setTextSize(o.u(16));
                    }
                });
            }
        });
        this.moneySymbol = (TextView) o.d(this, new Function0<TextView>() { // from class: com.tencent.mobileqq.vas.pay.page.QVipPreferentialServiceInfoItem$moneySymbol$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final TextView invoke() {
                return o.v(QVipPreferentialServiceInfoItem.this, new Function1<TextView, Unit>() { // from class: com.tencent.mobileqq.vas.pay.page.QVipPreferentialServiceInfoItem$moneySymbol$1.1
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(TextView textView) {
                        invoke2(textView);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull TextView text) {
                        float f16;
                        Intrinsics.checkNotNullParameter(text, "$this$text");
                        f16 = QVipPreferentialServiceInfoItem.K;
                        text.setElevation(f16);
                        text.setIncludeFontPadding(false);
                        ConstraintLayout.LayoutParams layoutParams5 = new ConstraintLayout.LayoutParams(o.i(7), o.i(9));
                        ((ViewGroup.MarginLayoutParams) layoutParams5).topMargin = o.i(56);
                        layoutParams5.topToTop = R.id.f67083cd;
                        layoutParams5.endToStart = R.id.f67063cb;
                        layoutParams5.setMarginEnd(o.i(2));
                        text.setLayoutParams(layoutParams5);
                        text.setMaxLines(1);
                        text.setEllipsize(TextUtils.TruncateAt.END);
                        text.setTextSize(o.u(12));
                        text.setBackground(o.k(text, R.drawable.npb));
                    }
                });
            }
        });
        this.qvipRenewalPreferentialInfoPrice = (TextView) o.b(this, R.id.f67063cb, new Function0<TextView>() { // from class: com.tencent.mobileqq.vas.pay.page.QVipPreferentialServiceInfoItem$qvipRenewalPreferentialInfoPrice$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final TextView invoke() {
                final QVipPreferentialServiceInfoItem qVipPreferentialServiceInfoItem = QVipPreferentialServiceInfoItem.this;
                return o.v(qVipPreferentialServiceInfoItem, new Function1<TextView, Unit>() { // from class: com.tencent.mobileqq.vas.pay.page.QVipPreferentialServiceInfoItem$qvipRenewalPreferentialInfoPrice$1.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(TextView textView) {
                        invoke2(textView);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull TextView text) {
                        float f16;
                        Typeface typeface;
                        Intrinsics.checkNotNullParameter(text, "$this$text");
                        f16 = QVipPreferentialServiceInfoItem.K;
                        text.setElevation(f16);
                        ConstraintLayout.LayoutParams layoutParams5 = new ConstraintLayout.LayoutParams(-2, -2);
                        ((ViewGroup.MarginLayoutParams) layoutParams5).topMargin = o.i(49);
                        layoutParams5.topToTop = R.id.f67083cd;
                        layoutParams5.startToStart = R.id.f67083cd;
                        layoutParams5.endToEnd = R.id.f67083cd;
                        text.setLayoutParams(layoutParams5);
                        typeface = QVipPreferentialServiceInfoItem.this.numTypeface;
                        text.setTypeface(typeface);
                        text.setIncludeFontPadding(false);
                        text.setMaxLines(1);
                        text.setTextSize(o.u(36));
                        text.setMaxWidth(o.i(80));
                        text.setTextColor(o.h("#8F5600", null, 2, null));
                    }
                });
            }
        });
        this.qvipRenewalOriginalPrice = (TextView) o.b(this, R.id.f66973c3, new Function0<TextView>() { // from class: com.tencent.mobileqq.vas.pay.page.QVipPreferentialServiceInfoItem$qvipRenewalOriginalPrice$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final TextView invoke() {
                return o.v(QVipPreferentialServiceInfoItem.this, new Function1<TextView, Unit>() { // from class: com.tencent.mobileqq.vas.pay.page.QVipPreferentialServiceInfoItem$qvipRenewalOriginalPrice$1.1
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(TextView textView) {
                        invoke2(textView);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull TextView text) {
                        float f16;
                        Intrinsics.checkNotNullParameter(text, "$this$text");
                        f16 = QVipPreferentialServiceInfoItem.K;
                        text.setElevation(f16);
                        ConstraintLayout.LayoutParams layoutParams5 = new ConstraintLayout.LayoutParams(-2, -2);
                        ((ViewGroup.MarginLayoutParams) layoutParams5).bottomMargin = o.i(16);
                        layoutParams5.startToStart = R.id.f67083cd;
                        layoutParams5.endToEnd = R.id.f67083cd;
                        layoutParams5.bottomToBottom = R.id.f67083cd;
                        text.setLayoutParams(layoutParams5);
                        text.setTextSize(o.u(12));
                        text.setMaxWidth(o.i(90));
                        text.setTextColor(o.h("#999999", null, 2, null));
                    }
                });
            }
        });
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<View>() { // from class: com.tencent.mobileqq.vas.pay.page.QVipPreferentialServiceInfoItem$smallTriangleMark$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final View invoke() {
                final QVipPreferentialServiceInfoItem qVipPreferentialServiceInfoItem = QVipPreferentialServiceInfoItem.this;
                return o.b(qVipPreferentialServiceInfoItem, R.id.f67123ch, new Function0<View>() { // from class: com.tencent.mobileqq.vas.pay.page.QVipPreferentialServiceInfoItem$smallTriangleMark$2.1
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    @NotNull
                    public final View invoke() {
                        return o.w(QVipPreferentialServiceInfoItem.this, new Function1<View, Unit>() { // from class: com.tencent.mobileqq.vas.pay.page.QVipPreferentialServiceInfoItem.smallTriangleMark.2.1.1
                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(View view) {
                                invoke2(view);
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(@NotNull View view) {
                                float f16;
                                Intrinsics.checkNotNullParameter(view, "$this$view");
                                f16 = QVipPreferentialServiceInfoItem.K;
                                view.setElevation(f16);
                                ConstraintLayout.LayoutParams layoutParams5 = new ConstraintLayout.LayoutParams(o.i(40), o.i(36));
                                layoutParams5.startToStart = R.id.f67083cd;
                                layoutParams5.endToEnd = R.id.f67083cd;
                                layoutParams5.bottomToBottom = 0;
                                ((ViewGroup.MarginLayoutParams) layoutParams5).topMargin = o.i(4);
                                view.setLayoutParams(layoutParams5);
                            }
                        });
                    }
                });
            }
        });
        this.smallTriangleMark = lazy;
    }

    private final View D0() {
        return (View) this.smallTriangleMark.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E0(QVipPreferentialServiceInfoItem this$0, Function2 invoke, View it) {
        EventCollector.getInstance().onViewClickedBefore(it);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(invoke, "$invoke");
        QLog.i("QVipPreferentialServiceInfoItem", 1, "click item pos: " + this$0.position);
        Intrinsics.checkNotNullExpressionValue(it, "it");
        invoke.invoke(it, Integer.valueOf(this$0.position));
        EventCollector.getInstance().onViewClicked(it);
    }

    public final void setInfoTitle(@NotNull String title, boolean isSelected) {
        Intrinsics.checkNotNullParameter(title, "title");
        this.qvipRenewalPreferentialInfoTitle.setText(title);
        if (isSelected) {
            this.qvipRenewalPreferentialInfoTitle.setTextColor(o.g(-16777216, 0, 2, null));
        } else {
            this.qvipRenewalPreferentialInfoTitle.setTextColor(o.e(-16777216, -1));
        }
    }

    public final void setItemBg(@NotNull String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        if (TextUtils.isEmpty(url)) {
            return;
        }
        ImageView imageView = this.qvipRenewalPreferentialServiceBgImg;
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        ColorDrawable colorDrawable = new ColorDrawable(0);
        obtain.mFailedDrawable = colorDrawable;
        obtain.mLoadingDrawable = colorDrawable;
        Unit unit = Unit.INSTANCE;
        imageView.setImageDrawable(URLDrawable.getDrawable(url, obtain));
    }

    public final void setOnItemClickListener(@NotNull final Function2<? super View, ? super Integer, Unit> invoke) {
        Intrinsics.checkNotNullParameter(invoke, "invoke");
        setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.vas.pay.page.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QVipPreferentialServiceInfoItem.E0(QVipPreferentialServiceInfoItem.this, invoke, view);
            }
        });
    }

    public final void setOriginalPrice(@NotNull String originalPrice) {
        Intrinsics.checkNotNullParameter(originalPrice, "originalPrice");
        this.qvipRenewalOriginalPrice.setText(originalPrice);
    }

    public final void setPosition(int position) {
        this.position = position;
        setLayoutParams(new ViewGroup.LayoutParams(o.i(109), o.i(146)));
    }

    public final void setPreferentialPrice(@NotNull String price, boolean isSelected) {
        int h16;
        Intrinsics.checkNotNullParameter(price, "price");
        this.qvipRenewalPreferentialInfoPrice.setText(price);
        if (o.n()) {
            if (isSelected) {
                h16 = o.h("#8F5600", null, 2, null);
            } else {
                h16 = o.h("#FFDEAE", null, 2, null);
            }
        } else {
            h16 = o.h("#8F5600", null, 2, null);
        }
        this.qvipRenewalPreferentialInfoPrice.setTextColor(h16);
        boolean n3 = o.n();
        int i3 = R.drawable.npb;
        if (n3 && !isSelected) {
            i3 = R.drawable.npc;
        }
        this.moneySymbol.setBackgroundResource(i3);
    }

    public final void setRedFlag(@NotNull String flagText) {
        int i3;
        Intrinsics.checkNotNullParameter(flagText, "flagText");
        if (TextUtils.isEmpty(flagText)) {
            this.qvipRenewalRedFlag.setVisibility(8);
            return;
        }
        this.qvipRenewalRedFlag.setVisibility(0);
        this.qvipRenewalRedFlag.setText(flagText);
        float measureText = this.qvipRenewalRedFlag.getPaint().measureText(flagText);
        if (measureText > 0.0f) {
            TextView textView = this.qvipRenewalRedFlag;
            ViewGroup.LayoutParams layoutParams = textView.getLayoutParams();
            layoutParams.width = (int) (measureText + o.i(10));
            textView.setLayoutParams(layoutParams);
            return;
        }
        TextView textView2 = this.qvipRenewalRedFlag;
        ViewGroup.LayoutParams layoutParams2 = textView2.getLayoutParams();
        if (flagText.length() <= 4) {
            i3 = o.i(52);
        } else {
            i3 = o.i(56);
        }
        layoutParams2.width = i3;
        textView2.setLayoutParams(layoutParams2);
    }

    public final void setSmallTriangleMarkVisible(boolean isShow) {
        if (isShow) {
            D0().setVisibility(0);
        } else {
            D0().setVisibility(8);
        }
        D0().setBackground(o.l(this, R.drawable.lag, R.drawable.lah));
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QVipPreferentialServiceInfoItem(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Lazy lazy;
        Intrinsics.checkNotNullParameter(context, "context");
        this.position = -1;
        setLayoutParams(new ViewGroup.LayoutParams(o.i(109), o.i(141)));
        setClipToPadding(false);
        setClipChildren(false);
        Typeface createFromAsset = Typeface.createFromAsset(getContext().getResources().getAssets(), VasNativePayManagerImpl.DINALTERNATE_BOLD_FONT_PATH);
        Intrinsics.checkNotNullExpressionValue(createFromAsset, "createFromAsset(context.\u2026ALTERNATE_BOLD_FONT_PATH)");
        this.numTypeface = createFromAsset;
        ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(-2, -2);
        layoutParams.topToTop = 0;
        layoutParams.leftToLeft = 0;
        layoutParams.setMarginStart(o.i(3));
        ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = o.i(7);
        Unit unit = Unit.INSTANCE;
        this.qvipRenewalPreferentialServiceBg = (CardView) o.a(this, R.id.f67083cd, layoutParams, new Function0<CardView>() { // from class: com.tencent.mobileqq.vas.pay.page.QVipPreferentialServiceInfoItem$qvipRenewalPreferentialServiceBg$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final CardView invoke() {
                CardView cardView = new CardView(QVipPreferentialServiceInfoItem.this.getContext());
                QVipPreferentialServiceInfoItem qVipPreferentialServiceInfoItem = QVipPreferentialServiceInfoItem.this;
                cardView.setClipChildren(false);
                cardView.setCardElevation(o.i(5));
                cardView.setRadius(o.i(18));
                cardView.setCardBackgroundColor(Color.parseColor("#33cfcfcf"));
                cardView.addView(o.w(qVipPreferentialServiceInfoItem, new Function1<View, Unit>() { // from class: com.tencent.mobileqq.vas.pay.page.QVipPreferentialServiceInfoItem$qvipRenewalPreferentialServiceBg$2$1$1
                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull View view) {
                        Intrinsics.checkNotNullParameter(view, "$this$view");
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(View view) {
                        invoke2(view);
                        return Unit.INSTANCE;
                    }
                }), new FrameLayout.LayoutParams(o.i(97), o.i(129)));
                return cardView;
            }
        });
        ConstraintLayout.LayoutParams layoutParams2 = new ConstraintLayout.LayoutParams(o.i(18), o.i(18));
        layoutParams2.topToTop = 0;
        layoutParams2.endToEnd = R.id.f67083cd;
        ((ViewGroup.MarginLayoutParams) layoutParams2).topMargin = o.i(7);
        this.topRightShadow = (CardView) o.c(this, layoutParams2, new Function0<CardView>() { // from class: com.tencent.mobileqq.vas.pay.page.QVipPreferentialServiceInfoItem$topRightShadow$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final CardView invoke() {
                CardView cardView = new CardView(QVipPreferentialServiceInfoItem.this.getContext());
                cardView.setAlpha(0.8f);
                cardView.setCardElevation(o.i(5));
                cardView.setRadius(o.i(6));
                cardView.setCardBackgroundColor(Color.parseColor("#33cfcfcf"));
                return cardView;
            }
        });
        ConstraintLayout.LayoutParams layoutParams3 = new ConstraintLayout.LayoutParams(o.i(18), o.i(18));
        layoutParams3.bottomToBottom = R.id.f67083cd;
        layoutParams3.startToStart = 0;
        layoutParams3.setMarginStart(o.i(3));
        this.bottomLeftShadow = (CardView) o.c(this, layoutParams3, new Function0<CardView>() { // from class: com.tencent.mobileqq.vas.pay.page.QVipPreferentialServiceInfoItem$bottomLeftShadow$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final CardView invoke() {
                CardView cardView = new CardView(QVipPreferentialServiceInfoItem.this.getContext());
                cardView.setAlpha(0.8f);
                cardView.setCardElevation(o.i(5));
                cardView.setRadius(o.i(6));
                cardView.setCardBackgroundColor(Color.parseColor("#33cfcfcf"));
                return cardView;
            }
        });
        ConstraintLayout.LayoutParams layoutParams4 = new ConstraintLayout.LayoutParams(o.i(97), o.i(129));
        layoutParams4.topToTop = 0;
        layoutParams4.leftToLeft = 0;
        layoutParams4.setMarginStart(o.i(3));
        ((ViewGroup.MarginLayoutParams) layoutParams4).topMargin = o.i(7);
        this.qvipRenewalPreferentialServiceBgImg = (ImageView) o.a(this, R.id.f67093ce, layoutParams4, new Function0<ImageView>() { // from class: com.tencent.mobileqq.vas.pay.page.QVipPreferentialServiceInfoItem$qvipRenewalPreferentialServiceBgImg$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final ImageView invoke() {
                final QVipPreferentialServiceInfoItem qVipPreferentialServiceInfoItem = QVipPreferentialServiceInfoItem.this;
                return o.m(qVipPreferentialServiceInfoItem, new Function1<ImageView, Unit>() { // from class: com.tencent.mobileqq.vas.pay.page.QVipPreferentialServiceInfoItem$qvipRenewalPreferentialServiceBgImg$2.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(ImageView imageView) {
                        invoke2(imageView);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull ImageView image) {
                        Intrinsics.checkNotNullParameter(image, "$this$image");
                        image.setElevation(o.i(5));
                        QVipPreferentialServiceInfoItem.this.bgImage = image;
                        image.setScaleType(ImageView.ScaleType.FIT_XY);
                    }
                });
            }
        });
        this.qvipRenewalRedFlag = (TextView) o.b(this, R.id.f67103cf, new Function0<TextView>() { // from class: com.tencent.mobileqq.vas.pay.page.QVipPreferentialServiceInfoItem$qvipRenewalRedFlag$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final TextView invoke() {
                return o.v(QVipPreferentialServiceInfoItem.this, new Function1<TextView, Unit>() { // from class: com.tencent.mobileqq.vas.pay.page.QVipPreferentialServiceInfoItem$qvipRenewalRedFlag$1.1
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(TextView textView) {
                        invoke2(textView);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull TextView text) {
                        float f16;
                        Intrinsics.checkNotNullParameter(text, "$this$text");
                        f16 = QVipPreferentialServiceInfoItem.K;
                        text.setElevation(f16);
                        ConstraintLayout.LayoutParams layoutParams5 = new ConstraintLayout.LayoutParams(-2, o.i(19));
                        layoutParams5.startToStart = 0;
                        layoutParams5.topToTop = 0;
                        ((ViewGroup.MarginLayoutParams) layoutParams5).topMargin = o.i(7);
                        text.setLayoutParams(layoutParams5);
                        o.p(text, o.i(3));
                        o.q(text, o.i(2));
                        text.setGravity(17);
                        text.setTextSize(o.u(10));
                        text.setMaxLines(1);
                        text.setMaxWidth(o.i(55));
                        text.setTextColor(o.g(-1, 0, 2, null));
                        text.setIncludeFontPadding(false);
                        text.setEllipsize(TextUtils.TruncateAt.END);
                        text.setBackground(new AbsAsyncDrawable() { // from class: com.tencent.mobileqq.vas.pay.page.QVipPreferentialServiceInfoItem$qvipRenewalRedFlag$1$1$d$1
                            /* JADX INFO: Access modifiers changed from: package-private */
                            {
                                setSupportNinePath(true);
                                setTargetDrawableBuild(new Function0<URLDrawable>() { // from class: com.tencent.mobileqq.vas.pay.page.QVipPreferentialServiceInfoItem$qvipRenewalRedFlag$1$1$d$1.1
                                    /* JADX WARN: Can't rename method to resolve collision */
                                    @Override // kotlin.jvm.functions.Function0
                                    public final URLDrawable invoke() {
                                        return URLDrawable.getDrawable(j.INSTANCE.k());
                                    }
                                });
                                AbsAsyncDrawable.load$default(this, false, 1, null);
                            }

                            @Override // com.tencent.mobileqq.vas.image.AbsAsyncDrawable
                            public void doLoadTask(@NotNull ILoaderSucessCallback callback) {
                                Intrinsics.checkNotNullParameter(callback, "callback");
                            }

                            @Override // com.tencent.mobileqq.vas.image.AbsAsyncDrawable
                            @Nullable
                            public Bitmap getNinePathBitmap(@Nullable Drawable d16) {
                                if (d16 instanceof URLDrawable) {
                                    Drawable currDrawable = ((URLDrawable) d16).getCurrDrawable();
                                    if (currDrawable instanceof ApngDrawable) {
                                        return ((ApngDrawable) currDrawable).getImage().getCurrentFrame();
                                    }
                                    if (currDrawable instanceof RegionDrawable) {
                                        return ((RegionDrawable) currDrawable).getBitmap();
                                    }
                                }
                                return super.getNinePathBitmap(d16);
                            }

                            @Override // com.tencent.mobileqq.vas.image.AbsAsyncDrawable
                            /* renamed from: isLoadSucess */
                            public boolean getIsLoadSuccess() {
                                return true;
                            }
                        });
                        text.setVisibility(8);
                    }
                });
            }
        });
        this.qvipRenewalPreferentialInfoTitle = (TextView) o.d(this, new Function0<TextView>() { // from class: com.tencent.mobileqq.vas.pay.page.QVipPreferentialServiceInfoItem$qvipRenewalPreferentialInfoTitle$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final TextView invoke() {
                return o.v(QVipPreferentialServiceInfoItem.this, new Function1<TextView, Unit>() { // from class: com.tencent.mobileqq.vas.pay.page.QVipPreferentialServiceInfoItem$qvipRenewalPreferentialInfoTitle$1.1
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(TextView textView) {
                        invoke2(textView);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull TextView text) {
                        float f16;
                        Intrinsics.checkNotNullParameter(text, "$this$text");
                        f16 = QVipPreferentialServiceInfoItem.K;
                        text.setElevation(f16);
                        ConstraintLayout.LayoutParams layoutParams5 = new ConstraintLayout.LayoutParams(-2, -2);
                        ((ViewGroup.MarginLayoutParams) layoutParams5).topMargin = o.i(16);
                        layoutParams5.topToTop = R.id.f67083cd;
                        layoutParams5.startToStart = R.id.f67083cd;
                        layoutParams5.endToEnd = R.id.f67083cd;
                        text.setLayoutParams(layoutParams5);
                        text.getPaint().setFakeBoldText(true);
                        text.setMaxLines(1);
                        text.setEllipsize(TextUtils.TruncateAt.END);
                        text.setMaxWidth(o.i(97));
                        text.setTextSize(o.u(16));
                    }
                });
            }
        });
        this.moneySymbol = (TextView) o.d(this, new Function0<TextView>() { // from class: com.tencent.mobileqq.vas.pay.page.QVipPreferentialServiceInfoItem$moneySymbol$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final TextView invoke() {
                return o.v(QVipPreferentialServiceInfoItem.this, new Function1<TextView, Unit>() { // from class: com.tencent.mobileqq.vas.pay.page.QVipPreferentialServiceInfoItem$moneySymbol$1.1
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(TextView textView) {
                        invoke2(textView);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull TextView text) {
                        float f16;
                        Intrinsics.checkNotNullParameter(text, "$this$text");
                        f16 = QVipPreferentialServiceInfoItem.K;
                        text.setElevation(f16);
                        text.setIncludeFontPadding(false);
                        ConstraintLayout.LayoutParams layoutParams5 = new ConstraintLayout.LayoutParams(o.i(7), o.i(9));
                        ((ViewGroup.MarginLayoutParams) layoutParams5).topMargin = o.i(56);
                        layoutParams5.topToTop = R.id.f67083cd;
                        layoutParams5.endToStart = R.id.f67063cb;
                        layoutParams5.setMarginEnd(o.i(2));
                        text.setLayoutParams(layoutParams5);
                        text.setMaxLines(1);
                        text.setEllipsize(TextUtils.TruncateAt.END);
                        text.setTextSize(o.u(12));
                        text.setBackground(o.k(text, R.drawable.npb));
                    }
                });
            }
        });
        this.qvipRenewalPreferentialInfoPrice = (TextView) o.b(this, R.id.f67063cb, new Function0<TextView>() { // from class: com.tencent.mobileqq.vas.pay.page.QVipPreferentialServiceInfoItem$qvipRenewalPreferentialInfoPrice$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final TextView invoke() {
                final QVipPreferentialServiceInfoItem qVipPreferentialServiceInfoItem = QVipPreferentialServiceInfoItem.this;
                return o.v(qVipPreferentialServiceInfoItem, new Function1<TextView, Unit>() { // from class: com.tencent.mobileqq.vas.pay.page.QVipPreferentialServiceInfoItem$qvipRenewalPreferentialInfoPrice$1.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(TextView textView) {
                        invoke2(textView);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull TextView text) {
                        float f16;
                        Typeface typeface;
                        Intrinsics.checkNotNullParameter(text, "$this$text");
                        f16 = QVipPreferentialServiceInfoItem.K;
                        text.setElevation(f16);
                        ConstraintLayout.LayoutParams layoutParams5 = new ConstraintLayout.LayoutParams(-2, -2);
                        ((ViewGroup.MarginLayoutParams) layoutParams5).topMargin = o.i(49);
                        layoutParams5.topToTop = R.id.f67083cd;
                        layoutParams5.startToStart = R.id.f67083cd;
                        layoutParams5.endToEnd = R.id.f67083cd;
                        text.setLayoutParams(layoutParams5);
                        typeface = QVipPreferentialServiceInfoItem.this.numTypeface;
                        text.setTypeface(typeface);
                        text.setIncludeFontPadding(false);
                        text.setMaxLines(1);
                        text.setTextSize(o.u(36));
                        text.setMaxWidth(o.i(80));
                        text.setTextColor(o.h("#8F5600", null, 2, null));
                    }
                });
            }
        });
        this.qvipRenewalOriginalPrice = (TextView) o.b(this, R.id.f66973c3, new Function0<TextView>() { // from class: com.tencent.mobileqq.vas.pay.page.QVipPreferentialServiceInfoItem$qvipRenewalOriginalPrice$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final TextView invoke() {
                return o.v(QVipPreferentialServiceInfoItem.this, new Function1<TextView, Unit>() { // from class: com.tencent.mobileqq.vas.pay.page.QVipPreferentialServiceInfoItem$qvipRenewalOriginalPrice$1.1
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(TextView textView) {
                        invoke2(textView);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull TextView text) {
                        float f16;
                        Intrinsics.checkNotNullParameter(text, "$this$text");
                        f16 = QVipPreferentialServiceInfoItem.K;
                        text.setElevation(f16);
                        ConstraintLayout.LayoutParams layoutParams5 = new ConstraintLayout.LayoutParams(-2, -2);
                        ((ViewGroup.MarginLayoutParams) layoutParams5).bottomMargin = o.i(16);
                        layoutParams5.startToStart = R.id.f67083cd;
                        layoutParams5.endToEnd = R.id.f67083cd;
                        layoutParams5.bottomToBottom = R.id.f67083cd;
                        text.setLayoutParams(layoutParams5);
                        text.setTextSize(o.u(12));
                        text.setMaxWidth(o.i(90));
                        text.setTextColor(o.h("#999999", null, 2, null));
                    }
                });
            }
        });
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<View>() { // from class: com.tencent.mobileqq.vas.pay.page.QVipPreferentialServiceInfoItem$smallTriangleMark$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final View invoke() {
                final QVipPreferentialServiceInfoItem qVipPreferentialServiceInfoItem = QVipPreferentialServiceInfoItem.this;
                return o.b(qVipPreferentialServiceInfoItem, R.id.f67123ch, new Function0<View>() { // from class: com.tencent.mobileqq.vas.pay.page.QVipPreferentialServiceInfoItem$smallTriangleMark$2.1
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    @NotNull
                    public final View invoke() {
                        return o.w(QVipPreferentialServiceInfoItem.this, new Function1<View, Unit>() { // from class: com.tencent.mobileqq.vas.pay.page.QVipPreferentialServiceInfoItem.smallTriangleMark.2.1.1
                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(View view) {
                                invoke2(view);
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(@NotNull View view) {
                                float f16;
                                Intrinsics.checkNotNullParameter(view, "$this$view");
                                f16 = QVipPreferentialServiceInfoItem.K;
                                view.setElevation(f16);
                                ConstraintLayout.LayoutParams layoutParams5 = new ConstraintLayout.LayoutParams(o.i(40), o.i(36));
                                layoutParams5.startToStart = R.id.f67083cd;
                                layoutParams5.endToEnd = R.id.f67083cd;
                                layoutParams5.bottomToBottom = 0;
                                ((ViewGroup.MarginLayoutParams) layoutParams5).topMargin = o.i(4);
                                view.setLayoutParams(layoutParams5);
                            }
                        });
                    }
                });
            }
        });
        this.smallTriangleMark = lazy;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QVipPreferentialServiceInfoItem(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Lazy lazy;
        Intrinsics.checkNotNullParameter(context, "context");
        this.position = -1;
        setLayoutParams(new ViewGroup.LayoutParams(o.i(109), o.i(141)));
        setClipToPadding(false);
        setClipChildren(false);
        Typeface createFromAsset = Typeface.createFromAsset(getContext().getResources().getAssets(), VasNativePayManagerImpl.DINALTERNATE_BOLD_FONT_PATH);
        Intrinsics.checkNotNullExpressionValue(createFromAsset, "createFromAsset(context.\u2026ALTERNATE_BOLD_FONT_PATH)");
        this.numTypeface = createFromAsset;
        ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(-2, -2);
        layoutParams.topToTop = 0;
        layoutParams.leftToLeft = 0;
        layoutParams.setMarginStart(o.i(3));
        ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = o.i(7);
        Unit unit = Unit.INSTANCE;
        this.qvipRenewalPreferentialServiceBg = (CardView) o.a(this, R.id.f67083cd, layoutParams, new Function0<CardView>() { // from class: com.tencent.mobileqq.vas.pay.page.QVipPreferentialServiceInfoItem$qvipRenewalPreferentialServiceBg$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final CardView invoke() {
                CardView cardView = new CardView(QVipPreferentialServiceInfoItem.this.getContext());
                QVipPreferentialServiceInfoItem qVipPreferentialServiceInfoItem = QVipPreferentialServiceInfoItem.this;
                cardView.setClipChildren(false);
                cardView.setCardElevation(o.i(5));
                cardView.setRadius(o.i(18));
                cardView.setCardBackgroundColor(Color.parseColor("#33cfcfcf"));
                cardView.addView(o.w(qVipPreferentialServiceInfoItem, new Function1<View, Unit>() { // from class: com.tencent.mobileqq.vas.pay.page.QVipPreferentialServiceInfoItem$qvipRenewalPreferentialServiceBg$2$1$1
                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull View view) {
                        Intrinsics.checkNotNullParameter(view, "$this$view");
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(View view) {
                        invoke2(view);
                        return Unit.INSTANCE;
                    }
                }), new FrameLayout.LayoutParams(o.i(97), o.i(129)));
                return cardView;
            }
        });
        ConstraintLayout.LayoutParams layoutParams2 = new ConstraintLayout.LayoutParams(o.i(18), o.i(18));
        layoutParams2.topToTop = 0;
        layoutParams2.endToEnd = R.id.f67083cd;
        ((ViewGroup.MarginLayoutParams) layoutParams2).topMargin = o.i(7);
        this.topRightShadow = (CardView) o.c(this, layoutParams2, new Function0<CardView>() { // from class: com.tencent.mobileqq.vas.pay.page.QVipPreferentialServiceInfoItem$topRightShadow$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final CardView invoke() {
                CardView cardView = new CardView(QVipPreferentialServiceInfoItem.this.getContext());
                cardView.setAlpha(0.8f);
                cardView.setCardElevation(o.i(5));
                cardView.setRadius(o.i(6));
                cardView.setCardBackgroundColor(Color.parseColor("#33cfcfcf"));
                return cardView;
            }
        });
        ConstraintLayout.LayoutParams layoutParams3 = new ConstraintLayout.LayoutParams(o.i(18), o.i(18));
        layoutParams3.bottomToBottom = R.id.f67083cd;
        layoutParams3.startToStart = 0;
        layoutParams3.setMarginStart(o.i(3));
        this.bottomLeftShadow = (CardView) o.c(this, layoutParams3, new Function0<CardView>() { // from class: com.tencent.mobileqq.vas.pay.page.QVipPreferentialServiceInfoItem$bottomLeftShadow$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final CardView invoke() {
                CardView cardView = new CardView(QVipPreferentialServiceInfoItem.this.getContext());
                cardView.setAlpha(0.8f);
                cardView.setCardElevation(o.i(5));
                cardView.setRadius(o.i(6));
                cardView.setCardBackgroundColor(Color.parseColor("#33cfcfcf"));
                return cardView;
            }
        });
        ConstraintLayout.LayoutParams layoutParams4 = new ConstraintLayout.LayoutParams(o.i(97), o.i(129));
        layoutParams4.topToTop = 0;
        layoutParams4.leftToLeft = 0;
        layoutParams4.setMarginStart(o.i(3));
        ((ViewGroup.MarginLayoutParams) layoutParams4).topMargin = o.i(7);
        this.qvipRenewalPreferentialServiceBgImg = (ImageView) o.a(this, R.id.f67093ce, layoutParams4, new Function0<ImageView>() { // from class: com.tencent.mobileqq.vas.pay.page.QVipPreferentialServiceInfoItem$qvipRenewalPreferentialServiceBgImg$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final ImageView invoke() {
                final QVipPreferentialServiceInfoItem qVipPreferentialServiceInfoItem = QVipPreferentialServiceInfoItem.this;
                return o.m(qVipPreferentialServiceInfoItem, new Function1<ImageView, Unit>() { // from class: com.tencent.mobileqq.vas.pay.page.QVipPreferentialServiceInfoItem$qvipRenewalPreferentialServiceBgImg$2.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(ImageView imageView) {
                        invoke2(imageView);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull ImageView image) {
                        Intrinsics.checkNotNullParameter(image, "$this$image");
                        image.setElevation(o.i(5));
                        QVipPreferentialServiceInfoItem.this.bgImage = image;
                        image.setScaleType(ImageView.ScaleType.FIT_XY);
                    }
                });
            }
        });
        this.qvipRenewalRedFlag = (TextView) o.b(this, R.id.f67103cf, new Function0<TextView>() { // from class: com.tencent.mobileqq.vas.pay.page.QVipPreferentialServiceInfoItem$qvipRenewalRedFlag$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final TextView invoke() {
                return o.v(QVipPreferentialServiceInfoItem.this, new Function1<TextView, Unit>() { // from class: com.tencent.mobileqq.vas.pay.page.QVipPreferentialServiceInfoItem$qvipRenewalRedFlag$1.1
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(TextView textView) {
                        invoke2(textView);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull TextView text) {
                        float f16;
                        Intrinsics.checkNotNullParameter(text, "$this$text");
                        f16 = QVipPreferentialServiceInfoItem.K;
                        text.setElevation(f16);
                        ConstraintLayout.LayoutParams layoutParams5 = new ConstraintLayout.LayoutParams(-2, o.i(19));
                        layoutParams5.startToStart = 0;
                        layoutParams5.topToTop = 0;
                        ((ViewGroup.MarginLayoutParams) layoutParams5).topMargin = o.i(7);
                        text.setLayoutParams(layoutParams5);
                        o.p(text, o.i(3));
                        o.q(text, o.i(2));
                        text.setGravity(17);
                        text.setTextSize(o.u(10));
                        text.setMaxLines(1);
                        text.setMaxWidth(o.i(55));
                        text.setTextColor(o.g(-1, 0, 2, null));
                        text.setIncludeFontPadding(false);
                        text.setEllipsize(TextUtils.TruncateAt.END);
                        text.setBackground(new AbsAsyncDrawable() { // from class: com.tencent.mobileqq.vas.pay.page.QVipPreferentialServiceInfoItem$qvipRenewalRedFlag$1$1$d$1
                            /* JADX INFO: Access modifiers changed from: package-private */
                            {
                                setSupportNinePath(true);
                                setTargetDrawableBuild(new Function0<URLDrawable>() { // from class: com.tencent.mobileqq.vas.pay.page.QVipPreferentialServiceInfoItem$qvipRenewalRedFlag$1$1$d$1.1
                                    /* JADX WARN: Can't rename method to resolve collision */
                                    @Override // kotlin.jvm.functions.Function0
                                    public final URLDrawable invoke() {
                                        return URLDrawable.getDrawable(j.INSTANCE.k());
                                    }
                                });
                                AbsAsyncDrawable.load$default(this, false, 1, null);
                            }

                            @Override // com.tencent.mobileqq.vas.image.AbsAsyncDrawable
                            public void doLoadTask(@NotNull ILoaderSucessCallback callback) {
                                Intrinsics.checkNotNullParameter(callback, "callback");
                            }

                            @Override // com.tencent.mobileqq.vas.image.AbsAsyncDrawable
                            @Nullable
                            public Bitmap getNinePathBitmap(@Nullable Drawable d16) {
                                if (d16 instanceof URLDrawable) {
                                    Drawable currDrawable = ((URLDrawable) d16).getCurrDrawable();
                                    if (currDrawable instanceof ApngDrawable) {
                                        return ((ApngDrawable) currDrawable).getImage().getCurrentFrame();
                                    }
                                    if (currDrawable instanceof RegionDrawable) {
                                        return ((RegionDrawable) currDrawable).getBitmap();
                                    }
                                }
                                return super.getNinePathBitmap(d16);
                            }

                            @Override // com.tencent.mobileqq.vas.image.AbsAsyncDrawable
                            /* renamed from: isLoadSucess */
                            public boolean getIsLoadSuccess() {
                                return true;
                            }
                        });
                        text.setVisibility(8);
                    }
                });
            }
        });
        this.qvipRenewalPreferentialInfoTitle = (TextView) o.d(this, new Function0<TextView>() { // from class: com.tencent.mobileqq.vas.pay.page.QVipPreferentialServiceInfoItem$qvipRenewalPreferentialInfoTitle$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final TextView invoke() {
                return o.v(QVipPreferentialServiceInfoItem.this, new Function1<TextView, Unit>() { // from class: com.tencent.mobileqq.vas.pay.page.QVipPreferentialServiceInfoItem$qvipRenewalPreferentialInfoTitle$1.1
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(TextView textView) {
                        invoke2(textView);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull TextView text) {
                        float f16;
                        Intrinsics.checkNotNullParameter(text, "$this$text");
                        f16 = QVipPreferentialServiceInfoItem.K;
                        text.setElevation(f16);
                        ConstraintLayout.LayoutParams layoutParams5 = new ConstraintLayout.LayoutParams(-2, -2);
                        ((ViewGroup.MarginLayoutParams) layoutParams5).topMargin = o.i(16);
                        layoutParams5.topToTop = R.id.f67083cd;
                        layoutParams5.startToStart = R.id.f67083cd;
                        layoutParams5.endToEnd = R.id.f67083cd;
                        text.setLayoutParams(layoutParams5);
                        text.getPaint().setFakeBoldText(true);
                        text.setMaxLines(1);
                        text.setEllipsize(TextUtils.TruncateAt.END);
                        text.setMaxWidth(o.i(97));
                        text.setTextSize(o.u(16));
                    }
                });
            }
        });
        this.moneySymbol = (TextView) o.d(this, new Function0<TextView>() { // from class: com.tencent.mobileqq.vas.pay.page.QVipPreferentialServiceInfoItem$moneySymbol$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final TextView invoke() {
                return o.v(QVipPreferentialServiceInfoItem.this, new Function1<TextView, Unit>() { // from class: com.tencent.mobileqq.vas.pay.page.QVipPreferentialServiceInfoItem$moneySymbol$1.1
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(TextView textView) {
                        invoke2(textView);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull TextView text) {
                        float f16;
                        Intrinsics.checkNotNullParameter(text, "$this$text");
                        f16 = QVipPreferentialServiceInfoItem.K;
                        text.setElevation(f16);
                        text.setIncludeFontPadding(false);
                        ConstraintLayout.LayoutParams layoutParams5 = new ConstraintLayout.LayoutParams(o.i(7), o.i(9));
                        ((ViewGroup.MarginLayoutParams) layoutParams5).topMargin = o.i(56);
                        layoutParams5.topToTop = R.id.f67083cd;
                        layoutParams5.endToStart = R.id.f67063cb;
                        layoutParams5.setMarginEnd(o.i(2));
                        text.setLayoutParams(layoutParams5);
                        text.setMaxLines(1);
                        text.setEllipsize(TextUtils.TruncateAt.END);
                        text.setTextSize(o.u(12));
                        text.setBackground(o.k(text, R.drawable.npb));
                    }
                });
            }
        });
        this.qvipRenewalPreferentialInfoPrice = (TextView) o.b(this, R.id.f67063cb, new Function0<TextView>() { // from class: com.tencent.mobileqq.vas.pay.page.QVipPreferentialServiceInfoItem$qvipRenewalPreferentialInfoPrice$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final TextView invoke() {
                final QVipPreferentialServiceInfoItem qVipPreferentialServiceInfoItem = QVipPreferentialServiceInfoItem.this;
                return o.v(qVipPreferentialServiceInfoItem, new Function1<TextView, Unit>() { // from class: com.tencent.mobileqq.vas.pay.page.QVipPreferentialServiceInfoItem$qvipRenewalPreferentialInfoPrice$1.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(TextView textView) {
                        invoke2(textView);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull TextView text) {
                        float f16;
                        Typeface typeface;
                        Intrinsics.checkNotNullParameter(text, "$this$text");
                        f16 = QVipPreferentialServiceInfoItem.K;
                        text.setElevation(f16);
                        ConstraintLayout.LayoutParams layoutParams5 = new ConstraintLayout.LayoutParams(-2, -2);
                        ((ViewGroup.MarginLayoutParams) layoutParams5).topMargin = o.i(49);
                        layoutParams5.topToTop = R.id.f67083cd;
                        layoutParams5.startToStart = R.id.f67083cd;
                        layoutParams5.endToEnd = R.id.f67083cd;
                        text.setLayoutParams(layoutParams5);
                        typeface = QVipPreferentialServiceInfoItem.this.numTypeface;
                        text.setTypeface(typeface);
                        text.setIncludeFontPadding(false);
                        text.setMaxLines(1);
                        text.setTextSize(o.u(36));
                        text.setMaxWidth(o.i(80));
                        text.setTextColor(o.h("#8F5600", null, 2, null));
                    }
                });
            }
        });
        this.qvipRenewalOriginalPrice = (TextView) o.b(this, R.id.f66973c3, new Function0<TextView>() { // from class: com.tencent.mobileqq.vas.pay.page.QVipPreferentialServiceInfoItem$qvipRenewalOriginalPrice$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final TextView invoke() {
                return o.v(QVipPreferentialServiceInfoItem.this, new Function1<TextView, Unit>() { // from class: com.tencent.mobileqq.vas.pay.page.QVipPreferentialServiceInfoItem$qvipRenewalOriginalPrice$1.1
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(TextView textView) {
                        invoke2(textView);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull TextView text) {
                        float f16;
                        Intrinsics.checkNotNullParameter(text, "$this$text");
                        f16 = QVipPreferentialServiceInfoItem.K;
                        text.setElevation(f16);
                        ConstraintLayout.LayoutParams layoutParams5 = new ConstraintLayout.LayoutParams(-2, -2);
                        ((ViewGroup.MarginLayoutParams) layoutParams5).bottomMargin = o.i(16);
                        layoutParams5.startToStart = R.id.f67083cd;
                        layoutParams5.endToEnd = R.id.f67083cd;
                        layoutParams5.bottomToBottom = R.id.f67083cd;
                        text.setLayoutParams(layoutParams5);
                        text.setTextSize(o.u(12));
                        text.setMaxWidth(o.i(90));
                        text.setTextColor(o.h("#999999", null, 2, null));
                    }
                });
            }
        });
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<View>() { // from class: com.tencent.mobileqq.vas.pay.page.QVipPreferentialServiceInfoItem$smallTriangleMark$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final View invoke() {
                final QVipPreferentialServiceInfoItem qVipPreferentialServiceInfoItem = QVipPreferentialServiceInfoItem.this;
                return o.b(qVipPreferentialServiceInfoItem, R.id.f67123ch, new Function0<View>() { // from class: com.tencent.mobileqq.vas.pay.page.QVipPreferentialServiceInfoItem$smallTriangleMark$2.1
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    @NotNull
                    public final View invoke() {
                        return o.w(QVipPreferentialServiceInfoItem.this, new Function1<View, Unit>() { // from class: com.tencent.mobileqq.vas.pay.page.QVipPreferentialServiceInfoItem.smallTriangleMark.2.1.1
                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(View view) {
                                invoke2(view);
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(@NotNull View view) {
                                float f16;
                                Intrinsics.checkNotNullParameter(view, "$this$view");
                                f16 = QVipPreferentialServiceInfoItem.K;
                                view.setElevation(f16);
                                ConstraintLayout.LayoutParams layoutParams5 = new ConstraintLayout.LayoutParams(o.i(40), o.i(36));
                                layoutParams5.startToStart = R.id.f67083cd;
                                layoutParams5.endToEnd = R.id.f67083cd;
                                layoutParams5.bottomToBottom = 0;
                                ((ViewGroup.MarginLayoutParams) layoutParams5).topMargin = o.i(4);
                                view.setLayoutParams(layoutParams5);
                            }
                        });
                    }
                });
            }
        });
        this.smallTriangleMark = lazy;
    }
}
