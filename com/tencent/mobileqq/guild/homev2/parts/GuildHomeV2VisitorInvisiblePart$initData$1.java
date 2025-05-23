package com.tencent.mobileqq.guild.homev2.parts;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.view.View;
import android.view.ViewStub;
import android.view.WindowInsets;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.guild.aio.util.ex.ViewExtKt;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.ep;
import com.tencent.mobileqq.guild.homev2.viewmodels.GuildHomeViewModel;
import com.tencent.mobileqq.guild.jump.GuildJumpUtil;
import com.tencent.mobileqq.guild.util.GuildUIUtils;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.mobileqq.guild.util.v;
import com.tencent.mobileqq.guild.widget.ShadowFrameLayout;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProJoinGuildResult;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/tencent/mobileqq/guild/homev2/viewmodels/GuildHomeViewModel$b;", "kotlin.jvm.PlatformType", "it", "", "invoke", "(Lcom/tencent/mobileqq/guild/homev2/viewmodels/GuildHomeViewModel$b;)V", "<anonymous>"}, k = 3, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildHomeV2VisitorInvisiblePart$initData$1 extends Lambda implements Function1<GuildHomeViewModel.GuildHomeUiState, Unit> {
    final /* synthetic */ GuildHomeV2VisitorInvisiblePart this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildHomeV2VisitorInvisiblePart$initData$1(GuildHomeV2VisitorInvisiblePart guildHomeV2VisitorInvisiblePart) {
        super(1);
        this.this$0 = guildHomeV2VisitorInvisiblePart;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final WindowInsets d(View this_apply, View view, WindowInsets windowInsets) {
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        ViewExtKt.f(this_apply, 0);
        return windowInsets;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(GuildHomeV2VisitorInvisiblePart this$0, View view) {
        String str;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!com.tencent.mobileqq.guild.util.o.a(view)) {
            str = this$0.guildNumber;
            com.tencent.mobileqq.guild.util.b.a(str);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(final GuildHomeV2VisitorInvisiblePart this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Context context = this$0.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        com.tencent.mobileqq.guild.channel.joinchannel.q.c(context, this$0.C9().getJumpGuildParam(), false, 1, new Function1<IGProJoinGuildResult, Unit>() { // from class: com.tencent.mobileqq.guild.homev2.parts.GuildHomeV2VisitorInvisiblePart$initData$1$3$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(IGProJoinGuildResult iGProJoinGuildResult) {
                invoke2(iGProJoinGuildResult);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull IGProJoinGuildResult result) {
                List listOf;
                Intrinsics.checkNotNullParameter(result, "result");
                Activity a16 = ep.a(GuildHomeV2VisitorInvisiblePart.this.getContext());
                if (GuildHomeV2VisitorInvisiblePart.this.getContext() == null || a16 == null || a16.isFinishing() || a16.isDestroyed() || !com.tencent.mobileqq.guild.channel.joinchannel.h.d(result.getRetCode(), result.getSecRet())) {
                    return;
                }
                listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new Integer[]{1, 2, 3, 4, 6, 7});
                if (listOf.contains(Integer.valueOf(GuildHomeV2VisitorInvisiblePart.this.C9().getJumpGuildParam().businessType))) {
                    Context context2 = GuildHomeV2VisitorInvisiblePart.this.getContext();
                    Intrinsics.checkNotNullExpressionValue(context2, "context");
                    GuildJumpUtil.n(context2, GuildHomeV2VisitorInvisiblePart.this.C9().getJumpGuildParam());
                }
            }
        });
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(GuildHomeViewModel.GuildHomeUiState guildHomeUiState) {
        invoke2(guildHomeUiState);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0145, code lost:
    
        r4 = r3.welcomeIcon;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0157, code lost:
    
        r4 = r3.contentViewWrapper;
     */
    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void invoke2(GuildHomeViewModel.GuildHomeUiState guildHomeUiState) {
        View view;
        View view2;
        View view3;
        TextView textView;
        TextView textView2;
        TextView textView3;
        TextView textView4;
        TextView textView5;
        ImageView imageView;
        TextView textView6;
        TextView textView7;
        TextView textView8;
        TextView textView9;
        View view4;
        TextView textView10;
        TextView textView11;
        TextView textView12;
        final View view5;
        ShadowFrameLayout shadowFrameLayout;
        ImageView imageView2;
        IGProGuildInfo guildInfo = guildHomeUiState.getGuildInfo();
        if (guildInfo == null) {
            return;
        }
        if (guildHomeUiState.getIsNormalGuild() || guildHomeUiState.getIsBanedGuild() || guildHomeUiState.getIsVisitorVisibleGuild()) {
            view = this.this$0.com.google.android.exoplayer2.text.ttml.TtmlNode.TAG_LAYOUT java.lang.String;
            if (view == null) {
                return;
            }
            view.setVisibility(8);
            return;
        }
        view2 = this.this$0.com.google.android.exoplayer2.text.ttml.TtmlNode.TAG_LAYOUT java.lang.String;
        if (view2 == null) {
            ViewStub viewStub = (ViewStub) this.this$0.getPartRootView().findViewById(R.id.wjw);
            GuildHomeV2VisitorInvisiblePart guildHomeV2VisitorInvisiblePart = this.this$0;
            if (viewStub == null || (view5 = viewStub.inflate()) == null) {
                view5 = null;
            } else {
                final GuildHomeV2VisitorInvisiblePart guildHomeV2VisitorInvisiblePart2 = this.this$0;
                guildHomeV2VisitorInvisiblePart2.welcomeIcon = (ImageView) view5.findViewById(R.id.f165653x53);
                guildHomeV2VisitorInvisiblePart2.welcomeTitle = view5.findViewById(R.id.x56);
                guildHomeV2VisitorInvisiblePart2.inviterTv = (TextView) view5.findViewById(R.id.wjx);
                guildHomeV2VisitorInvisiblePart2.welcomeTitleTv = (TextView) view5.findViewById(R.id.wjy);
                guildHomeV2VisitorInvisiblePart2.welcomeTips = view5.findViewById(R.id.x55);
                guildHomeV2VisitorInvisiblePart2.welcomeTipsTv = (TextView) view5.findViewById(R.id.f165644x40);
                guildHomeV2VisitorInvisiblePart2.contentViewWrapper = (ShadowFrameLayout) view5.findViewById(R.id.w2z);
                guildHomeV2VisitorInvisiblePart2.contentView = view5.findViewById(R.id.w2y);
                guildHomeV2VisitorInvisiblePart2.guildCoverIv = (ImageView) view5.findViewById(R.id.f165455w32);
                guildHomeV2VisitorInvisiblePart2.guildMetalContainer = (LinearLayout) view5.findViewById(R.id.wpn);
                guildHomeV2VisitorInvisiblePart2.guildNameTv = (TextView) view5.findViewById(R.id.x3n);
                guildHomeV2VisitorInvisiblePart2.spacingView = view5.findViewById(R.id.x1_);
                guildHomeV2VisitorInvisiblePart2.memberNumTv = (TextView) view5.findViewById(R.id.wqv);
                guildHomeV2VisitorInvisiblePart2.feedNumTv = (TextView) view5.findViewById(R.id.wcg);
                guildHomeV2VisitorInvisiblePart2.guildDescTv = (TextView) view5.findViewById(R.id.w3j);
                guildHomeV2VisitorInvisiblePart2.guildJoinBtn = view5.findViewById(R.id.wku);
                guildHomeV2VisitorInvisiblePart2.tvGuildStrNumber = (TextView) view5.findViewById(R.id.x1h);
                view5.setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener() { // from class: com.tencent.mobileqq.guild.homev2.parts.f
                    @Override // android.view.View.OnApplyWindowInsetsListener
                    public final WindowInsets onApplyWindowInsets(View view6, WindowInsets windowInsets) {
                        WindowInsets d16;
                        d16 = GuildHomeV2VisitorInvisiblePart$initData$1.d(view5, view6, windowInsets);
                        return d16;
                    }
                });
                view5.findViewById(R.id.x1i).setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.homev2.parts.g
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view6) {
                        GuildHomeV2VisitorInvisiblePart$initData$1.e(GuildHomeV2VisitorInvisiblePart.this, view6);
                    }
                });
                ImageView imageView3 = (ImageView) view5.findViewById(R.id.y4v);
                Context context = view5.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "context");
                imageView3.setImageDrawable(GuildUIUtils.y(context, R.drawable.qui_copy, QQGuildUIUtil.i(view5.getContext(), R.color.qui_common_text_secondary)));
                if (QQTheme.isNowThemeIsNight() && imageView2 != null) {
                    imageView2.setImageResource(R.drawable.guild_home_visitor_top_bg_night);
                }
                if (Build.VERSION.SDK_INT < 28 && shadowFrameLayout != null) {
                    shadowFrameLayout.setBorder(Color.parseColor("#15000000"), ViewUtils.dip2px(1.0f));
                }
                guildHomeV2VisitorInvisiblePart2.updateView();
            }
            guildHomeV2VisitorInvisiblePart.com.google.android.exoplayer2.text.ttml.TtmlNode.TAG_LAYOUT java.lang.String = view5;
        }
        view3 = this.this$0.com.google.android.exoplayer2.text.ttml.TtmlNode.TAG_LAYOUT java.lang.String;
        if (view3 != null) {
            view3.setVisibility(0);
        }
        String string = this.this$0.C9().getJumpGuildParam().extras.getString("jump_guild_guest_inviter_name");
        int i3 = this.this$0.C9().getJumpGuildParam().extras.getInt("jump_guild_guest_feed_num");
        boolean z16 = true;
        if (string == null || string.length() == 0) {
            textView11 = this.this$0.welcomeTitleTv;
            if (textView11 != null) {
                textView11.setText("\u52a0\u5165\u540e\u53ef\u67e5\u770b");
            }
            textView12 = this.this$0.welcomeTipsTv;
            if (textView12 != null) {
                textView12.setText("\u9891\u9053\u672a\u5bf9\u8bbf\u5ba2\u516c\u5f00");
            }
        } else {
            textView = this.this$0.welcomeTitleTv;
            if (textView != null) {
                textView.setText(" \u9080\u8bf7\u4f60\u52a0\u5165");
            }
            textView2 = this.this$0.welcomeTipsTv;
            if (textView2 != null) {
                textView2.setText("\u52a0\u5165\u540e\u53ef\u67e5\u770b\u5168\u90e8\u5185\u5bb9");
            }
        }
        textView3 = this.this$0.inviterTv;
        if (textView3 != null) {
            textView3.setText(string);
        }
        textView4 = this.this$0.guildNameTv;
        if (textView4 != null) {
            textView4.setText(guildInfo.getGuildName());
        }
        GuildHomeV2VisitorInvisiblePart guildHomeV2VisitorInvisiblePart3 = this.this$0;
        String guildNumber = guildInfo.getGuildNumber();
        Intrinsics.checkNotNullExpressionValue(guildNumber, "guildInfo.guildNumber");
        guildHomeV2VisitorInvisiblePart3.guildNumber = guildNumber;
        textView5 = this.this$0.tvGuildStrNumber;
        if (textView5 != null) {
            textView5.setText("\u9891\u9053\u53f7: " + guildInfo.getGuildNumber());
        }
        imageView = this.this$0.guildCoverIv;
        if (imageView != null) {
            String avatarUrl = guildInfo.getAvatarUrl(140);
            Intrinsics.checkNotNullExpressionValue(avatarUrl, "guildInfo.getAvatarUrl(I\u2026ldAvatarUrlType.SIZE_140)");
            v.i(avatarUrl, imageView);
        }
        textView6 = this.this$0.memberNumTv;
        if (textView6 != null) {
            textView6.setText(cp1.c.f391536a.a(guildInfo.getUserNum(), ""));
        }
        textView7 = this.this$0.feedNumTv;
        if (textView7 != null) {
            textView7.setText(cp1.c.f391536a.a(i3, ""));
        }
        String profile = guildInfo.getProfile();
        if (profile != null && profile.length() != 0) {
            z16 = false;
        }
        if (z16) {
            textView10 = this.this$0.guildDescTv;
            if (textView10 != null) {
                textView10.setVisibility(8);
            }
        } else {
            textView8 = this.this$0.guildDescTv;
            if (textView8 != null) {
                textView8.setVisibility(0);
            }
            textView9 = this.this$0.guildDescTv;
            if (textView9 != null) {
                textView9.setText(guildInfo.getProfile());
            }
        }
        view4 = this.this$0.guildJoinBtn;
        if (view4 != null) {
            final GuildHomeV2VisitorInvisiblePart guildHomeV2VisitorInvisiblePart4 = this.this$0;
            view4.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.homev2.parts.h
                @Override // android.view.View.OnClickListener
                public final void onClick(View view6) {
                    GuildHomeV2VisitorInvisiblePart$initData$1.f(GuildHomeV2VisitorInvisiblePart.this, view6);
                }
            });
        }
        this.this$0.ua(guildInfo);
        this.this$0.ra();
    }
}
