package com.tencent.av.video.effect.utils;

/* compiled from: P */
/* loaded from: classes3.dex */
public class NativeLoader {
    public static boolean mIsSoLoaded;

    public static void loadSo() {
        try {
            System.loadLibrary("qav_video_effect");
            mIsSoLoaded = true;
        } catch (RuntimeException unused) {
            mIsSoLoaded = false;
        } catch (Exception unused2) {
            mIsSoLoaded = false;
        } catch (UnsatisfiedLinkError unused3) {
            mIsSoLoaded = false;
        }
    }
}
