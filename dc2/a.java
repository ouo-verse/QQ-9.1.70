package dc2;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/* compiled from: P */
/* loaded from: classes9.dex */
public class a extends RecyclerView.ItemDecoration {

    /* renamed from: d, reason: collision with root package name */
    private int f393583d;

    public a(int i3) {
        this.f393583d = i3;
    }

    @Override // android.support.v7.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        int i3 = this.f393583d;
        rect.top = i3;
        rect.bottom = 0;
        rect.left = i3 / 2;
        rect.right = i3 / 2;
    }
}
