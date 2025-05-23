package com.tencent.mobileqq.webview.swift.injector;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.HashMap;
import java.util.List;
import mqq.app.AppRuntime;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes20.dex */
public interface c {

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public HashMap<String, Integer> f314604a;

        /* renamed from: b, reason: collision with root package name */
        public int f314605b;

        public a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            } else {
                this.f314604a = new HashMap<>();
                this.f314605b = 6;
            }
        }

        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return "CrashStatConfig{rulesMap=" + this.f314604a + ", tailNumber=" + this.f314605b + '}';
        }
    }

    boolean a();

    boolean b();

    String c(String str, String str2, String str3);

    String d(String str, boolean z16);

    @NonNull
    List<String> e(String str);

    boolean f();

    boolean g();

    boolean h(String str);

    boolean i();

    boolean isSwitchOn(String str, boolean z16);

    boolean j();

    boolean k();

    boolean l();

    boolean m();

    @Nullable
    String n(String str);

    JSONObject o(AppRuntime appRuntime, String str, boolean z16);

    boolean p();

    boolean q();

    boolean r();

    void reset();

    boolean s();

    a t();

    boolean u();

    boolean v();

    boolean w();
}
