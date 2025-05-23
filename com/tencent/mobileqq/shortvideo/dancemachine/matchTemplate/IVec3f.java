package com.tencent.mobileqq.shortvideo.dancemachine.matchTemplate;

import com.tencent.mobileqq.shortvideo.dancemachine.utils.Vec3f;

/* compiled from: P */
/* loaded from: classes18.dex */
public class IVec3f extends Vec3f {
    public int index;

    public IVec3f(int i3, Vec3f vec3f) {
        this.index = i3;
        this.f287861x = vec3f.f287861x;
        this.f287862y = vec3f.f287862y;
        this.f287863z = vec3f.f287863z;
    }

    @Override // com.tencent.mobileqq.shortvideo.dancemachine.utils.Vec3f
    public String toString() {
        return this.index + "  : " + super.toString();
    }

    public IVec3f(int i3, float f16, float f17, float f18) {
        this.index = i3;
        this.f287861x = f16;
        this.f287862y = f17;
        this.f287863z = f18;
    }
}
