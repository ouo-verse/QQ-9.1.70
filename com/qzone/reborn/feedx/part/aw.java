package com.qzone.reborn.feedx.part;

import android.app.Activity;
import android.os.Bundle;
import com.qzone.reborn.albumx.qzone.local.QZoneUploadRecommendDirector;
import com.tencent.richframework.thread.RFWThreadManager;
import cooperation.qzone.QZoneHelper;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes37.dex */
public class aw extends g {
    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void F9() {
        try {
            com.qzone.business.tianshu.n.f44882a.d();
            QZoneUploadRecommendDirector.INSTANCE.a().x();
        } catch (Throwable th5) {
            xe.b.f447841a.d(th5);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void G9() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            km.a.f412646a.f(peekAppRuntime, QZoneHelper.QZONE_PRELOAD_FROM_FEEDX);
        }
        km.a.f412646a.g();
    }

    private void H9() {
        RFWThreadManager.getInstance().execOnSubThread(new Runnable() { // from class: com.qzone.reborn.feedx.part.au
            @Override // java.lang.Runnable
            public final void run() {
                aw.F9();
            }
        });
    }

    private void I9() {
        RFWThreadManager.getInstance().execOnSubThread(new Runnable() { // from class: com.qzone.reborn.feedx.part.av
            @Override // java.lang.Runnable
            public final void run() {
                aw.G9();
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
        H9();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartResume(Activity activity) {
        super.onPartResume(activity);
        I9();
    }
}
