package com.tencent.mobileqq.login;

import androidx.annotation.NonNull;
import com.tencent.mobileqq.login.ntlogin.mainline.NTAccountLoginMainline;
import com.tencent.mobileqq.login.ntlogin.mainline.NTLocalPhoneLoginMainline;
import com.tencent.mobileqq.login.ntlogin.mainline.NTPhonePasswordLoginMainline;
import com.tencent.mobileqq.login.ntlogin.mainline.NTPhoneSmsLoginMainline;
import com.tencent.mobileqq.login.ntlogin.mainline.NTWechatLoginMainline;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInjectJustClazz;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes15.dex */
public class al {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @QAutoInjectJustClazz(configPath = "AutoInjectYml/Business/QQLoginImpl/Inject_login_register_config.yml", version = 1)
    private static HashMap<String, Class<? extends k>> f241875a;

    /* renamed from: b, reason: collision with root package name */
    @QAutoInjectJustClazz(configPath = "AutoInjectYml/Business/QQLoginImpl/Inject_login_register_config.yml", version = 1)
    private static HashMap<String, Class<? extends k>> f241876b;

    /* renamed from: c, reason: collision with root package name */
    private static final Map<Class<? extends k>, k> f241877c;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(32457);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        HashMap<String, Class<? extends k>> hashMap = new HashMap<>();
        f241875a = hashMap;
        hashMap.put("7", PhonePasswordLoginMainline.class);
        f241875a.put("6", WeChatLoginMainline.class);
        f241875a.put("5", PhoneSmsLoginMainline.class);
        f241875a.put("4", PhoneQuickLoginMainline.class);
        f241875a.put("3", AccountLoginMainline.class);
        f241875a.put("2", AccountLoginMainline.class);
        f241875a.put("1", AccountLoginMainline.class);
        HashMap<String, Class<? extends k>> hashMap2 = new HashMap<>();
        f241876b = hashMap2;
        hashMap2.put("7", NTPhonePasswordLoginMainline.class);
        f241876b.put("6", NTWechatLoginMainline.class);
        f241876b.put("5", NTPhoneSmsLoginMainline.class);
        f241876b.put("4", NTLocalPhoneLoginMainline.class);
        f241876b.put("3", NTAccountLoginMainline.class);
        f241876b.put("2", NTAccountLoginMainline.class);
        f241876b.put("1", NTAccountLoginMainline.class);
        f241877c = new ConcurrentHashMap();
    }

    public al() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private static synchronized k a(Class<? extends k> cls) {
        k newInstance;
        synchronized (al.class) {
            try {
                newInstance = cls.newInstance();
            } catch (Exception e16) {
                QLog.e("LoginMainlineFactory", 1, "createInstance exception", e16);
                return null;
            }
        }
        return newInstance;
    }

    @NonNull
    public static <T extends k<S>, S extends l> T b(int i3) {
        Class<? extends k> cls;
        T t16;
        if (MobileQQ.sMobileQQ.isLoginByNT()) {
            cls = f241876b.get(String.valueOf(i3));
        } else {
            cls = f241875a.get(String.valueOf(i3));
        }
        if (cls != null) {
            Map<Class<? extends k>, k> map = f241877c;
            T t17 = (T) map.get(cls);
            if (t17 != null) {
                return t17;
            }
            synchronized (al.class) {
                t16 = (T) map.get(cls);
                if (t16 == null && (t16 = (T) a(cls)) != null) {
                    map.put(cls, t16);
                }
            }
            if (t16 != null) {
                return t16;
            }
            throw new RuntimeException("LoginMainline return null, loginType=" + i3);
        }
        throw new RuntimeException("LoginMainline class is null, loginType=" + i3);
    }
}
