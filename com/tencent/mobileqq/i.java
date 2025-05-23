package com.tencent.mobileqq;

import android.text.TextUtils;
import com.tencent.mobileqq.emoticon.EmotionInjectionInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes9.dex */
public class i {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private ConcurrentHashMap<String, EmotionInjectionInfo> f237054a;

    public i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public void a(String str, EmotionInjectionInfo emotionInjectionInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) str, (Object) emotionInjectionInfo);
            return;
        }
        if (emotionInjectionInfo != null && !TextUtils.isEmpty(str)) {
            if (this.f237054a == null) {
                this.f237054a = new ConcurrentHashMap<>();
            }
            if (!this.f237054a.containsKey(str)) {
                this.f237054a.put(str, emotionInjectionInfo);
            }
        }
    }

    public EmotionInjectionInfo b(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (EmotionInjectionInfo) iPatchRedirector.redirect((short) 5, (Object) this, i3);
        }
        String b16 = com.tencent.mobileqq.config.business.n.b(i3);
        ConcurrentHashMap<String, EmotionInjectionInfo> concurrentHashMap = this.f237054a;
        if (concurrentHashMap != null && b16 != null) {
            return concurrentHashMap.get(b16);
        }
        return null;
    }

    public EmotionInjectionInfo c(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (EmotionInjectionInfo) iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
        }
        ConcurrentHashMap<String, EmotionInjectionInfo> concurrentHashMap = this.f237054a;
        if (concurrentHashMap != null && str != null) {
            return concurrentHashMap.get(str);
        }
        return null;
    }

    public Map<String, EmotionInjectionInfo> d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Map) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.f237054a;
    }
}
