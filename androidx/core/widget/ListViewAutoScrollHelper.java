package androidx.core.widget;

import android.widget.ListView;
import androidx.annotation.NonNull;

/* compiled from: P */
/* loaded from: classes.dex */
public class ListViewAutoScrollHelper extends AutoScrollHelper {
    private final ListView mTarget;

    public ListViewAutoScrollHelper(@NonNull ListView listView) {
        super(listView);
        this.mTarget = listView;
    }

    @Override // androidx.core.widget.AutoScrollHelper
    public boolean canTargetScrollHorizontally(int i3) {
        return false;
    }

    @Override // androidx.core.widget.AutoScrollHelper
    public boolean canTargetScrollVertically(int i3) {
        ListView listView = this.mTarget;
        int count = listView.getCount();
        if (count == 0) {
            return false;
        }
        int childCount = listView.getChildCount();
        int firstVisiblePosition = listView.getFirstVisiblePosition();
        int i16 = firstVisiblePosition + childCount;
        if (i3 > 0) {
            if (i16 >= count && listView.getChildAt(childCount - 1).getBottom() <= listView.getHeight()) {
                return false;
            }
        } else {
            if (i3 >= 0) {
                return false;
            }
            if (firstVisiblePosition <= 0 && listView.getChildAt(0).getTop() >= 0) {
                return false;
            }
        }
        return true;
    }

    @Override // androidx.core.widget.AutoScrollHelper
    public void scrollTargetBy(int i3, int i16) {
        ListViewCompat.scrollListBy(this.mTarget, i16);
    }
}
