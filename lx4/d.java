package lx4;

import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J0\u0010\n\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007H&J0\u0010\u000b\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007H&J0\u0010\f\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007H&J0\u0010\r\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007H&\u00a8\u0006\u000e"}, d2 = {"Llx4/d;", "", "", "tag", "", "clr", "message", "", "t", "", "d", "i", "w", "e", "common_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes27.dex */
public interface d {

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 2})
    /* loaded from: classes27.dex */
    public static final class a {
        public static /* synthetic */ void a(d dVar, String str, int i3, String str2, Throwable th5, int i16, Object obj) {
            if (obj == null) {
                if ((i16 & 8) != 0) {
                    th5 = null;
                }
                dVar.d(str, i3, str2, th5);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: d");
        }

        public static /* synthetic */ void b(d dVar, String str, int i3, String str2, Throwable th5, int i16, Object obj) {
            if (obj == null) {
                if ((i16 & 8) != 0) {
                    th5 = null;
                }
                dVar.e(str, i3, str2, th5);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: e");
        }

        public static /* synthetic */ void c(d dVar, String str, int i3, String str2, Throwable th5, int i16, Object obj) {
            if (obj == null) {
                if ((i16 & 8) != 0) {
                    th5 = null;
                }
                dVar.i(str, i3, str2, th5);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: i");
        }

        public static /* synthetic */ void d(d dVar, String str, int i3, String str2, Throwable th5, int i16, Object obj) {
            if (obj == null) {
                if ((i16 & 8) != 0) {
                    th5 = null;
                }
                dVar.w(str, i3, str2, th5);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: w");
        }
    }

    void d(@Nullable String tag, int clr, @Nullable String message, @Nullable Throwable t16);

    void e(@Nullable String tag, int clr, @Nullable String message, @Nullable Throwable t16);

    void i(@Nullable String tag, int clr, @Nullable String message, @Nullable Throwable t16);

    void w(@Nullable String tag, int clr, @Nullable String message, @Nullable Throwable t16);
}
