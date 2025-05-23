package com.tencent.mqpsdk;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mqpsdk.secsrv.c;
import java.util.LinkedHashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes21.dex */
public class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public Context f336136a;

    /* renamed from: b, reason: collision with root package name */
    public a f336137b;

    /* renamed from: c, reason: collision with root package name */
    private Map<String, Object> f336138c;

    public b(Context context, a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) aVar);
            return;
        }
        this.f336138c = null;
        this.f336136a = context;
        this.f336137b = aVar;
    }

    public Object a(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
        }
        Object obj = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (this.f336138c == null) {
            this.f336138c = new LinkedHashMap();
        }
        if (this.f336138c.containsKey(str)) {
            return this.f336138c.get(str);
        }
        if (TextUtils.equals(str, "intchk")) {
            obj = new com.tencent.mqpsdk.secsrv.b(this);
        } else if (TextUtils.equals(str, "sig_check")) {
            obj = new c(this);
        }
        if (obj != null) {
            this.f336138c.put(str, obj);
        }
        return obj;
    }
}
