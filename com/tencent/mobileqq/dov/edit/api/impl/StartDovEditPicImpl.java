package com.tencent.mobileqq.dov.edit.api.impl;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.aelight.camera.qqstory.api.IAELaunchEditPic;
import com.tencent.mobileqq.dov.edit.api.IStartDovEditPic;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;

/* loaded from: classes10.dex */
public class StartDovEditPicImpl implements IStartDovEditPic {
    static IPatchRedirector $redirector_ = null;
    public static final String TAG = "StartDovEditPicImpl";

    public StartDovEditPicImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.dov.edit.api.IStartDovEditPic
    public void enterCropActivity(Activity activity, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) activity, (Object) str);
            return;
        }
        if (activity != null && !TextUtils.isEmpty(str)) {
            Intent startEditPic = ((IAELaunchEditPic) QRoute.api(IAELaunchEditPic.class)).startEditPic(activity, str, false, false, false, true, false, 2, 146, 9);
            startEditPic.putExtra("qq_sub_business_id", 103);
            activity.startActivity(startEditPic);
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, String.format("enterCropActivity, path: %s", str));
            }
            ReportController.o(null, "dc00898", "", "", "0X80082DB", "0X80082DB", 0, 0, "", "", "", "");
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.e(TAG, 2, "enterCropActivity error, picture path is empty");
        }
    }
}
