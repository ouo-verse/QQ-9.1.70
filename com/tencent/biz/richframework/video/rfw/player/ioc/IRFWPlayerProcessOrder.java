package com.tencent.biz.richframework.video.rfw.player.ioc;

import com.tencent.biz.richframework.video.rfw.player.videopreload.RFWVideoPreloadBean;
import java.util.LinkedList;

/* loaded from: classes5.dex */
public interface IRFWPlayerProcessOrder {
    LinkedList<String> getPlayFormalOrder();

    LinkedList<String> getPreloadVideoOrder(RFWVideoPreloadBean rFWVideoPreloadBean, String str);
}
