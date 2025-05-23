package com.tencent.mobileqq.tts;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.qroute.annotation.QRouteFactory;
import com.tencent.mobileqq.tts.silk.a;
import com.tencent.mobileqq.tts.stream.b;
import java.io.InputStream;

@QRouteFactory(singleton = false)
@QAPI(process = {"all"})
/* loaded from: classes19.dex */
public interface ITtsPlayer extends QRouteApi {
    boolean isPlaying();

    void release();

    void setDataStream(InputStream inputStream);

    void setDataStreams(b bVar);

    void setPlayerCallback(a aVar);

    void start();

    void start(int i3);

    void stop();
}
