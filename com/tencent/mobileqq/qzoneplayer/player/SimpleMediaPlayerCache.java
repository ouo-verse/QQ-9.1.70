package com.tencent.mobileqq.qzoneplayer.player;

import com.tencent.oskplayer.player.StateMediaPlayer;
import com.tencent.oskplayer.util.PlayerUtils;
import com.tencent.oskplayer.util.ThreadUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes35.dex */
public class SimpleMediaPlayerCache implements b {

    /* renamed from: a, reason: collision with root package name */
    private List<CachedMediaPlayer> f279453a = new ArrayList();

    public SimpleMediaPlayerCache(int i3) {
    }

    @Override // com.tencent.mobileqq.qzoneplayer.player.b
    public void a(final CachedMediaPlayer cachedMediaPlayer) {
        ThreadUtils.submitTask(new Runnable() { // from class: com.tencent.mobileqq.qzoneplayer.player.SimpleMediaPlayerCache.1
            @Override // java.lang.Runnable
            public void run() {
                CachedMediaPlayer cachedMediaPlayer2 = cachedMediaPlayer;
                if (cachedMediaPlayer2 == null || cachedMediaPlayer2.d() == null) {
                    return;
                }
                if (cachedMediaPlayer.d().checkState(StateMediaPlayer.StateMediaPlayerOperation.OP_RESET)) {
                    PlayerUtils.log(5, "mpCache", "async reset mediaplayer");
                    cachedMediaPlayer.d().reset();
                }
                try {
                    cachedMediaPlayer.d().release();
                } catch (NullPointerException | Exception unused) {
                }
            }
        }, "asyncReleaseMediaplayer");
    }

    @Override // com.tencent.mobileqq.qzoneplayer.player.b
    public synchronized void release() {
        Iterator<CachedMediaPlayer> it = this.f279453a.iterator();
        while (it.hasNext()) {
            it.next().i();
        }
        this.f279453a.clear();
    }
}
