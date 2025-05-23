package com.tencent.mobileqq.guild.mainframe.helper;

import android.content.Intent;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.gamecenter.qa.api.IQQGameStrategyApi;
import com.tencent.mobileqq.guild.mainframe.k;
import com.tencent.mobileqq.qroute.QRoute;

/* compiled from: P */
/* loaded from: classes14.dex */
public class b extends k {
    public b(com.tencent.mobileqq.guild.mainframe.i iVar) {
        super(iVar);
    }

    @Override // com.tencent.mobileqq.guild.mainframe.k, com.tencent.mobileqq.guild.mainframe.t
    public void onActivityResult(int i3, int i16, Intent intent) {
        QBaseActivity activity;
        super.onActivityResult(i3, i16, intent);
        if (i16 != -1 || intent == null || (activity = this.f227466d.getActivity()) == null) {
            return;
        }
        if (i3 == 10025 || i3 == 10022 || i3 == 10023) {
            ((IQQGameStrategyApi) QRoute.api(IQQGameStrategyApi.class)).getStrategyDialogFragment(activity).onActivityResult(i3, i16, intent);
        }
    }
}
