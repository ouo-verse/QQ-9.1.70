package e94;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.nativeui.adapter.holder.BaseAvatarPanelItemViewHolder;
import com.tencent.sqshow.zootopia.nativeui.adapter.holder.StoreItemViewHolder;
import com.tencent.sqshow.zootopia.nativeui.adapter.holder.y;
import com.tencent.sqshow.zootopia.nativeui.data.j;
import com.tencent.sqshow.zootopia.nativeui.view.page.ZPlanAvatarPreDownloadManager;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import n74.ad;
import uv4.bk;

/* compiled from: P */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 ,2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001-B\u001f\u0012\u0006\u0010\u0018\u001a\u00020\u0013\u0012\u0006\u0010\u001e\u001a\u00020\u0019\u0012\u0006\u0010$\u001a\u00020\u001f\u00a2\u0006\u0004\b*\u0010+J\u0018\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0005H\u0016J\u0014\u0010\u000e\u001a\u00020\r2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nJ\u0018\u0010\u0010\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0005H\u0016J\b\u0010\u0011\u001a\u00020\u0005H\u0016J\u0010\u0010\u0012\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0002H\u0016R\u0017\u0010\u0018\u001a\u00020\u00138\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0017\u0010\u001e\u001a\u00020\u00198\u0006\u00a2\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u0017\u0010$\u001a\u00020\u001f8\u0006\u00a2\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#R$\u0010)\u001a\u0012\u0012\u0004\u0012\u00020\u000b0%j\b\u0012\u0004\u0012\u00020\u000b`&8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b'\u0010(\u00a8\u0006."}, d2 = {"Le94/a;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/sqshow/zootopia/nativeui/adapter/holder/BaseAvatarPanelItemViewHolder;", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "viewType", "j0", "position", "getItemViewType", "", "Luv4/bk;", "dataList", "", "l0", "holder", "i0", "getItemCount", "k0", "Landroid/content/Context;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "context", "Lcom/tencent/sqshow/zootopia/nativeui/data/j;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/sqshow/zootopia/nativeui/data/j;", "getChannel", "()Lcom/tencent/sqshow/zootopia/nativeui/data/j;", WadlProxyConsts.CHANNEL, "Le94/b;", "D", "Le94/b;", "getSizeHelper", "()Le94/b;", "sizeHelper", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "E", "Ljava/util/ArrayList;", "mDataList", "<init>", "(Landroid/content/Context;Lcom/tencent/sqshow/zootopia/nativeui/data/j;Le94/b;)V", UserInfo.SEX_FEMALE, "a", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class a extends RecyclerView.Adapter<BaseAvatarPanelItemViewHolder> {

    /* renamed from: C, reason: from kotlin metadata */
    private final j channel;

    /* renamed from: D, reason: from kotlin metadata */
    private final b sizeHelper;

    /* renamed from: E, reason: from kotlin metadata */
    private final ArrayList<bk> mDataList;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final Context context;

    public a(Context context, j channel, b sizeHelper) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(channel, "channel");
        Intrinsics.checkNotNullParameter(sizeHelper, "sizeHelper");
        this.context = context;
        this.channel = channel;
        this.sizeHelper = sizeHelper;
        this.mDataList = new ArrayList<>();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getNUM_BACKGOURND_ICON() {
        return this.mDataList.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: i0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(BaseAvatarPanelItemViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        bk bkVar = this.mDataList.get(position);
        Intrinsics.checkNotNullExpressionValue(bkVar, "mDataList[position]");
        bk bkVar2 = bkVar;
        holder.y(bkVar2, position, this.mDataList);
        holder.z();
        ZPlanAvatarPreDownloadManager.f371947a.r(bkVar2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: j0, reason: merged with bridge method [inline-methods] */
    public BaseAvatarPanelItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        ad g16 = ad.g(LayoutInflater.from(this.context));
        Intrinsics.checkNotNullExpressionValue(g16, "inflate(LayoutInflater.from(context))");
        return new y(g16, this.sizeHelper, this.channel, new StoreItemViewHolder.Companion.CategoryData(0, null, null, 7, null));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: k0, reason: merged with bridge method [inline-methods] */
    public void onViewRecycled(BaseAvatarPanelItemViewHolder holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        holder.onViewRecycled();
    }

    public final void l0(List<bk> dataList) {
        Intrinsics.checkNotNullParameter(dataList, "dataList");
        QLog.i("AvatarRecommendAdapter", 1, "refreshData dataList:" + dataList.size());
        this.mDataList.clear();
        this.mDataList.addAll(dataList);
        notifyDataSetChanged();
    }
}
