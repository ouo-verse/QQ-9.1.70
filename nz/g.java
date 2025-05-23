package nz;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.tencent.biz.pubaccount.weishi.util.r;

/* compiled from: P */
/* loaded from: classes38.dex */
public class g extends RecyclerView.ItemDecoration {

    /* renamed from: d, reason: collision with root package name */
    public static final int f421614d = r.H(12.0f);

    @Override // android.support.v7.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        super.getItemOffsets(rect, view, recyclerView, state);
        if (recyclerView.getChildAdapterPosition(view) == 0) {
            rect.left = f421614d;
        }
        rect.right = f421614d;
    }
}
