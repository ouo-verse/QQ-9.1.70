package com.tencent.biz.qqcircle.richframework.widget.video;

import android.text.TextUtils;
import com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.ad.b;
import com.tencent.biz.richframework.video.rfw.RFWPlayer;
import com.tencent.biz.richframework.video.rfw.view.RFWBasePlayerManager;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes5.dex */
public class a extends RFWBasePlayerManager {

    /* renamed from: e, reason: collision with root package name */
    private static volatile a f92262e;

    /* renamed from: a, reason: collision with root package name */
    private volatile int f92263a = -1;

    /* renamed from: b, reason: collision with root package name */
    private final ConcurrentHashMap<Integer, String> f92264b = new ConcurrentHashMap<>();

    /* renamed from: c, reason: collision with root package name */
    private final ConcurrentHashMap<String, RFWPlayer> f92265c = new ConcurrentHashMap<>();

    /* renamed from: d, reason: collision with root package name */
    private final b f92266d = new b();

    public static a c() {
        if (f92262e == null) {
            synchronized (a.class) {
                if (f92262e == null) {
                    f92262e = new a();
                }
            }
        }
        return f92262e;
    }

    private RFWPlayer d(int i3) {
        if (!this.f92265c.isEmpty() && !this.f92264b.isEmpty()) {
            if (!this.f92264b.containsKey(Integer.valueOf(i3))) {
                QLog.e("QFSAdCoverVideoPlayerManager", 1, "getValidPlayer error: mPosToVideoMap not contains key:" + i3);
                return null;
            }
            String str = this.f92264b.get(Integer.valueOf(i3));
            if (TextUtils.isEmpty(str)) {
                QLog.e("QFSAdCoverVideoPlayerManager", 1, "getValidPlayer error: playerUniqueKey is null");
                return null;
            }
            if (!this.f92265c.containsKey(str)) {
                QLog.e("QFSAdCoverVideoPlayerManager", 4, "getValidPlayer error: mVideoPlayerMap not contains key:" + str);
                return null;
            }
            QLog.d("QFSAdCoverVideoPlayerManager", 4, "getValidPlayer playerUniqueKey: " + str);
            return this.f92265c.get(str);
        }
        QLog.e("QFSAdCoverVideoPlayerManager", 1, "getValidPlayer error: player list is empty");
        return null;
    }

    private int e(String str) {
        for (Map.Entry<Integer, String> entry : this.f92264b.entrySet()) {
            if (TextUtils.equals(str, entry.getValue())) {
                return entry.getKey().intValue();
            }
        }
        return 0;
    }

    private void j(int i3, RFWPlayer rFWPlayer) {
        if (rFWPlayer == null) {
            return;
        }
        if (rFWPlayer.getCurrentPositionMs() > 0) {
            this.f92266d.f(i3, rFWPlayer.getCurrentPositionMs());
        }
        rFWPlayer.seek(0L);
        rFWPlayer.pause();
    }

    private void l(int i3, boolean z16) {
        long currentPositionMs;
        RFWPlayer d16 = d(i3);
        if (d16 == null) {
            QLog.w("QFSAdCoverVideoPlayerManager", 1, "startPlayer fail: player is null");
            return;
        }
        if (!d16.isReady()) {
            QLog.d("QFSAdCoverVideoPlayerManager", 1, "startPlayer fail: player not ready");
            return;
        }
        if (d16.isPlaying()) {
            QLog.d("QFSAdCoverVideoPlayerManager", 1, "startPlayer fail: player is playing");
            return;
        }
        d16.start();
        b bVar = this.f92266d;
        if (z16) {
            currentPositionMs = 0;
        } else {
            currentPositionMs = d16.getCurrentPositionMs();
        }
        bVar.e(i3, currentPositionMs);
    }

    private void m() {
        if (this.f92264b.size() >= 2 && this.f92263a >= 0) {
            for (Map.Entry<Integer, String> entry : this.f92264b.entrySet()) {
                if (entry.getKey().intValue() != this.f92263a) {
                    int intValue = entry.getKey().intValue();
                    j(intValue, d(intValue));
                    QLog.d("QFSAdCoverVideoPlayerManager", 4, "stopOtherPlayers: position:" + intValue);
                }
            }
        }
    }

    public boolean b(int i3) {
        RFWPlayer d16 = d(i3);
        if (d16 == null) {
            return false;
        }
        return d16.isOutputMute();
    }

    public RFWPlayer f(String str, int i3, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            this.f92266d.a(i3, str2);
            return newAQCirclePlayer(str);
        }
        return null;
    }

    public void g(int i3) {
        this.f92266d.c(i3);
    }

    @Override // com.tencent.biz.richframework.video.rfw.view.RFWBasePlayerManager
    public RFWPlayer getPlayer(String str) {
        if (!this.f92265c.containsKey(str)) {
            QLog.d("QFSAdCoverVideoPlayerManager", 4, "getPlayer is null = " + str);
            return null;
        }
        return this.f92265c.get(str);
    }

    public void h(int i3) {
        RFWPlayer d16 = d(i3);
        if (d16 == null) {
            return;
        }
        d16.pause();
        if (d16.getRealPlayer() != null && d16.getRealPlayer().getCurrentPositionMs() > 0) {
            this.f92266d.d(i3, d16.getRealPlayer().getCurrentPositionMs());
        }
    }

    public void i(int i3) {
        RFWPlayer d16 = d(i3);
        if (d16 == null) {
            QLog.e("QFSAdCoverVideoPlayerManager", 1, "reportVideoComplete error: player is null: " + i3);
            return;
        }
        this.f92266d.b(i3, d16.getDurationMs());
    }

    public void k(int i3, boolean z16) {
        RFWPlayer d16 = d(i3);
        if (d16 == null) {
            return;
        }
        d16.setOutputMute(z16);
    }

    public void n(int i3, boolean z16) {
        if (!this.f92264b.containsKey(Integer.valueOf(i3))) {
            QLog.d("QFSAdCoverVideoPlayerManager", 1, "tryToStart return: player list is empty");
            return;
        }
        if (this.f92263a > 0 && i3 > this.f92263a) {
            QLog.d("QFSAdCoverVideoPlayerManager", 1, "tryToStart return: position:" + i3 + " > mCurrentAdTopPosition:" + this.f92263a);
            return;
        }
        this.f92263a = i3;
        RFWPlayer d16 = d(this.f92263a);
        if (d16 != null && d16.isPlaying()) {
            QLog.d("QFSAdCoverVideoPlayerManager", 1, "tryToStart return: mCurrentPlayer isPlaying");
            return;
        }
        QLog.d("QFSAdCoverVideoPlayerManager", 1, "tryToStart position: " + this.f92263a);
        l(this.f92263a, z16);
        m();
    }

    @Override // com.tencent.biz.richframework.video.rfw.view.RFWBasePlayerManager
    public RFWPlayer newAQCirclePlayer(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        QLog.d("QFSAdCoverVideoPlayerManager", 4, "new circle player, uniqueKey = " + str);
        RFWPlayer rFWPlayer = new RFWPlayer();
        putPlayer(str, rFWPlayer);
        return rFWPlayer;
    }

    public void o(int i3, String str, boolean z16) {
        if (z16) {
            this.f92264b.put(Integer.valueOf(i3), str);
        } else {
            this.f92264b.remove(Integer.valueOf(i3));
        }
    }

    @Override // com.tencent.biz.richframework.video.rfw.view.RFWBasePlayerManager
    public void putPlayer(String str, RFWPlayer rFWPlayer) {
        RFWPlayer rFWPlayer2;
        if (!TextUtils.isEmpty(str) && rFWPlayer != null) {
            if (this.f92265c.containsKey(str) && (rFWPlayer2 = this.f92265c.get(str)) != null) {
                rFWPlayer2.release(RFWPlayer.RELEASE_FROM_PLAYER_MANGER);
                this.f92265c.remove(str);
                QLog.d("QFSAdCoverVideoPlayerManager", 4, "putPlayer has old player and remove it:" + str);
            }
            this.f92265c.put(str, rFWPlayer);
        }
    }

    @Override // com.tencent.biz.richframework.video.rfw.view.RFWBasePlayerManager
    public boolean releasePlayer(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        QLog.d("QFSAdCoverVideoPlayerManager", 4, "releasePlayer uniquekey = " + str);
        RFWPlayer rFWPlayer = this.f92265c.get(str);
        if (rFWPlayer != null) {
            rFWPlayer.release(RFWPlayer.RELEASE_FROM_VIDEO_VIEW);
            int e16 = e(str);
            this.f92266d.f(e16, rFWPlayer.getCurrentPositionMs());
            this.f92265c.remove(str);
            this.f92266d.h(e16);
            this.f92263a = -1;
            QLog.d("QFSAdCoverVideoPlayerManager", 4, "releasePlayer success = " + str);
            return true;
        }
        QLog.d("QFSAdCoverVideoPlayerManager", 4, "releasePlayer fail, player is null = " + str);
        return false;
    }
}
