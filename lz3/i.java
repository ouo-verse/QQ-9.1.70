package lz3;

import com.tencent.rdelivery.RDelivery;
import com.tencent.rdelivery.data.RDeliveryData;
import com.tencent.rdelivery.reshub.core.k;
import iz3.o;
import iz3.p;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00009\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007*\u0001\f\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0015\u001a\u00020\u0010\u0012\u0006\u0010\u001a\u001a\u00020\u0016\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J\b\u0010\u000b\u001a\u00020\u0004H\u0016R\u0014\u0010\u000f\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0017\u0010\u0015\u001a\u00020\u00108\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\u001a\u001a\u00020\u00168\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\u00a8\u0006\u001d"}, d2 = {"Llz3/i;", "", "Lcom/tencent/rdelivery/RDelivery;", "rd", "", "d", "", "code", "", "msg", "g", "c", "lz3/i$b", "a", "Llz3/i$b;", "rdListener", "Lcom/tencent/rdelivery/reshub/core/k;", "b", "Lcom/tencent/rdelivery/reshub/core/k;", "f", "()Lcom/tencent/rdelivery/reshub/core/k;", "req", "Llz3/b;", "Llz3/b;", "e", "()Llz3/b;", "callback", "<init>", "(Lcom/tencent/rdelivery/reshub/core/k;Llz3/b;)V", "reshub_debug"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes25.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final b rdListener;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final k req;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final lz3.b callback;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001e\u0010\n\u001a\u00020\u00042\u0014\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0006H\u0016\u00a8\u0006\u000b"}, d2 = {"lz3/i$a", "Liz3/f;", "", "reason", "", "onFail", "", "", "Lcom/tencent/rdelivery/data/RDeliveryData;", "taskDataMap", "onSuccess", "reshub_debug"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes25.dex */
    public static final class a implements iz3.f {
        a() {
        }

        @Override // iz3.f
        public void onFail(@NotNull String reason) {
            Intrinsics.checkParameterIsNotNull(reason, "reason");
            i.this.rdListener.onFail(reason);
        }

        @Override // iz3.f
        public void onSuccess(@NotNull Map<Long, RDeliveryData> taskDataMap) {
            Intrinsics.checkParameterIsNotNull(taskDataMap, "taskDataMap");
            i.this.rdListener.b(taskDataMap.get(Long.valueOf(i.this.getReq().getCom.tencent.mobileqq.mini.servlet.MiniAppGetGameTaskTicketServlet.KEY_TASKID java.lang.String())));
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u0018\u0010\u000b\u001a\u00020\u00042\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\tH\u0016J2\u0010\u0010\u001a\u00020\u00042\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\f2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\f2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00060\fH\u0016\u00a8\u0006\u0011"}, d2 = {"lz3/i$b", "Liz3/p;", "", "reason", "", "onFail", "Lcom/tencent/rdelivery/data/RDeliveryData;", "data", "b", "", "datas", "onSuccess", "", "remainedDatas", "updatedDatas", "deletedDatas", "a", "reshub_debug"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes25.dex */
    public static final class b implements p {
        b() {
        }

        @Override // iz3.m
        public void a(@NotNull List<RDeliveryData> remainedDatas, @NotNull List<RDeliveryData> updatedDatas, @NotNull List<RDeliveryData> deletedDatas) {
            Intrinsics.checkParameterIsNotNull(remainedDatas, "remainedDatas");
            Intrinsics.checkParameterIsNotNull(updatedDatas, "updatedDatas");
            Intrinsics.checkParameterIsNotNull(deletedDatas, "deletedDatas");
            iz3.k.a(this, remainedDatas, updatedDatas, deletedDatas);
        }

        @Override // iz3.p
        public void b(@Nullable RDeliveryData data) {
            String str;
            boolean z16;
            if (data != null) {
                str = data.getConfigValue();
            } else {
                str = null;
            }
            if (str != null && str.length() != 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (z16) {
                i.this.g(1004, "RDelivery\u8fd4\u56de\u6570\u636e\u4e3a\u7a7a.");
                return;
            }
            jz3.d.e("RDeliveryFetcher", "Remote ResConfig Data: " + str);
            jz3.e b16 = h.b(data);
            if (b16 == null) {
                i.this.g(1005, "RDelivery\u8fd4\u56de\u6570\u636e\u89e3\u6790\u5931\u8d25.");
            } else {
                i.this.getCallback().b(b16);
            }
        }

        @Override // iz3.m
        public void onFail(@NotNull String reason) {
            Intrinsics.checkParameterIsNotNull(reason, "reason");
            i.this.g(1003, reason);
        }

        @Override // iz3.l
        public void onSuccess(@Nullable List<RDeliveryData> datas) {
            o.a(this, datas);
        }
    }

    public i(@NotNull k req, @NotNull lz3.b callback) {
        Intrinsics.checkParameterIsNotNull(req, "req");
        Intrinsics.checkParameterIsNotNull(callback, "callback");
        this.req = req;
        this.callback = callback;
        this.rdListener = new b();
    }

    private final void d(RDelivery rd5) {
        List<Long> listOf;
        listOf = CollectionsKt__CollectionsJVMKt.listOf(Long.valueOf(this.req.getCom.tencent.mobileqq.mini.servlet.MiniAppGetGameTaskTicketServlet.KEY_TASKID java.lang.String()));
        rd5.k(listOf, new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void g(int code, String msg2) {
        com.tencent.rdelivery.reshub.report.a aVar = new com.tencent.rdelivery.reshub.report.a();
        aVar.e(code);
        aVar.g(msg2);
        jz3.d.c("RDeliveryFetcher", "ResConfig(" + this.req.x() + ") Fetch Error: " + com.tencent.rdelivery.reshub.report.c.a(aVar));
        this.callback.a(aVar);
    }

    public void c() {
        RDelivery rDelivery = this.req.getRDelivery();
        if (rDelivery != null) {
            if (this.req.getMode() == 4) {
                d(rDelivery);
                return;
            } else {
                rDelivery.J(this.req.x(), this.rdListener);
                return;
            }
        }
        g(10004, "RDelivery\u521d\u59cb\u5316\u9519\u8bef.");
    }

    @NotNull
    /* renamed from: e, reason: from getter */
    public final lz3.b getCallback() {
        return this.callback;
    }

    @NotNull
    /* renamed from: f, reason: from getter */
    public final k getReq() {
        return this.req;
    }
}
