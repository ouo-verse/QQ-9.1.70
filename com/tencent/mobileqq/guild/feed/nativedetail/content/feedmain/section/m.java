package com.tencent.mobileqq.guild.feed.nativedetail.content.feedmain.section;

import android.content.Context;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.guild.feed.feedsquare.section.h;
import com.tencent.mobileqq.guild.feed.guildpanel.prefer.GuildFeedUserPreferListFragment;
import com.tencent.mobileqq.guild.feed.nativedetail.content.feedmain.FeedDetailMainData;
import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.common.EventAgingType;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStFeed;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\b\u0010\u0003\u001a\u00020\u0002H\u0014J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0014J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0014J4\u0010\u0013\u001a\u00020\u00062\b\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u000e\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u00102\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0014J\b\u0010\u0015\u001a\u00020\u0014H\u0014R\u0014\u0010\u0019\u001a\u00020\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativedetail/content/feedmain/section/m;", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/feedmain/section/e;", "", "getViewStubLayoutId", "Landroid/view/View;", "containerView", "", "onInitView", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/feedmain/FeedDetailMainData$c$c;", "payload", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/feedmain/FeedDetailMainData;", "data", "", "position", "", "", "payloads", "t", "", "getLogTag", "Lcom/tencent/mobileqq/guild/feed/feedsquare/section/h;", "d", "Lcom/tencent/mobileqq/guild/feed/feedsquare/section/h;", "components", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class m extends e {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.guild.feed.feedsquare.section.h components = new com.tencent.mobileqq.guild.feed.feedsquare.section.h(new a(), false);

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/guild/feed/nativedetail/content/feedmain/section/m$a", "Lcom/tencent/mobileqq/guild/feed/feedsquare/section/h$b;", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStFeed;", "stFeed", "", "a", "b", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class a implements h.b {
        a() {
        }

        @Override // com.tencent.mobileqq.guild.feed.feedsquare.section.h.b
        public void a(@NotNull View rootView, @NotNull GProStFeed stFeed) {
            FragmentActivity fragmentActivity;
            FragmentManager fragmentManager;
            int i3;
            Integer businessType;
            Intrinsics.checkNotNullParameter(rootView, "rootView");
            Intrinsics.checkNotNullParameter(stFeed, "stFeed");
            Context context = rootView.getContext();
            JumpGuildParam.JoinInfoParam joinInfoParam = null;
            if (context instanceof FragmentActivity) {
                fragmentActivity = (FragmentActivity) context;
            } else {
                fragmentActivity = null;
            }
            if (fragmentActivity != null) {
                fragmentManager = fragmentActivity.getSupportFragmentManager();
            } else {
                fragmentManager = null;
            }
            rl1.a p16 = m.this.p();
            if (p16 != null && (businessType = p16.getBusinessType()) != null) {
                i3 = businessType.intValue();
            } else {
                i3 = 0;
            }
            int i16 = i3;
            rl1.a p17 = m.this.p();
            if (p17 != null) {
                joinInfoParam = p17.b();
            }
            JumpGuildParam.JoinInfoParam joinInfoParam2 = joinInfoParam;
            if (fragmentManager != null) {
                GuildFeedUserPreferListFragment.INSTANCE.a(fragmentManager, stFeed, i16, joinInfoParam2, "pg_sgrp_forum_detail");
            }
        }

        @Override // com.tencent.mobileqq.guild.feed.feedsquare.section.h.b
        public void b(@NotNull View rootView, @NotNull GProStFeed stFeed) {
            Intrinsics.checkNotNullParameter(rootView, "rootView");
            Intrinsics.checkNotNullParameter(stFeed, "stFeed");
            VideoReport.setEventType(rootView, EventAgingType.REALTIME);
            String str = stFeed.idd;
            Intrinsics.checkNotNullExpressionValue(str, "stFeed.idd");
            if1.a.b(rootView, "em_sgrp_overt_like_frame", str, null, null, null, null, null, null, 252, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    @NotNull
    /* renamed from: getLogTag */
    public String getTAG() {
        return "GuildFeedMainPreferSection";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    @NotNull
    public int[] getViewStubLayoutId() {
        return this.components.g();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public void onInitView(@NotNull View containerView) {
        Intrinsics.checkNotNullParameter(containerView, "containerView");
        this.components.m(containerView);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.feedmain.section.e
    public boolean q(@NotNull FeedDetailMainData.c.C7755c payload) {
        Intrinsics.checkNotNullParameter(payload, "payload");
        if (!super.q(payload) && payload.getType() != 7) {
            return false;
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.feedmain.section.e
    protected void t(@Nullable FeedDetailMainData data, int position, @Nullable List<Object> payloads, @Nullable FeedDetailMainData.c.C7755c payload) {
        if (data == 0) {
            return;
        }
        this.mData = data;
        this.components.k(data.getFeedDetail(), position, payloads);
    }
}
