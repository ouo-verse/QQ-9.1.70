package com.tencent.qqmini.minigame.plugins;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.res.Resources;
import android.os.Build;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.activity.miniaio.MiniChatConstants;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import com.tencent.qqlive.tvkplayer.api.TVKPlayerMsg;
import com.tencent.qqmini.minigame.helper.PreloadSystemInfoHelper;
import com.tencent.qqmini.sdk.annotation.JsEvent;
import com.tencent.qqmini.sdk.annotation.JsPlugin;
import com.tencent.qqmini.sdk.core.MiniAppConst;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.core.utils.DeviceUtil;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.model.AppThemeInfo;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.utils.DisplayUtil;
import com.tencent.qqmini.sdk.utils.DebugUtil;
import com.tencent.qqmini.sdk.utils.DeviceInfoUtil;
import com.tencent.qqmini.sdk.utils.QUAUtil;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;
import tl.h;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

@JsPlugin
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0007\u0018\u0000 \u00192\u00020\u0001:\u0003\u001a\u001b\u000eB\u0007\u00a2\u0006\u0004\b\u0017\u0010\u0018J \u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0002J\b\u0010\u000e\u001a\u00020\rH\u0002J\b\u0010\u0010\u001a\u00020\u000fH\u0002J\u0010\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u0011H\u0007J\u0010\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u0011H\u0007J\u0010\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u0011H\u0007\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/qqmini/minigame/plugins/GameInfoJsPlugin;", "Lcom/tencent/qqmini/sdk/launcher/core/plugins/BaseJsPlugin;", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", "density", "", "statusBarHeight", "getSafeAreaTop", "Lcom/tencent/qqmini/minigame/plugins/GameInfoJsPlugin$b;", "screenInfo", "Lorg/json/JSONObject;", "c", "Lcom/tencent/qqmini/minigame/plugins/GameInfoJsPlugin$AppDeviceInfo;", "b", "", "d", "Lcom/tencent/qqmini/sdk/launcher/core/model/RequestEvent;", "req", "", "getWindowInfo", "getAppBaseInfo", "getDeviceInfo", "<init>", "()V", "e", "AppDeviceInfo", "a", "lib_minigame_internalRelease"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes23.dex */
public final class GameInfoJsPlugin extends BaseJsPlugin {

    /* renamed from: d, reason: collision with root package name */
    private static AppDeviceInfo f346602d;

    /* JADX INFO: Access modifiers changed from: private */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010\t\n\u0002\b\t\b\u0002\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b!\u0010\"R\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001f\u0010\r\u001a\n \t*\u0004\u0018\u00010\b0\b8\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\n\u001a\u0004\b\u000b\u0010\fR*\u0010\u0011\u001a\n \t*\u0004\u0018\u00010\b0\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\n\u001a\u0004\b\u000e\u0010\f\"\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0014\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\n\u001a\u0004\b\u0013\u0010\fR*\u0010\u0017\u001a\n \t*\u0004\u0018\u00010\b0\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\n\u001a\u0004\b\u0012\u0010\f\"\u0004\b\u0016\u0010\u0010R\u001a\u0010\u0019\u001a\u00020\b8\u0006X\u0086D\u00a2\u0006\f\n\u0004\b\u000e\u0010\n\u001a\u0004\b\u0018\u0010\fR\u001b\u0010\u001d\u001a\u00020\u001a8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0018\u0010\u001b\u001a\u0004\b\u0015\u0010\u001cR\u001b\u0010\u001e\u001a\u00020\b8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0013\u0010\u001b\u001a\u0004\b\u0003\u0010\fR\u001b\u0010 \u001a\u00020\u001a8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001f\u0010\u001b\u001a\u0004\b\u001f\u0010\u001c\u00a8\u0006#"}, d2 = {"Lcom/tencent/qqmini/minigame/plugins/GameInfoJsPlugin$AppDeviceInfo;", "", "", "a", "I", "b", "()I", "benchmarkLevel", "", "kotlin.jvm.PlatformType", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "brand", "f", "setModel", "(Ljava/lang/String;)V", "model", "d", h.F, TVKPlayerMsg.PLAYER_CHOICE_SYSTEM, "e", "setCpuType", "cpuType", "g", "platform", "", "Lkotlin/Lazy;", "()J", "memorySize", "abi", "i", "versionCode", "<init>", "()V", "lib_minigame_internalRelease"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes23.dex */
    public static final class AppDeviceInfo {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final int benchmarkLevel = PreloadSystemInfoHelper.a();

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private final String brand = Build.BRAND;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        private String model = DeviceInfoUtil.getPhoneModel();

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String system = "Android " + Build.VERSION.RELEASE;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private String cpuType = Build.HARDWARE;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String platform = "android";

        /* renamed from: g, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final Lazy memorySize;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final Lazy abi;

        /* renamed from: i, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final Lazy versionCode;

        public AppDeviceInfo() {
            Lazy lazy;
            Lazy lazy2;
            Lazy lazy3;
            lazy = LazyKt__LazyJVMKt.lazy(new Function0<Long>() { // from class: com.tencent.qqmini.minigame.plugins.GameInfoJsPlugin$AppDeviceInfo$memorySize$2
                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Long invoke() {
                    return Long.valueOf(invoke2());
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final long invoke2() {
                    return DeviceUtil.getSystemTotalMemory() / 1048576;
                }
            });
            this.memorySize = lazy;
            lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<String>() { // from class: com.tencent.qqmini.minigame.plugins.GameInfoJsPlugin$AppDeviceInfo$abi$2
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return Build.CPU_ABI;
                }
            });
            this.abi = lazy2;
            lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<Long>() { // from class: com.tencent.qqmini.minigame.plugins.GameInfoJsPlugin$AppDeviceInfo$versionCode$2
                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Long invoke() {
                    return Long.valueOf(invoke2());
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final long invoke2() {
                    long longVersionCode;
                    AppLoaderFactory g16 = AppLoaderFactory.g();
                    Intrinsics.checkExpressionValueIsNotNull(g16, "AppLoaderFactory.g()");
                    Context ctx = g16.getContext();
                    if (Build.VERSION.SDK_INT >= 28) {
                        Intrinsics.checkExpressionValueIsNotNull(ctx, "ctx");
                        PackageInfo packageInfo = InstalledAppListMonitor.getPackageInfo(ctx.getPackageManager(), ctx.getPackageName(), 0);
                        Intrinsics.checkExpressionValueIsNotNull(packageInfo, "ctx.packageManager.getPa\u2026eInfo(ctx.packageName, 0)");
                        longVersionCode = packageInfo.getLongVersionCode();
                        return longVersionCode;
                    }
                    Intrinsics.checkExpressionValueIsNotNull(ctx, "ctx");
                    return InstalledAppListMonitor.getPackageInfo(ctx.getPackageManager(), ctx.getPackageName(), 0).versionCode;
                }
            });
            this.versionCode = lazy3;
        }

        @NotNull
        public final String a() {
            return (String) this.abi.getValue();
        }

        /* renamed from: b, reason: from getter */
        public final int getBenchmarkLevel() {
            return this.benchmarkLevel;
        }

        /* renamed from: c, reason: from getter */
        public final String getBrand() {
            return this.brand;
        }

        /* renamed from: d, reason: from getter */
        public final String getCpuType() {
            return this.cpuType;
        }

        public final long e() {
            return ((Number) this.memorySize.getValue()).longValue();
        }

        /* renamed from: f, reason: from getter */
        public final String getModel() {
            return this.model;
        }

        @NotNull
        /* renamed from: g, reason: from getter */
        public final String getPlatform() {
            return this.platform;
        }

        @NotNull
        /* renamed from: h, reason: from getter */
        public final String getSystem() {
            return this.system;
        }

        public final long i() {
            return ((Number) this.versionCode.getValue()).longValue();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u00105\u001a\u000202\u0012\u0006\u00106\u001a\u00020\u0016\u00a2\u0006\u0004\b7\u00108J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0017\u0010\u000b\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR\u0017\u0010\u0010\u001a\u00020\f8\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u0007\u0010\u000fR\u0017\u0010\u0015\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\"\u0010\u0019\u001a\u00020\u00168\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u0017\u0010\u001f\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u001d\u0010\u0012\u001a\u0004\b\u001e\u0010\u0014R\u0017\u0010\"\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b \u0010\u0012\u001a\u0004\b!\u0010\u0014R\u0017\u0010$\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b!\u0010\u0012\u001a\u0004\b#\u0010\u0014R\"\u0010'\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001e\u0010\u0012\u001a\u0004\b\u001d\u0010\u0014\"\u0004\b%\u0010&R\"\u0010)\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b#\u0010\u0012\u001a\u0004\b\u0011\u0010\u0014\"\u0004\b(\u0010&R\"\u0010+\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u0012\u001a\u0004\b\u0017\u0010\u0014\"\u0004\b*\u0010&R\"\u0010.\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b,\u0010\u0012\u001a\u0004\b \u0010\u0014\"\u0004\b-\u0010&R\"\u00101\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b/\u0010\u0012\u001a\u0004\b\r\u0010\u0014\"\u0004\b0\u0010&R\u0014\u00105\u001a\u0002028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b3\u00104\u00a8\u00069"}, d2 = {"Lcom/tencent/qqmini/minigame/plugins/GameInfoJsPlugin$b;", "", "", "notchBarHeight", "", "j", "Landroid/util/DisplayMetrics;", "a", "Landroid/util/DisplayMetrics;", "getDisplayMetrics", "()Landroid/util/DisplayMetrics;", "displayMetrics", "", "b", "D", "()D", "density", "c", "I", "getDeviceStatusBarHeight", "()I", "deviceStatusBarHeight", "", "d", "Z", MiniChatConstants.MINI_APP_LANDSCAPE, "()Z", "setLandscape", "(Z)V", "e", h.F, "screenWidth", "f", "g", "screenHeight", "i", "statusBarHeight", "setSafeAreaTop", "(I)V", "safeAreaTop", "setSafeAreaLeft", "safeAreaLeft", "setSafeAreaRight", "safeAreaRight", "k", "setSafeAreaWidth", "safeAreaWidth", "l", "setSafeAreaHeight", "safeAreaHeight", "Landroid/app/Activity;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "isOrientationLandscape", "<init>", "(Landroid/app/Activity;Z)V", "lib_minigame_internalRelease"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes23.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final DisplayMetrics displayMetrics;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private final double density;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        private final int deviceStatusBarHeight;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private boolean isLandscape;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private final int screenWidth;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        private final int screenHeight;

        /* renamed from: g, reason: collision with root package name and from kotlin metadata */
        private final int statusBarHeight;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata */
        private int safeAreaTop;

        /* renamed from: i, reason: collision with root package name and from kotlin metadata */
        private int safeAreaLeft;

        /* renamed from: j, reason: collision with root package name and from kotlin metadata */
        private int safeAreaRight;

        /* renamed from: k, reason: collision with root package name and from kotlin metadata */
        private int safeAreaWidth;

        /* renamed from: l, reason: collision with root package name and from kotlin metadata */
        private int safeAreaHeight;

        /* renamed from: m, reason: collision with root package name and from kotlin metadata */
        private final Activity activity;

        public b(@NotNull Activity activity, boolean z16) {
            int coerceAtLeast;
            int coerceAtMost;
            int coerceAtMost2;
            int coerceAtLeast2;
            boolean z17;
            Intrinsics.checkParameterIsNotNull(activity, "activity");
            this.activity = activity;
            DisplayMetrics displayMetrics = DisplayUtil.getDisplayMetrics(activity);
            Intrinsics.checkExpressionValueIsNotNull(displayMetrics, "DisplayUtil.getDisplayMetrics(activity)");
            this.displayMetrics = displayMetrics;
            double d16 = displayMetrics.density;
            this.density = d16;
            int statusBarHeight = DisplayUtil.getStatusBarHeight(activity);
            this.deviceStatusBarHeight = statusBarHeight;
            this.isLandscape = z16;
            if (DeviceInfoUtil.isFoldDevice()) {
                if (!z16) {
                    Resources resources = activity.getResources();
                    Intrinsics.checkExpressionValueIsNotNull(resources, "activity.resources");
                    if (resources.getConfiguration().orientation != 2) {
                        z17 = false;
                        this.isLandscape = z17;
                    }
                }
                z17 = true;
                this.isLandscape = z17;
            }
            int i3 = (int) (displayMetrics.widthPixels / d16);
            int i16 = (int) (displayMetrics.heightPixels / d16);
            if (this.isLandscape) {
                coerceAtMost2 = RangesKt___RangesKt.coerceAtMost(i3, i16);
                this.screenHeight = coerceAtMost2;
                coerceAtLeast2 = RangesKt___RangesKt.coerceAtLeast(i3, i16);
                this.screenWidth = coerceAtLeast2;
            } else {
                coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(i3, i16);
                this.screenHeight = coerceAtLeast;
                coerceAtMost = RangesKt___RangesKt.coerceAtMost(i3, i16);
                this.screenWidth = coerceAtMost;
            }
            this.statusBarHeight = (int) (statusBarHeight / d16);
        }

        /* renamed from: a, reason: from getter */
        public final double getDensity() {
            return this.density;
        }

        /* renamed from: b, reason: from getter */
        public final int getSafeAreaHeight() {
            return this.safeAreaHeight;
        }

        /* renamed from: c, reason: from getter */
        public final int getSafeAreaLeft() {
            return this.safeAreaLeft;
        }

        /* renamed from: d, reason: from getter */
        public final int getSafeAreaRight() {
            return this.safeAreaRight;
        }

        /* renamed from: e, reason: from getter */
        public final int getSafeAreaTop() {
            return this.safeAreaTop;
        }

        /* renamed from: f, reason: from getter */
        public final int getSafeAreaWidth() {
            return this.safeAreaWidth;
        }

        /* renamed from: g, reason: from getter */
        public final int getScreenHeight() {
            return this.screenHeight;
        }

        /* renamed from: h, reason: from getter */
        public final int getScreenWidth() {
            return this.screenWidth;
        }

        /* renamed from: i, reason: from getter */
        public final int getStatusBarHeight() {
            return this.statusBarHeight;
        }

        public final void j(int notchBarHeight) {
            this.safeAreaRight = this.screenWidth;
            if (this.isLandscape) {
                this.safeAreaTop = 0;
                Object systemService = this.activity.getSystemService("window");
                if (systemService != null) {
                    Display defaultDisplay = ((WindowManager) systemService).getDefaultDisplay();
                    Intrinsics.checkExpressionValueIsNotNull(defaultDisplay, "windowManager.defaultDisplay");
                    if (defaultDisplay.getRotation() == 3) {
                        this.safeAreaLeft = 0;
                        this.safeAreaRight = this.screenWidth - notchBarHeight;
                    } else {
                        this.safeAreaLeft = notchBarHeight;
                    }
                } else {
                    throw new TypeCastException("null cannot be cast to non-null type android.view.WindowManager");
                }
            } else {
                this.safeAreaTop = notchBarHeight;
                this.safeAreaLeft = 0;
            }
            this.safeAreaWidth = this.safeAreaRight - this.safeAreaLeft;
            this.safeAreaHeight = this.screenHeight - this.safeAreaTop;
        }
    }

    private final AppDeviceInfo b() {
        AppDeviceInfo appDeviceInfo = f346602d;
        if (appDeviceInfo != null) {
            if (appDeviceInfo == null) {
                Intrinsics.throwNpe();
            }
            return appDeviceInfo;
        }
        synchronized (GameInfoJsPlugin.class) {
            if (f346602d == null) {
                f346602d = new AppDeviceInfo();
            }
            Unit unit = Unit.INSTANCE;
        }
        AppDeviceInfo appDeviceInfo2 = f346602d;
        if (appDeviceInfo2 == null) {
            Intrinsics.throwNpe();
        }
        return appDeviceInfo2;
    }

    private final JSONObject c(b screenInfo) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("left", screenInfo.getSafeAreaLeft());
            jSONObject.put("top", screenInfo.getSafeAreaTop());
            jSONObject.put("right", screenInfo.getSafeAreaRight());
            jSONObject.put("bottom", screenInfo.getScreenHeight());
            jSONObject.put("width", screenInfo.getSafeAreaWidth());
            jSONObject.put("height", screenInfo.getSafeAreaHeight());
        } catch (JSONException e16) {
            QMLog.e("GameInfoJsPlugin", "getJsonSafeArea failed.", e16);
        }
        return jSONObject;
    }

    private final boolean d() {
        MiniAppInfo miniAppInfo = this.mMiniAppInfo;
        if (miniAppInfo != null && miniAppInfo.verType == 3) {
            return false;
        }
        return DebugUtil.getDebugEnabled(miniAppInfo);
    }

    private final int getSafeAreaTop(Activity activity, double density, int statusBarHeight) {
        int b16 = (int) (PreloadSystemInfoHelper.b(activity) / density);
        if (b16 == 0 && !TextUtils.isEmpty(this.mApkgInfo.mConfigStr)) {
            try {
                if (new JSONObject(this.mApkgInfo.mConfigStr).optBoolean("showStatusBar", false)) {
                    return statusBarHeight;
                }
            } catch (JSONException e16) {
                QMLog.e("GameInfoJsPlugin", "safeAreaTop JSONException:", e16);
            }
        }
        return b16;
    }

    @JsEvent({"getAppBaseInfo"})
    @NotNull
    public final String getAppBaseInfo(@NotNull RequestEvent req) {
        String str;
        Object obj;
        Object obj2;
        Intrinsics.checkParameterIsNotNull(req, "req");
        try {
            AppDeviceInfo b16 = b();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("SDKVersion", "1.74.3.00001");
            jSONObject.put("enableDebug", d());
            MiniAppProxy miniAppProxy = (MiniAppProxy) ProxyManager.get(MiniAppProxy.class);
            JSONObject jSONObject2 = new JSONObject();
            if (!QUAUtil.isQQMainApp()) {
                Intrinsics.checkExpressionValueIsNotNull(miniAppProxy, "miniAppProxy");
                jSONObject2.put("appId", miniAppProxy.getPlatformId());
            }
            Intrinsics.checkExpressionValueIsNotNull(miniAppProxy, "miniAppProxy");
            jSONObject2.put(MosaicConstants$JsProperty.PROP_ENV, miniAppProxy.getAppName());
            jSONObject2.put("version", b16.i());
            jSONObject.put("host", jSONObject2);
            jSONObject.put(IjkMediaMeta.IJKM_KEY_LANGUAGE, "zh_CN");
            jSONObject.put("version", miniAppProxy.getAppVersion());
            jSONObject.put("AppPlatform", "qq");
            AppThemeInfo appThemeInfo = miniAppProxy.getAppThemeInfo();
            if (appThemeInfo != null && appThemeInfo.isNightTheme()) {
                str = MiniAppConst.MENU_STYLE_DARK;
            } else {
                str = MiniAppConst.MENU_STYLE_LIGHT;
            }
            jSONObject.put("theme", str);
            if (appThemeInfo != null) {
                obj = Float.valueOf(appThemeInfo.getFontScale());
            } else {
                obj = 1;
            }
            jSONObject.put("fontSizeScaleFactor", obj);
            if (appThemeInfo != null) {
                obj2 = Float.valueOf(appThemeInfo.getFontSize());
            } else {
                obj2 = 16;
            }
            jSONObject.put("fontSizeSetting", obj2);
            jSONObject.put("mode", "default");
            jSONObject.put("translateLanguage", "language_default");
            if (QMLog.isColorLevel()) {
                QMLog.d("GameInfoJsPlugin", "getAppBaseInfo:" + jSONObject);
            }
            String jSONObject3 = jSONObject.toString();
            Intrinsics.checkExpressionValueIsNotNull(jSONObject3, "result.toString()");
            return jSONObject3;
        } catch (Exception e16) {
            QMLog.e("GameInfoJsPlugin", "getAppBaseInfo: failed, e=", e16);
            String fail = req.fail();
            Intrinsics.checkExpressionValueIsNotNull(fail, "req.fail()");
            return fail;
        }
    }

    @JsEvent({"getDeviceInfo"})
    @NotNull
    public final String getDeviceInfo(@NotNull RequestEvent req) {
        Intrinsics.checkParameterIsNotNull(req, "req");
        try {
            AppDeviceInfo b16 = b();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("abi", b16.a());
            jSONObject.put("deviceAbi", b16.a());
            jSONObject.put("benchmarkLevel", b16.getBenchmarkLevel());
            jSONObject.put("brand", b16.getBrand());
            jSONObject.put("model", b16.getModel());
            jSONObject.put(TVKPlayerMsg.PLAYER_CHOICE_SYSTEM, b16.getSystem());
            jSONObject.put("platform", b16.getPlatform());
            jSONObject.put("cpuType", b16.getCpuType());
            jSONObject.put("memorySize", String.valueOf(b16.e()));
            if (QMLog.isColorLevel()) {
                QMLog.d("GameInfoJsPlugin", "getDeviceInfo:" + jSONObject);
            }
            String jSONObject2 = jSONObject.toString();
            Intrinsics.checkExpressionValueIsNotNull(jSONObject2, "result.toString()");
            return jSONObject2;
        } catch (Exception e16) {
            QMLog.e("GameInfoJsPlugin", "getDeviceInfo: failed, e=", e16);
            String fail = req.fail();
            Intrinsics.checkExpressionValueIsNotNull(fail, "req.fail()");
            return fail;
        }
    }

    @JsEvent({"getWindowInfo"})
    @NotNull
    public final String getWindowInfo(@NotNull RequestEvent req) {
        Intrinsics.checkParameterIsNotNull(req, "req");
        IMiniAppContext mMiniAppContext = this.mMiniAppContext;
        Intrinsics.checkExpressionValueIsNotNull(mMiniAppContext, "mMiniAppContext");
        Activity attachActivity = mMiniAppContext.getAttachActivity();
        if (mMiniAppContext != null && attachActivity != null) {
            try {
                b bVar = new b(attachActivity, mMiniAppContext.isOrientationLandscape());
                bVar.j(getSafeAreaTop(attachActivity, bVar.getDensity(), bVar.getStatusBarHeight()));
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("pixelRatio", bVar.getDensity());
                jSONObject.put("screenWidth", bVar.getScreenWidth());
                jSONObject.put("screenHeight", bVar.getScreenHeight());
                jSONObject.put("windowWidth", bVar.getScreenWidth());
                jSONObject.put("windowHeight", bVar.getScreenHeight());
                jSONObject.put("statusBarHeight", bVar.getStatusBarHeight());
                jSONObject.put("safeArea", c(bVar));
                jSONObject.put("screenTop", 0);
                if (QMLog.isColorLevel()) {
                    QMLog.d("GameInfoJsPlugin", "getWindowInfo:" + jSONObject);
                }
                String jSONObject2 = jSONObject.toString();
                Intrinsics.checkExpressionValueIsNotNull(jSONObject2, "result.toString()");
                return jSONObject2;
            } catch (Exception e16) {
                QMLog.e("GameInfoJsPlugin", "getWindowInfo: failed, e=", e16);
                String fail = req.fail();
                Intrinsics.checkExpressionValueIsNotNull(fail, "req.fail()");
                return fail;
            }
        }
        QMLog.e("GameInfoJsPlugin", "getSystemInfo error,context is NULL");
        String fail2 = req.fail();
        Intrinsics.checkExpressionValueIsNotNull(fail2, "req.fail()");
        return fail2;
    }
}
