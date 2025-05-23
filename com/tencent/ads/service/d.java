package com.tencent.ads.service;

import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.ads.AdManager;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.CookieStore;
import java.net.HttpCookie;
import java.net.URI;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes37.dex */
public final class d implements CookieStore {

    /* renamed from: a, reason: collision with root package name */
    private static final String f61697a = "PersistentCookieStore";

    /* renamed from: b, reason: collision with root package name */
    private static final String f61698b = "qzone.ad.CookiePrefsFile";

    /* renamed from: c, reason: collision with root package name */
    private final ConcurrentHashMap f61699c;

    /* renamed from: d, reason: collision with root package name */
    private final SharedPreferences f61700d;

    public d() {
        SerializableCookie a16;
        String domain;
        SharedPreferences sharedPreferences = AdManager.getApplicationContext().getSharedPreferences(f61698b, 0);
        this.f61700d = sharedPreferences;
        this.f61699c = new ConcurrentHashMap();
        Map<String, ?> all = sharedPreferences.getAll();
        if (all != null) {
            Iterator<Map.Entry<String, ?>> it = all.entrySet().iterator();
            while (it.hasNext()) {
                Object value = it.next().getValue();
                if (value != null && (value instanceof String) && (a16 = a((String) value)) != null) {
                    HttpCookie a17 = a16.a();
                    Date b16 = a16.b();
                    int compareTo = b16.compareTo(new Date());
                    if (a17 != null && compareTo > 0 && (domain = a17.getDomain()) != null) {
                        ConcurrentHashMap concurrentHashMap = (ConcurrentHashMap) this.f61699c.get(domain);
                        if (concurrentHashMap == null) {
                            concurrentHashMap = new ConcurrentHashMap();
                            this.f61699c.put(domain, concurrentHashMap);
                        }
                        concurrentHashMap.put(a17.getName(), new c(a17, b16));
                    }
                }
            }
        }
    }

    private static SerializableCookie a(String str) {
        try {
            int length = str.length();
            byte[] bArr = new byte[length / 2];
            for (int i3 = 0; i3 < length; i3 += 2) {
                bArr[i3 / 2] = (byte) ((Character.digit(str.charAt(i3), 16) << 4) + Character.digit(str.charAt(i3 + 1), 16));
            }
            return (SerializableCookie) new ObjectInputStream(new ByteArrayInputStream(bArr)).readObject();
        } catch (Throwable unused) {
            Log.d(f61697a, "decodeCookie failed");
            return null;
        }
    }

    private void b() {
        SharedPreferences.Editor edit = this.f61700d.edit();
        edit.clear();
        edit.commit();
        this.f61699c.clear();
    }

    private boolean c() {
        boolean z16 = false;
        for (String str : this.f61699c.keySet()) {
            for (Map.Entry entry : ((ConcurrentHashMap) this.f61699c.get(str)).entrySet()) {
                if (entry != null) {
                    String str2 = (String) entry.getKey();
                    c cVar = (c) entry.getValue();
                    if (cVar != null && cVar.b().compareTo(new Date()) <= 0) {
                        ((ConcurrentHashMap) this.f61699c.get(str)).remove(str2);
                        z16 = true;
                    }
                }
            }
        }
        return z16;
    }

    @Override // java.net.CookieStore
    public final List get(URI uri) {
        c cVar;
        HttpCookie a16;
        String str;
        String str2;
        Log.i(f61697a, "get:" + uri);
        ArrayList arrayList = new ArrayList();
        if (uri == null) {
            str2 = "get fail: uri null";
        } else {
            String host = uri.getHost();
            if (TextUtils.isEmpty(host)) {
                str2 = "get fail: host null";
            } else {
                for (String str3 : this.f61699c.keySet()) {
                    Log.d(f61697a, "get: host(" + host + ") domain(" + str3 + ")");
                    if (host != null && host.endsWith(str3)) {
                        for (Map.Entry entry : ((ConcurrentHashMap) this.f61699c.get(str3)).entrySet()) {
                            if (entry != null && (cVar = (c) entry.getValue()) != null && (a16 = cVar.a()) != null) {
                                String str4 = (String) entry.getKey();
                                if (cVar.b().compareTo(new Date()) <= 0) {
                                    ((ConcurrentHashMap) this.f61699c.get(str3)).remove(str4);
                                    str = "get remove name: (" + str4 + ") from domain(" + str3 + ") expired";
                                } else {
                                    arrayList.add(a16);
                                    str = "get - add cookie: " + a16;
                                }
                                Log.d(f61697a, str);
                            }
                        }
                    }
                }
                return arrayList;
            }
        }
        Log.i(f61697a, str2);
        return arrayList;
    }

    @Override // java.net.CookieStore
    public final List getCookies() {
        return null;
    }

    @Override // java.net.CookieStore
    public final List getURIs() {
        return null;
    }

    @Override // java.net.CookieStore
    public final boolean remove(URI uri, HttpCookie httpCookie) {
        String host = uri.getHost();
        boolean z16 = false;
        for (String str : this.f61699c.keySet()) {
            if (host.endsWith(str) && this.f61699c.get(str) != null) {
                ((ConcurrentHashMap) this.f61699c.get(str)).remove(httpCookie.getName());
                z16 = true;
            }
        }
        return z16;
    }

    @Override // java.net.CookieStore
    public final boolean removeAll() {
        SharedPreferences.Editor edit = this.f61700d.edit();
        edit.clear();
        edit.commit();
        this.f61699c.clear();
        return false;
    }

    private static String a(SerializableCookie serializableCookie) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            new ObjectOutputStream(byteArrayOutputStream).writeObject(serializableCookie);
            return a(byteArrayOutputStream.toByteArray());
        } catch (Exception unused) {
            return null;
        }
    }

    private static byte[] b(String str) {
        int length = str.length();
        byte[] bArr = new byte[length / 2];
        for (int i3 = 0; i3 < length; i3 += 2) {
            bArr[i3 / 2] = (byte) ((Character.digit(str.charAt(i3), 16) << 4) + Character.digit(str.charAt(i3 + 1), 16));
        }
        return bArr;
    }

    private static String a(byte[] bArr) {
        StringBuilder sb5 = new StringBuilder(bArr.length * 2);
        for (byte b16 : bArr) {
            int i3 = b16 & 255;
            if (i3 < 16) {
                sb5.append('0');
            }
            sb5.append(Integer.toHexString(i3));
        }
        return sb5.toString().toUpperCase();
    }

    public final void a() {
        HttpCookie a16;
        String str;
        Log.i("AdCookie", "persistentCookies");
        SharedPreferences.Editor edit = this.f61700d.edit();
        for (String str2 : this.f61699c.keySet()) {
            for (Map.Entry entry : ((ConcurrentHashMap) this.f61699c.get(str2)).entrySet()) {
                if (entry != null) {
                    String str3 = (String) entry.getKey();
                    c cVar = (c) entry.getValue();
                    if (cVar != null && (a16 = cVar.a()) != null) {
                        Date b16 = cVar.b();
                        if (b16.compareTo(new Date()) <= 0) {
                            ((ConcurrentHashMap) this.f61699c.get(str2)).remove(str3);
                            str = "persistentCookies - remove: (domain)" + str2 + " (name)" + str3;
                        } else {
                            String a17 = a(new SerializableCookie(a16, b16));
                            edit.putString(String.valueOf(str2) + str3, a17);
                            str = "persistentCookies - write: " + a17;
                        }
                        Log.i("AdCookie", str);
                    }
                }
            }
        }
        edit.commit();
    }

    public final void a(HttpCookie httpCookie) {
        String domain = httpCookie.getDomain();
        if (domain == null) {
            return;
        }
        ConcurrentHashMap concurrentHashMap = (ConcurrentHashMap) this.f61699c.get(domain);
        if (concurrentHashMap == null) {
            concurrentHashMap = new ConcurrentHashMap();
            this.f61699c.put(domain, concurrentHashMap);
        }
        if (httpCookie.hasExpired()) {
            concurrentHashMap.remove(httpCookie.getName());
        } else {
            concurrentHashMap.put(httpCookie.getName(), new c(httpCookie, httpCookie.getMaxAge() == -1 ? new Date(2147483647000L) : new Date(System.currentTimeMillis() + (httpCookie.getMaxAge() * 1000))));
        }
    }

    @Override // java.net.CookieStore
    public final void add(URI uri, HttpCookie httpCookie) {
        if (uri == null || httpCookie == null) {
            return;
        }
        String host = uri.getHost();
        if (TextUtils.isEmpty(host)) {
            return;
        }
        String domain = httpCookie.getDomain();
        if (host.endsWith(domain)) {
            if (TextUtils.isEmpty(domain)) {
                httpCookie.setDomain(host);
            }
            a(httpCookie);
        }
    }
}
