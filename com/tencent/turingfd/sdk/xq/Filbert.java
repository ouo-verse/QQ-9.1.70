package com.tencent.turingfd.sdk.xq;

import android.net.Network;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes27.dex */
public class Filbert {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public final String f382747a;

    /* renamed from: b, reason: collision with root package name */
    public final URL f382748b;

    /* renamed from: c, reason: collision with root package name */
    public final String f382749c;

    /* renamed from: d, reason: collision with root package name */
    public final Map<String, String> f382750d;

    /* renamed from: e, reason: collision with root package name */
    public final byte[] f382751e;

    /* renamed from: f, reason: collision with root package name */
    public final int f382752f;

    /* renamed from: g, reason: collision with root package name */
    public final int f382753g;

    /* renamed from: h, reason: collision with root package name */
    public final Network f382754h;

    /* renamed from: i, reason: collision with root package name */
    public final boolean f382755i;

    /* renamed from: j, reason: collision with root package name */
    public final boolean f382756j;

    /* compiled from: P */
    /* renamed from: com.tencent.turingfd.sdk.xq.Filbert$do, reason: invalid class name */
    /* loaded from: classes27.dex */
    public static class Cdo {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public final String f382757a;

        /* renamed from: b, reason: collision with root package name */
        public final URL f382758b;

        /* renamed from: c, reason: collision with root package name */
        public String f382759c;

        /* renamed from: d, reason: collision with root package name */
        public final HashMap<String, String> f382760d;

        /* renamed from: e, reason: collision with root package name */
        public byte[] f382761e;

        /* renamed from: f, reason: collision with root package name */
        public int f382762f;

        /* renamed from: g, reason: collision with root package name */
        public int f382763g;

        /* renamed from: h, reason: collision with root package name */
        public Network f382764h;

        /* renamed from: i, reason: collision with root package name */
        public boolean f382765i;

        /* renamed from: j, reason: collision with root package name */
        public boolean f382766j;

        public Cdo(String str) throws MalformedURLException {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) str);
                return;
            }
            this.f382759c = "GET";
            HashMap<String, String> hashMap = new HashMap<>();
            this.f382760d = hashMap;
            this.f382762f = 10000;
            this.f382763g = 10000;
            this.f382764h = null;
            this.f382765i = true;
            this.f382766j = false;
            this.f382757a = str;
            this.f382758b = new URL(str);
            hashMap.put("Content-Type", "application/json; charset=utf-8");
        }

        public Cdo a(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (Cdo) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
            }
            try {
                byte[] bytes = str.getBytes("utf-8");
                this.f382759c = "POST";
                this.f382761e = bytes;
            } catch (UnsupportedEncodingException unused) {
            }
            return this;
        }
    }

    public Filbert(Cdo cdo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) cdo);
            return;
        }
        this.f382747a = cdo.f382757a;
        this.f382748b = cdo.f382758b;
        this.f382749c = cdo.f382759c;
        this.f382750d = cdo.f382760d;
        this.f382751e = cdo.f382761e;
        this.f382752f = cdo.f382762f;
        this.f382753g = cdo.f382763g;
        this.f382754h = cdo.f382764h;
        this.f382755i = cdo.f382765i;
        this.f382756j = cdo.f382766j;
    }
}
