package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;

/* loaded from: classes24.dex */
public final class GProPosterInfo implements Serializable {
    public int age;
    public int gender;
    long serialVersionUID = 1;

    public GProPosterInfo() {
    }

    public int getAge() {
        return this.age;
    }

    public int getGender() {
        return this.gender;
    }

    public String toString() {
        return "GProPosterInfo{gender=" + this.gender + ",age=" + this.age + ",}";
    }

    public GProPosterInfo(int i3, int i16) {
        this.gender = i3;
        this.age = i16;
    }
}
