package com.tencent.widget;

import android.database.DataSetObserver;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ListAdapter;
import android.widget.WrapperListAdapter;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ListView;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes27.dex */
public class HeaderViewListAdapter implements WrapperListAdapter, Filterable {
    static IPatchRedirector $redirector_;
    static final ArrayList<ListView.FixedViewInfo> EMPTY_INFO_LIST;
    private final ListAdapter mAdapter;
    boolean mAreAllFixedViewsSelectable;
    ArrayList<ListView.FixedViewInfo> mFooterViewInfos;
    ArrayList<ListView.FixedViewInfo> mHeaderViewInfos;
    private final boolean mIsFilterable;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(40269);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 21)) {
            redirector.redirect((short) 21);
        } else {
            EMPTY_INFO_LIST = new ArrayList<>();
        }
    }

    public HeaderViewListAdapter(ArrayList<ListView.FixedViewInfo> arrayList, ArrayList<ListView.FixedViewInfo> arrayList2, ListAdapter listAdapter) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, arrayList, arrayList2, listAdapter);
            return;
        }
        this.mAdapter = listAdapter;
        this.mIsFilterable = listAdapter instanceof Filterable;
        if (arrayList == null) {
            this.mHeaderViewInfos = EMPTY_INFO_LIST;
        } else {
            this.mHeaderViewInfos = arrayList;
        }
        if (arrayList2 == null) {
            this.mFooterViewInfos = EMPTY_INFO_LIST;
        } else {
            this.mFooterViewInfos = arrayList2;
        }
        this.mAreAllFixedViewsSelectable = areAllListInfosSelectable(this.mHeaderViewInfos) && areAllListInfosSelectable(this.mFooterViewInfos);
    }

    private boolean areAllListInfosSelectable(ArrayList<ListView.FixedViewInfo> arrayList) {
        if (arrayList != null) {
            Iterator<ListView.FixedViewInfo> it = arrayList.iterator();
            while (it.hasNext()) {
                if (!it.next().isSelectable) {
                    return false;
                }
            }
            return true;
        }
        return true;
    }

    @Override // android.widget.ListAdapter
    public boolean areAllItemsEnabled() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this)).booleanValue();
        }
        ListAdapter listAdapter = this.mAdapter;
        if (listAdapter == null) {
            return true;
        }
        if (this.mAreAllFixedViewsSelectable && listAdapter.areAllItemsEnabled()) {
            return true;
        }
        return false;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this)).intValue();
        }
        if (this.mAdapter != null) {
            return getFootersCount() + getHeadersCount() + this.mAdapter.getCount();
        }
        return getFootersCount() + getHeadersCount();
    }

    @Override // android.widget.Filterable
    public Filter getFilter() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return (Filter) iPatchRedirector.redirect((short) 19, (Object) this);
        }
        if (this.mIsFilterable) {
            return ((Filterable) this.mAdapter).getFilter();
        }
        return null;
    }

    public View getFooterItemView(int i3) {
        ListView.FixedViewInfo fixedViewInfo;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (View) iPatchRedirector.redirect((short) 7, (Object) this, i3);
        }
        ArrayList<ListView.FixedViewInfo> arrayList = this.mFooterViewInfos;
        if (arrayList == null || i3 >= arrayList.size() || (fixedViewInfo = this.mFooterViewInfos.get(i3)) == null) {
            return null;
        }
        return fixedViewInfo.view;
    }

    public int getFootersCount() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return this.mFooterViewInfos.size();
    }

    public int getHeadersCount() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return this.mHeaderViewInfos.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i3) {
        int i16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return iPatchRedirector.redirect((short) 11, (Object) this, i3);
        }
        int headersCount = getHeadersCount();
        if (i3 < headersCount) {
            return this.mHeaderViewInfos.get(i3).data;
        }
        int i17 = i3 - headersCount;
        ListAdapter listAdapter = this.mAdapter;
        if (listAdapter != null) {
            i16 = listAdapter.getCount();
            if (i17 < i16) {
                return this.mAdapter.getItem(i17);
            }
        } else {
            i16 = 0;
        }
        return this.mFooterViewInfos.get(i17 - i16).data;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i3) {
        int i16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Long) iPatchRedirector.redirect((short) 12, (Object) this, i3)).longValue();
        }
        int headersCount = getHeadersCount();
        ListAdapter listAdapter = this.mAdapter;
        if (listAdapter != null && i3 >= headersCount && (i16 = i3 - headersCount) < listAdapter.getCount()) {
            return this.mAdapter.getItemId(i16);
        }
        return -1L;
    }

    @Override // android.widget.Adapter
    public int getItemViewType(int i3) {
        int i16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Integer) iPatchRedirector.redirect((short) 15, (Object) this, i3)).intValue();
        }
        int headersCount = getHeadersCount();
        ListAdapter listAdapter = this.mAdapter;
        if (listAdapter != null && i3 >= headersCount && (i16 = i3 - headersCount) < listAdapter.getCount()) {
            return this.mAdapter.getItemViewType(i16);
        }
        return -2;
    }

    @Override // android.widget.Adapter
    public View getView(int i3, View view, ViewGroup viewGroup) {
        View view2;
        IPatchRedirector iPatchRedirector = $redirector_;
        int i16 = 0;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            view2 = (View) iPatchRedirector.redirect((short) 14, this, Integer.valueOf(i3), view, viewGroup);
        } else {
            int headersCount = getHeadersCount();
            if (i3 < headersCount) {
                view2 = this.mHeaderViewInfos.get(i3).view;
            } else {
                int i17 = i3 - headersCount;
                ListAdapter listAdapter = this.mAdapter;
                if (listAdapter != null && i17 < (i16 = listAdapter.getCount())) {
                    view2 = this.mAdapter.getView(i17, view, viewGroup);
                } else {
                    try {
                        view2 = this.mFooterViewInfos.get(i17 - i16).view;
                    } catch (Exception unused) {
                        QLog.d("HeaderViewListAdapter", 1, "adapter index out of bound. adapter count: " + i16 + ", footCount: " + this.mFooterViewInfos.size() + ", numHeaders:" + headersCount + " , position: " + i17 + ", Adapter: " + this.mAdapter);
                        view2 = null;
                    }
                }
            }
        }
        EventCollector.getInstance().onListGetView(i3, view, viewGroup, getItemId(i3));
        return view2;
    }

    @Override // android.widget.Adapter
    public int getViewTypeCount() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Integer) iPatchRedirector.redirect((short) 16, (Object) this)).intValue();
        }
        ListAdapter listAdapter = this.mAdapter;
        if (listAdapter != null) {
            return listAdapter.getViewTypeCount();
        }
        return 1;
    }

    @Override // android.widget.WrapperListAdapter
    public ListAdapter getWrappedAdapter() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return (ListAdapter) iPatchRedirector.redirect((short) 20, (Object) this);
        }
        return this.mAdapter;
    }

    @Override // android.widget.Adapter
    public boolean hasStableIds() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Boolean) iPatchRedirector.redirect((short) 13, (Object) this)).booleanValue();
        }
        ListAdapter listAdapter = this.mAdapter;
        if (listAdapter != null) {
            return listAdapter.hasStableIds();
        }
        return false;
    }

    @Override // android.widget.Adapter
    public boolean isEmpty() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        ListAdapter listAdapter = this.mAdapter;
        if (listAdapter != null && !listAdapter.isEmpty()) {
            return false;
        }
        return true;
    }

    @Override // android.widget.ListAdapter
    public boolean isEnabled(int i3) {
        int i16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this, i3)).booleanValue();
        }
        int headersCount = getHeadersCount();
        if (i3 < headersCount) {
            return this.mHeaderViewInfos.get(i3).isSelectable;
        }
        int i17 = i3 - headersCount;
        ListAdapter listAdapter = this.mAdapter;
        if (listAdapter != null) {
            i16 = listAdapter.getCount();
            if (i17 < i16) {
                return this.mAdapter.isEnabled(i17);
            }
        } else {
            i16 = 0;
        }
        try {
            int i18 = i17 - i16;
            if (this.mFooterViewInfos.size() <= i18) {
                QLog.e("HeaderViewListAdapter", 1, "adapter index out of bound. adapter count: " + i16 + ", footCount: " + this.mFooterViewInfos.size() + " , adjPosition: " + i17 + ", Adapter: " + this.mAdapter + "position=" + i3 + "numHeaders=" + headersCount);
                return false;
            }
            return this.mFooterViewInfos.get(i18).isSelectable;
        } catch (Exception unused) {
            QLog.d("HeaderViewListAdapter", 1, "adapter index out of bound. adapter count: " + i16 + ", footCount: " + this.mFooterViewInfos.size() + " , position: " + i17 + ", Adapter: " + this.mAdapter);
            return false;
        }
    }

    @Override // android.widget.Adapter
    public void registerDataSetObserver(DataSetObserver dataSetObserver) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) dataSetObserver);
            return;
        }
        ListAdapter listAdapter = this.mAdapter;
        if (listAdapter != null && dataSetObserver != null) {
            listAdapter.registerDataSetObserver(dataSetObserver);
        }
    }

    public boolean removeFooter(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this, (Object) view)).booleanValue();
        }
        boolean z16 = false;
        for (int i3 = 0; i3 < this.mFooterViewInfos.size(); i3++) {
            if (this.mFooterViewInfos.get(i3).view == view) {
                this.mFooterViewInfos.remove(i3);
                if (areAllListInfosSelectable(this.mHeaderViewInfos) && areAllListInfosSelectable(this.mFooterViewInfos)) {
                    z16 = true;
                }
                this.mAreAllFixedViewsSelectable = z16;
                return true;
            }
        }
        return false;
    }

    public boolean removeHeader(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, (Object) view)).booleanValue();
        }
        boolean z16 = false;
        for (int i3 = 0; i3 < this.mHeaderViewInfos.size(); i3++) {
            if (this.mHeaderViewInfos.get(i3).view == view) {
                this.mHeaderViewInfos.remove(i3);
                if (areAllListInfosSelectable(this.mHeaderViewInfos) && areAllListInfosSelectable(this.mFooterViewInfos)) {
                    z16 = true;
                }
                this.mAreAllFixedViewsSelectable = z16;
                return true;
            }
        }
        return false;
    }

    @Override // android.widget.Adapter
    public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, (Object) dataSetObserver);
            return;
        }
        ListAdapter listAdapter = this.mAdapter;
        if (listAdapter != null && dataSetObserver != null) {
            listAdapter.unregisterDataSetObserver(dataSetObserver);
        }
    }
}
