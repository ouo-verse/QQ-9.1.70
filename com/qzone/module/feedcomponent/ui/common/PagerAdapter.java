package com.qzone.module.feedcomponent.ui.common;

import android.database.DataSetObservable;
import android.database.DataSetObserver;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;

/* loaded from: classes39.dex */
public abstract class PagerAdapter {
    public static final int POSITION_NONE = -2;
    public static final int POSITION_UNCHANGED = -1;
    DataSetObservable mObservable = new DataSetObservable();

    public void destroyItem(ViewGroup viewGroup, int i3, Object obj) {
        destroyItem((View) viewGroup, i3, obj);
    }

    public void finishUpdate(View view) {
    }

    public abstract int getCount();

    public int getItemPosition(Object obj) {
        return -1;
    }

    public CharSequence getPageTitle(int i3) {
        return null;
    }

    public float getPageWidth(int i3) {
        return 1.0f;
    }

    public Object instantiateItem(ViewGroup viewGroup, int i3) {
        return instantiateItem((View) viewGroup, i3);
    }

    public abstract boolean isViewFromObject(View view, Object obj);

    public void notifyDataSetChanged() {
        this.mObservable.notifyChanged();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void registerDataSetObserver(DataSetObserver dataSetObserver) {
        this.mObservable.registerObserver(dataSetObserver);
    }

    public Parcelable saveState() {
        return null;
    }

    public void setPrimaryItem(View view, int i3, Object obj) {
    }

    public void startUpdate(View view) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
        this.mObservable.unregisterObserver(dataSetObserver);
    }

    public void destroyItem(View view, int i3, Object obj) {
        throw new UnsupportedOperationException("Required method destroyItem was not overridden");
    }

    public void finishUpdate(ViewGroup viewGroup) {
        finishUpdate((View) viewGroup);
    }

    public Object instantiateItem(View view, int i3) {
        throw new UnsupportedOperationException("Required method instantiateItem was not overridden");
    }

    public void setPrimaryItem(ViewGroup viewGroup, int i3, Object obj) {
        setPrimaryItem((View) viewGroup, i3, obj);
    }

    public void startUpdate(ViewGroup viewGroup) {
        startUpdate((View) viewGroup);
    }

    public void restoreState(Parcelable parcelable, ClassLoader classLoader) {
    }
}
