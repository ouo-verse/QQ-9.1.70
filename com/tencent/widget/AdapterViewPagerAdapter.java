package com.tencent.widget;

import android.content.Context;
import android.database.DataSetObserver;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import androidx.viewpager.widget.PagerAdapter;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* loaded from: classes27.dex */
public class AdapterViewPagerAdapter extends PagerAdapter {
    static IPatchRedirector $redirector_;
    private SparseArray<android.widget.AdapterView> mAdapterViewCache;
    private AdapterViewFactory mAdapterViewFactory;
    private Context mContext;
    private PageInflateDelegate mInflateDelegate;
    private PagerBaseAdapterWrapper mPagerBaseAdapter;

    /* loaded from: classes27.dex */
    public interface AdapterViewFactory {
        android.widget.AdapterView create(Context context, int i3);
    }

    /* loaded from: classes27.dex */
    public interface PageInflateDelegate {
        void deflate(ViewGroup viewGroup, View view, int i3);

        View inflate(ViewGroup viewGroup, android.widget.AdapterView adapterView, int i3);
    }

    /* loaded from: classes27.dex */
    class a extends DataSetObserver {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AdapterViewPagerAdapter.this);
            }
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                AdapterViewPagerAdapter.this.notifyDataSetChanged();
            }
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
            } else {
                super.onInvalidated();
            }
        }
    }

    public AdapterViewPagerAdapter(Context context, BaseAdapter baseAdapter, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, baseAdapter, Integer.valueOf(i3));
            return;
        }
        this.mAdapterViewCache = new SparseArray<>();
        this.mContext = context;
        PagerBaseAdapterWrapper pagerBaseAdapterWrapper = new PagerBaseAdapterWrapper(baseAdapter, i3);
        this.mPagerBaseAdapter = pagerBaseAdapterWrapper;
        pagerBaseAdapterWrapper.registerDataSetObserver(new a());
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i3, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, viewGroup, Integer.valueOf(i3), obj);
            return;
        }
        PageInflateDelegate pageInflateDelegate = this.mInflateDelegate;
        if (pageInflateDelegate != null) {
            pageInflateDelegate.deflate(viewGroup, (View) obj, i3);
        } else {
            viewGroup.removeView((View) obj);
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return this.mPagerBaseAdapter.getMaxPageNum();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return iPatchRedirector.redirect((short) 5, (Object) this, (Object) viewGroup, i3);
        }
        android.widget.AdapterView obtainAdapterView = obtainAdapterView(i3);
        if (obtainAdapterView == null) {
            return null;
        }
        PageInflateDelegate pageInflateDelegate = this.mInflateDelegate;
        if (pageInflateDelegate != null) {
            return pageInflateDelegate.inflate(viewGroup, obtainAdapterView, i3);
        }
        viewGroup.addView(obtainAdapterView);
        return obtainAdapterView;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this, (Object) view, obj)).booleanValue();
        }
        if (view == obj) {
            return true;
        }
        return false;
    }

    public android.widget.AdapterView obtainAdapterView(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (android.widget.AdapterView) iPatchRedirector.redirect((short) 6, (Object) this, i3);
        }
        android.widget.AdapterView adapterView = this.mAdapterViewCache.get(i3);
        if (adapterView == null) {
            AdapterViewFactory adapterViewFactory = this.mAdapterViewFactory;
            if (adapterViewFactory != null) {
                adapterView = adapterViewFactory.create(this.mContext, i3);
            } else {
                throw new IllegalArgumentException("setAdapterViewFactory should be invoked first!");
            }
        }
        if (adapterView != null) {
            PagerBaseAdapterWrapper pagerBaseAdapterWrapper = new PagerBaseAdapterWrapper(this.mPagerBaseAdapter.getWrapperAdapter(), this.mPagerBaseAdapter.getPageItemNum());
            pagerBaseAdapterWrapper.setCurrentPage(i3);
            adapterView.setAdapter(pagerBaseAdapterWrapper);
            this.mAdapterViewCache.put(i3, adapterView);
        }
        return adapterView;
    }

    public void setAdapterViewFactory(AdapterViewFactory adapterViewFactory) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) adapterViewFactory);
        } else {
            this.mAdapterViewFactory = adapterViewFactory;
        }
    }

    public void setInflateDelegate(PageInflateDelegate pageInflateDelegate) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) pageInflateDelegate);
        } else {
            this.mInflateDelegate = pageInflateDelegate;
        }
    }
}
