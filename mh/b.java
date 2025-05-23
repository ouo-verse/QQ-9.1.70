package mh;

import com.qzone.reborn.feedx.video.QZonePlayer;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes38.dex */
public class b extends a {

    /* renamed from: c, reason: collision with root package name */
    private static volatile b f416755c;

    /* renamed from: b, reason: collision with root package name */
    private ConcurrentHashMap<String, QZonePlayer> f416756b = new ConcurrentHashMap<>();

    b() {
        b();
    }

    public static b d() {
        if (f416755c == null) {
            synchronized (b.class) {
                if (f416755c == null) {
                    f416755c = new b();
                }
            }
        }
        return f416755c;
    }

    public synchronized QZonePlayer e(String str) {
        QZonePlayer qZonePlayer;
        qZonePlayer = new QZonePlayer();
        this.f416756b.put(str, qZonePlayer);
        return qZonePlayer;
    }

    public synchronized void f() {
        ConcurrentHashMap<String, QZonePlayer> concurrentHashMap = this.f416756b;
        if (concurrentHashMap != null && concurrentHashMap.size() != 0) {
            c(this.f416756b.entrySet().iterator());
        }
    }

    public synchronized boolean g(String str) {
        if (this.f416756b.containsKey(str)) {
            this.f416756b.get(str).H(QZonePlayer.M);
            this.f416756b.remove(str);
            return true;
        }
        QLog.d("QZoneAudioPlayerManager", 1, "releasePlayer is null:" + str);
        return false;
    }
}
