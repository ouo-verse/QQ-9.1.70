package p9;

import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0016\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u000b\u0010\fR\"\u0010\u0005\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\u0003\u0010\u0006\"\u0004\b\t\u0010\b\u00a8\u0006\r"}, d2 = {"Lp9/b;", "", "", "a", "Z", "isNeedToReportAfterRsp", "()Z", "b", "(Z)V", "c", "isNeedToReportPgExposure", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public class b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private boolean isNeedToReportAfterRsp = true;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private boolean isNeedToReportPgExposure;

    /* renamed from: a, reason: from getter */
    public final boolean getIsNeedToReportPgExposure() {
        return this.isNeedToReportPgExposure;
    }

    public final void b(boolean z16) {
        this.isNeedToReportAfterRsp = z16;
    }

    public final void c(boolean z16) {
        this.isNeedToReportPgExposure = z16;
    }
}
