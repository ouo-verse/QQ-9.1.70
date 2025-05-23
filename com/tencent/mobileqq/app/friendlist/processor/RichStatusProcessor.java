package com.tencent.mobileqq.app.friendlist.processor;

import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.friend.processor.BaseFriendProcessor;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.app.AppRuntime;

@KeepClassConstructor
/* loaded from: classes11.dex */
public class RichStatusProcessor extends BaseFriendProcessor {
    static IPatchRedirector $redirector_;

    public RichStatusProcessor(AppRuntime appRuntime) {
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
            QLog.d("IMCore.friend.RichStatusProcessor", 1, "onGetExtensionInfoResp| app is not QQAppInterface");
        } else {
            ((FriendListHandler) ((QQAppInterface) appRuntime).getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).getRichStatus(new String[]{str});
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
            QLog.d("IMCore.friend.RichStatusProcessor", 1, "onGetExtensionInfoResp| app is not QQAppInterface");
        } else {
            ((FriendListHandler) ((QQAppInterface) appRuntime).getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).fetchRichStatusIfNeed(arrayList);
        }
    }
}
