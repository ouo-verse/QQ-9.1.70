package com.tencent.luggage.wxa.w8;

import android.view.View;
import android.view.ViewGroup;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public final HashMap f144124a = new HashMap();

    public final int a(ViewGroup viewGroup, View view, int i3) {
        Intrinsics.checkNotNullParameter(viewGroup, "viewGroup");
        Intrinsics.checkNotNullParameter(view, "view");
        Integer num = (Integer) this.f144124a.get(view);
        if (num != null && num.intValue() == i3) {
            return -2;
        }
        this.f144124a.put(view, Integer.valueOf(i3));
        int childCount = viewGroup.getChildCount();
        boolean z16 = false;
        int i16 = 0;
        for (int i17 = 0; i17 < childCount; i17++) {
            Object obj = this.f144124a.get(viewGroup.getChildAt(i17));
            Intrinsics.checkNotNull(obj);
            if (i3 < ((Number) obj).intValue()) {
                z16 = true;
                i16 = i17;
            }
        }
        if (z16) {
            return i16;
        }
        return -1;
    }

    public final void a(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.f144124a.remove(view);
    }
}
