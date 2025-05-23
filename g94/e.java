package g94;

import androidx.lifecycle.MutableLiveData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u000e\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tR\u001d\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00020\f8\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\r\u0010\u000fR\u001d\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00060\f8\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u000e\u001a\u0004\b\u0011\u0010\u000fR\u001d\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\t0\f8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u000e\u001a\u0004\b\u0013\u0010\u000f\u00a8\u0006\u0017"}, d2 = {"Lg94/e;", "", "", "isSide", "", "e", "", "slotId", "f", "Lg94/d;", "info", "d", "Landroidx/lifecycle/MutableLiveData;", "b", "Landroidx/lifecycle/MutableLiveData;", "()Landroidx/lifecycle/MutableLiveData;", "sideLiveData", "c", "slotIdLiveData", "a", "faceResetLiveData", "<init>", "()V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public static final e f401573a = new e();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final MutableLiveData<Boolean> sideLiveData = new MutableLiveData<>();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static final MutableLiveData<Integer> slotIdLiveData = new MutableLiveData<>();

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static final MutableLiveData<FaceResetInfo> faceResetLiveData = new MutableLiveData<>();

    e() {
    }

    public final MutableLiveData<FaceResetInfo> a() {
        return faceResetLiveData;
    }

    public final MutableLiveData<Boolean> b() {
        return sideLiveData;
    }

    public final MutableLiveData<Integer> c() {
        return slotIdLiveData;
    }

    public final void d(FaceResetInfo info) {
        Intrinsics.checkNotNullParameter(info, "info");
        faceResetLiveData.postValue(info);
    }

    public final void e(boolean isSide) {
        sideLiveData.postValue(Boolean.valueOf(isSide));
    }

    public final void f(int slotId) {
        slotIdLiveData.postValue(Integer.valueOf(slotId));
    }
}
