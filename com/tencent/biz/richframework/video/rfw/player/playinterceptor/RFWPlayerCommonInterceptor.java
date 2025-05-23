package com.tencent.biz.richframework.video.rfw.player.playinterceptor;

import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.video.rfw.RFWPlayer;
import com.tencent.biz.richframework.video.rfw.RFWVideoUtils;
import com.tencent.biz.richframework.video.rfw.player.playinterceptor.controller.RFWBaseInterceptorController;
import com.tencent.biz.richframework.video.rfw.player.strategy.RFWPlayerAV1DecodeStrategyV2;
import com.tencent.mobileqq.qqvideoplatform.api.QQVideoPlaySDKManager;
import com.tencent.superplayer.api.ISuperPlayer;
import com.tencent.superplayer.api.SuperPlayerOption;
import com.tencent.superplayer.player.SuperPlayerMgr;
import com.tencent.thumbplayer.api.optionalparam.TPOptionalID;
import com.tencent.thumbplayer.api.optionalparam.TPOptionalParam;
import com.tencent.thumbplayer.api.player.TPPlayerConstructParams;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import uq3.o;

/* loaded from: classes5.dex */
public class RFWPlayerCommonInterceptor extends RFWPlayerBaseInterceptor {
    public RFWPlayerCommonInterceptor(RFWBaseInterceptorController rFWBaseInterceptorController) {
        super(rFWBaseInterceptorController);
    }

    private void addAV1MediaCodecParam(List<TPOptionalParam> list, ISuperPlayer iSuperPlayer) {
        if (list != null && iSuperPlayer != null && getOptions() != null && RFWPlayerAV1DecodeStrategyV2.g().enableAV1MediaCodec() && RFWVideoUtils.isAV1(getOptions().getRealPlayBean())) {
            list.add(TPOptionalParam.buildQueueInt(TPOptionalID.OPTIONAL_ID_BEFORE_QUEUE_INT_VIDEO_DECODER_TYPE, new int[]{102, 101}));
            RFWLog.d(getTag(), RFWLog.USR, "use av1 mediaCodec");
        }
    }

    private void addAdaptiveParam(List<TPOptionalParam> list, ISuperPlayer iSuperPlayer) {
        if (list == null || iSuperPlayer == null || !o.v()) {
            return;
        }
        list.add(TPOptionalParam.buildBoolean(TPOptionalID.OPTIONAL_ID_BEFORE_BOOL_ENABLE_VIDEO_ADAPTIVE_FRAMERATE, true));
        RFWLog.d(getTag(), RFWLog.USR, "use adapter frame param");
    }

    private void checkSystemPlayerOpt(ISuperPlayer iSuperPlayer) {
        if (!getOptions().forceSystemPlayer()) {
            ArrayList arrayList = new ArrayList();
            addAdaptiveParam(arrayList, iSuperPlayer);
            addAV1MediaCodecParam(arrayList, iSuperPlayer);
            arrayList.add(TPOptionalParam.buildQueueInt(TPPlayerConstructParams.CONSTRUCT_ID_QUEUE_INT_CORE_TYPE, new int[]{2, 1}));
            iSuperPlayer.setPlayerOptionalParamList(arrayList);
            RFWLog.d(getTag(), RFWLog.USR, "use thumb player first");
            return;
        }
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(TPOptionalParam.buildQueueInt(TPPlayerConstructParams.CONSTRUCT_ID_QUEUE_INT_CORE_TYPE, new int[]{1}));
        iSuperPlayer.setPlayerOptionalParamList(arrayList2);
        RFWLog.d(getTag(), RFWLog.USR, "use system player");
    }

    @Override // com.tencent.biz.richframework.video.rfw.player.playinterceptor.RFWPlayerBaseInterceptor
    public void afterOpenMedia(SuperPlayerOption superPlayerOption, ISuperPlayer iSuperPlayer) {
        super.afterOpenMedia(superPlayerOption, iSuperPlayer);
        if (iSuperPlayer instanceof SuperPlayerMgr) {
            try {
                Method declaredMethod = SuperPlayerMgr.class.getDeclaredMethod("getPlayerTag", new Class[0]);
                declaredMethod.setAccessible(true);
                String str = (String) declaredMethod.invoke(iSuperPlayer, new Object[0]);
                RFWLog.d(getTag(), RFWLog.USR, "superPlayerTag:SuperPlayer-" + str);
            } catch (Exception e16) {
                RFWLog.d(getTag(), RFWLog.USR, e16);
            }
        }
    }

    @Override // com.tencent.biz.richframework.video.rfw.player.playinterceptor.RFWPlayerBaseInterceptor
    public void beforeOpenMedia(SuperPlayerOption superPlayerOption, ISuperPlayer iSuperPlayer) {
        int R2;
        super.beforeOpenMedia(superPlayerOption, iSuperPlayer);
        if (superPlayerOption == null) {
            RFWLog.d(getTag(), RFWLog.USR, "superPlayerOption is empty");
            return;
        }
        QQVideoPlaySDKManager.addVideoHwCodecBlackList(1029);
        boolean a06 = uq3.c.a0();
        superPlayerOption.enableCodecReuse = a06;
        superPlayerOption.prepareTimeoutMs = uq3.c.U2();
        superPlayerOption.bufferTimeoutMs = uq3.c.N0();
        RFWLog.d(getTag(), RFWLog.USR, "[beforeOpenMedia] prepareTimeoutMs: " + superPlayerOption.prepareTimeoutMs + " | bufferTimeoutMs: " + superPlayerOption.bufferTimeoutMs);
        superPlayerOption.tpCoreSampleRate = (double) uq3.c.w4();
        superPlayerOption.disableSuperSample = this.mPlayerOptions.isDisableSuperSample();
        if (uq3.c.S5()) {
            if (this.mPlayerOptions.isLocalVideo()) {
                R2 = uq3.c.k2();
            } else {
                R2 = uq3.c.R2();
            }
            superPlayerOption.bufferPacketMinTotalDurationMs = R2;
            superPlayerOption.enableListenerPlayerBuffer = true;
        }
        superPlayerOption.notifyPreparedPlayMsgAhead = true;
        checkSystemPlayerOpt(iSuperPlayer);
        RFWLog.d(getTag(), RFWLog.USR, "[beforeOpenMedia] reUse Player Decoder:" + a06 + " | prepareTimeoutMs:" + superPlayerOption.prepareTimeoutMs + " | bufferTimeoutMs:" + superPlayerOption.bufferTimeoutMs + " | tpCoreSampleRate:" + superPlayerOption.tpCoreSampleRate);
    }

    @Override // com.tencent.biz.richframework.video.rfw.player.playinterceptor.RFWPlayerBaseInterceptor
    public boolean onError(ISuperPlayer iSuperPlayer, int i3, int i16, int i17, String str) {
        if (!RFWVideoUtils.isSpecialError(i17)) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.biz.richframework.video.rfw.player.playinterceptor.RFWPlayerBaseInterceptor
    public void onStart() {
        super.onStart();
        RFWPlayer rFWPlayer = this.mPlayer;
        if (rFWPlayer != null && rFWPlayer.getRealPlayer() != null) {
            this.mPlayer.setPlayerActive();
        }
    }

    @Override // com.tencent.biz.richframework.video.rfw.player.playinterceptor.RFWPlayerBaseInterceptor
    public void onVideoPrepare() {
        super.onVideoPrepare();
    }
}
