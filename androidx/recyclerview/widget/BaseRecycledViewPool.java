package androidx.recyclerview.widget;

import android.util.SparseArray;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes.dex */
public class BaseRecycledViewPool extends RecyclerView.RecycledViewPool {
    public SparseArray<RecyclerView.RecycledViewPool.ScrapData> getScrap() {
        return this.mScrap;
    }
}
