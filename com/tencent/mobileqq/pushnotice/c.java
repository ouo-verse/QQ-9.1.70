package com.tencent.mobileqq.pushnotice;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.subaccount.api.ISubAccountService;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.AppSetting;
import com.tencent.util.notification.NotificationController;
import com.xiaomi.mipush.sdk.MiPushMessage;
import mqq.app.AppRuntime;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes16.dex */
public class c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static String f261350a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(74313);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f261350a = "HPush";
        }
    }

    private static String a(int i3, int i16) {
        if (i3 != 1041) {
            if (i3 != 1042) {
                return null;
            }
        } else if (i16 != 0) {
            if (i16 != 1) {
                if (i16 == 2) {
                    return "0X8009E08";
                }
            } else {
                return "0X8009E07";
            }
        } else {
            return "0X8009E06";
        }
        if (i16 != 0) {
            if (i16 != 1) {
                if (i16 != 2) {
                    return null;
                }
                return "0X8009E0B";
            }
            return "0X8009E0A";
        }
        return "0X8009E09";
    }

    public static boolean b(Context context, Intent intent) {
        if (intent == null || intent.getExtras() == null) {
            return false;
        }
        if (!c(intent)) {
            if (!AppSetting.isPublicVersion()) {
                QLog.e(f261350a, 1, "handlePushJumpIntent:isFromPush=false, intent: " + intent.getExtras());
            } else {
                QLog.i(f261350a, 1, "handlePushJumpIntent: isFromPush=false");
            }
            return false;
        }
        QLog.i(f261350a, 1, "handlePushJumpIntent: is from hw push.");
        Intent intent2 = new Intent();
        intent2.putExtra("from_third_push_jump", true);
        intent2.putExtras(intent.getExtras());
        RouteUtils.startActivity(context, intent2, RouterConstants.UI_ROUTER_JUMP);
        return true;
    }

    public static boolean c(Intent intent) {
        if (intent.hasExtra("third_push_jump") && intent.hasExtra("token")) {
            return true;
        }
        return false;
    }

    public static boolean d(Intent intent) {
        if (!"xiaomi".equalsIgnoreCase(Build.MANUFACTURER) || intent == null || intent.getExtras() == null || !intent.getExtras().containsKey("key_message")) {
            return false;
        }
        try {
            MiPushMessage miPushMessage = (MiPushMessage) intent.getExtras().getSerializable("key_message");
            if (!miPushMessage.getExtra().containsKey("client_data")) {
                return false;
            }
            String str = miPushMessage.getExtra().get("client_data");
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            JSONObject jSONObject = new JSONObject(str);
            if (!jSONObject.has("third_push_jump")) {
                return false;
            }
            if (!jSONObject.has("token")) {
                return false;
            }
            return true;
        } catch (Throwable th5) {
            QLog.e(f261350a, 1, "isFromXiaomiPush: exception.", th5);
            return false;
        }
    }

    public static void e(int i3, int i16) {
        String a16 = a(i3, i16);
        if (!TextUtils.isEmpty(a16)) {
            ReportController.o(null, "dc00898", "", "", a16, a16, 0, 0, "", "", "", "");
        }
    }

    public static void f(boolean z16) {
        AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
        if (runtime != null && (runtime instanceof QQAppInterface)) {
            QQAppInterface qQAppInterface = (QQAppInterface) BaseApplicationImpl.getApplication().getRuntime();
            NotificationController notificationController = (NotificationController) qQAppInterface.getBusinessHandler(BusinessHandlerFactory.NOTIFICATION_CONTROLLER_HANDLER);
            ISubAccountService iSubAccountService = (ISubAccountService) qQAppInterface.getRuntimeService(ISubAccountService.class, "");
            if (notificationController != null && iSubAccountService != null) {
                notificationController.requestSetNewMsgSwitch(z16, iSubAccountService.getNotifySwitch());
                QLog.d("HPush", 1, "HPush_Huawei Push sendNewMsgSwitchToServer : " + z16);
            }
        }
    }
}
