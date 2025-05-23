package com.huawei.agconnect.config.impl;

import android.content.Context;
import com.huawei.agconnect.AGCRoutePolicy;
import com.huawei.agconnect.AGConnectOptions;
import com.huawei.agconnect.JsonProcessingFactory;
import com.huawei.agconnect.core.Service;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes2.dex */
public class b implements AGConnectOptions {

    /* renamed from: a, reason: collision with root package name */
    private final String f36476a;

    /* renamed from: b, reason: collision with root package name */
    private final Context f36477b;

    /* renamed from: c, reason: collision with root package name */
    private final String f36478c;

    /* renamed from: d, reason: collision with root package name */
    private final AGCRoutePolicy f36479d;

    /* renamed from: e, reason: collision with root package name */
    private final d f36480e;

    /* renamed from: f, reason: collision with root package name */
    private final e f36481f;

    /* renamed from: g, reason: collision with root package name */
    private final Map<String, String> f36482g;

    /* renamed from: h, reason: collision with root package name */
    private final List<Service> f36483h;

    /* renamed from: i, reason: collision with root package name */
    private final Map<String, String> f36484i = new HashMap();

    public b(Context context, String str, AGCRoutePolicy aGCRoutePolicy, InputStream inputStream, Map<String, String> map, List<Service> list, String str2) {
        context = context.getApplicationContext() != null ? context.getApplicationContext() : context;
        this.f36477b = context;
        str = str == null ? context.getPackageName() : str;
        this.f36478c = str;
        if (inputStream != null) {
            this.f36480e = new h(inputStream, str);
            Utils.closeQuietly(inputStream);
        } else {
            this.f36480e = new k(context, str);
        }
        this.f36481f = new e(this.f36480e);
        AGCRoutePolicy aGCRoutePolicy2 = AGCRoutePolicy.UNKNOWN;
        if (aGCRoutePolicy != aGCRoutePolicy2 && "1.0".equals(this.f36480e.a("/configuration_version", null))) {
            throw new RuntimeException("The file version does not match,please download the latest agconnect-services.json from the AGC website.");
        }
        this.f36479d = (aGCRoutePolicy == null || aGCRoutePolicy == aGCRoutePolicy2) ? Utils.getRoutePolicyFromJson(this.f36480e.a("/region", null), this.f36480e.a("/agcgw/url", null)) : aGCRoutePolicy;
        this.f36482g = Utils.fixKeyPathMap(map);
        this.f36483h = list;
        this.f36476a = str2 == null ? b() : str2;
    }

    private String a(String str) {
        Map<String, JsonProcessingFactory.JsonProcessor> processors = JsonProcessingFactory.getProcessors();
        if (!processors.containsKey(str)) {
            return null;
        }
        if (this.f36484i.containsKey(str)) {
            return this.f36484i.get(str);
        }
        JsonProcessingFactory.JsonProcessor jsonProcessor = processors.get(str);
        if (jsonProcessor == null) {
            return null;
        }
        String processOption = jsonProcessor.processOption(this);
        this.f36484i.put(str, processOption);
        return processOption;
    }

    private String b() {
        return String.valueOf(("{packageName='" + this.f36478c + "', routePolicy=" + this.f36479d + ", reader=" + this.f36480e.toString().hashCode() + ", customConfigMap=" + new JSONObject(this.f36482g).toString().hashCode() + '}').hashCode());
    }

    @Override // com.huawei.agconnect.AGConnectOptions
    public boolean getBoolean(String str) {
        return getBoolean(str, false);
    }

    @Override // com.huawei.agconnect.AGConnectOptions
    public Context getContext() {
        return this.f36477b;
    }

    @Override // com.huawei.agconnect.AGConnectOptions
    public String getIdentifier() {
        return this.f36476a;
    }

    @Override // com.huawei.agconnect.AGConnectOptions
    public int getInt(String str) {
        return getInt(str, 0);
    }

    @Override // com.huawei.agconnect.AGConnectOptions
    public String getPackageName() {
        return this.f36478c;
    }

    @Override // com.huawei.agconnect.AGConnectOptions
    public AGCRoutePolicy getRoutePolicy() {
        AGCRoutePolicy aGCRoutePolicy = this.f36479d;
        if (aGCRoutePolicy == null) {
            return AGCRoutePolicy.UNKNOWN;
        }
        return aGCRoutePolicy;
    }

    @Override // com.huawei.agconnect.AGConnectOptions
    public String getString(String str) {
        return getString(str, null);
    }

    public List<Service> a() {
        return this.f36483h;
    }

    @Override // com.huawei.agconnect.AGConnectOptions
    public boolean getBoolean(String str, boolean z16) {
        return Boolean.parseBoolean(getString(str, String.valueOf(z16)));
    }

    @Override // com.huawei.agconnect.AGConnectOptions
    public int getInt(String str, int i3) {
        try {
            return Integer.parseInt(getString(str, String.valueOf(i3)));
        } catch (NumberFormatException unused) {
            return i3;
        }
    }

    @Override // com.huawei.agconnect.AGConnectOptions
    public String getString(String str, String str2) {
        if (str == null) {
            return str2;
        }
        String fixPath = Utils.fixPath(str);
        String str3 = this.f36482g.get(fixPath);
        if (str3 != null) {
            return str3;
        }
        String a16 = a(fixPath);
        if (a16 != null) {
            return a16;
        }
        String a17 = this.f36480e.a(fixPath, str2);
        return e.a(a17) ? this.f36481f.a(a17, str2) : a17;
    }
}
