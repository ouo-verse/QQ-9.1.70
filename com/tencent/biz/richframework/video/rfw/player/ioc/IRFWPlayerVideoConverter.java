package com.tencent.biz.richframework.video.rfw.player.ioc;

import com.tencent.biz.richframework.video.rfw.player.stinfo.RFWStVideo;

/* loaded from: classes5.dex */
public interface IRFWPlayerVideoConverter<T> {
    T convertToBusinessVideo(RFWStVideo rFWStVideo);

    RFWStVideo convertToRFWStVideo(T t16);
}
