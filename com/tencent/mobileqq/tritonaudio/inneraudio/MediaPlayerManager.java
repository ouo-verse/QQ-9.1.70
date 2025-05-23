package com.tencent.mobileqq.tritonaudio.inneraudio;

import android.media.MediaPlayer;
import com.tencent.mobileqq.triton.utils.LogDelegate;
import com.tencent.qqlive.module.videoreport.dtreport.audio.playback.ReportMediaPlayer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

/* loaded from: classes19.dex */
public class MediaPlayerManager {
    public static final String TAG = "MediaPlayerManager";
    private static MediaPlayerManager sInstance;
    private final LinkedList<MediaPlayer> mReusePlayers = new LinkedList<>();

    public static MediaPlayerManager getInstance() {
        if (sInstance == null) {
            synchronized (MediaPlayerManager.class) {
                if (sInstance == null) {
                    sInstance = new MediaPlayerManager();
                }
            }
        }
        return sInstance;
    }

    public MediaPlayer dequeuePlayer(LogDelegate logDelegate) {
        MediaPlayer poll;
        int size;
        boolean z16;
        synchronized (this.mReusePlayers) {
            poll = this.mReusePlayers.poll();
            size = this.mReusePlayers.size();
        }
        boolean z17 = true;
        if (poll == null) {
            try {
                poll = new ReportMediaPlayer();
            } catch (Throwable th5) {
                if (logDelegate != null) {
                    logDelegate.printLog(LogDelegate.Level.ERROR, TAG, "dequeuePlayer: exception.", th5);
                }
            }
            z16 = false;
        } else {
            z16 = true;
        }
        if (logDelegate != null) {
            LogDelegate.Level level = LogDelegate.Level.ERROR;
            StringBuilder sb5 = new StringBuilder();
            sb5.append("dequeuePlayer: isReuse=");
            sb5.append(z16);
            sb5.append(";isPlayer valid=");
            if (poll == null) {
                z17 = false;
            }
            sb5.append(z17);
            sb5.append("; players size=");
            sb5.append(size);
            logDelegate.printLog(level, TAG, sb5.toString(), null);
        }
        return poll;
    }

    public void enqueuePlayer(MediaPlayer mediaPlayer) {
        if (mediaPlayer != null) {
            synchronized (this.mReusePlayers) {
                this.mReusePlayers.add(mediaPlayer);
            }
        }
    }

    public void releaseAll() {
        ArrayList arrayList;
        synchronized (this.mReusePlayers) {
            if (this.mReusePlayers.size() > 0) {
                arrayList = new ArrayList(this.mReusePlayers);
                this.mReusePlayers.clear();
            } else {
                arrayList = null;
            }
        }
        if (arrayList != null) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((MediaPlayer) it.next()).release();
            }
        }
    }
}
