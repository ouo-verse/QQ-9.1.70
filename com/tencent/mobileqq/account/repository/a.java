package com.tencent.mobileqq.account.repository;

import android.content.Context;
import android.text.TextUtils;
import com.google.gson.Gson;
import com.google.gson.JsonParseException;
import com.google.gson.reflect.TypeToken;
import com.tencent.mobileqq.account.bean.DeleteAccount;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import mqq.app.MobileQQ;
import okhttp3.HttpUrl;

/* compiled from: P */
/* loaded from: classes9.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private final Context f174505a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.account.repository.a$a, reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class C7089a extends TypeToken<List<DeleteAccount>> {
        static IPatchRedirector $redirector_;

        C7089a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) a.this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private static final a f174507a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(26016);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
            } else {
                f174507a = new a();
            }
        }
    }

    a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f174505a = MobileQQ.sMobileQQ.getApplicationContext();
        }
    }

    public static a c() {
        return b.f174507a;
    }

    private String d(String str, String str2, String str3) {
        StringBuilder sb5 = new StringBuilder();
        sb5.append("qq_account_manager");
        if (str == null) {
            str = "";
        }
        sb5.append(str);
        return this.f174505a.getSharedPreferences(sb5.toString(), 0).getString(str2, str3);
    }

    private void f(String str, String str2, String str3) {
        StringBuilder sb5 = new StringBuilder();
        sb5.append("qq_account_manager");
        if (str == null) {
            str = "";
        }
        sb5.append(str);
        this.f174505a.getSharedPreferences(sb5.toString(), 0).edit().putString(str2, str3).apply();
    }

    public void a(String str, String str2) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) str, (Object) str2);
            return;
        }
        if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
            return;
        }
        List<DeleteAccount> b16 = b();
        if (b16 != null) {
            for (DeleteAccount deleteAccount : b16) {
                z16 = false;
                if ((!TextUtils.isEmpty(str) && TextUtils.equals(str, deleteAccount.getUin())) || (!TextUtils.isEmpty(str2) && TextUtils.equals(str2, deleteAccount.getId()))) {
                    break;
                }
            }
        }
        z16 = true;
        if (z16) {
            DeleteAccount deleteAccount2 = new DeleteAccount(str, str2);
            if (b16 == null) {
                b16 = new ArrayList<>();
            }
            b16.add(deleteAccount2);
            e(b16);
        }
    }

    public List<DeleteAccount> b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (List) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        String d16 = d("", "delete_accounts", "");
        try {
            if (TextUtils.isEmpty(d16)) {
                return null;
            }
            return (List) new Gson().fromJson(d16, new C7089a().getType());
        } catch (JsonParseException e16) {
            QLog.e("AccountCacheManager", 2, e16, new Object[0]);
            return null;
        }
    }

    public void e(List<DeleteAccount> list) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) list);
            return;
        }
        if (list != null && !list.isEmpty()) {
            str = new Gson().toJson(list);
        } else {
            str = HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
        }
        f("", "delete_accounts", str);
    }
}
