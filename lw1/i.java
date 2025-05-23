package lw1;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000  2\u00020\u0001:\u0001!B\u000f\u0012\u0006\u0010\u0018\u001a\u00020\u0015\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\u0014\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002J\u0012\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\u0007H\u0016J&\u0010\u0013\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u000e\u001a\u00020\u00072\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016J\b\u0010\u0014\u001a\u00020\u0007H\u0016R\u0014\u0010\u0018\u001a\u00020\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R&\u0010\u001d\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0019j\b\u0012\u0004\u0012\u00020\u0003`\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001c\u00a8\u0006\""}, d2 = {"Llw1/i;", "Landroid/widget/BaseAdapter;", "", "", "searchList", "", "setData", "", "index", "", "getItem", "p0", "", "getItemId", "position", "Landroid/view/View;", "convertView", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "getView", "getCount", "Llw1/j;", "d", "Llw1/j;", "clickCallback", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "e", "Ljava/util/ArrayList;", "mHistorySearchList", "<init>", "(Llw1/j;)V", "f", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class i extends BaseAdapter {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final j clickCallback;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private ArrayList<String> mHistorySearchList;

    public i(@NotNull j clickCallback) {
        Intrinsics.checkNotNullParameter(clickCallback, "clickCallback");
        this.clickCallback = clickCallback;
        this.mHistorySearchList = new ArrayList<>();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.mHistorySearchList.size();
    }

    @Override // android.widget.Adapter
    @Nullable
    public Object getItem(int index) {
        if (index < this.mHistorySearchList.size()) {
            return this.mHistorySearchList.get(index);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int p06) {
        return p06;
    }

    @Override // android.widget.Adapter
    @Nullable
    public View getView(int position, @Nullable View convertView, @Nullable ViewGroup parent) {
        View view;
        h hVar = new h();
        if (convertView == null) {
            view = hVar.d(parent, this.clickCallback);
        } else {
            hVar.c(convertView, this.clickCallback);
            view = convertView;
        }
        Object item = getItem(position);
        if (item != null) {
            hVar.b((String) item);
        }
        EventCollector.getInstance().onListGetView(position, convertView, parent, getItemId(position));
        return view;
    }

    public final void setData(@NotNull List<String> searchList) {
        Intrinsics.checkNotNullParameter(searchList, "searchList");
        this.mHistorySearchList.clear();
        this.mHistorySearchList.addAll(searchList);
        notifyDataSetChanged();
    }
}
