package j84;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.sqshow.zootopia.c2c.item.ZootopiaAvatarLoadMoreView;
import com.tencent.widget.pull2refresh.BaseViewHolder;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\b&\u0018\u0000 :*\u0004\b\u0000\u0010\u0001*\u000e\b\u0001\u0010\u0003*\b\u0012\u0004\u0012\u00028\u00000\u00022\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00020\u0004:\u0001;B\u000f\u0012\u0006\u0010,\u001a\u00020'\u00a2\u0006\u0004\b8\u00109J\u001e\u0010\t\u001a\u00020\b2\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J \u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\f\u001a\u00020\u0006H\u0016J!\u0010\u000e\u001a\u00028\u00012\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\f\u001a\u00020\u0006H&\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u001e\u0010\u0010\u001a\u00020\b2\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00022\u0006\u0010\u0007\u001a\u00020\u0006J0\u0010\u0014\u001a\u00020\b2\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u000e\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011H\u0016J0\u0010\u0015\u001a\u00020\b2\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u000e\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011H\u0016J!\u0010\u0016\u001a\u00020\b2\b\u0010\u0005\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0007\u001a\u00020\u0006H&\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u001a\u001a\u00020\b2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018J\u0006\u0010\u001b\u001a\u00020\u0006J\u0014\u0010\u001f\u001a\u00020\u001e2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00028\u00000\u001cJ\u0010\u0010!\u001a\u00020 2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\"\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010#\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H&J\u0017\u0010$\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u0007\u001a\u00020\u0006\u00a2\u0006\u0004\b$\u0010%J\u000e\u0010&\u001a\u00020\u001e2\u0006\u0010\u0007\u001a\u00020\u0006R\u0017\u0010,\u001a\u00020'8\u0006\u00a2\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+R2\u00105\u001a\u0012\u0012\u0004\u0012\u00028\u00000-j\b\u0012\u0004\u0012\u00028\u0000`.8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b/\u00100\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b6\u00107\u00a8\u0006<"}, d2 = {"Lj84/c;", "M", "Lcom/tencent/widget/pull2refresh/BaseViewHolder;", "VH", "Landroid/support/v7/widget/RecyclerView$Adapter;", "holder", "", "position", "", "r", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "viewType", "onCreateViewHolder", "onCreateCustomViewHolder", "(Landroid/view/ViewGroup;I)Lcom/tencent/widget/pull2refresh/BaseViewHolder;", "onBindViewHolder", "", "", "payloads", ReportConstant.COSTREPORT_PREFIX, "t", "onBindCustomViewHolder", "(Lcom/tencent/widget/pull2refresh/BaseViewHolder;I)V", "Lcom/tencent/sqshow/zootopia/c2c/item/ZootopiaAvatarLoadMoreView;", "footerView", "p", "getItemCount", "", "list", "", "fillList", "", "getItemId", "getItemViewType", "getCustomItemViewType", "getItem", "(I)Ljava/lang/Object;", "isFooterPosition", "Landroid/content/Context;", "d", "Landroid/content/Context;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "()Landroid/content/Context;", "context", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "e", "Ljava/util/ArrayList;", "getDataList", "()Ljava/util/ArrayList;", "setDataList", "(Ljava/util/ArrayList;)V", "dataList", "f", "Lcom/tencent/sqshow/zootopia/c2c/item/ZootopiaAvatarLoadMoreView;", "<init>", "(Landroid/content/Context;)V", h.F, "a", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public abstract class c<M, VH extends BaseViewHolder<M>> extends RecyclerView.Adapter<BaseViewHolder<M>> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final Context context;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private ArrayList<M> dataList;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private ZootopiaAvatarLoadMoreView footerView;

    public c(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        this.dataList = new ArrayList<>();
    }

    public final boolean fillList(List<? extends M> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        boolean z16 = !this.dataList.isEmpty();
        this.dataList.clear();
        boolean addAll = this.dataList.addAll(list) | z16;
        if (addAll) {
            notifyDataSetChanged();
        }
        return addAll;
    }

    public abstract int getCustomItemViewType(int position);

    public final M getItem(int position) {
        if (position >= this.dataList.size()) {
            return null;
        }
        return this.dataList.get(position);
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public final int getItemCount() {
        if (this.footerView == null) {
            return this.dataList.size();
        }
        return this.dataList.size() + 1;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public long getItemId(int position) {
        return position;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        if (this.footerView == null || position != this.dataList.size()) {
            return getCustomItemViewType(position);
        }
        return 1025;
    }

    public final boolean isFooterPosition(int position) {
        return position >= getItemCount() - 1;
    }

    public abstract void onBindCustomViewHolder(VH holder, int position);

    public abstract VH onCreateCustomViewHolder(ViewGroup parent, int viewType);

    /* renamed from: q, reason: from getter */
    public final Context getContext() {
        return this.context;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public BaseViewHolder<M> onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == 1025) {
            return new BaseViewHolder<>(this.footerView);
        }
        return onCreateCustomViewHolder(parent, viewType);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    public final void onBindViewHolder(BaseViewHolder<M> holder, int position) {
        Integer valueOf = holder != null ? Integer.valueOf(holder.getItemViewType()) : null;
        if (valueOf != null && valueOf.intValue() == 1025) {
            r(holder, position);
        } else if (valueOf != null && valueOf.intValue() == 0) {
            if (holder == null) {
                holder = null;
            }
            onBindCustomViewHolder(holder, position);
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: s, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(BaseViewHolder<M> holder, int position, List<Object> payloads) {
        if (payloads != null && !payloads.isEmpty()) {
            t(holder, position, payloads);
        } else {
            super.onBindViewHolder(holder, position, payloads);
        }
    }

    public final void p(ZootopiaAvatarLoadMoreView footerView) {
        if (footerView == null) {
            return;
        }
        this.footerView = footerView;
        notifyDataSetChanged();
    }

    private final void r(BaseViewHolder<M> holder, int position) {
    }

    public void t(BaseViewHolder<M> holder, int position, List<Object> payloads) {
    }
}
