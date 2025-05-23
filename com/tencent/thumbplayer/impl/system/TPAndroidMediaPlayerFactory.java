package com.tencent.thumbplayer.impl.system;

import android.media.MediaPlayer;
import androidx.annotation.NonNull;
import com.tencent.thumbplayer.api.player.TPAndroidMediaPlayerInjector;
import com.tencent.thumbplayer.common.TPContext;
import com.tencent.thumbplayer.common.log.TPLogUtil;

/* loaded from: classes26.dex */
public class TPAndroidMediaPlayerFactory {
    @NonNull
    public static MediaPlayer createPlayer(TPContext tPContext) {
        MediaPlayer mediaPlayer;
        TPAndroidMediaPlayerInjector.ITPAndroidMediaPlayerCreator androidMediaPlayerCreator = TPAndroidMediaPlayerInjector.getInstance().getAndroidMediaPlayerCreator();
        if (androidMediaPlayerCreator != null) {
            mediaPlayer = androidMediaPlayerCreator.createPlayer();
        } else {
            mediaPlayer = null;
        }
        if (mediaPlayer != null) {
            TPLogUtil.i(tPContext.getLogTag(), "create injected android media player");
            return mediaPlayer;
        }
        return new TPMediaPlayer(tPContext);
    }
}
