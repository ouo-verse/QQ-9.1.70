package com.tencent.mobileqq.listentogether.lyrics;

import android.graphics.Paint;

/* compiled from: P */
/* loaded from: classes33.dex */
public interface c {
    String a();

    int getState();

    boolean isPlaying();

    void pause();

    void seek(int i3);

    void setAlign(Paint.Align align);

    void setLineMaxWidth(int i3);

    void setLyric(com.tencent.mobileqq.lyric.data.b bVar, int i3);

    void setOnSizeChangeListener(e eVar);

    void setSongId(String str);

    void setStrokeColor(int i3);

    void setStrokeWidth(int i3);

    void start();

    void stop();
}
