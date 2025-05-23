package com.qzone.proxy.covercomponent.adapter;

import android.content.Context;
import android.content.Intent;
import com.qzone.common.activities.base.ak;
import com.qzone.misc.network.report.a;
import yo.d;

/* compiled from: P */
/* loaded from: classes39.dex */
public class CoverJumpAction {
    public static Intent getActivityCoverPageIntent(String str) {
        return ak.a(str);
    }

    public static Intent getCoverClickedIntentFromJceData(long j3) {
        return ak.f(j3);
    }

    public static Intent getCoverPreviewIntent(String str, int i3, String str2, long j3) {
        return ak.g(str, i3, str2, j3);
    }

    public static Intent getCoverStoreIntent(int i3, String str, long j3) {
        return ak.h(i3, str, j3);
    }

    public static Intent getMusicCoverPreviewIntent(String str, int i3, String str2, long j3) {
        return ak.n(str, i3, str2, j3);
    }

    public static void handleScheme(String str, Context context, String str2) {
        d.d(str, context, str2);
    }

    public static void jumpToCoverCenter(Context context, int i3, String str, long j3) {
        if (context != null) {
            try {
                context.startActivity(ak.h(i3, str, j3));
                if (i3 == 1) {
                    a.e();
                } else if (i3 == 2) {
                    a.f();
                }
                return;
            } catch (Throwable th5) {
                CoverLog.e("CoverJumpAction", "jumpToCoverCenter fail.", th5);
                return;
            }
        }
        CoverLog.e("CoverJumpAction", "jumpToCoverCenter context null", null);
    }

    public static void jumpToUrlPageFromJceData(Context context, long j3) {
        if (context != null) {
            try {
                Intent f16 = ak.f(j3);
                if (f16 != null) {
                    context.startActivity(f16);
                } else {
                    CoverLog.e("CoverJumpAction", "jumpToUrlPageFromJceData fail.Intent is null", null);
                }
                return;
            } catch (Throwable th5) {
                CoverLog.e("CoverJumpAction", "jumpToUrlPageFromJceData fail.", th5);
                return;
            }
        }
        CoverLog.e("CoverJumpAction", "jumpToUrlPageFromJceData context null", null);
    }
}
