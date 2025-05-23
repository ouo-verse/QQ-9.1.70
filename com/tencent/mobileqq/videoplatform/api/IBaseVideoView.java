package com.tencent.mobileqq.videoplatform.api;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.tencent.superplayer.api.ISuperPlayer;
import com.tencent.thumbplayer.api.optionalparam.TPOptionalParam;
import java.util.List;

/* compiled from: P */
/* loaded from: classes20.dex */
public interface IBaseVideoView {
    void addSubtitleSource(String str, String str2, String str3);

    void captureCurFrame(long j3, int i3, int i16);

    void createMediaPlayer();

    Drawable getCoverDrawable();

    ImageView getCoverImage();

    long getCurPlayingPos();

    long getVideoDurationMs();

    boolean isLocalPlay();

    boolean isMute();

    boolean isPlaying();

    void pause();

    void pauseDownload();

    void play();

    void releasePlayer(boolean z16);

    void resume();

    void resumeDownload();

    void seekTo(int i3);

    void seekTo(int i3, int i16);

    void setCoverDrawable(Drawable drawable);

    void setID(long j3);

    void setMute(boolean z16);

    void setOnSubtitleDataListener(ISuperPlayer.OnSubtitleDataListener onSubtitleDataListener);

    void setPlayerOptionalParamList(List<TPOptionalParam> list);

    void setVideoParam(VideoPlayParam videoPlayParam);

    void showCover(Drawable drawable);
}
