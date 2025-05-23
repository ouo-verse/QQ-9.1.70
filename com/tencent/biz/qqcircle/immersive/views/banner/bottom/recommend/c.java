package com.tencent.biz.qqcircle.immersive.views.banner.bottom.recommend;

import android.content.Context;
import android.util.Size;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.qqcircle.immersive.views.banner.bottom.recommend.QFSBottomVideoContainerItemView;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import feedcloud.FeedCloudMeta$StFeed;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\u0018\u0000 !2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\"#B\u0007\u00a2\u0006\u0004\b\u001f\u0010 J\u000e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003J\u0010\u0010\t\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007J\u000e\u0010\f\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\nJ\u0018\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\u0018\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u000fH\u0016R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0018\u0010\u001e\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001d\u00a8\u0006$"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/views/banner/bottom/recommend/c;", "Lcom/tencent/biz/qqcircle/immersive/adapter/a;", "Le30/b;", "Lcom/tencent/biz/qqcircle/immersive/views/banner/bottom/recommend/QFSBottomVideoContainerItemView$b;", "playListener", "", "j0", "Lfeedcloud/FeedCloudMeta$StFeed;", "feed", "i0", "Landroid/util/Size;", "size", "k0", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "viewType", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "onCreateItemViewHolder", "holder", "position", "onBindViewHolder", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/biz/qqcircle/immersive/views/banner/bottom/recommend/QFSBottomVideoContainerItemView$b;", "itemPlayListener", BdhLogUtil.LogTag.Tag_Conn, "Lfeedcloud/FeedCloudMeta$StFeed;", "containerFeed", "D", "Landroid/util/Size;", "itemSize", "<init>", "()V", "E", "a", "b", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class c extends com.tencent.biz.qqcircle.immersive.adapter.a<e30.b> {

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private FeedCloudMeta$StFeed containerFeed;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private Size itemSize;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private QFSBottomVideoContainerItemView.b itemPlayListener;

    /* compiled from: P */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u00a2\u0006\u0004\b\u0011\u0010\u0012J*\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bJ\u000e\u0010\u000e\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/views/banner/bottom/recommend/c$b;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Le30/b;", "data", "", com.tencent.luggage.wxa.c8.c.G, "Lfeedcloud/FeedCloudMeta$StFeed;", "containerFeed", "Landroid/util/Size;", "size", "", "l", "Lcom/tencent/biz/qqcircle/immersive/views/banner/bottom/recommend/QFSBottomVideoContainerItemView$b;", "listener", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/view/View;", "itemView", "<init>", "(Landroid/view/View;)V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes4.dex */
    public static final class b extends RecyclerView.ViewHolder {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(@NotNull View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
        }

        public final void l(@NotNull e30.b data, int pos, @Nullable FeedCloudMeta$StFeed containerFeed, @Nullable Size size) {
            QFSBottomVideoContainerItemView qFSBottomVideoContainerItemView;
            Intrinsics.checkNotNullParameter(data, "data");
            View view = this.itemView;
            if (view instanceof QFSBottomVideoContainerItemView) {
                qFSBottomVideoContainerItemView = (QFSBottomVideoContainerItemView) view;
            } else {
                qFSBottomVideoContainerItemView = null;
            }
            if (qFSBottomVideoContainerItemView != null) {
                qFSBottomVideoContainerItemView.setItemSize(size);
            }
            if (qFSBottomVideoContainerItemView != null) {
                qFSBottomVideoContainerItemView.setData(data, pos);
            }
            if (qFSBottomVideoContainerItemView != null) {
                qFSBottomVideoContainerItemView.setContainerFeed(containerFeed);
            }
        }

        public final void m(@NotNull QFSBottomVideoContainerItemView.b listener) {
            QFSBottomVideoContainerItemView qFSBottomVideoContainerItemView;
            Intrinsics.checkNotNullParameter(listener, "listener");
            View view = this.itemView;
            if (view instanceof QFSBottomVideoContainerItemView) {
                qFSBottomVideoContainerItemView = (QFSBottomVideoContainerItemView) view;
            } else {
                qFSBottomVideoContainerItemView = null;
            }
            if (qFSBottomVideoContainerItemView != null) {
                qFSBottomVideoContainerItemView.setListener(listener);
            }
        }
    }

    public final void i0(@Nullable FeedCloudMeta$StFeed feed) {
        this.containerFeed = feed;
    }

    public final void j0(@NotNull QFSBottomVideoContainerItemView.b playListener) {
        Intrinsics.checkNotNullParameter(playListener, "playListener");
        this.itemPlayListener = playListener;
    }

    public final void k0(@NotNull Size size) {
        Intrinsics.checkNotNullParameter(size, "size");
        this.itemSize = size;
    }

    @Override // com.tencent.biz.richframework.video.rfw.drive.RFWBaseVideoAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NotNull RecyclerView.ViewHolder holder, int position) {
        b bVar;
        Intrinsics.checkNotNullParameter(holder, "holder");
        super.onBindViewHolder(holder, position);
        if (getDataList().size() <= position) {
            return;
        }
        if (holder instanceof b) {
            bVar = (b) holder;
        } else {
            bVar = null;
        }
        if (bVar != null) {
            e30.b bVar2 = getDataList().get(position);
            Intrinsics.checkNotNullExpressionValue(bVar2, "dataList[position]");
            bVar.l(bVar2, position, this.containerFeed, this.itemSize);
        }
        QFSBottomVideoContainerItemView.b bVar3 = this.itemPlayListener;
        if (bVar3 != null && bVar != null) {
            bVar.m(bVar3);
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.adapter.a
    @NotNull
    public RecyclerView.ViewHolder onCreateItemViewHolder(@NotNull ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        Context context = parent.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "parent.context");
        return new b(new QFSBottomVideoContainerItemView(context));
    }
}
