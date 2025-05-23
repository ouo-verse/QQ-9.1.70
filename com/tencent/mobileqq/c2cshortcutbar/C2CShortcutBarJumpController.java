package com.tencent.mobileqq.c2cshortcutbar;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.c2cshortcutbar.store.a;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface;
import com.tencent.mobileqq.mini.sdk.EntryModel;
import com.tencent.mobileqq.mini.utils.SchemaUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.api.IChatSettingForTroopApi;
import com.tencent.mobileqq.utils.ac;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes11.dex */
public class C2CShortcutBarJumpController {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private com.tencent.mobileqq.c2cshortcutbar.store.a f200918a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes11.dex */
    public class a implements a.InterfaceC7442a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Activity f200920a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.activity.aio.rebuild.input.shortcutbar.a f200921b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ QQAppInterface f200922c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ SessionInfo f200923d;

        a(Activity activity, com.tencent.mobileqq.activity.aio.rebuild.input.shortcutbar.a aVar, QQAppInterface qQAppInterface, SessionInfo sessionInfo) {
            this.f200920a = activity;
            this.f200921b = aVar;
            this.f200922c = qQAppInterface;
            this.f200923d = sessionInfo;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, C2CShortcutBarJumpController.this, activity, aVar, qQAppInterface, sessionInfo);
            }
        }

        @Override // com.tencent.mobileqq.c2cshortcutbar.store.a.InterfaceC7442a
        public void a(int i3, com.tencent.mobileqq.c2cshortcutbar.b bVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, i3, (Object) bVar);
                return;
            }
            C2CShortcutBarJumpController.this.b(this.f200920a, this.f200921b, this.f200922c, this.f200923d, bVar, false);
            QQAppInterface qQAppInterface = this.f200922c;
            ReportController.o(qQAppInterface, "dc00898", "", "", "0X800B32D", "0X800B32D", e.d(qQAppInterface).f(this.f200923d.f179557e), 0, bVar.f200935a, i3 + "", "", "");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes11.dex */
    public class b implements MiniAppCmdInterface {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Activity f200925a;

        b(Activity activity) {
            this.f200925a = activity;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) C2CShortcutBarJumpController.this, (Object) activity);
            }
        }

        @Override // com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface
        public void onCmdListener(boolean z16, JSONObject jSONObject) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), jSONObject);
                return;
            }
            if (jSONObject != null && jSONObject.optInt("retCode") == -12998002) {
                C2CShortcutBarJumpController.this.k(this.f200925a);
            }
            if (QLog.isColorLevel()) {
                QLog.d("C2CShortcutBarJumpController", 2, "onCmdListener() isSuc = " + z16);
            }
        }
    }

    public C2CShortcutBarJumpController() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private static void c(QQAppInterface qQAppInterface, Context context, String str) {
        tr2.b bVar = (tr2.b) qQAppInterface.getManager(QQManagerFactory.TOGETHER_CONTROLLER_MANAGER);
        boolean B = bVar.B(4, -1, str);
        Bundle d16 = tr2.g.d(B, 3);
        if (B) {
            bVar.D(context, str, 2, 4, 3, d16);
        } else {
            bVar.S(context, str, 2, 4, 3, d16);
        }
    }

    private static void d(Activity activity, QQAppInterface qQAppInterface, SessionInfo sessionInfo, com.tencent.mobileqq.c2cshortcutbar.b bVar) {
        if (!TextUtils.isEmpty(bVar.f200939e)) {
            if (bVar.f200939e.startsWith("http") || bVar.f200939e.startsWith("https")) {
                Intent intent = new Intent(activity, (Class<?>) QQBrowserActivity.class);
                intent.putExtra("url", i(bVar.f200939e, qQAppInterface, sessionInfo.f179557e, bVar.f200935a));
                intent.putExtra("webStyle", "noBottomBar");
                intent.putExtra("startOpenPageTime", System.currentTimeMillis());
                activity.startActivity(intent);
            }
        }
    }

    private static void e(Activity activity, com.tencent.mobileqq.activity.aio.rebuild.input.shortcutbar.a aVar, QQAppInterface qQAppInterface, SessionInfo sessionInfo, com.tencent.mobileqq.c2cshortcutbar.b bVar) {
        boolean z16;
        int i3;
        if (!TextUtils.isEmpty(bVar.f200939e) && ((IMiniAppService) QRoute.api(IMiniAppService.class)).isMiniAppUrl(bVar.f200939e)) {
            if (aVar.b() == 5) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                i3 = 4017;
            } else {
                i3 = 4016;
            }
            ((IMiniAppService) QRoute.api(IMiniAppService.class)).startMiniApp(activity, i(bVar.f200939e, qQAppInterface, sessionInfo.f179557e, bVar.f200935a), i3, new EntryModel(0, Long.valueOf(sessionInfo.f179557e).longValue(), ac.G(qQAppInterface, sessionInfo.f179557e), false), null);
        }
    }

    private static void f(Activity activity, QQAppInterface qQAppInterface, SessionInfo sessionInfo, com.tencent.mobileqq.c2cshortcutbar.b bVar) {
        if (String.valueOf(IChatSettingForTroopApi.APPID_TOGETHERLISTEN).equals(bVar.f200935a)) {
            com.tencent.mobileqq.listentogether.g.b(qQAppInterface, activity, 2, sessionInfo.f179557e, 0);
        } else if (String.valueOf(IChatSettingForTroopApi.APPID_TOGETHERSING).equals(bVar.f200935a)) {
            c(qQAppInterface, activity, sessionInfo.f179557e);
        } else {
            String.valueOf(IChatSettingForTroopApi.APPID_TOGETHEHIGH).equals(bVar.f200935a);
        }
    }

    private static void g(Activity activity, QQAppInterface qQAppInterface, SessionInfo sessionInfo, com.tencent.mobileqq.c2cshortcutbar.b bVar) {
        if (!TextUtils.isEmpty(bVar.f200939e) && bVar.f200939e.startsWith(SchemaUtils.SCHEMA_MQQAPI)) {
            bVar.f200939e = i(bVar.f200939e, qQAppInterface, sessionInfo.f179557e, bVar.f200935a);
            Intent intent = new Intent(activity, (Class<?>) JumpActivity.class);
            intent.setData(Uri.parse(bVar.f200939e));
            activity.startActivity(intent);
        }
    }

    private boolean h(Activity activity, com.tencent.mobileqq.activity.aio.rebuild.input.shortcutbar.a aVar, QQAppInterface qQAppInterface, SessionInfo sessionInfo) {
        boolean z16;
        a();
        List<com.tencent.mobileqq.c2cshortcutbar.b> b16 = e.d(qQAppInterface).b(sessionInfo.f179557e);
        String str = sessionInfo.f179557e;
        a aVar2 = new a(activity, aVar, qQAppInterface, sessionInfo);
        if (aVar.b() == 5) {
            z16 = true;
        } else {
            z16 = false;
        }
        com.tencent.mobileqq.c2cshortcutbar.store.a aVar3 = new com.tencent.mobileqq.c2cshortcutbar.store.a(activity, qQAppInterface, str, b16, aVar2, z16);
        this.f200918a = aVar3;
        aVar3.f();
        ReportController.o(qQAppInterface, "dc00898", "", "", "0X800B32B", "0X800B32B", e.d(qQAppInterface).f(sessionInfo.f179557e), 0, "", "", "", "");
        return true;
    }

    private static String i(String str, QQAppInterface qQAppInterface, String str2, String str3) {
        return str.replace("$UIN$", qQAppInterface.getCurrentAccountUin()).replace("$GCODE$", str2).replace("$APPID$", str3);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x005a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean j(Activity activity, com.tencent.mobileqq.activity.aio.rebuild.input.shortcutbar.a aVar, QQAppInterface qQAppInterface, SessionInfo sessionInfo, com.tencent.mobileqq.c2cshortcutbar.b bVar) {
        int i3;
        int i16 = 0;
        if (!bVar.f200945k) {
            return false;
        }
        byte[] bArr = null;
        if (aVar.b() == 5) {
            int i17 = sessionInfo.f179555d;
            if (1044 == i17) {
                bArr = qQAppInterface.getMsgCache().H0(sessionInfo.f179557e, qQAppInterface.getCurrentAccountUin(), true);
                i16 = 163;
            } else if (1045 == i17) {
                bArr = qQAppInterface.getMsgCache().H0(sessionInfo.f179557e, qQAppInterface.getCurrentAccountUin(), false);
                i16 = 166;
            } else {
                if (1046 == i17) {
                    bArr = qQAppInterface.getMsgCache().I0(sessionInfo.f179557e, qQAppInterface.getCurrentAccountUin());
                }
                i3 = i17;
                byte[] bArr2 = bArr;
                if (QLog.isColorLevel()) {
                    QLog.d("C2CShortcutBarJumpController", 2, "sendArk() curType = " + i3 + " sig = " + bArr2);
                }
                ((IMiniAppService) QRoute.api(IMiniAppService.class)).createUpdatableMsg(bVar.f200935a, "657667B4D8C04B3F84E4AAA3D046A903", 1, 1, -1, sessionInfo.f179557e, i3, bArr2, new b(activity));
                return true;
            }
        }
        i3 = i16;
        byte[] bArr22 = bArr;
        if (QLog.isColorLevel()) {
        }
        ((IMiniAppService) QRoute.api(IMiniAppService.class)).createUpdatableMsg(bVar.f200935a, "657667B4D8C04B3F84E4AAA3D046A903", 1, 1, -1, sessionInfo.f179557e, i3, bArr22, new b(activity));
        return true;
    }

    public void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        com.tencent.mobileqq.c2cshortcutbar.store.a aVar = this.f200918a;
        if (aVar != null) {
            aVar.d();
            this.f200918a = null;
        }
    }

    public void b(Activity activity, com.tencent.mobileqq.activity.aio.rebuild.input.shortcutbar.a aVar, QQAppInterface qQAppInterface, SessionInfo sessionInfo, com.tencent.mobileqq.c2cshortcutbar.b bVar, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, activity, aVar, qQAppInterface, sessionInfo, bVar, Boolean.valueOf(z16));
            return;
        }
        if (bVar != null && aVar != null && qQAppInterface != null && activity != null && sessionInfo != null) {
            if (QLog.isColorLevel()) {
                QLog.d("C2CShortcutBarJumpController", 2, "isClickManager", Boolean.valueOf(z16), " { info = ", bVar.toString());
            }
            if (z16) {
                h(activity, aVar, qQAppInterface, sessionInfo);
                return;
            }
            int i3 = bVar.f200948n;
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        if (i3 != 4) {
                            if (i3 != 5) {
                                QLog.d("C2CShortcutBarJumpController", 1, "handlerJumpAction() unknown type: ", Long.valueOf(bVar.f200936b));
                                return;
                            } else {
                                f(activity, qQAppInterface, sessionInfo, bVar);
                                return;
                            }
                        }
                        j(activity, aVar, qQAppInterface, sessionInfo, bVar);
                        return;
                    }
                    e(activity, aVar, qQAppInterface, sessionInfo, bVar);
                    return;
                }
                d(activity, qQAppInterface, sessionInfo, bVar);
                return;
            }
            g(activity, qQAppInterface, sessionInfo, bVar);
            return;
        }
        QLog.d("C2CShortcutBarJumpController", 1, "handlerJumpAction() param is null just return ");
    }

    public void k(Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) activity);
        } else {
            if (activity == null) {
                return;
            }
            activity.runOnUiThread(new Runnable(activity) { // from class: com.tencent.mobileqq.c2cshortcutbar.C2CShortcutBarJumpController.3
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ Activity f200919d;

                {
                    this.f200919d = activity;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) C2CShortcutBarJumpController.this, (Object) activity);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else {
                        QQToast.makeText(this.f200919d, R.string.f3c, 0).show();
                    }
                }
            });
        }
    }
}
