package com.tencent.widget.pull2refresh;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.pull2refresh.BaseAdapter;
import com.tencent.widget.pull2refresh.BaseViewHolder;

/* compiled from: P */
/* loaded from: classes27.dex */
public abstract class HeaderAndFooterAdapter<M, VH extends BaseViewHolder<M>> extends RecyclerView.Adapter<BaseViewHolder<M>> {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "HeaderAndFooterAdapter";
    public static final int VIEW_TYPE_FOOTER = 1025;
    public static final int VIEW_TYPE_HEADER = 1024;
    protected Context context;
    protected View footerView;
    protected View headerView;
    protected BaseAdapter.OnItemClickListener mOnItemClickListener;
    protected BaseAdapter.OnItemLongClickListener mOnItemLongClickListener;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes27.dex */
    public class a implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ BaseViewHolder f384814d;

        a(BaseViewHolder baseViewHolder) {
            this.f384814d = baseViewHolder;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) HeaderAndFooterAdapter.this, (Object) baseViewHolder);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                int position = this.f384814d.getPosition();
                if (position >= 0) {
                    HeaderAndFooterAdapter.this.mOnItemClickListener.onItemClick(this.f384814d.itemView, position);
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes27.dex */
    public class b implements View.OnLongClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ BaseViewHolder f384816d;

        b(BaseViewHolder baseViewHolder) {
            this.f384816d = baseViewHolder;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) HeaderAndFooterAdapter.this, (Object) baseViewHolder);
            }
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            boolean z16;
            EventCollector.getInstance().onViewLongClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                z16 = ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) view)).booleanValue();
            } else {
                int position = this.f384816d.getPosition();
                if (position >= 0) {
                    HeaderAndFooterAdapter.this.mOnItemLongClickListener.onItemLongClick(this.f384816d.itemView, position);
                }
                z16 = true;
            }
            EventCollector.getInstance().onViewLongClicked(view);
            return z16;
        }
    }

    public HeaderAndFooterAdapter(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
        } else {
            this.context = context;
        }
    }

    public void addFooterView(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) view);
        } else if (view == null) {
            Log.w(TAG, "add the footer view is null");
        } else {
            this.footerView = view;
            notifyDataSetChanged();
        }
    }

    public void addHeaderView(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) view);
        } else if (view == null) {
            Log.w(TAG, "add the header view is null");
        } else {
            this.headerView = view;
            notifyDataSetChanged();
        }
    }

    public int getExtraViewCount() {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this)).intValue();
        }
        if (this.headerView != null) {
            i3 = 1;
        } else {
            i3 = 0;
        }
        if (this.footerView != null) {
            return i3 + 1;
        }
        return i3;
    }

    public int getFooterExtraViewCount() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Integer) iPatchRedirector.redirect((short) 12, (Object) this)).intValue();
        }
        if (this.footerView == null) {
            return 0;
        }
        return 1;
    }

    public int getHeaderExtraViewCount() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Integer) iPatchRedirector.redirect((short) 11, (Object) this)).intValue();
        }
        if (this.headerView == null) {
            return 0;
        }
        return 1;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public abstract long getItemId(int i3);

    public abstract void onBindCustomViewHolder(VH vh5, int i3);

    public abstract VH onCreateCustomViewHolder(ViewGroup viewGroup, int i3);

    public void removeFooterView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
        } else if (this.footerView != null) {
            this.footerView = null;
            notifyDataSetChanged();
        }
    }

    public void removeHeaderView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        } else if (this.headerView != null) {
            this.headerView = null;
            notifyDataSetChanged();
        }
    }

    public void setOnItemClickListener(BaseAdapter.OnItemClickListener onItemClickListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) onItemClickListener);
        } else {
            this.mOnItemClickListener = onItemClickListener;
        }
    }

    public void setOnItemLongClickListener(BaseAdapter.OnItemLongClickListener onItemLongClickListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) onItemLongClickListener);
        } else {
            this.mOnItemLongClickListener = onItemLongClickListener;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    public final void onBindViewHolder(BaseViewHolder baseViewHolder, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            int itemViewType = baseViewHolder.getItemViewType();
            if (itemViewType != 1024 && itemViewType != 1025) {
                onBindCustomViewHolder(baseViewHolder, i3);
            }
        } else {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) baseViewHolder, i3);
        }
        EventCollector.getInstance().onRecyclerBindViewHolder(baseViewHolder, i3, getItemId(i3));
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public final BaseViewHolder onCreateViewHolder(ViewGroup viewGroup, int i3) {
        BaseViewHolder onCreateCustomViewHolder;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (BaseViewHolder) iPatchRedirector.redirect((short) 2, (Object) this, (Object) viewGroup, i3);
        }
        if (i3 == 1024) {
            onCreateCustomViewHolder = new BaseViewHolder(this.headerView);
        } else if (i3 == 1025) {
            onCreateCustomViewHolder = new BaseViewHolder(this.footerView);
        } else {
            onCreateCustomViewHolder = onCreateCustomViewHolder(viewGroup, i3);
        }
        if (this.mOnItemClickListener != null) {
            onCreateCustomViewHolder.itemView.setOnClickListener(new a(onCreateCustomViewHolder));
        }
        if (this.mOnItemLongClickListener != null) {
            onCreateCustomViewHolder.itemView.setOnLongClickListener(new b(onCreateCustomViewHolder));
        }
        return onCreateCustomViewHolder;
    }
}
