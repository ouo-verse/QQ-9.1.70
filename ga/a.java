package ga;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0013\u0010\u0014R\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\u000b\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u0004\u001a\u0004\b\u0003\u0010\u0006\"\u0004\b\n\u0010\bR\"\u0010\u0012\u001a\u00020\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\r\u0010\u000f\"\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lga/a;", "", "", "a", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "e", "(Ljava/lang/String;)V", "coverPicBgUrl", "d", "coverPicAnimUrl", "", "c", "I", "()I", "f", "(I)V", "from", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private String coverPicBgUrl = "";

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private String coverPicAnimUrl = "";

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private int from;

    /* renamed from: a, reason: from getter */
    public final String getCoverPicAnimUrl() {
        return this.coverPicAnimUrl;
    }

    /* renamed from: b, reason: from getter */
    public final String getCoverPicBgUrl() {
        return this.coverPicBgUrl;
    }

    /* renamed from: c, reason: from getter */
    public final int getFrom() {
        return this.from;
    }

    public final void d(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.coverPicAnimUrl = str;
    }

    public final void e(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.coverPicBgUrl = str;
    }

    public final void f(int i3) {
        this.from = i3;
    }
}
