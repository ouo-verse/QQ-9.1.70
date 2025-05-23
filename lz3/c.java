package lz3;

import com.tencent.rdelivery.RDelivery;
import com.tencent.rdelivery.data.RDeliveryData;
import com.tencent.rdelivery.reshub.core.k;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 \u00122\u00020\u0001:\u0001\rB\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\f\u001a\u00020\u0004H\u0016R\u0017\u0010\u0003\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0007\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0016"}, d2 = {"Llz3/c;", "", "Lcom/tencent/rdelivery/reshub/core/k;", "req", "", "g", "Llz3/b;", "callback", "", "b", "Ljz3/e;", "e", "c", "a", "Lcom/tencent/rdelivery/reshub/core/k;", "f", "()Lcom/tencent/rdelivery/reshub/core/k;", "Llz3/b;", "d", "()Llz3/b;", "<init>", "(Lcom/tencent/rdelivery/reshub/core/k;Llz3/b;)V", "reshub_debug"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes25.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final k req;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final lz3.b callback;

    /* renamed from: c, reason: collision with root package name */
    private static final ConcurrentHashMap<String, Long> f415845c = new ConcurrentHashMap<>();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\t"}, d2 = {"lz3/c$b", "Llz3/b;", "Ljz3/e;", "resConfig", "", "b", "Lcom/tencent/rdelivery/reshub/report/a;", "error", "a", "reshub_debug"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes25.dex */
    public static final class b implements lz3.b {
        b() {
        }

        @Override // lz3.b
        public void a(@NotNull com.tencent.rdelivery.reshub.report.a error) {
            Intrinsics.checkParameterIsNotNull(error, "error");
            c.this.getCallback().a(error);
        }

        @Override // lz3.b
        public void b(@NotNull jz3.e resConfig) {
            Intrinsics.checkParameterIsNotNull(resConfig, "resConfig");
            c.this.getCallback().b(resConfig);
            c cVar = c.this;
            cVar.g(cVar.getReq());
        }
    }

    public c(@NotNull k req, @NotNull lz3.b callback) {
        Intrinsics.checkParameterIsNotNull(req, "req");
        Intrinsics.checkParameterIsNotNull(callback, "callback");
        this.req = req;
        this.callback = callback;
    }

    private final boolean b(k req, lz3.b callback) {
        Long l3;
        jz3.e e16;
        com.tencent.rdelivery.reshub.core.j jVar = com.tencent.rdelivery.reshub.core.j.L;
        if (!jVar.g() && !req.getForceRequestRemoteConfig() && (l3 = f415845c.get(k.p(req, null, 1, null))) != null) {
            Intrinsics.checkExpressionValueIsNotNull(l3, "lastValidFetchTime[req.g\u2026ashKey()] ?: return false");
            if (System.currentTimeMillis() - l3.longValue() <= jVar.q() && (e16 = e(req)) != null && com.tencent.rdelivery.reshub.util.a.c(e16, req.getAppInfo())) {
                jz3.d.e("FreqCachedRDeliveryFetcher", "Res(" + req.x() + ") Config Requesting Too Often, Ignore and Use Local Latest Config.");
                callback.b(e16);
                return true;
            }
        }
        return false;
    }

    private final jz3.e e(k req) {
        RDeliveryData z16;
        if (req.getMode() == 4) {
            return req.getConfigMap().p(req.x(), req.getCom.tencent.mobileqq.mini.servlet.MiniAppGetGameTaskTicketServlet.KEY_TASKID java.lang.String());
        }
        if (req.getRDelivery() != null) {
            RDelivery rDelivery = req.getRDelivery();
            if (rDelivery != null && (z16 = RDelivery.z(rDelivery, req.x(), null, true, 2, null)) != null) {
                return h.b(z16);
            }
            return null;
        }
        return req.getConfigMap().m(req.x());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void g(k req) {
        f415845c.put(k.p(req, null, 1, null), Long.valueOf(System.currentTimeMillis()));
    }

    public void c() {
        if (b(this.req, this.callback)) {
            return;
        }
        jz3.d.e("FreqCachedRDeliveryFetcher", "Start RDelivery Remote Config Fetching...");
        new i(this.req, new b()).c();
    }

    @NotNull
    /* renamed from: d, reason: from getter */
    public final lz3.b getCallback() {
        return this.callback;
    }

    @NotNull
    /* renamed from: f, reason: from getter */
    public final k getReq() {
        return this.req;
    }
}
