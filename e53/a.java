package e53;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes20.dex */
public class a extends RecyclerView.ItemDecoration {

    /* renamed from: d, reason: collision with root package name */
    private int f395724d;

    @Override // android.support.v7.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        int i3;
        int dimensionPixelSize;
        if (this.f395724d == 0) {
            this.f395724d = (view.getResources().getDisplayMetrics().widthPixels - view.getResources().getDimensionPixelSize(R.dimen.d_m)) / 2;
        }
        int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
        int itemCount = recyclerView.getAdapter().getItemCount();
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
        if (childAdapterPosition == 0) {
            i3 = this.f395724d;
        } else {
            i3 = 0;
        }
        if (childAdapterPosition == itemCount - 1) {
            dimensionPixelSize = this.f395724d;
        } else {
            dimensionPixelSize = view.getResources().getDimensionPixelSize(R.dimen.f158713n2);
        }
        layoutParams.setMargins(i3, 0, dimensionPixelSize, 0);
        view.setLayoutParams(layoutParams);
        super.getItemOffsets(rect, view, recyclerView, state);
    }
}
