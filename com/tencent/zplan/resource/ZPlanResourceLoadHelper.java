package com.tencent.zplan.resource;

import com.tencent.zplan.resource.api.a;
import com.tencent.zplan.utils.ZLog;
import cy4.ZPlanResourceBusinessData;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import zx4.o;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ0\u0010\n\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006H\u0002J\u0012\u0010\u000b\u001a\u00020\b2\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/zplan/resource/ZPlanResourceLoadHelper;", "", "", "reqLogString", "Lcom/tencent/zplan/resource/api/a;", "resourceCallback", "Lkotlin/Function1;", "Lzx4/o;", "", "checkProxyCallback", "a", "b", "<init>", "()V", "zplan_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes27.dex */
public final class ZPlanResourceLoadHelper {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final ZPlanResourceLoadHelper f386183a = new ZPlanResourceLoadHelper();

    ZPlanResourceLoadHelper() {
    }

    private final void a(String reqLogString, a resourceCallback, Function1<? super o, Unit> checkProxyCallback) {
        o oVar = (o) mx4.a.f417748a.a(o.class);
        ZLog.f386189b.i("ZPlanResourceLoadHelper", 1, "checkResourceProxy - " + reqLogString + ", " + oVar);
        if (oVar == null) {
            if (resourceCallback != null) {
                a.C10071a.b(resourceCallback, ZPlanResourceBusinessData.INSTANCE.a(), null, 2, null);
                return;
            }
            return;
        }
        checkProxyCallback.invoke(oVar);
    }

    public final void b(@Nullable final a resourceCallback) {
        a("downloadHotPatchResource", resourceCallback, new Function1<o, Unit>() { // from class: com.tencent.zplan.resource.ZPlanResourceLoadHelper$downloadHotPatchResource$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(o oVar) {
                invoke2(oVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull o it) {
                Intrinsics.checkNotNullParameter(it, "it");
                it.a(a.this);
            }
        });
    }
}
