package com.tencent.qqnt.expandRecyclerView.adapter.provider;

import androidx.annotation.IntRange;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.expandRecyclerView.adapter.BaseProviderMultiAdapter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u001e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b&\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0019\u0012\u0010\b\u0002\u0010/\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0007\u00a2\u0006\u0004\b0\u00101J/\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\u00072\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0002\u00a2\u0006\u0004\b\b\u0010\tJ<\u0010\u0011\u001a\u00020\n2\b\b\u0001\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\u00052\b\b\u0002\u0010\r\u001a\u00020\u00052\b\b\u0002\u0010\u000e\u001a\u00020\u00052\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0002J<\u0010\u0013\u001a\u00020\n2\b\b\u0001\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\u0012\u001a\u00020\u00052\b\b\u0002\u0010\r\u001a\u00020\u00052\b\b\u0002\u0010\u000e\u001a\u00020\u00052\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0002J\u000e\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u0014J\u0016\u0010\u0019\u001a\u00020\u00162\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00020\u0018H\u0016J\u0010\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\nH\u0014J\u0016\u0010\u001d\u001a\u00020\u00162\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\u0002J\u000e\u0010\u001e\u001a\u00020\u00162\u0006\u0010\u001c\u001a\u00020\u0002J\u001e\u0010 \u001a\u00020\u00162\u0006\u0010\u000b\u001a\u00020\n2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00020\u0003H\u0016J\u0016\u0010!\u001a\u00020\u00162\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00020\u0003H\u0016J$\u0010$\u001a\u00020\u00162\u0006\u0010\"\u001a\u00020\u00022\u0006\u0010#\u001a\u00020\n2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00020\u0003J\u0016\u0010&\u001a\u00020\u00162\u0006\u0010\"\u001a\u00020\u00022\u0006\u0010%\u001a\u00020\u0002J\u0018\u0010'\u001a\u00020\u00162\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0003H\u0016J2\u0010(\u001a\u00020\n2\b\b\u0001\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\r\u001a\u00020\u00052\b\b\u0002\u0010\u000e\u001a\u00020\u00052\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0007J2\u0010)\u001a\u00020\n2\b\b\u0001\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\r\u001a\u00020\u00052\b\b\u0002\u0010\u000e\u001a\u00020\u00052\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0007R$\u0010.\u001a\u0012\u0012\u0004\u0012\u00020\n0*j\b\u0012\u0004\u0012\u00020\n`+8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b,\u0010-\u00a8\u00062"}, d2 = {"Lcom/tencent/qqnt/expandRecyclerView/adapter/provider/b;", "Lcom/tencent/qqnt/expandRecyclerView/adapter/BaseProviderMultiAdapter;", "Lcom/tencent/qqnt/expandRecyclerView/adapter/node/b;", "", "list", "", "isExpanded", "", "N0", "(Ljava/util/Collection;Ljava/lang/Boolean;)Ljava/util/List;", "", "position", "isChangeChildCollapse", "animate", "notify", "", "parentPayload", "H0", "isChangeChildExpand", "J0", "Lcom/tencent/qqnt/expandRecyclerView/adapter/provider/c;", "provider", "", "F0", "Lcom/tencent/qqnt/expandRecyclerView/adapter/provider/a;", "k0", "type", "r0", "data", "D0", "E0", "newData", "i0", "j0", "parentNode", "childIndex", "Q0", "childNode", "R0", "B0", "I0", "L0", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", UserInfo.SEX_FEMALE, "Ljava/util/HashSet;", "fullSpanNodeTypeSet", "nodeList", "<init>", "(Ljava/util/List;)V", "chathistory_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public abstract class b extends BaseProviderMultiAdapter<com.tencent.qqnt.expandRecyclerView.adapter.node.b> {
    static IPatchRedirector $redirector_;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final HashSet<Integer> fullSpanNodeTypeSet;

    public b() {
        this(null, 1, 0 == true ? 1 : 0);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 51)) {
            return;
        }
        iPatchRedirector.redirect((short) 51, (Object) this);
    }

    private final int H0(@IntRange(from = 0) int position, boolean isChangeChildCollapse, boolean animate, boolean notify, Object parentPayload) {
        boolean z16;
        Boolean bool;
        com.tencent.qqnt.expandRecyclerView.adapter.node.b bVar = m0().get(position);
        if (bVar instanceof com.tencent.qqnt.expandRecyclerView.adapter.node.a) {
            com.tencent.qqnt.expandRecyclerView.adapter.node.a aVar = (com.tencent.qqnt.expandRecyclerView.adapter.node.a) bVar;
            if (aVar.d()) {
                aVar.e(false);
                List<com.tencent.qqnt.expandRecyclerView.adapter.node.b> b16 = bVar.b();
                if (b16 != null && !b16.isEmpty()) {
                    z16 = false;
                } else {
                    z16 = true;
                }
                if (z16) {
                    notifyItemChanged(position, parentPayload);
                    return 0;
                }
                List<com.tencent.qqnt.expandRecyclerView.adapter.node.b> b17 = bVar.b();
                Intrinsics.checkNotNull(b17);
                List<com.tencent.qqnt.expandRecyclerView.adapter.node.b> list = b17;
                if (isChangeChildCollapse) {
                    bool = Boolean.FALSE;
                } else {
                    bool = null;
                }
                List<com.tencent.qqnt.expandRecyclerView.adapter.node.b> N0 = N0(list, bool);
                Iterator<T> it = N0.iterator();
                while (it.hasNext()) {
                    ((com.tencent.qqnt.expandRecyclerView.adapter.node.b) it.next()).c(false);
                }
                int size = N0.size();
                m0().removeAll(N0);
                if (notify) {
                    if (animate) {
                        notifyItemChanged(position, parentPayload);
                        notifyItemRangeRemoved(position + 1, size);
                    } else {
                        notifyDataSetChanged();
                    }
                }
                return size;
            }
        }
        return 0;
    }

    private final int J0(@IntRange(from = 0) int position, boolean isChangeChildExpand, boolean animate, boolean notify, Object parentPayload) {
        boolean z16;
        Boolean bool;
        com.tencent.qqnt.expandRecyclerView.adapter.node.b bVar = m0().get(position);
        if (bVar instanceof com.tencent.qqnt.expandRecyclerView.adapter.node.a) {
            com.tencent.qqnt.expandRecyclerView.adapter.node.a aVar = (com.tencent.qqnt.expandRecyclerView.adapter.node.a) bVar;
            if (!aVar.d()) {
                aVar.e(true);
                List<com.tencent.qqnt.expandRecyclerView.adapter.node.b> b16 = bVar.b();
                if (b16 != null && !b16.isEmpty()) {
                    z16 = false;
                } else {
                    z16 = true;
                }
                if (z16) {
                    notifyItemChanged(position, parentPayload);
                    return 0;
                }
                List<com.tencent.qqnt.expandRecyclerView.adapter.node.b> b17 = bVar.b();
                Intrinsics.checkNotNull(b17);
                List<com.tencent.qqnt.expandRecyclerView.adapter.node.b> list = b17;
                if (isChangeChildExpand) {
                    bool = Boolean.TRUE;
                } else {
                    bool = null;
                }
                List<com.tencent.qqnt.expandRecyclerView.adapter.node.b> N0 = N0(list, bool);
                Iterator<T> it = N0.iterator();
                while (it.hasNext()) {
                    ((com.tencent.qqnt.expandRecyclerView.adapter.node.b) it.next()).c(true);
                }
                int size = N0.size();
                int i3 = position + 1;
                m0().addAll(i3, N0);
                if (notify) {
                    if (animate) {
                        notifyItemChanged(position, parentPayload);
                        notifyItemRangeInserted(i3, size);
                    } else {
                        notifyDataSetChanged();
                    }
                }
                return size;
            }
        }
        return 0;
    }

    public static /* synthetic */ int K0(b bVar, int i3, boolean z16, boolean z17, Object obj, int i16, Object obj2) {
        if (obj2 == null) {
            if ((i16 & 2) != 0) {
                z16 = true;
            }
            if ((i16 & 4) != 0) {
                z17 = true;
            }
            if ((i16 & 8) != 0) {
                obj = null;
            }
            return bVar.I0(i3, z16, z17, obj);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: expand");
    }

    public static /* synthetic */ int M0(b bVar, int i3, boolean z16, boolean z17, Object obj, int i16, Object obj2) {
        if (obj2 == null) {
            if ((i16 & 2) != 0) {
                z16 = true;
            }
            if ((i16 & 4) != 0) {
                z17 = true;
            }
            if ((i16 & 8) != 0) {
                obj = null;
            }
            return bVar.L0(i3, z16, z17, obj);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: expandOrCollapse");
    }

    private final List<com.tencent.qqnt.expandRecyclerView.adapter.node.b> N0(Collection<? extends com.tencent.qqnt.expandRecyclerView.adapter.node.b> list, Boolean isExpanded) {
        ArrayList arrayList = new ArrayList();
        for (com.tencent.qqnt.expandRecyclerView.adapter.node.b bVar : list) {
            arrayList.add(bVar);
            boolean z16 = false;
            if (bVar instanceof com.tencent.qqnt.expandRecyclerView.adapter.node.a) {
                if (Intrinsics.areEqual(isExpanded, Boolean.TRUE) || ((com.tencent.qqnt.expandRecyclerView.adapter.node.a) bVar).d()) {
                    List<com.tencent.qqnt.expandRecyclerView.adapter.node.b> b16 = bVar.b();
                    if (b16 == null || b16.isEmpty()) {
                        z16 = true;
                    }
                    if (!z16) {
                        arrayList.addAll(N0(b16, isExpanded));
                    }
                }
                if (isExpanded != null) {
                    ((com.tencent.qqnt.expandRecyclerView.adapter.node.a) bVar).e(isExpanded.booleanValue());
                }
            } else {
                List<com.tencent.qqnt.expandRecyclerView.adapter.node.b> b17 = bVar.b();
                if (b17 == null || b17.isEmpty()) {
                    z16 = true;
                }
                if (!z16) {
                    arrayList.addAll(N0(b17, isExpanded));
                }
            }
        }
        return arrayList;
    }

    static /* synthetic */ List O0(b bVar, Collection collection, Boolean bool, int i3, Object obj) {
        if (obj == null) {
            if ((i3 & 2) != 0) {
                bool = null;
            }
            return bVar.N0(collection, bool);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: flatData");
    }

    @Override // com.tencent.qqnt.expandRecyclerView.adapter.BaseProviderMultiAdapter
    public void B0(@Nullable Collection<? extends com.tencent.qqnt.expandRecyclerView.adapter.node.b> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, (Object) list);
            return;
        }
        if (list == null) {
            list = new ArrayList<>();
        }
        super.B0(O0(this, list, null, 2, null));
    }

    public final void D0(int position, @NotNull com.tencent.qqnt.expandRecyclerView.adapter.node.b data) {
        ArrayList arrayListOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, position, (Object) data);
            return;
        }
        Intrinsics.checkNotNullParameter(data, "data");
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(data);
        i0(position, arrayListOf);
    }

    public final void E0(@NotNull com.tencent.qqnt.expandRecyclerView.adapter.node.b data) {
        ArrayList arrayListOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) data);
            return;
        }
        Intrinsics.checkNotNullParameter(data, "data");
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(data);
        j0(arrayListOf);
    }

    public final void F0(@NotNull c provider) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) provider);
            return;
        }
        Intrinsics.checkNotNullParameter(provider, "provider");
        this.fullSpanNodeTypeSet.add(Integer.valueOf(provider.f()));
        k0(provider);
    }

    @JvmOverloads
    public final int I0(@IntRange(from = 0) int position, boolean animate, boolean notify, @Nullable Object parentPayload) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return ((Integer) iPatchRedirector.redirect((short) 23, this, Integer.valueOf(position), Boolean.valueOf(animate), Boolean.valueOf(notify), parentPayload)).intValue();
        }
        if (position < 0) {
            QLog.w("BaseNodeAdapter", 1, "expand pos illegal: " + position);
            return 0;
        }
        return J0(position, false, animate, notify, parentPayload);
    }

    @JvmOverloads
    public final int L0(@IntRange(from = 0) int position, boolean animate, boolean notify, @Nullable Object parentPayload) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return ((Integer) iPatchRedirector.redirect((short) 24, this, Integer.valueOf(position), Boolean.valueOf(animate), Boolean.valueOf(notify), parentPayload)).intValue();
        }
        com.tencent.qqnt.expandRecyclerView.adapter.node.b bVar = m0().get(position);
        if (!(bVar instanceof com.tencent.qqnt.expandRecyclerView.adapter.node.a)) {
            return 0;
        }
        if (((com.tencent.qqnt.expandRecyclerView.adapter.node.a) bVar).d()) {
            return H0(position, false, animate, notify, parentPayload);
        }
        return J0(position, false, animate, notify, parentPayload);
    }

    public final void Q0(@NotNull com.tencent.qqnt.expandRecyclerView.adapter.node.b parentNode, int childIndex, @NotNull Collection<? extends com.tencent.qqnt.expandRecyclerView.adapter.node.b> newData) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, this, parentNode, Integer.valueOf(childIndex), newData);
            return;
        }
        Intrinsics.checkNotNullParameter(parentNode, "parentNode");
        Intrinsics.checkNotNullParameter(newData, "newData");
        List<com.tencent.qqnt.expandRecyclerView.adapter.node.b> b16 = parentNode.b();
        if (b16 != null) {
            b16.addAll(childIndex, newData);
            if ((parentNode instanceof com.tencent.qqnt.expandRecyclerView.adapter.node.a) && !((com.tencent.qqnt.expandRecyclerView.adapter.node.a) parentNode).d()) {
                return;
            }
            i0(m0().indexOf(parentNode) + 1 + childIndex, newData);
        }
    }

    public final void R0(@NotNull com.tencent.qqnt.expandRecyclerView.adapter.node.b parentNode, @NotNull com.tencent.qqnt.expandRecyclerView.adapter.node.b childNode) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, (Object) parentNode, (Object) childNode);
            return;
        }
        Intrinsics.checkNotNullParameter(parentNode, "parentNode");
        Intrinsics.checkNotNullParameter(childNode, "childNode");
        List<com.tencent.qqnt.expandRecyclerView.adapter.node.b> b16 = parentNode.b();
        if (b16 != null) {
            if ((parentNode instanceof com.tencent.qqnt.expandRecyclerView.adapter.node.a) && !((com.tencent.qqnt.expandRecyclerView.adapter.node.a) parentNode).d()) {
                b16.remove(childNode);
            } else {
                x0(childNode);
                b16.remove(childNode);
            }
        }
    }

    @Override // com.tencent.qqnt.expandRecyclerView.adapter.BaseProviderMultiAdapter
    public void i0(int position, @NotNull Collection<? extends com.tencent.qqnt.expandRecyclerView.adapter.node.b> newData) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, position, (Object) newData);
        } else {
            Intrinsics.checkNotNullParameter(newData, "newData");
            super.i0(position, O0(this, newData, null, 2, null));
        }
    }

    @Override // com.tencent.qqnt.expandRecyclerView.adapter.BaseProviderMultiAdapter
    public void j0(@NotNull Collection<? extends com.tencent.qqnt.expandRecyclerView.adapter.node.b> newData) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) newData);
        } else {
            Intrinsics.checkNotNullParameter(newData, "newData");
            super.j0(O0(this, newData, null, 2, null));
        }
    }

    @Override // com.tencent.qqnt.expandRecyclerView.adapter.BaseProviderMultiAdapter
    public void k0(@NotNull a<com.tencent.qqnt.expandRecyclerView.adapter.node.b> provider) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) provider);
            return;
        }
        Intrinsics.checkNotNullParameter(provider, "provider");
        if (provider instanceof c) {
            super.k0(provider);
            return;
        }
        throw new IllegalStateException("Please add BaseNodeProvider, no BaseItemProvider!");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.qqnt.expandRecyclerView.adapter.BaseProviderMultiAdapter
    public boolean r0(int type) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this, type)).booleanValue();
        }
        if (!super.r0(type) && !this.fullSpanNodeTypeSet.contains(Integer.valueOf(type))) {
            return false;
        }
        return true;
    }

    public b(@Nullable List<com.tencent.qqnt.expandRecyclerView.adapter.node.b> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z16 = true;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) list);
            return;
        }
        this.fullSpanNodeTypeSet = new HashSet<>();
        List<com.tencent.qqnt.expandRecyclerView.adapter.node.b> list2 = list;
        if (list2 != null && !list2.isEmpty()) {
            z16 = false;
        }
        if (z16) {
            return;
        }
        m0().addAll(O0(this, list2, null, 2, null));
    }

    public /* synthetic */ b(List list, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : list);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, list, Integer.valueOf(i3), defaultConstructorMarker);
    }
}
