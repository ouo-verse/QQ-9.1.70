package androidx.recyclerview.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes.dex */
public class HippyLinearLayoutManager extends LinearLayoutManager {
    public static final int INVALID_SIZE = -1;

    /* renamed from: a, reason: collision with root package name */
    private static final RecyclerView.LayoutParams f26486a = new RecyclerView.LayoutParams(0, 0);
    protected HashMap<Integer, Integer> itemSizeMaps;

    public HippyLinearLayoutManager(Context context) {
        super(context);
        this.itemSizeMaps = new HashMap<>();
    }

    int a(int i3) {
        int i16;
        int i17;
        Object adapter = this.mRecyclerView.getAdapter();
        if (!(adapter instanceof ItemLayoutParams)) {
            return -1;
        }
        a();
        RecyclerView.LayoutParams layoutParams = f26486a;
        ((ItemLayoutParams) adapter).getItemLayoutParams(i3, layoutParams);
        if (this.mOrientation == 1) {
            int i18 = ((ViewGroup.MarginLayoutParams) layoutParams).height;
            if (i18 < 0) {
                return -1;
            }
            i16 = i18 + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
            i17 = ((ViewGroup.MarginLayoutParams) layoutParams).topMargin;
        } else {
            int i19 = ((ViewGroup.MarginLayoutParams) layoutParams).width;
            if (i19 < 0) {
                return -1;
            }
            i16 = i19 + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin;
            i17 = ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
        }
        int i26 = i16 + i17;
        a(i26, i3);
        return i26;
    }

    int b(int i3) {
        int i16 = 0;
        for (int i17 = 0; i17 <= i3; i17++) {
            Integer num = this.itemSizeMaps.get(Integer.valueOf(i17));
            if (num == null) {
                num = Integer.valueOf(a(i17));
            }
            if (num == null || num.intValue() == -1) {
                return -1;
            }
            i16 += num.intValue();
        }
        return i16;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeHorizontalScrollOffset(RecyclerView.State state) {
        if (getChildCount() > 0 && getItemCount() > 0) {
            int findFirstVisibleItemPosition = findFirstVisibleItemPosition();
            View findViewByPosition = findViewByPosition(findFirstVisibleItemPosition);
            int b16 = b(findFirstVisibleItemPosition);
            if (findViewByPosition != null && b16 != -1) {
                return b16 - this.mOrientationHelper.getDecoratedEnd(findViewByPosition);
            }
            return super.computeHorizontalScrollOffset(state);
        }
        return 0;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeHorizontalScrollRange(RecyclerView.State state) {
        int b16 = b(getItemCount() - 1);
        if (b16 != -1) {
            return b16;
        }
        return super.computeHorizontalScrollRange(state);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeVerticalScrollOffset(RecyclerView.State state) {
        if (getChildCount() > 0 && getItemCount() > 0) {
            int findFirstVisibleItemPosition = findFirstVisibleItemPosition();
            View findViewByPosition = findViewByPosition(findFirstVisibleItemPosition);
            int b16 = b(findFirstVisibleItemPosition);
            if (findViewByPosition != null && b16 != -1) {
                return b16 - this.mOrientationHelper.getDecoratedEnd(findViewByPosition);
            }
            return super.computeVerticalScrollOffset(state);
        }
        return 0;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeVerticalScrollRange(RecyclerView.State state) {
        int b16 = b(getItemCount() - 1);
        if (b16 != -1) {
            return b16;
        }
        return super.computeVerticalScrollRange(state);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void layoutDecoratedWithMargins(@NonNull View view, int i3, int i16, int i17, int i18) {
        int i19;
        super.layoutDecoratedWithMargins(view, i3, i16, i17, i18);
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
        if (this.mOrientation == 1) {
            i19 = (i18 - i16) + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
        } else {
            i19 = (i17 - i3) + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
        }
        a(i19, getPosition(view));
    }

    public void resetCache() {
        this.itemSizeMaps.clear();
    }

    public HippyLinearLayoutManager(Context context, int i3, boolean z16) {
        super(context, i3, z16);
        this.itemSizeMaps = new HashMap<>();
    }

    private static void a() {
        RecyclerView.LayoutParams layoutParams = f26486a;
        ((ViewGroup.MarginLayoutParams) layoutParams).width = 0;
        ((ViewGroup.MarginLayoutParams) layoutParams).height = 0;
        ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = 0;
        ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin = 0;
        ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin = 0;
        ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin = 0;
    }

    public HippyLinearLayoutManager(Context context, AttributeSet attributeSet, int i3, int i16) {
        super(context, attributeSet, i3, i16);
        this.itemSizeMaps = new HashMap<>();
    }

    private void a(int i3, int i16) {
        this.itemSizeMaps.put(Integer.valueOf(i16), Integer.valueOf(i3));
    }
}
