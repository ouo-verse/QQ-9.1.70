package com.tencent.mobileqq.qwallet.jump.impl;

import android.content.Context;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.icgame.api.impl.room.report.AudienceReportConst;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.jump.IWXMiniProgramHelper;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.utils.ax;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes16.dex */
public class a extends ax {
    public a(BaseQQAppInterface baseQQAppInterface, Context context) {
        super(baseQQAppInterface, context);
    }

    private boolean F() {
        ((IWXMiniProgramHelper) QRoute.api(IWXMiniProgramHelper.class)).launchMiniProgram(this.f307441f, this.f307438c);
        return true;
    }

    @Override // com.tencent.mobileqq.utils.ax
    public boolean b() {
        try {
            if (!this.f307441f.containsKey(AudienceReportConst.USER_NAME) || StringUtil.isEmpty(this.f307441f.get(AudienceReportConst.USER_NAME))) {
                return false;
            }
            return F();
        } catch (Exception e16) {
            QLog.e("QwalletToLaunchWXMiniAppAction", 1, "doAction error: " + e16.getMessage());
            i("QwalletToLaunchWXMiniAppAction");
            return false;
        }
    }
}
