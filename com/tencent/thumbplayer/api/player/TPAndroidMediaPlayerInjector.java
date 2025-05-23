package com.tencent.thumbplayer.api.player;

import android.media.MediaPlayer;
import androidx.annotation.NonNull;

/* loaded from: classes26.dex */
public class TPAndroidMediaPlayerInjector {
    private static TPAndroidMediaPlayerInjector sInstance;
    private ITPAndroidMediaPlayerCreator mCreator = null;

    /* loaded from: classes26.dex */
    public interface ITPAndroidMediaPlayerCreator {
        @NonNull
        MediaPlayer createPlayer();
    }

    TPAndroidMediaPlayerInjector() {
    }

    public static synchronized TPAndroidMediaPlayerInjector getInstance() {
        TPAndroidMediaPlayerInjector tPAndroidMediaPlayerInjector;
        synchronized (TPAndroidMediaPlayerInjector.class) {
            if (sInstance == null) {
                sInstance = new TPAndroidMediaPlayerInjector();
            }
            tPAndroidMediaPlayerInjector = sInstance;
        }
        return tPAndroidMediaPlayerInjector;
    }

    public synchronized ITPAndroidMediaPlayerCreator getAndroidMediaPlayerCreator() {
        return this.mCreator;
    }

    public synchronized void injectAndroidMediaPlayerCreator(ITPAndroidMediaPlayerCreator iTPAndroidMediaPlayerCreator) {
        this.mCreator = iTPAndroidMediaPlayerCreator;
    }
}
