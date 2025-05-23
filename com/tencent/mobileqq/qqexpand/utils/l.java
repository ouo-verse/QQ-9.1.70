package com.tencent.mobileqq.qqexpand.utils;

import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\n\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/qqexpand/utils/l;", "", "Lcom/tencent/mobileqq/qqexpand/utils/j;", "b", "Lcom/tencent/mobileqq/qqexpand/utils/j;", "a", "()Lcom/tencent/mobileqq/qqexpand/utils/j;", "setLogger", "(Lcom/tencent/mobileqq/qqexpand/utils/j;)V", "logger", "<init>", "()V", "qqexpand-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class l {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final l f264102a = new l();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static j logger = new a();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0016J*\u0010\u000b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00022\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/qqexpand/utils/l$a", "Lcom/tencent/mobileqq/qqexpand/utils/j;", "", "tag", "", "level", "msg", "", "d", "", ReportConstant.COSTREPORT_TRANS, "e", "qqexpand-api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public static final class a implements j {
        a() {
        }

        @Override // com.tencent.mobileqq.qqexpand.utils.j
        public void d(@NotNull String tag, int level, @NotNull String msg2) {
            Intrinsics.checkNotNullParameter(tag, "tag");
            Intrinsics.checkNotNullParameter(msg2, "msg");
            QLog.d(tag, level, msg2);
        }

        @Override // com.tencent.mobileqq.qqexpand.utils.j
        public void e(@NotNull String tag, int level, @NotNull String msg2, @Nullable Throwable tr5) {
            Intrinsics.checkNotNullParameter(tag, "tag");
            Intrinsics.checkNotNullParameter(msg2, "msg");
            QLog.e(tag, level, msg2, tr5);
        }
    }

    l() {
    }

    @NotNull
    public final j a() {
        return logger;
    }
}
