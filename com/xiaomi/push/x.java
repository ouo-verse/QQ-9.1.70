package com.xiaomi.push;

import android.net.NetworkInfo;
import com.tencent.qmethod.pandoraex.monitor.NetworkMonitor;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes28.dex */
public class x {

    /* renamed from: a, reason: collision with root package name */
    private final NetworkInfo f389865a;

    /* renamed from: b, reason: collision with root package name */
    private final ConcurrentHashMap<String, Object> f389866b = new ConcurrentHashMap<>();

    public x(NetworkInfo networkInfo) {
        this.f389865a = networkInfo;
    }

    private <T> T d(String str) {
        char c16;
        Object valueOf;
        if (!this.f389866b.containsKey(str)) {
            synchronized (str) {
                if (!this.f389866b.contains(str)) {
                    switch (str.hashCode()) {
                        case -830707388:
                            if (str.equals("getSubtype")) {
                                c16 = 2;
                                break;
                            }
                            c16 = '\uffff';
                            break;
                        case -75106384:
                            if (str.equals("getType")) {
                                c16 = 0;
                                break;
                            }
                            c16 = '\uffff';
                            break;
                        case -66906641:
                            if (str.equals("getSubtypeName")) {
                                c16 = 3;
                                break;
                            }
                            c16 = '\uffff';
                            break;
                        case 599209215:
                            if (str.equals("isConnected")) {
                                c16 = 4;
                                break;
                            }
                            c16 = '\uffff';
                            break;
                        case 711698955:
                            if (str.equals("getDetailedState")) {
                                c16 = 6;
                                break;
                            }
                            c16 = '\uffff';
                            break;
                        case 1401392731:
                            if (str.equals("getTypeName")) {
                                c16 = 1;
                                break;
                            }
                            c16 = '\uffff';
                            break;
                        case 1965583067:
                            if (str.equals("getState")) {
                                c16 = 5;
                                break;
                            }
                            c16 = '\uffff';
                            break;
                        default:
                            c16 = '\uffff';
                            break;
                    }
                    switch (c16) {
                        case 0:
                            valueOf = Integer.valueOf(NetworkMonitor.getType(this.f389865a));
                            break;
                        case 1:
                            valueOf = NetworkMonitor.getTypeName(this.f389865a);
                            break;
                        case 2:
                            valueOf = Integer.valueOf(NetworkMonitor.getSubtype(this.f389865a));
                            break;
                        case 3:
                            valueOf = this.f389865a.getSubtypeName();
                            break;
                        case 4:
                            valueOf = Boolean.valueOf(this.f389865a.isConnected());
                            break;
                        case 5:
                            valueOf = this.f389865a.getState();
                            break;
                        case 6:
                            valueOf = this.f389865a.getDetailedState();
                            break;
                        default:
                            valueOf = null;
                            break;
                    }
                    if (valueOf != null) {
                        this.f389866b.put(str, valueOf);
                    }
                }
            }
        }
        return (T) this.f389866b.get(str);
    }

    public int a() {
        return ((Integer) d("getType")).intValue();
    }

    public NetworkInfo.DetailedState b() {
        return (NetworkInfo.DetailedState) d("getDetailedState");
    }

    public NetworkInfo.State c() {
        return (NetworkInfo.State) d("getState");
    }

    public String e() {
        return (String) d("getTypeName");
    }

    public boolean f() {
        return ((Boolean) d("isConnected")).booleanValue();
    }

    public int g() {
        return ((Integer) d("getSubtype")).intValue();
    }

    public String h() {
        return (String) d("getSubtypeName");
    }
}
