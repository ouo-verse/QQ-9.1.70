package com.tencent.mobileqq.onlinestatus.utils;

import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.activity.api.IUnitedConfig;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqfeatureswitch.IFeatureRuntimeService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.utils.abtest.ABTestController;
import com.tencent.mobileqq.utils.abtest.ExpEntityInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.ntrelation.api.IFriendsTABService;
import cooperation.qzone.remote.logic.RemoteHandleConst;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import oicq.wlogin_sdk.tools.util;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b(\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\bB\u0010>J\b\u0010\u0003\u001a\u00020\u0002H\u0007J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007J\u0018\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0002H\u0007J\b\u0010\t\u001a\u00020\u0002H\u0007J\b\u0010\n\u001a\u00020\u0002H\u0007J\b\u0010\u000b\u001a\u00020\u0002H\u0007J\b\u0010\f\u001a\u00020\u0002H\u0007J\b\u0010\r\u001a\u00020\u0002H\u0007J\b\u0010\u000e\u001a\u00020\u0002H\u0007J\b\u0010\u000f\u001a\u00020\u0002H\u0007J\b\u0010\u0010\u001a\u00020\u0002H\u0007J\b\u0010\u0011\u001a\u00020\u0002H\u0007J\b\u0010\u0013\u001a\u00020\u0012H\u0002J\b\u0010\u0014\u001a\u00020\u0002H\u0007J\b\u0010\u0015\u001a\u00020\u0002H\u0007J\b\u0010\u0016\u001a\u00020\u0002H\u0007J\b\u0010\u0017\u001a\u00020\u0002H\u0007R \u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00020\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0019R \u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u001b0\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u0019R#\u0010\"\u001a\n \u001e*\u0004\u0018\u00010\u00020\u00028BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000b\u0010\u001f\u001a\u0004\b \u0010!R#\u0010$\u001a\n \u001e*\u0004\u0018\u00010\u00020\u00028BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\t\u0010\u001f\u001a\u0004\b#\u0010!R#\u0010'\u001a\n \u001e*\u0004\u0018\u00010\u00020\u00028BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b%\u0010\u001f\u001a\u0004\b&\u0010!R#\u0010(\u001a\n \u001e*\u0004\u0018\u00010\u00020\u00028BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\f\u0010\u001f\u001a\u0004\b\u001c\u0010!R#\u0010)\u001a\n \u001e*\u0004\u0018\u00010\u00020\u00028BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0013\u0010\u001f\u001a\u0004\b%\u0010!R#\u0010,\u001a\n \u001e*\u0004\u0018\u00010\u00020\u00028BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b*\u0010\u001f\u001a\u0004\b+\u0010!R#\u0010/\u001a\n \u001e*\u0004\u0018\u00010\u00020\u00028BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b-\u0010\u001f\u001a\u0004\b.\u0010!R#\u00102\u001a\n \u001e*\u0004\u0018\u00010\u00020\u00028BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b0\u0010\u001f\u001a\u0004\b1\u0010!R#\u00104\u001a\n \u001e*\u0004\u0018\u00010\u00020\u00028BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b \u0010\u001f\u001a\u0004\b3\u0010!R#\u00105\u001a\n \u001e*\u0004\u0018\u00010\u00020\u00028BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b.\u0010\u001f\u001a\u0004\b-\u0010!R#\u00107\u001a\n \u001e*\u0004\u0018\u00010\u00020\u00028BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000e\u0010\u001f\u001a\u0004\b6\u0010!R#\u00109\u001a\n \u001e*\u0004\u0018\u00010\u00020\u00028BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b+\u0010\u001f\u001a\u0004\b8\u0010!R\u001b\u0010<\u001a\u00020\u00028BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\r\u0010\u001f\u001a\u0004\b:\u0010;R!\u0010?\u001a\u00020\u00028FX\u0087\u0084\u0002\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u001f\u0012\u0004\b=\u0010>\u001a\u0004\b*\u0010;R!\u0010A\u001a\u00020\u00028FX\u0087\u0084\u0002\u00a2\u0006\u0012\n\u0004\b:\u0010\u001f\u0012\u0004\b@\u0010>\u001a\u0004\b0\u0010;\u00a8\u0006C"}, d2 = {"Lcom/tencent/mobileqq/onlinestatus/utils/OnlineStatusToggleUtils;", "", "", "B", "", "toggleName", "D", RemoteHandleConst.PARAM_DEFAULT_VALUE, "E", "e", "y", "d", "g", "p", DomainData.DOMAIN_NAME, ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "w", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Lcom/tencent/mobileqq/utils/abtest/ExpEntityInfo;", tl.h.F, BdhLogUtil.LogTag.Tag_Conn, "t", "b", UserInfo.SEX_FEMALE, "", "Ljava/util/Map;", "sToggleMap", "Lorg/json/JSONObject;", "c", "sToggleJsonMap", "kotlin.jvm.PlatformType", "Lkotlin/Lazy;", "l", "()Ljava/lang/Boolean;", "mWeatherSwitch", ReportConstant.COSTREPORT_PREFIX, "openPanelSwitch", "f", HippyTKDListViewAdapter.X, "setNullSwitch", "biaotaiChangeSwitch", "clearStatusCallback", "i", "o", "onlineStatusBlurBgSwitch", "j", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "onlineStatusAggregationChangeSwitch", "k", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "stepStatusSwitch", "v", "requestGetPermission", "fixLeakMemorySwitch", "u", "qqProfileCardOnlineStatusSwitch", "a", "accountPanelRefreshLyricsEventSwitch", "r", "()Z", "onlineStatusNTData", "getEnableFilterOfflineTofu$annotations", "()V", "enableFilterOfflineTofu", "getFixOnAccountChangedSlow$annotations", "fixOnAccountChangedSlow", "<init>", "qqonlinestatus-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class OnlineStatusToggleUtils {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final OnlineStatusToggleUtils f256314a = new OnlineStatusToggleUtils();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Map<String, Boolean> sToggleMap = new LinkedHashMap();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Map<String, JSONObject> sToggleJsonMap = new LinkedHashMap();

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy mWeatherSwitch;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy openPanelSwitch;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy setNullSwitch;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy biaotaiChangeSwitch;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy clearStatusCallback;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy onlineStatusBlurBgSwitch;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy onlineStatusAggregationChangeSwitch;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy stepStatusSwitch;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy requestGetPermission;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy fixLeakMemorySwitch;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy qqProfileCardOnlineStatusSwitch;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy accountPanelRefreshLyricsEventSwitch;

    /* renamed from: p, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy onlineStatusNTData;

    /* renamed from: q, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy enableFilterOfflineTofu;

    /* renamed from: r, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy fixOnAccountChangedSlow;

    static {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        Lazy lazy4;
        Lazy lazy5;
        Lazy lazy6;
        Lazy lazy7;
        Lazy lazy8;
        Lazy lazy9;
        Lazy lazy10;
        Lazy lazy11;
        Lazy lazy12;
        Lazy lazy13;
        Lazy lazy14;
        Lazy lazy15;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Boolean>() { // from class: com.tencent.mobileqq.onlinestatus.utils.OnlineStatusToggleUtils$mWeatherSwitch$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                return ((IUnitedConfig) QRoute.api(IUnitedConfig.class)).isSwitchOn("online_status_weaher_8983_886508329", Boolean.TRUE);
            }
        });
        mWeatherSwitch = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<Boolean>() { // from class: com.tencent.mobileqq.onlinestatus.utils.OnlineStatusToggleUtils$openPanelSwitch$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                return ((IUnitedConfig) QRoute.api(IUnitedConfig.class)).isSwitchOn("101091", Boolean.TRUE);
            }
        });
        openPanelSwitch = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<Boolean>() { // from class: com.tencent.mobileqq.onlinestatus.utils.OnlineStatusToggleUtils$setNullSwitch$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                return ((IUnitedConfig) QRoute.api(IUnitedConfig.class)).isSwitchOn("online_status_set_null_875_113996447", Boolean.TRUE);
            }
        });
        setNullSwitch = lazy3;
        lazy4 = LazyKt__LazyJVMKt.lazy(new Function0<Boolean>() { // from class: com.tencent.mobileqq.onlinestatus.utils.OnlineStatusToggleUtils$biaotaiChangeSwitch$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                return ((IUnitedConfig) QRoute.api(IUnitedConfig.class)).isSwitchOn("online_status_biaotai_change_8983_886140023", Boolean.TRUE);
            }
        });
        biaotaiChangeSwitch = lazy4;
        lazy5 = LazyKt__LazyJVMKt.lazy(new Function0<Boolean>() { // from class: com.tencent.mobileqq.onlinestatus.utils.OnlineStatusToggleUtils$clearStatusCallback$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                return ((IUnitedConfig) QRoute.api(IUnitedConfig.class)).isSwitchOn("online_set_callback_8983_115212279", Boolean.TRUE);
            }
        });
        clearStatusCallback = lazy5;
        lazy6 = LazyKt__LazyJVMKt.lazy(new Function0<Boolean>() { // from class: com.tencent.mobileqq.onlinestatus.utils.OnlineStatusToggleUtils$onlineStatusBlurBgSwitch$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                return ((IUnitedConfig) QRoute.api(IUnitedConfig.class)).isSwitchOn("online_status_blurbg_8983_887462369", Boolean.TRUE);
            }
        });
        onlineStatusBlurBgSwitch = lazy6;
        lazy7 = LazyKt__LazyJVMKt.lazy(new Function0<Boolean>() { // from class: com.tencent.mobileqq.onlinestatus.utils.OnlineStatusToggleUtils$onlineStatusAggregationChangeSwitch$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                return ((IUnitedConfig) QRoute.api(IUnitedConfig.class)).isSwitchOn("OS_Aggregation_8988_887563005", Boolean.TRUE);
            }
        });
        onlineStatusAggregationChangeSwitch = lazy7;
        lazy8 = LazyKt__LazyJVMKt.lazy(new Function0<Boolean>() { // from class: com.tencent.mobileqq.onlinestatus.utils.OnlineStatusToggleUtils$stepStatusSwitch$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                return ((IUnitedConfig) QRoute.api(IUnitedConfig.class)).isSwitchOn("online_status_sport_8988", Boolean.TRUE);
            }
        });
        stepStatusSwitch = lazy8;
        lazy9 = LazyKt__LazyJVMKt.lazy(new Function0<Boolean>() { // from class: com.tencent.mobileqq.onlinestatus.utils.OnlineStatusToggleUtils$requestGetPermission$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                return ((IUnitedConfig) QRoute.api(IUnitedConfig.class)).isSwitchOn("OS_Permission_8990_115376969", Boolean.TRUE);
            }
        });
        requestGetPermission = lazy9;
        lazy10 = LazyKt__LazyJVMKt.lazy(new Function0<Boolean>() { // from class: com.tencent.mobileqq.onlinestatus.utils.OnlineStatusToggleUtils$fixLeakMemorySwitch$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                return ((IUnitedConfig) QRoute.api(IUnitedConfig.class)).isSwitchOn("OS_account_leak_8996_117857041", Boolean.TRUE);
            }
        });
        fixLeakMemorySwitch = lazy10;
        lazy11 = LazyKt__LazyJVMKt.lazy(new Function0<Boolean>() { // from class: com.tencent.mobileqq.onlinestatus.utils.OnlineStatusToggleUtils$qqProfileCardOnlineStatusSwitch$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                return ((IUnitedConfig) QRoute.api(IUnitedConfig.class)).isSwitchOn("OS_profile_card_icon_9030", Boolean.TRUE);
            }
        });
        qqProfileCardOnlineStatusSwitch = lazy11;
        lazy12 = LazyKt__LazyJVMKt.lazy(new Function0<Boolean>() { // from class: com.tencent.mobileqq.onlinestatus.utils.OnlineStatusToggleUtils$accountPanelRefreshLyricsEventSwitch$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                return ((IUnitedConfig) QRoute.api(IUnitedConfig.class)).isSwitchOn("online_panel_lyrics_refresh", Boolean.TRUE);
            }
        });
        accountPanelRefreshLyricsEventSwitch = lazy12;
        lazy13 = LazyKt__LazyJVMKt.lazy(new Function0<Boolean>() { // from class: com.tencent.mobileqq.onlinestatus.utils.OnlineStatusToggleUtils$onlineStatusNTData$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Boolean invoke() {
                boolean z16 = false;
                if (((IFriendsTABService) QRoute.api(IFriendsTABService.class)).isNtDataService() && !((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("online_status_nt_data_revert", false)) {
                    z16 = true;
                }
                Boolean valueOf = Boolean.valueOf(z16);
                QLog.d("OnlineStatusToggleUtils", 1, "onlineStatusNTData: " + valueOf.booleanValue());
                return valueOf;
            }
        });
        onlineStatusNTData = lazy13;
        lazy14 = LazyKt__LazyJVMKt.lazy(new Function0<Boolean>() { // from class: com.tencent.mobileqq.onlinestatus.utils.OnlineStatusToggleUtils$enableFilterOfflineTofu$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Boolean invoke() {
                return Boolean.valueOf(((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("online_status_filter_offline_tofu", true));
            }
        });
        enableFilterOfflineTofu = lazy14;
        lazy15 = LazyKt__LazyJVMKt.lazy(new Function0<Boolean>() { // from class: com.tencent.mobileqq.onlinestatus.utils.OnlineStatusToggleUtils$fixOnAccountChangedSlow$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Boolean invoke() {
                return Boolean.valueOf(((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("online_status_fix_account_changed_slow", true));
            }
        });
        fixOnAccountChangedSlow = lazy15;
    }

    OnlineStatusToggleUtils() {
    }

    @JvmStatic
    public static final boolean A() {
        Boolean stepStatusSwitch2 = f256314a.z();
        Intrinsics.checkNotNullExpressionValue(stepStatusSwitch2, "stepStatusSwitch");
        return stepStatusSwitch2.booleanValue();
    }

    @JvmStatic
    public static final boolean B() {
        Boolean mWeatherSwitch2 = f256314a.l();
        Intrinsics.checkNotNullExpressionValue(mWeatherSwitch2, "mWeatherSwitch");
        return mWeatherSwitch2.booleanValue();
    }

    @JvmStatic
    public static final boolean C() {
        return f256314a.h().isExperiment();
    }

    @JvmStatic
    public static final boolean D(@NotNull String toggleName) {
        Intrinsics.checkNotNullParameter(toggleName, "toggleName");
        return E(toggleName, true);
    }

    @JvmStatic
    public static final boolean E(@NotNull String toggleName, boolean defaultValue) {
        Intrinsics.checkNotNullParameter(toggleName, "toggleName");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return defaultValue;
        }
        String str = toggleName + util.base64_pad_url + peekAppRuntime.getCurrentUin();
        Map<String, Boolean> map = sToggleMap;
        Boolean bool = map.get(str);
        if (bool != null) {
            return bool.booleanValue();
        }
        IRuntimeService runtimeService = peekAppRuntime.getRuntimeService(IFeatureRuntimeService.class, "all");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "appRuntime.getRuntimeSer\u2026     ProcessConstant.ALL)");
        Boolean valueOf = Boolean.valueOf(((IFeatureRuntimeService) runtimeService).isFeatureSwitchEnable(toggleName, defaultValue));
        QLog.d("OnlineStatusToggleUtils", 1, "isToggleEnable name: " + toggleName + " key: " + str + " value: " + valueOf + " defaultValue: " + defaultValue);
        map.put(str, valueOf);
        return valueOf.booleanValue();
    }

    @JvmStatic
    public static final boolean F() {
        return f256314a.r();
    }

    private final Boolean a() {
        return (Boolean) accountPanelRefreshLyricsEventSwitch.getValue();
    }

    @JvmStatic
    public static final boolean b() {
        Boolean accountPanelRefreshLyricsEventSwitch2 = f256314a.a();
        Intrinsics.checkNotNullExpressionValue(accountPanelRefreshLyricsEventSwitch2, "accountPanelRefreshLyricsEventSwitch");
        return accountPanelRefreshLyricsEventSwitch2.booleanValue();
    }

    private final Boolean c() {
        return (Boolean) biaotaiChangeSwitch.getValue();
    }

    @JvmStatic
    public static final boolean d() {
        Boolean biaotaiChangeSwitch2 = f256314a.c();
        Intrinsics.checkNotNullExpressionValue(biaotaiChangeSwitch2, "biaotaiChangeSwitch");
        return biaotaiChangeSwitch2.booleanValue();
    }

    @JvmStatic
    public static final boolean e() {
        Boolean s16 = f256314a.s();
        if (s16 == null) {
            return false;
        }
        return s16.booleanValue();
    }

    private final Boolean f() {
        return (Boolean) clearStatusCallback.getValue();
    }

    @JvmStatic
    public static final boolean g() {
        Boolean clearStatusCallback2 = f256314a.f();
        Intrinsics.checkNotNullExpressionValue(clearStatusCallback2, "clearStatusCallback");
        return clearStatusCallback2.booleanValue();
    }

    private final ExpEntityInfo h() {
        ExpEntityInfo expEntity = ABTestController.getInstance().getExpEntity("exp_qq_base_online_status_trans_v1");
        Intrinsics.checkNotNullExpressionValue(expEntity, "getInstance().getExpEnti\u2026E_ONLINE_STATUS_TRANS_V1)");
        expEntity.reportExpExposure();
        return expEntity;
    }

    public static final boolean i() {
        return ((Boolean) enableFilterOfflineTofu.getValue()).booleanValue();
    }

    private final Boolean j() {
        return (Boolean) fixLeakMemorySwitch.getValue();
    }

    public static final boolean k() {
        return ((Boolean) fixOnAccountChangedSlow.getValue()).booleanValue();
    }

    private final Boolean l() {
        return (Boolean) mWeatherSwitch.getValue();
    }

    private final Boolean m() {
        return (Boolean) onlineStatusAggregationChangeSwitch.getValue();
    }

    @JvmStatic
    public static final boolean n() {
        Boolean onlineStatusAggregationChangeSwitch2 = f256314a.m();
        Intrinsics.checkNotNullExpressionValue(onlineStatusAggregationChangeSwitch2, "onlineStatusAggregationChangeSwitch");
        return onlineStatusAggregationChangeSwitch2.booleanValue();
    }

    private final Boolean o() {
        return (Boolean) onlineStatusBlurBgSwitch.getValue();
    }

    @JvmStatic
    public static final boolean p() {
        Boolean onlineStatusBlurBgSwitch2 = f256314a.o();
        Intrinsics.checkNotNullExpressionValue(onlineStatusBlurBgSwitch2, "onlineStatusBlurBgSwitch");
        return onlineStatusBlurBgSwitch2.booleanValue();
    }

    @JvmStatic
    public static final boolean q() {
        Boolean fixLeakMemorySwitch2 = f256314a.j();
        Intrinsics.checkNotNullExpressionValue(fixLeakMemorySwitch2, "fixLeakMemorySwitch");
        return fixLeakMemorySwitch2.booleanValue();
    }

    private final boolean r() {
        return ((Boolean) onlineStatusNTData.getValue()).booleanValue();
    }

    private final Boolean s() {
        return (Boolean) openPanelSwitch.getValue();
    }

    @JvmStatic
    public static final boolean t() {
        Boolean qqProfileCardOnlineStatusSwitch2 = f256314a.u();
        Intrinsics.checkNotNullExpressionValue(qqProfileCardOnlineStatusSwitch2, "qqProfileCardOnlineStatusSwitch");
        if (qqProfileCardOnlineStatusSwitch2.booleanValue() && C()) {
            return true;
        }
        return false;
    }

    private final Boolean u() {
        return (Boolean) qqProfileCardOnlineStatusSwitch.getValue();
    }

    private final Boolean v() {
        return (Boolean) requestGetPermission.getValue();
    }

    @JvmStatic
    public static final boolean w() {
        Boolean requestGetPermission2 = f256314a.v();
        Intrinsics.checkNotNullExpressionValue(requestGetPermission2, "requestGetPermission");
        return requestGetPermission2.booleanValue();
    }

    private final Boolean x() {
        return (Boolean) setNullSwitch.getValue();
    }

    @JvmStatic
    public static final boolean y() {
        Boolean setNullSwitch2 = f256314a.x();
        Intrinsics.checkNotNullExpressionValue(setNullSwitch2, "setNullSwitch");
        return setNullSwitch2.booleanValue();
    }

    private final Boolean z() {
        return (Boolean) stepStatusSwitch.getValue();
    }
}
