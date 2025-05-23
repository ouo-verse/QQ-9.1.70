package p11;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.local_edit.andserver.error.NotFoundException;
import com.tencent.local_edit.andserver.error.ServerInternalException;
import com.tencent.local_edit.andserver.http.f;
import com.tencent.local_edit.andserver.http.h;
import com.tencent.local_edit.andserver.util.MediaType;
import com.tencent.local_edit.andserver.util.g;
import k11.e;

/* compiled from: P */
/* loaded from: classes7.dex */
public class d implements g {

    /* renamed from: h, reason: collision with root package name */
    private e f424890h;

    @Nullable
    private MediaType a(@NonNull com.tencent.local_edit.andserver.http.b bVar) {
        Object attribute = bVar.getAttribute("http.response.Produce");
        if (attribute instanceof MediaType) {
            return (MediaType) attribute;
        }
        return null;
    }

    private void c(Object obj, @NonNull com.tencent.local_edit.andserver.http.b bVar, @NonNull com.tencent.local_edit.andserver.http.c cVar) {
        if (obj instanceof CharSequence) {
            String obj2 = obj.toString();
            if (TextUtils.isEmpty(obj2)) {
                return;
            }
            if (obj2.matches("redirect:(.)*")) {
                cVar.setStatus(302);
                if (obj2.length() >= 9) {
                    cVar.setHeader("Location", obj2.substring(9));
                    return;
                }
                return;
            }
            if (obj2.matches("forward:(.)*")) {
                String substring = obj2.substring(8);
                f b16 = bVar.b(substring);
                if (b16 != null) {
                    b16.a(bVar, cVar);
                    return;
                }
                throw new NotFoundException(substring);
            }
            if (obj2.matches(g.f119883c)) {
                String str = obj2 + ".html";
                f b17 = bVar.b(str);
                if (b17 != null) {
                    b17.a(bVar, cVar);
                    return;
                }
                throw new NotFoundException(str);
            }
            throw new NotFoundException(obj2);
        }
        throw new ServerInternalException(String.format("The return value of [%s] is not supported", obj));
    }

    private void d(Object obj, @NonNull com.tencent.local_edit.andserver.http.b bVar, @NonNull com.tencent.local_edit.andserver.http.c cVar) {
        if (obj instanceof h) {
            cVar.b((h) obj);
            return;
        }
        e eVar = this.f424890h;
        if (eVar != null) {
            cVar.b(eVar.a(obj, a(bVar)));
            return;
        }
        if (obj == null) {
            cVar.b(new l11.b(""));
        } else if (obj instanceof String) {
            cVar.b(new l11.b(obj.toString(), a(bVar)));
        } else {
            cVar.b(new l11.b(obj.toString()));
        }
    }

    public void b(@Nullable c cVar, @NonNull com.tencent.local_edit.andserver.http.b bVar, @NonNull com.tencent.local_edit.andserver.http.c cVar2) {
        if (cVar == null) {
            return;
        }
        Object b16 = cVar.b();
        if (cVar.a()) {
            d(b16, bVar, cVar2);
        } else {
            c(b16, bVar, cVar2);
        }
    }
}
