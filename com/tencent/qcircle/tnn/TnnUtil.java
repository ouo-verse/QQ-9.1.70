package com.tencent.qcircle.tnn;

/* compiled from: P */
/* loaded from: classes22.dex */
public class TnnUtil {
    private static IQFSRankNativeCallback mRankNativeCallback;

    public static int attaUpload(String str) {
        IQFSRankNativeCallback iQFSRankNativeCallback = mRankNativeCallback;
        if (iQFSRankNativeCallback != null) {
            return iQFSRankNativeCallback.attaUpload(str);
        }
        return 0;
    }

    public static native String delDetailFeedList();

    public static native String doReRank(String str, String str2);

    public static void error(int i3, String str) {
        IQFSRankNativeCallback iQFSRankNativeCallback = mRankNativeCallback;
        if (iQFSRankNativeCallback != null) {
            iQFSRankNativeCallback.errorCallback(i3, str);
        }
    }

    public static int getAppStatus() {
        IQFSRankNativeCallback iQFSRankNativeCallback = mRankNativeCallback;
        if (iQFSRankNativeCallback != null) {
            return iQFSRankNativeCallback.getAppStatus();
        }
        return 0;
    }

    public static String getFilePath(String str) {
        IQFSRankNativeCallback iQFSRankNativeCallback = mRankNativeCallback;
        if (iQFSRankNativeCallback != null) {
            return iQFSRankNativeCallback.getFilePath(str);
        }
        return null;
    }

    public static native int init(String str, String str2);

    public static native String mixRank(String str, String str2, String str3, String str4, String str5);

    public static native int release();

    public static void rerankLog(String str) {
        IQFSRankNativeCallback iQFSRankNativeCallback = mRankNativeCallback;
        if (iQFSRankNativeCallback != null) {
            iQFSRankNativeCallback.rerankLog(str);
        }
    }

    public static native String sealRank(String str, String str2);

    public static void setCallback(IQFSRankNativeCallback iQFSRankNativeCallback) {
        mRankNativeCallback = iQFSRankNativeCallback;
    }

    public static native void setCategory(String str);

    public static int trainSwitch() {
        IQFSRankNativeCallback iQFSRankNativeCallback = mRankNativeCallback;
        if (iQFSRankNativeCallback != null) {
            return iQFSRankNativeCallback.trainSwitch();
        }
        return 0;
    }

    public static native String trainTest();
}
