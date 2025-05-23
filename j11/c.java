package j11;

import android.content.Context;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.local_edit.andserver.error.NotFoundException;
import com.tencent.local_edit.andserver.error.ServerInternalException;
import com.tencent.local_edit.andserver.http.cookie.Cookie;
import com.tencent.local_edit.andserver.http.f;
import com.tencent.local_edit.andserver.http.g;
import com.tencent.local_edit.andserver.http.i;
import com.tencent.local_edit.andserver.http.j;
import com.tencent.local_edit.andserver.http.k;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import k11.b;
import org.apache.httpcore.HttpRequest;
import org.apache.httpcore.HttpResponse;
import org.apache.httpcore.protocol.HttpContext;
import org.apache.httpcore.protocol.HttpRequestHandler;

/* compiled from: P */
/* loaded from: classes7.dex */
public class c implements HttpRequestHandler, s11.b {

    /* renamed from: a, reason: collision with root package name */
    private final Context f409080a;

    /* renamed from: b, reason: collision with root package name */
    private r11.c f409081b;

    /* renamed from: c, reason: collision with root package name */
    private k11.e f409082c;

    /* renamed from: f, reason: collision with root package name */
    private List<n11.a> f409085f = new LinkedList();

    /* renamed from: g, reason: collision with root package name */
    private List<k11.c> f409086g = new LinkedList();

    /* renamed from: d, reason: collision with root package name */
    private p11.d f409083d = new p11.d();

    /* renamed from: e, reason: collision with root package name */
    private k11.b f409084e = new b.C10626b(k11.b.f411393a);

    /* compiled from: P */
    /* loaded from: classes7.dex */
    class a implements f {
        a() {
        }

        @Override // com.tencent.local_edit.andserver.http.f
        public void a(@NonNull com.tencent.local_edit.andserver.http.b bVar, @NonNull com.tencent.local_edit.andserver.http.c cVar) {
            c.this.f(bVar, cVar);
        }
    }

    public c(Context context) {
        this.f409080a = context;
        this.f409081b = new r11.f(context);
        this.f409086g.add(new k11.f());
    }

    private n11.a d(com.tencent.local_edit.andserver.http.b bVar) {
        for (n11.a aVar : this.f409085f) {
            if (aVar.a(bVar)) {
                return aVar;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(com.tencent.local_edit.andserver.http.b bVar, com.tencent.local_edit.andserver.http.c cVar) {
        n11.a d16;
        boolean z16;
        com.tencent.local_edit.andserver.http.multipart.f fVar = new com.tencent.local_edit.andserver.http.multipart.f();
        try {
            if (fVar.c(bVar)) {
                c(fVar);
                bVar = fVar.b(bVar);
            }
            d16 = d(bVar);
        } catch (Throwable th5) {
            try {
                try {
                    this.f409084e.a(bVar, cVar, th5);
                } catch (Exception e16) {
                    ServerInternalException serverInternalException = new ServerInternalException(e16);
                    cVar.setStatus(500);
                    cVar.b(new l11.b(serverInternalException.getMessage()));
                }
                h(bVar, cVar);
                if (!(bVar instanceof com.tencent.local_edit.andserver.http.multipart.c)) {
                    return;
                }
            } finally {
                if (bVar instanceof com.tencent.local_edit.andserver.http.multipart.c) {
                    fVar.a((com.tencent.local_edit.andserver.http.multipart.c) bVar);
                }
            }
        }
        if (d16 != null) {
            n11.f b16 = d16.b(bVar);
            if (b16 != null) {
                if (g(bVar, cVar, b16)) {
                    if (z16) {
                        return;
                    } else {
                        return;
                    }
                }
                bVar.setAttribute("android.context", this.f409080a);
                bVar.setAttribute("http.message.converter", this.f409082c);
                this.f409083d.b(b16.d(bVar, cVar), bVar, cVar);
                h(bVar, cVar);
                if (!(bVar instanceof com.tencent.local_edit.andserver.http.multipart.c)) {
                    return;
                }
                fVar.a((com.tencent.local_edit.andserver.http.multipart.c) bVar);
                return;
            }
            throw new NotFoundException(bVar.getPath());
        }
        throw new NotFoundException(bVar.getPath());
    }

    private boolean g(com.tencent.local_edit.andserver.http.b bVar, com.tencent.local_edit.andserver.http.c cVar, n11.f fVar) throws Exception {
        Iterator<k11.c> it = this.f409086g.iterator();
        while (it.hasNext()) {
            if (it.next().a(bVar, cVar, fVar)) {
                return true;
            }
        }
        return false;
    }

    private void h(com.tencent.local_edit.andserver.http.b bVar, com.tencent.local_edit.andserver.http.c cVar) {
        Object attribute = bVar.getAttribute("http.request.Session");
        if (attribute instanceof r11.b) {
            r11.b bVar2 = (r11.b) attribute;
            try {
                this.f409081b.a(bVar2);
            } catch (IOException e16) {
                Log.e("AndServer", "Session persistence failed.", e16);
            }
            Cookie cookie = new Cookie("ASESSIONID", bVar2.getId());
            cookie.setPath("/");
            cookie.setHttpOnly(true);
            cVar.c(cookie);
        }
    }

    @Override // s11.b
    public void a(@NonNull n11.a aVar) {
        com.tencent.local_edit.andserver.util.a.c(aVar, "The adapter cannot be null.");
        if (!this.f409085f.contains(aVar)) {
            this.f409085f.add(aVar);
        }
    }

    @Nullable
    public f e(com.tencent.local_edit.andserver.http.b bVar, String str) {
        com.tencent.local_edit.andserver.http.b bVar2 = bVar;
        while (bVar2 instanceof g) {
            bVar2 = ((g) bVar).e();
        }
        ((j) bVar2).k(str);
        if (d(bVar2) != null) {
            return new a();
        }
        throw new NotFoundException(bVar.getPath());
    }

    @Override // org.apache.httpcore.protocol.HttpRequestHandler
    public void handle(HttpRequest httpRequest, HttpResponse httpResponse, HttpContext httpContext) {
        f(new j(httpRequest, new i(httpContext), this, this.f409081b), new k(httpResponse));
    }

    private void c(com.tencent.local_edit.andserver.http.multipart.d dVar) {
    }
}
