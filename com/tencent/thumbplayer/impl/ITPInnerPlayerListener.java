package com.tencent.thumbplayer.impl;

import com.tencent.thumbplayer.api.player.ITPPlayerListener;
import com.tencent.thumbplayer.common.TPGeneralPlayFlowParams;

/* loaded from: classes26.dex */
public interface ITPInnerPlayerListener extends ITPPlayerListener {

    /* loaded from: classes26.dex */
    public interface IOnEventRecordListener {
        void onDrmInfo(ITPInnerPlayer iTPInnerPlayer, TPGeneralPlayFlowParams.TPPlayerDrmParams tPPlayerDrmParams);
    }
}
