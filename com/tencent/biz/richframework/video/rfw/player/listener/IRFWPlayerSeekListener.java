package com.tencent.biz.richframework.video.rfw.player.listener;

import android.widget.SeekBar;

/* loaded from: classes5.dex */
public interface IRFWPlayerSeekListener {
    void onProgress(String str, int i3, int i16);

    void onSeekBarProgressChanged(SeekBar seekBar, int i3, boolean z16);

    void onStartTrackingTouch(SeekBar seekBar);

    void onStopTrackingTouch(SeekBar seekBar);
}
