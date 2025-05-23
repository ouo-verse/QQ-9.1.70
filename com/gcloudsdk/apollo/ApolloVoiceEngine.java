package com.gcloudsdk.apollo;

/* compiled from: P */
/* loaded from: classes2.dex */
public class ApolloVoiceEngine {
    static {
        try {
            System.loadLibrary("GVoice");
        } catch (UnsatisfiedLinkError unused) {
            System.err.println("load library GVoice failed!!!");
        }
    }

    public static final native void APITrace(String str, String str2);

    public static final native String GetDeviceBrand();

    public static final native String GetDeviceModel();

    public static final native boolean GetHeadsetVoipState();

    public static final native boolean IsPause();

    public static final native void OnEvent(int i3, String str);

    public static final native int Pause();

    public static final native int Resume();

    public static final native void SetBluetoothState(boolean z16);

    public static final native void SetHeadSetState(boolean z16);

    public static final native int StartBlueTooth();

    public static final native int StopBlueTooth();
}
