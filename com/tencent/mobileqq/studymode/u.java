package com.tencent.mobileqq.studymode;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.studymode.KidModeObserver;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes18.dex */
public class u extends QIPCModule {
    static IPatchRedirector $redirector_;

    /* renamed from: f, reason: collision with root package name */
    public static u f291034f;

    /* renamed from: d, reason: collision with root package name */
    private int f291035d;

    /* renamed from: e, reason: collision with root package name */
    private KidModeObserver f291036e;

    /* compiled from: P */
    /* loaded from: classes18.dex */
    class a extends KidModeObserver {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) u.this);
            }
        }

        @Override // com.tencent.mobileqq.studymode.KidModeObserver
        public void b(KidModeObserver.ClearPasswordResult clearPasswordResult) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) clearPasswordResult);
                return;
            }
            u.this.getAppRuntime().unRegistObserver(this);
            if (clearPasswordResult == null) {
                QLog.i("KidModeObserver", 1, "onClearPassword result == null");
                u uVar = u.this;
                uVar.f(uVar.f291035d, 1, "result == null");
                return;
            }
            QLog.i("KidModeObserver", 1, "onClearPassword errCode=" + clearPasswordResult.errCode + ",errMessage=" + clearPasswordResult.errMessage);
            if (clearPasswordResult.errCode != 0) {
                u uVar2 = u.this;
                uVar2.f(uVar2.f291035d, clearPasswordResult.errCode, clearPasswordResult.errMessage);
            } else {
                u uVar3 = u.this;
                uVar3.g(uVar3.f291035d, clearPasswordResult.errMessage);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(75717);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            f291034f = null;
        }
    }

    u(String str) {
        super(str);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str);
        } else {
            this.f291036e = new a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(int i3, int i16, String str) {
        Bundle bundle = new Bundle();
        bundle.putInt("ret", i16);
        bundle.putString("errMsg", str);
        bundle.putBoolean("reset_null", true);
        callbackResult(i3, EIPCResult.createResult(-102, bundle));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(int i3, String str) {
        Bundle bundle = new Bundle();
        bundle.putInt("ret", 0);
        bundle.putString("errMsg", str);
        bundle.putBoolean("reset_null", false);
        callbackResult(i3, EIPCResult.createResult(0, bundle));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public AppRuntime getAppRuntime() {
        return MobileQQ.sMobileQQ.waitAppRuntime(null);
    }

    private void h(Bundle bundle) {
        long j3 = bundle.getLong("nonce");
        String string = bundle.getString("idKey", "");
        if (!TextUtils.isEmpty(string) && j3 != 0) {
            AppRuntime appRuntime = getAppRuntime();
            if (appRuntime != null && (appRuntime instanceof QQAppInterface)) {
                QQAppInterface qQAppInterface = (QQAppInterface) appRuntime;
                qQAppInterface.registObserver(this.f291036e);
                KidModeServlet.e(qQAppInterface, String.valueOf(j3), string);
                return;
            }
            f(this.f291035d, 1, "appRuntime err");
            return;
        }
        f(this.f291035d, 1, "nonce or idKey null");
    }

    public static u i() {
        if (f291034f == null) {
            synchronized (u.class) {
                if (f291034f == null) {
                    f291034f = new u("StudyModeIpcServer_model");
                }
            }
        }
        return f291034f;
    }

    @Override // eipc.EIPCModule
    public EIPCResult onCall(String str, Bundle bundle, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        int i16 = 0;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (EIPCResult) iPatchRedirector.redirect((short) 2, this, str, bundle, Integer.valueOf(i3));
        }
        if (QLog.isColorLevel()) {
            QLog.d("qqstudymode_server", 2, "onCall, callbackId =" + i3);
        }
        if ("clear_pwd".equals(str)) {
            this.f291035d = i3;
            if (bundle == null) {
                QLog.d("qqstudymode_server", 1, "onCall, param is null, action=" + str + ", callBackId=" + i3);
                f(i3, 1, "no params");
                return null;
            }
            h(bundle);
        } else if ("verify_pwd".equals(str)) {
            if (!JumpKidModeMgr.b().p()) {
                i16 = -102;
            }
            return EIPCResult.createResult(i16, new Bundle());
        }
        return null;
    }
}
