package com.tencent.xnet;

/* compiled from: P */
/* loaded from: classes38.dex */
public class ClassifierXnetLog {
    static ILogCallbackInterface sCallback;

    public static void printLog(int i3, String str, String str2) {
        ILogCallbackInterface iLogCallbackInterface = sCallback;
        if (iLogCallbackInterface != null) {
            iLogCallbackInterface.printLog(i3, str, str2);
        }
    }

    public static void setLogCallback(ILogCallbackInterface iLogCallbackInterface) {
        sCallback = iLogCallbackInterface;
    }
}
