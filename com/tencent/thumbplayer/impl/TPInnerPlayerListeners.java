package com.tencent.thumbplayer.impl;

import com.tencent.thumbplayer.common.TPGeneralPlayFlowParams;
import com.tencent.thumbplayer.common.log.TPLogUtil;
import com.tencent.thumbplayer.impl.ITPInnerPlayerListener;
import com.tencent.thumbplayer.tpplayer.TPPlayerListeners;

/* loaded from: classes26.dex */
public class TPInnerPlayerListeners extends TPPlayerListeners implements ITPInnerPlayerListener.IOnEventRecordListener {
    private final TPPlayerListenersEmptyImpl mEmptyListeners;
    private ITPInnerPlayerListener.IOnEventRecordListener mOnEventRecordListener;

    /* loaded from: classes26.dex */
    private static class TPPlayerListenersEmptyImpl implements ITPInnerPlayerListener.IOnEventRecordListener {
        private String mTag;

        public TPPlayerListenersEmptyImpl(String str) {
            this.mTag = str;
        }

        @Override // com.tencent.thumbplayer.impl.ITPInnerPlayerListener.IOnEventRecordListener
        public void onDrmInfo(ITPInnerPlayer iTPInnerPlayer, TPGeneralPlayFlowParams.TPPlayerDrmParams tPPlayerDrmParams) {
            TPLogUtil.i(this.mTag, " empty listener , notify , onDrmInfo");
        }
    }

    public TPInnerPlayerListeners(String str) {
        super(str);
        TPPlayerListenersEmptyImpl tPPlayerListenersEmptyImpl = new TPPlayerListenersEmptyImpl(str);
        this.mEmptyListeners = tPPlayerListenersEmptyImpl;
        this.mOnEventRecordListener = tPPlayerListenersEmptyImpl;
    }

    @Override // com.tencent.thumbplayer.tpplayer.TPPlayerListeners
    public void clear() {
        super.clear();
        this.mOnEventRecordListener = this.mEmptyListeners;
    }

    @Override // com.tencent.thumbplayer.impl.ITPInnerPlayerListener.IOnEventRecordListener
    public void onDrmInfo(ITPInnerPlayer iTPInnerPlayer, TPGeneralPlayFlowParams.TPPlayerDrmParams tPPlayerDrmParams) {
        this.mOnEventRecordListener.onDrmInfo(iTPInnerPlayer, tPPlayerDrmParams);
    }

    public void setOnEventRecordListener(ITPInnerPlayerListener.IOnEventRecordListener iOnEventRecordListener) {
        if (iOnEventRecordListener == null) {
            iOnEventRecordListener = this.mEmptyListeners;
        }
        this.mOnEventRecordListener = iOnEventRecordListener;
    }
}
