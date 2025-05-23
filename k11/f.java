package k11;

import android.util.Log;
import androidx.annotation.NonNull;
import com.tencent.local_edit.andserver.http.HttpMethod;

/* compiled from: P */
/* loaded from: classes7.dex */
public class f implements c {
    @Override // k11.c
    public boolean a(@NonNull com.tencent.local_edit.andserver.http.b bVar, @NonNull com.tencent.local_edit.andserver.http.c cVar, @NonNull n11.f fVar) {
        String str;
        long j3;
        HttpMethod method = bVar.getMethod();
        if (method != HttpMethod.GET && method != HttpMethod.HEAD) {
            return false;
        }
        try {
            str = fVar.c(bVar);
        } catch (Throwable th5) {
            Log.w("AndServer", th5);
            str = null;
        }
        try {
            j3 = fVar.b(bVar);
        } catch (Throwable th6) {
            Log.w("AndServer", th6);
            j3 = -1;
        }
        return new com.tencent.local_edit.andserver.http.d(bVar, cVar).d(str, j3);
    }
}
