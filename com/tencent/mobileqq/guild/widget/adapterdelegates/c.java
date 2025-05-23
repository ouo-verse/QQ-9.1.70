package com.tencent.mobileqq.guild.widget.adapterdelegates;

import android.util.SparseIntArray;
import android.view.ViewGroup;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.SparseArrayCompat;
import androidx.core.util.Pools;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.guild.util.s;
import com.tencent.mobileqq.guild.widget.adapterdelegates.annotations.CachedSize;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.List;

/* compiled from: P */
/* loaded from: classes14.dex */
public class c<T> {

    /* renamed from: g, reason: collision with root package name */
    private static final List<Object> f236200g = Collections.emptyList();

    /* renamed from: h, reason: collision with root package name */
    private static boolean f236201h = false;

    /* renamed from: b, reason: collision with root package name */
    protected b<T> f236203b;

    /* renamed from: c, reason: collision with root package name */
    protected RecyclerView f236204c;

    /* renamed from: a, reason: collision with root package name */
    protected SparseArrayCompat<b<T>> f236202a = new SparseArrayCompat<>();

    /* renamed from: d, reason: collision with root package name */
    protected SparseIntArray f236205d = new SparseIntArray();

    /* renamed from: e, reason: collision with root package name */
    private boolean f236206e = false;

    /* renamed from: f, reason: collision with root package name */
    private SparseArrayCompat<Pools.Pool<RecyclerView.ViewHolder>> f236207f = new SparseArrayCompat<>();

    /* compiled from: P */
    /* loaded from: classes14.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private static Method f236208a;

        public static void a(RecyclerView.ViewHolder viewHolder) {
            if (f236208a == null) {
                try {
                    Method declaredMethod = RecyclerView.ViewHolder.class.getDeclaredMethod("resetInternal", new Class[0]);
                    f236208a = declaredMethod;
                    declaredMethod.setAccessible(true);
                } catch (NoSuchMethodException e16) {
                    QLog.e("AdapterDelegatesManager", 1, "resetInternal", e16);
                    return;
                }
            }
            try {
                f236208a.invoke(viewHolder, new Object[0]);
            } catch (IllegalAccessException e17) {
                QLog.e("AdapterDelegatesManager", 1, "resetInternal", e17);
            } catch (InvocationTargetException e18) {
                QLog.e("AdapterDelegatesManager", 1, "resetInternal", e18);
            }
        }
    }

    private Pools.Pool<RecyclerView.ViewHolder> g(int i3) {
        Pools.Pool<RecyclerView.ViewHolder> pool = this.f236207f.get(i3);
        if (pool == null) {
            Pools.SimplePool simplePool = new Pools.SimplePool(15);
            this.f236207f.put(i3, simplePool);
            return simplePool;
        }
        return pool;
    }

    private void s(@NonNull RecyclerView.ViewHolder viewHolder, b<T> bVar) {
        int identityHashCode;
        int i3;
        if (this.f236205d.size() == 0 || this.f236204c == null || (i3 = this.f236205d.get((identityHashCode = System.identityHashCode(bVar)), -1)) < 0) {
            return;
        }
        int itemViewType = viewHolder.getItemViewType();
        QLog.i("AdapterDelegatesManager", 1, System.identityHashCode(this) + ": setRecycledViewPool size " + i3 + " for viewType " + itemViewType + " delegate: " + bVar.getClass().getCanonicalName());
        this.f236204c.getRecycledViewPool().setMaxRecycledViews(itemViewType, i3);
        this.f236205d.delete(identityHashCode);
    }

    public c<T> a(int i3, @NonNull b<T> bVar) {
        return b(i3, false, bVar);
    }

    public c<T> b(int i3, boolean z16, @NonNull b<T> bVar) {
        if (bVar != null) {
            if (i3 != 2147483646) {
                if (!z16 && this.f236202a.get(i3) != null) {
                    throw new IllegalArgumentException("An AdapterDelegate is already registered for the viewType = " + i3 + ". Already registered AdapterDelegate is " + this.f236202a.get(i3));
                }
                this.f236202a.put(i3, bVar);
                CachedSize cachedSize = (CachedSize) bVar.getClass().getAnnotation(CachedSize.class);
                if (cachedSize != null) {
                    int identityHashCode = System.identityHashCode(bVar);
                    this.f236205d.put(identityHashCode, cachedSize.size());
                    QLog.i("AdapterDelegatesManager", 1, System.identityHashCode(this) + ": key = " + identityHashCode + " " + bVar.getClass().getSimpleName() + " CachedSize: " + cachedSize.size());
                }
                if (this.f236206e) {
                    int identityHashCode2 = System.identityHashCode(bVar);
                    this.f236205d.put(identityHashCode2, 0);
                    QLog.i("AdapterDelegatesManager", 1, System.identityHashCode(this) + ": key = " + identityHashCode2 + " " + bVar.getClass().getSimpleName() + " CachedSize: 0");
                }
                return this;
            }
            throw new IllegalArgumentException("The view type = 2147483646 is reserved for fallback adapter delegate (see setFallbackDelegate() ). Please use another view type.");
        }
        throw new NullPointerException("AdapterDelegate is null!");
    }

    public c<T> c(@NonNull b<T> bVar) {
        int size = this.f236202a.size();
        while (this.f236202a.get(size) != null) {
            size++;
            if (size == 2147483646) {
                throw new IllegalArgumentException("Oops, we are very close to Integer.MAX_VALUE. It seems that there are no more free and unused view type integers left to add another AdapterDelegate.");
            }
        }
        return b(size, false, bVar);
    }

    @Nullable
    public b<T> d(int i3) {
        return this.f236202a.get(i3, this.f236203b);
    }

    protected int e(@NonNull RecyclerView.ViewHolder viewHolder) {
        if (f236201h) {
            RecyclerView recyclerView = this.f236204c;
            if (recyclerView == null) {
                QLog.e("AdapterDelegatesManager", 1, "getInnerViewType " + viewHolder.getItemViewType() + ", recyclerView(null)");
            } else if (recyclerView.getAdapter() == null) {
                QLog.e("AdapterDelegatesManager", 1, "getInnerViewType " + viewHolder.getItemViewType() + ", adapter(null)");
            } else {
                try {
                    QLog.i("AdapterDelegatesManager", 1, "getInnerViewType " + viewHolder.getItemViewType() + ", adapter " + this.f236204c.getAdapter().getItemViewType(viewHolder.getAdapterPosition()));
                } catch (Exception e16) {
                    QLog.e("AdapterDelegatesManager", 1, "getInnerViewType " + viewHolder.getItemViewType() + ", adapter " + e16);
                }
            }
        }
        return viewHolder.getItemViewType();
    }

    public int f(@NonNull T t16, int i3) {
        String str;
        if (t16 != null) {
            int size = this.f236202a.size();
            for (int i16 = 0; i16 < size; i16++) {
                if (this.f236202a.valueAt(i16).a(t16, i3)) {
                    return this.f236202a.keyAt(i16);
                }
            }
            if (this.f236203b != null) {
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

    public int h() {
        int i3;
        int size = this.f236202a.size();
        if (this.f236203b != null) {
            i3 = 1;
        } else {
            i3 = 0;
        }
        return size + i3;
    }

    public void i(RecyclerView recyclerView) {
        this.f236204c = recyclerView;
        QLog.i("AdapterDelegatesManager", 1, "onAttachedToRecyclerView");
        for (int i3 = 0; i3 < this.f236202a.size(); i3++) {
            b<T> bVar = this.f236202a.get(this.f236202a.keyAt(i3));
            if (bVar != null) {
                bVar.b(recyclerView);
            }
        }
    }

    public void j(@NonNull T t16, int i3, @NonNull RecyclerView.ViewHolder viewHolder, List list) {
        List list2;
        boolean z16;
        int e16 = e(viewHolder);
        b<T> d16 = d(e16);
        if (d16 != null) {
            s(viewHolder, d16);
            if (Debug.ENABLE_DEBUG) {
                if (list == null) {
                    list = f236200g;
                }
                Debug.j(d16, t16, i3, viewHolder, list);
                return;
            }
            if (list != null) {
                list2 = list;
            } else {
                try {
                    list2 = f236200g;
                } catch (ClassCastException e17) {
                    RecyclerView recyclerView = this.f236204c;
                    boolean z17 = false;
                    if (recyclerView == null) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (recyclerView != null && recyclerView.isInLayout()) {
                        z17 = true;
                    }
                    String str = "onBindViewHolder(isInLayout: " + z17 + ", isRecyclerViewNull=" + z16 + ")";
                    QLog.e("AdapterDelegatesManager", 1, str, e17);
                    if (list == null) {
                        list = f236200g;
                    }
                    k(d16, t16, i3, viewHolder, list);
                    s.e("AdapterDelegatesManager", "AdapterDelegatesManager ClassCastError", new RuntimeException(str, e17));
                }
            }
            k.a(d16, t16, i3, viewHolder, list2);
            if (f236201h) {
                QLog.i("AdapterDelegatesManager", 1, "onBindViewHolder viewType: " + e16 + " holder: " + System.identityHashCode(viewHolder));
                return;
            }
            return;
        }
        throw new NullPointerException("No delegate found for item at position = " + i3 + " for viewType = " + e(viewHolder));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @CallSuper
    public void k(@NonNull b<T> bVar, T t16, int i3, @NonNull RecyclerView.ViewHolder viewHolder, List list) {
        QLog.e("AdapterDelegatesManager", 1, "error : position is " + i3);
        QLog.e("AdapterDelegatesManager", 1, "error : delegate is " + bVar.getClass().getCanonicalName());
        QLog.e("AdapterDelegatesManager", 1, "error : holder is " + viewHolder.getClass().getCanonicalName());
        QLog.e("AdapterDelegatesManager", 1, "error : holder position " + viewHolder.getAdapterPosition() + " " + viewHolder.getLayoutPosition());
        List list2 = (List) t16;
        int max = Math.max(i3 + (-3), 0);
        int min = Math.min(i3 + 3, list2.size() - 1);
        QLog.e("AdapterDelegatesManager", 1, "error : from position " + max + " to " + min);
        while (max <= min) {
            Object obj = list2.get(max);
            if (max == i3) {
                QLog.e("AdapterDelegatesManager", 1, "error : " + max + " " + obj.getClass().getCanonicalName() + " <===");
                QLog.e("AdapterDelegatesManager", 1, "error : " + max + " " + obj + " <===");
            } else {
                QLog.e("AdapterDelegatesManager", 1, "error : " + max + " " + obj.getClass().getCanonicalName());
                QLog.e("AdapterDelegatesManager", 1, "error : " + max + " " + obj);
            }
            max++;
        }
    }

    @NonNull
    public RecyclerView.ViewHolder l(@NonNull ViewGroup viewGroup, int i3) {
        RecyclerView.ViewHolder viewHolder;
        b<T> d16 = d(i3);
        if (d16 != null) {
            if (this.f236206e) {
                viewHolder = g(i3).acquire();
            } else {
                viewHolder = null;
            }
            if (viewHolder != null) {
                QLog.i("AdapterDelegatesManager", 1, System.identityHashCode(this) + " onCreateViewHolder get from pool, viewType: " + i3 + " holder: " + System.identityHashCode(viewHolder));
                a.a(viewHolder);
            } else if (Debug.ENABLE_DEBUG) {
                viewHolder = Debug.k(d16, viewGroup);
            } else {
                viewHolder = k.b(d16, viewGroup);
            }
            if (viewHolder != null) {
                try {
                    ViewGroup viewGroup2 = (ViewGroup) viewHolder.itemView.getParent();
                    if (viewGroup2 != null) {
                        viewGroup2.removeView(viewHolder.itemView);
                    }
                } catch (Exception e16) {
                    QLog.e("AdapterDelegatesManager", 2, "onCreateViewHolder error : " + e16.toString());
                }
                QLog.i("AdapterDelegatesManager", 1, "onCreateViewHolder viewType: " + i3 + " holder: " + System.identityHashCode(viewHolder) + " delegate: " + d16.getClass().getSimpleName() + " " + viewHolder);
                return viewHolder;
            }
            throw new NullPointerException("ViewHolder returned from AdapterDelegate " + d16 + " for ViewType =" + i3 + " is null!");
        }
        throw new NullPointerException("No AdapterDelegate added for ViewType " + i3);
    }

    public void m(RecyclerView recyclerView) {
        this.f236204c = null;
        for (int i3 = 0; i3 < this.f236202a.size(); i3++) {
            b<T> bVar = this.f236202a.get(this.f236202a.keyAt(i3));
            if (bVar != null) {
                bVar.e(recyclerView);
            }
        }
    }

    public boolean n(@NonNull RecyclerView.ViewHolder viewHolder) {
        b<T> d16 = d(e(viewHolder));
        if (d16 != null) {
            if (this.f236206e) {
                QLog.i("AdapterDelegatesManager", 1, "onFailedToRecycleView put to pool, viewType: " + e(viewHolder) + " holder: " + System.identityHashCode(viewHolder));
            }
            return d16.f(viewHolder);
        }
        throw new NullPointerException("No delegate found for " + viewHolder + " for item at position = " + viewHolder.getAdapterPosition() + " for viewType = " + e(viewHolder));
    }

    public void o(@NonNull RecyclerView.ViewHolder viewHolder) {
        b<T> d16 = d(e(viewHolder));
        if (d16 != null) {
            d16.g(viewHolder);
            if (f236201h) {
                QLog.i("AdapterDelegatesManager", 1, "onViewAttachedToWindow viewType: " + e(viewHolder) + " holder: " + System.identityHashCode(viewHolder));
                return;
            }
            return;
        }
        throw new NullPointerException("No delegate found for " + viewHolder + " for item at position = " + viewHolder.getAdapterPosition() + " for viewType = " + e(viewHolder));
    }

    public void p(@NonNull RecyclerView.ViewHolder viewHolder) {
        b<T> d16 = d(e(viewHolder));
        if (d16 != null) {
            d16.h(viewHolder);
            if (f236201h) {
                QLog.i("AdapterDelegatesManager", 1, "onViewDetachedFromWindow viewType: " + e(viewHolder) + " holder: " + System.identityHashCode(viewHolder));
                return;
            }
            return;
        }
        throw new NullPointerException("No delegate found for " + viewHolder + " for item at position = " + viewHolder.getAdapterPosition() + " for viewType = " + e(viewHolder));
    }

    public void q(@NonNull RecyclerView.ViewHolder viewHolder) {
        int e16 = e(viewHolder);
        b<T> d16 = d(e16);
        if (d16 != null) {
            d16.i(viewHolder);
            if (this.f236206e) {
                try {
                    QLog.i("AdapterDelegatesManager", 1, System.identityHashCode(this) + " onViewRecycled put to pool, viewType: " + e16 + " holder: " + System.identityHashCode(viewHolder));
                    g(e16).release(viewHolder);
                    return;
                } catch (Exception e17) {
                    QLog.e("AdapterDelegatesManager", 1, "onViewRecycled put to pool, viewType: " + e16 + " holder: " + System.identityHashCode(viewHolder) + "\n", e17);
                    return;
                }
            }
            return;
        }
        throw new NullPointerException("No delegate found for " + viewHolder + " for item at position = " + viewHolder.getAdapterPosition() + " for viewType = " + e16);
    }

    public c<T> r(@Nullable b<T> bVar) {
        this.f236203b = bVar;
        return this;
    }
}
