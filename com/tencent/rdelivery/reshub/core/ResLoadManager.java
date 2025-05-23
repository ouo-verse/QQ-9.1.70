package com.tencent.rdelivery.reshub.core;

import com.tencent.rdelivery.reshub.processor.m;
import com.tencent.rdelivery.reshub.util.ThreadUtil;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u00a8\u0006\f"}, d2 = {"Lcom/tencent/rdelivery/reshub/core/ResLoadManager;", "", "Lcom/tencent/rdelivery/reshub/core/k;", "req", "Lcom/tencent/rdelivery/reshub/api/h;", "callback", "", "a", "", "b", "<init>", "()V", "reshub_debug"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes25.dex */
public final class ResLoadManager {

    /* renamed from: a, reason: collision with root package name */
    public static final ResLoadManager f364407a = new ResLoadManager();

    ResLoadManager() {
    }

    private final boolean a(k req, com.tencent.rdelivery.reshub.api.h callback) {
        boolean isBlank;
        isBlank = StringsKt__StringsJVMKt.isBlank(req.x());
        if (!isBlank) {
            return false;
        }
        com.tencent.rdelivery.reshub.report.a aVar = new com.tencent.rdelivery.reshub.report.a();
        aVar.e(1009);
        aVar.g("ResID: " + req.x());
        k.A(req, false, aVar, 0L, 4, null);
        if (callback != null) {
            callback.onComplete(false, null, com.tencent.rdelivery.reshub.report.b.b(aVar));
            return true;
        }
        return true;
    }

    public final void b(@NotNull final k req, @Nullable com.tencent.rdelivery.reshub.api.h callback) {
        Intrinsics.checkParameterIsNotNull(req, "req");
        if (a(req, callback)) {
            return;
        }
        req.J(callback);
        if (e.f364425b.a(req)) {
            ThreadUtil.f364593c.b("ResLoad", req.getPriority(), new Function0<Unit>() { // from class: com.tencent.rdelivery.reshub.core.ResLoadManager$startLoadRes$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    com.tencent.rdelivery.reshub.processor.l lVar = new com.tencent.rdelivery.reshub.processor.l();
                    lVar.a(m.a());
                    lVar.d(k.this);
                }
            });
        }
    }
}
