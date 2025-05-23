package com.tencent.richmediabrowser.view.progress;

import android.content.Context;
import com.tencent.richmediabrowser.view.BrowserBaseScene;

/* loaded from: classes25.dex */
public interface AbstractProgressView {
    void hide();

    void init(Context context, BrowserBaseScene browserBaseScene);

    boolean isShow();

    boolean isStarted();

    void setProgress(int i3);

    void show();

    void start(int i3);

    void stop();
}
