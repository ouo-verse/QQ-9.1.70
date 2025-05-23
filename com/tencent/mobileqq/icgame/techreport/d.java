package com.tencent.mobileqq.icgame.techreport;

import android.content.Context;
import android.os.Build;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.common.config.AppSetting;
import com.tencent.icgame.common.api.IAegisLogApi;
import com.tencent.mobileqq.icgame.api.impl.room.report.AudienceReportConst;
import com.tencent.mobileqq.mqq.api.IAccountRuntime;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.thumbplayer.core.downloadproxy.api.TPDownloadProxyEnum;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\"\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00000\u0002\u001a\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006\u001a\u001c\u0010\u000b\u001a\u00020\u00042\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00000\tH\u0002\u001a\b\u0010\f\u001a\u00020\u0004H\u0002\u001a\b\u0010\r\u001a\u00020\u0004H\u0002\u001a\b\u0010\u000e\u001a\u00020\u0004H\u0002\u001a\b\u0010\u000f\u001a\u00020\u0000H\u0002\u001a\u0010\u0010\u0012\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u0010H\u0002\"\u0016\u0010\u0015\u001a\u00020\u00008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014\"\u0016\u0010\u0018\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0017\"\u0014\u0010\u001b\u001a\u00020\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u001a\"0\u0010\u001f\u001a\u001e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00000\u001cj\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u0000`\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\u001e\u00a8\u0006 "}, d2 = {"", "eventId", "", "businessParams", "", "g", "Lcom/tencent/mobileqq/icgame/techreport/f;", "builder", "f", "", "params", "e", "d", "i", h.F, "c", "Landroid/content/Context;", "context", "b", "a", "Ljava/lang/String;", DKEngine.GlobalKey.NET_WORK_TYPE, "Ljava/util/concurrent/atomic/AtomicBoolean;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "networkListenerRegistered", "Lcom/tencent/icgame/common/api/IAegisLogApi;", "Lcom/tencent/icgame/common/api/IAegisLogApi;", "aegisLogger", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "Ljava/util/HashMap;", "baseParams", "ic-game-common-api_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private static String f237808a;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private static AtomicBoolean f237809b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    private static final IAegisLogApi f237810c;

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    private static final HashMap<String, String> f237811d;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\t\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\n\u001a\u00020\u0004H\u0016J\b\u0010\u000b\u001a\u00020\u0004H\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/icgame/techreport/d$a", "Lcom/tencent/mobileqq/msf/sdk/handler/INetInfoHandler;", "", "apn", "", "onNetNone2Mobile", "onNetWifi2Mobile", TPDownloadProxyEnum.USER_SSID, "onNetNone2Wifi", "onNetMobile2Wifi", "onNetMobile2None", "onNetWifi2None", "ic-game-common-api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes15.dex */
    public static final class a implements INetInfoHandler {
        a() {
        }

        @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
        public void onNetMobile2None() {
            d.i();
        }

        @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
        public void onNetMobile2Wifi(@Nullable String ssid) {
            d.i();
        }

        @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
        public void onNetNone2Mobile(@Nullable String apn) {
            d.i();
        }

        @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
        public void onNetNone2Wifi(@Nullable String ssid) {
            d.i();
        }

        @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
        public void onNetWifi2Mobile(@Nullable String apn) {
            d.i();
        }

        @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
        public void onNetWifi2None() {
            d.i();
        }
    }

    static {
        String b16 = e.b(BaseApplication.getContext());
        Intrinsics.checkNotNullExpressionValue(b16, "getNewNetworkType(MobileQQ.getContext())");
        f237808a = b16;
        f237809b = new AtomicBoolean(false);
        QRouteApi api = QRoute.api(IAegisLogApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IAegisLogApi::class.java)");
        f237810c = (IAegisLogApi) api;
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put(AudienceReportConst.CLIENT_TYPE, "401");
        hashMap.put(AudienceReportConst.TERMINAL_TYPE, "Android");
        String BRAND = Build.BRAND;
        Intrinsics.checkNotNullExpressionValue(BRAND, "BRAND");
        hashMap.put(AudienceReportConst.TERMINAL_BRAND, BRAND);
        String MODEL = DeviceInfoMonitor.getModel();
        Intrinsics.checkNotNullExpressionValue(MODEL, "MODEL");
        hashMap.put(AudienceReportConst.TERMINAL_MODEL, MODEL);
        hashMap.put("os_version", String.valueOf(Build.VERSION.SDK_INT));
        BaseApplication context = BaseApplication.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext()");
        hashMap.put("app_version_code", b(context));
        hashMap.put("app_version_name", c());
        String packageName = BaseApplication.getContext().getPackageName();
        Intrinsics.checkNotNullExpressionValue(packageName, "getContext().packageName");
        hashMap.put("bundle", packageName);
        hashMap.put("network_type", f237808a);
        String account = ((IAccountRuntime) QRoute.api(IAccountRuntime.class)).getAccount();
        Intrinsics.checkNotNullExpressionValue(account, "api(IAccountRuntime::class.java).account");
        hashMap.put(AudienceReportConst.USER_QQ, account);
        f237811d = hashMap;
    }

    private static final String b(Context context) {
        try {
            int i3 = InstalledAppListMonitor.getPackageInfo(context.getPackageManager(), context.getPackageName(), 16384).versionCode;
            StringBuilder sb5 = new StringBuilder();
            sb5.append(i3);
            return sb5.toString();
        } catch (Exception e16) {
            f237810c.e("ICGameTechReporter", e16.getLocalizedMessage(), e16);
            return "unknown";
        }
    }

    private static final String c() {
        String subVersion = AppSetting.f99551k;
        Intrinsics.checkNotNullExpressionValue(subVersion, "subVersion");
        return subVersion;
    }

    private static final void d() {
        if (!f237809b.compareAndSet(false, true)) {
            return;
        }
        AppNetConnInfo.registerConnectionChangeReceiver(BaseApplication.getContext(), new a());
    }

    private static final void e(Map<String, String> map) {
        String joinToString$default;
        map.putAll(f237811d);
        map.put("event_time", String.valueOf(System.currentTimeMillis()));
        String remove = map.remove("attaid");
        if (remove == null) {
            remove = "07900074928";
        }
        String remove2 = map.remove("token");
        if (remove2 == null) {
            remove2 = "8953433378";
        }
        if (rt0.a.INSTANCE.l()) {
            IAegisLogApi iAegisLogApi = f237810c;
            joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(map.entrySet(), null, null, null, 0, null, null, 63, null);
            iAegisLogApi.i("ICGameTechReporter", "report to atta: attaId=" + remove + "," + joinToString$default);
        }
        c.e(remove, remove2, map);
    }

    public static final void f(@NotNull f builder) {
        Intrinsics.checkNotNullParameter(builder, "builder");
        d();
        e(builder.a());
    }

    public static final void g(@NotNull String eventId, @NotNull Map<String, String> businessParams) {
        Map mutableMap;
        Intrinsics.checkNotNullParameter(eventId, "eventId");
        Intrinsics.checkNotNullParameter(businessParams, "businessParams");
        d();
        mutableMap = MapsKt__MapsKt.toMutableMap(businessParams);
        mutableMap.put("event_id", eventId);
        e(mutableMap);
    }

    private static final void h() {
        f237811d.put("network_type", f237808a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i() {
        String newNetworkType = e.b(BaseApplication.getContext());
        f237810c.i("ICGameTechReporter", "update network type from:" + f237808a + " to " + newNetworkType);
        Intrinsics.checkNotNullExpressionValue(newNetworkType, "newNetworkType");
        f237808a = newNetworkType;
        h();
    }
}
