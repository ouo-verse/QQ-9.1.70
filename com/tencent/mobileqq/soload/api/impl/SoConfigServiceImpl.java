package com.tencent.mobileqq.soload.api.impl;

import android.os.Bundle;
import com.tencent.mobileqq.config.am;
import com.tencent.mobileqq.perf.block.BinderMethodProxy;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.soload.api.ISoConfigService;
import com.tencent.mobileqq.soload.biz.OnGetSoLoadInfoListener;
import com.tencent.mobileqq.soload.biz.SoLoadIPCModule;
import com.tencent.mobileqq.soload.biz.entity.SoInfo;
import com.tencent.mobileqq.soload.biz.entity.SoLoadInfo;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes18.dex */
public class SoConfigServiceImpl implements ISoConfigService {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "SoLoadWidget.SoConfigServiceImpl";

    /* compiled from: P */
    /* loaded from: classes18.dex */
    class a implements EIPCResultCallback {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ OnGetSoLoadInfoListener f288525d;

        a(OnGetSoLoadInfoListener onGetSoLoadInfoListener) {
            this.f288525d = onGetSoLoadInfoListener;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SoConfigServiceImpl.this, (Object) onGetSoLoadInfoListener);
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:28:0x0040  */
        /* JADX WARN: Removed duplicated region for block: B:30:? A[RETURN, SYNTHETIC] */
        @Override // eipc.EIPCResultCallback
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onCallback(EIPCResult eIPCResult) {
            OnGetSoLoadInfoListener onGetSoLoadInfoListener;
            Bundle bundle;
            Throwable th5;
            SoLoadInfo soLoadInfo;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) eIPCResult);
                return;
            }
            SoLoadInfo soLoadInfo2 = SoLoadInfo.sDefault;
            if (eIPCResult != null && eIPCResult.isSuccess() && (bundle = eIPCResult.data) != null) {
                try {
                    soLoadInfo = (SoLoadInfo) bundle.getSerializable("res");
                    if (soLoadInfo == null) {
                        try {
                            soLoadInfo = SoLoadInfo.sDefault;
                        } catch (Throwable th6) {
                            th5 = th6;
                            QLog.e("SoLoadWidget.IPC", 1, th5, new Object[0]);
                            soLoadInfo2 = soLoadInfo;
                            onGetSoLoadInfoListener = this.f288525d;
                            if (onGetSoLoadInfoListener == null) {
                            }
                        }
                    }
                } catch (Throwable th7) {
                    th5 = th7;
                    soLoadInfo = soLoadInfo2;
                }
                soLoadInfo2 = soLoadInfo;
            }
            onGetSoLoadInfoListener = this.f288525d;
            if (onGetSoLoadInfoListener == null) {
                onGetSoLoadInfoListener.onGetLoadInfo(soLoadInfo2);
            }
        }
    }

    public SoConfigServiceImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.soload.api.ISoConfigService
    public int getConfigId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        return 526;
    }

    @Override // com.tencent.mobileqq.soload.api.ISoConfigService
    public Map<String, SoInfo> getSoInfos() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Map) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return com.tencent.mobileqq.soload.config.a.b().f();
    }

    @Override // com.tencent.mobileqq.soload.api.ISoConfigService
    public void getSoLoadInfoAsync(Bundle bundle, OnGetSoLoadInfoListener onGetSoLoadInfoListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) bundle, (Object) onGetSoLoadInfoListener);
        } else {
            QIPCClientHelper.getInstance().callServer(SoLoadIPCModule.NAME, SoLoadIPCModule.ACTION_COM_IPC_UTILS, bundle, new a(onGetSoLoadInfoListener));
        }
    }

    @Override // com.tencent.mobileqq.soload.api.ISoConfigService
    public EIPCResult getSoLoadInfoSync(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (EIPCResult) iPatchRedirector.redirect((short) 6, (Object) this, (Object) bundle);
        }
        return BinderMethodProxy.callServer(QIPCClientHelper.getInstance().getClient(), SoLoadIPCModule.NAME, SoLoadIPCModule.ACTION_COM_IPC_UTILS, bundle);
    }

    @Override // com.tencent.mobileqq.soload.api.ISoConfigService
    public void notifyNetFailed(int[] iArr, FromServiceMsg fromServiceMsg) {
        boolean z16;
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) iArr, (Object) fromServiceMsg);
            return;
        }
        for (int i16 : iArr) {
            if (i16 == 526) {
                int i17 = -1;
                if (QLog.isColorLevel()) {
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("[notifyNetFailed] isSucc=");
                    if (fromServiceMsg != null && fromServiceMsg.isSuccess()) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    sb5.append(z16);
                    sb5.append(", resultCode=");
                    if (fromServiceMsg != null) {
                        i3 = fromServiceMsg.getResultCode();
                    } else {
                        i3 = -1;
                    }
                    sb5.append(i3);
                    QLog.d(TAG, 2, sb5.toString());
                }
                com.tencent.mobileqq.config.l e16 = am.s().e(526);
                if (e16 != null) {
                    if (fromServiceMsg == null || fromServiceMsg.getResultCode() != 1002) {
                        i17 = -2;
                    }
                    e16.onReqFailed(i17);
                }
            }
        }
    }

    @Override // com.tencent.mobileqq.soload.api.ISoConfigService
    public void removeSoInfo(String str) {
        Map<String, SoInfo> soInfos;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
        } else if (!StringUtil.isEmpty(str) && (soInfos = getSoInfos()) != null) {
            soInfos.remove(str);
        }
    }
}
