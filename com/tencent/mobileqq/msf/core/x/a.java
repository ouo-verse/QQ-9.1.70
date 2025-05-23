package com.tencent.mobileqq.msf.core.x;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes15.dex */
public class a {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: d, reason: collision with root package name */
    private static final String f250163d = "BeforeMsgSyncConfig";

    /* renamed from: e, reason: collision with root package name */
    public static final String f250164e = "before_msg_sync_config_sp_name";

    /* renamed from: f, reason: collision with root package name */
    public static final String f250165f = "json_config_all";

    /* renamed from: g, reason: collision with root package name */
    public static final String f250166g = "is_control_enable";

    /* renamed from: h, reason: collision with root package name */
    public static final String f250167h = "max_control_time";

    /* renamed from: i, reason: collision with root package name */
    public static final String f250168i = "white_cmd_list";

    /* renamed from: j, reason: collision with root package name */
    public static final Boolean f250169j;

    /* renamed from: k, reason: collision with root package name */
    public static final int f250170k = 3000;

    /* renamed from: a, reason: collision with root package name */
    private boolean f250171a;

    /* renamed from: b, reason: collision with root package name */
    private int f250172b;

    /* renamed from: c, reason: collision with root package name */
    private HashSet<String> f250173c;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public static class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private static final a f250174a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(25763);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
            } else {
                f250174a = new a(null);
            }
        }

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(19407);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            f250169j = Boolean.TRUE;
        }
    }

    /* synthetic */ a(C8099a c8099a) {
        this();
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) c8099a);
    }

    public static a b() {
        return b.f250174a;
    }

    public void a(@NonNull ToServiceMsg toServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) toServiceMsg);
            return;
        }
        Object obj = toServiceMsg.getAttributes().get(BaseConstants.KEY_BEFORE_MSG_SYNC_CONFIG_ALL);
        if (obj instanceof String) {
            String str = (String) obj;
            com.tencent.mobileqq.msf.core.b0.a.b().b(f250164e, 0).edit().putString(f250165f, str).apply();
            a(str);
            QLog.d(f250163d, 1, "[onUpdate], BeforeMsgSyncConfig: " + str);
        }
    }

    public boolean c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        return this.f250171a;
    }

    public int d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        return this.f250172b;
    }

    a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f250171a = f250169j.booleanValue();
        this.f250172b = 3000;
        this.f250173c = new HashSet<>();
        String string = com.tencent.mobileqq.msf.core.b0.a.b().b(f250164e, 0).getString(f250165f, "");
        if (TextUtils.isEmpty(string)) {
            return;
        }
        a(string);
        QLog.d(f250163d, 1, "[init], BeforeMsgSyncConfig: " + string);
    }

    private void a(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.f250171a = jSONObject.optBoolean(f250166g, f250169j.booleanValue());
            this.f250172b = jSONObject.optInt(f250167h, 3000);
            this.f250173c = MsfSdkUtils.convertJsonArrayToSet(jSONObject.optJSONArray(f250168i));
        } catch (Exception e16) {
            QLog.d(f250163d, 1, "onParseConfig with exception !", e16);
        }
    }

    public HashSet<String> a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 7)) ? this.f250173c : (HashSet) iPatchRedirector.redirect((short) 7, (Object) this);
    }
}
