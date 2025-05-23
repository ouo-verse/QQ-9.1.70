package com.tencent.widget.pull2refresh;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes27.dex */
public class RecyclerViewHeaderViewAdapter<T extends RecyclerView.Adapter> extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    static IPatchRedirector $redirector_ = null;
    private static final int FOOTER_VIEW_TYPE = -2000;
    private static final int HEADER_VIEW_TYPE = -1000;
    private ContentDataObserver contentDataObserver;
    private final T mBase;
    private final List<View> mFooters;
    private final List<View> mHeaders;
    private OnBindHeaderObserver mOnBindHeaderObserver;

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public interface ContentDataObserver {
        void contentDataChange(RecyclerView.Adapter adapter);
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public interface OnBindHeaderObserver {
        void onBindHeader(RecyclerView.ViewHolder viewHolder, int i3);
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    class b extends RecyclerView.ViewHolder {
        static IPatchRedirector $redirector_;

        b(View view) {
            super(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) RecyclerViewHeaderViewAdapter.this, (Object) view);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    class c extends RecyclerView.ViewHolder {
        static IPatchRedirector $redirector_;

        c(View view) {
            super(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) RecyclerViewHeaderViewAdapter.this, (Object) view);
            }
        }
    }

    public RecyclerViewHeaderViewAdapter(T t16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) t16);
            return;
        }
        this.mHeaders = new ArrayList();
        this.mFooters = new ArrayList();
        this.mBase = t16;
        t16.registerAdapterDataObserver(new a());
    }

    public void addFooter(@NonNull View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) view);
        } else {
            this.mFooters.add(view);
        }
    }

    public void addHeader(@NonNull View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) view);
        } else {
            this.mHeaders.add(view);
        }
    }

    public ContentDataObserver getContentDataObserver() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return (ContentDataObserver) iPatchRedirector.redirect((short) 1, (Object) this);
        }
        return this.contentDataObserver;
    }

    public View getFooter(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (View) iPatchRedirector.redirect((short) 15, (Object) this, i3);
        }
        if (i3 < this.mFooters.size()) {
            return this.mFooters.get(i3);
        }
        return null;
    }

    public int getFooterCount() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Integer) iPatchRedirector.redirect((short) 13, (Object) this)).intValue();
        }
        return this.mFooters.size();
    }

    public View getHeader(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (View) iPatchRedirector.redirect((short) 14, (Object) this, i3);
        }
        if (i3 < this.mHeaders.size()) {
            return this.mHeaders.get(i3);
        }
        return null;
    }

    public int getHeaderCount() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Integer) iPatchRedirector.redirect((short) 12, (Object) this)).intValue();
        }
        return this.mHeaders.size();
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return ((Integer) iPatchRedirector.redirect((short) 24, (Object) this)).intValue();
        }
        return this.mHeaders.size() + this.mBase.getItemCount() + this.mFooters.size();
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public long getItemId(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            return ((Long) iPatchRedirector.redirect((short) 27, (Object) this, i3)).longValue();
        }
        if (i3 < this.mHeaders.size()) {
            return this.mHeaders.get(i3).hashCode();
        }
        if (i3 < this.mHeaders.size() + this.mBase.getItemCount()) {
            return this.mBase.getItemId(i3 - this.mHeaders.size());
        }
        return this.mFooters.get((i3 - this.mHeaders.size()) - this.mBase.getItemCount()).hashCode();
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemViewType(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            return ((Integer) iPatchRedirector.redirect((short) 25, (Object) this, i3)).intValue();
        }
        if (i3 < this.mHeaders.size()) {
            return i3 - 1000;
        }
        if (i3 < this.mHeaders.size() + this.mBase.getItemCount()) {
            return this.mBase.getItemViewType(i3 - this.mHeaders.size());
        }
        return ((i3 - 2000) - this.mHeaders.size()) - this.mBase.getItemCount();
    }

    public T getWrappedAdapter() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (T) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.mBase;
    }

    public boolean hasHeader(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this, (Object) view)).booleanValue();
        }
        return this.mHeaders.contains(view);
    }

    public boolean isFooter(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return ((Boolean) iPatchRedirector.redirect((short) 19, (Object) this, i3)).booleanValue();
        }
        if (i3 >= -2000 && i3 < this.mFooters.size() - 2000) {
            return true;
        }
        return false;
    }

    public boolean isFooterPosition(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Boolean) iPatchRedirector.redirect((short) 17, (Object) this, i3)).booleanValue();
        }
        if (i3 >= getItemCount() - this.mFooters.size()) {
            return true;
        }
        return false;
    }

    public boolean isHeader(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return ((Boolean) iPatchRedirector.redirect((short) 18, (Object) this, i3)).booleanValue();
        }
        if (i3 >= -1000 && i3 < this.mHeaders.size() - 1000) {
            return true;
        }
        return false;
    }

    public boolean isHeaderPosition(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Boolean) iPatchRedirector.redirect((short) 16, (Object) this, i3)).booleanValue();
        }
        if (i3 < this.mHeaders.size()) {
            return true;
        }
        return false;
    }

    protected void onBindHeader(RecyclerView.ViewHolder viewHolder, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this, (Object) viewHolder, i3);
            return;
        }
        OnBindHeaderObserver onBindHeaderObserver = this.mOnBindHeaderObserver;
        if (onBindHeaderObserver != null) {
            onBindHeaderObserver.onBindHeader(viewHolder, i3);
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i3, List<Object> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, this, viewHolder, Integer.valueOf(i3), list);
        } else if (i3 < this.mHeaders.size()) {
            super.onBindViewHolder(viewHolder, i3, list);
        } else if (i3 < this.mHeaders.size() + this.mBase.getItemCount()) {
            this.mBase.onBindViewHolder(viewHolder, i3 - this.mHeaders.size(), list);
        } else {
            super.onBindViewHolder(viewHolder, i3, list);
        }
        EventCollector.getInstance().onRecyclerBindViewHolder(viewHolder, i3, list, getItemId(i3));
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return (RecyclerView.ViewHolder) iPatchRedirector.redirect((short) 20, (Object) this, (Object) viewGroup, i3);
        }
        if (isHeader(i3)) {
            return new b(this.mHeaders.get(Math.abs(i3 + 1000)));
        }
        if (isFooter(i3)) {
            return new c(this.mFooters.get(Math.abs(i3 + 2000)));
        }
        return this.mBase.onCreateViewHolder(viewGroup, i3);
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public void onViewAttachedToWindow(RecyclerView.ViewHolder viewHolder) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, (Object) this, (Object) viewHolder);
            return;
        }
        super.onViewAttachedToWindow(viewHolder);
        T t16 = this.mBase;
        if (t16 != null && (viewHolder instanceof BaseViewHolder)) {
            t16.onViewAttachedToWindow(viewHolder);
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public void onViewDetachedFromWindow(RecyclerView.ViewHolder viewHolder) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, (Object) this, (Object) viewHolder);
            return;
        }
        super.onViewDetachedFromWindow(viewHolder);
        T t16 = this.mBase;
        if (t16 != null && (viewHolder instanceof BaseViewHolder)) {
            t16.onViewDetachedFromWindow(viewHolder);
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this, (Object) viewHolder);
            return;
        }
        super.onViewRecycled(viewHolder);
        T t16 = this.mBase;
        if (t16 != null && (viewHolder instanceof BaseViewHolder)) {
            t16.onViewRecycled(viewHolder);
        }
    }

    public void removeHeader(@NonNull View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) view);
        } else {
            this.mHeaders.remove(view);
        }
    }

    public RecyclerViewHeaderViewAdapter setContentDataObserver(ContentDataObserver contentDataObserver) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (RecyclerViewHeaderViewAdapter) iPatchRedirector.redirect((short) 2, (Object) this, (Object) contentDataObserver);
        }
        this.contentDataObserver = contentDataObserver;
        return this;
    }

    public void setFooterVisibility(boolean z16) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, z16);
            return;
        }
        for (View view : this.mFooters) {
            if (z16) {
                i3 = 0;
            } else {
                i3 = 8;
            }
            view.setVisibility(i3);
        }
    }

    public void setHeaderVisibility(boolean z16) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, z16);
            return;
        }
        for (View view : this.mHeaders) {
            if (z16) {
                i3 = 0;
            } else {
                i3 = 8;
            }
            view.setVisibility(i3);
        }
    }

    public void setOnBindHeaderObserver(OnBindHeaderObserver onBindHeaderObserver) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) onBindHeaderObserver);
        } else {
            this.mOnBindHeaderObserver = onBindHeaderObserver;
        }
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    class a extends RecyclerView.AdapterDataObserver {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) RecyclerViewHeaderViewAdapter.this);
            }
        }

        @Override // android.support.v7.widget.RecyclerView.AdapterDataObserver
        public void onChanged() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            RecyclerViewHeaderViewAdapter.this.notifyDataSetChanged();
            if (RecyclerViewHeaderViewAdapter.this.contentDataObserver != null) {
                RecyclerViewHeaderViewAdapter.this.contentDataObserver.contentDataChange(RecyclerViewHeaderViewAdapter.this.mBase);
            }
        }

        @Override // android.support.v7.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeChanged(int i3, int i16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, Integer.valueOf(i3), Integer.valueOf(i16));
                return;
            }
            RecyclerViewHeaderViewAdapter recyclerViewHeaderViewAdapter = RecyclerViewHeaderViewAdapter.this;
            recyclerViewHeaderViewAdapter.notifyItemRangeChanged(i3 + recyclerViewHeaderViewAdapter.mHeaders.size(), i16);
            if (RecyclerViewHeaderViewAdapter.this.contentDataObserver != null) {
                RecyclerViewHeaderViewAdapter.this.contentDataObserver.contentDataChange(RecyclerViewHeaderViewAdapter.this.mBase);
            }
        }

        @Override // android.support.v7.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeInserted(int i3, int i16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, this, Integer.valueOf(i3), Integer.valueOf(i16));
                return;
            }
            RecyclerViewHeaderViewAdapter recyclerViewHeaderViewAdapter = RecyclerViewHeaderViewAdapter.this;
            recyclerViewHeaderViewAdapter.notifyItemRangeInserted(i3 + recyclerViewHeaderViewAdapter.mHeaders.size(), i16);
            if (RecyclerViewHeaderViewAdapter.this.contentDataObserver != null) {
                RecyclerViewHeaderViewAdapter.this.contentDataObserver.contentDataChange(RecyclerViewHeaderViewAdapter.this.mBase);
            }
        }

        @Override // android.support.v7.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeMoved(int i3, int i16, int i17) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
                return;
            }
            RecyclerViewHeaderViewAdapter recyclerViewHeaderViewAdapter = RecyclerViewHeaderViewAdapter.this;
            recyclerViewHeaderViewAdapter.notifyItemMoved(i3 + recyclerViewHeaderViewAdapter.mHeaders.size(), i16 + RecyclerViewHeaderViewAdapter.this.mHeaders.size());
            if (RecyclerViewHeaderViewAdapter.this.contentDataObserver != null) {
                RecyclerViewHeaderViewAdapter.this.contentDataObserver.contentDataChange(RecyclerViewHeaderViewAdapter.this.mBase);
            }
        }

        @Override // android.support.v7.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeRemoved(int i3, int i16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, this, Integer.valueOf(i3), Integer.valueOf(i16));
                return;
            }
            RecyclerViewHeaderViewAdapter recyclerViewHeaderViewAdapter = RecyclerViewHeaderViewAdapter.this;
            recyclerViewHeaderViewAdapter.notifyItemRangeRemoved(i3 + recyclerViewHeaderViewAdapter.mHeaders.size(), i16);
            if (RecyclerViewHeaderViewAdapter.this.contentDataObserver != null) {
                RecyclerViewHeaderViewAdapter.this.contentDataObserver.contentDataChange(RecyclerViewHeaderViewAdapter.this.mBase);
            }
        }

        @Override // android.support.v7.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeChanged(int i3, int i16, Object obj) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, this, Integer.valueOf(i3), Integer.valueOf(i16), obj);
                return;
            }
            RecyclerViewHeaderViewAdapter recyclerViewHeaderViewAdapter = RecyclerViewHeaderViewAdapter.this;
            recyclerViewHeaderViewAdapter.notifyItemRangeChanged(i3 + recyclerViewHeaderViewAdapter.mHeaders.size(), i16, obj);
            if (RecyclerViewHeaderViewAdapter.this.contentDataObserver != null) {
                RecyclerViewHeaderViewAdapter.this.contentDataObserver.contentDataChange(RecyclerViewHeaderViewAdapter.this.mBase);
            }
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i3) {
        StaggeredGridLayoutManager.LayoutParams layoutParams;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 23)) {
            if (i3 < this.mHeaders.size()) {
                layoutParams = StaggeredGridLayoutManager.LayoutParams.class.isInstance(viewHolder.itemView.getLayoutParams()) ? (StaggeredGridLayoutManager.LayoutParams) viewHolder.itemView.getLayoutParams() : null;
                if (layoutParams == null) {
                    layoutParams = new StaggeredGridLayoutManager.LayoutParams(-1, -2);
                    viewHolder.itemView.setLayoutParams(layoutParams);
                }
                layoutParams.setFullSpan(true);
                onBindHeader(viewHolder, i3);
            } else if (i3 < this.mHeaders.size() + this.mBase.getItemCount()) {
                this.mBase.onBindViewHolder(viewHolder, i3 - this.mHeaders.size());
            } else {
                layoutParams = StaggeredGridLayoutManager.LayoutParams.class.isInstance(viewHolder.itemView.getLayoutParams()) ? (StaggeredGridLayoutManager.LayoutParams) viewHolder.itemView.getLayoutParams() : null;
                if (layoutParams == null) {
                    layoutParams = new StaggeredGridLayoutManager.LayoutParams(-1, -2);
                    viewHolder.itemView.setLayoutParams(layoutParams);
                }
                layoutParams.setFullSpan(true);
            }
        } else {
            iPatchRedirector.redirect((short) 23, (Object) this, (Object) viewHolder, i3);
        }
        EventCollector.getInstance().onRecyclerBindViewHolder(viewHolder, i3, getItemId(i3));
    }
}
