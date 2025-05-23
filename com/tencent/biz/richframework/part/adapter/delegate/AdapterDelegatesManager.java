package com.tencent.biz.richframework.part.adapter.delegate;

import android.util.SparseIntArray;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.SparseArrayCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import java.util.Collections;
import java.util.List;

/* compiled from: P */
/* loaded from: classes5.dex */
public class AdapterDelegatesManager<T> {
    public static final int FALLBACK_DELEGATE_VIEW_TYPE = 2147483646;
    private static final List<Object> PAYLOADS_EMPTY_LIST = Collections.emptyList();
    private static final String TAG = "AdapterDelegatesManager";
    protected AdapterDelegate<T> fallbackDelegate;
    private final SparseIntArray viewTypeMap = new SparseIntArray();
    protected SparseArrayCompat<AdapterDelegate<T>> delegates = new SparseArrayCompat<>();

    public AdapterDelegatesManager() {
    }

    public AdapterDelegatesManager<T> addDelegate(@NonNull AdapterDelegate<T> adapterDelegate) {
        int size = this.delegates.size();
        while (this.delegates.get(size) != null) {
            size++;
            if (size == 2147483646) {
                throw new IllegalArgumentException("Oops, we are very close to Integer.MAX_VALUE. It seems that there are no more free and unused view type integers left to add another AdapterDelegate.");
            }
        }
        return addDelegate(size, false, adapterDelegate);
    }

    @Nullable
    public AdapterDelegate<T> getDelegateForViewType(int i3) {
        return this.delegates.get(i3, this.fallbackDelegate);
    }

    @Nullable
    public AdapterDelegate<T> getFallbackDelegate() {
        return this.fallbackDelegate;
    }

    protected int getInnerViewType(@NonNull RecyclerView.ViewHolder viewHolder) {
        return this.viewTypeMap.get(viewHolder.hashCode());
    }

    public int getItemViewType(@NonNull T t16, int i3) {
        String str;
        if (t16 != null) {
            int size = this.delegates.size();
            for (int i16 = 0; i16 < size; i16++) {
                if (this.delegates.valueAt(i16).isForViewType(t16, i3)) {
                    return this.delegates.keyAt(i16);
                }
            }
            if (this.fallbackDelegate != null) {
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

    public int getTotalDelegateCount() {
        int i3;
        int size = this.delegates.size();
        if (this.fallbackDelegate != null) {
            i3 = 1;
        } else {
            i3 = 0;
        }
        return size + i3;
    }

    public int getViewType(@NonNull AdapterDelegate<T> adapterDelegate) {
        if (adapterDelegate != null) {
            int indexOfValue = this.delegates.indexOfValue(adapterDelegate);
            if (indexOfValue == -1) {
                return -1;
            }
            return this.delegates.keyAt(indexOfValue);
        }
        throw new NullPointerException("Delegate is null");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onBindViewHolder(@NonNull T t16, int i3, @NonNull RecyclerView.ViewHolder viewHolder, List list) {
        AdapterDelegate<T> delegateForViewType = getDelegateForViewType(getInnerViewType(viewHolder));
        if (delegateForViewType != 0) {
            if (list == null) {
                list = PAYLOADS_EMPTY_LIST;
            }
            delegateForViewType.onBindViewHolder(t16, i3, viewHolder, list);
        } else {
            throw new NullPointerException("No delegate found for item at position = " + i3 + " for viewType = " + getInnerViewType(viewHolder));
        }
    }

    @NonNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i3) {
        AdapterDelegate<T> delegateForViewType = getDelegateForViewType(i3);
        if (delegateForViewType != null) {
            RecyclerView.ViewHolder onCreateViewHolder = delegateForViewType.onCreateViewHolder(viewGroup);
            if (onCreateViewHolder != null) {
                this.viewTypeMap.put(onCreateViewHolder.hashCode(), i3);
                try {
                    ViewGroup viewGroup2 = (ViewGroup) onCreateViewHolder.itemView.getParent();
                    if (viewGroup2 != null) {
                        viewGroup2.removeView(onCreateViewHolder.itemView);
                    }
                } catch (Exception e16) {
                    RFWLog.fatal(TAG, RFWLog.USR, e16);
                }
                return onCreateViewHolder;
            }
            throw new NullPointerException("ViewHolder returned from AdapterDelegate " + delegateForViewType + " for ViewType =" + i3 + " is null!");
        }
        throw new NullPointerException("No AdapterDelegate added for ViewType " + i3);
    }

    public boolean onFailedToRecycleView(@NonNull RecyclerView.ViewHolder viewHolder) {
        AdapterDelegate<T> delegateForViewType = getDelegateForViewType(getInnerViewType(viewHolder));
        if (delegateForViewType != null) {
            return delegateForViewType.onFailedToRecycleView(viewHolder);
        }
        throw new NullPointerException("No delegate found for " + viewHolder + " for item at position = " + viewHolder.getAdapterPosition() + " for viewType = " + getInnerViewType(viewHolder));
    }

    public void onViewAttachedToWindow(@NonNull RecyclerView.ViewHolder viewHolder) {
        AdapterDelegate<T> delegateForViewType = getDelegateForViewType(getInnerViewType(viewHolder));
        if (delegateForViewType != null) {
            delegateForViewType.onViewAttachedToWindow(viewHolder);
            return;
        }
        throw new NullPointerException("No delegate found for " + viewHolder + " for item at position = " + viewHolder.getAdapterPosition() + " for viewType = " + getInnerViewType(viewHolder));
    }

    public void onViewDetachedFromWindow(@NonNull RecyclerView.ViewHolder viewHolder) {
        AdapterDelegate<T> delegateForViewType = getDelegateForViewType(getInnerViewType(viewHolder));
        if (delegateForViewType != null) {
            delegateForViewType.onViewDetachedFromWindow(viewHolder);
            return;
        }
        throw new NullPointerException("No delegate found for " + viewHolder + " for item at position = " + viewHolder.getAdapterPosition() + " for viewType = " + getInnerViewType(viewHolder));
    }

    public void onViewRecycled(@NonNull RecyclerView.ViewHolder viewHolder) {
        AdapterDelegate<T> delegateForViewType = getDelegateForViewType(getInnerViewType(viewHolder));
        if (delegateForViewType != null) {
            delegateForViewType.onViewRecycled(viewHolder);
            return;
        }
        throw new NullPointerException("No delegate found for " + viewHolder + " for item at position = " + viewHolder.getAdapterPosition() + " for viewType = " + getInnerViewType(viewHolder));
    }

    public AdapterDelegatesManager<T> removeDelegate(@NonNull AdapterDelegate<T> adapterDelegate) {
        if (adapterDelegate != null) {
            int indexOfValue = this.delegates.indexOfValue(adapterDelegate);
            if (indexOfValue >= 0) {
                this.delegates.removeAt(indexOfValue);
            }
            return this;
        }
        throw new NullPointerException("AdapterDelegate is null");
    }

    public AdapterDelegatesManager<T> setFallbackDelegate(@Nullable AdapterDelegate<T> adapterDelegate) {
        this.fallbackDelegate = adapterDelegate;
        return this;
    }

    public AdapterDelegatesManager(@NonNull AdapterDelegate<T>... adapterDelegateArr) {
        for (AdapterDelegate<T> adapterDelegate : adapterDelegateArr) {
            addDelegate(adapterDelegate);
        }
    }

    public AdapterDelegatesManager<T> removeDelegate(int i3) {
        this.delegates.remove(i3);
        return this;
    }

    public AdapterDelegatesManager<T> addDelegate(int i3, @NonNull AdapterDelegate<T> adapterDelegate) {
        return addDelegate(i3, false, adapterDelegate);
    }

    public AdapterDelegatesManager<T> addDelegate(int i3, boolean z16, @NonNull AdapterDelegate<T> adapterDelegate) {
        if (adapterDelegate == null) {
            throw new NullPointerException("AdapterDelegate is null!");
        }
        if (i3 != 2147483646) {
            if (!z16 && this.delegates.get(i3) != null) {
                throw new IllegalArgumentException("An AdapterDelegate is already registered for the viewType = " + i3 + ". Already registered AdapterDelegate is " + this.delegates.get(i3));
            }
            this.delegates.put(i3, adapterDelegate);
            return this;
        }
        throw new IllegalArgumentException("The view type = 2147483646 is reserved for fallback adapter delegate (see setFallbackDelegate() ). Please use another view type.");
    }

    public void onBindViewHolder(@NonNull T t16, int i3, @NonNull RecyclerView.ViewHolder viewHolder) {
        onBindViewHolder(t16, i3, viewHolder, PAYLOADS_EMPTY_LIST);
    }
}
