package eu2;

import bu2.c;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\b\u00c0\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u0004\u001a\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\u0006\u001a\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0005J\u000e\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0007J\u0006\u0010\n\u001a\u00020\bJ\u0006\u0010\u000b\u001a\u00020\bJ\u0006\u0010\f\u001a\u00020\bJ\u0006\u0010\r\u001a\u00020\bJ\u000e\u0010\u000e\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0007J\u0006\u0010\u000f\u001a\u00020\bJ\u000e\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u0010J\u0006\u0010\u0013\u001a\u00020\bJ\u000e\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0007J\u0006\u0010\u0015\u001a\u00020\b\u00a8\u0006\u0018"}, d2 = {"Leu2/c;", "", "", "errorCode", "l", "(Ljava/lang/Integer;)I", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "Lbu2/c$c;", "a", "b", "c", "d", "g", "e", "f", "Leu2/e;", "state", "j", "k", h.F, "i", "<init>", "()V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final c f397144a = new c();

    c() {
    }

    @NotNull
    public final c.C0152c a(long errorCode) {
        return new c.C0152c(14, "route error: " + errorCode);
    }

    @NotNull
    public final c.C0152c b() {
        return new c.C0152c(14, "response is null");
    }

    @NotNull
    public final c.C0152c c() {
        return new c.C0152c(2, "request in progress");
    }

    @NotNull
    public final c.C0152c d() {
        return new c.C0152c(16, "server struct illegal");
    }

    @NotNull
    public final c.C0152c e(long errorCode) {
        return new c.C0152c(4, "route error: " + errorCode);
    }

    @NotNull
    public final c.C0152c f() {
        return new c.C0152c(4, "response is null");
    }

    @NotNull
    public final c.C0152c g() {
        return new c.C0152c(3, "request in progress");
    }

    @NotNull
    public final c.C0152c h(long errorCode) {
        return new c.C0152c(3, "route error: " + errorCode);
    }

    @NotNull
    public final c.C0152c i() {
        return new c.C0152c(3, "response is null");
    }

    @NotNull
    public final c.C0152c j(@NotNull e state) {
        int i3;
        Intrinsics.checkNotNullParameter(state, "state");
        if (state.h()) {
            i3 = 6;
        } else {
            state.g();
            i3 = 5;
        }
        return new c.C0152c(Integer.valueOf(i3), "request in progress");
    }

    @NotNull
    public final c.C0152c k() {
        return new c.C0152c(2, "server struct illegal");
    }

    public final int l(@Nullable Integer errorCode) {
        if (errorCode != null && errorCode.intValue() != 0) {
            int intValue = errorCode.intValue();
            if (intValue != -895 && intValue != 1006) {
                if (intValue != 1120) {
                    if (intValue != 1111 && intValue != 1112) {
                        return 14;
                    }
                    return 18;
                }
                return 21;
            }
            return 18;
        }
        return 0;
    }

    public final int m(@Nullable Integer errorCode) {
        if (errorCode != null && errorCode.intValue() != 0) {
            int intValue = errorCode.intValue();
            if (intValue != -895 && intValue != 1006 && intValue != 1112) {
                if (intValue != 1120) {
                    return 3;
                }
                return 21;
            }
            return 4;
        }
        return 0;
    }
}
