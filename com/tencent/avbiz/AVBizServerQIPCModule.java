package com.tencent.avbiz;

import android.os.Bundle;
import com.tencent.avbiz.Constants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.qipc.QIPCServerHelper;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCConnection;
import eipc.EIPCOnGetConnectionListener;
import eipc.EIPCResult;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* loaded from: classes3.dex */
public class AVBizServerQIPCModule extends QIPCModule {
    static IPatchRedirector $redirector_ = null;
    public static final String NAME = "AVBizServerQIPCModule";
    private static final String TAG = "AVBizServerQIPCModule";
    private static volatile AVBizServerQIPCModule sInstance;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class a implements EIPCOnGetConnectionListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AVBizServerQIPCModule.this);
            }
        }

        @Override // eipc.EIPCOnGetConnectionListener
        public void onConnectBind(EIPCConnection eIPCConnection) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) eIPCConnection);
                return;
            }
            if (eIPCConnection != null && QLog.isColorLevel()) {
                QLog.i("AVBizServerQIPCModule", 2, "onConnectBind, [" + eIPCConnection.procName + "]");
            }
        }

        @Override // eipc.EIPCOnGetConnectionListener
        public void onConnectUnbind(EIPCConnection eIPCConnection) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) eIPCConnection);
                return;
            }
            if (eIPCConnection == null) {
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.i("AVBizServerQIPCModule", 2, "onConnectUnbind, [" + eIPCConnection.procName + "]");
            }
            Set<String> set = Constants.PROCESS_BIZ_NAME_MAP.get(eIPCConnection.procName);
            if (set != null) {
                Iterator<String> it = set.iterator();
                while (it.hasNext()) {
                    AVBizPriorityManager.getInstance().abandonAVFocus(it.next());
                }
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(37917);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            sInstance = null;
        }
    }

    AVBizServerQIPCModule(String str) {
        super(str);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str);
        } else {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.avbiz.AVBizServerQIPCModule.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AVBizServerQIPCModule.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                        AVBizServerQIPCModule.this.initBinderListener();
                    } else {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                }
            }, 16, null, true);
        }
    }

    public static AVBizServerQIPCModule getInstance() {
        if (sInstance == null) {
            synchronized (AVBizServerQIPCModule.class) {
                if (sInstance == null) {
                    sInstance = new AVBizServerQIPCModule("AVBizServerQIPCModule");
                }
            }
        }
        return sInstance;
    }

    private void handleAbandonAVFocus(Bundle bundle) {
        AVBizPriorityManager.getInstance().abandonAVFocus(bundle.getString("module_name"));
    }

    private Bundle handleCheckAVFocus(Bundle bundle) {
        String checkAVFocus = AVBizPriorityManager.getInstance().checkAVFocus(bundle.getString("module_name"));
        Bundle bundle2 = new Bundle();
        bundle2.putString(Constants.Key.CHECK_FOCUS_RESULT, checkAVFocus);
        return bundle2;
    }

    private Bundle handleGetFocusBusiness() {
        HashMap<Long, String> focusBusiness = AVBizPriorityManager.getInstance().getFocusBusiness();
        Bundle bundle = new Bundle();
        bundle.putSerializable(Constants.Key.GET_FOCUS_BIZ_RESULT, focusBusiness);
        return bundle;
    }

    private Bundle handleGetInQueueBusiness() {
        HashSet<String> inQueueBusiness = AVBizPriorityManager.getInstance().getInQueueBusiness();
        Bundle bundle = new Bundle();
        bundle.putSerializable(Constants.Key.GET_IN_QUEUE_BIZ_RESULT, inQueueBusiness);
        return bundle;
    }

    private Bundle handleRequestAVFocus(Bundle bundle) {
        String requestAVFocus = AVBizPriorityManager.getInstance().requestAVFocus(bundle.getString("module_name"), bundle.getString("process_name"));
        Bundle bundle2 = new Bundle();
        bundle2.putString(Constants.Key.REQUEST_FOCUS_RESULT, requestAVFocus);
        return bundle2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initBinderListener() {
        QLog.i("AVBizServerQIPCModule", 2, "initBinderListener");
        QIPCServerHelper.getInstance().getServer().addListener(new a());
    }

    @Override // eipc.EIPCModule
    public EIPCResult onCall(String str, Bundle bundle, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (EIPCResult) iPatchRedirector.redirect((short) 3, this, str, bundle, Integer.valueOf(i3));
        }
        if (QLog.isColorLevel()) {
            QLog.i("AVBizServerQIPCModule", 4, "onCall, action[" + str + "]");
        }
        if (Constants.Action.REQUEST_AV_FOCUS.equals(str)) {
            return EIPCResult.createSuccessResult(handleRequestAVFocus(bundle));
        }
        if (Constants.Action.CHECK_AV_FOCUS.equals(str)) {
            return EIPCResult.createSuccessResult(handleCheckAVFocus(bundle));
        }
        if (Constants.Action.ABANDON_AV_FOCUS.equals(str)) {
            handleAbandonAVFocus(bundle);
        } else {
            if (Constants.Action.GET_FOCUS_BUSINESS.equals(str)) {
                return EIPCResult.createSuccessResult(handleGetFocusBusiness());
            }
            if (Constants.Action.GET_IN_QUEUE_BUSINESS.equals(str)) {
                return EIPCResult.createSuccessResult(handleGetInQueueBusiness());
            }
        }
        return EIPCResult.UNKNOW_RESULT;
    }

    public void onSystemPhoneStatusChange(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, z16);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("AVBizServerQIPCModule", 2, "onPhoneStatusChange, isCalling[" + z16 + "]");
        }
        if (z16) {
            AVBizPriorityManager.getInstance().requestAVFocus(Constants.Business.SYSTEM_PHONE, "");
        } else {
            AVBizPriorityManager.getInstance().abandonAVFocus(Constants.Business.SYSTEM_PHONE);
        }
    }
}
