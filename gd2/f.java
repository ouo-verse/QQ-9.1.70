package gd2;

import com.tencent.mobileqq.perf.upload.cos.PerfCosUploader;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqperf.debug.report.PerfProblemBusinessHandler;
import jy3.MemoryLeakProblem;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0016\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002\u00a8\u0006\t"}, d2 = {"Lgd2/f;", "", "", "zipPath", "objInfo", "", "a", "<init>", "()V", "QQPerf-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final f f401967a = new f();

    f() {
    }

    public final void a(@NotNull String zipPath, @NotNull String objInfo) {
        int indexOf$default;
        Intrinsics.checkNotNullParameter(zipPath, "zipPath");
        Intrinsics.checkNotNullParameter(objInfo, "objInfo");
        try {
            indexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) objInfo, "@", 0, false, 6, (Object) null);
            String substring = objInfo.substring(indexOf$default + 1);
            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String).substring(startIndex)");
            try {
                PerfProblemBusinessHandler.INSTANCE.c(new MemoryLeakProblem("java\u5185\u5b58\u6cc4\u6f0f", objInfo, PerfCosUploader.f258269a.c(PerfCosUploader.BucketType.LEAK_FILE, zipPath, '/' + substring + ".zip", false), null, 8, null));
            } catch (Exception unused) {
                QLog.e("QQRMonitorLeakMemReporter", 1, "reportForMR error, " + StringCompanionObject.INSTANCE);
            }
        } catch (Exception unused2) {
        }
    }
}
