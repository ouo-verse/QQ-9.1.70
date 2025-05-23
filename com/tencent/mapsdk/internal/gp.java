package com.tencent.mapsdk.internal;

import android.support.annotation.MainThread;
import android.text.TextUtils;
import com.tencent.map.tools.Util;
import com.tencent.map.tools.json.JsonComposer;
import com.tencent.map.tools.json.JsonUtils;
import com.tencent.map.tools.json.annotation.Json;
import com.tencent.map.tools.net.NetResponse;
import com.tencent.mapsdk.core.utils.log.LogUtil;
import com.tencent.mapsdk.internal.gn;
import com.tencent.oskplayer.cache.FileDataSink;
import com.tencent.tencentmap.mapsdk.maps.TencentMapOptions;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class gp {

    /* renamed from: i, reason: collision with root package name */
    private static final String f148530i = "stData";

    /* renamed from: a, reason: collision with root package name */
    public int f148531a;

    /* renamed from: b, reason: collision with root package name */
    final f f148532b;

    /* renamed from: c, reason: collision with root package name */
    public final String f148533c;

    /* renamed from: d, reason: collision with root package name */
    public String f148534d;

    /* renamed from: e, reason: collision with root package name */
    public String f148535e;

    /* renamed from: f, reason: collision with root package name */
    final File f148536f;

    /* renamed from: g, reason: collision with root package name */
    final File f148537g;

    /* renamed from: h, reason: collision with root package name */
    volatile boolean f148538h;

    /* renamed from: j, reason: collision with root package name */
    private final String f148539j;

    /* renamed from: k, reason: collision with root package name */
    private final boolean f148540k;

    /* renamed from: l, reason: collision with root package name */
    private d f148541l;

    /* compiled from: P */
    /* renamed from: com.tencent.mapsdk.internal.gp$1, reason: invalid class name */
    /* loaded from: classes9.dex */
    public class AnonymousClass1 implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ a f148542a;

        public AnonymousClass1(a aVar) {
            this.f148542a = aVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            c cVar = c.READ;
            e a16 = e.a(cVar);
            a16.f148562a = b.START;
            File file = gp.this.f148536f;
            a16.f148566e = file;
            byte[] c16 = kt.c(file);
            if (gp.this.f148536f.exists() && c16 != null && c16.length != 0) {
                e a17 = e.a(cVar);
                a17.f148562a = b.PROCESSING;
                a17.f148566e = gp.this.f148536f;
                f fVar = (f) JsonUtils.parseToModel(new String(c16), f.class, new Object[0]);
                e a18 = e.a(cVar);
                a18.f148562a = b.END;
                a18.f148566e = gp.this.f148536f;
                a18.f148564c = true;
                a aVar = this.f148542a;
                if (aVar != null) {
                    aVar.a(fVar);
                    return;
                }
                return;
            }
            e a19 = e.a(cVar);
            a19.f148562a = b.END;
            a19.f148566e = gp.this.f148536f;
            a19.f148564c = false;
            a aVar2 = this.f148542a;
            if (aVar2 != null) {
                aVar2.a(null);
            }
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mapsdk.internal.gp$2, reason: invalid class name */
    /* loaded from: classes9.dex */
    public class AnonymousClass2 implements a<f> {
        public AnonymousClass2() {
        }

        @Override // com.tencent.mapsdk.internal.gp.a
        public final /* synthetic */ void a(f fVar) {
            f fVar2 = fVar;
            if (fVar2 == null || fVar2.a()) {
                return;
            }
            gp.this.a(fVar2, new AnonymousClass1());
        }

        /* compiled from: P */
        /* renamed from: com.tencent.mapsdk.internal.gp$2$1, reason: invalid class name */
        /* loaded from: classes9.dex */
        final class AnonymousClass1 implements a<Boolean> {
            AnonymousClass1() {
            }

            @Override // com.tencent.mapsdk.internal.gp.a
            public final /* synthetic */ void a(Boolean bool) {
                gp.a(gp.this, bool.booleanValue());
            }

            /* renamed from: a, reason: avoid collision after fix types in other method */
            private void a2(Boolean bool) {
                gp.a(gp.this, bool.booleanValue());
            }
        }

        /* renamed from: a, reason: avoid collision after fix types in other method */
        private void a2(f fVar) {
            if (fVar == null || fVar.a()) {
                return;
            }
            gp.this.a(fVar, new AnonymousClass1());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public interface a<T> {
        void a(T t16);
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public enum b {
        START,
        PROCESSING,
        END,
        CANCEL
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public enum c {
        CREATE,
        READ,
        UPLOAD,
        UPLOAD_END,
        WRITE,
        TRANSLATE_BYTE
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public interface d {
        void a();
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static class e {

        /* renamed from: a, reason: collision with root package name */
        b f148562a;

        /* renamed from: b, reason: collision with root package name */
        e f148563b;

        /* renamed from: c, reason: collision with root package name */
        boolean f148564c;

        /* renamed from: d, reason: collision with root package name */
        byte[] f148565d;

        /* renamed from: e, reason: collision with root package name */
        public Object f148566e;

        /* renamed from: f, reason: collision with root package name */
        private c f148567f;

        private e a() {
            return this;
        }

        private c b() {
            return this.f148567f;
        }

        private byte[] c() {
            return this.f148565d;
        }

        private boolean d() {
            return this.f148564c;
        }

        private Object e() {
            return this.f148566e;
        }

        private b f() {
            return this.f148562a;
        }

        public final String toString() {
            String str;
            StringBuffer stringBuffer = new StringBuffer("StatisticState{");
            stringBuffer.append("mState=");
            stringBuffer.append(this.f148567f);
            stringBuffer.append(", mStage=");
            stringBuffer.append(this.f148562a);
            stringBuffer.append(", mParentState=");
            stringBuffer.append(this.f148563b);
            stringBuffer.append(", mResult=");
            stringBuffer.append(this.f148564c);
            stringBuffer.append(", mData=");
            if (this.f148565d == null) {
                stringBuffer.append("null");
            } else {
                stringBuffer.append('[');
                for (int i3 = 0; i3 < this.f148565d.length; i3++) {
                    if (i3 == 0) {
                        str = "";
                    } else {
                        str = ", ";
                    }
                    stringBuffer.append(str);
                    stringBuffer.append((int) this.f148565d[i3]);
                }
                stringBuffer.append(']');
            }
            stringBuffer.append(", mTag=");
            stringBuffer.append(this.f148566e);
            stringBuffer.append('}');
            return stringBuffer.toString();
        }

        public static e a(c cVar) {
            e eVar = new e();
            eVar.f148567f = cVar;
            return eVar;
        }

        private boolean b(c cVar) {
            return cVar == this.f148567f;
        }

        private boolean c(c cVar) {
            e eVar = this.f148563b;
            return eVar != null && cVar == eVar.f148567f;
        }

        private boolean b(c cVar, b bVar) {
            e eVar = this.f148563b;
            return eVar != null && bVar == eVar.f148562a && cVar == eVar.f148567f;
        }

        private e a(e eVar) {
            this.f148563b = eVar;
            return this;
        }

        private e a(b bVar) {
            this.f148562a = bVar;
            return this;
        }

        private e a(byte[] bArr) {
            this.f148565d = bArr;
            return this;
        }

        private e a(boolean z16) {
            this.f148564c = z16;
            return this;
        }

        private e a(Object obj) {
            this.f148566e = obj;
            return this;
        }

        private boolean a(c cVar, b bVar) {
            return bVar == this.f148562a && cVar == this.f148567f;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static class f extends JsonComposer {

        /* renamed from: a, reason: collision with root package name */
        @Json(name = gp.f148530i)
        List<hi> f148568a = new ArrayList();

        /* renamed from: b, reason: collision with root package name */
        @Json(name = "clsData")
        List<gn.b> f148569b = new ArrayList();

        private void d() {
            this.f148568a.clear();
            this.f148569b.clear();
        }

        public final boolean a() {
            return this.f148568a.isEmpty() && this.f148569b.isEmpty();
        }

        public final void a(f fVar) {
            if (fVar == null) {
                return;
            }
            this.f148568a.addAll(fVar.f148568a);
            this.f148569b.addAll(fVar.f148569b);
        }

        public final byte[] b() {
            List<hi> list = this.f148568a;
            if (list == null || list.isEmpty()) {
                return new byte[0];
            }
            String collectionToJson = JsonUtils.collectionToJson(new ArrayList(this.f148568a));
            try {
                LogUtil.b(ky.f149104j, "Post statistic data: ".concat(String.valueOf(collectionToJson)));
                return collectionToJson.getBytes("UTF-8");
            } catch (UnsupportedEncodingException e16) {
                e16.printStackTrace();
                return new byte[0];
            }
        }

        public final byte[] c() {
            List<gn.b> list = this.f148569b;
            if (list == null || list.isEmpty()) {
                return new byte[0];
            }
            gn gnVar = new gn();
            gnVar.a(this.f148569b);
            String modelToJsonString = JsonUtils.modelToJsonString(gnVar);
            LogUtil.b(ky.f149104j, "Post cls data: ".concat(String.valueOf(modelToJsonString)));
            try {
                return modelToJsonString.getBytes("UTF-8");
            } catch (UnsupportedEncodingException e16) {
                e16.printStackTrace();
                return new byte[0];
            }
        }
    }

    public gp(bp bpVar) {
        this(bpVar, (byte) 0);
    }

    gp(bp bpVar, byte b16) {
        this.f148540k = true;
        String str = bpVar.D().f147925a;
        this.f148533c = str;
        this.f148534d = "";
        this.f148535e = "";
        this.f148532b = new f();
        TencentMapOptions tencentMapOptions = bpVar.f147915b;
        if (tencentMapOptions != null) {
            this.f148534d = tencentMapOptions.getSubKey();
            this.f148535e = bpVar.f147915b.getSubId();
        }
        String str2 = bpVar.getContext().getFilesDir().getAbsolutePath() + File.separator + "stData_" + Util.getMD5String(str);
        this.f148539j = str2;
        kt.a(str2);
        this.f148536f = new File(str2);
        this.f148537g = new File(str2 + FileDataSink.TEMP_FILE);
    }

    @MainThread
    private void c() {
        if (this.f148531a == 0) {
            a(new AnonymousClass1(new AnonymousClass2()));
        }
        this.f148531a++;
    }

    private static hi d() {
        return a(System.currentTimeMillis());
    }

    private go e() {
        String str = this.f148533c;
        String str2 = this.f148534d;
        String m3 = ho.m();
        String str3 = this.f148535e;
        String h16 = ho.h();
        String d16 = ho.d();
        StringBuilder sb5 = new StringBuilder();
        sb5.append(ho.j());
        return new go(new gn.b(str, str2, m3, str3, h16, d16, sb5.toString(), ho.k(), ho.n(), ho.c(), ho.g()));
    }

    private String a() {
        return this.f148539j;
    }

    private void b() {
        a(new AnonymousClass1(new AnonymousClass2()));
    }

    private void a(d dVar) {
        this.f148541l = dVar;
    }

    public final void a(Runnable runnable) {
        if (this.f148538h) {
            return;
        }
        if (this.f148540k) {
            new BaseThread(runnable).start();
        } else {
            runnable.run();
        }
    }

    private void a(a<f> aVar) {
        a(new AnonymousClass1(aVar));
    }

    private static f a(File file) {
        f fVar;
        f fVar2 = new f();
        byte[] c16 = kt.c(file);
        if (c16 != null && c16.length > 0 && (fVar = (f) JsonUtils.parseToModel(new String(c16), f.class, new Object[0])) != null) {
            fVar2.a(fVar);
        }
        return fVar2;
    }

    private static byte[] a(f fVar, e eVar) {
        c cVar = c.TRANSLATE_BYTE;
        e a16 = e.a(cVar);
        a16.f148562a = b.START;
        a16.f148563b = eVar;
        byte[] bArr = null;
        if (fVar.a()) {
            e a17 = e.a(cVar);
            a17.f148562a = b.END;
            a17.f148563b = eVar;
            a17.f148564c = false;
            return null;
        }
        e a18 = e.a(cVar);
        a18.f148562a = b.PROCESSING;
        a18.f148566e = fVar;
        a18.f148563b = eVar;
        String modelToJsonString = JsonUtils.modelToJsonString(fVar);
        if (!TextUtils.isEmpty(modelToJsonString)) {
            try {
                bArr = modelToJsonString.getBytes("UTF-8");
            } catch (UnsupportedEncodingException unused) {
                bArr = modelToJsonString.getBytes();
            }
        }
        e a19 = e.a(c.TRANSLATE_BYTE);
        a19.f148562a = b.END;
        a19.f148565d = bArr;
        a19.f148566e = modelToJsonString;
        a19.f148563b = eVar;
        a19.f148564c = bArr != null;
        return bArr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(final f fVar, final a<Boolean> aVar) {
        a(new Runnable() { // from class: com.tencent.mapsdk.internal.gp.3
            @Override // java.lang.Runnable
            public final void run() {
                NetResponse reportBehavior;
                c cVar = c.UPLOAD;
                e a16 = e.a(cVar);
                f fVar2 = fVar;
                a16.f148566e = fVar2;
                a16.f148562a = b.START;
                if (fVar2 != null && !fVar2.a()) {
                    boolean z16 = true;
                    gp.this.f148538h = true;
                    try {
                        e.a(cVar).f148562a = b.PROCESSING;
                        byte[] b16 = fVar.b();
                        if (b16 != null && b16.length > 0) {
                            dk dkVar = (dk) ((dz) cr.a(dz.class)).i();
                            gp gpVar = gp.this;
                            NetResponse report = dkVar.report(gpVar.f148533c, gpVar.f148534d, ho.m(), gp.this.f148535e, ho.h(), ho.d(), ho.j(), ho.k(), ho.n(), ho.c(), ho.g(), b16);
                            if (report != null) {
                                LogUtil.c(ky.f149104j, "Post statistic data with response:" + new String(report.data, report.charset));
                            }
                        }
                        byte[] c16 = fVar.c();
                        if (c16 != null && c16.length > 0 && (reportBehavior = ((db) ((dq) cr.a(dq.class)).i()).reportBehavior(c16)) != null) {
                            LogUtil.c(ky.f149104j, "Post cls data with response:" + new String(reportBehavior.data, reportBehavior.charset));
                        }
                    } catch (Exception e16) {
                        LogUtil.e(ky.f149104j, "err:" + e16.getMessage());
                        kt.c(gp.this.f148537g, JsonUtils.modelToJson(fVar).toString());
                        z16 = false;
                    }
                    e a17 = e.a(c.UPLOAD);
                    a17.f148566e = fVar;
                    a17.f148562a = b.END;
                    a17.f148564c = z16;
                    a aVar2 = aVar;
                    if (aVar2 != null) {
                        aVar2.a(Boolean.valueOf(z16));
                    }
                    gp.this.f148538h = false;
                    return;
                }
                a aVar3 = aVar;
                if (aVar3 != null) {
                    aVar3.a(Boolean.FALSE);
                }
                e a18 = e.a(cVar);
                a18.f148564c = false;
                a18.f148562a = b.END;
            }
        });
    }

    private void a(boolean z16) {
        c cVar = c.UPLOAD_END;
        e a16 = e.a(cVar);
        b bVar = b.START;
        a16.f148562a = bVar;
        byte[] c16 = kt.c(this.f148537g);
        e a17 = e.a(cVar);
        a17.f148562a = b.PROCESSING;
        a17.f148564c = z16;
        a17.f148565d = c16;
        a17.f148566e = this.f148537g;
        if (z16) {
            kt.b(this.f148536f);
            if (c16 != null && c16.length > 0) {
                kt.a(this.f148537g, this.f148536f);
            }
        } else if (c16 != null && c16.length > 0) {
            f fVar = new f();
            f a18 = a(this.f148536f);
            f a19 = a(this.f148537g);
            fVar.a(a18);
            fVar.a(a19);
            kt.b(this.f148536f);
            kt.b(this.f148537g);
            byte[] a26 = a(fVar, a17);
            c cVar2 = c.WRITE;
            e a27 = e.a(cVar2);
            a27.f148562a = bVar;
            a27.f148563b = a17;
            a27.f148565d = a26;
            File file = this.f148536f;
            a27.f148566e = file;
            boolean a28 = kt.a(file, a26);
            e a29 = e.a(cVar2);
            a29.f148562a = b.END;
            a29.f148563b = a17;
            a29.f148564c = a28;
        }
        e.a(cVar).f148562a = b.END;
    }

    @MainThread
    public final void a(hi hiVar, go goVar) {
        this.f148531a--;
        if (hiVar != null) {
            synchronized (this) {
                this.f148532b.f148568a.add(hiVar);
                if (goVar != null && goVar.f148529b.f148507a != null) {
                    this.f148532b.f148569b.addAll(goVar.f148529b.f148507a);
                }
            }
        }
        if (this.f148531a == 0 && !this.f148532b.a()) {
            a(this.f148532b, new a<Boolean>() { // from class: com.tencent.mapsdk.internal.gp.4
                @Override // com.tencent.mapsdk.internal.gp.a
                public final /* synthetic */ void a(Boolean bool) {
                    Boolean bool2 = bool;
                    gp.a(gp.this, bool2.booleanValue());
                    if (bool2.booleanValue()) {
                        f fVar = gp.this.f148532b;
                        fVar.f148568a.clear();
                        fVar.f148569b.clear();
                    }
                }

                /* renamed from: a, reason: avoid collision after fix types in other method */
                private void a2(Boolean bool) {
                    gp.a(gp.this, bool.booleanValue());
                    if (bool.booleanValue()) {
                        f fVar = gp.this.f148532b;
                        fVar.f148568a.clear();
                        fVar.f148569b.clear();
                    }
                }
            });
        }
    }

    public static hi a(long j3) {
        e.a(c.CREATE).f148566e = Long.valueOf(j3);
        return new hi(j3);
    }

    static /* synthetic */ void a(gp gpVar, boolean z16) {
        c cVar = c.UPLOAD_END;
        e a16 = e.a(cVar);
        b bVar = b.START;
        a16.f148562a = bVar;
        byte[] c16 = kt.c(gpVar.f148537g);
        e a17 = e.a(cVar);
        a17.f148562a = b.PROCESSING;
        a17.f148564c = z16;
        a17.f148565d = c16;
        a17.f148566e = gpVar.f148537g;
        if (z16) {
            kt.b(gpVar.f148536f);
            if (c16 != null && c16.length > 0) {
                kt.a(gpVar.f148537g, gpVar.f148536f);
            }
        } else if (c16 != null && c16.length > 0) {
            f fVar = new f();
            f a18 = a(gpVar.f148536f);
            f a19 = a(gpVar.f148537g);
            fVar.a(a18);
            fVar.a(a19);
            kt.b(gpVar.f148536f);
            kt.b(gpVar.f148537g);
            byte[] a26 = a(fVar, a17);
            c cVar2 = c.WRITE;
            e a27 = e.a(cVar2);
            a27.f148562a = bVar;
            a27.f148563b = a17;
            a27.f148565d = a26;
            File file = gpVar.f148536f;
            a27.f148566e = file;
            boolean a28 = kt.a(file, a26);
            e a29 = e.a(cVar2);
            a29.f148562a = b.END;
            a29.f148563b = a17;
            a29.f148564c = a28;
        }
        e.a(cVar).f148562a = b.END;
    }
}
