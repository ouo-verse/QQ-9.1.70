package com.qzone.personalize.music.business;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Message;
import android.os.RemoteException;
import android.text.TextUtils;
import com.qzone.util.l;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.music.QQPlayerService;
import com.tencent.mobileqq.music.SongInfo;
import com.tencent.mobileqq.music.c;
import com.tencent.mobileqq.music.e;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.richframework.thread.RFWThreadManager;
import cooperation.qzone.util.QZLog;

/* compiled from: P */
/* loaded from: classes39.dex */
public class QQMusicWrap {

    /* renamed from: b, reason: collision with root package name */
    private QusicService f49312b;

    /* renamed from: d, reason: collision with root package name */
    private String f49314d;

    /* renamed from: a, reason: collision with root package name */
    private volatile e f49311a = null;

    /* renamed from: c, reason: collision with root package name */
    protected volatile long f49313c = -1;

    /* renamed from: e, reason: collision with root package name */
    private volatile boolean f49315e = false;

    /* renamed from: f, reason: collision with root package name */
    protected ServiceConnection f49316f = new ServiceConnection() { // from class: com.qzone.personalize.music.business.QQMusicWrap.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, final IBinder iBinder) {
            if (QZLog.isDevelopLevel()) {
                QZLog.d("QQMusicWrap", 4, " onServiceConnected service:" + componentName);
            }
            RFWThreadManager.getInstance().execOnSubThread(new Runnable() { // from class: com.qzone.personalize.music.business.QQMusicWrap.1.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        QQMusicWrap.this.f49311a = e.a.j(iBinder);
                        QQMusicWrap.this.f49311a.C4(QQMusicWrap.this.f49317g);
                    } catch (Throwable th5) {
                        QZLog.w(th5);
                    }
                }
            });
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            QQMusicWrap.this.f49311a = null;
        }
    };

    /* renamed from: g, reason: collision with root package name */
    private c.a f49317g = new a();

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class a extends c.a {
        a() {
        }

        @Override // com.tencent.mobileqq.music.c
        public void onPlaySongChanged(SongInfo songInfo) throws RemoteException {
            if (QZLog.isDevelopLevel()) {
                QZLog.d("QQMusicWrap", 4, "onReceive onPlaySongChanged SongInfo:" + songInfo);
            }
            QQMusicWrap.this.f49312b.T().removeMessages(0);
            Message obtainMessage = QQMusicWrap.this.f49312b.T().obtainMessage(0);
            obtainMessage.obj = songInfo;
            QQMusicWrap.this.f49312b.T().sendMessageDelayed(obtainMessage, 50L);
        }

        @Override // com.tencent.mobileqq.music.c
        public void onPlayStateChanged(int i3) throws RemoteException {
            if (QZLog.isDevelopLevel()) {
                QZLog.d("QQMusicWrap", 4, "onReceive onPlayStateChanged playState:" + i3);
            }
            QQMusicWrap.this.f49312b.T().removeMessages(1);
            Message obtainMessage = QQMusicWrap.this.f49312b.T().obtainMessage(1);
            obtainMessage.arg1 = i3;
            QQMusicWrap.this.f49312b.T().sendMessageDelayed(obtainMessage, 50L);
        }
    }

    public QQMusicWrap(QusicService qusicService) {
        this.f49312b = qusicService;
    }

    private String f() {
        if (TextUtils.isEmpty(this.f49314d) && this.f49311a != null) {
            try {
                this.f49314d = this.f49311a.T4(4, "QQMusicWrap");
            } catch (Exception e16) {
                e16.printStackTrace();
                QZLog.w(e16);
            }
        }
        return this.f49314d;
    }

    private Intent p() {
        return new Intent(BaseApplication.getContext(), (Class<?>) QQPlayerService.class);
    }

    public void A() {
        long currentTimeMillis = System.currentTimeMillis();
        if (this.f49313c != -1 && currentTimeMillis - this.f49313c <= 10000) {
            if (QZLog.isDevelopLevel()) {
                QZLog.d("QQMusicWrap", 4, "wait start QQPlay service result, skiped...");
            }
        } else {
            this.f49313c = currentTimeMillis;
            e();
        }
    }

    public boolean B() {
        if (!t()) {
            return false;
        }
        try {
            this.f49311a.stop();
            return true;
        } catch (Exception e16) {
            QZLog.w(e16);
            return false;
        }
    }

    public void C() {
        try {
            if (this.f49311a != null) {
                BaseApplication.getContext().unbindService(this.f49316f);
                if (QZLog.isDevelopLevel()) {
                    QZLog.d("QQMusicWrap", 4, " unbindService QQPlayService finished");
                }
                this.f49311a = null;
                this.f49315e = true;
            }
        } catch (Exception e16) {
            QZLog.w(e16);
        }
    }

    public boolean D() {
        if (this.f49311a != null) {
            try {
                f();
                String token = this.f49311a.getToken();
                if (token != null) {
                    return token.equals(this.f49314d);
                }
                return false;
            } catch (Exception e16) {
                QZLog.w(e16);
            }
        }
        return false;
    }

    public SongInfo g() {
        if (!t()) {
            return null;
        }
        try {
            return this.f49311a.getCurrentSong();
        } catch (Exception e16) {
            QZLog.w(e16);
            return null;
        }
    }

    public int h() {
        if (!t()) {
            return -1;
        }
        try {
            return this.f49311a.q4();
        } catch (Exception e16) {
            QZLog.w(e16);
            return -1;
        }
    }

    public int i() {
        if (!t()) {
            return 4;
        }
        try {
            return this.f49311a.getPlayState();
        } catch (Exception e16) {
            QZLog.w(e16);
            return 4;
        }
    }

    public Bundle j() {
        if (!t()) {
            return null;
        }
        try {
            return this.f49311a.getExtras();
        } catch (Exception e16) {
            QZLog.w(e16);
            return null;
        }
    }

    public SongInfo k() {
        if (!t()) {
            return null;
        }
        try {
            return this.f49311a.y0();
        } catch (Exception e16) {
            QZLog.w(e16);
            return null;
        }
    }

    public Intent l() {
        if (!t()) {
            return null;
        }
        try {
            return this.f49311a.N0();
        } catch (Exception e16) {
            QZLog.w(e16);
            return null;
        }
    }

    public int m() {
        if (!t()) {
            return 0;
        }
        try {
            return this.f49311a.O();
        } catch (Exception e16) {
            QZLog.w(e16);
            return 0;
        }
    }

    public int n() {
        if (!t()) {
            return 0;
        }
        try {
            return this.f49311a.X2();
        } catch (Exception e16) {
            QZLog.w(e16);
            return 0;
        }
    }

    public long q() {
        if (!t()) {
            return -1L;
        }
        try {
            long currentSongPosition = this.f49311a.getCurrentSongPosition();
            long duration = this.f49311a.getDuration();
            if (duration < 0) {
                duration = 0;
            }
            return currentSongPosition > duration ? duration : currentSongPosition;
        } catch (Exception e16) {
            QZLog.w(e16);
            return -1L;
        }
    }

    public long r() {
        if (!t()) {
            return -1L;
        }
        try {
            long w3 = this.f49311a.w3();
            long duration = this.f49311a.getDuration();
            if (duration < 0) {
                duration = 0;
            }
            return w3 > duration ? duration : w3;
        } catch (Exception e16) {
            QZLog.w(e16);
            return -1L;
        }
    }

    public long s() {
        if (!t()) {
            return -1L;
        }
        try {
            long duration = this.f49311a.getDuration();
            if (duration < 0) {
                return 0L;
            }
            return duration;
        } catch (Exception e16) {
            QZLog.w(e16);
            return -1L;
        }
    }

    public boolean t() {
        if (this.f49315e) {
            return false;
        }
        if (this.f49311a != null) {
            return true;
        }
        A();
        return false;
    }

    public boolean u() {
        if (!t()) {
            return false;
        }
        try {
            if (!this.f49311a.isPlaying()) {
                return false;
            }
            this.f49311a.pause();
            return true;
        } catch (Exception e16) {
            QZLog.w(e16);
            return false;
        }
    }

    public void v(int i3, SongInfo[] songInfoArr) {
        if (songInfoArr != null && i3 >= 0 && i3 <= songInfoArr.length - 1) {
            if (t()) {
                try {
                    this.f49311a.b2(this.f49311a.T4(4, "QQMusicWrap"), songInfoArr, i3);
                    return;
                } catch (Exception e16) {
                    QZLog.w(e16);
                    return;
                }
            }
            return;
        }
        QZLog.w("QQMusicWrap", "playSong startIndex is out of range of SongList! Please check!");
    }

    public boolean w() {
        if (!t()) {
            return false;
        }
        try {
            if (this.f49311a.isPlaying()) {
                return false;
            }
            if (this.f49311a.getPlayState() != 3) {
                return true;
            }
            this.f49311a.resume();
            return true;
        } catch (Exception e16) {
            QZLog.w(e16);
            return false;
        }
    }

    public void x(Bundle bundle) {
        if (t()) {
            try {
                this.f49311a.setExtras(bundle);
            } catch (Exception e16) {
                QZLog.w(e16);
            }
        }
    }

    public void z(int i3) {
        if (t()) {
            try {
                this.f49311a.setPlayMode(i3);
                if (QZLog.isColorLevel()) {
                    QZLog.i("QQMusicWrap", "\u8bbe\u7f6e\u64ad\u653e\u6a21\u5f0f\uff1a" + o(i3));
                }
            } catch (Exception e16) {
                QZLog.w(e16);
            }
        }
    }

    boolean e() {
        boolean z16 = false;
        try {
            z16 = BaseApplication.getContext().bindService(p(), this.f49316f, 33);
            if (QZLog.isDevelopLevel()) {
                QZLog.d("QQMusicWrap", 4, " bind QQPlayService finished " + z16);
            }
        } catch (Exception e16) {
            QZLog.w(e16);
        }
        return z16;
    }

    public void y(Intent intent) {
        if (intent == null || !t()) {
            return;
        }
        try {
            this.f49311a.m2(intent);
        } catch (Exception e16) {
            QZLog.w(e16);
        }
    }

    private static String o(int i3) {
        switch (i3) {
            case 100:
                return l.a(R.string.qv9);
            case 101:
                return l.a(R.string.qva);
            case 102:
                return l.a(R.string.qv_);
            case 103:
                return l.a(R.string.qv7);
            case 104:
            default:
                return String.valueOf(i3);
            case 105:
                return l.a(R.string.qv8);
        }
    }
}
