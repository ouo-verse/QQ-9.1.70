package jw1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \"2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001#B\u0007\u00a2\u0006\u0004\b \u0010!J\u001e\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u00062\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003H\u0002J\b\u0010\b\u001a\u00020\u0003H\u0016J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0003H\u0016J\u0018\u0010\u000e\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u0003H\u0016J\u0018\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0003H\u0016J\u000e\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0003R&\u0010\u0018\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0014j\b\u0012\u0004\u0012\u00020\u0003`\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R0\u0010\u001d\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0019j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003`\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR<\u0010\u001f\u001a*\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00060\u0019j\u0014\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0006`\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001c\u00a8\u0006$"}, d2 = {"Ljw1/a;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Ljw1/b;", "", "dataValue", "repeatedCnt", "", "i0", "getItemCount", "position", "getItemViewType", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "viewType", "k0", "holder", "", "j0", "type", "l0", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/util/ArrayList;", "mItems", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", BdhLogUtil.LogTag.Tag_Conn, "Ljava/util/HashMap;", "mSkeletonItems", "D", "mSkeletonTabPages", "<init>", "()V", "E", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class a extends RecyclerView.Adapter<b> {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final HashMap<Integer, Integer> mSkeletonItems;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final HashMap<Integer, List<Integer>> mSkeletonTabPages;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private ArrayList<Integer> mItems = new ArrayList<>();

    public a() {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        hashMap.put(1, Integer.valueOf(R.layout.f3h));
        hashMap.put(3, Integer.valueOf(R.layout.f3i));
        this.mSkeletonItems = hashMap;
        HashMap<Integer, List<Integer>> hashMap2 = new HashMap<>();
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(i0(3, 4));
        hashMap2.put(2, arrayList);
        this.mSkeletonTabPages = hashMap2;
    }

    private final List<Integer> i0(int dataValue, int repeatedCnt) {
        ArrayList arrayList = new ArrayList();
        int i3 = repeatedCnt - 1;
        for (int i16 = 0; i16 < i3; i16++) {
            arrayList.add(Integer.valueOf(dataValue));
            arrayList.add(1);
        }
        if (repeatedCnt >= 1) {
            arrayList.add(Integer.valueOf(dataValue));
        }
        return arrayList;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.mItems.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        Integer num = this.mItems.get(position);
        Intrinsics.checkNotNullExpressionValue(num, "mItems[position]");
        return num.intValue();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: j0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(@NotNull b holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        QLog.i("QQGuildInSearchTag.GuildSearchSkeletonLoadingAdapter", 1, "onBindViewHolder " + position);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    /* renamed from: k0, reason: merged with bridge method [inline-methods] */
    public b onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        Integer num = this.mSkeletonItems.get(Integer.valueOf(viewType));
        if (num != null) {
            int intValue = num.intValue();
            QLog.i("QQGuildInSearchTag.GuildSearchSkeletonLoadingAdapter", 1, "onCreateViewHolder viewType: " + viewType + ", " + intValue);
            View itemView = LayoutInflater.from(parent.getContext()).inflate(intValue, parent, false);
            Intrinsics.checkNotNullExpressionValue(itemView, "itemView");
            return new b(itemView);
        }
        throw new IllegalArgumentException("viewType = " + viewType + " is illegal!");
    }

    public final void l0(int type) {
        this.mItems.clear();
        List<Integer> list = this.mSkeletonTabPages.get(Integer.valueOf(type));
        if (list != null) {
            this.mItems.addAll(list);
        }
        notifyDataSetChanged();
    }
}
