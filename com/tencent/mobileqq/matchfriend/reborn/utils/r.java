package com.tencent.mobileqq.matchfriend.reborn.utils;

import android.view.MotionEvent;
import android.view.View;
import com.tencent.ditto.shell.LayoutAttrDefine;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u001a\u0016\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0001H\u0007\u00a8\u0006\u0005"}, d2 = {"Landroid/view/View;", "", LayoutAttrDefine.PRESSED_ALPHA, "", "b", "matchfriend_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class r {
    public static final void b(View view, final float f16) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        view.setOnTouchListener(new View.OnTouchListener() { // from class: com.tencent.mobileqq.matchfriend.reborn.utils.q
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view2, MotionEvent motionEvent) {
                boolean d16;
                d16 = r.d(f16, view2, motionEvent);
                return d16;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean d(float f16, View view, MotionEvent motionEvent) {
        Integer valueOf = motionEvent != null ? Integer.valueOf(motionEvent.getAction()) : null;
        if (valueOf != null && valueOf.intValue() == 0) {
            if (view == null) {
                return false;
            }
            view.setAlpha(f16);
            return false;
        }
        if (valueOf != null && valueOf.intValue() == 1) {
            if (view == null) {
                return false;
            }
            view.setAlpha(1.0f);
            return false;
        }
        if (valueOf == null || valueOf.intValue() != 3 || view == null) {
            return false;
        }
        view.setAlpha(1.0f);
        return false;
    }

    public static /* synthetic */ void c(View view, float f16, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            f16 = 0.5f;
        }
        b(view, f16);
    }
}
