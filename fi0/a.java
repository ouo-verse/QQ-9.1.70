package fi0;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ecommerce.base.ui.recyclerviewhelper.ECItemTouchHelperAdapter;
import com.tencent.ecommerce.base.ui.recyclerviewhelper.ECOnDragSortListener;
import com.tencent.ecommerce.biz.live.ui.viewholder.ECBaseLiveItemViewHolder;
import com.tencent.ecommerce.biz.live.ui.viewholder.ECNormalMasterLiveItemViewHolder;
import com.tencent.ecommerce.biz.live.ui.viewholder.c;
import com.tencent.ecommerce.biz.live.ui.viewholder.d;
import com.tencent.ecommerce.biz.live.ui.viewholder.g;
import com.tencent.ecommerce.repo.live.LiveProduct;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 P2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001QB\u00b5\u0001\u0012\u0006\u00103\u001a\u000200\u0012\u0006\u00105\u001a\u00020\b\u0012\u0016\u0010:\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\f06j\u0002`7\u0012\u0006\u0010>\u001a\u00020;\u0012\u0016\u0010?\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\f06j\u0002`7\u0012\u0016\u0010A\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\f06j\u0002`7\u0012\u0016\u0010C\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\f06j\u0002`7\u0012\u001c\u0010H\u001a\u0018\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\f0Dj\u0002`E\u0012\u0016\b\u0002\u0010M\u001a\u0010\u0012\u0004\u0012\u00020\f\u0018\u00010Ij\u0004\u0018\u0001`J\u00a2\u0006\u0004\bN\u0010OJ\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\t\u001a\u00020\bH\u0002J\u0016\u0010\r\u001a\u00020\f2\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\nJ\u0016\u0010\u000e\u001a\u00020\f2\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\nJ\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00060\nJ\u000e\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\bJ\u0018\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0004H\u0016J\u0018\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J&\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018H\u0016J\b\u0010\u001b\u001a\u00020\u0004H\u0016J\u0010\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\u001d\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010 \u001a\u00020\b2\u0006\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\u0004H\u0016J\u0010\u0010!\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\u0002H\u0016J\u0010\u0010\"\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\u0002H\u0016J\u000e\u0010$\u001a\u00020\f2\u0006\u0010#\u001a\u00020\u0004R\u0016\u0010'\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010&R&\u0010,\u001a\u0012\u0012\u0004\u0012\u00020\u00060(j\b\u0012\u0004\u0012\u00020\u0006`)8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u0016\u0010/\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u0014\u00103\u001a\u0002008\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b1\u00102R\u0014\u00105\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b4\u0010&R$\u0010:\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\f06j\u0002`78\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b8\u00109R\u0014\u0010>\u001a\u00020;8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b<\u0010=R$\u0010?\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\f06j\u0002`78\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b.\u00109R$\u0010A\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\f06j\u0002`78\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b@\u00109R$\u0010C\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\f06j\u0002`78\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bB\u00109R*\u0010H\u001a\u0018\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\f0Dj\u0002`E8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bF\u0010GR\"\u0010M\u001a\u0010\u0012\u0004\u0012\u00020\f\u0018\u00010Ij\u0004\u0018\u0001`J8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bK\u0010L\u00a8\u0006R"}, d2 = {"Lfi0/a;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/tencent/ecommerce/base/ui/recyclerviewhelper/ECItemTouchHelperAdapter;", "", "position", "Lcom/tencent/ecommerce/repo/live/q;", "i0", "", "k0", "", "productList", "", "setData", "n0", "j0", "state", "l0", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "viewType", "onCreateViewHolder", "holder", "onBindViewHolder", "", "", "payloads", "getItemCount", "getItemViewType", "onItemDismiss", "fromPosition", "toPosition", "onItemMove", "onViewAttachedToWindow", "onViewDetachedFromWindow", "status", "m0", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Z", "isEditable", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", BdhLogUtil.LogTag.Tag_Conn, "Ljava/util/ArrayList;", "liveProductList", "D", "I", "loadStatus", "Landroid/content/Context;", "E", "Landroid/content/Context;", "context", UserInfo.SEX_FEMALE, "isMaster", "Lkotlin/Function1;", "Lcom/tencent/ecommerce/biz/live/ui/adapter/CustomClick;", "G", "Lkotlin/jvm/functions/Function1;", "onItemClick", "Lcom/tencent/ecommerce/base/ui/recyclerviewhelper/ECOnDragSortListener;", "H", "Lcom/tencent/ecommerce/base/ui/recyclerviewhelper/ECOnDragSortListener;", "dragSortListener", "onActionClick", "J", "onSellingPointClick", "K", "onSelectClick", "Lkotlin/Function2;", "Lcom/tencent/ecommerce/biz/live/ui/adapter/ItemExposure;", "L", "Lkotlin/jvm/functions/Function2;", "itemExposure", "Lkotlin/Function0;", "Lcom/tencent/ecommerce/biz/live/ui/adapter/FooterRetryClick;", "M", "Lkotlin/jvm/functions/Function0;", "onFooterRetryClick", "<init>", "(Landroid/content/Context;ZLkotlin/jvm/functions/Function1;Lcom/tencent/ecommerce/base/ui/recyclerviewhelper/ECOnDragSortListener;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function0;)V", "N", "a", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class a extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements ECItemTouchHelperAdapter {

    /* renamed from: C, reason: from kotlin metadata */
    private ArrayList<LiveProduct> liveProductList = new ArrayList<>();

    /* renamed from: D, reason: from kotlin metadata */
    private int loadStatus;

    /* renamed from: E, reason: from kotlin metadata */
    public final Context context;

    /* renamed from: F, reason: from kotlin metadata */
    private final boolean isMaster;

    /* renamed from: G, reason: from kotlin metadata */
    private final Function1<LiveProduct, Unit> onItemClick;

    /* renamed from: H, reason: from kotlin metadata */
    private final ECOnDragSortListener dragSortListener;

    /* renamed from: I, reason: from kotlin metadata */
    private final Function1<LiveProduct, Unit> onActionClick;

    /* renamed from: J, reason: from kotlin metadata */
    private final Function1<LiveProduct, Unit> onSellingPointClick;

    /* renamed from: K, reason: from kotlin metadata */
    private final Function1<LiveProduct, Unit> onSelectClick;

    /* renamed from: L, reason: from kotlin metadata */
    private final Function2<LiveProduct, Boolean, Unit> itemExposure;

    /* renamed from: M, reason: from kotlin metadata */
    private final Function0<Unit> onFooterRetryClick;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private boolean isEditable;

    /* JADX WARN: Multi-variable type inference failed */
    public a(Context context, boolean z16, Function1<? super LiveProduct, Unit> function1, ECOnDragSortListener eCOnDragSortListener, Function1<? super LiveProduct, Unit> function12, Function1<? super LiveProduct, Unit> function13, Function1<? super LiveProduct, Unit> function14, Function2<? super LiveProduct, ? super Boolean, Unit> function2, Function0<Unit> function0) {
        this.context = context;
        this.isMaster = z16;
        this.onItemClick = function1;
        this.dragSortListener = eCOnDragSortListener;
        this.onActionClick = function12;
        this.onSellingPointClick = function13;
        this.onSelectClick = function14;
        this.itemExposure = function2;
        this.onFooterRetryClick = function0;
    }

    private final LiveProduct i0(int position) {
        int size = this.liveProductList.size();
        if (position >= 0 && size > position) {
            return this.liveProductList.get(position);
        }
        return null;
    }

    private final boolean k0() {
        return this.liveProductList.size() > 0 && this.loadStatus != 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (k0()) {
            return this.liveProductList.size() + 1;
        }
        return this.liveProductList.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        LiveProduct.UIStyle uiStyle;
        if (k0() && position + 1 == getItemCount()) {
            return 1;
        }
        LiveProduct i06 = i0(position);
        int i3 = (i06 == null || (uiStyle = i06.getUiStyle()) == null) ? 0 : uiStyle.type;
        return (i3 == 0 || !(i3 == 1 || i3 == 2)) ? 0 : 2;
    }

    public final List<LiveProduct> j0() {
        return this.liveProductList;
    }

    public final void l0(boolean state) {
        if (this.isEditable == state) {
            return;
        }
        this.isEditable = state;
        notifyDataSetChanged();
    }

    public final void m0(int status) {
        int i3 = this.loadStatus;
        this.loadStatus = status;
        if (k0()) {
            notifyItemChanged(getItemCount() - 1);
        } else if (i3 == 0 && this.loadStatus == 1) {
            notifyItemRemoved(getItemCount() - 1);
        }
    }

    public final void n0(List<LiveProduct> productList) {
        this.liveProductList.clear();
        if (productList != null) {
            List<LiveProduct> list = productList;
            if (!list.isEmpty()) {
                this.liveProductList.addAll(list);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        cg0.a.b("ECLiveWindowListAdapter", "onBindViewHolder: position: " + position + " isEditable: " + this.isEditable);
        if (holder instanceof ECBaseLiveItemViewHolder) {
            LiveProduct i06 = i0(position);
            if (i06 != null) {
                i06.N(position);
            }
            ((ECBaseLiveItemViewHolder) holder).t(position, i06, this.isEditable, null);
            return;
        }
        if (holder instanceof d) {
            ((d) holder).m(this.loadStatus);
        }
    }

    @Override // com.tencent.ecommerce.base.ui.recyclerviewhelper.ECItemTouchHelperAdapter
    public void onItemDismiss(int position) {
        cg0.a.b("ECLiveWindowListAdapter", "onItemDismiss: position: " + position);
        this.liveProductList.remove(position);
        notifyItemRemoved(position);
    }

    @Override // com.tencent.ecommerce.base.ui.recyclerviewhelper.ECItemTouchHelperAdapter
    public boolean onItemMove(int fromPosition, int toPosition) {
        cg0.a.b("ECLiveWindowListAdapter", "onItemMove: fromPosition: " + fromPosition + " => toPosition: " + toPosition);
        Collections.swap(this.liveProductList, fromPosition, toPosition);
        notifyItemMoved(fromPosition, toPosition);
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewAttachedToWindow(RecyclerView.ViewHolder holder) {
        LiveProduct i06;
        cg0.a.b("ECLiveWindowListAdapter", "onViewAttachedToWindow: position: " + holder.getAdapterPosition());
        super.onViewAttachedToWindow(holder);
        if (holder.getAdapterPosition() >= 0 && (i06 = i0(holder.getAdapterPosition())) != null) {
            this.itemExposure.invoke(i06, Boolean.FALSE);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewDetachedFromWindow(RecyclerView.ViewHolder holder) {
        LiveProduct i06;
        cg0.a.b("ECLiveWindowListAdapter", "onViewDetachedFromWindow: position: " + holder.getAdapterPosition());
        super.onViewDetachedFromWindow(holder);
        if (holder.getAdapterPosition() >= 0 && (i06 = i0(holder.getAdapterPosition())) != null) {
            this.itemExposure.invoke(i06, Boolean.TRUE);
        }
    }

    public final void setData(List<LiveProduct> productList) {
        this.liveProductList.clear();
        if (productList != null) {
            List<LiveProduct> list = productList;
            if (!list.isEmpty()) {
                this.liveProductList.addAll(list);
            }
        }
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder bVar;
        if (viewType == 1) {
            return new d(LayoutInflater.from(parent.getContext()).inflate(R.layout.crt, parent, false), this.onFooterRetryClick);
        }
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.cru, parent, false);
        if (viewType != 2) {
            if (this.isMaster) {
                bVar = new ECNormalMasterLiveItemViewHolder(inflate, this.onItemClick, this.onActionClick, this.dragSortListener, this.onSelectClick, this.onSellingPointClick);
            } else {
                bVar = new g(inflate, this.onItemClick, this.onActionClick);
            }
        } else if (this.isMaster) {
            bVar = new c(inflate, this.onItemClick, this.onActionClick);
        } else {
            bVar = new com.tencent.ecommerce.biz.live.ui.viewholder.b(inflate, this.onItemClick, this.onActionClick);
        }
        return bVar;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position, List<Object> payloads) {
        cg0.a.b("ECLiveWindowListAdapter", "onBindViewHolder: position: " + position + " isEditable: " + this.isEditable + " payloads:" + payloads);
        if (holder instanceof ECBaseLiveItemViewHolder) {
            LiveProduct i06 = i0(position);
            if (i06 != null) {
                i06.N(position);
            }
            ((ECBaseLiveItemViewHolder) holder).t(position, i06, this.isEditable, payloads);
            return;
        }
        if (holder instanceof d) {
            ((d) holder).m(this.loadStatus);
        }
    }
}
