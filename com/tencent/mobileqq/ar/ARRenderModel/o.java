package com.tencent.mobileqq.ar.ARRenderModel;

import com.tencent.mobileqq.ar.aidl.ArCloudConfigInfo;

/* compiled from: P */
/* loaded from: classes11.dex */
public class o extends e {

    /* renamed from: i, reason: collision with root package name */
    public ArCloudConfigInfo f197319i;

    public o(String str, int i3, int i16, ArCloudConfigInfo arCloudConfigInfo, int i17, float f16, float f17, float f18) {
        super(str, i3, i16, i17, f16, f17, f18);
        this.f197319i = arCloudConfigInfo;
    }

    public String toString() {
        return "MultiFragmentAnimARResourceInfo{key=" + this.f197225a + "', arType=" + this.f197226b + ", trackMode=" + this.f197228d + ", arResourceInfo=" + this.f197319i + '}';
    }
}
