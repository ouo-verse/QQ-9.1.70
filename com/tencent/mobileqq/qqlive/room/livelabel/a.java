package com.tencent.mobileqq.qqlive.room.livelabel;

import android.graphics.Rect;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes17.dex */
public class a extends RecyclerView.ItemDecoration {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private int f271618d;

    /* renamed from: e, reason: collision with root package name */
    private int f271619e;

    /* renamed from: f, reason: collision with root package name */
    private int f271620f;

    public a(int i3, int i16, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
            return;
        }
        this.f271618d = i3;
        this.f271619e = i16;
        this.f271620f = i17;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(@NonNull Rect rect, @NonNull View view, @NonNull RecyclerView recyclerView, @NonNull RecyclerView.State state) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, rect, view, recyclerView, state);
            return;
        }
        int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
        int i3 = this.f271618d;
        int i16 = childAdapterPosition % i3;
        int i17 = this.f271620f;
        rect.left = (i16 * i17) / i3;
        rect.right = i17 - (((i16 + 1) * i17) / i3);
        rect.top = this.f271619e;
    }
}
