package kf2;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R.\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\b\u0010\n\"\u0004\b\u000b\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lkf2/c;", "", "Lorg/json/JSONObject;", "data", "", "b", "", "", "a", "Ljava/util/Map;", "()Ljava/util/Map;", "setReportMap", "(Ljava/util/Map;)V", "reportMap", "<init>", "()V", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private Map<String, String> reportMap = new LinkedHashMap();

    public final Map<String, String> a() {
        return this.reportMap;
    }

    public final void b(JSONObject data) {
        Intrinsics.checkNotNullParameter(data, "data");
        Iterator keys = data.keys();
        while (keys.hasNext()) {
            Object next = keys.next();
            Intrinsics.checkNotNull(next, "null cannot be cast to non-null type kotlin.String");
            String str = (String) next;
            Map<String, String> map = this.reportMap;
            String optString = data.optString(str);
            Intrinsics.checkNotNull(optString, "null cannot be cast to non-null type kotlin.String");
            map.put(str, optString);
        }
    }
}
