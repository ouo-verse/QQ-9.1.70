package com.tencent.ams.mosaic.jsengine.common;

import androidx.annotation.NonNull;
import com.tencent.ams.hippo.quickjs.android.JSFunction;
import com.tencent.ams.hippo.quickjs.android.JSObject;
import com.tencent.ams.mosaic.f;
import com.tencent.ams.mosaic.jsengine.c;
import com.tencent.ams.mosaic.jsengine.e;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes3.dex */
public class c implements INativeBridge {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private final com.tencent.ams.mosaic.jsengine.a f70817a;

    /* compiled from: P */
    /* loaded from: classes3.dex */
    class a implements c.a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ JSFunction f70818a;

        a(JSFunction jSFunction) {
            this.f70818a = jSFunction;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) c.this, (Object) jSFunction);
            }
        }

        @Override // com.tencent.ams.mosaic.jsengine.c.a
        public void a(Object obj, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, obj, i3);
            } else if (this.f70818a != null) {
                if (f.k().z()) {
                    c.this.f70817a.p(this.f70818a, new Object[]{obj, Integer.valueOf(i3)}, null);
                } else {
                    c.this.f70817a.u(this.f70818a, new Object[]{obj, Integer.valueOf(i3)}, null);
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    class b implements c.a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ JSFunction f70820a;

        b(JSFunction jSFunction) {
            this.f70820a = jSFunction;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) c.this, (Object) jSFunction);
            }
        }

        @Override // com.tencent.ams.mosaic.jsengine.c.a
        public void a(Object obj, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, obj, i3);
            } else if (this.f70820a != null) {
                if (f.k().z()) {
                    c.this.f70817a.p(this.f70820a, new Object[]{obj, Integer.valueOf(i3)}, null);
                } else {
                    c.this.f70817a.u(this.f70820a, new Object[]{obj, Integer.valueOf(i3)}, null);
                }
            }
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.ams.mosaic.jsengine.common.c$c, reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0687c {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        Map<String, Object> f70822a;

        C0687c(JSObject jSObject) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) c.this, (Object) jSObject);
            } else {
                this.f70822a = e.f(c.this.f70817a.l(), jSObject);
            }
        }

        public Map<String, Object> a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return (Map) iPatchRedirector.redirect((short) 6, (Object) this);
            }
            return this.f70822a;
        }

        @NonNull
        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return (String) iPatchRedirector.redirect((short) 7, (Object) this);
            }
            Map<String, Object> map = this.f70822a;
            if (map != null) {
                return map.toString();
            }
            return "";
        }
    }

    public c(@NonNull com.tencent.ams.mosaic.jsengine.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) aVar);
        } else {
            this.f70817a = aVar;
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.common.INativeBridge
    public void invoke(String str, String str2, JSObject jSObject, JSFunction jSFunction) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, str, str2, jSObject, jSFunction);
            return;
        }
        com.tencent.ams.mosaic.jsengine.c j3 = this.f70817a.j();
        if (j3 != null) {
            j3.invoke(str, str2, new C0687c(jSObject), new a(jSFunction));
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.common.INativeBridge
    public void invokeBridge(String str, String str2, JSObject jSObject, JSFunction jSFunction) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, str, str2, jSObject, jSFunction);
            return;
        }
        com.tencent.ams.mosaic.jsengine.c j3 = this.f70817a.j();
        if (j3 != null) {
            j3.invokeApi(str, str2, new C0687c(jSObject), new b(jSFunction));
        }
    }
}
