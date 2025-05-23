package com.tencent.relation.common.widget.squaredIndicator;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes25.dex */
public class h extends RecyclerView.ItemDecoration {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private int f364876d;

    /* renamed from: e, reason: collision with root package name */
    private Context f364877e;

    /* renamed from: f, reason: collision with root package name */
    private com.tencent.mobileqq.mutualmark.util.a f364878f;

    public h(Context context, int i3, int i16, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
            return;
        }
        this.f364877e = context;
        this.f364876d = i3;
        this.f364878f = new com.tencent.mobileqq.mutualmark.util.a(context);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(@NonNull Rect rect, @NonNull View view, @NonNull RecyclerView recyclerView, @NonNull RecyclerView.State state) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, rect, view, recyclerView, state);
            return;
        }
        int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
        int i3 = childAdapterPosition % this.f364876d;
        int f16 = this.f364878f.f();
        int i16 = this.f364876d;
        rect.left = (i3 * f16) / i16;
        rect.right = f16 - (((i3 + 1) * f16) / i16);
        if (childAdapterPosition >= i16) {
            rect.top = this.f364878f.e();
        }
    }
}
