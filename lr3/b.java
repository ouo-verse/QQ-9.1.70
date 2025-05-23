package lr3;

import javax.net.ssl.HostnameVerifier;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\f\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rR\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R.\u0010\u000b\u001a\u0004\u0018\u00010\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u00028F@FX\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\u0003\u0010\b\"\u0004\b\t\u0010\n\u00a8\u0006\u000e"}, d2 = {"Llr3/b;", "", "Ljavax/net/ssl/HostnameVerifier;", "a", "Ljavax/net/ssl/HostnameVerifier;", "DEFAULT_NAME_VERIFIER", "value", "b", "()Ljavax/net/ssl/HostnameVerifier;", "setNameVerifier", "(Ljavax/net/ssl/HostnameVerifier;)V", "nameVerifier", "<init>", "()V", "qmethod-privacy-monitor_tencentBuglyRelease"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes22.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private static final HostnameVerifier DEFAULT_NAME_VERIFIER;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static HostnameVerifier nameVerifier;

    /* renamed from: c, reason: collision with root package name */
    public static final b f415472c = new b();

    static {
        a aVar = new a();
        DEFAULT_NAME_VERIFIER = aVar;
        nameVerifier = aVar;
    }

    b() {
    }

    @Nullable
    public final HostnameVerifier a() {
        HostnameVerifier hostnameVerifier = nameVerifier;
        if (hostnameVerifier == null) {
            return DEFAULT_NAME_VERIFIER;
        }
        return hostnameVerifier;
    }
}
