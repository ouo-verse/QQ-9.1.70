package com.tencent.mobileqq.activity.recent.config.optpopbar;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.freesia.BaseConfigParser;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import java.nio.charset.StandardCharsets;

/* loaded from: classes10.dex */
public class RecentOptPopBarSwitchProcessor extends BaseConfigParser<a> {
    static IPatchRedirector $redirector_;

    public RecentOptPopBarSwitchProcessor() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.freesia.BaseConfigParser, com.tencent.freesia.ConfigParser
    @NonNull
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public a defaultConfig() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (a) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return a.a();
    }

    @Override // com.tencent.freesia.BaseConfigParser
    @NonNull
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public a parse(@NonNull byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (a) iPatchRedirector.redirect((short) 2, (Object) this, (Object) bArr);
        }
        String str = new String(bArr, StandardCharsets.UTF_8);
        if (TextUtils.isEmpty(str)) {
            QLog.d("RecentOptPopBarSwitchProcessor", 1, "RecentOptPopBarSwitchBean parse null");
            return a.a();
        }
        QLog.d("RecentOptPopBarSwitchProcessor", 1, "RecentOptPopBarSwitchBean parse " + str);
        return a.o(str);
    }
}
