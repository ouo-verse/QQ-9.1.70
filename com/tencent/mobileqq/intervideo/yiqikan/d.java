package com.tencent.mobileqq.intervideo.yiqikan;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.intervideo.yiqikan.TogetherBusinessServlet;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import mqq.observer.BusinessObserver;
import mqq.util.WeakReference;

/* compiled from: P */
/* loaded from: classes15.dex */
public class d extends QIPCModule {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private static volatile d f238477d;

    /* compiled from: P */
    /* loaded from: classes15.dex */
    public static class a implements BusinessObserver {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        private WeakReference<QIPCModule> f238478d;

        /* renamed from: e, reason: collision with root package name */
        private int f238479e;

        public a(QIPCModule qIPCModule, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) qIPCModule, i3);
            } else {
                this.f238478d = new WeakReference<>(qIPCModule);
                this.f238479e = i3;
            }
        }

        private void a(Bundle bundle, TogetherBusinessServlet.RspOpenStart rspOpenStart) {
            String str;
            if (BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface) {
                if (QLog.isColorLevel()) {
                    QLog.d("TogetherObserver", 2, "handleStartPackage TogetherControlManager");
                }
                int i3 = bundle.getInt("session_type", -1);
                long j3 = bundle.getLong("uin", -1L);
                int i16 = bundle.getInt("business_type", 0);
                String string = bundle.getString("appid", "");
                QQAppInterface qQAppInterface = (QQAppInterface) BaseApplicationImpl.getApplication().getRuntime();
                if (i16 == 2) {
                    if (i3 == 2) {
                        str = "c2c_AIO";
                    } else {
                        str = "Grp_AIO";
                    }
                    ReportController.o(qQAppInterface, "dc00899", str, "", "video_tab", "clk_share_suc", 0, 0, j3 + "", string, "", "");
                }
                tr2.g.j(qQAppInterface, rspOpenStart.jumpType, rspOpenStart.jumpUrl, null, new Bundle(), i3);
            }
        }

        private boolean b(TogetherBusinessServlet.RspOpenStart rspOpenStart) {
            TogetherBusinessServlet.ResultInfo resultInfo = rspOpenStart.resultInfo;
            if (resultInfo != null && resultInfo.showErrorMsg && !TextUtils.isEmpty(resultInfo.errorMsg)) {
                return false;
            }
            int i3 = rspOpenStart.jumpType;
            if ((i3 != 1 && i3 != 2) || TextUtils.isEmpty(rspOpenStart.jumpUrl)) {
                return false;
            }
            return true;
        }

        @Override // mqq.observer.BusinessObserver
        public void onReceive(int i3, boolean z16, Bundle bundle) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Boolean.valueOf(z16), bundle);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("TogetherObserver", 2, "type:" + i3 + " isSuccess:" + z16);
            }
            if (this.f238478d.get() == null) {
                if (QLog.isColorLevel()) {
                    QLog.d("TogetherObserver", 2, " mRef is empty");
                    return;
                }
                return;
            }
            QIPCModule qIPCModule = this.f238478d.get();
            if (12 == i3 && z16) {
                qIPCModule.callbackResult(this.f238479e, EIPCResult.createResult(0, bundle));
                return;
            }
            if (13 == i3 && z16) {
                qIPCModule.callbackResult(this.f238479e, EIPCResult.createResult(0, bundle));
                TogetherBusinessServlet.RspOpenStart rspOpenStart = (TogetherBusinessServlet.RspOpenStart) bundle.getSerializable("QQAIOMediaSvc.open_start");
                Bundle bundle2 = bundle.getBundle("bundle");
                if (bundle2 != null && rspOpenStart != null) {
                    if (b(rspOpenStart)) {
                        if (QLog.isColorLevel()) {
                            QLog.d("TogetherObserver", 2, "handleStartPackage jumpToTogetherBusiness");
                        }
                        a(bundle2, rspOpenStart);
                        return;
                    }
                    return;
                }
                if (QLog.isColorLevel()) {
                    QLog.d("TogetherObserver", 2, "bundleExtra is null or rspOpenStart is null");
                }
            }
        }
    }

    public d(String str) {
        super(str);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str);
        }
    }

    public static d b() {
        if (f238477d == null) {
            synchronized (d.class) {
                if (f238477d == null) {
                    f238477d = new d("TogetherBusinessIPCModule");
                }
            }
        }
        return f238477d;
    }

    @Override // eipc.EIPCModule
    public EIPCResult onCall(String str, Bundle bundle, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (EIPCResult) iPatchRedirector.redirect((short) 2, this, str, bundle, Integer.valueOf(i3));
        }
        if (QLog.isColorLevel()) {
            QLog.d("TogetherBusinessIPCModule", 2, "call TogetherBusinessIPCModule action=" + str);
        }
        if ("action_open_identify".equals(str)) {
            TogetherBusinessServlet.e("QQAIOMediaSvc.open_identify", (QQAppInterface) BaseApplicationImpl.getApplication().getRuntime(), bundle, new a(this, i3));
        } else if ("action_open_start".equals(str)) {
            TogetherBusinessServlet.e("QQAIOMediaSvc.open_start", (QQAppInterface) BaseApplicationImpl.getApplication().getRuntime(), bundle, new a(this, i3));
        } else if ("action_set_floating".equals(str)) {
            boolean z16 = bundle.getBoolean("BUNDLE_SET_STATUS");
            String string = bundle.getString("BUNDLE_SET_KEY_UIN", "");
            int i16 = bundle.getInt("BUNDLE_SET_KEY_SESSION_TYPE", -1);
            boolean z17 = bundle.getBoolean("BUNDLE_SET_KEY_REFRESH_UI", true);
            f.k(z16, string, i16, z17);
            if (QLog.isColorLevel()) {
                QLog.d("TogetherBusinessIPCModule", 2, "ACTION_SET_FLOATING  isShow=" + z16 + " uin=" + string + " sessionType=" + i16 + " refresh=" + z17);
            }
            if (!z17) {
                return null;
            }
            tr2.b bVar = (tr2.b) ((QQAppInterface) BaseApplicationImpl.getApplication().getRuntime()).getManager(QQManagerFactory.TOGETHER_CONTROLLER_MANAGER);
            WatchTogetherSession watchTogetherSession = (WatchTogetherSession) bVar.s(2, i16, string);
            if (watchTogetherSession != null) {
                bVar.k(true, watchTogetherSession, 1002, "");
            }
        }
        return null;
    }
}
