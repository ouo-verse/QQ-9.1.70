package com.tencent.mobileqq.emoticonview.ipc.proxy;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.data.CustomEmotionData;
import com.tencent.mobileqq.emosm.api.IFavroamingDBManagerService;
import com.tencent.mobileqq.emoticonview.EmoticonInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes12.dex */
public class FavroamingDBManagerServiceProxy extends AbsEmoRuntimeServiceProxy<IFavroamingDBManagerService> {
    static IPatchRedirector $redirector_ = null;
    public static final String TAG = "FavroamingDBManagerServiceProxy";

    public FavroamingDBManagerServiceProxy(BaseQQAppInterface baseQQAppInterface) {
        super(baseQQAppInterface, IFavroamingDBManagerService.class);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) baseQQAppInterface);
        }
    }

    public void delOverflow(List<CustomEmotionData> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) list);
            return;
        }
        T t16 = this.manager;
        if (t16 != 0) {
            ((IFavroamingDBManagerService) t16).delOverflow(list);
        }
    }

    public List<CustomEmotionData> getEmoticonDataList() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (List) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        T t16 = this.manager;
        if (t16 != 0) {
            return ((IFavroamingDBManagerService) t16).getEmoticonDataList();
        }
        return new ArrayList();
    }

    public List<EmoticonInfo> syncGetCustomEmotionInfoShowedInAIOPanel() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (List) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        T t16 = this.manager;
        if (t16 != 0) {
            return ((IFavroamingDBManagerService) t16).syncGetCustomEmotionInfoShowedInAIOPanel();
        }
        return new ArrayList();
    }

    public List<EmoticonInfo> syncGetCustomEmotionInfoShowedInPanel() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (List) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        T t16 = this.manager;
        if (t16 != 0) {
            return ((IFavroamingDBManagerService) t16).syncGetCustomEmotionInfoShowedInPanel();
        }
        return new ArrayList();
    }
}
