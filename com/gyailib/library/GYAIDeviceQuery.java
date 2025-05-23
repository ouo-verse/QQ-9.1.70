package com.gyailib.library;

/* compiled from: P */
/* loaded from: classes2.dex */
public class GYAIDeviceQuery {
    static {
        try {
            System.loadLibrary("c++_shared");
            System.loadLibrary("light_device_query");
        } catch (Error e16) {
            e16.printStackTrace();
        } catch (Exception e17) {
            e17.printStackTrace();
        }
    }

    public native String getBundleNameFromLevel(int i3);
}
