package com.tencent.mobileqq.emoticonview.ipc.proxy;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.data.CameraEmotionData;
import com.tencent.mobileqq.emosm.api.ICameraEmotionRoamingDBManagerService;
import com.tencent.mobileqq.emoticonview.EmoticonInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes12.dex */
public class CameraEmotionRoamingDBManagerServiceProxy extends AbsEmoRuntimeServiceProxy<ICameraEmotionRoamingDBManagerService> {
    static IPatchRedirector $redirector_ = null;
    public static final String TAG = "CameraEmotionRoamingDBManagerServiceProxy";

    public CameraEmotionRoamingDBManagerServiceProxy(BaseQQAppInterface baseQQAppInterface) {
        super(baseQQAppInterface, ICameraEmotionRoamingDBManagerService.class);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) baseQQAppInterface);
        }
    }

    public int getCatchDataCount() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        if (this.manager != 0) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 4, "do catchDataCount.");
            }
            return ((ICameraEmotionRoamingDBManagerService) this.manager).getCatchDataCount();
        }
        return 0;
    }

    public List<CameraEmotionData> getEmoticonDataList() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (List) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        if (this.manager != 0) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 4, "do emoticonDataList.");
            }
            return ((ICameraEmotionRoamingDBManagerService) this.manager).getEmoticonDataList();
        }
        return new ArrayList();
    }

    public List<EmoticonInfo> syncGetCustomEmotionInfoShowedInPanel() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (List) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        if (this.manager != 0) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 4, "do syncGetCustomEmotionInfoShowedInPanel.");
            }
            return ((ICameraEmotionRoamingDBManagerService) this.manager).syncGetCustomEmotionInfoShowedInPanel();
        }
        return new ArrayList();
    }
}
