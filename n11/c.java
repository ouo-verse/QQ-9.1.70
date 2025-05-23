package n11;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.local_edit.andserver.http.HttpMethod;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import o11.e;
import org.apache.httpcore.HttpHeaders;

/* compiled from: P */
/* loaded from: classes7.dex */
public abstract class c implements d {

    /* renamed from: a, reason: collision with root package name */
    private final Object f417980a;

    /* renamed from: b, reason: collision with root package name */
    private final o11.b f417981b;

    /* renamed from: c, reason: collision with root package name */
    private final o11.a f417982c;

    /* renamed from: d, reason: collision with root package name */
    private final m11.a f417983d;

    public c(@NonNull Object obj, @NonNull o11.b bVar, @NonNull o11.a aVar, @Nullable m11.a aVar2) {
        this.f417980a = obj;
        this.f417981b = bVar;
        this.f417982c = aVar;
        this.f417983d = aVar2;
    }

    private p11.c g(com.tencent.local_edit.andserver.http.c cVar, HttpMethod... httpMethodArr) {
        cVar.setStatus(403);
        if (httpMethodArr != null && httpMethodArr.length > 0) {
            cVar.setHeader(HttpHeaders.ALLOW, TextUtils.join(", ", httpMethodArr));
        }
        return new p11.a(new l11.b("Invalid CORS request."));
    }

    @Override // n11.d
    @Nullable
    public m11.a a() {
        return this.f417983d;
    }

    @Override // k11.d
    public long b(@NonNull com.tencent.local_edit.andserver.http.b bVar) throws Throwable {
        Object e16 = e();
        if (e16 instanceof k11.d) {
            return ((k11.d) e16).b(bVar);
        }
        return -1L;
    }

    @Override // k11.a
    public String c(@NonNull com.tencent.local_edit.andserver.http.b bVar) throws Throwable {
        Object e16 = e();
        if (e16 instanceof k11.a) {
            return ((k11.a) e16).c(bVar);
        }
        return null;
    }

    @Override // n11.f
    public p11.c d(@NonNull com.tencent.local_edit.andserver.http.b bVar, @NonNull com.tencent.local_edit.andserver.http.c cVar) throws Throwable {
        boolean z16;
        String header = bVar.getHeader("Origin");
        Log.d("Local_edit_andserver", "mapping handle request=" + bVar.getURI());
        if (this.f417983d != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        Log.d("Local_edit_andserver", "mapping handle origin=" + header + " mCrossOrigin= " + z16);
        if (!TextUtils.isEmpty(header) && this.f417983d != null) {
            HttpMethod method = bVar.getMethod();
            List asList = Arrays.asList(this.f417983d.d());
            Log.d("Local_edit_andserver", "mapping handle allowMethods=" + asList.isEmpty() + " method= " + method.toString());
            if (!asList.isEmpty() && !asList.contains(method)) {
                return g(cVar, new HttpMethod[0]);
            }
            cVar.setHeader("Access-Control-Allow-Origin", header);
            cVar.setHeader("Access-Control-Allow-Credentials", Boolean.toString(this.f417983d.f()));
            cVar.setHeader(HttpHeaders.VARY, "Origin");
        }
        Log.d("Local_edit_andserver", "mapping handle end");
        return h(bVar, cVar);
    }

    @NonNull
    protected Object e() {
        return this.f417980a;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NonNull
    public Map<String, String> f(@NonNull String str) {
        boolean z16;
        List<e.b> d16 = o11.e.d(str);
        Iterator<e.a> it = this.f417981b.e().b().iterator();
        while (it.hasNext()) {
            List<e.b> a16 = it.next().a();
            if (d16.size() == a16.size()) {
                if (o11.e.c(a16).equals(str)) {
                    return Collections.emptyMap();
                }
                int i3 = 0;
                boolean z17 = false;
                while (true) {
                    if (i3 < a16.size()) {
                        e.b bVar = a16.get(i3);
                        boolean b16 = bVar.b();
                        if (!z17 && !b16) {
                            z17 = false;
                        } else {
                            z17 = true;
                        }
                        if (!bVar.equals(d16.get(i3)) && !b16) {
                            z16 = false;
                            break;
                        }
                        i3++;
                    } else {
                        z16 = true;
                        break;
                    }
                }
                if (z16 && z17) {
                    HashMap hashMap = new HashMap();
                    for (int i16 = 0; i16 < a16.size(); i16++) {
                        e.b bVar2 = a16.get(i16);
                        if (bVar2.b()) {
                            e.b bVar3 = d16.get(i16);
                            String a17 = bVar2.a();
                            hashMap.put(a17.substring(1, a17.length() - 1), bVar3.a());
                        }
                    }
                    return hashMap;
                }
            }
        }
        return Collections.emptyMap();
    }

    protected abstract p11.c h(com.tencent.local_edit.andserver.http.b bVar, com.tencent.local_edit.andserver.http.c cVar) throws Throwable;
}
