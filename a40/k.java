package a40;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.qqcircle.immersive.album.view.QFSRelatedAlbumsHintView;
import com.tencent.biz.qqcircle.immersive.album.view.QFSRelatedAlbumsView;
import com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView;
import com.tencent.biz.richframework.part.block.base.LoadInfo;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import qqcircle.QQCircleFeedAlbum$StVideoAlbumFeedInfo;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u001e2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u001f B\u000f\u0012\u0006\u0010\u001b\u001a\u00020\u0007\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\b\u0010\u0004\u001a\u00020\u0003H\u0014J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\u0012\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\u0012\u0010\r\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016J\b\u0010\u000e\u001a\u00020\u0005H\u0016J\u0010\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0005H\u0016J\u0018\u0010\u0013\u001a\u00020\t2\u000e\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0011H\u0016J\u0018\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0005H\u0016J\u0018\u0010\u001a\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\u00172\u0006\u0010\u000f\u001a\u00020\u0005H\u0016\u00a8\u0006!"}, d2 = {"La40/k;", "Lcom/tencent/biz/qqcircle/bizparts/a;", "Lqqcircle/QQCircleFeedAlbum$StVideoAlbumFeedInfo;", "", "getLogTag", "", "getItemCount", "Landroid/os/Bundle;", "initParams", "", "onInitBlock", "Lcom/tencent/biz/richframework/part/block/base/LoadInfo;", "loadInfo", "loadData", "getViewTypeCount", "position", "getItemViewType", "", "list", "setDatas", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "viewType", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "onCreateItemViewHolder", "holder", "onBindViewHolder", "initBean", "<init>", "(Landroid/os/Bundle;)V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "a", "b", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class k extends com.tencent.biz.qqcircle.bizparts.a<QQCircleFeedAlbum$StVideoAlbumFeedInfo> {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\b\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004\u00a8\u0006\f"}, d2 = {"La40/k$b;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lqqcircle/QQCircleFeedAlbum$StVideoAlbumFeedInfo;", "albumInfo", "", com.tencent.luggage.wxa.c8.c.G, "", "l", "Lcom/tencent/biz/qqcircle/widgets/QCircleBaseWidgetView;", "itemView", "<init>", "(Lcom/tencent/biz/qqcircle/widgets/QCircleBaseWidgetView;)V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes4.dex */
    private static final class b extends RecyclerView.ViewHolder {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(@NotNull QCircleBaseWidgetView<QQCircleFeedAlbum$StVideoAlbumFeedInfo> itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
        }

        public final void l(@NotNull QQCircleFeedAlbum$StVideoAlbumFeedInfo albumInfo, int pos) {
            QCircleBaseWidgetView qCircleBaseWidgetView;
            Intrinsics.checkNotNullParameter(albumInfo, "albumInfo");
            View view = this.itemView;
            if (view instanceof QCircleBaseWidgetView) {
                qCircleBaseWidgetView = (QCircleBaseWidgetView) view;
            } else {
                qCircleBaseWidgetView = null;
            }
            if (qCircleBaseWidgetView != null) {
                qCircleBaseWidgetView.setData(albumInfo, pos);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(@NotNull Bundle initBean) {
        super(initBean);
        Intrinsics.checkNotNullParameter(initBean, "initBean");
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock, com.tencent.biz.richframework.part.block.base.BaseListViewAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getNUM_BACKGOURND_ICON() {
        return getDataList().size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        if (position == 0) {
            return 0;
        }
        return 1;
    }

    @Override // com.tencent.biz.qqcircle.bizparts.a
    @NotNull
    protected String getLogTag() {
        return "QFSRelatedAlbumsBlock";
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock
    public int getViewTypeCount() {
        return 2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NotNull RecyclerView.ViewHolder holder, int position) {
        b bVar;
        Intrinsics.checkNotNullParameter(holder, "holder");
        if (ab0.a.a(position, getDataList())) {
            return;
        }
        if (holder instanceof b) {
            bVar = (b) holder;
        } else {
            bVar = null;
        }
        if (bVar != null) {
            QQCircleFeedAlbum$StVideoAlbumFeedInfo qQCircleFeedAlbum$StVideoAlbumFeedInfo = getDataList().get(position);
            Intrinsics.checkNotNullExpressionValue(qQCircleFeedAlbum$StVideoAlbumFeedInfo, "dataList[position]");
            bVar.l(qQCircleFeedAlbum$StVideoAlbumFeedInfo, position);
        }
    }

    @Override // com.tencent.biz.qqcircle.bizparts.a
    @NotNull
    public RecyclerView.ViewHolder onCreateItemViewHolder(@NotNull ViewGroup parent, int viewType) {
        QCircleBaseWidgetView qFSRelatedAlbumsView;
        Intrinsics.checkNotNullParameter(parent, "parent");
        if (viewType == 0) {
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            qFSRelatedAlbumsView = new QFSRelatedAlbumsHintView(context);
        } else {
            Context context2 = getContext();
            Intrinsics.checkNotNullExpressionValue(context2, "context");
            qFSRelatedAlbumsView = new QFSRelatedAlbumsView(context2);
        }
        qFSRelatedAlbumsView.setParentView(parent);
        qFSRelatedAlbumsView.setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
        qFSRelatedAlbumsView.setReportBean(getReportBean());
        qFSRelatedAlbumsView.setExtraTypeInfo(getExtraTypeInfo());
        return new b(qFSRelatedAlbumsView);
    }

    @Override // com.tencent.biz.richframework.part.block.base.BaseListViewAdapter
    public void setDatas(@Nullable List<QQCircleFeedAlbum$StVideoAlbumFeedInfo> list) {
        super.setDatas(list);
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock
    public void loadData(@Nullable LoadInfo loadInfo) {
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock
    public void onInitBlock(@Nullable Bundle initParams) {
    }
}
