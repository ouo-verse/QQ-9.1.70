package com.tencent.mobileqq.guild.setting.guildmanage.speak.threshold.view;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.core.content.res.ResourcesCompat;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.o;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00062\u00020\u0001:\u0001\tB\u001d\b\u0007\u0012\u0006\u0010 \u001a\u00020\u001f\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b!\u0010\"J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0004H\u0002J\b\u0010\t\u001a\u00020\u0004H\u0002J\b\u0010\n\u001a\u00020\u0004H\u0002J\b\u0010\u000b\u001a\u00020\u0004H\u0002J\b\u0010\f\u001a\u00020\u0004H\u0002J\b\u0010\r\u001a\u00020\u0004H\u0002J\b\u0010\u000e\u001a\u00020\u0004H\u0002J\u000e\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000fJ\u0016\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0012J\u0018\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000f2\b\b\u0001\u0010\u0016\u001a\u00020\u0012J\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u00192\b\u0010\u0018\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0014\u001a\u00020\u0012H\u0014R\u0014\u0010\u001d\u001a\u00020\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\u001cR\u0016\u0010\u0010\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u001e\u00a8\u0006#"}, d2 = {"Lcom/tencent/mobileqq/guild/setting/guildmanage/speak/threshold/view/FormSwitchWithSubTitle;", "Lcom/tencent/mobileqq/widget/FormSwitchItem;", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "", "b", "f", "e", "d", "a", "g", "c", "i", h.F, "j", "", QQWinkConstants.TAB_SUBTITLE, "setSubTitle", "", "drawableRes", "bgType", "setBackground", "subTitleColor", "Landroid/content/res/Resources;", "res", "Landroid/graphics/drawable/Drawable;", "getSelectorByTypeInternal", "Landroid/widget/TextView;", "Landroid/widget/TextView;", "subTitleText", "Ljava/lang/String;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class FormSwitchWithSubTitle extends FormSwitchItem {

    /* renamed from: h, reason: collision with root package name */
    private static final int f234361h = ViewUtils.dip2px(14.0f);

    /* renamed from: i, reason: collision with root package name */
    private static final int f234362i = ViewUtils.dip2px(1.0f);

    /* renamed from: m, reason: collision with root package name */
    private static final int f234363m = ViewUtils.dip2px(56.0f);

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final TextView subTitleText;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String subTitle;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public FormSwitchWithSubTitle(@NotNull Context context) {
        this(context, null, 2, 0 == true ? 1 : 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void a() {
        ViewGroup.LayoutParams layoutParams = getTextView().getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        ((RelativeLayout.LayoutParams) layoutParams).addRule(15, 0);
    }

    private final void b(AttributeSet attrs) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attrs, jj2.b.f410081i2);
        Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "context.obtainStyledAttr\u2026qui.R.styleable.FormItem)");
        String string = obtainStyledAttributes.getString(jj2.b.D2);
        if (string == null) {
            string = "";
        }
        this.subTitle = string;
        obtainStyledAttributes.recycle();
    }

    private final void c() {
        this.subTitleText.setGravity(8388627);
        this.subTitleText.setEllipsize(TextUtils.TruncateAt.END);
        this.subTitleText.setIncludeFontPadding(false);
        this.subTitleText.setTextSize(0, f234361h);
        this.subTitleText.setTextColor(Color.parseColor("#0099FF"));
        this.subTitleText.setSingleLine(true);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.leftMargin = this.mPadding;
        layoutParams.topMargin = f234362i;
        layoutParams.addRule(9);
        layoutParams.addRule(3, R.id.cjp);
        layoutParams.addRule(0, R.id.cjo);
        addView(this.subTitleText, layoutParams);
    }

    private final void d() {
        getTextView().setIncludeFontPadding(false);
    }

    private final void e() {
        int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(R.dimen.f158570j9);
        setPadding(0, dimensionPixelSize, 0, dimensionPixelSize);
    }

    private final void f() {
        e();
        d();
        c();
        i();
    }

    private final void g() {
        ViewGroup.LayoutParams layoutParams = getTextView().getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        ((RelativeLayout.LayoutParams) layoutParams).addRule(15);
    }

    private final void h() {
        LinearLayout.LayoutParams layoutParams;
        boolean z16;
        ViewGroup.LayoutParams layoutParams2 = getLayoutParams();
        if (layoutParams2 instanceof LinearLayout.LayoutParams) {
            layoutParams = (LinearLayout.LayoutParams) layoutParams2;
        } else {
            layoutParams = null;
        }
        if (layoutParams == null) {
            return;
        }
        if (this.subTitle.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            layoutParams.height = f234363m;
        } else {
            layoutParams.height = -2;
        }
        setLayoutParams(layoutParams);
    }

    private final void i() {
        boolean z16;
        if (this.subTitle.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            this.subTitleText.setText("");
            g();
            this.subTitleText.setVisibility(8);
        } else {
            this.subTitleText.setText(this.subTitle);
            a();
            this.subTitleText.setVisibility(0);
        }
    }

    private final void j() {
        int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(R.dimen.f158570j9);
        setPadding(getPaddingLeft(), dimensionPixelSize, getPaddingRight(), dimensionPixelSize);
    }

    @Override // com.tencent.mobileqq.widget.FormSwitchItem
    @Nullable
    protected Drawable getSelectorByTypeInternal(@Nullable Resources res, int bgType) {
        return null;
    }

    public final void setBackground(int drawableRes, int bgType) {
        setBackground(o.i(getResources(), bgType, true, true, ResourcesCompat.getDrawable(getResources(), drawableRes, null)));
        j();
    }

    public final void setSubTitle(@NotNull String subTitle) {
        Intrinsics.checkNotNullParameter(subTitle, "subTitle");
        this.subTitle = subTitle;
        i();
        h();
    }

    public /* synthetic */ FormSwitchWithSubTitle(Context context, AttributeSet attributeSet, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public FormSwitchWithSubTitle(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.subTitleText = new TextView(context);
        this.subTitle = "";
        this.mNeedSetHeight = false;
        if (attributeSet != null) {
            b(attributeSet);
        }
        f();
    }

    public final void setSubTitle(@NotNull String subTitle, @ColorInt int subTitleColor) {
        Intrinsics.checkNotNullParameter(subTitle, "subTitle");
        this.subTitle = subTitle;
        this.subTitleText.setTextColor(subTitleColor);
        i();
        h();
        j();
    }
}
