package com.tencent.biz.qqcircle.immersive.album.view;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.qqcircle.launcher.QCircleSchemeLauncher;
import com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView;
import com.tencent.biz.richframework.compat.DisplayUtil;
import com.tencent.biz.richframework.part.block.base.SafeLinearLayoutManager;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import qqcircle.QQCircleFeedAlbum$StFeedDetail;
import qqcircle.QQCircleFeedAlbum$StVideoAlbumFeedInfo;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 ,2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001-B\u000f\u0012\u0006\u0010\u000b\u001a\u00020\n\u00a2\u0006\u0004\b*\u0010+J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0004H\u0002J\b\u0010\t\u001a\u00020\u0004H\u0002J\u001a\u0010\u000e\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\r\u001a\u00020\fH\u0014J\b\u0010\u000f\u001a\u00020\fH\u0016J\u001a\u0010\u0012\u001a\u00020\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0011\u001a\u00020\fH\u0014J\u0012\u0010\u0015\u001a\u00020\u00042\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016R\u0016\u0010\u0018\u001a\u00020\u00138\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001e\u001a\u00020\u00198\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001bR\u0016\u0010\"\u001a\u00020\u001f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0018\u0010%\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0018\u0010)\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010(\u00a8\u0006."}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/album/view/QFSRelatedAlbumsView;", "Lcom/tencent/biz/qqcircle/widgets/QCircleBaseWidgetView;", "Lqqcircle/QQCircleFeedAlbum$StVideoAlbumFeedInfo;", "Landroid/view/View$OnClickListener;", "", "o0", "k0", "n0", "p0", "m0", "Landroid/content/Context;", "context", "", "viewType", "initView", "getLayoutId", "objData", com.tencent.luggage.wxa.c8.c.G, "l0", "Landroid/view/View;", "v", NodeProps.ON_CLICK, "d", "Landroid/view/View;", "titleContainer", "Landroid/widget/TextView;", "e", "Landroid/widget/TextView;", "titleTv", "f", "infoTv", "Landroidx/recyclerview/widget/RecyclerView;", tl.h.F, "Landroidx/recyclerview/widget/RecyclerView;", "episodesRv", "i", "Lqqcircle/QQCircleFeedAlbum$StVideoAlbumFeedInfo;", "albumInfo", "La40/l;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "La40/l;", "adapter", "<init>", "(Landroid/content/Context;)V", BdhLogUtil.LogTag.Tag_Conn, "a", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class QFSRelatedAlbumsView extends QCircleBaseWidgetView<QQCircleFeedAlbum$StVideoAlbumFeedInfo> implements View.OnClickListener {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private View titleContainer;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private TextView titleTv;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private TextView infoTv;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private RecyclerView episodesRv;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private QQCircleFeedAlbum$StVideoAlbumFeedInfo albumInfo;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private a40.l adapter;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J(\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/biz/qqcircle/immersive/album/view/QFSRelatedAlbumsView$b", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "Landroid/graphics/Rect;", "outRect", "Landroid/view/View;", "view", "Landroidx/recyclerview/widget/RecyclerView;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroidx/recyclerview/widget/RecyclerView$State;", "state", "", "getItemOffsets", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
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
            super.getItemOffsets(outRect, view, parent, state);
            if (parent.getChildAdapterPosition(view) == 0) {
                outRect.left = DisplayUtil.dip2px(QFSRelatedAlbumsView.this.getContext(), 16.0f);
            }
            outRect.right = DisplayUtil.dip2px(QFSRelatedAlbumsView.this.getContext(), 9.0f);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QFSRelatedAlbumsView(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void k0() {
        QQCircleFeedAlbum$StVideoAlbumFeedInfo qQCircleFeedAlbum$StVideoAlbumFeedInfo = this.albumInfo;
        if (qQCircleFeedAlbum$StVideoAlbumFeedInfo != null) {
            StringBuilder sb5 = new StringBuilder(qQCircleFeedAlbum$StVideoAlbumFeedInfo.page_views.get());
            sb5.append(com.tencent.biz.qqcircle.utils.h.a(R.string.f188303wb));
            sb5.append("\u00b7");
            sb5.append(qQCircleFeedAlbum$StVideoAlbumFeedInfo.item_count.get());
            sb5.append(com.tencent.biz.qqcircle.utils.h.a(R.string.f1901941f));
            TextView textView = this.infoTv;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("infoTv");
                textView = null;
            }
            textView.setText(sb5);
        }
    }

    private final void m0() {
        Long l3;
        Long l16;
        Long l17;
        PBUInt64Field pBUInt64Field;
        PBUInt64Field pBUInt64Field2;
        PBUInt64Field pBUInt64Field3;
        Map<String, Object> params = new QCircleDTParamBuilder().buildElementParams();
        Intrinsics.checkNotNullExpressionValue(params, "params");
        QQCircleFeedAlbum$StVideoAlbumFeedInfo qQCircleFeedAlbum$StVideoAlbumFeedInfo = this.albumInfo;
        View view = null;
        if (qQCircleFeedAlbum$StVideoAlbumFeedInfo != null && (pBUInt64Field3 = qQCircleFeedAlbum$StVideoAlbumFeedInfo.album_id) != null) {
            l3 = Long.valueOf(pBUInt64Field3.get());
        } else {
            l3 = null;
        }
        params.put(QCircleDaTongConstant.ElementParamKey.XSJ_ALBUM_ID, l3);
        VideoReport.setElementId(this, QCircleDaTongConstant.ElementId.EM_XSJ_REC_ALBUM_CARD);
        VideoReport.setElementParams(this, params);
        VideoReport.setElementClickPolicy(this, ClickPolicy.REPORT_NONE);
        VideoReport.setElementExposePolicy(this, ExposurePolicy.REPORT_ALL);
        VideoReport.setElementEndExposePolicy(this, EndExposurePolicy.REPORT_ALL);
        int hashCode = hashCode();
        QQCircleFeedAlbum$StVideoAlbumFeedInfo qQCircleFeedAlbum$StVideoAlbumFeedInfo2 = this.albumInfo;
        if (qQCircleFeedAlbum$StVideoAlbumFeedInfo2 != null && (pBUInt64Field2 = qQCircleFeedAlbum$StVideoAlbumFeedInfo2.album_id) != null) {
            l16 = Long.valueOf(pBUInt64Field2.get());
        } else {
            l16 = null;
        }
        VideoReport.setElementReuseIdentifier(this, QCircleDaTongConstant.ElementId.EM_XSJ_REC_ALBUM_CARD + hashCode + l16);
        View view2 = this.titleContainer;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleContainer");
            view2 = null;
        }
        VideoReport.setElementId(view2, QCircleDaTongConstant.ElementId.EM_XSJ_ALBUM_CARD_MORE);
        View view3 = this.titleContainer;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleContainer");
            view3 = null;
        }
        VideoReport.setElementParams(view3, params);
        View view4 = this.titleContainer;
        if (view4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleContainer");
            view4 = null;
        }
        VideoReport.setElementClickPolicy(view4, ClickPolicy.REPORT_ALL);
        View view5 = this.titleContainer;
        if (view5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleContainer");
            view5 = null;
        }
        VideoReport.setElementExposePolicy(view5, ExposurePolicy.REPORT_NONE);
        View view6 = this.titleContainer;
        if (view6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleContainer");
            view6 = null;
        }
        VideoReport.setElementEndExposePolicy(view6, EndExposurePolicy.REPORT_NONE);
        int hashCode2 = hashCode();
        QQCircleFeedAlbum$StVideoAlbumFeedInfo qQCircleFeedAlbum$StVideoAlbumFeedInfo3 = this.albumInfo;
        if (qQCircleFeedAlbum$StVideoAlbumFeedInfo3 != null && (pBUInt64Field = qQCircleFeedAlbum$StVideoAlbumFeedInfo3.album_id) != null) {
            l17 = Long.valueOf(pBUInt64Field.get());
        } else {
            l17 = null;
        }
        String str = QCircleDaTongConstant.ElementId.EM_XSJ_ALBUM_CARD_MORE + hashCode2 + l17;
        View view7 = this.titleContainer;
        if (view7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleContainer");
        } else {
            view = view7;
        }
        VideoReport.setElementReuseIdentifier(view, str);
    }

    private final void n0() {
        a40.l lVar;
        QQCircleFeedAlbum$StVideoAlbumFeedInfo qQCircleFeedAlbum$StVideoAlbumFeedInfo = this.albumInfo;
        if (qQCircleFeedAlbum$StVideoAlbumFeedInfo != null && (lVar = this.adapter) != null) {
            List<QQCircleFeedAlbum$StFeedDetail> list = qQCircleFeedAlbum$StVideoAlbumFeedInfo.detail.get();
            Intrinsics.checkNotNullExpressionValue(list, "it.detail.get()");
            lVar.setData(list);
        }
    }

    private final void o0() {
        SafeLinearLayoutManager safeLinearLayoutManager = new SafeLinearLayoutManager(getContext());
        safeLinearLayoutManager.setOrientation(0);
        RecyclerView recyclerView = this.episodesRv;
        RecyclerView recyclerView2 = null;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("episodesRv");
            recyclerView = null;
        }
        recyclerView.setLayoutManager(safeLinearLayoutManager);
        RecyclerView recyclerView3 = this.episodesRv;
        if (recyclerView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("episodesRv");
            recyclerView3 = null;
        }
        recyclerView3.addItemDecoration(new b());
        this.adapter = new a40.l();
        RecyclerView recyclerView4 = this.episodesRv;
        if (recyclerView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("episodesRv");
        } else {
            recyclerView2 = recyclerView4;
        }
        recyclerView2.setAdapter(this.adapter);
    }

    private final void p0() {
        String str;
        PBStringField pBStringField;
        Context context = getContext();
        QQCircleFeedAlbum$StVideoAlbumFeedInfo qQCircleFeedAlbum$StVideoAlbumFeedInfo = this.albumInfo;
        if (qQCircleFeedAlbum$StVideoAlbumFeedInfo != null && (pBStringField = qQCircleFeedAlbum$StVideoAlbumFeedInfo.more_schema) != null) {
            str = pBStringField.get();
        } else {
            str = null;
        }
        QCircleSchemeLauncher.f(context, str);
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.gq_;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public void initView(@Nullable Context context, int viewType) {
        super.initView(context, viewType);
        View findViewById = findViewById(R.id.f519429g);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.qfs_re\u2026d_albums_title_container)");
        this.titleContainer = findViewById;
        View findViewById2 = findViewById(R.id.f519329f);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.qfs_related_albums_title)");
        this.titleTv = (TextView) findViewById2;
        View findViewById3 = findViewById(R.id.f519029c);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.qfs_related_albums_info)");
        this.infoTv = (TextView) findViewById3;
        View findViewById4 = findViewById(R.id.f519229e);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.qfs_related_albums_recycler)");
        this.episodesRv = (RecyclerView) findViewById4;
        o0();
        View view = this.titleContainer;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleContainer");
            view = null;
        }
        view.setOnClickListener(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    /* renamed from: l0, reason: merged with bridge method [inline-methods] */
    public void bindData(@Nullable QQCircleFeedAlbum$StVideoAlbumFeedInfo objData, int pos) {
        PBStringField pBStringField;
        this.albumInfo = objData;
        TextView textView = this.titleTv;
        String str = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleTv");
            textView = null;
        }
        QQCircleFeedAlbum$StVideoAlbumFeedInfo qQCircleFeedAlbum$StVideoAlbumFeedInfo = this.albumInfo;
        if (qQCircleFeedAlbum$StVideoAlbumFeedInfo != null && (pBStringField = qQCircleFeedAlbum$StVideoAlbumFeedInfo.album_title) != null) {
            str = pBStringField.get();
        }
        textView.setText(str);
        k0();
        n0();
        m0();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@Nullable View v3) {
        EventCollector.getInstance().onViewClickedBefore(v3);
        p0();
        EventCollector.getInstance().onViewClicked(v3);
    }
}
