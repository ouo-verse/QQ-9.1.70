package com.tencent.mobileqq.qqlive.kuikly;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.api.IQQKuiklyDexResApi;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.api.ResError;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tJ\u0006\u0010\u0003\u001a\u00020\u0002R\u0016\u0010\u0007\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/qqlive/kuikly/QQLiveKuiklyConfigUtils;", "", "", "a", "", "b", "J", WadlProxyConsts.LAST_UPDATE_TIME, "<init>", "()V", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class QQLiveKuiklyConfigUtils {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final QQLiveKuiklyConfigUtils f271368a = new QQLiveKuiklyConfigUtils();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static long lastUpdateTime;

    QQLiveKuiklyConfigUtils() {
    }

    public final void a() {
        List<String> list;
        final a aVar = (a) ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadConfig("101851");
        if (aVar == null) {
            QLog.w("QQLiveKuiklyConfigUtils", 2, "preloadQQLiveKuiklyRes config is null");
            return;
        }
        if (System.currentTimeMillis() - lastUpdateTime < aVar.getCooldown() * 1000) {
            QLog.i("QQLiveKuiklyConfigUtils", 2, "preloadQQLiveKuiklyRes waiting cooldown");
        } else if (!aVar.a().isEmpty()) {
            lastUpdateTime = System.currentTimeMillis();
            IQQKuiklyDexResApi iQQKuiklyDexResApi = (IQQKuiklyDexResApi) QRoute.api(IQQKuiklyDexResApi.class);
            list = CollectionsKt___CollectionsKt.toList(aVar.a());
            iQQKuiklyDexResApi.updateMultiDexRes(list, new Function1<ResError, Unit>() { // from class: com.tencent.mobileqq.qqlive.kuikly.QQLiveKuiklyConfigUtils$preloadQQLiveKuiklyRes$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(ResError resError) {
                    invoke2(resError);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull ResError result) {
                    Intrinsics.checkNotNullParameter(result, "result");
                    QLog.i("QQLiveKuiklyConfigUtils", 2, "enter room update kuikly res size:" + a.this.a().size() + " result:" + result);
                }
            });
        }
    }
}
