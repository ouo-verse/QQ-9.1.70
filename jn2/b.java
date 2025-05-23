package jn2;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes18.dex */
public abstract class b<D, V extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<V> {
    protected a<D> C;

    /* renamed from: m, reason: collision with root package name */
    protected List<D> f410656m = new ArrayList();

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public interface a<D> {
        void a(View view, D d16, int i3);
    }

    @Nullable
    public D getItem(int i3) {
        if (i3 >= 0 && i3 < getItemCount()) {
            return this.f410656m.get(i3);
        }
        return null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public abstract int getItemCount();

    protected abstract void i0(@NonNull V v3, int i3, @NonNull D d16);

    public boolean isEmpty() {
        if (getItemCount() == 0) {
            return true;
        }
        return false;
    }

    public D j0(int i3) {
        if (i3 >= 0 && i3 < getItemCount()) {
            D remove = this.f410656m.remove(i3);
            notifyItemRemoved(i3);
            return remove;
        }
        return null;
    }

    protected abstract void k0(@NonNull V v3);

    public void l0(a<D> aVar) {
        this.C = aVar;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull V v3, int i3) {
        D item = getItem(i3);
        if (item == null) {
            return;
        }
        k0(v3);
        i0(v3, i3, item);
    }

    public void release() {
        this.C = null;
    }

    public void updateData(List<D> list) {
        this.f410656m.clear();
        if (list != null && !list.isEmpty()) {
            this.f410656m.addAll(list);
        }
        notifyDataSetChanged();
    }
}
