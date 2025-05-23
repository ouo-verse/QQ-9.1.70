package com.tencent.biz.richframework.video.rfw.player.ioc;

import com.tencent.biz.richframework.video.rfw.player.RFWPlayerOptions;

/* loaded from: classes5.dex */
public interface IRFWOptionsProcessCallback {
    void onOptionsFinish(RFWPlayerOptions rFWPlayerOptions, String str);

    void onOptionsStart(RFWPlayerOptions rFWPlayerOptions, String str);
}
