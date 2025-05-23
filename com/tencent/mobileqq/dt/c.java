package com.tencent.mobileqq.dt;

import android.text.TextUtils;
import com.tencent.beacon.event.open.EventType;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.QQBeaconReport;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.common.EventAgingType;
import com.tencent.qqlive.module.videoreport.common.IReporter;
import com.tencent.qqlive.module.videoreport.common.ReportEvent;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTEventKey;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\t\b\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0002J\u001c\u0010\b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002H\u0002J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0002J\u0012\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/dt/c;", "Lcom/tencent/qqlive/module/videoreport/common/IReporter;", "", com.heytap.mcssdk.a.a.f36102l, "", "g", "eventKey", "f", "e", "Lcom/tencent/qqlive/module/videoreport/common/EventAgingType;", "agingType", "Lcom/tencent/beacon/event/open/EventType;", "c", "Lcom/tencent/qqlive/module/videoreport/common/ReportEvent;", "event", "", "report", "<init>", "()V", "a", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes5.dex */
public final class c implements IReporter {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    private static volatile c f203758b;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028FX\u0087\u0004\u00a2\u0006\f\u0012\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0003\u0010\u0004R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\f\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/dt/c$a;", "", "Lcom/tencent/mobileqq/dt/c;", "a", "()Lcom/tencent/mobileqq/dt/c;", "getInstance$annotations", "()V", WadlProxyConsts.LOAD_CONFIG_FROM_INSTANCE, "", "DT_REFRESH_TIME_STAMP_ID", "Ljava/lang/String;", "INSTANCT", "Lcom/tencent/mobileqq/dt/c;", "<init>", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.dt.c$a, reason: from kotlin metadata */
    /* loaded from: classes5.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return;
            }
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) defaultConstructorMarker);
        }

        @Nullable
        public final c a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (c) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            if (c.f203758b == null) {
                synchronized (c.class) {
                    if (c.f203758b == null) {
                        c.f203758b = new c(null);
                    }
                    Unit unit = Unit.INSTANCE;
                }
            }
            return c.f203758b;
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes5.dex */
    public /* synthetic */ class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f203759a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(54915);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 1)) {
                redirector.redirect((short) 1);
                return;
            }
            int[] iArr = new int[EventAgingType.values().length];
            try {
                iArr[EventAgingType.REALTIME.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[EventAgingType.IMMEDIATE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f203759a = iArr;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(54917);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public /* synthetic */ c(DefaultConstructorMarker defaultConstructorMarker) {
        this();
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
            return;
        }
        iPatchRedirector.redirect((short) 5, (Object) this, (Object) defaultConstructorMarker);
    }

    private final EventType c(EventAgingType agingType) {
        int i3 = b.f203759a[agingType.ordinal()];
        if (i3 != 1) {
            if (i3 != 2) {
                return EventType.NORMAL;
            }
            return EventType.IMMEDIATE_MSF;
        }
        return EventType.REALTIME;
    }

    @Nullable
    public static final c d() {
        return INSTANCE.a();
    }

    private final boolean e(String appKey, String eventKey) {
        if (g(appKey) && (TextUtils.equals(QCircleDaTongConstant.EventId.XSJ_FEED_IMPL, eventKey) || TextUtils.equals("dt_imp_end", eventKey) || TextUtils.equals("dt_imp", eventKey))) {
            return true;
        }
        return false;
    }

    private final boolean f(String eventKey) {
        if (!Intrinsics.areEqual("qqout", eventKey) && !Intrinsics.areEqual("qqin", eventKey) && !Intrinsics.areEqual(eventKey, "dt_pgin") && !Intrinsics.areEqual(eventKey, "dt_clck")) {
            return false;
        }
        return true;
    }

    private final boolean g(String appKey) {
        return Intrinsics.areEqual(appKey, "00000QG6YX3X0LZH");
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0137  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0141  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0156  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0145  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0139  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0103  */
    @Override // com.tencent.qqlive.module.videoreport.common.IReporter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void report(@Nullable ReportEvent event) {
        String str;
        boolean z16;
        Map<String, String> params;
        ConcurrentHashMap concurrentHashMap;
        String key;
        boolean areEqual;
        boolean z17;
        EventType eventType;
        int mapCapacity;
        boolean z18;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) event);
            return;
        }
        if (event != null && !TextUtils.isEmpty(event.getKey())) {
            int i3 = 2;
            if (event.isSampleHit() && event.isRemoteSampled()) {
                if (!TextUtils.isEmpty(event.getAppKey())) {
                    str = event.getAppKey();
                } else {
                    Map<String, String> params2 = event.getParams();
                    if (params2 != null) {
                        str = params2.get(DTParamKey.REPORT_KEY_APPKEY);
                    } else {
                        str = null;
                    }
                }
                if (TextUtils.isEmpty(str)) {
                    str = "0S200MNJT807V3GE";
                }
                EventAgingType type = event.getType();
                Intrinsics.checkNotNullExpressionValue(type, "event.type");
                EventType c16 = c(type);
                boolean z19 = false;
                if (!g(str)) {
                    String key2 = event.getKey();
                    Intrinsics.checkNotNullExpressionValue(key2, "event.key");
                    if (!f(key2)) {
                        z16 = false;
                        if (c16 != EventType.IMMEDIATE_MSF && z16) {
                            c16 = EventType.REALTIME;
                        }
                        params = event.getParams();
                        if (params == null) {
                            LinkedHashMap linkedHashMap = new LinkedHashMap();
                            for (Map.Entry<String, String> entry : params.entrySet()) {
                                if (entry.getKey() != null) {
                                    z18 = true;
                                } else {
                                    z18 = false;
                                }
                                if (z18) {
                                    linkedHashMap.put(entry.getKey(), entry.getValue());
                                }
                            }
                            mapCapacity = MapsKt__MapsJVMKt.mapCapacity(linkedHashMap.size());
                            LinkedHashMap linkedHashMap2 = new LinkedHashMap(mapCapacity);
                            for (Map.Entry entry2 : linkedHashMap.entrySet()) {
                                Object key3 = entry2.getKey();
                                String str2 = (String) entry2.getValue();
                                if (str2 == null) {
                                    str2 = "";
                                } else {
                                    Intrinsics.checkNotNullExpressionValue(str2, "it.value ?: \"\"");
                                }
                                linkedHashMap2.put(key3, str2);
                            }
                            concurrentHashMap = new ConcurrentHashMap(linkedHashMap2);
                        } else {
                            concurrentHashMap = new ConcurrentHashMap();
                        }
                        key = event.getKey();
                        if (Intrinsics.areEqual(DTEventKey.APP_IN, key) && ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("101071", true)) {
                            com.tencent.mobileqq.dt.b.l();
                        }
                        com.tencent.mobileqq.dt.b.k(key, concurrentHashMap);
                        areEqual = Intrinsics.areEqual(str, "00000QG6YX3X0LZH");
                        if (c16 != EventType.IMMEDIATE_MSF) {
                            z17 = true;
                        } else {
                            z17 = false;
                        }
                        if (areEqual && z17) {
                            z19 = true;
                        }
                        if (z19) {
                            QQBeaconReport.reportWithAppKey(str, key, concurrentHashMap, c16);
                        } else {
                            if (z16) {
                                eventType = EventType.REALTIME;
                            } else {
                                eventType = EventType.NORMAL;
                            }
                            QQBeaconReport.reportWithAppKey(str, key, concurrentHashMap, eventType);
                        }
                        if (!e(str, key)) {
                            i3 = 1;
                        }
                        QLog.d("QQDtReporter", i3, "848QQDT _report eventKey: " + key + ", appKey:" + str + ", type: " + c16 + ", isQCircle: " + areEqual + ", isMsfImme: " + z17 + ", params: " + params);
                        return;
                    }
                }
                z16 = true;
                if (c16 != EventType.IMMEDIATE_MSF) {
                    c16 = EventType.REALTIME;
                }
                params = event.getParams();
                if (params == null) {
                }
                key = event.getKey();
                if (Intrinsics.areEqual(DTEventKey.APP_IN, key)) {
                    com.tencent.mobileqq.dt.b.l();
                }
                com.tencent.mobileqq.dt.b.k(key, concurrentHashMap);
                areEqual = Intrinsics.areEqual(str, "00000QG6YX3X0LZH");
                if (c16 != EventType.IMMEDIATE_MSF) {
                }
                if (areEqual) {
                    z19 = true;
                }
                if (z19) {
                }
                if (!e(str, key)) {
                }
                QLog.d("QQDtReporter", i3, "848QQDT _report eventKey: " + key + ", appKey:" + str + ", type: " + c16 + ", isQCircle: " + areEqual + ", isMsfImme: " + z17 + ", params: " + params);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("QQDtReporter", 2, "dtReport has been sampled, event: " + event);
            }
        }
    }

    c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }
}
