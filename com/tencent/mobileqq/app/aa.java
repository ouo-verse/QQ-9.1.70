package com.tencent.mobileqq.app;

import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes11.dex */
public class aa extends QIPCModule {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private static volatile aa f195230d;

    public aa(String str) {
        super(str);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str);
        }
    }

    public static aa b() {
        if (f195230d == null) {
            synchronized (aa.class) {
                if (f195230d == null) {
                    f195230d = new aa("ExtendFriendQIPCModule");
                }
            }
        }
        return f195230d;
    }

    @Override // eipc.EIPCModule
    public EIPCResult onCall(String str, Bundle bundle, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        int i16 = 3;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (EIPCResult) iPatchRedirector.redirect((short) 2, this, str, bundle, Integer.valueOf(i3));
        }
        AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
        if (!(runtime instanceof QQAppInterface)) {
            return null;
        }
        QQAppInterface qQAppInterface = (QQAppInterface) runtime;
        if ("notifyCampusFriendCertificateResult".equals(str)) {
            boolean z16 = bundle.getBoolean("key_result");
            if (QLog.isColorLevel()) {
                QLog.d("ExtendFriendQIPCModule", 2, "onCall ACTION_NOTIFY_CAMPUS_FRIEND_CERTIFICATE_RESULT ,result = " + z16);
            }
            com.tencent.mobileqq.qqexpand.manager.e eVar = (com.tencent.mobileqq.qqexpand.manager.e) qQAppInterface.getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER);
            if (eVar != null) {
                if (z16) {
                    i16 = 2;
                }
                eVar.V(i16, 1);
                ((com.tencent.mobileqq.qqexpand.network.e) qQAppInterface.getBusinessHandler(BusinessHandlerFactory.EXTEND_FRIEND_HANDLER)).notifyUI(20, true, new Object[]{2});
            }
        } else if ("notifyUploadSutudentIDResult".equals(str)) {
            boolean z17 = bundle.getBoolean("key_result");
            com.tencent.mobileqq.qqexpand.manager.e eVar2 = (com.tencent.mobileqq.qqexpand.manager.e) qQAppInterface.getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER);
            if (z17) {
                eVar2.V(1, 2);
                ((com.tencent.mobileqq.qqexpand.network.e) qQAppInterface.getBusinessHandler(BusinessHandlerFactory.EXTEND_FRIEND_HANDLER)).notifyUI(20, true, new Object[]{2});
            }
            if (QLog.isColorLevel()) {
                QLog.d("ExtendFriendQIPCModule", 2, "onCall ACTION_NOTIFY_STUDENTID_UPLOAD_RESULT ,result = " + z17);
            }
        } else if ("notifyUpdateSchoolInfo".equals(str)) {
            String string = bundle.getString("name", "");
            int i17 = bundle.getInt("category", 0);
            String string2 = bundle.getString("schoolid", "");
            int i18 = bundle.getInt("idx", 0);
            com.tencent.mobileqq.qqexpand.manager.e eVar3 = (com.tencent.mobileqq.qqexpand.manager.e) qQAppInterface.getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER);
            String t16 = eVar3.t();
            if (QLog.isColorLevel()) {
                QLog.d("ExtendFriendQIPCModule", 2, "onCall ACTION_NOTIFY_SCHOOL_INFO_UPDATE \uff0cschoolName = " + string + "\uff0coldSchoolName = " + t16);
            }
            if (!string.equals(t16)) {
                eVar3.V(0, -1);
            }
            eVar3.j(i18, string, string2, i17);
            ((com.tencent.mobileqq.qqexpand.network.e) qQAppInterface.getBusinessHandler(BusinessHandlerFactory.EXTEND_FRIEND_HANDLER)).notifyUI(22, true, bundle);
        }
        return null;
    }
}
