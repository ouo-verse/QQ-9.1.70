package com.tencent.mobileqq.msf.core.x;

import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes15.dex */
public class j extends f {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: e, reason: collision with root package name */
    private static final String f250281e = "enableMultiTcp";

    /* renamed from: f, reason: collision with root package name */
    private static final String f250282f = "simultTcpCmdWhiteList";

    /* renamed from: g, reason: collision with root package name */
    public static final boolean f250283g = false;

    /* renamed from: h, reason: collision with root package name */
    public static final String f250284h = "";

    /* renamed from: c, reason: collision with root package name */
    private final AtomicBoolean f250285c;

    /* renamed from: d, reason: collision with root package name */
    private final Set<String> f250286d;

    public j() {
        String[] strArr;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f250285c = new AtomicBoolean(a(f250281e, false));
        String a16 = a(f250282f, "");
        if (!TextUtils.isEmpty(a16)) {
            strArr = a16.split("\\|");
        } else {
            strArr = null;
        }
        this.f250286d = Collections.synchronizedSet(new HashSet(Arrays.asList(strArr == null ? new String[0] : strArr)));
        QLog.d("MSFConfig", 1, toString());
    }

    @Override // com.tencent.mobileqq.msf.core.x.f
    public void a(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
            return;
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            QLog.d("MSFConfig", 1, "update MSFMultiTcpConfigManager config = " + str);
            JSONObject jSONObject = new JSONObject(str);
            a(str, jSONObject, this.f250285c, f250281e);
            a(str, jSONObject, this.f250286d, f250282f);
        } catch (Exception e16) {
            QLog.d("MSFConfig", 1, "MSFMultiTcpConfigManager onUpdateConfig error, ", e16);
        }
    }

    public boolean b(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, (Object) str)).booleanValue();
        }
        if (this.f250286d != null && !TextUtils.isEmpty(str)) {
            return this.f250286d.contains(str);
        }
        return false;
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        StringBuilder sb5 = new StringBuilder();
        Set<String> set = this.f250286d;
        if (set != null) {
            Iterator<String> it = set.iterator();
            while (it.hasNext()) {
                sb5.append(it.next());
                sb5.append(',');
            }
        }
        return "MSFMultiTcpConfigManager{multiTcpEnable=" + this.f250285c + ", multiTcpCmdWhiteList=" + ((Object) sb5) + '}';
    }

    public boolean a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) ? this.f250285c.get() : ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
    }
}
