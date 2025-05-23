package com.tencent.biz;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Looper;
import android.support.v4.util.ArrayMap;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.biz.pubaccount.api.IPublicAccountHandler;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QMMKVFile;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.config.am;
import com.tencent.mobileqq.config.business.bh;
import com.tencent.mobileqq.mp.mobileqq_mp$WebviewWhiteListRequset;
import com.tencent.mobileqq.mp.mobileqq_mp$WebviewWhiteListResponse;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.webprocess.WebAccelerateHelper;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserStatistics;
import com.tencent.mobileqq.webview.swift.cookie.SwiftTicketCookie;
import com.tencent.mobileqq.webview.swift.injector.aa;
import com.tencent.mobileqq.webview.util.s;
import com.tencent.mobileqq.webview.util.t;
import com.tencent.mobileqq.webview.util.x;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import com.tencent.sqshow.zootopia.publish.ZPlanPublishSource;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.zip.Inflater;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import mqq.observer.BusinessObserver;
import okhttp3.HttpUrl;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes2.dex */
public class AuthorizeConfig {
    protected static final ArrayMap<String, String> A;
    static final boolean B;
    protected static volatile long C;
    private static final List<String> D;
    protected static AuthorizeConfig E;
    private static final Object F;
    private static final Object G;
    private static long H;

    /* renamed from: z, reason: collision with root package name */
    public static final String[] f78108z;

    /* renamed from: b, reason: collision with root package name */
    private s43.a f78110b;

    /* renamed from: d, reason: collision with root package name */
    protected volatile JSONObject f78112d;

    /* renamed from: e, reason: collision with root package name */
    protected volatile JSONObject f78113e;

    /* renamed from: f, reason: collision with root package name */
    protected volatile JSONObject f78114f;

    /* renamed from: g, reason: collision with root package name */
    protected volatile JSONArray f78115g;

    /* renamed from: h, reason: collision with root package name */
    protected volatile JSONArray f78116h;

    /* renamed from: i, reason: collision with root package name */
    protected volatile JSONArray f78117i;

    /* renamed from: k, reason: collision with root package name */
    protected volatile JSONArray f78119k;

    /* renamed from: l, reason: collision with root package name */
    protected volatile JSONArray f78120l;

    /* renamed from: m, reason: collision with root package name */
    protected volatile long f78121m;

    /* renamed from: n, reason: collision with root package name */
    protected volatile JSONObject f78122n;

    /* renamed from: o, reason: collision with root package name */
    protected volatile JSONObject f78123o;

    /* renamed from: q, reason: collision with root package name */
    protected final ConcurrentHashMap<String, JSONArray> f78125q;

    /* renamed from: r, reason: collision with root package name */
    protected final ConcurrentHashMap<String, Set<String>> f78126r;

    /* renamed from: s, reason: collision with root package name */
    Context f78127s;

    /* renamed from: t, reason: collision with root package name */
    j f78128t;

    /* renamed from: u, reason: collision with root package name */
    lx.e f78129u;

    /* renamed from: v, reason: collision with root package name */
    @NonNull
    private final com.tencent.mobileqq.webview.swift.injector.c f78130v;

    /* renamed from: w, reason: collision with root package name */
    private com.tencent.mobileqq.webview.swift.injector.g f78131w;

    /* renamed from: x, reason: collision with root package name */
    protected ArrayList<String> f78132x;

    /* renamed from: y, reason: collision with root package name */
    private volatile boolean f78133y;

    /* renamed from: a, reason: collision with root package name */
    private ArrayList<s43.b> f78109a = new ArrayList<>();

    /* renamed from: c, reason: collision with root package name */
    public final AtomicInteger f78111c = new AtomicInteger(-1);

    /* renamed from: j, reason: collision with root package name */
    protected volatile int f78118j = -1;

    /* renamed from: p, reason: collision with root package name */
    protected volatile long f78124p = -1;

    /* compiled from: P */
    /* loaded from: classes2.dex */
    class a implements com.tencent.mobileqq.webview.swift.injector.g {
        a() {
        }

        @Override // com.tencent.mobileqq.webview.swift.injector.g
        public void onFail(@NonNull String str) {
            QLog.e("AuthorizeConfig", 1, "[preload] Failed error:" + str);
        }

        @Override // com.tencent.mobileqq.webview.swift.injector.g
        public void onSuccess(@NonNull Map<String, String> map) {
            QLog.i("AuthorizeConfig", 1, "[preload] Done ticket: pt4token");
            AuthorizeConfig.this.f78133y = false;
            AuthorizeConfig.this.q0();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public class b implements com.tencent.mobileqq.webview.swift.injector.g {
        b() {
        }

        @Override // com.tencent.mobileqq.webview.swift.injector.g
        public void onFail(@NonNull String str) {
            QLog.i("AuthorizeConfig", 1, "[preload] Done pskey fail, next");
            AuthorizeConfig.this.q0();
        }

        @Override // com.tencent.mobileqq.webview.swift.injector.g
        public void onSuccess(@NonNull Map<String, String> map) {
            QLog.i("AuthorizeConfig", 1, "[preload] Done pskey suc, next");
            AuthorizeConfig.this.q0();
        }
    }

    static {
        String[] strArr = {"skey", "pskey", ICustomDataEditor.STRING_ARRAY_PARAM_1, ICustomDataEditor.STRING_ARRAY_PARAM_2, "ptlogin2", "pt4_token"};
        f78108z = strArr;
        ArrayMap<String, String> arrayMap = new ArrayMap<>(strArr.length);
        A = arrayMap;
        arrayMap.put("skey", "[\"*.qq.com\",\"*.tenpay.com\"]");
        arrayMap.put("pskey", "[\"qun.qq.com\",\"game.qq.com\",\"kg.qq.com\",\"id.qq.com\",\"qzone.qq.com\",\"qzone.com\",\"openmobile.qq.com\",\"tenpay.com\",\"buluo.qq.com\",\"docs.qq.com\",\"ti.qq.com\",\"accounts.qq.com\",\"yundong.qq.com\",\"mp.qq.com\",\"xsj.qq.com\"]");
        arrayMap.put(ICustomDataEditor.STRING_ARRAY_PARAM_1, HttpUrl.PATH_SEGMENT_ENCODE_SET_URI);
        arrayMap.put(ICustomDataEditor.STRING_ARRAY_PARAM_2, "[\"aq.qq.com\",\"weloan.tenpay.com\"]");
        arrayMap.put("ptlogin2", "[\"http://ptlogin2.qq.com\",\"https://ssl.ptlogin2.qq.com\", \"https://ptlogin2.qq.com\"]");
        arrayMap.put("pt4_token", "[\"gamecenter.qq.com\",\"imgcache.qq.com\",\"vip.qq.com\",\"haoma.qq.com\"]");
        B = ((com.tencent.mobileqq.inject.b) aa.k(com.tencent.mobileqq.inject.b.class)).isDebugVersion();
        C = -1L;
        D = Arrays.asList("ti.qq.com", "accounts.qq.com", "graph.qq.com");
        F = new Object();
        G = new Object();
    }

    AuthorizeConfig(Context context) {
        String[] strArr = f78108z;
        this.f78125q = new ConcurrentHashMap<>(strArr.length);
        this.f78126r = new ConcurrentHashMap<>(strArr.length);
        this.f78130v = (com.tencent.mobileqq.webview.swift.injector.c) aa.d(com.tencent.mobileqq.webview.swift.injector.c.class);
        this.f78131w = new a();
        this.f78132x = new ArrayList<>();
        this.f78133y = false;
        if (QLog.isColorLevel()) {
            QLog.d("AuthorizeConfig", 2, "AuthorizeConfig init");
        }
        K(context);
    }

    private JSONObject C() {
        JSONObject jSONObject = this.f78112d;
        long currentTimeMillis = System.currentTimeMillis();
        if (jSONObject == null) {
            String d16 = this.f78129u.d();
            if (d16 != null) {
                try {
                    jSONObject = new JSONObject(d16);
                } catch (JSONException unused) {
                    if (QLog.isColorLevel()) {
                        QLog.d("AuthorizeConfig", 2, "Decode mOfflineConfig  error");
                    }
                }
            }
            if (jSONObject == null) {
                jSONObject = new JSONObject();
            }
        }
        if (!((com.tencent.mobileqq.inject.b) aa.k(com.tencent.mobileqq.inject.b.class)).isPublicVersion()) {
            QLog.i("AuthorizeConfig", 1, "Web_qqbrowser_authorize_getOfflineConfig, cost=" + (System.currentTimeMillis() - currentTimeMillis));
        }
        return jSONObject;
    }

    private void L() {
        boolean isDebugVersion;
        RuntimeException runtimeException;
        try {
            ArrayList<Class<? extends s43.b>> arrayList = h.f78563a;
            if (arrayList != null) {
                Iterator<Class<? extends s43.b>> it = arrayList.iterator();
                while (it.hasNext()) {
                    this.f78109a.add(it.next().newInstance());
                }
            }
            ArrayList<Class<? extends s43.a>> arrayList2 = h.f78564b;
            if (arrayList2 != null && arrayList2.size() > 0) {
                this.f78110b = h.f78564b.get(0).newInstance();
            }
        } finally {
            if (!isDebugVersion) {
            }
        }
    }

    private boolean M(String str, String str2) {
        Iterator<s43.b> it = this.f78109a.iterator();
        while (it.hasNext()) {
            if (it.next().b(str, str2)) {
                return true;
            }
        }
        return false;
    }

    public static boolean P(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return false;
        }
        if ("*".equals(str)) {
            return true;
        }
        if ("*.*".equals(str)) {
            if (str2.indexOf(46) == -1) {
                return false;
            }
            return true;
        }
        if (str.startsWith("*")) {
            return str2.endsWith(str.substring(1));
        }
        if (str.endsWith("*")) {
            return str2.startsWith(str.substring(0, str.length() - 1));
        }
        return str2.equals(str);
    }

    private boolean Q() {
        boolean z16;
        boolean z17;
        synchronized (this.f78111c) {
            boolean z18 = false;
            if (this.f78111c.get() == 1) {
                return false;
            }
            if (this.f78111c.get() == 3) {
                QLog.d("AuthorizeConfig", 1, "return true because reload");
                return true;
            }
            if (!S(MobileQQ.sMobileQQ.peekAppRuntime())) {
                return false;
            }
            if (this.f78111c.get() == -1) {
                if (MobileQQ.sProcessId == 1) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                this.f78111c.set(0);
            } else {
                z16 = false;
            }
            long currentTimeMillis = System.currentTimeMillis() - C;
            if (currentTimeMillis >= 0 && currentTimeMillis < 1800000) {
                z17 = false;
                if (!z16 || z17) {
                    z18 = true;
                }
                if (z18 && QLog.isColorLevel()) {
                    QLog.d("AuthorizeConfig", 2, "isAfterLogin:" + z16 + " isTimeout:" + z17 + " offset:" + currentTimeMillis + " sLastUpdateTime:" + C);
                }
                return z18;
            }
            z17 = true;
            if (!z16) {
            }
            z18 = true;
            if (z18) {
                QLog.d("AuthorizeConfig", 2, "isAfterLogin:" + z16 + " isTimeout:" + z17 + " offset:" + currentTimeMillis + " sLastUpdateTime:" + C);
            }
            return z18;
        }
    }

    private static boolean S(AppRuntime appRuntime) {
        if (appRuntime != null && appRuntime.isLogin() && s.j(appRuntime.getAccount())) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void U(final int i3, final boolean z16, final Bundle bundle) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.biz.g
            @Override // java.lang.Runnable
            public final void run() {
                AuthorizeConfig.this.T(i3, z16, bundle);
            }
        }, 128, null, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void V(AppRuntime appRuntime, String str) {
        com.tencent.mobileqq.webview.swift.injector.m mVar = (com.tencent.mobileqq.webview.swift.injector.m) aa.k(com.tencent.mobileqq.webview.swift.injector.m.class);
        if (str.length() > 200) {
            str = str.substring(0, 200);
        }
        mVar.b(appRuntime, "dc00899", "Grp_tech_report", "", "webview", "file_js", 0, 0, str, "", "", "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void W(AppRuntime appRuntime, String str) {
        com.tencent.mobileqq.webview.swift.injector.m mVar = (com.tencent.mobileqq.webview.swift.injector.m) aa.k(com.tencent.mobileqq.webview.swift.injector.m.class);
        if (str.length() > 200) {
            str = str.substring(0, 200);
        }
        mVar.b(appRuntime, "dc00899", "Grp_tech_report", "", "webview", "file_jump", 0, 0, str, "", "", "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void X(AppRuntime appRuntime, String str) {
        com.tencent.mobileqq.webview.swift.injector.m mVar = (com.tencent.mobileqq.webview.swift.injector.m) aa.k(com.tencent.mobileqq.webview.swift.injector.m.class);
        if (str.length() > 200) {
            str = str.substring(0, 200);
        }
        mVar.b(appRuntime, "dc00899", "Grp_tech_report", "", "webview", "file_scheme", 0, 0, str, "", "", "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Y(AppRuntime appRuntime, Set set) {
        try {
            SwiftTicketCookie.A(appRuntime, appRuntime.getAccount(), new ArrayList(set), this.f78131w);
        } catch (Exception unused) {
            QLog.e("AuthorizeConfig", 1, "preload k exception ");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Z(ArrayList arrayList, AppRuntime appRuntime) {
        com.tencent.mobileqq.webview.swift.cookie.a.a(arrayList, false, appRuntime, new b());
    }

    private static String g0(String str, String str2, Set<String> set) {
        String host;
        String str3 = "";
        if (!TextUtils.isEmpty(str2)) {
            Uri parse = Uri.parse(str2);
            String scheme = parse.getScheme();
            if (!"http".equals(scheme) && !"https".equals(scheme)) {
                return "";
            }
            if (parse.isHierarchical() && (host = parse.getHost()) != null) {
                String lowerCase = host.toLowerCase();
                if (set.contains(lowerCase)) {
                    str3 = lowerCase;
                } else {
                    Iterator<String> it = set.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        String next = it.next();
                        if (lowerCase.endsWith("." + next)) {
                            str3 = next;
                            break;
                        }
                    }
                }
            }
        }
        if (QLog.isColorLevel()) {
            if (!TextUtils.isEmpty(str3)) {
                QLog.d("AuthorizeConfig", 2, str3 + " need " + str + " which extract from " + str2);
            } else {
                QLog.d("AuthorizeConfig", 2, str2 + " not need " + str);
            }
        }
        return str3;
    }

    public static String n(byte[] bArr) {
        ByteArrayOutputStream byteArrayOutputStream;
        ByteArrayOutputStream byteArrayOutputStream2 = null;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
        } catch (Throwable th5) {
            th = th5;
        }
        try {
            Inflater inflater = new Inflater();
            inflater.setInput(bArr);
            byte[] bArr2 = new byte[1024];
            while (!inflater.finished()) {
                byteArrayOutputStream.write(bArr2, 0, inflater.inflate(bArr2));
            }
            inflater.end();
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            String str = new String(byteArray);
            if (((com.tencent.mobileqq.inject.b) aa.k(com.tencent.mobileqq.inject.b.class)).isDebugVersion()) {
                QLog.i("AuthorizeConfig", 2, "byte length: " + byteArray.length + ", InflaterToString: " + str);
            }
            try {
                byteArrayOutputStream.close();
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.e("AuthorizeConfig", 2, "", e16);
                }
            }
            return str;
        } catch (Throwable th6) {
            th = th6;
            byteArrayOutputStream2 = byteArrayOutputStream;
            try {
                if (QLog.isColorLevel()) {
                    QLog.e("AuthorizeConfig", 2, "", th);
                }
                return "";
            } finally {
                if (byteArrayOutputStream2 != null) {
                    try {
                        byteArrayOutputStream2.close();
                    } catch (Exception e17) {
                        if (QLog.isColorLevel()) {
                            QLog.e("AuthorizeConfig", 2, "", e17);
                        }
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: n0, reason: merged with bridge method [inline-methods] */
    public void T(int i3, boolean z16, Bundle bundle) {
        byte[] byteArray;
        byte[] bArr;
        String str;
        int i16;
        if (QLog.isColorLevel()) {
            QLog.d("AuthorizeConfig", 2, "onReceive whitelist:" + z16);
        }
        String string = bundle.getString("version", "");
        if (z16 && (byteArray = bundle.getByteArray("data")) != null) {
            mobileqq_mp$WebviewWhiteListResponse mobileqq_mp_webviewwhitelistresponse = new mobileqq_mp$WebviewWhiteListResponse();
            try {
                mobileqq_mp_webviewwhitelistresponse.mergeFrom(byteArray);
                int i17 = mobileqq_mp_webviewwhitelistresponse.ret_info.ret_code.get();
                if (QLog.isColorLevel()) {
                    QLog.d("AuthorizeConfig", 2, "sso status code: " + String.valueOf(i17));
                }
                if (i17 == 0) {
                    if (mobileqq_mp_webviewwhitelistresponse.version != null) {
                        PBBytesField pBBytesField = mobileqq_mp_webviewwhitelistresponse.gziped_data;
                        if (pBBytesField != null && pBBytesField.get().size() != 0) {
                            bArr = mobileqq_mp_webviewwhitelistresponse.gziped_data.get().toByteArray();
                            if (QLog.isColorLevel()) {
                                StringBuilder sb5 = new StringBuilder();
                                sb5.append("now read compress data, size: ");
                                if (bArr != null) {
                                    i16 = bArr.length;
                                } else {
                                    i16 = 0;
                                }
                                sb5.append(i16);
                                QLog.i("AuthorizeConfig", 2, sb5.toString());
                            }
                        } else {
                            bArr = null;
                        }
                        try {
                            if (bArr != null) {
                                str = n(bArr);
                                if (!TextUtils.isEmpty(str) && QLog.isColorLevel()) {
                                    QLog.i("AuthorizeConfig", 2, "use zip data to json: " + mobileqq_mp_webviewwhitelistresponse.data.get());
                                }
                            } else {
                                str = mobileqq_mp_webviewwhitelistresponse.data.get();
                                if (QLog.isColorLevel()) {
                                    QLog.i("AuthorizeConfig", 2, "not use zip data to json: " + mobileqq_mp_webviewwhitelistresponse.data.get());
                                }
                            }
                            if (!TextUtils.isEmpty(str)) {
                                m0(str, mobileqq_mp_webviewwhitelistresponse.version.get(), "lastVersion");
                            }
                        } catch (Exception e16) {
                            e16.printStackTrace();
                            QLog.e("AuthorizeConfig", 2, "", e16);
                        }
                    }
                    if (((com.tencent.mobileqq.inject.b) aa.k(com.tencent.mobileqq.inject.b.class)).isDebugVersion() || SwiftBrowserStatistics.f314348m1) {
                        SwiftBrowserStatistics.f0(0, string);
                        return;
                    }
                    return;
                }
                if (i17 == 304) {
                    this.f78111c.set(2);
                    long currentTimeMillis = System.currentTimeMillis();
                    C = currentTimeMillis;
                    this.f78128t.d("lastUpdate", Long.valueOf(currentTimeMillis)).a();
                    o0();
                    if (((com.tencent.mobileqq.inject.b) aa.k(com.tencent.mobileqq.inject.b.class)).isDebugVersion() || SwiftBrowserStatistics.f314348m1) {
                        SwiftBrowserStatistics.f0(2, string);
                        return;
                    }
                    return;
                }
            } catch (Exception e17) {
                if (QLog.isColorLevel()) {
                    QLog.d("AuthorizeConfig", 2, "update error: " + e17);
                }
            }
        }
        o0();
        this.f78111c.set(0);
        if (((com.tencent.mobileqq.inject.b) aa.k(com.tencent.mobileqq.inject.b.class)).isDebugVersion() || SwiftBrowserStatistics.f314348m1) {
            SwiftBrowserStatistics.f0(1, string);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o() {
        Bundle bundle;
        String str;
        String str2 = null;
        String c16 = this.f78128t.c("qqVersion", null);
        AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
        if (waitAppRuntime != null) {
            String c17 = this.f78128t.c("lastVersion", null);
            mobileqq_mp$WebviewWhiteListRequset mobileqq_mp_webviewwhitelistrequset = new mobileqq_mp$WebviewWhiteListRequset();
            if (!TextUtils.isEmpty(c17) && ((com.tencent.mobileqq.inject.b) aa.k(com.tencent.mobileqq.inject.b.class)).d().equals(c16)) {
                mobileqq_mp_webviewwhitelistrequset.version.set(c17);
                if (QLog.isColorLevel()) {
                    QLog.d("AuthorizeConfig", 2, "Local white list version=" + c17);
                }
            } else if (QLog.isColorLevel()) {
                if (TextUtils.isEmpty(c17)) {
                    str = "Local white list may not exist";
                } else {
                    str = "QQ version changed so ignore version of local white list";
                }
                QLog.d("AuthorizeConfig", 2, str);
            }
            mobileqq_mp_webviewwhitelistrequset.qqversion.set(((com.tencent.mobileqq.inject.b) aa.k(com.tencent.mobileqq.inject.b.class)).getSubVersion());
            mobileqq_mp_webviewwhitelistrequset.gziped.set(true);
            mobileqq_mp_webviewwhitelistrequset.implat.set(109);
            if (QLog.isColorLevel()) {
                QLog.i("AuthorizeConfig", 2, "send whitelist request\uff0c lastversion: " + mobileqq_mp_webviewwhitelistrequset.version.get() + ", qq version: " + mobileqq_mp_webviewwhitelistrequset.qqversion.get() + ", isGzip: " + mobileqq_mp_webviewwhitelistrequset.gziped.get());
            }
            NewIntent newIntent = new NewIntent(this.f78127s, i.class);
            newIntent.setWithouLogin(true);
            newIntent.putExtra("cmd", "JsApiSvr.webview.whitelist");
            newIntent.putExtra("version", mobileqq_mp_webviewwhitelistrequset.version.get());
            try {
                newIntent.putExtra("data", mobileqq_mp_webviewwhitelistrequset.toByteArray());
                newIntent.setObserver(new BusinessObserver() { // from class: com.tencent.biz.d
                    @Override // mqq.observer.BusinessObserver
                    public final void onReceive(int i3, boolean z16, Bundle bundle2) {
                        AuthorizeConfig.this.U(i3, z16, bundle2);
                    }
                });
                waitAppRuntime.startServlet(newIntent);
                return;
            } catch (Exception e16) {
                QLog.d("AuthorizeConfig", 1, "toByteArray failed", e16);
                this.f78111c.set(0);
                return;
            }
        }
        String c18 = this.f78128t.c("lastMod", null);
        if (c18 != null && c18.length() > 0 && ((com.tencent.mobileqq.inject.b) aa.k(com.tencent.mobileqq.inject.b.class)).d().equals(c16)) {
            Bundle bundle2 = new Bundle();
            bundle2.putString("If-Modified-Since", c18);
            bundle = bundle2;
        } else {
            bundle = null;
        }
        try {
            HttpResponse c19 = com.tencent.mobileqq.webview.util.g.c(this.f78127s, MsfSdkUtils.insertMtype(AppConstants.HTTP_TYPE_QB_OFFLINE, "https://pub.idqqimg.com/qqmobile/config/webview_whitelist2.json"), Uri.parse("https://pub.idqqimg.com/qqmobile/config/webview_whitelist2.json").getHost(), "GET", null, bundle);
            if (c19 != null) {
                int statusCode = c19.getStatusLine().getStatusCode();
                if (QLog.isColorLevel()) {
                    QLog.d("AuthorizeConfig", 2, "status code: " + String.valueOf(statusCode));
                }
                if (statusCode == 200) {
                    Header firstHeader = c19.getFirstHeader("Last-Modified");
                    if (firstHeader != null) {
                        str2 = firstHeader.getValue();
                    }
                    m0(com.tencent.mobileqq.webview.util.g.d(c19), str2, "lastMod");
                    ((com.tencent.mobileqq.webview.swift.injector.m) aa.k(com.tencent.mobileqq.webview.swift.injector.m.class)).a(null, "P_CliOper", IPublicAccountHandler.MAIN_ACTION, "", "webview_whitelist", "update_success", 1, 1, 0, "", "", "", "");
                    return;
                }
                if (statusCode == 304) {
                    this.f78111c.set(2);
                    long currentTimeMillis = System.currentTimeMillis();
                    C = currentTimeMillis;
                    this.f78128t.d("lastUpdate", Long.valueOf(currentTimeMillis)).a();
                    ((com.tencent.mobileqq.webview.swift.injector.m) aa.k(com.tencent.mobileqq.webview.swift.injector.m.class)).a(null, "P_CliOper", IPublicAccountHandler.MAIN_ACTION, "", "webview_whitelist", "update_not_modify", 1, 1, 0, "", "", "", "");
                    return;
                }
            }
        } catch (Exception e17) {
            if (QLog.isColorLevel()) {
                QLog.d("AuthorizeConfig", 2, "update error: " + e17);
            }
        }
        this.f78111c.set(0);
        ((com.tencent.mobileqq.webview.swift.injector.m) aa.k(com.tencent.mobileqq.webview.swift.injector.m.class)).a(null, "P_CliOper", IPublicAccountHandler.MAIN_ACTION, "", "webview_whitelist", "update_failed", 1, 1, 0, "", "", "", "");
    }

    private void o0() {
        k();
        p0();
    }

    private boolean p(String str, String str2, Uri uri) {
        if ("identification.loginVerify".equals(str2)) {
            return true;
        }
        if (("identification.identifyNoLogin".equals(str2) && D.contains(uri.getHost())) || "faceUnblockCamera.startPTVActivity".equals(str2)) {
            return true;
        }
        if ("qbizApi.getClientInfo".equals(str2) && str.startsWith("https://mysec.qq.com/v2/account_control/index.html")) {
            return true;
        }
        return false;
    }

    private boolean r() {
        Iterator<s43.b> it = this.f78109a.iterator();
        while (it.hasNext()) {
            if (it.next().d()) {
                return true;
            }
        }
        return false;
    }

    private String s0(String str, String str2) {
        if (str.startsWith(str2)) {
            return str.substring(str2.length());
        }
        return str;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x00b5 A[Catch: all -> 0x010a, LOOP:0: B:25:0x00b3->B:26:0x00b5, LOOP_END, TryCatch #4 {, blocks: (B:11:0x0019, B:13:0x0023, B:47:0x002a, B:49:0x0037, B:51:0x003d, B:37:0x00d0, B:39:0x00d6, B:40:0x00ee, B:42:0x00f2, B:43:0x00f8, B:44:0x00fd, B:45:0x00fe, B:55:0x005c, B:57:0x0062, B:16:0x0089, B:20:0x0094, B:22:0x00a4, B:26:0x00b5, B:28:0x00bf, B:30:0x00c5, B:32:0x00af, B:61:0x0108), top: B:10:0x0019 }] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00c5 A[Catch: all -> 0x010a, TryCatch #4 {, blocks: (B:11:0x0019, B:13:0x0023, B:47:0x002a, B:49:0x0037, B:51:0x003d, B:37:0x00d0, B:39:0x00d6, B:40:0x00ee, B:42:0x00f2, B:43:0x00f8, B:44:0x00fd, B:45:0x00fe, B:55:0x005c, B:57:0x0062, B:16:0x0089, B:20:0x0094, B:22:0x00a4, B:26:0x00b5, B:28:0x00bf, B:30:0x00c5, B:32:0x00af, B:61:0x0108), top: B:10:0x0019 }] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00d0 A[Catch: all -> 0x010a, TryCatch #4 {, blocks: (B:11:0x0019, B:13:0x0023, B:47:0x002a, B:49:0x0037, B:51:0x003d, B:37:0x00d0, B:39:0x00d6, B:40:0x00ee, B:42:0x00f2, B:43:0x00f8, B:44:0x00fd, B:45:0x00fe, B:55:0x005c, B:57:0x0062, B:16:0x0089, B:20:0x0094, B:22:0x00a4, B:26:0x00b5, B:28:0x00bf, B:30:0x00c5, B:32:0x00af, B:61:0x0108), top: B:10:0x0019 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private JSONArray u(String str) {
        JSONArray jSONArray;
        JSONException e16;
        JSONArray jSONArray2;
        JSONException e17;
        int i3;
        if (TextUtils.isEmpty(str)) {
            return new JSONArray();
        }
        JSONArray jSONArray3 = this.f78125q.get(str);
        if (jSONArray3 == null) {
            synchronized (this.f78125q) {
                jSONArray3 = this.f78125q.get(str);
                if (jSONArray3 == null) {
                    jSONArray3 = A(str);
                    if (jSONArray3 == null) {
                        try {
                            jSONArray = new JSONArray(A.get(str));
                        } catch (JSONException e18) {
                            jSONArray = jSONArray3;
                            e16 = e18;
                        }
                        try {
                            if (QLog.isColorLevel()) {
                                QLog.e("AuthorizeConfig", 2, "Load local default config for " + str);
                            }
                        } catch (JSONException e19) {
                            e16 = e19;
                            if (QLog.isColorLevel()) {
                                QLog.e("AuthorizeConfig", 2, "Decode builtin " + str + " config failed " + e16.getMessage());
                            }
                            jSONArray3 = jSONArray;
                            if (jSONArray3 == null) {
                            }
                            this.f78125q.put(str, jSONArray3);
                            this.f78126r.remove(str);
                            return jSONArray3;
                        }
                        jSONArray3 = jSONArray;
                    } else if ("pskey".equals(str)) {
                        try {
                            jSONArray2 = new JSONArray(A.get("pskey"));
                        } catch (JSONException e26) {
                            jSONArray2 = null;
                            e17 = e26;
                        }
                        try {
                            i3 = jSONArray2.length();
                        } catch (JSONException e27) {
                            e17 = e27;
                            e17.printStackTrace();
                            i3 = 0;
                            while (r3 < i3) {
                            }
                            if (QLog.isColorLevel()) {
                            }
                            if (jSONArray3 == null) {
                            }
                            this.f78125q.put(str, jSONArray3);
                            this.f78126r.remove(str);
                            return jSONArray3;
                        }
                        for (int i16 = 0; i16 < i3; i16++) {
                            jSONArray3.mo162put(jSONArray2.optString(i16));
                        }
                        if (QLog.isColorLevel()) {
                            QLog.d("AuthorizeConfig", 2, "p_skey need merge server and local config");
                        }
                    }
                    if (jSONArray3 == null) {
                        if (QLog.isColorLevel()) {
                            QLog.e("AuthorizeConfig", 2, str + " config is null, please check server and local configuration!");
                        }
                        if (!B) {
                            jSONArray3 = new JSONArray();
                        } else {
                            throw new NullPointerException();
                        }
                    }
                    this.f78125q.put(str, jSONArray3);
                    this.f78126r.remove(str);
                }
            }
        }
        return jSONArray3;
    }

    private JSONObject w() {
        JSONObject jSONObject = this.f78113e;
        System.currentTimeMillis();
        if (jSONObject == null) {
            String b16 = this.f78129u.b();
            if (b16 != null) {
                try {
                    jSONObject = new JSONObject(b16);
                } catch (JSONException unused) {
                    if (QLog.isColorLevel()) {
                        QLog.d("AuthorizeConfig", 2, "Decode mExtraConfig error");
                    }
                }
            }
            if (jSONObject == null) {
                jSONObject = new JSONObject();
            }
            this.f78113e = jSONObject;
        }
        return jSONObject;
    }

    public static AuthorizeConfig y() {
        if (E == null) {
            synchronized (AuthorizeConfig.class) {
                if (E == null) {
                    E = new AuthorizeConfig(BaseApplication.getContext());
                }
            }
        }
        E.d0();
        if (!E.v0(true)) {
            E.p0();
        }
        return E;
    }

    public static AuthorizeConfig z(boolean z16) {
        if (E == null) {
            synchronized (AuthorizeConfig.class) {
                if (E == null) {
                    E = new AuthorizeConfig(BaseApplication.getContext());
                }
            }
        }
        E.d0();
        E.v0(z16);
        return E;
    }

    JSONArray A(String str) {
        if (S(MobileQQ.sMobileQQ.peekAppRuntime())) {
            bh bhVar = (bh) am.s().x(757);
            if (bhVar.f202611b) {
                JSONArray a16 = this.f78129u.a(str);
                QLog.w("AuthorizeConfig", 1, "load mqq config for " + str);
                return a16;
            }
            JSONArray b16 = bhVar.b(str);
            QLog.i("AuthorizeConfig", 1, "load manage config for " + str);
            return b16;
        }
        return null;
    }

    void B() {
        Set<String> v3 = v("pskey");
        ArrayList<String> arrayList = new ArrayList<>(v3.size());
        HashSet hashSet = new HashSet(20);
        for (String str : x.f314886a) {
            hashSet.add(str);
        }
        for (String str2 : v3) {
            if (!hashSet.contains(str2)) {
                arrayList.add(str2);
            }
        }
        synchronized (F) {
            this.f78132x = arrayList;
        }
        if (QLog.isColorLevel()) {
            QLog.d("AuthorizeConfig", 2, "[preload] getNeedCacheDomains domains:", Integer.valueOf(v3.size()), " default:", Integer.valueOf(hashSet.size()), " cur:", Integer.valueOf(arrayList.size()));
        }
    }

    public String D(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String[] split = str.split("\\?");
        JSONObject C2 = C();
        boolean z16 = B;
        if (C2.has(split[0])) {
            try {
                return C2.getJSONObject(split[0]).getString("bid");
            } catch (JSONException e16) {
                e16.printStackTrace();
                if (QLog.isColorLevel()) {
                    QLog.d("AuthorizeConfig", 2, "getOfflineId error");
                }
            }
        }
        return null;
    }

    public long E() {
        if (-1 == this.f78124p) {
            this.f78124p = ((Long) this.f78128t.b("publishSeq", 0L)).longValue();
        }
        return this.f78124p;
    }

    public boolean F(final String str, String str2) {
        if (str == null) {
            QLog.e("AuthorizeConfig", 1, "cmdName: " + str2 + ", url is null");
            return false;
        }
        Uri parse = Uri.parse(str);
        String scheme = parse.getScheme();
        if (!((com.tencent.mobileqq.inject.b) aa.k(com.tencent.mobileqq.inject.b.class)).isPublicVersion() && ((Boolean) t.j().b("enableWebviewDebug", Boolean.FALSE)).booleanValue()) {
            if (QLog.isColorLevel()) {
                QLog.d("AuthorizeConfig", 2, "hasCommandRight in debug mode");
            }
            return true;
        }
        if ("file".equals(scheme)) {
            final AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.biz.c
                @Override // java.lang.Runnable
                public final void run() {
                    AuthorizeConfig.V(AppRuntime.this, str);
                }
            }, 16, null, false);
            QLog.e("AuthorizeConfig", 1, "action deprecated with file protocol");
            return false;
        }
        if (!"http".equals(scheme) && !"https".equals(scheme)) {
            QLog.e("AuthorizeConfig", 1, "not http or https, cmdName: " + str2 + ", url: " + str);
            return false;
        }
        if ("data.checkPermission".equals(str2)) {
            boolean startsWith = str.startsWith("https://qqweb.qq.com/m/whitelist/testing/");
            if (!startsWith) {
                QLog.e("AuthorizeConfig", 1, "not http or https, cmdName: " + str2 + ", url: " + str);
            }
            return startsWith;
        }
        if (str2.equals("UrlSaveVerifyV2.validCheck") || str2.startsWith("CAPTCHA.")) {
            return true;
        }
        if (str2.startsWith("login.openSmsPage") && "ti.qq.com".equals(parse.getHost())) {
            return true;
        }
        if ((str2.equals("o3.sendRequest") && "accounts.qq.com".equals(parse.getHost())) || p(str, str2, parse)) {
            return true;
        }
        long currentTimeMillis = System.currentTimeMillis();
        int f16 = this.f78129u.f(parse.getHost(), str2);
        if (QLog.isDevelopLevel()) {
            QLog.i("AuthorizeConfig", 1, "Web_qqbrowser_authorize_hasCommandRight, cost=" + (System.currentTimeMillis() - currentTimeMillis));
        }
        if (lx.b.h(f16)) {
            return true;
        }
        if (lx.b.g(f16)) {
            QLog.e("AuthorizeConfig", 1, "ret: " + f16 + ", cmdName: " + str2 + ", url: " + str);
            return false;
        }
        if (M(str, str2)) {
            return true;
        }
        QLog.e("AuthorizeConfig", 1, "cmdName: " + str2 + ", url: " + str);
        return false;
    }

    public Boolean G(final String str, String str2) {
        int length;
        if (str == null) {
            return Boolean.FALSE;
        }
        Uri parse = Uri.parse(str);
        String scheme = parse.getScheme();
        if ("file".equals(scheme)) {
            final AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.biz.b
                @Override // java.lang.Runnable
                public final void run() {
                    AuthorizeConfig.W(AppRuntime.this, str);
                }
            }, 16, null, false);
            QLog.e("AuthorizeConfig", 1, "action deprecated with file protocol");
            return Boolean.FALSE;
        }
        if (!"http".equals(scheme) && !"https".equals(scheme)) {
            return Boolean.FALSE;
        }
        String host = parse.getHost();
        if (!TextUtils.isEmpty(host)) {
            host = host.toLowerCase();
        }
        JSONObject jSONObject = this.f78114f;
        long currentTimeMillis = System.currentTimeMillis();
        if (jSONObject == null) {
            String c16 = this.f78129u.c();
            if (c16 != null) {
                try {
                    jSONObject = new JSONObject(c16);
                } catch (JSONException unused) {
                    if (QLog.isColorLevel()) {
                        QLog.d("AuthorizeConfig", 2, "Decode mJumpConfig error");
                    }
                }
            }
            StringBuilder sb5 = new StringBuilder();
            sb5.append("[jump] read from pref. len=");
            if (jSONObject == null) {
                length = 0;
            } else {
                length = jSONObject.length();
            }
            sb5.append(length);
            QLog.d("AuthorizeConfig", 1, sb5.toString());
            if (jSONObject == null) {
                try {
                    jSONObject = new JSONObject("{\"host\": [\"*.qq.com\",\"*.tenpay.com\"]}");
                } catch (JSONException unused2) {
                }
                QLog.d("AuthorizeConfig", 1, "[jump] read from default");
            }
            this.f78114f = jSONObject;
        }
        if (!((com.tencent.mobileqq.inject.b) aa.k(com.tencent.mobileqq.inject.b.class)).isPublicVersion()) {
            QLog.i("AuthorizeConfig", 1, "Web_qqbrowser_authorize_hasJumpRight, cost=" + (System.currentTimeMillis() - currentTimeMillis));
        }
        boolean z16 = B;
        try {
            JSONArray jSONArray = jSONObject.getJSONArray("host");
            int length2 = jSONArray.length();
            for (int i3 = 0; i3 < length2; i3++) {
                if (P(jSONArray.optString(i3), host)) {
                    return Boolean.TRUE;
                }
            }
        } catch (JSONException unused3) {
        }
        try {
            JSONArray jSONArray2 = jSONObject.getJSONArray(ZPlanPublishSource.FROM_SCHEME);
            int length3 = jSONArray2.length();
            for (int i16 = 0; i16 < length3; i16++) {
                if (jSONArray2.optString(i16).equals(str2)) {
                    return Boolean.TRUE;
                }
            }
        } catch (JSONException unused4) {
        }
        try {
            JSONArray jSONArray3 = jSONObject.getJSONArray("scheme_a");
            int length4 = jSONArray3.length();
            for (int i17 = 0; i17 < length4; i17++) {
                if (jSONArray3.optString(i17).equals(str2)) {
                    return Boolean.TRUE;
                }
            }
        } catch (JSONException unused5) {
        }
        QLog.e("AuthorizeConfig", 1, "[jump] " + host + " has [" + str2 + "] right: false");
        return Boolean.FALSE;
    }

    public boolean H(final String str, String str2) {
        int length;
        JSONArray optJSONArray;
        if (str == null || "about:blank".equalsIgnoreCase(str)) {
            str = "https://localhost/";
        }
        Uri parse = Uri.parse(str);
        String scheme = parse.getScheme();
        boolean z16 = false;
        if ("file".equals(scheme)) {
            final AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.biz.f
                @Override // java.lang.Runnable
                public final void run() {
                    AuthorizeConfig.X(AppRuntime.this, str);
                }
            }, 16, null, false);
            QLog.e("AuthorizeConfig", 1, "action deprecated with file protocol");
            return false;
        }
        if (!"http".equals(scheme) && !"https".equals(scheme)) {
            return false;
        }
        JSONObject jSONObject = this.f78123o;
        long currentTimeMillis = System.currentTimeMillis();
        if (jSONObject == null) {
            try {
                jSONObject = this.f78129u.e();
            } catch (JSONException unused) {
                if (QLog.isColorLevel()) {
                    QLog.d("AuthorizeConfig", 2, "Decode mSchemeConfig error");
                }
            }
            StringBuilder sb5 = new StringBuilder();
            sb5.append("[scheme] read from pref. len=");
            if (jSONObject == null) {
                length = 0;
            } else {
                length = jSONObject.length();
            }
            sb5.append(length);
            QLog.d("AuthorizeConfig", 1, sb5.toString());
            if (jSONObject == null) {
                try {
                    jSONObject = new JSONObject("{\"*.qq.com\":[\"*\"],\"*.tencent.com\":[\"*\"],\"*.soso.com\":[\"*\"],\"*.paipai.com\":[\"*\"],\"*.tenpay.com\":[\"*\"],\"*.yixun.com\":[\"*\"],\"*.myapp.com\":[\"*\"],\"*.wanggou.com\":[\"*\"],\"*.qzone.com\":[\"*\"],\"*.weishi.com\":[\"*\"],\"*.weiyun.com\":[\"*\"],\"*\":[\"tel\",\"sms\",\"http\",\"https\",\"file\", \"mqqc2b\"]}");
                } catch (JSONException unused2) {
                }
                QLog.d("AuthorizeConfig", 1, "[scheme] read from default");
            }
            boolean z17 = B;
            this.f78123o = jSONObject;
        }
        if (!((com.tencent.mobileqq.inject.b) aa.k(com.tencent.mobileqq.inject.b.class)).isPublicVersion()) {
            QLog.i("AuthorizeConfig", 1, "Web_qqbrowser_authorize_hasSchemeRight, cost=" + (System.currentTimeMillis() - currentTimeMillis));
        }
        JSONArray names = jSONObject.names();
        String host = parse.getHost();
        if (names != null) {
            if (!TextUtils.isEmpty(host)) {
                host = host.toLowerCase();
            }
            int length2 = names.length();
            boolean z18 = false;
            for (int i3 = 0; i3 < length2; i3++) {
                String optString = names.optString(i3);
                if (P(optString, host) && (optJSONArray = jSONObject.optJSONArray(optString)) != null) {
                    int length3 = optJSONArray.length();
                    int i16 = 0;
                    while (true) {
                        if (i16 >= length3) {
                            break;
                        }
                        if (P(optJSONArray.optString(i16), str2)) {
                            z18 = true;
                            break;
                        }
                        i16++;
                    }
                }
            }
            z16 = z18;
        }
        if (QLog.isDevelopLevel()) {
            QLog.i("AuthorizeConfig", 1, "[scheme] " + host + " has [" + str2 + "] right: " + z16);
        } else if (!z16) {
            QLog.e("AuthorizeConfig", 1, "[scheme] " + host + " has [" + str2 + "] right: " + z16);
        }
        return z16;
    }

    public boolean I(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                if (this.f78120l == null && !e0()) {
                    if (QLog.isColorLevel()) {
                        QLog.d("AuthorizeConfig", 2, "forceHttpsExcludeConfig loadfromsp fail , url: " + s.d(str, new String[0]));
                    }
                    return false;
                }
                if (this.f78120l == null) {
                    return false;
                }
                String host = Uri.parse(str).getHost();
                int length = this.f78120l.length();
                if (length != 0 && !TextUtils.isEmpty(host)) {
                    String lowerCase = host.toLowerCase();
                    for (int i3 = 0; i3 < length; i3++) {
                        String optString = this.f78120l.optString(i3, "");
                        if (!TextUtils.isEmpty(optString)) {
                            if (!TextUtils.equals(lowerCase, optString)) {
                                if (lowerCase.endsWith("." + optString)) {
                                }
                            }
                            if (QLog.isColorLevel()) {
                                QLog.d("AuthorizeConfig", 2, "forceHttpsExcludeConfig hit , url: " + s.d(str, new String[0]) + " domain: " + optString);
                                return true;
                            }
                            return true;
                        }
                    }
                }
            } else if (QLog.isColorLevel()) {
                QLog.d("AuthorizeConfig", 2, "forceHttpsExcludeConfig check fail , url empty!");
            }
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.e("AuthorizeConfig", 2, "forceHttpsExcludeConfig check exception", e16);
            }
        }
        return false;
    }

    public boolean J(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                if (this.f78119k == null && !e0()) {
                    if (QLog.isColorLevel()) {
                        QLog.d("AuthorizeConfig", 2, "forceHttpsConfig loadfromsp fail , url: " + s.d(str, new String[0]));
                    }
                    return false;
                }
                if (this.f78119k == null) {
                    return false;
                }
                String host = Uri.parse(str).getHost();
                int length = this.f78119k.length();
                if (length != 0 && !TextUtils.isEmpty(host)) {
                    String lowerCase = host.toLowerCase();
                    for (int i3 = 0; i3 < length; i3++) {
                        String optString = this.f78119k.optString(i3, "");
                        if (!TextUtils.isEmpty(optString)) {
                            if (!TextUtils.equals(lowerCase, optString)) {
                                if (lowerCase.endsWith("." + optString)) {
                                }
                            }
                            if (QLog.isColorLevel()) {
                                QLog.d("AuthorizeConfig", 2, "forceHttpsConfig hit , url: " + s.d(str, new String[0]) + " domain: " + optString);
                                return true;
                            }
                            return true;
                        }
                    }
                }
            } else if (QLog.isColorLevel()) {
                QLog.d("AuthorizeConfig", 2, "forceHttpsConfig check fail , url empty!");
            }
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.e("AuthorizeConfig", 2, "forceHttpsConfig check exception", e16);
            }
        }
        return false;
    }

    protected void K(Context context) {
        this.f78127s = context;
        t n3 = t.n(QMMKVFile.FILE_JSAPI, "");
        this.f78128t = n3;
        this.f78129u = new lx.e(n3, null);
        L();
        u0();
    }

    public boolean N(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                if (this.f78116h == null && !a0()) {
                    if (QLog.isColorLevel()) {
                        QLog.d("AuthorizeConfig", 2, "AsyncCheckConfig loadfromsp fail , url: " + s.d(str, new String[0]));
                    }
                    return false;
                }
                if (this.f78116h == null) {
                    return false;
                }
                String host = Uri.parse(str).getHost();
                int length = this.f78116h.length();
                if (length != 0 && !TextUtils.isEmpty(host)) {
                    String lowerCase = host.toLowerCase();
                    for (int i3 = 0; i3 < length; i3++) {
                        String optString = this.f78116h.optString(i3, "");
                        if (!TextUtils.isEmpty(optString)) {
                            if (!TextUtils.equals(lowerCase, optString)) {
                                if (lowerCase.endsWith("." + optString)) {
                                }
                            }
                            if (QLog.isColorLevel()) {
                                QLog.d("AuthorizeConfig", 2, "AsyncCheckConfig hit , url: " + s.d(str, new String[0]) + " domain: " + optString);
                                return true;
                            }
                            return true;
                        }
                    }
                }
            } else if (QLog.isColorLevel()) {
                QLog.d("AuthorizeConfig", 2, "AsyncCheckConfig check fail , url empty!");
            }
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.e("AuthorizeConfig", 2, "AsyncCheckConfig check exception", e16);
            }
        }
        return false;
    }

    public boolean O(@NonNull String str, String str2) {
        Iterator<s43.b> it = this.f78109a.iterator();
        while (it.hasNext()) {
            s43.b next = it.next();
            if (next.getBusinessName().equals(str)) {
                return next.a(str2);
            }
        }
        return false;
    }

    public boolean R(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                if (this.f78117i == null && !f0()) {
                    if (QLog.isColorLevel()) {
                        QLog.d("AuthorizeConfig", 2, "SkipInputWarningConfig loadfromsp fail , url: " + s.d(str, new String[0]));
                    }
                    return false;
                }
                if (this.f78117i == null) {
                    return false;
                }
                String host = Uri.parse(str).getHost();
                int length = this.f78117i.length();
                if (length != 0 && !TextUtils.isEmpty(host)) {
                    String lowerCase = host.toLowerCase();
                    for (int i3 = 0; i3 < length; i3++) {
                        String optString = this.f78117i.optString(i3, "");
                        if (!TextUtils.isEmpty(optString)) {
                            if (!TextUtils.equals(lowerCase, optString)) {
                                if (lowerCase.endsWith("." + optString)) {
                                }
                            }
                            if (QLog.isDevelopLevel()) {
                                QLog.d("AuthorizeConfig", 2, "SkipInputWarningConfig hit , url: " + s.d(str, new String[0]) + " domain: " + optString);
                                return true;
                            }
                            return true;
                        }
                    }
                }
            } else if (QLog.isColorLevel()) {
                QLog.d("AuthorizeConfig", 2, "SkipInputWarningConfig check fail , url empty!");
            }
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.e("AuthorizeConfig", 2, "SkipInputWarningConfig check exception", e16);
            }
        }
        return false;
    }

    public boolean a0() {
        String f16 = q.f();
        if (!TextUtils.isEmpty(f16)) {
            if (QLog.isColorLevel()) {
                QLog.d("AuthorizeConfig", 2, "AsyncCheckConfig sp content: " + f16);
            }
            try {
                this.f78116h = new JSONArray(f16);
            } catch (JSONException e16) {
                if (QLog.isColorLevel()) {
                    QLog.d("AuthorizeConfig", 2, "AsyncCheckConfig load exception: " + e16.getMessage());
                }
            }
        } else if (QLog.isColorLevel()) {
            QLog.d("AuthorizeConfig", 2, "AsyncCheckConfig sp content empty!");
        }
        if (this.f78116h != null) {
            return true;
        }
        return false;
    }

    public boolean b0() {
        String g16 = q.g();
        if (!TextUtils.isEmpty(g16)) {
            if (QLog.isColorLevel()) {
                QLog.d("AuthorizeConfig", 2, "CgiConfig sp content: " + g16);
            }
            try {
                this.f78115g = new JSONArray(g16);
            } catch (JSONException e16) {
                if (QLog.isColorLevel()) {
                    QLog.d("AuthorizeConfig", 2, "CgiConfig load exception: " + e16.getMessage());
                }
            }
        } else if (QLog.isColorLevel()) {
            QLog.d("AuthorizeConfig", 2, "CgiConfig sp content empty!");
        }
        if (this.f78115g != null) {
            return true;
        }
        return false;
    }

    public void c0() {
        s43.a aVar = this.f78110b;
        if (aVar == null) {
            return;
        }
        JSONObject a16 = aVar.a();
        if (a16 != null) {
            Iterator<s43.b> it = this.f78109a.iterator();
            while (it.hasNext()) {
                it.next().c(a16);
            }
            return;
        }
        QLog.d("AuthorizeConfig", 1, "WebViewSwitchAio loadFuncDevWebViewConfig return null");
    }

    protected void d0() {
        long longValue = ((Long) this.f78128t.b("lastUpdate", 0L)).longValue();
        if (longValue != C) {
            t0();
            C = longValue;
            QLog.i("AuthorizeConfig", 1, "loadConfig lastConfigUpdateTs changed.");
        }
    }

    public boolean e0() {
        int i3;
        int d16 = q.d();
        if (d16 == 1) {
            i3 = 1;
        } else {
            i3 = 0;
        }
        this.f78118j = i3;
        String b16 = q.b();
        if (!TextUtils.isEmpty(b16)) {
            if (QLog.isColorLevel()) {
                QLog.d("AuthorizeConfig", 2, "forceHttpsConfig sp content: " + b16);
            }
            try {
                this.f78119k = new JSONArray(b16);
            } catch (JSONException e16) {
                if (QLog.isColorLevel()) {
                    QLog.d("AuthorizeConfig", 2, "forceHttpsConfig load exception: " + e16.getMessage());
                }
            }
        } else if (QLog.isColorLevel()) {
            QLog.d("AuthorizeConfig", 2, "forceHttpsConfig sp content empty!");
        }
        String c16 = q.c();
        if (!TextUtils.isEmpty(c16)) {
            if (QLog.isColorLevel()) {
                QLog.d("AuthorizeConfig", 2, "forceHttpsExcludeConfig sp content: " + c16);
            }
            try {
                this.f78120l = new JSONArray(c16);
            } catch (JSONException e17) {
                if (QLog.isColorLevel()) {
                    QLog.d("AuthorizeConfig", 2, "forceHttpsExcludeConfig load exception: " + e17.getMessage());
                }
            }
        } else if (QLog.isColorLevel()) {
            QLog.d("AuthorizeConfig", 2, "forceHttpsExcludeConfig sp content empty!");
        }
        if (d16 == -1 || this.f78119k == null || this.f78120l == null) {
            return false;
        }
        return true;
    }

    public boolean f0() {
        String e16 = q.e();
        if (!TextUtils.isEmpty(e16)) {
            if (QLog.isColorLevel()) {
                QLog.d("AuthorizeConfig", 2, "SkipInputWarningConfig sp content: " + e16);
            }
            try {
                this.f78117i = new JSONArray(e16);
            } catch (JSONException e17) {
                if (QLog.isColorLevel()) {
                    QLog.d("AuthorizeConfig", 2, "SkipInputWarningConfig load exception: " + e17.getMessage());
                }
            }
        } else if (QLog.isColorLevel()) {
            QLog.d("AuthorizeConfig", 2, "SkipInputWarningConfig sp content empty!");
        }
        if (this.f78117i != null) {
            return true;
        }
        return false;
    }

    public boolean h0(String str) {
        String scheme = Uri.parse(str).getScheme();
        if (!"http".equals(scheme) && !"https".equals(scheme)) {
            return false;
        }
        Set<String> v3 = v(ICustomDataEditor.STRING_ARRAY_PARAM_1);
        String host = Uri.parse(str).getHost();
        if (!TextUtils.isEmpty(host)) {
            host = host.toLowerCase();
        }
        if (v3.contains(host)) {
            return true;
        }
        Iterator<String> it = v3.iterator();
        while (it.hasNext()) {
            if (P(it.next(), host)) {
                return true;
            }
        }
        return false;
    }

    public String i0(String str) {
        return g0(ICustomDataEditor.STRING_ARRAY_PARAM_2, str, v(ICustomDataEditor.STRING_ARRAY_PARAM_2));
    }

    public String j0(String str) {
        return g0("p_skey", str, v("pskey"));
    }

    public void k() {
        AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
        if (!S(waitAppRuntime)) {
            if (QLog.isColorLevel()) {
                QLog.d("AuthorizeConfig", 2, "[preload] cachePreloadPskeyList is not login");
                return;
            }
            return;
        }
        final String account = waitAppRuntime.getAccount();
        long longValue = ((Long) this.f78128t.b("lastPreloadPskey" + account, 0L)).longValue();
        final long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - longValue < 43200000) {
            if (QLog.isColorLevel()) {
                QLog.d("AuthorizeConfig", 1, "[preload] cachePreloadPskeyList too often lastTime:", Long.valueOf(longValue), " interval:", 43200000L);
            }
        } else {
            Runnable runnable = new Runnable() { // from class: com.tencent.biz.AuthorizeConfig.3
                @Override // java.lang.Runnable
                public void run() {
                    AuthorizeConfig.this.B();
                    if (QLog.isColorLevel()) {
                        Object[] objArr = new Object[4];
                        int i3 = 0;
                        objArr[0] = "[preload] preloadPskey list:";
                        ArrayList<String> arrayList = AuthorizeConfig.this.f78132x;
                        if (arrayList != null) {
                            i3 = arrayList.size();
                        }
                        objArr[1] = Integer.valueOf(i3);
                        objArr[2] = " waitPt4Token:";
                        objArr[3] = Boolean.valueOf(AuthorizeConfig.this.f78133y);
                        QLog.d("AuthorizeConfig", 2, objArr);
                    }
                    if (!AuthorizeConfig.this.f78133y) {
                        AuthorizeConfig.this.q0();
                        AuthorizeConfig.this.f78128t.d("lastPreloadPskey" + account, Long.valueOf(currentTimeMillis)).a();
                    }
                }
            };
            if (Looper.myLooper() != Looper.getMainLooper()) {
                runnable.run();
            } else {
                ThreadManagerV2.post(runnable, 8, null, true);
            }
        }
    }

    public String k0(String str) {
        return g0("pt4_token", str, v("pt4_token"));
    }

    public boolean l(String str) {
        if (TextUtils.isEmpty(str) || "about:blank".equalsIgnoreCase(str)) {
            str = "https://localhost/";
        }
        Uri parse = Uri.parse(str);
        String scheme = parse.getScheme();
        if (!"http".equals(scheme) && !"https".equals(scheme)) {
            return false;
        }
        JSONObject jSONObject = this.f78123o;
        long currentTimeMillis = System.currentTimeMillis();
        if (jSONObject == null) {
            try {
                jSONObject = this.f78129u.e();
            } catch (JSONException unused) {
                if (QLog.isColorLevel()) {
                    QLog.d("AuthorizeConfig", 2, "Decode mSchemeConfig error");
                }
            }
            if (jSONObject == null) {
                try {
                    jSONObject = new JSONObject("{\"*.qq.com\":[\"*\"],\"*.tencent.com\":[\"*\"],\"*.soso.com\":[\"*\"],\"*.paipai.com\":[\"*\"],\"*.tenpay.com\":[\"*\"],\"*.yixun.com\":[\"*\"],\"*.myapp.com\":[\"*\"],\"*.wanggou.com\":[\"*\"],\"*.qzone.com\":[\"*\"],\"*.weishi.com\":[\"*\"],\"*.weiyun.com\":[\"*\"],\"*\":[\"tel\",\"sms\",\"http\",\"https\",\"file\", \"mqqc2b\"]}");
                } catch (JSONException unused2) {
                }
            }
            boolean z16 = B;
        }
        if (!((com.tencent.mobileqq.inject.b) aa.k(com.tencent.mobileqq.inject.b.class)).isPublicVersion()) {
            QLog.i("AuthorizeConfig", 1, "Web_qqbrowser_authorize_canGameCenterAddUin, cost=" + (System.currentTimeMillis() - currentTimeMillis));
        }
        JSONArray names = jSONObject.names();
        if (names == null) {
            return false;
        }
        String host = parse.getHost();
        if (!TextUtils.isEmpty(host)) {
            host = host.toLowerCase();
        }
        int length = names.length();
        for (int i3 = 0; i3 < length; i3++) {
            String optString = names.optString(i3);
            if ((optString == null || !optString.equals("*")) && P(optString, host)) {
                return true;
            }
        }
        return false;
    }

    public boolean l0(String str) {
        String scheme = Uri.parse(str).getScheme();
        if (!"http".equals(scheme) && !"https".equals(scheme)) {
            return false;
        }
        String host = Uri.parse(str).getHost();
        if (!TextUtils.isEmpty(host)) {
            host = host.toLowerCase();
        }
        JSONArray u16 = u("skey");
        int length = u16.length();
        for (int i3 = 0; i3 < length; i3++) {
            if (P(u16.optString(i3), host)) {
                return true;
            }
        }
        return false;
    }

    public boolean m(String str) {
        JSONArray jSONArray;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (this.f78122n == null) {
            r0();
        }
        JSONObject jSONObject = this.f78122n;
        if (jSONObject != null) {
            jSONArray = jSONObject.optJSONArray("domainList");
        } else {
            jSONArray = null;
        }
        if (jSONObject == null || jSONArray == null) {
            jSONArray = new JSONArray();
            jSONArray.mo162put("*.vip.qq.com");
        }
        for (int length = jSONArray.length() - 1; length >= 0; length--) {
            if (P(jSONArray.optString(length), str)) {
                return true;
            }
        }
        return false;
    }

    protected void m0(String str, String str2, String str3) throws Exception {
        long currentTimeMillis = System.currentTimeMillis();
        String k3 = this.f78129u.k(this.f78128t, str);
        if (k3 == null) {
            return;
        }
        long j3 = this.f78124p;
        this.f78124p = ((Long) this.f78128t.b("publishSeq", Long.valueOf(this.f78124p))).longValue();
        QLog.i("AuthorizeConfig", 1, "update white list's publishSeq from " + j3 + " to " + this.f78124p + ".");
        if (TextUtils.isEmpty(k3)) {
            this.f78111c.set(2);
            this.f78128t.d("lastUpdate", Long.valueOf(System.currentTimeMillis()));
            this.f78128t.e("qqVersion", ((com.tencent.mobileqq.inject.b) aa.k(com.tencent.mobileqq.inject.b.class)).d());
            this.f78128t.e(str3, str2);
            if (QLog.isColorLevel()) {
                QLog.d("AuthorizeConfig", 2, "White list update completed as version=" + str2);
            }
            ((com.tencent.mobileqq.webview.swift.injector.m) aa.k(com.tencent.mobileqq.webview.swift.injector.m.class)).a(null, "P_CliOper", IPublicAccountHandler.MAIN_ACTION, "", "webview_whitelist", "update_ok", 0, 1, 0, "", "", "", "");
        } else {
            this.f78111c.set(0);
            ((com.tencent.mobileqq.webview.swift.injector.m) aa.k(com.tencent.mobileqq.webview.swift.injector.m.class)).a(null, "P_CliOper", IPublicAccountHandler.MAIN_ACTION, "", "webview_whitelist", "update_failed", 0, 1, 0, "", "", "", "");
            if (QLog.isColorLevel()) {
                QLog.e("AuthorizeConfig", 2, "Authorize config parse failed include: " + k3);
            }
        }
        this.f78128t.a();
        o0();
        this.f78125q.clear();
        this.f78126r.clear();
        if (!((com.tencent.mobileqq.inject.b) aa.k(com.tencent.mobileqq.inject.b.class)).isPublicVersion()) {
            QLog.i("AuthorizeConfig", 1, "Web_qqbrowser_authorize_commitConfig, cost=" + (System.currentTimeMillis() - currentTimeMillis));
        }
    }

    public void p0() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - H < 21600000) {
            return;
        }
        synchronized (G) {
            if (currentTimeMillis - H < 21600000) {
                return;
            }
            H = currentTimeMillis;
            if (MobileQQ.sProcessId != 1) {
                return;
            }
            final AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
            if (!S(waitAppRuntime)) {
                return;
            }
            if (WebAccelerateHelper.getInstance().getWebViewFeatureParams()[3].intValue() == 1) {
                final Set<String> v3 = v("pt4_token");
                if (v3.size() > 0) {
                    Runnable runnable = new Runnable() { // from class: com.tencent.biz.a
                        @Override // java.lang.Runnable
                        public final void run() {
                            AuthorizeConfig.this.Y(waitAppRuntime, v3);
                        }
                    };
                    if (Looper.myLooper() != Looper.getMainLooper()) {
                        runnable.run();
                    } else {
                        ThreadManagerV2.post(runnable, 8, null, true);
                    }
                    this.f78133y = true;
                    return;
                }
                this.f78133y = false;
                q0();
                return;
            }
            QLog.d("AuthorizeConfig", 1, "do not support preload.");
        }
    }

    public boolean q() {
        try {
            if (this.f78118j == -1 && !e0()) {
                if (QLog.isColorLevel()) {
                    QLog.d("AuthorizeConfig", 2, "forceHttpsConfig loadfromsp fail");
                }
                return false;
            }
            if (this.f78118j != 1) {
                return false;
            }
            return true;
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.e("AuthorizeConfig", 2, "forceHttps enable check exception", e16);
            }
            return false;
        }
    }

    public void q0() {
        if (this.f78133y) {
            if (QLog.isColorLevel()) {
                QLog.d("AuthorizeConfig", 2, "[preload] preloadPskey waiting");
                return;
            }
            return;
        }
        final AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
        if (!S(waitAppRuntime)) {
            if (QLog.isColorLevel()) {
                QLog.d("AuthorizeConfig", 2, "[preload] preloadPskey is not login");
                return;
            }
            return;
        }
        final ArrayList arrayList = new ArrayList(20);
        ArrayList<String> arrayList2 = new ArrayList<>();
        synchronized (F) {
            for (int i3 = 0; i3 < this.f78132x.size(); i3++) {
                if (i3 < 20) {
                    arrayList.add(this.f78132x.get(i3));
                } else {
                    arrayList2.add(this.f78132x.get(i3));
                }
            }
            StringBuilder sb5 = new StringBuilder(100);
            sb5.append("[preload] list:");
            sb5.append(arrayList.toString());
            sb5.append(" mPreloadDomains:");
            sb5.append(this.f78132x.size());
            sb5.append(" curDomainList:");
            sb5.append(arrayList.size());
            sb5.append(" leftDomainList:");
            sb5.append(arrayList2.size());
            if (QLog.isColorLevel()) {
                QLog.d("AuthorizeConfig", 2, sb5.toString());
            }
            this.f78132x = arrayList2;
        }
        if (arrayList.size() == 0) {
            return;
        }
        Runnable runnable = new Runnable() { // from class: com.tencent.biz.e
            @Override // java.lang.Runnable
            public final void run() {
                AuthorizeConfig.this.Z(arrayList, waitAppRuntime);
            }
        };
        if (Looper.myLooper() != Looper.getMainLooper()) {
            runnable.run();
        } else {
            ThreadManagerV2.post(runnable, 8, null, true);
        }
    }

    public void r0() {
        if (QLog.isColorLevel()) {
            QLog.i("AuthorizeConfig", 2, "readAndSaveX5PreloadWhiteListConfig from VasQuickUpdateManager.SCID_FUNCDEV_WEBVIEW.");
        }
        AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
        JSONObject o16 = this.f78130v.o(waitAppRuntime, "VASBiz_FuncDev_webview.json", false);
        if (o16 != null && S(waitAppRuntime)) {
            if (QLog.isColorLevel()) {
                QLog.i("AuthorizeConfig", 2, "receive X5PreloadWhiteList data: " + o16.toString());
            }
            JSONArray optJSONArray = o16.optJSONArray("x5PreloadWhiteList");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                this.f78122n = optJSONArray.optJSONObject(0);
            }
        }
    }

    public int s(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        String[] split = str.split("\\?");
        JSONObject C2 = C();
        boolean z16 = B;
        if (C2.has(split[0])) {
            try {
                return C2.getJSONObject(split[0]).getInt("delay");
            } catch (JSONException e16) {
                e16.printStackTrace();
                if (QLog.isColorLevel()) {
                    QLog.d("AuthorizeConfig", 2, "getCheckUpDelayTime error");
                }
            }
        }
        return 0;
    }

    public String t(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String[] split = str.split("\\?");
        JSONObject C2 = C();
        boolean z16 = B;
        if (C2.has(split[0])) {
            try {
                return C2.getJSONObject(split[0]).getString("duck");
            } catch (JSONException e16) {
                e16.printStackTrace();
                if (QLog.isColorLevel()) {
                    QLog.d("AuthorizeConfig", 2, "getCheckUpType error");
                }
            }
        }
        return null;
    }

    public void t0() {
        QLog.i("AuthorizeConfig", 1, "reset()");
        C = -1L;
        this.f78129u.j();
        this.f78123o = null;
        this.f78113e = null;
        this.f78114f = null;
        this.f78112d = null;
        this.f78125q.clear();
        this.f78126r.clear();
    }

    public void u0() {
        synchronized (this) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.f78121m < 1800000 && !r()) {
                return;
            }
            this.f78121m = currentTimeMillis;
            ThreadManagerV2.post(new Runnable() { // from class: com.tencent.biz.AuthorizeConfig.5
                @Override // java.lang.Runnable
                public void run() {
                    AuthorizeConfig.this.c0();
                }
            }, 5, null, false);
        }
    }

    public Set<String> v(String str) {
        if (TextUtils.isEmpty(str)) {
            return new HashSet();
        }
        Set<String> set = this.f78126r.get(str);
        if (set == null) {
            synchronized (this.f78126r) {
                set = this.f78126r.get(str);
                if (set == null) {
                    set = new HashSet<>(32);
                    JSONArray u16 = u(str);
                    if (u16 != null && u16.length() != 0) {
                        int length = u16.length();
                        for (int i3 = 0; i3 < length; i3++) {
                            if ("skey".equals(str)) {
                                set.add(s0(u16.optString(i3, ""), "*."));
                            } else {
                                set.add(u16.optString(i3, ""));
                            }
                        }
                    }
                    this.f78126r.put(str, set);
                    if (QLog.isColorLevel()) {
                        QLog.d("AuthorizeConfig", 2, str + " domain white list: " + set);
                    }
                }
            }
        }
        return set;
    }

    protected boolean v0(boolean z16) {
        long j3;
        if (Q()) {
            this.f78111c.set(1);
            if (z16) {
                j3 = 5000;
            } else {
                j3 = 0;
            }
            ThreadManagerV2.executeDelay(new Runnable() { // from class: com.tencent.biz.AuthorizeConfig.1
                @Override // java.lang.Runnable
                public void run() {
                    AuthorizeConfig.this.o();
                }
            }, 128, null, true, j3);
            return true;
        }
        return false;
    }

    public String x(String str, String str2) {
        return w().optString(str, str2);
    }
}
