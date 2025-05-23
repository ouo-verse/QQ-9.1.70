package nu3;

import com.tencent.ecommerce.base.report.api.IECDtReport;
import com.tencent.qqmini.proxyimpl.tavcutplugin.apiproxy.TavImageGenerator;
import com.tencent.qqmini.proxyimpl.tavcutplugin.apiproxy.o;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010%\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u00012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0086\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0001J\u000e\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0001J\u0010\u0010\t\u001a\u00020\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0001J\u000e\u0010\u000b\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0002J\b\u0010\f\u001a\u00020\u0002H\u0016R\"\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00010\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lnu3/g;", "", "", "identity", "a", "obj", "c", "b", "", "d", IECDtReport.ACTION_IDENTIFIER, "e", "toString", "", "Ljava/util/Map;", "objectMap", "<init>", "()V", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    public static final g f421341a = new g();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final Map<String, Object> objectMap = new HashMap();

    g() {
    }

    public final Object a(String identity) {
        return objectMap.get(identity);
    }

    public final String b(Object obj) {
        Intrinsics.checkNotNullParameter(obj, "obj");
        int identityHashCode = System.identityHashCode(obj);
        StringBuilder sb5 = new StringBuilder();
        sb5.append(identityHashCode);
        return sb5.toString();
    }

    public final void e(String identifier) {
        Intrinsics.checkNotNullParameter(identifier, "identifier");
        ee4.b.i("TavObjPool", "release() called with: identifier = [" + identifier + "]");
        Map<String, Object> map = objectMap;
        Object remove = map.remove(identifier);
        if (remove instanceof o) {
            ((o) remove).k();
        }
        if (remove instanceof com.tencent.tavcut.session.a) {
            ((com.tencent.tavcut.session.a) remove).release();
        }
        if (remove instanceof TavImageGenerator) {
            ((TavImageGenerator) remove).e();
        }
        ee4.b.a("TavObjPool", "release: objMap = " + map);
    }

    public String toString() {
        return "ObjPool{objectMap.size=" + objectMap.size() + "}";
    }

    public final String c(Object obj) {
        if (obj == null) {
            return "-1";
        }
        String b16 = b(obj);
        Map<String, Object> map = objectMap;
        if (map.containsKey(b16)) {
            return b16;
        }
        ee4.b.a("TavObjPool", "put() called with: obj = [" + obj + "]");
        map.put(b16, obj);
        return b16;
    }

    public final void d(Object obj) {
        if (obj == null) {
            return;
        }
        e(b(obj));
    }
}
