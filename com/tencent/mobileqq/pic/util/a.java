package com.tencent.mobileqq.pic.util;

import android.view.View;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.widget.Gallery;

/* compiled from: P */
/* loaded from: classes16.dex */
public class a {
    static IPatchRedirector $redirector_;

    public static void a(View view, URLDrawable uRLDrawable, int i3) {
        int i16 = 3;
        if (i3 != 3) {
            if (i3 != 6) {
                if (i3 != 8) {
                    i16 = 0;
                }
            } else {
                i16 = 1;
            }
        } else {
            i16 = 2;
        }
        boolean z16 = !uRLDrawable.isAnim();
        view.setTag(Gallery.ID_CHILD_ROTATEABLE, Boolean.valueOf(z16));
        if (z16) {
            view.setTag(Gallery.ID_DEFAULT_ROTATE, Integer.valueOf(i16));
        }
    }
}
