package com.tencent.mobileqq.vas.pay.page;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.tencent.aelight.camera.constants.AECameraConstants;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.pay.api.impl.VasNativePayManagerImpl;
import com.tencent.mobileqq.vas.webview.util.VasWebviewUtil;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 22\u00020\u0001:\u00013B\u0011\b\u0016\u0012\u0006\u0010*\u001a\u00020)\u00a2\u0006\u0004\b+\u0010,B\u001b\b\u0016\u0012\u0006\u0010*\u001a\u00020)\u0012\b\u0010.\u001a\u0004\u0018\u00010-\u00a2\u0006\u0004\b+\u0010/B#\b\u0016\u0012\u0006\u0010*\u001a\u00020)\u0012\b\u0010.\u001a\u0004\u0018\u00010-\u0012\u0006\u00100\u001a\u00020\u0004\u00a2\u0006\u0004\b+\u00101J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0004H\u0002J\u0010\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0004H\u0002J\u0018\u0010\u000f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\fH\u0002J\u0006\u0010\u0011\u001a\u00020\u0010J\u000e\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0004J\u000e\u0010\u0015\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\u0004J\u0014\u0010\u0018\u001a\u00020\u00102\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00100\u0016J\u0016\u0010\u0019\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\fR\u001c\u0010\u001e\u001a\n \u001b*\u0004\u0018\u00010\u001a0\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0014\u0010\"\u001a\u00020\u001f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0014\u0010$\u001a\u00020\u001f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b#\u0010!R\u0014\u0010&\u001a\u00020\u001f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b%\u0010!R\u0014\u0010(\u001a\u00020\u001f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b'\u0010!\u00a8\u00064"}, d2 = {"Lcom/tencent/mobileqq/vas/pay/page/QVipPayItem;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "", "F0", "", "saveMoney", "Landroid/text/SpannableString;", "E0", "price", "B0", "payDisplay", "C0", "", "jumpUrl1", "jumpUrl2", "D0", "", "initView", "setSaveMoney", "originPrice", "setOriginPrice", "setPayDisplayText", "Lkotlin/Function0;", "click", "setPayOnClickListener", "setPayProtocol", "Landroid/graphics/Typeface;", "kotlin.jvm.PlatformType", "d", "Landroid/graphics/Typeface;", "numTypeface", "Landroid/widget/TextView;", "e", "Landroid/widget/TextView;", "saveMoneyTv", "f", "originalPriceTv", tl.h.F, "startPayBtn", "i", "payProtocol", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "a", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class QVipPayItem extends ConstraintLayout {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final Typeface numTypeface;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final TextView saveMoneyTv;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final TextView originalPriceTv;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final TextView startPayBtn;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final TextView payProtocol;

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/vas/pay/page/QVipPayItem$b", "Landroid/text/style/ClickableSpan;", "Landroid/text/TextPaint;", "ds", "", "updateDrawState", "Landroid/view/View;", AECameraConstants.HOT_ENTRY_TYPE_WIDGET, NodeProps.ON_CLICK, "vas-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public static final class b extends ClickableSpan {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f310325d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ QVipPayItem f310326e;

        b(String str, QVipPayItem qVipPayItem) {
            this.f310325d = str;
            this.f310326e = qVipPayItem;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(@NotNull View widget) {
            Intrinsics.checkNotNullParameter(widget, "widget");
            QLog.i("QVipPayItem", 1, "click vip protocol: " + this.f310325d);
            Intent intent = new Intent(this.f310326e.getContext(), (Class<?>) QQBrowserActivity.class);
            intent.setFlags(268435456);
            VasWebviewUtil.openQQBrowserActivity(this.f310326e.getContext(), this.f310325d, -1L, intent, false, -1);
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(@NotNull TextPaint ds5) {
            Intrinsics.checkNotNullParameter(ds5, "ds");
            ds5.setUnderlineText(false);
            ds5.clearShadowLayer();
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/vas/pay/page/QVipPayItem$c", "Landroid/text/style/ClickableSpan;", "Landroid/text/TextPaint;", "ds", "", "updateDrawState", "Landroid/view/View;", AECameraConstants.HOT_ENTRY_TYPE_WIDGET, NodeProps.ON_CLICK, "vas-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public static final class c extends ClickableSpan {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f310327d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ QVipPayItem f310328e;

        c(String str, QVipPayItem qVipPayItem) {
            this.f310327d = str;
            this.f310328e = qVipPayItem;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(@NotNull View widget) {
            Intrinsics.checkNotNullParameter(widget, "widget");
            QLog.i("QVipPayItem", 1, "click auto renewal protocol: " + this.f310327d);
            Intent intent = new Intent(this.f310328e.getContext(), (Class<?>) QQBrowserActivity.class);
            intent.setFlags(268435456);
            VasWebviewUtil.openQQBrowserActivity(this.f310328e.getContext(), this.f310327d, -1L, intent, false, -1);
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(@NotNull TextPaint ds5) {
            Intrinsics.checkNotNullParameter(ds5, "ds");
            ds5.setUnderlineText(false);
            ds5.clearShadowLayer();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QVipPayItem(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.numTypeface = Typeface.createFromAsset(getContext().getResources().getAssets(), VasNativePayManagerImpl.DINALTERNATE_BOLD_FONT_PATH);
        ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(-2, -2);
        ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = o.i(16);
        layoutParams.setMarginStart(o.i(16));
        layoutParams.topToTop = 0;
        layoutParams.startToStart = 0;
        Unit unit = Unit.INSTANCE;
        this.saveMoneyTv = (TextView) o.a(this, R.id.f67023c8, layoutParams, new Function0<TextView>() { // from class: com.tencent.mobileqq.vas.pay.page.QVipPayItem$saveMoneyTv$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final TextView invoke() {
                return o.v(QVipPayItem.this, new Function1<TextView, Unit>() { // from class: com.tencent.mobileqq.vas.pay.page.QVipPayItem$saveMoneyTv$2.1
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(TextView textView) {
                        invoke2(textView);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull TextView text) {
                        Intrinsics.checkNotNullParameter(text, "$this$text");
                        text.setMaxLines(1);
                        text.setTextColor(o.e(-16777216, -1));
                        text.setTextSize(o.u(20));
                        text.setMaxWidth(o.i(100));
                        text.setGravity(17);
                    }
                });
            }
        });
        ConstraintLayout.LayoutParams layoutParams2 = new ConstraintLayout.LayoutParams(-2, -2);
        layoutParams2.startToStart = R.id.f67023c8;
        layoutParams2.endToEnd = R.id.f67023c8;
        layoutParams2.topToBottom = R.id.f67023c8;
        ((ViewGroup.MarginLayoutParams) layoutParams2).topMargin = o.i(-2);
        this.originalPriceTv = (TextView) o.a(this, R.id.f67003c6, layoutParams2, new Function0<TextView>() { // from class: com.tencent.mobileqq.vas.pay.page.QVipPayItem$originalPriceTv$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final TextView invoke() {
                return o.v(QVipPayItem.this, new Function1<TextView, Unit>() { // from class: com.tencent.mobileqq.vas.pay.page.QVipPayItem$originalPriceTv$2.1
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(TextView textView) {
                        invoke2(textView);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull TextView text) {
                        Intrinsics.checkNotNullParameter(text, "$this$text");
                        text.setTextColor(o.g(Color.parseColor("#999999"), 0, 2, null));
                        text.setTextSize(o.u(12));
                        text.getPaint().setFlags(16);
                        text.getPaint().setAntiAlias(true);
                    }
                });
            }
        });
        ConstraintLayout.LayoutParams layoutParams3 = new ConstraintLayout.LayoutParams(o.i(0), o.i(45));
        layoutParams3.endToEnd = 0;
        layoutParams3.topToTop = 0;
        layoutParams3.startToStart = 0;
        layoutParams3.setMarginStart(o.i(112));
        ((ViewGroup.MarginLayoutParams) layoutParams3).topMargin = o.i(8);
        layoutParams3.setMarginEnd(o.i(16));
        this.startPayBtn = (TextView) o.a(this, R.id.f66983c4, layoutParams3, new Function0<TextView>() { // from class: com.tencent.mobileqq.vas.pay.page.QVipPayItem$startPayBtn$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final TextView invoke() {
                final QVipPayItem qVipPayItem = QVipPayItem.this;
                return o.v(qVipPayItem, new Function1<TextView, Unit>() { // from class: com.tencent.mobileqq.vas.pay.page.QVipPayItem$startPayBtn$2.1
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
                        float F0;
                        Intrinsics.checkNotNullParameter(text, "$this$text");
                        text.setBackgroundResource(R.drawable.la7);
                        text.setTextColor(o.g(Color.parseColor("#8F5600"), 0, 2, null));
                        F0 = QVipPayItem.this.F0();
                        text.setTextSize(F0);
                        text.setMaxLines(1);
                        text.setMaxWidth(o.i(255));
                        text.setEllipsize(TextUtils.TruncateAt.END);
                        text.setTextAlignment(4);
                        text.setGravity(17);
                    }
                });
            }
        });
        ConstraintLayout.LayoutParams layoutParams4 = new ConstraintLayout.LayoutParams(-2, -2);
        layoutParams4.topToBottom = R.id.f66983c4;
        layoutParams4.startToStart = R.id.f66983c4;
        layoutParams4.endToEnd = 0;
        layoutParams4.setMarginEnd(o.i(16));
        ((ViewGroup.MarginLayoutParams) layoutParams4).topMargin = o.i(4);
        this.payProtocol = (TextView) o.a(this, R.id.f67013c7, layoutParams4, new Function0<TextView>() { // from class: com.tencent.mobileqq.vas.pay.page.QVipPayItem$payProtocol$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final TextView invoke() {
                return o.v(QVipPayItem.this, new Function1<TextView, Unit>() { // from class: com.tencent.mobileqq.vas.pay.page.QVipPayItem$payProtocol$2.1
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(TextView textView) {
                        invoke2(textView);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull TextView text) {
                        Intrinsics.checkNotNullParameter(text, "$this$text");
                        text.setTextSize(o.u(12));
                        text.setTextColor(o.g(Color.parseColor("#999999"), 0, 2, null));
                        text.setHighlightColor(o.g(0, 0, 2, null));
                        text.setClickable(true);
                        int screenWidth = (ViewUtils.getScreenWidth() - o.i(112)) - o.i(16);
                        if (screenWidth > o.i(255)) {
                            screenWidth = o.i(255);
                        }
                        text.setMaxWidth(screenWidth);
                        text.setMovementMethod(LinkMovementMethod.getInstance());
                    }
                });
            }
        });
        initView();
    }

    private final SpannableString B0(int price) {
        return new SpannableString("\uffe5" + price);
    }

    private final SpannableString C0(int payDisplay) {
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String string = getContext().getString(R.string.f21748615);
        Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.stri\u2026vip_renewal_pay_btn_desc)");
        StringBuilder sb5 = new StringBuilder();
        sb5.append(payDisplay);
        String format = String.format(string, Arrays.copyOf(new Object[]{sb5.toString()}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
        SpannableString spannableString = new SpannableString(format);
        spannableString.setSpan(new com.tencent.mobileqq.vas.pay.page.b((int) F0()), 0, 6, 34);
        com.tencent.mobileqq.vas.pay.page.b bVar = new com.tencent.mobileqq.vas.pay.page.b((int) F0());
        StringBuilder sb6 = new StringBuilder();
        sb6.append(payDisplay);
        spannableString.setSpan(bVar, sb6.toString().length() + 7, format.length(), 34);
        spannableString.setSpan(new AbsoluteSizeSpan(12, true), 6, 7, 33);
        spannableString.setSpan(new com.tencent.mobileqq.vas.pay.page.b(12), 6, 7, 34);
        Typeface numTypeface = this.numTypeface;
        Intrinsics.checkNotNullExpressionValue(numTypeface, "numTypeface");
        com.tencent.mobileqq.vas.pay.page.c cVar = new com.tencent.mobileqq.vas.pay.page.c(numTypeface);
        StringBuilder sb7 = new StringBuilder();
        sb7.append(payDisplay);
        spannableString.setSpan(cVar, 7, sb7.toString().length() + 7, 33);
        AbsoluteSizeSpan absoluteSizeSpan = new AbsoluteSizeSpan(24, true);
        StringBuilder sb8 = new StringBuilder();
        sb8.append(payDisplay);
        spannableString.setSpan(absoluteSizeSpan, 7, sb8.toString().length() + 7, 33);
        return spannableString;
    }

    private final SpannableString D0(String jumpUrl1, String jumpUrl2) {
        String str;
        String string = getContext().getString(R.string.f21749616);
        Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.stri\u2026p_renewal_pay_protocol_1)");
        String string2 = getContext().getString(R.string.f21750617);
        Intrinsics.checkNotNullExpressionValue(string2, "context.getString(R.stri\u2026p_renewal_pay_protocol_2)");
        boolean z16 = !TextUtils.isEmpty(jumpUrl2);
        String str2 = "";
        if (!z16) {
            str = "";
        } else {
            str = getContext().getString(R.string.f21751618);
        }
        Intrinsics.checkNotNullExpressionValue(str, "if (isUrl2) context.getS\u2026l_pay_protocol_3) else \"\"");
        if (z16) {
            str2 = getContext().getString(R.string.f21752619);
        }
        Intrinsics.checkNotNullExpressionValue(str2, "if (isUrl2) context.getS\u2026l_pay_protocol_4) else \"\"");
        int length = string.length() + string2.length();
        int length2 = str.length() + length;
        int length3 = str2.length() + length2;
        SpannableString spannableString = new SpannableString(string + string2 + str + str2);
        spannableString.setSpan(new ForegroundColorSpan(o.e(-16777216, -1)), string.length(), length, 33);
        spannableString.setSpan(new b(jumpUrl1, this), string.length(), length, 33);
        if (z16) {
            spannableString.setSpan(new ForegroundColorSpan(o.e(-16777216, -1)), length2, length3, 33);
            spannableString.setSpan(new c(jumpUrl2, this), length2, length3, 33);
        }
        return spannableString;
    }

    private final SpannableString E0(int saveMoney) {
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String string = getContext().getString(R.string.f2175361_);
        Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.stri\u2026p_renewal_pay_save_money)");
        StringBuilder sb5 = new StringBuilder();
        sb5.append(saveMoney);
        String format = String.format(string, Arrays.copyOf(new Object[]{sb5.toString()}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
        SpannableString spannableString = new SpannableString(format);
        spannableString.setSpan(new AbsoluteSizeSpan(12, true), 0, 3, 33);
        Typeface numTypeface = this.numTypeface;
        Intrinsics.checkNotNullExpressionValue(numTypeface, "numTypeface");
        spannableString.setSpan(new com.tencent.mobileqq.vas.pay.page.c(numTypeface), 3, format.length(), 33);
        return spannableString;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final float F0() {
        int i3;
        if (FontSettingManager.getFontLevel() >= 18.0f) {
            i3 = 14;
        } else {
            i3 = 17;
        }
        return o.u(i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void G0(Function0 click, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(click, "$click");
        QLog.i("QVipPayItem", 1, "click pay");
        click.invoke();
        EventCollector.getInstance().onViewClicked(view);
    }

    public final void initView() {
        setBackgroundColor(o.e(-1, Color.parseColor("#242424")));
        this.saveMoneyTv.setTextColor(o.e(-16777216, -1));
        this.originalPriceTv.setTextColor(o.g(Color.parseColor("#999999"), 0, 2, null));
        this.startPayBtn.setBackgroundResource(R.drawable.la7);
        this.startPayBtn.setTextColor(o.g(Color.parseColor("#8F5600"), 0, 2, null));
        this.payProtocol.setTextColor(o.g(Color.parseColor("#999999"), 0, 2, null));
    }

    public final void setOriginPrice(int originPrice) {
        this.originalPriceTv.setText(B0(originPrice));
    }

    public final void setPayDisplayText(int payDisplay) {
        this.startPayBtn.setText(C0(payDisplay));
    }

    public final void setPayOnClickListener(@NotNull final Function0<Unit> click) {
        Intrinsics.checkNotNullParameter(click, "click");
        this.startPayBtn.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.vas.pay.page.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QVipPayItem.G0(Function0.this, view);
            }
        });
    }

    public final void setPayProtocol(@NotNull String jumpUrl1, @NotNull String jumpUrl2) {
        Intrinsics.checkNotNullParameter(jumpUrl1, "jumpUrl1");
        Intrinsics.checkNotNullParameter(jumpUrl2, "jumpUrl2");
        this.payProtocol.setText(D0(jumpUrl1, jumpUrl2));
    }

    public final void setSaveMoney(int saveMoney) {
        this.saveMoneyTv.setText(E0(saveMoney));
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QVipPayItem(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.numTypeface = Typeface.createFromAsset(getContext().getResources().getAssets(), VasNativePayManagerImpl.DINALTERNATE_BOLD_FONT_PATH);
        ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(-2, -2);
        ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = o.i(16);
        layoutParams.setMarginStart(o.i(16));
        layoutParams.topToTop = 0;
        layoutParams.startToStart = 0;
        Unit unit = Unit.INSTANCE;
        this.saveMoneyTv = (TextView) o.a(this, R.id.f67023c8, layoutParams, new Function0<TextView>() { // from class: com.tencent.mobileqq.vas.pay.page.QVipPayItem$saveMoneyTv$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final TextView invoke() {
                return o.v(QVipPayItem.this, new Function1<TextView, Unit>() { // from class: com.tencent.mobileqq.vas.pay.page.QVipPayItem$saveMoneyTv$2.1
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(TextView textView) {
                        invoke2(textView);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull TextView text) {
                        Intrinsics.checkNotNullParameter(text, "$this$text");
                        text.setMaxLines(1);
                        text.setTextColor(o.e(-16777216, -1));
                        text.setTextSize(o.u(20));
                        text.setMaxWidth(o.i(100));
                        text.setGravity(17);
                    }
                });
            }
        });
        ConstraintLayout.LayoutParams layoutParams2 = new ConstraintLayout.LayoutParams(-2, -2);
        layoutParams2.startToStart = R.id.f67023c8;
        layoutParams2.endToEnd = R.id.f67023c8;
        layoutParams2.topToBottom = R.id.f67023c8;
        ((ViewGroup.MarginLayoutParams) layoutParams2).topMargin = o.i(-2);
        this.originalPriceTv = (TextView) o.a(this, R.id.f67003c6, layoutParams2, new Function0<TextView>() { // from class: com.tencent.mobileqq.vas.pay.page.QVipPayItem$originalPriceTv$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final TextView invoke() {
                return o.v(QVipPayItem.this, new Function1<TextView, Unit>() { // from class: com.tencent.mobileqq.vas.pay.page.QVipPayItem$originalPriceTv$2.1
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(TextView textView) {
                        invoke2(textView);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull TextView text) {
                        Intrinsics.checkNotNullParameter(text, "$this$text");
                        text.setTextColor(o.g(Color.parseColor("#999999"), 0, 2, null));
                        text.setTextSize(o.u(12));
                        text.getPaint().setFlags(16);
                        text.getPaint().setAntiAlias(true);
                    }
                });
            }
        });
        ConstraintLayout.LayoutParams layoutParams3 = new ConstraintLayout.LayoutParams(o.i(0), o.i(45));
        layoutParams3.endToEnd = 0;
        layoutParams3.topToTop = 0;
        layoutParams3.startToStart = 0;
        layoutParams3.setMarginStart(o.i(112));
        ((ViewGroup.MarginLayoutParams) layoutParams3).topMargin = o.i(8);
        layoutParams3.setMarginEnd(o.i(16));
        this.startPayBtn = (TextView) o.a(this, R.id.f66983c4, layoutParams3, new Function0<TextView>() { // from class: com.tencent.mobileqq.vas.pay.page.QVipPayItem$startPayBtn$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final TextView invoke() {
                final QVipPayItem qVipPayItem = QVipPayItem.this;
                return o.v(qVipPayItem, new Function1<TextView, Unit>() { // from class: com.tencent.mobileqq.vas.pay.page.QVipPayItem$startPayBtn$2.1
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
                        float F0;
                        Intrinsics.checkNotNullParameter(text, "$this$text");
                        text.setBackgroundResource(R.drawable.la7);
                        text.setTextColor(o.g(Color.parseColor("#8F5600"), 0, 2, null));
                        F0 = QVipPayItem.this.F0();
                        text.setTextSize(F0);
                        text.setMaxLines(1);
                        text.setMaxWidth(o.i(255));
                        text.setEllipsize(TextUtils.TruncateAt.END);
                        text.setTextAlignment(4);
                        text.setGravity(17);
                    }
                });
            }
        });
        ConstraintLayout.LayoutParams layoutParams4 = new ConstraintLayout.LayoutParams(-2, -2);
        layoutParams4.topToBottom = R.id.f66983c4;
        layoutParams4.startToStart = R.id.f66983c4;
        layoutParams4.endToEnd = 0;
        layoutParams4.setMarginEnd(o.i(16));
        ((ViewGroup.MarginLayoutParams) layoutParams4).topMargin = o.i(4);
        this.payProtocol = (TextView) o.a(this, R.id.f67013c7, layoutParams4, new Function0<TextView>() { // from class: com.tencent.mobileqq.vas.pay.page.QVipPayItem$payProtocol$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final TextView invoke() {
                return o.v(QVipPayItem.this, new Function1<TextView, Unit>() { // from class: com.tencent.mobileqq.vas.pay.page.QVipPayItem$payProtocol$2.1
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(TextView textView) {
                        invoke2(textView);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull TextView text) {
                        Intrinsics.checkNotNullParameter(text, "$this$text");
                        text.setTextSize(o.u(12));
                        text.setTextColor(o.g(Color.parseColor("#999999"), 0, 2, null));
                        text.setHighlightColor(o.g(0, 0, 2, null));
                        text.setClickable(true);
                        int screenWidth = (ViewUtils.getScreenWidth() - o.i(112)) - o.i(16);
                        if (screenWidth > o.i(255)) {
                            screenWidth = o.i(255);
                        }
                        text.setMaxWidth(screenWidth);
                        text.setMovementMethod(LinkMovementMethod.getInstance());
                    }
                });
            }
        });
        initView();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QVipPayItem(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        this.numTypeface = Typeface.createFromAsset(getContext().getResources().getAssets(), VasNativePayManagerImpl.DINALTERNATE_BOLD_FONT_PATH);
        ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(-2, -2);
        ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = o.i(16);
        layoutParams.setMarginStart(o.i(16));
        layoutParams.topToTop = 0;
        layoutParams.startToStart = 0;
        Unit unit = Unit.INSTANCE;
        this.saveMoneyTv = (TextView) o.a(this, R.id.f67023c8, layoutParams, new Function0<TextView>() { // from class: com.tencent.mobileqq.vas.pay.page.QVipPayItem$saveMoneyTv$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final TextView invoke() {
                return o.v(QVipPayItem.this, new Function1<TextView, Unit>() { // from class: com.tencent.mobileqq.vas.pay.page.QVipPayItem$saveMoneyTv$2.1
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(TextView textView) {
                        invoke2(textView);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull TextView text) {
                        Intrinsics.checkNotNullParameter(text, "$this$text");
                        text.setMaxLines(1);
                        text.setTextColor(o.e(-16777216, -1));
                        text.setTextSize(o.u(20));
                        text.setMaxWidth(o.i(100));
                        text.setGravity(17);
                    }
                });
            }
        });
        ConstraintLayout.LayoutParams layoutParams2 = new ConstraintLayout.LayoutParams(-2, -2);
        layoutParams2.startToStart = R.id.f67023c8;
        layoutParams2.endToEnd = R.id.f67023c8;
        layoutParams2.topToBottom = R.id.f67023c8;
        ((ViewGroup.MarginLayoutParams) layoutParams2).topMargin = o.i(-2);
        this.originalPriceTv = (TextView) o.a(this, R.id.f67003c6, layoutParams2, new Function0<TextView>() { // from class: com.tencent.mobileqq.vas.pay.page.QVipPayItem$originalPriceTv$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final TextView invoke() {
                return o.v(QVipPayItem.this, new Function1<TextView, Unit>() { // from class: com.tencent.mobileqq.vas.pay.page.QVipPayItem$originalPriceTv$2.1
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(TextView textView) {
                        invoke2(textView);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull TextView text) {
                        Intrinsics.checkNotNullParameter(text, "$this$text");
                        text.setTextColor(o.g(Color.parseColor("#999999"), 0, 2, null));
                        text.setTextSize(o.u(12));
                        text.getPaint().setFlags(16);
                        text.getPaint().setAntiAlias(true);
                    }
                });
            }
        });
        ConstraintLayout.LayoutParams layoutParams3 = new ConstraintLayout.LayoutParams(o.i(0), o.i(45));
        layoutParams3.endToEnd = 0;
        layoutParams3.topToTop = 0;
        layoutParams3.startToStart = 0;
        layoutParams3.setMarginStart(o.i(112));
        ((ViewGroup.MarginLayoutParams) layoutParams3).topMargin = o.i(8);
        layoutParams3.setMarginEnd(o.i(16));
        this.startPayBtn = (TextView) o.a(this, R.id.f66983c4, layoutParams3, new Function0<TextView>() { // from class: com.tencent.mobileqq.vas.pay.page.QVipPayItem$startPayBtn$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final TextView invoke() {
                final QVipPayItem qVipPayItem = QVipPayItem.this;
                return o.v(qVipPayItem, new Function1<TextView, Unit>() { // from class: com.tencent.mobileqq.vas.pay.page.QVipPayItem$startPayBtn$2.1
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
                        float F0;
                        Intrinsics.checkNotNullParameter(text, "$this$text");
                        text.setBackgroundResource(R.drawable.la7);
                        text.setTextColor(o.g(Color.parseColor("#8F5600"), 0, 2, null));
                        F0 = QVipPayItem.this.F0();
                        text.setTextSize(F0);
                        text.setMaxLines(1);
                        text.setMaxWidth(o.i(255));
                        text.setEllipsize(TextUtils.TruncateAt.END);
                        text.setTextAlignment(4);
                        text.setGravity(17);
                    }
                });
            }
        });
        ConstraintLayout.LayoutParams layoutParams4 = new ConstraintLayout.LayoutParams(-2, -2);
        layoutParams4.topToBottom = R.id.f66983c4;
        layoutParams4.startToStart = R.id.f66983c4;
        layoutParams4.endToEnd = 0;
        layoutParams4.setMarginEnd(o.i(16));
        ((ViewGroup.MarginLayoutParams) layoutParams4).topMargin = o.i(4);
        this.payProtocol = (TextView) o.a(this, R.id.f67013c7, layoutParams4, new Function0<TextView>() { // from class: com.tencent.mobileqq.vas.pay.page.QVipPayItem$payProtocol$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final TextView invoke() {
                return o.v(QVipPayItem.this, new Function1<TextView, Unit>() { // from class: com.tencent.mobileqq.vas.pay.page.QVipPayItem$payProtocol$2.1
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(TextView textView) {
                        invoke2(textView);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull TextView text) {
                        Intrinsics.checkNotNullParameter(text, "$this$text");
                        text.setTextSize(o.u(12));
                        text.setTextColor(o.g(Color.parseColor("#999999"), 0, 2, null));
                        text.setHighlightColor(o.g(0, 0, 2, null));
                        text.setClickable(true);
                        int screenWidth = (ViewUtils.getScreenWidth() - o.i(112)) - o.i(16);
                        if (screenWidth > o.i(255)) {
                            screenWidth = o.i(255);
                        }
                        text.setMaxWidth(screenWidth);
                        text.setMovementMethod(LinkMovementMethod.getInstance());
                    }
                });
            }
        });
        initView();
    }
}
