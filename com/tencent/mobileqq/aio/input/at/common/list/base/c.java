package com.tencent.mobileqq.aio.input.at.common.list.base;

import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.SparseArrayCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import java.util.Collections;
import java.util.List;

/* compiled from: P */
/* loaded from: classes10.dex */
public class c<T> {
    static IPatchRedirector $redirector_;

    /* renamed from: c, reason: collision with root package name */
    private static final List<Object> f189307c;

    /* renamed from: a, reason: collision with root package name */
    protected SparseArrayCompat<b<T>> f189308a;

    /* renamed from: b, reason: collision with root package name */
    protected b<T> f189309b;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(65892);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 20)) {
            redirector.redirect((short) 20);
        } else {
            f189307c = Collections.emptyList();
        }
    }

    public c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f189308a = new SparseArrayCompat<>();
        }
    }

    public c<T> a(int i3, boolean z16, @NonNull b<T> bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (c) iPatchRedirector.redirect((short) 5, this, Integer.valueOf(i3), Boolean.valueOf(z16), bVar);
        }
        if (bVar != null) {
            if (i3 != 2147483646) {
                if (!z16 && this.f189308a.get(i3) != null) {
                    throw new IllegalArgumentException("An AdapterDelegate is already registered for the viewType = " + i3 + ". Already registered AdapterDelegate is " + this.f189308a.get(i3));
                }
                this.f189308a.put(i3, bVar);
                return this;
            }
            throw new IllegalArgumentException("The view type = 2147483646 is reserved for fallback adapter delegate (see setFallbackDelegate() ). Please use another view type.");
        }
        throw new NullPointerException("AdapterDelegate is null!");
    }

    public c<T> b(@NonNull b<T> bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (c) iPatchRedirector.redirect((short) 3, (Object) this, (Object) bVar);
        }
        int size = this.f189308a.size();
        while (this.f189308a.get(size) != null) {
            size++;
            if (size == 2147483646) {
                throw new IllegalArgumentException("Oops, we are very close to Integer.MAX_VALUE. It seems that there are no more free and unused view type integers left to add another AdapterDelegate.");
            }
        }
        return a(size, false, bVar);
    }

    @Nullable
    public b<T> c(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return (b) iPatchRedirector.redirect((short) 18, (Object) this, i3);
        }
        return this.f189308a.get(i3, this.f189309b);
    }

    public int d(@NonNull T t16, int i3) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this, (Object) t16, i3)).intValue();
        }
        if (t16 != null) {
            int size = this.f189308a.size();
            for (int i16 = 0; i16 < size; i16++) {
                if (this.f189308a.valueAt(i16).a(t16, i3)) {
                    return this.f189308a.keyAt(i16);
                }
            }
            if (this.f189309b != null) {
                return 2147483646;
            }
            if (t16 instanceof List) {
                str = "No AdapterDelegate added that matches item=" + ((List) t16).get(i3).toString() + " at position=" + i3 + " in data source";
            } else {
                str = "No AdapterDelegate added for item at position=" + i3 + ". items=" + t16;
            }
            throw new NullPointerException(str);
        }
        throw new NullPointerException("Items datasource is null!");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void e(@NonNull T t16, int i3, @NonNull RecyclerView.ViewHolder viewHolder, List list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, t16, Integer.valueOf(i3), viewHolder, list);
            return;
        }
        b<T> c16 = c(viewHolder.getItemViewType());
        if (c16 != 0) {
            if (list == null) {
                list = f189307c;
            }
            c16.b(t16, i3, viewHolder, list);
        } else {
            throw new NullPointerException("No delegate found for item at position = " + i3 + " for viewType = " + viewHolder.getItemViewType());
        }
    }

    @NonNull
    public RecyclerView.ViewHolder f(@NonNull ViewGroup viewGroup, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (RecyclerView.ViewHolder) iPatchRedirector.redirect((short) 9, (Object) this, (Object) viewGroup, i3);
        }
        b<T> c16 = c(i3);
        if (c16 != null) {
            RecyclerView.ViewHolder c17 = c16.c(viewGroup);
            if (c17 != null) {
                try {
                    ViewGroup viewGroup2 = (ViewGroup) c17.itemView.getParent();
                    if (viewGroup2 != null) {
                        viewGroup2.removeView(c17.itemView);
                    }
                } catch (Exception e16) {
                    if (QLog.isColorLevel()) {
                        QLog.e("AdapterDelegatesManager", 2, "onCreateViewHolder error : " + e16.toString());
                    }
                }
                return c17;
            }
            throw new NullPointerException("ViewHolder returned from AdapterDelegate " + c16 + " for ViewType =" + i3 + " is null!");
        }
        throw new NullPointerException("No AdapterDelegate added for ViewType " + i3);
    }

    public boolean g(@NonNull RecyclerView.ViewHolder viewHolder) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Boolean) iPatchRedirector.redirect((short) 13, (Object) this, (Object) viewHolder)).booleanValue();
        }
        b<T> c16 = c(viewHolder.getItemViewType());
        if (c16 != null) {
            return c16.d(viewHolder);
        }
        throw new NullPointerException("No delegate found for " + viewHolder + " for item at position = " + viewHolder.getAdapterPosition() + " for viewType = " + viewHolder.getItemViewType());
    }

    public void h(@NonNull RecyclerView.ViewHolder viewHolder) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) viewHolder);
            return;
        }
        b<T> c16 = c(viewHolder.getItemViewType());
        if (c16 != null) {
            c16.e(viewHolder);
            return;
        }
        throw new NullPointerException("No delegate found for " + viewHolder + " for item at position = " + viewHolder.getAdapterPosition() + " for viewType = " + viewHolder.getItemViewType());
    }

    public void i(@NonNull RecyclerView.ViewHolder viewHolder) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) viewHolder);
            return;
        }
        b<T> c16 = c(viewHolder.getItemViewType());
        if (c16 != null) {
            c16.f(viewHolder);
            return;
        }
        throw new NullPointerException("No delegate found for " + viewHolder + " for item at position = " + viewHolder.getAdapterPosition() + " for viewType = " + viewHolder.getItemViewType());
    }

    public void j(@NonNull RecyclerView.ViewHolder viewHolder) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) viewHolder);
            return;
        }
        b<T> c16 = c(viewHolder.getItemViewType());
        if (c16 != null) {
            c16.g(viewHolder);
            return;
        }
        throw new NullPointerException("No delegate found for " + viewHolder + " for item at position = " + viewHolder.getAdapterPosition() + " for viewType = " + viewHolder.getItemViewType());
    }
}
