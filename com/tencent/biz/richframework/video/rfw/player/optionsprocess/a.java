package com.tencent.biz.richframework.video.rfw.player.optionsprocess;

import com.tencent.biz.richframework.video.rfw.player.RFWPlayerOptions;

/* compiled from: P */
/* loaded from: classes5.dex */
public final /* synthetic */ class a {
    public static String a(IRFWPlayerOptionsProcess iRFWPlayerOptionsProcess, RFWPlayerOptions rFWPlayerOptions) {
        if (rFWPlayerOptions == null) {
            return iRFWPlayerOptionsProcess.getClass().getSimpleName();
        }
        return iRFWPlayerOptionsProcess.getClass().getSimpleName() + "_" + rFWPlayerOptions.tag();
    }
}
