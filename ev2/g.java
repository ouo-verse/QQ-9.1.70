package ev2;

import android.content.Context;
import android.content.Intent;
import androidx.fragment.app.Fragment;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.bridge.info.QADLandingPageInfo;

/* compiled from: P */
/* loaded from: classes19.dex */
public final class g {
    public static void a(Context context, QADLandingPageInfo qADLandingPageInfo) {
        hv2.h hVar;
        if (qADLandingPageInfo != null && (hVar = (hv2.h) dv2.b.d().a(hv2.h.class)) != null) {
            hVar.a(context, qADLandingPageInfo);
        }
    }

    public static void b(Context context, Intent intent, Class<? extends Fragment> cls) {
        hv2.h hVar;
        if (context != null && intent != null && (hVar = (hv2.h) dv2.b.d().a(hv2.h.class)) != null) {
            hVar.b(context, intent, cls);
        }
    }
}
