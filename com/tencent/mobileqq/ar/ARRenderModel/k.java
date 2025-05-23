package com.tencent.mobileqq.ar.ARRenderModel;

import com.tencent.mobileqq.ar.aidl.ArCloudConfigInfo;

/* compiled from: P */
/* loaded from: classes11.dex */
public class k extends e {

    /* renamed from: i, reason: collision with root package name */
    public String f197283i;

    /* renamed from: j, reason: collision with root package name */
    public String f197284j;

    /* renamed from: k, reason: collision with root package name */
    public String f197285k;

    /* renamed from: l, reason: collision with root package name */
    public ArCloudConfigInfo.b f197286l;

    public k(String str, int i3, int i16, String str2, String str3, String str4, ArCloudConfigInfo.b bVar, int i17, float f16, float f17, float f18) {
        super(str, i3, i16, i17, f16, f17, f18);
        this.f197283i = str2;
        this.f197284j = str3;
        this.f197285k = str4;
        this.f197286l = bVar;
    }

    public String toString() {
        return "GeneralAR_3D_ResourceInfo{key=" + this.f197225a + "', arType=" + this.f197226b + ", trackMode=" + this.f197228d + ", mLuaScriptPath=" + this.f197283i + ", mResourceDirPath='" + this.f197284j + "', mMusicPath='" + this.f197285k + "', mLayout='" + this.f197286l + "'}";
    }
}
