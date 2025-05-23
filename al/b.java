package al;

import androidx.recyclerview.widget.DiffUtil;
import bl.CommonNoticeBean;
import com.qzone.reborn.base.h;
import com.tencent.biz.richframework.part.adapter.delegate.AdapterDelegatesManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016\u00a8\u0006\t"}, d2 = {"Lal/b;", "Lcom/qzone/reborn/base/h;", "Lbl/a;", "", "position", "", "getItemId", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes39.dex */
public final class b extends h<CommonNoticeBean> {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\u0018\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"al/b$a", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lbl/a;", "oldItem", "newItem", "", "b", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes39.dex */
    public static final class a extends DiffUtil.ItemCallback<CommonNoticeBean> {
        a() {
        }

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean areContentsTheSame(CommonNoticeBean oldItem, CommonNoticeBean newItem) {
            Intrinsics.checkNotNullParameter(oldItem, "oldItem");
            Intrinsics.checkNotNullParameter(newItem, "newItem");
            return false;
        }

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public boolean areItemsTheSame(CommonNoticeBean oldItem, CommonNoticeBean newItem) {
            Intrinsics.checkNotNullParameter(oldItem, "oldItem");
            Intrinsics.checkNotNullParameter(newItem, "newItem");
            return Intrinsics.areEqual(oldItem.getNotice().getNoticeId(), newItem.getNotice().getNoticeId());
        }
    }

    public b() {
        super(new a(), new AdapterDelegatesManager(new el.b()));
    }

    @Override // com.tencent.biz.richframework.part.adapter.AsyncListDifferDelegationAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int position) {
        if (getItems().size() > position) {
            String noticeId = getItems().get(position).getNotice().getNoticeId();
            return (noticeId + position).hashCode();
        }
        return super.getItemId(position);
    }
}
