package com.tencent.mobileqq.qqecommerce.biz.kuikly.api;

import com.tencent.biz.qqcircle.immersive.request.search.QFSSearchBaseRequest;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\b\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J?\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u00062#\u0010\f\u001a\u001f\u0012\u0013\u0012\u00110\t\u00a2\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r\u0018\u00010\bH&J7\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022%\b\u0002\u0010\f\u001a\u001f\u0012\u0013\u0012\u00110\t\u00a2\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r\u0018\u00010\bH&J=\u0010\u0011\u001a\u00020\r2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00020\u000f2%\b\u0002\u0010\f\u001a\u001f\u0012\u0013\u0012\u00110\t\u00a2\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r\u0018\u00010\bH&J\u0018\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0002H&J/\u0010\u0014\u001a\u00020\r2%\b\u0002\u0010\f\u001a\u001f\u0012\u0013\u0012\u00110\t\u00a2\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r\u0018\u00010\bH&J\u0010\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\u0018\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u0002H&Jy\u0010\u001f\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\u00152g\b\u0002\u0010\f\u001aa\u0012\u0013\u0012\u00110\u0006\u00a2\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u001b\u0012\u001f\u0012\u001d\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00150\u001c\u00a2\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u001d\u0012\u001f\u0012\u001d\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u001c\u00a2\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u001e\u0012\u0004\u0012\u00020\r\u0018\u00010\u001aH&J\u0018\u0010\"\u001a\u00020\r2\u0006\u0010 \u001a\u00020\u00022\u0006\u0010!\u001a\u00020\u0006H&J\u000e\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00020\u000fH&\u00a8\u0006$"}, d2 = {"Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/api/IQQKuiklyDexResApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "", "resId", "Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/api/b;", "getDexResInfo", "", "forceUpdate", "Lkotlin/Function1;", "Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/api/k;", "Lkotlin/ParameterName;", "name", "result", "", "updateDexRes", "", "resIdList", "updateMultiDexRes", "pageName", "isDexPageExist", "requestFullConfig", "", "getLastRequestServerTime", "getFetchedResVersion", "deleteBundle", "scenc", "Lkotlin/Function3;", "isAllSuccess", "", "resMap", "errMap", "getBundleInfoByScene", "bundleName", QFSSearchBaseRequest.EXTRA_KEY_IS_TEST_ENVIRONMENT, "switchBundleShiplyEnv", "getShiplyTestBundleList", "qqecommerce-api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes16.dex */
public interface IQQKuiklyDexResApi extends QRouteApi {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes16.dex */
    public static final class a {
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void a(IQQKuiklyDexResApi iQQKuiklyDexResApi, List list, Function1 function1, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 2) != 0) {
                    function1 = null;
                }
                iQQKuiklyDexResApi.updateMultiDexRes(list, function1);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: updateMultiDexRes");
        }
    }

    void deleteBundle(@NotNull String resId);

    void getBundleInfoByScene(long scenc, @Nullable Function3<? super Boolean, ? super Map<String, Long>, ? super Map<String, String>, Unit> result);

    @NotNull
    DexResInfo getDexResInfo(@NotNull String resId);

    long getFetchedResVersion(@NotNull String resId);

    long getLastRequestServerTime(@NotNull String resId);

    @NotNull
    List<String> getShiplyTestBundleList();

    boolean isDexPageExist(@NotNull String resId, @NotNull String pageName);

    void requestFullConfig(@Nullable Function1<? super ResError, Unit> result);

    void switchBundleShiplyEnv(@NotNull String bundleName, boolean isTest);

    void updateDexRes(@NotNull String resId, @Nullable Function1<? super ResError, Unit> result);

    void updateDexRes(@NotNull String resId, boolean forceUpdate, @Nullable Function1<? super ResError, Unit> result);

    void updateMultiDexRes(@NotNull List<String> resIdList, @Nullable Function1<? super ResError, Unit> result);
}
