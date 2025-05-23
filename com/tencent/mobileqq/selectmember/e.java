package com.tencent.mobileqq.selectmember;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.selectmember.SelectMsgShareProcessor;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes18.dex */
public class e {
    static IPatchRedirector $redirector_;

    public static ResultRecord a(String str, String str2, int i3, String str3) {
        ResultRecord resultRecord = new ResultRecord();
        resultRecord.uin = str;
        resultRecord.name = str2;
        resultRecord.type = i3;
        resultRecord.groupUin = str3;
        return resultRecord;
    }

    public static int b() {
        SelectMsgShareProcessor.a aVar = (SelectMsgShareProcessor.a) ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadConfig("100932");
        if (aVar == null) {
            aVar = new SelectMsgShareProcessor.a();
        }
        return aVar.f285785d;
    }

    public static int c() {
        SelectMsgShareProcessor.a aVar = (SelectMsgShareProcessor.a) ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadConfig("100932");
        if (aVar == null) {
            aVar = new SelectMsgShareProcessor.a();
        }
        QLog.d("SelectMsgShareProcessor", 1, "getMsgNumUpperLimit = ", aVar);
        return aVar.f285786e;
    }
}
