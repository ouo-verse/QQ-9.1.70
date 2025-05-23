package mh;

import com.qzone.reborn.feedx.video.QZonePlayer;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes38.dex */
public class d extends a {

    /* renamed from: c, reason: collision with root package name */
    private static volatile d f416758c;

    /* renamed from: b, reason: collision with root package name */
    private ConcurrentHashMap<String, QZonePlayer> f416759b = new ConcurrentHashMap<>();

    d() {
        b();
    }

    public static d d() {
        if (f416758c == null) {
            synchronized (d.class) {
                if (f416758c == null) {
                    f416758c = new d();
                }
            }
        }
        return f416758c;
    }

    public synchronized QZonePlayer e(String str) {
        QZonePlayer qZonePlayer;
        qZonePlayer = new QZonePlayer();
        this.f416759b.put(str, qZonePlayer);
        return qZonePlayer;
    }

    public synchronized void f() {
        ConcurrentHashMap<String, QZonePlayer> concurrentHashMap = this.f416759b;
        if (concurrentHashMap != null && concurrentHashMap.size() != 0) {
            c(this.f416759b.entrySet().iterator());
        }
    }

    public synchronized boolean g(String str) {
        QZonePlayer qZonePlayer = this.f416759b.get(str);
        if (qZonePlayer != null) {
            qZonePlayer.H(QZonePlayer.M);
            this.f416759b.remove(str);
            QLog.d("QZoneVideoPlayerManager", 1, "releasePlayer success = " + str);
            return true;
        }
        QLog.d("QZoneVideoPlayerManager", 1, "releasePlayer is null = " + str);
        return false;
    }
}
