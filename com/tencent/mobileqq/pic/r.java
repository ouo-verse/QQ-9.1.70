package com.tencent.mobileqq.pic;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes16.dex */
public class r extends QIPCModule {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private static volatile r f258797d;

    public r(String str) {
        super(str);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str);
        }
    }

    public static r b() {
        if (f258797d == null) {
            synchronized (r.class) {
                if (f258797d == null) {
                    f258797d = new r("PicSTWXQIPCModule");
                }
            }
        }
        return f258797d;
    }

    @Override // eipc.EIPCModule
    public EIPCResult onCall(String str, Bundle bundle, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (EIPCResult) iPatchRedirector.redirect((short) 2, this, str, bundle, Integer.valueOf(i3));
        }
        if (QLog.isColorLevel()) {
            QLog.d("PicSTWXQIPCModule", 2, "onCall, action = " + str);
        }
        String string = bundle.getString("param_pic_path", "");
        if (TextUtils.isEmpty(string)) {
            if (QLog.isColorLevel()) {
                QLog.d("PicSTWXQIPCModule", 2, "path is empty");
            }
            return null;
        }
        if (QLog.isColorLevel()) {
            QLog.d("PicSTWXQIPCModule", 2, "onCall, path = " + string);
        }
        int i16 = bundle.getInt("param_from_type", 0);
        if (QLog.isColorLevel()) {
            QLog.d("PicSTWXQIPCModule", 2, "onCall, fromType = " + i16);
        }
        AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
        if (!(runtime instanceof QQAppInterface)) {
            if (QLog.isColorLevel()) {
                QLog.d("PicSTWXQIPCModule", 2, "cannot get QQAppInterface.");
            }
            return null;
        }
        PicShareToWX.f().s(this, i3, (QQAppInterface) runtime, string, i16);
        return null;
    }
}
