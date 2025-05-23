package com.tencent.mobileqq.msf.core.f0.c.e;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes15.dex */
public class h extends com.tencent.mobileqq.msf.core.x.f {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: g, reason: collision with root package name */
    public static final String f248218g = "isOpen";

    /* renamed from: h, reason: collision with root package name */
    public static final String f248219h = "compressThreshold";

    /* renamed from: i, reason: collision with root package name */
    public static final String f248220i = "compressThresholdMap";

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    private final AtomicBoolean f248221c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    private final AtomicInteger f248222d;

    /* renamed from: e, reason: collision with root package name */
    private String f248223e;

    /* renamed from: f, reason: collision with root package name */
    @NonNull
    private HashMap<String, Integer> f248224f;

    public h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f248221c = new AtomicBoolean(a(f248218g, true));
        this.f248222d = new AtomicInteger(a(f248219h, 3000));
        this.f248223e = a(f248220i, "");
        this.f248224f = new HashMap<>();
        if (!TextUtils.isEmpty(this.f248223e)) {
            this.f248224f = b(this.f248223e);
        }
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
            JSONObject jSONObject = new JSONObject(str);
            a(str, jSONObject, this.f248221c, f248218g);
            a(str, jSONObject, this.f248222d, f248219h);
            String a16 = a(str, jSONObject, f248220i, "");
            this.f248223e = a16;
            if (!TextUtils.isEmpty(a16)) {
                this.f248224f = b(this.f248223e);
            }
            QLog.d("MSFConfig", 1, "update MSFCorePacketCombineConfig, config = " + str);
        } catch (Exception e16) {
            QLog.d("MSFConfig", 2, "update MSFCorePacketCombineConfig error, ", e16);
        }
    }

    public HashMap<String, Integer> b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) ? this.f248224f : (HashMap) iPatchRedirector.redirect((short) 5, (Object) this);
    }

    public boolean c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        return this.f248221c.get();
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return "MSFCorePkgCompressConfigmIsOpen=" + this.f248221c + ", mCompressThreshold=" + this.f248222d.get() + ", mCompressThresholdMap" + this.f248224f;
    }

    private HashMap<String, Integer> b(String str) {
        HashMap<String, Integer> hashMap = new HashMap<>();
        try {
            JSONObject jSONObject = new JSONObject(str);
            Iterator keys = jSONObject.keys();
            while (keys.hasNext()) {
                String str2 = (String) keys.next();
                hashMap.put(str2, Integer.valueOf(jSONObject.optInt(str2)));
            }
        } catch (Exception e16) {
            QLog.d("MSFConfig", 2, "convertJsonToMap with exception !", e16);
        }
        return hashMap;
    }

    public int a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? this.f248222d.get() : ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
    }
}
