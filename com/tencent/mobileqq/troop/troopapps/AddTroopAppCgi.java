package com.tencent.mobileqq.troop.troopapps;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.flock.base.FlockBaseRequest;
import com.tencent.mobileqq.pskey.api.IPskeyManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.troop.utils.e;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import java.util.HashMap;
import java.util.Map;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes19.dex */
public class AddTroopAppCgi {
    static IPatchRedirector $redirector_;

    /* renamed from: g, reason: collision with root package name */
    private static volatile boolean f299299g;

    /* renamed from: h, reason: collision with root package name */
    private static Dialog f299300h;

    /* renamed from: a, reason: collision with root package name */
    private WeakReference<c> f299301a;

    /* renamed from: b, reason: collision with root package name */
    private String f299302b;

    /* renamed from: c, reason: collision with root package name */
    private long f299303c;

    /* renamed from: d, reason: collision with root package name */
    private long f299304d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f299305e;

    /* renamed from: f, reason: collision with root package name */
    private Object f299306f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes19.dex */
    public class a implements sd2.a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f299309a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ QQAppInterface f299310b;

        a(String str, QQAppInterface qQAppInterface) {
            this.f299309a = str;
            this.f299310b = qQAppInterface;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, AddTroopAppCgi.this, str, qQAppInterface);
            }
        }

        @Override // sd2.a
        public void onFail(@NonNull String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
                return;
            }
            QLog.e("AddTroopAppCgi", 1, "fail to get pskey, domain = " + this.f299309a + " errMsg: " + str);
        }

        @Override // sd2.a
        public void onSuccess(@NonNull Map<String, String> map) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) map);
            } else {
                QLog.d("AddTroopAppCgi", 1, "get pskey onSuccess");
                AddTroopAppCgi.this.h(this.f299310b, map.get(this.f299309a));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes19.dex */
    public class b implements DialogInterface.OnDismissListener {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AddTroopAppCgi.this);
            }
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface);
            } else {
                QLog.i("AddTroopAppCgi", 1, "dialog onDismiss");
                AddTroopAppCgi.f299300h = null;
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes19.dex */
    public interface c {
        void a(Object obj);

        void b(int i3, String str, Object obj);
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(76626);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            f299299g = false;
            f299300h = null;
        }
    }

    public AddTroopAppCgi(c cVar, String str, long j3, long j16, boolean z16, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, cVar, str, Long.valueOf(j3), Long.valueOf(j16), Boolean.valueOf(z16), obj);
            return;
        }
        this.f299302b = str;
        this.f299303c = j3;
        this.f299304d = j16;
        this.f299305e = z16;
        this.f299301a = new WeakReference<>(cVar);
        this.f299306f = obj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(QQAppInterface qQAppInterface, String str) {
        String currentUin = qQAppInterface.getCurrentUin();
        String j3 = j(str, 10);
        Bundle bundle = new Bundle();
        HashMap<String, Object> hashMap = new HashMap<>();
        bundle.putString("bkn", "" + TroopUtils.h(j3));
        bundle.putString("Cookie", "uin=o" + currentUin + ";skey=" + j3 + ";p_uin=o" + currentUin + ";p_skey=" + str);
        bundle.putString("gc", String.valueOf(this.f299302b));
        bundle.putString("append_appid", String.valueOf(this.f299303c));
        String str2 = "1";
        bundle.putString("add_type", "1");
        bundle.putString("append_source", String.valueOf(this.f299304d));
        bundle.putString("qqver", AppSetting.f99551k + "." + AppSetting.f99542b);
        bundle.putString("platform", "2");
        if (!this.f299305e) {
            str2 = "0";
        }
        bundle.putString("open_shortcut", str2);
        hashMap.put("BUNDLE", bundle);
        hashMap.put("CONTEXT", qQAppInterface.getApp().getApplicationContext());
        if (f299299g) {
            QLog.i("AddTroopAppCgi", 1, "execute failed, isRequesting, fast return");
            return;
        }
        f299299g = true;
        Dialog dialog = f299300h;
        if (dialog != null && dialog.isShowing()) {
            QLog.i("AddTroopAppCgi", 1, "requst, dialog isShowing, try dimiss");
            f299300h.dismiss();
            f299300h = null;
        }
        QBaseActivity qBaseActivity = QBaseActivity.sTopActivity;
        if (qBaseActivity != null) {
            Dialog i3 = i(qBaseActivity);
            f299300h = i3;
            i3.setOnDismissListener(new b());
            QLog.i("AddTroopAppCgi", 1, "show dialog");
            f299300h.show();
        }
        new com.tencent.mobileqq.troop.utils.f("https://app.qun.qq.com/cgi-bin/api/inner_setunifiedapp", "POST", new e.a() { // from class: com.tencent.mobileqq.troop.troopapps.AddTroopAppCgi.3
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) AddTroopAppCgi.this);
                }
            }

            @Override // com.tencent.mobileqq.troop.utils.e.a
            public void rg(JSONObject jSONObject, int i16, Bundle bundle2) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                    AddTroopAppCgi.f299299g = false;
                    ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.troop.troopapps.AddTroopAppCgi.3.1
                        static IPatchRedirector $redirector_;

                        {
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AnonymousClass3.this);
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                iPatchRedirector2.redirect((short) 2, (Object) this);
                            } else if (AddTroopAppCgi.f299300h != null && AddTroopAppCgi.f299300h.isShowing()) {
                                QLog.i("AddTroopAppCgi", 1, "onResult dialog dismiss");
                                AddTroopAppCgi.f299300h.dismiss();
                            }
                        }
                    });
                    if (AddTroopAppCgi.this.f299301a.get() == 0) {
                        return;
                    }
                    if (jSONObject != null && jSONObject.has("ec")) {
                        int optInt = jSONObject.optInt("ec");
                        String optString = jSONObject.optString("em");
                        if (QLog.isColorLevel()) {
                            QLog.d("AddTroopAppCgi", 2, "retCode:", Integer.valueOf(optInt));
                        }
                        if (optInt == 0) {
                            ((c) AddTroopAppCgi.this.f299301a.get()).a(AddTroopAppCgi.this.f299306f);
                            return;
                        } else {
                            ((c) AddTroopAppCgi.this.f299301a.get()).b(optInt, optString, AddTroopAppCgi.this.f299306f);
                            return;
                        }
                    }
                    QLog.e("AddTroopAppCgi", 1, "add appid get result err");
                    ((c) AddTroopAppCgi.this.f299301a.get()).b(-1, "", AddTroopAppCgi.this.f299306f);
                    return;
                }
                iPatchRedirector.redirect((short) 2, this, jSONObject, Integer.valueOf(i16), bundle2);
            }
        }, 1000, null).b(hashMap);
        if (QLog.isColorLevel()) {
            QLog.d("AddTroopAppCgi", 2, "AddTroopAppCgi mTroopUin:" + this.f299302b + " append_appid:" + this.f299303c + " mNeedOpenShortCut:" + this.f299305e);
        }
    }

    private static Dialog i(Activity activity) {
        ReportDialog reportDialog = null;
        try {
            ReportDialog reportDialog2 = new ReportDialog(activity, R.style.qZoneInputDialog);
            try {
                reportDialog2.setCancelable(true);
                reportDialog2.setContentView(R.layout.f168383uh);
                ((TextView) reportDialog2.findViewById(R.id.photo_prievew_progress_dialog_text)).setText("\u6b63\u5728\u6dfb\u52a0...");
                return reportDialog2;
            } catch (OutOfMemoryError e16) {
                e = e16;
                reportDialog = reportDialog2;
                QLog.e("AddTroopAppCgi", 2, "newLoadingDialog error", e);
                return reportDialog;
            }
        } catch (OutOfMemoryError e17) {
            e = e17;
        }
    }

    @NotNull
    private String j(String str, int i3) {
        if (i3 > 0 && !TextUtils.isEmpty(str) && str.length() >= i3) {
            return str.substring(0, i3);
        }
        return "";
    }

    public void g(QQAppInterface qQAppInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) qQAppInterface);
        } else {
            if (qQAppInterface == null) {
                return;
            }
            ((IPskeyManager) qQAppInterface.getRuntimeService(IPskeyManager.class, "all")).getPskey(new String[]{FlockBaseRequest.QUN_DOMAIN}, new a(FlockBaseRequest.QUN_DOMAIN, qQAppInterface));
        }
    }
}
