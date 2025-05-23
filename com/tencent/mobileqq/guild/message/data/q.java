package com.tencent.mobileqq.guild.message.data;

import android.content.Context;
import android.os.Bundle;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.data.GrayTipsMessageConstants$HighlightItem;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProSecurityResult;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import vh2.cd;

/* compiled from: P */
/* loaded from: classes33.dex */
public class q extends com.tencent.mobileqq.guild.message.base.n {
    @Override // com.tencent.mobileqq.guild.message.base.n
    public boolean a(AppRuntime appRuntime, Context context, GrayTipsMessageConstants$HighlightItem grayTipsMessageConstants$HighlightItem, Bundle bundle) {
        if (grayTipsMessageConstants$HighlightItem.actionType != 73) {
            return false;
        }
        if (QLog.isColorLevel()) {
            QLog.i("GuildUniteGrayTipRobotBlockClickHandler", 2, "HighlightItem handleOnClick, item.type:" + grayTipsMessageConstants$HighlightItem.actionType);
        }
        ((IGPSService) appRuntime.getRuntimeService(IGPSService.class, "")).setDirectMsgBlack(bundle.getString("sender_uin", ""), true, new cd() { // from class: com.tencent.mobileqq.guild.message.data.p
            @Override // vh2.cd
            public final void a(int i3, String str, IGProSecurityResult iGProSecurityResult) {
                q.c(i3, str, iGProSecurityResult);
            }
        });
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void c(int i3, String str, IGProSecurityResult iGProSecurityResult) {
        if (i3 != 0) {
            QLog.e("GuildUniteGrayTipRobotBlockClickHandler", 2, "block friend failed\uff1aresult =" + i3 + ", errMsg:" + str);
        }
        QQToast.makeText(BaseApplication.getContext(), 2, R.string.f1327045, 1).show();
    }
}
