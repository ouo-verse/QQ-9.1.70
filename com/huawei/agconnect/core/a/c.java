package com.huawei.agconnect.core.a;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.os.Bundle;
import android.util.Log;
import com.huawei.agconnect.core.Service;
import com.huawei.agconnect.core.ServiceDiscovery;
import com.huawei.agconnect.core.ServiceRegistrar;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes2.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private final Context f36528a;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class a implements Serializable, Comparator<Map.Entry<String, Integer>> {
        a() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(Map.Entry<String, Integer> entry, Map.Entry<String, Integer> entry2) {
            return entry.getValue().intValue() - entry2.getValue().intValue();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(Context context) {
        this.f36528a = context;
    }

    private <T extends ServiceRegistrar> T a(String str) {
        StringBuilder sb5;
        String sb6;
        try {
            Class<?> cls = Class.forName(str);
            if (ServiceRegistrar.class.isAssignableFrom(cls)) {
                return (T) Class.forName(str).newInstance();
            }
            Log.e("ServiceRegistrarParser", cls + " must extends from ServiceRegistrar.");
            return null;
        } catch (ClassNotFoundException e16) {
            sb6 = "Can not found service class, " + e16.getMessage();
            Log.e("ServiceRegistrarParser", sb6);
            return null;
        } catch (IllegalAccessException e17) {
            e = e17;
            sb5 = new StringBuilder();
            sb5.append("instantiate service class exception ");
            sb5.append(e.getLocalizedMessage());
            sb6 = sb5.toString();
            Log.e("ServiceRegistrarParser", sb6);
            return null;
        } catch (InstantiationException e18) {
            e = e18;
            sb5 = new StringBuilder();
            sb5.append("instantiate service class exception ");
            sb5.append(e.getLocalizedMessage());
            sb6 = sb5.toString();
            Log.e("ServiceRegistrarParser", sb6);
            return null;
        }
    }

    private List<String> b() {
        StringBuilder sb5;
        ArrayList arrayList = new ArrayList();
        Bundle c16 = c();
        if (c16 == null) {
            return arrayList;
        }
        HashMap hashMap = new HashMap(10);
        for (String str : c16.keySet()) {
            if ("com.huawei.agconnect.core.ServiceRegistrar".equals(c16.getString(str))) {
                String[] split = str.split(":");
                if (split.length == 2) {
                    try {
                        hashMap.put(split[0], Integer.valueOf(split[1]));
                    } catch (NumberFormatException e16) {
                        sb5 = new StringBuilder();
                        sb5.append("registrar configuration format error:");
                        str = e16.getMessage();
                    }
                } else if (split.length == 1) {
                    hashMap.put(split[0], 1000);
                } else {
                    sb5 = new StringBuilder();
                    sb5.append("registrar configuration error, ");
                    sb5.append(str);
                    Log.e("ServiceRegistrarParser", sb5.toString());
                }
            }
        }
        ArrayList arrayList2 = new ArrayList(hashMap.entrySet());
        Collections.sort(arrayList2, new a());
        Iterator it = arrayList2.iterator();
        while (it.hasNext()) {
            arrayList.add(((Map.Entry) it.next()).getKey());
        }
        return arrayList;
    }

    private Bundle c() {
        ServiceInfo serviceInfo;
        PackageManager packageManager = this.f36528a.getPackageManager();
        if (packageManager == null) {
            return null;
        }
        try {
            serviceInfo = packageManager.getServiceInfo(new ComponentName(this.f36528a, (Class<?>) ServiceDiscovery.class), 128);
        } catch (PackageManager.NameNotFoundException e16) {
            Log.e("ServiceRegistrarParser", "get ServiceDiscovery exception." + e16.getLocalizedMessage());
        }
        if (serviceInfo == null) {
            Log.e("ServiceRegistrarParser", "Can not found ServiceDiscovery service.");
            return null;
        }
        return serviceInfo.metaData;
    }

    public List<Service> a() {
        Log.i("ServiceRegistrarParser", "getServices");
        List<String> b16 = b();
        ArrayList arrayList = new ArrayList();
        Iterator<String> it = b16.iterator();
        while (it.hasNext()) {
            ServiceRegistrar a16 = a(it.next());
            if (a16 != null) {
                a16.initialize(this.f36528a);
                List<Service> services = a16.getServices(this.f36528a);
                if (services != null) {
                    arrayList.addAll(services);
                }
            }
        }
        Log.i("ServiceRegistrarParser", "services:" + Integer.valueOf(arrayList.size()));
        return arrayList;
    }
}
