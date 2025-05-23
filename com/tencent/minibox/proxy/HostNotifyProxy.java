package com.tencent.minibox.proxy;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import androidx.annotation.Keep;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.vivo.push.PushClientConstants;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Keep
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&J \u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH&J\u001a\u0010\u0010\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0011H&J\u001a\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0011H&J\u001a\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0011H&J \u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0006\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\u0018H&J\u001a\u0010\u0019\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0011H&J\u0018\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\rH&\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/minibox/proxy/HostNotifyProxy;", "", "callHost", "", "context", "Landroid/content/Context;", "params", "", "callback", "Lcom/tencent/minibox/proxy/CallHostCallback;", "getLoginInfo", PushClientConstants.TAG_PKG_NAME, "forceUpdate", "", "callBack", "Lcom/tencent/minibox/proxy/LoginInfoCallback;", "msdkShare", "Landroid/os/Bundle;", "notifyHost", "action", "route", "saveImageToPhotosAlbum", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/app/Activity;", "Lcom/tencent/minibox/proxy/HostNotifySimpleBooleanCallback;", "showShareArkPanel", "updateWifiAutoUpdateFlag", "allowWifiAutoUpdate", "MiniBoxDynamicApi_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes9.dex */
public interface HostNotifyProxy {
    void callHost(@NotNull Context context, @NotNull String params, @NotNull CallHostCallback callback);

    void getLoginInfo(@NotNull String pkgName, boolean forceUpdate, @NotNull LoginInfoCallback callBack);

    void msdkShare(@Nullable Context context, @NotNull Bundle params);

    void notifyHost(@NotNull String action, @Nullable Bundle params);

    void route(@NotNull Context context, @Nullable Bundle params);

    void saveImageToPhotosAlbum(@NotNull Activity activity, @NotNull Bundle params, @NotNull HostNotifySimpleBooleanCallback callBack);

    void showShareArkPanel(@Nullable Context context, @NotNull Bundle params);

    void updateWifiAutoUpdateFlag(@NotNull String pkgName, boolean allowWifiAutoUpdate);
}
