package com.tencent.aegiskmm;

import com.tencent.aegiskmm.f;
import com.tencent.kuikly.core.module.NetworkModule;
import com.tencent.kuikly.core.module.NetworkResponse;
import com.tencent.kuikly.core.module.r;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.rmonitor.base.config.data.k;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import oicq.wlogin_sdk.tools.util;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0012\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\"\u001a\u00020\u0005\u0012\u0006\u0010$\u001a\u00020\u0005\u0012\u0006\u0010&\u001a\u00020\u0005\u0012\u0006\u0010(\u001a\u00020\u0005\u0012\u0006\u0010+\u001a\u00020\u000b\u00a2\u0006\u0004\b,\u0010-J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\n\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0002R$\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b8\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R$\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b8\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b\n\u0010\u000e\u001a\u0004\b\u0012\u0010\u0010R$\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b8\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b\u0012\u0010\u000e\u001a\u0004\b\u0014\u0010\u0010R$\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b8\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b\u0016\u0010\u000e\u001a\u0004\b\u0016\u0010\u0010R$\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b8\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b\u0018\u0010\u000e\u001a\u0004\b\u0018\u0010\u0010R$\u0010\u001b\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b8\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b\u000f\u0010\u000e\u001a\u0004\b\u001a\u0010\u0010R\u0016\u0010\u001e\u001a\u00020\u001c8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u001dR\u0017\u0010\"\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010\u001f\u001a\u0004\b \u0010!R\u0017\u0010$\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b\u001a\u0010\u001f\u001a\u0004\b#\u0010!R\u0017\u0010&\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u001f\u001a\u0004\b%\u0010!R\u0017\u0010(\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b\u0004\u0010\u001f\u001a\u0004\b'\u0010!R\u0017\u0010+\u001a\u00020\u000b8\u0006\u00a2\u0006\f\n\u0004\b)\u0010\u000e\u001a\u0004\b*\u0010\u0010\u00a8\u0006."}, d2 = {"Lcom/tencent/aegiskmm/RemoteConfigManager;", "", "", "j", "k", "", "key", h.F, "Lcom/tencent/kuikly/core/nvi/serialization/json/e;", "response", "b", "", "<set-?>", "a", "Z", "f", "()Z", "logSwitch", "c", "apiStaticSwitch", "g", "performanceSwitch", "d", "customEventSwitch", "e", "customSpeedTestSwitch", "i", "pvSwitch", "Lcom/tencent/aegiskmm/f$a;", "Lcom/tencent/aegiskmm/f$a;", "storageInterface", "Ljava/lang/String;", "getUin", "()Ljava/lang/String;", "uin", "getAppId", "appId", "getAppKey", com.heytap.mcssdk.a.a.f36102l, "getDId", "dId", "l", "getReportToTestServer", "reportToTestServer", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", "ShiplyCS-KuiklyAegis_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes37.dex */
public final class RemoteConfigManager {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private boolean logSwitch;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private boolean apiStaticSwitch;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private boolean performanceSwitch;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private boolean customEventSwitch;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean customSpeedTestSwitch;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean pvSwitch;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private f.a storageInterface;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final String uin;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final String appId;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private final String appKey;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private final String dId;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    private final boolean reportToTestServer;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002H\u0016J\u0019\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a2\u0006\u0004\b\t\u0010\nJ\u0018\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\bH\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/aegiskmm/RemoteConfigManager$a", "Lcom/tencent/aegiskmm/f$a;", "", "key", "getString", "value", "", "setString", "", "getInt", "(Ljava/lang/String;)Ljava/lang/Integer;", "setInt", "ShiplyCS-KuiklyAegis_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes37.dex */
    public static final class a implements f.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ r f61722a;

        a(r rVar) {
            this.f61722a = rVar;
        }

        @Override // com.tencent.aegiskmm.f.a
        public Integer getInt(String key) {
            Intrinsics.checkNotNullParameter(key, "key");
            return this.f61722a.getInt(key);
        }

        @Override // com.tencent.aegiskmm.f.a
        public String getString(String key) {
            Intrinsics.checkNotNullParameter(key, "key");
            return this.f61722a.getString(key);
        }

        @Override // com.tencent.aegiskmm.f.a
        public void setInt(String key, int value) {
            Intrinsics.checkNotNullParameter(key, "key");
            this.f61722a.setInt(key, Integer.valueOf(value));
        }

        @Override // com.tencent.aegiskmm.f.a
        public void setString(String key, String value) {
            Intrinsics.checkNotNullParameter(key, "key");
            Intrinsics.checkNotNullParameter(value, "value");
            this.f61722a.a(key, value);
        }
    }

    public RemoteConfigManager(String uin, String appId, String appKey, String dId, boolean z16) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(appId, "appId");
        Intrinsics.checkNotNullParameter(appKey, "appKey");
        Intrinsics.checkNotNullParameter(dId, "dId");
        this.uin = uin;
        this.appId = appId;
        this.appKey = appKey;
        this.dId = dId;
        this.reportToTestServer = z16;
        com.tencent.aegiskmm.a aVar = com.tencent.aegiskmm.a.f61726d;
        this.logSwitch = aVar.c();
        this.apiStaticSwitch = aVar.c();
        this.performanceSwitch = aVar.c();
        this.customEventSwitch = aVar.c();
        this.customSpeedTestSwitch = aVar.c();
        this.pvSwitch = aVar.c();
        try {
            this.storageInterface = new a((r) com.tencent.kuikly.core.manager.c.f117352a.g().acquireModule("KRSharedPreferencesModule"));
        } catch (Exception e16) {
            com.tencent.aegiskmm.a.f61726d.b().e("KA-RemoteCfgManager", "init err " + e16);
        }
        j();
        k();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void b(com.tencent.kuikly.core.nvi.serialization.json.e response) {
        long a16 = g.a().a();
        f.a aVar = this.storageInterface;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("storageInterface");
        }
        aVar.setString(h("last_request_ts"), String.valueOf(a16));
        int j3 = response.j("next_time_in_sec");
        f.a aVar2 = this.storageInterface;
        if (aVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("storageInterface");
        }
        aVar2.setInt(h("next_time_in_sec"), j3);
        int j16 = response.j("status");
        String q16 = response.q("md5code", "");
        f.a aVar3 = this.storageInterface;
        if (aVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("storageInterface");
        }
        aVar3.setString(h("md5code"), q16);
        if (j16 != 1000) {
            if (j16 != 1200) {
                return;
            }
            com.tencent.aegiskmm.a.f61726d.b().d("KA-RemoteCfgManager", "decodeNetResult NO_NEED_UPDATE_CONFIG");
            return;
        }
        com.tencent.kuikly.core.nvi.serialization.json.e m3 = response.m("data");
        com.tencent.kuikly.core.nvi.serialization.json.b l3 = m3 != null ? m3.l(k.FEATURES_KEY) : null;
        if (l3 != null) {
            com.tencent.kuikly.core.nvi.serialization.json.e eVar = new com.tencent.kuikly.core.nvi.serialization.json.e();
            int c16 = l3.c();
            for (int i3 = 0; i3 < c16; i3++) {
                com.tencent.kuikly.core.nvi.serialization.json.e l16 = l3.l(i3);
                String p16 = l16 != null ? l16.p("name") : null;
                boolean f16 = l16 != null ? l16.f(NodeProps.ENABLED) : false;
                if (p16 != null) {
                    switch (p16.hashCode()) {
                        case -1819991800:
                            if (p16.equals("rum_api_static")) {
                                this.apiStaticSwitch = f16;
                                break;
                            } else {
                                break;
                            }
                        case -1370685275:
                            if (p16.equals("rum_event")) {
                                this.customEventSwitch = f16;
                                break;
                            } else {
                                break;
                            }
                        case -919850021:
                            if (p16.equals("rum_pv")) {
                                this.pvSwitch = f16;
                                break;
                            } else {
                                break;
                            }
                        case 400670406:
                            if (p16.equals("rum_custom")) {
                                this.customSpeedTestSwitch = f16;
                                break;
                            } else {
                                break;
                            }
                        case 1317775867:
                            if (p16.equals("rum_performance")) {
                                this.performanceSwitch = f16;
                                break;
                            } else {
                                break;
                            }
                        case 1549416463:
                            if (p16.equals("rum_log")) {
                                this.logSwitch = f16;
                                break;
                            } else {
                                break;
                            }
                    }
                    eVar.w(p16, f16);
                }
            }
            f.a aVar4 = this.storageInterface;
            if (aVar4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("storageInterface");
            }
            aVar4.setString(h("rum_switches"), eVar.toString());
        }
        com.tencent.aegiskmm.a.f61726d.b().d("KA-RemoteCfgManager", "decodeNetResult logSwitch = " + this.logSwitch + ",apiStaticSwitch = " + this.apiStaticSwitch + ",performanceSwitch = " + this.performanceSwitch + ",customEventSwitch = " + this.customEventSwitch + ",customSpeedTestSwitch = " + this.customSpeedTestSwitch + ",pvSwitch = " + this.pvSwitch);
    }

    private final String h(String key) {
        return "shiply_bugly_" + this.uin + util.base64_pad_url + key;
    }

    private final void j() {
        f.a aVar = this.storageInterface;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("storageInterface");
        }
        try {
            com.tencent.kuikly.core.nvi.serialization.json.e eVar = new com.tencent.kuikly.core.nvi.serialization.json.e(aVar.getString(h("rum_switches")));
            this.logSwitch = eVar.g("rum_log", false);
            this.apiStaticSwitch = eVar.g("rum_api_static", false);
            this.performanceSwitch = eVar.g("rum_performance", false);
            this.customEventSwitch = eVar.g("rum_event", false);
            this.customSpeedTestSwitch = eVar.g("rum_custom", false);
            this.pvSwitch = eVar.g("rum_pv", false);
        } catch (Exception e16) {
            com.tencent.aegiskmm.a.f61726d.b().e("KA-RemoteCfgManager", "loadLocalConfig err " + e16);
        }
        com.tencent.aegiskmm.a.f61726d.b().d("KA-RemoteCfgManager", "loadLocalConfig logSwitch = " + this.logSwitch + ",apiStaticSwitch = " + this.apiStaticSwitch + ",performanceSwitch = " + this.performanceSwitch + ",customEventSwitch = " + this.customEventSwitch + ",customSpeedTestSwitch = " + this.customSpeedTestSwitch + ",pvSwitch = " + this.pvSwitch);
    }

    private final void k() {
        Long longOrNull;
        String str;
        f.a aVar = this.storageInterface;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("storageInterface");
        }
        Integer num = aVar.getInt(h("next_time_in_sec"));
        int intValue = num != null ? num.intValue() : 3600;
        f.a aVar2 = this.storageInterface;
        if (aVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("storageInterface");
        }
        longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull(aVar2.getString(h("last_request_ts")));
        long longValue = longOrNull != null ? longOrNull.longValue() : 0L;
        f.a aVar3 = this.storageInterface;
        if (aVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("storageInterface");
        }
        String string = aVar3.getString(h("md5code"));
        long a16 = g.a().a();
        com.tencent.aegiskmm.a aVar4 = com.tencent.aegiskmm.a.f61726d;
        com.tencent.aegiskmm.utils.a b16 = aVar4.b();
        StringBuilder sb5 = new StringBuilder();
        sb5.append("tryUpdateConfigFromNetwork nextTimeSpan = ");
        sb5.append(intValue);
        sb5.append(",md5Code = ");
        sb5.append(string);
        sb5.append(",(curTimeStamp - lastRequestTimeStamp) = ");
        long j3 = a16 - longValue;
        sb5.append(j3);
        b16.d("KA-RemoteCfgManager", sb5.toString());
        if (j3 < intValue * 1000) {
            aVar4.b().d("KA-RemoteCfgManager", "tryUpdateConfigFromNetwork return for time limit");
            return;
        }
        final com.tencent.kuikly.core.nvi.serialization.json.e eVar = new com.tencent.kuikly.core.nvi.serialization.json.e();
        eVar.v("uin", this.uin);
        eVar.v("pid", this.appId);
        eVar.v("app_key", this.appKey);
        eVar.v("deviceid", this.dId);
        eVar.v("md5code", string);
        if (this.reportToTestServer) {
            str = "https://t.rmonitor.qq.com/appconfig/vhippy/config/" + this.appId + '/';
        } else {
            str = "https://rmonitor.qq.com/appconfig/vhippy/config/" + this.appId + '/';
        }
        final String str2 = str;
        try {
            NetworkModule networkModule = (NetworkModule) com.tencent.kuikly.core.manager.c.f117352a.g().acquireModule("KRNetworkModule");
            com.tencent.kuikly.core.nvi.serialization.json.e eVar2 = new com.tencent.kuikly.core.nvi.serialization.json.e();
            eVar2.v("Content-Type", "application/json");
            Unit unit = Unit.INSTANCE;
            networkModule.d(str2, true, eVar, (r18 & 8) != 0 ? null : eVar2, (r18 & 16) != 0 ? null : "", (r18 & 32) != 0 ? 30 : 0, new Function4<com.tencent.kuikly.core.nvi.serialization.json.e, Boolean, String, NetworkResponse, Unit>() { // from class: com.tencent.aegiskmm.RemoteConfigManager$tryUpdateConfigFromNetwork$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(4);
                }

                @Override // kotlin.jvm.functions.Function4
                public /* bridge */ /* synthetic */ Unit invoke(com.tencent.kuikly.core.nvi.serialization.json.e eVar3, Boolean bool, String str3, NetworkResponse networkResponse) {
                    invoke(eVar3, bool.booleanValue(), str3, networkResponse);
                    return Unit.INSTANCE;
                }

                public final void invoke(com.tencent.kuikly.core.nvi.serialization.json.e data, boolean z16, String errorMsg, NetworkResponse response) {
                    Intrinsics.checkNotNullParameter(data, "data");
                    Intrinsics.checkNotNullParameter(errorMsg, "errorMsg");
                    Intrinsics.checkNotNullParameter(response, "response");
                    a aVar5 = a.f61726d;
                    aVar5.b().d("KA-RemoteCfgManager", "updateConfigFromNetwork finish! url:" + str2 + ",param:" + eVar + " success:" + z16 + ",data:" + data + ",error:" + errorMsg + ",code:" + response);
                    if (z16) {
                        RemoteConfigManager.this.b(data);
                        return;
                    }
                    aVar5.b().e("KA-RemoteCfgManager", "updateConfigFromNetwork \u8bf7\u6c42\u9519\u8bef:" + errorMsg);
                }
            });
        } catch (Error e16) {
            com.tencent.aegiskmm.a.f61726d.b().e("KA-RemoteCfgManager", "updateConfigFromNetwork \u8bf7\u6c42\u9519\u8bef\uff1a" + e16.getMessage());
        }
    }

    /* renamed from: c, reason: from getter */
    public final boolean getApiStaticSwitch() {
        return this.apiStaticSwitch;
    }

    /* renamed from: d, reason: from getter */
    public final boolean getCustomEventSwitch() {
        return this.customEventSwitch;
    }

    /* renamed from: e, reason: from getter */
    public final boolean getCustomSpeedTestSwitch() {
        return this.customSpeedTestSwitch;
    }

    /* renamed from: f, reason: from getter */
    public final boolean getLogSwitch() {
        return this.logSwitch;
    }

    /* renamed from: g, reason: from getter */
    public final boolean getPerformanceSwitch() {
        return this.performanceSwitch;
    }

    /* renamed from: i, reason: from getter */
    public final boolean getPvSwitch() {
        return this.pvSwitch;
    }
}
