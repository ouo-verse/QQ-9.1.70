package com.tencent.mobileqq.tvideo.ad.miniqadsdk.feedsdk.immersiveAd;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes19.dex */
public final class b {
    public static void a(Context context, f fVar) {
        if (context instanceof Activity) {
            Activity activity = (Activity) context;
            if (d(activity)) {
                activity.setRequestedOrientation(1);
                fVar.v(12, new g(Boolean.TRUE));
            } else {
                activity.finish();
            }
        }
    }

    public static boolean b(int i3) {
        if (i3 != 1021 && i3 != 1023) {
            return false;
        }
        return true;
    }

    public static boolean c(View view) {
        if (view.getId() != R.id.xlh && view.getId() != R.id.xlb) {
            return false;
        }
        return true;
    }

    private static boolean d(Activity activity) {
        if (activity.getResources().getConfiguration().orientation == 2) {
            return true;
        }
        return false;
    }
}
