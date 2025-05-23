package com.tencent.mobileqq.guild.feed.topic.view;

import android.content.Context;
import android.content.res.ColorStateList;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.biz.qui.quipagetabbar.QUIPageTabBar;
import com.tencent.guild.aio.util.c;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.feed.feedsquare.widget.GuildFeedSquareTabBarV2;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import if1.a;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B/\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\tJ\u001a\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00072\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0014J\u0010\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u0007H\u0014\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/topic/view/TopicPageTabView;", "Lcom/tencent/biz/qui/quipagetabbar/QUIPageTabBar;", "context", "Landroid/content/Context;", Node.ATTRS_ATTR, "Landroid/util/AttributeSet;", "defStyleAttr", "", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "addTab", "", "position", "title", "", "updateTextColor", "currentPos", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes13.dex */
public final class TopicPageTabView extends QUIPageTabBar {
    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public TopicPageTabView(@NotNull Context context) {
        this(context, null, 0, 0, 14, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qui.quipagetabbar.QUIPageTabBar
    public void addTab(int position, @Nullable String title) {
        ColorStateList colorStateList;
        int i3;
        Map mapOf;
        TextView textView = new TextView(getContext());
        textView.setFocusable(true);
        textView.setText(title);
        textView.setTextSize(14.0f);
        textView.setIncludeFontPadding(false);
        textView.setGravity(17);
        GuildFeedSquareTabBarV2.Companion companion = GuildFeedSquareTabBarV2.INSTANCE;
        textView.setPadding(companion.b(), companion.a(), companion.b(), companion.a());
        textView.setSingleLine();
        if (position == getCurrentPosition()) {
            colorStateList = this.mCheckedTextColor;
        } else {
            colorStateList = this.mUncheckedTextColor;
        }
        textView.setTextColor(colorStateList);
        if (position == getCurrentPosition()) {
            i3 = R.drawable.guild_feed_square_tab_select_bg;
        } else {
            i3 = R.drawable.guild_feed_square_tab_normal_bg;
        }
        textView.setBackgroundResource(i3);
        textView.setTag(Integer.valueOf(position));
        mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("sgrp_section_name", String.valueOf(title)));
        a.b(textView, "em_sgrp_forum_section", null, mapOf, ExposurePolicy.REPORT_NONE, null, null, null, null, 242, null);
        setAccessibilityDelegate(textView);
        setTabClickListener(position, textView);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        layoutParams.leftMargin = 0;
        layoutParams.rightMargin = c.b(12);
        this.mTabContainer.addView(textView, position, layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qui.quipagetabbar.QUIPageTabBar
    public void updateTextColor(int currentPos) {
        ColorStateList colorStateList;
        int i3;
        int childCount = this.mTabContainer.getChildCount();
        for (int i16 = 0; i16 < childCount; i16++) {
            View childAt = this.mTabContainer.getChildAt(i16);
            Intrinsics.checkNotNull(childAt, "null cannot be cast to non-null type android.widget.TextView");
            TextView textView = (TextView) childAt;
            if (i16 == currentPos) {
                colorStateList = this.mCheckedTextColor;
            } else {
                colorStateList = this.mUncheckedTextColor;
            }
            textView.setTextColor(colorStateList);
            if (i16 == currentPos) {
                i3 = R.drawable.guild_feed_square_tab_select_bg;
            } else {
                i3 = R.drawable.guild_feed_square_tab_normal_bg;
            }
            textView.setBackgroundResource(i3);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public TopicPageTabView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public TopicPageTabView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        this(context, attributeSet, i3, 0, 8, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ TopicPageTabView(Context context, AttributeSet attributeSet, int i3, int i16, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i17 & 2) != 0 ? null : attributeSet, (i17 & 4) != 0 ? 0 : i3, (i17 & 8) != 0 ? 0 : i16);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public TopicPageTabView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3, int i16) {
        super(context, attributeSet, i3, i16);
        Intrinsics.checkNotNullParameter(context, "context");
        setIsShowLine(false);
        this.mCheckedTextColor = getResources().getColorStateList(R.color.qui_common_brand_standard);
        this.mUncheckedTextColor = getResources().getColorStateList(R.color.qui_common_text_primary);
    }
}
