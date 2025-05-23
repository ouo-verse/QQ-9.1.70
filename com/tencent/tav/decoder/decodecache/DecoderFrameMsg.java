package com.tencent.tav.decoder.decodecache;

import com.tencent.tav.coremedia.CMTime;
import java.util.concurrent.CountDownLatch;

/* compiled from: P */
/* loaded from: classes26.dex */
class DecoderFrameMsg {
    final CountDownLatch finishWait;
    final CMTime time;

    /* JADX INFO: Access modifiers changed from: package-private */
    public DecoderFrameMsg(CMTime cMTime, CountDownLatch countDownLatch) {
        this.time = cMTime;
        this.finishWait = countDownLatch;
    }
}
