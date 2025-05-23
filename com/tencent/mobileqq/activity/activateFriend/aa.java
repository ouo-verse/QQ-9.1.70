package com.tencent.mobileqq.activity.activateFriend;

import Wallet.AcsQueryRsp;
import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.activateFriend.ae;
import com.tencent.mobileqq.activity.activateFriend.biz.c;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.reminder.api.IQQActivateFriendService;
import com.tencent.mobileqq.reminder.api.IQQReminderService;
import com.tencent.mobileqq.vaswebviewplugin.QWalletMixJsPlugin;
import com.tencent.qphone.base.util.QLog;
import com.tencent.thumbplayer.report.reportv1.TPReportKeys;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import java.io.Serializable;
import mqq.observer.BusinessObserver;
import mqq.util.WeakReference;

/* compiled from: P */
/* loaded from: classes9.dex */
public class aa extends QIPCModule implements ae.b {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private static volatile aa f177943d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class a implements c.a {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f177944d;

        a(int i3) {
            this.f177944d = i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) aa.this, i3);
            }
        }

        @Override // com.tencent.mobileqq.activity.activateFriend.biz.c.a
        public void onResult(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, z16);
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putBoolean("allowed", z16);
            aa.this.callbackResult(this.f177944d, EIPCResult.createResult(0, bundle));
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static class b implements BusinessObserver, EIPCResultCallback {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        private WeakReference<ae.b> f177946d;

        /* renamed from: e, reason: collision with root package name */
        private Bundle f177947e;

        public b(ae.b bVar, Bundle bundle) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) bVar, (Object) bundle);
            } else {
                this.f177946d = new WeakReference<>(bVar);
                this.f177947e = bundle;
            }
        }

        @Override // eipc.EIPCResultCallback
        public void onCallback(EIPCResult eIPCResult) {
            Bundle j3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) eIPCResult);
                return;
            }
            ae.b bVar = this.f177946d.get();
            if (bVar == null) {
                if (QLog.isColorLevel()) {
                    QLog.d("QQNotifyObserver", 2, " onCallback mRef is empty");
                }
            } else {
                if (eIPCResult != null && eIPCResult.code == 0) {
                    j3 = eIPCResult.data;
                } else {
                    j3 = ae.j(-100, QWalletMixJsPlugin.ERROR_MSG_UNKNOWN_ERROR);
                }
                bVar.queryHasSetNotify(j3, this.f177947e);
            }
        }

        @Override // mqq.observer.BusinessObserver
        public void onReceive(int i3, boolean z16, Bundle bundle) {
            String str;
            int i16;
            int i17;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Boolean.valueOf(z16), bundle);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("QQNotifyObserver", 2, "type:" + i3 + " isSuccess:" + z16);
            }
            ae.b bVar = this.f177946d.get();
            if (bVar == null) {
                if (QLog.isColorLevel()) {
                    QLog.d("QQNotifyObserver", 2, " mRef is empty");
                    return;
                }
                return;
            }
            Serializable serializable = bundle.getSerializable("rsp");
            if (serializable instanceof AcsQueryRsp) {
                AcsQueryRsp acsQueryRsp = (AcsQueryRsp) serializable;
                str = acsQueryRsp.err_str;
                i16 = acsQueryRsp.ret_code;
                i17 = acsQueryRsp.subscribed;
            } else {
                str = QWalletMixJsPlugin.ERROR_MSG_UNKNOWN_ERROR;
                i16 = -100;
                i17 = -1;
            }
            bVar.queryHasSetNotify(ae.h(i16, str, i17), this.f177947e);
        }
    }

    public aa(String str) {
        super(str);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str);
        }
    }

    private void c(int i3) {
        if (af.c()) {
            Bundle bundle = new Bundle();
            bundle.putBoolean("allowed", true);
            callbackResult(i3, EIPCResult.createResult(0, bundle));
            return;
        }
        af.e(new WeakReference(new a(i3)));
    }

    public static aa d() {
        if (f177943d == null) {
            synchronized (aa.class) {
                if (f177943d == null) {
                    f177943d = new aa("QQNotifyIPCModule");
                }
            }
        }
        return f177943d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e(int i3, Bundle bundle, Bundle bundle2) {
        callbackResult(i3, EIPCResult.createResult(0, bundle));
    }

    @Override // eipc.EIPCModule
    public EIPCResult onCall(String str, Bundle bundle, final int i3) {
        IQQActivateFriendService iQQActivateFriendService;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (EIPCResult) iPatchRedirector.redirect((short) 2, this, str, bundle, Integer.valueOf(i3));
        }
        if (!"newSubscribe".equals(str)) {
            if ("query".equals(str)) {
                IQQReminderService iQQReminderService = (IQQReminderService) BaseApplicationImpl.getApplication().getRuntime().getRuntimeService(IQQReminderService.class, "");
                if (iQQReminderService != null) {
                    iQQReminderService.queryNotifyIsSubscribed(bundle.getString("msgid"), new b(this, ae.d(i3)));
                }
            } else if (TPReportKeys.LiveExKeys.LIVE_EX_DEFINATION_SWICH.equals(str)) {
                c(i3);
            } else if ("add_msg".equals(str)) {
                af.g(bundle);
            } else if ("switch_query".equals(str)) {
                Bundle bundle2 = new Bundle();
                bundle2.putBoolean("allowed", af.c());
                callbackResult(i3, EIPCResult.createResult(0, bundle2));
            } else if ("subscribe_directly".equals(str)) {
                ae.s(bundle.getString("msgid"), bundle.getString("domain"), bundle.getString("busiid"), new ae.c() { // from class: com.tencent.mobileqq.activity.activateFriend.z
                    @Override // com.tencent.mobileqq.activity.activateFriend.ae.c
                    public final void onResult(Bundle bundle3, Bundle bundle4) {
                        aa.this.e(i3, bundle3, bundle4);
                    }
                });
            } else if (IQQActivateFriendService.METHOD_ACTION_QQNOTIFY_SET_SWITCH_VALUE.equals(str) && (iQQActivateFriendService = (IQQActivateFriendService) BaseApplicationImpl.getApplication().getRuntime().getRuntimeService(IQQActivateFriendService.class, "")) != null) {
                iQQActivateFriendService.setSwitchValueForQQNotify(bundle.getBoolean(IQQActivateFriendService.KEY_IS_OPEN), bundle.getBoolean(IQQActivateFriendService.KEY_IS_REMOTE));
                callbackResult(i3, EIPCResult.createResult(0, null));
            }
        }
        return EIPCResult.createResult(-100, null);
    }

    @Override // com.tencent.mobileqq.activity.activateFriend.ae.b
    public void queryHasSetNotify(Bundle bundle, Bundle bundle2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) bundle, (Object) bundle2);
        } else {
            callbackResult(ae.e(bundle2), EIPCResult.createResult(0, bundle));
        }
    }
}
