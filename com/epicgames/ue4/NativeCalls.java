package com.epicgames.ue4;

/* compiled from: P */
/* loaded from: classes2.dex */
public class NativeCalls {
    public static native void AllowJavaBackButtonEvent(boolean z16);

    public static native void AllowSleep(String str);

    public static native void CallNativeToEmbedded(String str, int i3, String str2, String str3, String[] strArr, String str4);

    public static native void ForwardNotification(String str);

    public static native void HandleCustomTouchEvent(int i3, int i16, int i17, int i18, float f16, float f17);

    public static native void KeepAwake(String str, boolean z16);

    public static native RecordFrameBuffer PeekRecordFrameBuffer(long j3);

    public static native void PopRecordFrameBuffer(long j3);

    public static native void RouteServiceIntent(String str, String str2);

    public static native void SetNamedObject(String str, Object obj);

    public static native void StartRecord(String str);

    public static native void UELogError(String str);

    public static native void UELogLog(String str);

    public static native void UELogVerbose(String str);

    public static native void UELogWarning(String str);

    public static native void WebViewVisible(boolean z16);
}
