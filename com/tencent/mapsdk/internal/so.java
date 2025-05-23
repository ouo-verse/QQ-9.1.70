package com.tencent.mapsdk.internal;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.map.tools.Callback;
import com.tencent.map.tools.json.JsonUtils;
import com.tencent.map.tools.net.NetManager;
import com.tencent.map.tools.net.NetResponse;
import com.tencent.mapsdk.core.utils.log.LogUtil;
import com.tencent.mapsdk.internal.kp;
import com.tencent.tencentmap.mapsdk.maps.TencentMapOptions;
import com.tencent.tencentmap.mapsdk.maps.model.Language;
import com.tencent.tencentmap.mapsdk.maps.model.OverSeaSource;
import com.tencent.tencentmap.mapsdk.maps.model.OverSeaTileProvider;
import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class so {

    /* renamed from: g, reason: collision with root package name */
    public sw f150355g;

    /* renamed from: h, reason: collision with root package name */
    boolean f150356h;

    /* renamed from: k, reason: collision with root package name */
    public OverSeaTileProvider f150359k;

    /* renamed from: a, reason: collision with root package name */
    public int f150349a = sv.f150401a;

    /* renamed from: b, reason: collision with root package name */
    public int f150350b = 1000;

    /* renamed from: c, reason: collision with root package name */
    public int f150351c = sv.f150403c;

    /* renamed from: d, reason: collision with root package name */
    public int f150352d = 0;

    /* renamed from: e, reason: collision with root package name */
    public volatile boolean f150353e = false;

    /* renamed from: f, reason: collision with root package name */
    public int f150354f = 0;

    /* renamed from: l, reason: collision with root package name */
    private String f150360l = null;

    /* renamed from: i, reason: collision with root package name */
    public OverSeaSource f150357i = OverSeaSource.DEFAULT;

    /* renamed from: j, reason: collision with root package name */
    public Language f150358j = Language.zh;

    /* compiled from: P */
    /* renamed from: com.tencent.mapsdk.internal.so$2, reason: invalid class name */
    /* loaded from: classes9.dex */
    public class AnonymousClass2 extends kp.g<Boolean> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f150363a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ OverSeaSource f150364b;

        public AnonymousClass2(Context context, OverSeaSource overSeaSource) {
            this.f150363a = context;
            this.f150364b = overSeaSource;
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Override // java.util.concurrent.Callable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Boolean call() throws Exception {
            String a16;
            LogUtil.c(ky.f149103i, "\u5f00\u59cb\u521d\u59cb\u5316\u914d\u7f6e");
            Context context = this.f150363a;
            OverSeaSource overSeaSource = this.f150364b;
            my a17 = my.a(context);
            int i3 = AnonymousClass3.f150366a[overSeaSource.ordinal()];
            if (i3 != 1) {
                if (i3 != 2) {
                    a16 = null;
                } else {
                    a16 = a17.a("worldMapConfig_BING");
                }
            } else {
                a16 = a17.a(et.f148304g);
            }
            LogUtil.c(ky.f149103i, "\u672c\u5730\u914d\u7f6e\u6570\u636e\uff1a".concat(String.valueOf(a16)));
            if (!hs.a(a16)) {
                try {
                    so.this.f150355g = (sw) JsonUtils.parseToModel(new JSONObject(a16), sw.class, new Object[0]);
                } catch (JSONException e16) {
                    LogUtil.c(ky.f149103i, e16);
                }
                so soVar = so.this;
                soVar.a(soVar.f150355g);
            } else if (kl.a("5.6.3.2", "4.3.1")) {
                so.this.a(this.f150363a);
            }
            LogUtil.c(ky.f149103i, "\u5b8c\u6210\u521d\u59cb\u5316\u914d\u7f6e");
            return null;
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mapsdk.internal.so$3, reason: invalid class name */
    /* loaded from: classes9.dex */
    public static /* synthetic */ class AnonymousClass3 {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f150366a;

        static {
            int[] iArr = new int[OverSeaSource.values().length];
            f150366a = iArr;
            try {
                iArr[OverSeaSource.DEFAULT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f150366a[OverSeaSource.SPARE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    private int e() {
        return this.f150352d;
    }

    private boolean f() {
        return this.f150353e;
    }

    private int g() {
        return this.f150354f;
    }

    private su h() {
        sv svVar;
        sw swVar = this.f150355g;
        if (swVar == null || (svVar = swVar.f150412b) == null) {
            return null;
        }
        return svVar.f150408h;
    }

    private boolean i() {
        return this.f150356h;
    }

    private OverSeaSource j() {
        return this.f150357i;
    }

    private int k() {
        int i3 = AnonymousClass3.f150366a[this.f150357i.ordinal()];
        if (i3 == 1) {
            return 2;
        }
        if (i3 == 2) {
            return 1;
        }
        return 0;
    }

    private Language l() {
        return this.f150358j;
    }

    private OverSeaTileProvider m() {
        return this.f150359k;
    }

    public final List<ss> c() {
        sw swVar = this.f150355g;
        if (swVar == null) {
            return null;
        }
        if (this.f150359k != null) {
            ArrayList arrayList = new ArrayList(c(this.f150355g.f150412b));
            ss ssVar = new ss();
            ssVar.f150385a = new int[]{0, 18};
            ArrayList arrayList2 = new ArrayList();
            st stVar = new st();
            stVar.f150391b = sm.f150328a;
            stVar.f150397h = true;
            stVar.f150390a = 1;
            stVar.f150392c = this.f150359k.getProviderName();
            stVar.f150395f = this.f150359k.getLogo(true);
            stVar.f150396g = this.f150359k.getLogo(false);
            arrayList2.add(stVar);
            ssVar.f150386b = arrayList2;
            arrayList.add(0, ssVar);
            return arrayList;
        }
        return c(swVar.f150412b);
    }

    public final String d() {
        if (this.f150359k != null) {
            return this.f150359k.getProviderVersion() + File.separator + this.f150358j.name();
        }
        sx b16 = b();
        if (b16 != null) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append(b16.f150415c);
            String str = File.separator;
            sb5.append(str);
            sb5.append(b16.f150414b);
            sb5.append(str);
            sb5.append(b16.f150416d);
            sb5.append(str);
            sb5.append(this.f150358j.name());
            return sb5.toString();
        }
        return "";
    }

    private File b(Context context) {
        return new File(mz.a(context, (TencentMapOptions) null).b(), a());
    }

    private boolean a(Context context, String str) {
        sv svVar;
        boolean z16;
        LogUtil.c(ky.f149103i, "\u5f00\u59cb\u66f4\u65b0\u914d\u7f6e\uff1a".concat(String.valueOf(str)));
        sw swVar = (sw) JsonUtils.parseToModel(str, sw.class, new Object[0]);
        if (swVar != null && (svVar = swVar.f150412b) != null) {
            if (swVar.f150411a != 0) {
                z16 = this.f150353e;
                this.f150353e = false;
            } else {
                z16 = !this.f150353e;
                this.f150353e = true;
            }
            LogUtil.c(ky.f149103i, "\u6743\u9650\u662f\u5426\u66f4\u65b0\uff1a".concat(String.valueOf(z16)));
            boolean z17 = svVar.f150407g != this.f150352d;
            LogUtil.c(ky.f149103i, "\u534f\u8bae\u7248\u672c\u662f\u5426\u66f4\u65b0\uff1a".concat(String.valueOf(z17)));
            if (!z16 && !z17) {
                return false;
            }
            sr a16 = a(svVar);
            if (a16 != null) {
                int i3 = a16.f150383d;
                sx sxVar = a16.f150384e;
                if (sxVar != null) {
                    int i16 = sxVar.f150416d;
                    int i17 = sxVar.f150414b;
                    LogUtil.c(ky.f149103i, "\u7248\u672c\u5bf9\u6bd4: old[" + this.f150351c + "]-new[" + i16 + "]");
                    LogUtil.c(ky.f149103i, "\u6837\u5f0f\u5bf9\u6bd4: old[" + this.f150350b + "]-new[" + i17 + "]");
                    if (i16 != this.f150351c || i17 != this.f150350b || i3 != this.f150349a) {
                        File file = new File(mz.a(context, (TencentMapOptions) null).b(), a());
                        if (file.exists()) {
                            kt.b(file);
                            LogUtil.c(ky.f149103i, "\u5220\u9664\u6d77\u5916\u56fe\u7f13\u5b58\u76ee\u5f55: ".concat(String.valueOf(file)));
                        }
                    }
                }
            }
            su suVar = svVar.f150408h;
            if (suVar != null) {
                String str2 = suVar.f150400b;
                LogUtil.c(ky.f149103i, "\u914d\u7f6e\u8fb9\u754c\u7ebf: ".concat(String.valueOf(str2)));
                a(str2);
                suVar.f150399a = this.f150354f;
            }
            this.f150355g = swVar;
            OverSeaSource overSeaSource = this.f150357i;
            my a17 = my.a(context);
            int i18 = AnonymousClass3.f150366a[overSeaSource.ordinal()];
            if (i18 == 1) {
                a17.a(et.f148304g, str);
            } else if (i18 == 2) {
                a17.a("worldMapConfig_BING", str);
            }
            a(this.f150355g);
            LogUtil.c(ky.f149103i, "\u914d\u7f6e\u66f4\u65b0\u5b8c\u6210");
            return true;
        }
        LogUtil.c(ky.f149103i, "\u914d\u7f6e\u66f4\u65b0\u6570\u636e\u89e3\u6790\u5931\u8d25\uff0c\u4f7f\u7528\u4e0a\u6b21\u7684\u914d\u7f6e");
        return false;
    }

    public final sx b() {
        sw swVar = this.f150355g;
        if (swVar == null) {
            return null;
        }
        return b(swVar.f150412b);
    }

    private sx b(sv svVar) {
        sr a16;
        if (svVar == null || (a16 = a(svVar)) == null) {
            return null;
        }
        return a16.f150384e;
    }

    private static /* synthetic */ String b(Context context, OverSeaSource overSeaSource) {
        my a16 = my.a(context);
        int i3 = AnonymousClass3.f150366a[overSeaSource.ordinal()];
        if (i3 == 1) {
            return a16.a(et.f148304g);
        }
        if (i3 != 2) {
            return null;
        }
        return a16.a("worldMapConfig_BING");
    }

    private static List<ss> c(sv svVar) {
        if (svVar != null) {
            return svVar.f150410j;
        }
        return null;
    }

    public final void a(String str) {
        byte[] b16;
        if (str == null || str.length() == 0) {
            return;
        }
        LogUtil.c(ky.f149103i, "\u4e0b\u8f7d\u65b0\u8fb9\u754c\u6570\u636e\uff1a".concat(str));
        try {
            NetResponse doStream = NetManager.getInstance().builder().gzip().url(str).doStream();
            InputStream inputStream = doStream.getInputStream();
            if (doStream.statusCode == 200) {
                String str2 = TextUtils.isEmpty(doStream.contentEncoding) ? "gzip" : doStream.contentEncoding;
                if (str2 != null && str2.length() > 0 && str2.toLowerCase().contains("gzip")) {
                    b16 = kw.a(inputStream);
                } else {
                    b16 = ku.b(inputStream);
                }
                if (b16 == null || b16.length <= 0) {
                    return;
                }
                String str3 = new String(b16);
                sm.a();
                this.f150354f = sm.b(str3);
                LogUtil.c(ky.f149103i, "\u65b0\u8fb9\u754c\u6570\u636e\u7248\u672c\u53f7\uff1a" + this.f150354f);
                sm.a().a(str3);
            }
        } catch (Throwable th5) {
            LogUtil.c(ky.f149103i, th5);
        }
    }

    public final String a() {
        boolean z16;
        String str;
        OverSeaTileProvider overSeaTileProvider = this.f150359k;
        if (overSeaTileProvider != null) {
            z16 = overSeaTileProvider.onDayNightChange(this.f150356h);
            str = "rastermap/customoversea/" + this.f150359k.getProviderName();
        } else if (AnonymousClass3.f150366a[this.f150357i.ordinal()] != 2) {
            z16 = true;
            str = "rastermap/world";
        } else {
            z16 = false;
            str = "rastermap/bingworld";
        }
        return str + ((this.f150356h && z16) ? "/dark" : "");
    }

    private void a(Context context, OverSeaSource overSeaSource, final Callback<Boolean> callback) {
        if (context == null) {
            return;
        }
        this.f150357i = overSeaSource;
        kp.a((kp.g) new AnonymousClass2(context, overSeaSource)).a((kp.b.a) Boolean.FALSE, (kp.a<kp.b.a>) (callback != null ? new kp.a<Boolean>() { // from class: com.tencent.mapsdk.internal.so.1
            private void a(Boolean bool) {
                callback.callback(bool);
            }

            @Override // com.tencent.mapsdk.internal.kp.a, com.tencent.map.tools.Callback
            public final /* bridge */ /* synthetic */ void callback(Object obj) {
                callback.callback((Boolean) obj);
            }
        } : null));
    }

    private static String a(Context context, OverSeaSource overSeaSource) {
        my a16 = my.a(context);
        int i3 = AnonymousClass3.f150366a[overSeaSource.ordinal()];
        if (i3 == 1) {
            return a16.a(et.f148304g);
        }
        if (i3 != 2) {
            return null;
        }
        return a16.a("worldMapConfig_BING");
    }

    private static void a(Context context, OverSeaSource overSeaSource, String str) {
        my a16 = my.a(context);
        int i3 = AnonymousClass3.f150366a[overSeaSource.ordinal()];
        if (i3 == 1) {
            a16.a(et.f148304g, str);
        } else {
            if (i3 != 2) {
                return;
            }
            a16.a("worldMapConfig_BING", str);
        }
    }

    public final void a(Context context) {
        my a16 = my.a(context);
        LogUtil.c(ky.f149103i, "\u517c\u5bb9\u8001\u6570\u636e");
        int b16 = a16.b(et.f148306i, 1000);
        int b17 = a16.b(et.f148307j, sv.f150401a);
        int b18 = a16.b(et.f148308k, sv.f150403c);
        int b19 = a16.b(et.f148310m, 0);
        boolean c16 = a16.c(et.f148305h);
        String a17 = a16.a(et.f148311n);
        int[] iArr = new int[0];
        try {
            String a18 = a16.a(et.f148312o);
            if (!hs.a(a18)) {
                JSONArray jSONArray = new JSONArray(a18);
                int length = jSONArray.length();
                iArr = new int[length];
                for (int i3 = 0; i3 < length; i3++) {
                    iArr[i3] = jSONArray.getInt(i3);
                }
            }
        } catch (Exception e16) {
            LogUtil.c(ky.f149103i, e16);
        }
        String a19 = a16.a(et.f148313p);
        int b26 = a16.b(et.f148309l, 0);
        sr srVar = new sr();
        srVar.f150383d = 1;
        sx sxVar = new sx();
        sxVar.f150417e = a17;
        sxVar.f150418f = iArr;
        sxVar.f150415c = b17;
        sxVar.f150414b = b16;
        sxVar.f150416d = b18;
        srVar.f150384e = sxVar;
        sv svVar = new sv();
        svVar.f150407g = b19;
        List<ss> list = null;
        try {
            if (!hs.a(a19)) {
                list = JsonUtils.parseToList(new JSONArray(a19), ss.class, new Object[0]);
            }
        } catch (JSONException e17) {
            LogUtil.c(ky.f149103i, e17);
        }
        svVar.f150410j = list;
        ArrayList arrayList = new ArrayList();
        arrayList.add(srVar);
        svVar.f150409i = arrayList;
        su suVar = new su();
        suVar.f150399a = b26;
        svVar.f150408h = suVar;
        sw swVar = new sw();
        this.f150355g = swVar;
        swVar.f150411a = c16 ? 0 : -1;
        swVar.f150412b = svVar;
        String jSONObject = swVar.toJson().toString();
        LogUtil.c(ky.f149103i, "\u8001\u6570\u636e\uff1a".concat(String.valueOf(jSONObject)));
        a16.a(et.f148304g, jSONObject);
        a16.a(new String[]{et.f148306i, et.f148307j, et.f148308k, et.f148310m, et.f148305h, et.f148311n, et.f148312o, et.f148313p, et.f148309l});
        a(this.f150355g);
    }

    public final void a(boolean z16) {
        LogUtil.c(ky.f149103i, "\u4f7f\u7528\u6d77\u5916\u6697\u8272\u6a21\u5f0f\uff1f".concat(String.valueOf(z16)));
        this.f150356h = z16;
    }

    private void a(OverSeaTileProvider overSeaTileProvider) {
        this.f150359k = overSeaTileProvider;
    }

    private void a(Language language) {
        this.f150358j = language;
    }

    public final void a(sw swVar) {
        if (swVar == null) {
            return;
        }
        sv svVar = swVar.f150412b;
        if (svVar != null) {
            this.f150352d = svVar.f150407g;
            LogUtil.c(ky.f149103i, "\u66f4\u65b0\u7248\u672c\uff1a" + this.f150352d);
            su suVar = svVar.f150408h;
            if (suVar != null) {
                this.f150354f = suVar.f150399a;
                LogUtil.c(ky.f149103i, "\u66f4\u65b0\u8fb9\u754c\u7248\u672c\uff1a" + this.f150351c);
            }
        }
        sx b16 = b(svVar);
        if (b16 != null) {
            this.f150350b = b16.f150414b;
            this.f150349a = b16.f150415c;
            this.f150351c = b16.f150416d;
            this.f150360l = b16.f150417e;
            LogUtil.c(ky.f149103i, "\u66f4\u65b0\u56fe\u6e90\u7248\u672c\uff1a" + this.f150351c);
        }
        this.f150353e = swVar.f150411a == 0;
    }

    public final sr a(sv svVar) {
        List<sr> list;
        if (svVar == null || (list = svVar.f150409i) == null) {
            return null;
        }
        for (sr srVar : list) {
            int i3 = srVar.f150383d;
            if (i3 == 2 && this.f150356h) {
                return srVar;
            }
            if (i3 == 1 && !this.f150356h) {
                return srVar;
            }
        }
        return null;
    }
}
