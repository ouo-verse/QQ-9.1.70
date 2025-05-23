package m72;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\u0002\u00a2\u0006\u0004\b\t\u0010\nR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\b\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0004\u001a\u0004\b\u0003\u0010\u0006\u00a8\u0006\u000b"}, d2 = {"Lm72/c;", "", "", "a", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "url", "saveFilePath", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final String url;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final String saveFilePath;

    public c(String url, String saveFilePath) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(saveFilePath, "saveFilePath");
        this.url = url;
        this.saveFilePath = saveFilePath;
    }

    /* renamed from: a, reason: from getter */
    public final String getSaveFilePath() {
        return this.saveFilePath;
    }

    /* renamed from: b, reason: from getter */
    public final String getUrl() {
        return this.url;
    }
}
