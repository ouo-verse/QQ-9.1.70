package com.tencent.widget.pull2refresh;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes27.dex */
public class AdapterItemDecoration extends RecyclerView.ItemDecoration {
    static IPatchRedirector $redirector_;

    public AdapterItemDecoration() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // android.support.v7.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, rect, view, recyclerView, state);
            return;
        }
        super.getItemOffsets(rect, view, recyclerView, state);
        if (recyclerView.getChildViewHolder(view) instanceof IViewHolderItemDecoration) {
            ((IViewHolderItemDecoration) recyclerView.getChildViewHolder(view)).getItemOffsets(rect, view, recyclerView, state);
        }
    }

    @Override // android.support.v7.widget.RecyclerView.ItemDecoration
    public void onDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, canvas, recyclerView, state);
        } else {
            super.onDraw(canvas, recyclerView, state);
        }
    }
}
