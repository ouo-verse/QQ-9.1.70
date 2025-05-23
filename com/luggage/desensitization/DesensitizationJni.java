package com.luggage.desensitization;

/* compiled from: P */
/* loaded from: classes2.dex */
public class DesensitizationJni {
    static {
        System.loadLibrary("android_desensitization");
    }

    private native String nativeStrDesensitizeDetectedContentWithMask(String str, int i3, int i16);

    public String a(String str, int i3, int i16) {
        return nativeStrDesensitizeDetectedContentWithMask(str, i3, i16);
    }
}
