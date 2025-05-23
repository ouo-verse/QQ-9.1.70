package com.tencent.open.ticket;

import com.tencent.open.agent.util.i;
import com.tencent.open.agent.util.t;
import com.tencent.open.agent.util.u;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import mqq.app.MobileQQ;
import mqq.app.TicketManagerImpl;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007J\u0018\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007J \u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0004H\u0007J\u0018\u0010\f\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007J \u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\rH\u0007J\u0018\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0007R\u001b\u0010\u0014\u001a\u00020\u00108BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\f\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/open/ticket/OpenTicketHelper;", "", "", "uin", "Lcom/tencent/open/agent/util/u;", "callback", "", "a", "d", "", "isHost", "c", "b", "Lcom/tencent/open/agent/util/i;", "f", "e", "Lcom/tencent/open/ticket/a;", "Lkotlin/Lazy;", "g", "()Lcom/tencent/open/ticket/a;", "ticketApi", "<init>", "()V", "opensdk-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class OpenTicketHelper {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final OpenTicketHelper f341730a = new OpenTicketHelper();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy ticketApi;

    static {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<a>() { // from class: com.tencent.open.ticket.OpenTicketHelper$ticketApi$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final a invoke() {
                if (MobileQQ.sMobileQQ.isLoginByNT()) {
                    t.f("OpenTicketHelper", "use ntTicketApi");
                    return new c();
                }
                t.f("OpenTicketHelper", "use wtTicketApi");
                return new d();
            }
        });
        ticketApi = lazy;
    }

    OpenTicketHelper() {
    }

    @JvmStatic
    public static final void a(@NotNull String uin, @NotNull u callback) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(callback, "callback");
        f341730a.g().e(uin, callback);
    }

    @JvmStatic
    public static final void b(@NotNull String uin, @NotNull u callback) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(callback, "callback");
        f341730a.g().c(uin, a.INSTANCE.a(), callback);
    }

    @JvmStatic
    public static final void c(@NotNull String uin, boolean isHost, @NotNull u callback) {
        int[] iArr;
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (isHost) {
            iArr = new int[]{16};
        } else {
            iArr = new int[]{TicketManagerImpl.BUFLAG_OPEN_CONNECT};
        }
        f341730a.g().c(uin, iArr, callback);
    }

    @JvmStatic
    public static final void d(@NotNull String uin, @NotNull u callback) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(callback, "callback");
        f341730a.g().d(uin, callback);
    }

    @JvmStatic
    public static final void e(@NotNull String uin, boolean isHost) {
        Long longOrNull;
        int i3;
        Intrinsics.checkNotNullParameter(uin, "uin");
        longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull(uin);
        if (longOrNull != null) {
            long longValue = longOrNull.longValue();
            if (isHost) {
                i3 = 16;
            } else {
                i3 = TicketManagerImpl.BUFLAG_OPEN_CONNECT;
            }
            f341730a.g().b(longValue, i3);
        }
    }

    @JvmStatic
    public static final void f(@NotNull String uin, boolean isHost, @NotNull i callback) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(callback, "callback");
        f341730a.g().a(uin, isHost, callback);
    }

    private final a g() {
        return (a) ticketApi.getValue();
    }
}
