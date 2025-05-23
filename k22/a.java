package k22;

import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0005\u0018\u0000 \t2\u00020\u0001:\u0001\bB\u0007\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\t\u001a\u00020\u0004H\u0016R\u001a\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\u000b\u00a8\u0006\u000f"}, d2 = {"Lk22/a;", "Lk22/c;", "Lk22/b;", "handler", "", "g", "i", "", "a", "b", "", "Ljava/util/List;", "handlerList", "<init>", "()V", "ic-game-room-base_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class a implements c {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<b> handlerList = new ArrayList();

    public boolean a() {
        int i3 = 0;
        for (Object obj : this.handlerList) {
            int i16 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            b bVar = (b) obj;
            if (i3 == 0) {
                QLog.i("ICGameBackEventServiceImpl", 1, "start pre handle backPressed!");
            } else {
                QLog.i("ICGameBackEventServiceImpl", 1, "preHandleBackPressed:preHandler is " + this.handlerList.get(i3 - 1).getClass().getSimpleName());
            }
            bVar.j();
            i3 = i16;
        }
        Iterator<T> it = this.handlerList.iterator();
        while (it.hasNext()) {
            if (((b) it.next()).handleBackPressed()) {
                return true;
            }
        }
        return false;
    }

    public void b() {
        this.handlerList.clear();
    }

    @Override // k22.c
    public void g(@NotNull b handler) {
        Intrinsics.checkNotNullParameter(handler, "handler");
        if (this.handlerList.contains(handler)) {
            return;
        }
        this.handlerList.add(handler);
    }

    @Override // k22.c
    public void i(@NotNull b handler) {
        Intrinsics.checkNotNullParameter(handler, "handler");
        this.handlerList.remove(handler);
    }
}
