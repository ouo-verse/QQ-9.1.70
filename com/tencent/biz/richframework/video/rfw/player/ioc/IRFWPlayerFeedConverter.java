package com.tencent.biz.richframework.video.rfw.player.ioc;

import com.tencent.biz.richframework.video.rfw.player.stinfo.RFWPlayerReportInfo;
import com.tencent.biz.richframework.video.rfw.player.stinfo.RFWStVideo;

/* loaded from: classes5.dex */
public interface IRFWPlayerFeedConverter<T> {
    RFWStVideo convertFeedToStVideo(Object obj);

    RFWPlayerReportInfo<T> convertToReportInfo(T t16);
}
