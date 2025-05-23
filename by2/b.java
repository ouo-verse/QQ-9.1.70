package by2;

import com.tencent.biz.richframework.video.rfw.RFWPlayer;
import com.tencent.biz.richframework.video.rfw.view.RFWBasePlayerManager;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes19.dex */
public class b extends RFWBasePlayerManager {

    /* renamed from: b, reason: collision with root package name */
    private static volatile b f29387b;

    /* renamed from: a, reason: collision with root package name */
    private ConcurrentHashMap<String, RFWPlayer> f29388a = new ConcurrentHashMap<>();

    b() {
        initPlay();
    }

    public static b b() {
        if (f29387b == null) {
            synchronized (b.class) {
                if (f29387b == null) {
                    f29387b = new b();
                }
            }
        }
        return f29387b;
    }

    @Override // com.tencent.biz.richframework.video.rfw.view.RFWBasePlayerManager
    public RFWPlayer getPlayer(String str) {
        if (this.f29388a.containsKey(str)) {
            return this.f29388a.get(str);
        }
        QLog.d("QFSTVideoPlayerManager", 1, "getPlayer is null = " + str);
        return null;
    }

    @Override // com.tencent.biz.richframework.video.rfw.view.RFWBasePlayerManager
    public synchronized RFWPlayer newAQCirclePlayer(String str) {
        RFWPlayer rFWPlayer;
        rFWPlayer = new RFWPlayer();
        this.f29388a.put(str, rFWPlayer);
        return rFWPlayer;
    }

    @Override // com.tencent.biz.richframework.video.rfw.view.RFWBasePlayerManager
    public void putPlayer(String str, RFWPlayer rFWPlayer) {
        RFWPlayer rFWPlayer2 = this.f29388a.get(str);
        if (rFWPlayer2 != null) {
            rFWPlayer2.release(RFWPlayer.RELEASE_FROM_PLAYER_MANGER);
            this.f29388a.remove(str);
            QLog.d("QFSTVideoPlayerManager", 1, "putPlayer has old view :" + str);
        }
        this.f29388a.put(str, rFWPlayer);
    }

    public synchronized void releaseAll() {
        ConcurrentHashMap<String, RFWPlayer> concurrentHashMap = this.f29388a;
        if (concurrentHashMap != null && concurrentHashMap.size() != 0) {
            iteratorRelease(this.f29388a.entrySet().iterator());
        }
    }

    @Override // com.tencent.biz.richframework.video.rfw.view.RFWBasePlayerManager
    public synchronized boolean releasePlayer(String str) {
        RFWPlayer rFWPlayer = this.f29388a.get(str);
        if (rFWPlayer != null) {
            rFWPlayer.release(RFWPlayer.RELEASE_FROM_VIDEO_VIEW);
            this.f29388a.remove(str);
            QLog.d("QFSTVideoPlayerManager", 1, "releasePlayer success = " + str);
            return true;
        }
        QLog.d("QFSTVideoPlayerManager", 1, "releasePlayer is null = " + str);
        return false;
    }
}
