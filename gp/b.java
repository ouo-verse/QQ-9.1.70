package gp;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.qzone.reborn.base.i;
import com.qzone.widget.recommendfriend.QZoneRecommendFriendPicWidgetView;
import com.tencent.mobileqq.data.MayKnowRecommend;
import com.tencent.mobileqq.data.MediaInfo;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001 B\u0007\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0018\u0010\f\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0005H\u0016J\b\u0010\r\u001a\u00020\u0005H\u0016J\u001e\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000e2\u000e\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010R\u0016\u0010\u0016\u001a\u00020\u000e8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R(\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00110\u00108\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001c\u00a8\u0006!"}, d2 = {"Lgp/b;", "Lcom/qzone/reborn/base/i;", "Lgp/b$a;", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "viewType", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "onCreateItemViewHolder", "holder", "position", "", "onBindViewHolder", "getItemCount", "Lcom/tencent/mobileqq/data/MayKnowRecommend;", "data", "", "Lcom/tencent/mobileqq/data/MediaInfo;", "mediaList", "i0", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/data/MayKnowRecommend;", "batchData", BdhLogUtil.LogTag.Tag_Conn, "Ljava/util/List;", "getMediaInfoList", "()Ljava/util/List;", "setMediaInfoList", "(Ljava/util/List;)V", "mediaInfoList", "<init>", "()V", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class b extends i<a> {

    /* renamed from: C, reason: from kotlin metadata */
    private List<MediaInfo> mediaInfoList = new ArrayList();

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private MayKnowRecommend batchData;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000b\u001a\u00020\n\u00a2\u0006\u0004\b\f\u0010\rJ\u001e\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006\u00a8\u0006\u000e"}, d2 = {"Lgp/b$a;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/tencent/mobileqq/data/MayKnowRecommend;", "batchData", "Lcom/tencent/mobileqq/data/MediaInfo;", "mediaInfo", "", "position", "", "l", "Landroid/view/View;", "itemView", "<init>", "(Lgp/b;Landroid/view/View;)V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes38.dex */
    public final class a extends RecyclerView.ViewHolder {
        final /* synthetic */ b E;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(b bVar, View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            this.E = bVar;
        }

        public final void l(MayKnowRecommend batchData, MediaInfo mediaInfo, int position) {
            Intrinsics.checkNotNullParameter(batchData, "batchData");
            Intrinsics.checkNotNullParameter(mediaInfo, "mediaInfo");
            View view = this.itemView;
            if (view instanceof QZoneRecommendFriendPicWidgetView) {
                Intrinsics.checkNotNull(view, "null cannot be cast to non-null type com.qzone.widget.recommendfriend.QZoneRecommendFriendPicWidgetView");
                ((QZoneRecommendFriendPicWidgetView) view).setBatchData(batchData);
                View view2 = this.itemView;
                Intrinsics.checkNotNull(view2, "null cannot be cast to non-null type com.qzone.widget.recommendfriend.QZoneRecommendFriendPicWidgetView");
                ((QZoneRecommendFriendPicWidgetView) view2).setData(mediaInfo, position);
            }
        }
    }

    public b() {
        setHasStableIds(true);
    }

    @Override // com.tencent.biz.richframework.part.block.base.BaseListViewAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getNUM_BACKGOURND_ICON() {
        return this.mediaInfoList.size();
    }

    public final void i0(MayKnowRecommend data, List<MediaInfo> mediaList) {
        Intrinsics.checkNotNullParameter(data, "data");
        this.batchData = data;
        if (mediaList == null) {
            mediaList = new ArrayList<>();
        }
        this.mediaInfoList = mediaList;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        if (holder instanceof a) {
            a aVar = (a) holder;
            MayKnowRecommend mayKnowRecommend = this.batchData;
            if (mayKnowRecommend == null) {
                Intrinsics.throwUninitializedPropertyAccessException("batchData");
                mayKnowRecommend = null;
            }
            aVar.l(mayKnowRecommend, this.mediaInfoList.get(position), position);
        }
    }

    @Override // com.qzone.reborn.base.i
    public RecyclerView.ViewHolder onCreateItemViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        Context context = parent.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "parent.context");
        return new a(this, new QZoneRecommendFriendPicWidgetView(context));
    }
}
