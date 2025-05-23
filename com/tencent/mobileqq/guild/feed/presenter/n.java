package com.tencent.mobileqq.guild.feed.presenter;

import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.layoutinflater.RFWLayoutPreLoader;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.guild.feed.adapter.GuildFeedCacheRecycleViewPool;
import com.tencent.mobileqq.guild.feed.feedsquare.section.f;
import com.tencent.mobileqq.guild.feed.feedsquare.utils.AbsGuildFeedMediaSizeUtils;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedBaseInitBean;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedDefaultInitBean;
import com.tencent.mobileqq.guild.feed.nativedetail.content.feedmain.data.GProStFeedDetailRspWrapper;
import com.tencent.mobileqq.guild.feed.report.GuildFeedReportTable12003;
import com.tencent.mobileqq.guild.feed.util.ax;
import com.tencent.mobileqq.guild.media.widget.RoundCornerLayout;
import com.tencent.mobileqq.guild.report.GuildChannelReportManager;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqmini.sdk.core.ReportConst;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStFeed;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStImage;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 )2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001*B\u000f\u0012\u0006\u0010&\u001a\u00020%\u00a2\u0006\u0004\b'\u0010(J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0012\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0002J\u001a\u0010\u000e\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0002J\u0010\u0010\u0010\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\bH\u0016J\u001a\u0010\u0013\u001a\u00020\n2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0012\u001a\u00020\fH\u0016J\u0012\u0010\u0014\u001a\u00020\n2\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J\u0010\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\bH\u0016J\b\u0010\u0017\u001a\u00020\nH\u0016J\b\u0010\u0018\u001a\u00020\nH\u0016R&\u0010\u001d\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0019j\b\u0012\u0004\u0012\u00020\u0004`\u001a8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010 \u001a\u00020\b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0014\u0010$\u001a\u00020!8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\"\u0010#\u00a8\u0006+"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/presenter/n;", "Lcom/tencent/mobileqq/guild/feed/presenter/GuildBaseFeedChildPresenter;", "Lij1/g;", "Landroid/view/View$OnClickListener;", "Lcom/tencent/mobileqq/guild/feed/adapter/n;", "mixedMediaData", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStImage;", "v", "Landroid/view/View;", "view", "", "u", "", com.tencent.luggage.wxa.c8.c.G, HippyTKDListViewAdapter.X, MosaicConstants$JsProperty.PROP_ROOT_VIEW, "o", "data", "position", "w", NodeProps.ON_CLICK, "requestView", "onPreloadResult", "j", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", UserInfo.SEX_FEMALE, "Ljava/util/ArrayList;", "mMixedMediaDataList", "G", "Landroid/view/View;", "mContainerView", "Lcom/tencent/mobileqq/guild/feed/feedsquare/section/f;", "H", "Lcom/tencent/mobileqq/guild/feed/feedsquare/section/f;", "components", "Lcom/tencent/mobileqq/guild/feed/launcher/GuildFeedDefaultInitBean;", "defaultInitBean", "<init>", "(Lcom/tencent/mobileqq/guild/feed/launcher/GuildFeedDefaultInitBean;)V", "I", "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class n extends GuildBaseFeedChildPresenter<ij1.g> implements View.OnClickListener {

    /* renamed from: F, reason: from kotlin metadata */
    private ArrayList<com.tencent.mobileqq.guild.feed.adapter.n> mMixedMediaDataList;

    /* renamed from: G, reason: from kotlin metadata */
    private View mContainerView;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.guild.feed.feedsquare.section.f components;

    /* compiled from: P */
    @Metadata(d1 = {"\u00005\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\u0018\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0016J\u001a\u0010\u000e\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\r\u001a\u00020\fH\u0016J\u0010\u0010\u000f\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0016J\n\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016R\u001a\u0010\u0015\u001a\u00020\u00028\u0016X\u0096D\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\u00a8\u0006\u0016"}, d2 = {"com/tencent/mobileqq/guild/feed/presenter/n$b", "Lcom/tencent/mobileqq/guild/feed/feedsquare/section/f$b;", "", "dataSize", "d", "Landroidx/recyclerview/widget/RecyclerView$RecycledViewPool;", "getRecycledViewPool", com.tencent.luggage.wxa.c8.c.G, "Landroid/view/View;", "view", "", "i", "", "elementId", "c", tl.h.F, "", "a", "I", "g", "()I", "maxRow", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class b implements f.b {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final int maxRow = 1;

        b() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.tencent.mobileqq.guild.feed.feedsquare.section.f.b
        @Nullable
        public Object a() {
            GProStFeed b16 = ((ij1.g) n.this.f222800d).b();
            if (b16 != null) {
                return b16.idd;
            }
            return null;
        }

        @Override // com.tencent.mobileqq.guild.feed.feedsquare.section.f.b
        public void c(@Nullable View view, @NotNull String elementId) {
            Intrinsics.checkNotNullParameter(elementId, "elementId");
            n.this.c(view, elementId);
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
        @NotNull
        public RecyclerView.RecycledViewPool getRecycledViewPool() {
            return GuildFeedCacheRecycleViewPool.INSTANCE.a();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.tencent.mobileqq.guild.feed.feedsquare.section.f.b
        public void h(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            n nVar = n.this;
            nVar.i(((ij1.g) nVar.f222800d).b(), 0, 1);
        }

        @Override // com.tencent.mobileqq.guild.feed.feedsquare.section.f.b
        public void i(int pos, @NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            n.this.x(pos, view);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n(@NotNull GuildFeedDefaultInitBean defaultInitBean) {
        super(defaultInitBean);
        Intrinsics.checkNotNullParameter(defaultInitBean, "defaultInitBean");
        this.components = new com.tencent.mobileqq.guild.feed.feedsquare.section.f(new b());
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void u(View view) {
        T t16;
        String pageForumType;
        if (view != null && (t16 = this.f222800d) != 0 && ((ij1.g) t16).b() != null) {
            GuildFeedBaseInitBean q16 = ax.q(view.getContext());
            if (q16 == null) {
                pageForumType = "";
            } else {
                pageForumType = q16.getPageForumType(q16.getPageId());
            }
            GuildFeedReportTable12003.b(new GuildFeedReportTable12003.a(com.tencent.mobileqq.guild.feed.report.f.b(((ij1.g) this.f222800d).b(), pageForumType).K(ReportConst.ACTION.FULLSCREEN).J("success").Y("pg_channel_forum_page")));
            GuildChannelReportManager.f231987a.f(GuildChannelReportManager.PageType.CHANNEL_PAGE_FEED_LIST, null);
        }
    }

    private final GProStImage v(com.tencent.mobileqq.guild.feed.adapter.n mixedMediaData) {
        if (mixedMediaData.e() == 1) {
            return mixedMediaData.c();
        }
        if (mixedMediaData.e() == 2) {
            return mixedMediaData.d().cover;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void x(int pos, View view) {
        GProStFeed b16;
        ArrayList<com.tencent.mobileqq.guild.feed.adapter.n> arrayList = this.mMixedMediaDataList;
        ImageView imageView = null;
        if (arrayList == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMixedMediaDataList");
            arrayList = null;
        }
        com.tencent.mobileqq.guild.feed.adapter.n nVar = arrayList.get(pos);
        Intrinsics.checkNotNullExpressionValue(nVar, "mMixedMediaDataList[pos]");
        GProStImage v3 = v(nVar);
        if (v3 == null) {
            return;
        }
        if (view instanceof ImageView) {
            imageView = (ImageView) view;
        }
        ImageView imageView2 = imageView;
        if (imageView2 == null || (b16 = ((ij1.g) this.f222800d).b()) == null) {
            return;
        }
        com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.widget.j.f221614a.b(imageView2, b16, v3, this.D.getBusinessType(), null);
        u(view);
    }

    @Override // com.tencent.mobileqq.guild.feed.presenter.GuildBaseFeedChildPresenter
    public void j() {
        super.j();
        this.components.f();
    }

    @Override // com.tencent.mobileqq.guild.feed.presenter.GuildBaseFeedChildPresenter
    public void m() {
        super.m();
        this.components.h();
    }

    @Override // com.tencent.mobileqq.guild.feed.presenter.GuildBaseFeedChildPresenter
    public void o(@NotNull View rootView) {
        int first;
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.o(rootView);
        RFWLayoutPreLoader d16 = gj1.a.a().d();
        first = ArraysKt___ArraysKt.first(this.components.e());
        View findViewById = rootView.findViewById(first);
        Intrinsics.checkNotNull(findViewById, "null cannot be cast to non-null type android.view.ViewStub");
        d16.requestPreloadViewForViewStub((ViewStub) findViewById, this);
    }

    @Override // com.tencent.mobileqq.guild.feed.presenter.GuildBaseFeedChildPresenter, com.tencent.biz.richframework.layoutinflater.RFWLayoutPreLoader.RequestPreloadViewListener
    public void onPreloadResult(@NotNull View requestView) {
        Intrinsics.checkNotNullParameter(requestView, "requestView");
        super.onPreloadResult(requestView);
        this.mContainerView = requestView;
        this.components.i(requestView);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [kotlin.jvm.internal.DefaultConstructorMarker, com.tencent.mobileqq.guild.feed.bean.GuildFeedRichMediaData] */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v2, types: [android.view.View] */
    @Override // com.tencent.mobileqq.guild.feed.presenter.GuildBaseFeedChildPresenter
    /* renamed from: w, reason: merged with bridge method [inline-methods] */
    public void k(@Nullable ij1.g data, int position) {
        GProStFeed gProStFeed;
        GProStFeedDetailRspWrapper gProStFeedDetailRspWrapper;
        GProStFeed b16;
        super.k(data, position);
        ?? r06 = 0;
        View view = null;
        if (data != null) {
            gProStFeed = data.b();
        } else {
            gProStFeed = null;
        }
        ArrayList<com.tencent.mobileqq.guild.feed.adapter.n> m3 = com.tencent.mobileqq.guild.feed.adapter.n.m(gProStFeed);
        Intrinsics.checkNotNullExpressionValue(m3, "stFeed2MixedMediaData(data?.sourceData)");
        this.mMixedMediaDataList = m3;
        if (m3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMixedMediaDataList");
            m3 = null;
        }
        if (m3.isEmpty()) {
            View view2 = this.mContainerView;
            if (view2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mContainerView");
            } else {
                view = view2;
            }
            view.setVisibility(8);
            return;
        }
        if (data != null && (b16 = data.b()) != null) {
            gProStFeedDetailRspWrapper = new GProStFeedDetailRspWrapper(b16, r06, 2, r06);
        } else {
            gProStFeedDetailRspWrapper = null;
        }
        this.components.g(gProStFeedDetailRspWrapper, position, null);
        ArrayList<com.tencent.mobileqq.guild.feed.adapter.n> arrayList = this.mMixedMediaDataList;
        if (arrayList == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMixedMediaDataList");
            arrayList = null;
        }
        com.tencent.mobileqq.guild.feed.gallery.d.b(arrayList);
        View view3 = this.mContainerView;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContainerView");
        } else {
            r06 = view3;
        }
        r06.setVisibility(0);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@Nullable View v3) {
    }
}
