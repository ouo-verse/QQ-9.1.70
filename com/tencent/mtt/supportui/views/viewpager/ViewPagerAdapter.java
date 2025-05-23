package com.tencent.mtt.supportui.views.viewpager;

import android.database.DataSetObservable;
import android.database.DataSetObserver;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;

/* loaded from: classes21.dex */
public abstract class ViewPagerAdapter {
    public static final int POSITION_NONE = -2;
    public static final int POSITION_UNCHANGED = -1;
    public static final int REFRESH_NONE = 0;
    public static final int REFRESH_SIZE_CHANGED = 1;
    private DataSetObservable mObservable = new DataSetObservable();

    public void destroyItem(View view, int i3, Object obj) {
        throw new UnsupportedOperationException("Required method destroyItem was not overridden");
    }

    public void finishUpdate(View view) {
    }

    public abstract int getCount();

    public int getInitialItemIndex() {
        return 0;
    }

    public int getItemPosition(Object obj) {
        return -1;
    }

    public float getPageSize(int i3) {
        return 1.0f;
    }

    public CharSequence getPageTitle(int i3) {
        return null;
    }

    public View getTab(int i3) {
        return null;
    }

    public Object instantiateItem(View view, int i3) {
        throw new UnsupportedOperationException("Required method instantiateItem was not overridden");
    }

    public abstract boolean isViewFromObject(View view, Object obj);

    public void notifyDataSetChanged() {
        this.mObservable.notifyChanged();
    }

    public int refreshItem(ViewGroup viewGroup, int i3, Object obj) {
        return 0;
    }

    public void registerDataSetObserver(DataSetObserver dataSetObserver) {
        this.mObservable.registerObserver(dataSetObserver);
    }

    public Parcelable saveState() {
        return null;
    }

    public void setPrimaryItem(View view, int i3, Object obj) {
    }

    public void startUpdate(View view, int i3) {
    }

    public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
        this.mObservable.unregisterObserver(dataSetObserver);
    }

    public void destroyItem(ViewGroup viewGroup, int i3, Object obj) {
        destroyItem((View) viewGroup, i3, obj);
    }

    public void finishUpdate(ViewGroup viewGroup) {
        finishUpdate((View) viewGroup);
    }

    public Object instantiateItem(ViewGroup viewGroup, int i3) {
        return instantiateItem((View) viewGroup, i3);
    }

    public void setPrimaryItem(ViewGroup viewGroup, int i3, Object obj) {
        setPrimaryItem((View) viewGroup, i3, obj);
    }

    public void startUpdate(ViewGroup viewGroup, int i3) {
        startUpdate((View) viewGroup, i3);
    }

    public void restoreState(Parcelable parcelable, ClassLoader classLoader) {
    }
}
