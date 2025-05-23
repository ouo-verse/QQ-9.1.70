package com.tencent.mobileqq.msf.core.x;

import android.support.annotation.NonNull;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes15.dex */
public class i {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: b, reason: collision with root package name */
    public static final String f250274b = "MSFMMKVConfig";

    /* renamed from: c, reason: collision with root package name */
    public static final String f250275c = "isMSFMigrateToMMKV";

    /* renamed from: d, reason: collision with root package name */
    public static final String f250276d = "isDefaultSPMigrateToMMKV";

    /* renamed from: e, reason: collision with root package name */
    public static final boolean f250277e = true;

    /* renamed from: f, reason: collision with root package name */
    public static final boolean f250278f = true;

    /* renamed from: a, reason: collision with root package name */
    private final ConcurrentHashMap<String, String> f250279a;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public static class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private static final i f250280a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(28998);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
            } else {
                f250280a = new i(null);
            }
        }

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    /* synthetic */ i(a aVar) {
        this();
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) aVar);
    }

    public static i a() {
        return b.f250280a;
    }

    public boolean b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        try {
            if (this.f250279a.containsKey(f250276d)) {
                String str = this.f250279a.get(f250276d);
                Objects.requireNonNull(str);
                return Boolean.parseBoolean(str);
            }
        } catch (Exception e16) {
            QLog.d(f250274b, 1, "isDefaultSPMigrateToMMKV error", e16);
        }
        return true;
    }

    public boolean c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        try {
            if (this.f250279a.containsKey(f250275c)) {
                String str = this.f250279a.get(f250275c);
                Objects.requireNonNull(str);
                return Boolean.parseBoolean(str);
            }
        } catch (Exception e16) {
            QLog.d(f250274b, 1, "isMMKVEnable error", e16);
        }
        return true;
    }

    i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        ConcurrentHashMap<String, String> concurrentHashMap = new ConcurrentHashMap<>();
        this.f250279a = concurrentHashMap;
        MMKVOptionEntity a16 = com.tencent.mobileqq.msf.core.b0.a.b().a();
        if (a16 == null) {
            QLog.d(f250274b, 1, "[MSFMMKVConfig] get MMKV entity null");
        } else {
            concurrentHashMap.putAll(MsfSdkUtils.convertJsonToMap(a16.decodeString(BaseConstants.KEY_MSF_MMKV_CONFIG, "")));
        }
    }

    public void a(@NonNull ToServiceMsg toServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) toServiceMsg);
            return;
        }
        Object obj = toServiceMsg.getAttributes().get(BaseConstants.KEY_MSF_MMKV_CONFIG);
        if (obj instanceof String) {
            String str = (String) obj;
            this.f250279a.putAll(MsfSdkUtils.convertJsonToMap(str));
            MMKVOptionEntity a16 = com.tencent.mobileqq.msf.core.b0.a.b().a();
            if (a16 == null) {
                QLog.d(f250274b, 1, "[onUpdateConfig] get MMKV entity null");
                return;
            }
            a16.encodeString(BaseConstants.KEY_MSF_MMKV_CONFIG, str);
            QLog.d(f250274b, 1, "[onUpdateConfig], config: " + str);
        }
    }
}
