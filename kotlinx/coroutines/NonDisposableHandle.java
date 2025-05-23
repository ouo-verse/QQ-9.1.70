package kotlinx.coroutines;

import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@InternalCoroutinesApi
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u00c7\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0003J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016R\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u00058VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\u0010"}, d2 = {"Lkotlinx/coroutines/NonDisposableHandle;", "Lkotlinx/coroutines/DisposableHandle;", "Lkotlinx/coroutines/ChildHandle;", "()V", HippyNestedScrollComponent.PRIORITY_PARENT, "Lkotlinx/coroutines/Job;", "getParent", "()Lkotlinx/coroutines/Job;", "childCancelled", "", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_CAUSE, "", "dispose", "", "toString", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes28.dex */
public final class NonDisposableHandle implements DisposableHandle, ChildHandle {

    @NotNull
    public static final NonDisposableHandle INSTANCE = new NonDisposableHandle();

    NonDisposableHandle() {
    }

    @Override // kotlinx.coroutines.ChildHandle
    public boolean childCancelled(@NotNull Throwable cause) {
        return false;
    }

    @Override // kotlinx.coroutines.ChildHandle
    @Nullable
    public Job getParent() {
        return null;
    }

    @NotNull
    public String toString() {
        return "NonDisposableHandle";
    }

    @Override // kotlinx.coroutines.DisposableHandle
    public void dispose() {
    }
}
