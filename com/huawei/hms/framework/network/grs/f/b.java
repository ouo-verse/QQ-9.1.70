package com.huawei.hms.framework.network.grs.f;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.framework.common.AssetsUtil;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.network.grs.GrsApp;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes2.dex */
public class b {

    /* renamed from: b, reason: collision with root package name */
    private static final Map<String, b> f36957b = new ConcurrentHashMap(16);

    /* renamed from: c, reason: collision with root package name */
    private static final Object f36958c = new Object();

    /* renamed from: a, reason: collision with root package name */
    private a f36959a;

    public b(Context context, GrsBaseInfo grsBaseInfo, boolean z16) {
        a(context, z16);
        f36957b.put(context.getPackageName() + grsBaseInfo.uniqueCode(), this);
    }

    public static b a(String str, GrsBaseInfo grsBaseInfo) {
        return f36957b.get(str + grsBaseInfo.uniqueCode());
    }

    public Set<String> b() {
        return this.f36959a.c();
    }

    public com.huawei.hms.framework.network.grs.local.model.a a() {
        return this.f36959a.b();
    }

    public String a(Context context, com.huawei.hms.framework.network.grs.e.a aVar, GrsBaseInfo grsBaseInfo, String str, String str2, boolean z16) {
        synchronized (f36958c) {
            String a16 = this.f36959a.a(context, aVar, grsBaseInfo, str, str2, z16);
            if (!TextUtils.isEmpty(a16) || !this.f36959a.d()) {
                return a16;
            }
            a(context, true);
            a(grsBaseInfo);
            f36957b.put(context.getPackageName() + grsBaseInfo.uniqueCode(), this);
            return this.f36959a.a(context, aVar, grsBaseInfo, str, str2, z16);
        }
    }

    public Map<String, String> a(Context context, com.huawei.hms.framework.network.grs.e.a aVar, GrsBaseInfo grsBaseInfo, String str, boolean z16) {
        synchronized (f36958c) {
            Map<String, String> a16 = this.f36959a.a(context, aVar, grsBaseInfo, str, z16);
            if ((a16 != null && !a16.isEmpty()) || !this.f36959a.d()) {
                return a16;
            }
            a(context, true);
            a(grsBaseInfo);
            f36957b.put(context.getPackageName() + grsBaseInfo.uniqueCode(), this);
            return this.f36959a.a(context, aVar, grsBaseInfo, str, z16);
        }
    }

    public static void a(Context context, GrsBaseInfo grsBaseInfo) {
        b a16 = a(context.getPackageName(), grsBaseInfo);
        if (a16 != null) {
            Logger.i("LocalManagerProxy", "appGrs is not null and clear services.");
            synchronized (f36958c) {
                a16.f36959a.a();
            }
        }
    }

    public void a(Context context, boolean z16) {
        String[] list = AssetsUtil.list(context, GrsApp.getInstance().getBrand(""));
        List<String> arrayList = list == null ? new ArrayList<>() : Arrays.asList(list);
        String appConfigName = GrsApp.getInstance().getAppConfigName();
        Logger.i("LocalManagerProxy", "appConfigName is: " + appConfigName);
        this.f36959a = new d(false, z16);
        if (arrayList.contains("grs_app_global_route_config.json") || !TextUtils.isEmpty(appConfigName)) {
            this.f36959a = new d(context, appConfigName, z16);
        }
        if (!this.f36959a.e() && arrayList.contains("grs_sdk_global_route_config.json")) {
            this.f36959a = new c(context, z16);
        }
        this.f36959a.a(context, arrayList);
    }

    public void a(GrsBaseInfo grsBaseInfo) {
        this.f36959a.a(grsBaseInfo);
    }
}
