package com.tencent.mobileqq.guild.feed.feedsquare.section;

import android.view.View;
import android.widget.ImageView;
import com.tencent.biz.richframework.part.adapter.section.Section;
import com.tencent.mobileqq.guild.feed.feedsquare.section.GuildFeedSingleImageComponents;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedBaseInitBean;
import com.tencent.mobileqq.guild.feed.nativedetail.content.feedmain.data.GProStFeedDetailRspWrapper;
import com.tencent.mobileqq.guild.feed.publish.bean.GuildTaskProgressState;
import com.tencent.mobileqq.guild.feed.report.GuildFeedReportTable12003;
import com.tencent.mobileqq.guild.feed.util.ax;
import com.tencent.mobileqq.guild.report.GuildChannelReportManager;
import com.tencent.qqmini.sdk.core.ReportConst;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStFeed;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStImage;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001cB\u0007\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J\b\u0010\n\u001a\u00020\tH\u0014J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0006H\u0014J*\u0010\u0014\u001a\u00020\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0010\u001a\u00020\u000f2\u000e\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011H\u0016R\u0014\u0010\u0018\u001a\u00020\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/feedsquare/section/am;", "Lcom/tencent/mobileqq/guild/feed/feedsquare/section/GuildFeedSquareFeedBaseSection;", "Landroid/widget/ImageView;", "image", "", "U", "Landroid/view/View;", "view", "T", "", "getViewStubLayoutId", "containerView", "onInitView", "Lcom/tencent/mobileqq/guild/feed/feedsquare/data/h;", "data", "", "position", "", "", "payload", "M", "Lcom/tencent/mobileqq/guild/feed/feedsquare/section/GuildFeedSingleImageComponents;", "e", "Lcom/tencent/mobileqq/guild/feed/feedsquare/section/GuildFeedSingleImageComponents;", "components", "<init>", "()V", "f", "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class am extends GuildFeedSquareFeedBaseSection {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final GuildFeedSingleImageComponents components = new GuildFeedSingleImageComponents(new b());

    /* compiled from: P */
    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\n\u0010\n\u001a\u0004\u0018\u00010\tH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/guild/feed/feedsquare/section/am$b", "Lcom/tencent/mobileqq/guild/feed/feedsquare/section/GuildFeedSingleImageComponents$b;", "Landroid/widget/ImageView;", "image", "", "c", "Landroid/view/View;", "imageView", "b", "", "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class b implements GuildFeedSingleImageComponents.b {
        b() {
        }

        @Override // com.tencent.mobileqq.guild.feed.feedsquare.section.GuildFeedSingleImageComponents.b
        @Nullable
        public Object a() {
            GuildTaskProgressState p16 = ((com.tencent.mobileqq.guild.feed.feedsquare.data.h) ((Section) am.this).mData).getBlockData().p();
            if (p16 != null) {
                return p16.mTaskId;
            }
            return null;
        }

        @Override // com.tencent.mobileqq.guild.feed.feedsquare.section.GuildFeedSingleImageComponents.b
        public void b(@NotNull View imageView) {
            Intrinsics.checkNotNullParameter(imageView, "imageView");
            am.this.A(imageView, "em_sgrp_forum_full_screen");
        }

        @Override // com.tencent.mobileqq.guild.feed.feedsquare.section.GuildFeedSingleImageComponents.b
        public void c(@NotNull ImageView image) {
            Intrinsics.checkNotNullParameter(image, "image");
            am.this.U(image);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void T(View view) {
        String pageForumType;
        if (view == null) {
            return;
        }
        GuildFeedBaseInitBean q16 = ax.q(this.mRootView.getContext());
        GProStFeed b16 = ((com.tencent.mobileqq.guild.feed.feedsquare.data.h) this.mData).getBlockData().b();
        if (q16 == null) {
            pageForumType = "";
        } else {
            pageForumType = q16.getPageForumType(q16.getPageId());
        }
        GuildFeedReportTable12003.b(new GuildFeedReportTable12003.a(com.tencent.mobileqq.guild.feed.report.f.b(b16, pageForumType).K(ReportConst.ACTION.FULLSCREEN).J("success").Y("pg_channel_forum_page")));
        GuildChannelReportManager.f231987a.f(GuildChannelReportManager.PageType.CHANNEL_PAGE_FEED_LIST, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void U(ImageView image) {
        GProStImage stImage = ((com.tencent.mobileqq.guild.feed.feedsquare.data.h) this.mData).getBlockData().b().images.get(0);
        GProStFeed b16 = ((com.tencent.mobileqq.guild.feed.feedsquare.data.h) this.mData).getBlockData().b();
        if (b16 == null) {
            return;
        }
        com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.widget.j jVar = com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.widget.j.f221614a;
        Intrinsics.checkNotNullExpressionValue(stImage, "stImage");
        jVar.b(image, b16, stImage, p(), com.tencent.mobileqq.guild.feed.feedsquare.data.g.b(((com.tencent.mobileqq.guild.feed.feedsquare.data.h) this.mData).getBlockData()));
        T(image);
    }

    @Override // com.tencent.mobileqq.guild.feed.feedsquare.section.GuildFeedSquareFeedBaseSection
    public void M(@Nullable com.tencent.mobileqq.guild.feed.feedsquare.data.h data, int position, @Nullable List<Object> payload) {
        GProStFeed D = D();
        if (D == null) {
            return;
        }
        this.components.g(new GProStFeedDetailRspWrapper(D, null, 2, null), position, payload);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    @NotNull
    public int[] getViewStubLayoutId() {
        return this.components.f();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public void onInitView(@NotNull View containerView) {
        Intrinsics.checkNotNullParameter(containerView, "containerView");
        this.components.h(containerView);
    }
}
