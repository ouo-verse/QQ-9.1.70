package com.tencent.mobileqq.icgame.framework.page.manager;

import com.tencent.icgame.common.api.IAegisLogApi;
import com.tencent.mobileqq.icgame.framework.interfaceService.InjectService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import java.lang.reflect.Field;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c0\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0016\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0001R\u0014\u0010\n\u001a\u00020\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\t\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/icgame/framework/page/manager/d;", "", "Lcom/tencent/mobileqq/icgame/framework/page/manager/c;", "extInterfaceManager", SemanticAttributes.DbCassandraConsistencyLevelValues.ANY, "", "a", "Lcom/tencent/icgame/common/api/IAegisLogApi;", "b", "Lcom/tencent/icgame/common/api/IAegisLogApi;", "aegisLog", "<init>", "()V", "ic-game-base-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final d f237352a = new d();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final IAegisLogApi aegisLog;

    static {
        QRouteApi api = QRoute.api(IAegisLogApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IAegisLogApi::class.java)");
        aegisLog = (IAegisLogApi) api;
    }

    d() {
    }

    public final void a(@NotNull c extInterfaceManager, @NotNull Object any) {
        Intrinsics.checkNotNullParameter(extInterfaceManager, "extInterfaceManager");
        Intrinsics.checkNotNullParameter(any, "any");
        try {
            Field[] declaredFields = any.getClass().getDeclaredFields();
            Intrinsics.checkNotNullExpressionValue(declaredFields, "declaredFields");
            for (Field field : declaredFields) {
                InjectService injectService = (InjectService) field.getAnnotation(InjectService.class);
                if (injectService != null) {
                    Class<?> key = injectService.key();
                    aegisLog.w("ICGameExtInterfaceParse", "java:" + key);
                    Object c16 = extInterfaceManager.c(key);
                    if (c16 != null) {
                        field.setAccessible(true);
                        field.set(any, c16);
                    }
                }
            }
        } catch (IllegalAccessException e16) {
            aegisLog.w("ICGameExtInterfaceParse", "exception:" + e16.getMessage());
        } catch (IllegalArgumentException e17) {
            aegisLog.w("ICGameExtInterfaceParse", "exception:" + e17.getMessage());
        } catch (Exception e18) {
            aegisLog.w("ICGameExtInterfaceParse", "exception:" + e18.getMessage());
        }
    }
}
