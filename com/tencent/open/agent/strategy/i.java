package com.tencent.open.agent.strategy;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.open.agent.AuthorityActivity;

/* compiled from: P */
/* loaded from: classes22.dex */
class i extends c {
    public i(String str) {
        super(str);
    }

    @Override // com.tencent.open.agent.strategy.c
    public void d(Activity activity, Bundle bundle) {
        c(new Intent(activity, (Class<?>) AuthorityActivity.class), activity, bundle);
        ReportController.o(null, "dc00898", "", "", "0X800BC5D", "0X800BC5D", 0, 0, "", "", "", "");
    }
}
