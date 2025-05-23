package com.tencent.guild.aio.panel.plus.subitem;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.Checkable;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import androidx.appcompat.widget.AppCompatRadioButton;
import androidx.viewpager.widget.ViewPager;
import com.tencent.aio.base.tool.a;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.biz.pubaccount.weishi.event.WSComboHomePageChangeEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mq0.i;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u001b\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\b\u0010\u0004\u001a\u00020\u0003H\u0002J\u000e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005J \u0010\u000e\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\tH\u0016J\u0010\u0010\u000f\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0016J\u0010\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\tH\u0016J\u0016\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\tR\u0016\u0010\u0017\u001a\u00020\u00058\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/guild/aio/panel/plus/subitem/GuildPagerRadioGroup;", "Landroid/widget/RadioGroup;", "Landroidx/viewpager/widget/ViewPager$OnPageChangeListener;", "Landroid/widget/RadioButton;", "a", "Lmq0/i;", "indicatorInfo", "", "setIndicatorInfo", "", "position", "", "positionOffset", "positionOffsetPixels", WSComboHomePageChangeEvent.EVENT_ON_PAGE_SCROLLED, "onPageSelected", "state", "onPageScrollStateChanged", "count", "currentItem", "b", "d", "Lmq0/i;", "mIndicatorInfo", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class GuildPagerRadioGroup extends RadioGroup implements ViewPager.OnPageChangeListener {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private i mIndicatorInfo;

    public GuildPagerRadioGroup(@Nullable Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    private final RadioButton a() {
        final Context context = getContext();
        AppCompatRadioButton appCompatRadioButton = new AppCompatRadioButton(context) { // from class: com.tencent.guild.aio.panel.plus.subitem.GuildPagerRadioGroup$createButton$button$1
            @Override // android.widget.CompoundButton, android.view.View
            public boolean performClick() {
                return true;
            }
        };
        i iVar = this.mIndicatorInfo;
        i iVar2 = null;
        if (iVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mIndicatorInfo");
            iVar = null;
        }
        appCompatRadioButton.setButtonDrawable(iVar.getDrawableId());
        appCompatRadioButton.setGravity(17);
        appCompatRadioButton.setClickable(true);
        a.Companion companion = a.INSTANCE;
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "context");
        i iVar3 = this.mIndicatorInfo;
        if (iVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mIndicatorInfo");
            iVar3 = null;
        }
        int b16 = companion.b(context2, iVar3.getWidthDp());
        Context context3 = getContext();
        Intrinsics.checkNotNullExpressionValue(context3, "context");
        i iVar4 = this.mIndicatorInfo;
        if (iVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mIndicatorInfo");
            iVar4 = null;
        }
        RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams(b16, companion.b(context3, iVar4.getHeightDp()));
        layoutParams.gravity = 17;
        Context context4 = getContext();
        Intrinsics.checkNotNullExpressionValue(context4, "context");
        i iVar5 = this.mIndicatorInfo;
        if (iVar5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mIndicatorInfo");
            iVar5 = null;
        }
        layoutParams.leftMargin = companion.b(context4, iVar5.getLeftMarginDp());
        Context context5 = getContext();
        Intrinsics.checkNotNullExpressionValue(context5, "context");
        i iVar6 = this.mIndicatorInfo;
        if (iVar6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mIndicatorInfo");
        } else {
            iVar2 = iVar6;
        }
        layoutParams.rightMargin = companion.b(context5, iVar2.getRightMarginDp());
        appCompatRadioButton.setLayoutParams(layoutParams);
        return appCompatRadioButton;
    }

    public final void b(int count, int currentItem) {
        removeAllViews();
        if (count <= 1) {
            return;
        }
        for (int i3 = 0; i3 < count; i3++) {
            addView(a());
        }
        Checkable checkable = (Checkable) getChildAt(currentItem);
        if (checkable != null) {
            checkable.setChecked(true);
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageSelected(int position) {
        Checkable checkable;
        if (getChildCount() > position && (checkable = (Checkable) getChildAt(position)) != null) {
            checkable.setChecked(true);
        }
    }

    public final void setIndicatorInfo(@NotNull i indicatorInfo) {
        Intrinsics.checkNotNullParameter(indicatorInfo, "indicatorInfo");
        this.mIndicatorInfo = indicatorInfo;
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int state) {
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
    }
}
