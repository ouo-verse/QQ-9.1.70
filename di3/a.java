package di3;

import java.io.File;
import kotlin.Metadata;
import mqq.app.MobileQQ;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tJ\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002R\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Ldi3/a;", "", "Ljava/io/File;", "b", "Ljava/io/File;", "a", "()Ljava/io/File;", "PARENT_CACHE_FILE", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f393982a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final File PARENT_CACHE_FILE;

    static {
        a aVar = new a();
        f393982a = aVar;
        PARENT_CACHE_FILE = aVar.b();
    }

    a() {
    }

    private final File b() {
        return MobileQQ.sMobileQQ.getApplicationContext().getExternalCacheDir();
    }

    public final File a() {
        return PARENT_CACHE_FILE;
    }
}
