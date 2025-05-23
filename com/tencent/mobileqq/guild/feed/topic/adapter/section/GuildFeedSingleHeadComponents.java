package com.tencent.mobileqq.guild.feed.topic.adapter.section;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.google.android.flexbox.FlexboxLayout;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 .2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u000b\u000fB\u000f\u0012\u0006\u0010\u001f\u001a\u00020\u001b\u00a2\u0006\u0004\b,\u0010-J\b\u0010\u0004\u001a\u00020\u0003H\u0002J$\u0010\u000b\u001a\u00020\u0003*\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0002J\u0018\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\fH\u0002J\b\u0010\u0011\u001a\u00020\u0010H\u0016J\u0010\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0012H\u0016J(\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\t2\u000e\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017H\u0016R\u0017\u0010\u001f\u001a\u00020\u001b8\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u0016\u0010!\u001a\u00020\u00128\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0004\u0010 R\u0016\u0010#\u001a\u00020\u00058\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\"R\u0016\u0010%\u001a\u00020\u00058\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b$\u0010\"R\u0016\u0010)\u001a\u00020&8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010+\u001a\u00020\u00058\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b*\u0010\"\u00a8\u0006/"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/topic/adapter/section/GuildFeedSingleHeadComponents;", "Lcom/tencent/mobileqq/guild/feed/feedsquare/section/a;", "Lcom/tencent/mobileqq/guild/feed/topic/adapter/section/a;", "", "e", "Landroid/widget/TextView;", "", "bgColor", "textStr", "", "textColorResId", "a", "", "radius", "Landroid/graphics/drawable/Drawable;", "b", "", "d", "Landroid/view/View;", "containerView", "g", "params", "position", "", "", "payload", "f", "Lcom/tencent/mobileqq/guild/feed/topic/adapter/section/GuildFeedSingleHeadComponents$b;", "Lcom/tencent/mobileqq/guild/feed/topic/adapter/section/GuildFeedSingleHeadComponents$b;", "c", "()Lcom/tencent/mobileqq/guild/feed/topic/adapter/section/GuildFeedSingleHeadComponents$b;", "depends", "Landroid/view/View;", "headerRoot", "Landroid/widget/TextView;", "nickNameTv", tl.h.F, "feedRoleTv", "Lcom/google/android/flexbox/FlexboxLayout;", "i", "Lcom/google/android/flexbox/FlexboxLayout;", "flexboxLayout", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "channelTopFlagTv", "<init>", "(Lcom/tencent/mobileqq/guild/feed/topic/adapter/section/GuildFeedSingleHeadComponents$b;)V", BdhLogUtil.LogTag.Tag_Conn, "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildFeedSingleHeadComponents extends com.tencent.mobileqq.guild.feed.feedsquare.section.a<GuildFeedHeadBindParams> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b depends;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private View headerRoot;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private TextView nickNameTv;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private TextView feedRoleTv;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private FlexboxLayout flexboxLayout;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private TextView channelTopFlagTv;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/topic/adapter/section/GuildFeedSingleHeadComponents$b;", "", "", "b", "Landroid/view/View;", "v", "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public interface b {
        void a(@NotNull View v3);

        void b();
    }

    public GuildFeedSingleHeadComponents(@NotNull b depends) {
        Intrinsics.checkNotNullParameter(depends, "depends");
        this.depends = depends;
    }

    private final void a(TextView textView, String str, String str2, int i3) {
        Drawable b16 = b(Color.parseColor(str), 3.0f);
        b16.setAlpha(26);
        textView.setBackground(b16);
        textView.setText(str2);
        textView.setTextColor(ContextCompat.getColor(textView.getContext(), i3));
        textView.setVisibility(0);
    }

    private final Drawable b(int bgColor, float radius) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(bgColor);
        gradientDrawable.setCornerRadius(com.tencent.mobileqq.guild.feed.util.e.a(MobileQQ.sMobileQQ, radius));
        return gradientDrawable;
    }

    private final void e() {
        View view = this.headerRoot;
        TextView textView = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("headerRoot");
            view = null;
        }
        View findViewById = view.findViewById(R.id.way);
        Intrinsics.checkNotNullExpressionValue(findViewById, "headerRoot.findViewById(\u2026.guild_feed_item_name_ll)");
        this.flexboxLayout = (FlexboxLayout) findViewById;
        View view2 = this.headerRoot;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("headerRoot");
            view2 = null;
        }
        TextView textView2 = new TextView(view2.getContext());
        textView2.setId(R.id.wah);
        textView2.setLayoutParams(new FlexboxLayout.LayoutParams(-2, -2));
        textView2.setEllipsize(TextUtils.TruncateAt.END);
        textView2.setMaxLines(1);
        View view3 = this.headerRoot;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("headerRoot");
            view3 = null;
        }
        textView2.setTextColor(ContextCompat.getColor(view3.getContext(), R.color.qui_common_text_secondary));
        textView2.setIncludeFontPadding(false);
        textView2.setTextSize(14.0f);
        this.nickNameTv = textView2;
        FlexboxLayout flexboxLayout = this.flexboxLayout;
        if (flexboxLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("flexboxLayout");
            flexboxLayout = null;
        }
        TextView textView3 = this.nickNameTv;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nickNameTv");
            textView3 = null;
        }
        flexboxLayout.addView(textView3);
        View view4 = this.headerRoot;
        if (view4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("headerRoot");
            view4 = null;
        }
        TextView textView4 = new TextView(view4.getContext());
        textView4.setId(R.id.waj);
        FlexboxLayout.LayoutParams layoutParams = new FlexboxLayout.LayoutParams(-2, ViewUtils.dpToPx(13.0f));
        layoutParams.b(0.0f);
        layoutParams.setMargins(ViewUtils.dpToPx(4.0f), 0, 0, 0);
        textView4.setPadding(ViewUtils.dpToPx(4.0f), 0, ViewUtils.dpToPx(4.0f), 0);
        textView4.setLayoutParams(layoutParams);
        textView4.setTextSize(9.0f);
        View view5 = this.headerRoot;
        if (view5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("headerRoot");
            view5 = null;
        }
        textView4.setTextColor(ContextCompat.getColor(view5.getContext(), R.color.f158017al3));
        textView4.setGravity(17);
        this.feedRoleTv = textView4;
        FlexboxLayout flexboxLayout2 = this.flexboxLayout;
        if (flexboxLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("flexboxLayout");
            flexboxLayout2 = null;
        }
        TextView textView5 = this.feedRoleTv;
        if (textView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("feedRoleTv");
        } else {
            textView = textView5;
        }
        flexboxLayout2.addView(textView);
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final b getDepends() {
        return this.depends;
    }

    @NotNull
    public int[] d() {
        return new int[]{R.id.wak};
    }

    public void f(@NotNull GuildFeedHeadBindParams params, int position, @Nullable List<Object> payload) {
        boolean z16;
        Intrinsics.checkNotNullParameter(params, "params");
        TextView textView = this.nickNameTv;
        TextView textView2 = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nickNameTv");
            textView = null;
        }
        textView.setText(params.getNickName());
        View view = this.headerRoot;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("headerRoot");
            view = null;
        }
        view.setContentDescription(params.getNickName());
        boolean z17 = true;
        if (params.getFeedRole().length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            TextView textView3 = this.feedRoleTv;
            if (textView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("feedRoleTv");
                textView3 = null;
            }
            textView3.setText(params.getFeedRole());
            TextView textView4 = this.feedRoleTv;
            if (textView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("feedRoleTv");
                textView4 = null;
            }
            textView4.setBackground(b(params.getFeedRoleColor() | (-16777216), 2.0f));
            TextView textView5 = this.feedRoleTv;
            if (textView5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("feedRoleTv");
                textView5 = null;
            }
            textView5.setVisibility(0);
        } else {
            TextView textView6 = this.feedRoleTv;
            if (textView6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("feedRoleTv");
                textView6 = null;
            }
            textView6.setVisibility(8);
        }
        if (params.getChannelTopFlagText().length() <= 0) {
            z17 = false;
        }
        if (z17) {
            TextView textView7 = this.channelTopFlagTv;
            if (textView7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("channelTopFlagTv");
            } else {
                textView2 = textView7;
            }
            a(textView2, params.getChannelTopFlagBgColor(), params.getChannelTopFlagText(), params.getChannelTopFlagTextColorRes());
            return;
        }
        TextView textView8 = this.channelTopFlagTv;
        if (textView8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("channelTopFlagTv");
        } else {
            textView2 = textView8;
        }
        textView2.setVisibility(8);
    }

    public void g(@NotNull View containerView) {
        Intrinsics.checkNotNullParameter(containerView, "containerView");
        View findViewById = containerView.findViewById(R.id.wae);
        Intrinsics.checkNotNullExpressionValue(findViewById, "containerView.findViewBy\u2026_feed_item_header_layout)");
        this.headerRoot = findViewById;
        final TextView textView = null;
        if (findViewById == null) {
            Intrinsics.throwUninitializedPropertyAccessException("headerRoot");
            findViewById = null;
        }
        findViewById.setClickable(false);
        View view = this.headerRoot;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("headerRoot");
            view = null;
        }
        view.setLongClickable(true);
        View findViewById2 = containerView.findViewById(R.id.w_x);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "containerView.findViewBy\u2026item_channel_top_flag_tv)");
        this.channelTopFlagTv = (TextView) findViewById2;
        e();
        final View view2 = this.headerRoot;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("headerRoot");
            view2 = null;
        }
        final long j3 = 200;
        view2.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.feed.topic.adapter.section.GuildFeedSingleHeadComponents$onInitView$$inlined$setSingleClickListener$1
            @Override // android.view.View.OnClickListener
            public final void onClick(View it) {
                EventCollector.getInstance().onViewClickedBefore(it);
                view2.setClickable(false);
                Intrinsics.checkNotNullExpressionValue(it, "it");
                this.getDepends().b();
                final View view3 = view2;
                view3.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.topic.adapter.section.GuildFeedSingleHeadComponents$onInitView$$inlined$setSingleClickListener$1.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        view3.setClickable(true);
                    }
                }, j3);
                EventCollector.getInstance().onViewClicked(it);
            }
        });
        TextView textView2 = this.nickNameTv;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nickNameTv");
        } else {
            textView = textView2;
        }
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.feed.topic.adapter.section.GuildFeedSingleHeadComponents$onInitView$$inlined$setSingleClickListener$2
            @Override // android.view.View.OnClickListener
            public final void onClick(View it) {
                EventCollector.getInstance().onViewClickedBefore(it);
                textView.setClickable(false);
                Intrinsics.checkNotNullExpressionValue(it, "it");
                this.getDepends().a(it);
                final View view3 = textView;
                view3.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.topic.adapter.section.GuildFeedSingleHeadComponents$onInitView$$inlined$setSingleClickListener$2.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        view3.setClickable(true);
                    }
                }, j3);
                EventCollector.getInstance().onViewClicked(it);
            }
        });
    }
}
