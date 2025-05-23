package com.tencent.mobileqq.app.friendlist.processor;

import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.friendlist.b;
import com.tencent.mobileqq.friend.processor.BaseFriendProcessor;
import com.tencent.mobileqq.phonecontact.api.IPhoneContactService;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import mqq.app.AppRuntime;

@KeepClassConstructor
/* loaded from: classes11.dex */
public class MainProcessor extends BaseFriendProcessor {
    static IPatchRedirector $redirector_;

    public MainProcessor(AppRuntime appRuntime) {
        super(appRuntime);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) appRuntime);
        }
    }

    @Override // com.tencent.mobileqq.friend.processor.BaseFriendProcessor
    public void onGetFriendInfoFinish(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
            return;
        }
        AppRuntime appRuntime = this.mApp;
        if (!(appRuntime instanceof QQAppInterface)) {
            QLog.d("IMCore.friend.MainProcessor", 1, "onGetExtensionInfoResp| app is not QQAppInterface");
            return;
        }
        IPhoneContactService iPhoneContactService = (IPhoneContactService) ((QQAppInterface) appRuntime).getRuntimeService(IPhoneContactService.class, "");
        if (iPhoneContactService != null) {
            iPhoneContactService.notifyContactChanged();
        }
    }

    @Override // com.tencent.mobileqq.friend.processor.BaseFriendProcessor
    public void onGetFriendListFinish(boolean z16, ArrayList<String> arrayList, com.tencent.mobileqq.friend.data.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), arrayList, aVar);
            return;
        }
        AppRuntime appRuntime = this.mApp;
        if (!(appRuntime instanceof QQAppInterface)) {
            QLog.d("IMCore.friend.MainProcessor", 1, "onGetExtensionInfoResp| app is not QQAppInterface");
            return;
        }
        QQAppInterface qQAppInterface = (QQAppInterface) appRuntime;
        IPhoneContactService iPhoneContactService = (IPhoneContactService) qQAppInterface.getRuntimeService(IPhoneContactService.class, "");
        iPhoneContactService.notifyContactChanged();
        if (!z16) {
            iPhoneContactService.onFriendListChanged();
        }
        qQAppInterface.notifyFriendListSynced();
        ((FriendListHandler) qQAppInterface.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).getGatheredContactsList(0);
    }

    @Override // com.tencent.mobileqq.friend.processor.BaseFriendProcessor
    public void onReportFriendListNetLoad(long j3, long j16, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Long.valueOf(j3), Long.valueOf(j16), Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("request_data_time", String.valueOf(j3));
        hashMap.put("response_data_time", String.valueOf(j16));
        hashMap.put("response_data_time_result", String.valueOf(i16));
        hashMap.put("response_item_count", String.valueOf(i3));
        b.b(hashMap);
    }
}
