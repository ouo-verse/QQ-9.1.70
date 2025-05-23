package com.tencent.mobileqq.aio.input.at.common.list.base;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.List;

/* compiled from: P */
/* loaded from: classes10.dex */
public abstract class a<I extends T, T, VH extends RecyclerView.ViewHolder> extends b<List<T>> {
    static IPatchRedirector $redirector_;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    protected abstract boolean h(@NonNull T t16, @NonNull List<T> list, int i3);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.aio.input.at.common.list.base.b
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public final boolean a(@NonNull List<T> list, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) list, i3)).booleanValue();
        }
        return h(list.get(i3), list, i3);
    }

    protected abstract void j(@NonNull I i3, @NonNull VH vh5, @NonNull List<Object> list);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.aio.input.at.common.list.base.b
    /* renamed from: k, reason: merged with bridge method [inline-methods] */
    public final void b(@NonNull List<T> list, int i3, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull List<Object> list2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, list, Integer.valueOf(i3), viewHolder, list2);
        } else {
            j(list.get(i3), viewHolder, list2);
        }
    }
}
