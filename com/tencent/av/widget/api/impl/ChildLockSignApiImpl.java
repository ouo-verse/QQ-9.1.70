package com.tencent.av.widget.api.impl;

import android.content.Context;
import com.tencent.av.n;
import com.tencent.av.ui.AVActivity;
import com.tencent.av.widget.api.IChildLockSignApi;
import com.tencent.mobileqq.statistics.ReportController;

/* compiled from: P */
/* loaded from: classes32.dex */
public class ChildLockSignApiImpl implements IChildLockSignApi {
    @Override // com.tencent.av.widget.api.IChildLockSignApi
    public void handleSuccessMsg(Context context) {
        try {
            AVActivity aVActivity = (AVActivity) context;
            if (!n.e().f().f73048l0) {
                n.e().f().f73052m0 = true;
                ReportController.o(null, "CliOper", "", "", "0X80061F7", "0X80061F7", 0, 0, "", "", "", "");
            } else {
                n.e().f().f73052m0 = false;
                ReportController.o(null, "CliOper", "", "", "0X80061F9", "0X80061F9", 0, 0, "", "", "", "");
            }
            if (aVActivity.I0 != null) {
                if (!n.e().f().f73048l0) {
                    aVActivity.I0.e();
                } else {
                    aVActivity.I0.f();
                }
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }
}
