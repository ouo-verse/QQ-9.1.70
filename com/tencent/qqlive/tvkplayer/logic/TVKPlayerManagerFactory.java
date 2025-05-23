package com.tencent.qqlive.tvkplayer.logic;

import android.content.Context;
import android.os.Looper;
import com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer;
import com.tencent.qqlive.tvkplayer.api.render.ITVKDrawableContainer;

/* loaded from: classes23.dex */
public class TVKPlayerManagerFactory {
    private static TVKPlayerManagerFactory mInstance;

    TVKPlayerManagerFactory() {
    }

    public static TVKPlayerManagerFactory getInstance() {
        if (mInstance == null) {
            mInstance = new TVKPlayerManagerFactory();
        }
        return mInstance;
    }

    public ITVKMediaPlayer createPlayerManager(Context context, ITVKDrawableContainer iTVKDrawableContainer, Looper looper) {
        return (ITVKMediaPlayer) new TVKPlayerManagerProxyFactory(new TVKPlayerManager(context, iTVKDrawableContainer, looper)).getProxyInstance();
    }
}
