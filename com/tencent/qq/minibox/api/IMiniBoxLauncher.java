package com.tencent.qq.minibox.api;

import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.qq.minibox.api.data.VirtualAppInfo;
import com.vivo.push.PushClientConstants;
import fs3.MiniBoxInfo;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&J\b\u0010\u0007\u001a\u00020\u0002H&J$\u0010\f\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\nH&J \u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH&J0\u0010\u0015\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\b2\b\u0010\u0013\u001a\u0004\u0018\u00010\b2\b\u0010\u0014\u001a\u0004\u0018\u00010\bH&Jq\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u00162W\b\u0002\u0010 \u001aQ\u0012\u0013\u0012\u00110\u0019\u00a2\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001c\u0012\u0013\u0012\u00110\u000f\u00a2\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001d\u0012\u0015\u0012\u0013\u0018\u00010\b\u00a2\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001e\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0018j\u0004\u0018\u0001`\u001fH&J\b\u0010!\u001a\u00020\bH&J\u0010\u0010\"\u001a\u00020\u00192\u0006\u0010\u0013\u001a\u00020\bH&J\f\u0010$\u001a\u0006\u0012\u0002\b\u00030#H&J\u0010\u0010&\u001a\u00020\u00022\u0006\u0010%\u001a\u00020\u000fH&JX\u0010+\u001a\u00020\u00022N\u0010 \u001aJ\u0012\u0013\u0012\u00110\u0019\u00a2\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001c\u0012\u001b\u0012\u0019\u0012\u0004\u0012\u00020\u0016\u0018\u00010(\u00a2\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b()\u0012\u0004\u0012\u00020\u00020'j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160(`*H&J\u0012\u0010-\u001a\u0004\u0018\u00010\u00162\u0006\u0010,\u001a\u00020\bH&Ji\u0010/\u001a\u00020\u00022\u0006\u0010.\u001a\u00020\b2W\b\u0002\u0010 \u001aQ\u0012\u0013\u0012\u00110\u0019\u00a2\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001c\u0012\u0013\u0012\u00110\u000f\u00a2\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001d\u0012\u0015\u0012\u0013\u0018\u00010\b\u00a2\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001e\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0018j\u0004\u0018\u0001`\u001fH&Ji\u00100\u001a\u00020\u00022\u0006\u0010,\u001a\u00020\b2W\b\u0002\u0010 \u001aQ\u0012\u0013\u0012\u00110\u0019\u00a2\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001c\u0012\u0013\u0012\u00110\u000f\u00a2\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001d\u0012\u0015\u0012\u0013\u0018\u00010\b\u00a2\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001e\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0018j\u0004\u0018\u0001`\u001fH&J\u0010\u00102\u001a\u0002012\u0006\u0010\u0005\u001a\u00020\u0004H&J\u0010\u00103\u001a\u0002012\u0006\u0010,\u001a\u00020\bH&J\u0010\u00104\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&\u00a8\u00065"}, d2 = {"Lcom/tencent/qq/minibox/api/IMiniBoxLauncher;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "", "preload", "Landroid/content/Context;", "context", "init", "onApplicationCreate", "", "dataJson", "Landroid/content/Intent;", "intent", "startMiniBoxManagerPage", "Lcom/tencent/qq/minibox/api/data/MiniBoxAppDataInfo;", "miniBoxAppDataInfo", "", "from", "startVirtualApp", "appId", "packageName", "appVersion", "launchVirtualApp", "Lfs3/a;", "miniBoxInfo", "Lkotlin/Function3;", "", "Lkotlin/ParameterName;", "name", "isSuccess", "errCode", "errMsg", "Lcom/tencent/qq/minibox/constants/MiniBoxCallback;", "callback", "getMiniBoxInstallApp", "isMiniBoxAppInstall", "Ljava/lang/Class;", "getMiniBoxDebugFragmentClass", "result", "reportHippyEntryStatus", "Lkotlin/Function2;", "", "data", "Lcom/tencent/qq/minibox/constants/MiniBoxDataCallback;", "getMiniBoxInstallList", PushClientConstants.TAG_PKG_NAME, "getCacheMiniBoxAppInfo", "apkPath", "installVirtualApp", "uninstallVirtualApp", "", "getAllCacheSize", "getAppCacheSize", "preLaunchProcess", "minibox-api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes22.dex */
public interface IMiniBoxLauncher extends QRouteApi {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes22.dex */
    public static final class a {
        public static /* synthetic */ void a(IMiniBoxLauncher iMiniBoxLauncher, Context context, String str, Intent intent, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 4) != 0) {
                    intent = null;
                }
                iMiniBoxLauncher.startMiniBoxManagerPage(context, str, intent);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: startMiniBoxManagerPage");
        }
    }

    long getAllCacheSize(@NotNull Context context);

    long getAppCacheSize(@NotNull String pkgName);

    @Nullable
    MiniBoxInfo getCacheMiniBoxAppInfo(@NotNull String pkgName);

    @NotNull
    Class<?> getMiniBoxDebugFragmentClass();

    @NotNull
    String getMiniBoxInstallApp();

    void getMiniBoxInstallList(@NotNull Function2<? super Boolean, ? super List<MiniBoxInfo>, Unit> callback);

    void init(@NotNull Context context);

    void installVirtualApp(@NotNull String apkPath, @Nullable Function3<? super Boolean, ? super Integer, ? super String, Unit> callback);

    boolean isMiniBoxAppInstall(@NotNull String packageName);

    void launchVirtualApp(@Nullable Context context, @Nullable String appId, @Nullable String packageName, @Nullable String appVersion);

    void launchVirtualApp(@NotNull String appId, @NotNull MiniBoxInfo miniBoxInfo, @Nullable Function3<? super Boolean, ? super Integer, ? super String, Unit> callback);

    void onApplicationCreate();

    void preLaunchProcess(@NotNull Context context);

    void preload();

    void reportHippyEntryStatus(int result);

    void startMiniBoxManagerPage(@NotNull Context context, @NotNull String dataJson, @Nullable Intent intent);

    void startVirtualApp(@NotNull Context context, @NotNull VirtualAppInfo miniBoxAppDataInfo, int from);

    void uninstallVirtualApp(@NotNull String pkgName, @Nullable Function3<? super Boolean, ? super Integer, ? super String, Unit> callback);
}
