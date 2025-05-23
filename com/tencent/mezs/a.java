package com.tencent.mezs;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.NotificationActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.icgame.api.impl.room.report.AudienceReportConst;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.utils.SecUtil;
import com.tencent.mqpsdk.b;
import com.tencent.mqpsdk.secsrv.c;
import com.tencent.msfmqpsdkbridge.MSFNetTransportProvider;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import common.config.service.QzoneConfig;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes9.dex */
public class a implements c.a {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private static boolean f151584d;

    /* renamed from: a, reason: collision with root package name */
    private QQAppInterface f151585a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f151586b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f151587c;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(66516);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            f151584d = true;
        }
    }

    public a(QQAppInterface qQAppInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface);
            return;
        }
        this.f151586b = false;
        this.f151587c = false;
        this.f151585a = qQAppInterface;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        String str;
        String str2;
        if (this.f151585a == null) {
            return;
        }
        SharedPreferences sharedPreferences = BaseApplication.getContext().getSharedPreferences("SecSig", 0);
        SharedPreferences.Editor edit = sharedPreferences.edit();
        String string = sharedPreferences.getString("SecMd5Entry", null);
        int i3 = sharedPreferences.getInt("SecResEntry", -1);
        long j3 = sharedPreferences.getLong("SecStampEntry", -1L);
        long currentTimeMillis = System.currentTimeMillis();
        int i16 = sharedPreferences.getInt("SecCacheTime", QzoneConfig.DefaultValue.QZONESETTINGS_AIO_FEEDS_MIN_REFRESH_TIME);
        if (this.f151587c) {
            str = "SecMd5Entry";
            edit.remove("SecResEntry");
            edit.remove("SecStampEntry");
            str2 = null;
        } else {
            if (!f151584d) {
                if (currentTimeMillis > (j3 ^ 18) + (i16 * 1000)) {
                    f151584d = true;
                } else {
                    return;
                }
            }
            str2 = com.tencent.mdm.a.a(this.f151585a.getApplication().getApplicationInfo().sourceDir);
            if (str2 != null && str2.length() != 0) {
                f151584d = false;
                if (string == null || !string.equalsIgnoreCase(str2) || j3 == -1) {
                    str = "SecMd5Entry";
                } else {
                    str = "SecMd5Entry";
                    if (currentTimeMillis <= (j3 ^ 18) + (i16 * 1000) && i3 != -1 && (i3 ^ 18) == 1) {
                        return;
                    }
                }
                if (currentTimeMillis > (j3 ^ 18) + (i16 * 1000)) {
                    edit.remove("SecResEntry");
                    edit.remove("SecStampEntry");
                }
            } else {
                return;
            }
        }
        if (str2 == null && ((str2 = com.tencent.mdm.a.a(this.f151585a.getApplication().getApplicationInfo().sourceDir)) == null || str2.length() == 0)) {
            return;
        }
        edit.putString(str, str2);
        edit.commit();
        String signatureHash = SecUtil.getSignatureHash(SecUtil.getSign(BaseApplication.getContext()));
        String packageVersion = SecUtil.getPackageVersion(BaseApplication.getContext());
        if (QLog.isColorLevel()) {
            QLog.d("SigChk", 2, str2);
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("uin", Long.parseLong(this.f151585a.getCurrentAccountUin()));
            jSONObject.put(AudienceReportConst.CLIENT_TYPE, 0);
            jSONObject.put("is_repack", 0);
            String packageName = this.f151585a.getApplication().getPackageName();
            if (TextUtils.isEmpty(packageName)) {
                packageName = "MobileQQ";
            }
            jSONObject.put("package_name", packageName);
            jSONObject.put("package_version", packageVersion);
            jSONObject.put("package_md5", str2);
            jSONObject.put("package_signature", signatureHash);
            c cVar = (c) new b(this.f151585a.getApp().getApplicationContext(), (MSFNetTransportProvider) this.f151585a.getBusinessHandler(BusinessHandlerFactory.MSF_NET_TRANSPORT_PROVIDER_HANDLER)).a("sig_check");
            if (cVar != null) {
                cVar.b(this);
                cVar.c(jSONObject.toString());
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:25:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void d(JSONObject jSONObject) {
        String str;
        String str2;
        String str3;
        String str4;
        if (jSONObject == null) {
            return;
        }
        String str5 = null;
        try {
            str = jSONObject.getString("dialog_title");
        } catch (Exception e16) {
            e = e16;
            str = null;
            str2 = null;
        }
        try {
            str2 = jSONObject.getString("dialog_content");
            try {
                str3 = jSONObject.getString("dialog_left_button");
                try {
                    str4 = jSONObject.getString("dialog_right_button");
                    try {
                        str5 = jSONObject.getString("url");
                    } catch (Exception e17) {
                        e = e17;
                        e.printStackTrace();
                        if (TextUtils.isEmpty(str)) {
                        }
                    }
                } catch (Exception e18) {
                    e = e18;
                    str4 = null;
                }
            } catch (Exception e19) {
                e = e19;
                str3 = null;
                str4 = str3;
                e.printStackTrace();
                if (TextUtils.isEmpty(str)) {
                }
            }
        } catch (Exception e26) {
            e = e26;
            str2 = null;
            str3 = str2;
            str4 = str3;
            e.printStackTrace();
            if (TextUtils.isEmpty(str)) {
            } else {
                return;
            }
        }
        if (TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            BaseActivity baseActivity = BaseActivity.sTopActivity;
            Intent intent = new Intent();
            intent.putExtra("type", 9);
            Bundle bundle = new Bundle();
            bundle.putString(NotificationActivity.DLG_TITLE, str);
            bundle.putString(NotificationActivity.DLG_CONTENT, str2);
            bundle.putString(NotificationActivity.DLG_LBUTTON, str3);
            bundle.putString(NotificationActivity.DLG_RBUTTON, str4);
            bundle.putString(NotificationActivity.DLG_URL, str5);
            intent.putExtras(bundle);
            intent.setFlags(872415232);
            RouteUtils.startActivity(baseActivity, intent, RouterConstants.UI_ROUTER_NOTIFICATION);
        }
    }

    private void f(int i3, int i16) {
        SharedPreferences sharedPreferences = BaseApplication.getContext().getSharedPreferences("SecSig", 0);
        SharedPreferences.Editor edit = sharedPreferences.edit();
        int i17 = sharedPreferences.getInt("SecResEntry", -1);
        if (i17 == -1 || (i17 ^ 18) != i3) {
            edit.putInt("SecResEntry", i3 ^ 18);
            edit.putLong("SecStampEntry", System.currentTimeMillis() ^ 18);
            edit.putInt("SecCacheTime", i16);
            edit.commit();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0042  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004b  */
    @Override // com.tencent.mqpsdk.secsrv.c.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(String str) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
            return;
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        int i16 = -1;
        JSONObject jSONObject = null;
        try {
            JSONObject jSONObject2 = new JSONObject(str);
            i3 = jSONObject2.getInt("sig_check_result");
            try {
                jSONObject = jSONObject2.getJSONObject("dialog_config");
                i16 = jSONObject2.getInt("cache_time");
            } catch (Exception e16) {
                e = e16;
                e.printStackTrace();
                int i17 = 1;
                if (i3 != 0) {
                    if (i3 == 2) {
                    }
                }
                if (i3 != 0) {
                }
                f(i17, i16);
            }
        } catch (Exception e17) {
            e = e17;
            i3 = -1;
        }
        int i172 = 1;
        if (i3 != 0 && i3 != 1) {
            if (i3 == 2) {
                if (i3 != 3) {
                    return;
                }
            } else {
                d(jSONObject);
            }
        }
        if (i3 != 0) {
            i172 = 0;
        }
        f(i172, i16);
    }

    public void e(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, z16);
            return;
        }
        if (this.f151586b) {
            return;
        }
        this.f151586b = true;
        this.f151587c = z16;
        if (z16) {
            new BaseThread() { // from class: com.tencent.mezs.a.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) a.this);
                    }
                }

                @Override // com.tencent.thread.monitor.plugin.proxy.BaseThread, java.lang.Thread, java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                        a.this.c();
                    } else {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                }
            }.start();
        } else {
            c();
        }
        this.f151586b = false;
    }
}
