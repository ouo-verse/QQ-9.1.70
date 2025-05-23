package lz3;

import com.tencent.rdelivery.dependency.AbsLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u001c\u0010\u0006\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0002J$\u0010\n\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\b\u001a\u00020\u00072\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0016J.\u0010\r\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\b\u001a\u00020\u00072\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016\u00a8\u0006\u0010"}, d2 = {"Llz3/e;", "Lcom/tencent/rdelivery/dependency/AbsLog;", "", "tag", "msg", "", "f", "Lcom/tencent/rdelivery/dependency/AbsLog$Level;", "logLevel", "", "b", "", "throwable", "c", "<init>", "()V", "reshub_debug"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes25.dex */
final class e extends AbsLog {
    private final boolean f(String tag, String msg2) {
        boolean contains$default;
        boolean contains$default2;
        boolean contains$default3;
        if (tag != null && msg2 != null) {
            contains$default = StringsKt__StringsKt.contains$default((CharSequence) tag, (CharSequence) "BuglyHelper", false, 2, (Object) null);
            if (contains$default) {
                contains$default2 = StringsKt__StringsKt.contains$default((CharSequence) msg2, (CharSequence) "NoSuchMethodException", false, 2, (Object) null);
                if (!contains$default2) {
                    contains$default3 = StringsKt__StringsKt.contains$default((CharSequence) msg2, (CharSequence) "init error", false, 2, (Object) null);
                    if (contains$default3) {
                        return true;
                    }
                } else {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // com.tencent.rdelivery.dependency.AbsLog
    public void b(@Nullable String tag, @NotNull AbsLog.Level logLevel, @Nullable String msg2) {
        Intrinsics.checkParameterIsNotNull(logLevel, "logLevel");
        if (f(tag, msg2)) {
            return;
        }
        int i3 = d.f415850a[logLevel.ordinal()];
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 != 4) {
                        if (i3 == 5) {
                            jz3.d.c(tag, msg2);
                            return;
                        }
                        return;
                    }
                    jz3.d.i(tag, msg2);
                    return;
                }
                jz3.d.e(tag, msg2);
                return;
            }
            jz3.d.a(tag, msg2);
            return;
        }
        jz3.d.h(tag, msg2);
    }

    @Override // com.tencent.rdelivery.dependency.AbsLog
    public void c(@Nullable String tag, @NotNull AbsLog.Level logLevel, @Nullable String msg2, @Nullable Throwable throwable) {
        Intrinsics.checkParameterIsNotNull(logLevel, "logLevel");
        if (f(tag, msg2)) {
            return;
        }
        int i3 = d.f415851b[logLevel.ordinal()];
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 != 4) {
                        if (i3 == 5) {
                            jz3.d.d(tag, msg2, throwable);
                            return;
                        }
                        return;
                    }
                    jz3.d.j(tag, msg2, throwable);
                    return;
                }
                jz3.d.f(tag, msg2, throwable);
                return;
            }
            jz3.d.b(tag, msg2, throwable);
            return;
        }
        jz3.d.h(tag, msg2);
    }
}
