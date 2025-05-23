package com.tencent.mobileqq.wholepeople;

import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.nearby.redtouch.LocalRedTouchManager;
import com.tencent.mobileqq.nearby.redtouch.RedTouchItem;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;

/* compiled from: P */
/* loaded from: classes20.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static String f315335a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(77402);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f315335a = "com.qq.hotact";
        }
    }

    public static EIPCResult a(String str, Bundle bundle, int i3) {
        QQAppInterface qQAppInterface;
        if (QLog.isColorLevel()) {
            QLog.i("WholePeopleConstant", 2, "clearMsgRedPoint");
        }
        Bundle bundle2 = new Bundle();
        EIPCResult eIPCResult = new EIPCResult();
        eIPCResult.data = bundle2;
        if (BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface) {
            qQAppInterface = (QQAppInterface) BaseApplicationImpl.getApplication().getRuntime();
        } else {
            qQAppInterface = null;
        }
        if (qQAppInterface == null) {
            if (QLog.isColorLevel()) {
                QLog.d("WholePeopleConstant", 2, "clearMsgRedPoint, app is null");
            }
            eIPCResult.code = -1;
        } else {
            ((LocalRedTouchManager) qQAppInterface.getManager(QQManagerFactory.LOCAL_REDTOUCH_MANAGER)).u(10014);
            eIPCResult.code = 0;
        }
        return eIPCResult;
    }

    public static EIPCResult b(String str, Bundle bundle, int i3) {
        QQAppInterface qQAppInterface;
        int i16;
        int i17;
        if (QLog.isColorLevel()) {
            QLog.i("WholePeopleConstant", 2, "getMsgRedPoint");
        }
        Bundle bundle2 = new Bundle();
        EIPCResult eIPCResult = new EIPCResult();
        eIPCResult.data = bundle2;
        if (BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface) {
            qQAppInterface = (QQAppInterface) BaseApplicationImpl.getApplication().getRuntime();
        } else {
            qQAppInterface = null;
        }
        if (qQAppInterface == null) {
            if (QLog.isColorLevel()) {
                QLog.d("WholePeopleConstant", 2, "getMsgRedPoint, app is null");
            }
            eIPCResult.code = -1;
        } else {
            LocalRedTouchManager localRedTouchManager = (LocalRedTouchManager) qQAppInterface.getManager(QQManagerFactory.LOCAL_REDTOUCH_MANAGER);
            RedTouchItem j3 = localRedTouchManager.j(10014);
            if (localRedTouchManager.d(j3, false)) {
                if (j3.redtouchType == 2) {
                    i17 = j3.count + 0;
                    i16 = 0;
                } else {
                    i16 = 1;
                    i17 = 0;
                }
            } else {
                i16 = 0;
                i17 = 0;
            }
            bundle2.putInt("redPointCount", i16);
            bundle2.putInt("redNumCount", i17);
            if (QLog.isColorLevel()) {
                QLog.i("WholePeopleConstant", 2, "getMsgRedPoint redPointCount:" + i16 + " redNumCount:" + i17);
            }
            eIPCResult.code = 0;
        }
        return eIPCResult;
    }

    public static BusinessInfoCheckUpdate.AppInfo c(int i3, int i16) {
        BusinessInfoCheckUpdate.AppInfo appInfo = new BusinessInfoCheckUpdate.AppInfo();
        if (QLog.isColorLevel()) {
            QLog.i("WholePeopleConstant", 2, "getMsgRedTouch redNum:" + i3 + " redPoint:" + i16);
        }
        if (i3 <= 0 && i16 <= 0) {
            return appInfo;
        }
        if (i3 > 0) {
            BusinessInfoCheckUpdate.RedTypeInfo redTypeInfo = new BusinessInfoCheckUpdate.RedTypeInfo();
            if (i3 > 99) {
                redTypeInfo.red_content.set("99+");
            } else {
                redTypeInfo.red_content.set(String.valueOf(i3));
            }
            redTypeInfo.red_type.set(5);
            redTypeInfo.red_desc.set("{'cn':'#FF0000'}");
            appInfo.red_display_info.red_type_info.add(redTypeInfo);
            appInfo.iNewFlag.set(1);
            return appInfo;
        }
        BusinessInfoCheckUpdate.RedTypeInfo redTypeInfo2 = new BusinessInfoCheckUpdate.RedTypeInfo();
        redTypeInfo2.red_type.set(0);
        redTypeInfo2.red_desc.set("");
        redTypeInfo2.red_content.set("");
        appInfo.red_display_info.red_type_info.add(redTypeInfo2);
        appInfo.iNewFlag.set(1);
        return appInfo;
    }
}
