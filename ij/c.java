package ij;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u001a\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b$\u0010%J\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0004\u001a\u00020\u0002R\"\u0010\u000b\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\"\u0010\u0012\u001a\u00020\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0004\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\"\u0010\u0016\u001a\u00020\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\r\u001a\u0004\b\u0014\u0010\u000f\"\u0004\b\u0015\u0010\u0011R\"\u0010\u0019\u001a\u00020\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0017\u0010\r\u001a\u0004\b\u0018\u0010\u000f\"\u0004\b\u0013\u0010\u0011R\"\u0010\u001f\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\"\u0010\"\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b \u0010\u0006\u001a\u0004\b!\u0010\b\"\u0004\b\u0017\u0010\nR\"\u0010#\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001d\u0010\u001a\u001a\u0004\b#\u0010\u001c\"\u0004\b \u0010\u001e\u00a8\u0006&"}, d2 = {"Lij/c;", "", "", "a", "b", "", "Ljava/lang/String;", "getSpaceId", "()Ljava/lang/String;", tl.h.F, "(Ljava/lang/String;)V", "spaceId", "", "I", "getJobStatus", "()I", "e", "(I)V", "jobStatus", "c", "getAuthAction", "setAuthAction", "authAction", "d", "getAuthStatus", "authStatus", "Z", "getShowToolTips", "()Z", "g", "(Z)V", "showToolTips", "f", "getJobId", "jobId", "isOtherAgree", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class c {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean showToolTips;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private boolean isOtherAgree;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private String spaceId = "";

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private int jobStatus = -1;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private int authAction = -1;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private int authStatus = -1;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private String jobId = "";

    public final boolean a() {
        return this.showToolTips && this.jobStatus == 1;
    }

    public final boolean b() {
        return this.showToolTips && this.jobStatus != 1;
    }

    public final void c(int i3) {
        this.authStatus = i3;
    }

    public final void d(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.jobId = str;
    }

    public final void e(int i3) {
        this.jobStatus = i3;
    }

    public final void f(boolean z16) {
        this.isOtherAgree = z16;
    }

    public final void g(boolean z16) {
        this.showToolTips = z16;
    }

    public final void h(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.spaceId = str;
    }
}
