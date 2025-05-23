package com.tencent.mobileqq.guild.widget.adapterdelegates;

import android.util.Log;
import android.util.SparseIntArray;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u001c*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002:\u0001\u001dB\u0007\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0010\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0007H\u0014JG\u0010\u0014\u001a\u00020\u00132\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000b2\u0006\u0010\r\u001a\u00028\u00002\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u00072\u0010\u0010\u0012\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0011\u0018\u00010\u0010H\u0014\u00a2\u0006\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0019\u001a\u00020\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/mobileqq/guild/widget/adapterdelegates/h;", "T", "Lcom/tencent/mobileqq/guild/widget/adapterdelegates/c;", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "viewType", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "l", "viewHolder", "e", "Lcom/tencent/mobileqq/guild/widget/adapterdelegates/b;", "delegate", "items", "position", "holder", "", "", "list", "", "k", "(Lcom/tencent/mobileqq/guild/widget/adapterdelegates/b;Ljava/lang/Object;ILandroidx/recyclerview/widget/RecyclerView$ViewHolder;Ljava/util/List;)V", "Landroid/util/SparseIntArray;", "i", "Landroid/util/SparseIntArray;", "viewTypeMap", "<init>", "()V", "j", "a", "qqguild-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class h<T> extends c<T> {

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final SparseIntArray viewTypeMap = new SparseIntArray();

    @Override // com.tencent.mobileqq.guild.widget.adapterdelegates.c
    protected int e(@NotNull RecyclerView.ViewHolder viewHolder) {
        Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
        int i3 = this.viewTypeMap.get(viewHolder.hashCode());
        Logger logger = Logger.f235387a;
        if (QLog.isDevelopLevel()) {
            Log.d("BlockCompatibleDelegatesManager", "getInnerViewType: " + viewHolder.getItemViewType() + " -> " + i3 + ", offset: " + (i3 - viewHolder.getItemViewType()));
        }
        return i3;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.widget.adapterdelegates.c
    public void k(@NotNull b<T> delegate, T items, int position, @NotNull RecyclerView.ViewHolder holder, @Nullable List<Object> list) {
        List list2;
        int coerceAtLeast;
        int coerceAtMost;
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        Intrinsics.checkNotNullParameter(holder, "holder");
        super.k(delegate, items, position, holder, list);
        int size = this.viewTypeMap.size();
        for (int i3 = 0; i3 < size; i3++) {
            int keyAt = this.viewTypeMap.keyAt(i3);
            int valueAt = this.viewTypeMap.valueAt(i3);
            if (keyAt == holder.hashCode()) {
                Logger logger = Logger.f235387a;
                Logger.b bVar = new Logger.b();
                String str = "error: ViewType MAP: " + keyAt + " -> " + valueAt + " <===";
                if (str instanceof String) {
                    bVar.a().add(str);
                }
                Iterator<T> it = bVar.a().iterator();
                while (it.hasNext()) {
                    Logger.f235387a.d().e("BlockCompatibleDelegatesManager", 1, (String) it.next(), null);
                }
            } else {
                Logger logger2 = Logger.f235387a;
                Logger.b bVar2 = new Logger.b();
                String str2 = "error: ViewType MAP: " + keyAt + " -> " + valueAt;
                if (str2 instanceof String) {
                    bVar2.a().add(str2);
                }
                Iterator<T> it5 = bVar2.a().iterator();
                while (it5.hasNext()) {
                    Logger.f235387a.d().e("BlockCompatibleDelegatesManager", 1, (String) it5.next(), null);
                }
            }
        }
        RecyclerView recyclerView = this.f236204c;
        if (recyclerView != null) {
            if (items instanceof List) {
                list2 = (List) items;
            } else {
                list2 = null;
            }
            if (list2 != null) {
                coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(position - 3, 0);
                coerceAtMost = RangesKt___RangesKt.coerceAtMost(position + 3, list2.size() - 1);
                Logger logger3 = Logger.f235387a;
                Logger.b bVar3 = new Logger.b();
                String str3 = "error: RecyclerView viewHolders(" + coerceAtLeast + ".." + coerceAtMost + "):";
                if (str3 instanceof String) {
                    bVar3.a().add(str3);
                }
                Iterator<T> it6 = bVar3.a().iterator();
                while (it6.hasNext()) {
                    Logger.f235387a.d().e("BlockCompatibleDelegatesManager", 1, (String) it6.next(), null);
                }
                if (coerceAtLeast <= coerceAtMost) {
                    while (true) {
                        RecyclerView.ViewHolder findViewHolderForAdapterPosition = recyclerView.findViewHolderForAdapterPosition(coerceAtLeast);
                        if (findViewHolderForAdapterPosition != null) {
                            Logger logger4 = Logger.f235387a;
                            Logger.b bVar4 = new Logger.b();
                            String str4 = "error: ViewHolder at " + coerceAtLeast + MsgSummary.STR_COLON + findViewHolderForAdapterPosition.getClass().getCanonicalName();
                            if (str4 instanceof String) {
                                bVar4.a().add(str4);
                            }
                            Iterator<T> it7 = bVar4.a().iterator();
                            while (it7.hasNext()) {
                                Logger.f235387a.d().e("BlockCompatibleDelegatesManager", 1, (String) it7.next(), null);
                            }
                            Logger logger5 = Logger.f235387a;
                            Logger.b bVar5 = new Logger.b();
                            String str5 = "error: ViewHolder at " + coerceAtLeast + MsgSummary.STR_COLON + findViewHolderForAdapterPosition.hashCode() + " -> " + this.viewTypeMap.get(findViewHolderForAdapterPosition.hashCode());
                            if (str5 instanceof String) {
                                bVar5.a().add(str5);
                            }
                            Iterator<T> it8 = bVar5.a().iterator();
                            while (it8.hasNext()) {
                                Logger.f235387a.d().e("BlockCompatibleDelegatesManager", 1, (String) it8.next(), null);
                            }
                        }
                        if (coerceAtLeast == coerceAtMost) {
                            break;
                        } else {
                            coerceAtLeast++;
                        }
                    }
                }
                Logger logger6 = Logger.f235387a;
                Logger.b bVar6 = new Logger.b();
                bVar6.a().add("error: RecyclerView viewHolders ends");
                Iterator<T> it9 = bVar6.a().iterator();
                while (it9.hasNext()) {
                    Logger.f235387a.d().e("BlockCompatibleDelegatesManager", 1, (String) it9.next(), null);
                }
            }
        }
    }

    @Override // com.tencent.mobileqq.guild.widget.adapterdelegates.c
    @NotNull
    public RecyclerView.ViewHolder l(@NotNull ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        RecyclerView.ViewHolder l3 = super.l(parent, viewType);
        Intrinsics.checkNotNullExpressionValue(l3, "super.onCreateViewHolder(parent, viewType)");
        this.viewTypeMap.put(l3.hashCode(), viewType);
        return l3;
    }
}
