package i9;

import androidx.recyclerview.widget.DiffUtil;
import com.qzone.reborn.albumx.common.bean.CommonGridItemData;
import com.tencent.biz.richframework.part.adapter.delegate.AdapterDelegatesManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\u00a2\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0014R\u0014\u0010\u000b\u001a\u00020\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\u000e"}, d2 = {"Li9/a;", "Lcom/qzone/reborn/base/h;", "Lcom/qzone/reborn/albumx/common/bean/CommonGridItemData;", "", "position", "", "getItemId", "", "j0", "E", "Z", "isOpenAddPositionSwitch", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class a extends com.qzone.reborn.base.h<CommonGridItemData> {

    /* renamed from: E, reason: from kotlin metadata */
    private final boolean isOpenAddPositionSwitch;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\u0018\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"i9/a$a", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lcom/qzone/reborn/albumx/common/bean/CommonGridItemData;", "oldItem", "newItem", "", "b", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: i9.a$a, reason: collision with other inner class name */
    /* loaded from: classes38.dex */
    public static final class C10514a extends DiffUtil.ItemCallback<CommonGridItemData> {
        C10514a() {
        }

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean areContentsTheSame(CommonGridItemData oldItem, CommonGridItemData newItem) {
            Intrinsics.checkNotNullParameter(oldItem, "oldItem");
            Intrinsics.checkNotNullParameter(newItem, "newItem");
            return false;
        }

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public boolean areItemsTheSame(CommonGridItemData oldItem, CommonGridItemData newItem) {
            Intrinsics.checkNotNullParameter(oldItem, "oldItem");
            Intrinsics.checkNotNullParameter(newItem, "newItem");
            return aa.d.f25752a.b(oldItem, newItem);
        }
    }

    public a() {
        super(new C10514a(), new AdapterDelegatesManager(new m9.b(), new m9.c(), new m9.a()));
        this.isOpenAddPositionSwitch = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("common_album_detail_list_open_position_add", true);
    }

    @Override // com.tencent.biz.richframework.part.adapter.AsyncListDifferDelegationAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int position) {
        if (getItems().get(position).getItemType() == CommonGridItemData.ItemType.HEAD_SECTION_ITEM) {
            if (getItems().get(position).getBatchBean().getBatchInfo().getLinkId() == 0) {
                return super.getItemId(position);
            }
            return getItems().get(position).getBatchBean().getBatchInfo().getLinkId();
        }
        if (getItems().get(position).getItemType() == CommonGridItemData.ItemType.PIC_SECTION_ITEM) {
            if (aa.e.f25753a.b(getItems().get(position).f()) != null) {
                return r0.hashCode();
            }
            return super.getItemId(position);
        }
        return super.getItemId(position);
    }

    @Override // com.qzone.reborn.base.h
    protected boolean j0() {
        return true;
    }
}
