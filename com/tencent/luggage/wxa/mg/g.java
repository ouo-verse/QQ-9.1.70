package com.tencent.luggage.wxa.mg;

import android.graphics.Bitmap;
import android.view.View;

/* compiled from: P */
/* loaded from: classes8.dex */
public interface g {

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public interface a {
        void a();

        void a(int i3);

        void a(f fVar);

        void b();

        boolean c();

        void d();

        void e();

        boolean f();

        void g();

        boolean h();

        void i();

        boolean j();

        void k();

        boolean l();

        void m();

        void n();

        void onDestroy();

        void quitFullScreen();

        void setDanmakuBtnOnClickListener(InterfaceC6475g interfaceC6475g);

        void setDanmakuBtnOpen(boolean z16);

        void setExitFullScreenBtnOnClickListener(View.OnClickListener onClickListener);

        void setFullScreenBtnOnClickListener(View.OnClickListener onClickListener);

        void setIplaySeekCallback(d dVar);

        void setIsPlay(boolean z16);

        void setMuteBtnOnClickListener(View.OnClickListener onClickListener);

        void setMuteBtnState(boolean z16);

        void setOnPlayButtonClickListener(View.OnClickListener onClickListener);

        void setOnUpdateProgressLenListener(e eVar);

        void setPlayBtnInCenterPosition(boolean z16);

        void setShowControlProgress(boolean z16);

        void setShowDanmakuBtn(boolean z16);

        void setShowFullScreenBtn(boolean z16);

        void setShowMuteBtn(boolean z16);

        void setShowPlayBtn(boolean z16);

        void setShowProgress(boolean z16);

        void setStatePorter(i iVar);

        void setTitle(String str);
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public interface b {
        void a(boolean z16);

        void b(int i3);

        int getVideoTotalTime();

        void setVideoTotalTime(int i3);
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public interface c {
        void a(String str, String str2);

        void a(String str, String str2, int i3, int i16);

        void a(String str, String str2, String str3, int i3, int i16);

        void b(String str, String str2);

        void c(String str, String str2);

        void d(String str, String str2);

        void e(String str, String str2);

        void f(String str, String str2);
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public interface d {
        void a();

        void a(int i3);
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public interface e {
        void a(int i3, int i16);
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public interface f {
        void a(boolean z16);
    }

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.mg.g$g, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public interface InterfaceC6475g {
        void a(View view, boolean z16);
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public enum h {
        DEFAULT,
        FILL,
        CONTAIN,
        COVER
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public interface i {
        int a();

        int b();
    }

    void a(boolean z16, String str, int i3);

    boolean a(double d16);

    boolean a(double d16, boolean z16);

    boolean a(float f16);

    boolean c();

    void d();

    void f();

    void g();

    int getCacheTimeSec();

    int getCurrPosMs();

    int getCurrPosSec();

    int getPlayerType();

    int getVideoDurationSec();

    View getView();

    boolean i();

    boolean isPlaying();

    void j();

    boolean pause();

    void setCover(Bitmap bitmap);

    void setFullDirection(int i3);

    void setIMMVideoViewCallback(c cVar);

    void setIsShowBasicControls(boolean z16);

    void setMinBufferDuration(long j3);

    void setMute(boolean z16);

    void setScaleType(h hVar);

    void setVideoContext(k kVar);

    void setVideoFooterView(b bVar);

    void setVideoSource(int i3);

    void start();

    void stop();
}
