package com.tencent.mobileqq.guild.feed.feedsquare.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.ColorRes;
import androidx.core.content.ContextCompat;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u001f2\u00020\u0001:\u0001 B\u001d\b\u0007\u0012\u0006\u0010\u001a\u001a\u00020\u0019\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001b\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\u0012\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\u0007\u001a\u00020\u00042\b\b\u0001\u0010\u0006\u001a\u00020\u0002H\u0002J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0002H\u0002J\"\u0010\u000e\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\r\u001a\u00020\u0002H\u0016J\b\u0010\u000f\u001a\u00020\u0004H\u0016J\u001a\u0010\u0010\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016J\u0010\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0002H\u0014J\u000e\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0002R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017\u00a8\u0006!"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/feedsquare/widget/GuildFeedSquareTabBarV2;", "Lcom/tencent/mobileqq/guild/feed/feedsquare/widget/GuildFeedSquareTabBar;", "", "checkedTextColor", "", "setCheckedTextColor", "uncheckedTextColor", "setUncheckedTextColor", "position", "Landroid/widget/LinearLayout$LayoutParams;", "t", "", "title", "leftMargin", "f", "notifyDataSetChanged", "c", "currentPos", "updateTextColor", "margin", "u", "Landroid/view/View;", "E", "Landroid/view/View;", "lastItemView", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", UserInfo.SEX_FEMALE, "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildFeedSquareTabBarV2 extends GuildFeedSquareTabBar {

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private static final int G = QQGuildUIUtil.f(5.0f);
    private static final int H = QQGuildUIUtil.f(12.0f);
    private static int I = com.tencent.guild.aio.util.c.b(16);
    private static int J = com.tencent.guild.aio.util.c.b(50);
    private static int K = com.tencent.guild.aio.util.c.b(4);

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private View lastItemView;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0016\u0010\u0017R\u0017\u0010\u0003\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\fR\"\u0010\r\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\r\u0010\u0004\u001a\u0004\b\u000e\u0010\u0006\"\u0004\b\u000f\u0010\fR\u0014\u0010\u0011\u001a\u00020\u00108\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0014\u001a\u00020\u00138\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/feedsquare/widget/GuildFeedSquareTabBarV2$a;", "", "", "DP_5dot3", "I", "a", "()I", "DP_8", "b", "DP_BAR_MARGIN", "d", "setDP_BAR_MARGIN", "(I)V", "DP_BAR_LARGE_MARGIN", "c", "setDP_BAR_LARGE_MARGIN", "", "TAB_TEXT_SIZE", UserInfo.SEX_FEMALE, "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.feed.feedsquare.widget.GuildFeedSquareTabBarV2$a, reason: from kotlin metadata */
    /* loaded from: classes13.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int a() {
            return GuildFeedSquareTabBarV2.G;
        }

        public final int b() {
            return GuildFeedSquareTabBarV2.H;
        }

        public final int c() {
            return GuildFeedSquareTabBarV2.J;
        }

        public final int d() {
            return GuildFeedSquareTabBarV2.I;
        }

        Companion() {
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuildFeedSquareTabBarV2(@NotNull Context context) {
        this(context, null, 2, 0 == true ? 1 : 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void setCheckedTextColor(@ColorRes int checkedTextColor) {
        this.mCheckedTextColor = getResources().getColorStateList(checkedTextColor);
    }

    private final void setUncheckedTextColor(@ColorRes int uncheckedTextColor) {
        this.mUncheckedTextColor = getResources().getColorStateList(uncheckedTextColor);
    }

    private final LinearLayout.LayoutParams t(int position) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        if (position == 0) {
            layoutParams.leftMargin = I;
        } else {
            layoutParams.leftMargin = K;
        }
        if (position == this.mTabTexts.length - 1) {
            layoutParams.rightMargin = I;
        } else {
            layoutParams.rightMargin = K;
        }
        return layoutParams;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v(GuildFeedSquareTabBarV2 this$0, int i3) {
        ViewGroup.LayoutParams layoutParams;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        View view = this$0.lastItemView;
        LinearLayout.LayoutParams layoutParams2 = null;
        if (view != null) {
            layoutParams = view.getLayoutParams();
        } else {
            layoutParams = null;
        }
        if (layoutParams instanceof LinearLayout.LayoutParams) {
            layoutParams2 = (LinearLayout.LayoutParams) layoutParams;
        }
        if (layoutParams2 != null) {
            layoutParams2.rightMargin = i3;
        }
        QLog.i("GuildFeedSquareTabBarV2", 1, "updateLastTabItemEndMargin margin=" + i3 + " lp=" + layoutParams2);
        View view2 = this$0.lastItemView;
        if (view2 != null) {
            view2.setLayoutParams(layoutParams2);
        }
        View view3 = this$0.lastItemView;
        if (view3 != null) {
            view3.requestLayout();
        }
    }

    @Override // com.tencent.mobileqq.guild.feed.feedsquare.widget.GuildFeedSquareTabBar
    public void c(int position, @Nullable String title) {
        final TextView textView = new TextView(getContext());
        Drawable drawable = ContextCompat.getDrawable(getContext(), R.drawable.qui_add);
        if (drawable != null) {
            drawable.setBounds(0, 0, com.tencent.guild.aio.util.c.b(14), com.tencent.guild.aio.util.c.b(14));
        }
        textView.setCompoundDrawables(drawable, null, null, null);
        textView.setText(R.string.f145660s3);
        textView.setGravity(17);
        textView.setTextSize(14.0f);
        textView.setPadding(com.tencent.guild.aio.util.c.b(5), 0, 0, 0);
        textView.setFocusable(true);
        textView.setBackgroundResource(R.drawable.guild_feed_square_tab_normal_bg);
        textView.setIncludeFontPadding(false);
        textView.setTextColor(this.mUncheckedTextColor);
        int i3 = H;
        int i16 = G;
        textView.setPadding(i3, i16, i3, i16);
        textView.setSingleLine();
        textView.setTag(Integer.valueOf(position));
        setAccessibilityDelegate(textView);
        final long j3 = 200;
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.feed.feedsquare.widget.GuildFeedSquareTabBarV2$addCreateSection$$inlined$setSingleClickListener$1
            @Override // android.view.View.OnClickListener
            public final void onClick(View it) {
                EventCollector.getInstance().onViewClickedBefore(it);
                textView.setClickable(false);
                Intrinsics.checkNotNullExpressionValue(it, "it");
                QLog.i("GuildFeedSquareTabBarV2", 1, "setting btn click");
                this.j();
                final View view = textView;
                view.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.feedsquare.widget.GuildFeedSquareTabBarV2$addCreateSection$$inlined$setSingleClickListener$1.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        view.setClickable(true);
                    }
                }, j3);
                EventCollector.getInstance().onViewClicked(it);
            }
        });
        this.mTabContainer.addView(textView, position, t(position));
        ch.Y0(textView, "em_sgrp_create_new_forum_section", ClickPolicy.REPORT_ALL, ExposurePolicy.REPORT_ALL);
    }

    @Override // com.tencent.mobileqq.guild.feed.feedsquare.widget.GuildFeedSquareTabBar
    public void f(int position, @Nullable String title, int leftMargin) {
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
        int i3 = H;
        int i16 = G;
        textView.setPadding(i3, i16, i3, i16);
        textView.setSingleLine();
        textView.setTag(Integer.valueOf(position));
        setAccessibilityDelegate(textView);
        setTabClickListener(position, textView);
        this.mTabContainer.addView(textView, position, t(position));
        if (position == getCurrentPosition()) {
            textView.setBackgroundResource(R.drawable.guild_feed_square_tab_select_bg);
        } else {
            textView.setBackgroundResource(R.drawable.guild_feed_square_tab_normal_bg);
        }
        if (position == this.mTabTexts.length - 1) {
            this.lastItemView = textView;
        }
    }

    @Override // com.tencent.mobileqq.guild.feed.feedsquare.widget.GuildFeedSquareTabBar, com.tencent.biz.qui.quipagetabbar.QUIPageTabBar
    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
        updateTextColor(getCurrentPosition());
    }

    public final void u(final int margin) {
        View view = this.lastItemView;
        if (view != null) {
            view.post(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.feedsquare.widget.k
                @Override // java.lang.Runnable
                public final void run() {
                    GuildFeedSquareTabBarV2.v(GuildFeedSquareTabBarV2.this, margin);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.feed.feedsquare.widget.GuildFeedSquareTabBar, com.tencent.biz.qui.quipagetabbar.QUIPageTabBar
    public void updateTextColor(int currentPos) {
        TextView textView;
        ColorStateList colorStateList;
        int childCount = this.mTabContainer.getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = this.mTabContainer.getChildAt(i3);
            if (childAt instanceof TextView) {
                textView = (TextView) childAt;
            } else {
                textView = null;
            }
            if (textView != null) {
                if (i3 == currentPos) {
                    colorStateList = this.mCheckedTextColor;
                } else {
                    colorStateList = this.mUncheckedTextColor;
                }
                textView.setTextColor(colorStateList);
            }
            if (i3 == currentPos) {
                if (textView != null) {
                    textView.setBackgroundResource(R.drawable.guild_feed_square_tab_select_bg);
                }
            } else if (textView != null) {
                textView.setBackgroundResource(R.drawable.guild_feed_square_tab_normal_bg);
            }
        }
    }

    public /* synthetic */ GuildFeedSquareTabBarV2(Context context, AttributeSet attributeSet, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuildFeedSquareTabBarV2(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        setIsShowLine(false);
        setCheckedTextColor(R.color.qui_common_brand_standard);
        setUncheckedTextColor(R.color.qui_common_text_primary);
    }
}
