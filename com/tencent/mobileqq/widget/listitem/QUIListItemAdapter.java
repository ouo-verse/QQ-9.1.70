package com.tencent.mobileqq.widget.listitem;

import android.annotation.SuppressLint;
import android.view.ViewGroup;
import androidx.collection.SparseArrayCompat;
import androidx.recyclerview.widget.AdapterListUpdateCallback;
import androidx.recyclerview.widget.AsyncDifferConfig;
import androidx.recyclerview.widget.AsyncListDiffer;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.vas.vipav.api.VipFunCallConstants;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0011\b\u0016\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B'\b\u0007\u0012\b\b\u0002\u0010+\u001a\u00020(\u0012\b\b\u0002\u0010.\u001a\u00020\u0016\u0012\b\b\u0002\u00100\u001a\u00020\u0016\u00a2\u0006\u0004\bI\u0010JJ\b\u0010\u0004\u001a\u00020\u0003H\u0003J \u0010\n\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t\u0018\u00010\u00072\u0006\u0010\u0006\u001a\u00020\u0005J!\u0010\u000e\u001a\u00020\u00032\u0012\u0010\r\u001a\n\u0012\u0006\b\u0001\u0012\u00020\f0\u000b\"\u00020\f\u00a2\u0006\u0004\b\u000e\u0010\u000fJ/\u0010\u0012\u001a\u001a\u0012\u0006\b\u0001\u0012\u00020\u0002 \u0011*\f\u0012\u0006\b\u0001\u0012\u00020\u0002\u0018\u00010\t0\t2\u0006\u0010\u0010\u001a\u00020\bH\u0000\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u0012\u0010\u0015\u001a\u00020\u00032\n\u0010\u0014\u001a\u0006\u0012\u0002\b\u00030\tJ\u001a\u0010\u0018\u001a\u00020\u00032\n\u0010\u0014\u001a\u0006\u0012\u0002\b\u00030\t2\u0006\u0010\u0017\u001a\u00020\u0016J\u0016\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\u0016J\u0010\u0010\u001b\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\bH\u0016J\u0018\u0010\u001f\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\bH\u0016J\u0018\u0010!\u001a\u00020\u00032\u0006\u0010 \u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\bH\u0016J(\u0010%\u001a\u00020\u00032\u0006\u0010 \u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\b2\u000e\u0010$\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010#0\"H\u0016J\b\u0010&\u001a\u00020\bH\u0016J\u0010\u0010'\u001a\u00020\u00032\u0006\u0010 \u001a\u00020\u0002H\u0016R\u0014\u0010+\u001a\u00020(8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0014\u0010.\u001a\u00020\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u0014\u00100\u001a\u00020\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b/\u0010-R\u001e\u00104\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t018\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b2\u00103R \u00107\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t0\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b5\u00106R \u00109\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t0\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b8\u00106R1\u0010?\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0002\b\u0003 \u0011*\b\u0012\u0002\b\u0003\u0018\u00010\t0\t0:8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b;\u0010<\u001a\u0004\b=\u0010>R0\u0010H\u001a\u00020\b2\u0006\u0010@\u001a\u00020\b8\u0006@GX\u0086\u000e\u00a2\u0006\u0018\n\u0004\bA\u0010A\u0012\u0004\bF\u0010G\u001a\u0004\bB\u0010C\"\u0004\bD\u0010E\u00a8\u0006K"}, d2 = {"Lcom/tencent/mobileqq/widget/listitem/QUIListItemAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mobileqq/widget/listitem/e;", "", "o0", "", "title", "Lkotlin/Pair;", "", "Lcom/tencent/mobileqq/widget/listitem/a;", "k0", "", "Lcom/tencent/mobileqq/widget/listitem/Group;", "groups", "t0", "([Lcom/tencent/mobileqq/widget/listitem/Group;)V", "position", "kotlin.jvm.PlatformType", "j0", "(I)Lcom/tencent/mobileqq/widget/listitem/a;", DownloadInfo.spKey_Config, "l0", "", "isVisible", "m0", VipFunCallConstants.KEY_GROUP, "n0", "getItemViewType", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "viewType", "r0", "holder", "p0", "", "", "payloads", "q0", "getItemCount", "s0", "Lcom/tencent/mobileqq/widget/listitem/QUIListItemStyle;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/widget/listitem/QUIListItemStyle;", "listItemStyle", BdhLogUtil.LogTag.Tag_Conn, "Z", "useAsyncListDiffer", "D", "disableReuse", "Landroidx/collection/SparseArrayCompat;", "E", "Landroidx/collection/SparseArrayCompat;", "viewType2Config", UserInfo.SEX_FEMALE, "Ljava/util/List;", "originItems", "G", "items", "Landroidx/recyclerview/widget/AsyncListDiffer;", "H", "Lkotlin/Lazy;", "i0", "()Landroidx/recyclerview/widget/AsyncListDiffer;", "differ", "value", "I", "getThemeId", "()I", "u0", "(I)V", "getThemeId$annotations", "()V", "themeId", "<init>", "(Lcom/tencent/mobileqq/widget/listitem/QUIListItemStyle;ZZ)V", "qqui_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public class QUIListItemAdapter extends RecyclerView.Adapter<e> {

    /* renamed from: C, reason: from kotlin metadata */
    private final boolean useAsyncListDiffer;

    /* renamed from: D, reason: from kotlin metadata */
    private final boolean disableReuse;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final SparseArrayCompat<a<?>> viewType2Config;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private List<? extends a<?>> originItems;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private List<? extends a<?>> items;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final Lazy differ;

    /* renamed from: I, reason: from kotlin metadata */
    private int themeId;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final QUIListItemStyle listItemStyle;

    @JvmOverloads
    public QUIListItemAdapter() {
        this(null, false, false, 7, null);
    }

    private final AsyncListDiffer<a<?>> i0() {
        return (AsyncListDiffer) this.differ.getValue();
    }

    @SuppressLint({"NotifyDataSetChanged"})
    private final void o0() {
        List<? extends a<?>> list = this.originItems;
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (((a) obj).k()) {
                arrayList.add(obj);
            }
        }
        if (this.useAsyncListDiffer) {
            i0().submitList(arrayList);
        } else {
            this.items = arrayList;
            notifyDataSetChanged();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        List list;
        if (this.useAsyncListDiffer) {
            list = i0().getCurrentList();
        } else {
            list = this.items;
        }
        return list.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        int identityHashCode;
        a<? extends e> j06 = j0(position);
        if (this.disableReuse) {
            identityHashCode = System.identityHashCode(j06);
        } else {
            identityHashCode = System.identityHashCode(j06.getClass());
        }
        this.viewType2Config.put(identityHashCode, j06);
        return identityHashCode;
    }

    public final a<? extends e> j0(int position) {
        List list;
        if (this.useAsyncListDiffer) {
            list = i0().getCurrentList();
        } else {
            list = this.items;
        }
        return (a) list.get(position);
    }

    @Nullable
    public final Pair<Integer, a<?>> k0(@NotNull String title) {
        Intrinsics.checkNotNullParameter(title, "title");
        List<? extends a<?>> list = this.originItems;
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (((a) obj).k()) {
                arrayList.add(obj);
            }
        }
        int i3 = 0;
        for (Object obj2 : arrayList) {
            int i16 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            a aVar = (a) obj2;
            if ((aVar instanceof w) && Intrinsics.areEqual(((w) aVar).C(), title)) {
                return new Pair<>(Integer.valueOf(i3), aVar);
            }
            i3 = i16;
        }
        return null;
    }

    public final void l0(@NotNull a<?> config) {
        List list;
        boolean z16;
        Intrinsics.checkNotNullParameter(config, "config");
        if (this.useAsyncListDiffer) {
            list = i0().getCurrentList();
            Intrinsics.checkNotNullExpressionValue(list, "{\n            differ.currentList\n        }");
        } else {
            list = this.items;
        }
        Iterator it = list.iterator();
        int i3 = 0;
        while (true) {
            if (it.hasNext()) {
                if (((a) it.next()) == config) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    break;
                } else {
                    i3++;
                }
            } else {
                i3 = -1;
                break;
            }
        }
        if (i3 >= 0) {
            notifyItemChanged(i3);
        }
    }

    public final void m0(@NotNull a<?> config, boolean isVisible) {
        Intrinsics.checkNotNullParameter(config, "config");
        if (isVisible == config.j()) {
            return;
        }
        config.A(isVisible);
        Group group = config.getCom.tencent.mobileqq.vas.vipav.api.VipFunCallConstants.KEY_GROUP java.lang.String();
        if (group != null) {
            group.c();
        }
        o0();
    }

    public final void n0(@NotNull Group group, boolean isVisible) {
        Intrinsics.checkNotNullParameter(group, "group");
        ArrayList<a<?>> a16 = group.a();
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = a16.iterator();
        while (true) {
            boolean z16 = true;
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            a aVar = (a) next;
            if (aVar.j() != isVisible) {
                aVar.A(isVisible);
            } else {
                z16 = false;
            }
            if (z16) {
                arrayList.add(next);
            }
        }
        if (!arrayList.isEmpty()) {
            group.c();
            o0();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: p0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(@NotNull e holder, int position) {
        List<? extends Object> emptyList;
        Intrinsics.checkNotNullParameter(holder, "holder");
        a<? extends e> j06 = j0(position);
        Intrinsics.checkNotNull(j06, "null cannot be cast to non-null type com.tencent.mobileqq.widget.listitem.Config<com.tencent.mobileqq.widget.listitem.ListItemViewHolder>");
        this.viewType2Config.remove(j06.getClass().hashCode());
        holder.m(j06);
        QUIListItemStyle qUIListItemStyle = this.listItemStyle;
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        j06.a(qUIListItemStyle, holder, position, emptyList);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: q0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(@NotNull e holder, int position, @NotNull List<? extends Object> payloads) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        onBindViewHolder(holder, position);
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [com.tencent.mobileqq.widget.listitem.e] */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    /* renamed from: r0, reason: merged with bridge method [inline-methods] */
    public e onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        a<?> aVar = this.viewType2Config.get(viewType);
        Intrinsics.checkNotNull(aVar);
        return aVar.n(parent);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: s0, reason: merged with bridge method [inline-methods] */
    public void onViewAttachedToWindow(@NotNull e holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        super.onViewAttachedToWindow(holder);
        holder.l().o(holder);
    }

    public final void t0(@NotNull Group... groups) {
        Intrinsics.checkNotNullParameter(groups, "groups");
        ArrayList arrayList = new ArrayList();
        for (Group group : groups) {
            CollectionsKt__MutableCollectionsKt.addAll(arrayList, group.a());
        }
        this.originItems = arrayList;
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((a) it.next()).z(this.themeId);
        }
        o0();
    }

    @SuppressLint({"NotifyDataSetChanged"})
    public final void u0(int i3) {
        if (i3 != this.themeId) {
            this.themeId = i3;
            Iterator<T> it = this.originItems.iterator();
            while (it.hasNext()) {
                ((a) it.next()).z(this.themeId);
            }
            notifyDataSetChanged();
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public QUIListItemAdapter(@NotNull QUIListItemStyle listItemStyle) {
        this(listItemStyle, false, false, 6, null);
        Intrinsics.checkNotNullParameter(listItemStyle, "listItemStyle");
    }

    public /* synthetic */ QUIListItemAdapter(QUIListItemStyle qUIListItemStyle, boolean z16, boolean z17, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? QUIListItemStyle.Card : qUIListItemStyle, (i3 & 2) != 0 ? false : z16, (i3 & 4) != 0 ? false : z17);
    }

    @JvmOverloads
    public QUIListItemAdapter(@NotNull QUIListItemStyle listItemStyle, boolean z16, boolean z17) {
        List<? extends a<?>> emptyList;
        List<? extends a<?>> emptyList2;
        Intrinsics.checkNotNullParameter(listItemStyle, "listItemStyle");
        this.listItemStyle = listItemStyle;
        this.useAsyncListDiffer = z16;
        this.disableReuse = z17;
        this.viewType2Config = new SparseArrayCompat<>();
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        this.originItems = emptyList;
        emptyList2 = CollectionsKt__CollectionsKt.emptyList();
        this.items = emptyList2;
        this.differ = LazyKt.lazy(new Function0<AsyncListDiffer<a<?>>>() { // from class: com.tencent.mobileqq.widget.listitem.QUIListItemAdapter$differ$2

            /* compiled from: P */
            @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\u0001J \u0010\u0006\u001a\u00020\u00052\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u00022\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0002H\u0016J \u0010\u0007\u001a\u00020\u00052\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u00022\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0002H\u0017\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/widget/listitem/QUIListItemAdapter$differ$2$a", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lcom/tencent/mobileqq/widget/listitem/a;", "oldItem", "newItem", "", "b", "a", "qqui_kit_release"}, k = 1, mv = {1, 7, 1})
            /* loaded from: classes20.dex */
            public static final class a extends DiffUtil.ItemCallback<com.tencent.mobileqq.widget.listitem.a<?>> {
                a() {
                }

                @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
                @SuppressLint({"DiffUtilEquals"})
                /* renamed from: a, reason: merged with bridge method [inline-methods] */
                public boolean areContentsTheSame(@NotNull com.tencent.mobileqq.widget.listitem.a<?> oldItem, @NotNull com.tencent.mobileqq.widget.listitem.a<?> newItem) {
                    Intrinsics.checkNotNullParameter(oldItem, "oldItem");
                    Intrinsics.checkNotNullParameter(newItem, "newItem");
                    return false;
                }

                @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
                /* renamed from: b, reason: merged with bridge method [inline-methods] */
                public boolean areItemsTheSame(@NotNull com.tencent.mobileqq.widget.listitem.a<?> oldItem, @NotNull com.tencent.mobileqq.widget.listitem.a<?> newItem) {
                    Intrinsics.checkNotNullParameter(oldItem, "oldItem");
                    Intrinsics.checkNotNullParameter(newItem, "newItem");
                    if (oldItem == newItem) {
                        return true;
                    }
                    return false;
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final AsyncListDiffer<com.tencent.mobileqq.widget.listitem.a<?>> invoke() {
                return new AsyncListDiffer<>(new AdapterListUpdateCallback(QUIListItemAdapter.this), new AsyncDifferConfig.Builder(new a()).build());
            }
        });
        this.themeId = 1000;
    }
}
