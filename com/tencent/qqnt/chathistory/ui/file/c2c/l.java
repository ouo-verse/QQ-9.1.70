package com.tencent.qqnt.chathistory.ui.file.c2c;

import android.view.View;
import android.widget.FrameLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes23.dex */
final class l {
    static IPatchRedirector $redirector_;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> T a(T t16, String str) {
        if (t16 != null) {
            return t16;
        }
        throw new NullPointerException(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void b(View view) {
        View view2 = (View) view.getParent();
        if (!(view2 instanceof FrameLayout) && !(view2 instanceof CoordinatorLayout)) {
            throw new IllegalArgumentException("RecyclerView parent must be either a FrameLayout or CoordinatorLayout");
        }
    }
}
