package com.tencent.mobileqq.weiyun.model;

import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.INetEngineListener;
import com.tencent.weiyun.utils.IOUtils;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes20.dex */
public class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private final String f315169a;

    /* renamed from: b, reason: collision with root package name */
    private final a f315170b;

    /* renamed from: c, reason: collision with root package name */
    private final String f315171c;

    /* renamed from: d, reason: collision with root package name */
    private volatile boolean f315172d;

    /* renamed from: e, reason: collision with root package name */
    private volatile boolean f315173e;

    /* renamed from: f, reason: collision with root package name */
    private volatile boolean f315174f;

    /* renamed from: g, reason: collision with root package name */
    private volatile boolean f315175g;

    /* renamed from: h, reason: collision with root package name */
    private final c f315176h;

    /* renamed from: i, reason: collision with root package name */
    private long f315177i;

    /* renamed from: j, reason: collision with root package name */
    private String f315178j;

    /* renamed from: k, reason: collision with root package name */
    private String f315179k;

    /* renamed from: l, reason: collision with root package name */
    private HttpNetReq f315180l;

    /* renamed from: m, reason: collision with root package name */
    private y43.c f315181m;

    b(String str, String str2, a aVar, c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, str, str2, aVar, cVar);
            return;
        }
        this.f315169a = str;
        this.f315171c = str2;
        this.f315170b = aVar;
        this.f315176h = cVar;
    }

    public static b b(String str, a aVar, String str2, c cVar) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && aVar != null && cVar != null) {
            return new b(str, IOUtils.getDirPathNoSeparator(str2), aVar, cVar);
        }
        throw new IllegalArgumentException("The params jobOwnerUid, localDir, file and statusInfo should be valid.");
    }

    public static HttpNetReq c(Object obj, String str, String str2, String str3, boolean z16, INetEngineListener iNetEngineListener) {
        return d(obj, str, str2, str3, z16, iNetEngineListener, null);
    }

    public static HttpNetReq d(Object obj, String str, String str2, String str3, boolean z16, INetEngineListener iNetEngineListener, String str4) {
        HttpNetReq httpNetReq = new HttpNetReq();
        httpNetReq.mCallback = iNetEngineListener;
        httpNetReq.mReqUrl = str;
        httpNetReq.mHttpMethod = 0;
        if (!TextUtils.isEmpty(str3)) {
            HashMap<String, String> hashMap = new HashMap<>();
            httpNetReq.mReqProperties = hashMap;
            hashMap.put("Cookie", str3);
        }
        if (!TextUtils.isEmpty(str4)) {
            httpNetReq.mTempPath = str4;
        }
        httpNetReq.mOutPath = str2;
        httpNetReq.mPrioty = 1;
        httpNetReq.setUserData(obj);
        httpNetReq.mSupportBreakResume = z16;
        return httpNetReq;
    }

    public c a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return (c) iPatchRedirector.redirect((short) 24, (Object) this);
        }
        return this.f315176h.clone();
    }

    public long e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Long) iPatchRedirector.redirect((short) 16, (Object) this)).longValue();
        }
        return this.f315177i;
    }

    public String f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return (String) iPatchRedirector.redirect((short) 18, (Object) this);
        }
        return this.f315179k;
    }

    public a g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (a) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        return this.f315170b;
    }

    public String h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return (String) iPatchRedirector.redirect((short) 17, (Object) this);
        }
        return this.f315178j;
    }

    public y43.c i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return (y43.c) iPatchRedirector.redirect((short) 21, (Object) this);
        }
        return this.f315181m;
    }

    public HttpNetReq j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return (HttpNetReq) iPatchRedirector.redirect((short) 19, (Object) this);
        }
        return this.f315180l;
    }

    public boolean k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Boolean) iPatchRedirector.redirect((short) 15, (Object) this)).booleanValue();
        }
        return this.f315175g;
    }

    public boolean l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Boolean) iPatchRedirector.redirect((short) 14, (Object) this)).booleanValue();
        }
        return this.f315173e;
    }

    public boolean m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Boolean) iPatchRedirector.redirect((short) 13, (Object) this)).booleanValue();
        }
        return this.f315172d;
    }

    public boolean n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        return this.f315174f;
    }

    public String o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (String) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        return this.f315171c;
    }

    public void p(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, z16);
        } else {
            this.f315175g = z16;
        }
    }

    public void q(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, j3);
        } else {
            this.f315177i = j3;
        }
    }

    public void r(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) str);
        } else {
            this.f315179k = str;
        }
    }

    public void s(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) str);
        } else {
            this.f315178j = str;
        }
    }

    public void t(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, z16);
        } else {
            this.f315173e = z16;
        }
    }

    public void u(y43.c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this, (Object) cVar);
        } else {
            this.f315181m = cVar;
        }
    }

    public void v(HttpNetReq httpNetReq) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, (Object) httpNetReq);
        } else {
            this.f315180l = httpNetReq;
        }
    }

    public void w(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, z16);
        } else {
            this.f315172d = z16;
        }
    }

    public void x(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, z16);
        } else {
            this.f315174f = z16;
        }
    }

    public c y() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return (c) iPatchRedirector.redirect((short) 23, (Object) this);
        }
        return this.f315176h;
    }

    public String z() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (String) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return this.f315169a;
    }
}
