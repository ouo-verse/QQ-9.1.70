package nm4;

import android.app.Activity;
import android.content.Context;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.timi.game.scheme.tools.SchemeUtil;
import com.tencent.timi.game.utils.l;

/* compiled from: P */
/* loaded from: classes26.dex */
public class a {
    public static boolean a(String str) {
        return b(str, vf4.a.b());
    }

    public static boolean b(String str, Activity activity) {
        return c(str, activity, null);
    }

    public static boolean c(String str, Activity activity, SchemeUtil.c cVar) {
        String str2 = SchemeUtil.f379338b;
        boolean z16 = activity instanceof QBaseActivity;
        Context context = activity;
        if (!z16) {
            context = eh4.a.b();
        }
        boolean g16 = SchemeUtil.g(context, str, str2, false, cVar);
        l.h("GameSchemeUtil", 1, "launchGameScheme, ret = " + g16);
        return g16;
    }
}
