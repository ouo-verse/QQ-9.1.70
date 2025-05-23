package com.qq.e.comm.plugin.h;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.managers.setting.SM;
import com.qq.e.comm.managers.status.SDKStatus;
import com.qq.e.comm.managers.thread.GdtSDKThreadManager;
import com.qq.e.comm.plugin.k.ad;
import com.qq.e.comm.plugin.k.g;
import com.qq.e.comm.plugin.k.k;
import com.qq.e.comm.plugin.k.l;
import com.qq.e.comm.util.GDTLogger;
import com.qq.e.tg.tangram.TangramAdManager;
import com.tencent.gamematrix.gmcg.api.constant.GmCgConstants;
import com.tencent.qqnt.kernel.nativeinterface.FileBridgeSearchErrorCode;
import java.io.File;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes3.dex */
public class d {

    /* renamed from: c, reason: collision with root package name */
    private static volatile d f39437c;

    /* renamed from: d, reason: collision with root package name */
    private Object f39440d = null;

    /* renamed from: e, reason: collision with root package name */
    private Class f39441e = null;

    /* renamed from: f, reason: collision with root package name */
    private Class f39442f = null;

    /* renamed from: g, reason: collision with root package name */
    private Class f39443g = null;

    /* renamed from: h, reason: collision with root package name */
    private Class f39444h = null;

    /* renamed from: i, reason: collision with root package name */
    private Class f39445i = null;

    /* renamed from: j, reason: collision with root package name */
    private Field f39446j = null;

    /* renamed from: k, reason: collision with root package name */
    private Field f39447k = null;

    /* renamed from: l, reason: collision with root package name */
    private Field f39448l = null;

    /* renamed from: m, reason: collision with root package name */
    private Field f39449m = null;

    /* renamed from: n, reason: collision with root package name */
    private Field f39450n = null;

    /* renamed from: o, reason: collision with root package name */
    private Field f39451o = null;

    /* renamed from: p, reason: collision with root package name */
    private Field f39452p = null;

    /* renamed from: a, reason: collision with root package name */
    protected ConcurrentHashMap<String, List<WeakReference<c>>> f39438a = new ConcurrentHashMap<>();

    /* renamed from: b, reason: collision with root package name */
    protected ConcurrentHashMap<String, Boolean> f39439b = new ConcurrentHashMap<>();

    d() {
        c();
    }

    public static boolean b() {
        SM sm5 = GDTADManager.getInstance().getSM();
        if (sm5 == null) {
            return false;
        }
        return (l.a("com.tencent.thumbplayer.core.downloadproxy.api.TPDownloadProxy") == null || TextUtils.isEmpty(sm5.getString("pcdn_platform"))) ? false : true;
    }

    private void c() {
        GdtSDKThreadManager.getInstance().runOnThread(1, new Runnable() { // from class: com.qq.e.comm.plugin.h.d.1
            @Override // java.lang.Runnable
            public void run() {
                if (d.this.f39442f == null) {
                    d.this.f39442f = l.a("com.tencent.thumbplayer.core.downloadproxy.api.TPDLProxyInitParam");
                }
                if (d.this.f39441e == null) {
                    d.this.f39441e = l.a("com.tencent.thumbplayer.core.downloadproxy.api.TPDownloadProxy");
                    if (d.this.d() < 0) {
                        GDTLogger.e("PcdnSDKManager  initDownloadProxy error.");
                        return;
                    }
                }
                if (d.this.f39443g == null) {
                    d.this.f39443g = l.a("com.tencent.thumbplayer.core.downloadproxy.api.TPDownloadParam");
                }
                if (d.this.f39444h == null) {
                    d.this.f39444h = l.a("com.tencent.thumbplayer.core.downloadproxy.api.TPDownloadProxyEnum");
                }
                if (d.this.f39445i == null) {
                    d.this.f39445i = l.a("com.tencent.thumbplayer.core.downloadproxy.api.ITPPreLoadListener");
                }
                if (d.this.f39446j == null) {
                    d dVar = d.this;
                    dVar.f39446j = l.a(dVar.f39444h, "DLTYPE_MP4_VOD");
                }
                if (d.this.f39447k == null) {
                    d dVar2 = d.this;
                    dVar2.f39447k = l.a(dVar2.f39444h, "DLTYPE_FILE_DOWNLOAD");
                }
                if (d.this.f39448l == null) {
                    d dVar3 = d.this;
                    dVar3.f39448l = l.a(dVar3.f39444h, "DLPARAM_PRELOAD_SIZE");
                }
                if (d.this.f39449m == null) {
                    d dVar4 = d.this;
                    dVar4.f39449m = l.a(dVar4.f39444h, "DLPARAM_ENABLE_TEG_PCDN");
                }
                if (d.this.f39450n == null) {
                    d dVar5 = d.this;
                    dVar5.f39450n = l.a(dVar5.f39444h, "DLPARAM_VINFO_FP2P");
                }
                if (d.this.f39451o == null) {
                    d dVar6 = d.this;
                    dVar6.f39451o = l.a(dVar6.f39444h, "DLPARAM_SAVE_PATH");
                }
                if (d.this.f39452p == null) {
                    d dVar7 = d.this;
                    dVar7.f39452p = l.a(dVar7.f39444h, "DLPARAM_PCDN_CHARGE_ID");
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int d() {
        Object obj;
        Object obj2;
        Class cls = this.f39441e;
        Class cls2 = Integer.TYPE;
        Constructor a16 = l.a(cls, cls2);
        if (a16 != null) {
            this.f39440d = l.a(a16, Integer.valueOf(FileBridgeSearchErrorCode.SEARCH_UNNKOWN));
        }
        Constructor a17 = l.a(this.f39442f, cls2, String.class, String.class, String.class, String.class, String.class);
        if (a17 != null) {
            int a18 = ad.a(GDTADManager.getInstance().getSM().getString("pcdn_platform"), -1);
            if (a18 < 0) {
                return a18;
            }
            Pair<String, String> taidAndOaid = TangramAdManager.getInstance().getAdActionTrigger().getTaidAndOaid();
            Object[] objArr = new Object[6];
            objArr[0] = Integer.valueOf(a18);
            objArr[1] = SDKStatus.getIntegrationSDKVersion();
            objArr[2] = taidAndOaid != null ? (String) taidAndOaid.second : "";
            objArr[3] = "";
            objArr[4] = k.f().getAbsolutePath();
            objArr[5] = "{\"VodCacheEnable\":true,\"PrepareDownloadGoPcdn\":true,\"PCDNFileEnable\":true}";
            obj = l.a(a17, objArr);
        } else {
            obj = null;
        }
        Method a19 = l.a(this.f39441e, "init", Context.class, this.f39442f);
        if (a19 == null || obj == null || (obj2 = this.f39440d) == null) {
            return -1;
        }
        return l.a(obj2, a19, GDTADManager.getInstance().getAppContext(), obj) == null ? -1 : 0;
    }

    private boolean c(b bVar) {
        if (bVar != null && bVar.h()) {
            if (new File(bVar.c(), bVar.b()).exists()) {
                bVar.d().get().a(bVar.a());
                return true;
            }
            if (!this.f39438a.containsKey(bVar.a())) {
                return false;
            }
            List<WeakReference<c>> list = this.f39438a.get(bVar.a());
            if (!g.a(list)) {
                return true;
            }
            list.add(bVar.d());
            GDTLogger.d("PcdnSDKManager append listener :" + bVar.a() + " size :" + list.size());
            return true;
        }
        GDTLogger.e("PcdnSDKManager filterUrlAndListener pcdnDownloadParam == null || !pcdnDownloadParam.isValid()");
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(List<WeakReference<c>> list, String str) {
        if (g.b(list)) {
            return;
        }
        GDTLogger.d("PcdnSDKManager callbackCompleted :" + str + " callback count :" + list.size());
        for (WeakReference<c> weakReference : list) {
            if (weakReference != null && weakReference.get() != null) {
                GDTLogger.d("PcdnSDKManager onCompleted :" + str);
                weakReference.get().a(str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(b bVar) {
        if (bVar != null && bVar.h()) {
            Class cls = this.f39443g;
            Class cls2 = this.f39441e;
            Class cls3 = this.f39445i;
            if (cls != null && cls2 != null && cls3 != null) {
                if (c(bVar)) {
                    GDTLogger.e("PcdnSDKManager filterUrlAndListener file is downloading " + bVar.a());
                    return;
                }
                Object a16 = a(cls, bVar);
                if (a16 != null) {
                    a(bVar.a(), bVar.d());
                    Method a17 = l.a(cls2, "startPreload", String.class, cls, cls3);
                    if (a17 != null) {
                        Object a18 = l.a(this.f39440d, a17, bVar.b(), a16, Proxy.newProxyInstance(d.class.getClassLoader(), new Class[]{cls3}, new a(new WeakReference(this), bVar.a())));
                        if (a18 instanceof Integer) {
                            a(bVar, ((Integer) a18).intValue());
                            return;
                        } else {
                            bVar.d().get().a(bVar.a(), 100001, null);
                            return;
                        }
                    }
                    return;
                }
                bVar.d().get().a(bVar.a(), 100000, null);
                return;
            }
            GDTLogger.e("PcdnSDKManager class not found error.");
            bVar.d().get().a(bVar.a(), 100000, null);
            return;
        }
        GDTLogger.e("PcdnSDKManager pcdnDownloadParam == null || !pcdnDownloadParam.isValid()");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(List<WeakReference<c>> list, int i3, String str, String str2) {
        if (g.b(list)) {
            return;
        }
        GDTLogger.i("PcdnSDKManager callbackError :" + i3);
        for (WeakReference<c> weakReference : list) {
            if (weakReference != null && weakReference.get() != null) {
                weakReference.get().a(str2, i3, str);
            }
        }
    }

    protected void a(List<WeakReference<c>> list, int i3, String str) {
        if (g.b(list)) {
            return;
        }
        for (WeakReference<c> weakReference : list) {
            if (weakReference != null && weakReference.get() != null) {
                weakReference.get().a(str, i3);
            }
        }
        GDTLogger.i("PcdnSDKManager callbackTimeout clean cache." + i3);
        a(str);
    }

    private void a(String str) {
        this.f39439b.remove(str);
        this.f39438a.remove(str);
    }

    public static d a() {
        if (f39437c == null) {
            synchronized (d.class) {
                if (f39437c == null) {
                    f39437c = new d();
                }
            }
        }
        return f39437c;
    }

    public void a(final b bVar) {
        GdtSDKThreadManager.getInstance().runOnThread(2, new Runnable() { // from class: com.qq.e.comm.plugin.h.d.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    d.this.b(bVar);
                } catch (Throwable th5) {
                    GDTLogger.e("PcdnSDKManager invokePCDNSDKPreload error :", th5);
                }
            }
        });
    }

    private void a(final b bVar, final int i3) {
        if (bVar != null && bVar.h()) {
            long e16 = bVar.e();
            GdtSDKThreadManager.getInstance().runOnThread(3, new Runnable() { // from class: com.qq.e.comm.plugin.h.d.3
                @Override // java.lang.Runnable
                public void run() {
                    Boolean bool = d.this.f39439b.get(bVar.a());
                    if (bool == null || !bool.booleanValue()) {
                        d.this.a(i3, bVar.c(), bVar.b(), bVar.a(), 1);
                    } else {
                        GDTLogger.i("pcdn downloading wait for safe time out.");
                    }
                }
            }, bVar.f());
            GdtSDKThreadManager.getInstance().runOnThread(3, new Runnable() { // from class: com.qq.e.comm.plugin.h.d.4
                @Override // java.lang.Runnable
                public void run() {
                    d.this.a(i3, bVar.c(), bVar.b(), bVar.a(), 2);
                }
            }, e16);
            return;
        }
        GDTLogger.e("PcdnSDKManager setupSrcCheckTimer pcdnDownloadParam == null || !pcdnDownloadParam.isValid()");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i3, String str, String str2, String str3, int i16) {
        if (!new File(str, str2).exists()) {
            a(i3);
            a(this.f39438a.get(str3), i16, str3);
        } else {
            GDTLogger.i("PcdnSDKManager sourceCheck file exists clean cache.");
            a(str3);
        }
    }

    private void a(int i3) {
        Method a16;
        Class cls = this.f39441e;
        if (cls == null || (a16 = l.a(cls, "stopPreload", Integer.TYPE)) == null) {
            return;
        }
        GDTLogger.e("PcdnSDKManager stopCurrentPreloadTaskById :" + i3);
        l.a(this.f39440d, a16, Integer.valueOf(i3));
    }

    private void a(String str, WeakReference<c> weakReference) {
        if (TextUtils.isEmpty(str) || weakReference == null) {
            return;
        }
        if (this.f39438a.containsKey(str)) {
            List<WeakReference<c>> list = this.f39438a.get(str);
            if (g.a(list)) {
                list.add(weakReference);
                return;
            }
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(weakReference);
        this.f39438a.putIfAbsent(str, arrayList);
    }

    private Object a(Class cls, b bVar) {
        Object obj = null;
        if (bVar != null && bVar.h()) {
            try {
                Constructor a16 = l.a(cls, ArrayList.class, Integer.TYPE, Map.class);
                if (a16 != null) {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(bVar.a());
                    HashMap hashMap = new HashMap();
                    hashMap.put((String) this.f39448l.get(null), Long.valueOf(GmCgConstants.MIN_NECESSARY_STORAGE_SIZE_DEFAULT));
                    hashMap.put((String) this.f39449m.get(null), Boolean.TRUE);
                    if (bVar.g()) {
                        hashMap.put((String) this.f39450n.get(null), 1);
                    }
                    hashMap.put((String) this.f39452p.get(null), "pcdn_ams_ad_" + GDTADManager.getInstance().getAppStatus().getAPPID());
                    hashMap.put((String) this.f39451o.get(null), bVar.c() + File.separator + bVar.b());
                    Object[] objArr = new Object[3];
                    objArr[0] = arrayList;
                    Field field = this.f39447k;
                    objArr[1] = field != null ? field.get(null) : 1;
                    objArr[2] = hashMap;
                    obj = a16.newInstance(objArr);
                }
            } catch (Throwable th5) {
                th5.printStackTrace();
            }
            StringBuilder sb5 = new StringBuilder();
            sb5.append("TPDownloadParam Reflection succ ?");
            sb5.append(obj != null);
            GDTLogger.e(sb5.toString());
            return obj;
        }
        GDTLogger.e("PcdnSDKManager  getDownloadParam error.");
        return null;
    }
}
