package o11;

import androidx.annotation.NonNull;
import com.tencent.local_edit.andserver.http.HttpMethod;
import java.util.LinkedList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes7.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private List<HttpMethod> f421725a = new LinkedList();

    public void a(@NonNull String str) {
        this.f421725a.add(HttpMethod.reverse(str));
    }

    @NonNull
    public List<HttpMethod> b() {
        return this.f421725a;
    }
}
