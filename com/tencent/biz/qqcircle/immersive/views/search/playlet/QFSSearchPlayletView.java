package com.tencent.biz.qqcircle.immersive.views.search.playlet;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.qqcircle.beans.QCircleAlbumBean;
import com.tencent.biz.qqcircle.beans.QCircleFeedAlbumInfo;
import com.tencent.biz.qqcircle.immersive.bean.QFSSearchInfo;
import com.tencent.biz.qqcircle.immersive.views.search.widget.QFSSearchBaseWidgetView;
import com.tencent.biz.qqcircle.launcher.QCircleSchemeLauncher;
import com.tencent.biz.qqcircle.richframework.widget.RoundCornerImageView;
import com.tencent.biz.qui.quibutton.QUIButton;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudMeta$FeedAlbumInfo;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudRead$StCollectionDetail;
import feedcloud.FeedCloudRead$StVideoCollectionInfo;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 C2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001DB\u000f\u0012\u0006\u0010\u000b\u001a\u00020\n\u00a2\u0006\u0004\bA\u0010BJ\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0002J\b\u0010\t\u001a\u00020\bH\u0016J\u001a\u0010\r\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\f\u001a\u00020\bH\u0014J\u001a\u0010\u0010\u001a\u00020\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000f\u001a\u00020\bH\u0014J\u0012\u0010\u0013\u001a\u00020\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001d\u001a\u00020\u00188\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001aR\u0016\u0010!\u001a\u00020\u001e8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010#\u001a\u00020\u00188\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\"\u0010\u001aR\u0016\u0010'\u001a\u00020$8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010+\u001a\u00020(8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010-\u001a\u00020\u00188\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b,\u0010\u001aR\u0016\u00101\u001a\u00020.8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b/\u00100R\u0018\u00104\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u00103R\u0018\u00108\u001a\u0004\u0018\u0001058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b6\u00107R$\u0010@\u001a\u0004\u0018\u0001098\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b:\u0010;\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?\u00a8\u0006E"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/views/search/playlet/QFSSearchPlayletView;", "Lcom/tencent/biz/qqcircle/immersive/views/search/widget/QFSSearchBaseWidgetView;", "Lfeedcloud/FeedCloudRead$StVideoCollectionInfo;", "Landroid/view/View$OnClickListener;", "", "m0", "l0", "n0", "", "getLayoutId", "Landroid/content/Context;", "context", "viewType", "initView", "info", com.tencent.luggage.wxa.c8.c.G, "k0", "Landroid/view/View;", "v", NodeProps.ON_CLICK, "Lcom/tencent/biz/qqcircle/richframework/widget/RoundCornerImageView;", "e", "Lcom/tencent/biz/qqcircle/richframework/widget/RoundCornerImageView;", "coverIv", "Landroid/widget/TextView;", "f", "Landroid/widget/TextView;", "titleTv", h.F, "subTitleTv", "Landroid/widget/LinearLayout;", "i", "Landroid/widget/LinearLayout;", "subTitleLayout", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "descTv", "Lcom/tencent/biz/qui/quibutton/QUIButton;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/biz/qui/quibutton/QUIButton;", "watchBtn", "Landroidx/recyclerview/widget/RecyclerView;", "D", "Landroidx/recyclerview/widget/RecyclerView;", "episodesRecycler", "E", "loadTv", "Landroid/widget/ImageView;", UserInfo.SEX_FEMALE, "Landroid/widget/ImageView;", "loadIv", "G", "Lfeedcloud/FeedCloudRead$StVideoCollectionInfo;", "collectionInfo", "Lq90/c;", "H", "Lq90/c;", "adapter", "Lcom/tencent/biz/qqcircle/immersive/bean/QFSSearchInfo;", "I", "Lcom/tencent/biz/qqcircle/immersive/bean/QFSSearchInfo;", "getSearchInfo", "()Lcom/tencent/biz/qqcircle/immersive/bean/QFSSearchInfo;", "setSearchInfo", "(Lcom/tencent/biz/qqcircle/immersive/bean/QFSSearchInfo;)V", "searchInfo", "<init>", "(Landroid/content/Context;)V", "J", "a", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class QFSSearchPlayletView extends QFSSearchBaseWidgetView<FeedCloudRead$StVideoCollectionInfo> implements View.OnClickListener {

    /* renamed from: C, reason: from kotlin metadata */
    private QUIButton watchBtn;

    /* renamed from: D, reason: from kotlin metadata */
    private RecyclerView episodesRecycler;

    /* renamed from: E, reason: from kotlin metadata */
    private TextView loadTv;

    /* renamed from: F, reason: from kotlin metadata */
    private ImageView loadIv;

    /* renamed from: G, reason: from kotlin metadata */
    @Nullable
    private FeedCloudRead$StVideoCollectionInfo collectionInfo;

    /* renamed from: H, reason: from kotlin metadata */
    @Nullable
    private q90.c adapter;

    /* renamed from: I, reason: from kotlin metadata */
    @Nullable
    private QFSSearchInfo searchInfo;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private RoundCornerImageView coverIv;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private TextView titleTv;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private TextView subTitleTv;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private LinearLayout subTitleLayout;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private TextView descTv;

    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J(\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/biz/qqcircle/immersive/views/search/playlet/QFSSearchPlayletView$b", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "Landroid/graphics/Rect;", "outRect", "Landroid/view/View;", "view", "Landroidx/recyclerview/widget/RecyclerView;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroidx/recyclerview/widget/RecyclerView$State;", "state", "", "getItemOffsets", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes4.dex */
    public static final class b extends RecyclerView.ItemDecoration {
        b() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(@NotNull Rect outRect, @NotNull View view, @NotNull RecyclerView parent, @NotNull RecyclerView.State state) {
            Intrinsics.checkNotNullParameter(outRect, "outRect");
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(parent, "parent");
            Intrinsics.checkNotNullParameter(state, "state");
            outRect.right = ViewUtils.dip2px(8.0f);
        }
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\u0005"}, d2 = {"com/tencent/biz/qqcircle/immersive/views/search/playlet/QFSSearchPlayletView$c", "Landroidx/recyclerview/widget/LinearLayoutManager;", "", "canScrollHorizontally", "canScrollVertically", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes4.dex */
    public static final class c extends LinearLayoutManager {
        c(Context context) {
            super(context);
        }

        @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
        public boolean canScrollHorizontally() {
            return true;
        }

        @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
        public boolean canScrollVertically() {
            return false;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QFSSearchPlayletView(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void l0() {
        String str;
        String str2;
        int i3;
        PBStringField pBStringField;
        Map<String, Object> map = new QCircleDTParamBuilder().buildElementParams();
        FeedCloudRead$StVideoCollectionInfo feedCloudRead$StVideoCollectionInfo = this.collectionInfo;
        LinearLayout linearLayout = null;
        if (feedCloudRead$StVideoCollectionInfo != null && (pBStringField = feedCloudRead$StVideoCollectionInfo.collectionID) != null) {
            str = pBStringField.get();
        } else {
            str = null;
        }
        String str3 = "";
        if (str == null) {
            str = "";
        }
        Intrinsics.checkNotNullExpressionValue(map, "map");
        map.put(QCircleDaTongConstant.ElementParamKey.XSJ_ALBUM_ID, str);
        QFSSearchInfo qFSSearchInfo = this.searchInfo;
        if (qFSSearchInfo != null) {
            str2 = qFSSearchInfo.f();
        } else {
            str2 = null;
        }
        if (str2 != null) {
            str3 = str2;
        }
        map.put("xsj_query_text", str3);
        QFSSearchInfo qFSSearchInfo2 = this.searchInfo;
        if (qFSSearchInfo2 != null) {
            i3 = qFSSearchInfo2.e();
        } else {
            i3 = 0;
        }
        map.put(QCircleDaTongConstant.ElementParamKey.XSJ_QUERY_SOURCE, Integer.valueOf(i3));
        VideoReport.setElementId(this, QCircleDaTongConstant.ElementId.EM_XSJ_ALBUM_GATHER_CARD);
        VideoReport.setElementParams(this, map);
        VideoReport.setElementReuseIdentifier(this, QCircleDaTongConstant.ElementId.EM_XSJ_ALBUM_GATHER_CARD + str);
        VideoReport.setElementExposePolicy(this, ExposurePolicy.REPORT_ALL);
        VideoReport.setElementClickPolicy(this, ClickPolicy.REPORT_NONE);
        RoundCornerImageView roundCornerImageView = this.coverIv;
        if (roundCornerImageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("coverIv");
            roundCornerImageView = null;
        }
        VideoReport.setElementId(roundCornerImageView, QCircleDaTongConstant.ElementId.EM_XSJ_ALBUM_COVER);
        RoundCornerImageView roundCornerImageView2 = this.coverIv;
        if (roundCornerImageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("coverIv");
            roundCornerImageView2 = null;
        }
        VideoReport.setElementParams(roundCornerImageView2, map);
        RoundCornerImageView roundCornerImageView3 = this.coverIv;
        if (roundCornerImageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("coverIv");
            roundCornerImageView3 = null;
        }
        ExposurePolicy exposurePolicy = ExposurePolicy.REPORT_NONE;
        VideoReport.setElementExposePolicy(roundCornerImageView3, exposurePolicy);
        RoundCornerImageView roundCornerImageView4 = this.coverIv;
        if (roundCornerImageView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("coverIv");
            roundCornerImageView4 = null;
        }
        ClickPolicy clickPolicy = ClickPolicy.REPORT_ALL;
        VideoReport.setElementClickPolicy(roundCornerImageView4, clickPolicy);
        QUIButton qUIButton = this.watchBtn;
        if (qUIButton == null) {
            Intrinsics.throwUninitializedPropertyAccessException("watchBtn");
            qUIButton = null;
        }
        VideoReport.setElementId(qUIButton, QCircleDaTongConstant.ElementId.EM_XSJ_ALBUM_WATCH_BTN);
        QUIButton qUIButton2 = this.watchBtn;
        if (qUIButton2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("watchBtn");
            qUIButton2 = null;
        }
        VideoReport.setElementParams(qUIButton2, map);
        QUIButton qUIButton3 = this.watchBtn;
        if (qUIButton3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("watchBtn");
            qUIButton3 = null;
        }
        VideoReport.setElementExposePolicy(qUIButton3, exposurePolicy);
        QUIButton qUIButton4 = this.watchBtn;
        if (qUIButton4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("watchBtn");
            qUIButton4 = null;
        }
        VideoReport.setElementClickPolicy(qUIButton4, clickPolicy);
        LinearLayout linearLayout2 = this.subTitleLayout;
        if (linearLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("subTitleLayout");
            linearLayout2 = null;
        }
        VideoReport.setElementId(linearLayout2, QCircleDaTongConstant.ElementId.EM_XSJ_ALBUM_NAME_BTN);
        LinearLayout linearLayout3 = this.subTitleLayout;
        if (linearLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("subTitleLayout");
            linearLayout3 = null;
        }
        VideoReport.setElementParams(linearLayout3, map);
        LinearLayout linearLayout4 = this.subTitleLayout;
        if (linearLayout4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("subTitleLayout");
            linearLayout4 = null;
        }
        VideoReport.setElementExposePolicy(linearLayout4, exposurePolicy);
        LinearLayout linearLayout5 = this.subTitleLayout;
        if (linearLayout5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("subTitleLayout");
        } else {
            linearLayout = linearLayout5;
        }
        VideoReport.setElementClickPolicy(linearLayout, clickPolicy);
    }

    private final void m0() {
        View findViewById = findViewById(R.id.f53772de);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.qfs_search_playlet_recycler)");
        this.episodesRecycler = (RecyclerView) findViewById;
        c cVar = new c(getContext());
        cVar.setOrientation(0);
        RecyclerView recyclerView = this.episodesRecycler;
        RecyclerView recyclerView2 = null;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("episodesRecycler");
            recyclerView = null;
        }
        recyclerView.setLayoutManager(cVar);
        RecyclerView recyclerView3 = this.episodesRecycler;
        if (recyclerView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("episodesRecycler");
            recyclerView3 = null;
        }
        recyclerView3.addItemDecoration(new b());
        this.adapter = new q90.c();
        RecyclerView recyclerView4 = this.episodesRecycler;
        if (recyclerView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("episodesRecycler");
        } else {
            recyclerView2 = recyclerView4;
        }
        recyclerView2.setAdapter(this.adapter);
    }

    private final void n0() {
        PBInt32Field pBInt32Field;
        PBRepeatMessageField<FeedCloudRead$StCollectionDetail> pBRepeatMessageField;
        List<FeedCloudRead$StCollectionDetail> list;
        PBRepeatMessageField<FeedCloudRead$StCollectionDetail> pBRepeatMessageField2;
        FeedCloudRead$StCollectionDetail feedCloudRead$StCollectionDetail;
        FeedCloudMeta$StFeed feedCloudMeta$StFeed;
        PBStringField pBStringField;
        FeedCloudRead$StVideoCollectionInfo feedCloudRead$StVideoCollectionInfo = this.collectionInfo;
        if (feedCloudRead$StVideoCollectionInfo != null && (pBInt32Field = feedCloudRead$StVideoCollectionInfo.btnIndex) != null) {
            int i3 = pBInt32Field.get();
            FeedCloudRead$StVideoCollectionInfo feedCloudRead$StVideoCollectionInfo2 = this.collectionInfo;
            if (feedCloudRead$StVideoCollectionInfo2 != null && (pBRepeatMessageField = feedCloudRead$StVideoCollectionInfo2.detail) != null && (list = pBRepeatMessageField.get()) != null) {
                FeedCloudMeta$StFeed feedCloudMeta$StFeed2 = null;
                r2 = null;
                String str = null;
                feedCloudMeta$StFeed2 = null;
                feedCloudMeta$StFeed2 = null;
                feedCloudMeta$StFeed2 = null;
                if (i3 >= list.size()) {
                    Context context = getContext();
                    FeedCloudRead$StVideoCollectionInfo feedCloudRead$StVideoCollectionInfo3 = this.collectionInfo;
                    if (feedCloudRead$StVideoCollectionInfo3 != null && (pBStringField = feedCloudRead$StVideoCollectionInfo3.btnSchema) != null) {
                        str = pBStringField.get();
                    }
                    QCircleSchemeLauncher.f(context, str);
                    return;
                }
                FeedCloudRead$StVideoCollectionInfo feedCloudRead$StVideoCollectionInfo4 = this.collectionInfo;
                if (feedCloudRead$StVideoCollectionInfo4 != null && (pBRepeatMessageField2 = feedCloudRead$StVideoCollectionInfo4.detail) != null && (feedCloudRead$StCollectionDetail = pBRepeatMessageField2.get(i3)) != null && (feedCloudMeta$StFeed = feedCloudRead$StCollectionDetail.feed) != null) {
                    feedCloudMeta$StFeed2 = feedCloudMeta$StFeed.get();
                }
                if (feedCloudMeta$StFeed2 == null) {
                    return;
                }
                Intrinsics.checkNotNullExpressionValue(feedCloudMeta$StFeed2.album_infos.get(), "feed.album_infos.get()");
                if (!r1.isEmpty()) {
                    FeedCloudMeta$FeedAlbumInfo feedCloudMeta$FeedAlbumInfo = feedCloudMeta$StFeed2.album_infos.get().get(0);
                    Intrinsics.checkNotNullExpressionValue(feedCloudMeta$FeedAlbumInfo, "feed.album_infos.get()[0]");
                    QCircleFeedAlbumInfo qCircleFeedAlbumInfo = new QCircleFeedAlbumInfo(feedCloudMeta$FeedAlbumInfo.album.f398441id.get());
                    qCircleFeedAlbumInfo.isDraft = false;
                    QCircleAlbumBean qCircleAlbumBean = new QCircleAlbumBean(qCircleFeedAlbumInfo);
                    qCircleAlbumBean.setNeedShowAlbumPanel(false);
                    qCircleAlbumBean.setFromReportBean(getReportBean().m466clone());
                    qCircleAlbumBean.setSourceType(52);
                    qCircleAlbumBean.setDataPosInList(i3);
                    qCircleAlbumBean.setFeed(feedCloudMeta$StFeed2);
                    qCircleAlbumBean.setPreRenderType(10011);
                    com.tencent.biz.qqcircle.launcher.c.u(getContext(), qCircleAlbumBean);
                }
            }
        }
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.gsa;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public void initView(@Nullable Context context, int viewType) {
        super.initView(context, viewType);
        View findViewById = findViewById(R.id.f53722d_);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.qfs_search_playlet_cover)");
        this.coverIv = (RoundCornerImageView) findViewById;
        View findViewById2 = findViewById(R.id.f53802dh);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.qfs_search_playlet_title)");
        this.titleTv = (TextView) findViewById2;
        View findViewById3 = findViewById(R.id.f53792dg);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.qfs_se\u2026playlet_sub_title_layout)");
        this.subTitleLayout = (LinearLayout) findViewById3;
        View findViewById4 = findViewById(R.id.f53782df);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.qfs_search_playlet_sub_title)");
        this.subTitleTv = (TextView) findViewById4;
        View findViewById5 = findViewById(R.id.f53732da);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(R.id.qfs_search_playlet_desc)");
        this.descTv = (TextView) findViewById5;
        View findViewById6 = findViewById(R.id.f53812di);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "findViewById(R.id.qfs_search_playlet_watch_btn)");
        this.watchBtn = (QUIButton) findViewById6;
        View findViewById7 = findViewById(R.id.f53762dd);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "findViewById(R.id.qfs_search_playlet_load_text)");
        this.loadTv = (TextView) findViewById7;
        View findViewById8 = findViewById(R.id.f53752dc);
        Intrinsics.checkNotNullExpressionValue(findViewById8, "findViewById(R.id.qfs_search_playlet_load_arrow)");
        this.loadIv = (ImageView) findViewById8;
        m0();
        RoundCornerImageView roundCornerImageView = this.coverIv;
        ImageView imageView = null;
        if (roundCornerImageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("coverIv");
            roundCornerImageView = null;
        }
        roundCornerImageView.setCorner(ViewUtils.dip2px(8.0f));
        RoundCornerImageView roundCornerImageView2 = this.coverIv;
        if (roundCornerImageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("coverIv");
            roundCornerImageView2 = null;
        }
        roundCornerImageView2.setOnClickListener(this);
        TextView textView = this.titleTv;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleTv");
            textView = null;
        }
        textView.setOnClickListener(this);
        LinearLayout linearLayout = this.subTitleLayout;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("subTitleLayout");
            linearLayout = null;
        }
        linearLayout.setOnClickListener(this);
        TextView textView2 = this.descTv;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("descTv");
            textView2 = null;
        }
        textView2.setOnClickListener(this);
        QUIButton qUIButton = this.watchBtn;
        if (qUIButton == null) {
            Intrinsics.throwUninitializedPropertyAccessException("watchBtn");
            qUIButton = null;
        }
        qUIButton.setOnClickListener(this);
        TextView textView3 = this.loadTv;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("loadTv");
            textView3 = null;
        }
        textView3.setOnClickListener(this);
        ImageView imageView2 = this.loadIv;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("loadIv");
        } else {
            imageView = imageView2;
        }
        imageView.setOnClickListener(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    /* renamed from: k0, reason: merged with bridge method [inline-methods] */
    public void bindData(@Nullable FeedCloudRead$StVideoCollectionInfo info, int pos) {
        if (info == null) {
            return;
        }
        this.collectionInfo = info;
        TextView textView = this.titleTv;
        RecyclerView recyclerView = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleTv");
            textView = null;
        }
        textView.setText(info.collectionName.get());
        TextView textView2 = this.subTitleTv;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("subTitleTv");
            textView2 = null;
        }
        textView2.setText(info.authorName.get());
        QUIButton qUIButton = this.watchBtn;
        if (qUIButton == null) {
            Intrinsics.throwUninitializedPropertyAccessException("watchBtn");
            qUIButton = null;
        }
        qUIButton.setText(info.btnName.get());
        Option url = Option.obtain().setUrl(info.cover.get());
        RoundCornerImageView roundCornerImageView = this.coverIv;
        if (roundCornerImageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("coverIv");
            roundCornerImageView = null;
        }
        Option targetView = url.setTargetView(roundCornerImageView);
        targetView.setSupportRecycler(true);
        QCircleFeedPicLoader.g().loadImage(targetView);
        q90.c cVar = this.adapter;
        if (cVar != null) {
            cVar.m0(this.searchInfo);
        }
        q90.c cVar2 = this.adapter;
        if (cVar2 != null) {
            String str = info.moreSchema.get();
            Intrinsics.checkNotNullExpressionValue(str, "info.moreSchema.get()");
            cVar2.l0(str);
        }
        q90.c cVar3 = this.adapter;
        if (cVar3 != null) {
            String str2 = info.collectionID.get();
            Intrinsics.checkNotNullExpressionValue(str2, "info.collectionID.get()");
            cVar3.k0(str2);
        }
        q90.c cVar4 = this.adapter;
        if (cVar4 != null) {
            List<FeedCloudRead$StCollectionDetail> list = info.detail.get();
            Intrinsics.checkNotNullExpressionValue(list, "info.detail.get()");
            cVar4.setData(list);
        }
        TextView textView3 = this.descTv;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("descTv");
            textView3 = null;
        }
        textView3.setText(info.collectionDesc.get());
        RecyclerView recyclerView2 = this.episodesRecycler;
        if (recyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("episodesRecycler");
        } else {
            recyclerView = recyclerView2;
        }
        recyclerView.scrollToPosition(0);
        l0();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@Nullable View v3) {
        Integer num;
        boolean z16;
        boolean z17;
        boolean z18;
        PBStringField pBStringField;
        PBStringField pBStringField2;
        EventCollector.getInstance().onViewClickedBefore(v3);
        String str = null;
        if (v3 != null) {
            num = Integer.valueOf(v3.getId());
        } else {
            num = null;
        }
        boolean z19 = false;
        if ((num != null && num.intValue() == R.id.f53802dh) || (num != null && num.intValue() == R.id.f53722d_)) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16 || (num != null && num.intValue() == R.id.f53732da)) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (z17 || (num != null && num.intValue() == R.id.f53812di)) {
            z18 = true;
        } else {
            z18 = false;
        }
        if (z18) {
            n0();
        } else {
            if ((num != null && num.intValue() == R.id.f53762dd) || (num != null && num.intValue() == R.id.f53752dc)) {
                z19 = true;
            }
            if (z19) {
                Context context = getContext();
                FeedCloudRead$StVideoCollectionInfo feedCloudRead$StVideoCollectionInfo = this.collectionInfo;
                if (feedCloudRead$StVideoCollectionInfo != null && (pBStringField2 = feedCloudRead$StVideoCollectionInfo.moreSchema) != null) {
                    str = pBStringField2.get();
                }
                QCircleSchemeLauncher.f(context, str);
            } else if (num != null && num.intValue() == R.id.f53792dg) {
                Context context2 = getContext();
                FeedCloudRead$StVideoCollectionInfo feedCloudRead$StVideoCollectionInfo2 = this.collectionInfo;
                if (feedCloudRead$StVideoCollectionInfo2 != null && (pBStringField = feedCloudRead$StVideoCollectionInfo2.authorSchema) != null) {
                    str = pBStringField.get();
                }
                QCircleSchemeLauncher.f(context2, str);
            }
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    public final void setSearchInfo(@Nullable QFSSearchInfo qFSSearchInfo) {
        this.searchInfo = qFSSearchInfo;
    }
}
