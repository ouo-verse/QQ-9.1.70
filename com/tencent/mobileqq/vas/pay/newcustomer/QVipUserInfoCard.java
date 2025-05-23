package com.tencent.mobileqq.vas.pay.newcustomer;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.proxy.personalitycomponent.model.WidgetCacheWeatherData;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.common.app.AppInterface;
import com.tencent.image.ApngDrawable;
import com.tencent.image.RegionDrawable;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.vas.image.AbsAsyncDrawable;
import com.tencent.mobileqq.vas.image.ILoaderSucessCallback;
import com.tencent.mobileqq.vip.api.IVipIconUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.widget.RoundRectImageView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.Constants;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 R2\u00020\u0001:\u0001SB\u0011\b\u0016\u0012\u0006\u0010J\u001a\u00020I\u00a2\u0006\u0004\bK\u0010LB\u001b\b\u0016\u0012\u0006\u0010J\u001a\u00020I\u0012\b\u0010N\u001a\u0004\u0018\u00010M\u00a2\u0006\u0004\bK\u0010OB#\b\u0016\u0012\u0006\u0010J\u001a\u00020I\u0012\b\u0010N\u001a\u0004\u0018\u00010M\u0012\u0006\u0010P\u001a\u00020\u0004\u00a2\u0006\u0004\bK\u0010QJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\t\u001a\u00020\u0002H\u0002J\u0010\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0007H\u0002J\u0010\u0010\r\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u0004H\u0002J\u0006\u0010\u000e\u001a\u00020\u0002J\u0006\u0010\u000f\u001a\u00020\u0002J\u0016\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0007J\u000e\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0013J\u000e\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u0016J\u000e\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u0016J\u000e\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u0007J\u000e\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u0007J\u0006\u0010\u001c\u001a\u00020\u0002J&\u0010!\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u0004J\u000e\u0010$\u001a\u00020\u00022\u0006\u0010#\u001a\u00020\"J\u000e\u0010%\u001a\u00020\u00022\u0006\u0010#\u001a\u00020\"R\u0014\u0010)\u001a\u00020&8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0014\u0010+\u001a\u00020&8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b*\u0010(R\u0014\u0010-\u001a\u00020&8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b,\u0010(R\u0014\u0010/\u001a\u00020&8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b.\u0010(R\u0014\u00102\u001a\u0002008\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u00101R\u0014\u00106\u001a\u0002038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b4\u00105R\u0014\u0010:\u001a\u0002078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b8\u00109R\u0014\u0010<\u001a\u0002038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b;\u00105R\u0014\u0010>\u001a\u00020&8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b=\u0010(R\u0014\u0010@\u001a\u0002038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b?\u00105R\u0014\u0010B\u001a\u0002038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bA\u00105R\u0014\u0010D\u001a\u0002038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bC\u00105R\u0014\u0010F\u001a\u0002038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bE\u00105R\u0014\u0010H\u001a\u0002038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bG\u00105\u00a8\u0006T"}, d2 = {"Lcom/tencent/mobileqq/vas/pay/newcustomer/QVipUserInfoCard;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "", "E0", "", "refreshTimes", "G0", "", "B0", "F0", "flagText", "setRedFlag", "i", "A0", "initView", "setNamePlate", "payText", "markText", "setPayBtn", "", "isInCountDownGetExperience", "setCountDownGetExperience", "Landroid/text/SpannableString;", "text", "setUserStatusTitle", "setUserStatusSubtitle", "setCountDownText", "setGetExperienceBtnText", "D0", "day", WidgetCacheWeatherData.HOUR, "minute", "sec", "setExperienceExpiredCountDown", "Landroid/view/View$OnClickListener;", "click", "setPayBtnClickListener", "setGetSVipExperienceClickListener", "Landroid/view/View;", "d", "Landroid/view/View;", "qSVipNewCustomerBg1", "e", "qSVipNewCustomerBg3", "f", "qSVipNewCustomerSVipFlag", tl.h.F, "qSVipNewCustomerBg2", "Lcom/tencent/widget/RoundRectImageView;", "Lcom/tencent/widget/RoundRectImageView;", "qSvipNewCustomerHeadIv", "Landroid/widget/TextView;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/widget/TextView;", "qSvipNewCustomerUserName", "Landroid/widget/ImageView;", BdhLogUtil.LogTag.Tag_Conn, "Landroid/widget/ImageView;", "qSvipNewCustomerVipNamePlate", "D", "qSvipNewCustomerPayBtn", "E", "qSvipViewHolder", UserInfo.SEX_FEMALE, "qSvipNewCustomerRedFlag", "G", "qSvipNewCustomerPayTitle", "H", "qSvipNewCustomerPaySubtitle", "I", "qSvipNewCustomerPayGetExperienceBtn", "J", "qSvipNewCustomerPayCountdown", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "K", "a", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class QVipUserInfoCard extends ConstraintLayout {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final ImageView qSvipNewCustomerVipNamePlate;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final TextView qSvipNewCustomerPayBtn;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final View qSvipViewHolder;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final TextView qSvipNewCustomerRedFlag;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final TextView qSvipNewCustomerPayTitle;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final TextView qSvipNewCustomerPaySubtitle;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final TextView qSvipNewCustomerPayGetExperienceBtn;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private final TextView qSvipNewCustomerPayCountdown;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final View qSVipNewCustomerBg1;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final View qSVipNewCustomerBg3;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final View qSVipNewCustomerSVipFlag;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final View qSVipNewCustomerBg2;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final RoundRectImageView qSvipNewCustomerHeadIv;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final TextView qSvipNewCustomerUserName;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QVipUserInfoCard(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        setPadding(com.tencent.mobileqq.vas.pay.page.o.i(16), 0, com.tencent.mobileqq.vas.pay.page.o.i(16), 0);
        this.qSVipNewCustomerBg1 = com.tencent.mobileqq.vas.pay.page.o.a(this, R.id.f6549393, new ConstraintLayout.LayoutParams(-1, com.tencent.mobileqq.vas.pay.page.o.i(159)), new Function0<View>() { // from class: com.tencent.mobileqq.vas.pay.newcustomer.QVipUserInfoCard$qSVipNewCustomerBg1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final View invoke() {
                return com.tencent.mobileqq.vas.pay.page.o.w(QVipUserInfoCard.this, new Function1<View, Unit>() { // from class: com.tencent.mobileqq.vas.pay.newcustomer.QVipUserInfoCard$qSVipNewCustomerBg1$1.1
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(View view) {
                        invoke2(view);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull View view) {
                        Intrinsics.checkNotNullParameter(view, "$this$view");
                        BaseApplication context2 = BaseApplication.context;
                        Intrinsics.checkNotNullExpressionValue(context2, "context");
                        Drawable j3 = com.tencent.mobileqq.vas.pay.page.o.j(context2, R.drawable.l7y);
                        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
                        obtain.mLoadingDrawable = j3;
                        obtain.mFailedDrawable = j3;
                        view.setBackground(URLDrawable.getDrawable("https://tianquan.gtimg.cn/shoal/vaclient/6ae11b4e-6c93-47f5-849f-074e6b016e45.png", obtain));
                    }
                });
            }
        });
        ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(-1, com.tencent.mobileqq.vas.pay.page.o.i(140));
        layoutParams.topToTop = 0;
        layoutParams.startToStart = 0;
        layoutParams.endToEnd = 0;
        ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = com.tencent.mobileqq.vas.pay.page.o.i(13);
        layoutParams.setMarginStart(com.tencent.mobileqq.vas.pay.page.o.i(13));
        layoutParams.setMarginEnd(com.tencent.mobileqq.vas.pay.page.o.i(13));
        Unit unit = Unit.INSTANCE;
        this.qSVipNewCustomerBg3 = com.tencent.mobileqq.vas.pay.page.o.a(this, R.id.f6551395, layoutParams, new Function0<View>() { // from class: com.tencent.mobileqq.vas.pay.newcustomer.QVipUserInfoCard$qSVipNewCustomerBg3$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final View invoke() {
                return com.tencent.mobileqq.vas.pay.page.o.w(QVipUserInfoCard.this, new Function1<View, Unit>() { // from class: com.tencent.mobileqq.vas.pay.newcustomer.QVipUserInfoCard$qSVipNewCustomerBg3$2.1
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(View view) {
                        invoke2(view);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull View view) {
                        Intrinsics.checkNotNullParameter(view, "$this$view");
                        BaseApplication context2 = BaseApplication.context;
                        Intrinsics.checkNotNullExpressionValue(context2, "context");
                        Drawable j3 = com.tencent.mobileqq.vas.pay.page.o.j(context2, R.drawable.l7x);
                        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
                        obtain.mLoadingDrawable = j3;
                        obtain.mFailedDrawable = j3;
                        view.setBackground(URLDrawable.getDrawable("https://tianquan.gtimg.cn/shoal/vaclient/15145663-b324-4d5b-8592-89e56a8d65c8.png", obtain));
                    }
                });
            }
        });
        ConstraintLayout.LayoutParams layoutParams2 = new ConstraintLayout.LayoutParams(com.tencent.mobileqq.vas.pay.page.o.i(135), com.tencent.mobileqq.vas.pay.page.o.i(40));
        ((ViewGroup.MarginLayoutParams) layoutParams2).topMargin = com.tencent.mobileqq.vas.pay.page.o.i(27);
        layoutParams2.setMarginStart(com.tencent.mobileqq.vas.pay.page.o.i(67));
        layoutParams2.topToTop = 0;
        layoutParams2.startToStart = 0;
        this.qSVipNewCustomerSVipFlag = com.tencent.mobileqq.vas.pay.page.o.a(this, R.id.f656539i, layoutParams2, new Function0<View>() { // from class: com.tencent.mobileqq.vas.pay.newcustomer.QVipUserInfoCard$qSVipNewCustomerSVipFlag$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final View invoke() {
                return com.tencent.mobileqq.vas.pay.page.o.w(QVipUserInfoCard.this, new Function1<View, Unit>() { // from class: com.tencent.mobileqq.vas.pay.newcustomer.QVipUserInfoCard$qSVipNewCustomerSVipFlag$2.1
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(View view) {
                        invoke2(view);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull View view) {
                        Intrinsics.checkNotNullParameter(view, "$this$view");
                        view.setBackground(URLDrawable.getDrawable("https://tianquan.gtimg.cn/shoal/vaclient/b0acee54-6925-47f0-9c90-f03234a0d5dd.png", URLDrawable.URLDrawableOptions.obtain()));
                    }
                });
            }
        });
        ConstraintLayout.LayoutParams layoutParams3 = new ConstraintLayout.LayoutParams(-1, com.tencent.mobileqq.vas.pay.page.o.i(90));
        ((ViewGroup.MarginLayoutParams) layoutParams3).topMargin = com.tencent.mobileqq.vas.pay.page.o.i(83);
        layoutParams3.topToTop = 0;
        this.qSVipNewCustomerBg2 = com.tencent.mobileqq.vas.pay.page.o.a(this, R.id.f6550394, layoutParams3, new Function0<View>() { // from class: com.tencent.mobileqq.vas.pay.newcustomer.QVipUserInfoCard$qSVipNewCustomerBg2$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final View invoke() {
                return com.tencent.mobileqq.vas.pay.page.o.w(QVipUserInfoCard.this, new Function1<View, Unit>() { // from class: com.tencent.mobileqq.vas.pay.newcustomer.QVipUserInfoCard$qSVipNewCustomerBg2$2.1
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(View view) {
                        invoke2(view);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull View view) {
                        Intrinsics.checkNotNullParameter(view, "$this$view");
                        Drawable drawable = view.getContext().getDrawable(R.drawable.l7w);
                        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
                        obtain.mFailedDrawable = drawable;
                        obtain.mLoadingDrawable = drawable;
                        view.setBackground(URLDrawable.getDrawable("https://tianquan.gtimg.cn/shoal/vaclient/6e7f6ec4-0687-402f-a097-e55971148669.png", obtain));
                    }
                });
            }
        });
        ConstraintLayout.LayoutParams layoutParams4 = new ConstraintLayout.LayoutParams(com.tencent.mobileqq.vas.pay.page.o.i(40), com.tencent.mobileqq.vas.pay.page.o.i(40));
        layoutParams4.startToStart = 0;
        layoutParams4.topToTop = 0;
        layoutParams4.setMarginStart(com.tencent.mobileqq.vas.pay.page.o.i(30));
        ((ViewGroup.MarginLayoutParams) layoutParams4).topMargin = com.tencent.mobileqq.vas.pay.page.o.i(30);
        this.qSvipNewCustomerHeadIv = (RoundRectImageView) com.tencent.mobileqq.vas.pay.page.o.a(this, R.id.f6553397, layoutParams4, new Function0<RoundRectImageView>() { // from class: com.tencent.mobileqq.vas.pay.newcustomer.QVipUserInfoCard$qSvipNewCustomerHeadIv$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final RoundRectImageView invoke() {
                return com.tencent.mobileqq.vas.pay.page.o.t(QVipUserInfoCard.this, new Function1<RoundRectImageView, Unit>() { // from class: com.tencent.mobileqq.vas.pay.newcustomer.QVipUserInfoCard$qSvipNewCustomerHeadIv$2.1
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(RoundRectImageView roundRectImageView) {
                        invoke2(roundRectImageView);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull RoundRectImageView roundImage) {
                        Intrinsics.checkNotNullParameter(roundImage, "$this$roundImage");
                        roundImage.setCornerRadiusAndMode(com.tencent.mobileqq.vas.pay.page.o.i(20), 1);
                    }
                });
            }
        });
        ConstraintLayout.LayoutParams layoutParams5 = new ConstraintLayout.LayoutParams(-2, -2);
        layoutParams5.setMarginStart(com.tencent.mobileqq.vas.pay.page.o.i(8));
        layoutParams5.topToTop = R.id.f6553397;
        layoutParams5.startToEnd = R.id.f6553397;
        layoutParams5.horizontalChainStyle = 2;
        this.qSvipNewCustomerUserName = (TextView) com.tencent.mobileqq.vas.pay.page.o.a(this, R.id.f656739k, layoutParams5, new Function0<TextView>() { // from class: com.tencent.mobileqq.vas.pay.newcustomer.QVipUserInfoCard$qSvipNewCustomerUserName$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final TextView invoke() {
                return com.tencent.mobileqq.vas.pay.page.o.v(QVipUserInfoCard.this, new Function1<TextView, Unit>() { // from class: com.tencent.mobileqq.vas.pay.newcustomer.QVipUserInfoCard$qSvipNewCustomerUserName$2.1
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(TextView textView) {
                        invoke2(textView);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull TextView text) {
                        Intrinsics.checkNotNullParameter(text, "$this$text");
                        text.getPaint().setFakeBoldText(true);
                        text.setTextColor(Color.parseColor("#8F5600"));
                        text.setMaxLines(1);
                        text.setSingleLine(true);
                        text.setMaxWidth(com.tencent.mobileqq.vas.pay.page.o.i(128));
                        text.setEllipsize(TextUtils.TruncateAt.END);
                        text.setTextSize(com.tencent.mobileqq.vas.pay.page.o.u(16));
                    }
                });
            }
        });
        ConstraintLayout.LayoutParams layoutParams6 = new ConstraintLayout.LayoutParams(-2, com.tencent.mobileqq.vas.pay.page.o.i(15));
        layoutParams6.setMarginStart(com.tencent.mobileqq.vas.pay.page.o.i(8));
        layoutParams6.startToEnd = R.id.f6553397;
        layoutParams6.bottomToBottom = R.id.f6553397;
        this.qSvipNewCustomerVipNamePlate = (ImageView) com.tencent.mobileqq.vas.pay.page.o.a(this, R.id.f6554398, layoutParams6, new Function0<ImageView>() { // from class: com.tencent.mobileqq.vas.pay.newcustomer.QVipUserInfoCard$qSvipNewCustomerVipNamePlate$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final ImageView invoke() {
                return com.tencent.mobileqq.vas.pay.page.o.m(QVipUserInfoCard.this, new Function1<ImageView, Unit>() { // from class: com.tencent.mobileqq.vas.pay.newcustomer.QVipUserInfoCard$qSvipNewCustomerVipNamePlate$2.1
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(ImageView imageView) {
                        invoke2(imageView);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull ImageView image) {
                        Intrinsics.checkNotNullParameter(image, "$this$image");
                        image.setBackgroundColor(Color.parseColor("#00000001"));
                    }
                });
            }
        });
        ConstraintLayout.LayoutParams layoutParams7 = new ConstraintLayout.LayoutParams(com.tencent.mobileqq.vas.pay.page.o.i(79), com.tencent.mobileqq.vas.pay.page.o.i(29));
        layoutParams7.setMarginEnd(com.tencent.mobileqq.vas.pay.page.o.i(30));
        ((ViewGroup.MarginLayoutParams) layoutParams7).topMargin = com.tencent.mobileqq.vas.pay.page.o.i(40);
        layoutParams7.topToTop = 0;
        layoutParams7.endToEnd = 0;
        this.qSvipNewCustomerPayBtn = (TextView) com.tencent.mobileqq.vas.pay.page.o.a(this, R.id.f656339g, layoutParams7, new Function0<TextView>() { // from class: com.tencent.mobileqq.vas.pay.newcustomer.QVipUserInfoCard$qSvipNewCustomerPayBtn$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final TextView invoke() {
                return com.tencent.mobileqq.vas.pay.page.o.v(QVipUserInfoCard.this, new Function1<TextView, Unit>() { // from class: com.tencent.mobileqq.vas.pay.newcustomer.QVipUserInfoCard$qSvipNewCustomerPayBtn$2.1
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(TextView textView) {
                        invoke2(textView);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull TextView text) {
                        Intrinsics.checkNotNullParameter(text, "$this$text");
                        text.setVisibility(8);
                        text.setTextColor(com.tencent.mobileqq.vas.pay.page.o.g(Color.parseColor("#8F5600"), 0, 2, null));
                        text.setBackgroundResource(R.drawable.f162031l81);
                        text.setGravity(17);
                    }
                });
            }
        });
        ConstraintLayout.LayoutParams layoutParams8 = new ConstraintLayout.LayoutParams(com.tencent.mobileqq.vas.pay.page.o.i(3), com.tencent.mobileqq.vas.pay.page.o.i(3));
        layoutParams8.endToStart = R.id.f656339g;
        layoutParams8.topToTop = R.id.f656339g;
        this.qSvipViewHolder = com.tencent.mobileqq.vas.pay.page.o.a(this, R.id.f656439h, layoutParams8, new Function0<View>() { // from class: com.tencent.mobileqq.vas.pay.newcustomer.QVipUserInfoCard$qSvipViewHolder$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final View invoke() {
                return com.tencent.mobileqq.vas.pay.page.o.w(QVipUserInfoCard.this, new Function1<View, Unit>() { // from class: com.tencent.mobileqq.vas.pay.newcustomer.QVipUserInfoCard$qSvipViewHolder$2.1
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(View view) {
                        invoke2(view);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull View view) {
                        Intrinsics.checkNotNullParameter(view, "$this$view");
                        view.setBackgroundColor(Color.parseColor("#00000001"));
                    }
                });
            }
        });
        ConstraintLayout.LayoutParams layoutParams9 = new ConstraintLayout.LayoutParams(-2, com.tencent.mobileqq.vas.pay.page.o.i(20));
        layoutParams9.startToStart = R.id.f656439h;
        layoutParams9.bottomToBottom = R.id.f656339g;
        ((ViewGroup.MarginLayoutParams) layoutParams9).topMargin = com.tencent.mobileqq.vas.pay.page.o.i(7);
        ((ViewGroup.MarginLayoutParams) layoutParams9).bottomMargin = com.tencent.mobileqq.vas.pay.page.o.i(19);
        this.qSvipNewCustomerRedFlag = (TextView) com.tencent.mobileqq.vas.pay.page.o.a(this, R.id.f656239f, layoutParams9, new Function0<TextView>() { // from class: com.tencent.mobileqq.vas.pay.newcustomer.QVipUserInfoCard$qSvipNewCustomerRedFlag$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final TextView invoke() {
                return com.tencent.mobileqq.vas.pay.page.o.v(QVipUserInfoCard.this, new Function1<TextView, Unit>() { // from class: com.tencent.mobileqq.vas.pay.newcustomer.QVipUserInfoCard$qSvipNewCustomerRedFlag$2.1
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(TextView textView) {
                        invoke2(textView);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull TextView text) {
                        Intrinsics.checkNotNullParameter(text, "$this$text");
                        com.tencent.mobileqq.vas.pay.page.o.p(text, com.tencent.mobileqq.vas.pay.page.o.i(3));
                        com.tencent.mobileqq.vas.pay.page.o.q(text, com.tencent.mobileqq.vas.pay.page.o.i(2));
                        text.setGravity(17);
                        text.setTextSize(com.tencent.mobileqq.vas.pay.page.o.u(10));
                        text.setMaxLines(1);
                        text.setMaxWidth(com.tencent.mobileqq.vas.pay.page.o.i(55));
                        text.setTextColor(com.tencent.mobileqq.vas.pay.page.o.g(-1, 0, 2, null));
                        text.setIncludeFontPadding(false);
                        text.setEllipsize(TextUtils.TruncateAt.END);
                        text.setBackground(new AbsAsyncDrawable() { // from class: com.tencent.mobileqq.vas.pay.newcustomer.QVipUserInfoCard$qSvipNewCustomerRedFlag$2$1$d$1
                            /* JADX INFO: Access modifiers changed from: package-private */
                            {
                                setSupportNinePath(true);
                                setTargetDrawableBuild(new Function0<URLDrawable>() { // from class: com.tencent.mobileqq.vas.pay.newcustomer.QVipUserInfoCard$qSvipNewCustomerRedFlag$2$1$d$1.1
                                    /* JADX WARN: Can't rename method to resolve collision */
                                    @Override // kotlin.jvm.functions.Function0
                                    public final URLDrawable invoke() {
                                        return URLDrawable.getDrawable(com.tencent.mobileqq.vas.pay.page.j.INSTANCE.k());
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
        ConstraintLayout.LayoutParams layoutParams10 = new ConstraintLayout.LayoutParams(-2, -2);
        layoutParams10.bottomToBottom = 0;
        layoutParams10.startToStart = 0;
        layoutParams10.endToEnd = 0;
        ((ViewGroup.MarginLayoutParams) layoutParams10).bottomMargin = com.tencent.mobileqq.vas.pay.page.o.i(38);
        this.qSvipNewCustomerPayTitle = (TextView) com.tencent.mobileqq.vas.pay.page.o.a(this, R.id.f656139e, layoutParams10, new Function0<TextView>() { // from class: com.tencent.mobileqq.vas.pay.newcustomer.QVipUserInfoCard$qSvipNewCustomerPayTitle$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final TextView invoke() {
                return com.tencent.mobileqq.vas.pay.page.o.v(QVipUserInfoCard.this, new Function1<TextView, Unit>() { // from class: com.tencent.mobileqq.vas.pay.newcustomer.QVipUserInfoCard$qSvipNewCustomerPayTitle$2.1
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(TextView textView) {
                        invoke2(textView);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull TextView text) {
                        Intrinsics.checkNotNullParameter(text, "$this$text");
                        text.setTextColor(com.tencent.mobileqq.vas.pay.page.o.g(Color.parseColor("#FFEBC5"), 0, 2, null));
                        text.setTextSize(com.tencent.mobileqq.vas.pay.page.o.u(16));
                    }
                });
            }
        });
        ConstraintLayout.LayoutParams layoutParams11 = new ConstraintLayout.LayoutParams(-2, -2);
        layoutParams11.bottomToBottom = 0;
        layoutParams11.startToStart = 0;
        layoutParams11.endToEnd = 0;
        layoutParams11.topToBottom = R.id.f656139e;
        ((ViewGroup.MarginLayoutParams) layoutParams11).bottomMargin = com.tencent.mobileqq.vas.pay.page.o.i(17);
        ((ViewGroup.MarginLayoutParams) layoutParams11).topMargin = com.tencent.mobileqq.vas.pay.page.o.i(3);
        this.qSvipNewCustomerPaySubtitle = (TextView) com.tencent.mobileqq.vas.pay.page.o.a(this, R.id.f656039d, layoutParams11, new Function0<TextView>() { // from class: com.tencent.mobileqq.vas.pay.newcustomer.QVipUserInfoCard$qSvipNewCustomerPaySubtitle$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final TextView invoke() {
                return com.tencent.mobileqq.vas.pay.page.o.v(QVipUserInfoCard.this, new Function1<TextView, Unit>() { // from class: com.tencent.mobileqq.vas.pay.newcustomer.QVipUserInfoCard$qSvipNewCustomerPaySubtitle$2.1
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(TextView textView) {
                        invoke2(textView);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull TextView text) {
                        Intrinsics.checkNotNullParameter(text, "$this$text");
                        text.setTextColor(com.tencent.mobileqq.vas.pay.page.o.g(Color.parseColor("#99FFFFFF"), 0, 2, null));
                        text.setTextSize(com.tencent.mobileqq.vas.pay.page.o.u(12));
                    }
                });
            }
        });
        ConstraintLayout.LayoutParams layoutParams12 = new ConstraintLayout.LayoutParams(-2, com.tencent.mobileqq.vas.pay.page.o.i(29));
        layoutParams12.bottomToBottom = 0;
        layoutParams12.startToStart = 0;
        layoutParams12.endToEnd = 0;
        ((ViewGroup.MarginLayoutParams) layoutParams12).bottomMargin = com.tencent.mobileqq.vas.pay.page.o.i(32);
        this.qSvipNewCustomerPayGetExperienceBtn = (TextView) com.tencent.mobileqq.vas.pay.page.o.a(this, R.id.f6555399, layoutParams12, new Function0<TextView>() { // from class: com.tencent.mobileqq.vas.pay.newcustomer.QVipUserInfoCard$qSvipNewCustomerPayGetExperienceBtn$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final TextView invoke() {
                return com.tencent.mobileqq.vas.pay.page.o.v(QVipUserInfoCard.this, new Function1<TextView, Unit>() { // from class: com.tencent.mobileqq.vas.pay.newcustomer.QVipUserInfoCard$qSvipNewCustomerPayGetExperienceBtn$2.1
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(TextView textView) {
                        invoke2(textView);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull TextView text) {
                        Intrinsics.checkNotNullParameter(text, "$this$text");
                        text.setPadding(com.tencent.mobileqq.vas.pay.page.o.i(16), 0, com.tencent.mobileqq.vas.pay.page.o.i(16), 0);
                        text.setVisibility(8);
                        text.setGravity(17);
                        text.setTextColor(com.tencent.mobileqq.vas.pay.page.o.g(Color.parseColor("#9A6310"), 0, 2, null));
                        text.setBackgroundResource(R.drawable.l7s);
                        text.setTextSize(com.tencent.mobileqq.vas.pay.page.o.u(14));
                    }
                });
            }
        });
        ConstraintLayout.LayoutParams layoutParams13 = new ConstraintLayout.LayoutParams(-2, -2);
        layoutParams13.bottomToBottom = 0;
        layoutParams13.startToStart = 0;
        layoutParams13.endToEnd = 0;
        ((ViewGroup.MarginLayoutParams) layoutParams13).bottomMargin = com.tencent.mobileqq.vas.pay.page.o.i(14);
        this.qSvipNewCustomerPayCountdown = (TextView) com.tencent.mobileqq.vas.pay.page.o.a(this, R.id.f656039d, layoutParams13, new Function0<TextView>() { // from class: com.tencent.mobileqq.vas.pay.newcustomer.QVipUserInfoCard$qSvipNewCustomerPayCountdown$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final TextView invoke() {
                return com.tencent.mobileqq.vas.pay.page.o.v(QVipUserInfoCard.this, new Function1<TextView, Unit>() { // from class: com.tencent.mobileqq.vas.pay.newcustomer.QVipUserInfoCard$qSvipNewCustomerPayCountdown$2.1
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(TextView textView) {
                        invoke2(textView);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull TextView text) {
                        Intrinsics.checkNotNullParameter(text, "$this$text");
                        text.setVisibility(8);
                        text.setTextColor(com.tencent.mobileqq.vas.pay.page.o.g(Color.parseColor("#99FFFFFF"), 0, 2, null));
                        text.setTextSize(com.tencent.mobileqq.vas.pay.page.o.u(10));
                    }
                });
            }
        });
        E0();
    }

    private final String A0(int i3) {
        if (i3 < 10) {
            return "0" + i3;
        }
        return String.valueOf(i3);
    }

    private final String B0(final int refreshTimes) {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return "";
        }
        String nickName = peekAppRuntime.getApplication().getProperty(Constants.PropertiesKey.nickName.toString() + peekAppRuntime.getCurrentAccountUin());
        if (refreshTimes <= 3 && TextUtils.isEmpty(nickName)) {
            ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.vas.pay.newcustomer.ae
                @Override // java.lang.Runnable
                public final void run() {
                    QVipUserInfoCard.C0(QVipUserInfoCard.this, refreshTimes);
                }
            }, 1000L);
        }
        if (TextUtils.isEmpty(nickName)) {
            nickName = peekAppRuntime.getCurrentAccountUin();
        }
        Intrinsics.checkNotNullExpressionValue(nickName, "nickName");
        return nickName;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void C0(QVipUserInfoCard this$0, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.G0(i3 + 1);
    }

    private final void F0() {
        AppRuntime appRuntime;
        MobileQQ mobileQQ = MobileQQ.sMobileQQ;
        if (mobileQQ != null) {
            appRuntime = mobileQQ.peekAppRuntime();
        } else {
            appRuntime = null;
        }
        if (appRuntime == null) {
            return;
        }
        ColorDrawable colorDrawable = new ColorDrawable(com.tencent.mobileqq.vas.pay.page.o.g(0, 0, 2, null));
        AppInterface appInterface = (AppInterface) appRuntime;
        this.qSvipNewCustomerHeadIv.setBackground(FaceDrawable.getFaceDrawable(appInterface, 1, appInterface.getCurrentAccountUin(), 3, colorDrawable, colorDrawable));
    }

    private final void G0(int refreshTimes) {
        this.qSvipNewCustomerUserName.setText(B0(refreshTimes));
    }

    private final void setRedFlag(String flagText) {
        int i3;
        if (TextUtils.isEmpty(flagText)) {
            this.qSvipNewCustomerRedFlag.setVisibility(8);
            return;
        }
        this.qSvipNewCustomerRedFlag.setVisibility(0);
        this.qSvipNewCustomerRedFlag.setText(flagText);
        float measureText = this.qSvipNewCustomerRedFlag.getPaint().measureText(flagText);
        if (measureText > 0.0f) {
            TextView textView = this.qSvipNewCustomerRedFlag;
            ViewGroup.LayoutParams layoutParams = textView.getLayoutParams();
            layoutParams.width = (int) (measureText + com.tencent.mobileqq.vas.pay.page.o.i(10));
            textView.setLayoutParams(layoutParams);
            return;
        }
        TextView textView2 = this.qSvipNewCustomerRedFlag;
        ViewGroup.LayoutParams layoutParams2 = textView2.getLayoutParams();
        if (flagText.length() <= 4) {
            i3 = com.tencent.mobileqq.vas.pay.page.o.i(52);
        } else {
            i3 = com.tencent.mobileqq.vas.pay.page.o.i(56);
        }
        layoutParams2.width = i3;
        textView2.setLayoutParams(layoutParams2);
    }

    public final void D0() {
        this.qSvipNewCustomerPayCountdown.setVisibility(8);
        this.qSvipNewCustomerPayGetExperienceBtn.setVisibility(8);
    }

    public final void initView() {
        F0();
        setNamePlate();
        G0(0);
    }

    public final void setCountDownGetExperience(boolean isInCountDownGetExperience) {
        if (isInCountDownGetExperience) {
            this.qSvipNewCustomerPayTitle.setVisibility(8);
            this.qSvipNewCustomerPaySubtitle.setVisibility(8);
            this.qSvipNewCustomerPayCountdown.setVisibility(0);
            this.qSvipNewCustomerPayGetExperienceBtn.setVisibility(0);
            return;
        }
        this.qSvipNewCustomerPayTitle.setVisibility(0);
        this.qSvipNewCustomerPaySubtitle.setVisibility(0);
        this.qSvipNewCustomerPayCountdown.setVisibility(8);
        this.qSvipNewCustomerPayGetExperienceBtn.setVisibility(8);
    }

    public final void setCountDownText(@NotNull String text) {
        Intrinsics.checkNotNullParameter(text, "text");
        this.qSvipNewCustomerPayCountdown.setText(text);
    }

    public final void setExperienceExpiredCountDown(int day, int hour, int minute, int sec) {
        if (day > 0) {
            setUserStatusTitle(new SpannableString(day + "\u5929\u540e\u4f53\u9a8c\u5230\u671f"));
            return;
        }
        setUserStatusTitle(new SpannableString(A0(hour) + ":" + A0(minute) + ":" + A0(sec) + " \u540e\u4f53\u9a8c\u5230\u671f"));
    }

    public final void setGetExperienceBtnText(@NotNull String text) {
        Intrinsics.checkNotNullParameter(text, "text");
        this.qSvipNewCustomerPayGetExperienceBtn.setText(text);
    }

    public final void setGetSVipExperienceClickListener(@NotNull View.OnClickListener click) {
        Intrinsics.checkNotNullParameter(click, "click");
        this.qSvipNewCustomerPayGetExperienceBtn.setOnClickListener(click);
    }

    public final void setNamePlate() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return;
        }
        IVipIconUtils api = IVipIconUtils.INSTANCE.api();
        ImageView imageView = this.qSvipNewCustomerVipNamePlate;
        String currentAccountUin = peekAppRuntime.getCurrentAccountUin();
        Intrinsics.checkNotNullExpressionValue(currentAccountUin, "appRuntime.currentAccountUin");
        api.setVipCardDrawable(imageView, currentAccountUin);
        if (this.qSvipNewCustomerVipNamePlate.getLayoutParams().width < com.tencent.mobileqq.vas.pay.page.o.i(40)) {
            ImageView imageView2 = this.qSvipNewCustomerVipNamePlate;
            ViewGroup.LayoutParams layoutParams = imageView2.getLayoutParams();
            int i3 = layoutParams.height;
            layoutParams.height = com.tencent.mobileqq.vas.pay.page.o.i(15);
            layoutParams.width = (int) (((com.tencent.mobileqq.vas.pay.page.o.i(15) * 1.0f) / i3) * layoutParams.width);
            imageView2.setLayoutParams(layoutParams);
        }
    }

    public final void setPayBtn(@NotNull String payText, @NotNull String markText) {
        Intrinsics.checkNotNullParameter(payText, "payText");
        Intrinsics.checkNotNullParameter(markText, "markText");
        if (TextUtils.isEmpty(payText)) {
            this.qSvipNewCustomerPayBtn.setVisibility(8);
            this.qSvipNewCustomerRedFlag.setVisibility(8);
        } else {
            this.qSvipNewCustomerPayBtn.setVisibility(0);
            this.qSvipNewCustomerPayBtn.setText(payText);
            setRedFlag(markText);
        }
    }

    public final void setPayBtnClickListener(@NotNull View.OnClickListener click) {
        Intrinsics.checkNotNullParameter(click, "click");
        this.qSvipNewCustomerPayBtn.setOnClickListener(click);
    }

    public final void setUserStatusSubtitle(@NotNull SpannableString text) {
        Intrinsics.checkNotNullParameter(text, "text");
        this.qSvipNewCustomerPaySubtitle.setText(text);
    }

    public final void setUserStatusTitle(@NotNull SpannableString text) {
        Intrinsics.checkNotNullParameter(text, "text");
        this.qSvipNewCustomerPayTitle.setText(text);
    }

    private final void E0() {
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QVipUserInfoCard(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        setPadding(com.tencent.mobileqq.vas.pay.page.o.i(16), 0, com.tencent.mobileqq.vas.pay.page.o.i(16), 0);
        this.qSVipNewCustomerBg1 = com.tencent.mobileqq.vas.pay.page.o.a(this, R.id.f6549393, new ConstraintLayout.LayoutParams(-1, com.tencent.mobileqq.vas.pay.page.o.i(159)), new Function0<View>() { // from class: com.tencent.mobileqq.vas.pay.newcustomer.QVipUserInfoCard$qSVipNewCustomerBg1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final View invoke() {
                return com.tencent.mobileqq.vas.pay.page.o.w(QVipUserInfoCard.this, new Function1<View, Unit>() { // from class: com.tencent.mobileqq.vas.pay.newcustomer.QVipUserInfoCard$qSVipNewCustomerBg1$1.1
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(View view) {
                        invoke2(view);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull View view) {
                        Intrinsics.checkNotNullParameter(view, "$this$view");
                        BaseApplication context2 = BaseApplication.context;
                        Intrinsics.checkNotNullExpressionValue(context2, "context");
                        Drawable j3 = com.tencent.mobileqq.vas.pay.page.o.j(context2, R.drawable.l7y);
                        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
                        obtain.mLoadingDrawable = j3;
                        obtain.mFailedDrawable = j3;
                        view.setBackground(URLDrawable.getDrawable("https://tianquan.gtimg.cn/shoal/vaclient/6ae11b4e-6c93-47f5-849f-074e6b016e45.png", obtain));
                    }
                });
            }
        });
        ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(-1, com.tencent.mobileqq.vas.pay.page.o.i(140));
        layoutParams.topToTop = 0;
        layoutParams.startToStart = 0;
        layoutParams.endToEnd = 0;
        ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = com.tencent.mobileqq.vas.pay.page.o.i(13);
        layoutParams.setMarginStart(com.tencent.mobileqq.vas.pay.page.o.i(13));
        layoutParams.setMarginEnd(com.tencent.mobileqq.vas.pay.page.o.i(13));
        Unit unit = Unit.INSTANCE;
        this.qSVipNewCustomerBg3 = com.tencent.mobileqq.vas.pay.page.o.a(this, R.id.f6551395, layoutParams, new Function0<View>() { // from class: com.tencent.mobileqq.vas.pay.newcustomer.QVipUserInfoCard$qSVipNewCustomerBg3$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final View invoke() {
                return com.tencent.mobileqq.vas.pay.page.o.w(QVipUserInfoCard.this, new Function1<View, Unit>() { // from class: com.tencent.mobileqq.vas.pay.newcustomer.QVipUserInfoCard$qSVipNewCustomerBg3$2.1
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(View view) {
                        invoke2(view);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull View view) {
                        Intrinsics.checkNotNullParameter(view, "$this$view");
                        BaseApplication context2 = BaseApplication.context;
                        Intrinsics.checkNotNullExpressionValue(context2, "context");
                        Drawable j3 = com.tencent.mobileqq.vas.pay.page.o.j(context2, R.drawable.l7x);
                        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
                        obtain.mLoadingDrawable = j3;
                        obtain.mFailedDrawable = j3;
                        view.setBackground(URLDrawable.getDrawable("https://tianquan.gtimg.cn/shoal/vaclient/15145663-b324-4d5b-8592-89e56a8d65c8.png", obtain));
                    }
                });
            }
        });
        ConstraintLayout.LayoutParams layoutParams2 = new ConstraintLayout.LayoutParams(com.tencent.mobileqq.vas.pay.page.o.i(135), com.tencent.mobileqq.vas.pay.page.o.i(40));
        ((ViewGroup.MarginLayoutParams) layoutParams2).topMargin = com.tencent.mobileqq.vas.pay.page.o.i(27);
        layoutParams2.setMarginStart(com.tencent.mobileqq.vas.pay.page.o.i(67));
        layoutParams2.topToTop = 0;
        layoutParams2.startToStart = 0;
        this.qSVipNewCustomerSVipFlag = com.tencent.mobileqq.vas.pay.page.o.a(this, R.id.f656539i, layoutParams2, new Function0<View>() { // from class: com.tencent.mobileqq.vas.pay.newcustomer.QVipUserInfoCard$qSVipNewCustomerSVipFlag$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final View invoke() {
                return com.tencent.mobileqq.vas.pay.page.o.w(QVipUserInfoCard.this, new Function1<View, Unit>() { // from class: com.tencent.mobileqq.vas.pay.newcustomer.QVipUserInfoCard$qSVipNewCustomerSVipFlag$2.1
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(View view) {
                        invoke2(view);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull View view) {
                        Intrinsics.checkNotNullParameter(view, "$this$view");
                        view.setBackground(URLDrawable.getDrawable("https://tianquan.gtimg.cn/shoal/vaclient/b0acee54-6925-47f0-9c90-f03234a0d5dd.png", URLDrawable.URLDrawableOptions.obtain()));
                    }
                });
            }
        });
        ConstraintLayout.LayoutParams layoutParams3 = new ConstraintLayout.LayoutParams(-1, com.tencent.mobileqq.vas.pay.page.o.i(90));
        ((ViewGroup.MarginLayoutParams) layoutParams3).topMargin = com.tencent.mobileqq.vas.pay.page.o.i(83);
        layoutParams3.topToTop = 0;
        this.qSVipNewCustomerBg2 = com.tencent.mobileqq.vas.pay.page.o.a(this, R.id.f6550394, layoutParams3, new Function0<View>() { // from class: com.tencent.mobileqq.vas.pay.newcustomer.QVipUserInfoCard$qSVipNewCustomerBg2$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final View invoke() {
                return com.tencent.mobileqq.vas.pay.page.o.w(QVipUserInfoCard.this, new Function1<View, Unit>() { // from class: com.tencent.mobileqq.vas.pay.newcustomer.QVipUserInfoCard$qSVipNewCustomerBg2$2.1
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(View view) {
                        invoke2(view);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull View view) {
                        Intrinsics.checkNotNullParameter(view, "$this$view");
                        Drawable drawable = view.getContext().getDrawable(R.drawable.l7w);
                        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
                        obtain.mFailedDrawable = drawable;
                        obtain.mLoadingDrawable = drawable;
                        view.setBackground(URLDrawable.getDrawable("https://tianquan.gtimg.cn/shoal/vaclient/6e7f6ec4-0687-402f-a097-e55971148669.png", obtain));
                    }
                });
            }
        });
        ConstraintLayout.LayoutParams layoutParams4 = new ConstraintLayout.LayoutParams(com.tencent.mobileqq.vas.pay.page.o.i(40), com.tencent.mobileqq.vas.pay.page.o.i(40));
        layoutParams4.startToStart = 0;
        layoutParams4.topToTop = 0;
        layoutParams4.setMarginStart(com.tencent.mobileqq.vas.pay.page.o.i(30));
        ((ViewGroup.MarginLayoutParams) layoutParams4).topMargin = com.tencent.mobileqq.vas.pay.page.o.i(30);
        this.qSvipNewCustomerHeadIv = (RoundRectImageView) com.tencent.mobileqq.vas.pay.page.o.a(this, R.id.f6553397, layoutParams4, new Function0<RoundRectImageView>() { // from class: com.tencent.mobileqq.vas.pay.newcustomer.QVipUserInfoCard$qSvipNewCustomerHeadIv$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final RoundRectImageView invoke() {
                return com.tencent.mobileqq.vas.pay.page.o.t(QVipUserInfoCard.this, new Function1<RoundRectImageView, Unit>() { // from class: com.tencent.mobileqq.vas.pay.newcustomer.QVipUserInfoCard$qSvipNewCustomerHeadIv$2.1
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(RoundRectImageView roundRectImageView) {
                        invoke2(roundRectImageView);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull RoundRectImageView roundImage) {
                        Intrinsics.checkNotNullParameter(roundImage, "$this$roundImage");
                        roundImage.setCornerRadiusAndMode(com.tencent.mobileqq.vas.pay.page.o.i(20), 1);
                    }
                });
            }
        });
        ConstraintLayout.LayoutParams layoutParams5 = new ConstraintLayout.LayoutParams(-2, -2);
        layoutParams5.setMarginStart(com.tencent.mobileqq.vas.pay.page.o.i(8));
        layoutParams5.topToTop = R.id.f6553397;
        layoutParams5.startToEnd = R.id.f6553397;
        layoutParams5.horizontalChainStyle = 2;
        this.qSvipNewCustomerUserName = (TextView) com.tencent.mobileqq.vas.pay.page.o.a(this, R.id.f656739k, layoutParams5, new Function0<TextView>() { // from class: com.tencent.mobileqq.vas.pay.newcustomer.QVipUserInfoCard$qSvipNewCustomerUserName$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final TextView invoke() {
                return com.tencent.mobileqq.vas.pay.page.o.v(QVipUserInfoCard.this, new Function1<TextView, Unit>() { // from class: com.tencent.mobileqq.vas.pay.newcustomer.QVipUserInfoCard$qSvipNewCustomerUserName$2.1
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(TextView textView) {
                        invoke2(textView);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull TextView text) {
                        Intrinsics.checkNotNullParameter(text, "$this$text");
                        text.getPaint().setFakeBoldText(true);
                        text.setTextColor(Color.parseColor("#8F5600"));
                        text.setMaxLines(1);
                        text.setSingleLine(true);
                        text.setMaxWidth(com.tencent.mobileqq.vas.pay.page.o.i(128));
                        text.setEllipsize(TextUtils.TruncateAt.END);
                        text.setTextSize(com.tencent.mobileqq.vas.pay.page.o.u(16));
                    }
                });
            }
        });
        ConstraintLayout.LayoutParams layoutParams6 = new ConstraintLayout.LayoutParams(-2, com.tencent.mobileqq.vas.pay.page.o.i(15));
        layoutParams6.setMarginStart(com.tencent.mobileqq.vas.pay.page.o.i(8));
        layoutParams6.startToEnd = R.id.f6553397;
        layoutParams6.bottomToBottom = R.id.f6553397;
        this.qSvipNewCustomerVipNamePlate = (ImageView) com.tencent.mobileqq.vas.pay.page.o.a(this, R.id.f6554398, layoutParams6, new Function0<ImageView>() { // from class: com.tencent.mobileqq.vas.pay.newcustomer.QVipUserInfoCard$qSvipNewCustomerVipNamePlate$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final ImageView invoke() {
                return com.tencent.mobileqq.vas.pay.page.o.m(QVipUserInfoCard.this, new Function1<ImageView, Unit>() { // from class: com.tencent.mobileqq.vas.pay.newcustomer.QVipUserInfoCard$qSvipNewCustomerVipNamePlate$2.1
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(ImageView imageView) {
                        invoke2(imageView);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull ImageView image) {
                        Intrinsics.checkNotNullParameter(image, "$this$image");
                        image.setBackgroundColor(Color.parseColor("#00000001"));
                    }
                });
            }
        });
        ConstraintLayout.LayoutParams layoutParams7 = new ConstraintLayout.LayoutParams(com.tencent.mobileqq.vas.pay.page.o.i(79), com.tencent.mobileqq.vas.pay.page.o.i(29));
        layoutParams7.setMarginEnd(com.tencent.mobileqq.vas.pay.page.o.i(30));
        ((ViewGroup.MarginLayoutParams) layoutParams7).topMargin = com.tencent.mobileqq.vas.pay.page.o.i(40);
        layoutParams7.topToTop = 0;
        layoutParams7.endToEnd = 0;
        this.qSvipNewCustomerPayBtn = (TextView) com.tencent.mobileqq.vas.pay.page.o.a(this, R.id.f656339g, layoutParams7, new Function0<TextView>() { // from class: com.tencent.mobileqq.vas.pay.newcustomer.QVipUserInfoCard$qSvipNewCustomerPayBtn$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final TextView invoke() {
                return com.tencent.mobileqq.vas.pay.page.o.v(QVipUserInfoCard.this, new Function1<TextView, Unit>() { // from class: com.tencent.mobileqq.vas.pay.newcustomer.QVipUserInfoCard$qSvipNewCustomerPayBtn$2.1
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(TextView textView) {
                        invoke2(textView);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull TextView text) {
                        Intrinsics.checkNotNullParameter(text, "$this$text");
                        text.setVisibility(8);
                        text.setTextColor(com.tencent.mobileqq.vas.pay.page.o.g(Color.parseColor("#8F5600"), 0, 2, null));
                        text.setBackgroundResource(R.drawable.f162031l81);
                        text.setGravity(17);
                    }
                });
            }
        });
        ConstraintLayout.LayoutParams layoutParams8 = new ConstraintLayout.LayoutParams(com.tencent.mobileqq.vas.pay.page.o.i(3), com.tencent.mobileqq.vas.pay.page.o.i(3));
        layoutParams8.endToStart = R.id.f656339g;
        layoutParams8.topToTop = R.id.f656339g;
        this.qSvipViewHolder = com.tencent.mobileqq.vas.pay.page.o.a(this, R.id.f656439h, layoutParams8, new Function0<View>() { // from class: com.tencent.mobileqq.vas.pay.newcustomer.QVipUserInfoCard$qSvipViewHolder$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final View invoke() {
                return com.tencent.mobileqq.vas.pay.page.o.w(QVipUserInfoCard.this, new Function1<View, Unit>() { // from class: com.tencent.mobileqq.vas.pay.newcustomer.QVipUserInfoCard$qSvipViewHolder$2.1
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(View view) {
                        invoke2(view);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull View view) {
                        Intrinsics.checkNotNullParameter(view, "$this$view");
                        view.setBackgroundColor(Color.parseColor("#00000001"));
                    }
                });
            }
        });
        ConstraintLayout.LayoutParams layoutParams9 = new ConstraintLayout.LayoutParams(-2, com.tencent.mobileqq.vas.pay.page.o.i(20));
        layoutParams9.startToStart = R.id.f656439h;
        layoutParams9.bottomToBottom = R.id.f656339g;
        ((ViewGroup.MarginLayoutParams) layoutParams9).topMargin = com.tencent.mobileqq.vas.pay.page.o.i(7);
        ((ViewGroup.MarginLayoutParams) layoutParams9).bottomMargin = com.tencent.mobileqq.vas.pay.page.o.i(19);
        this.qSvipNewCustomerRedFlag = (TextView) com.tencent.mobileqq.vas.pay.page.o.a(this, R.id.f656239f, layoutParams9, new Function0<TextView>() { // from class: com.tencent.mobileqq.vas.pay.newcustomer.QVipUserInfoCard$qSvipNewCustomerRedFlag$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final TextView invoke() {
                return com.tencent.mobileqq.vas.pay.page.o.v(QVipUserInfoCard.this, new Function1<TextView, Unit>() { // from class: com.tencent.mobileqq.vas.pay.newcustomer.QVipUserInfoCard$qSvipNewCustomerRedFlag$2.1
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(TextView textView) {
                        invoke2(textView);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull TextView text) {
                        Intrinsics.checkNotNullParameter(text, "$this$text");
                        com.tencent.mobileqq.vas.pay.page.o.p(text, com.tencent.mobileqq.vas.pay.page.o.i(3));
                        com.tencent.mobileqq.vas.pay.page.o.q(text, com.tencent.mobileqq.vas.pay.page.o.i(2));
                        text.setGravity(17);
                        text.setTextSize(com.tencent.mobileqq.vas.pay.page.o.u(10));
                        text.setMaxLines(1);
                        text.setMaxWidth(com.tencent.mobileqq.vas.pay.page.o.i(55));
                        text.setTextColor(com.tencent.mobileqq.vas.pay.page.o.g(-1, 0, 2, null));
                        text.setIncludeFontPadding(false);
                        text.setEllipsize(TextUtils.TruncateAt.END);
                        text.setBackground(new AbsAsyncDrawable() { // from class: com.tencent.mobileqq.vas.pay.newcustomer.QVipUserInfoCard$qSvipNewCustomerRedFlag$2$1$d$1
                            /* JADX INFO: Access modifiers changed from: package-private */
                            {
                                setSupportNinePath(true);
                                setTargetDrawableBuild(new Function0<URLDrawable>() { // from class: com.tencent.mobileqq.vas.pay.newcustomer.QVipUserInfoCard$qSvipNewCustomerRedFlag$2$1$d$1.1
                                    /* JADX WARN: Can't rename method to resolve collision */
                                    @Override // kotlin.jvm.functions.Function0
                                    public final URLDrawable invoke() {
                                        return URLDrawable.getDrawable(com.tencent.mobileqq.vas.pay.page.j.INSTANCE.k());
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
        ConstraintLayout.LayoutParams layoutParams10 = new ConstraintLayout.LayoutParams(-2, -2);
        layoutParams10.bottomToBottom = 0;
        layoutParams10.startToStart = 0;
        layoutParams10.endToEnd = 0;
        ((ViewGroup.MarginLayoutParams) layoutParams10).bottomMargin = com.tencent.mobileqq.vas.pay.page.o.i(38);
        this.qSvipNewCustomerPayTitle = (TextView) com.tencent.mobileqq.vas.pay.page.o.a(this, R.id.f656139e, layoutParams10, new Function0<TextView>() { // from class: com.tencent.mobileqq.vas.pay.newcustomer.QVipUserInfoCard$qSvipNewCustomerPayTitle$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final TextView invoke() {
                return com.tencent.mobileqq.vas.pay.page.o.v(QVipUserInfoCard.this, new Function1<TextView, Unit>() { // from class: com.tencent.mobileqq.vas.pay.newcustomer.QVipUserInfoCard$qSvipNewCustomerPayTitle$2.1
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(TextView textView) {
                        invoke2(textView);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull TextView text) {
                        Intrinsics.checkNotNullParameter(text, "$this$text");
                        text.setTextColor(com.tencent.mobileqq.vas.pay.page.o.g(Color.parseColor("#FFEBC5"), 0, 2, null));
                        text.setTextSize(com.tencent.mobileqq.vas.pay.page.o.u(16));
                    }
                });
            }
        });
        ConstraintLayout.LayoutParams layoutParams11 = new ConstraintLayout.LayoutParams(-2, -2);
        layoutParams11.bottomToBottom = 0;
        layoutParams11.startToStart = 0;
        layoutParams11.endToEnd = 0;
        layoutParams11.topToBottom = R.id.f656139e;
        ((ViewGroup.MarginLayoutParams) layoutParams11).bottomMargin = com.tencent.mobileqq.vas.pay.page.o.i(17);
        ((ViewGroup.MarginLayoutParams) layoutParams11).topMargin = com.tencent.mobileqq.vas.pay.page.o.i(3);
        this.qSvipNewCustomerPaySubtitle = (TextView) com.tencent.mobileqq.vas.pay.page.o.a(this, R.id.f656039d, layoutParams11, new Function0<TextView>() { // from class: com.tencent.mobileqq.vas.pay.newcustomer.QVipUserInfoCard$qSvipNewCustomerPaySubtitle$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final TextView invoke() {
                return com.tencent.mobileqq.vas.pay.page.o.v(QVipUserInfoCard.this, new Function1<TextView, Unit>() { // from class: com.tencent.mobileqq.vas.pay.newcustomer.QVipUserInfoCard$qSvipNewCustomerPaySubtitle$2.1
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(TextView textView) {
                        invoke2(textView);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull TextView text) {
                        Intrinsics.checkNotNullParameter(text, "$this$text");
                        text.setTextColor(com.tencent.mobileqq.vas.pay.page.o.g(Color.parseColor("#99FFFFFF"), 0, 2, null));
                        text.setTextSize(com.tencent.mobileqq.vas.pay.page.o.u(12));
                    }
                });
            }
        });
        ConstraintLayout.LayoutParams layoutParams12 = new ConstraintLayout.LayoutParams(-2, com.tencent.mobileqq.vas.pay.page.o.i(29));
        layoutParams12.bottomToBottom = 0;
        layoutParams12.startToStart = 0;
        layoutParams12.endToEnd = 0;
        ((ViewGroup.MarginLayoutParams) layoutParams12).bottomMargin = com.tencent.mobileqq.vas.pay.page.o.i(32);
        this.qSvipNewCustomerPayGetExperienceBtn = (TextView) com.tencent.mobileqq.vas.pay.page.o.a(this, R.id.f6555399, layoutParams12, new Function0<TextView>() { // from class: com.tencent.mobileqq.vas.pay.newcustomer.QVipUserInfoCard$qSvipNewCustomerPayGetExperienceBtn$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final TextView invoke() {
                return com.tencent.mobileqq.vas.pay.page.o.v(QVipUserInfoCard.this, new Function1<TextView, Unit>() { // from class: com.tencent.mobileqq.vas.pay.newcustomer.QVipUserInfoCard$qSvipNewCustomerPayGetExperienceBtn$2.1
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(TextView textView) {
                        invoke2(textView);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull TextView text) {
                        Intrinsics.checkNotNullParameter(text, "$this$text");
                        text.setPadding(com.tencent.mobileqq.vas.pay.page.o.i(16), 0, com.tencent.mobileqq.vas.pay.page.o.i(16), 0);
                        text.setVisibility(8);
                        text.setGravity(17);
                        text.setTextColor(com.tencent.mobileqq.vas.pay.page.o.g(Color.parseColor("#9A6310"), 0, 2, null));
                        text.setBackgroundResource(R.drawable.l7s);
                        text.setTextSize(com.tencent.mobileqq.vas.pay.page.o.u(14));
                    }
                });
            }
        });
        ConstraintLayout.LayoutParams layoutParams13 = new ConstraintLayout.LayoutParams(-2, -2);
        layoutParams13.bottomToBottom = 0;
        layoutParams13.startToStart = 0;
        layoutParams13.endToEnd = 0;
        ((ViewGroup.MarginLayoutParams) layoutParams13).bottomMargin = com.tencent.mobileqq.vas.pay.page.o.i(14);
        this.qSvipNewCustomerPayCountdown = (TextView) com.tencent.mobileqq.vas.pay.page.o.a(this, R.id.f656039d, layoutParams13, new Function0<TextView>() { // from class: com.tencent.mobileqq.vas.pay.newcustomer.QVipUserInfoCard$qSvipNewCustomerPayCountdown$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final TextView invoke() {
                return com.tencent.mobileqq.vas.pay.page.o.v(QVipUserInfoCard.this, new Function1<TextView, Unit>() { // from class: com.tencent.mobileqq.vas.pay.newcustomer.QVipUserInfoCard$qSvipNewCustomerPayCountdown$2.1
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(TextView textView) {
                        invoke2(textView);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull TextView text) {
                        Intrinsics.checkNotNullParameter(text, "$this$text");
                        text.setVisibility(8);
                        text.setTextColor(com.tencent.mobileqq.vas.pay.page.o.g(Color.parseColor("#99FFFFFF"), 0, 2, null));
                        text.setTextSize(com.tencent.mobileqq.vas.pay.page.o.u(10));
                    }
                });
            }
        });
        E0();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QVipUserInfoCard(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        setPadding(com.tencent.mobileqq.vas.pay.page.o.i(16), 0, com.tencent.mobileqq.vas.pay.page.o.i(16), 0);
        this.qSVipNewCustomerBg1 = com.tencent.mobileqq.vas.pay.page.o.a(this, R.id.f6549393, new ConstraintLayout.LayoutParams(-1, com.tencent.mobileqq.vas.pay.page.o.i(159)), new Function0<View>() { // from class: com.tencent.mobileqq.vas.pay.newcustomer.QVipUserInfoCard$qSVipNewCustomerBg1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final View invoke() {
                return com.tencent.mobileqq.vas.pay.page.o.w(QVipUserInfoCard.this, new Function1<View, Unit>() { // from class: com.tencent.mobileqq.vas.pay.newcustomer.QVipUserInfoCard$qSVipNewCustomerBg1$1.1
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(View view) {
                        invoke2(view);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull View view) {
                        Intrinsics.checkNotNullParameter(view, "$this$view");
                        BaseApplication context2 = BaseApplication.context;
                        Intrinsics.checkNotNullExpressionValue(context2, "context");
                        Drawable j3 = com.tencent.mobileqq.vas.pay.page.o.j(context2, R.drawable.l7y);
                        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
                        obtain.mLoadingDrawable = j3;
                        obtain.mFailedDrawable = j3;
                        view.setBackground(URLDrawable.getDrawable("https://tianquan.gtimg.cn/shoal/vaclient/6ae11b4e-6c93-47f5-849f-074e6b016e45.png", obtain));
                    }
                });
            }
        });
        ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(-1, com.tencent.mobileqq.vas.pay.page.o.i(140));
        layoutParams.topToTop = 0;
        layoutParams.startToStart = 0;
        layoutParams.endToEnd = 0;
        ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = com.tencent.mobileqq.vas.pay.page.o.i(13);
        layoutParams.setMarginStart(com.tencent.mobileqq.vas.pay.page.o.i(13));
        layoutParams.setMarginEnd(com.tencent.mobileqq.vas.pay.page.o.i(13));
        Unit unit = Unit.INSTANCE;
        this.qSVipNewCustomerBg3 = com.tencent.mobileqq.vas.pay.page.o.a(this, R.id.f6551395, layoutParams, new Function0<View>() { // from class: com.tencent.mobileqq.vas.pay.newcustomer.QVipUserInfoCard$qSVipNewCustomerBg3$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final View invoke() {
                return com.tencent.mobileqq.vas.pay.page.o.w(QVipUserInfoCard.this, new Function1<View, Unit>() { // from class: com.tencent.mobileqq.vas.pay.newcustomer.QVipUserInfoCard$qSVipNewCustomerBg3$2.1
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(View view) {
                        invoke2(view);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull View view) {
                        Intrinsics.checkNotNullParameter(view, "$this$view");
                        BaseApplication context2 = BaseApplication.context;
                        Intrinsics.checkNotNullExpressionValue(context2, "context");
                        Drawable j3 = com.tencent.mobileqq.vas.pay.page.o.j(context2, R.drawable.l7x);
                        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
                        obtain.mLoadingDrawable = j3;
                        obtain.mFailedDrawable = j3;
                        view.setBackground(URLDrawable.getDrawable("https://tianquan.gtimg.cn/shoal/vaclient/15145663-b324-4d5b-8592-89e56a8d65c8.png", obtain));
                    }
                });
            }
        });
        ConstraintLayout.LayoutParams layoutParams2 = new ConstraintLayout.LayoutParams(com.tencent.mobileqq.vas.pay.page.o.i(135), com.tencent.mobileqq.vas.pay.page.o.i(40));
        ((ViewGroup.MarginLayoutParams) layoutParams2).topMargin = com.tencent.mobileqq.vas.pay.page.o.i(27);
        layoutParams2.setMarginStart(com.tencent.mobileqq.vas.pay.page.o.i(67));
        layoutParams2.topToTop = 0;
        layoutParams2.startToStart = 0;
        this.qSVipNewCustomerSVipFlag = com.tencent.mobileqq.vas.pay.page.o.a(this, R.id.f656539i, layoutParams2, new Function0<View>() { // from class: com.tencent.mobileqq.vas.pay.newcustomer.QVipUserInfoCard$qSVipNewCustomerSVipFlag$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final View invoke() {
                return com.tencent.mobileqq.vas.pay.page.o.w(QVipUserInfoCard.this, new Function1<View, Unit>() { // from class: com.tencent.mobileqq.vas.pay.newcustomer.QVipUserInfoCard$qSVipNewCustomerSVipFlag$2.1
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(View view) {
                        invoke2(view);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull View view) {
                        Intrinsics.checkNotNullParameter(view, "$this$view");
                        view.setBackground(URLDrawable.getDrawable("https://tianquan.gtimg.cn/shoal/vaclient/b0acee54-6925-47f0-9c90-f03234a0d5dd.png", URLDrawable.URLDrawableOptions.obtain()));
                    }
                });
            }
        });
        ConstraintLayout.LayoutParams layoutParams3 = new ConstraintLayout.LayoutParams(-1, com.tencent.mobileqq.vas.pay.page.o.i(90));
        ((ViewGroup.MarginLayoutParams) layoutParams3).topMargin = com.tencent.mobileqq.vas.pay.page.o.i(83);
        layoutParams3.topToTop = 0;
        this.qSVipNewCustomerBg2 = com.tencent.mobileqq.vas.pay.page.o.a(this, R.id.f6550394, layoutParams3, new Function0<View>() { // from class: com.tencent.mobileqq.vas.pay.newcustomer.QVipUserInfoCard$qSVipNewCustomerBg2$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final View invoke() {
                return com.tencent.mobileqq.vas.pay.page.o.w(QVipUserInfoCard.this, new Function1<View, Unit>() { // from class: com.tencent.mobileqq.vas.pay.newcustomer.QVipUserInfoCard$qSVipNewCustomerBg2$2.1
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(View view) {
                        invoke2(view);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull View view) {
                        Intrinsics.checkNotNullParameter(view, "$this$view");
                        Drawable drawable = view.getContext().getDrawable(R.drawable.l7w);
                        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
                        obtain.mFailedDrawable = drawable;
                        obtain.mLoadingDrawable = drawable;
                        view.setBackground(URLDrawable.getDrawable("https://tianquan.gtimg.cn/shoal/vaclient/6e7f6ec4-0687-402f-a097-e55971148669.png", obtain));
                    }
                });
            }
        });
        ConstraintLayout.LayoutParams layoutParams4 = new ConstraintLayout.LayoutParams(com.tencent.mobileqq.vas.pay.page.o.i(40), com.tencent.mobileqq.vas.pay.page.o.i(40));
        layoutParams4.startToStart = 0;
        layoutParams4.topToTop = 0;
        layoutParams4.setMarginStart(com.tencent.mobileqq.vas.pay.page.o.i(30));
        ((ViewGroup.MarginLayoutParams) layoutParams4).topMargin = com.tencent.mobileqq.vas.pay.page.o.i(30);
        this.qSvipNewCustomerHeadIv = (RoundRectImageView) com.tencent.mobileqq.vas.pay.page.o.a(this, R.id.f6553397, layoutParams4, new Function0<RoundRectImageView>() { // from class: com.tencent.mobileqq.vas.pay.newcustomer.QVipUserInfoCard$qSvipNewCustomerHeadIv$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final RoundRectImageView invoke() {
                return com.tencent.mobileqq.vas.pay.page.o.t(QVipUserInfoCard.this, new Function1<RoundRectImageView, Unit>() { // from class: com.tencent.mobileqq.vas.pay.newcustomer.QVipUserInfoCard$qSvipNewCustomerHeadIv$2.1
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(RoundRectImageView roundRectImageView) {
                        invoke2(roundRectImageView);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull RoundRectImageView roundImage) {
                        Intrinsics.checkNotNullParameter(roundImage, "$this$roundImage");
                        roundImage.setCornerRadiusAndMode(com.tencent.mobileqq.vas.pay.page.o.i(20), 1);
                    }
                });
            }
        });
        ConstraintLayout.LayoutParams layoutParams5 = new ConstraintLayout.LayoutParams(-2, -2);
        layoutParams5.setMarginStart(com.tencent.mobileqq.vas.pay.page.o.i(8));
        layoutParams5.topToTop = R.id.f6553397;
        layoutParams5.startToEnd = R.id.f6553397;
        layoutParams5.horizontalChainStyle = 2;
        this.qSvipNewCustomerUserName = (TextView) com.tencent.mobileqq.vas.pay.page.o.a(this, R.id.f656739k, layoutParams5, new Function0<TextView>() { // from class: com.tencent.mobileqq.vas.pay.newcustomer.QVipUserInfoCard$qSvipNewCustomerUserName$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final TextView invoke() {
                return com.tencent.mobileqq.vas.pay.page.o.v(QVipUserInfoCard.this, new Function1<TextView, Unit>() { // from class: com.tencent.mobileqq.vas.pay.newcustomer.QVipUserInfoCard$qSvipNewCustomerUserName$2.1
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(TextView textView) {
                        invoke2(textView);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull TextView text) {
                        Intrinsics.checkNotNullParameter(text, "$this$text");
                        text.getPaint().setFakeBoldText(true);
                        text.setTextColor(Color.parseColor("#8F5600"));
                        text.setMaxLines(1);
                        text.setSingleLine(true);
                        text.setMaxWidth(com.tencent.mobileqq.vas.pay.page.o.i(128));
                        text.setEllipsize(TextUtils.TruncateAt.END);
                        text.setTextSize(com.tencent.mobileqq.vas.pay.page.o.u(16));
                    }
                });
            }
        });
        ConstraintLayout.LayoutParams layoutParams6 = new ConstraintLayout.LayoutParams(-2, com.tencent.mobileqq.vas.pay.page.o.i(15));
        layoutParams6.setMarginStart(com.tencent.mobileqq.vas.pay.page.o.i(8));
        layoutParams6.startToEnd = R.id.f6553397;
        layoutParams6.bottomToBottom = R.id.f6553397;
        this.qSvipNewCustomerVipNamePlate = (ImageView) com.tencent.mobileqq.vas.pay.page.o.a(this, R.id.f6554398, layoutParams6, new Function0<ImageView>() { // from class: com.tencent.mobileqq.vas.pay.newcustomer.QVipUserInfoCard$qSvipNewCustomerVipNamePlate$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final ImageView invoke() {
                return com.tencent.mobileqq.vas.pay.page.o.m(QVipUserInfoCard.this, new Function1<ImageView, Unit>() { // from class: com.tencent.mobileqq.vas.pay.newcustomer.QVipUserInfoCard$qSvipNewCustomerVipNamePlate$2.1
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(ImageView imageView) {
                        invoke2(imageView);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull ImageView image) {
                        Intrinsics.checkNotNullParameter(image, "$this$image");
                        image.setBackgroundColor(Color.parseColor("#00000001"));
                    }
                });
            }
        });
        ConstraintLayout.LayoutParams layoutParams7 = new ConstraintLayout.LayoutParams(com.tencent.mobileqq.vas.pay.page.o.i(79), com.tencent.mobileqq.vas.pay.page.o.i(29));
        layoutParams7.setMarginEnd(com.tencent.mobileqq.vas.pay.page.o.i(30));
        ((ViewGroup.MarginLayoutParams) layoutParams7).topMargin = com.tencent.mobileqq.vas.pay.page.o.i(40);
        layoutParams7.topToTop = 0;
        layoutParams7.endToEnd = 0;
        this.qSvipNewCustomerPayBtn = (TextView) com.tencent.mobileqq.vas.pay.page.o.a(this, R.id.f656339g, layoutParams7, new Function0<TextView>() { // from class: com.tencent.mobileqq.vas.pay.newcustomer.QVipUserInfoCard$qSvipNewCustomerPayBtn$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final TextView invoke() {
                return com.tencent.mobileqq.vas.pay.page.o.v(QVipUserInfoCard.this, new Function1<TextView, Unit>() { // from class: com.tencent.mobileqq.vas.pay.newcustomer.QVipUserInfoCard$qSvipNewCustomerPayBtn$2.1
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(TextView textView) {
                        invoke2(textView);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull TextView text) {
                        Intrinsics.checkNotNullParameter(text, "$this$text");
                        text.setVisibility(8);
                        text.setTextColor(com.tencent.mobileqq.vas.pay.page.o.g(Color.parseColor("#8F5600"), 0, 2, null));
                        text.setBackgroundResource(R.drawable.f162031l81);
                        text.setGravity(17);
                    }
                });
            }
        });
        ConstraintLayout.LayoutParams layoutParams8 = new ConstraintLayout.LayoutParams(com.tencent.mobileqq.vas.pay.page.o.i(3), com.tencent.mobileqq.vas.pay.page.o.i(3));
        layoutParams8.endToStart = R.id.f656339g;
        layoutParams8.topToTop = R.id.f656339g;
        this.qSvipViewHolder = com.tencent.mobileqq.vas.pay.page.o.a(this, R.id.f656439h, layoutParams8, new Function0<View>() { // from class: com.tencent.mobileqq.vas.pay.newcustomer.QVipUserInfoCard$qSvipViewHolder$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final View invoke() {
                return com.tencent.mobileqq.vas.pay.page.o.w(QVipUserInfoCard.this, new Function1<View, Unit>() { // from class: com.tencent.mobileqq.vas.pay.newcustomer.QVipUserInfoCard$qSvipViewHolder$2.1
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(View view) {
                        invoke2(view);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull View view) {
                        Intrinsics.checkNotNullParameter(view, "$this$view");
                        view.setBackgroundColor(Color.parseColor("#00000001"));
                    }
                });
            }
        });
        ConstraintLayout.LayoutParams layoutParams9 = new ConstraintLayout.LayoutParams(-2, com.tencent.mobileqq.vas.pay.page.o.i(20));
        layoutParams9.startToStart = R.id.f656439h;
        layoutParams9.bottomToBottom = R.id.f656339g;
        ((ViewGroup.MarginLayoutParams) layoutParams9).topMargin = com.tencent.mobileqq.vas.pay.page.o.i(7);
        ((ViewGroup.MarginLayoutParams) layoutParams9).bottomMargin = com.tencent.mobileqq.vas.pay.page.o.i(19);
        this.qSvipNewCustomerRedFlag = (TextView) com.tencent.mobileqq.vas.pay.page.o.a(this, R.id.f656239f, layoutParams9, new Function0<TextView>() { // from class: com.tencent.mobileqq.vas.pay.newcustomer.QVipUserInfoCard$qSvipNewCustomerRedFlag$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final TextView invoke() {
                return com.tencent.mobileqq.vas.pay.page.o.v(QVipUserInfoCard.this, new Function1<TextView, Unit>() { // from class: com.tencent.mobileqq.vas.pay.newcustomer.QVipUserInfoCard$qSvipNewCustomerRedFlag$2.1
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(TextView textView) {
                        invoke2(textView);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull TextView text) {
                        Intrinsics.checkNotNullParameter(text, "$this$text");
                        com.tencent.mobileqq.vas.pay.page.o.p(text, com.tencent.mobileqq.vas.pay.page.o.i(3));
                        com.tencent.mobileqq.vas.pay.page.o.q(text, com.tencent.mobileqq.vas.pay.page.o.i(2));
                        text.setGravity(17);
                        text.setTextSize(com.tencent.mobileqq.vas.pay.page.o.u(10));
                        text.setMaxLines(1);
                        text.setMaxWidth(com.tencent.mobileqq.vas.pay.page.o.i(55));
                        text.setTextColor(com.tencent.mobileqq.vas.pay.page.o.g(-1, 0, 2, null));
                        text.setIncludeFontPadding(false);
                        text.setEllipsize(TextUtils.TruncateAt.END);
                        text.setBackground(new AbsAsyncDrawable() { // from class: com.tencent.mobileqq.vas.pay.newcustomer.QVipUserInfoCard$qSvipNewCustomerRedFlag$2$1$d$1
                            /* JADX INFO: Access modifiers changed from: package-private */
                            {
                                setSupportNinePath(true);
                                setTargetDrawableBuild(new Function0<URLDrawable>() { // from class: com.tencent.mobileqq.vas.pay.newcustomer.QVipUserInfoCard$qSvipNewCustomerRedFlag$2$1$d$1.1
                                    /* JADX WARN: Can't rename method to resolve collision */
                                    @Override // kotlin.jvm.functions.Function0
                                    public final URLDrawable invoke() {
                                        return URLDrawable.getDrawable(com.tencent.mobileqq.vas.pay.page.j.INSTANCE.k());
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
        ConstraintLayout.LayoutParams layoutParams10 = new ConstraintLayout.LayoutParams(-2, -2);
        layoutParams10.bottomToBottom = 0;
        layoutParams10.startToStart = 0;
        layoutParams10.endToEnd = 0;
        ((ViewGroup.MarginLayoutParams) layoutParams10).bottomMargin = com.tencent.mobileqq.vas.pay.page.o.i(38);
        this.qSvipNewCustomerPayTitle = (TextView) com.tencent.mobileqq.vas.pay.page.o.a(this, R.id.f656139e, layoutParams10, new Function0<TextView>() { // from class: com.tencent.mobileqq.vas.pay.newcustomer.QVipUserInfoCard$qSvipNewCustomerPayTitle$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final TextView invoke() {
                return com.tencent.mobileqq.vas.pay.page.o.v(QVipUserInfoCard.this, new Function1<TextView, Unit>() { // from class: com.tencent.mobileqq.vas.pay.newcustomer.QVipUserInfoCard$qSvipNewCustomerPayTitle$2.1
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(TextView textView) {
                        invoke2(textView);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull TextView text) {
                        Intrinsics.checkNotNullParameter(text, "$this$text");
                        text.setTextColor(com.tencent.mobileqq.vas.pay.page.o.g(Color.parseColor("#FFEBC5"), 0, 2, null));
                        text.setTextSize(com.tencent.mobileqq.vas.pay.page.o.u(16));
                    }
                });
            }
        });
        ConstraintLayout.LayoutParams layoutParams11 = new ConstraintLayout.LayoutParams(-2, -2);
        layoutParams11.bottomToBottom = 0;
        layoutParams11.startToStart = 0;
        layoutParams11.endToEnd = 0;
        layoutParams11.topToBottom = R.id.f656139e;
        ((ViewGroup.MarginLayoutParams) layoutParams11).bottomMargin = com.tencent.mobileqq.vas.pay.page.o.i(17);
        ((ViewGroup.MarginLayoutParams) layoutParams11).topMargin = com.tencent.mobileqq.vas.pay.page.o.i(3);
        this.qSvipNewCustomerPaySubtitle = (TextView) com.tencent.mobileqq.vas.pay.page.o.a(this, R.id.f656039d, layoutParams11, new Function0<TextView>() { // from class: com.tencent.mobileqq.vas.pay.newcustomer.QVipUserInfoCard$qSvipNewCustomerPaySubtitle$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final TextView invoke() {
                return com.tencent.mobileqq.vas.pay.page.o.v(QVipUserInfoCard.this, new Function1<TextView, Unit>() { // from class: com.tencent.mobileqq.vas.pay.newcustomer.QVipUserInfoCard$qSvipNewCustomerPaySubtitle$2.1
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(TextView textView) {
                        invoke2(textView);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull TextView text) {
                        Intrinsics.checkNotNullParameter(text, "$this$text");
                        text.setTextColor(com.tencent.mobileqq.vas.pay.page.o.g(Color.parseColor("#99FFFFFF"), 0, 2, null));
                        text.setTextSize(com.tencent.mobileqq.vas.pay.page.o.u(12));
                    }
                });
            }
        });
        ConstraintLayout.LayoutParams layoutParams12 = new ConstraintLayout.LayoutParams(-2, com.tencent.mobileqq.vas.pay.page.o.i(29));
        layoutParams12.bottomToBottom = 0;
        layoutParams12.startToStart = 0;
        layoutParams12.endToEnd = 0;
        ((ViewGroup.MarginLayoutParams) layoutParams12).bottomMargin = com.tencent.mobileqq.vas.pay.page.o.i(32);
        this.qSvipNewCustomerPayGetExperienceBtn = (TextView) com.tencent.mobileqq.vas.pay.page.o.a(this, R.id.f6555399, layoutParams12, new Function0<TextView>() { // from class: com.tencent.mobileqq.vas.pay.newcustomer.QVipUserInfoCard$qSvipNewCustomerPayGetExperienceBtn$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final TextView invoke() {
                return com.tencent.mobileqq.vas.pay.page.o.v(QVipUserInfoCard.this, new Function1<TextView, Unit>() { // from class: com.tencent.mobileqq.vas.pay.newcustomer.QVipUserInfoCard$qSvipNewCustomerPayGetExperienceBtn$2.1
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(TextView textView) {
                        invoke2(textView);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull TextView text) {
                        Intrinsics.checkNotNullParameter(text, "$this$text");
                        text.setPadding(com.tencent.mobileqq.vas.pay.page.o.i(16), 0, com.tencent.mobileqq.vas.pay.page.o.i(16), 0);
                        text.setVisibility(8);
                        text.setGravity(17);
                        text.setTextColor(com.tencent.mobileqq.vas.pay.page.o.g(Color.parseColor("#9A6310"), 0, 2, null));
                        text.setBackgroundResource(R.drawable.l7s);
                        text.setTextSize(com.tencent.mobileqq.vas.pay.page.o.u(14));
                    }
                });
            }
        });
        ConstraintLayout.LayoutParams layoutParams13 = new ConstraintLayout.LayoutParams(-2, -2);
        layoutParams13.bottomToBottom = 0;
        layoutParams13.startToStart = 0;
        layoutParams13.endToEnd = 0;
        ((ViewGroup.MarginLayoutParams) layoutParams13).bottomMargin = com.tencent.mobileqq.vas.pay.page.o.i(14);
        this.qSvipNewCustomerPayCountdown = (TextView) com.tencent.mobileqq.vas.pay.page.o.a(this, R.id.f656039d, layoutParams13, new Function0<TextView>() { // from class: com.tencent.mobileqq.vas.pay.newcustomer.QVipUserInfoCard$qSvipNewCustomerPayCountdown$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final TextView invoke() {
                return com.tencent.mobileqq.vas.pay.page.o.v(QVipUserInfoCard.this, new Function1<TextView, Unit>() { // from class: com.tencent.mobileqq.vas.pay.newcustomer.QVipUserInfoCard$qSvipNewCustomerPayCountdown$2.1
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(TextView textView) {
                        invoke2(textView);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull TextView text) {
                        Intrinsics.checkNotNullParameter(text, "$this$text");
                        text.setVisibility(8);
                        text.setTextColor(com.tencent.mobileqq.vas.pay.page.o.g(Color.parseColor("#99FFFFFF"), 0, 2, null));
                        text.setTextSize(com.tencent.mobileqq.vas.pay.page.o.u(10));
                    }
                });
            }
        });
        E0();
    }
}
