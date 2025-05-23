package ox3;

import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\f\u001a\u001c\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00000\u0002\u001a\u001c\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00000\u0002\u001a\u001c\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00000\u0002\u001a\u001c\u0010\b\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00000\u0002\u001a\u001c\u0010\t\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00000\u0002\u001a\u001c\u0010\n\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00000\u0002\u001a\u0014\u0010\u000b\u001a\u00020\u00042\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00000\u0002\u001a\u0014\u0010\f\u001a\u00020\u00042\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00000\u0002\u001a\u0014\u0010\r\u001a\u00020\u00042\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00000\u0002\u001a\u001c\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00000\u0002\u001a\u001c\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00000\u0002\u00a8\u0006\u0010"}, d2 = {"", "tag", "Lkotlin/Function0;", "msg", "", "g", "a", "k", "d", "c", "f", h.F, "j", "i", "e", "b", "nt_album_kit_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class a {
    public static final void a(@NotNull String tag, @NotNull Function0<String> msg2) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(msg2, "msg");
        if (QLog.isColorLevel()) {
            QLog.d(tag, 2, msg2.invoke());
        }
    }

    public static final void b(@NotNull String tag, @NotNull Function0<String> msg2) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(msg2, "msg");
        QLog.d(tag, 4, msg2.invoke());
    }

    public static final void c(@NotNull String tag, @NotNull Function0<String> msg2) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(msg2, "msg");
        QLog.d(tag, 1, msg2.invoke());
    }

    public static final void d(@NotNull String tag, @NotNull Function0<String> msg2) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(msg2, "msg");
        if (QLog.isColorLevel()) {
            QLog.e(tag, 2, msg2.invoke());
        }
    }

    public static final void e(@NotNull String tag, @NotNull Function0<String> msg2) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(msg2, "msg");
        QLog.e(tag, 4, msg2.invoke());
    }

    public static final void f(@NotNull String tag, @NotNull Function0<String> msg2) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(msg2, "msg");
        QLog.e(tag, 1, msg2.invoke());
    }

    public static final void g(@NotNull String tag, @NotNull Function0<String> msg2) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(msg2, "msg");
        if (QLog.isColorLevel()) {
            QLog.i(tag, 2, msg2.invoke());
        }
    }

    public static final void h(@NotNull Function0<String> msg2) {
        Intrinsics.checkNotNullParameter(msg2, "msg");
        QLog.d("QBaseAlbum.Performance", 1, msg2.invoke());
    }

    public static final void i(@NotNull Function0<String> msg2) {
        Intrinsics.checkNotNullParameter(msg2, "msg");
        if (QLog.isColorLevel()) {
            QLog.d("QBaseAlbum.Report", 2, msg2.invoke());
        }
    }

    public static final void j(@NotNull Function0<String> msg2) {
        Intrinsics.checkNotNullParameter(msg2, "msg");
        QLog.w("QBaseAlbum.Task", 2, msg2.invoke());
    }

    public static final void k(@NotNull String tag, @NotNull Function0<String> msg2) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(msg2, "msg");
        if (QLog.isColorLevel()) {
            QLog.w(tag, 2, msg2.invoke());
        }
    }
}
