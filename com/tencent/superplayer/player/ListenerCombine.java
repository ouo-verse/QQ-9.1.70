package com.tencent.superplayer.player;

import com.tencent.superplayer.api.ISuperPlayer;
import com.tencent.superplayer.vinfo.VInfoGetter;
import com.tencent.thumbplayer.api.player.ITPPlayerListener;

/* compiled from: P */
/* loaded from: classes26.dex */
class ListenerCombine {

    /* compiled from: P */
    /* loaded from: classes26.dex */
    interface ISuperPlayerCombine extends ISuperPlayer.OnVideoPreparedListener, ISuperPlayer.OnCompletionListener, ISuperPlayer.OnSeekCompleteListener, ISuperPlayer.OnCaptureImageListener, ISuperPlayer.OnErrorListener, ISuperPlayer.OnInfoListener, ISuperPlayer.OnVideoSizeChangedListener, ISuperPlayer.OnVideoFrameOutputListener, ISuperPlayer.OnAudioFrameOutputListener, ISuperPlayer.OnDefinitionInfoListener, ISuperPlayer.OnTVideoNetInfoListener, ISuperPlayer.OnSubtitleDataListener {
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    interface ITPPlayerCombine extends ITPPlayerListener.IOnPreparedListener, ITPPlayerListener.IOnCompletionListener, ITPPlayerListener.IOnInfoListener, ITPPlayerListener.IOnErrorListener, ITPPlayerListener.IOnSeekCompleteListener, ITPPlayerListener.IOnVideoSizeChangedListener, ITPPlayerListener.IOnVideoFrameOutListener, ITPPlayerListener.IOnAudioFrameOutListener, ITPPlayerListener.IOnSubtitleDataOutListener, ITPPlayerListener.IOnSnapshotListener, VInfoGetter.VInfoGetterListener {
    }

    ListenerCombine() {
    }
}
