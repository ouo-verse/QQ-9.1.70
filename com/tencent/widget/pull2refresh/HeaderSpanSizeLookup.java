package com.tencent.widget.pull2refresh;

import android.support.v7.widget.GridLayoutManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes27.dex */
public class HeaderSpanSizeLookup extends GridLayoutManager.SpanSizeLookup {
    static IPatchRedirector $redirector_;
    private final RecyclerViewHeaderViewAdapter mAdapter;
    private GridLayoutManager.SpanSizeLookup mInnerSpanSizeLookup;
    private final GridLayoutManager mLayoutManager;

    public HeaderSpanSizeLookup(RecyclerViewHeaderViewAdapter recyclerViewHeaderViewAdapter, GridLayoutManager gridLayoutManager) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) recyclerViewHeaderViewAdapter, (Object) gridLayoutManager);
        } else {
            this.mAdapter = recyclerViewHeaderViewAdapter;
            this.mLayoutManager = gridLayoutManager;
        }
    }

    @Override // android.support.v7.widget.GridLayoutManager.SpanSizeLookup
    public int getSpanSize(int i3) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this, i3)).intValue();
        }
        if (!this.mAdapter.isHeaderPosition(i3) && !this.mAdapter.isFooterPosition(i3)) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return this.mLayoutManager.getSpanCount();
        }
        GridLayoutManager.SpanSizeLookup spanSizeLookup = this.mInnerSpanSizeLookup;
        if (spanSizeLookup == null) {
            return 1;
        }
        return spanSizeLookup.getSpanSize(i3 - this.mAdapter.getHeaderCount());
    }

    public void setSpanSizeLookup(GridLayoutManager.SpanSizeLookup spanSizeLookup) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) spanSizeLookup);
        } else {
            this.mInnerSpanSizeLookup = spanSizeLookup;
        }
    }
}
