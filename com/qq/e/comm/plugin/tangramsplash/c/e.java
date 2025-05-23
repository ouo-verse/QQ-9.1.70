package com.qq.e.comm.plugin.tangramsplash.c;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.text.TextUtils;
import android.util.SparseArray;
import com.qq.e.comm.adevent.ADEvent;
import com.qq.e.comm.adevent.ADListener;
import com.qq.e.comm.constants.LoadAdParams;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.managers.status.NetworkType;
import com.qq.e.comm.managers.status.SDKStatus;
import com.qq.e.comm.plugin.base.ad.model.r;
import com.qq.e.comm.plugin.base.ad.model.u;
import com.qq.e.comm.plugin.base.ad.model.v;
import com.qq.e.comm.plugin.h.b;
import com.qq.e.comm.plugin.i.h;
import com.qq.e.comm.plugin.k.ac;
import com.qq.e.comm.plugin.k.at;
import com.qq.e.comm.plugin.k.au;
import com.qq.e.comm.plugin.k.g;
import com.qq.e.comm.plugin.k.k;
import com.qq.e.comm.plugin.k.w;
import com.qq.e.comm.plugin.k.y;
import com.qq.e.comm.plugin.router.PublicApi;
import com.qq.e.comm.plugin.router.PublicApiHelper;
import com.qq.e.comm.plugin.stat.StatTracer;
import com.qq.e.comm.plugin.tangramsplash.d.f;
import com.qq.e.comm.plugin.tangramsplash.report.SplashLinkReporter;
import com.qq.e.comm.plugin.tangramsplash.report.c;
import com.qq.e.comm.plugin.tangramsplash.selector.a;
import com.qq.e.comm.plugin.tangramsplash.selector.c;
import com.qq.e.comm.util.GDTLogger;
import com.qq.e.comm.util.SharedPreferencedUtil;
import com.qq.e.tg.splash.image.TGSplashFileUtil;
import com.qzone.publish.business.task.compress.VideoCompressTask;
import com.tencent.ams.fusion.a.i;
import com.tencent.ams.fusion.a.j;
import com.tencent.biz.common.util.WebViewConstants;
import com.tencent.mobileqq.icgame.api.impl.room.report.AudienceReportConst;
import com.tencent.mobileqq.tianshu.data.BusinessInfoCheckUpdateItem;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes3.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    public static final Object f39841a = new Object();

    /* renamed from: b, reason: collision with root package name */
    public static final Object f39842b = new Object();

    /* renamed from: n, reason: collision with root package name */
    private static final e f39843n = new e();

    /* renamed from: c, reason: collision with root package name */
    public volatile ConcurrentHashMap<String, List<r>> f39844c;

    /* renamed from: d, reason: collision with root package name */
    public volatile ConcurrentHashMap<String, List<r>> f39845d;

    /* renamed from: e, reason: collision with root package name */
    public volatile List<r> f39846e;

    /* renamed from: f, reason: collision with root package name */
    public volatile List<r> f39847f;

    /* renamed from: g, reason: collision with root package name */
    public volatile ConcurrentHashMap<String, List<r>> f39848g;

    /* renamed from: h, reason: collision with root package name */
    public volatile ConcurrentHashMap<String, List<r>> f39849h;

    /* renamed from: i, reason: collision with root package name */
    public volatile List<r> f39850i;

    /* renamed from: j, reason: collision with root package name */
    public volatile List<r> f39851j;

    /* renamed from: k, reason: collision with root package name */
    public SparseArray<ADListener> f39852k;

    /* renamed from: l, reason: collision with root package name */
    public com.qq.e.comm.plugin.tangramsplash.d.e f39853l;

    /* renamed from: m, reason: collision with root package name */
    public Handler f39854m;

    /* renamed from: o, reason: collision with root package name */
    private final Handler.Callback f39855o;

    /* renamed from: p, reason: collision with root package name */
    private final AtomicInteger f39856p;

    /* renamed from: q, reason: collision with root package name */
    private final Object f39857q;

    /* renamed from: r, reason: collision with root package name */
    private volatile boolean f39858r;

    /* renamed from: s, reason: collision with root package name */
    private int f39859s;

    /* renamed from: t, reason: collision with root package name */
    private int f39860t;

    /* renamed from: u, reason: collision with root package name */
    private volatile HandlerThread f39861u;

    /* renamed from: v, reason: collision with root package name */
    private List<com.qq.e.comm.plugin.h.c> f39862v;

    e() {
        AtomicInteger atomicInteger = new AtomicInteger();
        this.f39856p = atomicInteger;
        this.f39844c = new ConcurrentHashMap<>();
        this.f39845d = new ConcurrentHashMap<>();
        this.f39846e = new CopyOnWriteArrayList();
        this.f39847f = new CopyOnWriteArrayList();
        this.f39848g = new ConcurrentHashMap<>();
        this.f39849h = new ConcurrentHashMap<>();
        this.f39850i = null;
        this.f39851j = null;
        this.f39857q = new Object();
        this.f39859s = 0;
        this.f39860t = 0;
        this.f39862v = new CopyOnWriteArrayList();
        this.f39853l = new com.qq.e.comm.plugin.tangramsplash.d.e();
        atomicInteger.set(0);
        this.f39855o = new Handler.Callback() { // from class: com.qq.e.comm.plugin.tangramsplash.c.e.1
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                int i3 = message.what;
                boolean z16 = true;
                if (i3 != 1) {
                    if (i3 == 2) {
                        Object obj = message.obj;
                        if (!(obj instanceof Bundle)) {
                            GDTLogger.e("\u9884\u52a0\u8f7d\u6570\u636e\u53c2\u6570\u7c7b\u578b\u9519\u8bef\uff01");
                            e.this.b(100042);
                        } else {
                            Bundle bundle = (Bundle) obj;
                            e.this.a(bundle.getString("posId", ""), bundle.getInt("errorCode", Integer.MIN_VALUE), bundle.getLong("costTime", WebViewConstants.WV.ENABLE_WEBAIO_SWITCH), (String) null, bundle.getBoolean("isHotStart", false));
                        }
                    }
                    e.this.a((LoadAdParams) null, false);
                    return z16;
                }
                Object obj2 = message.obj;
                if (!(obj2 instanceof Bundle)) {
                    GDTLogger.e("\u9884\u52a0\u8f7d\u6570\u636e\u53c2\u6570\u7c7b\u578b\u9519\u8bef\uff01");
                    e.this.b(100042);
                } else {
                    Bundle bundle2 = (Bundle) obj2;
                    com.qq.e.comm.plugin.base.ad.b bVar = (com.qq.e.comm.plugin.base.ad.b) bundle2.getSerializable(QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_AD_TYPE);
                    String string = bundle2.getString("appId", "");
                    String string2 = bundle2.getString("posId", "");
                    String string3 = bundle2.getString("adThreadId", "");
                    long j3 = bundle2.getLong("costTime", WebViewConstants.WV.ENABLE_WEBAIO_SWITCH);
                    String string4 = bundle2.getString("response", "");
                    try {
                        e.this.a(bVar, string, string2, string3, j3, bundle2.getBoolean("isHotStart", false), new JSONObject(string4));
                    } catch (JSONException e16) {
                        GDTLogger.e("\u9884\u52a0\u8f7d\u6570\u636e\u53c2\u6570\u9519\u8bef\uff01" + e16.getMessage());
                        e.this.b(100042);
                    }
                    e.this.a((LoadAdParams) null, false);
                    return z16;
                }
                z16 = false;
                e.this.a((LoadAdParams) null, false);
                return z16;
            }
        };
    }

    private synchronized void b(String str, boolean z16) {
        at.a(at.a(str, z16), "p");
    }

    private void c(boolean z16, r rVar, boolean z17) {
        if (rVar.bI().size() > 0) {
            for (r.a aVar : rVar.bI()) {
                this.f39860t++;
                if (!TextUtils.isEmpty(aVar.f39127c)) {
                    String str = aVar.f39127c;
                    a(rVar, str, str, z17, 1, z16);
                }
                if (!TextUtils.isEmpty(aVar.f39128d)) {
                    a(rVar, aVar.f39128d, (String) null, z17, 2, z16);
                }
            }
        }
    }

    public void a(com.qq.e.comm.plugin.base.ad.b bVar, String str, String str2, String str3, long j3, boolean z16, JSONObject jSONObject) {
        c();
        a(jSONObject, bVar, str, str2, str3, j3, z16);
        a(str2, z16);
        b(str2, z16);
    }

    private void b(com.qq.e.comm.plugin.base.ad.b bVar, String str, String str2, String str3, boolean z16) {
        if (com.qq.e.comm.plugin.j.c.b()) {
            return;
        }
        if (!at.c()) {
            GDTLogger.d("checkPrivateAdnetDirSize disk not full");
        } else if (SDKStatus.getSDKVersionCode() >= 140 && com.qq.e.comm.plugin.j.c.a("clean_splash_material_rule_Config", 0, 1)) {
            at.a(bVar, str, str2, str3, z16);
        } else {
            at.b(bVar, str, str2, str3, z16);
        }
    }

    public void a(c.b bVar, long j3, boolean z16, JSONObject jSONObject) {
        if (bVar == null) {
            return;
        }
        com.qq.e.comm.plugin.tangramsplash.d.b.a();
        a(com.qq.e.comm.plugin.base.ad.b.SPLASH, bVar.f40334a, bVar.f40335b, bVar.f40336c, j3, z16, jSONObject);
        a(bVar, z16);
        c(bVar.f40335b, z16);
    }

    private void c(String str, boolean z16) {
        com.qq.e.comm.plugin.tangramsplash.report.c.a(1310117, str, z16, this.f39859s, this.f39860t);
        this.f39859s = 0;
        this.f39860t = 0;
        a(false, str);
    }

    public void a(c.b bVar, boolean z16) {
        LoadAdParams loadAdParams;
        LoadAdParams loadAdParams2;
        LoadAdParams loadAdParams3;
        boolean z17 = false;
        boolean z18 = !z16 || ((loadAdParams3 = bVar.f40338e) != null && loadAdParams3.isRefreshAdRequest());
        GDTLogger.i("processPreloadResult isHotStart:" + z16 + " canSelect:" + z18);
        if (z18) {
            com.qq.e.comm.plugin.tangramsplash.selector.a aVar = new com.qq.e.comm.plugin.tangramsplash.selector.a(bVar, z16, new a.InterfaceC0294a() { // from class: com.qq.e.comm.plugin.tangramsplash.c.e.2
                @Override // com.qq.e.comm.plugin.tangramsplash.selector.a.InterfaceC0294a
                public void a(String str, int i3, int i16) {
                }

                @Override // com.qq.e.comm.plugin.tangramsplash.selector.a.InterfaceC0294a
                public void a(String str, r rVar) {
                }
            });
            aVar.a((bVar == null || (loadAdParams2 = bVar.f40338e) == null) ? null : loadAdParams2.getAdListener());
            if (z16 && (loadAdParams = bVar.f40338e) != null && loadAdParams.isRefreshAdRequest()) {
                z17 = true;
            }
            aVar.a(z16 ? this.f39847f : this.f39846e, z17 ? 4 : 3);
        }
    }

    private void b(boolean z16, r rVar, boolean z17) {
        String i3 = rVar.i();
        if (!TextUtils.isEmpty(i3)) {
            a(rVar, i3, i3, z17, 1, z16);
        }
        String bE = rVar.bE();
        if (TextUtils.isEmpty(bE)) {
            return;
        }
        a(rVar, bE, (String) null, z17, 2, z16);
    }

    private void c() {
        GDTLogger.d("clearCachedPvLimit");
        i.b();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public List<r> b(String str, String str2, String str3, com.qq.e.comm.plugin.base.ad.b bVar, boolean z16, c.a aVar) {
        int i3;
        int i16;
        List<r> list = null;
        if (!TextUtils.isEmpty(str2)) {
            if (z16) {
                List<r> list2 = this.f39845d.get(str2);
                List<r> list3 = this.f39849h.get(str2);
                if (list2 != null && list2.size() > 0) {
                    GDTLogger.d("\u9009\u5355\u8bfb\u53d6\u5185\u5b58\u7f13\u5b58\uff0c\u70ed\u542f\u52a8\uff1a" + list2.size());
                    i16 = 3;
                } else if (list3 != null && list3.size() > 0) {
                    list2 = new CopyOnWriteArrayList<>(list3);
                    boolean z17 = this.f39858r;
                    GDTLogger.d("\u9009\u5355\u8bfb\u53d6\u5185\u5b58\u7f13\u5b58\uff0c\u70ed\u542f\u52a8\uff1a" + list3.size());
                    i16 = z17;
                }
                int i17 = i16;
                list = list2;
                i3 = i17;
            } else {
                List<r> list4 = this.f39848g.get(str2);
                if (list4 != null && list4.size() > 0) {
                    list = new CopyOnWriteArrayList<>(list4);
                    boolean z18 = this.f39858r;
                    GDTLogger.d("\u9009\u5355\u8bfb\u53d6\u5185\u5b58\u7f13\u5b58\uff0c\u51b7\u542f\u52a8\uff1a" + list4.size());
                    i3 = z18 ? 1 : 0;
                }
            }
            if (list == null && list.size() != 0) {
                GDTLogger.d("\u65e0\u987b\u8bfb\u53d6\u672c\u5730\u6570\u636e\uff0c\u521d\u59cb\u5316\u9636\u6bb5\u6216\u7f51\u7edc\u6062\u590d\u65f6\u5df2\u8bfb\u53d6\uff1a" + this.f39858r);
                com.qq.e.comm.plugin.tangramsplash.report.c.a(1310116, str2, i3, z16);
                return list;
            }
            com.qq.e.comm.plugin.tangramsplash.report.c.a(1310116, str2, 2, z16);
            List<r> a16 = a(str, str2, str3, bVar, z16, aVar);
            GDTLogger.d("\u65e0\u5185\u5b58\u7f13\u5b58\uff0c\u8bfb\u53d6\u6587\u4ef6\u6570\u636e\uff1a" + str2);
            return a16;
        }
        i3 = 2;
        if (list == null) {
        }
        com.qq.e.comm.plugin.tangramsplash.report.c.a(1310116, str2, 2, z16);
        List<r> a162 = a(str, str2, str3, bVar, z16, aVar);
        GDTLogger.d("\u65e0\u5185\u5b58\u7f13\u5b58\uff0c\u8bfb\u53d6\u6587\u4ef6\u6570\u636e\uff1a" + str2);
        return a162;
    }

    public static e a() {
        return f39843n;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(LoadAdParams loadAdParams, boolean z16) {
        if (z16) {
            this.f39856p.incrementAndGet();
            if (this.f39861u == null || !this.f39861u.isAlive()) {
                boolean a16 = com.qq.e.comm.plugin.tangramsplash.d.a.a(loadAdParams);
                StringBuilder sb5 = new StringBuilder();
                sb5.append("AMS-TangramPreloader");
                sb5.append(a16 ? "Hot" : "Cold");
                this.f39861u = new BaseHandlerThread(sb5.toString());
                this.f39861u.start();
                this.f39854m = new Handler(this.f39861u.getLooper(), this.f39855o);
            }
        } else {
            this.f39856p.decrementAndGet();
            if (this.f39861u != null && this.f39861u.isAlive() && this.f39856p.get() == 0) {
                this.f39861u.quit();
                this.f39861u = null;
            }
        }
    }

    public void a(ADListener aDListener, int i3) {
        synchronized (this.f39857q) {
            if (this.f39852k == null) {
                this.f39852k = new SparseArray<>();
            }
            this.f39852k.put(i3, aDListener);
            GDTLogger.d("setPreloadListener :" + i3 + " adListener," + aDListener);
        }
    }

    public void b(int i3) {
        a(1, i3);
    }

    public void a(int i3) {
        if (g.a(this.f39852k)) {
            return;
        }
        synchronized (this.f39857q) {
            GDTLogger.d("removeListener :" + i3);
            this.f39852k.remove(i3);
        }
    }

    public synchronized void b() {
        if (this.f39848g != null) {
            this.f39848g.clear();
        }
        if (this.f39849h != null) {
            this.f39849h.clear();
        }
        if (this.f39850i != null) {
            this.f39850i.clear();
        }
        if (this.f39851j != null) {
            this.f39851j.clear();
        }
        if (this.f39844c != null) {
            this.f39844c.clear();
        }
        if (this.f39845d != null) {
            this.f39845d.clear();
        }
        if (this.f39846e != null) {
            this.f39846e.clear();
        }
        if (this.f39847f != null) {
            this.f39847f.clear();
        }
        com.qq.e.comm.plugin.tangramsplash.d.e eVar = this.f39853l;
        if (eVar != null) {
            eVar.a();
        }
        this.f39854m = null;
    }

    private void a(int i3, int i16) {
        if (g.a(this.f39852k)) {
            return;
        }
        synchronized (this.f39857q) {
            for (int i17 = 0; i17 < this.f39852k.size(); i17++) {
                ADListener valueAt = this.f39852k.valueAt(i17);
                if (valueAt != null) {
                    int keyAt = this.f39852k.keyAt(i17);
                    valueAt.onADEvent(new ADEvent(i3, new Object[]{Integer.valueOf(i16), Integer.valueOf(keyAt)}));
                    GDTLogger.d("adListener.onADEvent :" + i3 + " code," + i16 + " tag," + keyAt);
                }
            }
        }
    }

    public void a(Context context, String str, String str2, LoadAdParams loadAdParams) {
        a(loadAdParams, true);
        GDTLogger.d("\u9884\u52a0\u8f7d\u5f00\u59cb" + str2);
        com.qq.e.comm.plugin.tangramsplash.report.c.a(1310101, str2, com.qq.e.comm.plugin.tangramsplash.report.c.a(WebViewConstants.WV.ENABLE_WEBAIO_SWITCH, 0, Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE, (String) null, com.qq.e.comm.plugin.tangramsplash.d.a.a(loadAdParams)));
        a(context, str2);
        a(com.qq.e.comm.plugin.base.ad.b.SPLASH, str, str2, com.qq.e.comm.plugin.k.a.a(str, str2, ((PublicApi.DeviceInfoApi) PublicApiHelper.getModuleApi(PublicApi.DeviceInfoApi.class)).getDeviceId()), loadAdParams);
    }

    public void a(Context context, String str) {
        String string = SharedPreferencedUtil.getString("splash_pos_id", "");
        if (string != null && !string.contains(str)) {
            if (!"".equals(string)) {
                str = string + "," + str;
            }
            SharedPreferencedUtil.putString("splash_pos_id", str);
        }
        if (f.a(context)) {
            com.qq.e.comm.plugin.tangramsplash.a.c.a().b();
        }
    }

    private void a(com.qq.e.comm.plugin.base.ad.b bVar, String str, String str2, String str3, LoadAdParams loadAdParams) {
        int integer = GDTADManager.getInstance().getSM().getInteger("preloadNetwork", -1);
        NetworkType networkType = GDTADManager.getInstance().getDeviceStatus().getNetworkType();
        if ((integer & networkType.getPermValue()) <= 0) {
            StatTracer.trackEvent(BusinessInfoCheckUpdateItem.UIAPPID_THIRD_PENDANT_DIY, networkType.getPermValue(), (com.qq.e.comm.plugin.stat.b) null);
            a(str2, BusinessInfoCheckUpdateItem.UIAPPID_THIRD_PENDANT_DIY, WebViewConstants.WV.ENABLE_WEBAIO_SWITCH, (String) null, com.qq.e.comm.plugin.tangramsplash.d.a.a(loadAdParams));
            GDTLogger.i("\u5f53\u524d\u8bbe\u5907\u7684\u7f51\u7edc\u7c7b\u578b\u4e0d\u7b26\u5408\u9884\u52a0\u8f7d\u5e7f\u544a\u7684\u6761\u4ef6\uff0c\u8bf7\u5c1d\u8bd5WIFI\u73af\u5883\u3002\u5982\u4ecd\u6709\u95ee\u9898\u8bf7\u8054\u7cfb\u5ba2\u670d");
            return;
        }
        this.f39854m.post(new d(bVar, str, str2, str3, loadAdParams));
    }

    private void a(JSONObject jSONObject, com.qq.e.comm.plugin.base.ad.b bVar, String str, String str2, String str3, long j3, boolean z16) {
        if (z16) {
            this.f39847f.clear();
        } else {
            this.f39846e.clear();
        }
        a(jSONObject, bVar, str, str2, str3, j3, (r) null, z16);
        if (z16) {
            this.f39845d.put(str2, this.f39847f);
        } else {
            this.f39844c.put(str2, this.f39846e);
        }
        a(3, 0);
    }

    private void a(JSONObject jSONObject, com.qq.e.comm.plugin.base.ad.b bVar, String str, String str2, String str3, long j3, r rVar, boolean z16) {
        JSONArray jSONArray;
        boolean z17;
        r rVar2;
        r rVar3;
        int i3;
        JSONArray jSONArray2;
        boolean z18;
        r rVar4;
        JSONArray a16 = a(jSONObject, str2, j3, z16);
        if (y.a(a16)) {
            return;
        }
        List<r> a17 = rVar == null ? a(bVar, str, str2, str3, z16) : null;
        a(bVar, str, str2, str3, a16, z16);
        JSONArray c16 = w.c(a16);
        boolean z19 = false;
        int i16 = 0;
        while (true) {
            if (i16 >= a16.length()) {
                jSONArray = c16;
                break;
            }
            JSONObject optJSONObject = a16.optJSONObject(i16);
            r rVar5 = new r(str, str2, str3, bVar);
            rVar5.e(optJSONObject);
            if (rVar5.ar() && g.a(a17)) {
                GDTLogger.i("isPreloadResponseNeedMerge ad:" + rVar5.bg());
                GDTLogger.i("isPreloadResponseNeedMerge old adArrayLast:" + a17);
                r a18 = a(rVar5, a17);
                a18.f(rVar5.bs());
                a18.o(rVar5.bc());
                a18.p(rVar5.be());
                GDTLogger.i("isPreloadResponseNeedMerge update ad:" + a18.bg());
                w.a(c16, i16, y.a(a18.bg()));
                rVar2 = a18;
                z17 = true;
            } else {
                z17 = z19;
                rVar2 = rVar5;
            }
            if (SharedPreferencedUtil.getInt(rVar2.bn(), -1) != -1) {
                SharedPreferencedUtil.putInt(rVar2.bn(), rVar2.bc());
            }
            this.f39860t++;
            if (TextUtils.isEmpty(rVar2.bw()) || TextUtils.isEmpty(rVar2.bv()) || str2.equals(rVar2.bw())) {
                rVar3 = rVar2;
                i3 = i16;
                jSONArray = c16;
                jSONArray2 = a16;
                z18 = true;
            } else {
                rVar3 = rVar2;
                jSONArray2 = a16;
                z18 = true;
                i3 = i16;
                jSONArray = c16;
                a(jSONObject, bVar, str, rVar2.bw(), str3, j3, rVar3, z16);
            }
            if (z16) {
                rVar4 = rVar3;
                this.f39847f.add(rVar4);
            } else {
                rVar4 = rVar3;
                this.f39846e.add(rVar4);
            }
            if (rVar != null && rVar.bx() == null && rVar4.s().equals(rVar.bw()) && rVar4.bn().equals(rVar.bv())) {
                rVar.a(f.b(rVar4));
                rVar4.q(z18);
                z19 = z17;
                break;
            } else {
                i16 = i3 + 1;
                z19 = z17;
                a16 = jSONArray2;
                c16 = jSONArray;
            }
        }
        if (z19) {
            synchronized (f39841a) {
                try {
                    at.a(at.c(str2, z16), jSONArray.toString());
                    GDTLogger.d("\u9884\u52a0\u8f7d\u5e7f\u544a\u6570\u636e\u5df2\u66f4\u65b0\uff0c\u5199\u5165\u6587\u4ef6\uff1a" + jSONArray.toString());
                } finally {
                }
            }
        }
    }

    private r a(r rVar, List<r> list) {
        if (rVar == null || g.b(list)) {
            return rVar;
        }
        String f16 = rVar.f();
        for (r rVar2 : list) {
            if (rVar2 != null && TextUtils.equals(f16, rVar2.f())) {
                return rVar2;
            }
        }
        return null;
    }

    private List<r> a(com.qq.e.comm.plugin.base.ad.b bVar, String str, String str2, String str3, boolean z16) {
        String a16 = a(str2, z16, false);
        if (TextUtils.isEmpty(a16)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        if (com.qq.e.comm.plugin.j.c.a()) {
            JSONObject a17 = y.a(a16);
            if (!y.a(a17)) {
                return null;
            }
            com.qq.e.comm.plugin.tangramsplash.fusionsdkimpl.a.a(a17, bVar, str, str2, str3, null, arrayList, false);
        }
        return arrayList;
    }

    private JSONArray a(JSONObject jSONObject, String str, long j3, boolean z16) {
        int optInt = jSONObject.optInt("ret");
        if (optInt != 0) {
            StatTracer.trackEvent(BusinessInfoCheckUpdateItem.UIAPPID_WALLET_ACCOUNT_WEILIDAI, optInt, (com.qq.e.comm.plugin.stat.b) null);
            a(str, BusinessInfoCheckUpdateItem.UIAPPID_WALLET_ACCOUNT_WEILIDAI, j3, (String) null, z16);
            return null;
        }
        a(y.f(jSONObject, "req_exp_list"), str);
        JSONObject optJSONObject = jSONObject.optJSONObject("data");
        if (optJSONObject == null) {
            StatTracer.trackEvent(100072, (JSONObject) null, (JSONObject) null);
            a(str, 100072, j3, (String) null, z16);
            return null;
        }
        JSONObject optJSONObject2 = optJSONObject.optJSONObject(str);
        if (optJSONObject2 == null) {
            StatTracer.trackEvent(VideoCompressTask.VIDEO_COMPRESS_RESULT_FILE_NOT_EXIST, (JSONObject) null, (JSONObject) null);
            a(str, VideoCompressTask.VIDEO_COMPRESS_RESULT_FILE_NOT_EXIST, j3, (String) null, z16);
            return null;
        }
        int optInt2 = optJSONObject2.optInt("ret");
        if (optInt2 != 0) {
            StatTracer.trackEvent(100092, optInt2, (com.qq.e.comm.plugin.stat.b) null);
            a(str, 100092, j3, (String) null, z16);
            return null;
        }
        JSONArray optJSONArray = optJSONObject2.optJSONArray("list");
        if (!y.a(optJSONArray)) {
            return optJSONArray;
        }
        StatTracer.trackEvent(AudienceReportConst.EVENT_ID_ENTER_ROOM_FAILURE, optInt2, (com.qq.e.comm.plugin.stat.b) null);
        a(str, AudienceReportConst.EVENT_ID_ENTER_ROOM_FAILURE, j3, (String) null, z16);
        return null;
    }

    private void a(JSONArray jSONArray, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (y.a(jSONArray)) {
            GDTLogger.e("reqExpList null removeExpCache:" + str);
            a(str);
            return;
        }
        GDTLogger.i("refreshExpInfo posId:" + str + " info :" + jSONArray);
        boolean z16 = false;
        int i3 = 0;
        while (true) {
            if (i3 >= jSONArray.length()) {
                break;
            }
            JSONObject a16 = y.a(jSONArray, i3);
            if (y.a(a16) && SharedPreferencedUtil.KEY_CPM_PRIORITY_EXP.equals(y.e(a16, "key"))) {
                SharedPreferencedUtil.putString(str + File.separator + SharedPreferencedUtil.KEY_CPM_PRIORITY_EXP, y.e(a16, "value"));
                z16 = true;
                break;
            }
            i3++;
        }
        GDTLogger.i("refreshExpInfo hitExp:" + z16);
        if (z16) {
            return;
        }
        a(str);
    }

    private static void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        SharedPreferencedUtil.remove(str + File.separator + SharedPreferencedUtil.KEY_CPM_PRIORITY_EXP);
    }

    private void a(com.qq.e.comm.plugin.base.ad.b bVar, String str, String str2, String str3, JSONArray jSONArray, boolean z16) {
        synchronized (f39841a) {
            b(bVar, str, str2, str3, z16);
            try {
                at.a(at.c(str2, z16), jSONArray.toString());
                GDTLogger.d("\u9884\u52a0\u8f7d\u5e7f\u544a\u6570\u636e\u5199\u5165\u6587\u4ef6\uff1a" + str2);
            } catch (Throwable th5) {
                GDTLogger.e("checkAndCachePreLoadDatas write error :", th5);
            }
        }
    }

    public void a(String str, boolean z16) {
        com.qq.e.comm.plugin.stat.c cVar = new com.qq.e.comm.plugin.stat.c();
        if (com.qq.e.comm.plugin.tangramsplash.c.a().a(z16 ? this.f39847f : this.f39846e, z16)) {
            cVar.a("splash_customDownloader", 1);
            GDTLogger.i("DownloadRes by Customer");
        } else {
            cVar.a("splash_customDownloader", 0);
            GDTLogger.i("DownloadRes by SDK");
            if (com.qq.e.comm.plugin.j.c.b()) {
                GDTLogger.d("OpenSplashPreloadResDownloadTask");
            } else {
                a(str, z16 ? this.f39847f : this.f39846e, z16);
            }
        }
        au.a(1310501, str, cVar);
    }

    private void a(String str, List<r> list, boolean z16) {
        for (r rVar : list) {
            if (rVar != null) {
                a(rVar, z16, rVar.y());
                if (rVar.bi()) {
                    a(z16, rVar, true);
                }
                v H = rVar.H(1);
                if (H != null) {
                    a(rVar, H.b(), H.b(), true, 4, z16);
                }
                v H2 = rVar.H(3);
                if (H2 != null) {
                    a(rVar, H2.b(), H2.b(), true, 4, z16);
                }
                if (rVar.bI() != null) {
                    c(z16, rVar, true);
                }
                if (!TextUtils.isEmpty(com.qq.e.comm.plugin.tangramsplash.interactive.e.a(rVar))) {
                    a(rVar, com.qq.e.comm.plugin.tangramsplash.interactive.e.a(rVar), (String) null, true, 2, z16);
                }
                if (!TextUtils.isEmpty(com.qq.e.comm.plugin.tangramsplash.interactive.e.b(rVar))) {
                    a(rVar, com.qq.e.comm.plugin.tangramsplash.interactive.e.b(rVar), (String) null, true, 1, z16);
                }
                if (!TextUtils.isEmpty(com.qq.e.comm.plugin.tangramsplash.interactive.e.c(rVar))) {
                    a(rVar, com.qq.e.comm.plugin.tangramsplash.interactive.e.c(rVar), (String) null, false, 1, z16);
                }
                if (!TextUtils.isEmpty(com.qq.e.comm.plugin.tangramsplash.interactive.e.d(rVar))) {
                    a(rVar, com.qq.e.comm.plugin.tangramsplash.interactive.e.d(rVar), (String) null, true, 3, z16);
                }
                if (rVar.bJ() != null) {
                    String u16 = rVar.bJ().u();
                    if (!TextUtils.isEmpty(u16)) {
                        a(rVar, u16, u16, true, 1, z16);
                    }
                    List<String> aZ = rVar.aZ();
                    if (!j.b(aZ)) {
                        for (String str2 : aZ) {
                            if (!TextUtils.isEmpty(str2)) {
                                a(rVar, str2, str2, true, 1, z16);
                            }
                        }
                    }
                }
                if (rVar.bG()) {
                    b(z16, rVar, true);
                }
                List<String> T = rVar.T();
                if (T != null && T.size() > 0) {
                    for (String str3 : T) {
                        if (!TextUtils.isEmpty(str3)) {
                            a(rVar, str3, str3, true, 1, z16);
                        }
                    }
                }
                JSONObject bV = rVar.bV();
                if (y.a(bV)) {
                    JSONArray f16 = y.f(bV, "image_list");
                    if (!w.a(f16)) {
                        for (int i3 = 0; i3 < f16.length(); i3++) {
                            String a16 = w.a(f16, i3, "");
                            if (!TextUtils.isEmpty(a16)) {
                                GDTLogger.d("download image animation src url :" + a16);
                                a(rVar, a16, a16, true, 1, z16);
                            }
                        }
                    }
                }
            }
        }
    }

    private void a(r rVar, boolean z16, String str) {
        boolean by = rVar.by();
        int w3 = rVar.w();
        if (w3 == 0) {
            a(rVar, rVar.h(), rVar.h(), true, by ? 6 : 1, z16);
        } else {
            if (w3 != 1) {
                return;
            }
            a(rVar, rVar.h(), rVar.h(), true, by ? 6 : 1, z16);
            a(rVar, rVar.x(), rVar.bt(), true, by ? 7 : 2, z16);
        }
    }

    private void a(boolean z16, r rVar, boolean z17) {
        if (rVar == null) {
            return;
        }
        String i3 = rVar.i();
        if (!TextUtils.isEmpty(i3)) {
            a(rVar, i3, i3, z17, 6, z16);
        }
        r bx4 = rVar.bx();
        if (bx4 == null) {
            return;
        }
        a(bx4, bx4.ad(), bx4.bu(), z17, 5, z16);
    }

    public void a(r rVar, String str, String str2, boolean z16, int i3, boolean z17) {
        if (rVar == null) {
            return;
        }
        a(str, str2, z16, i3, z17, rVar.s(), rVar.y(), rVar.f(), rVar.ah(), rVar.ai(), rVar.aj(), rVar.ak(), rVar.al());
    }

    public void a(String str, String str2, boolean z16, int i3, boolean z17, String str3, String str4, String str5, boolean z18, long j3, long j16, String str6) {
        a(str, str2, z16, i3, z17, str3, str4, str5, z18, false, j3, j16, str6);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void a(String str, String str2, boolean z16, int i3, boolean z17, String str3, String str4, String str5, boolean z18, boolean z19, long j3, long j16, String str6) {
        String str7;
        byte b16;
        String c16;
        String str8;
        byte b17;
        String str9;
        String str10;
        e eVar;
        int i16;
        if (i3 == 2 || i3 == 5) {
            str7 = str2;
            b16 = true;
        } else {
            str7 = null;
            b16 = false;
        }
        if (TextUtils.isEmpty(str3) || TextUtils.isEmpty(str)) {
            return;
        }
        if (z16 && ac.b()) {
            com.qq.e.comm.plugin.tangramsplash.report.c.a(1310109, str3, com.qq.e.comm.plugin.tangramsplash.report.c.a(WebViewConstants.WV.ENABLE_WEBAIO_SWITCH, 9, Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE, (String) null, z17));
            return;
        }
        if (i3 == 3 && at.d(at.a(str3, str))) {
            a(str3, str6, 1310104, WebViewConstants.WV.ENABLE_WEBAIO_SWITCH, 1, 3, null, str5, z17, 0L, Integer.MIN_VALUE, null, Integer.MIN_VALUE, false);
            return;
        }
        if (i3 == 4) {
            a(str, i3, z17, str3, str4, str5, z18, z19, j3, j16, str6);
            return;
        }
        File a16 = at.a(b16 != false ? 2 : 1, str3, TextUtils.isEmpty(str2) ? str : str2);
        GDTLogger.i("isHotStart " + z17);
        GDTLogger.i("\u51c6\u5907\u7f13\u5b58 url " + str);
        if (a16 != null && a16.exists()) {
            GDTLogger.i("\u51c6\u5907\u7f13\u5b58 fileName " + a16.getAbsolutePath());
            GDTLogger.i("\u95ea\u5c4f\u8d44\u6e90\u5df2\u7ecf\u7f13\u5b58\u5728");
            SplashLinkReporter.a(7000034, str3, str5, i3, str4);
            this.f39859s = this.f39859s + 1;
            a(str3, str6, 1310104, WebViewConstants.WV.ENABLE_WEBAIO_SWITCH, 1, i3, null, str5, z17, 0L, Integer.MIN_VALUE, null, Integer.MIN_VALUE, false);
            return;
        }
        if (TextUtils.isEmpty(str2)) {
            c16 = at.c(str);
        } else {
            c16 = at.c(str2);
        }
        String str11 = c16;
        h a17 = new h.a().c(str).a(at.a(str3)).b(str6).a(str11).a();
        if (z18 && com.qq.e.comm.plugin.h.d.b()) {
            if (i3 == 3) {
                i16 = 3;
            } else {
                i16 = b16 != false ? 2 : 1;
            }
            str8 = str11;
            b17 = 2;
            a(str5, str3, str, i16, z17, j16, j3, str4, str7, str8, a17, (com.tencent.ams.fusion.service.resdownload.a) null, z19);
            eVar = this;
            str9 = str3;
            str10 = str5;
        } else {
            str8 = str11;
            b17 = 2;
            GDTLogger.d("start normal download :" + a17.c());
            com.qq.e.comm.plugin.i.f.a(GDTADManager.getInstance().getAppContext()).a(a17, str, new b(a17, i3, str3, str7, str5, z17, str4));
            str9 = str3;
            str10 = str5;
            SplashLinkReporter.b(7000030, str9, str10, i3, str4);
            eVar = this;
        }
        eVar.f39853l.a(str8);
        Map<String, String> a18 = com.qq.e.comm.plugin.tangramsplash.report.c.a(WebViewConstants.WV.ENABLE_WEBAIO_SWITCH, Integer.MIN_VALUE, Integer.MIN_VALUE, 1, i3, str, z17, 0, Integer.MIN_VALUE);
        String[] strArr = new String[3];
        strArr[0] = str10;
        strArr[1] = null;
        strArr[b17] = str6;
        com.qq.e.comm.plugin.tangramsplash.report.c.a(1310106, z18 ? 1 : 0, str9, com.qq.e.comm.plugin.tangramsplash.report.c.a(a18, strArr));
    }

    public void a(String str, String str2, String str3, int i3, boolean z16, long j3, long j16, String str4, String str5, String str6, h hVar, com.tencent.ams.fusion.service.resdownload.a aVar, boolean z17) {
        if (hVar != null && hVar.a() != null) {
            a aVar2 = new a(hVar, i3, str2, str5, str, z16, str4, 0, false, false);
            aVar2.a(aVar);
            WeakReference<com.qq.e.comm.plugin.h.c> weakReference = new WeakReference<>(aVar2);
            this.f39862v.add(aVar2);
            com.qq.e.comm.plugin.h.b a16 = new b.a().a(str3).b(str6).d(str2).c(hVar.a().getAbsolutePath()).a(j3).b(j16).a(i3).a(weakReference).a(z17).a();
            GDTLogger.i("PcdnSDKManager start download :" + str3);
            com.qq.e.comm.plugin.h.d.a().a(a16);
            return;
        }
        GDTLogger.e("PcdnSDKManager startPcdnDownload request invalid.");
    }

    public void a(com.qq.e.comm.plugin.h.c cVar) {
        this.f39862v.remove(cVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void a(String str, int i3, boolean z16, String str2, String str3, String str4, boolean z17, boolean z18, long j3, long j16, String str5) {
        String str6;
        byte b16;
        String str7;
        String str8;
        e eVar;
        File b17 = at.b(str);
        int a16 = com.qq.e.comm.plugin.j.c.a(str2, "splashButtonUrlTtl", 86400000);
        if (b17 != null && b17.exists() && System.currentTimeMillis() - b17.lastModified() < a16) {
            com.qq.e.comm.plugin.tangramsplash.report.c.a(1310117, str2, com.qq.e.comm.plugin.tangramsplash.report.c.a(com.qq.e.comm.plugin.tangramsplash.report.c.a(WebViewConstants.WV.ENABLE_WEBAIO_SWITCH, Integer.MIN_VALUE, Integer.MIN_VALUE, 1, i3, str, z16, 0, Integer.MIN_VALUE), str4));
            return;
        }
        String c16 = at.c(str, ".png");
        h a17 = new h.a().c(str).a(at.b()).a(c16).a();
        if (z17) {
            str6 = c16;
            b16 = 1;
            a(str4, str2, str, 1, z16, j16, j3, str3, (String) null, str6, a17, (com.tencent.ams.fusion.service.resdownload.a) null, z18);
            eVar = this;
            str7 = str2;
            str8 = str4;
        } else {
            str6 = c16;
            b16 = 1;
            GDTLogger.d("start normal download :" + a17.c());
            com.qq.e.comm.plugin.i.f.a(GDTADManager.getInstance().getAppContext()).a(a17, str, new b(a17, i3, str2, null, str4, z16, str3));
            str7 = str2;
            str8 = str4;
            SplashLinkReporter.b(7000030, str7, str8, i3, str3);
            eVar = this;
        }
        eVar.f39853l.a(str6);
        Map<String, String> a18 = com.qq.e.comm.plugin.tangramsplash.report.c.a(WebViewConstants.WV.ENABLE_WEBAIO_SWITCH, Integer.MIN_VALUE, Integer.MIN_VALUE, 1, i3, str, z16, 0, Integer.MIN_VALUE);
        String[] strArr = new String[3];
        strArr[0] = str8;
        strArr[b16] = null;
        strArr[2] = str5;
        com.qq.e.comm.plugin.tangramsplash.report.c.a(1310106, z17 ? 1 : 0, str7, com.qq.e.comm.plugin.tangramsplash.report.c.a(a18, strArr));
    }

    public List<r> a(String str, String str2, String str3, com.qq.e.comm.plugin.base.ad.b bVar, boolean z16, c.a aVar) {
        return a(str, str2, str3, bVar, (r) null, z16, aVar, false);
    }

    public List<r> a(String str, String str2, String str3, com.qq.e.comm.plugin.base.ad.b bVar, boolean z16, c.a aVar, boolean z17) {
        return a(str, str2, str3, bVar, (r) null, z16, aVar, z17);
    }

    public List<r> a(String str, String str2, String str3, com.qq.e.comm.plugin.base.ad.b bVar, r rVar, boolean z16, c.a aVar, boolean z17) {
        String str4;
        JSONArray jSONArray;
        ArrayList arrayList;
        r rVar2;
        int i3;
        boolean z18 = rVar == null;
        if (TextUtils.isEmpty(str2)) {
            aVar.a(z18, 10);
            return null;
        }
        long currentTimeMillis = System.currentTimeMillis();
        String a16 = a(str2, z16, z17);
        if (TextUtils.isEmpty(a16)) {
            aVar.a(z18, 11);
            return null;
        }
        if (z17) {
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            str4 = a16;
            com.qq.e.comm.plugin.tangramsplash.report.c.a(1310115, str2, this.f39858r ? 1 : 0, currentTimeMillis2, z16);
        } else {
            str4 = a16;
        }
        ArrayList arrayList2 = new ArrayList();
        if (com.qq.e.comm.plugin.j.c.a()) {
            JSONObject a17 = y.a(str4);
            if (!y.a(a17)) {
                aVar.a(z18, 12);
                return null;
            }
            com.qq.e.comm.plugin.tangramsplash.fusionsdkimpl.a.a(a17, com.qq.e.comm.plugin.base.ad.b.SPLASH, str, str2, str3, null, arrayList2, false);
            return arrayList2;
        }
        try {
            jSONArray = new JSONArray(str4);
        } catch (Exception e16) {
            GDTLogger.e("preload ad info error : " + e16);
            jSONArray = null;
        }
        if (jSONArray != null && jSONArray.length() > 0) {
            int i16 = 0;
            while (i16 < jSONArray.length()) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i16);
                r rVar3 = new r(str, str2, str3, bVar);
                rVar3.e(optJSONObject);
                arrayList2.add(rVar3);
                if (TextUtils.isEmpty(rVar3.bw()) || TextUtils.isEmpty(rVar3.bv()) || str2.equals(rVar3.bw())) {
                    arrayList = arrayList2;
                    rVar2 = rVar3;
                    i3 = i16;
                } else {
                    arrayList = arrayList2;
                    rVar2 = rVar3;
                    i3 = i16;
                    a(str, rVar3.bw(), str3, bVar, rVar3, z16, aVar, z17);
                }
                if (rVar != null && rVar.bx() == null && rVar2.s().equals(rVar.bw()) && rVar2.bn().equals(rVar.bv())) {
                    rVar.a(rVar2);
                    return arrayList;
                }
                i16 = i3 + 1;
                arrayList2 = arrayList;
            }
            return arrayList2;
        }
        aVar.a(z18, 12);
        return null;
    }

    private String a(String str, boolean z16, boolean z17) {
        String c16;
        if (TextUtils.isEmpty(str)) {
            GDTLogger.e("[getOriginPreloadDataString] return null, empty posId");
            return null;
        }
        synchronized (f39841a) {
            if (com.qq.e.comm.plugin.j.c.a()) {
                StringBuilder sb5 = new StringBuilder(str);
                String str2 = File.separator;
                sb5.append(str2);
                sb5.append(z16 ? "hot" : TGSplashFileUtil.PRELOAD_CACHE_DIR_COLD);
                sb5.append(str2);
                sb5.append("preload");
                c16 = k.d(new File(k.a(), sb5.toString()));
            } else {
                c16 = at.c(at.c(str, z16));
            }
            if (z17) {
                GDTLogger.d("SDK\u521d\u59cb\u5316\u8bfb\u53d6\u672c\u5730\u9884\u52a0\u8f7d\u6570\u636e");
            } else {
                GDTLogger.d("\u9009\u5355\u8bfb\u53d6\u672c\u5730\u9884\u52a0\u8f7d\u6570\u636e");
            }
        }
        return c16;
    }

    public SparseArray<r> a(List<r> list, String str) {
        List<u> list2;
        if (list == null || list.size() <= 0) {
            return null;
        }
        SparseArray<r> sparseArray = new SparseArray<>();
        for (r rVar : list) {
            if (rVar != null) {
                if (TextUtils.isEmpty(str)) {
                    list2 = rVar.bs();
                } else {
                    Map<String, List<u>> cg5 = rVar.cg();
                    list2 = cg5 != null ? cg5.get(str) : null;
                }
                if (list2 != null && list2.size() > 0) {
                    Iterator<u> it = list2.iterator();
                    while (it.hasNext()) {
                        List<Integer> c16 = it.next().c();
                        if (c16 != null && c16.size() > 0) {
                            Iterator<Integer> it5 = c16.iterator();
                            while (it5.hasNext()) {
                                sparseArray.put(it5.next().intValue(), rVar);
                            }
                        }
                    }
                }
            }
        }
        return sparseArray;
    }

    public void a(String str, int i3, long j3, String str2, boolean z16) {
        b(i3);
        int i16 = 1310103;
        switch (i3) {
            case BusinessInfoCheckUpdateItem.UIAPPID_THIRD_PENDANT_DIY /* 100052 */:
                i16 = 1310105;
                i3 = 0;
                break;
            case BusinessInfoCheckUpdateItem.UIAPPID_WALLET_ACCOUNT_WEILIDAI /* 100062 */:
                i3 = 1;
                break;
            case 100072:
                i3 = 2;
                break;
            case VideoCompressTask.VIDEO_COMPRESS_RESULT_FILE_NOT_EXIST /* 100082 */:
                i3 = 3;
                break;
            case 100092:
                i3 = 4;
                break;
            case AudienceReportConst.EVENT_ID_ENTER_ROOM_FAILURE /* 100102 */:
                i3 = 5;
                break;
        }
        int i17 = i3;
        GDTLogger.e("\u9884\u52a0\u8f7d\u9519\u8bef\uff1aeventId" + i16 + "finalErrorCode:" + i17);
        com.qq.e.comm.plugin.tangramsplash.report.c.a(i16, str, com.qq.e.comm.plugin.tangramsplash.report.c.a(j3, i17, Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE, str2, z16));
    }

    public void a(String str, String str2, int i3, long j3, int i16, int i17, String str3, String str4, boolean z16, long j16, int i18, String str5, int i19, boolean z17) {
        a(0, str, str2, i3, j3, i16, i17, str3, str4, z16, j16, i18, str5, i19, z17);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public void a(int i3, String str, String str2, int i16, long j3, int i17, int i18, String str3, String str4, boolean z16, long j16, int i19, String str5, int i26, boolean z17) {
        int i27;
        int i28 = 1310108;
        int i29 = Integer.MIN_VALUE;
        switch (i16) {
            case 7:
                i29 = 7;
                i27 = i29;
                break;
            case 8:
                i29 = 8;
                i27 = i29;
                break;
            case 1310104:
                i28 = 1310104;
                i29 = 6;
                i27 = i29;
                break;
            case 1310107:
                i28 = 1310107;
                i27 = i29;
                break;
            case 1310108:
                i27 = i29;
                break;
            case 1310119:
                i28 = 1310119;
                i27 = i29;
                break;
            case 1310120:
                i28 = 1310120;
                i27 = i29;
                break;
            case 1310122:
                i28 = 1310122;
                i27 = i29;
                break;
            case 1310123:
                i28 = 1310123;
                i27 = i29;
                break;
            default:
                i28 = Integer.MIN_VALUE;
                i27 = Integer.MIN_VALUE;
                break;
        }
        com.qq.e.comm.plugin.tangramsplash.report.c.a(i28, i3, str, com.qq.e.comm.plugin.tangramsplash.report.c.a(com.qq.e.comm.plugin.tangramsplash.report.c.a(j3, i27, Integer.MIN_VALUE, i17, i18, str3, z16, 0, i19, str5, i26, z17), str4, String.valueOf(j16 / 1024), str2));
    }

    public void a(List<r> list, String str, boolean z16, boolean z17) {
        GDTLogger.e("\u6bcf\u65e5\u9996\u6b21\u7f51\u7edc\u6062\u590d\u6216sdk\u521d\u59cb\u5316\u540e\uff0c\u68c0\u6d4b\u5230\u95ea\u5c4f\u7d20\u6750\u65f6\uff0c\u4f20\u5165:" + z16 + ",netWorkChange:" + z17);
        this.f39858r = z17;
        if (z16) {
            this.f39851j = new CopyOnWriteArrayList(list);
            this.f39849h.put(str, list);
        } else {
            this.f39850i = new CopyOnWriteArrayList(list);
            this.f39848g.put(str, list);
        }
    }

    public void a(boolean z16, String str) {
        GDTLogger.e("\u6e05\u7406\u9884\u52a0\u8f7d\u7f13\u5b58:" + z16 + ",netWorkChange:" + this.f39858r + ", posId:" + str);
        synchronized (f39842b) {
            if (z16) {
                if (this.f39851j != null) {
                    this.f39851j.clear();
                    this.f39851j = null;
                }
                if (this.f39847f != null) {
                    this.f39847f.clear();
                }
                if (!TextUtils.isEmpty(str)) {
                    this.f39849h.remove(str);
                    this.f39845d.remove(str);
                }
            } else {
                if (this.f39850i != null) {
                    this.f39850i.clear();
                    this.f39850i = null;
                }
                if (this.f39846e != null) {
                    this.f39846e.clear();
                }
                if (!TextUtils.isEmpty(str)) {
                    this.f39848g.remove(str);
                    this.f39844c.remove(str);
                }
            }
        }
    }
}
