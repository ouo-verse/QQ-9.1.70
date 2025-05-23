package com.tencent.mobileqq.vas.api;

import android.content.Context;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.vas.VasLogReportProxy;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J,\u0010\u0004\u001a\u00020\u00032\"\u0010\u0005\u001a\u001e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u0006j\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007`\bH&J\u0012\u0010\t\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u000bH&J\u0018\u0010\f\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u0007H&J \u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0007H&J\u001c\u0010\u0013\u001a\u00020\u00032\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u0014H&J0\u0010\u0015\u001a\u00020\u00032\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u00142\b\b\u0002\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u0019H&\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/vas/api/IVasUtilProxy;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "checkBusinessList", "", "collectPerformance", "params", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "handleIceBreakVipClick", "context", "Landroid/content/Context;", "openSchema", "url", "patch", "", "srcFile", "patchFile", "dstFile", "reportCommonReal", "", "reportLogReal", "elapse", "", "logLevel", "Lcom/tencent/mobileqq/vas/VasLogReportProxy$LEVEL;", "vas_api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {"all"})
/* loaded from: classes20.dex */
public interface IVasUtilProxy extends QRouteApi {

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes20.dex */
    public static final class DefaultImpls {
        public static /* synthetic */ void reportLogReal$default(IVasUtilProxy iVasUtilProxy, Map map, long j3, VasLogReportProxy.LEVEL level, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 2) != 0) {
                    j3 = -1;
                }
                if ((i3 & 4) != 0) {
                    level = VasLogReportProxy.LEVEL.HIGH;
                }
                iVasUtilProxy.reportLogReal(map, j3, level);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: reportLogReal");
        }
    }

    void checkBusinessList();

    void collectPerformance(@NotNull HashMap<String, String> params);

    void handleIceBreakVipClick(@Nullable Context context);

    void openSchema(@NotNull Context context, @NotNull String url);

    boolean patch(@NotNull String srcFile, @NotNull String patchFile, @NotNull String dstFile);

    void reportCommonReal(@NotNull Map<String, String> params);

    void reportLogReal(@NotNull Map<String, String> params, long elapse, @NotNull VasLogReportProxy.LEVEL logLevel);
}
