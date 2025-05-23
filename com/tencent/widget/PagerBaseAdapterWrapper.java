package com.tencent.widget;

import android.database.DataSetObserver;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

/* loaded from: classes27.dex */
public class PagerBaseAdapterWrapper extends BaseAdapter {
    static IPatchRedirector $redirector_;
    private int mPage;
    private int mPageItemNum;
    private BaseAdapter mWrapperAdapter;

    /* loaded from: classes27.dex */
    class a extends DataSetObserver {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) PagerBaseAdapterWrapper.this);
            }
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                PagerBaseAdapterWrapper.this.notifyDataSetChanged();
            }
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
            } else {
                PagerBaseAdapterWrapper.this.notifyDataSetInvalidated();
            }
        }
    }

    public PagerBaseAdapterWrapper(BaseAdapter baseAdapter, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) baseAdapter, i3);
            return;
        }
        this.mPageItemNum = 1;
        this.mWrapperAdapter = baseAdapter;
        this.mPageItemNum = i3 <= 0 ? 1 : i3;
        if (baseAdapter != null) {
            baseAdapter.registerDataSetObserver(new a());
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
        }
        int count = this.mWrapperAdapter.getCount();
        int i3 = this.mPage + 1;
        int i16 = this.mPageItemNum;
        if (i3 * i16 > count) {
            return count % i16;
        }
        return i16;
    }

    public int getCurrentPage() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        return this.mPage;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return iPatchRedirector.redirect((short) 8, (Object) this, i3);
        }
        return this.mWrapperAdapter.getItem((this.mPage * this.mPageItemNum) + i3);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Long) iPatchRedirector.redirect((short) 9, (Object) this, i3)).longValue();
        }
        return this.mWrapperAdapter.getItemId((this.mPage * this.mPageItemNum) + i3);
    }

    public int getMaxPageNum() {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        int count = this.mWrapperAdapter.getCount();
        int i16 = this.mPageItemNum;
        int i17 = count / i16;
        if (count % i16 != 0) {
            i3 = 1;
        } else {
            i3 = 0;
        }
        return i17 + i3;
    }

    public int getPageItemNum() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return this.mPageItemNum;
    }

    @Override // android.widget.Adapter
    public View getView(int i3, View view, ViewGroup viewGroup) {
        View view2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            view2 = (View) iPatchRedirector.redirect((short) 10, this, Integer.valueOf(i3), view, viewGroup);
        } else {
            view2 = this.mWrapperAdapter.getView((this.mPage * this.mPageItemNum) + i3, view, viewGroup);
        }
        EventCollector.getInstance().onListGetView(i3, view, viewGroup, getItemId(i3));
        return view2;
    }

    public BaseAdapter getWrapperAdapter() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (BaseAdapter) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.mWrapperAdapter;
    }

    public void setCurrentPage(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, i3);
            return;
        }
        int maxPageNum = getMaxPageNum();
        if (i3 < 0) {
            this.mPage = 0;
        } else if (i3 >= maxPageNum) {
            this.mPage = maxPageNum - 1;
        } else {
            this.mPage = i3;
        }
    }
}
