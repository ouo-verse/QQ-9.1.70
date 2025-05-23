package com.tencent.mobileqq.pushnotice.proxy;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pushnotice.ThirdPushManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import com.vivo.push.IPushActionListener;
import com.vivo.push.PushClient;
import com.vivo.push.PushConfig;
import com.vivo.push.listener.IPushQueryActionListener;
import com.vivo.push.model.UnvarnishedMessage;
import com.vivo.push.restructure.request.IPushRequestCallback;
import com.vivo.push.sdk.OpenClientPushMessageReceiver;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;

/* loaded from: classes16.dex */
public class VivoPushProcessor extends ThirdPushProcessorImpl {
    static IPatchRedirector $redirector_;

    /* renamed from: f, reason: collision with root package name */
    private Context f261392f;

    /* loaded from: classes16.dex */
    public static class VivoPushMsgReceiverImpl extends OpenClientPushMessageReceiver {
        static IPatchRedirector $redirector_;

        public VivoPushMsgReceiverImpl() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.vivo.push.sdk.OpenClientPushMessageReceiver, com.vivo.push.sdk.PushMessageCallback
        public void onReceiveRegId(Context context, String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) str);
                return;
            }
            QLog.d("VPUSH", 2, "onReceiveRegId : " + str);
            if (!TextUtils.isEmpty(str) && !((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("offline_vivo_surpport_profileid_8975", true)) {
                ThirdPushManager.getInstance().setToken(str);
            }
        }

        @Override // com.vivo.push.sdk.OpenClientPushMessageReceiver, com.vivo.push.sdk.BasePushMessageReceiver, com.vivo.push.sdk.PushMessageCallback
        public void onTransmissionMessage(Context context, UnvarnishedMessage unvarnishedMessage) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) context, (Object) unvarnishedMessage);
                return;
            }
            super.onTransmissionMessage(context, unvarnishedMessage);
            if (QLog.isColorLevel()) {
                QLog.d("VPUSH", 2, " onTransmissionMessage= " + unvarnishedMessage.getMessage());
            }
        }
    }

    public VivoPushProcessor() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f261392f = BaseApplication.getContext();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s(String str) {
        PushClient.getInstance(this.f261392f).addProfileId(str, new IPushRequestCallback<Integer>(str) { // from class: com.tencent.mobileqq.pushnotice.proxy.VivoPushProcessor.3
            static IPatchRedirector $redirector_;
            final /* synthetic */ String val$profileID;

            {
                this.val$profileID = str;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) VivoPushProcessor.this, (Object) str);
                }
            }

            @Override // com.vivo.push.restructure.request.IPushRequestCallback
            public void onError(int i3) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                    iPatchRedirector.redirect((short) 3, (Object) this, i3);
                } else {
                    QLog.d("VPUSH", 1, "addProfileId onError");
                    VivoPushProcessor.this.w();
                }
            }

            @Override // com.vivo.push.restructure.request.IPushRequestCallback
            public void onSuccess(Integer num) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) num);
                    return;
                }
                QLog.d("VPUSH", 1, "addProfileId Success " + this.val$profileID);
                VivoPushProcessor vivoPushProcessor = VivoPushProcessor.this;
                vivoPushProcessor.f261390b = this.val$profileID;
                vivoPushProcessor.w();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void u(int i3) {
        if (i3 == 0) {
            if (((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("offline_vivo_surpport_profileid_8975", true)) {
                if (PushClient.getInstance(this.f261392f).isSupportSyncProfileInfo() == 0) {
                    t();
                } else {
                    w();
                }
            } else {
                w();
            }
        }
        QLog.d("VPUSH", 1, "turnOnPush onStateChanged state:" + i3);
    }

    private void v() {
        try {
            if (!l()) {
                return;
            }
            PushClient.getInstance(this.f261392f).initialize(new PushConfig.Builder().agreePrivacyStatement(true).build());
            PushClient.getInstance(this.f261392f).turnOnPush(new IPushActionListener() { // from class: com.tencent.mobileqq.pushnotice.proxy.f
                @Override // com.vivo.push.IPushActionListener
                public final void onStateChanged(int i3) {
                    VivoPushProcessor.this.u(i3);
                }
            });
        } catch (Exception e16) {
            QLog.e("VPUSH", 1, "registerPush error! ", e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w() {
        PushClient.getInstance(this.f261392f).getRegId(new IPushQueryActionListener() { // from class: com.tencent.mobileqq.pushnotice.proxy.VivoPushProcessor.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) VivoPushProcessor.this);
                }
            }

            @Override // com.vivo.push.listener.IPushQueryActionListener, com.vivo.push.listener.IPushRequestListener
            public void onFail(Integer num) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                    QLog.d("VPUSH", 1, "sendPushToken getRegId onFail");
                } else {
                    iPatchRedirector.redirect((short) 3, (Object) this, (Object) num);
                }
            }

            @Override // com.vivo.push.listener.IPushQueryActionListener, com.vivo.push.listener.IPushRequestListener
            public void onSuccess(String str) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
                    return;
                }
                QLog.d("VPUSH", 1, "sendPushToken getRegId onSuccess token:" + str);
                VivoPushProcessor.this.a(str);
            }
        });
    }

    @Override // com.tencent.mobileqq.pushnotice.proxy.ThirdPushProcessorImpl, com.tencent.mobileqq.pushnotice.proxy.c
    public int c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        return 5;
    }

    @Override // com.tencent.mobileqq.pushnotice.proxy.ThirdPushProcessorImpl, com.tencent.mobileqq.pushnotice.proxy.c
    public void d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            v();
        }
    }

    @Override // com.tencent.mobileqq.pushnotice.proxy.ThirdPushProcessorImpl
    public boolean l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        boolean z16 = false;
        try {
            z16 = PushClient.getInstance(this.f261392f).isSupport();
            QLog.i("VPUSH", 1, "isSupport=" + z16);
            return z16;
        } catch (Exception e16) {
            QLog.e("VPUSH", 1, "isSupport error! ", e16);
            return z16;
        }
    }

    public void t() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
        if (runtime != null && (runtime instanceof QQAppInterface)) {
            String md5 = MD5.toMD5(runtime.getCurrentUin());
            if (!TextUtils.isEmpty(md5)) {
                if (md5.length() > 64) {
                    md5 = md5.substring(0, 64);
                }
                PushClient.getInstance(null).queryProfileIds(new IPushRequestCallback<List<String>>(md5) { // from class: com.tencent.mobileqq.pushnotice.proxy.VivoPushProcessor.2
                    static IPatchRedirector $redirector_;
                    final /* synthetic */ String val$tmpProfileID;

                    {
                        this.val$tmpProfileID = md5;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) VivoPushProcessor.this, (Object) md5);
                        }
                    }

                    @Override // com.vivo.push.restructure.request.IPushRequestCallback
                    public void onError(int i3) {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 3)) {
                            VivoPushProcessor.this.s(this.val$tmpProfileID);
                        } else {
                            iPatchRedirector2.redirect((short) 3, (Object) this, i3);
                        }
                    }

                    @Override // com.vivo.push.restructure.request.IPushRequestCallback
                    public void onSuccess(List<String> list) {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this, (Object) list);
                            return;
                        }
                        if (list != null && list.size() > 0) {
                            Iterator<String> it = list.iterator();
                            while (it.hasNext()) {
                                if (TextUtils.equals(this.val$tmpProfileID, it.next())) {
                                    QLog.d("VPUSH", 1, "queryProfileIds has profileID " + this.val$tmpProfileID);
                                    VivoPushProcessor vivoPushProcessor = VivoPushProcessor.this;
                                    vivoPushProcessor.f261390b = this.val$tmpProfileID;
                                    vivoPushProcessor.w();
                                    return;
                                }
                            }
                        }
                        VivoPushProcessor.this.s(this.val$tmpProfileID);
                    }
                });
                return;
            }
            return;
        }
        QLog.d("VPUSH", 1, "bindProfileID appRuntime invalid");
    }
}
