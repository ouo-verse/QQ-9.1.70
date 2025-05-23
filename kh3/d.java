package kh3;

import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import yh3.ZPlanHotPatchVersionInfo;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u0006\u0010\u0003\u001a\u00020\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\t\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0016R\"\u0010\u0010\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0011\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\u000b\u00a8\u0006\u0014"}, d2 = {"Lkh3/d;", "Lji3/d;", "", "d", "Lyh3/e;", "versionInfo", "a", "", "errCode", "b", "", "Z", "c", "()Z", "setMIsHotPatchSuccess", "(Z)V", "mIsHotPatchSuccess", "mIsStartHotPatch", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class d implements ji3.d {

    /* renamed from: a, reason: collision with root package name */
    public static final d f412402a = new d();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static boolean mIsHotPatchSuccess = true;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static boolean mIsStartHotPatch;

    d() {
    }

    @Override // ji3.d
    public void a(ZPlanHotPatchVersionInfo versionInfo) {
        Intrinsics.checkNotNullParameter(versionInfo, "versionInfo");
        QLog.i("[zplan][ZPlanEmoticonHotPatchStatusManager]", 1, "start hot patch");
        mIsStartHotPatch = true;
    }

    @Override // ji3.d
    public void b(int errCode) {
        if (mIsStartHotPatch) {
            QLog.i("[zplan][ZPlanEmoticonHotPatchStatusManager]", 1, "finish hot patch errCode: " + errCode);
            mIsHotPatchSuccess = errCode == 0;
            mIsStartHotPatch = false;
        }
    }

    public final boolean c() {
        return mIsHotPatchSuccess;
    }

    public final void d() {
        mIsHotPatchSuccess = true;
        mIsStartHotPatch = false;
    }
}
