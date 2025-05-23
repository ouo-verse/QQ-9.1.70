package com.tencent.qqnt.emotion.api.impl;

import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.emotion.api.IEmoticonManager;
import com.tencent.qqnt.emotion.api.IEmoticonManagerService;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes24.dex */
public class EmoticonManagerImpl implements IEmoticonManager {
    static IPatchRedirector $redirector_ = null;
    public static final String TAG = "EmoticonManagerImpl";
    private IEmoticonManagerService mEmoMgr;

    public EmoticonManagerImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.mEmoMgr = null;
        }
    }

    @Override // com.tencent.qqnt.emotion.api.IEmoticonManager
    public String getSmallEmoticonDescription(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str, (Object) str2);
        }
        IEmoticonManagerService iEmoticonManagerService = this.mEmoMgr;
        if (iEmoticonManagerService != null) {
            return iEmoticonManagerService.getSmallEmoticonDescription(str, str2);
        }
        return "";
    }

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) appRuntime);
        } else if (appRuntime != null) {
            try {
                this.mEmoMgr = (IEmoticonManagerService) appRuntime.getRuntimeService(IEmoticonManagerService.class, "");
            } catch (Throwable th5) {
                th5.printStackTrace();
            }
        }
    }

    @Override // mqq.app.api.IRuntimeService
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            this.mEmoMgr = null;
        }
    }

    @Override // com.tencent.qqnt.emotion.api.IEmoticonManager
    public String syncGetEmoticonDescriptionById(String str, String str2) {
        Emoticon syncFindEmoticonById;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this, (Object) str, (Object) str2);
        }
        IEmoticonManagerService iEmoticonManagerService = this.mEmoMgr;
        if (iEmoticonManagerService != null && (syncFindEmoticonById = iEmoticonManagerService.syncFindEmoticonById(str, str2)) != null) {
            return syncFindEmoticonById.character;
        }
        return "";
    }
}
