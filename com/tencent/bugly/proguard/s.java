package com.tencent.bugly.proguard;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.text.TextUtils;
import com.qzone.album.data.model.PhotoCategorySinglePicInfo;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.bugly.BuildConfigWrapper;
import com.tencent.bugly.GlobalConfig;
import com.tencent.bugly.common.constants.Constants;
import com.tencent.bugly.common.labels.VersionLabelWrapper;
import com.tencent.bugly.common.meta.UserMeta;
import com.tencent.bugly.common.reporter.builder.ReportDataBuilder;
import com.tencent.bugly.common.utils.RMonitorFeatureHelper;
import com.tencent.bugly.crashreport.biz.UserInfoBean;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.intervideo.nowproxy.NowProxyConstants;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import com.tencent.open.business.base.MobileInfoUtil;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import com.tencent.qqlive.tvkplayer.vinfo.live.TVKLiveRequestBuilder;
import java.io.BufferedReader;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes5.dex */
public final class s {

    /* renamed from: f, reason: collision with root package name */
    private static boolean f98536f = true;

    /* renamed from: a, reason: collision with root package name */
    public long f98537a;

    /* renamed from: b, reason: collision with root package name */
    public Context f98538b;

    /* renamed from: c, reason: collision with root package name */
    public int f98539c;

    /* renamed from: d, reason: collision with root package name */
    private long f98540d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f98541e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class a implements Runnable {

        /* renamed from: b, reason: collision with root package name */
        private boolean f98549b;

        /* renamed from: c, reason: collision with root package name */
        private UserInfoBean f98550c;

        public a(UserInfoBean userInfoBean, boolean z16) {
            this.f98550c = userInfoBean;
            this.f98549b = z16;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (!s.this.f98541e) {
                return;
            }
            try {
                UserInfoBean userInfoBean = this.f98550c;
                if (userInfoBean != null) {
                    s.a(userInfoBean);
                    av.c("[UserInfo] Record user info.", new Object[0]);
                    s.this.a(this.f98550c, false);
                }
                if (this.f98549b) {
                    s.this.c();
                }
            } catch (Throwable th5) {
                if (!av.a(th5)) {
                    th5.printStackTrace();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis < s.this.f98540d) {
                at.a().a(new b(), (s.this.f98540d - currentTimeMillis) + 5000);
            } else {
                s.this.a(3, false);
                s.this.a();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class c implements Runnable {

        /* renamed from: b, reason: collision with root package name */
        private long f98553b;

        public c(long j3) {
            this.f98553b = j3;
        }

        @Override // java.lang.Runnable
        public final void run() {
            s.this.c();
            s.this.a(this.f98553b);
        }
    }

    public s(Context context, boolean z16) {
        this.f98537a = MiniBoxNoticeInfo.MIN_5;
        this.f98538b = context;
        this.f98541e = z16;
        try {
            this.f98537a = Long.parseLong(ba.d("userInfoMinInterval", "300000"));
        } catch (Throwable th5) {
            av.b(th5);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x009a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean c(boolean z16) {
        boolean z17;
        boolean z18 = false;
        if (!z.a("userinfo_ratio")) {
            av.c("userinfo upload is disabled by remote", new Object[0]);
            return false;
        }
        if (!f98536f || z16) {
            return true;
        }
        File file = new File(this.f98538b.getFilesDir(), "bugly_last_us_up_tm");
        long currentTimeMillis = System.currentTimeMillis();
        if (!file.exists()) {
            aw.a(file, String.valueOf(currentTimeMillis), 1024L, false);
            return true;
        }
        BufferedReader a16 = ba.a(file);
        if (a16 != null) {
            try {
                long longValue = Long.valueOf(a16.readLine().trim()).longValue();
                if (currentTimeMillis >= longValue && currentTimeMillis - longValue <= 86400000) {
                    z17 = true;
                    if (!z17 && currentTimeMillis - longValue < this.f98537a) {
                        if (a16 != null) {
                        }
                        return z18;
                    }
                    aw.a(file, String.valueOf(currentTimeMillis), 1024L, false);
                }
                z17 = false;
                if (!z17) {
                }
                aw.a(file, String.valueOf(currentTimeMillis), 1024L, false);
            } catch (Throwable th5) {
                try {
                    av.b(th5);
                    aw.a(file, String.valueOf(currentTimeMillis), 1024L, false);
                    try {
                        a16.close();
                        return true;
                    } catch (Exception e16) {
                        av.a(e16);
                        return true;
                    }
                } finally {
                    try {
                        a16.close();
                    } catch (Exception e17) {
                        av.a(e17);
                    }
                }
            }
        }
        z18 = true;
        if (a16 != null) {
        }
        return z18;
    }

    public final boolean b() {
        aq a16;
        ak a17;
        if (!this.f98541e || (a16 = aq.a()) == null || (a17 = ak.a()) == null) {
            return false;
        }
        return !a17.b() || a16.b(1001);
    }

    public static void a(boolean z16) {
        f98536f = z16;
    }

    public static UserInfoBean a(Context context, int i3) {
        ai a16 = ai.a(context);
        UserInfoBean userInfoBean = new UserInfoBean();
        userInfoBean.f97814b = i3;
        userInfoBean.f97815c = a16.f98016d;
        userInfoBean.f97816d = a16.g();
        userInfoBean.f97817e = System.currentTimeMillis();
        userInfoBean.f97818f = -1L;
        userInfoBean.f97826n = a16.f98032t;
        userInfoBean.f97827o = i3 != 1 ? 0 : 1;
        userInfoBean.f97824l = a16.b();
        userInfoBean.f97825m = a16.G;
        userInfoBean.f97819g = a16.H;
        userInfoBean.f97820h = a16.I;
        userInfoBean.f97821i = a16.J;
        userInfoBean.f97823k = a16.K;
        userInfoBean.f97830r = a16.u();
        userInfoBean.f97831s = a16.z();
        userInfoBean.f97828p = a16.A();
        userInfoBean.f97829q = a16.F;
        JSONObject m3 = com.tencent.rmonitor.custom.b.a().m();
        if (m3 != null) {
            String jSONObject = m3.toString();
            if (!TextUtils.isEmpty(ReportDataBuilder.KEY_USER_CUSTOM)) {
                if (userInfoBean.f97832t == null) {
                    userInfoBean.f97832t = new ConcurrentHashMap();
                }
                userInfoBean.f97832t.put(ReportDataBuilder.KEY_USER_CUSTOM, jSONObject);
            }
        }
        return userInfoBean;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0048 A[Catch: all -> 0x0075, TryCatch #0 {, blocks: (B:3:0x0001, B:8:0x0009, B:10:0x001e, B:12:0x002c, B:13:0x0042, B:15:0x0048, B:17:0x004d, B:20:0x0054, B:23:0x006b, B:27:0x003c), top: B:2:0x0001 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void b(boolean z16) {
        boolean z17;
        if (b()) {
            String str = ai.a(this.f98538b).f98016d;
            ArrayList arrayList = new ArrayList();
            List<UserInfoBean> a16 = a(str);
            if (a16 != null) {
                a(a16, arrayList);
                b(a16, arrayList);
                int a17 = a(a16);
                if (a17 > 15) {
                    av.d("[UserInfo] Upload user info too many times in 10 min: %d", Integer.valueOf(a17));
                    z17 = false;
                    if (arrayList.size() > 0) {
                        b(arrayList);
                    }
                    if (z17 && a16.size() != 0) {
                        av.c("[UserInfo] Upload user info(size: %d)", Integer.valueOf(a16.size()));
                        a(a16, z16);
                        return;
                    }
                    av.c("[UserInfo] There is no user info in local database.", new Object[0]);
                }
            } else {
                a16 = new ArrayList<>();
            }
            z17 = true;
            if (arrayList.size() > 0) {
            }
            if (z17) {
                av.c("[UserInfo] Upload user info(size: %d)", Integer.valueOf(a16.size()));
                a(a16, z16);
                return;
            }
            av.c("[UserInfo] There is no user info in local database.", new Object[0]);
        }
    }

    public final void c() {
        at a16 = at.a();
        if (a16 != null) {
            a16.a(new Runnable() { // from class: com.tencent.bugly.proguard.s.3

                /* renamed from: a, reason: collision with root package name */
                final /* synthetic */ boolean f98546a = false;

                @Override // java.lang.Runnable
                public final void run() {
                    try {
                        s.this.b(this.f98546a);
                    } catch (Throwable th5) {
                        av.a(th5);
                    }
                }
            });
        }
    }

    private static ContentValues c(UserInfoBean userInfoBean) {
        if (userInfoBean == null) {
            return null;
        }
        try {
            ContentValues contentValues = new ContentValues();
            long j3 = userInfoBean.f97813a;
            if (j3 > 0) {
                contentValues.put("_id", Long.valueOf(j3));
            }
            contentValues.put("_tm", Long.valueOf(userInfoBean.f97817e));
            contentValues.put("_ut", Long.valueOf(userInfoBean.f97818f));
            contentValues.put("_tp", Integer.valueOf(userInfoBean.f97814b));
            contentValues.put("_pc", userInfoBean.f97815c);
            contentValues.put("_dt", ba.a(userInfoBean));
            return contentValues;
        } catch (Throwable th5) {
            if (!av.a(th5)) {
                th5.printStackTrace();
            }
            return null;
        }
    }

    private static void b(List<UserInfoBean> list, List<UserInfoBean> list2) {
        Iterator<UserInfoBean> it = list.iterator();
        while (it.hasNext()) {
            UserInfoBean next = it.next();
            if (next.f97818f != -1) {
                it.remove();
                if (next.f97817e < ba.b()) {
                    list2.add(next);
                }
            }
        }
    }

    public final void a(int i3, boolean z16) {
        ak a16 = ak.a();
        if (a16 != null && !a16.c().f97842g && i3 != 1 && i3 != 3) {
            av.e("UserInfo is disable", new Object[0]);
            return;
        }
        if (i3 == 1 || i3 == 3) {
            this.f98539c++;
        }
        at.a().a(new a(a(this.f98538b, i3), z16), 0L);
    }

    private JSONObject b(cj cjVar, co coVar) {
        ai a16 = ai.a(this.f98538b);
        JSONObject jSONObject = new JSONObject();
        try {
            UserMeta userMeta = new UserMeta();
            userMeta.uin = a16.g();
            userMeta.buildNumber = a16.O;
            userMeta.appKey = "unknow_app_key";
            userMeta.appId = a16.f();
            userMeta.appVersion = a16.f98032t;
            userMeta.sdkVersion = a16.f98020h;
            userMeta.setModel(a16.i());
            userMeta.setUniqueID(a16.h());
            jSONObject = ReportDataBuilder.makeParam(this.f98538b, "metric", "union_dau", userMeta);
            JSONObject a17 = a(cjVar, coVar);
            JSONObject m3 = com.tencent.rmonitor.custom.b.a().m();
            if (m3 != null) {
                a17.put(ReportDataBuilder.KEY_USER_CUSTOM, m3);
            }
            jSONObject.put(ReportDataBuilder.KEY_ATTRIBUTES, a17);
        } catch (Throwable th5) {
            av.b(th5);
        }
        return jSONObject;
    }

    public final void a(long j3) {
        at.a().a(new c(j3), j3);
    }

    public final void a() {
        this.f98540d = ba.b() + 86400000;
        at.a().a(new b(), (this.f98540d - System.currentTimeMillis()) + 5000);
    }

    public static void a(UserInfoBean userInfoBean) {
        ai c16;
        if (userInfoBean == null || (c16 = ai.c()) == null) {
            return;
        }
        userInfoBean.f97822j = c16.e();
    }

    private static void a(List<UserInfoBean> list, List<UserInfoBean> list2) {
        int size = list.size() - 20;
        if (size > 0) {
            int i3 = 0;
            while (i3 < list.size() - 1) {
                int i16 = i3 + 1;
                for (int i17 = i16; i17 < list.size(); i17++) {
                    if (list.get(i3).f97817e > list.get(i17).f97817e) {
                        UserInfoBean userInfoBean = list.get(i3);
                        list.set(i3, list.get(i17));
                        list.set(i17, userInfoBean);
                    }
                }
                i3 = i16;
            }
            for (int i18 = 0; i18 < size; i18++) {
                list2.add(list.get(i18));
            }
        }
    }

    private static void b(List<UserInfoBean> list) {
        if (list.size() == 0) {
            return;
        }
        StringBuilder sb5 = new StringBuilder();
        for (int i3 = 0; i3 < list.size() && i3 < 50; i3++) {
            UserInfoBean userInfoBean = list.get(i3);
            sb5.append(" or _id = ");
            sb5.append(userInfoBean.f97813a);
        }
        String sb6 = sb5.toString();
        if (sb6.length() > 0) {
            sb6 = sb6.substring(4);
        }
        sb5.setLength(0);
        try {
            av.c("[Database] deleted %s data %d", "t_ui", Integer.valueOf(ae.a().a("t_ui", sb6, (String[]) null)));
        } catch (Throwable th5) {
            if (av.a(th5)) {
                return;
            }
            th5.printStackTrace();
        }
    }

    private static int a(List<UserInfoBean> list) {
        int i3;
        long currentTimeMillis = System.currentTimeMillis();
        int i16 = 0;
        for (UserInfoBean userInfoBean : list) {
            if (userInfoBean.f97817e > currentTimeMillis - 600000 && ((i3 = userInfoBean.f97814b) == 1 || i3 == 4 || i3 == 3)) {
                i16++;
            }
        }
        return i16;
    }

    private static JSONArray a(co coVar) {
        JSONArray jSONArray = new JSONArray();
        try {
            Iterator<cn> it = coVar.f98492d.iterator();
            while (it.hasNext()) {
                cn next = it.next();
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("startTime", next.f98479a);
                jSONObject.put("startType", (int) next.f98480b);
                jSONObject.put("userId", next.f98481c);
                jSONObject.put("proceName", next.f98482d);
                jSONObject.put("valueMap", new JSONObject(next.f98484f));
                jSONObject.put("gatewayIp", next.f98485g);
                jSONObject.put("coldStart", next.f98486h);
                jSONArray.mo162put(jSONObject);
            }
        } catch (Throwable th5) {
            av.b(th5);
        }
        return jSONArray;
    }

    private static JSONObject a(co coVar, JSONArray jSONArray) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("type", (int) coVar.f98489a);
            jSONObject.put("proceName", coVar.f98490b);
            jSONObject.put(Constants.SP_DEVICE_ID, coVar.f98491c);
            jSONObject.put("list", jSONArray);
            jSONObject.put("valueMap", new JSONObject(coVar.f98493e));
        } catch (Throwable th5) {
            av.b(th5);
        }
        return jSONObject;
    }

    private JSONObject a(cj cjVar, JSONObject jSONObject) {
        JSONObject makeAttributes = ReportDataBuilder.makeAttributes(new String[]{"stage"});
        try {
            boolean z16 = true;
            if (this.f98539c != 1) {
                z16 = false;
            }
            makeAttributes.put("first_report", z16);
            makeAttributes.put("features_enabled", RMonitorFeatureHelper.getInstance().getStartedPluginList());
            makeAttributes.put(ConstantsAPI.Token.WX_TOKEN_PLATFORMID_KEY, cjVar.f98427a);
            makeAttributes.put("prodId", cjVar.f98428b);
            makeAttributes.put("bundleId", cjVar.f98429c);
            makeAttributes.put("version", cjVar.f98430d);
            makeAttributes.put(WadlProxyConsts.CHANNEL, cjVar.f98431e);
            makeAttributes.put("sdkVer", cjVar.f98432f);
            makeAttributes.put("cmd", cjVar.f98433g);
            makeAttributes.put("sBuffer", jSONObject);
            makeAttributes.put("model", cjVar.f98435i);
            makeAttributes.put("osVer", cjVar.f98436j);
            Map<String, String> map = cjVar.f98437k;
            map.remove(VersionLabelWrapper.SHIPLY_VERSION_LABEL_KEY);
            makeAttributes.put("reserved", new JSONObject(map));
            makeAttributes.put("sessionId", cjVar.f98438l);
            makeAttributes.put("strategylastUpdateTime", cjVar.f98439m);
            makeAttributes.put("sdkId", cjVar.f98440n);
            makeAttributes.put(Constants.SP_DEVICE_ID, cjVar.f98441o);
            makeAttributes.put("apn", cjVar.f98442p);
            makeAttributes.put(PhotoCategorySinglePicInfo.UPLOAD_TIME, cjVar.f98443q);
            makeAttributes.put("imei", cjVar.f98444r);
            makeAttributes.put(TVKLiveRequestBuilder.RequestParamKey.QIMEI36, cjVar.f98445s);
            makeAttributes.put(MobileInfoUtil.IMSI, cjVar.f98446t);
            makeAttributes.put("mac", cjVar.f98447u);
            makeAttributes.put("androidId", cjVar.f98448v);
            makeAttributes.put(DKEngine.GlobalKey.NET_WORK_TYPE, cjVar.f98449w);
            makeAttributes.put("idfv", cjVar.f98450x);
            makeAttributes.put("custom_upload_anything", ai.c().f97995ad);
        } catch (Throwable th5) {
            av.b(th5);
        }
        return makeAttributes;
    }

    private JSONObject a(cj cjVar, co coVar) {
        JSONObject makeAttributes = ReportDataBuilder.makeAttributes(new String[]{"stage"});
        try {
            return a(cjVar, a(coVar, a(coVar)));
        } catch (Throwable th5) {
            av.b(th5);
            return makeAttributes;
        }
    }

    public final void a(final List<UserInfoBean> list, boolean z16) {
        ai c16;
        if (GlobalConfig.isInStandaloneMode()) {
            av.d("upload user info fail for app in standalone mode.", new Object[0]);
            return;
        }
        if (!c(z16)) {
            long currentTimeMillis = System.currentTimeMillis();
            for (UserInfoBean userInfoBean : list) {
                userInfoBean.f97818f = currentTimeMillis;
                a(userInfoBean, true);
            }
            av.d("uploadCheck failed", new Object[0]);
            return;
        }
        int i3 = this.f98539c == 1 ? 1 : 2;
        co coVar = null;
        if (list != null && list.size() != 0 && (c16 = ai.c()) != null) {
            c16.p();
            co coVar2 = new co();
            coVar2.f98490b = c16.f98016d;
            coVar2.f98491c = c16.h();
            ArrayList<cn> arrayList = new ArrayList<>();
            Iterator<UserInfoBean> it = list.iterator();
            while (it.hasNext()) {
                cn a16 = am.a(it.next());
                if (a16 != null) {
                    arrayList.add(a16);
                }
            }
            coVar2.f98492d = arrayList;
            HashMap hashMap = new HashMap();
            coVar2.f98493e = hashMap;
            hashMap.put("A7", new StringBuilder().toString());
            coVar2.f98493e.put("A6", ai.o());
            coVar2.f98493e.put("A5", c16.n());
            Map<String, String> map = coVar2.f98493e;
            StringBuilder sb5 = new StringBuilder();
            sb5.append(c16.l());
            map.put(NowProxyConstants.AccountInfoKey.A2, sb5.toString());
            Map<String, String> map2 = coVar2.f98493e;
            StringBuilder sb6 = new StringBuilder();
            sb6.append(c16.l());
            map2.put("A1", sb6.toString());
            coVar2.f98493e.put("A24", c16.f98023k);
            Map<String, String> map3 = coVar2.f98493e;
            StringBuilder sb7 = new StringBuilder();
            sb7.append(c16.m());
            map3.put("A17", sb7.toString());
            coVar2.f98493e.put("A15", c16.r());
            Map<String, String> map4 = coVar2.f98493e;
            StringBuilder sb8 = new StringBuilder();
            sb8.append(c16.s());
            map4.put("A13", sb8.toString());
            coVar2.f98493e.put("F08", c16.M);
            coVar2.f98493e.put("F09", c16.N);
            Map<String, String> z17 = c16.z();
            if (z17 != null && z17.size() > 0) {
                for (Map.Entry<String, String> entry : z17.entrySet()) {
                    coVar2.f98493e.put("C04_" + entry.getKey(), entry.getValue());
                }
            }
            if (i3 == 1) {
                coVar2.f98489a = (byte) 1;
            } else if (i3 != 2) {
                av.e("unknown up type %d ", Integer.valueOf(i3));
            } else {
                coVar2.f98489a = (byte) 2;
            }
            coVar = coVar2;
        }
        if (coVar == null) {
            av.d("[UserInfo] Failed to create UserInfoPackage.", new Object[0]);
            return;
        }
        byte[] a17 = am.a((m) coVar);
        if (a17 == null) {
            av.d("[UserInfo] Failed to encode data.", new Object[0]);
            return;
        }
        cj a18 = am.a(this.f98538b, 840, a17);
        if (a18 == null) {
            av.d("[UserInfo] Request package is null.", new Object[0]);
            return;
        }
        ap apVar = new ap() { // from class: com.tencent.bugly.proguard.s.2
            @Override // com.tencent.bugly.proguard.ap
            public final void a(int i16) {
            }

            @Override // com.tencent.bugly.proguard.ap
            public final void a(int i16, ck ckVar, long j3, long j16, boolean z18, String str, String str2, long j17) {
                if (z18) {
                    av.c("[UserInfo] Successfully uploaded user info.", new Object[0]);
                    long currentTimeMillis2 = System.currentTimeMillis();
                    for (UserInfoBean userInfoBean2 : list) {
                        userInfoBean2.f97818f = currentTimeMillis2;
                        s.this.a(userInfoBean2, true);
                    }
                }
            }
        };
        String str = ak.a().c().f97852q;
        String str2 = StrategyBean.f97836a;
        ai a19 = ai.a(this.f98538b);
        if (a19.a()) {
            av.a("user info with new protoc", new Object[0]);
            JSONObject b16 = b(a18, coVar);
            aq.a().a(b16.toString().getBytes(), BuildConfigWrapper.getDomain() + "/v1/" + a19.f() + "/upload-json", BuildConfigWrapper.getDomain() + "/v1/" + a19.f() + "/upload-json", apVar, this.f98539c == 1);
            return;
        }
        av.a("user info with old protoc", new Object[0]);
        aq.a().a(ba.a(am.a((Object) a18)), str, str2, apVar, this.f98539c == 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(UserInfoBean userInfoBean, boolean z16) {
        List<UserInfoBean> a16;
        if (userInfoBean == null) {
            return;
        }
        if (!z16 && userInfoBean.f97814b != 1 && (a16 = a(ai.a(this.f98538b).f98016d)) != null && a16.size() >= 20) {
            av.a("[UserInfo] There are too many user info in local: %d", Integer.valueOf(a16.size()));
            return;
        }
        long a17 = ae.a().a("t_ui", c(userInfoBean), (ad) null);
        if (a17 >= 0) {
            av.c("[Database] insert %s success with ID: %d", "t_ui", Long.valueOf(a17));
            userInfoBean.f97813a = a17;
        }
    }

    public static List<UserInfoBean> a(String str) {
        Cursor cursor;
        String str2;
        try {
            if (ba.b(str)) {
                str2 = null;
            } else {
                str2 = "_pc = '" + str + "'";
            }
            cursor = ae.a().a("t_ui", (String[]) null, str2);
            if (cursor == null) {
                return null;
            }
            try {
                StringBuilder sb5 = new StringBuilder();
                ArrayList arrayList = new ArrayList();
                while (cursor.moveToNext()) {
                    UserInfoBean a16 = a(cursor);
                    if (a16 != null) {
                        arrayList.add(a16);
                    } else {
                        try {
                            long j3 = cursor.getLong(cursor.getColumnIndex("_id"));
                            sb5.append(" or _id = ");
                            sb5.append(j3);
                        } catch (Throwable unused) {
                            av.d("[Database] unknown id.", new Object[0]);
                        }
                    }
                }
                String sb6 = sb5.toString();
                if (sb6.length() > 0) {
                    av.d("[Database] deleted %s error data %d", "t_ui", Integer.valueOf(ae.a().a("t_ui", sb6.substring(4), (String[]) null)));
                }
                cursor.close();
                return arrayList;
            } catch (Throwable th5) {
                th = th5;
                try {
                    if (!av.a(th)) {
                        th.printStackTrace();
                    }
                    if (cursor != null) {
                        cursor.close();
                    }
                    return null;
                } finally {
                    if (cursor != null) {
                        cursor.close();
                    }
                }
            }
        } catch (Throwable th6) {
            th = th6;
            cursor = null;
        }
    }

    private static UserInfoBean a(Cursor cursor) {
        if (cursor == null) {
            return null;
        }
        try {
            byte[] blob = cursor.getBlob(cursor.getColumnIndex("_dt"));
            if (blob == null) {
                return null;
            }
            long j3 = cursor.getLong(cursor.getColumnIndex("_id"));
            UserInfoBean userInfoBean = (UserInfoBean) ba.a(blob, UserInfoBean.CREATOR);
            if (userInfoBean != null) {
                userInfoBean.f97813a = j3;
            }
            return userInfoBean;
        } catch (Throwable th5) {
            if (!av.a(th5)) {
                th5.printStackTrace();
            }
            return null;
        }
    }
}
