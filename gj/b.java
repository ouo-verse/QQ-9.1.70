package gj;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.qzone.reborn.albumx.common.bean.CommonAlbumListBean;
import com.qzone.reborn.base.i;
import com.qzone.reborn.intimate.bean.QZoneAlbumInfoBean;
import com.qzone.reborn.intimate.widget.QZoneAlbumIntimateTabContentView;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import qzone.QZoneBaseAlbumMeta$AlbumInfo;

/* compiled from: P */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001\"B\u0007\u00a2\u0006\u0004\b \u0010!J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0018\u0010\f\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0005H\u0016J\b\u0010\r\u001a\u00020\u0005H\u0016J\u0010\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\u0005H\u0016J\u0010\u0010\u0012\u001a\u00020\u000b2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010J\u001c\u0010\u0017\u001a\u00020\u000b2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\u0006\u0010\u0016\u001a\u00020\u0005R\u001c\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00190\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001e\u00a8\u0006#"}, d2 = {"Lgj/b;", "Lcom/qzone/reborn/base/i;", "Lgj/b$a;", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "viewType", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "onCreateItemViewHolder", "holder", "position", "", "onBindViewHolder", "getItemCount", "", "getItemId", "Lcom/qzone/reborn/intimate/bean/QZoneAlbumInfoBean;", "albumInfo", "i0", "", "Lqzone/QZoneBaseAlbumMeta$AlbumInfo;", "albumInfoList", "albumPosition", "q3", "", "Lcom/qzone/reborn/albumx/common/bean/CommonAlbumListBean;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/util/List;", "mAlbumInfoList", BdhLogUtil.LogTag.Tag_Conn, "Lcom/qzone/reborn/intimate/bean/QZoneAlbumInfoBean;", "mAlbumInfoBean", "<init>", "()V", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class b extends i<a> {

    /* renamed from: C, reason: from kotlin metadata */
    private QZoneAlbumInfoBean mAlbumInfoBean;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private List<CommonAlbumListBean> mAlbumInfoList = new ArrayList();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000b\u001a\u00020\n\u00a2\u0006\u0004\b\f\u0010\rJ \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006\u00a8\u0006\u000e"}, d2 = {"Lgj/b$a;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/qzone/reborn/albumx/common/bean/CommonAlbumListBean;", "albumListBean", "Lcom/qzone/reborn/intimate/bean/QZoneAlbumInfoBean;", "spaceInfoBean", "", "position", "", "l", "Landroid/view/View;", "itemView", "<init>", "(Lgj/b;Landroid/view/View;)V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes38.dex */
    public final class a extends RecyclerView.ViewHolder {
        final /* synthetic */ b E;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(b bVar, View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            this.E = bVar;
        }

        public final void l(CommonAlbumListBean albumListBean, QZoneAlbumInfoBean spaceInfoBean, int position) {
            Intrinsics.checkNotNullParameter(albumListBean, "albumListBean");
            View view = this.itemView;
            if (view instanceof QZoneAlbumIntimateTabContentView) {
                Intrinsics.checkNotNull(view, "null cannot be cast to non-null type com.qzone.reborn.intimate.widget.QZoneAlbumIntimateTabContentView");
                ((QZoneAlbumIntimateTabContentView) view).setAlbumSpaceInfoBean(spaceInfoBean);
                View view2 = this.itemView;
                Intrinsics.checkNotNull(view2, "null cannot be cast to non-null type com.qzone.reborn.intimate.widget.QZoneAlbumIntimateTabContentView");
                ((QZoneAlbumIntimateTabContentView) view2).setData(albumListBean, position);
            }
        }
    }

    @Override // com.tencent.biz.richframework.part.block.base.BaseListViewAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getNUM_BACKGOURND_ICON() {
        return this.mAlbumInfoList.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int position) {
        return position;
    }

    public final void i0(QZoneAlbumInfoBean albumInfo) {
        this.mAlbumInfoBean = albumInfo;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        if (holder instanceof a) {
            ((a) holder).l(this.mAlbumInfoList.get(position), this.mAlbumInfoBean, position);
        }
    }

    @Override // com.qzone.reborn.base.i
    public RecyclerView.ViewHolder onCreateItemViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        Context context = parent.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "parent.context");
        return new a(this, new QZoneAlbumIntimateTabContentView(context));
    }

    public final void q3(List<QZoneBaseAlbumMeta$AlbumInfo> albumInfoList, int albumPosition) {
        Intrinsics.checkNotNullParameter(albumInfoList, "albumInfoList");
        this.mAlbumInfoList = new ArrayList();
        Iterator<T> it = albumInfoList.iterator();
        while (it.hasNext()) {
            CommonAlbumListBean commonAlbumListBean = new CommonAlbumListBean(mj.a.b((QZoneBaseAlbumMeta$AlbumInfo) it.next()));
            commonAlbumListBean.setAlbumPosition(albumPosition);
            this.mAlbumInfoList.add(commonAlbumListBean);
        }
        notifyDataSetChanged();
    }
}
