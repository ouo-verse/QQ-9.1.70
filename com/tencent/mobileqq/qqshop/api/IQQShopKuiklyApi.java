package com.tencent.mobileqq.qqshop.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&JD\u0010\u000e\u001a\u00020\u00042:\b\u0002\u0010\r\u001a4\u0012\u0013\u0012\u00110\u0007\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00110\u000b\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0006H&\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/qqshop/api/IQQShopKuiklyApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "Lcom/tencent/kuikly/core/render/android/b;", "renderExport", "", "registerExternalModule", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "code", "", "msg", "callback", "preloadKuiklyBundle", "qqshop-feature-api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes17.dex */
public interface IQQShopKuiklyApi extends QRouteApi {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes17.dex */
    public static final class a {
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void a(IQQShopKuiklyApi iQQShopKuiklyApi, Function2 function2, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 1) != 0) {
                    function2 = null;
                }
                iQQShopKuiklyApi.preloadKuiklyBundle(function2);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: preloadKuiklyBundle");
        }
    }

    void preloadKuiklyBundle(@Nullable Function2<? super Integer, ? super String, Unit> callback);

    void registerExternalModule(@NotNull com.tencent.kuikly.core.render.android.b renderExport);
}
