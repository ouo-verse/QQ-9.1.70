package o00;

import com.tencent.biz.pubaccount.weishi.util.bb;
import java.util.Map;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0018\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J\u0018\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J\u0006\u0010\b\u001a\u00020\u0007J\u0006\u0010\n\u001a\u00020\t\u00a8\u0006\r"}, d2 = {"Lo00/d;", "", "", "key", "default", "b", "d", "", "a", "", "c", "<init>", "()V", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public static final d f421669a = new d();

    d() {
    }

    private final String b(String key, String r36) {
        String str;
        Map<String, String> q16 = com.tencent.biz.pubaccount.weishi.config.experiment.b.h().q();
        return (q16 == null || (str = q16.get(key)) == null) ? r36 : str;
    }

    private final String d(String key, String r36) {
        String str;
        Map<String, String> r16 = com.tencent.biz.pubaccount.weishi.config.experiment.b.h().r();
        return (r16 == null || (str = r16.get(key)) == null) ? r36 : str;
    }

    public final int a() {
        return bb.Y(b("count", ""), 0);
    }

    public final long c() {
        long Z = bb.Z(d("time_out", ""), 30000L);
        if (Z <= 0) {
            return 30000L;
        }
        return Z;
    }
}
