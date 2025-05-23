package com.tencent.mobileqq.troop.avatar.api.impl;

import android.graphics.Bitmap;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.face.GroupIconHelper;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.avatar.api.ITroopAvatarService;
import com.tencent.mobileqq.troop.handler.TroopAvatarHandler;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes19.dex */
public class TroopAvatarServiceImpl implements ITroopAvatarService {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "TroopAvatarServiceImpl";
    private AppRuntime app;
    private GroupIconHelper mIconHelper;

    public TroopAvatarServiceImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.troop.avatar.api.ITroopAvatarService
    public Bitmap getGroupFaceIcon(String str, boolean z16) {
        Bitmap bitmap;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (Bitmap) iPatchRedirector.redirect((short) 5, this, str, Boolean.valueOf(z16));
        }
        try {
            if (str == null) {
                if (!z16) {
                    return null;
                }
                return BaseImageUtil.getDefaultTroopFaceBitmap();
            }
            AppRuntime appRuntime = this.app;
            if (appRuntime instanceof QQAppInterface) {
                bitmap = ((QQAppInterface) appRuntime).getFaceBitmap(113, str, (byte) 3, false, (byte) 1, 0);
            } else {
                bitmap = null;
            }
            if (bitmap == null) {
                updateGroupIcon(str, true);
                if (!z16) {
                    return null;
                }
                return BaseImageUtil.getDefaultTroopFaceBitmap();
            }
            updateGroupIcon(str, false);
            return bitmap;
        } catch (Throwable th5) {
            if (!QLog.isColorLevel()) {
                return null;
            }
            QLog.e(TAG, 2, "getDiscussionFaceIcon error", th5);
            return null;
        }
    }

    @Override // com.tencent.mobileqq.troop.avatar.api.ITroopAvatarService
    public GroupIconHelper getGroupIconHelper() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (GroupIconHelper) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.mIconHelper;
    }

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) appRuntime);
            return;
        }
        this.app = appRuntime;
        if (appRuntime instanceof QQAppInterface) {
            this.mIconHelper = new GroupIconHelper(appRuntime.getCurrentAccountUin(), (TroopAvatarHandler) ((QQAppInterface) appRuntime).getBusinessHandler(BusinessHandlerFactory.TROOP_AVATAR_HANDLER));
        }
    }

    @Override // mqq.app.api.IRuntimeService
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        GroupIconHelper groupIconHelper = this.mIconHelper;
        if (groupIconHelper != null) {
            groupIconHelper.Q();
        }
    }

    @Override // com.tencent.mobileqq.troop.avatar.api.ITroopAvatarService
    public void updateGroupIcon(String str, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, str, Boolean.valueOf(z16));
            return;
        }
        AppRuntime appRuntime = this.app;
        if ((appRuntime instanceof QQAppInterface) && ((QQAppInterface) appRuntime).mAutomator.H2()) {
            if (z16) {
                this.mIconHelper.z(str);
            } else {
                this.mIconHelper.u(str);
            }
        }
    }
}
