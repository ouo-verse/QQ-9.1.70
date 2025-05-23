package ia3;

import android.app.Activity;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.wink.templatelibrary.memoryalbum.data.WinkAlbumItemWrapper;
import com.tencent.mobileqq.wink.templatelibrary.memoryalbum.holder.old.BaseMemoryAlbumViewHolder;
import com.tencent.mobileqq.wink.templatelibrary.memoryalbum.holder.p009new.BaseNewAlbumViewHolder;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\b\u0010\b&\u0018\u0000 )2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001*B\u000f\u0012\u0006\u0010\u001a\u001a\u00020\u0015\u00a2\u0006\u0004\b'\u0010(J\u000e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003J\u0016\u0010\n\u001a\u00020\u00052\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0004J\u0018\u0010\u000f\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0016J\b\u0010\u0010\u001a\u00020\rH\u0016J\u0018\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\rH\u0016J\u0010\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\rH\u0016R\u0017\u0010\u001a\u001a\u00020\u00158\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R \u0010 \u001a\b\u0012\u0004\u0012\u00020\b0\u001b8\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u001d\u0010#\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0006\u00a2\u0006\f\n\u0004\b!\u0010\u001d\u001a\u0004\b\"\u0010\u001fR\u0018\u0010&\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010%\u00a8\u0006+"}, d2 = {"Lia3/a;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lia3/b;", "listener", "", "i0", "", "Lcom/tencent/mobileqq/wink/templatelibrary/memoryalbum/data/a;", "data", "setData", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "viewType", "onCreateViewHolder", "getItemCount", "holder", "position", "onBindViewHolder", "getItemViewType", "Landroid/app/Activity;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/app/Activity;", "getActivity", "()Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", BdhLogUtil.LogTag.Tag_Conn, "Ljava/util/List;", "get_items", "()Ljava/util/List;", "_items", "D", "getItems", "items", "E", "Lia3/b;", "clickListener", "<init>", "(Landroid/app/Activity;)V", UserInfo.SEX_FEMALE, "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public abstract class a extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final List<WinkAlbumItemWrapper> _items;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final List<WinkAlbumItemWrapper> items;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private b clickListener;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Activity activity;

    public a(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.activity = activity;
        ArrayList arrayList = new ArrayList();
        this._items = arrayList;
        this.items = arrayList;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getNUM_BACKGOURND_ICON() {
        return this._items.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        return this._items.get(position).getType().getViewType();
    }

    @NotNull
    public final List<WinkAlbumItemWrapper> getItems() {
        return this.items;
    }

    public final void i0(@NotNull b listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.clickListener = listener;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NotNull RecyclerView.ViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        if (holder instanceof BaseMemoryAlbumViewHolder) {
            ((BaseMemoryAlbumViewHolder) holder).J(this._items.get(position).getWinkMemoryAlbum(), position, 3);
        } else if (holder instanceof BaseNewAlbumViewHolder) {
            ((BaseNewAlbumViewHolder) holder).K(this._items.get(position).getWinkNewAlbum(), position, 3);
        } else if (holder instanceof ka3.a) {
            ((ka3.a) holder).m(Unit.INSTANCE, position, 3);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        return ja3.a.f409682a.a(viewType, parent, this.clickListener);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void setData(@NotNull List<WinkAlbumItemWrapper> data) {
        Intrinsics.checkNotNullParameter(data, "data");
        this._items.clear();
        this._items.addAll(data);
        notifyDataSetChanged();
    }
}
