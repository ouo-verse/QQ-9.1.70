package com.qzone.reborn.groupalbum.block;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.qzone.reborn.groupalbum.widget.GroupAlbumAlbumListInfoHeadView;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u000b\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0002\u001c\u001dB\u0007\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u001c\u0010\u0007\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u001c\u0010\u000b\u001a\u00020\n2\n\u0010\b\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\t\u001a\u00020\u0005H\u0016J\u000e\u0010\u000e\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fJ\u000e\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u000fJ\b\u0010\u0012\u001a\u00020\u0005H\u0016J\u0010\u0010\u0014\u001a\u00020\u00132\u0006\u0010\t\u001a\u00020\u0005H\u0016R\u0018\u0010\r\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0019\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001e"}, d2 = {"Lcom/qzone/reborn/groupalbum/block/GroupAlbumAlbumListHeaderAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/qzone/reborn/groupalbum/block/GroupAlbumAlbumListHeaderAdapter$a;", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "viewType", "j0", "holder", "position", "", "i0", "Lcom/qzone/reborn/groupalbum/block/GroupAlbumAlbumListHeaderAdapter$GroupAlbumHeadInfoBean;", "headInfoBean", "k0", "", "show", "l0", "getItemCount", "", "getItemId", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/qzone/reborn/groupalbum/block/GroupAlbumAlbumListHeaderAdapter$GroupAlbumHeadInfoBean;", BdhLogUtil.LogTag.Tag_Conn, "Z", "showHeader", "<init>", "()V", "GroupAlbumHeadInfoBean", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class GroupAlbumAlbumListHeaderAdapter extends RecyclerView.Adapter<a> {

    /* renamed from: C, reason: from kotlin metadata */
    private boolean showHeader = true;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private GroupAlbumHeadInfoBean headInfoBean;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e\u00a8\u0006\u000f"}, d2 = {"Lcom/qzone/reborn/groupalbum/block/GroupAlbumAlbumListHeaderAdapter$GroupAlbumHeadInfoBean;", "Ljava/io/Serializable;", "albumNum", "", "mediaNum", "show", "", "(IIZ)V", "getAlbumNum", "()I", "getMediaNum", "getShow", "()Z", "setShow", "(Z)V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes37.dex */
    public static final class GroupAlbumHeadInfoBean implements Serializable {
        private final int albumNum;
        private final int mediaNum;
        private boolean show;

        public GroupAlbumHeadInfoBean(int i3, int i16, boolean z16) {
            this.albumNum = i3;
            this.mediaNum = i16;
            this.show = z16;
        }

        public final int getAlbumNum() {
            return this.albumNum;
        }

        public final int getMediaNum() {
            return this.mediaNum;
        }

        public final boolean getShow() {
            return this.show;
        }

        public final void setShow(boolean z16) {
            this.show = z16;
        }

        public /* synthetic */ GroupAlbumHeadInfoBean(int i3, int i16, boolean z16, int i17, DefaultConstructorMarker defaultConstructorMarker) {
            this(i3, i16, (i17 & 4) != 0 ? true : z16);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\t\u001a\u00020\b\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0018\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004\u00a8\u0006\f"}, d2 = {"Lcom/qzone/reborn/groupalbum/block/GroupAlbumAlbumListHeaderAdapter$a;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/qzone/reborn/groupalbum/block/GroupAlbumAlbumListHeaderAdapter$GroupAlbumHeadInfoBean;", "headInfoBean", "", "position", "", "l", "Landroid/view/ViewGroup;", "itemView", "<init>", "(Lcom/qzone/reborn/groupalbum/block/GroupAlbumAlbumListHeaderAdapter;Landroid/view/ViewGroup;)V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public final class a extends RecyclerView.ViewHolder {
        final /* synthetic */ GroupAlbumAlbumListHeaderAdapter E;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(GroupAlbumAlbumListHeaderAdapter groupAlbumAlbumListHeaderAdapter, ViewGroup itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            this.E = groupAlbumAlbumListHeaderAdapter;
        }

        public final void l(GroupAlbumHeadInfoBean headInfoBean, int position) {
            View view = this.itemView;
            if (view instanceof GroupAlbumAlbumListInfoHeadView) {
                GroupAlbumAlbumListInfoHeadView groupAlbumAlbumListInfoHeadView = view instanceof GroupAlbumAlbumListInfoHeadView ? (GroupAlbumAlbumListInfoHeadView) view : null;
                if (groupAlbumAlbumListInfoHeadView != null) {
                    groupAlbumAlbumListInfoHeadView.setData(headInfoBean, position);
                }
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int position) {
        return position;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: i0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(a holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        GroupAlbumHeadInfoBean groupAlbumHeadInfoBean = this.headInfoBean;
        if (groupAlbumHeadInfoBean != null) {
            holder.l(groupAlbumHeadInfoBean, position);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: j0, reason: merged with bridge method [inline-methods] */
    public a onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        Context context = parent.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "parent.context");
        return new a(this, new GroupAlbumAlbumListInfoHeadView(context));
    }

    public final void k0(GroupAlbumHeadInfoBean headInfoBean) {
        Intrinsics.checkNotNullParameter(headInfoBean, "headInfoBean");
        this.headInfoBean = headInfoBean;
        if (headInfoBean != null) {
            headInfoBean.setShow(this.showHeader);
        }
        notifyDataSetChanged();
    }

    public final void l0(boolean show) {
        this.showHeader = show;
        GroupAlbumHeadInfoBean groupAlbumHeadInfoBean = this.headInfoBean;
        if (groupAlbumHeadInfoBean != null) {
            Intrinsics.checkNotNull(groupAlbumHeadInfoBean);
            k0(groupAlbumHeadInfoBean);
        }
    }
}
