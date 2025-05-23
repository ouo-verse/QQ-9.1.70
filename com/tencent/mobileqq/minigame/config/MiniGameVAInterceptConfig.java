package com.tencent.mobileqq.minigame.config;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.freesia.IConfigData;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.activity.miniaio.MiniChatConstants;
import com.tencent.qqmini.sdk.launcher.core.proxy.va.VirtualAppProxy;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0002\b\u001a\n\u0002\u0010\t\n\u0002\b\r\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u001e\u0018\u0000 W2\u00020\u0001:\u0002WXB\u0005\u00a2\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR \u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0006\"\u0004\b\u0018\u0010\bR\u001a\u0010\u0019\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0006\"\u0004\b\u001b\u0010\bR\u001a\u0010\u001c\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\f\"\u0004\b\u001e\u0010\u000eR\u001a\u0010\u001f\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0006\"\u0004\b!\u0010\bR\u001a\u0010\"\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0006\"\u0004\b$\u0010\bR\u001a\u0010%\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u0006\"\u0004\b'\u0010\bR\u001a\u0010(\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\f\"\u0004\b*\u0010\u000eR\u001a\u0010+\u001a\u00020,X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u001c\u00101\u001a\u0004\u0018\u00010\u0011X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\u001a\u00106\u001a\u00020,X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b7\u0010.\"\u0004\b8\u00100R&\u00109\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020;0:X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R\u001a\u0010@\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b@\u0010\u0006\"\u0004\bA\u0010\bR\u001a\u0010B\u001a\u00020\u0011X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bC\u00103\"\u0004\bD\u00105R\u001a\u0010E\u001a\u00020\u0011X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bF\u00103\"\u0004\bG\u00105R\u001a\u0010H\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bI\u0010\u0006\"\u0004\bJ\u0010\bR\u001a\u0010K\u001a\u00020\u0011X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bL\u00103\"\u0004\bM\u00105R\u001a\u0010N\u001a\u00020\u0011X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bO\u00103\"\u0004\bP\u00105R\u001a\u0010Q\u001a\u00020\u0011X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bR\u00103\"\u0004\bS\u00105R\u001a\u0010T\u001a\u00020\u0011X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bU\u00103\"\u0004\bV\u00105\u00a8\u0006Y"}, d2 = {"Lcom/tencent/mobileqq/minigame/config/MiniGameVAInterceptConfig;", "Lcom/tencent/freesia/IConfigData;", "()V", "apkDownloadInnerStorageSwitch", "", "getApkDownloadInnerStorageSwitch", "()Z", "setApkDownloadInnerStorageSwitch", "(Z)V", VirtualAppProxy.KEY_AUTO_DOWNLOAD, "", "getAutoDownload", "()I", "setAutoDownload", "(I)V", "availableCheckCrashStacks", "", "", "getAvailableCheckCrashStacks", "()Ljava/util/List;", "setAvailableCheckCrashStacks", "(Ljava/util/List;)V", "availableCheckDefault", "getAvailableCheckDefault", "setAvailableCheckDefault", "availableCheckSwitch", "getAvailableCheckSwitch", "setAvailableCheckSwitch", "availableCheckTimeout", "getAvailableCheckTimeout", "setAvailableCheckTimeout", "checkVADownloadIgnoreGameEvent", "getCheckVADownloadIgnoreGameEvent", "setCheckVADownloadIgnoreGameEvent", "diffPatchDownloadEnable", "getDiffPatchDownloadEnable", "setDiffPatchDownloadEnable", "diffPatchMD5CheckEnable", "getDiffPatchMD5CheckEnable", "setDiffPatchMD5CheckEnable", VirtualAppProxy.KEY_DOWNLOAD_TYPE_ON_WIFI, "getDownloadTypeOnWifi", "setDownloadTypeOnWifi", "fastClickMinInterval", "", "getFastClickMinInterval", "()J", "setFastClickMinInterval", "(J)V", "gameAppOpenScheme", "getGameAppOpenScheme", "()Ljava/lang/String;", "setGameAppOpenScheme", "(Ljava/lang/String;)V", "hotfixTimeout", "getHotfixTimeout", "setHotfixTimeout", "interceptConfigMap", "", "Lcom/tencent/mobileqq/minigame/config/MiniGameVAInterceptConfig$VAInterceptConfig;", "getInterceptConfigMap", "()Ljava/util/Map;", "setInterceptConfigMap", "(Ljava/util/Map;)V", "isDisableVAOnFenShenApp", "setDisableVAOnFenShenApp", "loadingViewInstalledTips", "getLoadingViewInstalledTips", "setLoadingViewInstalledTips", "loadingViewInstallingTips", "getLoadingViewInstallingTips", "setLoadingViewInstallingTips", "preLaunchProcess", "getPreLaunchProcess", "setPreLaunchProcess", "restartConfirmDialogContent", "getRestartConfirmDialogContent", "setRestartConfirmDialogContent", "restartConfirmDialogNegativeButton", "getRestartConfirmDialogNegativeButton", "setRestartConfirmDialogNegativeButton", "restartConfirmDialogPositiveButton", "getRestartConfirmDialogPositiveButton", "setRestartConfirmDialogPositiveButton", "vaSwitchInfo", "getVaSwitchInfo", "setVaSwitchInfo", "Companion", "VAInterceptConfig", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final class MiniGameVAInterceptConfig implements IConfigData {
    public static final String CONFIG_ID = "102577";
    public static final long DEFAULT_FAST_CLICK_MIN_INTERVAL = 1000;
    private boolean availableCheckSwitch;
    private int availableCheckTimeout;
    private boolean diffPatchMD5CheckEnable;
    private int downloadTypeOnWifi;
    private String gameAppOpenScheme;
    private long hotfixTimeout;
    private boolean isDisableVAOnFenShenApp;
    private boolean preLaunchProcess;
    private int autoDownload = 1;
    private boolean checkVADownloadIgnoreGameEvent = true;
    private Map<String, VAInterceptConfig> interceptConfigMap = new LinkedHashMap();
    private String vaSwitchInfo = "";
    private boolean availableCheckDefault = true;
    private List<String> availableCheckCrashStacks = new ArrayList();
    private long fastClickMinInterval = 1000;
    private boolean apkDownloadInnerStorageSwitch = true;
    private String loadingViewInstallingTips = "\u65b0\u7248\u672c\u5b89\u88c5\u4e2d%d%%\uff0c\u5b89\u88c5\u8fc7\u7a0b\u4e0d\u6d88\u8017\u6d41\u91cf";
    private String loadingViewInstalledTips = "\u5b89\u88c5\u5b8c\u6210\uff0c\u5373\u5c06\u5f00\u542f\u519c\u573a\u65b0\u7bc7\u7ae0...";
    private String restartConfirmDialogContent = "\u7ecf\u5178\u519c\u573a\u5df2\u66f4\u65b0\u5b8c\u6210\uff0c\u7acb\u5373\u91cd\u542f\u9700\u7b49\u5f85\u8f83\u957f\u65f6\u95f4\uff0c\u63a8\u8350\u7ee7\u7eed\u6e38\u620f\uff0c\u95f2\u65f6\u540e\u53f0\u5c06\u4e3a\u60a8\u81ea\u52a8\u5b8c\u6210\u5b89\u88c5~";
    private String restartConfirmDialogPositiveButton = "\u7ee7\u7eed\u6e38\u620f";
    private String restartConfirmDialogNegativeButton = "\u7acb\u5373\u91cd\u542f";
    private boolean diffPatchDownloadEnable = true;

    public final boolean getApkDownloadInnerStorageSwitch() {
        return this.apkDownloadInnerStorageSwitch;
    }

    public final int getAutoDownload() {
        return this.autoDownload;
    }

    public final List<String> getAvailableCheckCrashStacks() {
        return this.availableCheckCrashStacks;
    }

    public final boolean getAvailableCheckDefault() {
        return this.availableCheckDefault;
    }

    public final boolean getAvailableCheckSwitch() {
        return this.availableCheckSwitch;
    }

    public final int getAvailableCheckTimeout() {
        return this.availableCheckTimeout;
    }

    public final boolean getCheckVADownloadIgnoreGameEvent() {
        return this.checkVADownloadIgnoreGameEvent;
    }

    public final boolean getDiffPatchDownloadEnable() {
        return this.diffPatchDownloadEnable;
    }

    public final boolean getDiffPatchMD5CheckEnable() {
        return this.diffPatchMD5CheckEnable;
    }

    public final int getDownloadTypeOnWifi() {
        return this.downloadTypeOnWifi;
    }

    public final long getFastClickMinInterval() {
        return this.fastClickMinInterval;
    }

    public final String getGameAppOpenScheme() {
        return this.gameAppOpenScheme;
    }

    public final long getHotfixTimeout() {
        return this.hotfixTimeout;
    }

    public final Map<String, VAInterceptConfig> getInterceptConfigMap() {
        return this.interceptConfigMap;
    }

    public final String getLoadingViewInstalledTips() {
        return this.loadingViewInstalledTips;
    }

    public final String getLoadingViewInstallingTips() {
        return this.loadingViewInstallingTips;
    }

    public final boolean getPreLaunchProcess() {
        return this.preLaunchProcess;
    }

    public final String getRestartConfirmDialogContent() {
        return this.restartConfirmDialogContent;
    }

    public final String getRestartConfirmDialogNegativeButton() {
        return this.restartConfirmDialogNegativeButton;
    }

    public final String getRestartConfirmDialogPositiveButton() {
        return this.restartConfirmDialogPositiveButton;
    }

    public final String getVaSwitchInfo() {
        return this.vaSwitchInfo;
    }

    /* renamed from: isDisableVAOnFenShenApp, reason: from getter */
    public final boolean getIsDisableVAOnFenShenApp() {
        return this.isDisableVAOnFenShenApp;
    }

    public final void setApkDownloadInnerStorageSwitch(boolean z16) {
        this.apkDownloadInnerStorageSwitch = z16;
    }

    public final void setAutoDownload(int i3) {
        this.autoDownload = i3;
    }

    public final void setAvailableCheckCrashStacks(List<String> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.availableCheckCrashStacks = list;
    }

    public final void setAvailableCheckDefault(boolean z16) {
        this.availableCheckDefault = z16;
    }

    public final void setAvailableCheckSwitch(boolean z16) {
        this.availableCheckSwitch = z16;
    }

    public final void setAvailableCheckTimeout(int i3) {
        this.availableCheckTimeout = i3;
    }

    public final void setCheckVADownloadIgnoreGameEvent(boolean z16) {
        this.checkVADownloadIgnoreGameEvent = z16;
    }

    public final void setDiffPatchDownloadEnable(boolean z16) {
        this.diffPatchDownloadEnable = z16;
    }

    public final void setDiffPatchMD5CheckEnable(boolean z16) {
        this.diffPatchMD5CheckEnable = z16;
    }

    public final void setDisableVAOnFenShenApp(boolean z16) {
        this.isDisableVAOnFenShenApp = z16;
    }

    public final void setDownloadTypeOnWifi(int i3) {
        this.downloadTypeOnWifi = i3;
    }

    public final void setFastClickMinInterval(long j3) {
        this.fastClickMinInterval = j3;
    }

    public final void setGameAppOpenScheme(String str) {
        this.gameAppOpenScheme = str;
    }

    public final void setHotfixTimeout(long j3) {
        this.hotfixTimeout = j3;
    }

    public final void setInterceptConfigMap(Map<String, VAInterceptConfig> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.interceptConfigMap = map;
    }

    public final void setLoadingViewInstalledTips(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.loadingViewInstalledTips = str;
    }

    public final void setLoadingViewInstallingTips(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.loadingViewInstallingTips = str;
    }

    public final void setPreLaunchProcess(boolean z16) {
        this.preLaunchProcess = z16;
    }

    public final void setRestartConfirmDialogContent(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.restartConfirmDialogContent = str;
    }

    public final void setRestartConfirmDialogNegativeButton(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.restartConfirmDialogNegativeButton = str;
    }

    public final void setRestartConfirmDialogPositiveButton(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.restartConfirmDialogPositiveButton = str;
    }

    public final void setVaSwitchInfo(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.vaSwitchInfo = str;
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b&\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0086\b\u0018\u0000 >2\u00020\u0001:\u0001>B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004Bm\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u0006\u0012\u0006\u0010\u000b\u001a\u00020\u0006\u0012\u0006\u0010\f\u001a\u00020\u0006\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\u0006\u0010\u0010\u001a\u00020\u0006\u0012\u0006\u0010\u0011\u001a\u00020\t\u0012\u0006\u0010\u0012\u001a\u00020\u0006\u0012\u0006\u0010\u0013\u001a\u00020\u000e\u0012\u0006\u0010\u0014\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u0015J\t\u0010$\u001a\u00020\u0006H\u00c6\u0003J\t\u0010%\u001a\u00020\tH\u00c6\u0003J\t\u0010&\u001a\u00020\u0006H\u00c6\u0003J\t\u0010'\u001a\u00020\u000eH\u00c6\u0003J\t\u0010(\u001a\u00020\u0006H\u00c6\u0003J\t\u0010)\u001a\u00020\u0006H\u00c6\u0003J\t\u0010*\u001a\u00020\tH\u00c6\u0003J\t\u0010+\u001a\u00020\u0006H\u00c6\u0003J\t\u0010,\u001a\u00020\u0006H\u00c6\u0003J\t\u0010-\u001a\u00020\u0006H\u00c6\u0003J\t\u0010.\u001a\u00020\u000eH\u00c6\u0003J\t\u0010/\u001a\u00020\u000eH\u00c6\u0003J\t\u00100\u001a\u00020\u0006H\u00c6\u0003J\u008b\u0001\u00101\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u00062\b\b\u0002\u0010\u000b\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\u00062\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u00062\b\b\u0002\u0010\u0011\u001a\u00020\t2\b\b\u0002\u0010\u0012\u001a\u00020\u00062\b\b\u0002\u0010\u0013\u001a\u00020\u000e2\b\b\u0002\u0010\u0014\u001a\u00020\u0006H\u00c6\u0001J\b\u00102\u001a\u00020\tH\u0016J\u0013\u00103\u001a\u00020\u000e2\b\u00104\u001a\u0004\u0018\u000105H\u00d6\u0003J\f\u00106\u001a\b\u0012\u0004\u0012\u00020\u000607J\t\u00108\u001a\u00020\tH\u00d6\u0001J\t\u00109\u001a\u00020\u0006H\u00d6\u0001J\u0018\u0010:\u001a\u00020;2\u0006\u0010<\u001a\u00020\u00032\u0006\u0010=\u001a\u00020\tH\u0016R\u0011\u0010\n\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0012\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0017R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0017R\u0011\u0010\u0011\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\u0010\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0017R\u0011\u0010\b\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001bR\u0011\u0010\u000f\u001a\u00020\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010\u0007\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b \u0010\u0017R\u0011\u0010\u0013\u001a\u00020\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u001fR\u0011\u0010\r\u001a\u00020\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u001fR\u0011\u0010\u000b\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0017R\u0011\u0010\f\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0017R\u0011\u0010\u0014\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0017\u00a8\u0006?"}, d2 = {"Lcom/tencent/mobileqq/minigame/config/MiniGameVAInterceptConfig$VAInterceptConfig;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "gameAppId", "", "gameAppPkgName", "gameAppMinVersionCode", "", "configId", "loadingImage", "miniGameId", MiniChatConstants.MINI_APP_LANDSCAPE, "", "gameAppOpenSwitch", "gameAppLaunchParams", "gameAppLaunchFlags", "gameAppDefaultDeepLink", "isAllJumpApp", "viaList", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZLjava/lang/String;ILjava/lang/String;ZLjava/lang/String;)V", "getConfigId", "()Ljava/lang/String;", "getGameAppDefaultDeepLink", "getGameAppId", "getGameAppLaunchFlags", "()I", "getGameAppLaunchParams", "getGameAppMinVersionCode", "getGameAppOpenSwitch", "()Z", "getGameAppPkgName", "getLoadingImage", "getMiniGameId", "getViaList", "component1", "component10", "component11", "component12", "component13", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "describeContents", "equals", "other", "", "getViaWhiteList", "", "hashCode", "toString", "writeToParcel", "", "dest", WadlProxyConsts.FLAGS, "CREATOR", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes33.dex */
    public static final /* data */ class VAInterceptConfig implements Parcelable {

        /* renamed from: CREATOR, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final String configId;
        private final String gameAppDefaultDeepLink;
        private final String gameAppId;
        private final int gameAppLaunchFlags;
        private final String gameAppLaunchParams;
        private final int gameAppMinVersionCode;
        private final boolean gameAppOpenSwitch;
        private final String gameAppPkgName;
        private final boolean isAllJumpApp;
        private final boolean isLandscape;
        private final String loadingImage;
        private final String miniGameId;
        private final String viaList;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001d\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016\u00a2\u0006\u0002\u0010\u000b\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/minigame/config/MiniGameVAInterceptConfig$VAInterceptConfig$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mobileqq/minigame/config/MiniGameVAInterceptConfig$VAInterceptConfig;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mobileqq/minigame/config/MiniGameVAInterceptConfig$VAInterceptConfig;", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
        /* renamed from: com.tencent.mobileqq.minigame.config.MiniGameVAInterceptConfig$VAInterceptConfig$CREATOR, reason: from kotlin metadata */
        /* loaded from: classes33.dex */
        public static final class Companion implements Parcelable.Creator<VAInterceptConfig> {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            Companion() {
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public VAInterceptConfig createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new VAInterceptConfig(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public VAInterceptConfig[] newArray(int size) {
                return new VAInterceptConfig[size];
            }
        }

        public VAInterceptConfig(String gameAppId, String gameAppPkgName, int i3, String configId, String loadingImage, String miniGameId, boolean z16, boolean z17, String gameAppLaunchParams, int i16, String gameAppDefaultDeepLink, boolean z18, String viaList) {
            Intrinsics.checkNotNullParameter(gameAppId, "gameAppId");
            Intrinsics.checkNotNullParameter(gameAppPkgName, "gameAppPkgName");
            Intrinsics.checkNotNullParameter(configId, "configId");
            Intrinsics.checkNotNullParameter(loadingImage, "loadingImage");
            Intrinsics.checkNotNullParameter(miniGameId, "miniGameId");
            Intrinsics.checkNotNullParameter(gameAppLaunchParams, "gameAppLaunchParams");
            Intrinsics.checkNotNullParameter(gameAppDefaultDeepLink, "gameAppDefaultDeepLink");
            Intrinsics.checkNotNullParameter(viaList, "viaList");
            this.gameAppId = gameAppId;
            this.gameAppPkgName = gameAppPkgName;
            this.gameAppMinVersionCode = i3;
            this.configId = configId;
            this.loadingImage = loadingImage;
            this.miniGameId = miniGameId;
            this.isLandscape = z16;
            this.gameAppOpenSwitch = z17;
            this.gameAppLaunchParams = gameAppLaunchParams;
            this.gameAppLaunchFlags = i16;
            this.gameAppDefaultDeepLink = gameAppDefaultDeepLink;
            this.isAllJumpApp = z18;
            this.viaList = viaList;
        }

        /* renamed from: component1, reason: from getter */
        public final String getGameAppId() {
            return this.gameAppId;
        }

        /* renamed from: component10, reason: from getter */
        public final int getGameAppLaunchFlags() {
            return this.gameAppLaunchFlags;
        }

        /* renamed from: component11, reason: from getter */
        public final String getGameAppDefaultDeepLink() {
            return this.gameAppDefaultDeepLink;
        }

        /* renamed from: component12, reason: from getter */
        public final boolean getIsAllJumpApp() {
            return this.isAllJumpApp;
        }

        /* renamed from: component13, reason: from getter */
        public final String getViaList() {
            return this.viaList;
        }

        /* renamed from: component2, reason: from getter */
        public final String getGameAppPkgName() {
            return this.gameAppPkgName;
        }

        /* renamed from: component3, reason: from getter */
        public final int getGameAppMinVersionCode() {
            return this.gameAppMinVersionCode;
        }

        /* renamed from: component4, reason: from getter */
        public final String getConfigId() {
            return this.configId;
        }

        /* renamed from: component5, reason: from getter */
        public final String getLoadingImage() {
            return this.loadingImage;
        }

        /* renamed from: component6, reason: from getter */
        public final String getMiniGameId() {
            return this.miniGameId;
        }

        /* renamed from: component7, reason: from getter */
        public final boolean getIsLandscape() {
            return this.isLandscape;
        }

        /* renamed from: component8, reason: from getter */
        public final boolean getGameAppOpenSwitch() {
            return this.gameAppOpenSwitch;
        }

        /* renamed from: component9, reason: from getter */
        public final String getGameAppLaunchParams() {
            return this.gameAppLaunchParams;
        }

        public final VAInterceptConfig copy(String gameAppId, String gameAppPkgName, int gameAppMinVersionCode, String configId, String loadingImage, String miniGameId, boolean isLandscape, boolean gameAppOpenSwitch, String gameAppLaunchParams, int gameAppLaunchFlags, String gameAppDefaultDeepLink, boolean isAllJumpApp, String viaList) {
            Intrinsics.checkNotNullParameter(gameAppId, "gameAppId");
            Intrinsics.checkNotNullParameter(gameAppPkgName, "gameAppPkgName");
            Intrinsics.checkNotNullParameter(configId, "configId");
            Intrinsics.checkNotNullParameter(loadingImage, "loadingImage");
            Intrinsics.checkNotNullParameter(miniGameId, "miniGameId");
            Intrinsics.checkNotNullParameter(gameAppLaunchParams, "gameAppLaunchParams");
            Intrinsics.checkNotNullParameter(gameAppDefaultDeepLink, "gameAppDefaultDeepLink");
            Intrinsics.checkNotNullParameter(viaList, "viaList");
            return new VAInterceptConfig(gameAppId, gameAppPkgName, gameAppMinVersionCode, configId, loadingImage, miniGameId, isLandscape, gameAppOpenSwitch, gameAppLaunchParams, gameAppLaunchFlags, gameAppDefaultDeepLink, isAllJumpApp, viaList);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public final String getConfigId() {
            return this.configId;
        }

        public final String getGameAppDefaultDeepLink() {
            return this.gameAppDefaultDeepLink;
        }

        public final String getGameAppId() {
            return this.gameAppId;
        }

        public final int getGameAppLaunchFlags() {
            return this.gameAppLaunchFlags;
        }

        public final String getGameAppLaunchParams() {
            return this.gameAppLaunchParams;
        }

        public final int getGameAppMinVersionCode() {
            return this.gameAppMinVersionCode;
        }

        public final boolean getGameAppOpenSwitch() {
            return this.gameAppOpenSwitch;
        }

        public final String getGameAppPkgName() {
            return this.gameAppPkgName;
        }

        public final String getLoadingImage() {
            return this.loadingImage;
        }

        public final String getMiniGameId() {
            return this.miniGameId;
        }

        public final String getViaList() {
            return this.viaList;
        }

        public final List<String> getViaWhiteList() {
            List<String> split$default;
            split$default = StringsKt__StringsKt.split$default((CharSequence) this.viaList, new String[]{","}, false, 0, 6, (Object) null);
            return split$default;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            int hashCode = ((((((((((this.gameAppId.hashCode() * 31) + this.gameAppPkgName.hashCode()) * 31) + this.gameAppMinVersionCode) * 31) + this.configId.hashCode()) * 31) + this.loadingImage.hashCode()) * 31) + this.miniGameId.hashCode()) * 31;
            boolean z16 = this.isLandscape;
            int i3 = z16;
            if (z16 != 0) {
                i3 = 1;
            }
            int i16 = (hashCode + i3) * 31;
            boolean z17 = this.gameAppOpenSwitch;
            int i17 = z17;
            if (z17 != 0) {
                i17 = 1;
            }
            int hashCode2 = (((((((i16 + i17) * 31) + this.gameAppLaunchParams.hashCode()) * 31) + this.gameAppLaunchFlags) * 31) + this.gameAppDefaultDeepLink.hashCode()) * 31;
            boolean z18 = this.isAllJumpApp;
            return ((hashCode2 + (z18 ? 1 : z18 ? 1 : 0)) * 31) + this.viaList.hashCode();
        }

        public final boolean isAllJumpApp() {
            return this.isAllJumpApp;
        }

        public final boolean isLandscape() {
            return this.isLandscape;
        }

        public String toString() {
            return "VAInterceptConfig(gameAppId=" + this.gameAppId + ", gameAppPkgName=" + this.gameAppPkgName + ", gameAppMinVersionCode=" + this.gameAppMinVersionCode + ", configId=" + this.configId + ", loadingImage=" + this.loadingImage + ", miniGameId=" + this.miniGameId + ", isLandscape=" + this.isLandscape + ", gameAppOpenSwitch=" + this.gameAppOpenSwitch + ", gameAppLaunchParams=" + this.gameAppLaunchParams + ", gameAppLaunchFlags=" + this.gameAppLaunchFlags + ", gameAppDefaultDeepLink=" + this.gameAppDefaultDeepLink + ", isAllJumpApp=" + this.isAllJumpApp + ", viaList=" + this.viaList + ")";
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel dest, int flags) {
            Intrinsics.checkNotNullParameter(dest, "dest");
            dest.writeString(this.gameAppId);
            dest.writeString(this.gameAppPkgName);
            dest.writeInt(this.gameAppMinVersionCode);
            dest.writeString(this.configId);
            dest.writeString(this.loadingImage);
            dest.writeString(this.miniGameId);
            dest.writeByte(this.isLandscape ? (byte) 1 : (byte) 0);
            dest.writeByte(this.gameAppOpenSwitch ? (byte) 1 : (byte) 0);
            dest.writeString(this.gameAppLaunchParams);
            dest.writeInt(this.gameAppLaunchFlags);
            dest.writeString(this.gameAppDefaultDeepLink);
            dest.writeByte(this.isAllJumpApp ? (byte) 1 : (byte) 0);
            dest.writeString(this.viaList);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof VAInterceptConfig)) {
                return false;
            }
            VAInterceptConfig vAInterceptConfig = (VAInterceptConfig) other;
            return Intrinsics.areEqual(this.gameAppId, vAInterceptConfig.gameAppId) && Intrinsics.areEqual(this.gameAppPkgName, vAInterceptConfig.gameAppPkgName) && this.gameAppMinVersionCode == vAInterceptConfig.gameAppMinVersionCode && Intrinsics.areEqual(this.configId, vAInterceptConfig.configId) && Intrinsics.areEqual(this.loadingImage, vAInterceptConfig.loadingImage) && Intrinsics.areEqual(this.miniGameId, vAInterceptConfig.miniGameId) && this.isLandscape == vAInterceptConfig.isLandscape && this.gameAppOpenSwitch == vAInterceptConfig.gameAppOpenSwitch && Intrinsics.areEqual(this.gameAppLaunchParams, vAInterceptConfig.gameAppLaunchParams) && this.gameAppLaunchFlags == vAInterceptConfig.gameAppLaunchFlags && Intrinsics.areEqual(this.gameAppDefaultDeepLink, vAInterceptConfig.gameAppDefaultDeepLink) && this.isAllJumpApp == vAInterceptConfig.isAllJumpApp && Intrinsics.areEqual(this.viaList, vAInterceptConfig.viaList);
        }

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public VAInterceptConfig(Parcel parcel) {
            this(r4, r5, r6, r7, r8, r9, r0, r11, r12, r13, r14, r15, r1 == null ? "" : r1);
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            String readString = parcel.readString();
            String str = readString == null ? "" : readString;
            String readString2 = parcel.readString();
            String str2 = readString2 == null ? "" : readString2;
            int readInt = parcel.readInt();
            String readString3 = parcel.readString();
            String str3 = readString3 == null ? "" : readString3;
            String readString4 = parcel.readString();
            String str4 = readString4 == null ? "" : readString4;
            String readString5 = parcel.readString();
            String str5 = readString5 == null ? "" : readString5;
            boolean z16 = parcel.readByte() != 0;
            boolean z17 = parcel.readByte() != 0;
            String readString6 = parcel.readString();
            readString6 = readString6 == null ? "" : readString6;
            int readInt2 = parcel.readInt();
            String readString7 = parcel.readString();
            readString7 = readString7 == null ? "" : readString7;
            boolean z18 = parcel.readByte() != 0;
            String readString8 = parcel.readString();
        }
    }
}
