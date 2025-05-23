package i9;

import androidx.recyclerview.widget.DiffUtil;
import com.qzone.reborn.albumx.common.bean.CommonAlbumListBean;
import com.qzone.reborn.albumx.common.convert.bean.CommonAlbumInfo;
import com.tencent.biz.richframework.part.adapter.delegate.AdapterDelegatesManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\u00a2\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0014\u00a8\u0006\u000b"}, d2 = {"Li9/b;", "Lcom/qzone/reborn/base/h;", "Lcom/qzone/reborn/albumx/common/bean/CommonAlbumListBean;", "", "position", "", "getItemId", "", "j0", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class b extends com.qzone.reborn.base.h<CommonAlbumListBean> {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\u0018\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"i9/b$a", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lcom/qzone/reborn/albumx/common/bean/CommonAlbumListBean;", "oldItem", "newItem", "", "b", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes38.dex */
    public static final class a extends DiffUtil.ItemCallback<CommonAlbumListBean> {
        a() {
        }

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean areContentsTheSame(CommonAlbumListBean oldItem, CommonAlbumListBean newItem) {
            Intrinsics.checkNotNullParameter(oldItem, "oldItem");
            Intrinsics.checkNotNullParameter(newItem, "newItem");
            return false;
        }

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public boolean areItemsTheSame(CommonAlbumListBean oldItem, CommonAlbumListBean newItem) {
            Intrinsics.checkNotNullParameter(oldItem, "oldItem");
            Intrinsics.checkNotNullParameter(newItem, "newItem");
            CommonAlbumInfo albumInfo = oldItem.getAlbumInfo();
            String albumId = albumInfo != null ? albumInfo.getAlbumId() : null;
            CommonAlbumInfo albumInfo2 = newItem.getAlbumInfo();
            return Intrinsics.areEqual(albumId, albumInfo2 != null ? albumInfo2.getAlbumId() : null);
        }
    }

    public b() {
        super(new a(), new AdapterDelegatesManager(new m9.d(), new m9.e(), new m9.f()));
    }

    @Override // com.tencent.biz.richframework.part.adapter.AsyncListDifferDelegationAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int position) {
        CommonAlbumInfo albumInfo;
        CommonAlbumListBean commonAlbumListBean = getItems().get(position);
        String albumId = (commonAlbumListBean == null || (albumInfo = commonAlbumListBean.getAlbumInfo()) == null) ? null : albumInfo.getAlbumId();
        if (getItems().size() > position && albumId != null) {
            return (albumId.hashCode() * 10000) + position;
        }
        return super.getItemId(position);
    }

    @Override // com.qzone.reborn.base.h
    protected boolean j0() {
        return true;
    }
}
