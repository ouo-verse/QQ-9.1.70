package gl0;

import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J,\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007H&\u00a8\u0006\u000b"}, d2 = {"Lgl0/b;", "", "", "isSuccess", "downloadSo", "", "errCode", "", "errMsg", "", "a", "zplan-service_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes6.dex */
public interface b {

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 2})
    /* loaded from: classes6.dex */
    public static final class a {
        public static /* synthetic */ void a(b bVar, boolean z16, boolean z17, int i3, String str, int i16, Object obj) {
            if (obj == null) {
                if ((i16 & 8) != 0) {
                    str = "";
                }
                bVar.a(z16, z17, i3, str);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onComplete");
        }
    }

    void a(boolean isSuccess, boolean downloadSo, int errCode, @Nullable String errMsg);
}
