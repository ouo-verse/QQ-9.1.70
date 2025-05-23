package com.tencent.mobileqq.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\"\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&J\u000e\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007H&J\u000e\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\tH&J\b\u0010\n\u001a\u00020\u000bH&J\b\u0010\f\u001a\u00020\u000bH&J\b\u0010\r\u001a\u00020\u000bH&\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/api/IBuildConfig;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "getAlphaBuildNo", "", "getDCLType", "", "getDynamicFeaturePlugins", "", "getRouteModules", "", "isQRun", "", "isQRunCompact", "isUITest", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {"all"})
/* loaded from: classes11.dex */
public interface IBuildConfig extends QRouteApi {
    @NotNull
    String getAlphaBuildNo();

    int getDCLType();

    @NotNull
    Set<String> getDynamicFeaturePlugins();

    @NotNull
    List<String> getRouteModules();

    boolean isQRun();

    boolean isQRunCompact();

    boolean isUITest();
}
