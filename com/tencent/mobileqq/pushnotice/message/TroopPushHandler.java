package com.tencent.mobileqq.pushnotice.message;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.AppOpenConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqfeatureswitch.IFeatureRuntimeService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ac;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.api.IKernelService;
import com.tencent.qqnt.troop.ITroopInfoRepoApi;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* loaded from: classes16.dex */
public class TroopPushHandler extends a {
    static IPatchRedirector $redirector_;

    public TroopPushHandler() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Intent h(String str, String str2, long j3) {
        Intent d16 = d();
        d16.putExtra("uin", str);
        d16.putExtra("uintype", 1);
        d16.putExtra("uinname", str2);
        if (j3 > 0) {
            d16.putExtra(AppOpenConstants.Key.THIRD_PUSH_MSG_SEQ, j3);
        }
        if (QLog.isDevelopLevel()) {
            QLog.d("TroopPushHandler", 4, "getIntent fromUin=" + str + ", nickName=" + str2 + ", msgSeq=" + j3);
        }
        return d16;
    }

    private static long i(Intent intent) {
        String stringExtra = intent.getStringExtra(AppConstants.Key.COLUMN_MSG_SEQ);
        if (TextUtils.isEmpty(stringExtra)) {
            return 0L;
        }
        try {
            return Long.parseLong(stringExtra);
        } catch (NumberFormatException e16) {
            QLog.w("TroopPushHandler", 1, "[getMsgSeqFromIntent] exc:" + e16);
            return 0L;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String j(AppRuntime appRuntime, String str) {
        if (appRuntime instanceof QQAppInterface) {
            String R = ac.R((QQAppInterface) appRuntime, str, 1);
            if (TextUtils.isEmpty(R) || R.equals(str)) {
                R = ((ITroopInfoRepoApi) QRoute.api(ITroopInfoRepoApi.class)).getTroopNameForPush(str);
                if (QLog.isColorLevel()) {
                    QLog.d("TroopPushHandler", 2, "getTroopNameForPush: nickName=" + R);
                }
            }
            return R;
        }
        return str;
    }

    private boolean k(Context context, Intent intent, AppRuntime appRuntime, String str, long j3) {
        if (!((IFeatureRuntimeService) appRuntime.getRuntimeService(IFeatureRuntimeService.class, "all")).isFeatureSwitchEnable("troop_push_get_name_async")) {
            return false;
        }
        ThreadManagerV2.excute(new Runnable(appRuntime, str, j3, context, intent) { // from class: com.tencent.mobileqq.pushnotice.message.TroopPushHandler.1
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ AppRuntime f261353d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ String f261354e;

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ long f261355f;

            /* renamed from: h, reason: collision with root package name */
            final /* synthetic */ Context f261356h;

            /* renamed from: i, reason: collision with root package name */
            final /* synthetic */ Intent f261357i;

            {
                this.f261353d = appRuntime;
                this.f261354e = str;
                this.f261355f = j3;
                this.f261356h = context;
                this.f261357i = intent;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, TroopPushHandler.this, appRuntime, str, Long.valueOf(j3), context, intent);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                    try {
                        TroopPushHandler.this.e(this.f261356h, TroopPushHandler.this.h(this.f261354e, TroopPushHandler.this.j(this.f261353d, this.f261354e), this.f261355f));
                        TroopPushHandler.this.c(this.f261357i, this.f261353d);
                        return;
                    } catch (Exception e16) {
                        QLog.i("TroopPushHandler", 1, "jumpAioAsync", e16);
                        return;
                    }
                }
                iPatchRedirector.redirect((short) 2, (Object) this);
            }
        }, 32, null, true);
        QLog.i("TroopPushHandler", 1, "jumpAioAsync");
        return true;
    }

    private void l(String str) {
        AppRuntime peekAppRuntime;
        if (TextUtils.isEmpty(str) || (peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime()) == null) {
            return;
        }
        try {
            ((IKernelService) peekAppRuntime.getRuntimeService(IKernelService.class, "")).setHighPriorityGroupUin(Long.parseLong(str));
        } catch (NumberFormatException e16) {
            QLog.w("TroopPushHandler", 1, "saveGroupUin", e16);
        }
    }

    @Override // com.tencent.mobileqq.pushnotice.message.h
    public boolean a(Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) intent)).booleanValue();
        }
        return "57619".equals(intent.getStringExtra("jumptype"));
    }

    @Override // com.tencent.mobileqq.pushnotice.message.h
    public boolean b(Context context, Intent intent, AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, this, context, intent, appRuntime)).booleanValue();
        }
        String stringExtra = intent.getStringExtra("groupcode");
        if (TextUtils.isEmpty(stringExtra)) {
            QLog.e("TroopPushHandler", 1, "fromUin is null");
            return true;
        }
        l(stringExtra);
        long i3 = i(intent);
        if (k(context, intent, appRuntime, stringExtra, i3)) {
            return false;
        }
        e(context, h(stringExtra, j(appRuntime, stringExtra), i3));
        c(intent, appRuntime);
        return false;
    }
}
