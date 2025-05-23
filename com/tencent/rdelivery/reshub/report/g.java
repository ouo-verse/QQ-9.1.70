package com.tencent.rdelivery.reshub.report;

import com.tencent.mobileqq.qwallet.preload.IPreloadServiceProxy;
import com.tencent.raft.standard.net.IRNetwork;
import com.tencent.rdelivery.reshub.core.k;
import java.util.Properties;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.aspectj.lang.JoinPoint;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001c\u0010\u0006\u001a\u00020\u0005*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u001a\u001a\u0010\f\u001a\u00020\u000b*\u00020\u00072\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b\u001a\n\u0010\u000e\u001a\u00020\u0001*\u00020\r\u001a\n\u0010\u000f\u001a\u00020\u0000*\u00020\r\u00a8\u0006\u0010"}, d2 = {"Ljava/util/Properties;", "", "key", "", "value", "", "a", "Lcom/tencent/raft/standard/net/IRNetwork$ResultInfo;", "", "errorCodeForHttp", "errorCodeForOther", "Lcom/tencent/rdelivery/reshub/report/a;", "d", "Lcom/tencent/rdelivery/reshub/core/k;", "c", "b", "reshub_debug"}, k = 2, mv = {1, 4, 0})
/* loaded from: classes25.dex */
public final class g {
    public static final void a(@NotNull Properties addNonNullParam, @NotNull String key, @Nullable Object obj) {
        Intrinsics.checkParameterIsNotNull(addNonNullParam, "$this$addNonNullParam");
        Intrinsics.checkParameterIsNotNull(key, "key");
        if (obj != null) {
            addNonNullParam.put(key, obj);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x005c, code lost:
    
        r4 = kotlin.text.StringsKt__StringNumberConversionsKt.toLongOrNull(r4);
     */
    @NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Properties b(@NotNull k createReportParams) {
        Object obj;
        Intrinsics.checkParameterIsNotNull(createReportParams, "$this$createReportParams");
        Properties properties = new Properties();
        properties.put(IPreloadServiceProxy.KEY_RESID, createReportParams.x());
        properties.put("app_id", createReportParams.getAppInfo().c());
        properties.put("req_mode", c(createReportParams));
        com.tencent.rdelivery.reshub.core.j jVar = com.tencent.rdelivery.reshub.core.j.L;
        a(properties, "host_app_ver", jVar.e(createReportParams.getAppInfo()));
        a(properties, "dev_id", jVar.f(createReportParams.getAppInfo()));
        jz3.e resConfig = createReportParams.getResConfig();
        if (resConfig == null) {
            resConfig = createReportParams.E();
        }
        if (resConfig != null) {
            String str = resConfig.f411279t;
            if (str == null || obj == null) {
                obj = 0;
            }
            properties.put("res_ver", obj);
            properties.put("file_ver", Long.valueOf(resConfig.f411261b));
        }
        return properties;
    }

    @NotNull
    public static final String c(@NotNull k reqModeToReportMode) {
        Intrinsics.checkParameterIsNotNull(reqModeToReportMode, "$this$reqModeToReportMode");
        int mode = reqModeToReportMode.getMode();
        if (mode != 1) {
            if (mode != 2) {
                if (mode != 3) {
                    if (mode != 4) {
                        if (mode != 5) {
                            return "[unknown]";
                        }
                        return "preload";
                    }
                    return "task";
                }
                return "fetch_config";
            }
            return "update";
        }
        return JoinPoint.SYNCHRONIZATION_LOCK;
    }

    @NotNull
    public static final a d(@NotNull IRNetwork.ResultInfo toErrorInfo, int i3, int i16) {
        Intrinsics.checkParameterIsNotNull(toErrorInfo, "$this$toErrorInfo");
        a aVar = new a();
        if (toErrorInfo.isSuccess()) {
            i3 = 0;
        } else if (!toErrorInfo.isHttpError()) {
            toErrorInfo.isOtherError();
            i3 = i16;
        }
        aVar.e(i3);
        aVar.g("code: " + toErrorInfo.getErrorCode() + " message: " + toErrorInfo.getErrorMessage());
        return aVar;
    }
}
