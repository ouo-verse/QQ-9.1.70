package com.tencent.mobileqq.qqexpand.fragment;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import com.tencent.mobileqq.app.QBaseFragment;
import com.tencent.mobileqq.util.x;

/* compiled from: P */
/* loaded from: classes16.dex */
class e extends RecyclerView.ItemDecoration {

    /* renamed from: d, reason: collision with root package name */
    private final int f263805d;

    /* renamed from: e, reason: collision with root package name */
    private final int f263806e;

    /* renamed from: f, reason: collision with root package name */
    private final int f263807f;

    /* renamed from: h, reason: collision with root package name */
    private final int f263808h;

    public e(QBaseFragment qBaseFragment) {
        this.f263805d = x.c(qBaseFragment.getContext(), 11.0f);
        this.f263806e = x.c(qBaseFragment.getContext(), 11.0f);
        this.f263807f = x.c(qBaseFragment.getContext(), 8.0f);
        this.f263808h = x.c(qBaseFragment.getContext(), 8.0f);
    }

    @Override // android.support.v7.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect rect, int i3, RecyclerView recyclerView) {
        int itemCount = recyclerView.getAdapter().getItemCount();
        if (recyclerView.getAdapter().getItemViewType(i3) == 6) {
            rect.set(0, this.f263805d, 0, 0);
        } else if (i3 == itemCount - 1) {
            rect.set(this.f263807f, this.f263805d, this.f263808h, this.f263806e);
        } else {
            rect.set(this.f263807f, this.f263805d, this.f263808h, 0);
        }
    }
}
