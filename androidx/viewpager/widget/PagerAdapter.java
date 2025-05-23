package androidx.viewpager.widget;

import android.database.DataSetObservable;
import android.database.DataSetObserver;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* loaded from: classes.dex */
public abstract class PagerAdapter {
    public static final int POSITION_NONE = -2;
    public static final int POSITION_UNCHANGED = -1;
    private final DataSetObservable mObservable = new DataSetObservable();
    private DataSetObserver mViewPagerObserver;

    public void destroyItem(@NonNull ViewGroup viewGroup, int i3, @NonNull Object obj) {
        destroyItem((View) viewGroup, i3, obj);
    }

    @Deprecated
    public void finishUpdate(@NonNull View view) {
    }

    public abstract int getCount();

    public int getItemPosition(@NonNull Object obj) {
        return -1;
    }

    @Nullable
    public CharSequence getPageTitle(int i3) {
        return null;
    }

    public float getPageWidth(int i3) {
        return 1.0f;
    }

    @NonNull
    public Object instantiateItem(@NonNull ViewGroup viewGroup, int i3) {
        return instantiateItem((View) viewGroup, i3);
    }

    public abstract boolean isViewFromObject(@NonNull View view, @NonNull Object obj);

    public void notifyDataSetChanged() {
        synchronized (this) {
            DataSetObserver dataSetObserver = this.mViewPagerObserver;
            if (dataSetObserver != null) {
                dataSetObserver.onChanged();
            }
        }
        this.mObservable.notifyChanged();
    }

    public void registerDataSetObserver(@NonNull DataSetObserver dataSetObserver) {
        this.mObservable.registerObserver(dataSetObserver);
    }

    @Nullable
    public Parcelable saveState() {
        return null;
    }

    @Deprecated
    public void setPrimaryItem(@NonNull View view, int i3, @NonNull Object obj) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setViewPagerObserver(DataSetObserver dataSetObserver) {
        synchronized (this) {
            this.mViewPagerObserver = dataSetObserver;
        }
    }

    @Deprecated
    public void startUpdate(@NonNull View view) {
    }

    public void unregisterDataSetObserver(@NonNull DataSetObserver dataSetObserver) {
        this.mObservable.unregisterObserver(dataSetObserver);
    }

    @Deprecated
    public void destroyItem(@NonNull View view, int i3, @NonNull Object obj) {
        throw new UnsupportedOperationException("Required method destroyItem was not overridden");
    }

    public void finishUpdate(@NonNull ViewGroup viewGroup) {
        finishUpdate((View) viewGroup);
    }

    @NonNull
    @Deprecated
    public Object instantiateItem(@NonNull View view, int i3) {
        throw new UnsupportedOperationException("Required method instantiateItem was not overridden");
    }

    public void setPrimaryItem(@NonNull ViewGroup viewGroup, int i3, @NonNull Object obj) {
        setPrimaryItem((View) viewGroup, i3, obj);
    }

    public void startUpdate(@NonNull ViewGroup viewGroup) {
        startUpdate((View) viewGroup);
    }

    public void restoreState(@Nullable Parcelable parcelable, @Nullable ClassLoader classLoader) {
    }
}
