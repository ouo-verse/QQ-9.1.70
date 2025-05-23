package com.qq.e.tg;

/* loaded from: classes3.dex */
public class TangramAlphaVideoPlayInfo {

    /* renamed from: a, reason: collision with root package name */
    private String f40430a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f40431b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f40432c;

    /* renamed from: d, reason: collision with root package name */
    private String f40433d;

    /* renamed from: e, reason: collision with root package name */
    private String f40434e;

    /* renamed from: f, reason: collision with root package name */
    private String f40435f;

    /* renamed from: g, reason: collision with root package name */
    private int f40436g;

    /* renamed from: h, reason: collision with root package name */
    private int f40437h;

    public String getAdData() {
        return this.f40433d;
    }

    public String getAppId() {
        return this.f40435f;
    }

    public int getFormatType() {
        return this.f40437h;
    }

    public String getPosId() {
        return this.f40434e;
    }

    public int getScaleType() {
        return this.f40436g;
    }

    public String getVideoPath() {
        return this.f40430a;
    }

    public boolean isLoopPlay() {
        return this.f40431b;
    }

    public boolean isOutputMute() {
        return this.f40432c;
    }

    public TangramAlphaVideoPlayInfo setAdInfo(String str) {
        this.f40433d = str;
        return this;
    }

    public TangramAlphaVideoPlayInfo setAppId(String str) {
        this.f40435f = str;
        return this;
    }

    public void setFormatType(int i3) {
        this.f40437h = i3;
    }

    public TangramAlphaVideoPlayInfo setLoopPlay(boolean z16) {
        this.f40431b = z16;
        return this;
    }

    public TangramAlphaVideoPlayInfo setOutputMute(boolean z16) {
        this.f40432c = z16;
        return this;
    }

    public TangramAlphaVideoPlayInfo setPosId(String str) {
        this.f40434e = str;
        return this;
    }

    public void setScaleType(int i3) {
        this.f40436g = i3;
    }

    public TangramAlphaVideoPlayInfo setVideoPath(String str) {
        this.f40430a = str;
        return this;
    }
}
