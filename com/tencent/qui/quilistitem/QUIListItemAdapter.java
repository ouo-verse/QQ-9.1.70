package com.tencent.qui.quilistitem;

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
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0016\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B'\b\u0007\u0012\b\b\u0002\u00103\u001a\u000200\u0012\b\b\u0002\u00107\u001a\u000204\u0012\b\b\u0002\u00108\u001a\u000204\u00a2\u0006\u0004\b9\u0010:J/\u0010\u0007\u001a\u001a\u0012\u0006\b\u0001\u0012\u00020\u0002 \u0006*\f\u0012\u0006\b\u0001\u0012\u00020\u0002\u0018\u00010\u00050\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0000\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u0018\u0010\r\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u0003H\u0016J\u0018\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J(\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0013\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u0011H\u0016J\b\u0010\u0015\u001a\u00020\u0003H\u0016J\u0010\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u0002H\u0016R\u001e\u0010\u001a\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00050\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R \u0010\u001d\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00050\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR \u0010\u001f\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00050\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001cR1\u0010%\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0002\b\u0003 \u0006*\b\u0012\u0002\b\u0003\u0018\u00010\u00050\u00050 8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R0\u0010/\u001a\u00020\u00032\u0006\u0010&\u001a\u00020\u00038\u0006@GX\u0086\u000e\u00a2\u0006\u0018\n\u0004\b'\u0010(\u0012\u0004\b-\u0010.\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u0014\u00103\u001a\u0002008\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b1\u00102R\u0014\u00107\u001a\u0002048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b5\u00106R\u0014\u00108\u001a\u0002048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b(\u00106\u00a8\u0006;"}, d2 = {"Lcom/tencent/qui/quilistitem/QUIListItemAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/qui/quilistitem/h;", "", "position", "Lcom/tencent/qui/quilistitem/a;", "kotlin.jvm.PlatformType", "j0", "(I)Lcom/tencent/qui/quilistitem/a;", "getItemViewType", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "viewType", "m0", "holder", "", "k0", "", "", "payloads", "l0", "getItemCount", "n0", "Landroidx/collection/SparseArrayCompat;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroidx/collection/SparseArrayCompat;", "viewType2Config", BdhLogUtil.LogTag.Tag_Conn, "Ljava/util/List;", "originItems", "D", "items", "Landroidx/recyclerview/widget/AsyncListDiffer;", "E", "Lkotlin/Lazy;", "i0", "()Landroidx/recyclerview/widget/AsyncListDiffer;", "differ", "value", UserInfo.SEX_FEMALE, "I", "getThemeId", "()I", "setThemeId", "(I)V", "getThemeId$annotations", "()V", "themeId", "Lcom/tencent/qui/quilistitem/QUIListItemStyle;", "G", "Lcom/tencent/qui/quilistitem/QUIListItemStyle;", "listItemStyle", "", "H", "Z", "useAsyncListDiffer", "disableReuse", "<init>", "(Lcom/tencent/qui/quilistitem/QUIListItemStyle;ZZ)V", "QUIListItem_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes25.dex */
public class QUIListItemAdapter extends RecyclerView.Adapter<h> {
    static IPatchRedirector $redirector_;

    /* renamed from: C, reason: from kotlin metadata */
    private List<? extends a<?>> originItems;

    /* renamed from: D, reason: from kotlin metadata */
    private List<? extends a<?>> items;

    /* renamed from: E, reason: from kotlin metadata */
    private final Lazy differ;

    /* renamed from: F, reason: from kotlin metadata */
    private int themeId;

    /* renamed from: G, reason: from kotlin metadata */
    private final QUIListItemStyle listItemStyle;

    /* renamed from: H, reason: from kotlin metadata */
    private final boolean useAsyncListDiffer;

    /* renamed from: I, reason: from kotlin metadata */
    private final boolean disableReuse;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final SparseArrayCompat<a<?>> viewType2Config;

    @JvmOverloads
    public QUIListItemAdapter() {
        this(null, false, false, 7, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 18)) {
            return;
        }
        iPatchRedirector.redirect((short) 18, (Object) this);
    }

    private final AsyncListDiffer<a<?>> i0() {
        return (AsyncListDiffer) this.differ.getValue();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        List list;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Integer) iPatchRedirector.redirect((short) 12, (Object) this)).intValue();
        }
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
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this, position)).intValue();
        }
        a<? extends h> j06 = j0(position);
        if (this.disableReuse) {
            identityHashCode = System.identityHashCode(j06);
        } else {
            identityHashCode = System.identityHashCode(j06.getClass());
        }
        this.viewType2Config.put(identityHashCode, j06);
        return identityHashCode;
    }

    public final a<? extends h> j0(int position) {
        List list;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (a) iPatchRedirector.redirect((short) 4, (Object) this, position);
        }
        if (this.useAsyncListDiffer) {
            list = i0().getCurrentList();
        } else {
            list = this.items;
        }
        return (a) list.get(position);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: k0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(@NotNull h holder, int position) {
        List<? extends Object> emptyList;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) holder, position);
            return;
        }
        Intrinsics.checkNotNullParameter(holder, "holder");
        a<? extends h> j06 = j0(position);
        if (j06 != null) {
            this.viewType2Config.remove(j06.getClass().hashCode());
            holder.m(j06);
            QUIListItemStyle qUIListItemStyle = this.listItemStyle;
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            j06.a(qUIListItemStyle, holder, position, emptyList);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type com.tencent.qui.quilistitem.Config<com.tencent.qui.quilistitem.ListItemViewHolder>");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: l0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(@NotNull h holder, int position, @NotNull List<? extends Object> payloads) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, holder, Integer.valueOf(position), payloads);
            return;
        }
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        onBindViewHolder(holder, position);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [com.tencent.qui.quilistitem.h] */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    /* renamed from: m0, reason: merged with bridge method [inline-methods] */
    public h onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (h) iPatchRedirector.redirect((short) 9, (Object) this, (Object) parent, viewType);
        }
        Intrinsics.checkNotNullParameter(parent, "parent");
        a<?> aVar = this.viewType2Config.get(viewType);
        Intrinsics.checkNotNull(aVar);
        return aVar.h(parent);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: n0, reason: merged with bridge method [inline-methods] */
    public void onViewAttachedToWindow(@NotNull h holder) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) holder);
            return;
        }
        Intrinsics.checkNotNullParameter(holder, "holder");
        super.onViewAttachedToWindow(holder);
        holder.l().i(holder);
    }

    public /* synthetic */ QUIListItemAdapter(QUIListItemStyle qUIListItemStyle, boolean z16, boolean z17, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? QUIListItemStyle.Card : qUIListItemStyle, (i3 & 2) != 0 ? false : z16, (i3 & 4) != 0 ? false : z17);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 15)) {
            return;
        }
        iPatchRedirector.redirect((short) 15, this, qUIListItemStyle, Boolean.valueOf(z16), Boolean.valueOf(z17), Integer.valueOf(i3), defaultConstructorMarker);
    }

    @JvmOverloads
    public QUIListItemAdapter(@NotNull QUIListItemStyle listItemStyle, boolean z16, boolean z17) {
        List<? extends a<?>> emptyList;
        List<? extends a<?>> emptyList2;
        Lazy lazy;
        Intrinsics.checkNotNullParameter(listItemStyle, "listItemStyle");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, this, listItemStyle, Boolean.valueOf(z16), Boolean.valueOf(z17));
            return;
        }
        this.listItemStyle = listItemStyle;
        this.useAsyncListDiffer = z16;
        this.disableReuse = z17;
        this.viewType2Config = new SparseArrayCompat<>();
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        this.originItems = emptyList;
        emptyList2 = CollectionsKt__CollectionsKt.emptyList();
        this.items = emptyList2;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<AsyncListDiffer<a<?>>>() { // from class: com.tencent.qui.quilistitem.QUIListItemAdapter$differ$2
            static IPatchRedirector $redirector_;

            /* compiled from: P */
            @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\u0001J \u0010\u0006\u001a\u00020\u00052\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u00022\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0002H\u0016J \u0010\u0007\u001a\u00020\u00052\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u00022\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0002H\u0017\u00a8\u0006\b"}, d2 = {"com/tencent/qui/quilistitem/QUIListItemAdapter$differ$2$a", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lcom/tencent/qui/quilistitem/a;", "oldItem", "newItem", "", "b", "a", "QUIListItem_debug"}, k = 1, mv = {1, 4, 2})
            /* loaded from: classes25.dex */
            public static final class a extends DiffUtil.ItemCallback<com.tencent.qui.quilistitem.a<?>> {
                static IPatchRedirector $redirector_;

                a() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                        iPatchRedirector.redirect((short) 3, (Object) this);
                    }
                }

                @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
                @SuppressLint({"DiffUtilEquals"})
                /* renamed from: a, reason: merged with bridge method [inline-methods] */
                public boolean areContentsTheSame(@NotNull com.tencent.qui.quilistitem.a<?> oldItem, @NotNull com.tencent.qui.quilistitem.a<?> newItem) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) oldItem, (Object) newItem)).booleanValue();
                    }
                    Intrinsics.checkNotNullParameter(oldItem, "oldItem");
                    Intrinsics.checkNotNullParameter(newItem, "newItem");
                    return false;
                }

                @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
                /* renamed from: b, reason: merged with bridge method [inline-methods] */
                public boolean areItemsTheSame(@NotNull com.tencent.qui.quilistitem.a<?> oldItem, @NotNull com.tencent.qui.quilistitem.a<?> newItem) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        return ((Boolean) iPatchRedirector.redirect((short) 1, (Object) this, (Object) oldItem, (Object) newItem)).booleanValue();
                    }
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
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) QUIListItemAdapter.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final AsyncListDiffer<com.tencent.qui.quilistitem.a<?>> invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 1)) ? new AsyncListDiffer<>(new AdapterListUpdateCallback(QUIListItemAdapter.this), new AsyncDifferConfig.Builder(new a()).build()) : (AsyncListDiffer) iPatchRedirector2.redirect((short) 1, (Object) this);
            }
        });
        this.differ = lazy;
        this.themeId = 1000;
    }
}
