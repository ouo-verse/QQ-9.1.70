package lz3;

import com.tencent.rdelivery.RDelivery;
import com.tencent.rdelivery.data.RDeliveryData;
import com.tencent.rdelivery.reshub.core.k;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0016\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004\u00a8\u0006\f"}, d2 = {"Llz3/j;", "", "Lcom/tencent/rdelivery/reshub/core/k;", "req", "Llz3/b;", "callback", "", "a", "", "b", "<init>", "()V", "reshub_debug"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes25.dex */
public final class j {

    /* renamed from: a, reason: collision with root package name */
    public static final j f415860a = new j();

    j() {
    }

    private final boolean a(k req, b callback) {
        RDeliveryData z16;
        jz3.e b16;
        jz3.e eVar;
        RDeliveryData z17;
        com.tencent.rdelivery.reshub.core.j jVar = com.tencent.rdelivery.reshub.core.j.L;
        if (jVar.g() || req.getForceRequestRemoteConfig() || jVar.E()) {
            return true;
        }
        if (req.getMode() == 4) {
            RDelivery rDelivery = req.getRDelivery();
            String str = null;
            if (rDelivery != null && (z17 = RDelivery.z(rDelivery, req.x(), null, true, 2, null)) != null) {
                eVar = h.b(z17);
            } else {
                eVar = null;
            }
            if (eVar != null) {
                str = eVar.f411279t;
            }
            if (!Intrinsics.areEqual(str, String.valueOf(req.getCom.tencent.mobileqq.mini.servlet.MiniAppGetGameTaskTicketServlet.KEY_TASKID java.lang.String()))) {
                return true;
            }
            jz3.d.e("ResConfigFetchManager", "MODE_TASK Res(" + req.x() + ") Use RDelivery Current Config: " + eVar);
            callback.b(eVar);
            return false;
        }
        RDelivery rDelivery2 = req.getRDelivery();
        if (rDelivery2 == null || (z16 = RDelivery.z(rDelivery2, req.x(), null, true, 2, null)) == null || (b16 = h.b(z16)) == null || !com.tencent.rdelivery.reshub.util.a.c(b16, req.getAppInfo())) {
            return true;
        }
        jz3.d.e("ResConfigFetchManager", "Res(" + req.x() + ") Use RDelivery Current Config: " + z16.getConfigValue());
        callback.b(b16);
        return false;
    }

    public final void b(@NotNull k req, @NotNull b callback) {
        Intrinsics.checkParameterIsNotNull(req, "req");
        Intrinsics.checkParameterIsNotNull(callback, "callback");
        if (!a(req, callback)) {
            return;
        }
        new c(req, callback).c();
    }
}
