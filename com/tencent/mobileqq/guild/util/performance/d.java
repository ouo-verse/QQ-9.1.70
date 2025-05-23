package com.tencent.mobileqq.guild.util.performance;

import android.os.Process;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\b\n\u0002\u0010\t\n\u0002\b\u0006\u001a\u0006\u0010\u0001\u001a\u00020\u0000\u001a\u0006\u0010\u0002\u001a\u00020\u0000\u001a\u0006\u0010\u0003\u001a\u00020\u0000\u001a\u000f\u0010\u0004\u001a\u0004\u0018\u00010\u0000\u00a2\u0006\u0004\b\u0004\u0010\u0005\u00a8\u0006\u0006"}, d2 = {"", "d", "c", "b", "a", "()Ljava/lang/Long;", "qqguild-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class d {
    @Nullable
    public static final Long a() {
        try {
            String[] a16 = a.a(Process.myPid());
            String str = a16[1];
            Intrinsics.checkNotNullExpressionValue(str, "processResult[1]");
            long parseLong = Long.parseLong(str);
            String str2 = a16[2];
            Intrinsics.checkNotNullExpressionValue(str2, "processResult[2]");
            long parseLong2 = Long.parseLong(str2);
            String str3 = a16[3];
            Intrinsics.checkNotNullExpressionValue(str3, "processResult[3]");
            long parseLong3 = Long.parseLong(str3);
            String str4 = a16[4];
            Intrinsics.checkNotNullExpressionValue(str4, "processResult[4]");
            return Long.valueOf(parseLong + parseLong2 + parseLong3 + Long.parseLong(str4));
        } catch (Exception e16) {
            QLog.e("PerformanceUtils", 1, "getCurProcessCpuJiffies error:" + e16.getMessage());
            return null;
        }
    }

    public static final long b() {
        return c.b();
    }

    public static final long c() {
        return c.d();
    }

    public static final long d() {
        try {
            return c.a(BaseApplication.getContext());
        } catch (Exception e16) {
            QLog.e("PerformanceUtils", 1, "getProcessUsedMemoryMB error=" + e16.getLocalizedMessage());
            return 0L;
        }
    }
}
