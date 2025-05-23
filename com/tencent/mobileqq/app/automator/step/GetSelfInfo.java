package com.tencent.mobileqq.app.automator.step;

import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.ConfigHandler;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.profilecard.utils.ProfileServiceUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.subaccount.api.ISubAccountService;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes11.dex */
public class GetSelfInfo extends AsyncStep<Automator> {
    static IPatchRedirector $redirector_;

    public GetSelfInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.automator.AsyncStep
    public int doStep() {
        ArrayList<String> arrayList;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        FriendListHandler friendListHandler = (FriendListHandler) ((Automator) this.mAutomator).E.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER);
        T t16 = this.mAutomator;
        if (((Automator) t16).E.mFirstGetSubAccountName) {
            ISubAccountService iSubAccountService = (ISubAccountService) ((Automator) t16).E.getRuntimeService(ISubAccountService.class, "");
            if (iSubAccountService != null) {
                arrayList = iSubAccountService.getAllSubUin();
            } else {
                arrayList = null;
            }
            if (arrayList != null && arrayList.size() > 0) {
                ((Automator) this.mAutomator).E.mFirstGetSubAccountName = false;
                Iterator<String> it = arrayList.iterator();
                while (it.hasNext()) {
                    friendListHandler.getFriendInfo(it.next());
                }
            }
        }
        ProfileServiceUtils.getIProfileProtocolService(((Automator) this.mAutomator).E).getProfileDetailForLogin();
        boolean a16 = com.tencent.relation.common.config.toggle.b.a(2);
        if (QLog.isColorLevel()) {
            QLog.i("IAutomator", 1, String.format("GetSelfInfo.profileMergeReq = %b", Boolean.valueOf(a16)));
        }
        if (!a16) {
            com.tencent.mobileqq.profilecommon.utils.a.b(((Automator) this.mAutomator).E);
        }
        ((ConfigHandler) ((Automator) this.mAutomator).E.getBusinessHandler(BusinessHandlerFactory.CONFIG_HANDLER)).M2();
        T t17 = this.mAutomator;
        FaceDrawable.getUserFaceDrawable(((Automator) t17).E, ((Automator) t17).E.getAccount(), (byte) 3);
        return 7;
    }
}
