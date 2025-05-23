package com.tencent.ams.fusion.widget.olympic2024.floating;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* compiled from: P */
/* loaded from: classes3.dex */
public interface OlympicFloatingViewListener {

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes3.dex */
    public @interface ViewType {
        public static final int CLOSE = 2;
        public static final int EXPAND_IMAGE = 3;
        public static final int FOLD_IMAGE = 4;
        public static final int VIDEO = 1;
    }

    void onDismiss();

    void onVideoPlayComplete();

    void onVideoPlayError(int i3);

    void onVideoPlayPause();

    void onVideoPlayStart();

    void onVideoPlayStop();

    void onVideoPlayUpdate(long j3);

    void onViewClick(int i3);

    void onViewExposure(int i3);
}
