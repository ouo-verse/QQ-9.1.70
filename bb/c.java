package bb;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\r\u001a\u00020\f\u00a2\u0006\u0004\b\u000e\u0010\u000fR\"\u0010\b\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\"\u0010\u000b\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0005\"\u0004\b\t\u0010\u0007\u00a8\u0006\u0010"}, d2 = {"Lbb/c;", "Lo9/b;", "", "f", "Ljava/lang/String;", "()Ljava/lang/String;", tl.h.F, "(Ljava/lang/String;)V", "uin", "g", "e", "lloc", "", "action", "<init>", "(I)V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes39.dex */
public final class c extends o9.b {

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private String uin;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private String lloc;

    public c(int i3) {
        super(i3);
        this.uin = "";
        this.lloc = "";
    }

    /* renamed from: e, reason: from getter */
    public final String getLloc() {
        return this.lloc;
    }

    /* renamed from: f, reason: from getter */
    public final String getUin() {
        return this.uin;
    }

    public final void g(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.lloc = str;
    }

    public final void h(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.uin = str;
    }
}
