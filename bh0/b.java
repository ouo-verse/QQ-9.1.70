package bh0;

import android.content.Context;
import android.view.ViewGroup;
import androidx.recyclerview.widget.AsyncListDiffer;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ecommerce.base.ui.ECBasePtsViewData;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u0016\u0018\u0000 ,2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001-B\u0017\u0012\u0006\u0010%\u001a\u00020\"\u0012\u0006\u0010)\u001a\u00020&\u00a2\u0006\u0004\b*\u0010+J\u0014\u0010\u0007\u001a\u00020\u00062\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003J\u0014\u0010\b\u001a\u00020\u00062\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003J\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u00042\u0006\u0010\n\u001a\u00020\tJ\b\u0010\f\u001a\u00020\tH\u0016J\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\tH\u0016J\u0010\u0010\u000f\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0016J\u0018\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\tH\u0016J\u0018\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0016J\u000e\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\u0016R\u0014\u0010\u001c\u001a\u00020\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\"\u0010!\u001a\u0010\u0012\f\u0012\n \u001e*\u0004\u0018\u00010\u00040\u00040\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0014\u0010%\u001a\u00020\"8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0014\u0010)\u001a\u00020&8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b'\u0010(\u00a8\u0006."}, d2 = {"Lbh0/b;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lbh0/c;", "", "Lcom/tencent/ecommerce/base/ui/b;", "list", "", "setData", "addData", "", "position", "i0", "getItemCount", "", "getItemId", "getItemViewType", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "viewType", "l0", "holder", "k0", "", "pageName", "j0", "Lbh0/a;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lbh0/a;", "diffCallback", "Landroidx/recyclerview/widget/AsyncListDiffer;", "kotlin.jvm.PlatformType", BdhLogUtil.LogTag.Tag_Conn, "Landroidx/recyclerview/widget/AsyncListDiffer;", "differ", "Landroid/content/Context;", "D", "Landroid/content/Context;", "context", "Lbh0/d;", "E", "Lbh0/d;", "viewModel", "<init>", "(Landroid/content/Context;Lbh0/d;)V", UserInfo.SEX_FEMALE, "a", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes39.dex */
public class b extends RecyclerView.Adapter<c> {

    /* renamed from: C, reason: from kotlin metadata */
    private final AsyncListDiffer<ECBasePtsViewData> differ;

    /* renamed from: D, reason: from kotlin metadata */
    public final Context context;

    /* renamed from: E, reason: from kotlin metadata */
    public final d viewModel;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final a diffCallback;

    public b(Context context, d dVar) {
        this.context = context;
        this.viewModel = dVar;
        a aVar = new a();
        this.diffCallback = aVar;
        this.differ = new AsyncListDiffer<>(this, aVar);
    }

    public final void addData(List<ECBasePtsViewData> list) {
        List<ECBasePtsViewData> arrayList = new ArrayList<>();
        int size = this.differ.getCurrentList().size();
        for (int i3 = 0; i3 < size; i3++) {
            arrayList.add(this.differ.getCurrentList().get(i3));
        }
        arrayList.addAll(list);
        setData(arrayList);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.differ.getCurrentList().size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int position) {
        return position;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    public final ECBasePtsViewData i0(int position) {
        if (this.differ.getCurrentList().size() <= 0 || position >= this.differ.getCurrentList().size()) {
            return null;
        }
        return this.differ.getCurrentList().get(position);
    }

    public final int j0(String pageName) {
        List<ECBasePtsViewData> currentList = this.differ.getCurrentList();
        int size = currentList.size();
        for (int i3 = 0; i3 < size; i3++) {
            if (Intrinsics.areEqual(pageName, currentList.get(i3).getPageName())) {
                return i3;
            }
        }
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: k0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(c holder, int position) {
        this.viewModel.L1(this.context, holder, i0(position), getItemViewType(position));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: l0, reason: merged with bridge method [inline-methods] */
    public c onCreateViewHolder(ViewGroup parent, int viewType) {
        return this.viewModel.M1(this.context, parent, viewType, null);
    }

    public final void setData(List<ECBasePtsViewData> list) {
        this.differ.submitList(list);
        int size = list.size();
        for (int i3 = 0; i3 < size; i3++) {
            cg0.a.b("ECBaseRecyclerViewAdapter", "setData for pageName:" + list.get(i3).getPageName() + ",index:" + i3);
        }
    }
}
