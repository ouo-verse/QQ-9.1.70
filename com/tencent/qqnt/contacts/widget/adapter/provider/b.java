package com.tencent.qqnt.contacts.widget.adapter.provider;

import androidx.annotation.IntRange;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.contacts.widget.adapter.BaseProviderMultiAdapter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u001e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b&\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0019\u0012\u0010\b\u0002\u0010#\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0007\u00a2\u0006\u0004\b$\u0010%J/\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\u00072\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0002\u00a2\u0006\u0004\b\b\u0010\tJ<\u0010\u0011\u001a\u00020\n2\b\b\u0001\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\u00052\b\b\u0002\u0010\r\u001a\u00020\u00052\b\b\u0002\u0010\u000e\u001a\u00020\u00052\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0002J<\u0010\u0013\u001a\u00020\n2\b\b\u0001\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\u0012\u001a\u00020\u00052\b\b\u0002\u0010\r\u001a\u00020\u00052\b\b\u0002\u0010\u000e\u001a\u00020\u00052\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0002J\u000e\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u0014J\u0016\u0010\u0019\u001a\u00020\u00162\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00020\u0018H\u0016J\u0010\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\nH\u0014J\u0018\u0010\u001c\u001a\u00020\u00162\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0003H\u0016J2\u0010\u001d\u001a\u00020\n2\b\b\u0001\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\r\u001a\u00020\u00052\b\b\u0002\u0010\u000e\u001a\u00020\u00052\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0007R$\u0010\"\u001a\u0012\u0012\u0004\u0012\u00020\n0\u001ej\b\u0012\u0004\u0012\u00020\n`\u001f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b \u0010!\u00a8\u0006&"}, d2 = {"Lcom/tencent/qqnt/contacts/widget/adapter/provider/b;", "Lcom/tencent/qqnt/contacts/widget/adapter/BaseProviderMultiAdapter;", "Lcom/tencent/qqnt/contacts/widget/adapter/node/b;", "", "list", "", "isExpanded", "", "A0", "(Ljava/util/Collection;Ljava/lang/Boolean;)Ljava/util/List;", "", "position", "isChangeChildCollapse", "animate", "notify", "", "parentPayload", "w0", "isChangeChildExpand", "x0", "Lcom/tencent/qqnt/contacts/widget/adapter/provider/c;", "provider", "", "v0", "Lcom/tencent/qqnt/contacts/widget/adapter/provider/a;", "i0", "type", "n0", "u0", "y0", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "D", "Ljava/util/HashSet;", "fullSpanNodeTypeSet", "nodeList", "<init>", "(Ljava/util/List;)V", "contacts_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public abstract class b extends BaseProviderMultiAdapter<com.tencent.qqnt.contacts.widget.adapter.node.b> {
    static IPatchRedirector $redirector_;

    /* renamed from: D, reason: from kotlin metadata */
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

    private final List<com.tencent.qqnt.contacts.widget.adapter.node.b> A0(Collection<? extends com.tencent.qqnt.contacts.widget.adapter.node.b> list, Boolean isExpanded) {
        ArrayList arrayList = new ArrayList();
        for (com.tencent.qqnt.contacts.widget.adapter.node.b bVar : list) {
            arrayList.add(bVar);
            boolean z16 = false;
            if (bVar instanceof com.tencent.qqnt.contacts.widget.adapter.node.a) {
                if (Intrinsics.areEqual(isExpanded, Boolean.TRUE) || ((com.tencent.qqnt.contacts.widget.adapter.node.a) bVar).b()) {
                    List<com.tencent.qqnt.contacts.widget.adapter.node.b> a16 = bVar.a();
                    if (a16 == null || a16.isEmpty()) {
                        z16 = true;
                    }
                    if (!z16) {
                        arrayList.addAll(A0(a16, isExpanded));
                    }
                }
                if (isExpanded != null) {
                    ((com.tencent.qqnt.contacts.widget.adapter.node.a) bVar).c(isExpanded.booleanValue());
                }
            } else {
                List<com.tencent.qqnt.contacts.widget.adapter.node.b> a17 = bVar.a();
                if (a17 == null || a17.isEmpty()) {
                    z16 = true;
                }
                if (!z16) {
                    arrayList.addAll(A0(a17, isExpanded));
                }
            }
        }
        return arrayList;
    }

    static /* synthetic */ List B0(b bVar, Collection collection, Boolean bool, int i3, Object obj) {
        if (obj == null) {
            if ((i3 & 2) != 0) {
                bool = null;
            }
            return bVar.A0(collection, bool);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: flatData");
    }

    private final int w0(@IntRange(from = 0) int position, boolean isChangeChildCollapse, boolean animate, boolean notify, Object parentPayload) {
        boolean z16;
        Boolean bool;
        com.tencent.qqnt.contacts.widget.adapter.node.b bVar = j0().get(position);
        if (bVar instanceof com.tencent.qqnt.contacts.widget.adapter.node.a) {
            com.tencent.qqnt.contacts.widget.adapter.node.a aVar = (com.tencent.qqnt.contacts.widget.adapter.node.a) bVar;
            if (aVar.b()) {
                aVar.c(false);
                List<com.tencent.qqnt.contacts.widget.adapter.node.b> a16 = bVar.a();
                if (a16 != null && !a16.isEmpty()) {
                    z16 = false;
                } else {
                    z16 = true;
                }
                if (z16) {
                    notifyItemChanged(position, parentPayload);
                    return 0;
                }
                List<com.tencent.qqnt.contacts.widget.adapter.node.b> a17 = bVar.a();
                Intrinsics.checkNotNull(a17);
                List<com.tencent.qqnt.contacts.widget.adapter.node.b> list = a17;
                if (isChangeChildCollapse) {
                    bool = Boolean.FALSE;
                } else {
                    bool = null;
                }
                List<com.tencent.qqnt.contacts.widget.adapter.node.b> A0 = A0(list, bool);
                int size = A0.size();
                j0().removeAll(A0);
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

    private final int x0(@IntRange(from = 0) int position, boolean isChangeChildExpand, boolean animate, boolean notify, Object parentPayload) {
        Boolean bool;
        com.tencent.qqnt.contacts.widget.adapter.node.b bVar = j0().get(position);
        if (bVar instanceof com.tencent.qqnt.contacts.widget.adapter.node.a) {
            com.tencent.qqnt.contacts.widget.adapter.node.a aVar = (com.tencent.qqnt.contacts.widget.adapter.node.a) bVar;
            if (!aVar.b()) {
                boolean z16 = true;
                aVar.c(true);
                List<com.tencent.qqnt.contacts.widget.adapter.node.b> a16 = bVar.a();
                if (a16 != null && !a16.isEmpty()) {
                    z16 = false;
                }
                if (z16) {
                    notifyItemChanged(position, parentPayload);
                    return 0;
                }
                List<com.tencent.qqnt.contacts.widget.adapter.node.b> a17 = bVar.a();
                Intrinsics.checkNotNull(a17);
                List<com.tencent.qqnt.contacts.widget.adapter.node.b> list = a17;
                if (isChangeChildExpand) {
                    bool = Boolean.TRUE;
                } else {
                    bool = null;
                }
                List<com.tencent.qqnt.contacts.widget.adapter.node.b> A0 = A0(list, bool);
                int size = A0.size();
                int i3 = position + 1;
                j0().addAll(i3, A0);
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

    public static /* synthetic */ int z0(b bVar, int i3, boolean z16, boolean z17, Object obj, int i16, Object obj2) {
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
            return bVar.y0(i3, z16, z17, obj);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: expandOrCollapse");
    }

    @Override // com.tencent.qqnt.contacts.widget.adapter.BaseProviderMultiAdapter
    public void i0(@NotNull a<com.tencent.qqnt.contacts.widget.adapter.node.b> provider) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) provider);
            return;
        }
        Intrinsics.checkNotNullParameter(provider, "provider");
        if (provider instanceof c) {
            super.i0(provider);
            return;
        }
        throw new IllegalStateException("Please add BaseNodeProvider, no BaseItemProvider!");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.qqnt.contacts.widget.adapter.BaseProviderMultiAdapter
    public boolean n0(int type) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this, type)).booleanValue();
        }
        if (!super.n0(type) && !this.fullSpanNodeTypeSet.contains(Integer.valueOf(type))) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.qqnt.contacts.widget.adapter.BaseProviderMultiAdapter
    public void u0(@Nullable Collection<? extends com.tencent.qqnt.contacts.widget.adapter.node.b> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, (Object) list);
            return;
        }
        if (list == null) {
            list = new ArrayList<>();
        }
        super.u0(B0(this, list, null, 2, null));
    }

    public final void v0(@NotNull c provider) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) provider);
            return;
        }
        Intrinsics.checkNotNullParameter(provider, "provider");
        this.fullSpanNodeTypeSet.add(Integer.valueOf(provider.f()));
        i0(provider);
    }

    @JvmOverloads
    public final int y0(@IntRange(from = 0) int position, boolean animate, boolean notify, @Nullable Object parentPayload) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return ((Integer) iPatchRedirector.redirect((short) 24, this, Integer.valueOf(position), Boolean.valueOf(animate), Boolean.valueOf(notify), parentPayload)).intValue();
        }
        com.tencent.qqnt.contacts.widget.adapter.node.b bVar = j0().get(position);
        if (!(bVar instanceof com.tencent.qqnt.contacts.widget.adapter.node.a)) {
            return 0;
        }
        if (((com.tencent.qqnt.contacts.widget.adapter.node.a) bVar).b()) {
            return w0(position, false, animate, notify, parentPayload);
        }
        return x0(position, false, animate, notify, parentPayload);
    }

    public b(@Nullable List<com.tencent.qqnt.contacts.widget.adapter.node.b> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z16 = true;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) list);
            return;
        }
        this.fullSpanNodeTypeSet = new HashSet<>();
        List<com.tencent.qqnt.contacts.widget.adapter.node.b> list2 = list;
        if (list2 != null && !list2.isEmpty()) {
            z16 = false;
        }
        if (z16) {
            return;
        }
        j0().addAll(B0(this, list2, null, 2, null));
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
