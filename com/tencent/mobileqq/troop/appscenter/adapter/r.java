package com.tencent.mobileqq.troop.appscenter.adapter;

import androidx.recyclerview.widget.DiffUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0007\u0018\u00002\u00020\u0001B#\u0012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00020\u000e\u0012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00020\u000e\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\t\u001a\u00020\u0007H\u0016J\u0018\u0010\f\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u0007H\u0016J\u0018\u0010\r\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u0007H\u0016R\u001a\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00020\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u000fR\u001a\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00020\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u000f\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/troop/appscenter/adapter/r;", "Landroidx/recyclerview/widget/DiffUtil$Callback;", "Lcom/tencent/mobileqq/troop/appscenter/adapter/a;", "oldItem", "newItem", "", "a", "", "getNewListSize", "getOldListSize", "oldItemPosition", "newItemPosition", "areContentsTheSame", "areItemsTheSame", "", "Ljava/util/List;", "oldList", "b", "newList", "<init>", "(Ljava/util/List;Ljava/util/List;)V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class r extends DiffUtil.Callback {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<a> oldList;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<a> newList;

    public r(@NotNull List<a> oldList, @NotNull List<a> newList) {
        Intrinsics.checkNotNullParameter(oldList, "oldList");
        Intrinsics.checkNotNullParameter(newList, "newList");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) oldList, (Object) newList);
        } else {
            this.oldList = oldList;
            this.newList = newList;
        }
    }

    private final boolean a(a oldItem, a newItem) {
        if (Intrinsics.areEqual(oldItem.a().name, newItem.a().name) && Intrinsics.areEqual(oldItem.a().icon, newItem.a().icon) && oldItem.a().type == newItem.a().type && oldItem.a().removable == newItem.a().removable && Intrinsics.areEqual(oldItem.a().desc, newItem.a().desc) && oldItem.a().added == newItem.a().added && oldItem.a().addTs == newItem.a().addTs && oldItem.b() == newItem.b()) {
            return true;
        }
        return false;
    }

    @Override // androidx.recyclerview.widget.DiffUtil.Callback
    public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, this, Integer.valueOf(oldItemPosition), Integer.valueOf(newItemPosition))).booleanValue();
        }
        return a(this.oldList.get(oldItemPosition), this.newList.get(newItemPosition));
    }

    @Override // androidx.recyclerview.widget.DiffUtil.Callback
    public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, this, Integer.valueOf(oldItemPosition), Integer.valueOf(newItemPosition))).booleanValue();
        }
        return Intrinsics.areEqual(this.oldList.get(oldItemPosition).a().appId, this.newList.get(newItemPosition).a().appId);
    }

    @Override // androidx.recyclerview.widget.DiffUtil.Callback
    public int getNewListSize() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return this.newList.size();
    }

    @Override // androidx.recyclerview.widget.DiffUtil.Callback
    public int getOldListSize() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return this.oldList.size();
    }
}
