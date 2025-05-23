package com.google.androidgamesdk;

/* compiled from: P */
/* loaded from: classes2.dex */
public class GameSdkDeviceInfoJni {

    /* renamed from: a, reason: collision with root package name */
    private static Throwable f34662a;

    static {
        try {
            System.loadLibrary("game_sdk_device_info_jni");
        } catch (Error e16) {
            f34662a = e16;
        } catch (Exception e17) {
            f34662a = e17;
        }
    }

    GameSdkDeviceInfoJni() {
    }

    private static native byte[] getProtoSerialized();
}
