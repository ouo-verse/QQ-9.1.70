package com.tencent.superplayer.player;

import android.graphics.Bitmap;
import com.tencent.superplayer.api.ISuperPlayer;
import com.tencent.superplayer.api.TVideoNetInfo;
import com.tencent.superplayer.player.ListenerCombine;
import com.tencent.superplayer.utils.LogUtil;
import com.tencent.thumbplayer.api.common.TPAudioFrameBuffer;
import com.tencent.thumbplayer.api.common.TPSubtitleData;
import com.tencent.thumbplayer.api.common.TPVideoFrameBuffer;
import java.util.ArrayList;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes26.dex */
public class SuperPlayerListenerMgr implements ListenerCombine.ISuperPlayerCombine {
    private static final String FILENAME = "SuperPlayerListenerMgr.java";
    private static final int[] FILTER_LOG_INFO_MSG = {126, 0, 205, 251, 204, 203, 250};
    private String mTag;
    private ISuperPlayer.OnAudioFrameOutputListener mOnAudioFrameOutputListener = null;
    private ISuperPlayer.OnCaptureImageListener mOnCaptureImageListener = null;
    private ISuperPlayer.OnCompletionListener mOnCompletionListener = null;
    private ISuperPlayer.OnDefinitionInfoListener mOnDefinitionInfoListener = null;
    private ISuperPlayer.OnErrorListener mOnErrorListener = null;
    private ISuperPlayer.OnInfoListener mOnInfoListener = null;
    private ISuperPlayer.OnSeekCompleteListener mOnSeekCompleteListener = null;
    private ISuperPlayer.OnVideoFrameOutputListener mOnVideoFrameOutputListener = null;
    private ISuperPlayer.OnVideoPreparedListener mOnVideoPreparedListener = null;
    private ISuperPlayer.OnVideoSizeChangedListener mOnVideoSizeChangedListener = null;
    private ISuperPlayer.OnTVideoNetInfoListener mOnTVideoNetInfoListener = null;
    private ISuperPlayer.OnSubtitleDataListener mOnSubtitleDataListener = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SuperPlayerListenerMgr(String str) {
        this.mTag = str + "-" + FILENAME;
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer.OnAudioFrameOutputListener
    public void onAudioFrameOutput(TPAudioFrameBuffer tPAudioFrameBuffer) {
        ISuperPlayer.OnAudioFrameOutputListener onAudioFrameOutputListener = this.mOnAudioFrameOutputListener;
        if (onAudioFrameOutputListener != null) {
            onAudioFrameOutputListener.onAudioFrameOutput(tPAudioFrameBuffer);
        }
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer.OnCaptureImageListener
    public void onCaptureImageFailed(ISuperPlayer iSuperPlayer, int i3, int i16) {
        ISuperPlayer.OnCaptureImageListener onCaptureImageListener = this.mOnCaptureImageListener;
        if (onCaptureImageListener != null) {
            onCaptureImageListener.onCaptureImageFailed(iSuperPlayer, i3, i16);
        }
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer.OnCaptureImageListener
    public void onCaptureImageSucceed(ISuperPlayer iSuperPlayer, int i3, int i16, int i17, Bitmap bitmap) {
        ISuperPlayer.OnCaptureImageListener onCaptureImageListener = this.mOnCaptureImageListener;
        if (onCaptureImageListener != null) {
            onCaptureImageListener.onCaptureImageSucceed(iSuperPlayer, i3, i16, i17, bitmap);
        }
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer.OnCompletionListener
    public void onCompletion(ISuperPlayer iSuperPlayer) {
        ISuperPlayer.OnCompletionListener onCompletionListener = this.mOnCompletionListener;
        if (onCompletionListener != null) {
            LogUtil.i(this.mTag, "notify : video completion");
            onCompletionListener.onCompletion(iSuperPlayer);
        }
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer.OnDefinitionInfoListener
    public void onDefinitionInfoUpdate(ISuperPlayer iSuperPlayer, String str, ArrayList<String> arrayList) {
        ISuperPlayer.OnDefinitionInfoListener onDefinitionInfoListener = this.mOnDefinitionInfoListener;
        if (onDefinitionInfoListener != null) {
            LogUtil.i(this.mTag, "notify : onDefinitionInfoUpdate currentDefinition:" + str + ", definitionList.size():" + arrayList.size());
            onDefinitionInfoListener.onDefinitionInfoUpdate(iSuperPlayer, str, arrayList);
        }
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer.OnErrorListener
    public boolean onError(ISuperPlayer iSuperPlayer, int i3, int i16, int i17, String str) {
        ISuperPlayer.OnErrorListener onErrorListener = this.mOnErrorListener;
        if (onErrorListener != null) {
            LogUtil.e(this.mTag, "notify : on error, module:" + i3 + ", errorType:" + i16 + ", errorCode:" + i17 + ", extraInfo:" + str);
            return onErrorListener.onError(iSuperPlayer, i3, i16, i17, str);
        }
        return false;
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer.OnInfoListener
    public boolean onInfo(ISuperPlayer iSuperPlayer, int i3, long j3, long j16, Object obj) {
        ISuperPlayer.OnInfoListener onInfoListener = this.mOnInfoListener;
        boolean z16 = false;
        if (onInfoListener == null) {
            return false;
        }
        int[] iArr = FILTER_LOG_INFO_MSG;
        int length = iArr.length;
        int i16 = 0;
        while (true) {
            if (i16 >= length) {
                break;
            }
            if (iArr[i16] == i3) {
                z16 = true;
                break;
            }
            i16++;
        }
        if (!z16) {
            LogUtil.i(this.mTag, "notify : on info  , cmd : " + i3);
        }
        return onInfoListener.onInfo(iSuperPlayer, i3, j3, j16, obj);
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer.OnSeekCompleteListener
    public void onSeekComplete(ISuperPlayer iSuperPlayer) {
        ISuperPlayer.OnSeekCompleteListener onSeekCompleteListener = this.mOnSeekCompleteListener;
        if (onSeekCompleteListener != null) {
            LogUtil.i(this.mTag, "notify : video onSeekComplete");
            onSeekCompleteListener.onSeekComplete(iSuperPlayer);
        }
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer.OnSubtitleDataListener
    public void onSubtitleData(ISuperPlayer iSuperPlayer, TPSubtitleData tPSubtitleData) {
        ISuperPlayer.OnSubtitleDataListener onSubtitleDataListener = this.mOnSubtitleDataListener;
        if (onSubtitleDataListener != null) {
            onSubtitleDataListener.onSubtitleData(iSuperPlayer, tPSubtitleData);
        }
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer.OnTVideoNetInfoListener
    public void onTVideoNetInfoUpdate(ISuperPlayer iSuperPlayer, TVideoNetInfo tVideoNetInfo) {
        ISuperPlayer.OnTVideoNetInfoListener onTVideoNetInfoListener = this.mOnTVideoNetInfoListener;
        if (onTVideoNetInfoListener != null) {
            LogUtil.i(this.mTag, "notify : onTVideoNetInfoUpdate");
            onTVideoNetInfoListener.onTVideoNetInfoUpdate(iSuperPlayer, tVideoNetInfo);
        }
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer.OnVideoFrameOutputListener
    public void onVideoFrameOutput(TPVideoFrameBuffer tPVideoFrameBuffer) {
        ISuperPlayer.OnVideoFrameOutputListener onVideoFrameOutputListener = this.mOnVideoFrameOutputListener;
        if (onVideoFrameOutputListener != null) {
            onVideoFrameOutputListener.onVideoFrameOutput(tPVideoFrameBuffer);
        }
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer.OnVideoPreparedListener
    public void onVideoPrepared(ISuperPlayer iSuperPlayer) {
        ISuperPlayer.OnVideoPreparedListener onVideoPreparedListener = this.mOnVideoPreparedListener;
        if (onVideoPreparedListener != null) {
            LogUtil.i(this.mTag, "notify : video prepared");
            onVideoPreparedListener.onVideoPrepared(iSuperPlayer);
        }
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer.OnVideoSizeChangedListener
    public void onVideoSizeChanged(ISuperPlayer iSuperPlayer, int i3, int i16) {
        ISuperPlayer.OnVideoSizeChangedListener onVideoSizeChangedListener = this.mOnVideoSizeChangedListener;
        if (onVideoSizeChangedListener != null) {
            LogUtil.i(this.mTag, "onVideoSizeChanged : width\uff1a" + i3 + ", height:" + i16);
            onVideoSizeChangedListener.onVideoSizeChanged(iSuperPlayer, i3, i16);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void release() {
        this.mOnAudioFrameOutputListener = null;
        this.mOnCaptureImageListener = null;
        this.mOnCompletionListener = null;
        this.mOnDefinitionInfoListener = null;
        this.mOnErrorListener = null;
        this.mOnInfoListener = null;
        this.mOnSeekCompleteListener = null;
        this.mOnVideoFrameOutputListener = null;
        this.mOnVideoPreparedListener = null;
        this.mOnVideoSizeChangedListener = null;
        this.mOnTVideoNetInfoListener = null;
        this.mOnSubtitleDataListener = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setOnAudioFrameOutputListener(ISuperPlayer.OnAudioFrameOutputListener onAudioFrameOutputListener) {
        this.mOnAudioFrameOutputListener = onAudioFrameOutputListener;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setOnCaptureImageListener(ISuperPlayer.OnCaptureImageListener onCaptureImageListener) {
        this.mOnCaptureImageListener = onCaptureImageListener;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setOnCompletionListener(ISuperPlayer.OnCompletionListener onCompletionListener) {
        this.mOnCompletionListener = onCompletionListener;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setOnDefinitionInfoListener(ISuperPlayer.OnDefinitionInfoListener onDefinitionInfoListener) {
        this.mOnDefinitionInfoListener = onDefinitionInfoListener;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setOnErrorListener(ISuperPlayer.OnErrorListener onErrorListener) {
        this.mOnErrorListener = onErrorListener;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setOnInfoListener(ISuperPlayer.OnInfoListener onInfoListener) {
        this.mOnInfoListener = onInfoListener;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setOnSeekCompleteListener(ISuperPlayer.OnSeekCompleteListener onSeekCompleteListener) {
        this.mOnSeekCompleteListener = onSeekCompleteListener;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setOnSubtitleDataListener(ISuperPlayer.OnSubtitleDataListener onSubtitleDataListener) {
        this.mOnSubtitleDataListener = onSubtitleDataListener;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setOnTVideoNetVideoInfoListener(ISuperPlayer.OnTVideoNetInfoListener onTVideoNetInfoListener) {
        this.mOnTVideoNetInfoListener = onTVideoNetInfoListener;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setOnVideoOutputFrameListener(ISuperPlayer.OnVideoFrameOutputListener onVideoFrameOutputListener) {
        this.mOnVideoFrameOutputListener = onVideoFrameOutputListener;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setOnVideoPreparedListener(ISuperPlayer.OnVideoPreparedListener onVideoPreparedListener) {
        this.mOnVideoPreparedListener = onVideoPreparedListener;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setOnVideoSizeChangedListener(ISuperPlayer.OnVideoSizeChangedListener onVideoSizeChangedListener) {
        this.mOnVideoSizeChangedListener = onVideoSizeChangedListener;
    }

    public void updatePlayerTag(String str) {
        this.mTag = str + "-" + FILENAME;
    }
}
