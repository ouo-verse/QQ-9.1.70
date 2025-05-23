package com.tencent.mobileqq.util.impl;

import android.content.DialogInterface;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.util.IDialogUtilService;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes20.dex */
public class DialogUtilServiceImpl implements IDialogUtilService {
    @Override // com.tencent.mobileqq.util.IDialogUtilService
    public void showMSFRespCustomDialog(int i3, String str, String str2, DialogInterface.OnClickListener onClickListener, DialogInterface.OnClickListener onClickListener2) {
        QBaseActivity qBaseActivity = QBaseActivity.sTopActivity;
        QLog.d("DialogUtilServiceImpl", 1, "showMSFRespCustomDialog, activity: " + qBaseActivity);
        if (qBaseActivity != null && !qBaseActivity.isFinishing()) {
            DialogUtil.createCustomDialog(qBaseActivity, i3, str, str2, onClickListener, onClickListener2).show();
        }
    }
}
