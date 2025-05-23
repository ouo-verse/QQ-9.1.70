package com.tencent.ams.mosaic.jsengine.sensor;

import com.tencent.ams.mosaic.jsengine.annotation.JSAgent;

/* compiled from: P */
@JSAgent
/* loaded from: classes3.dex */
public interface MosaicSensor {
    void destroy();

    boolean setSensorEventsDeliveredOnMainThread(boolean z16);

    void start();

    void stop();
}
