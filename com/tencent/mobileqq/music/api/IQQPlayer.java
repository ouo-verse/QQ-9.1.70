package com.tencent.mobileqq.music.api;

import android.content.Context;
import com.tencent.mobileqq.music.SongInfo;
import com.tencent.mobileqq.music.g;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process = {"all"})
/* loaded from: classes15.dex */
public abstract class IQQPlayer implements QRouteApi {
    static IPatchRedirector $redirector_;

    public IQQPlayer() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public abstract void addCallback(g gVar);

    public abstract String generateToken(int i3, String str);

    public abstract int getCurrentPlayPosition();

    public abstract SongInfo getCurrentSong();

    public abstract int getDuration();

    public abstract SongInfo getNextPlaySong();

    public abstract SongInfo getNextSong();

    public abstract SongInfo[] getPlayList();

    public abstract int getPlayListCount();

    public abstract int getPlayMode();

    public abstract int getPlayState();

    public abstract String getToken();

    public abstract boolean isMusicFileValid(String str);

    public abstract boolean isPlaying();

    public abstract boolean isPlayingMySong(String str);

    public abstract void pausePlayMusic(Context context);

    public abstract SongInfo pickNextSong();

    public abstract boolean playNext(Context context);

    public abstract boolean playPrev(Context context);

    public abstract void removeCallback(g gVar);

    public abstract void resumePlayMusic(Context context);

    public abstract void resumePlayMusic(Context context, boolean z16);

    public abstract void setPlayMode(int i3);

    public abstract void setSongList(SongInfo[] songInfoArr);

    public abstract void setSongList(SongInfo[] songInfoArr, int i3, int i16);

    public abstract void startPlayMusic(Context context, String str, SongInfo[] songInfoArr);

    public abstract void startPlayMusic(Context context, String str, SongInfo[] songInfoArr, int i3);

    public abstract void startPlayMusic(Context context, String str, SongInfo[] songInfoArr, int i3, boolean z16);

    public abstract void startPlaySingleSong(Context context, String str, SongInfo songInfo);

    public abstract void stopPlayMusic(Context context);
}
