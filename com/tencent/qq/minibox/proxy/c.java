package com.tencent.qq.minibox.proxy;

import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.common.config.AppSetting;
import com.tencent.common.config.pad.DeviceType;
import com.tencent.common.config.pad.PadUtil;
import com.tencent.minibox.proxy.HostInfoProxy;
import com.tencent.minibox.proxy.ObtainInfoCallback;
import com.tencent.mobileqq.minigame.api.IMiniGameVaConfigApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ah;
import com.tencent.qmethod.pandoraex.monitor.NetworkMonitor;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u0007\u00a2\u0006\u0004\b\u0017\u0010\u0018J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\u0007\u001a\u00020\u0002H\u0016J\n\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\u000e\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0016J\"\u0010\u0013\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\u00022\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\r\u001a\u00020\u00022\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016J\u0012\u0010\u0016\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0015\u001a\u00020\u0002H\u0016\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/qq/minibox/proxy/c;", "Lcom/tencent/minibox/proxy/HostInfoProxy;", "", "getAppVersion", "getModel", "", "getNetWorkType", "getOSVersion", "Landroid/net/wifi/WifiInfo;", "getConnectionInfo", "", "Landroid/net/wifi/ScanResult;", "getScanResults", "cmd", "Landroid/os/Bundle;", "params", "Lcom/tencent/minibox/proxy/ObtainInfoCallback;", "callback", "", "obtainInfoAsync", "obtainInfoSync", "key", "getHostEnvInfo", "<init>", "()V", "a", "minibox-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class c implements HostInfoProxy {

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private static final ArrayList<ScanResult> f344598b = new ArrayList<>();

    @Override // com.tencent.minibox.proxy.HostInfoProxy
    @NotNull
    public String getAppVersion() {
        String subVersion = AppSetting.f99551k;
        Intrinsics.checkNotNullExpressionValue(subVersion, "subVersion");
        return subVersion;
    }

    @Override // com.tencent.minibox.proxy.HostInfoProxy
    @Nullable
    public WifiInfo getConnectionInfo() {
        return null;
    }

    @Override // com.tencent.minibox.proxy.HostInfoProxy
    @Nullable
    public String getHostEnvInfo(@NotNull String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        if (Intrinsics.areEqual("diffPatchDownloadEnable", key)) {
            if (((IMiniGameVaConfigApi) QRoute.api(IMiniGameVaConfigApi.class)).isDiffPatchEnable()) {
                return "1";
            }
            return "";
        }
        if (Intrinsics.areEqual("deviceIsFold", key) && PadUtil.a(BaseApplication.getContext()) != DeviceType.FOLD) {
            return "1";
        }
        return "";
    }

    @Override // com.tencent.minibox.proxy.HostInfoProxy
    @NotNull
    public String getModel() {
        String F = ah.F();
        Intrinsics.checkNotNullExpressionValue(F, "getModel()");
        return F;
    }

    @Override // com.tencent.minibox.proxy.HostInfoProxy
    public int getNetWorkType() {
        return HttpUtil.getNetWorkType();
    }

    @Override // com.tencent.minibox.proxy.HostInfoProxy
    @NotNull
    public String getOSVersion() {
        String t16 = ah.t();
        Intrinsics.checkNotNullExpressionValue(t16, "getDeviceOSVersion()");
        return t16;
    }

    @Override // com.tencent.minibox.proxy.HostInfoProxy
    @NotNull
    public List<ScanResult> getScanResults() {
        ArrayList<ScanResult> arrayList = f344598b;
        if (!arrayList.isEmpty()) {
            return arrayList;
        }
        Object systemService = BaseApplication.getContext().getApplicationContext().getSystemService("wifi");
        if (systemService instanceof WifiManager) {
            arrayList.addAll(NetworkMonitor.getScanResults((WifiManager) systemService));
        }
        return arrayList;
    }

    @Override // com.tencent.minibox.proxy.HostInfoProxy
    public void obtainInfoAsync(@NotNull String cmd, @Nullable Bundle params, @NotNull ObtainInfoCallback callback) {
        Intrinsics.checkNotNullParameter(cmd, "cmd");
        Intrinsics.checkNotNullParameter(callback, "callback");
        us3.d.f439982a.c(cmd, params, callback);
    }

    @Override // com.tencent.minibox.proxy.HostInfoProxy
    @Nullable
    public Bundle obtainInfoSync(@NotNull String cmd, @Nullable Bundle params) {
        Intrinsics.checkNotNullParameter(cmd, "cmd");
        return us3.d.f439982a.d(cmd, params);
    }
}
