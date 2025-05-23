package com.huawei.agconnect.core.a;

import android.content.Context;
import android.util.Log;
import com.huawei.agconnect.AGCRoutePolicy;
import com.huawei.agconnect.AGConnectInstance;
import com.huawei.agconnect.AGConnectOptions;
import com.huawei.agconnect.AGConnectOptionsBuilder;
import com.huawei.agconnect.CustomAuthProvider;
import com.huawei.agconnect.CustomCredentialsProvider;
import com.huawei.agconnect.JsonProcessingFactory;
import com.huawei.agconnect.config.AGConnectServicesConfig;
import com.huawei.agconnect.config.impl.Utils;
import com.huawei.agconnect.core.Service;
import com.huawei.agconnect.core.service.auth.AuthProvider;
import com.huawei.agconnect.core.service.auth.CredentialsProvider;
import com.huawei.agconnect.core.service.auth.OnTokenListener;
import com.huawei.agconnect.core.service.auth.Token;
import com.huawei.hmf.tasks.Task;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes2.dex */
public class b extends AGConnectInstance {

    /* renamed from: a, reason: collision with root package name */
    private static List<Service> f36518a;

    /* renamed from: b, reason: collision with root package name */
    private static final Map<String, AGConnectInstance> f36519b = new HashMap();

    /* renamed from: c, reason: collision with root package name */
    private static String f36520c;

    /* renamed from: d, reason: collision with root package name */
    private final AGConnectOptions f36521d;

    /* renamed from: e, reason: collision with root package name */
    private final d f36522e;

    /* renamed from: f, reason: collision with root package name */
    private final d f36523f;

    public b(AGConnectOptions aGConnectOptions) {
        this.f36521d = aGConnectOptions;
        if (f36518a == null) {
            Log.e("AGConnectInstance", "please call `initialize()` first");
        }
        this.f36522e = new d(f36518a, aGConnectOptions.getContext());
        d dVar = new d(null, aGConnectOptions.getContext());
        this.f36523f = dVar;
        if (aGConnectOptions instanceof com.huawei.agconnect.config.impl.b) {
            dVar.a(((com.huawei.agconnect.config.impl.b) aGConnectOptions).a(), aGConnectOptions.getContext());
        }
    }

    public static AGConnectInstance a() {
        String str = f36520c;
        if (str == null) {
            str = Utils.DEFAULT_NAME;
        }
        return a(str);
    }

    private static void b() {
        JsonProcessingFactory.registerProcessor("/agcgw/url", new JsonProcessingFactory.JsonProcessor() { // from class: com.huawei.agconnect.core.a.b.1
            @Override // com.huawei.agconnect.JsonProcessingFactory.JsonProcessor
            public String processOption(AGConnectOptions aGConnectOptions) {
                String str;
                if (aGConnectOptions.getRoutePolicy().equals(AGCRoutePolicy.CHINA)) {
                    str = "/agcgw_all/CN";
                } else if (aGConnectOptions.getRoutePolicy().equals(AGCRoutePolicy.RUSSIA)) {
                    str = "/agcgw_all/RU";
                } else if (aGConnectOptions.getRoutePolicy().equals(AGCRoutePolicy.GERMANY)) {
                    str = "/agcgw_all/DE";
                } else if (aGConnectOptions.getRoutePolicy().equals(AGCRoutePolicy.SINGAPORE)) {
                    str = "/agcgw_all/SG";
                } else {
                    return null;
                }
                return aGConnectOptions.getString(str);
            }
        });
        JsonProcessingFactory.registerProcessor("/agcgw/backurl", new JsonProcessingFactory.JsonProcessor() { // from class: com.huawei.agconnect.core.a.b.2
            @Override // com.huawei.agconnect.JsonProcessingFactory.JsonProcessor
            public String processOption(AGConnectOptions aGConnectOptions) {
                String str;
                if (aGConnectOptions.getRoutePolicy().equals(AGCRoutePolicy.CHINA)) {
                    str = "/agcgw_all/CN_back";
                } else if (aGConnectOptions.getRoutePolicy().equals(AGCRoutePolicy.RUSSIA)) {
                    str = "/agcgw_all/RU_back";
                } else if (aGConnectOptions.getRoutePolicy().equals(AGCRoutePolicy.GERMANY)) {
                    str = "/agcgw_all/DE_back";
                } else if (aGConnectOptions.getRoutePolicy().equals(AGCRoutePolicy.SINGAPORE)) {
                    str = "/agcgw_all/SG_back";
                } else {
                    return null;
                }
                return aGConnectOptions.getString(str);
            }
        });
    }

    @Override // com.huawei.agconnect.AGConnectInstance
    public Context getContext() {
        return this.f36521d.getContext();
    }

    @Override // com.huawei.agconnect.AGConnectInstance
    public String getIdentifier() {
        return this.f36521d.getIdentifier();
    }

    @Override // com.huawei.agconnect.AGConnectInstance
    public AGConnectOptions getOptions() {
        return this.f36521d;
    }

    @Override // com.huawei.agconnect.AGConnectInstance
    public <T> T getService(Class<? super T> cls) {
        T t16 = (T) this.f36523f.a(this, cls);
        if (t16 != null) {
            return t16;
        }
        return (T) this.f36522e.a(this, cls);
    }

    public static AGConnectInstance a(AGConnectOptions aGConnectOptions) {
        return a(aGConnectOptions, false);
    }

    private static void b(Context context, AGConnectOptionsBuilder aGConnectOptionsBuilder) {
        AGConnectServicesConfig fromContext = AGConnectServicesConfig.fromContext(context);
        if (aGConnectOptionsBuilder.getInputStream() != null) {
            try {
                String utils = Utils.toString(aGConnectOptionsBuilder.getInputStream(), "UTF-8");
                aGConnectOptionsBuilder.getInputStream().reset();
                fromContext.overlayWith(new ByteArrayInputStream(utils.getBytes(Charset.forName("UTF-8"))));
            } catch (IOException unused) {
                Log.e("AGC_Instance", "input stream set to AGConnectServicesConfig fail");
            }
        }
        for (Map.Entry<String, String> entry : aGConnectOptionsBuilder.getCustomConfigMap().entrySet()) {
            fromContext.setParam(entry.getKey(), entry.getValue());
        }
        if (aGConnectOptionsBuilder.getRoutePolicy() != AGCRoutePolicy.UNKNOWN) {
            fromContext.setRoutePolicy(aGConnectOptionsBuilder.getRoutePolicy());
        }
    }

    private static synchronized AGConnectInstance a(AGConnectOptions aGConnectOptions, boolean z16) {
        AGConnectInstance aGConnectInstance;
        synchronized (b.class) {
            Map<String, AGConnectInstance> map = f36519b;
            aGConnectInstance = map.get(aGConnectOptions.getIdentifier());
            if (aGConnectInstance == null || z16) {
                aGConnectInstance = new b(aGConnectOptions);
                map.put(aGConnectOptions.getIdentifier(), aGConnectInstance);
            }
        }
        return aGConnectInstance;
    }

    public static synchronized AGConnectInstance a(String str) {
        AGConnectInstance aGConnectInstance;
        synchronized (b.class) {
            aGConnectInstance = f36519b.get(str);
            if (aGConnectInstance == null) {
                if (Utils.DEFAULT_NAME.equals(str)) {
                    Log.w("AGC_Instance", "please call `initialize()` first");
                } else {
                    Log.w("AGC_Instance", "not find instance for : " + str);
                }
            }
        }
        return aGConnectInstance;
    }

    public static synchronized void a(Context context) {
        synchronized (b.class) {
            if (f36519b.size() > 0) {
                Log.w("AGC_Instance", "Repeated invoking initialize");
            } else {
                a(context, AGConnectServicesConfig.fromContext(context));
            }
        }
    }

    private static synchronized void a(Context context, AGConnectOptions aGConnectOptions) {
        synchronized (b.class) {
            Context applicationContext = context.getApplicationContext();
            if (applicationContext == null) {
                Log.w("AGC_Instance", "context.getApplicationContext null");
            } else {
                context = applicationContext;
            }
            b();
            com.huawei.agconnect.config.impl.a.a(context);
            if (f36518a == null) {
                f36518a = new c(context).a();
            }
            a(aGConnectOptions, true);
            f36520c = aGConnectOptions.getIdentifier();
            a.a();
            Log.i("AGC_Instance", "AGC SDK initialize end");
        }
    }

    public static synchronized void a(Context context, AGConnectOptionsBuilder aGConnectOptionsBuilder) {
        synchronized (b.class) {
            b(context, aGConnectOptionsBuilder);
            a(context, aGConnectOptionsBuilder.build(context));
        }
    }

    public void a(final CustomAuthProvider customAuthProvider) {
        this.f36523f.a(Collections.singletonList(Service.builder((Class<?>) AuthProvider.class, new AuthProvider() { // from class: com.huawei.agconnect.core.a.b.4
            @Override // com.huawei.agconnect.core.service.auth.AuthProvider
            public Task<Token> getTokens() {
                return customAuthProvider.getTokens(false);
            }

            @Override // com.huawei.agconnect.core.service.auth.AuthProvider
            public String getUid() {
                return "";
            }

            @Override // com.huawei.agconnect.core.service.auth.AuthProvider
            public Task<Token> getTokens(boolean z16) {
                return customAuthProvider.getTokens(z16);
            }

            @Override // com.huawei.agconnect.core.service.auth.AuthProvider
            public void addTokenListener(OnTokenListener onTokenListener) {
            }

            @Override // com.huawei.agconnect.core.service.auth.AuthProvider
            public void removeTokenListener(OnTokenListener onTokenListener) {
            }
        }).build()), this.f36521d.getContext());
    }

    public void a(final CustomCredentialsProvider customCredentialsProvider) {
        this.f36523f.a(Collections.singletonList(Service.builder((Class<?>) CredentialsProvider.class, new CredentialsProvider() { // from class: com.huawei.agconnect.core.a.b.3
            @Override // com.huawei.agconnect.core.service.auth.CredentialsProvider
            public Task<Token> getTokens() {
                return customCredentialsProvider.getTokens(false);
            }

            @Override // com.huawei.agconnect.core.service.auth.CredentialsProvider
            public Task<Token> getTokens(boolean z16) {
                return customCredentialsProvider.getTokens(z16);
            }
        }).build()), this.f36521d.getContext());
    }
}
