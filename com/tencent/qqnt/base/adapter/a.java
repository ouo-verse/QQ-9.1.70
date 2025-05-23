package com.tencent.qqnt.base.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.ListAdapter;
import androidx.viewbinding.ViewBinding;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.base.adapter.b;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\b\b\u0001\u0010\u0004*\u00020\u00032\u001a\u0012\u0004\u0012\u00028\u0000\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00060\u0005B\u0015\u0012\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\u0016\u00a2\u0006\u0004\b\u0018\u0010\u0019J$\u0010\u000b\u001a\u00020\n2\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J2\u0010\u000f\u001a\u00020\n2\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00062\u0006\u0010\t\u001a\u00020\b2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0016J\u0010\u0010\u0010\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0016R\u0018\u0010\u0015\u001a\u00020\u0012*\u00020\u00118DX\u0084\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/qqnt/base/adapter/a;", "Lcom/tencent/qqnt/base/adapter/b;", "Item", "Landroidx/viewbinding/ViewBinding;", "VB", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/tencent/qqnt/base/adapter/d;", "holder", "", "position", "", "j0", "", "", "payloads", "k0", "getItemViewType", "Landroid/view/ViewGroup;", "Landroid/view/LayoutInflater;", "i0", "(Landroid/view/ViewGroup;)Landroid/view/LayoutInflater;", "layoutInflater", "Lcom/tencent/qqnt/base/adapter/c;", "diffCallbcak", "<init>", "(Lcom/tencent/qqnt/base/adapter/c;)V", "ntui_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public abstract class a<Item extends b, VB extends ViewBinding> extends ListAdapter<Item, d<Item, VB>> {
    static IPatchRedirector $redirector_;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(@NotNull c<Item> diffCallbcak) {
        super(diffCallbcak);
        Intrinsics.checkNotNullParameter(diffCallbcak, "diffCallbcak");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) diffCallbcak);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this, position)).intValue();
        }
        return ((b) getItem(position)).e();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final LayoutInflater i0(@NotNull ViewGroup viewGroup) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (LayoutInflater) iPatchRedirector.redirect((short) 2, (Object) this, (Object) viewGroup);
        }
        Intrinsics.checkNotNullParameter(viewGroup, "<this>");
        LayoutInflater from = LayoutInflater.from(viewGroup.getContext());
        Intrinsics.checkNotNullExpressionValue(from, "from(this.context)");
        return from;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: j0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(@NotNull d<Item, VB> holder, int position) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) holder, position);
            return;
        }
        Intrinsics.checkNotNullParameter(holder, "holder");
        Item item = getItem(position);
        Intrinsics.checkNotNullExpressionValue(item, "getItem(position)");
        holder.l((b) item);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: k0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(@NotNull d<Item, VB> holder, int position, @NotNull List<Object> payloads) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, holder, Integer.valueOf(position), payloads);
            return;
        }
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        Item item = getItem(position);
        Intrinsics.checkNotNullExpressionValue(item, "getItem(position)");
        holder.m((b) item, payloads);
    }
}
