package com.tencent.mobileqq.music.api.impl;

import android.content.Context;
import com.tencent.mobileqq.music.QQPlayerService;
import com.tencent.mobileqq.music.SongInfo;
import com.tencent.mobileqq.music.api.IQQPlayer;
import com.tencent.mobileqq.music.g;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* loaded from: classes15.dex */
public class QQPlayerImpl extends IQQPlayer {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "QQPlayerImpl";

    public QQPlayerImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.music.api.IQQPlayer
    public void addCallback(g gVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this, (Object) gVar);
        } else {
            QQPlayerService.R(gVar);
        }
    }

    @Override // com.tencent.mobileqq.music.api.IQQPlayer
    public String generateToken(int i3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            return (String) iPatchRedirector.redirect((short) 28, (Object) this, i3, (Object) str);
        }
        return QQPlayerService.Y(i3, str);
    }

    @Override // com.tencent.mobileqq.music.api.IQQPlayer
    public int getCurrentPlayPosition() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return ((Integer) iPatchRedirector.redirect((short) 24, (Object) this)).intValue();
        }
        return QQPlayerService.a0();
    }

    @Override // com.tencent.mobileqq.music.api.IQQPlayer
    public SongInfo getCurrentSong() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return (SongInfo) iPatchRedirector.redirect((short) 21, (Object) this);
        }
        return QQPlayerService.b0();
    }

    @Override // com.tencent.mobileqq.music.api.IQQPlayer
    public int getDuration() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return ((Integer) iPatchRedirector.redirect((short) 23, (Object) this)).intValue();
        }
        return QQPlayerService.e0();
    }

    @Override // com.tencent.mobileqq.music.api.IQQPlayer
    public SongInfo getNextPlaySong() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            return (SongInfo) iPatchRedirector.redirect((short) 30, (Object) this);
        }
        return QQPlayerService.g0();
    }

    @Override // com.tencent.mobileqq.music.api.IQQPlayer
    public SongInfo getNextSong() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return (SongInfo) iPatchRedirector.redirect((short) 22, (Object) this);
        }
        return QQPlayerService.h0();
    }

    @Override // com.tencent.mobileqq.music.api.IQQPlayer
    public SongInfo[] getPlayList() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return (SongInfo[]) iPatchRedirector.redirect((short) 19, (Object) this);
        }
        return QQPlayerService.j0();
    }

    @Override // com.tencent.mobileqq.music.api.IQQPlayer
    public int getPlayListCount() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return ((Integer) iPatchRedirector.redirect((short) 20, (Object) this)).intValue();
        }
        return QQPlayerService.k0();
    }

    @Override // com.tencent.mobileqq.music.api.IQQPlayer
    public int getPlayMode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return ((Integer) iPatchRedirector.redirect((short) 18, (Object) this)).intValue();
        }
        return QQPlayerService.l0();
    }

    @Override // com.tencent.mobileqq.music.api.IQQPlayer
    public int getPlayState() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Integer) iPatchRedirector.redirect((short) 16, (Object) this)).intValue();
        }
        return QQPlayerService.m0();
    }

    @Override // com.tencent.mobileqq.music.api.IQQPlayer
    public String getToken() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            return (String) iPatchRedirector.redirect((short) 27, (Object) this);
        }
        return QQPlayerService.o0();
    }

    @Override // com.tencent.mobileqq.music.api.IQQPlayer
    public boolean isMusicFileValid(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            return ((Boolean) iPatchRedirector.redirect((short) 31, (Object) this, (Object) str)).booleanValue();
        }
        return QQPlayerService.r0(str);
    }

    @Override // com.tencent.mobileqq.music.api.IQQPlayer
    public boolean isPlaying() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Boolean) iPatchRedirector.redirect((short) 15, (Object) this)).booleanValue();
        }
        return QQPlayerService.s0();
    }

    @Override // com.tencent.mobileqq.music.api.IQQPlayer
    public boolean isPlayingMySong(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            return ((Boolean) iPatchRedirector.redirect((short) 29, (Object) this, (Object) str)).booleanValue();
        }
        return QQPlayerService.u0(str);
    }

    @Override // com.tencent.mobileqq.music.api.IQQPlayer
    public void pausePlayMusic(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) context);
        } else {
            QQPlayerService.K0(context);
        }
    }

    @Override // com.tencent.mobileqq.music.api.IQQPlayer
    public SongInfo pickNextSong() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (SongInfo) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return QQPlayerService.L0();
    }

    @Override // com.tencent.mobileqq.music.api.IQQPlayer
    public boolean playNext(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this, (Object) context)).booleanValue();
        }
        return QQPlayerService.N0(context);
    }

    @Override // com.tencent.mobileqq.music.api.IQQPlayer
    public boolean playPrev(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this, (Object) context)).booleanValue();
        }
        return QQPlayerService.O0(context);
    }

    @Override // com.tencent.mobileqq.music.api.IQQPlayer
    public void removeCallback(g gVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this, (Object) gVar);
        } else {
            QQPlayerService.S0(gVar);
        }
    }

    @Override // com.tencent.mobileqq.music.api.IQQPlayer
    public void resumePlayMusic(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 12)) {
            QQPlayerService.U0(context);
        } else {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) context);
        }
    }

    @Override // com.tencent.mobileqq.music.api.IQQPlayer
    public void setPlayMode(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, i3);
        } else {
            QQPlayerService.c1(i3);
        }
    }

    @Override // com.tencent.mobileqq.music.api.IQQPlayer
    public void setSongList(SongInfo[] songInfoArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) {
            QQPlayerService.d1(songInfoArr);
        } else {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) songInfoArr);
        }
    }

    @Override // com.tencent.mobileqq.music.api.IQQPlayer
    public void startPlayMusic(Context context, String str, SongInfo[] songInfoArr, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            QQPlayerService.j1(context, str, songInfoArr, i3);
        } else {
            iPatchRedirector.redirect((short) 3, this, context, str, songInfoArr, Integer.valueOf(i3));
        }
    }

    @Override // com.tencent.mobileqq.music.api.IQQPlayer
    public void startPlaySingleSong(Context context, String str, SongInfo songInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, context, str, songInfo);
        } else {
            QQPlayerService.l1(context, str, songInfo);
        }
    }

    @Override // com.tencent.mobileqq.music.api.IQQPlayer
    public void stopPlayMusic(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) context);
        } else {
            QQPlayerService.m1(context);
        }
    }

    @Override // com.tencent.mobileqq.music.api.IQQPlayer
    public void resumePlayMusic(Context context, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 13)) {
            QQPlayerService.V0(context, z16);
        } else {
            iPatchRedirector.redirect((short) 13, this, context, Boolean.valueOf(z16));
        }
    }

    @Override // com.tencent.mobileqq.music.api.IQQPlayer
    public void setSongList(SongInfo[] songInfoArr, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 7)) {
            QQPlayerService.e1(songInfoArr, i3, i16);
        } else {
            iPatchRedirector.redirect((short) 7, this, songInfoArr, Integer.valueOf(i3), Integer.valueOf(i16));
        }
    }

    @Override // com.tencent.mobileqq.music.api.IQQPlayer
    public void startPlayMusic(Context context, String str, SongInfo[] songInfoArr, int i3, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
            QQPlayerService.k1(context, str, songInfoArr, i3, z16);
        } else {
            iPatchRedirector.redirect((short) 4, this, context, str, songInfoArr, Integer.valueOf(i3), Boolean.valueOf(z16));
        }
    }

    @Override // com.tencent.mobileqq.music.api.IQQPlayer
    public void startPlayMusic(Context context, String str, SongInfo[] songInfoArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
            QQPlayerService.i1(context, str, songInfoArr);
        } else {
            iPatchRedirector.redirect((short) 5, this, context, str, songInfoArr);
        }
    }
}
