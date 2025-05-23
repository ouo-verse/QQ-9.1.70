package nm3;

import android.content.Context;
import com.tencent.component.core.log.LogUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ6\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n\u00a8\u0006\u0010"}, d2 = {"Lnm3/o;", "", "", "isPKing", "isRankPKing", "isLinking", "Landroid/content/Context;", "context", "", "roomId", "Lnm3/a;", "closeLiveCallback", "", "a", "<init>", "()V", "qq-live-link-pk-anchorplay-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class o {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final o f420511a = new o();

    o() {
    }

    public final void a(boolean isPKing, boolean isRankPKing, boolean isLinking, @NotNull Context context, long roomId, @NotNull a closeLiveCallback) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(closeLiveCallback, "closeLiveCallback");
        LogUtil.i("LinkScreenAndPKCloseLiveHelper", "handleCloseLive, isPKing:" + isPKing + ", isRankPKing:" + isRankPKing + ", isLinking:" + isLinking, new Object[0]);
        if (isPKing) {
            if (isRankPKing) {
                j.t(context, closeLiveCallback);
                return;
            } else {
                j.p(context, roomId, closeLiveCallback);
                return;
            }
        }
        if (isLinking) {
            j.l(context, roomId, closeLiveCallback);
        }
    }
}
