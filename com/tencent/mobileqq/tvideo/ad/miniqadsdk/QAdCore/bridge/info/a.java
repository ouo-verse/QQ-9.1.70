package com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.bridge.info;

/* compiled from: P */
/* loaded from: classes19.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private String f303777a;

    /* renamed from: b, reason: collision with root package name */
    private String f303778b;

    /* renamed from: c, reason: collision with root package name */
    private QADApkDownloadTaskState f303779c;

    /* renamed from: d, reason: collision with root package name */
    private float f303780d;

    /* renamed from: e, reason: collision with root package name */
    private String f303781e;

    public a(String str, String str2, QADApkDownloadTaskState qADApkDownloadTaskState, float f16) {
        this.f303777a = str;
        this.f303778b = str2;
        this.f303779c = qADApkDownloadTaskState;
        this.f303780d = f16;
    }

    public String a() {
        return this.f303777a;
    }

    public String b() {
        return this.f303778b;
    }

    public float c() {
        return this.f303780d;
    }

    public String d() {
        return this.f303781e;
    }

    @QADApkDownloadUiState
    public int e() {
        return com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.bridge.download.a.b(this.f303779c);
    }

    public void f(String str) {
        this.f303781e = str;
    }
}
