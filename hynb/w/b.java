package hynb.w;

import com.google.gson.Gson;
import com.google.gson.internal.LinkedTreeMap;
import com.huya.huyasdk.data.HYNSRequest;
import com.huya.udb.loginsdk.wup.AppLoginData;
import com.huya.udb.loginsdk.wup.ResponseHeader;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import hynb.b.h;
import hynb.b.l;
import hynb.p.g;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes28.dex */
public class b {

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static class a implements h {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ hynb.x.a f406911a;

        public a(hynb.x.a aVar) {
            this.f406911a = aVar;
        }

        @Override // hynb.b.h
        public Class getResponseClass() {
            return Map.class;
        }

        @Override // hynb.b.h
        public void onError(int i3, String str, Object obj) {
            g.f406799a.info("WupHttpServer", "res error, code: " + i3);
            if (-9999 == i3) {
                b.a(this.f406911a, null, null, 2);
            } else {
                b.a(this.f406911a, null, null, 1);
            }
        }

        @Override // hynb.b.h
        public void onResponse(Object obj) {
            ResponseHeader responseHeader;
            AppLoginData appLoginData;
            if (obj == null) {
                g.f406799a.info("WupHttpServer", "res: null");
                b.a(this.f406911a, null, null, 3);
                return;
            }
            try {
                String json = new Gson().toJson(obj);
                g.f406799a.a("WupHttpServer", "res: " + json);
                if (json.length() > 10240) {
                    b.a(this.f406911a, null, null, 5);
                    return;
                }
                LinkedTreeMap linkedTreeMap = (LinkedTreeMap) obj;
                Gson gson = new Gson();
                if (linkedTreeMap.get("header") != null) {
                    responseHeader = (ResponseHeader) gson.fromJson(gson.toJson(linkedTreeMap.get("header")), ResponseHeader.class);
                } else {
                    responseHeader = null;
                }
                if (linkedTreeMap.get("loginData") != null) {
                    appLoginData = (AppLoginData) gson.fromJson(gson.toJson(linkedTreeMap.get("loginData")), AppLoginData.class);
                } else {
                    appLoginData = null;
                }
                b.a(this.f406911a, responseHeader, appLoginData, 0);
            } catch (Exception e16) {
                g.f406799a.error("WupHttpServer", "res Exception, e: " + e16.getMessage());
                b.a(this.f406911a, null, null, 4);
            } catch (Throwable th5) {
                g.f406799a.error("WupHttpServer", "res Throwable, e: " + th5.getMessage());
                b.a(this.f406911a, null, null, 4);
            }
        }
    }

    /* compiled from: P */
    /* renamed from: hynb.w.b$b, reason: collision with other inner class name */
    /* loaded from: classes28.dex */
    public static class RunnableC10492b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ hynb.x.a f406912a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f406913b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ ResponseHeader f406914c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ AppLoginData f406915d;

        public RunnableC10492b(hynb.x.a aVar, int i3, ResponseHeader responseHeader, AppLoginData appLoginData) {
            this.f406912a = aVar;
            this.f406913b = i3;
            this.f406914c = responseHeader;
            this.f406915d = appLoginData;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f406912a.a(this.f406913b, this.f406914c, this.f406915d);
        }
    }

    public static void a(Object obj, String str, String str2, String str3, hynb.x.a aVar) {
        String str4;
        try {
            str4 = new Gson().toJson(obj);
        } catch (Throwable unused) {
            str4 = "";
        }
        g.f406799a.a("WupHttpServer", "req: " + str4);
        l.i().b(new HYNSRequest.Builder().sServantName(str2).sFuncName(str3).jsonBodyObj(obj).build(), new a(aVar));
    }

    public static void a(hynb.x.a aVar, ResponseHeader responseHeader, AppLoginData appLoginData, int i3) {
        new BaseThread(new RunnableC10492b(aVar, i3, responseHeader, appLoginData)).start();
    }
}
