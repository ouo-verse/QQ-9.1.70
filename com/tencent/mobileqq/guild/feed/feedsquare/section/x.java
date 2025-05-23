package com.tencent.mobileqq.guild.feed.feedsquare.section;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedDetailInitBean;
import com.tencent.mobileqq.guild.feed.topic.adapter.section.GuildFeedHeadBindParams;
import com.tencent.mobileqq.guild.feed.topic.adapter.section.GuildFeedSingleHeadComponents;
import com.tencent.mobileqq.guild.feed.util.ax;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStFeed;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStUser;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u001f2\u00020\u0001:\u0001 B\u0007\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\t\u001a\u00020\bH\u0002J\b\u0010\u000b\u001a\u00020\nH\u0014J\u0010\u0010\r\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u0004H\u0014J*\u0010\u0015\u001a\u00020\u00022\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0011\u001a\u00020\u00102\u000e\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0012H\u0016J\b\u0010\u0016\u001a\u00020\bH\u0016R\u0016\u0010\f\u001a\u00020\u00048\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0014\u0010\u001c\u001a\u00020\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001b\u00a8\u0006!"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/feedsquare/section/x;", "Lcom/tencent/mobileqq/guild/feed/feedsquare/section/GuildFeedSquareFeedBaseSection;", "", "W", "Landroid/view/View;", "view", "V", "T", "", "U", "", "getViewStubLayoutId", "containerView", "onInitView", "Lcom/tencent/mobileqq/guild/feed/feedsquare/data/h;", "data", "", "position", "", "", "payload", "M", "v", "e", "Landroid/view/View;", "Lcom/tencent/mobileqq/guild/feed/topic/adapter/section/GuildFeedSingleHeadComponents;", "f", "Lcom/tencent/mobileqq/guild/feed/topic/adapter/section/GuildFeedSingleHeadComponents;", "components", "<init>", "()V", tl.h.F, "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class x extends GuildFeedSquareFeedBaseSection {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private View containerView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final GuildFeedSingleHeadComponents components = new GuildFeedSingleHeadComponents(new b());

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/guild/feed/feedsquare/section/x$b", "Lcom/tencent/mobileqq/guild/feed/topic/adapter/section/GuildFeedSingleHeadComponents$b;", "", "b", "Landroid/view/View;", "v", "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class b implements GuildFeedSingleHeadComponents.b {
        b() {
        }

        @Override // com.tencent.mobileqq.guild.feed.topic.adapter.section.GuildFeedSingleHeadComponents.b
        public void a(@NotNull View v3) {
            Intrinsics.checkNotNullParameter(v3, "v");
            x.this.V(v3);
        }

        @Override // com.tencent.mobileqq.guild.feed.topic.adapter.section.GuildFeedSingleHeadComponents.b
        public void b() {
            x.this.W();
        }
    }

    private final void T(View view) {
        Map map;
        GProStFeed D = D();
        if (D == null) {
            return;
        }
        GuildFeedDetailInitBean F = F(D);
        com.tencent.mobileqq.guild.feed.report.e.c(D, "avatar_click", F.getPageId(), F.getPageForumType(F.getPageId()), F.getPrePageId(), F.getPrePageForumType(F.getPrePageId()));
        String U = U();
        map = MapsKt__MapsKt.toMap(C());
        com.tencent.mobileqq.guild.feed.report.d.a("clck", view, U, map);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final String U() {
        switch (((com.tencent.mobileqq.guild.feed.feedsquare.data.h) this.mData).b()) {
            case 13:
                return "em_sgrp_nowplay_avatar";
            case 14:
                return "em_sgrp_voice_avatar";
            case 15:
                return "em_sgrp_single_event_avatar";
            default:
                return "em_sgrp_forum_avatar";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void V(View view) {
        GProStFeed D = D();
        if (D == null) {
            return;
        }
        String str = D.idd;
        String valueOf = String.valueOf(D.channelInfo.sign.guildId);
        String valueOf2 = String.valueOf(D.channelInfo.sign.channelId);
        QLog.d(v(), 1, "open profileCard guildId:" + valueOf + ", feedId:" + str + ", tinyId:" + valueOf2);
        Context context = view.getContext();
        Intrinsics.checkNotNull(context, "null cannot be cast to non-null type android.app.Activity");
        ax.I((Activity) context, valueOf, valueOf2, D.poster.idd, str, p(), r());
        T(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void W() {
        GProStFeed gProStFeed;
        ij1.g blockData;
        com.tencent.mobileqq.guild.feed.feedsquare.data.h hVar = (com.tencent.mobileqq.guild.feed.feedsquare.data.h) this.mData;
        if (hVar != null && (blockData = hVar.getBlockData()) != null) {
            gProStFeed = blockData.b();
        } else {
            gProStFeed = null;
        }
        if (gProStFeed == null) {
            return;
        }
        K(gProStFeed, 0, 1);
    }

    @Override // com.tencent.mobileqq.guild.feed.feedsquare.section.GuildFeedSquareFeedBaseSection
    public void M(@Nullable com.tencent.mobileqq.guild.feed.feedsquare.data.h data, int position, @Nullable List<Object> payload) {
        GProStUser gProStUser;
        if (data != null && (gProStUser = data.getBlockData().b().poster) != null) {
            Intrinsics.checkNotNullExpressionValue(gProStUser, "it.blockData.sourceData.poster ?: return@let");
            GProStFeed b16 = data.getBlockData().b();
            if (b16 != null) {
                Intrinsics.checkNotNullExpressionValue(b16, "it.blockData.sourceData ?: return@let");
                String str = gProStUser.nick;
                Intrinsics.checkNotNullExpressionValue(str, "user.nick");
                String str2 = gProStUser.manageTag.tagName;
                Intrinsics.checkNotNullExpressionValue(str2, "user.manageTag.tagName");
                GuildFeedHeadBindParams guildFeedHeadBindParams = new GuildFeedHeadBindParams(str, str2, gProStUser.manageTag.color, null, 0, null, 56, null);
                View view = this.containerView;
                if (view == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("containerView");
                    view = null;
                }
                Context context = view.getContext();
                if (b16.channelTopInfo.isTop) {
                    String string = context.getString(R.string.f155871io);
                    Intrinsics.checkNotNullExpressionValue(string, "getString(com.tencent.mo\u2026.string.guild_set_to_top)");
                    guildFeedHeadBindParams = GuildFeedHeadBindParams.b(guildFeedHeadBindParams, null, null, 0, string, R.color.qui_common_feedback_error, "#F74C30", 7, null);
                }
                this.components.f(guildFeedHeadBindParams, position, payload);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    @NotNull
    public int[] getViewStubLayoutId() {
        return this.components.d();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public void onInitView(@NotNull View containerView) {
        Intrinsics.checkNotNullParameter(containerView, "containerView");
        View findViewById = containerView.findViewById(R.id.wae);
        Intrinsics.checkNotNullExpressionValue(findViewById, "containerView.findViewBy\u2026_feed_item_header_layout)");
        this.containerView = findViewById;
        this.components.g(containerView);
    }

    @Override // com.tencent.mobileqq.guild.feed.feedsquare.section.n
    @NotNull
    public String v() {
        return "GuildFeedSquareFeedHeaderSection";
    }
}
