package com.tencent.mobileqq.guild.discovery.widget.scrolllabel;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.ColorRes;
import com.heytap.databaseengine.apiv3.data.Element;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.biz.qui.quipagetabbar.QUIPageTabBar;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.util.GuildUIUtils;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 &2\u00020\u0001:\u0002'(B1\b\u0007\u0012\u0006\u0010\u001f\u001a\u00020\u001e\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010 \u0012\b\b\u0002\u0010\"\u001a\u00020\u0002\u0012\b\b\u0002\u0010#\u001a\u00020\u0002\u00a2\u0006\u0004\b$\u0010%J\u0010\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u0002J\u0010\u0010\u0007\u001a\u00020\u00042\b\b\u0001\u0010\u0006\u001a\u00020\u0002J\u000e\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bJ\u000e\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0002J\u001a\u0010\u0010\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u00022\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0014J\u0010\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0002H\u0014R\u0016\u0010\u0015\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\"\u0010\u001d\u001a\u00020\u00168\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001c\u00a8\u0006)"}, d2 = {"Lcom/tencent/mobileqq/guild/discovery/widget/scrolllabel/GuildScrollLabelListTabBar;", "Lcom/tencent/biz/qui/quipagetabbar/QUIPageTabBar;", "", "checkedTextColor", "", "setCheckedTextColor", "uncheckedTextColor", "setUncheckedTextColor", "Lcom/tencent/mobileqq/guild/discovery/widget/scrolllabel/GuildScrollLabelListTabBar$b;", "callback", "setCreateTabCallback", Element.ELEMENT_NAME_DISTANCE, "setMarginHon", "position", "", "title", "addTab", "currentPos", "updateTextColor", "d", "I", "mDistance", "Landroid/graphics/drawable/Drawable;", "e", "Landroid/graphics/drawable/Drawable;", "getLableSelectBg", "()Landroid/graphics/drawable/Drawable;", "setLableSelectBg", "(Landroid/graphics/drawable/Drawable;)V", "lableSelectBg", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "defStyleRes", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "f", "a", "b", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildScrollLabelListTabBar extends QUIPageTabBar {

    /* renamed from: h, reason: collision with root package name */
    private static final int f216874h = QQGuildUIUtil.f(7.0f);

    /* renamed from: i, reason: collision with root package name */
    private static final int f216875i = QQGuildUIUtil.f(11.0f);

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private int mDistance;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private Drawable lableSelectBg;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\b\u00e6\u0080\u0001\u0018\u00002\u00020\u0001\u00a8\u0006\u0002"}, d2 = {"Lcom/tencent/mobileqq/guild/discovery/widget/scrolllabel/GuildScrollLabelListTabBar$b;", "", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public interface b {
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuildScrollLabelListTabBar(@NotNull Context context) {
        this(context, null, 0, 0, 14, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qui.quipagetabbar.QUIPageTabBar
    public void addTab(int position, @Nullable String title) {
        ColorStateList colorStateList;
        TextView textView = new TextView(getContext());
        textView.setFocusable(true);
        textView.setText(title);
        textView.setTextSize(14.0f);
        textView.setIncludeFontPadding(false);
        if (position == getCurrentPosition()) {
            colorStateList = this.mCheckedTextColor;
        } else {
            colorStateList = this.mUncheckedTextColor;
        }
        textView.setTextColor(colorStateList);
        textView.setGravity(17);
        int i3 = f216875i;
        int i16 = f216874h;
        textView.setPadding(i3, i16, i3, i16);
        textView.setSingleLine();
        textView.setTag(Integer.valueOf(position));
        if (position == getCurrentPosition()) {
            textView.setBackground(this.lableSelectBg);
        } else {
            textView.setBackgroundResource(R.drawable.qui_common_fill_standard_primary_bg_corner_4);
        }
        setAccessibilityDelegate(textView);
        setTabClickListener(position, textView);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        if (position == 0) {
            layoutParams.leftMargin = QQGuildUIUtil.f(this.mDistance);
        } else {
            layoutParams.leftMargin = QQGuildUIUtil.f(4.0f);
        }
        if (position == this.mTabTexts.length - 1) {
            layoutParams.rightMargin = QQGuildUIUtil.f(this.mDistance);
        } else {
            layoutParams.rightMargin = QQGuildUIUtil.f(4.0f);
        }
        this.mTabContainer.addView(textView, position, layoutParams);
    }

    public final void setCheckedTextColor(@ColorRes int checkedTextColor) {
        this.mCheckedTextColor = getResources().getColorStateList(checkedTextColor);
    }

    public final void setCreateTabCallback(@NotNull b callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
    }

    public final void setLableSelectBg(@NotNull Drawable drawable) {
        Intrinsics.checkNotNullParameter(drawable, "<set-?>");
        this.lableSelectBg = drawable;
    }

    public final void setMarginHon(int distance) {
        this.mDistance = distance;
    }

    public final void setUncheckedTextColor(@ColorRes int uncheckedTextColor) {
        this.mUncheckedTextColor = getResources().getColorStateList(uncheckedTextColor);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qui.quipagetabbar.QUIPageTabBar
    public void updateTextColor(int currentPos) {
        ColorStateList colorStateList;
        int childCount = this.mTabContainer.getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = this.mTabContainer.getChildAt(i3);
            Intrinsics.checkNotNull(childAt, "null cannot be cast to non-null type android.widget.TextView");
            TextView textView = (TextView) childAt;
            if (i3 == currentPos) {
                colorStateList = this.mCheckedTextColor;
            } else {
                colorStateList = this.mUncheckedTextColor;
            }
            textView.setTextColor(colorStateList);
            if (i3 == currentPos) {
                textView.setBackground(this.lableSelectBg);
            } else {
                textView.setBackgroundResource(R.drawable.qui_common_fill_standard_primary_bg_corner_4);
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuildScrollLabelListTabBar(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuildScrollLabelListTabBar(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        this(context, attributeSet, i3, 0, 8, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ GuildScrollLabelListTabBar(Context context, AttributeSet attributeSet, int i3, int i16, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i17 & 2) != 0 ? null : attributeSet, (i17 & 4) != 0 ? 0 : i3, (i17 & 8) != 0 ? 0 : i16);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuildScrollLabelListTabBar(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3, int i16) {
        super(context, attributeSet, i3, i16);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mDistance = 16;
        setIsShowLine(false);
        setBackgroundResource(R.drawable.qui_common_bg_bottom_light_bg);
        this.lableSelectBg = GuildUIUtils.f235378a.q(context, R.color.qui_common_brand_standard, 12, 24, 4.0f, 1.0f);
        setCheckedTextColor(R.color.qui_common_brand_standard);
        setUncheckedTextColor(R.color.qui_common_text_secondary_light);
    }
}
