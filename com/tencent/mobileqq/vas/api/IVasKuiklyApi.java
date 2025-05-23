package com.tencent.mobileqq.vas.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.vas.spanend.IH5DataCacheApi;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0007\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&JL\u0010\u0010\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072:\b\u0002\u0010\u000f\u001a4\u0012\u0013\u0012\u00110\n\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0013\u0012\u00110\u0007\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u0004\u0018\u00010\tH&JR\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\b\u001a\u00020\u000728\u0010\u000f\u001a4\u0012\u0013\u0012\u00110\n\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0015\u0012\u0013\u0018\u00010\u0007\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u00040\tH&J\u0018\u0010\u0016\u001a\u00020\u00152\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u0007H&J\b\u0010\u0017\u001a\u00020\u0004H&J.\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0014\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0018H&J\u0018\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u001cH&J\u0012\u0010\u001f\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001b\u001a\u00020\u0007H&J\u0010\u0010!\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u0007H&J\u0010\u0010\"\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u0007H&\u00a8\u0006#"}, d2 = {"Lcom/tencent/mobileqq/vas/api/IVasKuiklyApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "Lcom/tencent/kuikly/core/render/android/b;", "renderExport", "", "registerExternalRenderView", "registerExternalModule", "", "bundleName", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "code", "msg", "callback", "preloadKuiklyResByRule", "", "newTag", "preloadKuiklyResByTag", "pageName", "", "isDexPageExist", "startPreload", "", "params", "buildVasKuiklySchema", "key", "", "data", "setMqqToKuiklyData", "getMqqData", "param", "invokeArkViewReport", IH5DataCacheApi.METHOD_WRITE_H5_DATA, "vas-api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes20.dex */
public interface IVasKuiklyApi extends QRouteApi {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes20.dex */
    public static final class a {
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void a(IVasKuiklyApi iVasKuiklyApi, String str, Function2 function2, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 2) != 0) {
                    function2 = null;
                }
                iVasKuiklyApi.preloadKuiklyResByRule(str, function2);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: preloadKuiklyResByRule");
        }
    }

    @NotNull
    String buildVasKuiklySchema(@NotNull String pageName, @NotNull String bundleName, @Nullable Map<String, String> params);

    @Nullable
    Object getMqqData(@NotNull String key);

    void invokeArkViewReport(@NotNull String param);

    boolean isDexPageExist(@NotNull String bundleName, @NotNull String pageName);

    void preloadKuiklyResByRule(@NotNull String bundleName, @Nullable Function2<? super Integer, ? super String, Unit> callback);

    void preloadKuiklyResByTag(long newTag, @NotNull String bundleName, @NotNull Function2<? super Integer, ? super String, Unit> callback);

    void registerExternalModule(@NotNull com.tencent.kuikly.core.render.android.b renderExport);

    void registerExternalRenderView(@NotNull com.tencent.kuikly.core.render.android.b renderExport);

    void setMqqToKuiklyData(@NotNull String key, @NotNull Object data);

    void startPreload();

    void writeH5Data(@NotNull String param);
}
