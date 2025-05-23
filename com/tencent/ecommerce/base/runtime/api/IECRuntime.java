package com.tencent.ecommerce.base.runtime.api;

import android.app.Application;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0014\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0005H&J\b\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\b\u001a\u00020\tH&J\b\u0010\n\u001a\u00020\tH&J\b\u0010\u000b\u001a\u00020\tH&J\b\u0010\f\u001a\u00020\tH&\u00a8\u0006\r"}, d2 = {"Lcom/tencent/ecommerce/base/runtime/api/IECRuntime;", "", "appVersion", "", "getDeviceInfo", "", "getExternalApplicationContext", "Landroid/app/Application;", "isDebug", "", "isMainProcess", "isPublicVersion", "isTestEnv", "ecommerce_api_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes5.dex */
public interface IECRuntime {
    @NotNull
    String appVersion();

    @NotNull
    Map<String, String> getDeviceInfo();

    @NotNull
    Application getExternalApplicationContext();

    boolean isDebug();

    boolean isMainProcess();

    boolean isPublicVersion();

    boolean isTestEnv();
}
