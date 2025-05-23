package com.tencent.zplan.hotpatch;

import com.tencent.component.media.image.ImageTaskConst;
import com.tencent.hippy.qq.api.OpenHippyInfo;
import com.tencent.zplan.luabridge.plugins.data.CommonLoadingData;
import com.tencent.zplan.resource.api.ZPlanSceneResourceErrType;
import com.tencent.zplan.utils.ZLog;
import cy4.ZPlanResourceBusinessData;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mx4.a;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import zx4.g;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u001c\u0010\u0006\u001a\u00020\u00042\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002H\u0002J\u001e\u0010\f\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tJ\u000e\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rJ\u000e\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0010J0\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\t2\b\u0010\u0016\u001a\u0004\u0018\u00010\r2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\t\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/zplan/hotpatch/ZPlanHotPatchNotifyHelper;", "", "Lkotlin/Function1;", "Lzx4/g;", "", "checkProxyCallback", "a", "", "progress", "", "totalTaskCount", "completedTaskCount", "c", "", "versionInfo", "d", "Lcy4/b;", OpenHippyInfo.EXTRA_KEY_BUSINESS_DATA, "e", "Lcom/tencent/zplan/resource/api/ZPlanSceneResourceErrType;", ImageTaskConst.ERROR_TYPE, "errorCode", "errorMessage", "failedTaskCount", "b", "<init>", "()V", "zplan_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes27.dex */
public final class ZPlanHotPatchNotifyHelper {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final ZPlanHotPatchNotifyHelper f385645a = new ZPlanHotPatchNotifyHelper();

    ZPlanHotPatchNotifyHelper() {
    }

    private final void a(Function1<? super g, Unit> checkProxyCallback) {
        g gVar = (g) a.f417748a.a(g.class);
        ZLog.f386189b.i("ZPlanHotPatchNotifyHelper", 1, "checkHotPatchNotifyProxy - " + gVar);
        if (gVar != null) {
            checkProxyCallback.invoke(gVar);
        }
    }

    public final void b(@NotNull final ZPlanSceneResourceErrType errType, final int errorCode, @Nullable final String errorMessage, final int totalTaskCount, final int failedTaskCount) {
        Intrinsics.checkNotNullParameter(errType, "errType");
        a(new Function1<g, Unit>() { // from class: com.tencent.zplan.hotpatch.ZPlanHotPatchNotifyHelper$notifyHotPatchError$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(g gVar) {
                invoke2(gVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull g it) {
                Intrinsics.checkNotNullParameter(it, "it");
                it.b(ZPlanSceneResourceErrType.this, errorCode, errorMessage, totalTaskCount, failedTaskCount);
            }
        });
    }

    public final void c(float progress, int totalTaskCount, int completedTaskCount) {
        final CommonLoadingData commonLoadingData = new CommonLoadingData((int) (progress * 100), 1, 0, 1, 0, 0, null, 112, null);
        com.tencent.zplan.engine.service.a.f385627c.b(commonLoadingData);
        a(new Function1<g, Unit>() { // from class: com.tencent.zplan.hotpatch.ZPlanHotPatchNotifyHelper$notifyHotPatchProgress$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(g gVar) {
                invoke2(gVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull g it) {
                Intrinsics.checkNotNullParameter(it, "it");
                it.notifyHotPatchProgress(CommonLoadingData.this);
            }
        });
    }

    public final void d(@NotNull final String versionInfo) {
        Intrinsics.checkNotNullParameter(versionInfo, "versionInfo");
        a(new Function1<g, Unit>() { // from class: com.tencent.zplan.hotpatch.ZPlanHotPatchNotifyHelper$notifyHotPatchStart$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(g gVar) {
                invoke2(gVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull g it) {
                Intrinsics.checkNotNullParameter(it, "it");
                it.c(versionInfo);
            }
        });
    }

    public final void e(@NotNull final ZPlanResourceBusinessData businessData) {
        Intrinsics.checkNotNullParameter(businessData, "businessData");
        a(new Function1<g, Unit>() { // from class: com.tencent.zplan.hotpatch.ZPlanHotPatchNotifyHelper$notifyHotPatchSuccess$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(g gVar) {
                invoke2(gVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull g it) {
                Intrinsics.checkNotNullParameter(it, "it");
                it.a(ZPlanResourceBusinessData.this);
            }
        });
    }
}
