package er3;

import android.content.Context;
import android.content.Intent;
import com.tencent.qmethod.pandoraex.api.r;
import com.tencent.qmethod.pandoraex.core.o;
import com.tencent.qmethod.service.DexTransformService;
import cr3.c;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes22.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static c f397069a;

    public static void a(Context context, c cVar) {
        b.d(context);
        f397069a = cVar;
    }

    public static List<String> b(Context context) {
        ArrayList arrayList = new ArrayList();
        if (r.c(context, "key_transform_list").booleanValue()) {
            List<String> f16 = r.f(context, "key_transform_list", String.class);
            if (f16 == null) {
                return new ArrayList();
            }
            return f16;
        }
        return arrayList;
    }

    public static c c() {
        return f397069a;
    }

    public static void d(int i3) {
        b.f(i3);
    }

    public static void e(Context context) {
        o.a("DexMonitor", "do Transform...");
        context.startService(new Intent(context, (Class<?>) DexTransformService.class));
    }
}
