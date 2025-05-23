package com.tencent.qqlive.playerinterface;

import android.view.View;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.player.a;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: classes22.dex */
public interface IQAdPlayerView {

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes22.dex */
    public @interface StoreAndResumeState {
        public static final int RELEASE = 3;
        public static final int RESUME = 2;
        public static final int STORE = 1;
    }

    void a(boolean z16);

    boolean b();

    Object c();

    View getPlayerView();

    void setOpaqueInfo(boolean z16);

    void setPlayerCallback(a aVar);

    void setVideoWidthAndHeight(int i3, int i16);
}
