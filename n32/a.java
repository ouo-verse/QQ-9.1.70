package n32;

import com.tencent.mobileqq.icgame.framework.page.Page;
import com.tencent.mobileqq.icgame.framework.page.manager.PageManager;
import g32.e;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"Ln32/a;", "Ln32/b;", "Lg32/b;", "event", "", "a", "<init>", "()V", "ic-game-base-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class a implements b {
    @Override // n32.b
    public boolean a(@NotNull g32.b event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (event instanceof e) {
            Iterator<Page> it = PageManager.f237343a.b().iterator();
            while (it.hasNext()) {
                it.next().w0(event);
            }
            return true;
        }
        return false;
    }
}
