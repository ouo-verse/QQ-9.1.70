package com.tencent.mobileqq.litelivesdk.utils.ui;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.view.ViewGroup;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes15.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static float f241169a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(72762);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f241169a = 0.0f;
        }
    }

    public static boolean a(@NonNull Activity activity) {
        ViewGroup viewGroup = (ViewGroup) activity.getWindow().getDecorView();
        if (viewGroup != null) {
            for (int i3 = 0; i3 < viewGroup.getChildCount(); i3++) {
                viewGroup.getChildAt(i3).getContext().getPackageName();
                int i16 = viewGroup.getChildAt(i3).getLayoutParams().height;
                viewGroup.getChildAt(i3).getVisibility();
                if (viewGroup.getChildAt(i3).getId() != -1 && "navigationBarBackground".equals(activity.getResources().getResourceEntryName(viewGroup.getChildAt(i3).getId())) && viewGroup.getChildAt(i3).getVisibility() == 0) {
                    return true;
                }
            }
        }
        return false;
    }
}
