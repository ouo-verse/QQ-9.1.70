package com.tencent.mobileqq.vas.pay.page;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vip.api.IVipIconUtils;
import com.tencent.util.AppSetting;
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

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 -2\u00020\u0001:\u0001.B\u0011\b\u0016\u0012\u0006\u0010%\u001a\u00020$\u00a2\u0006\u0004\b&\u0010'B\u001b\b\u0016\u0012\u0006\u0010%\u001a\u00020$\u0012\b\u0010)\u001a\u0004\u0018\u00010(\u00a2\u0006\u0004\b&\u0010*B#\b\u0016\u0012\u0006\u0010%\u001a\u00020$\u0012\b\u0010)\u001a\u0004\u0018\u00010(\u0012\u0006\u0010+\u001a\u00020\u0002\u00a2\u0006\u0004\b&\u0010,J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\b\u001a\u00020\u0004H\u0002J\u0006\u0010\t\u001a\u00020\u0004J\u0006\u0010\n\u001a\u00020\u0004J\u0018\u0010\u000e\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000b2\b\b\u0001\u0010\r\u001a\u00020\u0002J\u000e\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000fR\u0014\u0010\u0015\u001a\u00020\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0019\u001a\u00020\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0014\u0010\u001b\u001a\u00020\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u0018R\u0014\u0010\u001f\u001a\u00020\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0014\u0010#\u001a\u00020 8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b!\u0010\"\u00a8\u0006/"}, d2 = {"Lcom/tencent/mobileqq/vas/pay/page/QvipRenewalPersonalInfo;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "", "refreshTimes", "", "D0", "", "A0", "C0", "initView", "setNamePlate", "Landroid/text/SpannableString;", "subtitle", "color", "setUserSubtitleInfo", "Landroid/view/View$OnClickListener;", "click", "setSubtitleClickListener", "Lcom/tencent/widget/RoundRectImageView;", "d", "Lcom/tencent/widget/RoundRectImageView;", "qvipRenewalHeadIv", "Landroid/widget/TextView;", "e", "Landroid/widget/TextView;", "qvipRenewalUserName", "f", "qvipRenewalUserSubtitleInfo", "Landroid/widget/ImageView;", tl.h.F, "Landroid/widget/ImageView;", "qvipRenewalVipNamePlate", "Landroid/view/View;", "i", "Landroid/view/View;", "spaceHolder", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "a", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class QvipRenewalPersonalInfo extends ConstraintLayout {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final RoundRectImageView qvipRenewalHeadIv;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final TextView qvipRenewalUserName;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final TextView qvipRenewalUserSubtitleInfo;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ImageView qvipRenewalVipNamePlate;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final View spaceHolder;
    private static final boolean C = AppSetting.isDebugVersion();

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QvipRenewalPersonalInfo(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(o.i(40), o.i(40));
        layoutParams.startToStart = 0;
        Unit unit = Unit.INSTANCE;
        this.qvipRenewalHeadIv = (RoundRectImageView) o.a(this, R.id.f66903bw, layoutParams, new Function0<RoundRectImageView>() { // from class: com.tencent.mobileqq.vas.pay.page.QvipRenewalPersonalInfo$qvipRenewalHeadIv$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final RoundRectImageView invoke() {
                return o.t(QvipRenewalPersonalInfo.this, new Function1<RoundRectImageView, Unit>() { // from class: com.tencent.mobileqq.vas.pay.page.QvipRenewalPersonalInfo$qvipRenewalHeadIv$2.1
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(RoundRectImageView roundRectImageView) {
                        invoke2(roundRectImageView);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull RoundRectImageView roundImage) {
                        Intrinsics.checkNotNullParameter(roundImage, "$this$roundImage");
                        roundImage.setCornerRadiusAndMode(o.i(20), 1);
                    }
                });
            }
        });
        ConstraintLayout.LayoutParams layoutParams2 = new ConstraintLayout.LayoutParams(-2, -2);
        layoutParams2.setMarginStart(o.i(8));
        layoutParams2.startToEnd = R.id.f66903bw;
        layoutParams2.endToStart = R.id.f66963c2;
        layoutParams2.horizontalChainStyle = 2;
        this.qvipRenewalUserName = (TextView) o.a(this, R.id.f67133ci, layoutParams2, new Function0<TextView>() { // from class: com.tencent.mobileqq.vas.pay.page.QvipRenewalPersonalInfo$qvipRenewalUserName$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final TextView invoke() {
                return o.v(QvipRenewalPersonalInfo.this, new Function1<TextView, Unit>() { // from class: com.tencent.mobileqq.vas.pay.page.QvipRenewalPersonalInfo$qvipRenewalUserName$2.1
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(TextView textView) {
                        invoke2(textView);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull TextView text) {
                        Intrinsics.checkNotNullParameter(text, "$this$text");
                        text.setTextColor(Color.parseColor("#8F5600"));
                        text.setMaxLines(1);
                        text.setSingleLine(true);
                        text.setMaxWidth((((ViewUtils.getScreenWidth() - (o.i(16) * 2)) - o.i(40)) - (o.i(8) * 2)) - o.i(55));
                        text.setEllipsize(TextUtils.TruncateAt.END);
                        text.setTextSize(o.u(16));
                    }
                });
            }
        });
        ConstraintLayout.LayoutParams layoutParams3 = new ConstraintLayout.LayoutParams(-2, -2);
        layoutParams3.setMarginStart(o.i(8));
        ((ViewGroup.MarginLayoutParams) layoutParams3).topMargin = o.i(2);
        layoutParams3.startToEnd = R.id.f66903bw;
        layoutParams3.topToBottom = R.id.f67133ci;
        this.qvipRenewalUserSubtitleInfo = (TextView) o.c(this, layoutParams3, new Function0<TextView>() { // from class: com.tencent.mobileqq.vas.pay.page.QvipRenewalPersonalInfo$qvipRenewalUserSubtitleInfo$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final TextView invoke() {
                return o.v(QvipRenewalPersonalInfo.this, new Function1<TextView, Unit>() { // from class: com.tencent.mobileqq.vas.pay.page.QvipRenewalPersonalInfo$qvipRenewalUserSubtitleInfo$2.1
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(TextView textView) {
                        invoke2(textView);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull TextView text) {
                        Intrinsics.checkNotNullParameter(text, "$this$text");
                        text.setTextSize(o.u(10));
                        text.setTextColor(o.g(Color.parseColor("#999999"), 0, 2, null));
                    }
                });
            }
        });
        ConstraintLayout.LayoutParams layoutParams4 = new ConstraintLayout.LayoutParams(-2, o.i(15));
        layoutParams4.startToEnd = R.id.f67133ci;
        layoutParams4.endToEnd = R.id.f67153ck;
        layoutParams4.topToTop = R.id.f67133ci;
        layoutParams4.bottomToBottom = R.id.f67133ci;
        layoutParams4.setMarginStart(o.i(8));
        this.qvipRenewalVipNamePlate = (ImageView) o.a(this, R.id.f66963c2, layoutParams4, new Function0<ImageView>() { // from class: com.tencent.mobileqq.vas.pay.page.QvipRenewalPersonalInfo$qvipRenewalVipNamePlate$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final ImageView invoke() {
                return o.m(QvipRenewalPersonalInfo.this, new Function1<ImageView, Unit>() { // from class: com.tencent.mobileqq.vas.pay.page.QvipRenewalPersonalInfo$qvipRenewalVipNamePlate$2.1
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
        ConstraintLayout.LayoutParams layoutParams5 = new ConstraintLayout.LayoutParams(o.i(0), o.i(1));
        layoutParams5.startToEnd = R.id.f66963c2;
        layoutParams5.endToEnd = 0;
        layoutParams5.horizontalWeight = 1.0f;
        this.spaceHolder = o.a(this, R.id.f67153ck, layoutParams5, new Function0<View>() { // from class: com.tencent.mobileqq.vas.pay.page.QvipRenewalPersonalInfo$spaceHolder$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final View invoke() {
                return o.x(QvipRenewalPersonalInfo.this, null, 1, null);
            }
        });
        initView();
    }

    private final String A0(final int refreshTimes) {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return "";
        }
        String property = peekAppRuntime.getApplication().getProperty(Constants.PropertiesKey.nickName.toString() + peekAppRuntime.getCurrentAccountUin());
        if (refreshTimes <= 3 && TextUtils.isEmpty(property)) {
            ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.vas.pay.page.m
                @Override // java.lang.Runnable
                public final void run() {
                    QvipRenewalPersonalInfo.B0(QvipRenewalPersonalInfo.this, refreshTimes);
                }
            }, 1000L);
        }
        return property + "(" + peekAppRuntime.getCurrentAccountUin() + ")";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void B0(QvipRenewalPersonalInfo this$0, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.D0(i3 + 1);
    }

    private final void C0() {
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
        ColorDrawable colorDrawable = new ColorDrawable(o.g(0, 0, 2, null));
        AppInterface appInterface = (AppInterface) appRuntime;
        this.qvipRenewalHeadIv.setBackground(FaceDrawable.getFaceDrawable(appInterface, 1, appInterface.getCurrentAccountUin(), 3, colorDrawable, colorDrawable));
    }

    private final void D0(int refreshTimes) {
        this.qvipRenewalUserName.setText(A0(refreshTimes));
    }

    public final void initView() {
        C0();
        setNamePlate();
        D0(0);
    }

    public final void setNamePlate() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return;
        }
        IVipIconUtils api = IVipIconUtils.INSTANCE.api();
        ImageView imageView = this.qvipRenewalVipNamePlate;
        String currentAccountUin = peekAppRuntime.getCurrentAccountUin();
        Intrinsics.checkNotNullExpressionValue(currentAccountUin, "appRuntime.currentAccountUin");
        api.setVipCardDrawable(imageView, currentAccountUin);
        if (this.qvipRenewalVipNamePlate.getLayoutParams().width < o.i(40)) {
            ImageView imageView2 = this.qvipRenewalVipNamePlate;
            ViewGroup.LayoutParams layoutParams = imageView2.getLayoutParams();
            int i3 = layoutParams.height;
            layoutParams.height = o.i(15);
            layoutParams.width = (int) (((o.i(15) * 1.0f) / i3) * layoutParams.width);
            imageView2.setLayoutParams(layoutParams);
        }
    }

    public final void setSubtitleClickListener(@NotNull View.OnClickListener click) {
        Intrinsics.checkNotNullParameter(click, "click");
        this.qvipRenewalUserSubtitleInfo.setOnClickListener(click);
    }

    public final void setUserSubtitleInfo(@NotNull SpannableString subtitle, @ColorInt int color) {
        Intrinsics.checkNotNullParameter(subtitle, "subtitle");
        this.qvipRenewalUserSubtitleInfo.setText(subtitle);
        this.qvipRenewalUserSubtitleInfo.setTextColor(color);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QvipRenewalPersonalInfo(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(o.i(40), o.i(40));
        layoutParams.startToStart = 0;
        Unit unit = Unit.INSTANCE;
        this.qvipRenewalHeadIv = (RoundRectImageView) o.a(this, R.id.f66903bw, layoutParams, new Function0<RoundRectImageView>() { // from class: com.tencent.mobileqq.vas.pay.page.QvipRenewalPersonalInfo$qvipRenewalHeadIv$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final RoundRectImageView invoke() {
                return o.t(QvipRenewalPersonalInfo.this, new Function1<RoundRectImageView, Unit>() { // from class: com.tencent.mobileqq.vas.pay.page.QvipRenewalPersonalInfo$qvipRenewalHeadIv$2.1
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(RoundRectImageView roundRectImageView) {
                        invoke2(roundRectImageView);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull RoundRectImageView roundImage) {
                        Intrinsics.checkNotNullParameter(roundImage, "$this$roundImage");
                        roundImage.setCornerRadiusAndMode(o.i(20), 1);
                    }
                });
            }
        });
        ConstraintLayout.LayoutParams layoutParams2 = new ConstraintLayout.LayoutParams(-2, -2);
        layoutParams2.setMarginStart(o.i(8));
        layoutParams2.startToEnd = R.id.f66903bw;
        layoutParams2.endToStart = R.id.f66963c2;
        layoutParams2.horizontalChainStyle = 2;
        this.qvipRenewalUserName = (TextView) o.a(this, R.id.f67133ci, layoutParams2, new Function0<TextView>() { // from class: com.tencent.mobileqq.vas.pay.page.QvipRenewalPersonalInfo$qvipRenewalUserName$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final TextView invoke() {
                return o.v(QvipRenewalPersonalInfo.this, new Function1<TextView, Unit>() { // from class: com.tencent.mobileqq.vas.pay.page.QvipRenewalPersonalInfo$qvipRenewalUserName$2.1
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(TextView textView) {
                        invoke2(textView);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull TextView text) {
                        Intrinsics.checkNotNullParameter(text, "$this$text");
                        text.setTextColor(Color.parseColor("#8F5600"));
                        text.setMaxLines(1);
                        text.setSingleLine(true);
                        text.setMaxWidth((((ViewUtils.getScreenWidth() - (o.i(16) * 2)) - o.i(40)) - (o.i(8) * 2)) - o.i(55));
                        text.setEllipsize(TextUtils.TruncateAt.END);
                        text.setTextSize(o.u(16));
                    }
                });
            }
        });
        ConstraintLayout.LayoutParams layoutParams3 = new ConstraintLayout.LayoutParams(-2, -2);
        layoutParams3.setMarginStart(o.i(8));
        ((ViewGroup.MarginLayoutParams) layoutParams3).topMargin = o.i(2);
        layoutParams3.startToEnd = R.id.f66903bw;
        layoutParams3.topToBottom = R.id.f67133ci;
        this.qvipRenewalUserSubtitleInfo = (TextView) o.c(this, layoutParams3, new Function0<TextView>() { // from class: com.tencent.mobileqq.vas.pay.page.QvipRenewalPersonalInfo$qvipRenewalUserSubtitleInfo$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final TextView invoke() {
                return o.v(QvipRenewalPersonalInfo.this, new Function1<TextView, Unit>() { // from class: com.tencent.mobileqq.vas.pay.page.QvipRenewalPersonalInfo$qvipRenewalUserSubtitleInfo$2.1
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(TextView textView) {
                        invoke2(textView);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull TextView text) {
                        Intrinsics.checkNotNullParameter(text, "$this$text");
                        text.setTextSize(o.u(10));
                        text.setTextColor(o.g(Color.parseColor("#999999"), 0, 2, null));
                    }
                });
            }
        });
        ConstraintLayout.LayoutParams layoutParams4 = new ConstraintLayout.LayoutParams(-2, o.i(15));
        layoutParams4.startToEnd = R.id.f67133ci;
        layoutParams4.endToEnd = R.id.f67153ck;
        layoutParams4.topToTop = R.id.f67133ci;
        layoutParams4.bottomToBottom = R.id.f67133ci;
        layoutParams4.setMarginStart(o.i(8));
        this.qvipRenewalVipNamePlate = (ImageView) o.a(this, R.id.f66963c2, layoutParams4, new Function0<ImageView>() { // from class: com.tencent.mobileqq.vas.pay.page.QvipRenewalPersonalInfo$qvipRenewalVipNamePlate$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final ImageView invoke() {
                return o.m(QvipRenewalPersonalInfo.this, new Function1<ImageView, Unit>() { // from class: com.tencent.mobileqq.vas.pay.page.QvipRenewalPersonalInfo$qvipRenewalVipNamePlate$2.1
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
        ConstraintLayout.LayoutParams layoutParams5 = new ConstraintLayout.LayoutParams(o.i(0), o.i(1));
        layoutParams5.startToEnd = R.id.f66963c2;
        layoutParams5.endToEnd = 0;
        layoutParams5.horizontalWeight = 1.0f;
        this.spaceHolder = o.a(this, R.id.f67153ck, layoutParams5, new Function0<View>() { // from class: com.tencent.mobileqq.vas.pay.page.QvipRenewalPersonalInfo$spaceHolder$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final View invoke() {
                return o.x(QvipRenewalPersonalInfo.this, null, 1, null);
            }
        });
        initView();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QvipRenewalPersonalInfo(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(o.i(40), o.i(40));
        layoutParams.startToStart = 0;
        Unit unit = Unit.INSTANCE;
        this.qvipRenewalHeadIv = (RoundRectImageView) o.a(this, R.id.f66903bw, layoutParams, new Function0<RoundRectImageView>() { // from class: com.tencent.mobileqq.vas.pay.page.QvipRenewalPersonalInfo$qvipRenewalHeadIv$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final RoundRectImageView invoke() {
                return o.t(QvipRenewalPersonalInfo.this, new Function1<RoundRectImageView, Unit>() { // from class: com.tencent.mobileqq.vas.pay.page.QvipRenewalPersonalInfo$qvipRenewalHeadIv$2.1
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(RoundRectImageView roundRectImageView) {
                        invoke2(roundRectImageView);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull RoundRectImageView roundImage) {
                        Intrinsics.checkNotNullParameter(roundImage, "$this$roundImage");
                        roundImage.setCornerRadiusAndMode(o.i(20), 1);
                    }
                });
            }
        });
        ConstraintLayout.LayoutParams layoutParams2 = new ConstraintLayout.LayoutParams(-2, -2);
        layoutParams2.setMarginStart(o.i(8));
        layoutParams2.startToEnd = R.id.f66903bw;
        layoutParams2.endToStart = R.id.f66963c2;
        layoutParams2.horizontalChainStyle = 2;
        this.qvipRenewalUserName = (TextView) o.a(this, R.id.f67133ci, layoutParams2, new Function0<TextView>() { // from class: com.tencent.mobileqq.vas.pay.page.QvipRenewalPersonalInfo$qvipRenewalUserName$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final TextView invoke() {
                return o.v(QvipRenewalPersonalInfo.this, new Function1<TextView, Unit>() { // from class: com.tencent.mobileqq.vas.pay.page.QvipRenewalPersonalInfo$qvipRenewalUserName$2.1
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(TextView textView) {
                        invoke2(textView);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull TextView text) {
                        Intrinsics.checkNotNullParameter(text, "$this$text");
                        text.setTextColor(Color.parseColor("#8F5600"));
                        text.setMaxLines(1);
                        text.setSingleLine(true);
                        text.setMaxWidth((((ViewUtils.getScreenWidth() - (o.i(16) * 2)) - o.i(40)) - (o.i(8) * 2)) - o.i(55));
                        text.setEllipsize(TextUtils.TruncateAt.END);
                        text.setTextSize(o.u(16));
                    }
                });
            }
        });
        ConstraintLayout.LayoutParams layoutParams3 = new ConstraintLayout.LayoutParams(-2, -2);
        layoutParams3.setMarginStart(o.i(8));
        ((ViewGroup.MarginLayoutParams) layoutParams3).topMargin = o.i(2);
        layoutParams3.startToEnd = R.id.f66903bw;
        layoutParams3.topToBottom = R.id.f67133ci;
        this.qvipRenewalUserSubtitleInfo = (TextView) o.c(this, layoutParams3, new Function0<TextView>() { // from class: com.tencent.mobileqq.vas.pay.page.QvipRenewalPersonalInfo$qvipRenewalUserSubtitleInfo$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final TextView invoke() {
                return o.v(QvipRenewalPersonalInfo.this, new Function1<TextView, Unit>() { // from class: com.tencent.mobileqq.vas.pay.page.QvipRenewalPersonalInfo$qvipRenewalUserSubtitleInfo$2.1
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(TextView textView) {
                        invoke2(textView);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull TextView text) {
                        Intrinsics.checkNotNullParameter(text, "$this$text");
                        text.setTextSize(o.u(10));
                        text.setTextColor(o.g(Color.parseColor("#999999"), 0, 2, null));
                    }
                });
            }
        });
        ConstraintLayout.LayoutParams layoutParams4 = new ConstraintLayout.LayoutParams(-2, o.i(15));
        layoutParams4.startToEnd = R.id.f67133ci;
        layoutParams4.endToEnd = R.id.f67153ck;
        layoutParams4.topToTop = R.id.f67133ci;
        layoutParams4.bottomToBottom = R.id.f67133ci;
        layoutParams4.setMarginStart(o.i(8));
        this.qvipRenewalVipNamePlate = (ImageView) o.a(this, R.id.f66963c2, layoutParams4, new Function0<ImageView>() { // from class: com.tencent.mobileqq.vas.pay.page.QvipRenewalPersonalInfo$qvipRenewalVipNamePlate$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final ImageView invoke() {
                return o.m(QvipRenewalPersonalInfo.this, new Function1<ImageView, Unit>() { // from class: com.tencent.mobileqq.vas.pay.page.QvipRenewalPersonalInfo$qvipRenewalVipNamePlate$2.1
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
        ConstraintLayout.LayoutParams layoutParams5 = new ConstraintLayout.LayoutParams(o.i(0), o.i(1));
        layoutParams5.startToEnd = R.id.f66963c2;
        layoutParams5.endToEnd = 0;
        layoutParams5.horizontalWeight = 1.0f;
        this.spaceHolder = o.a(this, R.id.f67153ck, layoutParams5, new Function0<View>() { // from class: com.tencent.mobileqq.vas.pay.page.QvipRenewalPersonalInfo$spaceHolder$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final View invoke() {
                return o.x(QvipRenewalPersonalInfo.this, null, 1, null);
            }
        });
        initView();
    }
}
