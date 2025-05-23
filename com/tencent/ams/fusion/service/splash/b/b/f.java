package com.tencent.ams.fusion.service.splash.b.b;

import android.content.Context;
import android.os.Parcelable;
import android.text.TextUtils;
import com.qq.e.tg.splash.image.TGSplashFileUtil;
import com.tencent.ams.fusion.a.j;
import com.tencent.ams.fusion.service.splash.b.b.a.b;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.io.File;
import java.io.Serializable;
import java.util.Map;
import nt.g;

/* compiled from: P */
/* loaded from: classes3.dex */
public class f implements kt.b<nt.f, g> {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private nt.f f70390a;

    /* renamed from: b, reason: collision with root package name */
    private com.tencent.ams.fusion.service.splash.data.a f70391b;

    /* renamed from: c, reason: collision with root package name */
    private long f70392c;

    public f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private b.f a(int i3) {
        b.f fVar = new b.f();
        fVar.d(false);
        fVar.b(System.currentTimeMillis() - this.f70392c);
        fVar.a(i3);
        g(431, i3, this.f70392c);
        return fVar;
    }

    private void g(int i3, long j3, long j16) {
        nt.d.b(this.f70390a, i3, j3, System.currentTimeMillis() - j16, Integer.MIN_VALUE);
    }

    @Override // kt.b
    public String b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return "PreloadSerializeDataTask";
    }

    @Override // kt.c
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public g c() {
        nt.f fVar;
        StringBuilder sb5;
        String str;
        rt.a value;
        String str2;
        int i3;
        String str3;
        long j3;
        long j16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (g) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        long currentTimeMillis = System.currentTimeMillis();
        this.f70392c = currentTimeMillis;
        g(430, 0L, currentTimeMillis);
        Context f16 = com.tencent.ams.fusion.service.b.b().f();
        if (f16 != null && this.f70391b != null && (fVar = this.f70390a) != null) {
            String b16 = fVar.b();
            if (this.f70390a.a()) {
                sb5 = new StringBuilder();
                sb5.append(b16);
                str = "key_preload_parse_data_hot";
            } else {
                sb5 = new StringBuilder();
                sb5.append(b16);
                str = "key_preload_parse_data_cold";
            }
            sb5.append(str);
            Object a16 = this.f70391b.a(sb5.toString());
            if (!(a16 instanceof rt.c)) {
                return a(4);
            }
            rt.c cVar = (rt.c) a16;
            if (TextUtils.isEmpty(cVar.b())) {
                return a(8);
            }
            Map<String, rt.a> a17 = cVar.a();
            if (j.c(a17)) {
                return a(16);
            }
            for (Map.Entry<String, rt.a> entry : a17.entrySet()) {
                if (entry != null) {
                    String key = entry.getKey();
                    if (!TextUtils.isEmpty(key) && (value = entry.getValue()) != null) {
                        if (this.f70390a.a()) {
                            str2 = "hot";
                        } else {
                            str2 = TGSplashFileUtil.PRELOAD_CACHE_DIR_COLD;
                        }
                        StringBuilder sb6 = new StringBuilder(cVar.b());
                        String str4 = File.separator;
                        sb6.append(str4);
                        sb6.append(key);
                        sb6.append(str4);
                        sb6.append(str2);
                        sb6.append(str4);
                        if (value instanceof Parcelable) {
                            sb6.append("parcelable_orders");
                            if (com.tencent.ams.fusion.a.b.p(new File(f16.getDir(TGSplashFileUtil.ADNET, 0), sb6.toString()), (Parcelable) value)) {
                                j16 = 1;
                            } else {
                                j16 = 0;
                            }
                            long j17 = this.f70392c;
                            str3 = TGSplashFileUtil.ADNET;
                            i3 = 0;
                            g(432, j16, j17);
                        } else {
                            i3 = 0;
                            str3 = TGSplashFileUtil.ADNET;
                        }
                        if (value instanceof Serializable) {
                            sb6.append("serializable_orders");
                            if (com.tencent.ams.fusion.a.b.q(new File(f16.getDir(str3, i3), sb6.toString()), value)) {
                                j3 = 1;
                            } else {
                                j3 = 0;
                            }
                            g(433, j3, this.f70392c);
                        }
                    }
                }
            }
            return a(2);
        }
        return a(1);
    }

    public void h(com.tencent.ams.fusion.service.splash.data.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) aVar);
        } else {
            this.f70391b = aVar;
        }
    }

    public void i(nt.f fVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) fVar);
        } else {
            this.f70390a = fVar;
        }
    }
}
