package com.tencent.mobileqq.guild.feed.feedlist.section;

import android.content.Context;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.richframework.part.adapter.section.Section;
import com.tencent.mobileqq.guild.api.FeedListSectionType;
import com.tencent.mobileqq.guild.feed.feedsquare.section.f;
import com.tencent.mobileqq.guild.feed.feedsquare.utils.AbsGuildFeedMediaSizeUtils;
import com.tencent.mobileqq.guild.media.widget.RoundCornerLayout;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.common.EventAgingType;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import rj1.b;

/* compiled from: P */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0016\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u0003B\u0007\u00a2\u0006\u0004\b&\u0010'J\b\u0010\u0005\u001a\u00020\u0004H\u0014J\u0012\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0014J0\u0010\u0011\u001a\u00020\b2\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\n2\u0006\u0010\r\u001a\u00020\f2\u000e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eH\u0014J\u0010\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u0012H\u0016R\u001b\u0010\u001a\u001a\u00020\u00158BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u001a\u0010 \u001a\u00020\u001b8\u0014X\u0094\u0004\u00a2\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u001b\u0010%\u001a\u00020!8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\"\u0010\u0017\u001a\u0004\b#\u0010$\u00a8\u0006("}, d2 = {"Lcom/tencent/mobileqq/guild/feed/feedlist/section/FeedListMultiImageSection;", "Lrj1/b;", "Ext", "Ltk1/a;", "", "getViewStubLayoutId", "Landroid/view/View;", "initContainerView", "", "onInitView", "Ltk1/c;", "bindData", "", "position", "", "", "payload", "u", "", "attached", "onAttachedChanged", "Lcom/tencent/mobileqq/guild/feed/feedsquare/utils/AbsGuildFeedMediaSizeUtils;", BdhLogUtil.LogTag.Tag_Conn, "Lkotlin/Lazy;", "H", "()Lcom/tencent/mobileqq/guild/feed/feedsquare/utils/AbsGuildFeedMediaSizeUtils;", "feedMediaSizeUtil", "Lcom/tencent/mobileqq/guild/feed/feedsquare/section/f$b;", "D", "Lcom/tencent/mobileqq/guild/feed/feedsquare/section/f$b;", "G", "()Lcom/tencent/mobileqq/guild/feed/feedsquare/section/f$b;", "depends", "Lcom/tencent/mobileqq/guild/feed/feedsquare/section/f;", "E", UserInfo.SEX_FEMALE, "()Lcom/tencent/mobileqq/guild/feed/feedsquare/section/f;", "components", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public class FeedListMultiImageSection<Ext extends rj1.b> extends tk1.a<Ext> {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final Lazy feedMediaSizeUtil;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final f.b depends;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final Lazy components;

    /* compiled from: P */
    @Metadata(d1 = {"\u00007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J\u0018\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0016J\u001a\u0010\u000f\u001a\u00020\n2\b\u0010\f\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000e\u001a\u00020\rH\u0016J\u0010\u0010\u0010\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\bH\u0016J\b\u0010\u0012\u001a\u00020\u0011H\u0016R\u001a\u0010\u0017\u001a\u00020\u00028\u0016X\u0096D\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\u00a8\u0006\u0018"}, d2 = {"com/tencent/mobileqq/guild/feed/feedlist/section/FeedListMultiImageSection$a", "Lcom/tencent/mobileqq/guild/feed/feedsquare/section/f$b;", "", "dataSize", "d", "Landroidx/recyclerview/widget/RecyclerView$RecycledViewPool;", "getRecycledViewPool", com.tencent.luggage.wxa.c8.c.G, "Landroid/view/View;", "view", "", "i", "v", "", "elementId", "c", tl.h.F, "Lcom/tencent/mobileqq/guild/feed/feedsquare/utils/AbsGuildFeedMediaSizeUtils;", "e", "a", "I", "g", "()I", "maxRow", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class a implements f.b {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final int maxRow = 1;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ FeedListMultiImageSection<Ext> f218588b;

        a(FeedListMultiImageSection<Ext> feedListMultiImageSection) {
            this.f218588b = feedListMultiImageSection;
        }

        @Override // com.tencent.mobileqq.guild.feed.feedsquare.section.f.b
        @Nullable
        public Object a() {
            return f.b.a.b(this);
        }

        @Override // com.tencent.mobileqq.guild.feed.feedsquare.section.f.b
        public void c(@Nullable View v3, @NotNull String elementId) {
            Intrinsics.checkNotNullParameter(elementId, "elementId");
            if (v3 == null) {
                return;
            }
            VideoReport.setEventType(v3, EventAgingType.REALTIME);
            if1.a.b(v3, "em_sgrp_forum_full_screen", ((Section) this.f218588b).mData.hashCode() + "#" + v3.hashCode(), null, ExposurePolicy.REPORT_NONE, null, null, null, null, 244, null);
        }

        @Override // com.tencent.mobileqq.guild.feed.feedsquare.section.f.b
        public int d(int dataSize) {
            return 3;
        }

        @Override // com.tencent.mobileqq.guild.feed.feedsquare.section.f.b
        @NotNull
        public AbsGuildFeedMediaSizeUtils e() {
            return this.f218588b.H();
        }

        @Override // com.tencent.mobileqq.guild.feed.feedsquare.section.f.b
        public void f(@NotNull RoundCornerLayout roundCornerLayout, int i3, int i16) {
            f.b.a.c(this, roundCornerLayout, i3, i16);
        }

        @Override // com.tencent.mobileqq.guild.feed.feedsquare.section.f.b
        /* renamed from: g, reason: from getter */
        public int getMaxRow() {
            return this.maxRow;
        }

        @Override // com.tencent.mobileqq.guild.feed.feedsquare.section.f.b
        @Nullable
        public RecyclerView.RecycledViewPool getRecycledViewPool() {
            return null;
        }

        @Override // com.tencent.mobileqq.guild.feed.feedsquare.section.f.b
        public void h(@NotNull View v3) {
            Intrinsics.checkNotNullParameter(v3, "v");
            rj1.a aVar = rj1.a.f431544a;
            Context context = v3.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "v.context");
            aVar.h(context, this.f218588b.r(), FeedListMultiImageSection.B(this.f218588b));
        }

        @Override // com.tencent.mobileqq.guild.feed.feedsquare.section.f.b
        public void i(int pos, @NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            rj1.a.f431544a.i(view, this.f218588b.r(), FeedListMultiImageSection.B(this.f218588b), pos);
        }
    }

    public FeedListMultiImageSection() {
        super(FeedListSectionType.MultiImage);
        Lazy lazy;
        Lazy lazy2;
        lazy = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.PUBLICATION, (Function0) new Function0<AbsGuildFeedMediaSizeUtils>(this) { // from class: com.tencent.mobileqq.guild.feed.feedlist.section.FeedListMultiImageSection$feedMediaSizeUtil$2
            final /* synthetic */ FeedListMultiImageSection<Ext> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.this$0 = this;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final AbsGuildFeedMediaSizeUtils invoke() {
                View p16;
                p16 = this.this$0.p();
                return com.tencent.mobileqq.guild.feed.feedsquare.utils.g.b(p16);
            }
        });
        this.feedMediaSizeUtil = lazy;
        this.depends = new a(this);
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<com.tencent.mobileqq.guild.feed.feedsquare.section.f>(this) { // from class: com.tencent.mobileqq.guild.feed.feedlist.section.FeedListMultiImageSection$components$2
            final /* synthetic */ FeedListMultiImageSection<Ext> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.this$0 = this;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final com.tencent.mobileqq.guild.feed.feedsquare.section.f invoke() {
                return new com.tencent.mobileqq.guild.feed.feedsquare.section.f(this.this$0.getDepends());
            }
        });
        this.components = lazy2;
    }

    public static final /* synthetic */ rj1.b B(FeedListMultiImageSection feedListMultiImageSection) {
        return (rj1.b) feedListMultiImageSection.s();
    }

    private final com.tencent.mobileqq.guild.feed.feedsquare.section.f F() {
        return (com.tencent.mobileqq.guild.feed.feedsquare.section.f) this.components.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AbsGuildFeedMediaSizeUtils H() {
        return (AbsGuildFeedMediaSizeUtils) this.feedMediaSizeUtil.getValue();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    /* renamed from: G, reason: from getter */
    public f.b getDepends() {
        return this.depends;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    @NotNull
    public int[] getViewStubLayoutId() {
        return F().e();
    }

    @Override // com.tencent.biz.richframework.part.adapter.section.Section, com.tencent.biz.richframework.part.adapter.VisibleAware
    public void onAttachedChanged(boolean attached) {
        super.onAttachedChanged(attached);
        if (attached) {
            F().f();
        } else {
            F().h();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // tk1.a, com.tencent.biz.richframework.part.adapter.section.Section
    public void onInitView(@Nullable View initContainerView) {
        super.onInitView(initContainerView);
        com.tencent.mobileqq.guild.feed.feedsquare.section.f F = F();
        View rootView = getRootView();
        Intrinsics.checkNotNullExpressionValue(rootView, "rootView");
        F.i(rootView);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // tk1.a, com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: u */
    public void onBindData(@Nullable tk1.c<Ext> bindData, int position, @Nullable List<Object> payload) {
        super.onBindData(bindData, position, payload);
        F().g(r(), position, payload);
    }
}
