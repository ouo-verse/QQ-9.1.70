package com.tencent.mobileqq.activity.specialcare;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.FileUtils;

/* compiled from: P */
/* loaded from: classes10.dex */
public class MoveConfig implements Runnable {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private String f186383d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public MoveConfig(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str);
        } else {
            this.f186383d = str;
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        FileUtils.moveFile(this.f186383d + "https://i.gtimg.cn/club/moblie/special_sound/new_config.json", this.f186383d + "pddata/vas/special_remind/new_config.json");
    }
}
