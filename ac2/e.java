package ac2;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;

/* compiled from: P */
/* loaded from: classes9.dex */
public class e extends RecyclerView.ItemDecoration {

    /* renamed from: d, reason: collision with root package name */
    private int f25852d;

    public e(int i3) {
        this.f25852d = i3;
    }

    @Override // android.support.v7.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        int i3;
        int i16 = 0;
        if (view.getTag() != null && (view.getTag() instanceof qb2.e)) {
            int i17 = ((qb2.e) view.getTag()).G;
            if (view.getLayoutParams() instanceof StaggeredGridLayoutManager.LayoutParams) {
                i3 = ((StaggeredGridLayoutManager.LayoutParams) view.getLayoutParams()).getSpanIndex();
            } else {
                i3 = -1;
            }
            if (i3 >= 0) {
                if (i3 % 2 == 0) {
                    int i18 = this.f25852d;
                    rect.left = i18;
                    if (i17 == 2) {
                        i16 = i18;
                    }
                    rect.top = i16;
                    rect.right = i18 / 2;
                    rect.bottom = i18;
                    return;
                }
                int i19 = this.f25852d;
                rect.left = i19 / 2;
                if (i17 == 3) {
                    i16 = i19;
                }
                rect.top = i16;
                rect.right = i19;
                rect.bottom = i19;
                return;
            }
            int i26 = this.f25852d;
            rect.left = i26 / 2;
            rect.top = 0;
            rect.right = i26 / 2;
            rect.bottom = i26;
            return;
        }
        rect.left = 0;
        rect.top = 0;
        rect.right = 0;
        rect.bottom = 0;
    }
}
