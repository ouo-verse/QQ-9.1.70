package com.tencent.qqmini.proxyimpl;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import com.tencent.mobileqq.music.QQPlayerService;
import com.tencent.mobileqq.music.SongInfo;
import com.tencent.mobileqq.music.c;
import com.tencent.mobileqq.music.e;
import com.tencent.mobileqq.musicgene.MusicPlayerActivity;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.annotation.ProxyService;
import com.tencent.qqmini.sdk.launcher.core.proxy.MusicPlayerProxy;

/* compiled from: P */
@ProxyService(proxy = MusicPlayerProxy.class)
/* loaded from: classes34.dex */
public class ar implements MusicPlayerProxy {

    /* renamed from: h, reason: collision with root package name */
    private static String f347787h;

    /* renamed from: a, reason: collision with root package name */
    private com.tencent.mobileqq.music.e f347788a;

    /* renamed from: b, reason: collision with root package name */
    private MusicPlayerProxy.MusicPlayerListener f347789b = null;

    /* renamed from: c, reason: collision with root package name */
    private String f347790c = null;

    /* renamed from: d, reason: collision with root package name */
    private String f347791d = null;

    /* renamed from: e, reason: collision with root package name */
    private long f347792e = -1;

    /* renamed from: f, reason: collision with root package name */
    private ServiceConnection f347793f = new a();

    /* renamed from: g, reason: collision with root package name */
    private c.a f347794g = new b();

    /* compiled from: P */
    /* loaded from: classes34.dex */
    class a implements ServiceConnection {

        /* compiled from: P */
        /* renamed from: com.tencent.qqmini.proxyimpl.ar$a$a, reason: collision with other inner class name */
        /* loaded from: classes34.dex */
        class C9406a implements IBinder.DeathRecipient {

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ IBinder f347796d;

            C9406a(IBinder iBinder) {
                this.f347796d = iBinder;
            }

            @Override // android.os.IBinder.DeathRecipient
            public void binderDied() {
                this.f347796d.unlinkToDeath(this, 0);
                ar.this.f347788a = null;
                QLog.i("MusicPlayerProxyImpl", 2, "linkToDeath binderDied");
            }
        }

        a() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            ar.this.f347788a = e.a.j(iBinder);
            try {
                if (ar.this.f347788a != null) {
                    ar.this.f347788a.C4(ar.this.f347794g);
                }
                if (iBinder != null) {
                    iBinder.linkToDeath(new C9406a(iBinder), 0);
                }
            } catch (Exception e16) {
                QLog.i("MusicPlayerProxyImpl", 2, "onServiceConnected " + e16);
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            QLog.i("MusicPlayerProxyImpl", 2, "onServiceDisconnected " + componentName);
            try {
                if (ar.this.f347788a != null) {
                    ar.this.f347788a.X3(ar.this.f347794g);
                    ar.this.f347788a = null;
                }
            } catch (Exception e16) {
                QLog.i("MusicPlayerProxyImpl", 2, "onServiceDisconnected " + e16);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes34.dex */
    class b extends c.a {
        b() {
        }

        @Override // com.tencent.mobileqq.music.c
        public void onPlaySongChanged(SongInfo songInfo) throws RemoteException {
            if (ar.this.f347789b != null) {
                com.tencent.qqmini.sdk.launcher.core.model.SongInfo songInfo2 = new com.tencent.qqmini.sdk.launcher.core.model.SongInfo();
                songInfo2.album = songInfo.E;
                songInfo2.coverUrl = songInfo.C;
                songInfo2.detailUrl = songInfo.D;
                songInfo2.duration = songInfo.L;
                songInfo2.fromMini = songInfo.J;
                songInfo2.f348087id = songInfo.f251867d;
                songInfo2.mid = songInfo.f251868e;
                songInfo2.singer = songInfo.F;
                songInfo2.singerId = songInfo.G;
                songInfo2.startTime = songInfo.H;
                songInfo2.summary = songInfo.f251872m;
                songInfo2.title = songInfo.f251871i;
                songInfo2.type = songInfo.I;
                songInfo2.uin = songInfo.f251869f;
                songInfo2.url = songInfo.f251870h;
                ar.this.f347789b.onPlaySongChanged(songInfo2);
            }
        }

        @Override // com.tencent.mobileqq.music.c
        public void onPlayStateChanged(int i3) throws RemoteException {
            if (ar.this.f347788a != null) {
                if ((ar.this.f347788a.getToken() == null || ar.this.f347788a.getToken().equals(ar.this.g())) && ar.this.f347789b != null) {
                    ar.this.f347789b.onPlayStateChanged(i3);
                }
            }
        }
    }

    private synchronized void f() {
        try {
            if (this.f347788a == null) {
                long currentTimeMillis = System.currentTimeMillis();
                long j3 = this.f347792e;
                if (j3 != -1 && currentTimeMillis - j3 <= 10000) {
                    QLog.e("MusicPlayerProxyImpl", 1, "waiting for binding service");
                }
                this.f347792e = currentTimeMillis;
                BaseApplication.getContext().bindService(new Intent(BaseApplication.getContext(), (Class<?>) QQPlayerService.class), this.f347793f, 33);
                QLog.e("MusicPlayerProxyImpl", 1, "bindQQPlayerService end!");
            }
        } finally {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String g() {
        if (f347787h == null) {
            f347787h = QQPlayerService.Y(8, "MusicPlayerProxyImpl" + this.f347790c);
        }
        return f347787h;
    }

    private synchronized void h() {
        try {
            if (this.f347788a != null) {
                BaseApplication.getContext().unbindService(this.f347793f);
                this.f347788a = null;
            }
        } finally {
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.MusicPlayerProxy
    public com.tencent.qqmini.sdk.launcher.core.model.SongInfo getCurrentSong() {
        try {
            com.tencent.mobileqq.music.e eVar = this.f347788a;
            if (eVar == null) {
                return null;
            }
            SongInfo currentSong = eVar.getCurrentSong();
            com.tencent.qqmini.sdk.launcher.core.model.SongInfo songInfo = new com.tencent.qqmini.sdk.launcher.core.model.SongInfo();
            songInfo.f348087id = currentSong.f251867d;
            songInfo.mid = currentSong.f251868e;
            songInfo.uin = currentSong.f251869f;
            songInfo.url = currentSong.f251870h;
            songInfo.title = currentSong.f251871i;
            songInfo.summary = currentSong.f251872m;
            songInfo.coverUrl = currentSong.C;
            songInfo.detailUrl = currentSong.D;
            songInfo.album = currentSong.E;
            songInfo.singer = currentSong.F;
            songInfo.singerId = currentSong.G;
            songInfo.startTime = currentSong.H;
            songInfo.type = currentSong.I;
            songInfo.fromMini = currentSong.J;
            songInfo.duration = currentSong.L;
            return songInfo;
        } catch (Exception e16) {
            QLog.e("MusicPlayerProxyImpl", 1, "getCurrentSong exception ", e16);
            return null;
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.MusicPlayerProxy
    public int getCurrentSongPosition() {
        com.tencent.mobileqq.music.e eVar = this.f347788a;
        if (eVar == null) {
            return 0;
        }
        try {
            return eVar.getCurrentSongPosition();
        } catch (Exception e16) {
            QLog.e("MusicPlayerProxyImpl", 1, "getCurrentSongPosition exception ", e16);
            return 0;
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.MusicPlayerProxy
    public int getDuration() {
        com.tencent.mobileqq.music.e eVar = this.f347788a;
        if (eVar == null) {
            return 0;
        }
        try {
            return eVar.getDuration();
        } catch (Exception e16) {
            QLog.e("MusicPlayerProxyImpl", 1, "getCurrentSongDuration exception ", e16);
            return 0;
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.MusicPlayerProxy
    public void init(MusicPlayerProxy.MusicPlayerListener musicPlayerListener, String str, String str2) {
        this.f347789b = musicPlayerListener;
        this.f347790c = str;
        this.f347791d = str2;
        f();
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.MusicPlayerProxy
    public boolean isInit() {
        return this.f347788a != null;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.MusicPlayerProxy
    public boolean isPlaying() {
        try {
            com.tencent.mobileqq.music.e eVar = this.f347788a;
            if (eVar != null && eVar.b3(g())) {
                return true;
            }
            StringBuilder sb5 = new StringBuilder();
            sb5.append("getBackgroundAudioState: null ");
            sb5.append(this.f347788a == null);
            Log.i("MusicPlayerProxyImpl", sb5.toString());
            return false;
        } catch (Exception e16) {
            QLog.e("MusicPlayerProxyImpl", 1, "isPlaying exception ", e16);
            return false;
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.MusicPlayerProxy
    public void pause() {
        try {
            com.tencent.mobileqq.music.e eVar = this.f347788a;
            if (eVar != null) {
                eVar.pause();
            }
        } catch (Exception e16) {
            QLog.e("MusicPlayerProxyImpl", 1, "pause exception ", e16);
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.MusicPlayerProxy
    public void resume() {
        try {
            com.tencent.mobileqq.music.e eVar = this.f347788a;
            if (eVar != null) {
                eVar.resume();
            }
        } catch (Exception e16) {
            QLog.e("MusicPlayerProxyImpl", 1, "resume exception ", e16);
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.MusicPlayerProxy
    public void seekTo(int i3) {
        try {
            com.tencent.mobileqq.music.e eVar = this.f347788a;
            if (eVar != null) {
                eVar.seekTo(i3);
            }
        } catch (Exception e16) {
            QLog.e("MusicPlayerProxyImpl", 1, "seekTo exception ", e16);
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.MusicPlayerProxy
    public void setPlayMode(int i3) {
        try {
            com.tencent.mobileqq.music.e eVar = this.f347788a;
            if (eVar != null) {
                eVar.setPlayMode(i3);
            }
        } catch (Exception e16) {
            QLog.e("MusicPlayerProxyImpl", 1, "setPlayMode exception ", e16);
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.MusicPlayerProxy
    public void stop() {
        try {
            com.tencent.mobileqq.music.e eVar = this.f347788a;
            if (eVar != null) {
                eVar.stop();
            }
        } catch (Exception e16) {
            QLog.e("MusicPlayerProxyImpl", 1, "stop exception ", e16);
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.MusicPlayerProxy
    public void unInit() {
        h();
        this.f347789b = null;
        this.f347790c = null;
        this.f347791d = null;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.MusicPlayerProxy
    public void startPlay(com.tencent.qqmini.sdk.launcher.core.model.SongInfo[] songInfoArr, int i3) {
        com.tencent.mobileqq.music.e eVar;
        if (songInfoArr == null || songInfoArr.length < 1 || (eVar = this.f347788a) == null) {
            return;
        }
        try {
            eVar.m2(new Intent(BaseApplication.getContext(), (Class<?>) MusicPlayerActivity.class));
            Bundle extras = this.f347788a.getExtras();
            if (extras == null) {
                extras = new Bundle();
                this.f347788a.setExtras(extras);
            }
            extras.putString("KEY_SOURCE_NAME", this.f347791d);
            this.f347788a.setExtras(extras);
            SongInfo[] songInfoArr2 = new SongInfo[songInfoArr.length];
            for (int i16 = 0; i16 < songInfoArr.length; i16++) {
                SongInfo songInfo = new SongInfo();
                songInfoArr2[i16] = songInfo;
                com.tencent.qqmini.sdk.launcher.core.model.SongInfo songInfo2 = songInfoArr[i16];
                songInfo.E = songInfo2.album;
                songInfo.C = songInfo2.coverUrl;
                songInfo.D = songInfo2.detailUrl;
                songInfo.L = songInfo2.duration;
                songInfo.J = songInfo2.fromMini;
                songInfo.f251867d = songInfo2.f348087id;
                songInfo.f251868e = songInfo2.mid;
                songInfo.F = songInfo2.singer;
                songInfo.G = songInfo2.singerId;
                songInfo.H = songInfo2.startTime;
                songInfo.f251872m = songInfo2.summary;
                songInfo.f251871i = songInfo2.title;
                songInfo.I = songInfo2.type;
                songInfo.f251869f = songInfo2.uin;
                songInfo.f251870h = songInfo2.url;
            }
            this.f347788a.setPlayMode(100);
            this.f347788a.b2(g(), songInfoArr2, i3);
        } catch (Exception e16) {
            QLog.e("MusicPlayerProxyImpl", 1, "startPlay exception ", e16);
        }
    }
}
