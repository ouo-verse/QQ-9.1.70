package com.tencent.mobileqq.ar.ARRenderModel;

import com.tencent.mobileqq.ar.aidl.ArCloudConfigInfo;

/* compiled from: P */
/* loaded from: classes11.dex */
public class n extends e {

    /* renamed from: i, reason: collision with root package name */
    public ArCloudConfigInfo f197315i;

    /* renamed from: j, reason: collision with root package name */
    public String f197316j;

    /* renamed from: k, reason: collision with root package name */
    public String f197317k;

    /* renamed from: l, reason: collision with root package name */
    public String f197318l;

    public n(String str, int i3, int i16, String str2, String str3, String str4, ArCloudConfigInfo arCloudConfigInfo, int i17, float f16, float f17, float f18) {
        super(str, i3, i16, i17, f16, f17, f18);
        this.f197316j = str2;
        this.f197317k = str3;
        this.f197318l = str4;
        this.f197315i = arCloudConfigInfo;
    }

    public String toString() {
        return "GeneralAR_3D_ResourceInfo{key=" + this.f197225a + "', arType=" + this.f197226b + ", trackMode=" + this.f197228d + ", mLuaScriptPath=" + this.f197316j + ", mResourceDirPath='" + this.f197317k + "', mMusicPath='" + this.f197318l + "'}";
    }
}
