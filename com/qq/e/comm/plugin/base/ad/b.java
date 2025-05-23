package com.qq.e.comm.plugin.base.ad;

/* compiled from: P */
/* loaded from: classes3.dex */
public enum b {
    UNKNOWN(0, 1),
    BANNER(1, 1),
    INTERSTITIAL(2, 3),
    APP_WALL(3, 8),
    SPLASH(4, 1),
    FEEDS(5, 1),
    NATIVEMEDIAAD(7, 1),
    GDTNATIVEAD(8, 1),
    GRID(6, 9),
    NATIVEEXPRESSAD(9, 1),
    CONTENTAD(10, 1),
    REWARDVIDEOAD(11, 1),
    NATIVEUNIFIEDAD(12, 1),
    UNIFIED_BANNER(13, 1),
    UNIFIED_INTERSTITIAL(14, 1),
    ROSE_AD(15, 1),
    PREMOVIE_AD(16, 1),
    PAUSE_AD(17, 1),
    POSTMOVIE_AD(18, 1),
    ENDING_AD(19, 1),
    HIGHLIGHT_AD(20, 1),
    IDLE_AD(21, 1);


    /* renamed from: w, reason: collision with root package name */
    private int f38382w;

    /* renamed from: x, reason: collision with root package name */
    private int f38383x;

    b(int i3, int i16) {
        this.f38382w = i3;
        this.f38383x = i16;
        ordinal();
    }

    public int b() {
        return this.f38382w;
    }

    public static b a(int i3) {
        switch (i3) {
            case 1:
                return BANNER;
            case 2:
                return INTERSTITIAL;
            case 3:
                return APP_WALL;
            case 4:
                return SPLASH;
            case 5:
                return FEEDS;
            case 6:
                return GRID;
            case 7:
                return NATIVEMEDIAAD;
            case 8:
                return GDTNATIVEAD;
            case 9:
                return NATIVEEXPRESSAD;
            case 10:
                return CONTENTAD;
            case 11:
                return REWARDVIDEOAD;
            case 12:
                return NATIVEUNIFIEDAD;
            case 13:
                return UNIFIED_BANNER;
            case 14:
                return UNIFIED_INTERSTITIAL;
            case 15:
                return ROSE_AD;
            case 16:
                return PREMOVIE_AD;
            case 17:
                return PAUSE_AD;
            case 18:
                return POSTMOVIE_AD;
            case 19:
                return ENDING_AD;
            case 20:
                return HIGHLIGHT_AD;
            case 21:
                return IDLE_AD;
            default:
                return UNKNOWN;
        }
    }
}
