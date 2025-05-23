package ie2;

import com.tencent.common.app.AppInterface;
import kotlin.Metadata;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\"\u0013\u0010\u0003\u001a\u0004\u0018\u00010\u00008F\u00a2\u0006\u0006\u001a\u0004\b\u0001\u0010\u0002\"\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u00048F\u00a2\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\b"}, d2 = {"Lmqq/app/AppRuntime;", "b", "()Lmqq/app/AppRuntime;", "appRuntime", "Lcom/tencent/common/app/AppInterface;", "a", "()Lcom/tencent/common/app/AppInterface;", "appInterface", "qne-api_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class a {
    @Nullable
    public static final AppInterface a() {
        AppRuntime b16 = b();
        if (b16 == null || !(b16 instanceof AppInterface)) {
            return null;
        }
        return (AppInterface) b16;
    }

    @Nullable
    public static final AppRuntime b() {
        return MobileQQ.sMobileQQ.peekAppRuntime();
    }
}
