package com.huawei.agconnect.config.impl;

import android.content.Context;
import android.util.Log;
import com.huawei.agconnect.AGCRoutePolicy;
import com.huawei.agconnect.JsonProcessingFactory;
import com.huawei.agconnect.config.AGConnectServicesConfig;
import com.huawei.agconnect.config.LazyInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes2.dex */
public class c extends AGConnectServicesConfig {

    /* renamed from: a, reason: collision with root package name */
    private final Context f36485a;

    /* renamed from: b, reason: collision with root package name */
    private final String f36486b;

    /* renamed from: c, reason: collision with root package name */
    private LazyInputStream f36487c;

    /* renamed from: d, reason: collision with root package name */
    private volatile d f36488d;

    /* renamed from: e, reason: collision with root package name */
    private final Object f36489e = new Object();

    /* renamed from: f, reason: collision with root package name */
    private AGCRoutePolicy f36490f = AGCRoutePolicy.UNKNOWN;

    /* renamed from: g, reason: collision with root package name */
    private final Map<String, String> f36491g = new HashMap();

    /* renamed from: h, reason: collision with root package name */
    private volatile e f36492h;

    public c(Context context, String str) {
        this.f36485a = context;
        this.f36486b = str;
    }

    private static LazyInputStream a(Context context, final InputStream inputStream) {
        return new LazyInputStream(context) { // from class: com.huawei.agconnect.config.impl.c.1
            @Override // com.huawei.agconnect.config.LazyInputStream
            public InputStream get(Context context2) {
                return inputStream;
            }
        };
    }

    private String b(String str) {
        JsonProcessingFactory.JsonProcessor jsonProcessor;
        Map<String, JsonProcessingFactory.JsonProcessor> processors = JsonProcessingFactory.getProcessors();
        if (processors.containsKey(str) && (jsonProcessor = processors.get(str)) != null) {
            return jsonProcessor.processOption(this);
        }
        return null;
    }

    @Override // com.huawei.agconnect.AGConnectOptions
    public boolean getBoolean(String str) {
        return getBoolean(str, false);
    }

    @Override // com.huawei.agconnect.AGConnectOptions
    public Context getContext() {
        return this.f36485a;
    }

    @Override // com.huawei.agconnect.AGConnectOptions
    public String getIdentifier() {
        return Utils.DEFAULT_NAME;
    }

    @Override // com.huawei.agconnect.AGConnectOptions
    public int getInt(String str) {
        return getInt(str, 0);
    }

    @Override // com.huawei.agconnect.AGConnectOptions
    public String getPackageName() {
        return this.f36486b;
    }

    @Override // com.huawei.agconnect.AGConnectOptions
    public AGCRoutePolicy getRoutePolicy() {
        if (this.f36490f == null) {
            this.f36490f = AGCRoutePolicy.UNKNOWN;
        }
        AGCRoutePolicy aGCRoutePolicy = this.f36490f;
        AGCRoutePolicy aGCRoutePolicy2 = AGCRoutePolicy.UNKNOWN;
        if (aGCRoutePolicy == aGCRoutePolicy2 && this.f36488d == null) {
            a();
        }
        AGCRoutePolicy aGCRoutePolicy3 = this.f36490f;
        if (aGCRoutePolicy3 != null) {
            return aGCRoutePolicy3;
        }
        return aGCRoutePolicy2;
    }

    @Override // com.huawei.agconnect.AGConnectOptions
    public String getString(String str) {
        return getString(str, null);
    }

    @Override // com.huawei.agconnect.config.AGConnectServicesConfig
    public void overlayWith(LazyInputStream lazyInputStream) {
        this.f36487c = lazyInputStream;
    }

    @Override // com.huawei.agconnect.config.AGConnectServicesConfig
    public void setParam(String str, String str2) {
        this.f36491g.put(Utils.fixPath(str), str2);
    }

    @Override // com.huawei.agconnect.config.AGConnectServicesConfig
    public void setRoutePolicy(AGCRoutePolicy aGCRoutePolicy) {
        this.f36490f = aGCRoutePolicy;
    }

    private static String a(String str) {
        int i3 = 0;
        if (str.length() > 0) {
            while (str.charAt(i3) == '/') {
                i3++;
            }
        }
        return '/' + str.substring(i3);
    }

    private void b() {
        if (this.f36490f == AGCRoutePolicy.UNKNOWN) {
            if (this.f36488d != null) {
                this.f36490f = Utils.getRoutePolicyFromJson(this.f36488d.a("/region", null), this.f36488d.a("/agcgw/url", null));
            } else {
                Log.w("AGConnectServiceConfig", "get route fail , config not ready");
            }
        }
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
            throw new NullPointerException("path must not be null.");
        }
        if (this.f36488d == null) {
            a();
        }
        String a16 = a(str);
        String str3 = this.f36491g.get(a16);
        if (str3 != null) {
            return str3;
        }
        String b16 = b(a16);
        if (b16 != null) {
            return b16;
        }
        String a17 = this.f36488d.a(a16, str2);
        return e.a(a17) ? this.f36492h.a(a17, str2) : a17;
    }

    @Override // com.huawei.agconnect.config.AGConnectServicesConfig
    public void overlayWith(InputStream inputStream) {
        overlayWith(a(this.f36485a, inputStream));
    }

    private void a() {
        Log.d("AGC_ConfigImpl", "initConfigReader");
        if (this.f36488d == null) {
            synchronized (this.f36489e) {
                if (this.f36488d == null) {
                    LazyInputStream lazyInputStream = this.f36487c;
                    if (lazyInputStream != null) {
                        this.f36488d = new h(lazyInputStream.loadInputStream(), "UTF-8");
                        this.f36487c.close();
                        this.f36487c = null;
                    } else {
                        this.f36488d = new k(this.f36485a, this.f36486b);
                    }
                    this.f36492h = new e(this.f36488d);
                }
                b();
            }
        }
    }
}
