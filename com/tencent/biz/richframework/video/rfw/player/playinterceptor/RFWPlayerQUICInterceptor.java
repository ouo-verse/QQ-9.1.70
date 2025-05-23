package com.tencent.biz.richframework.video.rfw.player.playinterceptor;

import com.tencent.biz.qqcircle.QCircleSchemeAttr;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.video.rfw.RFWPlayer;
import com.tencent.biz.richframework.video.rfw.player.RFWPlayerOptions;
import com.tencent.biz.richframework.video.rfw.player.playinterceptor.controller.RFWBaseInterceptorController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.superplayer.api.ISuperPlayer;
import com.tencent.superplayer.api.SuperPlayerOption;

/* loaded from: classes5.dex */
public class RFWPlayerQUICInterceptor extends RFWPlayerBaseInterceptor {
    public RFWPlayerQUICInterceptor(RFWBaseInterceptorController rFWBaseInterceptorController) {
        super(rFWBaseInterceptorController);
    }

    private boolean isQUIC(RFWPlayerOptions rFWPlayerOptions) {
        boolean z16 = false;
        if (rFWPlayerOptions.isVideo() && rFWPlayerOptions.getStVideo() != null) {
            if (rFWPlayerOptions.getStVideo().isQuic() != 0) {
                z16 = true;
            }
            QLog.w(getTag(), 1, "isQUIC()\uff1a" + z16 + "|" + rFWPlayerOptions.getStVideo().isQuic());
        }
        return z16;
    }

    @Override // com.tencent.biz.richframework.video.rfw.player.playinterceptor.RFWPlayerBaseInterceptor
    public void beforeOpenMedia(SuperPlayerOption superPlayerOption, ISuperPlayer iSuperPlayer) {
        RFWPlayer rFWPlayer = this.mPlayer;
        if (rFWPlayer != null && rFWPlayer.getRFWPlayerOptions() != null && superPlayerOption != null && iSuperPlayer != null) {
            if (isQUIC(this.mPlayer.getRFWPlayerOptions())) {
                superPlayerOption.superPlayerDownOption.quicEnableMode = 2;
                report(QCircleSchemeAttr.Detail.IS_QUIC, null);
                RFWLog.d(getTag(), RFWLog.USR, "beforeOpenMedia us isQUIC: true ");
                return;
            }
            RFWLog.d(getTag(), RFWLog.USR, "beforeOpenMedia us isQUIC: false ");
        }
    }
}
