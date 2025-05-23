package com.qzone.reborn.feedx.part;

import android.app.Activity;
import android.view.View;
import com.qzone.app.QZoneFeedAlertService;
import com.qzone.common.business.result.QZoneResult;
import common.config.service.QZoneConfigHelper;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import cooperation.qzone.util.QZLog;
import java.lang.ref.WeakReference;

/* loaded from: classes37.dex */
public class QZoneFeedxUndealCountPart extends g {

    /* renamed from: e, reason: collision with root package name */
    private static long f54960e;

    /* renamed from: d, reason: collision with root package name */
    private final AlterLoopTimerTask f54961d = new AlterLoopTimerTask(this);

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes37.dex */
    public static final class AlterLoopTimerTask implements Runnable {

        /* renamed from: e, reason: collision with root package name */
        static int f54962e;

        /* renamed from: d, reason: collision with root package name */
        private final WeakReference<g> f54963d;

        public AlterLoopTimerTask(g gVar) {
            this.f54963d = new WeakReference<>(gVar);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f54963d.get() == null) {
                QZLog.e("QZoneFeedxUndealCountPart", 1, "[run] current qzone friend feed should not be null.");
                return;
            }
            QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.BackGroundThread).postDelayed(this, QZoneConfigHelper.f390035a);
            QZoneFeedAlertService.getInstance().getFeedAlert(this.f54963d.get().getMainHandler(), 11);
            f54962e++;
        }
    }

    private void D9() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - f54960e >= QZoneConfigHelper.f390035a) {
            QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.BackGroundThread).removeTask(this.f54961d);
            QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.BackGroundThread).post(this.f54961d);
            f54960e = currentTimeMillis;
        } else {
            QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.BackGroundThread).removeTask(this.f54961d);
            QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.BackGroundThread).postDelayed(this.f54961d, QZoneConfigHelper.f390035a);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QZoneFeedxUndealCountPart";
    }

    @Override // com.qzone.reborn.feedx.part.g, com.qzone.reborn.feedx.viewmodel.b
    public void i5(QZoneResult qZoneResult) {
        super.i5(qZoneResult);
        QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.BackGroundThread).removeTask(this.f54961d);
        QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.BackGroundThread).post(this.f54961d);
    }

    @Override // com.qzone.reborn.feedx.part.g, com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        super.onInitView(view);
        f54960e = System.currentTimeMillis();
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.BackGroundThread).removeTask(this.f54961d);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartPause(Activity activity) {
        super.onPartPause(activity);
        QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.BackGroundThread).removeTask(this.f54961d);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartResume(Activity activity) {
        super.onPartResume(activity);
        D9();
    }
}
