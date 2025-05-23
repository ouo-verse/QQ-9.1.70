package com.tencent.mobileqq.relationx.friendclue;

import androidx.annotation.NonNull;
import com.tencent.freesia.BaseConfigParser;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import java.nio.charset.StandardCharsets;
import org.json.JSONObject;

/* loaded from: classes17.dex */
public class FriendClueConfigParser extends BaseConfigParser<b> {
    static IPatchRedirector $redirector_;

    public FriendClueConfigParser() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.freesia.BaseConfigParser, com.tencent.freesia.ConfigParser
    @NonNull
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public b defaultConfig() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (b) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        QLog.i("FriendClueConfigParser", 1, "defaultConfig");
        return new b();
    }

    @Override // com.tencent.freesia.BaseConfigParser
    @NonNull
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public b parse(@NonNull byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (b) iPatchRedirector.redirect((short) 2, (Object) this, (Object) bArr);
        }
        b bVar = new b();
        String str = "";
        if (bArr != null) {
            try {
                if (bArr.length > 0) {
                    str = new String(bArr, StandardCharsets.UTF_8);
                }
            } catch (Exception e16) {
                QLog.e("FriendClueConfigParser", 1, "parse, exp=" + e16.toString());
            }
        }
        JSONObject jSONObject = new JSONObject(str);
        if (jSONObject.has("friendClueSwitch")) {
            bVar.f280733d = jSONObject.getBoolean("friendClueSwitch");
        }
        QLog.i("FriendClueConfigParser", 1, "parse, friendClueSwitch=" + bVar.f280733d + " cfgStr=" + str);
        return bVar;
    }
}
