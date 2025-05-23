package com.tencent.widget.pull2refresh;

import android.content.Context;
import android.view.View;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.widget.pull2refresh.BaseViewHolder;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes27.dex */
public abstract class BaseAdapter<M, VH extends BaseViewHolder<M>> extends HeaderAndFooterAdapter<M, VH> {
    static IPatchRedirector $redirector_;
    private List<M> dataList;

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public interface OnItemClickListener {
        void onItemClick(View view, int i3);
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public interface OnItemLongClickListener {
        void onItemLongClick(View view, int i3);
    }

    public BaseAdapter(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            this.dataList = new ArrayList();
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
        }
    }

    public boolean appendItem(M m3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, (Object) m3)).booleanValue();
        }
        boolean add = this.dataList.add(m3);
        if (add) {
            if (getHeaderExtraViewCount() == 0) {
                notifyItemInserted(this.dataList.size() - 1);
            } else {
                notifyItemInserted(this.dataList.size());
            }
        }
        return add;
    }

    public boolean appendList(List<M> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this, (Object) list)).booleanValue();
        }
        boolean addAll = this.dataList.addAll(list);
        if (addAll) {
            notifyItemRangeInserted(this.dataList.size() - list.size(), list.size());
        }
        return addAll;
    }

    public void clearList() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            this.dataList.clear();
            notifyDataSetChanged();
        }
    }

    public boolean fillList(List<M> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) list)).booleanValue();
        }
        boolean z16 = !this.dataList.isEmpty();
        this.dataList.clear();
        boolean addAll = this.dataList.addAll(list) | z16;
        if (addAll) {
            notifyDataSetChanged();
        }
        return addAll;
    }

    public int getCustomItemCount() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Integer) iPatchRedirector.redirect((short) 12, (Object) this)).intValue();
        }
        return this.dataList.size();
    }

    public int getCustomItemPos(int i3) {
        int i16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Integer) iPatchRedirector.redirect((short) 13, (Object) this, i3)).intValue();
        }
        if (this.headerView == null) {
            i16 = 0;
        } else {
            i16 = 1;
        }
        return i3 - i16;
    }

    public abstract int getCustomItemViewType(int i3);

    public List<M> getDataList() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return (List) iPatchRedirector.redirect((short) 21, (Object) this);
        }
        return this.dataList;
    }

    public M getItem(int i3) {
        List<M> list;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (M) iPatchRedirector.redirect((short) 14, (Object) this, i3);
        }
        if ((this.headerView != null && i3 == 0) || i3 >= this.dataList.size() + getHeaderExtraViewCount()) {
            return null;
        }
        if (this.headerView == null) {
            list = this.dataList;
        } else {
            list = this.dataList;
            i3--;
        }
        return list.get(i3);
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Integer) iPatchRedirector.redirect((short) 11, (Object) this)).intValue();
        }
        return this.dataList.size() + getExtraViewCount();
    }

    @Override // com.tencent.widget.pull2refresh.HeaderAndFooterAdapter, android.support.v7.widget.RecyclerView.Adapter
    public long getItemId(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Long) iPatchRedirector.redirect((short) 9, (Object) this, i3)).longValue();
        }
        return i3;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public final int getItemViewType(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this, i3)).intValue();
        }
        if (this.headerView != null && i3 == 0) {
            return 1024;
        }
        if (this.footerView != null && i3 == this.dataList.size() + getHeaderExtraViewCount()) {
            return 1025;
        }
        return getCustomItemViewType(i3);
    }

    public void insertOrReplaceItem(M m3, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) m3, i3);
            return;
        }
        int indexOf = this.dataList.indexOf(m3);
        if (indexOf != -1) {
            this.dataList.remove(indexOf);
        }
        this.dataList.add(i3, m3);
        if (indexOf != -1) {
            if (this.headerView == null) {
                notifyItemMoved(indexOf, i3);
                notifyItemChanged(i3);
                return;
            } else {
                int i16 = i3 + 1;
                notifyItemMoved(indexOf + 1, i16);
                notifyItemChanged(i16);
                return;
            }
        }
        if (this.headerView == null) {
            notifyItemInserted(i3);
        } else {
            notifyItemInserted(i3 + 1);
        }
    }

    public boolean isEmpty() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return ((Boolean) iPatchRedirector.redirect((short) 20, (Object) this)).booleanValue();
        }
        List<M> list = this.dataList;
        if (list != null && !list.isEmpty()) {
            return false;
        }
        return true;
    }

    public void prependItem(M m3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) m3);
            return;
        }
        this.dataList.add(0, m3);
        if (getHeaderExtraViewCount() == 0) {
            notifyItemInserted(0);
        } else {
            notifyItemInserted(getHeaderExtraViewCount());
        }
    }

    public void prependList(List<M> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) list);
        } else {
            this.dataList.addAll(0, list);
            notifyDataSetChanged();
        }
    }

    public void removeItem(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, i3);
            return;
        }
        this.dataList.remove(i3);
        if (this.headerView != null) {
            i3++;
        }
        notifyItemRemoved(i3);
    }

    public int updateItem(M m3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Integer) iPatchRedirector.redirect((short) 16, (Object) this, (Object) m3)).intValue();
        }
        int indexOf = this.dataList.indexOf(m3);
        if (indexOf < 0) {
            return indexOf;
        }
        this.dataList.set(indexOf, m3);
        if (this.headerView == null) {
            notifyItemChanged(indexOf);
        } else {
            notifyItemChanged(indexOf + 1);
        }
        return indexOf;
    }

    public BaseAdapter(Context context, List<M> list) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) list);
            return;
        }
        ArrayList arrayList = new ArrayList();
        this.dataList = arrayList;
        arrayList.addAll(list);
    }

    public void removeItem(M m3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, (Object) m3);
            return;
        }
        int indexOf = this.dataList.indexOf(m3);
        if (indexOf < 0) {
            return;
        }
        this.dataList.remove(indexOf);
        if (this.headerView == null) {
            notifyItemRemoved(indexOf);
        } else {
            notifyItemRemoved(indexOf + 1);
        }
    }

    public M getItem(VH vh5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 15)) ? getItem(vh5.getPosition()) : (M) iPatchRedirector.redirect((short) 15, (Object) this, (Object) vh5);
    }
}
