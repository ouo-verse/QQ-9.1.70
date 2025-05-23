package com.tencent.mobileqq.vas.perception.api.impl;

import android.os.Looper;
import com.google.protobuf.nano.MessageNano;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.profilecard.api.IProfileProtocolConst;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.vas.api.IPbProtocol;
import com.tencent.mobileqq.vas.perception.api.VipPerceptionRequestResult;
import gu4.o;
import gu4.p;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0019\u0010\u001aJ \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0002J\u001e\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rJ.\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\rJ4\u0010\u0016\u001a\u00020\u000b2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00020\u00132\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\rJ\u001e\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\r\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/vas/perception/api/impl/n;", "", "", "privilegeType", "aioType", "", IProfileProtocolConst.PARAM_TARGET_UIN, "Lgu4/g;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/lang/Runnable;", TencentLocation.RUN_MODE, "", "D", "Lcom/tencent/mobileqq/vas/perception/api/VipPerceptionRequestResult;", "Lgu4/m;", "callback", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "Lgu4/i;", "v", "", "privilegeTypeList", "Lgu4/c;", DomainData.DOMAIN_NAME, "Lgu4/o;", "r", "<init>", "()V", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class n {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final n f310567a = new n();

    n() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r5v5, types: [T, java.lang.String] */
    public static final void A(final VipPerceptionRequestResult vipPerceptionRequestResult, int i3, boolean z16, final Object obj) {
        final Ref.IntRef intRef = new Ref.IntRef();
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = "";
        if (z16 && (obj instanceof byte[])) {
            try {
                final gu4.m c16 = gu4.m.c((byte[]) obj);
                int i16 = c16.f403402a;
                f310567a.D(new Runnable() { // from class: com.tencent.mobileqq.vas.perception.api.impl.j
                    @Override // java.lang.Runnable
                    public final void run() {
                        n.B(VipPerceptionRequestResult.this, c16, obj);
                    }
                });
                return;
            } catch (Exception e16) {
                intRef.element = -10000001;
                objectRef.element = "parse exception, e: " + e16.getMessage();
            }
        }
        f310567a.D(new Runnable() { // from class: com.tencent.mobileqq.vas.perception.api.impl.k
            @Override // java.lang.Runnable
            public final void run() {
                n.C(VipPerceptionRequestResult.this, intRef, objectRef);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void B(VipPerceptionRequestResult vipPerceptionRequestResult, gu4.m rsp, Object data) {
        if (vipPerceptionRequestResult != null) {
            Intrinsics.checkNotNullExpressionValue(rsp, "rsp");
            Intrinsics.checkNotNullExpressionValue(data, "data");
            vipPerceptionRequestResult.success(rsp, data);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void C(VipPerceptionRequestResult vipPerceptionRequestResult, Ref.IntRef errorCode, Ref.ObjectRef errorMsg) {
        Intrinsics.checkNotNullParameter(errorCode, "$errorCode");
        Intrinsics.checkNotNullParameter(errorMsg, "$errorMsg");
        if (vipPerceptionRequestResult != null) {
            vipPerceptionRequestResult.failure(errorCode.element, (String) errorMsg.element, null);
        }
    }

    private final void D(Runnable run) {
        if (Intrinsics.areEqual(Thread.currentThread(), Looper.getMainLooper().getThread())) {
            run.run();
        } else {
            ThreadManagerV2.getUIHandlerV2().post(run);
        }
    }

    private final gu4.g m(int privilegeType, int aioType, String targetUin) {
        Long longOrNull;
        long j3;
        gu4.g gVar = new gu4.g();
        gVar.f403390a = privilegeType;
        gu4.a aVar = new gu4.a();
        aVar.f403378a = aioType;
        longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull(targetUin);
        if (longOrNull != null) {
            j3 = longOrNull.longValue();
        } else {
            j3 = 0;
        }
        aVar.f403379b = j3;
        if (privilegeType != 1) {
            if (privilegeType != 2) {
                if (privilegeType == 3) {
                    gVar.f403393d = new gu4.j();
                }
            } else {
                p pVar = new p();
                pVar.f403411a = aVar;
                gVar.f403392c = pVar;
            }
        } else {
            gu4.f fVar = new gu4.f();
            fVar.f403388a = aVar;
            gVar.f403391b = fVar;
        }
        return gVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r5v5, types: [T, java.lang.String] */
    public static final void o(final VipPerceptionRequestResult vipPerceptionRequestResult, int i3, boolean z16, final Object obj) {
        final Ref.IntRef intRef = new Ref.IntRef();
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = "";
        if (z16 && (obj instanceof byte[])) {
            try {
                final gu4.c c16 = gu4.c.c((byte[]) obj);
                f310567a.D(new Runnable() { // from class: com.tencent.mobileqq.vas.perception.api.impl.h
                    @Override // java.lang.Runnable
                    public final void run() {
                        n.p(VipPerceptionRequestResult.this, c16, obj);
                    }
                });
                return;
            } catch (Exception e16) {
                intRef.element = -10000001;
                objectRef.element = "parse exception, e: " + e16.getMessage();
            }
        }
        f310567a.D(new Runnable() { // from class: com.tencent.mobileqq.vas.perception.api.impl.i
            @Override // java.lang.Runnable
            public final void run() {
                n.q(VipPerceptionRequestResult.this, intRef, objectRef);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p(VipPerceptionRequestResult vipPerceptionRequestResult, gu4.c rsp, Object data) {
        if (vipPerceptionRequestResult != null) {
            Intrinsics.checkNotNullExpressionValue(rsp, "rsp");
            Intrinsics.checkNotNullExpressionValue(data, "data");
            vipPerceptionRequestResult.success(rsp, data);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void q(VipPerceptionRequestResult vipPerceptionRequestResult, Ref.IntRef errorCode, Ref.ObjectRef errorMsg) {
        Intrinsics.checkNotNullParameter(errorCode, "$errorCode");
        Intrinsics.checkNotNullParameter(errorMsg, "$errorMsg");
        if (vipPerceptionRequestResult != null) {
            vipPerceptionRequestResult.failure(errorCode.element, (String) errorMsg.element, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r5v5, types: [T, java.lang.String] */
    public static final void s(final VipPerceptionRequestResult vipPerceptionRequestResult, int i3, boolean z16, final Object obj) {
        final Ref.IntRef intRef = new Ref.IntRef();
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = "";
        if (z16 && (obj instanceof byte[])) {
            try {
                final o c16 = o.c((byte[]) obj);
                f310567a.D(new Runnable() { // from class: com.tencent.mobileqq.vas.perception.api.impl.l
                    @Override // java.lang.Runnable
                    public final void run() {
                        n.t(VipPerceptionRequestResult.this, c16, obj);
                    }
                });
                return;
            } catch (Exception e16) {
                intRef.element = -10000001;
                objectRef.element = "parse exception, e: " + e16.getMessage();
            }
        }
        f310567a.D(new Runnable() { // from class: com.tencent.mobileqq.vas.perception.api.impl.m
            @Override // java.lang.Runnable
            public final void run() {
                n.u(VipPerceptionRequestResult.this, intRef, objectRef);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t(VipPerceptionRequestResult vipPerceptionRequestResult, o rsp, Object data) {
        if (vipPerceptionRequestResult != null) {
            Intrinsics.checkNotNullExpressionValue(rsp, "rsp");
            Intrinsics.checkNotNullExpressionValue(data, "data");
            vipPerceptionRequestResult.success(rsp, data);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void u(VipPerceptionRequestResult vipPerceptionRequestResult, Ref.IntRef errorCode, Ref.ObjectRef errorMsg) {
        Intrinsics.checkNotNullParameter(errorCode, "$errorCode");
        Intrinsics.checkNotNullParameter(errorMsg, "$errorMsg");
        if (vipPerceptionRequestResult != null) {
            vipPerceptionRequestResult.failure(errorCode.element, (String) errorMsg.element, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r5v5, types: [T, java.lang.String] */
    public static final void w(final VipPerceptionRequestResult vipPerceptionRequestResult, int i3, boolean z16, final Object obj) {
        final Ref.IntRef intRef = new Ref.IntRef();
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = "";
        if (z16 && (obj instanceof byte[])) {
            try {
                final gu4.i c16 = gu4.i.c((byte[]) obj);
                f310567a.D(new Runnable() { // from class: com.tencent.mobileqq.vas.perception.api.impl.c
                    @Override // java.lang.Runnable
                    public final void run() {
                        n.x(VipPerceptionRequestResult.this, c16, obj);
                    }
                });
                return;
            } catch (Exception e16) {
                intRef.element = -10000001;
                objectRef.element = "parse exception, e: " + e16.getMessage();
            }
        }
        f310567a.D(new Runnable() { // from class: com.tencent.mobileqq.vas.perception.api.impl.d
            @Override // java.lang.Runnable
            public final void run() {
                n.y(VipPerceptionRequestResult.this, intRef, objectRef);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x(VipPerceptionRequestResult vipPerceptionRequestResult, gu4.i rsp, Object data) {
        if (vipPerceptionRequestResult != null) {
            Intrinsics.checkNotNullExpressionValue(rsp, "rsp");
            Intrinsics.checkNotNullExpressionValue(data, "data");
            vipPerceptionRequestResult.success(rsp, data);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void y(VipPerceptionRequestResult vipPerceptionRequestResult, Ref.IntRef errorCode, Ref.ObjectRef errorMsg) {
        Intrinsics.checkNotNullParameter(errorCode, "$errorCode");
        Intrinsics.checkNotNullParameter(errorMsg, "$errorMsg");
        if (vipPerceptionRequestResult != null) {
            vipPerceptionRequestResult.failure(errorCode.element, (String) errorMsg.element, null);
        }
    }

    public final void n(@NotNull List<Integer> privilegeTypeList, int aioType, @NotNull String targetUin, @Nullable final VipPerceptionRequestResult<gu4.c> callback) {
        Intrinsics.checkNotNullParameter(privilegeTypeList, "privilegeTypeList");
        Intrinsics.checkNotNullParameter(targetUin, "targetUin");
        gu4.b bVar = new gu4.b();
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = privilegeTypeList.iterator();
        while (it.hasNext()) {
            arrayList.add(f310567a.m(((Number) it.next()).intValue(), aioType, targetUin));
        }
        Object[] array = arrayList.toArray(new gu4.g[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        bVar.f403380a = (gu4.g[]) array;
        ((IPbProtocol) QRoute.api(IPbProtocol.class)).request("trpc.qqva.privilege_experience_server.Logic.SsoExpireNotice", MessageNano.toByteArray(bVar), new BusinessObserver() { // from class: com.tencent.mobileqq.vas.perception.api.impl.f
            @Override // com.tencent.mobileqq.app.BusinessObserver
            public final void onUpdate(int i3, boolean z16, Object obj) {
                n.o(VipPerceptionRequestResult.this, i3, z16, obj);
            }
        });
    }

    public final void r(int privilegeType, @Nullable final VipPerceptionRequestResult<o> callback) {
        gu4.d dVar = new gu4.d();
        dVar.f403384a = privilegeType;
        ((IPbProtocol) QRoute.api(IPbProtocol.class)).request("trpc.qqva.privilege_experience_server.Logic.SsoGetUserExperienceInfo", MessageNano.toByteArray(dVar), new BusinessObserver() { // from class: com.tencent.mobileqq.vas.perception.api.impl.e
            @Override // com.tencent.mobileqq.app.BusinessObserver
            public final void onUpdate(int i3, boolean z16, Object obj) {
                n.s(VipPerceptionRequestResult.this, i3, z16, obj);
            }
        });
    }

    public final void v(int privilegeType, int aioType, @NotNull String targetUin, @Nullable final VipPerceptionRequestResult<gu4.i> callback) {
        Intrinsics.checkNotNullParameter(targetUin, "targetUin");
        gu4.h hVar = new gu4.h();
        hVar.f403394a = new gu4.g[]{f310567a.m(privilegeType, aioType, targetUin)};
        ((IPbProtocol) QRoute.api(IPbProtocol.class)).request("trpc.qqva.privilege_experience_server.Logic.SsoGuide", MessageNano.toByteArray(hVar), new BusinessObserver() { // from class: com.tencent.mobileqq.vas.perception.api.impl.b
            @Override // com.tencent.mobileqq.app.BusinessObserver
            public final void onUpdate(int i3, boolean z16, Object obj) {
                n.w(VipPerceptionRequestResult.this, i3, z16, obj);
            }
        });
    }

    public final void z(int privilegeType, @Nullable final VipPerceptionRequestResult<gu4.m> callback) {
        gu4.l lVar = new gu4.l();
        lVar.f403401a = privilegeType;
        ((IPbProtocol) QRoute.api(IPbProtocol.class)).request("trpc.qqva.privilege_experience_server.Logic.SsoObtainExperience", MessageNano.toByteArray(lVar), new BusinessObserver() { // from class: com.tencent.mobileqq.vas.perception.api.impl.g
            @Override // com.tencent.mobileqq.app.BusinessObserver
            public final void onUpdate(int i3, boolean z16, Object obj) {
                n.A(VipPerceptionRequestResult.this, i3, z16, obj);
            }
        });
    }
}
