package com.qzone.reborn.feedx.part;

import android.app.Activity;
import android.os.Message;
import android.view.View;
import com.qzone.common.account.LoginData;
import com.qzone.common.business.result.QZoneResult;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import cooperation.qzone.util.QZLog;
import java.util.ArrayList;

/* loaded from: classes37.dex */
public class QZoneFeedxVisitNotifyTopBannerPart extends g {

    /* renamed from: h, reason: collision with root package name */
    private static long f54964h;

    /* renamed from: i, reason: collision with root package name */
    static int f54965i;

    /* renamed from: d, reason: collision with root package name */
    private gf.n f54966d;

    /* renamed from: e, reason: collision with root package name */
    private int f54967e;

    /* renamed from: f, reason: collision with root package name */
    private final Runnable f54968f = new Runnable() { // from class: com.qzone.reborn.feedx.part.QZoneFeedxVisitNotifyTopBannerPart.1
        @Override // java.lang.Runnable
        public void run() {
            if (QZoneFeedxVisitNotifyTopBannerPart.this.f54967e == 0) {
                return;
            }
            QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.BackGroundThread).postDelayed(this, QZoneFeedxVisitNotifyTopBannerPart.this.f54967e * 1000);
            com.qzone.feed.business.service.c.a().d(LoginData.getInstance().getUin(), QZoneFeedxVisitNotifyTopBannerPart.this.getMainHandler());
            QZoneFeedxVisitNotifyTopBannerPart.f54965i++;
        }
    };

    private void E9(QZoneResult qZoneResult) {
        gf.n nVar;
        if (qZoneResult.getSucceed() && (nVar = this.f54966d) != null && nVar.d()) {
            com.qzone.feed.business.model.a aVar = new com.qzone.feed.business.model.a();
            aVar.f47125i = new ArrayList<>((ArrayList) qZoneResult.getData());
            aVar.f47117a = 9;
            aVar.f47126j = com.qzone.feed.business.service.c.a().c();
            this.f54967e = com.qzone.feed.business.service.c.a().b();
            if (aVar.f47125i.size() == 0) {
                QZLog.d("VisitNotify", 4, "visitUser  size is 0, not shown!");
            } else {
                this.f54966d.b(aVar);
            }
        }
    }

    private void F9() {
        if (this.f54967e != 0) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - f54964h >= this.f54967e * 1000) {
                QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.BackGroundThread).removeTask(this.f54968f);
                QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.BackGroundThread).post(this.f54968f);
                f54964h = currentTimeMillis;
                QLog.d("QZoneFeedxVisitNotifyTopBannerPart", 1, "resumeTimerTask->addVisitNotifyRunnable,right now!");
                return;
            }
            QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.BackGroundThread).removeTask(this.f54968f);
            QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.BackGroundThread).postDelayed(this.f54968f, this.f54967e * 1000);
            QLog.d("QZoneFeedxVisitNotifyTopBannerPart", 1, "resumeTimerTask->addVisitNotifyRunnable,delay ", Integer.valueOf(this.f54967e), "s!");
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QZoneFeedxVisitNotifyTopBannerPart";
    }

    @Override // com.qzone.reborn.feedx.part.g, com.qzone.reborn.feedx.viewmodel.b
    public void i6() {
        super.i6();
        QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.BackGroundThread).removeTask(this.f54968f);
        QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.BackGroundThread).post(this.f54968f);
        QLog.d("QZoneFeedxVisitNotifyTopBannerPart", 1, "onDelayShowAfterFeedShow->addVisitNotifyRunnable");
    }

    @Override // com.qzone.reborn.feedx.part.g, com.qzone.reborn.feedx.viewmodel.b
    public void onHandleMessage(Message message) {
        QZoneResult unpack = QZoneResult.unpack(message);
        if (unpack == null || message.what != 1000097) {
            return;
        }
        E9(unpack);
    }

    @Override // com.qzone.reborn.feedx.part.g, com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        super.onInitView(view);
        this.f54966d = (gf.n) getIocInterface(gf.n.class);
        f54964h = System.currentTimeMillis();
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        QLog.d("QZoneFeedxVisitNotifyTopBannerPart", 1, "onPartDestroy");
        QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.BackGroundThread).removeTask(this.f54968f);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartPause(Activity activity) {
        super.onPartPause(activity);
        QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.BackGroundThread).removeTask(this.f54968f);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartResume(Activity activity) {
        super.onPartResume(activity);
        F9();
    }
}
