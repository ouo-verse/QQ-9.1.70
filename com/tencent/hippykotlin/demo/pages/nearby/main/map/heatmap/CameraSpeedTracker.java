package com.tencent.hippykotlin.demo.pages.nearby.main.map.heatmap;

import com.tencent.hippykotlin.demo.pages.nearby.base.data.NBPLatLng;
import com.tencent.hippykotlin.demo.pages.nearby.base.tech_reporter.APICallTechReporterKt;
import com.tencent.hippykotlin.demo.pages.nearby.base.view.CameraPosition;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.kuikly.core.timer.TimerKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class CameraSpeedTracker {
    public CameraPosition curCamera;
    public NBPLatLng lastPos = new NBPLatLng(0.0d, 0.0d, 3, null);
    public long lastTime;
    public final Function1<CameraPosition, Unit> onSlowDown;
    public boolean running;
    public final float screenHeight;
    public final float screenWidth;
    public String timeoutHandle;

    /* JADX WARN: Multi-variable type inference failed */
    public CameraSpeedTracker(float f16, float f17, Function1<? super CameraPosition, Unit> function1) {
        this.screenWidth = f16;
        this.screenHeight = f17;
        this.onSlowDown = function1;
    }

    public final void reset() {
        String str = this.timeoutHandle;
        if (str != null) {
            TimerKt.b(str);
        }
        this.running = false;
        this.lastTime = 0L;
        this.curCamera = null;
    }

    public final void runLoop() {
        CameraPosition cameraPosition;
        if (this.running) {
            this.timeoutHandle = TimerKt.d(200, new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.heatmap.CameraSpeedTracker$runLoop$1
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final Unit invoke() {
                    CameraSpeedTracker.this.runLoop();
                    return Unit.INSTANCE;
                }
            });
            if (this.lastTime == 0 || (cameraPosition = this.curCamera) == null) {
                return;
            }
            NBPLatLng nBPLatLng = cameraPosition.topLeftPosition;
            long NBPCurrentTime = APICallTechReporterKt.NBPCurrentTime();
            long j3 = NBPCurrentTime - this.lastTime;
            NBPLatLng nBPLatLng2 = this.lastPos;
            double distanceToLeftTop = (1000.0d / j3) * CameraSpeedTrackerKt.getDistanceToLeftTop(this.screenWidth, this.screenHeight, nBPLatLng2.latitude, nBPLatLng2.longitude, cameraPosition);
            KLog.INSTANCE.i("CameraSpeedTracker", "speed=" + distanceToLeftTop);
            if (distanceToLeftTop < 10.0d) {
                this.onSlowDown.invoke(cameraPosition);
            }
            this.lastTime = NBPCurrentTime;
            this.lastPos = nBPLatLng;
        }
    }
}
