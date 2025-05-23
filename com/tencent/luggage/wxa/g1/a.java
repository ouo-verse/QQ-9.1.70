package com.tencent.luggage.wxa.g1;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* compiled from: P */
/* loaded from: classes8.dex */
public class a extends RecyclerView.ItemDecoration {

    /* renamed from: a, reason: collision with root package name */
    public int f126394a;

    /* renamed from: b, reason: collision with root package name */
    public int f126395b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f126396c;

    public a(int i3, int i16, boolean z16) {
        this.f126394a = i3;
        this.f126395b = i16;
        this.f126396c = z16;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
        int i3 = this.f126394a;
        int i16 = childAdapterPosition % i3;
        if (this.f126396c) {
            int i17 = this.f126395b;
            rect.left = i17 - ((i16 * i17) / i3);
            rect.right = ((i16 + 1) * i17) / i3;
            if (childAdapterPosition < i3) {
                rect.top = i17;
            }
            rect.bottom = i17;
            return;
        }
        int i18 = this.f126395b;
        rect.left = (i16 * i18) / i3;
        rect.right = i18 - (((i16 + 1) * i18) / i3);
        if (childAdapterPosition >= i3) {
            rect.top = i18;
        }
    }
}
