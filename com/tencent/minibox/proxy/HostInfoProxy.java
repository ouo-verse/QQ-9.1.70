package com.tencent.minibox.proxy;

import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.os.Bundle;
import androidx.annotation.Keep;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Keep
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\n\u0010\u0002\u001a\u0004\u0018\u00010\u0003H&J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0007\u001a\u00020\u0003H&J\b\u0010\b\u001a\u00020\u0003H&J\b\u0010\t\u001a\u00020\nH&J\b\u0010\u000b\u001a\u00020\u0003H&J\u0010\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rH&J\"\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00032\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u0015H&J\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0011\u001a\u00020\u00032\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H&\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/minibox/proxy/HostInfoProxy;", "", "getAppVersion", "", "getConnectionInfo", "Landroid/net/wifi/WifiInfo;", "getHostEnvInfo", "key", "getModel", "getNetWorkType", "", "getOSVersion", "getScanResults", "", "Landroid/net/wifi/ScanResult;", "obtainInfoAsync", "", "cmd", "params", "Landroid/os/Bundle;", "callback", "Lcom/tencent/minibox/proxy/ObtainInfoCallback;", "obtainInfoSync", "MiniBoxDynamicApi_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes9.dex */
public interface HostInfoProxy {
    @Nullable
    String getAppVersion();

    @Nullable
    WifiInfo getConnectionInfo();

    @Nullable
    String getHostEnvInfo(@NotNull String key);

    @NotNull
    String getModel();

    int getNetWorkType();

    @NotNull
    String getOSVersion();

    @Nullable
    List<ScanResult> getScanResults();

    void obtainInfoAsync(@NotNull String cmd, @Nullable Bundle params, @NotNull ObtainInfoCallback callback);

    @Nullable
    Bundle obtainInfoSync(@NotNull String cmd, @Nullable Bundle params);
}
