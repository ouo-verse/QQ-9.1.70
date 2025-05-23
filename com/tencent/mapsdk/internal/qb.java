package com.tencent.mapsdk.internal;

import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.map.tools.json.JsonParser;
import com.tencent.map.tools.json.JsonUtils;
import com.tencent.map.tools.net.NetResponse;
import com.tencent.tencentmap.mapsdk.maps.TencentMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class qb extends AsyncTask<Object, Void, Void> {

    /* renamed from: a, reason: collision with root package name */
    public static final int f149749a = 10000;

    /* renamed from: b, reason: collision with root package name */
    final Handler f149750b = new Handler(Looper.myLooper()) { // from class: com.tencent.mapsdk.internal.qb.1
        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            super.handleMessage(message);
            if (message.what == 10000) {
                qb qbVar = new qb(qb.this.f149751c, qb.this.f149752d, qb.this.f149753e, qb.this.f149754f, qb.this.f149756h);
                qb.this.f149756h.add(qbVar);
                qbVar.execute(new Object[0]);
            }
        }
    };

    /* renamed from: c, reason: collision with root package name */
    private final Handler f149751c;

    /* renamed from: d, reason: collision with root package name */
    private final String f149752d;

    /* renamed from: e, reason: collision with root package name */
    private final String f149753e;

    /* renamed from: f, reason: collision with root package name */
    private final c f149754f;

    /* renamed from: g, reason: collision with root package name */
    private b f149755g;

    /* renamed from: h, reason: collision with root package name */
    private final List<AsyncTask> f149756h;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.mapsdk.internal.qb$2, reason: invalid class name */
    /* loaded from: classes9.dex */
    public final class AnonymousClass2 implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ JSONObject f149758a;

        AnonymousClass2(JSONObject jSONObject) {
            this.f149758a = jSONObject;
        }

        @Override // java.lang.Runnable
        public final void run() {
            qb.this.f149754f.a(qb.this.f149755g, this.f149758a);
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mapsdk.internal.qb$3, reason: invalid class name */
    /* loaded from: classes9.dex */
    final class AnonymousClass3 implements Runnable {
        AnonymousClass3() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            qb.this.f149754f.c();
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public enum a {
        NETWORK_ERROR(1000),
        INTERNAL_ERROR(1001);


        /* renamed from: c, reason: collision with root package name */
        public final int f149764c;

        a(int i3) {
            this.f149764c = i3;
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static class b implements JsonParser {

        /* renamed from: a, reason: collision with root package name */
        public fz f149765a;

        /* renamed from: b, reason: collision with root package name */
        public JSONArray f149766b;

        /* renamed from: c, reason: collision with root package name */
        public JSONObject f149767c;

        /* renamed from: d, reason: collision with root package name */
        public qg f149768d;

        /* renamed from: e, reason: collision with root package name */
        public int f149769e = sa.f150168c;

        /* renamed from: f, reason: collision with root package name */
        public boolean f149770f;

        /* renamed from: g, reason: collision with root package name */
        public JSONObject f149771g;

        @Override // com.tencent.map.tools.json.JsonParser
        public void parse(JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("cfg");
            this.f149771g = optJSONObject;
            if (optJSONObject != null) {
                this.f149766b = optJSONObject.optJSONObject("custom_map_style").optJSONArray("style_list");
                JSONObject optJSONObject2 = optJSONObject.optJSONObject("indoor_map");
                if (optJSONObject2 != null) {
                    int optInt = optJSONObject2.optInt("enable", -1);
                    int optInt2 = optJSONObject2.optInt("type", -1);
                    if (optInt != -1 && optInt2 != -1) {
                        this.f149765a = new fz(optInt, optInt2, optJSONObject2.optJSONArray("building_list"));
                    }
                }
                JSONObject optJSONObject3 = optJSONObject.optJSONObject("custom_layer");
                boolean z16 = false;
                if (optJSONObject3 != null) {
                    this.f149768d = (qg) JsonUtils.parseToModel(optJSONObject3, qg.class, new Object[0]);
                }
                JSONObject optJSONObject4 = optJSONObject.optJSONObject("event_map");
                if (optJSONObject4 != null) {
                    this.f149769e = optJSONObject4.optInt("enable", sa.f150168c);
                }
                this.f149767c = optJSONObject.optJSONObject("data_layer");
                JSONObject optJSONObject5 = optJSONObject.optJSONObject("l4_render");
                if (optJSONObject5 != null) {
                    if (optJSONObject5.optInt("enable", -1) == 1) {
                        z16 = true;
                    }
                    this.f149770f = z16;
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public interface c extends TencentMap.OnAuthResultCallback {
        void a(b bVar, JSONObject jSONObject);

        void c();
    }

    public qb(Handler handler, String str, String str2, @NonNull c cVar, List<AsyncTask> list) {
        this.f149751c = handler;
        this.f149754f = cVar;
        this.f149752d = TextUtils.isEmpty(str) ? "" : str;
        this.f149753e = TextUtils.isEmpty(str2) ? "" : str2;
        this.f149756h = list;
    }

    @Override // android.os.AsyncTask
    protected final /* synthetic */ Void doInBackground(Object[] objArr) {
        this.f149751c.post(new AnonymousClass3());
        boolean a16 = a();
        if (ho.f148706i == 2) {
            this.f149750b.sendEmptyMessageDelayed(10000, 10000L);
        }
        if (!a16 && this.f149751c != null) {
            gc gcVar = new gc();
            gcVar.f148468f = 3;
            this.f149751c.sendMessage(this.f149751c.obtainMessage(3, gcVar));
            return null;
        }
        return null;
    }

    private boolean a() {
        String str;
        String str2;
        int i3;
        dm dmVar = (dm) cr.a(dm.class);
        if (dmVar == null) {
            this.f149754f.onAuthFail(a.INTERNAL_ERROR.f149764c, "Native environment not ready");
            return false;
        }
        cz czVar = (cz) dmVar.i();
        String a16 = ho.a();
        String str3 = this.f149752d;
        String m3 = ho.m();
        String str4 = this.f149753e;
        String h16 = ho.h();
        String d16 = ho.d();
        int j3 = ho.j();
        String k3 = ho.k();
        String n3 = ho.n();
        String c16 = ho.c();
        String g16 = ho.g();
        if (TextUtils.isEmpty(g16)) {
            str = "0";
        } else {
            str = "wifi".equals(g16) ? "2" : "1";
        }
        NetResponse checkAuth = czVar.checkAuth(a16, str3, m3, str4, h16, d16, j3, k3, n3, c16, str);
        ho.f148707j = Calendar.getInstance().get(1);
        ho.f148708k = Calendar.getInstance().get(2);
        ho.f148709l = Calendar.getInstance().get(5);
        if (checkAuth != null) {
            String str5 = checkAuth.charset;
            if (checkAuth.errorCode != 0) {
                this.f149754f.onAuthFail(a.NETWORK_ERROR.f149764c, "Network resp error[" + checkAuth.errorCode + "]:" + checkAuth.exception);
                return false;
            }
            byte[] bArr = checkAuth.data;
            if (bArr != null && bArr.length > 0) {
                try {
                    JSONObject jSONObject = new JSONObject(new String(bArr, str5));
                    JSONObject optJSONObject = jSONObject.optJSONObject("info");
                    if (optJSONObject != null) {
                        i3 = optJSONObject.optInt("error");
                        str2 = optJSONObject.optString("msg");
                    } else {
                        str2 = null;
                        i3 = 0;
                    }
                    if (i3 != 0) {
                        a(i3, str2);
                        if (i3 < -400) {
                            ho.f148706i = -1;
                        } else {
                            ho.f148706i = 1;
                        }
                        this.f149754f.onAuthFail(i3, str2);
                    } else if (optJSONObject != null) {
                        ho.f148706i = 0;
                        this.f149754f.onAuthSuccess();
                    } else {
                        this.f149754f.onAuthFail(a.NETWORK_ERROR.f149764c, "Network environment error");
                    }
                    this.f149755g = (b) JsonUtils.parseToModel(jSONObject.optJSONObject("detail"), b.class, new Object[0]);
                    this.f149751c.post(new AnonymousClass2(jSONObject));
                    return ho.f148706i == 0;
                } catch (Exception e16) {
                    e16.printStackTrace();
                    this.f149754f.onAuthFail(a.INTERNAL_ERROR.f149764c, "Internal error exception: " + e16.fillInStackTrace().getMessage());
                    return false;
                }
            }
            this.f149754f.onAuthFail(a.NETWORK_ERROR.f149764c, "Network resp data null or 0");
            return false;
        }
        this.f149754f.onAuthFail(a.NETWORK_ERROR.f149764c, "Network resp null");
        return false;
    }

    private static String b() {
        String g16 = ho.g();
        return TextUtils.isEmpty(g16) ? "0" : "wifi".equals(g16) ? "2" : "1";
    }

    private Void c() {
        this.f149751c.post(new AnonymousClass3());
        boolean a16 = a();
        if (ho.f148706i == 2) {
            this.f149750b.sendEmptyMessageDelayed(10000, 10000L);
        }
        if (a16 || this.f149751c == null) {
            return null;
        }
        gc gcVar = new gc();
        gcVar.f148468f = 3;
        this.f149751c.sendMessage(this.f149751c.obtainMessage(3, gcVar));
        return null;
    }

    private Handler d() {
        return this.f149750b;
    }

    private void e() {
        if (this.f149751c != null) {
            gc gcVar = new gc();
            gcVar.f148468f = 3;
            this.f149751c.sendMessage(this.f149751c.obtainMessage(3, gcVar));
        }
    }

    private void b(JSONObject jSONObject) {
        this.f149755g = (b) JsonUtils.parseToModel(jSONObject.optJSONObject("detail"), b.class, new Object[0]);
        this.f149751c.post(new AnonymousClass2(jSONObject));
    }

    private void a(JSONObject jSONObject) {
        String str;
        int i3;
        JSONObject optJSONObject = jSONObject.optJSONObject("info");
        if (optJSONObject != null) {
            i3 = optJSONObject.optInt("error");
            str = optJSONObject.optString("msg");
        } else {
            str = null;
            i3 = 0;
        }
        if (i3 == 0) {
            if (optJSONObject != null) {
                ho.f148706i = 0;
                this.f149754f.onAuthSuccess();
                return;
            } else {
                this.f149754f.onAuthFail(a.NETWORK_ERROR.f149764c, "Network environment error");
                return;
            }
        }
        a(i3, str);
        if (i3 < -400) {
            ho.f148706i = -1;
        } else {
            ho.f148706i = 1;
        }
        this.f149754f.onAuthFail(i3, str);
    }

    private static void a(int i3, String str) {
        ArrayList arrayList = new ArrayList(4);
        arrayList.add("\u817e\u8baf\u5730\u56fe\u9274\u6743\u5931\u8d25\uff0c\u8bf7\u8bbf\u95ee lbs.qq.com \u68c0\u67e5 key \u914d\u7f6e");
        arrayList.add("\u9519\u8bef\u7801\uff1a".concat(String.valueOf(i3)));
        arrayList.add("\u9519\u8bef\u4fe1\u606f\uff1a".concat(String.valueOf(str)));
        StringBuilder sb5 = new StringBuilder(1024);
        sb5.append("Auth Fail:\n");
        char[] cArr = new char[81];
        Arrays.fill(cArr, '*');
        cArr[80] = '\n';
        sb5.append(cArr);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            sb5.append((String) it.next());
            sb5.append("\n");
        }
        sb5.append(cArr);
        Log.e("tencentmap", sb5.toString());
    }
}
