package com.tencent.luggage.wxa.kj;

import android.view.View;
import android.view.ViewGroup;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class f extends c0 {
    public f(ViewGroup viewGroup) {
        super(viewGroup);
    }

    public static void a(View view, int i3, int i16) {
        if (view.getLayoutParams() == null) {
            view.setLayoutParams(new ViewGroup.LayoutParams(i3, i16));
            return;
        }
        view.getLayoutParams().width = i3;
        view.getLayoutParams().height = i16;
        if (view.getParent() != null) {
            view.requestLayout();
        }
    }

    @Override // com.tencent.luggage.wxa.kj.c0
    public boolean a(View view, int i3, int i16, float[] fArr, int i17, boolean z16) {
        return super.a(view, i3, i16, fArr, i17, z16);
    }

    @Override // com.tencent.luggage.wxa.kj.c0
    public boolean a(View view, int i3, int i16, float[] fArr, int i17, boolean z16, boolean z17) {
        return super.a(view, i3, i16, fArr, i17, z16, z17);
    }

    @Override // com.tencent.luggage.wxa.kj.c0, com.tencent.luggage.wxa.xd.f.a
    public boolean a(View view, int i3, int i16, float[] fArr, int i17, boolean z16, boolean z17, boolean z18) {
        return super.a(view, i3, i16, fArr, i17, z16, z17, z18);
    }

    public void a(com.tencent.luggage.wxa.lj.c cVar) {
        a((View) cVar, 1, 0, new float[]{0.0f, 0.0f, 0.0f, 0.0f, 1000.0f}, 0, true);
        a(cVar, -1, -2);
    }
}
