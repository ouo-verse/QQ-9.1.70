package hq1;

import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.bc;
import com.tencent.mobileqq.guild.util.Logger;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \b2\u00020\u0001:\u0001\u0003B\u0007\u00a2\u0006\u0004\b\f\u0010\rJ\u0006\u0010\u0003\u001a\u00020\u0002J\u0018\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u0006R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\n\u00a8\u0006\u000e"}, d2 = {"Lhq1/a;", "", "", "a", "Ljava/lang/Runnable;", "r", "", "delay", "b", "Lcom/tencent/mobileqq/app/bc;", "Lcom/tencent/mobileqq/app/bc;", "onlinePushHandler", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private volatile bc onlinePushHandler;

    public final void a() {
        Logger.f235387a.d().d("QGL.GuildLiveMsgHandler", 1, "[onDestroy] ");
        this.onlinePushHandler = null;
    }

    public final void b(@NotNull Runnable r16, long delay) {
        Intrinsics.checkNotNullParameter(r16, "r");
        if (this.onlinePushHandler == null) {
            long currentTimeMillis = System.currentTimeMillis();
            synchronized (this) {
                if (this.onlinePushHandler == null) {
                    this.onlinePushHandler = ThreadManagerV2.newHandlerRecycleThread("Guild_Live_Msg_Thread", 0).b();
                    Logger.f235387a.d().d("QGL.GuildLiveMsgHandler", 1, "[postTaskInOnlinePushThread] start, cost = " + (System.currentTimeMillis() - currentTimeMillis) + " ");
                }
                Unit unit = Unit.INSTANCE;
            }
        }
        if (delay > 0) {
            bc bcVar = this.onlinePushHandler;
            if (bcVar != null) {
                bcVar.postDelayed(r16, delay);
                return;
            }
            return;
        }
        bc bcVar2 = this.onlinePushHandler;
        if (bcVar2 != null) {
            bcVar2.post(r16);
        }
    }
}
