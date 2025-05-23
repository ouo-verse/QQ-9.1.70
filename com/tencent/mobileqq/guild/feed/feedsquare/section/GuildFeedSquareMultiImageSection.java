package com.tencent.mobileqq.guild.feed.feedsquare.section;

import android.view.View;
import android.widget.ImageView;
import com.tencent.biz.richframework.ioc.RFWIocAbilityProvider;
import com.tencent.biz.richframework.part.adapter.section.Section;
import com.tencent.mobileqq.guild.feed.feedsquare.section.f;
import com.tencent.mobileqq.guild.feed.feedsquare.utils.AbsGuildFeedMediaSizeUtils;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedBaseInitBean;
import com.tencent.mobileqq.guild.feed.nativedetail.content.feedmain.data.GProStFeedDetailRspWrapper;
import com.tencent.mobileqq.guild.feed.publish.bean.GuildTaskProgressState;
import com.tencent.mobileqq.guild.feed.report.GuildFeedReportTable12003;
import com.tencent.mobileqq.guild.feed.util.ax;
import com.tencent.mobileqq.guild.media.widget.RoundCornerLayout;
import com.tencent.mobileqq.guild.report.GuildChannelReportManager;
import com.tencent.qqmini.sdk.core.ReportConst;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStFeed;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStImage;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 )2\u00020\u0001:\u0001*B\u0007\u00a2\u0006\u0004\b'\u0010(J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\u0012\u0010\b\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\b\u0010\n\u001a\u00020\tH\u0014J\u0010\u0010\f\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0004H\u0014J*\u0010\u0013\u001a\u00020\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000f\u001a\u00020\u00022\u000e\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010H\u0016J\u0010\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u0014H\u0016R&\u0010\u001c\u001a\u0012\u0012\u0004\u0012\u00020\u00180\u0017j\b\u0012\u0004\u0012\u00020\u0018`\u00198\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u001d\u0010\"\u001a\u0004\u0018\u00010\u001d8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R\u0014\u0010&\u001a\u00020#8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b$\u0010%\u00a8\u0006+"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/feedsquare/section/GuildFeedSquareMultiImageSection;", "Lcom/tencent/mobileqq/guild/feed/feedsquare/section/GuildFeedSquareFeedBaseSection;", "", com.tencent.luggage.wxa.c8.c.G, "Landroid/view/View;", "view", "", "W", "U", "", "getViewStubLayoutId", "containerView", "onInitView", "Lcom/tencent/mobileqq/guild/feed/feedsquare/data/h;", "data", "position", "", "", "payload", "M", "", "attached", "onAttachedChanged", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/guild/feed/adapter/n;", "Lkotlin/collections/ArrayList;", "e", "Ljava/util/ArrayList;", "mMixedMediaDataList", "Lxj1/d;", "f", "Lkotlin/Lazy;", "V", "()Lxj1/d;", "recyclerViewPoolIoc", "Lcom/tencent/mobileqq/guild/feed/feedsquare/section/f;", tl.h.F, "Lcom/tencent/mobileqq/guild/feed/feedsquare/section/f;", "components", "<init>", "()V", "i", "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildFeedSquareMultiImageSection extends GuildFeedSquareFeedBaseSection {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private ArrayList<com.tencent.mobileqq.guild.feed.adapter.n> mMixedMediaDataList;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy recyclerViewPoolIoc;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final f components;

    /* compiled from: P */
    @Metadata(d1 = {"\u00003\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\n\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\u0018\u0010\r\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u001a\u0010\u0010\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J\u0010\u0010\u0011\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0016R\u001a\u0010\u0015\u001a\u00020\u00048\u0016X\u0096D\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\u00a8\u0006\u0016"}, d2 = {"com/tencent/mobileqq/guild/feed/feedsquare/section/GuildFeedSquareMultiImageSection$b", "Lcom/tencent/mobileqq/guild/feed/feedsquare/section/f$b;", "", "a", "", "dataSize", "d", "Lcom/tencent/mobileqq/guild/feed/feedsquare/widget/a;", "b", com.tencent.luggage.wxa.c8.c.G, "Landroid/view/View;", "view", "", "i", "", "elementId", "c", tl.h.F, "I", "g", "()I", "maxRow", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class b implements f.b {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final int maxRow = 1;

        b() {
        }

        @Override // com.tencent.mobileqq.guild.feed.feedsquare.section.f.b
        @Nullable
        public Object a() {
            ij1.g blockData;
            GuildTaskProgressState p16;
            com.tencent.mobileqq.guild.feed.feedsquare.data.h hVar = (com.tencent.mobileqq.guild.feed.feedsquare.data.h) ((Section) GuildFeedSquareMultiImageSection.this).mData;
            if (hVar != null && (blockData = hVar.getBlockData()) != null && (p16 = blockData.p()) != null) {
                return p16.mTaskId;
            }
            return null;
        }

        @Override // com.tencent.mobileqq.guild.feed.feedsquare.section.f.b
        @Nullable
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public com.tencent.mobileqq.guild.feed.feedsquare.widget.a getRecycledViewPool() {
            xj1.d V = GuildFeedSquareMultiImageSection.this.V();
            if (V != null) {
                return V.a();
            }
            return null;
        }

        @Override // com.tencent.mobileqq.guild.feed.feedsquare.section.f.b
        public void c(@Nullable View view, @NotNull String elementId) {
            Intrinsics.checkNotNullParameter(elementId, "elementId");
            GuildFeedSquareMultiImageSection.this.A(view, elementId);
        }

        @Override // com.tencent.mobileqq.guild.feed.feedsquare.section.f.b
        public int d(int dataSize) {
            return 3;
        }

        @Override // com.tencent.mobileqq.guild.feed.feedsquare.section.f.b
        @NotNull
        public AbsGuildFeedMediaSizeUtils e() {
            return f.b.a.a(this);
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
        public void h(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            GuildFeedSquareMultiImageSection guildFeedSquareMultiImageSection = GuildFeedSquareMultiImageSection.this;
            GProStFeed b16 = ((com.tencent.mobileqq.guild.feed.feedsquare.data.h) ((Section) guildFeedSquareMultiImageSection).mData).getBlockData().b();
            Intrinsics.checkNotNullExpressionValue(b16, "mData.blockData.sourceData");
            guildFeedSquareMultiImageSection.K(b16, 0, 1);
        }

        @Override // com.tencent.mobileqq.guild.feed.feedsquare.section.f.b
        public void i(int pos, @NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            GuildFeedSquareMultiImageSection.this.W(pos, view);
        }
    }

    public GuildFeedSquareMultiImageSection() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<xj1.d>() { // from class: com.tencent.mobileqq.guild.feed.feedsquare.section.GuildFeedSquareMultiImageSection$recyclerViewPoolIoc$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final xj1.d invoke() {
                return (xj1.d) RFWIocAbilityProvider.g().getIocInterface(xj1.d.class, GuildFeedSquareMultiImageSection.this.getRootView(), null);
            }
        });
        this.recyclerViewPoolIoc = lazy;
        this.components = new f(new b());
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void U(View view) {
        String pageForumType;
        if (view == null) {
            return;
        }
        GuildFeedBaseInitBean q16 = ax.q(view.getContext());
        if (q16 == null) {
            pageForumType = "";
        } else {
            pageForumType = q16.getPageForumType(q16.getPageId());
        }
        GuildFeedReportTable12003.b(new GuildFeedReportTable12003.a(com.tencent.mobileqq.guild.feed.report.f.b(((com.tencent.mobileqq.guild.feed.feedsquare.data.h) this.mData).getBlockData().b(), pageForumType).K(ReportConst.ACTION.FULLSCREEN).J("success").Y("pg_channel_forum_page")));
        GuildChannelReportManager.f231987a.f(GuildChannelReportManager.PageType.CHANNEL_PAGE_FEED_LIST, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final xj1.d V() {
        return (xj1.d) this.recyclerViewPoolIoc.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void W(int pos, View view) {
        GProStFeed b16;
        ArrayList<com.tencent.mobileqq.guild.feed.adapter.n> arrayList = this.mMixedMediaDataList;
        ImageView imageView = null;
        if (arrayList == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMixedMediaDataList");
            arrayList = null;
        }
        GProStImage c16 = arrayList.get(pos).c();
        if (c16 == null) {
            return;
        }
        if (view instanceof ImageView) {
            imageView = (ImageView) view;
        }
        ImageView imageView2 = imageView;
        if (imageView2 == null || (b16 = ((com.tencent.mobileqq.guild.feed.feedsquare.data.h) this.mData).getBlockData().b()) == null) {
            return;
        }
        com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.widget.j.f221614a.b(imageView2, b16, c16, p(), com.tencent.mobileqq.guild.feed.feedsquare.data.g.b(((com.tencent.mobileqq.guild.feed.feedsquare.data.h) this.mData).getBlockData()));
        U(view);
    }

    @Override // com.tencent.mobileqq.guild.feed.feedsquare.section.GuildFeedSquareFeedBaseSection
    public void M(@Nullable com.tencent.mobileqq.guild.feed.feedsquare.data.h data, int position, @Nullable List<Object> payload) {
        if (data == null) {
            return;
        }
        ArrayList<com.tencent.mobileqq.guild.feed.adapter.n> m3 = com.tencent.mobileqq.guild.feed.adapter.n.m(data.getBlockData().b());
        Intrinsics.checkNotNullExpressionValue(m3, "stFeed2MixedMediaData(data.blockData.sourceData)");
        this.mMixedMediaDataList = m3;
        GProStFeed b16 = data.getBlockData().b();
        GProStFeedDetailRspWrapper gProStFeedDetailRspWrapper = null;
        if (b16 != null) {
            gProStFeedDetailRspWrapper = new GProStFeedDetailRspWrapper(b16, null, 2, null);
        }
        this.components.g(gProStFeedDetailRspWrapper, position, payload);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    @NotNull
    public int[] getViewStubLayoutId() {
        return this.components.e();
    }

    @Override // com.tencent.biz.richframework.part.adapter.section.Section, com.tencent.biz.richframework.part.adapter.VisibleAware
    public void onAttachedChanged(boolean attached) {
        super.onAttachedChanged(attached);
        if (attached) {
            this.components.f();
        } else {
            this.components.h();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public void onInitView(@NotNull View containerView) {
        Intrinsics.checkNotNullParameter(containerView, "containerView");
        this.components.i(containerView);
    }
}
