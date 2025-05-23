package k11;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.local_edit.andserver.error.HttpException;
import com.tencent.local_edit.andserver.error.MethodNotSupportException;
import com.tencent.local_edit.andserver.http.HttpMethod;
import java.util.List;
import org.apache.httpcore.HttpHeaders;

/* compiled from: P */
/* loaded from: classes7.dex */
public interface b {

    /* renamed from: a, reason: collision with root package name */
    public static final b f411393a = new a();

    /* compiled from: P */
    /* loaded from: classes7.dex */
    class a implements b {
        a() {
        }

        @Override // k11.b
        public void a(@NonNull com.tencent.local_edit.andserver.http.b bVar, @NonNull com.tencent.local_edit.andserver.http.c cVar, @NonNull Throwable th5) {
            if (th5 instanceof HttpException) {
                cVar.setStatus(((HttpException) th5).getStatusCode());
            } else {
                cVar.setStatus(500);
            }
            cVar.b(new l11.b(th5.getMessage()));
        }
    }

    /* compiled from: P */
    /* renamed from: k11.b$b, reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static class C10626b implements b {

        /* renamed from: b, reason: collision with root package name */
        private final b f411394b;

        public C10626b(b bVar) {
            this.f411394b = bVar;
        }

        @Override // k11.b
        public void a(@NonNull com.tencent.local_edit.andserver.http.b bVar, @NonNull com.tencent.local_edit.andserver.http.c cVar, @NonNull Throwable th5) {
            List<HttpMethod> methods;
            if ((th5 instanceof MethodNotSupportException) && (methods = ((MethodNotSupportException) th5).getMethods()) != null && methods.size() > 0) {
                cVar.setHeader(HttpHeaders.ALLOW, TextUtils.join(", ", methods));
            }
            this.f411394b.a(bVar, cVar, th5);
        }
    }

    void a(@NonNull com.tencent.local_edit.andserver.http.b bVar, @NonNull com.tencent.local_edit.andserver.http.c cVar, @NonNull Throwable th5);
}
