package b01;

import com.tencent.kuikly.core.nvi.serialization.json.e;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0018\u0010\u0004\u001a\u00020\u0003*\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0000\u001a\u0014\u0010\u0007\u001a\u00020\u0006*\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0005H\u0000\u00a8\u0006\b"}, d2 = {"", "", "", "Lcom/tencent/kuikly/core/nvi/serialization/json/e;", "b", "", "Lcom/tencent/kuikly/core/nvi/serialization/json/b;", "a", "core_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes39.dex */
public final class c {
    public static final com.tencent.kuikly.core.nvi.serialization.json.b a(List<? extends Object> list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        com.tencent.kuikly.core.nvi.serialization.json.b bVar = new com.tencent.kuikly.core.nvi.serialization.json.b();
        for (Object obj : list) {
            if (obj instanceof Integer) {
                bVar.r(((Number) obj).intValue());
            } else if (obj instanceof Long) {
                bVar.s(((Number) obj).longValue());
            } else if (obj instanceof Float) {
                bVar.t(obj);
            } else if (obj instanceof Double) {
                bVar.q(((Number) obj).doubleValue());
            } else if (obj instanceof String) {
                bVar.t(obj);
            } else if (obj instanceof Boolean) {
                bVar.u(((Boolean) obj).booleanValue());
            } else if (obj instanceof Map) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.Any>");
                bVar.t(b((Map) obj));
            } else if (obj instanceof List) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any>");
                bVar.t(a((List) obj));
            } else if (obj instanceof b) {
                bVar.t(((b) obj).serialization());
            } else {
                bVar.t(null);
            }
        }
        return bVar;
    }

    public static final e b(Map<String, ? extends Object> map) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        e eVar = new e();
        for (Map.Entry<String, ? extends Object> entry : map.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            if (value instanceof Integer) {
                eVar.t(key, ((Number) value).intValue());
            } else if (value instanceof Long) {
                eVar.u(key, ((Number) value).longValue());
            } else if (value instanceof Double) {
                eVar.s(key, ((Number) value).doubleValue());
            } else if (value instanceof Float) {
                eVar.v(key, value);
            } else if (value instanceof String) {
                eVar.v(key, value);
            } else if (value instanceof Boolean) {
                eVar.t(key, ((Boolean) value).booleanValue() ? 1 : 0);
            } else if (value instanceof Map) {
                Intrinsics.checkNotNull(value, "null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.Any>");
                eVar.v(key, b((Map) value));
            } else if (value instanceof List) {
                Intrinsics.checkNotNull(value, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any>");
                eVar.v(key, a((List) value));
            } else if (value instanceof b) {
                eVar.v(key, ((b) value).serialization());
            } else {
                eVar.v(key, null);
            }
        }
        return eVar;
    }
}
