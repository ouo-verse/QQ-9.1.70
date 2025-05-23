package f9;

import androidx.recyclerview.widget.DiffUtil;
import com.qzone.reborn.base.h;
import com.tencent.biz.richframework.part.adapter.delegate.AdapterDelegatesManager;
import com.tencent.qqnt.kernel.nativeinterface.GetAllAlbumListItem;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0005"}, d2 = {"Lf9/a;", "Lcom/qzone/reborn/base/h;", "Lcom/tencent/qqnt/kernel/nativeinterface/GetAllAlbumListItem;", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class a extends h<GetAllAlbumListItem> {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\u0018\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"f9/a$a", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lcom/tencent/qqnt/kernel/nativeinterface/GetAllAlbumListItem;", "oldItem", "newItem", "", "b", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: f9.a$a, reason: collision with other inner class name */
    /* loaded from: classes38.dex */
    public static final class C10291a extends DiffUtil.ItemCallback<GetAllAlbumListItem> {
        C10291a() {
        }

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean areContentsTheSame(GetAllAlbumListItem oldItem, GetAllAlbumListItem newItem) {
            Intrinsics.checkNotNullParameter(oldItem, "oldItem");
            Intrinsics.checkNotNullParameter(newItem, "newItem");
            return false;
        }

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public boolean areItemsTheSame(GetAllAlbumListItem oldItem, GetAllAlbumListItem newItem) {
            Intrinsics.checkNotNullParameter(oldItem, "oldItem");
            Intrinsics.checkNotNullParameter(newItem, "newItem");
            return Intrinsics.areEqual(oldItem.qunId, newItem.qunId);
        }
    }

    public a() {
        super(new C10291a(), new AdapterDelegatesManager(new bi.a()));
    }
}
