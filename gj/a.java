package gj;

import androidx.recyclerview.widget.DiffUtil;
import com.qzone.reborn.intimate.bean.QZoneAlbumInfoBean;
import com.tencent.biz.richframework.part.adapter.delegate.AdapterDelegatesManager;
import com.tencent.mobileqq.pb.PBStringField;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import qzone.QZIntimateSpaceAlbum$AlbumSpaceInfo;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016\u00a8\u0006\t"}, d2 = {"Lgj/a;", "Lcom/qzone/reborn/base/h;", "Lcom/qzone/reborn/intimate/bean/QZoneAlbumInfoBean;", "", "position", "", "getItemId", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class a extends com.qzone.reborn.base.h<QZoneAlbumInfoBean> {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\u0018\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"gj/a$a", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lcom/qzone/reborn/intimate/bean/QZoneAlbumInfoBean;", "oldItem", "newItem", "", "b", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: gj.a$a, reason: collision with other inner class name */
    /* loaded from: classes38.dex */
    public static final class C10379a extends DiffUtil.ItemCallback<QZoneAlbumInfoBean> {
        C10379a() {
        }

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean areContentsTheSame(QZoneAlbumInfoBean oldItem, QZoneAlbumInfoBean newItem) {
            Intrinsics.checkNotNullParameter(oldItem, "oldItem");
            Intrinsics.checkNotNullParameter(newItem, "newItem");
            return false;
        }

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public boolean areItemsTheSame(QZoneAlbumInfoBean oldItem, QZoneAlbumInfoBean newItem) {
            Intrinsics.checkNotNullParameter(oldItem, "oldItem");
            Intrinsics.checkNotNullParameter(newItem, "newItem");
            PBStringField pBStringField = oldItem.getAlbumInfo().space_id;
            String str = pBStringField != null ? pBStringField.get() : null;
            PBStringField pBStringField2 = newItem.getAlbumInfo().space_id;
            return Intrinsics.areEqual(str, pBStringField2 != null ? pBStringField2.get() : null);
        }
    }

    public a() {
        super(new C10379a(), new AdapterDelegatesManager(new rj.d()));
    }

    @Override // com.tencent.biz.richframework.part.adapter.AsyncListDifferDelegationAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int position) {
        QZIntimateSpaceAlbum$AlbumSpaceInfo albumInfo;
        QZoneAlbumInfoBean qZoneAlbumInfoBean = getItems().get(position);
        PBStringField pBStringField = (qZoneAlbumInfoBean == null || (albumInfo = qZoneAlbumInfoBean.getAlbumInfo()) == null) ? null : albumInfo.space_id;
        if (getItems().size() > position && pBStringField != null) {
            return pBStringField.get().hashCode();
        }
        return super.getItemId(position);
    }
}
