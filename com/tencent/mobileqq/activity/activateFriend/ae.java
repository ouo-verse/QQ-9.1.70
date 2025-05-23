package com.tencent.mobileqq.activity.activateFriend;

import Wallet.AcsSubNoticeRsp;
import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.activateFriend.aa;
import com.tencent.mobileqq.activity.activateFriend.ae;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.mini.utils.SchemaUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.reminder.api.IQQReminderCalendarService;
import com.tencent.mobileqq.reminder.api.IQQReminderService;
import com.tencent.mobileqq.reminder.biz.entity.CalendarEntity;
import com.tencent.mobileqq.util.db;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.vaswebviewplugin.QWalletMixJsPlugin;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import java.lang.ref.WeakReference;
import mqq.app.AppActivity;
import mqq.app.MobileQQ;
import mqq.observer.BusinessObserver;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes9.dex */
public class ae {
    static IPatchRedirector $redirector_;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    class a implements IQQReminderCalendarService.a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Bundle f177954a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ c f177955b;

        a(Bundle bundle, c cVar) {
            this.f177954a = bundle;
            this.f177955b = cVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) bundle, (Object) cVar);
            }
        }

        @Override // com.tencent.mobileqq.reminder.api.IQQReminderCalendarService.a
        public void onResult(Bundle bundle) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) bundle);
                return;
            }
            ae.q(this.f177954a, bundle.getInt("retcode", -100), bundle.getString("retmsg", ""), this.f177955b);
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public interface b {
        void queryHasSetNotify(Bundle bundle, @Nullable Bundle bundle2);
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public interface c {
        void onResult(Bundle bundle, @Nullable Bundle bundle2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static class d implements EIPCResultCallback {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        private WeakReference<c> f177956d;

        /* renamed from: e, reason: collision with root package name */
        private Bundle f177957e;

        public d(Bundle bundle, c cVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) bundle, (Object) cVar);
            } else {
                this.f177957e = bundle;
                this.f177956d = new WeakReference<>(cVar);
            }
        }

        @Override // eipc.EIPCResultCallback
        public void onCallback(EIPCResult eIPCResult) {
            Bundle j3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) eIPCResult);
                return;
            }
            c cVar = this.f177956d.get();
            if (cVar == null) {
                return;
            }
            if (eIPCResult != null && eIPCResult.code == 0) {
                j3 = eIPCResult.data;
            } else {
                j3 = ae.j(-100, QWalletMixJsPlugin.ERROR_MSG_UNKNOWN_ERROR);
            }
            cVar.onResult(j3, this.f177957e);
        }
    }

    public static Bundle d(int i3) {
        Bundle bundle = new Bundle();
        bundle.putInt(QWalletMixJsPlugin.PARAMS_CALLBACK_ID, i3);
        return bundle;
    }

    public static int e(Bundle bundle) {
        if (bundle == null) {
            return -1;
        }
        return bundle.getInt(QWalletMixJsPlugin.PARAMS_CALLBACK_ID, -1);
    }

    public static Bundle f(String str, String str2, String str3) {
        Bundle bundle = new Bundle();
        bundle.putString("busiid", str3);
        bundle.putString("msgid", str);
        bundle.putString("domain", str2);
        return bundle;
    }

    public static Bundle g(String str, String str2, String str3, String str4) {
        Bundle bundle = new Bundle();
        bundle.putString("busiid", str3);
        bundle.putString("msgid", str);
        bundle.putString("domain", str2);
        bundle.putString(QWalletMixJsPlugin.PARAMS_IS_SET_CALENDAR, str4);
        return bundle;
    }

    public static Bundle h(int i3, String str, int i16) {
        Bundle bundle = new Bundle();
        bundle.putInt("retcode", i3);
        bundle.putString("retmsg", str);
        if (i16 != -1) {
            bundle.putInt(QWalletMixJsPlugin.PARAMS_HAS_SUBSCRIBE, i16);
        }
        return bundle;
    }

    public static String i(Bundle bundle) {
        int i3 = bundle.getInt("retcode", -1);
        String string = bundle.getString("retmsg", "");
        int i16 = bundle.getInt(QWalletMixJsPlugin.PARAMS_HAS_SUBSCRIBE, -1);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("retcode", i3);
            jSONObject.put("retmsg", string);
            if (i3 == 0) {
                jSONObject.put(QWalletMixJsPlugin.PARAMS_HAS_SUBSCRIBE, i16);
            }
            return jSONObject.toString();
        } catch (JSONException e16) {
            e16.printStackTrace();
            return "";
        }
    }

    public static Bundle j(int i3, String str) {
        Bundle bundle = new Bundle();
        bundle.putInt("retcode", i3);
        bundle.putString("retmsg", str);
        return bundle;
    }

    public static void k(@NonNull String str, String str2, String str3, @NonNull b bVar) {
        if (TextUtils.isEmpty(str)) {
            bVar.queryHasSetNotify(j(4, QWalletMixJsPlugin.ERROR_MSG_PARAM_ERROR), null);
            if (QLog.isColorLevel()) {
                QLog.d("QQNotifyUtils", 1, "hasBusinessSetNotify msgId is empty");
                return;
            }
            return;
        }
        if (MobileQQ.sProcessId == 1) {
            IQQReminderService iQQReminderService = (IQQReminderService) BaseApplicationImpl.getApplication().getRuntime().getRuntimeService(IQQReminderService.class, "");
            if (iQQReminderService != null) {
                iQQReminderService.queryNotifyIsSubscribed(str, new aa.b(bVar, null));
                return;
            }
            return;
        }
        QIPCClientHelper.getInstance().callServer("QQNotifyIPCModule", "query", f(str, str2, str3), new aa.b(bVar, null));
    }

    private static boolean l(String str) {
        if (!StringUtil.isEmpty(str) && ((IMiniAppService) QRoute.api(IMiniAppService.class)).isMiniAppUrl(str)) {
            return true;
        }
        return false;
    }

    public static void m(Activity activity, CalendarEntity calendarEntity) {
        String str = calendarEntity.jump_url;
        if (str == null) {
            QLog.e("QQNotifyUtils", 1, "jumpUrl is null");
        }
        if (l(str)) {
            ((IMiniAppService) QRoute.api(IMiniAppService.class)).startMiniApp(activity, str, 2102, null);
            return;
        }
        if (StringUtil.isEmpty(str)) {
            str = "https://act.qzone.qq.com/vip/meteor/blockly/p/4403xdf3cc";
        }
        Uri parse = Uri.parse(str);
        if (parse != null) {
            String scheme = parse.getScheme();
            if (!StringUtil.isEmpty(scheme)) {
                if (scheme.startsWith("http") || scheme.startsWith("https")) {
                    db.a(activity, str, true, true);
                }
                if (scheme.startsWith(SchemaUtils.SCHEMA_MQQAPI)) {
                    db.b(activity, str);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void n(c cVar, int i3, String str, Bundle bundle) {
        if (cVar != null) {
            cVar.onResult(j(i3, str), bundle);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void o(Bundle bundle, c cVar, int i3, boolean z16, Bundle bundle2) {
        if (i3 == 2002) {
            if (z16) {
                AcsSubNoticeRsp acsSubNoticeRsp = (AcsSubNoticeRsp) bundle2.getSerializable("rsp");
                if (acsSubNoticeRsp == null) {
                    q(bundle, 3, "system error", cVar);
                    return;
                }
                int i16 = acsSubNoticeRsp.ret_code;
                String str = acsSubNoticeRsp.err_str;
                QLog.i("QQNotifyUtils", 1, "subscribeNotifyInner retCode: " + i16 + " msg: " + str);
                if (i16 != 0) {
                    q(bundle, i16, str, cVar);
                    return;
                } else {
                    q(bundle, i16, "", cVar);
                    return;
                }
            }
            q(bundle, 3, "system error", cVar);
        }
    }

    public static void p(Activity activity, String str, String str2, String str3, int i3) {
        if (TextUtils.isEmpty(str)) {
            if (QLog.isColorLevel()) {
                QLog.d("QQNotifyUtils", 1, "newSubscribeNotify msgId is empty");
                return;
            }
            return;
        }
        QQRecurrentNotifySettingFragment.Jh(activity, str, str3, str2, i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void q(final Bundle bundle, final int i3, @Nullable final String str, @Nullable final c cVar) {
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.activity.activateFriend.ac
            @Override // java.lang.Runnable
            public final void run() {
                ae.n(ae.c.this, i3, str, bundle);
            }
        });
    }

    public static void r(AppInterface appInterface, AppActivity appActivity, String str, String str2, String str3, String str4, @Nullable c cVar) {
        Bundle g16 = g(str, str2, str3, str4);
        if (appInterface != null && appActivity != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3) && !TextUtils.isEmpty(str4)) {
            IQQReminderCalendarService iQQReminderCalendarService = (IQQReminderCalendarService) appInterface.getRuntimeService(IQQReminderCalendarService.class, "");
            if (iQQReminderCalendarService == null) {
                q(g16, 3, "system error", cVar);
                return;
            } else {
                iQQReminderCalendarService.subCalendarNotify(appActivity, str3, str, str2, "1".equals(str4), new a(g16, cVar));
                return;
            }
        }
        q(g16, 3, "system error", cVar);
    }

    public static void s(String str, String str2, String str3, @Nullable c cVar) {
        QLog.i("QQNotifyUtils", 1, "subscribeNotifyDirectly");
        if (TextUtils.isEmpty(str)) {
            QLog.e("QQNotifyUtils", 1, "subscribeNotifyDirectly msgId is empty");
        } else if (MobileQQ.sProcessId == 1) {
            t(str, str2, str3, cVar);
        } else {
            Bundle f16 = f(str, str2, str3);
            QIPCClientHelper.getInstance().callServer("QQNotifyIPCModule", "subscribe_directly", f16, new d(f16, cVar));
        }
    }

    private static void t(String str, String str2, String str3, @Nullable final c cVar) {
        IQQReminderService iQQReminderService = (IQQReminderService) BaseApplicationImpl.getApplication().getRuntime().getRuntimeService(IQQReminderService.class, "");
        if (iQQReminderService == null) {
            return;
        }
        final Bundle f16 = f(str, str2, str3);
        iQQReminderService.sendSubscribeReminder(str, str2, new BusinessObserver() { // from class: com.tencent.mobileqq.activity.activateFriend.ad
            @Override // mqq.observer.BusinessObserver
            public final void onReceive(int i3, boolean z16, Bundle bundle) {
                ae.o(f16, cVar, i3, z16, bundle);
            }
        });
    }
}
