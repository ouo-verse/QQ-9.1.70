package fa4;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import n74.v;
import uv4.az;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\t\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001f\u0012\u0006\u0010\u001a\u001a\u00020\u0013\u0012\u0006\u0010\"\u001a\u00020\u001b\u0012\u0006\u0010&\u001a\u00020#\u00a2\u0006\u0004\b*\u0010+J\u001e\u0010\b\u001a\u00020\u00072\u0016\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005J\u0018\u0010\r\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u0018\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000bH\u0016J\b\u0010\u0011\u001a\u00020\u000bH\u0016J\u0010\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u0002H\u0016R\"\u0010\u001a\u001a\u00020\u00138\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\"\u0010\"\u001a\u00020\u001b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u0014\u0010&\u001a\u00020#8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b$\u0010%R&\u0010)\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010(\u00a8\u0006,"}, d2 = {"Lfa4/a;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lfa4/j;", "Ljava/util/ArrayList;", "Luv4/az;", "Lkotlin/collections/ArrayList;", "itemArray", "", "i0", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "viewType", "k0", "holder", "position", "j0", "getItemCount", "l0", "Landroid/content/Context;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "context", "Lcom/tencent/sqshow/zootopia/nativeui/data/j;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/sqshow/zootopia/nativeui/data/j;", "getChannel", "()Lcom/tencent/sqshow/zootopia/nativeui/data/j;", "setChannel", "(Lcom/tencent/sqshow/zootopia/nativeui/data/j;)V", WadlProxyConsts.CHANNEL, "", "D", "Z", "isUgcData", "E", "Ljava/util/ArrayList;", "itemDataList", "<init>", "(Landroid/content/Context;Lcom/tencent/sqshow/zootopia/nativeui/data/j;Z)V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class a extends RecyclerView.Adapter<j> {

    /* renamed from: C, reason: from kotlin metadata */
    private com.tencent.sqshow.zootopia.nativeui.data.j channel;

    /* renamed from: D, reason: from kotlin metadata */
    private final boolean isUgcData;

    /* renamed from: E, reason: from kotlin metadata */
    private ArrayList<az> itemDataList;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private Context context;

    public a(Context context, com.tencent.sqshow.zootopia.nativeui.data.j channel, boolean z16) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(channel, "channel");
        this.context = context;
        this.channel = channel;
        this.isUgcData = z16;
        this.itemDataList = new ArrayList<>();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getNUM_BACKGOURND_ICON() {
        return this.itemDataList.size();
    }

    public final void i0(ArrayList<az> itemArray) {
        Intrinsics.checkNotNullParameter(itemArray, "itemArray");
        this.itemDataList = itemArray;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: j0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(j holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        az it = this.itemDataList.get(position);
        com.tencent.sqshow.zootopia.nativeui.data.l storeItemPool = this.channel.getStoreItemPool();
        Intrinsics.checkNotNullExpressionValue(it, "it");
        az b16 = storeItemPool.b(it);
        if (!Intrinsics.areEqual(b16, it)) {
            holder.z(b16);
        } else {
            holder.z(it);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: k0, reason: merged with bridge method [inline-methods] */
    public j onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        v g16 = v.g(LayoutInflater.from(this.context));
        Intrinsics.checkNotNullExpressionValue(g16, "inflate(\n            Lay\u2026      (context)\n        )");
        return new j(g16, this.channel, this.isUgcData);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: l0, reason: merged with bridge method [inline-methods] */
    public void onViewRecycled(j holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        super.onViewRecycled(holder);
        holder.onRecycled();
    }
}
