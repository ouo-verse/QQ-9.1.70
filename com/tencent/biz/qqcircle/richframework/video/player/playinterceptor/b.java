package com.tencent.biz.qqcircle.richframework.video.player.playinterceptor;

import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.video.rfw.player.playinterceptor.RFWPlayerBaseInterceptor;
import com.tencent.superplayer.api.ISuperPlayer;
import com.tencent.superplayer.api.SuperPlayerOption;
import uq3.o;

/* compiled from: P */
/* loaded from: classes5.dex */
public class b extends RFWPlayerBaseInterceptor {
    @Override // com.tencent.biz.richframework.video.rfw.player.playinterceptor.RFWPlayerBaseInterceptor
    public void beforeOpenMedia(SuperPlayerOption superPlayerOption, ISuperPlayer iSuperPlayer) {
        boolean X0;
        super.beforeOpenMedia(superPlayerOption, iSuperPlayer);
        if (superPlayerOption != null && superPlayerOption.enabledBluetoothLatencyOptimize != (X0 = o.X0())) {
            superPlayerOption.enabledBluetoothLatencyOptimize = X0;
            RFWLog.d(getTag(), 1, "[beforeOpenMedia] isEnabledBluetoothLatencyOptimize: " + X0);
        }
    }
}
