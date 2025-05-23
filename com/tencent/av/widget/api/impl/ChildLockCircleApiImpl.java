package com.tencent.av.widget.api.impl;

import android.content.Context;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.n;
import com.tencent.av.r;
import com.tencent.av.ui.AVActivity;
import com.tencent.av.widget.api.IChildLockCircleApi;
import com.tencent.avcore.util.AVCoreLog;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import cw.e;

/* compiled from: P */
/* loaded from: classes32.dex */
public class ChildLockCircleApiImpl implements IChildLockCircleApi {
    private static final String TAG = "ChildLockCircleApiImpl";

    @Override // com.tencent.av.widget.api.IChildLockCircleApi
    public void onAnimationEnd() {
        e.f((VideoAppInterface) BaseApplicationImpl.getApplication().getRuntime());
    }

    @Override // com.tencent.av.widget.api.IChildLockCircleApi
    public void onAnimationFailed(Context context) {
        try {
            if (!n.e().f().f73048l0) {
                ReportController.o(null, "CliOper", "", "", "0X80061F8", "0X80061F8", 0, 0, "", "", "", "");
            } else {
                ReportController.o(null, "CliOper", "", "", "0X80061FA", "0X80061FA", 0, 0, "", "", "", "");
            }
        } catch (Exception e16) {
            AVCoreLog.printErrorLog(TAG, e16.getMessage());
        }
    }

    @Override // com.tencent.av.widget.api.IChildLockCircleApi
    public boolean onLockSuccess(Context context) {
        if (r.h0() == null) {
            return false;
        }
        n.e().f().f73056n0 = 1;
        return true;
    }

    @Override // com.tencent.av.widget.api.IChildLockCircleApi
    public void startChildLockAnimation() {
        e.e((VideoAppInterface) BaseApplicationImpl.getApplication().getRuntime());
    }

    @Override // com.tencent.av.widget.api.IChildLockCircleApi
    public boolean updateText(Context context) {
        return !n.e().f().f73048l0;
    }

    @Override // com.tencent.av.widget.api.IChildLockCircleApi
    public void handleAnimSuccessMsg(Context context) {
        try {
            AVActivity aVActivity = (AVActivity) context;
            if (!n.e().f().f73048l0) {
                n.e().f().f73052m0 = true;
                n.e().f().f73056n0 = 2;
                if (QLog.isColorLevel()) {
                    QLog.e(TAG, 2, "[childLock] action lock");
                }
                ReportController.o(null, "CliOper", "", "", "0X80061F7", "0X80061F7", 0, 0, "", "", "", "");
            } else {
                n.e().f().f73052m0 = false;
                if (QLog.isColorLevel()) {
                    QLog.e(TAG, 2, "[childLock] action unlock");
                }
                ReportController.o(null, "CliOper", "", "", "0X80061F9", "0X80061F9", 0, 0, "", "", "", "");
            }
            if (aVActivity.I0 != null) {
                if (!n.e().f().f73048l0) {
                    aVActivity.I0.e();
                } else {
                    aVActivity.I0.f();
                }
            }
        } catch (Exception unused) {
        }
    }
}
