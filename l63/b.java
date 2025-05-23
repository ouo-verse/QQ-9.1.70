package l63;

import com.tencent.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes21.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private static final Map<Float, String> f413892a;

    static {
        HashMap hashMap = new HashMap();
        f413892a = hashMap;
        hashMap.put(Float.valueOf(0.5f), "0.5");
        hashMap.put(Float.valueOf(0.75f), "0.75");
        hashMap.put(Float.valueOf(1.0f), "1.0");
        hashMap.put(Float.valueOf(1.5f), "1.5");
        hashMap.put(Float.valueOf(2.0f), SemanticAttributes.HttpFlavorValues.HTTP_2_0);
    }

    public static boolean a(float f16, float f17) {
        if (Math.abs(f16 - f17) < 0.001d) {
            return true;
        }
        return false;
    }
}
