package com.tencent.mobileqq.aio.input.at.common.list.base;

import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.AdapterListUpdateCallback;
import androidx.recyclerview.widget.AsyncDifferConfig;
import androidx.recyclerview.widget.AsyncListDiffer;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.List;
import java.util.concurrent.Executor;

/* compiled from: P */
/* loaded from: classes10.dex */
public class d<T> extends RecyclerView.Adapter {
    static IPatchRedirector $redirector_;
    protected final AsyncListDiffer<T> C;
    private final String D;
    private Runnable E;
    private final AsyncListDiffer.ListListener<T> F;

    /* renamed from: m, reason: collision with root package name */
    protected final c<List<T>> f189310m;

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class a implements AsyncListDiffer.ListListener<T> {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) d.this);
            }
        }

        @Override // androidx.recyclerview.widget.AsyncListDiffer.ListListener
        public void onCurrentListChanged(@NonNull List<T> list, @NonNull List<T> list2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) list, (Object) list2);
            } else if (d.this.E != null) {
                d.this.E.run();
                d.this.E = null;
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    static class b implements Executor {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) runnable);
            } else {
                ThreadManagerV2.excute(runnable, 16, null, true);
            }
        }
    }

    public d(@NonNull DiffUtil.ItemCallback<T> itemCallback) {
        this(itemCallback, new c());
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) itemCallback);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Integer) iPatchRedirector.redirect((short) 17, (Object) this)).intValue();
        }
        return this.C.getCurrentList().size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Integer) iPatchRedirector.redirect((short) 9, (Object) this, i3)).intValue();
        }
        return this.f189310m.d(this.C.getCurrentList(), i3);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 7)) {
            this.f189310m.e(this.C.getCurrentList(), i3, viewHolder, null);
        } else {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) viewHolder, i3);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (RecyclerView.ViewHolder) iPatchRedirector.redirect((short) 6, (Object) this, (Object) viewGroup, i3);
        }
        return this.f189310m.f(viewGroup, i3);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public boolean onFailedToRecycleView(@NonNull RecyclerView.ViewHolder viewHolder) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this, (Object) viewHolder)).booleanValue();
        }
        return this.f189310m.g(viewHolder);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewAttachedToWindow(@NonNull RecyclerView.ViewHolder viewHolder) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) viewHolder);
        } else {
            this.f189310m.h(viewHolder);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewDetachedFromWindow(@NonNull RecyclerView.ViewHolder viewHolder) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) viewHolder);
        } else {
            this.f189310m.i(viewHolder);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewRecycled(@NonNull RecyclerView.ViewHolder viewHolder) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) viewHolder);
        } else {
            this.f189310m.j(viewHolder);
        }
    }

    public void setItems(List<T> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) list);
        } else {
            this.C.submitList(list);
        }
    }

    public d(@NonNull DiffUtil.ItemCallback<T> itemCallback, @NonNull c<List<T>> cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) itemCallback, (Object) cVar);
            return;
        }
        this.D = getClass().getCanonicalName();
        a aVar = new a();
        this.F = aVar;
        if (itemCallback == null) {
            throw new NullPointerException("ItemCallback is null");
        }
        if (cVar != null) {
            AsyncListDiffer<T> asyncListDiffer = new AsyncListDiffer<>(new AdapterListUpdateCallback(this), new AsyncDifferConfig.Builder(itemCallback).setBackgroundThreadExecutor(new b()).build());
            this.C = asyncListDiffer;
            this.f189310m = cVar;
            asyncListDiffer.addListListener(aVar);
            return;
        }
        throw new NullPointerException("AdapterDelegatesManager is null");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i3, @NonNull List list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 8)) {
            this.f189310m.e(this.C.getCurrentList(), i3, viewHolder, list);
        } else {
            iPatchRedirector.redirect((short) 8, this, viewHolder, Integer.valueOf(i3), list);
        }
    }
}
