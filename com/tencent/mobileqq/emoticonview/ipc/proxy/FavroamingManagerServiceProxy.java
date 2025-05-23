package com.tencent.mobileqq.emoticonview.ipc.proxy;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.data.CustomEmotionData;
import com.tencent.mobileqq.emosm.api.IFavroamingManagerService;
import com.tencent.mobileqq.emosm.favroaming.a;
import com.tencent.mobileqq.emosm.favroaming.n;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* loaded from: classes12.dex */
public class FavroamingManagerServiceProxy extends AbsEmoRuntimeServiceProxy<IFavroamingManagerService> {
    static IPatchRedirector $redirector_ = null;
    public static final String TAG = "FavroamingManagerServiceProxy";

    public FavroamingManagerServiceProxy(BaseQQAppInterface baseQQAppInterface) {
        super(baseQQAppInterface, IFavroamingManagerService.class);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) baseQQAppInterface);
        }
    }

    public void addSyncListener(n<CustomEmotionData> nVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) nVar);
            return;
        }
        T t16 = this.manager;
        if (t16 != 0) {
            ((IFavroamingManagerService) t16).addSyncListener(nVar);
        }
    }

    public void cacheAccessibilityEmotionData() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        T t16 = this.manager;
        if (t16 != 0) {
            ((IFavroamingManagerService) t16).cacheAccessibilityEmotionData();
        }
    }

    public CharSequence getAccessibilityDescription(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (CharSequence) iPatchRedirector.redirect((short) 2, (Object) this, i3);
        }
        T t16 = this.manager;
        if (t16 != 0) {
            return ((IFavroamingManagerService) t16).getAccessibilityDescription(Integer.valueOf(i3));
        }
        return null;
    }

    public boolean isInSyncing() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
        }
        T t16 = this.manager;
        if (t16 != 0) {
            return ((IFavroamingManagerService) t16).isInSyncing();
        }
        return false;
    }

    public void removeSyncListener(n<CustomEmotionData> nVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) nVar);
            return;
        }
        T t16 = this.manager;
        if (t16 != 0) {
            ((IFavroamingManagerService) t16).removeSyncListener(nVar);
        }
    }

    public void setAccessibilityResultListener(a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) aVar);
            return;
        }
        T t16 = this.manager;
        if (t16 != 0) {
            ((IFavroamingManagerService) t16).setUpdateResultListener(aVar);
        }
    }

    public void syncLocalDel() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        T t16 = this.manager;
        if (t16 != 0) {
            ((IFavroamingManagerService) t16).syncLocalDel();
        }
    }
}
