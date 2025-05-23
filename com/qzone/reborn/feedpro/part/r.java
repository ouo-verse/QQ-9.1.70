package com.qzone.reborn.feedpro.part;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.richframework.thread.RFWThreadManager;
import cooperation.qzone.QZoneHelper;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes37.dex */
public class r extends com.qzone.reborn.feedx.part.g {
    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void E9() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            km.a.f412646a.f(peekAppRuntime, QZoneHelper.QZONE_PRELOAD_FROM_FEEDX);
        }
        km.a.f412646a.g();
    }

    private void G9() {
        RFWThreadManager.getInstance().execOnSubThread(new Runnable() { // from class: com.qzone.reborn.feedpro.part.q
            @Override // java.lang.Runnable
            public final void run() {
                r.E9();
            }
        }, 3000L);
    }

    @Override // com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QZoneFeedxPreloadPart";
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(Activity activity, Bundle bundle) {
        F9();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartResume(Activity activity) {
        super.onPartResume(activity);
        G9();
    }

    private void F9() {
    }
}
