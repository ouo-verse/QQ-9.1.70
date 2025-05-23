package com.tencent.mobileqq.ar.ARRenderModel;

import com.tencent.mobileqq.ar.aidl.ArCloudConfigInfo;

/* compiled from: P */
/* loaded from: classes11.dex */
public class p extends e {

    /* renamed from: i, reason: collision with root package name */
    public int f197320i;

    /* renamed from: j, reason: collision with root package name */
    public String f197321j;

    /* renamed from: k, reason: collision with root package name */
    public int f197322k;

    /* renamed from: l, reason: collision with root package name */
    public x81.i f197323l;

    /* renamed from: m, reason: collision with root package name */
    public ArCloudConfigInfo.b f197324m;

    public p(String str, int i3, int i16, int i17, x81.i iVar, ArCloudConfigInfo.b bVar, String str2, int i18, int i19, float f16, float f17, float f18) {
        super(str, i3, i16, i19, f16, f17, f18);
        this.f197320i = i17;
        this.f197321j = str2;
        this.f197322k = i18;
        this.f197323l = iVar;
        this.f197324m = bVar;
    }

    public String toString() {
        return "NormalVideoARResourceInfo{key=" + this.f197225a + "', arType=" + this.f197226b + ", trackMode=" + this.f197228d + ", mRealRenderType=" + this.f197320i + ", mKeyingParams='" + this.f197323l + "', mVideoPath='" + this.f197321j + "', mLayout='" + this.f197324m + "'}";
    }
}
