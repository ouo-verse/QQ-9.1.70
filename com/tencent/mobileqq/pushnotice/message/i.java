package com.tencent.mobileqq.pushnotice.message;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.app.parser.jumpcontroller.b;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqfeatureswitch.IFeatureRuntimeService;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes16.dex */
public class i {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static String f261378a;

    /* renamed from: b, reason: collision with root package name */
    public static String f261379b;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(74325);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f261378a = "";
            f261379b = "";
        }
    }

    public static boolean a(Intent intent) {
        if (!i(intent)) {
            QLog.i("MessagePushHelper", 1, "canHandle: intent not support");
            return false;
        }
        if (j(intent)) {
            return true;
        }
        QLog.i("MessagePushHelper", 1, "canHandle: type cannot handle,");
        return false;
    }

    private static List<h> b() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new e());
        arrayList.add(new TroopPushHandler());
        arrayList.add(new g());
        arrayList.add(new j());
        return arrayList;
    }

    public static boolean c() {
        boolean z16;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            z16 = ((IFeatureRuntimeService) peekAppRuntime.getRuntimeService(IFeatureRuntimeService.class, "all")).isFeatureSwitchEnable("offline_push_switch_8885", true);
        } else {
            z16 = true;
        }
        if (!z16) {
            QLog.d("MessagePushHelper", 1, "getOfflinePushSwitch switchEnable:false");
        }
        return z16;
    }

    private static String d() {
        if (TextUtils.isEmpty(f261379b)) {
            f261379b = Build.BRAND;
        }
        return f261379b;
    }

    private static String e() {
        if (TextUtils.isEmpty(f261378a)) {
            f261378a = Build.BRAND + " " + DeviceInfoMonitor.getModel();
        }
        return f261378a;
    }

    public static int f(String str) {
        if ("57618".equals(str)) {
            return 1;
        }
        if ("57619".equals(str)) {
            return 2;
        }
        if ("57620".equals(str)) {
            return 3;
        }
        if ("57621".equals(str)) {
            return 4;
        }
        return 5;
    }

    public static int g(int i3) {
        if (i3 == 0) {
            return 1;
        }
        if (i3 == 1) {
            return 2;
        }
        if (i3 == 1000) {
            return 3;
        }
        if (i3 == 7000) {
            return 4;
        }
        return 5;
    }

    public static boolean h(Context context, Intent intent, AppRuntime appRuntime, b.a aVar) {
        if (context != null && intent != null && appRuntime != null) {
            k(appRuntime, intent);
            if (!a(intent)) {
                QLog.w("MessagePushHelper", 1, "handleMessagePush: not can handle intent, action=" + intent.getAction() + " scheme=" + intent.getScheme() + " extras=" + intent.getExtras());
                return false;
            }
            if (!c()) {
                QLog.i("MessagePushHelper", 1, "handleMessagePush: offline push switch is off");
                aVar.f196482a = false;
                n(context, new Intent());
                return true;
            }
            Iterator<h> it = b().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                h next = it.next();
                if (next.a(intent)) {
                    try {
                        QLog.i("MessagePushHelper", 1, "handleMessagePush: intent is handled by " + next.getClass().getSimpleName() + " action=" + intent.getAction() + " scheme=" + intent.getScheme() + " extras=" + intent.getExtras());
                        aVar.f196482a = next.b(context, intent, appRuntime);
                        return true;
                    } catch (Exception e16) {
                        QLog.w("MessagePushHelper", 1, "handleMessagePush doAction error", e16);
                    }
                }
            }
            QLog.w("MessagePushHelper", 1, "handleMessagePush: no proper handler, start splash activity, action=" + intent.getAction() + " scheme=" + intent.getScheme() + " extras=" + intent.getExtras());
            aVar.f196482a = false;
            n(context, new Intent());
            return true;
        }
        QLog.w("MessagePushHelper", 1, "handleMessagePush: param is null");
        return false;
    }

    private static boolean i(Intent intent) {
        if (!"com.tencent.mobileqq.third.push".equals(intent.getAction()) && !"mqqthirdpush".equalsIgnoreCase(intent.getScheme())) {
            return false;
        }
        return true;
    }

    private static boolean j(Intent intent) {
        if (intent == null) {
            QLog.w("MessagePushHelper", 1, "isTypeCanHandle intent null");
            return false;
        }
        String stringExtra = intent.getStringExtra("jumptype");
        if (!"57618".equals(stringExtra) && !"57619".equals(stringExtra) && !"57620".equals(stringExtra) && !"57621".equals(stringExtra)) {
            return false;
        }
        return true;
    }

    public static void k(AppRuntime appRuntime, Intent intent) {
        try {
            if (!((IFeatureRuntimeService) appRuntime.getRuntimeService(IFeatureRuntimeService.class, "all")).isFeatureSwitchEnable("message_third_push", true)) {
                QLog.w("MessagePushHelper", 1, "preHandleActionParam switchEnable:false");
                return;
            }
            if (!i(intent)) {
                QLog.w("MessagePushHelper", 1, "preHandleActionParam: intent is not supported, action=" + intent.getAction() + " scheme=" + intent.getScheme());
                return;
            }
            String stringExtra = intent.getStringExtra("action_param");
            if (stringExtra != null && stringExtra.length() != 0) {
                JSONObject jSONObject = new JSONObject(stringExtra);
                Iterator keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String str = (String) keys.next();
                    intent.putExtra(str, jSONObject.optString(str));
                }
                QLog.i("MessagePushHelper", 1, "preHandleActionParam: action=" + intent.getAction() + " scheme=" + intent.getScheme() + " actionParam=" + stringExtra);
            }
        } catch (Exception e16) {
            QLog.w("MessagePushHelper", 1, "preHandleActionParam: exception.", e16);
        }
    }

    public static void l(AppRuntime appRuntime, String str) {
        ReportController.o(appRuntime, "dc00898", "", "", "0X800C1C0", "0X800C1C0", 0, 1, String.valueOf(f(str)), "", e(), d());
    }

    public static void m(AppRuntime appRuntime, int i3) {
        ReportController.o(appRuntime, "dc00898", "", "", "0X800C1BF", "0X800C1BF", 0, 2, String.valueOf(g(i3)), "", "", d());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void n(Context context, Intent intent) {
        JumpActivity.setShouldFinishJumpActivity(intent);
        RouteUtils.startActivity(context, intent, RouterConstants.UI_ROUTER_SPLASH);
    }
}
