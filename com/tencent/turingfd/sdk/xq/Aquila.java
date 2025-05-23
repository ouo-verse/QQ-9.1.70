package com.tencent.turingfd.sdk.xq;

import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.upload.network.session.cache.SessionDbHelper;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes27.dex */
public class Aquila {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public final JSONObject f382560a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f382561b;

    /* renamed from: c, reason: collision with root package name */
    public Cif f382562c;

    /* renamed from: d, reason: collision with root package name */
    public final String f382563d;

    /* renamed from: e, reason: collision with root package name */
    public final int f382564e;

    /* compiled from: P */
    /* renamed from: com.tencent.turingfd.sdk.xq.Aquila$do, reason: invalid class name */
    /* loaded from: classes27.dex */
    public static class Cdo {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public final Object f382565a;

        /* renamed from: b, reason: collision with root package name */
        public final JSONObject f382566b;

        public Cdo(Object obj) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, obj);
            } else {
                this.f382566b = new JSONObject();
                this.f382565a = obj;
            }
        }

        public Cdo a(String str) throws JSONException {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (Cdo) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
            }
            synchronized (this.f382565a) {
                this.f382566b.put("err_msg", str);
            }
            return this;
        }
    }

    public Aquila(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, i3);
            return;
        }
        JSONObject jSONObject = new JSONObject();
        this.f382560a = jSONObject;
        this.f382561b = jSONObject;
        this.f382562c = null;
        this.f382564e = i3;
        if ((i3 & 2) != 0) {
            this.f382563d = "p1:";
        } else {
            if ((i3 & 1) != 0) {
                this.f382563d = "x1:";
                return;
            }
            throw new IllegalArgumentException(Sculptor.a("invalid bizFlags: ", i3));
        }
    }

    public Cif a() throws JSONException {
        Cif cif;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Cif) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        synchronized (this.f382561b) {
            if (this.f382562c == null) {
                Cif cif2 = new Cif(this.f382560a, this.f382564e);
                this.f382562c = cif2;
                this.f382560a.put("expand_token", cif2.f382568b);
            }
            cif = this.f382562c;
        }
        return cif;
    }

    /* compiled from: P */
    /* renamed from: com.tencent.turingfd.sdk.xq.Aquila$if, reason: invalid class name */
    /* loaded from: classes27.dex */
    public static class Cif {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public final Object f382567a;

        /* renamed from: b, reason: collision with root package name */
        public final JSONObject f382568b;

        /* renamed from: c, reason: collision with root package name */
        public int f382569c;

        /* renamed from: d, reason: collision with root package name */
        public String f382570d;

        /* renamed from: e, reason: collision with root package name */
        public JSONArray f382571e;

        /* renamed from: f, reason: collision with root package name */
        public final JSONObject f382572f;

        public Cif(Object obj, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, obj, i3);
                return;
            }
            this.f382568b = new JSONObject();
            this.f382569c = 0;
            this.f382570d = null;
            this.f382571e = null;
            this.f382567a = obj;
            if ((i3 & 2) != 0) {
                this.f382572f = new JSONObject();
            } else {
                this.f382572f = null;
            }
        }

        public Cif a(int i3, String str) throws JSONException {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (Cif) iPatchRedirector.redirect((short) 2, (Object) this, i3, (Object) str);
            }
            synchronized (this.f382567a) {
                this.f382568b.put("result", i3);
                if (!TextUtils.isEmpty(str)) {
                    this.f382568b.put("err_msg", str);
                    this.f382570d = str;
                }
                this.f382569c = i3;
            }
            return this;
        }

        public String b() {
            String str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (String) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            synchronized (this.f382567a) {
                str = this.f382570d;
            }
            return str;
        }

        public Cif a(String str) throws JSONException {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (Cif) iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
            }
            synchronized (this.f382567a) {
                this.f382568b.put(SessionDbHelper.SESSION_ID, str);
                JSONObject jSONObject = this.f382572f;
                if (jSONObject != null) {
                    jSONObject.put(SessionDbHelper.SESSION_ID, str);
                }
            }
            return this;
        }

        public Cdo a() throws JSONException {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (Cdo) iPatchRedirector.redirect((short) 5, (Object) this);
            }
            Cdo cdo = new Cdo(this.f382567a);
            synchronized (this.f382567a) {
                if (this.f382571e == null) {
                    JSONArray jSONArray = new JSONArray();
                    this.f382571e = jSONArray;
                    this.f382568b.put("action_results", jSONArray);
                    JSONObject jSONObject = this.f382572f;
                    if (jSONObject != null) {
                        jSONObject.put("action_results", this.f382571e);
                    }
                }
                this.f382571e.mo162put(cdo.f382566b);
            }
            return cdo;
        }
    }
}
