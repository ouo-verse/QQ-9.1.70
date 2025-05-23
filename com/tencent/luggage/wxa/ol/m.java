package com.tencent.luggage.wxa.ol;

import android.view.KeyEvent;
import com.tencent.luggage.wxa.df.h;
import com.tencent.luggage.wxa.ol.c;
import com.tencent.luggage.wxa.ol.g;
import com.tencent.luggage.wxa.ol.q0;
import com.tencent.luggage.wxa.ol.v0;
import com.tencent.qqmini.sdk.plugins.InputJsPlugin;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class m {

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements g.a {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f136857a;

        public a(int i3) {
            this.f136857a = i3;
        }

        @Override // com.tencent.luggage.wxa.ol.g.a
        public boolean a(p0 p0Var) {
            if (p0Var.d() != null && ((q0) p0Var.d()).getInputId() == this.f136857a) {
                return true;
            }
            return false;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class b implements q0.b {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ WeakReference f136859a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.ol.c f136860b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f136861c;

        public b(WeakReference weakReference, com.tencent.luggage.wxa.ol.c cVar, String str) {
            this.f136859a = weakReference;
            this.f136860b = cVar;
            this.f136861c = str;
        }

        @Override // com.tencent.luggage.wxa.ol.q0.b
        public boolean a(int i3, KeyEvent keyEvent) {
            if (i3 != 67) {
                return false;
            }
            com.tencent.luggage.wxa.kj.v vVar = (com.tencent.luggage.wxa.kj.v) this.f136859a.get();
            if (vVar != null) {
                try {
                    int inputId = this.f136860b.getInputId();
                    h.g gVar = new h.g();
                    gVar.setData(new JSONObject().put("value", this.f136860b.i().getText().toString()).put("data", this.f136861c).put("cursor", 0).put("inputId", inputId).put("keyCode", 8).toString());
                    vVar.a(gVar, (int[]) null);
                } catch (Exception e16) {
                    com.tencent.luggage.wxa.tn.w.b("MicroMsg.AppBrandInputJsApiHandler", "onKeyUpPostIme DEL, e = %s", e16);
                }
            }
            return true;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class d implements u0 {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ WeakReference f136868a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f136869b;

        public d(WeakReference weakReference, int i3) {
            this.f136868a = weakReference;
            this.f136869b = i3;
        }

        @Override // com.tencent.luggage.wxa.ol.u0
        public void a(int i3) {
            try {
                com.tencent.luggage.wxa.kj.v vVar = (com.tencent.luggage.wxa.kj.v) this.f136868a.get();
                if (vVar == null) {
                    return;
                }
                vVar.a("onKeyboardShow", com.tencent.luggage.wxa.xa.g.c().put("inputId", this.f136869b).put("height", com.tencent.luggage.wxa.tk.g.a(vVar.getContext(), i3)).toString());
                new com.tencent.luggage.wxa.xd.c0().a(i3, vVar.y0(), vVar, Integer.valueOf(this.f136869b));
            } catch (Exception unused) {
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static /* synthetic */ class e {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f136871a;

        static {
            int[] iArr = new int[v0.a.values().length];
            f136871a = iArr;
            try {
                iArr[v0.a.COMPLETE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f136871a[v0.a.CONFIRM.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class f {

        /* renamed from: a, reason: collision with root package name */
        public static final m f136872a = new m(null);
    }

    public /* synthetic */ m(a aVar) {
        this();
    }

    public static m a() {
        return f.f136872a;
    }

    public m() {
    }

    public final void a(com.tencent.luggage.wxa.kj.v vVar, com.tencent.luggage.wxa.ol.c cVar) {
        g.a(vVar, cVar);
    }

    public final com.tencent.luggage.wxa.ol.c a(com.tencent.luggage.wxa.kj.v vVar, int i3) {
        p0 a16 = g.a(vVar, new a(i3));
        if (a16 instanceof com.tencent.luggage.wxa.ol.c) {
            return (com.tencent.luggage.wxa.ol.c) a16;
        }
        return null;
    }

    public Integer a(com.tencent.luggage.wxa.vl.f fVar, String str, int i3, int i16, com.tencent.luggage.wxa.kj.v vVar) {
        com.tencent.luggage.wxa.ol.c a16 = c.EnumC6560c.a(fVar.R, vVar, fVar);
        if (a16 == null) {
            return null;
        }
        String str2 = fVar.f143663a;
        if (str2 != null) {
            a16.a(str2);
        }
        a16.a(fVar);
        com.tencent.luggage.wxa.vl.a aVar = fVar.V;
        if (aVar != null) {
            a16.a(aVar);
        }
        if (!a16.a(fVar.f143664b.intValue(), fVar.f143665c.intValue(), fVar.f143667e.intValue(), fVar.f143666d.intValue()) || !a16.a(i3, i16, vVar.D().forceLightMode())) {
            return null;
        }
        WeakReference weakReference = new WeakReference(vVar);
        int inputId = a16.getInputId();
        ((q0) a16.i()).setOnKeyUpPostImeListener(new b(weakReference, a16, str));
        a16.a(new c(weakReference, a16, inputId, str));
        a16.a(new d(weakReference, inputId));
        a(vVar, a16);
        new o(vVar);
        return Integer.valueOf(inputId);
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class c implements v0 {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ WeakReference f136863a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.ol.c f136864b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f136865c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ String f136866d;

        public c(WeakReference weakReference, com.tencent.luggage.wxa.ol.c cVar, int i3, String str) {
            this.f136863a = weakReference;
            this.f136864b = cVar;
            this.f136865c = i3;
            this.f136866d = str;
        }

        /* JADX WARN: Removed duplicated region for block: B:17:0x0079 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:18:0x007a A[Catch: Exception -> 0x0081, TRY_LEAVE, TryCatch #0 {Exception -> 0x0081, blocks: (B:2:0x0000, B:6:0x000b, B:8:0x0043, B:10:0x005c, B:15:0x0073, B:18:0x007a), top: B:1:0x0000 }] */
        @Override // com.tencent.luggage.wxa.ol.v0
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void a(String str, int i3, v0.a aVar) {
            String str2;
            try {
                com.tencent.luggage.wxa.kj.v vVar = (com.tencent.luggage.wxa.kj.v) this.f136863a.get();
                if (vVar == null) {
                    return;
                }
                JSONObject put = new JSONObject().put("value", str).put("keyCode", (int) ((q0) this.f136864b.i()).getLastKeyPressed()).put("inputId", this.f136865c).put("cursor", i3);
                String str3 = null;
                if (v0.a.CHANGED.equals(aVar)) {
                    h.g gVar = new h.g();
                    gVar.setData(put.put("data", this.f136866d).toString());
                    vVar.a(gVar, (int[]) null);
                    return;
                }
                int i16 = e.f136871a[aVar.ordinal()];
                if (i16 == 1) {
                    str2 = InputJsPlugin.ON_KEYBOARD_COMPLETE_CALLBACK;
                } else {
                    if (i16 != 2) {
                        if (com.tencent.luggage.wxa.tn.w0.c(str3)) {
                            vVar.a(str3, put.toString());
                            return;
                        }
                        return;
                    }
                    str2 = InputJsPlugin.ON_KEYBOARD_CONFIRM_CALLBACK;
                }
                str3 = str2;
                if (com.tencent.luggage.wxa.tn.w0.c(str3)) {
                }
            } catch (Exception unused) {
            }
        }

        @Override // com.tencent.luggage.wxa.ol.v0
        public void a(String str, int i3, String str2, String str3) {
            try {
                com.tencent.luggage.wxa.kj.v vVar = (com.tencent.luggage.wxa.kj.v) this.f136863a.get();
                if (vVar == null) {
                    return;
                }
                JSONObject put = new JSONObject().put("value", str).put("keyCode", (int) ((q0) this.f136864b.i()).getLastKeyPressed()).put("inputId", this.f136865c).put("cursor", i3);
                if (str2 != null) {
                    put.put("encryptValue", str2);
                }
                if (str3 != null) {
                    put.put("encryptError", str3);
                }
                String jSONObject = put.toString();
                com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrandInputJsApiHandler", "onKeyboardCompleteWithEncryptedValue, eventData: " + jSONObject);
                vVar.a(InputJsPlugin.ON_KEYBOARD_COMPLETE_CALLBACK, jSONObject);
            } catch (Exception unused) {
            }
        }
    }

    public boolean a(com.tencent.luggage.wxa.kj.v vVar, int i3, com.tencent.luggage.wxa.vl.i iVar) {
        com.tencent.luggage.wxa.ol.c a16 = a(vVar, i3);
        if (a16 == null) {
            return false;
        }
        String str = iVar.f143663a;
        if (str != null) {
            a16.a(str);
        }
        a16.a(iVar);
        a16.m();
        return true;
    }
}
