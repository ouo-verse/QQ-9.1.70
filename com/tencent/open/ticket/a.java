package com.tencent.open.ticket;

import com.tencent.open.agent.util.i;
import com.tencent.open.agent.util.u;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import mqq.app.TicketManagerImpl;
import mqq.manager.Manager;
import mqq.manager.TicketManager;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\bf\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&J\u0018\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&J \u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0004H&J \u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u000eH&J\u0018\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010H&\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/open/ticket/a;", "", "", "uin", "Lcom/tencent/open/agent/util/u;", "callback", "", "e", "d", "", "appIdArr", "c", "", "isHost", "Lcom/tencent/open/agent/util/i;", "a", "", "appId", "b", "opensdk-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public interface a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = Companion.f341733a;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0010\u0010\u000eJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000f\u0010\u0007\u001a\u00020\u0006H\u0000\u00a2\u0006\u0004\b\u0007\u0010\bR \u0010\u000f\u001a\u00020\t8\u0006X\u0087\u0004\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\n\u0012\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/open/ticket/a$a;", "", "", "isHost", "", "b", "Lmqq/manager/TicketManager;", "c", "()Lmqq/manager/TicketManager;", "", "[I", "a", "()[I", "getDefaultAppIdArr$annotations", "()V", "defaultAppIdArr", "<init>", "opensdk-api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.open.ticket.a$a, reason: collision with other inner class name and from kotlin metadata */
    /* loaded from: classes22.dex */
    public static final class Companion {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ Companion f341733a = new Companion();

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private static final int[] defaultAppIdArr = {16, TicketManagerImpl.BUFLAG_OPEN_CONNECT};

        Companion() {
        }

        @NotNull
        public final int[] a() {
            return defaultAppIdArr;
        }

        public final int b(boolean isHost) {
            if (isHost) {
                return 16;
            }
            return TicketManagerImpl.BUFLAG_OPEN_CONNECT;
        }

        @NotNull
        public final TicketManager c() {
            Manager manager = MobileQQ.sMobileQQ.peekAppRuntime().getManager(2);
            Intrinsics.checkNotNull(manager, "null cannot be cast to non-null type mqq.manager.TicketManager");
            return (TicketManager) manager;
        }
    }

    void a(@NotNull String uin, boolean isHost, @NotNull i callback);

    void b(long uin, long appId);

    void c(@NotNull String uin, @NotNull int[] appIdArr, @NotNull u callback);

    void d(@NotNull String uin, @NotNull u callback);

    void e(@NotNull String uin, @NotNull u callback);
}
