package com.tencent.mobileqq.wink.aiavatar.view;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.ecommerce.base.searchbar.IECSearchBar;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.wink.aiavatar.base.WinkAIAvatarUtils;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u001c\u001a\u00020\u001b\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001d\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u0004\u00a2\u0006\u0004\b \u0010!J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\u0010\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0004H\u0002J\u0012\u0010\u000b\u001a\u00020\u00022\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\tJ\u0012\u0010\f\u001a\u00020\u00022\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\tJ\u0012\u0010\r\u001a\u00020\u00022\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\tR\u001b\u0010\u0012\u001a\u00020\u000e8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0005\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0015\u001a\u00020\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0014R$\u0010\n\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\t8F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a\u00a8\u0006\""}, d2 = {"Lcom/tencent/mobileqq/wink/aiavatar/view/WinkAIAvatarGenerateBtn;", "Landroid/widget/FrameLayout;", "", "a", "", "d", "e", "backgroundColor", "f", "", "text", "setEnableState", "setDisableState", "setVipState", "Landroid/widget/TextView;", "Lkotlin/Lazy;", "c", "()Landroid/widget/TextView;", "textView", "", UserInfo.SEX_FEMALE, "radius", "value", "b", "()Ljava/lang/String;", IECSearchBar.METHOD_SET_TEXT, "(Ljava/lang/String;)V", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class WinkAIAvatarGenerateBtn extends FrameLayout {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy textView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final float radius;

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f317858f;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public WinkAIAvatarGenerateBtn(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void a() {
        c().setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
        c().setCompoundDrawablePadding(0);
    }

    private final TextView c() {
        return (TextView) this.textView.getValue();
    }

    private final int d() {
        if (QQTheme.isNowThemeIsNight()) {
            return Color.parseColor("#FFF5D8AB");
        }
        return Color.parseColor("#FFF2CE96");
    }

    private final int e() {
        if (QQTheme.isNowThemeIsNight()) {
            return Color.parseColor("#FF824F0E");
        }
        return Color.parseColor("#FF824F0E");
    }

    private final void f(int backgroundColor) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadius(this.radius);
        gradientDrawable.setColor(backgroundColor);
        setBackground(gradientDrawable);
    }

    public static /* synthetic */ void setDisableState$default(WinkAIAvatarGenerateBtn winkAIAvatarGenerateBtn, String str, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = null;
        }
        winkAIAvatarGenerateBtn.setDisableState(str);
    }

    public static /* synthetic */ void setEnableState$default(WinkAIAvatarGenerateBtn winkAIAvatarGenerateBtn, String str, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = null;
        }
        winkAIAvatarGenerateBtn.setEnableState(str);
    }

    public static /* synthetic */ void setVipState$default(WinkAIAvatarGenerateBtn winkAIAvatarGenerateBtn, String str, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = null;
        }
        winkAIAvatarGenerateBtn.setVipState(str);
    }

    @NotNull
    public final String b() {
        return c().getText().toString();
    }

    public final void setDisableState(@Nullable String text) {
        a();
        f(getContext().getColor(R.color.qui_button_bg_primary_disable));
        c().setTextColor(getContext().getColor(R.color.qui_button_text_primary_default));
        if (text != null) {
            setText(text);
        }
    }

    public final void setEnableState(@Nullable String text) {
        a();
        f(getContext().getColor(R.color.qui_button_bg_primary_default));
        c().setTextColor(getContext().getColor(R.color.qui_button_text_primary_default));
        if (text != null) {
            setText(text);
        }
    }

    public final void setText(@NotNull String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        c().setText(value);
    }

    public final void setVipState(@Nullable String text) {
        WinkAIAvatarUtils winkAIAvatarUtils = WinkAIAvatarUtils.f317678a;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        Drawable o16 = winkAIAvatarUtils.o(context, 24.0f);
        c().setCompoundDrawablePadding(ImmersiveUtils.dpToPx(4.0f));
        c().setCompoundDrawablesWithIntrinsicBounds(o16, (Drawable) null, (Drawable) null, (Drawable) null);
        f(d());
        c().setTextColor(e());
        if (text != null) {
            setText(text);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public WinkAIAvatarGenerateBtn(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public WinkAIAvatarGenerateBtn(@NotNull final Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Lazy lazy;
        Intrinsics.checkNotNullParameter(context, "context");
        this.f317858f = new LinkedHashMap();
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<TextView>() { // from class: com.tencent.mobileqq.wink.aiavatar.view.WinkAIAvatarGenerateBtn$textView$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final TextView invoke() {
                return new TextView(context);
            }
        });
        this.textView = lazy;
        this.radius = ImmersiveUtils.dpToPx(14.0f);
        setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        TextView c16 = c();
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        c16.setLayoutParams(layoutParams);
        c16.setTextSize(0, ImmersiveUtils.dpToPx(18.0f));
        c16.setGravity(17);
        c16.setEllipsize(TextUtils.TruncateAt.END);
        c16.setMaxLines(1);
        addView(c());
        setEnableState$default(this, null, 1, null);
    }

    public /* synthetic */ WinkAIAvatarGenerateBtn(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }
}
