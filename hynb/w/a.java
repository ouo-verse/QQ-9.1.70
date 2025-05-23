package hynb.w;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.huya.udb.loginsdk.wup.AppLoginData;
import com.huya.udb.loginsdk.wup.Biztoken;
import com.huya.udb.loginsdk.wup.ResponseHeader;
import hynb.p.g;
import hynb.v.c;
import hynb.v.d;
import java.lang.reflect.Type;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes28.dex */
public class a {

    /* renamed from: b, reason: collision with root package name */
    public static volatile a f406909b;

    /* renamed from: a, reason: collision with root package name */
    public Map<Long, AppLoginData> f406910a;

    /* compiled from: P */
    /* renamed from: hynb.w.a$a, reason: collision with other inner class name */
    /* loaded from: classes28.dex */
    public class C10491a extends TypeToken<ConcurrentHashMap<Long, AppLoginData>> {
        public C10491a(a aVar) {
        }
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x007f -> B:22:0x00a0). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x006b -> B:22:0x00a0). Please report as a decompilation issue!!! */
    public a() {
        this.f406910a = new ConcurrentHashMap();
        String str = "";
        try {
            str = new hynb.z.a(hynb.z.b.f406924c).a("HY_UDB_LOGIN_DATA_V1");
            Gson gson = new Gson();
            Type type = new C10491a(this).getType();
            if (str != null && str.length() > 0) {
                try {
                    Map<Long, AppLoginData> map = (Map) gson.fromJson(str, type);
                    this.f406910a = map;
                    if (map.size() > 0) {
                        g.f406799a.a("LoginDataHandler", "cache data uids: %s", this.f406910a.keySet().toString());
                    } else {
                        g.f406799a.info("LoginDataHandler", "cache data is empty");
                    }
                } catch (Exception e16) {
                    g.f406799a.b("LoginDataHandler", "read login data: %s, exception: %s", str, e16.getMessage());
                } catch (Throwable th5) {
                    g.f406799a.b("LoginDataHandler", "read login data: %s, error: %s", str, th5.getMessage());
                }
            }
        } catch (Throwable th6) {
            g.f406799a.b("LoginDataHandler", "read login data file: %s, error: %s", str, th6.getMessage());
        }
    }

    public static a c() {
        if (f406909b == null) {
            synchronized (a.class) {
                if (f406909b == null) {
                    f406909b = new a();
                }
            }
        }
        return f406909b;
    }

    public final void a(AppLoginData appLoginData) {
        if (appLoginData == null) {
            return;
        }
        a();
        Iterator<Long> it = this.f406910a.keySet().iterator();
        while (it.hasNext()) {
            if (this.f406910a.get(Long.valueOf(it.next().longValue())).isAnonymous) {
                it.remove();
            }
        }
        this.f406910a.put(Long.valueOf(appLoginData.uid), appLoginData);
        e();
    }

    public final void b(AppLoginData appLoginData) {
        if (appLoginData == null) {
            return;
        }
        a();
        long j3 = appLoginData.uid;
        if (this.f406910a.containsKey(Long.valueOf(j3))) {
            this.f406910a.remove(Long.valueOf(j3));
        }
        this.f406910a.put(Long.valueOf(j3), appLoginData);
        e();
    }

    public final void e() {
        try {
            new hynb.z.a(hynb.z.b.f406924c).a("HY_UDB_LOGIN_DATA_V1", new Gson().toJson(this.f406910a));
        } catch (Throwable unused) {
        }
    }

    public String b(long j3) {
        byte[] bArr;
        AppLoginData appLoginData = this.f406910a.get(Long.valueOf(j3));
        if (appLoginData == null) {
            return "";
        }
        Iterator<Biztoken> it = appLoginData.biztoken_vec.iterator();
        while (true) {
            if (!it.hasNext()) {
                bArr = null;
                break;
            }
            Biztoken next = it.next();
            if (next.bizAppid.equals(hynb.z.b.f406922a)) {
                bArr = next.biztoken;
                break;
            }
        }
        return new hynb.y.a().a(Long.valueOf(j3), hynb.z.b.f406922a, hynb.z.b.b(), hynb.z.b.f406922a, bArr, hynb.z.b.a(hynb.z.b.e()));
    }

    public final void a() {
        if (this.f406910a.size() <= 10) {
            return;
        }
        int i3 = 1000;
        while (this.f406910a.size() > 10) {
            int i16 = i3 - 1;
            if (i3 <= 0) {
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            long j3 = 0;
            for (AppLoginData appLoginData : this.f406910a.values()) {
                long j16 = appLoginData.timestamp;
                if (j16 <= currentTimeMillis && !appLoginData.isAnonymous) {
                    j3 = appLoginData.uid;
                    currentTimeMillis = j16;
                }
            }
            this.f406910a.remove(Long.valueOf(j3));
            i3 = i16;
        }
    }

    public AppLoginData b() {
        if (this.f406910a.isEmpty()) {
            return null;
        }
        for (Map.Entry<Long, AppLoginData> entry : this.f406910a.entrySet()) {
            if (entry.getValue().isAnonymous) {
                return entry.getValue();
            }
        }
        return null;
    }

    public hynb.v.b a(ResponseHeader responseHeader, AppLoginData appLoginData, boolean z16) {
        if (responseHeader == null) {
            return null;
        }
        if (z16) {
            return a(responseHeader, appLoginData);
        }
        hynb.z.b.b(responseHeader.currentTime);
        c cVar = new c();
        int i3 = responseHeader.returnCode;
        cVar.f406888b = i3;
        cVar.f406889c = responseHeader.description;
        if (i3 == 0 && appLoginData != null) {
            if (appLoginData.timestamp <= 0) {
                appLoginData.timestamp = responseHeader.currentTime;
            }
            b(appLoginData);
            long j3 = appLoginData.uid;
            hynb.z.b.f406930i = j3;
            cVar.f406891e = 0;
            cVar.f406890d = String.valueOf(j3);
            cVar.f406892f = appLoginData.thirdParams;
        } else {
            cVar.f406891e = 1;
        }
        return cVar;
    }

    public void d() {
    }

    public hynb.v.b a(ResponseHeader responseHeader, AppLoginData appLoginData) {
        if (responseHeader == null) {
            return null;
        }
        hynb.z.b.b(responseHeader.currentTime);
        hynb.v.a aVar = new hynb.v.a();
        if (responseHeader.returnCode == 0 && appLoginData != null) {
            appLoginData.isAnonymous = true;
            if (appLoginData.timestamp <= 0) {
                appLoginData.timestamp = responseHeader.currentTime;
            }
            a(appLoginData);
            aVar.f406886d = 0;
            aVar.f406885c = String.valueOf(appLoginData.uid);
        } else {
            aVar.f406886d = 1;
            aVar.f406884b = responseHeader.description;
        }
        return aVar;
    }

    public hynb.v.b a(String str) {
        return new d();
    }

    public void a(long j3) {
        this.f406910a.remove(Long.valueOf(j3));
        e();
    }
}
