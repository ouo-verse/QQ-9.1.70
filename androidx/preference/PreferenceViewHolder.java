package androidx.preference;

import android.util.SparseArray;
import android.view.View;
import androidx.annotation.IdRes;
import androidx.annotation.RestrictTo;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes.dex */
public class PreferenceViewHolder extends RecyclerView.ViewHolder {
    private final SparseArray<View> mCachedViews;
    private boolean mDividerAllowedAbove;
    private boolean mDividerAllowedBelow;

    /* JADX INFO: Access modifiers changed from: package-private */
    public PreferenceViewHolder(View view) {
        super(view);
        SparseArray<View> sparseArray = new SparseArray<>(4);
        this.mCachedViews = sparseArray;
        sparseArray.put(android.R.id.title, view.findViewById(android.R.id.title));
        sparseArray.put(android.R.id.summary, view.findViewById(android.R.id.summary));
        sparseArray.put(android.R.id.icon, view.findViewById(android.R.id.icon));
        sparseArray.put(com.tencent.mobileqq.R.id.xdw, view.findViewById(com.tencent.mobileqq.R.id.xdw));
        sparseArray.put(16908350, view.findViewById(16908350));
    }

    @RestrictTo({RestrictTo.Scope.TESTS})
    public static PreferenceViewHolder createInstanceForTests(View view) {
        return new PreferenceViewHolder(view);
    }

    public View findViewById(@IdRes int i3) {
        View view = this.mCachedViews.get(i3);
        if (view != null) {
            return view;
        }
        View findViewById = this.itemView.findViewById(i3);
        if (findViewById != null) {
            this.mCachedViews.put(i3, findViewById);
        }
        return findViewById;
    }

    public boolean isDividerAllowedAbove() {
        return this.mDividerAllowedAbove;
    }

    public boolean isDividerAllowedBelow() {
        return this.mDividerAllowedBelow;
    }

    public void setDividerAllowedAbove(boolean z16) {
        this.mDividerAllowedAbove = z16;
    }

    public void setDividerAllowedBelow(boolean z16) {
        this.mDividerAllowedBelow = z16;
    }
}
