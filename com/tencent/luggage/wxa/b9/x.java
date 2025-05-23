package com.tencent.luggage.wxa.b9;

import com.eclipsesource.mmv8.JavaVoidCallback;
import com.eclipsesource.mmv8.V8Array;
import com.eclipsesource.mmv8.V8Object;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.mobileqq.vas.vipav.api.VipFunCallConstants;
import com.tencent.qqmini.sdk.launcher.core.proxy.PayProxy;
import cooperation.qqcircle.report.QCircleLpReportDc05507;
import cooperation.qzone.webviewplugin.QzoneZipCacheHelper;

/* compiled from: P */
/* loaded from: classes8.dex */
public class x extends v {

    /* renamed from: b, reason: collision with root package name */
    public final JavaVoidCallback f122360b;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class b implements JavaVoidCallback {
        public b() {
        }

        @Override // com.eclipsesource.mmv8.JavaVoidCallback
        public void invoke(V8Object v8Object, V8Array v8Array) {
            x.this.a(2, v8Array);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class c implements JavaVoidCallback {
        public c() {
        }

        @Override // com.eclipsesource.mmv8.JavaVoidCallback
        public void invoke(V8Object v8Object, V8Array v8Array) {
            x.this.a(4, v8Array);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class d implements JavaVoidCallback {
        public d() {
        }

        @Override // com.eclipsesource.mmv8.JavaVoidCallback
        public void invoke(V8Object v8Object, V8Array v8Array) {
            x.this.a(5, v8Array);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class e implements JavaVoidCallback {
        public e() {
        }

        @Override // com.eclipsesource.mmv8.JavaVoidCallback
        public void invoke(V8Object v8Object, V8Array v8Array) {
            String v8Array2 = v8Array.toString();
            com.tencent.luggage.wxa.tn.w.b("MicroMsg.J2V8_Console", v8Array2);
            x.this.a(6, "MicroMsg.J2V8_Console", v8Array2);
            x.a(x.this);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class f implements JavaVoidCallback {
        public f() {
        }

        @Override // com.eclipsesource.mmv8.JavaVoidCallback
        public void invoke(V8Object v8Object, V8Array v8Array) {
            x.this.a(3, v8Array);
        }
    }

    public x() {
        super(MosaicConstants$JsProperty.PROP_CONSOLE);
        this.f122360b = new a();
    }

    @Override // com.tencent.luggage.wxa.b9.v
    public void a() {
    }

    public void a(com.tencent.luggage.wxa.ei.y yVar) {
    }

    public static /* synthetic */ com.tencent.luggage.wxa.ei.y a(x xVar) {
        xVar.getClass();
        return null;
    }

    public final void a(int i3, V8Array v8Array) {
        String v8Array2 = v8Array.toString();
        if (i3 == 2) {
            com.tencent.luggage.wxa.tn.w.e("MicroMsg.J2V8_Console", v8Array2);
        } else if (i3 == 3) {
            com.tencent.luggage.wxa.tn.w.a("MicroMsg.J2V8_Console", v8Array2);
        } else if (i3 == 4) {
            com.tencent.luggage.wxa.tn.w.d("MicroMsg.J2V8_Console", v8Array2);
        } else if (i3 == 5) {
            com.tencent.luggage.wxa.tn.w.f("MicroMsg.J2V8_Console", v8Array2);
        }
        a(3, "MicroMsg.J2V8_Console", v8Array2);
    }

    @Override // com.tencent.luggage.wxa.b9.v
    public void a(t tVar, V8Object v8Object) {
        v8Object.registerJavaMethod(new b(), "log");
        v8Object.registerJavaMethod(new c(), "info");
        v8Object.registerJavaMethod(new d(), "warn");
        v8Object.registerJavaMethod(new e(), "error");
        v8Object.registerJavaMethod(new f(), "debug");
        v8Object.registerJavaMethod(this.f122360b, "assert");
        v8Object.registerJavaMethod(this.f122360b, "count");
        v8Object.registerJavaMethod(this.f122360b, "profile");
        v8Object.registerJavaMethod(this.f122360b, "profileEnd");
        v8Object.registerJavaMethod(this.f122360b, "time");
        v8Object.registerJavaMethod(this.f122360b, "timeEnd");
        v8Object.registerJavaMethod(this.f122360b, PayProxy.Source.PAY_REQUEST_TIME_STAMP_KEY);
        v8Object.registerJavaMethod(this.f122360b, "takeHeapSnapshot");
        v8Object.registerJavaMethod(this.f122360b, VipFunCallConstants.KEY_GROUP);
        v8Object.registerJavaMethod(this.f122360b, "groupCollapsed");
        v8Object.registerJavaMethod(this.f122360b, "groupEnd");
        v8Object.registerJavaMethod(this.f122360b, QCircleLpReportDc05507.KEY_CLEAR);
        v8Object.registerJavaMethod(this.f122360b, QzoneZipCacheHelper.DIR);
        v8Object.registerJavaMethod(this.f122360b, "dirxml");
        v8Object.registerJavaMethod(this.f122360b, "table");
        v8Object.registerJavaMethod(this.f122360b, "trace");
    }

    public final void a(int i3, String str, String str2) {
        w.b g16 = t.g();
        if (g16 != null) {
            if (i3 == 2) {
                g16.d(0L, str, null, null, 0, 0, 0L, 0L, str2);
                return;
            }
            if (i3 == 3) {
                g16.f(0L, str, null, null, 0, 0, 0L, 0L, str2);
                return;
            }
            if (i3 == 4) {
                g16.a(0L, str, null, null, 0, 0, 0L, 0L, str2);
            } else if (i3 == 5) {
                g16.b(0L, str, null, null, 0, 0, 0L, 0L, str2);
            } else {
                if (i3 != 6) {
                    return;
                }
                g16.e(0L, str, null, null, 0, 0, 0L, 0L, str2);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements JavaVoidCallback {
        public a() {
        }

        @Override // com.eclipsesource.mmv8.JavaVoidCallback
        public void invoke(V8Object v8Object, V8Array v8Array) {
        }
    }
}
