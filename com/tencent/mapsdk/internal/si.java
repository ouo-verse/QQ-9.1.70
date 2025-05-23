package com.tencent.mapsdk.internal;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.component.media.image.ProgressTracer;
import com.tencent.map.lib.models.CommandFunctionModelClass;
import com.tencent.map.lib.models.ReturnInfoModelClass;
import com.tencent.map.sdk.comps.vis.VisualLayer;
import com.tencent.map.sdk.comps.vis.VisualLayerOptions;
import com.tencent.map.tools.Callback;
import com.tencent.map.tools.Condition;
import com.tencent.map.tools.Util;
import com.tencent.map.tools.json.JsonUtils;
import com.tencent.map.tools.net.NetRequest;
import com.tencent.map.tools.net.NetResponse;
import com.tencent.mapsdk.core.utils.log.LogUtil;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes9.dex */
public class si extends bo implements eg {

    /* renamed from: b, reason: collision with root package name */
    private Map<String, sd> f150216b;

    /* renamed from: c, reason: collision with root package name */
    private Map<String, AtomicInteger> f150217c;

    /* renamed from: d, reason: collision with root package name */
    private File f150218d;

    /* renamed from: e, reason: collision with root package name */
    private File f150219e;

    /* renamed from: f, reason: collision with root package name */
    private String f150220f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f150221g;

    /* renamed from: h, reason: collision with root package name */
    private List<el> f150222h;

    /* renamed from: i, reason: collision with root package name */
    private em f150223i;

    /* renamed from: j, reason: collision with root package name */
    private b f150224j;

    /* renamed from: k, reason: collision with root package name */
    private Set<String> f150225k;

    /* renamed from: l, reason: collision with root package name */
    private boolean f150226l;

    /* compiled from: P */
    /* renamed from: com.tencent.mapsdk.internal.si$5, reason: invalid class name */
    /* loaded from: classes9.dex */
    static /* synthetic */ class AnonymousClass5 {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f150235a;

        static {
            int[] iArr = new int[eh.values().length];
            f150235a = iArr;
            try {
                iArr[eh.Gradient.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f150235a[eh.Aggregation.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f150235a[eh.ArcLine.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f150235a[eh.GLModel.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    class a extends mc implements lv {

        /* renamed from: a, reason: collision with root package name */
        final String f150236a;

        /* renamed from: b, reason: collision with root package name */
        Callback<byte[]> f150237b;

        /* renamed from: c, reason: collision with root package name */
        lw f150238c = new lw();

        /* renamed from: e, reason: collision with root package name */
        private final String f150240e;

        /* renamed from: f, reason: collision with root package name */
        private ByteArrayOutputStream f150241f;

        /* renamed from: g, reason: collision with root package name */
        private String f150242g;

        public a(String str, String str2) {
            this.f150240e = str;
            this.f150236a = str2;
        }

        @Override // com.tencent.mapsdk.internal.lv
        public final void a(String str, lx lxVar) {
        }

        @Override // com.tencent.mapsdk.internal.lv
        public final void b(String str) {
            LogUtil.b(ky.f149119y, "#cancel download {" + this.f150240e + "} [" + str + "]");
            ku.a(this.f150241f);
            sd n3 = si.this.n(this.f150240e);
            if (n3 != null) {
                n3.a(1);
            }
        }

        @Override // com.tencent.mapsdk.internal.lv
        public final void c(String str) {
            byte[] bArr;
            int i3;
            LogUtil.b(ky.f149119y, "#completed download {" + this.f150240e + "} [" + str + "]");
            this.f150238c.b(this);
            if (this.f150237b != null) {
                byte[] byteArray = this.f150241f.toByteArray();
                if ("gzip".equals(this.f150242g)) {
                    bArr = kw.a(new ByteArrayInputStream(byteArray));
                } else {
                    bArr = byteArray;
                }
                StringBuilder sb5 = new StringBuilder("\u6570\u636e\u91cf\u5927\u5c0f {");
                sb5.append(this.f150240e);
                sb5.append("} [");
                int i16 = 0;
                if (byteArray != null) {
                    i3 = byteArray.length;
                } else {
                    i3 = 0;
                }
                sb5.append(i3);
                sb5.append(ProgressTracer.SEPARATOR);
                if (bArr != null) {
                    i16 = bArr.length;
                }
                sb5.append(i16);
                sb5.append("]result:");
                sb5.append(new String(bArr));
                LogUtil.b(ky.f149119y, sb5.toString());
                this.f150237b.callback(bArr);
            }
            ku.a(this.f150241f);
        }

        @Override // com.tencent.mapsdk.internal.lv
        public final void d(String str) {
            LogUtil.b(ky.f149119y, "#fail download {" + this.f150240e + "} [" + str + "]");
            ku.a(this.f150241f);
            sd n3 = si.this.n(this.f150240e);
            if (n3 != null) {
                n3.a(1);
            }
        }

        @Override // com.tencent.mapsdk.internal.lv
        public final void a(String str) {
            LogUtil.b(ky.f149119y, "#start download {" + this.f150240e + "} [" + str + "]");
            this.f150241f = new ByteArrayOutputStream();
        }

        @Override // com.tencent.mapsdk.internal.lv
        public final void a(String str, byte[] bArr) {
            if (bArr != null) {
                try {
                    this.f150241f.write(bArr);
                } catch (IOException e16) {
                    e16.printStackTrace();
                }
            }
        }

        @Override // com.tencent.mapsdk.internal.mc
        public final void a(NetRequest.NetRequestBuilder netRequestBuilder) {
            super.a(netRequestBuilder);
            LogUtil.b(ky.f149119y, "#onPreConnect gzip {" + this.f150240e + "}");
            netRequestBuilder.gzip();
        }

        @Override // com.tencent.mapsdk.internal.mc
        public final void a(NetResponse netResponse) {
            super.a(netResponse);
            this.f150242g = netResponse.contentEncoding;
        }

        private void a(Callback<byte[]> callback) {
            this.f150238c.a(this);
            this.f150238c.a(this.f150236a, this);
            this.f150237b = callback;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static class b extends Handler {

        /* renamed from: a, reason: collision with root package name */
        WeakReference<si> f150243a;

        public b(si siVar) {
            super(Looper.myLooper());
            this.f150243a = new WeakReference<>(siVar);
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            super.handleMessage(message);
            si siVar = this.f150243a.get();
            if (siVar != null && message.what != 0) {
                String str = (String) message.obj;
                int i3 = message.arg2;
                if (message.arg1 > 0) {
                    if (i3 > 0) {
                        LogUtil.b(ky.f149119y, "\u5faa\u73af\u5237\u65b0[" + str + "]\u6b21\u6570[" + i3 + "]");
                        si.a(siVar, str);
                    }
                    message.arg2 = i3 + 1;
                    sendMessageDelayed(Message.obtain(message), r6.arg1);
                }
            }
        }
    }

    /* JADX WARN: Type inference failed for: r0v10, types: [com.tencent.tencentmap.mapsdk.maps.TencentMap] */
    /* JADX WARN: Type inference failed for: r0v4, types: [com.tencent.tencentmap.mapsdk.maps.TencentMap] */
    private String h(String str) {
        CommandFunctionModelClass.BaseCommandFunction a16 = sh.a(str);
        if (a16 == null) {
            return sh.a(new ReturnInfoModelClass.ErrorReturnInfo(ReturnInfoModelClass.ErrorReturnInfo.ErrorMsg.jsonparse));
        }
        String str2 = a16.commandFunction;
        if (TextUtils.isEmpty(str2)) {
            return sh.a(new ReturnInfoModelClass.ErrorReturnInfo(ReturnInfoModelClass.ErrorReturnInfo.ErrorMsg.unsupported));
        }
        LogUtil.b(ky.f149119y, "executeCommand functionType: [" + str2 + "]");
        CommandFunctionModelClass.BaseCommandFunction a17 = sh.a(str, str2);
        if (getMapContext().f147916c.getMap().getVisualSettings() != null) {
            ReturnInfoModelClass.ReturnStatus executeVisualLayerSettings = getMapContext().f147916c.getMap().getVisualSettings().executeVisualLayerSettings(a17);
            LogUtil.b(ky.f149119y, "executeCommand returnJson:" + sh.a(executeVisualLayerSettings));
            return sh.a(executeVisualLayerSettings);
        }
        return sh.a(new ReturnInfoModelClass.ErrorReturnInfo(ReturnInfoModelClass.ErrorReturnInfo.ErrorMsg.internal.bindErrorMsg("visualsettings is null")));
    }

    private void i(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        kt.b(this.f150219e);
        kt.a(this.f150219e, str.getBytes());
    }

    private void j(String str) {
        LogUtil.b(ky.f149119y, "#refreshLayerData[" + str + "]");
        sd sdVar = this.f150216b.get(str);
        if (sdVar != null) {
            sdVar.b(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public File k(String str) {
        return new File(new File(this.f150218d, Util.getMD5String(o(str))), "cache.dat");
    }

    private File l(String str) {
        return new File(this.f150218d, Util.getMD5String(o(str)));
    }

    private el m(String str) {
        final String o16 = o(str);
        return (el) Util.singleWhere(new ArrayList(this.f150222h), new Condition<el>() { // from class: com.tencent.mapsdk.internal.si.3
            private boolean a(el elVar) {
                if (elVar != null && elVar.f148197a.equals(o16)) {
                    return true;
                }
                return false;
            }

            @Override // com.tencent.map.tools.Condition
            public final /* synthetic */ boolean condition(el elVar) {
                el elVar2 = elVar;
                if (elVar2 != null && elVar2.f148197a.equals(o16)) {
                    return true;
                }
                return false;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public sd n(final String str) {
        return (sd) Util.singleWhere(this.f150216b.values(), new Condition<sd>() { // from class: com.tencent.mapsdk.internal.si.4
            private boolean a(sd sdVar) {
                if (sdVar != null && sdVar.getId().equals(str)) {
                    return true;
                }
                return false;
            }

            @Override // com.tencent.map.tools.Condition
            public final /* synthetic */ boolean condition(sd sdVar) {
                sd sdVar2 = sdVar;
                if (sdVar2 != null && sdVar2.getId().equals(str)) {
                    return true;
                }
                return false;
            }
        });
    }

    private static String o(String str) {
        int lastIndexOf;
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        if (str.lastIndexOf("_") == -1) {
            lastIndexOf = str.length();
        } else {
            lastIndexOf = str.lastIndexOf("_");
        }
        return str.substring(0, lastIndexOf);
    }

    @Override // com.tencent.mapsdk.internal.bo
    public final synchronized void a(Context context) {
        super.a(context);
        this.f150216b = new ConcurrentHashMap();
        this.f150217c = new ConcurrentHashMap();
        LogUtil.b(ky.f149119y, "VisualLayerManager onCreate...");
    }

    @Override // com.tencent.mapsdk.internal.bo
    public final synchronized void c_() {
        super.c_();
        Map<String, sd> map = this.f150216b;
        if (map != null) {
            for (sd sdVar : map.values()) {
                if (!sdVar.isRemoved()) {
                    sdVar.remove();
                }
            }
            this.f150216b.clear();
        }
        this.f150217c.clear();
        LogUtil.b(ky.f149119y, "VisualLayerManager onDestroy...");
    }

    @Override // com.tencent.mapsdk.internal.bo
    public final void d(bp bpVar) {
        JSONObject json;
        super.d(bpVar);
        LogUtil.b(ky.f149119y, "#restoreLayerJsonToLocal");
        em emVar = this.f150223i;
        if (emVar != null && this.f150221g && (json = emVar.toJson()) != null) {
            i(json.toString());
        }
        sh.b();
        LogUtil.b(ky.f149119y, "\u9000\u51fa\u6570\u636e\u56fe\u5c42\u6210\u529f");
    }

    @Override // com.tencent.mapsdk.internal.eg
    public final boolean e(String str) {
        sd n3;
        LogUtil.b(ky.f149119y, "#checkLayerStatusById[" + str + "]");
        if (this.f150221g) {
            el m3 = m(str);
            if (m3 != null && (n3 = n(str)) != null) {
                int i3 = AnonymousClass5.f150235a[eh.a(m3.f148198b).ordinal()];
                if (i3 == 1) {
                    n3.f150186b = new sg();
                } else if (i3 == 2) {
                    n3.f150186b = new sb();
                } else if (i3 == 3) {
                    n3.f150186b = new sc();
                } else if (i3 == 4) {
                    n3.f150186b = new sf();
                }
            }
            if (m3 != null) {
                return true;
            }
        }
        return false;
    }

    @Override // com.tencent.mapsdk.internal.eg
    public final void f(String str) {
        LogUtil.d(ky.f149119y, "\u6dfb\u52a0\u5230\u7b49\u5f85\u961f\u5217[" + str + "]");
        this.f150225k.add(str);
    }

    @Override // com.tencent.mapsdk.internal.eg
    public final void g(String str) {
        String o16 = o(str);
        LogUtil.b(ky.f149119y, "#stopTimeInterval[" + str + "]");
        if (!TextUtils.isEmpty(o16)) {
            this.f150224j.removeMessages(o16.hashCode());
        }
    }

    @Override // com.tencent.mapsdk.internal.eg
    public final void b(String str) {
        LogUtil.b(ky.f149119y, "#removeLayer[" + str + "]");
        Map<String, sd> map = this.f150216b;
        if (map != null) {
            map.remove(str);
        }
        g(str);
    }

    @Override // com.tencent.mapsdk.internal.eg
    public final void c(String str) {
        LogUtil.b(ky.f149119y, "#clearCache[" + str + "]");
        if (str == null || TextUtils.isEmpty(str)) {
            return;
        }
        File l3 = l(str);
        LogUtil.b(ky.f149119y, "\u6267\u884c\u5220\u9664\u6587\u4ef6[" + l3 + "]");
        kt.f(l3);
        a(str, 0, 0);
    }

    private void f() {
        JSONObject json;
        LogUtil.b(ky.f149119y, "#restoreLayerJsonToLocal");
        em emVar = this.f150223i;
        if (emVar == null || !this.f150221g || (json = emVar.toJson()) == null) {
            return;
        }
        i(json.toString());
    }

    private boolean b(JSONObject jSONObject) {
        LogUtil.b(ky.f149119y, "#parseLayerInfoJson:".concat(String.valueOf(jSONObject)));
        em emVar = (em) JsonUtils.parseToModel(jSONObject, em.class, new Object[0]);
        if (emVar != null) {
            this.f150221g = emVar.a();
            this.f150222h.clear();
            List<el> list = emVar.f148206a;
            if (list != null && !list.isEmpty()) {
                this.f150222h.addAll(list);
            }
            LogUtil.b(ky.f149119y, "\u89e3\u6790LayerInfo\u6570\u636e\u6210\u529f");
            this.f150223i = emVar;
            return true;
        }
        LogUtil.d(ky.f149119y, "\u89e3\u6790LayerInfo\u6570\u636e\u5931\u8d25");
        return false;
    }

    @Override // com.tencent.mapsdk.internal.bo
    public final void a(bp bpVar) {
        super.a(bpVar);
        this.f150226l = false;
        this.f150224j = new b(this);
        this.f150222h = new CopyOnWriteArrayList();
        this.f150225k = new HashSet();
        this.f150220f = bpVar.D().f147925a;
        if (!TextUtils.isEmpty(bpVar.D().f147927c)) {
            this.f150220f = bpVar.D().f147927c;
        }
        this.f150218d = new File(bpVar.C().b(), "visual/".concat(String.valueOf(bpVar.D().c())));
        this.f150219e = new File(this.f150218d, "layerInfo.json");
        LogUtil.b(ky.f149119y, "#datalayer config file [" + this.f150219e + "]");
        LogUtil.b(ky.f149119y, "#loadLayerJsonFromLocal");
        byte[] c16 = kt.c(this.f150219e);
        if (c16 != null && c16.length > 0) {
            try {
                b(new JSONObject(new String(c16)));
            } catch (JSONException e16) {
                e16.printStackTrace();
            }
        }
        sh.a();
    }

    @Override // com.tencent.mapsdk.internal.eg
    public final String d(String str) {
        return l(o(str)).getAbsolutePath();
    }

    private void e() {
        LogUtil.b(ky.f149119y, "#loadLayerJsonFromLocal");
        byte[] c16 = kt.c(this.f150219e);
        if (c16 == null || c16.length <= 0) {
            return;
        }
        try {
            b(new JSONObject(new String(c16)));
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x010b  */
    /* JADX WARN: Removed duplicated region for block: B:17:? A[RETURN, SYNTHETIC] */
    @Override // com.tencent.mapsdk.internal.eg
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void b(String str, Callback<byte[]> callback) {
        boolean z16;
        String str2;
        LogUtil.b(ky.f149119y, "#requestNew[" + str + "]");
        el m3 = m(str);
        String o16 = o(str);
        if (m3 != null) {
            Map<String, sd> map = this.f150216b;
            z16 = true;
            if (map == null || map.get(o16) == null || this.f150216b.get(o16).f150185a <= 0) {
                int i3 = this.f150217c.get(o16).get();
                int i16 = 1;
                while (true) {
                    if (i16 >= i3) {
                        str2 = str;
                        break;
                    }
                    str2 = o16 + "_" + i16;
                    Map<String, sd> map2 = this.f150216b;
                    if (map2 != null && map2.get(str2) != null && this.f150216b.get(str2).f150185a > 0) {
                        break;
                    } else {
                        i16++;
                    }
                }
            } else {
                str2 = o16;
            }
            LogUtil.b(ky.f149119y, "\u56fe\u5c42id[" + str + "] \u9009\u4e3e\u4f5c\u4e3a\u5237\u65b0\u6570\u636e\u7684\u56fe\u5c42id[" + str2 + "]");
            if (!str.equals(str2)) {
                a(str, callback);
                LogUtil.b(ky.f149119y, "\u56fe\u5c42id[" + str + "] \u8bfb\u53d6\u672c\u5730\u56fe\u5c42\u7f13\u5b58\u6570\u636e, \u65e0\u9700\u91cd\u590d\u53d1\u9001\u8bf7\u6c42");
            } else {
                String a16 = m3.a();
                if (!TextUtils.isEmpty(a16)) {
                    String concat = a16.concat("&key=" + this.f150220f);
                    LogUtil.b(ky.f149119y, "\u56fe\u5c42id[" + str + "] \u8bf7\u6c42\u6570\u636e\u7684URL[" + concat + "]");
                    a aVar = new a(o16, concat);
                    aVar.f150238c.a(aVar);
                    aVar.f150238c.a(aVar.f150236a, aVar);
                    aVar.f150237b = callback;
                }
            }
            if (z16) {
                callback.callback(null);
                return;
            }
            return;
        }
        z16 = false;
        if (z16) {
        }
    }

    @Override // com.tencent.mapsdk.internal.eg
    public final VisualLayer a(VisualLayerOptions visualLayerOptions) {
        if (visualLayerOptions == null) {
            return null;
        }
        String layerId = visualLayerOptions.getLayerId();
        LogUtil.b(ky.f149119y, "#createLayer layerId [" + layerId + "]");
        String o16 = o(layerId);
        LogUtil.b(ky.f149119y, "#createLayer baseLayerId [" + o16 + "]");
        sd sdVar = this.f150216b.get(layerId);
        if (sdVar != null) {
            LogUtil.b(ky.f149119y, "#createLayer layerId [" + layerId + "] already exists");
            sdVar.a(visualLayerOptions);
            return sdVar;
        }
        sd sdVar2 = new sd(visualLayerOptions);
        this.f150216b.put(visualLayerOptions.getLayerId(), sdVar2);
        if (this.f150217c.get(o16) != null) {
            this.f150217c.get(o16).incrementAndGet();
        } else {
            this.f150217c.put(o16, new AtomicInteger(1));
        }
        sdVar2.a(this);
        return sdVar2;
    }

    @Override // com.tencent.mapsdk.internal.eg
    public final int a(String str) {
        if (this.f150217c.get(str) != null) {
            LogUtil.b(ky.f149119y, "#getRefCount [" + str + "], refCnt=[" + this.f150217c.get(str).get() + "]");
            return this.f150217c.get(str).get();
        }
        this.f150217c.put(str, new AtomicInteger(1));
        LogUtil.b(ky.f149119y, "#getRefCount [" + str + "], refCnt=[" + this.f150217c.get(str).get() + "]");
        return this.f150217c.get(str).get();
    }

    @Override // com.tencent.mapsdk.internal.eg
    public final void a(String str, int i3, int i16) {
        LogUtil.b(ky.f149119y, "#updateLayerVersionInfo[" + str + "], dv=" + i3 + " sv=" + i16);
        el m3 = m(str);
        if (m3 != null) {
            if (i16 != m3.f148200d) {
                m3.f148201e = null;
            }
            m3.f148200d = i16;
            if (i3 != m3.f148199c) {
                m3.f148201e = null;
            }
            m3.f148199c = i3;
        }
    }

    @Override // com.tencent.mapsdk.internal.eg
    public final boolean a() {
        return this.f150226l;
    }

    @Override // com.tencent.mapsdk.internal.eg
    public final void a(JSONObject jSONObject) {
        boolean z16;
        LogUtil.b(ky.f149119y, "#saveLayerInfosToLocal[" + jSONObject + "]");
        this.f150226l = true;
        if (jSONObject != null) {
            z16 = b(jSONObject);
            if (z16) {
                i(jSONObject.toString());
                if (!this.f150225k.isEmpty()) {
                    LogUtil.b(ky.f149119y, "\u521d\u59cb\u5316\u7b49\u5f85\u961f\u5217\u56fe\u5c42[" + this.f150225k.size() + "]");
                    Iterator<String> it = this.f150225k.iterator();
                    while (it.hasNext()) {
                        sd sdVar = this.f150216b.get(it.next());
                        if (sdVar != null) {
                            sdVar.a(this);
                        }
                    }
                    this.f150225k.clear();
                }
            }
        } else {
            z16 = false;
            this.f150221g = false;
            this.f150222h.clear();
            this.f150223i = null;
        }
        if (z16 && this.f150221g) {
            return;
        }
        Util.foreach(this.f150216b.values(), new Callback<sd>() { // from class: com.tencent.mapsdk.internal.si.1
            private static void a(sd sdVar2) {
                if (sdVar2 != null) {
                    sdVar2.a(2);
                    sdVar2.a();
                }
            }

            @Override // com.tencent.map.tools.Callback
            public final /* synthetic */ void callback(sd sdVar2) {
                sd sdVar3 = sdVar2;
                if (sdVar3 != null) {
                    sdVar3.a(2);
                    sdVar3.a();
                }
            }
        });
    }

    @Override // com.tencent.mapsdk.internal.eg
    public final void a(final String str, final Callback<byte[]> callback) {
        LogUtil.b(ky.f149119y, "#readLayerDataFromCache[" + str + "]");
        if (callback != null) {
            kp.b(new Runnable() { // from class: com.tencent.mapsdk.internal.si.2
                @Override // java.lang.Runnable
                public final void run() {
                    callback.callback(kt.c(si.this.k(str)));
                }
            });
        }
    }

    @Override // com.tencent.mapsdk.internal.eg
    public final void a(String str, byte[] bArr) {
        LogUtil.b(ky.f149119y, "#saveLayerData[" + str + "]");
        File k3 = k(str);
        File e16 = kt.e(k3);
        kt.a(e16, bArr);
        kt.a(e16, k3);
    }

    @Override // com.tencent.mapsdk.internal.eg
    public final void a(String str, int i3) {
        LogUtil.b(ky.f149119y, "#startTimeInterval[" + str + "], hash = " + str.hashCode() + " timeInterval = " + i3);
        if (i3 <= 0 || TextUtils.isEmpty(str)) {
            return;
        }
        this.f150224j.removeMessages(str.hashCode());
        Message.obtain(this.f150224j, str.hashCode(), i3 * 1000, 0, str).sendToTarget();
    }

    /* JADX WARN: Type inference failed for: r5v10, types: [com.tencent.tencentmap.mapsdk.maps.TencentMap] */
    /* JADX WARN: Type inference failed for: r5v4, types: [com.tencent.tencentmap.mapsdk.maps.TencentMap] */
    @Override // com.tencent.mapsdk.internal.eg
    public final String a(VisualLayer visualLayer, String str) {
        if (visualLayer == null) {
            CommandFunctionModelClass.BaseCommandFunction a16 = sh.a(str);
            if (a16 == null) {
                return sh.a(new ReturnInfoModelClass.ErrorReturnInfo(ReturnInfoModelClass.ErrorReturnInfo.ErrorMsg.jsonparse));
            }
            String str2 = a16.commandFunction;
            if (TextUtils.isEmpty(str2)) {
                return sh.a(new ReturnInfoModelClass.ErrorReturnInfo(ReturnInfoModelClass.ErrorReturnInfo.ErrorMsg.unsupported));
            }
            LogUtil.b(ky.f149119y, "executeCommand functionType: [" + str2 + "]");
            CommandFunctionModelClass.BaseCommandFunction a17 = sh.a(str, str2);
            if (getMapContext().f147916c.getMap().getVisualSettings() != null) {
                ReturnInfoModelClass.ReturnStatus executeVisualLayerSettings = getMapContext().f147916c.getMap().getVisualSettings().executeVisualLayerSettings(a17);
                LogUtil.b(ky.f149119y, "executeCommand returnJson:" + sh.a(executeVisualLayerSettings));
                return sh.a(executeVisualLayerSettings);
            }
            return sh.a(new ReturnInfoModelClass.ErrorReturnInfo(ReturnInfoModelClass.ErrorReturnInfo.ErrorMsg.internal.bindErrorMsg("visualsettings is null")));
        }
        if (this.f150216b.containsKey(visualLayer.getId())) {
            return visualLayer.executeCommand(getMapContext().f147916c.getMap(), str);
        }
        return sh.a(new ReturnInfoModelClass.ErrorReturnInfo(ReturnInfoModelClass.ErrorReturnInfo.ErrorMsg.internal.bindErrorMsg("layerId[" + visualLayer.getId() + "] doesn't exists")));
    }

    static /* synthetic */ void a(si siVar, String str) {
        LogUtil.b(ky.f149119y, "#refreshLayerData[" + str + "]");
        sd sdVar = siVar.f150216b.get(str);
        if (sdVar != null) {
            sdVar.b(siVar);
        }
    }
}
