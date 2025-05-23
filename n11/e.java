package n11;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.local_edit.andserver.error.NotFoundException;
import com.tencent.local_edit.andserver.http.HttpMethod;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import org.apache.httpcore.HttpHeaders;

/* compiled from: P */
/* loaded from: classes7.dex */
public class e implements d {

    /* renamed from: a, reason: collision with root package name */
    private List<o11.b> f417984a;

    /* renamed from: b, reason: collision with root package name */
    private Map<o11.b, f> f417985b;

    /* renamed from: c, reason: collision with root package name */
    private o11.b f417986c;

    /* renamed from: d, reason: collision with root package name */
    private d f417987d;

    public e(com.tencent.local_edit.andserver.http.b bVar, List<o11.b> list, Map<o11.b, f> map) {
        this.f417984a = list;
        this.f417985b = map;
        this.f417986c = list.get(0);
        String header = bVar.getHeader("Access-Control-Request-Method");
        if (!TextUtils.isEmpty(header)) {
            o11.b c16 = b.c(this.f417984a, HttpMethod.reverse(header));
            if (c16 != null) {
                this.f417986c = c16;
            }
        }
        this.f417987d = (d) this.f417985b.get(this.f417986c);
    }

    private p11.c e(com.tencent.local_edit.andserver.http.c cVar) {
        cVar.setStatus(403);
        cVar.setHeader(HttpHeaders.ALLOW, TextUtils.join(", ", HttpMethod.values()));
        return new p11.a(new l11.b("Invalid CORS request."));
    }

    @Override // n11.d
    @Nullable
    public m11.a a() {
        return this.f417987d.a();
    }

    @Override // k11.d
    public long b(@NonNull com.tencent.local_edit.andserver.http.b bVar) throws Throwable {
        return this.f417987d.b(bVar);
    }

    @Override // k11.a
    public String c(@NonNull com.tencent.local_edit.andserver.http.b bVar) throws Throwable {
        return this.f417987d.c(bVar);
    }

    @Override // n11.f
    public p11.c d(@NonNull com.tencent.local_edit.andserver.http.b bVar, @NonNull com.tencent.local_edit.andserver.http.c cVar) throws Throwable {
        Log.d("Local_edit_andserver", "options handle uri = " + bVar.getURI());
        String header = bVar.getHeader("Origin");
        if (TextUtils.isEmpty(header)) {
            return e(cVar);
        }
        String header2 = bVar.getHeader("Access-Control-Request-Method");
        if (TextUtils.isEmpty(header2)) {
            return e(cVar);
        }
        HttpMethod reverse = HttpMethod.reverse(header2);
        o11.b c16 = b.c(this.f417984a, reverse);
        if (c16 == null) {
            return e(cVar);
        }
        d dVar = (d) this.f417985b.get(c16);
        if (dVar != null) {
            m11.a a16 = dVar.a();
            if (a16 == null) {
                return e(cVar);
            }
            ArrayList arrayList = new ArrayList();
            Collections.addAll(arrayList, a16.d());
            List<HttpMethod> b16 = c16.c().b();
            if (arrayList.isEmpty()) {
                arrayList.addAll(b16);
            }
            if (!arrayList.contains(reverse)) {
                return e(cVar);
            }
            List asList = Arrays.asList(a16.e());
            if (!asList.isEmpty() && !asList.contains("*") && !asList.contains(header)) {
                return e(cVar);
            }
            List<String> asList2 = Arrays.asList(a16.a());
            ArrayList arrayList2 = new ArrayList();
            String header3 = bVar.getHeader("Access-Control-Request-Headers");
            ArrayList<String> arrayList3 = new ArrayList();
            if (!TextUtils.isEmpty(header3)) {
                StringTokenizer stringTokenizer = new StringTokenizer(header3, ",");
                while (stringTokenizer.hasMoreTokens()) {
                    String trim = stringTokenizer.nextToken().trim();
                    if (trim.length() > 0) {
                        arrayList3.add(trim);
                    }
                }
            }
            if (asList2.contains("*")) {
                if (arrayList3.size() > 0) {
                    arrayList2.addAll(arrayList3);
                }
            } else if (asList2.size() > 0) {
                if (arrayList3.size() > 0) {
                    for (String str : asList2) {
                        for (String str2 : arrayList3) {
                            if (str.equalsIgnoreCase(str2)) {
                                arrayList2.add(str2);
                            }
                        }
                    }
                    if (arrayList2.isEmpty()) {
                        return e(cVar);
                    }
                }
            } else if (arrayList3.size() > 0) {
                arrayList2.addAll(arrayList3);
            }
            String[] b17 = a16.b();
            cVar.setHeader("Access-Control-Allow-Origin", header);
            cVar.setHeader("Access-Control-Allow-Methods", TextUtils.join(", ", arrayList));
            if (arrayList2.size() > 0) {
                cVar.setHeader("Access-Control-Allow-Headers", TextUtils.join(", ", arrayList2));
            }
            if (b17.length > 0) {
                cVar.setHeader("Access-Control-Expose-Headers", TextUtils.join(", ", b17));
            }
            cVar.setHeader("Access-Control-Allow-Credentials", Boolean.toString(a16.f()));
            cVar.setHeader("Access-Control-Max-Age", Long.toString(a16.c()));
            cVar.setHeader(HttpHeaders.ALLOW, TextUtils.join(", ", HttpMethod.values()));
            cVar.setHeader(HttpHeaders.VARY, "Origin");
            return new p11.a(new l11.b("OK"));
        }
        throw new NotFoundException();
    }
}
