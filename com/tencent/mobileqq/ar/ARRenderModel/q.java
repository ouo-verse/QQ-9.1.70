package com.tencent.mobileqq.ar.ARRenderModel;

import com.tencent.mobileqq.ar.aidl.ArCloudConfigInfo;

/* compiled from: P */
/* loaded from: classes11.dex */
public class q extends e {

    /* renamed from: i, reason: collision with root package name */
    public int f197325i;

    /* renamed from: j, reason: collision with root package name */
    public String f197326j;

    /* renamed from: k, reason: collision with root package name */
    public long f197327k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f197328l;

    /* renamed from: m, reason: collision with root package name */
    public int f197329m;

    /* renamed from: n, reason: collision with root package name */
    public x81.i f197330n;

    /* renamed from: o, reason: collision with root package name */
    public ArCloudConfigInfo.b f197331o;

    public q(String str, int i3, int i16, int i17, x81.i iVar, ArCloudConfigInfo.b bVar, String str2, long j3, boolean z16, int i18, int i19, float f16, float f17, float f18) {
        super(str, i3, i16, i19, f16, f17, f18);
        this.f197325i = i17;
        this.f197326j = str2;
        this.f197327k = j3;
        this.f197328l = z16;
        this.f197329m = i18;
        this.f197330n = iVar;
        this.f197331o = bVar;
    }

    public String toString() {
        return "OnlineVideoARRenderableInfo{key=" + this.f197225a + "', arType=" + this.f197226b + ", trackMode=" + this.f197228d + ", mRealRenderType=" + this.f197325i + ", mKeyingParams='" + this.f197330n + "', mVideoUrl='" + this.f197326j + "', mVideoSize='" + this.f197327k + "', mLayout='" + this.f197331o + "', isSoftPlay='" + this.f197328l + "'}";
    }
}
