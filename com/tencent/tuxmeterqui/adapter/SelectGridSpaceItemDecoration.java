package com.tencent.tuxmeterqui.adapter;

import android.graphics.Rect;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes27.dex */
public class SelectGridSpaceItemDecoration extends RecyclerView.ItemDecoration {
    static IPatchRedirector $redirector_;
    private final int mColumnSpacing;
    private final int mRowSpacing;
    private final int mSpanCount;

    public SelectGridSpaceItemDecoration(int i3, int i16, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
            return;
        }
        this.mSpanCount = i3;
        this.mRowSpacing = i16;
        this.mColumnSpacing = i17;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(@NonNull Rect rect, @NonNull View view, @NonNull RecyclerView recyclerView, @NonNull RecyclerView.State state) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, rect, view, recyclerView, state);
            return;
        }
        int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
        int i3 = this.mSpanCount;
        int i16 = childAdapterPosition % i3;
        int i17 = this.mColumnSpacing;
        rect.left = (i16 * i17) / i3;
        rect.right = i17 - (((i16 + 1) * i17) / i3);
        if (childAdapterPosition >= i3) {
            rect.top = this.mRowSpacing;
        }
    }
}
