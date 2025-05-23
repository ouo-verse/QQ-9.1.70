package com.tencent.mobileqq.fragment.blacklist;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.ChnToSpell;
import java.util.LinkedHashMap;
import java.util.List;

/* compiled from: P */
/* loaded from: classes12.dex */
public class e {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    String[] f211314a;

    /* renamed from: b, reason: collision with root package name */
    int[] f211315b;

    /* renamed from: c, reason: collision with root package name */
    LinkedHashMap<String, List<a>> f211316c;

    /* compiled from: P */
    /* loaded from: classes12.dex */
    public static class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public String f211317a;

        /* renamed from: b, reason: collision with root package name */
        public String f211318b;

        /* renamed from: c, reason: collision with root package name */
        public String f211319c;

        /* renamed from: d, reason: collision with root package name */
        public String f211320d;

        public a(String str, String str2, String str3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, str, str2, str3);
                return;
            }
            this.f211320d = "";
            this.f211317a = str;
            this.f211318b = str2;
            this.f211319c = str3;
            this.f211320d = ChnToSpell.d(str2, 2);
        }

        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (String) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return this.f211318b;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f211314a = new String[0];
        this.f211315b = new int[0];
        this.f211316c = new LinkedHashMap<>();
    }
}
