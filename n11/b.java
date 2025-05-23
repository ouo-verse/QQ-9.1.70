package n11;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.local_edit.andserver.error.ContentNotAcceptableException;
import com.tencent.local_edit.andserver.error.ContentNotSupportedException;
import com.tencent.local_edit.andserver.error.MethodNotSupportException;
import com.tencent.local_edit.andserver.framework.mapping.Mime;
import com.tencent.local_edit.andserver.http.HttpMethod;
import com.tencent.local_edit.andserver.util.MediaType;
import com.tencent.local_edit.andserver.util.g;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import o11.e;

/* compiled from: P */
/* loaded from: classes7.dex */
public abstract class b implements a, g {
    public static o11.b c(List<o11.b> list, HttpMethod httpMethod) {
        for (o11.b bVar : list) {
            if (bVar.c().b().contains(httpMethod)) {
                return bVar;
            }
        }
        return null;
    }

    public static List<HttpMethod> d(List<o11.b> list) {
        ArrayList arrayList = new ArrayList();
        Iterator<o11.b> it = list.iterator();
        while (it.hasNext()) {
            arrayList.addAll(it.next().c().b());
        }
        return arrayList;
    }

    private List<o11.b> e(List<e.b> list) {
        ArrayList arrayList = new ArrayList();
        for (o11.b bVar : g().keySet()) {
            Iterator<e.a> it = bVar.e().b().iterator();
            while (it.hasNext()) {
                if (h(it.next().a(), list)) {
                    arrayList.add(bVar);
                }
            }
        }
        return arrayList;
    }

    private List<o11.b> f(List<e.b> list) {
        ArrayList arrayList = new ArrayList();
        for (o11.b bVar : g().keySet()) {
            Iterator<e.a> it = bVar.e().b().iterator();
            while (it.hasNext()) {
                if (i(it.next().a(), list)) {
                    arrayList.add(bVar);
                }
            }
        }
        return arrayList;
    }

    private boolean h(List<e.b> list, List<e.b> list2) {
        if (list2.size() != list.size()) {
            return false;
        }
        for (int i3 = 0; i3 < list.size(); i3++) {
            e.b bVar = list.get(i3);
            if (!bVar.equals(list2.get(i3)) && !bVar.b()) {
                return false;
            }
        }
        return true;
    }

    private boolean i(List<e.b> list, List<e.b> list2) {
        if (list2.size() != list.size() || !o11.e.c(list).equals(o11.e.c(list2))) {
            return false;
        }
        return true;
    }

    private void j(Mime mime, com.tencent.local_edit.andserver.http.b bVar) {
        List<Mime.Rule> b16 = mime.b();
        MediaType contentType = bVar.getContentType();
        ArrayList arrayList = new ArrayList();
        Iterator<Mime.Rule> it = b16.iterator();
        while (true) {
            boolean z16 = true;
            if (it.hasNext()) {
                Mime.Rule next = it.next();
                String type = next.getType();
                boolean startsWith = type.startsWith("!");
                if (startsWith) {
                    type = type.substring(1);
                }
                MediaType mediaType = new MediaType(type, next.getSubtype());
                if (startsWith) {
                    if (mediaType.equalsExcludeParameter(contentType)) {
                        throw new ContentNotSupportedException(contentType);
                    }
                } else {
                    arrayList.add(mediaType);
                }
            } else {
                Iterator it5 = arrayList.iterator();
                while (true) {
                    if (it5.hasNext()) {
                        if (((MediaType) it5.next()).includes(contentType)) {
                            break;
                        }
                    } else {
                        z16 = false;
                        break;
                    }
                }
                if (z16) {
                    return;
                } else {
                    throw new ContentNotSupportedException(contentType);
                }
            }
        }
    }

    private void k(Mime mime, com.tencent.local_edit.andserver.http.b bVar) {
        List<Mime.Rule> b16 = mime.b();
        List<MediaType> d16 = bVar.d();
        for (Mime.Rule rule : b16) {
            String type = rule.getType();
            boolean startsWith = type.startsWith("!");
            if (startsWith) {
                type = type.substring(1);
            }
            MediaType mediaType = new MediaType(type, rule.getSubtype());
            Iterator<MediaType> it = d16.iterator();
            boolean z16 = false;
            while (it.hasNext()) {
                if (it.next().includes(mediaType)) {
                    z16 = true;
                }
            }
            if (startsWith && z16) {
                throw new ContentNotAcceptableException();
            }
            if (!startsWith && !z16) {
                throw new ContentNotAcceptableException();
            }
        }
    }

    @Override // n11.a
    public boolean a(@NonNull com.tencent.local_edit.andserver.http.b bVar) {
        List<e.b> d16 = o11.e.d(bVar.getPath());
        List<o11.b> f16 = f(d16);
        if (f16.isEmpty()) {
            f16 = e(d16);
        }
        if (f16.isEmpty()) {
            return false;
        }
        HttpMethod method = bVar.getMethod();
        if (method.equals(HttpMethod.OPTIONS)) {
            return true;
        }
        o11.b c16 = c(f16, method);
        if (c16 != null) {
            c16.d();
            c16.b();
            Mime a16 = c16.a();
            if (a16 != null) {
                j(a16, bVar);
            }
            Mime f17 = c16.f();
            if (f17 != null) {
                k(f17, bVar);
            }
            return true;
        }
        MethodNotSupportException methodNotSupportException = new MethodNotSupportException(method);
        methodNotSupportException.setMethods(d(f16));
        throw methodNotSupportException;
    }

    @Override // n11.a
    @Nullable
    public f b(@NonNull com.tencent.local_edit.andserver.http.b bVar) {
        List<e.b> d16 = o11.e.d(bVar.getPath());
        List<o11.b> f16 = f(d16);
        if (f16.isEmpty()) {
            f16 = e(d16);
        }
        HttpMethod method = bVar.getMethod();
        o11.b c16 = c(f16, method);
        if (method.equals(HttpMethod.OPTIONS) && c16 == null) {
            return new e(bVar, f16, g());
        }
        Mime.Rule rule = null;
        if (c16 == null) {
            return null;
        }
        Mime f17 = c16.f();
        if (f17 != null) {
            Iterator<Mime.Rule> it = f17.b().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Mime.Rule next = it.next();
                if (!next.toString().startsWith("!")) {
                    rule = next;
                    break;
                }
            }
            bVar.setAttribute("http.response.Produce", rule);
        }
        return g().get(c16);
    }

    @NonNull
    protected abstract Map<o11.b, f> g();
}
