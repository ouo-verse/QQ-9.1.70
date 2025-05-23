package com.tencent.qqnt.aio.utils;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.theme.SkinnableBitmapDrawable;

/* compiled from: P */
/* loaded from: classes23.dex */
public class af {
    static IPatchRedirector $redirector_;

    public static Drawable a(Drawable drawable) {
        if (drawable instanceof SkinnableBitmapDrawable) {
            return ((SkinnableBitmapDrawable) drawable).mutate2();
        }
        if (drawable instanceof DrawableContainer) {
            Drawable.ConstantState constantState = drawable.getConstantState();
            if (constantState instanceof DrawableContainer.DrawableContainerState) {
                Drawable[] children = ((DrawableContainer.DrawableContainerState) constantState).getChildren();
                if (children != null && children.length != 0) {
                    for (int i3 = 0; i3 < children.length; i3++) {
                        children[i3] = a(children[i3]);
                    }
                } else {
                    return drawable.mutate();
                }
            }
        }
        if (drawable != null) {
            return drawable.mutate();
        }
        return null;
    }
}
