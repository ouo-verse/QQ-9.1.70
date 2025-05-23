package com.tencent.qqnt.chathistory.ui.file.c2c;

import android.content.Context;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.chathistory.ui.file.c2c.p;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes23.dex */
public class o extends LinearLayoutManager {
    static IPatchRedirector $redirector_;

    @Nullable
    private n C;

    /* renamed from: d, reason: collision with root package name */
    private StickyHeaderPositioner f353657d;

    /* renamed from: e, reason: collision with root package name */
    private m f353658e;

    /* renamed from: f, reason: collision with root package name */
    private List<Integer> f353659f;

    /* renamed from: h, reason: collision with root package name */
    private p.a f353660h;

    /* renamed from: i, reason: collision with root package name */
    private int f353661i;

    /* renamed from: m, reason: collision with root package name */
    private boolean f353662m;

    public o(Context context, m mVar) {
        this(context, 1, false, mVar);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            t(mVar);
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) mVar);
        }
    }

    private void r() {
        this.f353659f.clear();
        List<?> f16 = this.f353658e.f();
        if (f16 == null) {
            StickyHeaderPositioner stickyHeaderPositioner = this.f353657d;
            if (stickyHeaderPositioner != null) {
                stickyHeaderPositioner.J(this.f353659f);
                return;
            }
            return;
        }
        for (int i3 = 0; i3 < f16.size(); i3++) {
            if (f16.get(i3) instanceof com.tencent.qqnt.chathistory.ui.file.c2c.data.model.a) {
                this.f353659f.add(Integer.valueOf(i3));
            }
        }
        StickyHeaderPositioner stickyHeaderPositioner2 = this.f353657d;
        if (stickyHeaderPositioner2 != null) {
            stickyHeaderPositioner2.J(this.f353659f);
        }
    }

    private Map<Integer, View> s() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (int i3 = 0; i3 < getChildCount(); i3++) {
            View childAt = getChildAt(i3);
            int position = getPosition(childAt);
            if (this.f353659f.contains(Integer.valueOf(position))) {
                linkedHashMap.put(Integer.valueOf(position), childAt);
            }
        }
        return linkedHashMap;
    }

    private void t(m mVar) {
        l.a(mVar, "StickyHeaderHandler == null");
        this.f353658e = mVar;
    }

    private void u() {
        boolean z16;
        this.f353657d.E(getOrientation());
        StickyHeaderPositioner stickyHeaderPositioner = this.f353657d;
        int findFirstVisibleItemPosition = findFirstVisibleItemPosition();
        Map<Integer, View> s16 = s();
        p.a aVar = this.f353660h;
        if (findFirstCompletelyVisibleItemPosition() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        stickyHeaderPositioner.N(findFirstVisibleItemPosition, s16, aVar, z16);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onAttachedToWindow(RecyclerView recyclerView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) recyclerView);
            return;
        }
        if (this.f353662m) {
            l.b(recyclerView);
        }
        this.f353660h = new p.a(recyclerView);
        StickyHeaderPositioner stickyHeaderPositioner = new StickyHeaderPositioner(recyclerView);
        this.f353657d = stickyHeaderPositioner;
        stickyHeaderPositioner.I(this.f353661i);
        this.f353657d.K(this.C);
        if (this.f353659f.size() > 0) {
            this.f353657d.J(this.f353659f);
            u();
        }
        super.onAttachedToWindow(recyclerView);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onDetachedFromWindow(RecyclerView recyclerView, RecyclerView.Recycler recycler) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) recyclerView, (Object) recycler);
            return;
        }
        StickyHeaderPositioner stickyHeaderPositioner = this.f353657d;
        if (stickyHeaderPositioner != null) {
            stickyHeaderPositioner.q();
        }
        super.onDetachedFromWindow(recyclerView, recycler);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) recycler, (Object) state);
            return;
        }
        super.onLayoutChildren(recycler, state);
        r();
        if (this.f353657d != null) {
            u();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void removeAndRecycleAllViews(RecyclerView.Recycler recycler) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) recycler);
            return;
        }
        super.removeAndRecycleAllViews(recycler);
        StickyHeaderPositioner stickyHeaderPositioner = this.f353657d;
        if (stickyHeaderPositioner != null) {
            stickyHeaderPositioner.p();
        }
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int scrollHorizontallyBy(int i3, RecyclerView.Recycler recycler, RecyclerView.State state) {
        StickyHeaderPositioner stickyHeaderPositioner;
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z16 = true;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Integer) iPatchRedirector.redirect((short) 9, this, Integer.valueOf(i3), recycler, state)).intValue();
        }
        int scrollHorizontallyBy = super.scrollHorizontallyBy(i3, recycler, state);
        if (Math.abs(scrollHorizontallyBy) > 0 && (stickyHeaderPositioner = this.f353657d) != null) {
            int findFirstVisibleItemPosition = findFirstVisibleItemPosition();
            Map<Integer, View> s16 = s();
            p.a aVar = this.f353660h;
            if (findFirstCompletelyVisibleItemPosition() != 0) {
                z16 = false;
            }
            stickyHeaderPositioner.N(findFirstVisibleItemPosition, s16, aVar, z16);
        }
        return scrollHorizontallyBy;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int scrollVerticallyBy(int i3, RecyclerView.Recycler recycler, RecyclerView.State state) {
        StickyHeaderPositioner stickyHeaderPositioner;
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z16 = true;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Integer) iPatchRedirector.redirect((short) 8, this, Integer.valueOf(i3), recycler, state)).intValue();
        }
        int scrollVerticallyBy = super.scrollVerticallyBy(i3, recycler, state);
        if (Math.abs(scrollVerticallyBy) > 0 && (stickyHeaderPositioner = this.f353657d) != null) {
            int findFirstVisibleItemPosition = findFirstVisibleItemPosition();
            Map<Integer, View> s16 = s();
            p.a aVar = this.f353660h;
            if (findFirstCompletelyVisibleItemPosition() != 0) {
                z16 = false;
            }
            stickyHeaderPositioner.N(findFirstVisibleItemPosition, s16, aVar, z16);
        }
        return scrollVerticallyBy;
    }

    public void v(@Nullable n nVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) nVar);
            return;
        }
        this.C = nVar;
        StickyHeaderPositioner stickyHeaderPositioner = this.f353657d;
        if (stickyHeaderPositioner != null) {
            stickyHeaderPositioner.K(nVar);
        }
    }

    public o(Context context, int i3, boolean z16, m mVar) {
        super(context, i3, z16);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, context, Integer.valueOf(i3), Boolean.valueOf(z16), mVar);
            return;
        }
        this.f353659f = new ArrayList();
        this.f353661i = -1;
        this.f353662m = true;
        t(mVar);
    }
}
