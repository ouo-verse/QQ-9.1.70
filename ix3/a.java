package ix3;

import com.tencent.freesia.IConfigData;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\"\u0010\r\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lix3/a;", "Lcom/tencent/freesia/IConfigData;", "", "d", "Ljava/lang/String;", "CACHE_SIZE", "", "e", "I", "a", "()I", "setCacheSize", "(I)V", "cacheSize", "<init>", "()V", "relation_common_business_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class a implements IConfigData {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final String CACHE_SIZE = "cache_size";

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private int cacheSize = 200;

    /* renamed from: a, reason: from getter */
    public final int getCacheSize() {
        return this.cacheSize;
    }
}
