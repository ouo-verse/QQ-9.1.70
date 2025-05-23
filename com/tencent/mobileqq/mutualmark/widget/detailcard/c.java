package com.tencent.mobileqq.mutualmark.widget.detailcard;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes15.dex */
class c extends RecyclerView.ItemDecoration {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private int f252398d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(@NotNull Rect rect, @NotNull View view, @NotNull RecyclerView recyclerView, @NotNull RecyclerView.State state) {
        int dimensionPixelSize;
        int dimensionPixelSize2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, rect, view, recyclerView, state);
            return;
        }
        super.getItemOffsets(rect, view, recyclerView, state);
        if (this.f252398d == 0) {
            this.f252398d = (view.getResources().getDisplayMetrics().widthPixels - view.getResources().getDimensionPixelSize(R.dimen.d7n)) / 2;
        }
        int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
        if (recyclerView.getAdapter() == null) {
            return;
        }
        int itemCount = recyclerView.getAdapter().getItemCount();
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
        if (childAdapterPosition == 0) {
            dimensionPixelSize = this.f252398d;
        } else {
            dimensionPixelSize = view.getResources().getDimensionPixelSize(R.dimen.f158700mp);
        }
        if (childAdapterPosition == itemCount - 1) {
            dimensionPixelSize2 = this.f252398d;
        } else {
            dimensionPixelSize2 = view.getResources().getDimensionPixelSize(R.dimen.f158700mp);
        }
        layoutParams.setMargins(dimensionPixelSize, 0, dimensionPixelSize2, 0);
        view.setLayoutParams(layoutParams);
        super.getItemOffsets(rect, view, recyclerView, state);
    }
}
