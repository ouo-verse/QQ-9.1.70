package by2;

import com.tencent.biz.richframework.video.rfw.RFWPlayer;
import com.tencent.biz.richframework.video.rfw.view.RFWBasePlayerManager;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes19.dex */
public class a extends RFWBasePlayerManager {

    /* renamed from: b, reason: collision with root package name */
    private static volatile a f29385b;

    /* renamed from: a, reason: collision with root package name */
    private ConcurrentHashMap<String, RFWPlayer> f29386a = new ConcurrentHashMap<>();

    a() {
        initPlay();
    }

    public static a b() {
        if (f29385b == null) {
            synchronized (a.class) {
                if (f29385b == null) {
                    f29385b = new a();
                }
            }
        }
        return f29385b;
    }

    @Override // com.tencent.biz.richframework.video.rfw.view.RFWBasePlayerManager
    public RFWPlayer getPlayer(String str) {
        if (this.f29386a.containsKey(str)) {
            return this.f29386a.get(str);
        }
        QLog.d("QFSTVideoAudioPlayerManager", 1, "getPlayer is null = " + str);
        return null;
    }

    @Override // com.tencent.biz.richframework.video.rfw.view.RFWBasePlayerManager
    public synchronized RFWPlayer newAQCirclePlayer(String str) {
        RFWPlayer rFWPlayer;
        rFWPlayer = new RFWPlayer();
        this.f29386a.put(str, rFWPlayer);
        return rFWPlayer;
    }

    @Override // com.tencent.biz.richframework.video.rfw.view.RFWBasePlayerManager
    public void putPlayer(String str, RFWPlayer rFWPlayer) {
        if (this.f29386a.containsKey(str)) {
            this.f29386a.remove(str);
        }
        this.f29386a.put(str, rFWPlayer);
    }

    public synchronized void releaseAll() {
        ConcurrentHashMap<String, RFWPlayer> concurrentHashMap = this.f29386a;
        if (concurrentHashMap != null && concurrentHashMap.size() != 0) {
            iteratorRelease(this.f29386a.entrySet().iterator());
        }
    }

    @Override // com.tencent.biz.richframework.video.rfw.view.RFWBasePlayerManager
    public synchronized boolean releasePlayer(String str) {
        if (this.f29386a.containsKey(str)) {
            this.f29386a.get(str).release(RFWPlayer.RELEASE_FROM_VIDEO_VIEW);
            this.f29386a.remove(str);
            return true;
        }
        QLog.d("QFSTVideoAudioPlayerManager", 1, "releasePlayer is null:" + str);
        return false;
    }
}
