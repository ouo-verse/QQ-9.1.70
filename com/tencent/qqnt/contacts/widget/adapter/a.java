package com.tencent.qqnt.contacts.widget.adapter;

import android.util.SparseArray;
import android.view.View;
import androidx.annotation.IdRes;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\r\u001a\u00020\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ!\u0010\u0006\u001a\u00028\u0000\"\b\b\u0000\u0010\u0003*\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0006\u0010\u0007J#\u0010\b\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010\u0003*\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u0004\u00a2\u0006\u0004\b\b\u0010\u0007R\u001a\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00020\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000b\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/qqnt/contacts/widget/adapter/a;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/view/View;", "T", "", "viewId", "getView", "(I)Landroid/view/View;", "getViewOrNull", "Landroid/util/SparseArray;", "E", "Landroid/util/SparseArray;", "views", "itemView", "<init>", "(Landroid/view/View;)V", "contacts_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class a extends RecyclerView.ViewHolder {
    static IPatchRedirector $redirector_;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final SparseArray<View> views;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(@NotNull View itemView) {
        super(itemView);
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) itemView);
        } else {
            this.views = new SparseArray<>();
        }
    }

    @NotNull
    public final <T extends View> T getView(@IdRes int viewId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (T) iPatchRedirector.redirect((short) 4, (Object) this, viewId);
        }
        T t16 = (T) getViewOrNull(viewId);
        if (t16 != null) {
            return t16;
        }
        throw new IllegalStateException(("No view found with id " + viewId).toString());
    }

    @Nullable
    public final <T extends View> T getViewOrNull(@IdRes int viewId) {
        T t16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (T) iPatchRedirector.redirect((short) 5, (Object) this, viewId);
        }
        T t17 = (T) this.views.get(viewId);
        if (t17 == null && (t16 = (T) this.itemView.findViewById(viewId)) != null) {
            this.views.put(viewId, t16);
            return t16;
        }
        if (t17 == null) {
            return null;
        }
        return t17;
    }
}
