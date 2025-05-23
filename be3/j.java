package be3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.zplan.aigc.data.Imagery;
import com.tencent.mobileqq.zplan.aigc.view.viewHolder.SuitImageryHolder;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 (2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001)Bd\u0012\u0006\u0010\u0010\u001a\u00020\r\u0012\u0006\u0010\u0014\u001a\u00020\u0011\u0012K\u0010\u001e\u001aG\u0012\u0013\u0012\u00110\u0016\u00a2\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u0019\u0012\u0013\u0012\u00110\u001a\u00a2\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u001b\u0012\u0013\u0012\u00110\u0005\u00a2\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0015\u00a2\u0006\u0004\b&\u0010'J\u0018\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0018\u0010\u000b\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0005H\u0016J\b\u0010\f\u001a\u00020\u0005H\u0016R\u0014\u0010\u0010\u001a\u00020\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0014\u001a\u00020\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013RY\u0010\u001e\u001aG\u0012\u0013\u0012\u00110\u0016\u00a2\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u0019\u0012\u0013\u0012\u00110\u001a\u00a2\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u001b\u0012\u0013\u0012\u00110\u0005\u00a2\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR'\u0010%\u001a\u0012\u0012\u0004\u0012\u00020\u00160\u001fj\b\u0012\u0004\u0012\u00020\u0016` 8\u0006\u00a2\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\u00a8\u0006*"}, d2 = {"Lbe3/j;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mobileqq/zplan/aigc/view/viewHolder/SuitImageryHolder;", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "viewType", "k0", "holder", "position", "", "j0", "getItemCount", "Lzd3/a;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lzd3/a;", "dtReporter", "Landroid/content/Context;", BdhLogUtil.LogTag.Tag_Conn, "Landroid/content/Context;", "context", "Lkotlin/Function3;", "Lcom/tencent/mobileqq/zplan/aigc/data/i;", "Lkotlin/ParameterName;", "name", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "Landroid/widget/ImageView;", "imageView", "D", "Lkotlin/jvm/functions/Function3;", "onItemClick", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "E", "Ljava/util/ArrayList;", "i0", "()Ljava/util/ArrayList;", "dataList", "<init>", "(Lzd3/a;Landroid/content/Context;Lkotlin/jvm/functions/Function3;)V", UserInfo.SEX_FEMALE, "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes39.dex */
public final class j extends RecyclerView.Adapter<SuitImageryHolder> {

    /* renamed from: C, reason: from kotlin metadata */
    private final Context context;

    /* renamed from: D, reason: from kotlin metadata */
    private final Function3<Imagery, ImageView, Integer, Unit> onItemClick;

    /* renamed from: E, reason: from kotlin metadata */
    private final ArrayList<Imagery> dataList;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final zd3.a dtReporter;

    /* JADX WARN: Multi-variable type inference failed */
    public j(zd3.a dtReporter, Context context, Function3<? super Imagery, ? super ImageView, ? super Integer, Unit> onItemClick) {
        Intrinsics.checkNotNullParameter(dtReporter, "dtReporter");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(onItemClick, "onItemClick");
        this.dtReporter = dtReporter;
        this.context = context;
        this.onItemClick = onItemClick;
        this.dataList = new ArrayList<>();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.dataList.size();
    }

    public final ArrayList<Imagery> i0() {
        return this.dataList;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: j0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(SuitImageryHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        String name = this.dataList.get(position).getName();
        if (name != null) {
            zd3.a aVar = this.dtReporter;
            Imagery imagery = this.dataList.get(position);
            Intrinsics.checkNotNullExpressionValue(imagery, "dataList[position]");
            holder.n(aVar, imagery, this.dataList.get(position).getId(), position, name, this.onItemClick);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: k0, reason: merged with bridge method [inline-methods] */
    public SuitImageryHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.dg5, parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "from(parent.getContext()\u2026lder_item, parent, false)");
        return new SuitImageryHolder(this.context, inflate);
    }
}
