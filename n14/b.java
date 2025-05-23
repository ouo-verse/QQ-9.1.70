package n14;

import android.net.Uri;
import com.tencent.sqshow.zootopia.publish.ZPlanPublishSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import n14.c;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0003B\u0007\u00a2\u0006\u0004\b\f\u0010\rJ\u0016\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0005J\u001f\u0010\t\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00028\u00002\u0006\u0010\u0006\u001a\u00020\u0005H$\u00a2\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0001H&\u00a8\u0006\u000e"}, d2 = {"Ln14/b;", "Ln14/c;", "Context", "", "ctx", "Landroid/net/Uri;", ZPlanPublishSource.FROM_SCHEME, "", "b", "a", "(Ln14/c;Landroid/net/Uri;)Z", "c", "<init>", "()V", "robot-business-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public abstract class b<Context extends c> {
    protected abstract boolean a(@NotNull Context ctx, @NotNull Uri scheme);

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean b(@NotNull c ctx, @NotNull Uri scheme) {
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        Intrinsics.checkNotNullParameter(scheme, "scheme");
        return a(ctx, scheme);
    }

    public abstract boolean c(@NotNull c ctx);
}
